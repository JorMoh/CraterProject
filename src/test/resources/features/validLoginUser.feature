@Regression 
Feature: Title of your feature
  I want to use this template for my feature file

   Background: 
     Given user is on the login page
   
 @validLoginTest  @smokeTests
   Scenario: User is able to login successfully
     When  user enter valid "mochana24@gmail.com" and "Test1234"
     And   clicks on the login button
     Then  user should be on dashboard page
     And   user quits the browser
  

