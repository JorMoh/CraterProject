package step_definitions_UI;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import craterPagesPOM.CustomersPOM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BrowserUtils;
import utils.DButils;

public class EditCustomerTests {
	String EditName = "Mohammad";
	CustomersPOM customer = new CustomersPOM();
	BrowserUtils utils = new BrowserUtils();
	DButils db = new DButils();
	

	@Given("clicks on the more icon represented by three dots for a given customer")
	public void clicks_on_the_more_icon_represented_by_three_dots_for_a_given_customer() {
	    customer.threeDotsBtn.click();
	}
	
	@When("user clicks on ‘Edit’")
	public void user_clicks_on_edit() throws InterruptedException {
	    customer.ItemEditBtn.click();
	}
	
	@Then("user should be directed to the Edit Customer page")
	public void user_should_be_directed_to_the_edit_customer_page() {
	    Assert.assertTrue(customer.editCustomerHeader.isDisplayed());
	}
	
	@Then("should be able to view all the customer fields mentioned in ACs 2, 2.1,2.3,2.4")
	public void should_be_able_to_view_all_the_customer_fields_mentioned_in_a_cs() {
	    Assert.assertTrue(customer.editBasicInfoHeader.isDisplayed());
	    Assert.assertTrue(customer.editDisplayNameLabel.isDisplayed());
	    Assert.assertTrue(customer.editEmailLabel.isDisplayed());
	    Assert.assertTrue(customer.editPhoneLabel.isDisplayed());
	    Assert.assertTrue(customer.editPrimaryCurrencyLabel.isDisplayed());
	    Assert.assertTrue(customer.billingAddressHeader.isDisplayed());
	    Assert.assertTrue(customer.billingAddressNameLabel.isDisplayed());
	    Assert.assertTrue(customer.billingAddressCountryLabel.isDisplayed());
	    Assert.assertTrue(customer.billingAddressStateLabel.isDisplayed());
	    Assert.assertTrue(customer.billingAddressStreet1Label.isDisplayed());
	    Assert.assertTrue(customer.billingAddressCityLabel.isDisplayed());
	}
	
	@Then("should be able to edit all the customer fields mentioned in ACs 2, 2.1,2.3,2.4")
	public void should_be_able_to_edit_all_the_customer_fields_mentioned_in_a_cs() throws InterruptedException {
		Thread.sleep(5000);
		EditName = EditName + utils.randomNumber();
		 utils.waitUntilElementVisible(customer.basicInfoDisplayName);
		 utils.clearValueOnTheField(customer.basicInfoDisplayName);
		// Thread.sleep(5000);
		  customer.basicInfoDisplayName.sendKeys(EditName);
		 // Thread.sleep(5000);
	}
	@When("user clicks on the ‘Update Customer’ button")
	public void user_clicks_on_the_update_customer_button() {
	 customer.updateCustomerBtn.click();
	}
	@Then("user should see a flash message “Success! Customer updated successfully” with a close button to the right.")
	public void user_should_see_a_flash_message_success_customer_updated_successfully_with_a_close_button_to_the_right() throws InterruptedException {
		utils.waitUntilElementVisible(customer.successfulCustomerUpdateMsg);
	    Assert.assertTrue(customer.successfulCustomerUpdateMsg.isDisplayed());
	    
	}
	@Then("User should be directed to the sales and expenses page of the customer that was updated.")
	public void user_should_be_directed_to_the_sales_and_expenses_page_of_the_customer_that_was_updated() throws InterruptedException {
		
		Assert.assertTrue(customer.salesAndExpensesHeader.isDisplayed());
		//Assert.assertTrue(customer.customerPageDisplayName.getText().equals(EditName));
	}
	@Then("The application database should be updated with the Edits made by the user.")
	public void the_application_database_should_be_updated_with_the_edits_made_by_the_user() {
	    List<String> recordData = db.selectArecord("select * from customers where name='"+EditName+"'");
	    Assert.assertTrue(recordData.get(2).equals(EditName));
	}




}
