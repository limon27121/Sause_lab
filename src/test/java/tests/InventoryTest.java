package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;

import java.util.List;

public class InventoryTest extends  BaseClass{


    //**verify products are displayed correctly*//
    @Test
    public void testProductCount() {
        InventoryPage page=new InventoryPage(driver);
        int count = page.getProductCount();
        Assert.assertEquals(count, 6, "Product count should be 6");
    }


    @Test
    public void testSelectSortOption() {
        InventoryPage page=new InventoryPage(driver);
        String text1="Price (low to high)";
        String text2="Price (high to low)";
        // Select "Price (low to high)"
        page.selectSortOption(text1);

        // ✅ Example Assertion: Verify dropdown value is selected correctly
        String selectedOption = page
                .getSelectedOptionText();
        Assert.assertEquals(selectedOption, "Price (low to high)", "Dropdown option mismatch!");

        List<Double> prices = page.getAllProductPrices();

        List<Double> sortedPrices = prices.stream().sorted().toList();
        Assert.assertEquals(prices, sortedPrices, "Products should be sorted low to high");
    }

    @Test
    public void testAddtoCartProducts(){
        InventoryPage page=new InventoryPage(driver);
        page.Add_to_cart();
        Assert.assertTrue(page.Cart_container.isDisplayed()&&page.Remove_button.isDisplayed());

    }

    @Test
    public void testRemoveItemFromCart(){
        InventoryPage page=new InventoryPage(driver);
        testAddtoCartProducts();
        page.Remove_item();
        Assert.assertTrue(page.Continue_shopping_button.isDisplayed());
    }

    @Test
    public void testContinueShop(){
        InventoryPage page=new InventoryPage(driver);
        testAddtoCartProducts();
        page.Continue_shop();
        Assert.assertTrue(page.Header_Container.isDisplayed());
    }
}
