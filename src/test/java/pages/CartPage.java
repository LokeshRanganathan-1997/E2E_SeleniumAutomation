package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

	WebDriver driver;
	//Locators,
	By cartTitle= By.className("title");
    By productName=By.className("inventory_item_name");
    By checkoutButton=By.id("checkout");
    
    //Constructors,
    public CartPage(WebDriver driver) {
    	this.driver=driver;
    }
    
    //Actions,
    public String getCartTitle() {
		return driver.findElement(cartTitle).getText();
    	
    }
    public String getProductName() {
		return driver.findElement(productName).getText();
    	
    }
    
    public void clickCheckout() {
    	driver.findElement(checkoutButton).click();
    }
}
