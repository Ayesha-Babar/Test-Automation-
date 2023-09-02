package Assignment;

public class Banana extends Fruit
{
    public Banana(int calories)
    {
        this.calories= calories;
    }
    public void Peel()
    {
        System.out.println("Bananas have been peeled");
    }

    @Override
    public void MakeJuice()
    {
        System.out.println("Banana juice made");
    }

}
