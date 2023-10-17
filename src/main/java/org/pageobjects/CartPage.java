package org.pageobjects;

import org.Abstractcomponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponents {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

          //Page Factory design
     //driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
     //List<WebElement> productlists = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
   // @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
   // WebElement Cart;

    @FindBy(xpath = "//div[@class='cartSection']/h3")
    List<WebElement> AllProducts;

     //public String selectCart (){

        // Cart.click();
        // String urllink = driver.getCurrentUrl();
        // return urllink;
   // }

    public boolean VerifyProduct(String addedproduct){

        for(WebElement Allproduct : AllProducts)
        {
            System.out.println(Allproduct.getText());
        }

        boolean match = AllProducts.stream().anyMatch(Allproduct -> Allproduct.getText().equalsIgnoreCase(addedproduct));
        return match;
    }

 }
