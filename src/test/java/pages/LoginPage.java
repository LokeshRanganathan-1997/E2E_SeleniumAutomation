package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
	//Locators,
	By username= By.id("user-name");
	By password=By.id("password");
	By loginButton=By.id("login-button");
	By errorMessage=By.cssSelector("[data-test='error']");
	
	//Constructors,
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Actions
	public void enterUsername(String user) {
		driver.findElement(username).sendKeys(user);
	}
	
	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	
	public void clickLogin() {
		driver.findElement(loginButton).click();
		
	}
	
	public String getErrorMessage() {
		return driver.findElement(errorMessage).getText();
		
	}
}

