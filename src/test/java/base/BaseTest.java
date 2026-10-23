package base;
import utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
	
	protected WebDriver driver;
	@BeforeMethod
	public void setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get(ConfigReader.getProperty("url"));
		
	}

	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
		driver.quit();
		}
	}
}
