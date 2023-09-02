import java.util.Scanner;

public class tutorial3b {
    public static void main(String args[]) {
        // if else
        int quota = 10;
        System.out.println("Enter no of sales");
        Scanner scanner = new Scanner(System.in);
        int sales = scanner.nextInt();
        scanner.close();

        if (sales >= quota) {
            System.out.println("Congrats, you have met your quota");
        } else {
            int shorsales = quota - sales;
            System.out.println("Better luck next time, you were short by " + shorsales + " sales.");
        }
        scanner.close();
    }
}
