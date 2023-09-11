package chap6tutorials;
import java.util.Scanner;

// TUTORIAL 6A
public class rectangle {
    // objects
    // class for rectangle
    protected double length;
    private double width;

    // constructor
    public rectangle() {
        length = 0;
        width = 0;
    }

    // constructor when length and width is known
    public rectangle(double length, double width) {
        this.length = length;
        // or this can also be used
        setWidth(width);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

    public double calculatePerimeter() {
        return (2 * length) + (2 * width);
    }
}
