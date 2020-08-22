import java.util.Random;

public class Cat extends Animal
{
    // Дефолтное имя
    public static final String DEFAULT_NAME = "Мурзик";

    // Выношу в константы, чтобы удобнее править
    public static final float DEFAULT_RUN_LIMIT = 200f;
    public static final float DEFAULT_JUMP_LIMIT = 2f;
    public static final float SWIM_LIMIT = 0;

    private Random random = new Random();   // Для рандома смерти при слишком высоких прыжках
    private int lives = 9;


    // Пустой конструктор задает дефолтное имя и дефолтные значения лимитов
    Cat ()
    {
        super (DEFAULT_NAME,DEFAULT_RUN_LIMIT, SWIM_LIMIT, DEFAULT_JUMP_LIMIT);
    }


    // Конструктор с именем и принудительно указанными значениями лимитов
    Cat (String name, float runLimit, float jumpLimit)
    {
        super (name, runLimit, SWIM_LIMIT, jumpLimit);
    }


    // Реализуем абстрактный бег
    public boolean run (float distance)
    {
        System.out.printf("\n\n>>> Вы приказали коту по имени %s пробежать %.2f м. ", getName(), distance);

        if (isPossible(distance,getRunLimit()))
        {
            System.out.printf("\nКот %s лениво пробежал %.2f м., вернулся назад и требует вкусняшку.", getName(), distance/2);
            return true;
        }

        return false;
    }


    // Реализуем абстрактное плавание
    public boolean swim (float distance)
    {
        System.out.printf("\n\n>>> Вы приказали коту по имени %s проплыть %.2f м. ", getName(), distance);

        // Если кот мертв - выведется сообщение
        if(isAlive(true))
            System.out.printf("\nКоты не умеют плавать! Так в ТЗ написано! :)");

        return false;
    }


    // Реализуем асбтрактный прыжок
    public boolean jump (float height)
    {
        System.out.printf("\n\n>>> Вы приказали коту по имени %s прыгнуть на %.2f м. ", getName(), height);

        if (isPossible(height,getJumpLimit()))
        {
            // Котам рискованно прыгать выше, чем на дефолтную высоту
            if (height>DEFAULT_JUMP_LIMIT)
            {
                if(random.nextInt((int)height)<=DEFAULT_JUMP_LIMIT)
                {
                    System.out.printf("\nКот %s легко прыгнул на %.2f м. и приземлился на все 4 лапы.", getName(), height);
                }
                else
                {
                    System.out.printf("\nКот %s прыгнул на %.2f м., но неудачно приземлился и потерял одну из своих жизней.", getName(), height);
                    lives --; // Но прыжок засчитали, даже, если это была последняя жизнь :)
                }
            }

            return true;
        }

        return false;
    }


    // Дополнительная функция, чтобы потестить приведение типов
    public boolean lickOneself ()
    {
        if (isAlive(true))
        {
            System.out.printf("\nКот %s вылизывается.", getName());
            return true;
        }
        else
            return false;
    }


    // Живой или нет котик
    public boolean isAlive (boolean sayIt)
    {
        if (lives>0)
            return true;
        else
        {
            if (sayIt)
                System.out.printf("\nКот %s мертв и ему пофигу на Вас даже больше, чем обычно.", getName());

            return false;
        }
    }


    // Проверка команды на возможность выполнения
    // + стандартные реакции если выполнить невозможно или непонятно как
    public boolean isPossible (float givenRequest, float givenLimit)
    {
        if (isAlive(true))
        {
            if (givenRequest <= 0)
            {
                System.out.printf("\nКот %s не понимает, чего вы от него хотите, и озадаченно вылизывает пузо.", getName());
                return false;
            }
            else if (givenRequest>givenLimit)
            {
                System.out.printf("\nКот %s смотрит на Вас как на... ну Вы поняли...", getName());
                return false;
            }
            else
                return true;
        }
        else
            return false;

    }

}
