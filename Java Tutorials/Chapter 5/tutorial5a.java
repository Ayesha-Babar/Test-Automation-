import java.util.Scanner;

public class tutorial5a {
    // methods

    public static void main(String args[]) {
        System.out.println("Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        greetUser(name);
        scanner.close();
    }

    public static void greetUser(String name) {
        System.out.println("Hi there " + name);
    }
}
