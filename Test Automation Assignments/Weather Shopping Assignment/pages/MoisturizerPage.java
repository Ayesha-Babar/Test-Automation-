package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Float.parseFloat;

public class MoisturizerPage {
    WebDriver driver;
    private By AloeAddButton= By.xpath("//p[contains(text(), 'Aloe')]//following-sibling::button");
    private By AloePrices= By.xpath("//p[contains(text(), 'Aloe')]//following-sibling::p");
    private By AlmondAddButton= By.xpath("//p[contains(text(), 'Almond')]//following-sibling::button");
    private By AlmondPrices= By.xpath("//p[contains(text(), 'Almond')]//following-sibling::p");
    private By CartButton= By.xpath("//ul//button");

    List<WebElement> AloeButtons = new ArrayList<>();
    List<WebElement> Aloeprice=new ArrayList<>();
    List<WebElement>AlmondButtons= new ArrayList<>();
    List<WebElement>AlmondPrice= new ArrayList<>();
    public MoisturizerPage(WebDriver driver) {
        this.driver = driver;
    }

    public int clickAloe()
    {
        int lowestPrice= Integer.MAX_VALUE;
        int indexOflowestPrice= -1;
        AloeButtons=driver.findElements(AloeAddButton);
        Aloeprice= driver.findElements(AloePrices);
        for(int i=0;i< Aloeprice.size();i++)
        {
            int price=parsePrice(Aloeprice.get(i).getText());
            if(price<lowestPrice)
            {
                lowestPrice=price;
                indexOflowestPrice= i;

            }
        }
        System.out.println("The lowest price is "+lowestPrice);

        if(indexOflowestPrice!=-1)
        {
            WebElement lowestPriceButton= AloeButtons.get(indexOflowestPrice);
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


    public int clickAlmond()
    {
        int lowestPrice= Integer.MAX_VALUE;
        int indexOflowestPrice= -1;
        AlmondButtons=driver.findElements(AlmondAddButton);
        AlmondPrice= driver.findElements(AlmondPrices);
        for(int i=0;i< AlmondPrice.size();i++)
        {
            int price=parsePrice(AlmondPrice.get(i).getText());
            if(price<lowestPrice)
            {
                lowestPrice=price;
                indexOflowestPrice= i;

            }
        }
        //System.out.println("The lowest price is "+lowestPrice);

        if(indexOflowestPrice!=-1)
        {
            WebElement lowestPriceButton= AlmondButtons.get(indexOflowestPrice);
            lowestPriceButton.click();
        }

        return lowestPrice;


    }

    public CheckoutPage clickCart()
    {
        driver.findElement(CartButton).click();
        return new CheckoutPage(driver);
    }






}