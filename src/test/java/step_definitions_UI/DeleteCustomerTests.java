package step_definitions_UI;

import craterPagesPOM.CustomersPOM;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BrowserUtils;
import utils.DButils;

import java.util.List;

import org.junit.Assert;


public class DeleteCustomerTests {
	CustomersPOM customer = new CustomersPOM();
	DButils db = new DButils();
	BrowserUtils utils = new BrowserUtils();
	
	@When("user clicks \\(Delete)")
	public void user_clicks_delete() {
	   customer.customerDeleteBtn.click(); 
	}
	
	@Then("user should be prompted with the Modal titled: Are you sure?")
	public void user_should_be_prompted_with_the_modal_titled_are_you_sure() {
	   Assert.assertTrue(customer.modalTitle.isDisplayed()); 
	}
	
	@Then("modal message is: You will not be able to recover this customer and all the related Invoices, Estimates and Payments.")
	public void modal_message_is_you_will_not_be_able_to_recover_this_customer_and_all_the_related_invoices_estimates_and_payments() {
	    Assert.assertEquals(customer.modalMessage.getText(), "You will not be able "
	    		+ "to recover this customer and all the related Invoices, Estimates and Payments.");
	}
	
	@Then("user should see \\(OK) and \\(Cancel) buttons")
	public void user_should_see_ok_and_cancel_buttons() {
		Assert.assertTrue(customer.deleteOkButton.isDisplayed()); 
		Assert.assertTrue(customer.deleteCancelButton.isDisplayed()); 
	}
	
	@When("user clicks \\(Cancel)")
	public void user_clicks_cancel() {
	    customer.deleteCancelButton.click();
	}
	
	@Then("the alert modal should be closed")
	public void the_alert_modal_should_be_closed() {
		Assert.assertTrue(customer.addNewCustomerBtn.isDisplayed()); 
	}
	
	@When("user clicks \\(OK)")
	public void user_clicks_ok() {
	    customer.deleteOkButton.click();
	}
	
	@Then("user should see a flash message “Success! Customer deleted successfully” with a close button to the right.")
	public void user_should_see_a_flash_message_success_customer_deleted_successfully_with_a_close_button_to_the_right() {
		Assert.assertTrue(customer.successfulCustomerDeleteMsg.isDisplayed()); 
	}
	
	@Then("user should be directed to the customer table")
	public void user_should_be_directed_to_the_customer_table() {
		Assert.assertTrue(customer.addNewCustomerBtn.isDisplayed()); 
	}
	
	@Then("The customer’s record should be deleted from the application database")
	public void the_customer_s_record_should_be_deleted_from_the_application_database() {
	   List<String> deletedData = db.selectArecord("select * from customers where ");
	   Assert.assertTrue(deletedData.isEmpty());
	}







}
