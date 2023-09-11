public interface Product
{
    // methods with no bodies
    // if bodies are defined here, they are considered final
    double getPrice();
    void setPrice(double price);

    String getName();
    void setName(String name);

    String getColor();
    void setColor(String color);

    // no need to override default methods
    default String getBarcode()
    {
        return "no barcode";
    }

}
