package base;

import java.time.Duration;
import utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    // Driver object can be used by all child classes
    protected WebDriver driver;
    
    // Read values from config.properties
    protected ConfigReader config;

    // Runs before every test
    @BeforeMethod
    public void setUp() {

    	// Read values from config.properties
    	config = new ConfigReader();
    	
        // Launch Chrome browser
        driver = new ChromeDriver();

        // Maximize browser
        driver.manage().window().maximize();
        
     // Wait up to 10 seconds while searching for elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open application
        driver.get(config.getProperty("url"));
    }

    // Runs after every test
    @AfterMethod
    public void tearDown() {

        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }
    
 // Return driver object
    public WebDriver getDriver() {

        return driver;

    }
}