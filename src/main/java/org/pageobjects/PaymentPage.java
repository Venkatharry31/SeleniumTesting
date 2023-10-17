package org.pageobjects;

import org.Abstractcomponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PaymentPage extends AbstractComponents {
    WebDriver driver;

    public PaymentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"htmlData\"]/tbody/tr[4]/td/table/tbody/tr/td/table/tbody/tr[1]/td/h1")
    WebElement confirmationmsg;

    public  String VerifyConfirmation(){
    String message = confirmationmsg.getText();
    System.out.println(message);
    return message;
    }

 }
