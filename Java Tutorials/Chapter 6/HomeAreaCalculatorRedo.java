package chap6tutorials;
import java.util.Scanner;

// TUTORIAL 6C
public class HomeAreaCalculatorRedo {
    /*public static void main(String args[]) {
        // create two objects of rectangle
        HomeAreaCalculatorRedo calculator = new HomeAreaCalculatorRedo();
        rectangle kitchen = calculator.getRoom();
        rectangle bathroom = calculator.getRoom();
        double area = calculator.calculateTotalArea(kitchen, bathroom);
        System.out.println("The total area of both rectangles is "+area);
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }*/

    public rectangle getRoom() // the return type would be rectangle
    {
        
        System.out.println("Enter length of your room: ");
        Scanner scanner = new Scanner(System.in);
        
        double length = scanner.nextDouble();

        System.out.println("Enter width of your room: ");
        double width = scanner.nextDouble();
        // another method to create an object instead of tutorial6a room= new
        // tutorial6a(length,width)
        return new rectangle(length, width);

       
    }

    public double calculateTotalArea(rectangle rectangle1, rectangle rectangle2) {// using the non primitive data types
        return rectangle1.calculateArea() + rectangle2.calculateArea();
    }


}
