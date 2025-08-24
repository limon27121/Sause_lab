package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage extends BasePage{
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "inventory_item")
    public List<WebElement> inventoryItems;


    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> priceElements;


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


}
