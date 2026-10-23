package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartTest extends BaseTest {

	@Test
	public void verifyCartAndCheckout() {
		//login
		LoginPage login=new LoginPage(driver);
		login.enterUsername("standard_user");
		login.enterPassword("secret_sauce");
		login.clickLogin();
		
		
		//Add product,
		ProductsPage product=new ProductsPage(driver);
		product.addProductToCart();
		
		
		//OpenCart,
        driver.findElement(By.className("shopping_cart_link")).click();

        // Verify cart
        CartPage cart=new CartPage(driver);
        Assert.assertEquals(cart.getCartTitle(),"Your Cart");
        Assert.assertEquals(cart.getProductName(),"Sauce Labs Backpack");
        
		//Proceed to checkout,
        cart.clickCheckout();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one.html"));
		
	}
	
}
