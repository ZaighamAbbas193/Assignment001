
Feature: Student Form Validation

  Scenario: Verify that all mandatory fields display a red border if the user clicks the submit button without entering data into the fields.
    Given the user opens the student form page  	
    When the user submits the form without filling the mandatory fields
    Then the form should display red borders for the mandatory fields
 
  Scenario: Verify that the mobile number field validation works correctly when the user enters more or fewer than 10 digits.
    Given the user opens the student form page
    When the user enters an invalid mobile number
    Then the form should restrict the mobile number to exactly 10 digits
 
  Scenario: Verify that the Email field validation works correctly when the user enters wrong email.
    Given the user opens the student form page
    When the user enters an invalid email without a domain
    Then the form should display an error for the email field
    
  Scenario: Verify that the user can fill out the form and submit it successfully.
    Given the user opens the student form page
    When the user fills in the valid information in the form
    Then the form should be submitted successfully and show a success message