import java.util.Scanner;

public class tutorial3e {
    public static void main(String args[]) {
        System.out.println("Enter your letter grade");
        Scanner scanner = new Scanner(System.in);
        String grade = scanner.next();
        String message;
        switch (grade) {
            case "A":
                message = "Excellent job";
                break;
            case "B":
                message = "Your grade is B, great job";
                break;
            case "C":
                message = "Your grade is C, you need to work hard.";
                break;
            case "D":
                message = "Work harder.";
                break;
            case "F":
                message = "Retake the exam.";
                break;
            default:
                message = "Invalid grade";
                break;

        }
        System.out.println("In regards to your grade: " + message);
        scanner.close();
    }
}
