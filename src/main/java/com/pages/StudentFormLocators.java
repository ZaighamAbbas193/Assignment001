package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentFormLocators {

    // WebElements locators using @FindBy annotation
    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "userEmail")
    public WebElement emailField;

    @FindBy(xpath = "//label[normalize-space()='Male']")
    public WebElement genderMale;

    @FindBy(id = "userNumber")
    public WebElement mobileNumberField;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateInputLocator;

    @FindBy(id = "subjectsInput")
    public WebElement subjectsField;

    @FindBy(xpath = "//label[normalize-space()='Sports']")
    public WebElement hobbySports;

    @FindBy(id = "uploadPicture")
    public WebElement uploadPictureField;

    @FindBy(id = "currentAddress")
    public WebElement addressField;

    @FindBy(id = "state")
    public WebElement stateDropdown;

    @FindBy(id = "city")
    public WebElement cityDropdown;

    @FindBy(id = "react-select-3-option-1")
    public WebElement stateOption;

    @FindBy(id = "react-select-4-option-1")
    public WebElement cityOption;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@id='example-modal-sizes-title-lg']")
    public WebElement successMessage;

    // Method to enter first name
    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    // Method to enter last name
    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    // Method to enter email
    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    // Method to select gender
    public void selectGenderMale() {
        genderMale.click();
    }

    // Method to enter mobile number
    public void enterMobileNumber(String mobileNumber) {
        mobileNumberField.sendKeys(mobileNumber);
    }

    // Method to enter date of birth
    public void enterDateOfBirth(String date) {
        dateInputLocator.sendKeys(date); // You can use JavaScriptExecutor for setting the date if needed
    }

    // Method to enter subjects
    public void enterSubjects(String subject) {
        subjectsField.sendKeys(subject);
        subjectsField.sendKeys("\n"); // Simulate Enter key press to select the subject
    }

    // Method to select hobby (Sports)
    public void selectHobbySports() {
        hobbySports.click();
    }

    // Method to upload picture
    public void uploadPicture(String filePath) {
        uploadPictureField.sendKeys(filePath);
    }

    // Method to enter address
    public void enterAddress(String address) {
        addressField.sendKeys(address);
    }

    // Method to select state from dropdown
    public void selectState() {
        stateDropdown.click();
        stateOption.click();
    }

    // Method to select city from dropdown
    public void selectCity() {
        cityDropdown.click();
        cityOption.click();
    }

    // Method to click submit button
    public void submitForm() {
        submitButton.click();
    }

    // Method to get the success message after form submission
    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
