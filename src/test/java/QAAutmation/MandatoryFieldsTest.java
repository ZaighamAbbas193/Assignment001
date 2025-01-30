package QAAutmation;

import com.config.BaseTest;
import com.pages.StudentFormLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class MandatoryFieldsTest extends BaseTest {

    private StudentFormLocators studentFormLocators;

    @BeforeTest
    // Open the Student Form Website and initialize PageFactory
    public void openStudentFormWebsite() {
        // Setup WebDriver
        WebDriver driver = setup();

        // Initialize PageFactory to load elements annotated with @FindBy
        studentFormLocators = PageFactory.initElements(driver, StudentFormLocators.class);

        // Open the desired URL
        driver.get("https://demoqa.com/automation-practice-form");

        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test(priority = 1, enabled = true)
    // Fill out mandatory fields and submit the form to check validation
    public void validateMandatoryFields() throws InterruptedException {
        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Clear all fields to simulate empty input
        
        studentFormLocators.firstNameField.clear();
        studentFormLocators.lastNameField.clear();
        studentFormLocators.mobileNumberField.clear();
        
        

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down the page by a certain number of pixels
        js.executeScript("window.scrollBy(0, 1000)");
        

        // Click submit button without filling any mandatory fields
        studentFormLocators.submitForm();

        Thread.sleep(4000);
        
        // Wait for the form to process validation
        wait.until(ExpectedConditions.visibilityOf(studentFormLocators.firstNameField));

        // Validate First Name Field - Check for red border indicating an error
        String firstNameBorderColor = studentFormLocators.firstNameField.getCssValue("border-color");
        if (firstNameBorderColor.equals("rgb(220, 53, 69)")) {
            System.out.println("First Name field has a red border (PASS)");
        } else {
            System.out.println("First Name field does not have a red border (FAIL)");
        }

        // Validate Last Name Field
        String lastNameBorderColor = studentFormLocators.lastNameField.getCssValue("border-color");
        if (lastNameBorderColor.equals("rgb(220, 53, 69)")) {
            System.out.println("Last Name field has a red border (PASS)");
        } else {
            System.out.println("Last Name field does not have a red border (FAIL)");
        }

        // Validate Mobile Number Field
        String mobileNumberBorderColor = studentFormLocators.mobileNumberField.getCssValue("border-color");
        if (mobileNumberBorderColor.equals("rgb(220, 53, 69)")) {
            System.out.println("Mobile Number field has a red border (PASS)");
        } else {
            System.out.println("Mobile Number field does not have a red border (FAIL)");
        }
               
        // Verify that the Gender field border is red (for the radio button)
        String genderBorderColor = studentFormLocators.genderMale.getCssValue("border-color");
        if (genderBorderColor.equals("rgb(220, 53, 69)")) {
            System.out.println("Gender field has a red border (PASS)");
        } else {
            System.out.println("Gender field does not have a red border (FAIL)");
        }
        
        
    }
    
    
    
	/*
	 * public static void main(String[] args) throws InterruptedException {
	 * MandatoryFieldsTest test = new MandatoryFieldsTest();
	 * 
	 * // Open the form website test.openStudentFormWebsite();
	 * 
	 * // Validate mandatory fields
	 * 
	 * test.validateMandatoryFields();
	 * 
	 * // Tear down the WebDriver instance test.tearDown(); }
	 */
    
    
    
    
}