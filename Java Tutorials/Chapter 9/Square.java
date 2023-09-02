package chap9;

public class Square extends Rectangle
{
    @Override
    public double calculatePerimeter()
    {
        return sides*length;

        // name of the function is same
        // the implementation/body is different
    }

    // overloading
    public void print (String what)
    {
        System.out.println("I am a " + what);
    }


    public static void main(String args[])
    {
         Rectangle rectangle= new Rectangle();
         rectangle.print();
         Square square= new Square();
         square.print("square 1");
    }
}
