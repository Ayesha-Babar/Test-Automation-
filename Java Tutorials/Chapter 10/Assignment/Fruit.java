package Assignment;

public class Fruit
{
    int calories;
   public Fruit()
   {
       System.out.println("Fruit constructor");
   }
    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void MakeJuice()
    {
        System.out.println("Juice is made");
    }
}
