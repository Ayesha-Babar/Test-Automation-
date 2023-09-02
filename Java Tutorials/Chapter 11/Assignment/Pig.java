package Assignment;

public class Pig extends Animal{
    @Override
    public void MakeSound()
    {
        System.out.println("pig sound");
    }

    public void PigExclusiveMethod()
    {
        System.out.println("a method unique to pig's class");
    }
}
