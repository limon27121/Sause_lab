package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//button[@id='checkout']")
    public WebElement Check_out_button;

    @FindBy(xpath="//div[@class='header_secondary_container']")
    public WebElement Checkout_topbar_text;

    @FindBy(xpath="//input[@id='first-name']")
    public WebElement First_name;
    @FindBy(xpath="//input[@id='last-name']")
    public WebElement Last_name;
    @FindBy(xpath="//input[@id='postal-code']")
    public WebElement Postal_code;
    @FindBy(xpath="//input[@id='continue']")
    public WebElement Continue_button;

    @FindBy(xpath="//div[@class='checkout_info']")
    public WebElement Check_out_info_card;

    @FindBy(xpath="//span[@class='title']")
    public WebElement Checkout_header;

    @FindBy(xpath="//div[@class='cart_item']")
    public WebElement Cart_item;

    @FindBy(xpath="//button[@id='finish']")
    public WebElement Finish_button;




    public void Click_checkout() throws InterruptedException {
        InventoryPage inv_page=new InventoryPage(driver);
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
        inv_page.Add_to_cart();
        Check_out_button.click();
        Thread.sleep(2000);
        First_name.sendKeys("limon");
        Last_name.sendKeys("alam");
        Postal_code.sendKeys("1216");
        Continue_button.click();
        Finish_button.click();

    }
}
