package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseClass{
    @Test
    public void Login_with_valid_cred(){
        LoginPage p1=new LoginPage(driver);
        p1.Click_login("standard_user","secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                "User should be redirected to inventory page after valid login");
    }

    @Test
    public void Log_in_with_invalid_cred(){
        LoginPage p1=new LoginPage(driver);
        p1.Click_login("standard_user1","secret_sauce1");
        Assert.assertTrue(p1.Text(p1.error_text).contains("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public void testLockedUserLogin(){
        LoginPage p1=new LoginPage(driver);
        p1.Click_login("locked_out_user","secret_sauce");
        Assert.assertTrue(p1.Text(p1.locked_user_text).contains("Epic sadface: Sorry, this user has been locked out."));
    }


    @Test
    public void testEmptyFieldsLogin(){
        LoginPage p1=new LoginPage(driver);
        p1.Click_login("","");
        Assert.assertTrue(p1.Text(p1.empty_user_text).contains("Epic sadface: Username is required"));

    }
}
