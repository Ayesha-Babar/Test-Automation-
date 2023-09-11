import java.util.Scanner;

public class tutorial1 {
    
    public static void main(String arg[])
     {
        // get the no of hours worked,multiply hours and payrate, display result.

        System.out.println("Enter the no of hours ");
        Scanner scanner = new Scanner(System.in); 
        
            int hours = scanner.nextInt();

            System.out.println("Enter the payrate");
            double rate = scanner.nextDouble();

            double grossPay = hours * rate;
            System.out.println("The employee gross pay is " + grossPay);
            scanner.close();
        
        

    }
}
