@Regression @SmokeTest
Feature: As an Invoice application user,
  I want to be able to create customers,
  So that I can be able to log customer transactions.

  @AddCustomer
  Scenario: user is able to create a customer
    Given user is on the login page
    And user logs in
    And user navigates to Customers tab and clicks on it
    And clicks on new customer button
    When user enters the details for :Basic Info, Portal Access, Billing Address, and Shipping Address
    And user clicks on the Save Customer button.
    Then user should see a flash message : “Success! Customer created successfully” with a close button to the right.
    And user can close the flash message by clicking on the X button.
    Then user should be navigated to the Sales and expenses page.
    And user should be able to view the info for the customer:Basic Info, Display Name, Primary Contact Name, Email, Currency, Phone Number, website
    And the customer info entered for: (Basic Info, Portal Access, Billing Address, Shipping Address) should be saved in the application database
