package org.Test;

import org.Testcomponents.BaseClass;
import org.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.sql.SQLException;


public class LoginPage extends BaseClass {

    //public static void main(String[] args) throws InterruptedException, is replaced with Test NG as below
    @Test
    public void newOrder() throws InterruptedException, IOException, SQLException {
        String addedproduct = "adidas original";
        String actuallink = "https://rahulshettyacademy.com/client/dashboard/cart";
        String countryname = "New Zealand";
        String screeninfo = "THANKYOU FOR THE ORDER.";

        //ProductCatalog productCatalog = landingpage.loginApplication("test28@test.com","4$YYGYnsqnjvC@");
        String[] creds = dbConnection();
        ProductCatalog productCatalog = landingpage.loginApplicationfromdb(creds);
        //ProductCatalog productCatalog = new ProductCatalog(driver);

        productCatalog.selectProduct();
        Thread.sleep(3000);

        CartPage cartpage = new CartPage(driver);
        String urllink = cartpage.selectCart();
        Assert.assertEquals(urllink,actuallink);

        boolean match = cartpage.VerifyProduct(addedproduct);
        Assert.assertTrue(match);
        Thread.sleep(3000);

        CheckOut checkout = new CheckOut(driver);
        checkout.CheckOutPage();
        PaymentPage payment = checkout.ToPaymentScreen(countryname);
        Thread.sleep(3000);

        //PaymentPage payment = new PaymentPage(driver);
        String message = payment.VerifyConfirmation();
        Assert.assertTrue(message.equalsIgnoreCase(screeninfo));

        }


}
