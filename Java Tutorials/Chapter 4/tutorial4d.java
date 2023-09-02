import java.util.Scanner;

public class tutorial4d {
    /*
     * public static void main(String args[]) {
     * // nested for loops
     * // average test scores of 24 students with 4 tests
     * int students = 24;
     * int tests = 4;
     * Scanner scanner = new Scanner(System.in);
     * for (int i = 0; i < students; i++) {
     * double total = 0;
     * for (int j = 0; j < tests; j++) {
     * // total of 4 tests for a single student
     * System.out.println("Enter the score for test #" + (j + 1));
     * double score = scanner.nextDouble();
     * total = total + score;
     * }
     * double ave = total / tests;
     * System.out.println("For student # " + (i + 1) +
     * ", the average test score is " + ave);
     * 
     * }
     * scanner.close();
     * }
     */
    public static void main(String args[]) {
        // independent excercise problem
        // nested for loop for roll a die problem
        // 5 die rolls, total spaces=20
        Scanner scanner = new Scanner(System.in);
        int dieRolls = 5;
        int spaces = 20;
        for (int i = 1; i <= dieRolls; i++) {

            for (int j = 1; j <= spaces; j++) {
                System.out.println("Roll a die, enter a number between 1 and 6");
                int roll = scanner.nextInt();
                spaces += roll;
                System.out.print("You are left with " + (20 - roll) + " spaces.");

            }

        }
        scanner.close();
    }
}