import java.util.Scanner;

public class tutorial1assig {
    // create a sentence : On a [adjective][season of the year] day, i drink a
    // a minimum of [whole number] cups of coffee.
    public static void main(String arg[]) {
        // get adjective
        System.out.println("Enter your adjective for season of year");
        Scanner scanner = new Scanner(System.in);
        String adjective = scanner.nextLine();

        System.out.println("Enter season of year");
        String season = scanner.nextLine();

        System.out.println("Enter the no of cups of coffee per day");
        int cups = scanner.nextInt();

        System.out.println("On a " + adjective + " " + season + " day, i drink a minimum of " + cups + " of coffee.");
        scanner.close();

    }
}
