import java.util.Scanner;

public class tutorial3f {
    // relational operators
    public static void main(String args[]) {
        System.out.println("Enter two numbers to check if they are equal");
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        if (num1 == num2) {

            System.out.println("Both numbers are equal.");
        } else if (num1 > num2)
            System.out.println("Num1 is greater than num 2");
        else
            System.out.println("Num2 is greater than num1.");
        scanner.close();
    }

}
