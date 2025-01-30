package StepDefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.config.BaseTest;
import com.pages.StudentFormLocators;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.time.Duration;

public class StudentForm extends BaseTest{

    private StudentFormLocators studentFormLocators;
    private WebDriverWait wait;

    @Given("the user opens the student form page")
    public void the_user_opens_the_student_form_page() {
        
    	// Setup WebDriver
    			WebDriver driver = setup();

    			// Initialize PageFactory to load elements annotated with @FindBy
    			studentFormLocators = PageFactory.initElements(driver, StudentFormLocators.class);

    			// Open the desired URL
    			driver.get("https://demoqa.com/automation-practice-form");

    			// Maximize the browser window
    		//	driver.manage().window().maximize();
    }

    @When("the user submits the form without filling the mandatory fields")
    public void the_user_submits_the_form_without_filling_the_mandatory_fields() throws InterruptedException {
        // Clear all fields and submit without data
        studentFormLocators.firstNameField.clear();
        studentFormLocators.lastNameField.clear();
        studentFormLocators.mobileNumberField.clear();
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
        js.executeScript("window.scrollBy(0, 1000)");
        studentFormLocators.submitForm();
        
    }

    @Then("the form should display red borders for the mandatory fields")
    public void the_form_should_display_red_borders_for_the_mandatory_fields() throws InterruptedException {
    	Thread.sleep(4000);
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

    @When("the user enters an invalid mobile number")
    public void the_user_enters_an_invalid_mobile_number() throws InterruptedException {
        studentFormLocators.mobileNumberField.clear();
        studentFormLocators.mobileNumberField.sendKeys("12345");
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
        js.executeScript("window.scrollBy(0, 1000)");
        studentFormLocators.submitForm();
        
    }

    @Then("the form should restrict the mobile number to exactly 10 digits")
    public void the_form_should_restrict_the_mobile_number_to_exactly_10_digits() throws InterruptedException {
    	String enteredMobileNumber = studentFormLocators.mobileNumberField.getAttribute("value");
		if (enteredMobileNumber.length() == 10) {
			System.out.println("Mobile Number field validation (PASS): Field accepts only 10 digits.");
		} else {
			System.out.println(
					"Mobile Number field validation (FAIL): Field should not accepts more than or less than 10 digits.");
		}
    }

    @When("the user enters an invalid email without a domain")
    public void the_user_enters_an_invalid_email_without_a_domain() throws InterruptedException {
        studentFormLocators.emailField.clear();
        studentFormLocators.emailField.sendKeys("abc.com");
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
        js.executeScript("window.scrollBy(0, 1000)");
        studentFormLocators.submitForm();
      //  js.executeScript("window.scrollBy(0, 1000)");
        
    }

    @Then("the form should display an error for the email field")
    public void the_form_should_display_an_error_for_the_email_field() throws InterruptedException {
    	Thread.sleep(1000);
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

    @When("the user fills in the valid information in the form")
    public void the_user_fills_in_the_valid_information_in_the_form() {
        studentFormLocators.enterFirstName("John");
        studentFormLocators.enterLastName("Doe");
        studentFormLocators.enterEmail("johndoe@example.com");
        studentFormLocators.selectGenderMale();
        studentFormLocators.enterMobileNumber("1234567890");
        studentFormLocators.enterDateOfBirth("31 Jan 2026");
        studentFormLocators.enterSubjects("Maths");
        studentFormLocators.selectHobbySports();
        studentFormLocators.uploadPicture("C:\\Users\\IT\\Desktop\\ABC.png");
        studentFormLocators.enterAddress("123 Main Street, City, Country");

        JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
        js.executeScript("window.scrollBy(0, 1000)");

        studentFormLocators.selectState();
        studentFormLocators.selectCity();
       // studentFormLocators.submitForm();
    }
   
    @Then("the form should be submitted successfully and show a success message")
    public void the_form_should_be_submitted_successfully_and_show_a_success_message() {
    	 studentFormLocators.submitForm();
         String successMessage = studentFormLocators.getSuccessMessage();
         if ("Thanks for submitting the form".equals(successMessage)) {
             System.out.println("Form submitted successfully!");
         } else {
             System.out.println("Form submission failed!");
         }
    }
}
