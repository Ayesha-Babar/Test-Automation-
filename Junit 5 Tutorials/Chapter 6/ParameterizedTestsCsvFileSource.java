package Junit5Tests;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

// Shoppinglist.csv attached
public class ParameterizedTestsCsvFileSource
{

      @ParameterizedTest
      @CsvFileSource(files = {"C:\\Users\\Emumba\\courses\\Junit 5 Tutorials\\untitled\\src\\test\\java\\Junit5Tests\\Chapter 6\\Resources\\ShoppingList.csv"}, numLinesToSkip = 1)
      void csvFileSource_StringDoubleIntStringString (String name,double price, int quantity, String unit, String
      provider)
      {
          System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity + ", unit = " + unit + ", provider = " + provider);

      }


    @ParameterizedTest
    @CsvFileSource(files ={ "C:\\Users\\Emumba\\courses\\Junit 5 Tutorials\\untitled\\src\\test\\java\\Junit5Tests\\Chapter 6\\Resources\\ShoppingList.csv","C:\\Users\\Emumba\\courses\\Junit 5 Tutorials\\untitled\\src\\test\\java\\Junit5Tests\\Chapter 6\\Resources\\ShoppingList2.csv"}, numLinesToSkip = 1)
    void csvFileSource2_StringDoubleIntStringString (String name,double price, int quantity, String unit, String
            provider)
    {
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity + ", unit = " + unit + ", provider = " + provider);


    }

    @ParameterizedTest
    @CsvFileSource(files = {"C:\\Users\\Emumba\\courses\\Junit 5 Tutorials\\untitled\\src\\test\\java\\Junit5Tests\\Chapter 6\\Resources\\ShoppingList3"},
            numLinesToSkip = 1, delimiter='_')

    void csvFileSource3_StringDoubleIntStringString (String name,double price, int quantity, String unit, String
            provider)
    {
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity + ", unit = " + unit + ", provider = " + provider);

    }



}
