package QAAutmation;

import com.config.BaseTest;
import com.pages.StudentFormLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;

public class FieldValidation extends BaseTest {

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

	// Validate Mobile Number Field (Only 10 digits should be accepted)
	public void validateMobileNumberField() throws InterruptedException {
		// Clear and enter a number with more than 10 digits
		// studentFormLocators.mobileNumberField.clear();
		studentFormLocators.mobileNumberField.sendKeys("12345");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll down the page by a certain number of pixels
		js.executeScript("window.scrollBy(0, 1000)");

		// Click submit button without filling any mandatory fields
		studentFormLocators.submitForm();

		// Verify if the field restricts input to only 10 digits
		String enteredMobileNumber = studentFormLocators.mobileNumberField.getAttribute("value");
		if (enteredMobileNumber.length() == 10) {
			System.out.println("Mobile Number field validation (PASS): Field accepts only 10 digits.");
		} else {
			System.out.println(
					"Mobile Number field validation (FAIL): Field should not accepts more than or less than 10 digits.");
		}

		Thread.sleep(1000);

		// Validate Mobile Number Field
		String mobileNumberBorderColor = studentFormLocators.mobileNumberField.getCssValue("border-color");
		if (mobileNumberBorderColor.equals("rgb(220, 53, 69)")) {
			System.out.println("Mobile Number field has a red border (PASS)");
		} else {
			System.out.println("Mobile Number field does not have a red border (FAIL)");
		}

	}

	@Test(priority = 2, enabled = true)
	// Validate Email Field (Should contain a domain)
	public void validateEmailField() throws InterruptedException {

		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll down the page by a certain number of pixels
		js.executeScript("window.scrollBy(500, 500)");

		// Clear and enter an invalid email without a domain
		// studentFormLocators.emailField.clear();
		studentFormLocators.emailField.sendKeys("abc.com");

		js.executeScript("window.scrollBy(0, 1000)");

		// Check if the email is considered invalid (no domain part)
		String enteredEmail = studentFormLocators.emailField.getAttribute("value");
		if (enteredEmail.contains("@")) {
			System.out.println("Email validation (FAIL): Email contain valid domain.");
		} else {
			System.out.println("Email validation (PASS): Email does not contains a valid domain.");
		}

		Thread.sleep(1000);

		// Validate Mobile Number Field
		String Eamilcolor = studentFormLocators.emailField.getCssValue("border-color");
		if (Eamilcolor.equals("rgb(220, 53, 69)")) {
			System.out.println("Email field has a red border (PASS)");
		} else {
			System.out.println("Email field does not have a red border (FAIL)");
		}

	}

	/*
	 * public static void main(String[] args) throws InterruptedException {
	 * FieldValidation test = new FieldValidation();
	 * 
	 * // Open the form website
	 * 
	 * test.openStudentFormWebsite();
	 * 
	 * // Validate Mobile Number and Email fields
	 * 
	 * test.validateMobileNumberField(); test.validateEmailField();
	 * 
	 * }
	 */

}