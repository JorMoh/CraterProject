package step_definitions_UI;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import craterPagesPOM.CommonPOM;
import craterPagesPOM.CustomersPOM;
import craterPagesPOM.LoginPOM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BrowserUtils;
import utils.DButils;
import utils.Driver;

 
public class AddNewCustomerTests {
	String customerEmail = "JordanMo@yahoo.com";
	LoginPOM login = new LoginPOM();
	CommonPOM common = new CommonPOM();
	CustomersPOM customer = new CustomersPOM();
	BrowserUtils utils = new BrowserUtils();
	DButils db = new DButils();

	
	@Given("user logs in")
	public void user_logs_in() {
	    login.Craterlogin();
	}
	
	@Given("user navigates to Customers tab and clicks on it")
	public void user_navigates_to_customers_tab_and_clicks_on_it() {
		common.customersTab.click();
   	}
	
	@Given("clicks on new customer button")
	public void clicks_on_new_customer_button() {
	    customer.addNewCustomerBtn.click();
	}
	
	@When("user enters the details for :Basic Info, Portal Access, Billing Address, and Shipping Address")
	public void user_enters_the_details_for_basic_info_portal_access_billing_address_and_shipping_address() {
	   Assert.assertTrue(customer.newCustomerHeader.isDisplayed());
	   customer.basicInfoDisplayName.sendKeys("Jordan");
	   customerEmail =customerEmail + utils.randomNumber();
	   customer.basicInfoEmail.sendKeys(customerEmail);
	   customer.basicInfoPhone.sendKeys("5713331231");
	   customer.billingAddressName.sendKeys("Jordan");
	   customer.billingAddressCountry.sendKeys("United States");
	   customer.billingAddressState.sendKeys("VA");
	   customer.billingAddressCity.sendKeys("Burke");
	   customer.billingAddressStreet1.sendKeys("8511 Bauer dr");
	   customer.copyFromBillingBtn.click();
	   
	}
	
	@When("user clicks on the Save Customer button.")
	public void user_clicks_on_the_save_customer_button() {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
        wait.until(ExpectedConditions.elementToBeClickable(customer.saveCustomerBtn));
		 customer.saveCustomerBtn.click();
	}
	
	@Then("user should see a flash message : “Success! Customer created successfully” with a close button to the right.")
	public void user_should_see_a_flash_message_success_customer_created_successfully_with_a_close_button_to_the_right() throws InterruptedException {
		utils.waitUntilElementVisible(customer.successfulCustomerCreationMsg);
	    Assert.assertTrue(customer.successfulCustomerCreationMsg.isDisplayed());
	}
	
	
	@Then("user can close the flash message by clicking on the X button.")
	public void user_can_close_the_flash_message_by_clicking_on_the_x_button() {
	   
	}



	
	@Then("user should be navigated to the Sales and expenses page.")
	public void user_should_be_navigated_to_the_sales_and_expenses_page() {
	   Assert.assertTrue(customer.salesAndExpensesHeader.isDisplayed());
	}
	
	@Then("user should be able to view the info for the customer:Basic Info, Display Name, Primary Contact Name, Email, Currency, Phone Number, website")
	public void user_should_be_able_to_view_the_info_for_the_customer_basic_info_display_name_primary_contact_name_email_currency_phone_number_website() {
		Assert.assertEquals(customer.customerPageDisplayName.getText(), "Jordan");
		Assert.assertEquals(customer.customerPageEmail.getText(), customerEmail);
		Assert.assertEquals(customer.customerPagePhone.getText(), "5713331231");
		Assert.assertEquals(customer.customerPageCurrency.getText(), "USD ($)");
		
	}
	
	@Then("the customer info entered for: \\(Basic Info, Portal Access, Billing Address, Shipping Address) should be saved in the application database")
	public void the_customer_info_entered_for_basic_info_portal_access_billing_address_shipping_address_should_be_saved_in_the_application_database() {
		List<String> recordData = db.selectArecord("SELECT * FROM customers WHERE email='"+customerEmail+"'");
		Assert.assertTrue(recordData.get(3).equals(customerEmail));
	}




}
