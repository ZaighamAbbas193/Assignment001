package utils;
import io.qameta.allure.Allure;  // Ensure this import is correct

import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;  // Import WebDriver

public class AllureReport {

    // Method to attach a screenshot as byte array to Allure
    public static void attachScreenshot(WebDriver driver) {  // Specify WebDriver type for the parameter
        
        if (driver == null) {
            System.out.println("WebDriver is not initialized. Cannot take screenshot.");
            return;
        }

        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
    }
}