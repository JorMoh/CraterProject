@Regression @SmokeTest
Feature: As an Invoice application user,
  I want to be able to edit Item and update,
  So that I can be able to Edit and update Item.
​
  @EditItem
  Scenario: user is able to edit and update
    Given user is on the login page
    And user logs in
    And user navigates to click on the ‘Items’ Menu Link tab and clicks on it
    And clicks on the more icon represented by three dots for a given  
    When user clicks on Edit
    Then user should be  directed to the Edit Item page
    And should be able to view all the  able to view all the item fields mentioned in AC 2.
    And should be able to edit all should be able to edit all the item fields mentioned in AC 2.
    When user clicks on the Update Item button
    Then user should see a flash message “Success! item updated successfully” with a close button to the right.
    And User should be directed to the  Items page of the item that was updated.
    And  User should be able to view that the item is updated within the items table. 
    And The application database should be updated with the Edits made by the user for the respective item. 