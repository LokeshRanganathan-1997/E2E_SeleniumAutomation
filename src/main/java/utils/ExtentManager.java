package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    // Report object
    private static ExtentReports extent;

    // Create report only once
    public static ExtentReports getReport() {

        // If report is not created, create it
        if (extent == null) {

            // Report location
            ExtentSparkReporter reporter =
                    new ExtentSparkReporter("reports/AutomationReport.html");

            // Report Title
            reporter.config().setReportName("E2E Selenium Automation");

            // Browser title
            reporter.config().setDocumentTitle("Automation Execution Report");

            // Create Extent Report
            extent = new ExtentReports();

            // Attach reporter
            extent.attachReporter(reporter);

            // Additional information
            extent.setSystemInfo("Tester", "Lokesh");
            extent.setSystemInfo("Framework", "Selenium + TestNG");
            extent.setSystemInfo("Language", "Java");
        }

        return extent;
    }

}