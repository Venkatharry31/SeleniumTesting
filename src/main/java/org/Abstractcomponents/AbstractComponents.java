package org.Abstractcomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponents
{
    WebDriver driver;
    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public void waitForElementToAppear(By findBy1, By findBy2){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(findBy2)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy1));

   }

    public void waitForWebElementToAppear(WebElement findBy1){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy1));

    }

    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    WebElement Cart;
    public String selectCart (){

        Cart.click();
        String urllink = driver.getCurrentUrl();
        return urllink;
    }

}
