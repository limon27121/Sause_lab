package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

public class Cart_Test extends BaseClass{

    @Test
    public void test_checkout() throws InterruptedException {
        CartPage page=new CartPage(driver);
        page.Click_checkout();
        Assert.assertTrue(page.Checkout_topbar_text.isDisplayed());
//        Assert.assertTrue(page.Check_out_info_card.isDisplayed());
        System.out.printf(page.Checkout_header.getText());
//        Assert.assertEquals(page.Checkout_header.getText(),"Checkout: Overview");
        Assert.assertTrue(page.Cart_item.isDisplayed());


    }
}
