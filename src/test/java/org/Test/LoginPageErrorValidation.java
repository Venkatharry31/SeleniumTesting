package org.Test;

import org.Testcomponents.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginPageErrorValidation extends BaseClass {

    //public static void main(String[] args) throws InterruptedException, is replaced with Test NG as below
    @Test
    public void UserPassValidation() throws InterruptedException, IOException {

        String expectederrormsg = "Incorrect email or password.";
        landingpage.loginApplication("test281@test.com", "4$YYGYnsqnjvC@");
        String errordisplayed = landingpage.findError();
        System.out.println(errordisplayed);
        Assert.assertEquals(errordisplayed,expectederrormsg);

   }

    @Test(groups = {"PassValidation"})
    public void PasswordFieldValidation() throws InterruptedException, IOException {

        String expectederrormsg = "*Password is required";
        landingpage.loginApplication("test281@test.com", "");
        String errordisplayed = landingpage.findPassFieldError();
        System.out.println(errordisplayed);
        Assert.assertEquals(errordisplayed,expectederrormsg);

    }

}
