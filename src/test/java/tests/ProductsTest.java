package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsTest extends BaseTest{
	
	@Test
	public void verifyProductsAndAddToCart() {
		
		//loginPage
		LoginPage login=new LoginPage(driver);
		login.enterUsername("standard_user");
		login.enterPassword("secret_sauce");
		login.clickLogin();
		
		//ProductsPage
		ProductsPage products=new ProductsPage(driver);
		Assert.assertEquals(products.getPageTitle(),"Products");
		
		//AddProducts,
		products.addProductToCart();
		Assert.assertEquals(products.getCartCount(), "1");
	}

}
