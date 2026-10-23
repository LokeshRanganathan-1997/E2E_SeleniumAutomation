package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest{

	@Test
	public void validLogin() {
		LoginPage login=new LoginPage(driver);
		login.enterUsername("standard_user");
		login.enterPassword("secret_sauce");
		login.clickLogin();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
	}

	@Test
	public void invalidLogin() {
		LoginPage login=new LoginPage(driver);
		login.enterUsername("Wrong-user");
		login.enterPassword("Wrong-pass");
		login.clickLogin();
		
		Assert.assertTrue(login.getErrorMessage().contains("Username and password do not match"));
	}
	
	}

