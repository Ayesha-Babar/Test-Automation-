public class Zoo
{
    // testing polymorphism
    public static void main(String args[])
    {
        Dog Rocky= new Dog();
        Rocky.fetch();
        Rocky.MakeSound();
        feed(Rocky);

        Animal sasha= new Dog();
        sasha.MakeSound();

        sasha= new Cat();
        sasha.MakeSound();
        ((Cat)sasha).Scratch();
        feed(sasha);
    }

    public static void feed(Animal animal)
    {
        if(animal instanceof Dog)
        {
            System.out.println("this is dog food");
        }
        else
        {
            System.out.println("this is cat food");
        }
    }
}
