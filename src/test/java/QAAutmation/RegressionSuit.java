package QAAutmation;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.config.BaseTest;
import com.pages.StudentFormLocators;

public class RegressionSuit extends BaseTest {

	private StudentFormLocators studentFormLocators;

	@BeforeTest
	// Open the Student Form Website and initialize the page objects
	public void openStudentFormWebsite() {
		// Call the setup method from BaseTest to initialize WebDriver
		driver = setup();

		// Initialize PageFactory to load the elements annotated with @FindBy
		studentFormLocators = PageFactory.initElements(driver, StudentFormLocators.class);

		// Open the desired URL
		driver.get("https://demoqa.com/automation-practice-form");
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

	@Test(priority = 2, enabled = true)

	// Validate Mobile Number Field (Only 10 digits should be accepted)
	public void validateMobileNumberField() throws InterruptedException {

		studentFormLocators.mobileNumberField.sendKeys(Keys.ARROW_UP);
		// Clear and enter a number with more than 10 digits
		studentFormLocators.mobileNumberField.clear();
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

	@Test(priority = 3, enabled = true)
	// Validate Email Field (Should contain a domain)
	public void validateEmailField() throws InterruptedException {

		Thread.sleep(1000);

		// Clear and enter a number with more than 10 digits
		studentFormLocators.emailField.clear();
		studentFormLocators.emailField.sendKeys(Keys.ARROW_UP);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll down the page by a certain number of pixels
		js.executeScript("window.scrollBy(500, 0)");

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

	@Test(priority = 4, enabled = true)
	// Fill out the form using the methods from StudentFormLocators
	public void fillOutForm() {

		// Clear all fields to simulate empty input
		studentFormLocators.emailField.sendKeys(Keys.ARROW_UP);
		studentFormLocators.firstNameField.clear();
		studentFormLocators.lastNameField.clear();
		studentFormLocators.mobileNumberField.clear();
		studentFormLocators.emailField.clear();

		studentFormLocators.enterFirstName("QA");
		studentFormLocators.enterLastName("test");
		studentFormLocators.enterEmail("QAtest@mail.com");
		studentFormLocators.selectGenderMale();
		studentFormLocators.enterMobileNumber("1234567890");
		studentFormLocators.enterDateOfBirth("31 Jan 2026");
		studentFormLocators.enterSubjects("Maths");
		studentFormLocators.selectHobbySports();
		studentFormLocators.uploadPicture("C:\\Users\\IT\\Desktop\\ABC.png");
		studentFormLocators.enterAddress("12th Main Street, Karachi, Pakistan");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll down the page by a certain number of pixels
		js.executeScript("window.scrollBy(0, 1000)");

		studentFormLocators.selectState();
		studentFormLocators.selectCity();
	}

	@Test(priority = 5, enabled = true)
	// Submit the form and verify the success message
	public void submitFormAndVerify() {
		studentFormLocators.submitForm();
		String successMessage = studentFormLocators.getSuccessMessage();
		if ("Thanks for submitting the form".equals(successMessage)) {
			System.out.println("Form submitted successfully!");
		} else {
			System.out.println("Form submission failed!");
		}
	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}

}
