public class Assignment
{
    public static void main(String args[])
    {

    }
    public void divisionByzero()
    {
        try{
            int c=30/0;
        }catch(ArithmeticException e)
        {
            System.out.println("division by 0 isnt possible");
        }
        finally
        {
            System.out.println("division is fun");
        }
    }
}
