import java.util.Scanner;

public class tutorial5cassign {
    // phone bill calculator
    // input the plan fee,no of avg mins
    static double basicFee;
    static double avgMins;
    static double tax;
    static double total;
    static double basicMins = 40;

    public static void main(String args[]) {
       
        basicFee = getFee();
        avgMins = getAvgMins();
        tax = tax();
        total = total(tax, basicFee);
        System.out.println("The total fee including the tax and the basic fee would be " + total);
       
    }

    public static double getFee() {
        System.out.println("Enter the basic fee.");
        Scanner scanner = new Scanner(System.in);
        basicFee = scanner.nextInt();
        return basicFee;
    }

    public static double getAvgMins() {
        System.out.println("Enter the average no of mins youve used.");
        Scanner scanner = new Scanner(System.in);
        avgMins = scanner.nextInt();
        return avgMins;
    }

    public static double tax() {
        tax = 0.25 * (avgMins - basicMins);
        System.out.println("The tax would be " + tax + " for " + avgMins + "mins used.");
        return tax;
    }

    public static double total(double tax, double basicfee) {
        double t = tax + basicfee;
        return t;
    }
    scanner.close();
    
}
