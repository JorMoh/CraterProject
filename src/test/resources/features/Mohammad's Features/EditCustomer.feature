@Regression @SmokeTest
Feature: As an Invoice application user,
  I want to be able to edit customers,
  So that I can be able to update customers information.

  @EditCustomer
  Scenario: user is able to edit a customer
    Given user is on the login page
    And user logs in
    And user navigates to Customers tab and clicks on it
    And clicks on the more icon represented by three dots for a given customer
    When user clicks on ‘Edit’
    Then user should be directed to the Edit Customer page
    And should be able to view all the customer fields mentioned in ACs 2, 2.1,2.3,2.4
    And should be able to edit all the customer fields mentioned in ACs 2, 2.1,2.3,2.4
    When user clicks on the ‘Update Customer’ button
    Then user should see a flash message “Success! Customer updated successfully” with a close button to the right.
    And User should be directed to the sales and expenses page of the customer that was updated.
    And The application database should be updated with the Edits made by the user.
