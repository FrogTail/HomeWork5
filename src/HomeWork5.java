// Решил хоть немного разнообразить логику поведения котов и собак,
// чтобы разделение на классы имело смысл


public class HomeWork5
{
    public static void main (String[] args)
    {
        System.out.print("====== Создаем пса с дефолтными параметрами ======");
        Dog nonameDog = new Dog();
        nonameDog.run(200);
        nonameDog.jump(5);
        nonameDog.swim(1000);
        nonameDog.run(10);


        System.out.print("\n\n====== Создаем кота с дефолтными параметрами ======");
        Cat nonameCat = new Cat();
        nonameCat.run(150);
        nonameCat.swim(1);
        nonameCat.jump(2.5f);


        System.out.print("\n\n====== Создаем кота с параметрами отличающимися от дефолтных ======");
        Cat barseek = new Cat ("Барсик", 1000, 10);
        barseek.run(100);
        barseek.swim(-1);
        barseek.jump(-5);


        System.out.print("\n\n====== Создаем массив с животными и кладем в него всех, кого создали ======");
        Animal[] animals = new Animal[3];
        animals[0] = nonameCat;
        animals[1] = nonameDog;
        animals[2] = barseek;

        for (int i=0; i<animals.length; i++)
        {
            System.out.print("\n" +animals[i].getName());
        }


        System.out.print("\n\n====== Приказываем всем котам в массиве вылизываться ======");
        for (int i=0; i<animals.length; i++)
        {
            if (animals[i] instanceof Cat)
            {
                Cat tmpCat = (Cat) animals[i];
                tmpCat.lickOneself();
            }
        }


        System.out.print("\n\n====== Заставляем Барсика прыгать на 7 метров пока не потратит все жизни ======");
        while (animals[2].jump(7))
        {}
    }
}
