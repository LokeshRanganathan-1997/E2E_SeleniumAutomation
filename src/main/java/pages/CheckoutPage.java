package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    // ==========================
    // Driver
    // ==========================

    WebDriver driver;

    // ==========================
    // Constructor
    // ==========================

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // ==========================
    // Locators
    // ==========================

    // Checkout Button
    private By checkoutBtn = By.cssSelector(".totalRow button");

    // Country textbox
    private By country = By.xpath("//input[@placeholder='Select Country']");

    // India option
    private By india = By.xpath("//button[contains(@class,'ta-item')][2]");

    // Place Order
    private By placeOrder = By.cssSelector(".action__submit");

    // Success Message
    private By successMessage = By.cssSelector(".hero-primary");

    // ==========================
    // Methods
    // ==========================

    // Click Checkout
    public void clickCheckout() {

        driver.findElement(checkoutBtn).click();

    }

    // Select Country
    public void selectCountry(String countryName) {

        driver.findElement(country).sendKeys(countryName);

        driver.findElement(india).click();

    }

    // Click Place Order
    public void placeOrder() {

        driver.findElement(placeOrder).click();

    }

    // Get Success Message
    public String getSuccessMessage() {

        return driver.findElement(successMessage).getText();

    }

}