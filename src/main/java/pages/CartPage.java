package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    // Driver from BaseTest
    WebDriver driver;

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // ==========================
    // Locators
    // ==========================

    // All product names available in cart
    private By cartProducts = By.cssSelector(".cartSection h3");
    
 // Checkout button
    private By checkoutButton = By.cssSelector(".totalRow button");

    // ==========================
    // Actions
    // ==========================

    // Verify whether the expected product exists in cart
    public boolean verifyProductInCart(String expectedProduct) {

        // Get all product names from cart
        List<WebElement> products = driver.findElements(cartProducts);

        // Check each product
        for (WebElement product : products) {

            // Compare with expected product
            if (product.getText().equalsIgnoreCase(expectedProduct)) {

                // Product found
                return true;
            }
        }

        // Product not found
        return false;
    }
 // Click Checkout
    public void clickCheckout() {

        driver.findElement(checkoutButton).click();

    }

}