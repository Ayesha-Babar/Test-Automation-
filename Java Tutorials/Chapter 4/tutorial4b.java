import java.util.Scanner;

public class tutorial4b {
    public static void main(String args[]) {
        // do while loop
        // allow the user to enter two numbers and add them, allow iterations until the
        // user makes the again variable false.
        int num1;
        int num2;
        double sum;
        boolean again;
        Scanner scanner;
        do {
            System.out.println("Enter the two numbers you intend to add: ");
            scanner = new Scanner(System.in);
            num1 = scanner.nextInt();
            num2 = scanner.nextInt();
            sum = num1 + num2;
            System.out.println("The sum of two numbers is: " + sum);
            System.out.println("Do you want to start over?");
            again = scanner.nextBoolean();

        } while (again);
        System.out.println("The final sum is " + sum);
        scanner.close();
    }
}
