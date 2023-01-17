package step_definitions_UI;

import org.junit.Assert;

import craterPagesPOM.LoginPOM;
import craterPagesPOM.ResetPasswordPOM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BrowserUtils;
import utils.Driver;
import utils.dataReader;

public class ResetPasswordSteps {
	
	LoginPOM login = new LoginPOM();
	ResetPasswordPOM reset = new ResetPasswordPOM();
	BrowserUtils utils = new BrowserUtils();
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		Driver.getDriver().get(dataReader.getData("craterUrl"));
	}

	@When("user click on Forget Password? link")
	public void user_click_on_forget_password_link() {
	    login.forgotPasswordLink.click();
	}

	@Then("user is on reset password page")
	public void user_is_on_reset_password_page() {
		utils.waitUntilElementVisible(reset.sendResetLinkBtn);
		Assert.assertTrue(reset.sendResetLinkBtn.isDisplayed());
	   
	}

	@When("user enter email field with {string}")
	public void user_enter_email_field_with_invalid_email_format(String invalidFormat) {
		utils.sendKeysWithActionsClass(reset.enterEmailField, invalidFormat);
	   
	}

	@Then("user see the error message: “Incorrect Email”.")
	public void user_see_the_error_message_incorrect_email() {
		utils.waitUntilElementVisible(reset.incorrectEmailText);
		Assert.assertTrue(reset.incorrectEmailText.isDisplayed());
	    
	}

	@When("user clear email field")
	public void user_clear_email_field() {
		
		utils.clearTextOfAFieldMac(reset.enterEmailField);
	   
	}

	@Then("user see the error message: “Field is required”.")
	public void user_see_the_error_message_field_is_required() {
	    Assert.assertTrue(reset.fieldisRequiredText.isDisplayed());
	}

	@When("user enter valid {string}")
	public void user_enter_valid_email(String email) {
		utils.sendKeysWithActionsClass(reset.enterEmailField, email);
	   
	}

	@When("user click on Send Reset Link")
	public void user_click_on_send_reset_link() {
	    reset.sendResetLinkBtn.click();
	}

	@Then("user should see email sent successfully displaye")
	public void user_should_see_email_sent_successfully_displaye() {
		utils.waitUntilElementVisible(reset.mailSentsSuccessMessage);
		Assert.assertTrue(reset.mailSentsSuccessMessage.isDisplayed());
	}

	@When("user click on Back to Login? link")
	public void user_click_on_back_to_login_link() {
	    reset.backToLoginLink.click();
	}

	@Then("user should go back to login page")
	public void user_should_go_back_to_login_page() {
		utils.waitUntilElementVisible(login.loginButton);
		Assert.assertTrue(login.loginButton.isDisplayed());
	}


}
