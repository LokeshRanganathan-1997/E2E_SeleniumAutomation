package listeners;
import base.BaseTest;
import utils.ScreenshotUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentManager;

public class TestListener implements ITestListener {
	// Extent Report object
	ExtentReports extent = ExtentManager.getReport();

	// Individual Test
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {

	    System.out.println("Test Started : " + result.getName());

	    // Create test in report
	    test = extent.createTest(result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {

	    System.out.println("Test Passed : " + result.getName());

	    test.pass("Test Passed");

	}
    
    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("Test Failed : " + result.getName());

        test.fail(result.getThrowable());
        
        // Get current test class
        BaseTest test = (BaseTest) result.getInstance();

        // Capture screenshot
        ScreenshotUtils.captureScreenshot(
                test.getDriver(),
                result.getName());

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

        // Save report to HTML file
        extent.flush();

    }

}