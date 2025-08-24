package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

import java.time.Duration;

public class BaseClass {
    WebDriver driver;
    @BeforeClass
    void setUp() {
        WebDriverManager.chromedriver().setup(); // Add this line if using WebDriverManager
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        //log in credential pass in that class for avoid redundancy
       LoginPage login=new LoginPage(driver);
        login.Click_login("standard_user","secret_sauce");
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // close browser after tests
        }
    }
}
