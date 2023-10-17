package org.pageobjects;

import org.Abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalog extends AbstractComponents {
    WebDriver driver;

    public ProductCatalog(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //WebElement test1 = driver.findElement(By.xpath("//*[@id=\"products\"]/div[1]/div[2]/div[2]/div/div/h5/b"));
    //WebElement test2 = test1.findElement(By.xpath("//*[@id=\"products\"]/div[1]/div[2]/div[2]/div/div/button[2]/i"));
    //test2.click();


      //Page Factory design

    @FindBy(xpath = "//*[@id=\"products\"]/div[1]/div[2]/div[2]/div/div/h5/b")
    WebElement Parent;

    @FindBy(xpath = "//*[@id=\"products\"]/div[1]/div[2]/div[2]/div/div/button[2]/i")
    WebElement Child;

    By sample1 = By.xpath("//button[@routerlink='/dashboard/cart']");
    By sample2 = By.cssSelector(".ng-animating");

    public void selectProduct (){
        waitForElementToAppear(sample1,sample2
        );
        Child.click();
    }

 }
