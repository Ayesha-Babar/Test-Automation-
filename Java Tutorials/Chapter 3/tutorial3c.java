import java.util.Scanner;

public class tutorial3c {
    static public void main(String args[]) {
        // loan qualifier-Nested if loops

        int req_salary = 30000;
        int years_employed = 5;

        System.out.println("Enter your salary");
        Scanner scanner = new Scanner(System.in);
        double salary = scanner.nextDouble();

        System.out.println("Enter the no of years employed");
        double years = scanner.nextDouble();
        scanner.close();

        if (salary >= req_salary) {
            if (years >= years_employed) {
                System.out.println("loan allowed");
            } else
                System.out.println("sorry,You are short by " + (years_employed - years) + "years.");
        } else
            System.out.println("Sorry, you're short by " + (req_salary - salary) + " salary.");
      scanner.close();  
    }
    
}