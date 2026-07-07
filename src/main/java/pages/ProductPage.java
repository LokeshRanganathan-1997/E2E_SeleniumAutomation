package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    // Driver received from BaseTest
    WebDriver driver;
 // Explicit wait object
    WebDriverWait wait;

    // Constructor
    public ProductPage(WebDriver driver) {

        this.driver = driver;

        // Wait for a maximum of 10 seconds
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ==========================
    // Locators
    // ==========================

    // All product cards
    private By products = By.cssSelector(".mb-3");

    // Cart button
    private By cartButton = By.cssSelector("[routerlink='/dashboard/cart']");

    // ==========================
    // Actions
    // ==========================

    // Add required product to cart
 // Add required product to cart
    public void addProductToCart(String productName) {

        // Get all product cards
        List<WebElement> productList = driver.findElements(products);

        // Loop through each product
        for (WebElement product : productList) {

            // Read product name
            String name = product.findElement(By.cssSelector("b")).getText();

            // Compare product name
            if (name.equalsIgnoreCase(productName)) {

                // Click Add To Cart
                product.findElement(By.cssSelector(".card-body button:last-of-type")).click();

                // Stop loop
                break;
            }
        }

        // Wait until success message appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));

        // Wait until loading animation disappears
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
    }
    
    // Open Cart
    public void clickCart() {

        // Wait until cart button becomes clickable
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));

        // Click cart
        driver.findElement(cartButton).click();
    }

}