package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;



public class InventoryPage extends BasePage{
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "inventory_item")
    public List<WebElement> inventoryItems;


    @FindBy(className = "product_sort_container")
    public WebElement sortDropdown;

    @FindBy(className = "inventory_item_price")
    public List<WebElement> priceElements;

    @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
    public WebElement Add_to_cart_button;

    @FindBy(xpath="//a[@class='shopping_cart_link']")
    public WebElement Shopping_cart_icon;

    @FindBy(className = "shopping_cart_badge")
    public List<WebElement> cartBadge;;

    @FindBy(xpath="//div[@id='cart_contents_container']//div[3]")
    public WebElement Cart_container;

    @FindBy(xpath="//button[@id='remove-sauce-labs-backpack']")
    public WebElement Remove_button;

    @FindBy(xpath="//button[@id='continue-shopping']")
    public WebElement Continue_shopping_button;

    @FindBy(xpath="//div[@class='header_secondary_container']")
    public WebElement Header_Container;



    //*Actions*//

    public int getProductCount() {
        return inventoryItems.size();
    }


    // Method to select option by visible text
    public void selectSortOption(String optionText) {
        Select select = new Select(sortDropdown);
        select.selectByVisibleText(optionText);
    }

    public String getSelectedOptionText() {
        Select select = new Select(sortDropdown);
        return select.getFirstSelectedOption().getText();
    }


    public List<Double> getAllProductPrices() {
        return priceElements.stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "")))
                .collect(Collectors.toList());
    }

    public void Add_to_cart(){
        Add_to_cart_button.click();
        Shopping_cart_icon.click();
    }

    public void Remove_item(){
        Remove_button.click();
    }

    public void Continue_shop(){
        Continue_shopping_button.click();
    }








}
