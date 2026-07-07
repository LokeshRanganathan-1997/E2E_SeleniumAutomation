package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    // Driver received from BaseTest
    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {

        // Assign driver
        this.driver = driver;
    }

    // ==========================
    // Locators
    // ==========================

    // Email textbox
    private By txtEmail = By.id("userEmail");

    // Password textbox
    private By txtPassword = By.id("userPassword");

    // Login button
    private By btnLogin = By.id("login");

    // ==========================
    // Actions
    // ==========================

    // Complete Login Method
    public void loginToApplication(String email, String password) {

        // Enter email
        driver.findElement(txtEmail).sendKeys(email);

        // Enter password
        driver.findElement(txtPassword).sendKeys(password);

        // Click Login
        driver.findElement(btnLogin).click();
    }

}