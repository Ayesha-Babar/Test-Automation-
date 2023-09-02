import static java.lang.Character.isUpperCase;

public class tutorial8a
{
    // datatypes
   // primitive data types
    int num1=5;

    // wrapper classes
    Integer num2= 5;
    // here num2 is an object
     public static void ConvertDecimal()
     {
         double[] numbers= {1.5,3.4,6};
         for (Double number:numbers)
         {
             System.out.println(number.intValue());
             // here the number is treated like an object hence it can access methods.
         }
     }
     public static void main(String args[])
     {
         ConvertDecimal();

     }
}
