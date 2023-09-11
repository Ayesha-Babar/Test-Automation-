import java.util.Scanner;

public class tutorial2 {
    public static void main(String args[]) {
        // employees who exceed a quota for sales would get a bonus-if condition
        int salary = 1000;
        int bonus = 250;
        int quota = 10;
        // get values for unknown
        System.out.println("How many sales did the employee make?");
        Scanner scanner = new Scanner(System.in);
        int sales = scanner.nextInt();
        scanner.close();

        System.out.println("if the sales exceed the quota, employee would get a bonus ");
        if (sales > quota) {
            salary = salary + bonus;

        }
        System.out.println("The salary of this employee is " + salary);
        scanner.close();

    }
}
