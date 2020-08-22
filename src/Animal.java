public abstract class Animal
{
    // Без имени как-то совсем грустно, и не понятно, как их идентифицировать
    private String name;

    private float runLimit;
    private float swimLimit;
    private float jumpLimit;


    Animal (String name, float runLimit, float swimLimit, float jumpLimit)
    {
        this.name = name;
        this.runLimit = makeValid(runLimit);
        this.swimLimit = makeValid(swimLimit);
        this.jumpLimit = makeValid(jumpLimit);
    }


    // Валидация для параметров, которые должны быть больше 0
    private float makeValid (float value)
    {
        if (value < 0)
        {
            //System.out.print("Будем считать, Вы имели в виду 0.");
            return 0;
        }
        else
            return value;
    }


    // Сеттеры
    public void setName (String name)
    {
        this.name = name;
    }


    // Геттеры
    public String getName()
    {return name;}

    public float getRunLimit()
    {return  runLimit;}

    public float getSwimLimit()
    {return  swimLimit;}

    public float getJumpLimit()
    {return jumpLimit;}


    // Абстрактные методы
    public abstract boolean run (float distance);
    public abstract boolean swim (float distance);
    public abstract boolean jump (float distance);
    public abstract boolean isAlive (boolean sayIt);
    public abstract boolean isPossible (float request, float limit);
}
