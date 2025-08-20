package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseClass {
    WebDriver driver;
    @BeforeClass
    void setUp() {
        WebDriverManager.chromedriver().setup(); // Add this line if using WebDriverManager
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://ucam.uiu.ac.bd/Security/LogIn.aspx");
        driver.manage().window().maximize();
        //log in credential pass in that class for avoid redundancy
//        login_page login=new login_page(driver);
//        login.log_in("011171060","2353");
    }

    @AfterClass
    void tear_down() {
        driver.close();
    }
}
