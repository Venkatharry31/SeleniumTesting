package org.pageobjects;

import org.Abstractcomponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckOut extends AbstractComponents {
    WebDriver driver;

    public CheckOut(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //WebElement checkout = driver.findElement(By.xpath("/html/body/app-root/app-profile/div/div[2]/ul/li/div/div[3]/button[1]"));
    //checkout.click();

    //driver.findElement(By.xpath("/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/input")).sendKeys("New Zealand");
    //driver.findElement(By.xpath(("/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/section/button/span"))).click();
    //driver.findElement(By.xpath("/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[2]/a")).click();


    @FindBy(xpath = "/html/body/app-root/app-profile/div/div[2]/ul/li/div/div[3]/button[1]")
    WebElement Checkoutpage;

    @FindBy(xpath = "/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/input")
    WebElement CountryName;

    @FindBy(xpath = "/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div/section/button/span" )
    WebElement selectcountry;

    @FindBy(xpath="/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[2]/a")
    WebElement finishselection;
     public void CheckOutPage ()
     {
         Checkoutpage.click();
     }

    public PaymentPage ToPaymentScreen (String countryname)
    {
        CountryName.sendKeys(countryname);
        selectcountry.click();
        finishselection.click();
        PaymentPage payment = new PaymentPage(driver);
        return payment;

    }

 }
