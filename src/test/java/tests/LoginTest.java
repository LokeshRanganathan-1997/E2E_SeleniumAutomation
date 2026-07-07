package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.ScreenshotUtils;
import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;

public class LoginTest extends BaseTest {

    @Test
    public void verifyOrderFlow() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication(
        	    config.getProperty("email"),
        	    config.getProperty("password"));
        // Products
        ProductPage productPage = new ProductPage(driver);

        productPage.addProductToCart("ZARA COAT 3");

        //productPage.addProductToCart("IPHONE");
        
        productPage.clickCart();

        // Cart
        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(cartPage.verifyProductInCart("ZARA COAT 3"));

        cartPage.clickCheckout();

        // Checkout
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.selectCountry("India");

        checkoutPage.placeOrder();

        String actualMessage = checkoutPage.getSuccessMessage();

        Assert.assertEquals(actualMessage, "THANKYOU FOR THE ORDER.");

        System.out.println("Order Placed Successfully");
        
    }

}