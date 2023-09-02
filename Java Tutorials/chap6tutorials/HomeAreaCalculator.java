package chap6tutorials;
public class HomeAreaCalculator {
    // TUTORIAL 6b
    public static void main(String args[]) {
        // create instance for rectangle class(object=new constr)
        rectangle room1 = new rectangle();
        // if we intend to give values to length and width
        room1.setWidth(25);
        room1.setLength(50);
        double areaofRoom1 = room1.calculateArea();

        // create another object
        rectangle room2 = new rectangle(30, 16.0);
        double areaofRoom2 = room2.calculateArea();

        double totalArea = areaofRoom1 + areaofRoom2;
        System.out.println("Area of both rooms is: " + totalArea);
    }
}
