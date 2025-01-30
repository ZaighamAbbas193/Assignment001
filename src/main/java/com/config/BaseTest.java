package com.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;

    // Setup method to initialize the WebDriver
    public WebDriver setup() {
    	
        System.setProperty(
                "webdriver.chrome.driver",
                "D:\\Code\\chrome\\chrome\\chromedriver.exe");

        String adblockerExtensionPath = "C:\\Users\\IT\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\Super_Ads_Blocker\\1.7.2_0";

        // Initialize ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("load-extension=" + adblockerExtensionPath);

        // Initialize WebDriver with ChromeOptions
        
        driver = new ChromeDriver(options);

        // Get all window handles
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

        // Switch to the second tab (new tab) by index
        driver.switchTo().window(windowHandles.get(0));

        // Set some basic configurations
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    // Method to tear down the WebDriver instance (close the browser)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}