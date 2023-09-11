package Assignment;

public class Apple extends Fruit
{
    public Apple(int calories)
    {
        this.calories= calories;
    }
    public void RemoveSeeds()
    {
        System.out.println("Seeds have been removed");
    }

    @Override
    public void MakeJuice()
    {
        System.out.println("Apple juice made");
    }
}
