public  class Rectangle extends Shape
{
    private double length;
    private double width;

    public Rectangle(double l,double w)
    {
        this.length=l;
        this.width=w;
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

    @Override
    double calculateArea() {
        return length*width;
    }
}
