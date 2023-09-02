import java.util.Scanner;

public class tutorial4a {
    public static void main(String args[]) {
        // while loop
        int rate = 15;
        int maxhours = 40;
        System.out.println("How many hours did you work this week?");
        Scanner scanner = new Scanner(System.in);
        double hours = scanner.nextDouble();

        // validate input
        while (hours > maxhours || hours < 1) {
            System.out.println("invalid,enter hours between 1 and 40.");
            hours = scanner.nextDouble();
        }
        // gross pay
        double grossPay = rate * hours;
        System.out.println("The gross pay is " + grossPay);

        scanner.close();
    }
}
