package Assignment;

public class Farm
{
    // this would test the implementation
    public static void main(String args[])
    {
        Animal animal = new Duck();
        animal.Eat();

        animal.MakeSound();

        animal = new Pig();
        ((Pig)animal).PigExclusiveMethod();

    }
}
