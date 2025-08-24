package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//input[@id='user-name']")
    public WebElement user_name;

    @FindBy(xpath="//input[@id='password']")
    public WebElement password_field;

    @FindBy(xpath="//input[@id='login-button']")
    public WebElement log_in_button;

    @FindBy(xpath="//h3[contains(text(),'Epic sadface: Username and password do not match a')]")
    public WebElement error_text;

    @FindBy(xpath="//h3[contains(text(),'Epic sadface: Sorry, this user has been locked out')]")
    public WebElement locked_user_text;

    @FindBy(xpath="//h3[normalize-space()='Epic sadface: Username is required']")
    public WebElement empty_user_text;


    //**Action Methods**//

   public void Click_login(String user,String password){
       user_name.sendKeys(user);
       password_field.sendKeys(password);
       log_in_button.click();
   }

   public String Text(WebElement element){
       return element.getText();
   }


}
