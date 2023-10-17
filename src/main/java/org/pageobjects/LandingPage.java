package org.pageobjects;

import org.Abstractcomponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponents {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Page Factory design

    @FindBy(id = "userEmail")
    WebElement Email;

    @FindBy(id = "userPassword")
    WebElement Password;

    @FindBy(id = "login")
    WebElement login;

    @FindBy(css = "[class*='flyInOut']")
    WebElement errormsg;

    @FindBy(xpath = "/html/body/app-root/app-login/div[1]/section[2]/div/div[2]/form/div[2]/div/div")
    WebElement passwordfielderror;

    public ProductCatalog loginApplication(String email, String pwd){
        Email.sendKeys(email);
        Password.sendKeys(pwd);
        login.click();
        ProductCatalog productCatalog = new ProductCatalog(driver);
        return productCatalog;
    }

    public ProductCatalog loginApplicationfromdb(String[] creds){
        Email.sendKeys(creds[0]);
        Password.sendKeys(creds[1]);
        login.click();
        ProductCatalog productCatalog = new ProductCatalog(driver);
        return productCatalog;
    }

    public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/client/");
    }

    public String findError()
    {
        waitForWebElementToAppear(errormsg);
        String msg = errormsg.getText();
        return msg;
    }

    public String findPassFieldError()
    {
        waitForWebElementToAppear(passwordfielderror);
        String msg = passwordfielderror.getText();
        return msg;
    }

}
