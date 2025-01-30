
Feature: Student Form Validation

  Scenario: Validate Mandatory Fields
    Given the user opens the student form page  	
    When the user submits the form without filling the mandatory fields
    Then the form should display red borders for the mandatory fields
 
 Scenario: Validate Mobile Number Field
    Given the user opens the student form page
    When the user enters an invalid mobile number
    Then the form should restrict the mobile number to exactly 10 digits
 
 Scenario: Validate Email Field
    Given the user opens the student form page
    When the user enters an invalid email without a domain
    Then the form should display an error for the email field
    
 Scenario: Fill the Student Form
    Given the user opens the student form page
    When the user fills in the valid information in the form
    Then the form should be submitted successfully and show a success message