import java.util.Scanner;

public class tutorial5b {
    static int reqsalary = 2500;
    static int reqscore = 700;
    static boolean qualified;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        double salary = getSalary();
        int CreditScore = getCreditScore();
        qualified = isUserQualify(CreditScore, salary);
        notifyUser(qualified);
        scanner.close();

    }

    public static double getSalary() {
        System.out.println("Enter your salary: ");
        Scanner scanner = new Scanner(System.in);
        double salary = scanner.nextDouble();
        return salary;

    }

    public static int getCreditScore() {

        System.out.println("Enter your credit score: ");
        Scanner scanner = new Scanner(System.in);
        int creditScore = scanner.nextInt();
        return creditScore;

    }

    public static boolean isUserQualify(int c, double s)

    {
        if (c >= reqscore && s >= reqsalary) {
            return true;
        } else
            return false;

    }

    public static void notifyUser(boolean q) {
        if (q) {
            System.out.println("congrats, youve been approved");

        } else
            System.out.println("sorry, youve been declined");
    }
    scanner.close();
}
