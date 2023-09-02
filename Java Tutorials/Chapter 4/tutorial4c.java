import java.util.Scanner;

public class tutorial4c {
    /*
     * public static void main(String args[]) {
     * // for loop
     * // scan a given no of items and tally the cost.
     * System.out.println("Enter the no of items: ");
     * Scanner scanner = new Scanner(System.in);
     * int quantity = scanner.nextInt();
     * double cost = 0;
     * int count = 1;
     * for (int i = 0; i < quantity; i++) {
     * System.out.println("Enter the cost of item " + count);
     * double price = scanner.nextDouble();
     * cost += price;
     * count++;
     * }
     * scanner.close();
     * System.out.println("The cost of all items is " + cost);
     * }
     */

    // example 2
    public static void main(String args[]) {
        // find letter A in a string using for loop
        // get string
        System.out.println("Enter the text: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        scanner.close();
        boolean letterFound = true;

        for (int i = 0; i < text.length(); i++) {
            char currentLetter = text.charAt(i);
            if (currentLetter == 'A' || currentLetter == 'a') {
                letterFound = true;
                break;
            }
        }
        if (letterFound)
            System.out.println("This text contains letter A");
        else
            System.out.println("This text doesnt contain letter A");
         scanner.close();
    }
    

}
