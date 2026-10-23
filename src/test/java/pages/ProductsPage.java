package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
	WebDriver driver;
	
	//Locators,
	By pageTitle=By.className("title");
	By addToCartButton=By.id("add-to-cart-sauce-labs-backpack");
	By cartBadge=By.className("shopping_cart_badge");
	
	//Constructors,
	public ProductsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Actions,
	public String getPageTitle() {
		return driver.findElement(pageTitle).getText();
		
	}
	
	public void addProductToCart() {
		driver.findElement(addToCartButton).click();
	}

	public String getCartCount() {
		return driver.findElement(cartBadge).getText();
		
	}
}
