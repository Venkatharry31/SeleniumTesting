package org.Test;

import org.Testcomponents.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginPageErrorValidationFromProp extends BaseClass {

    //public static void main(String[] args) throws InterruptedException, is replaced with Test NG as below
    @Test(priority = 1)
    public void UserPassValidation() throws InterruptedException, IOException {

        String expectederrormsg = "Incorrect email or password.";
        landingpage.loginApplication(getUserCred().getString("username1"),getUserCred().getString("password1") );
        String errordisplayed = landingpage.findError();
        System.out.println(errordisplayed);
        Assert.assertEquals(errordisplayed,expectederrormsg);

   }

    @Test(priority = 2)
    public void PasswordFieldValidation() throws InterruptedException, IOException {

        String expectederrormsg = "*Password is required";
        landingpage.loginApplication(getUserCred().getString("username2"),getUserCred().getString("password2") );
        String errordisplayed = landingpage.findPassFieldError();
        System.out.println(errordisplayed);
        Assert.assertEquals(errordisplayed,expectederrormsg);

    }

}
