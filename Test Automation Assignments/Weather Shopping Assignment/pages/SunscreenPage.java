package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SunscreenPage
{
    private WebDriver driver;
    private By SPF50Prices= By.xpath("//p[contains(text(),'SPF-50')]//following-sibling::p");
    private By SPF30Prices= By.xpath("//p[contains(text(),'SPF-30')]//following-sibling::p");
    private By SPF30Buttons=By.xpath("//p[contains(text(),'SPF-30')]//following-sibling::button");
    private By SPF50Buttons= By.xpath("//p[contains(text(),'SPF-50')]//following-sibling::button");
    private By CartButton= By.xpath("//ul//button");

    List<WebElement> SPF50price = new ArrayList<>();
    List<WebElement>SPF50button= new ArrayList<>();
    List<WebElement>SPF30price= new ArrayList<>();
    List<WebElement>SPF30button= new ArrayList<>();
    public SunscreenPage(WebDriver driver)
    {
        this.driver= driver;
    }

    public int AddSPF50()
    {
        int lowestPrice= Integer.MAX_VALUE;
        int indexOflowestPrice= -1;
        SPF50button=driver.findElements(SPF50Buttons);
        SPF50price= driver.findElements(SPF50Prices);
        for(int i=0;i< SPF50price.size();i++)
        {
            int price=parsePrice(SPF50price.get(i).getText());
            if(price<lowestPrice)
            {
                lowestPrice=price;
                indexOflowestPrice= i;

            }
        }
        System.out.println("The lowest price is "+lowestPrice);

        if(indexOflowestPrice!=-1)
        {
            WebElement lowestPriceButton= SPF50button.get(indexOflowestPrice);
            lowestPriceButton.click();
        }

        return lowestPrice;


    }

    public int AddSPF30()
    {
        int lowestPrice= Integer.MAX_VALUE;
        int indexOflowestPrice= -1;
        SPF30button=driver.findElements(SPF30Buttons);
        SPF30price= driver.findElements(SPF30Prices);
        for(int i=0;i< SPF30price.size();i++)
        {
            int price=parsePrice(SPF30price.get(i).getText());
            if(price<lowestPrice)
            {
                lowestPrice=price;
                indexOflowestPrice= i;

            }
        }
        System.out.println("The lowest price is "+lowestPrice);

        if(indexOflowestPrice!=-1)
        {
            WebElement lowestPriceButton= SPF30button.get(indexOflowestPrice);
            lowestPriceButton.click();
        }

        return lowestPrice;


    }

    public int parsePrice(String priceText)
    {
        String numericpart= priceText.replaceAll("[^0-9]", "");
        int extractedPrice= Integer.parseInt(numericpart);

        return extractedPrice;
    }

    public CheckoutPage clickCart()
    {
        driver.findElement(CartButton).click();
        return new CheckoutPage(driver);
    }


}