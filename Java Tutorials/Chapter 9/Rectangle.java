package chap9;

public class Rectangle
{
    // overriding
    protected double length;
    protected double width;
    protected double sides;

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

    public double getSides() {
        return sides;
    }

    public void setSides(double sides) {
        this.sides = sides;
    }
    // to be overridden
    public double calculatePerimeter()
    {
        return(2*length);
    }
    // to be overloaded
    public void print()
    {
        System.out.println("I am a rectangle");
    }
}
