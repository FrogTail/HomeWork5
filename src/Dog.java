public class Dog extends Animal
{

    // Дефолтное имя
    public static final String DEFAULT_NAME = "Шарик";

    // Выношу в константы, чтобы удобнее править
    public static final float DEFAULT_RUN_LIMIT = 500f;
    public static final float DEFAULT_JUMP_LIMIT = 0.5f;
    public static final float DEFAULT_SWIM_LIMIT = 10f;

    private boolean alive = true;

    // Пустой конструктор задает дефолтное имя и дефолтные значения лимитов
    Dog ()
    {
        super (DEFAULT_NAME,DEFAULT_RUN_LIMIT, DEFAULT_SWIM_LIMIT, DEFAULT_JUMP_LIMIT);
    }


    // Конструктор с именем и принудительно указанными значениями лимитов
    Dog (String name, float runLimit, float swimLimit, float jumpLimit)
    {
        super (name, runLimit, swimLimit, jumpLimit);
    }


    // Реализуем абстрактный бег
    public boolean run (float distance)
    {
        System.out.printf("\n\n>>> Вы приказали псу по имени %s пробежать %.2f м. ", getName(), distance);

        if (isPossible(distance, getRunLimit()))
        {
            if (distance<=getRunLimit())
            {
                System.out.printf("\nПес %s с лаем отбежал от Вас на %.2f м. и вернулся обратно.", getName(), distance);
                return true;
            }
            else
            {
                System.out.printf("\nПес %s с лаем унесся в даль и не вернулся...", getName());
                alive = false;
                return false;
            }
        }
        else
            return false;

    }


    // Реализуем абстрактное плавание
    public boolean swim (float distance)
    {
        System.out.printf("\n\n>>> Вы приказали псу по имени %s проплыть %.2f м. ", getName(), distance);

        if(isPossible(distance, getSwimLimit()))
        {
            if (distance <= getSwimLimit())
            {
                System.out.printf("\nПес %s с радостью проплыл всю дистанцию.", getName());
                return true;
            } else
            {
                System.out.printf("\nПес %s утонул...", getName());
                alive = false;
                return false;
            }
        }
        else
            return false;
    }


    // Реализуем асбтрактный прыжок
    public boolean jump (float height)
    {
        System.out.printf("\n\n>>> Вы приказали псу по имени %s прыгнуть на %.2f м. ", getName(), height);

        if(isPossible(height, getJumpLimit()))
        {
            if (height<=getJumpLimit())
            {
                System.out.printf("\nПес %s легко прыгнул на нужную высоту.", getName());
                return true;
            }
            else
            {
                System.out.printf("\nПес %s отказывается прыгать!", getName());
                return false;
            }
        }
        else
            return false;
    }


    // Живой или нет песик
    public boolean isAlive (boolean sayIt)
    {
        if (alive)
            return true;
        else
        {
            if (sayIt)
                System.out.printf("\nВсе собаки попадают в рай. Пес %s уже там.", getName());

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
                System.out.printf("\nПес %s не понимает, чего вы от него хотите, но преданно виляет хвостом.", getName());
                return false;
            }
            else
                return true;
        }
        else
            return false;
    }
}
