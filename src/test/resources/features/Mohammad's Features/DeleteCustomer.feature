@Regression @DeleteCustomer
Feature: Feature: As an Invoice application user,
  I want to be able to delete customers

  Background: 
    Given user is on the login page
    And user logs in
    And user navigates to Customers tab and clicks on it
    And clicks on the more icon represented by three dots for a given customer
    When user clicks (Delete)
    Then user should be prompted with the Modal titled: Are you sure?
    And modal message is: You will not be able to recover this customer and all the related Invoices, Estimates and Payments.
    And user should see (OK) and (Cancel) buttons

  @CancelDeletion
  Scenario: user cancels customer deletion
    When user clicks (Cancel)
    Then the alert modal should be closed

  @ConfirmDeletion
  Scenario: user confirms customer deletion
    When user clicks (OK)
    Then user should see a flash message “Success! Customer deleted successfully” with a close button to the right.
    And user should be directed to the customer table
    And The customer’s record should be deleted from the application database
