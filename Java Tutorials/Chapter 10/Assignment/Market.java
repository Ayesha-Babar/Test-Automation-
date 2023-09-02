package Assignment;
// This class would test polymorphism
public class Market
{
    public static void main(String args[])
    {
        Fruit fruit= new Fruit();
        fruit.setCalories(34);
        fruit.MakeJuice();

        Fruit apple= new Apple(37);
        apple.MakeJuice();

        // type casting
        apple= new Banana(23);
        apple.MakeJuice();
        ((Banana)apple).Peel();

    }


}
