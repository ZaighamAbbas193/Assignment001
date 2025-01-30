package QAAutmation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.config.BaseTest;
import com.pages.StudentFormLocators;

public class StudentFormTest extends BaseTest {

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
	// Fill out the form using the methods from StudentFormLocators
	public void fillOutForm() {

		// Clear all fields to simulate empty input

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

	@Test(priority = 2, enabled = true)
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