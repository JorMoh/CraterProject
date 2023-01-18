package step_definitions_UI;

import org.junit.Assert;

import craterPagesPOM.DashboardPOM;
import craterPagesPOM.LoginPOM;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BrowserUtils;
import utils.Driver;
import utils.dataReader;

public class LoginValidationSteps {
	
	LoginPOM login = new LoginPOM();
	BrowserUtils utils = new BrowserUtils();
	DashboardPOM dashboard = new DashboardPOM();
	
	
	
	
	@When("user enter valid {string} and {string}")
	public void user_enter_valid_email_and_password(String useremail,String password) {
		utils.sendKeysWithActionsClass(login.userEmailField, useremail);
		utils.sendKeysWithActionsClass(login.passwordField, password);
	    
	}

	@When("clicks on the login button")
	public void clicks_on_the_login_button() {
	    login.loginButton.click();
	}

	@Then("user should be on dashboard page")
	public void user_should_be_on_dashboard_page() {
	    Assert.assertTrue(dashboard.amountDueText.isDisplayed());
	}

	@Then("user quits the browser")
	public void user_quits_the_browser() {
	    Driver.getDriver().quit();
	}
    
	//invalid login
	@When("user enters invalid {string} and {string}")
	public void user_enters_invalid_email_and_password(String invalidUseremail, String invalidPassword) {
		utils.sendKeysWithActionsClass(login.userEmailField, invalidUseremail);
		utils.sendKeysWithActionsClass(login.passwordField, invalidPassword);
	    
	}

	@Then("an error message appears")
	public void an_error_message_appears() {
		utils.waitUntilElementVisible(login.invalidUserErrorMessage);
	    Assert.assertTrue(login.invalidUserErrorMessage.isDisplayed());
	    
	}

	@Then("user is not logged in")
	public void user_is_not_logged_in() {
	    Assert.assertEquals(Driver.getDriver().getCurrentUrl(), dataReader.getData("craterUrl"));
	}
    
	//invalidTestSets
	boolean useremailEmpty;
	boolean passwordEmpty;
	
	
	@When("user enters invalid useremail {string} and password {string}")
	public void user_enters_invalid_useremail_and_password(String invalidUseremail, 
			String invalidPassword) {
		 
		 useremailEmpty = invalidUseremail.isBlank();
		 passwordEmpty = invalidPassword.isBlank();
	  
		 utils.sendKeysWithActionsClass(login.userEmailField, invalidUseremail);
		 utils.sendKeysWithActionsClass(login.passwordField, invalidPassword );
	   
	}

	@Then("error messages appear")
	public void error_messages_appear() {
		
		if (useremailEmpty || passwordEmpty) {
			utils.waitUntilElementVisible(login.fieldRequiredMsg);
			Assert.assertTrue(login.fieldRequiredMsg.isDisplayed());
		    
		} else {
			utils.waitUntilElementVisible(login.invalidUserErrorMessage);
		    Assert.assertTrue(login.invalidUserErrorMessage.isDisplayed());
		}
	

	    
	}
}
