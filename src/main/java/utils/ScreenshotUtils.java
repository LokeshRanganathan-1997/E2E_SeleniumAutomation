package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    // Capture Screenshot
    public static void captureScreenshot(WebDriver driver, String fileName) {

        // Take screenshot
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Destination
        File destination = new File("screenshots/" + fileName + ".png");

        try {

            // Copy screenshot
            Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot Saved : " + destination.getAbsolutePath());

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

}