@Regression1 @SmokeTest1
Feature: As an Invoice application user can Add new item,
  i want  Add new item.

  @AddNewItem
  Scenario: user is able to Add new item
    Given user is on the login page
    And user logs in
    And user navigates on Items Menu Link and clicks on it
    And clicks on  Add Item
    When user enters the details for :Name,price,unit and DESCRIPTION.
    And user clicks on Save Item  button.
    Then user should see a flash message : “Success! Item created  successfully” with a close button to the right.
    And user can close the flash message by clicking on the X button.
    Then user should be navigated to the item page.
    And user should be able to view the  item added within the Items table
    And The item information entered for the following sections:Name,price,unit and DESCRIPTION. should be saved in the application database.
