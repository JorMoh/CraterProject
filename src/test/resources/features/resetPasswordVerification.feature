@Regression
Feature: Reset Password Validation
  
  Background: 
    Given user is on the login page
    When user click on Forget Password? link
    Then user is on reset password page
  
  

  @resetPasswordComponents @resetPassword
  Scenario: Reset Password Components
    Then user should see textbox titled ‘Enter email*’.
    And button titled ‘Send Reset Link’.
    And link titled ‘Back to Login’. 
 
    
 
  @resetPasswordFunctionalityTest @resetPassword
  Scenario: user is able to enter email to reset password
    When user enter email field with "hgdhhdhd" 
    Then user see the error message: “Incorrect Email”.
    When user clear email field 
    Then user see the error message: “Field is required”.
    When user enter valid "mochana24@gmail.com"
    And user click on Send Reset Link
    Then user should see email sent successfully displaye
    When user click on Back to Login? link
    Then user should go back to login page
    
      
 


  