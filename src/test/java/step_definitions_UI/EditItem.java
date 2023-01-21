package step_definitions_UI;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import craterPagesPOM.CommonPOM;
import craterPagesPOM.CustomersPOM;
import craterPagesPOM.ItemsPOM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Driver;
import utils.BrowserUtils;
import utils.DButils;

public class EditItem {

	
	
	ItemsPOM item = new ItemsPOM ();
	BrowserUtils utils = new BrowserUtils();
	DButils db = new DButils();
	CommonPOM common = new CommonPOM();
	String newItemName = "Smart tv 889";
	String itemNewDescription;
	

	@Given("user navigates to click on the ‘Items’ Menu Link tab and clicks on it")
	public void user_navigates_to_click_on_the_items_menu_link_tab_and_clicks_on_it() {
		common.itemsTab.click();
			
	}
	
		   

		@Given("clicks on the more icon represented by three dots for a given")
		public void clicks_on_the_more_icon_represented_by_three_dots_for_a_given() throws InterruptedException {
			utils.waitUntilElementVisible(item.filterItemBtn);
			item.filterItemBtn.click();
			Thread.sleep(5000);
			utils.waitUntilElementVisible(item.filterNameField);
			item.filterNameField.sendKeys("smart tv 889");
			
		   item.threeDotsBtn.click();
		   
		}

		@When("user clicks on Edit")
		public void user_clicks_on_edit() {
		  item.ItemEditBtn.click();
		}

		@Then("user should be  directed to the Edit Item page")
	public void user_should_be_directed_to_the_edit_item_page() {
			//item.newItemHeader.isDisplayed();
		Assert.assertTrue( item.editItemHeader.isDisplayed());
		//	Assert.assertTrue(item.newItemHeader.isDisplayed());
		}

		@Then("should be able to view all the  able to view all the item fields mentioned in AC 2.")
		public void should_be_able_to_view_all_the_able_to_view_all_the_item_fields_mentioned_in_ac() {
			Assert.assertTrue(item.nameField.isDisplayed());
			Assert.assertTrue(item.priceField.isDisplayed());
			Assert.assertTrue(item.unitField.isDisplayed());
			Assert.assertTrue(item.descriptionField.isDisplayed());
			Assert.assertTrue(item.updateItemBtn.isDisplayed());
	     
		}
		

		@Then("should be able to edit all should be able to edit all the item fields mentioned in AC 2.")
		public void should_be_able_to_edit_all_should_be_able_to_edit_all_the_item_fields_mentioned_in_ac() throws InterruptedException {
			
			
			
			//Driver.getDriver().findElement(By.xpath("//a[text()='"+newItemName+"']")).click();
		
			//Assert.assertTrue(item.editItemHeader.isDisplayed());
		
			
			utils.waitUntilElementVisible(item.descriptionField);
			
			
			
		
		}

		@When("user clicks on the Update Item button")
		public void user_clicks_on_the_update_item_button() {
			//utils.waitUntilElementVisible(item.updateItemBtn);
		   item.updateItemBtn.click();
		}
		@Then("user should see a flash message “Success! item updated successfully” with a close button to the right.")
		public void user_should_see_a_flash_message_success_item_updated_successfully_with_a_close_button_to_the_right() {
		   
			utils.waitUntilElementVisible(item.itemUpdatedMsg);
		

			Assert.assertTrue(item.itemUpdatedMsg.isDisplayed());
		}

		@Then("User should be directed to the  Items page of the item that was updated.")
		public void user_should_be_directed_to_the_items_page_of_the_item_that_was_updated() throws InterruptedException {
			Thread.sleep(7000);
		   Assert.assertTrue(item.itemsHeader.isDisplayed());
		   Thread.sleep(7000);
		}

		@Then("User should be able to view that the item is updated within the items table.")
		public void user_should_be_able_to_view_that_the_item_is_updated_within_the_items_table() {
		  
		}

		@Then("The application database should be updated with the Edits made by the user for the respective item.")
		public void the_application_database_should_be_updated_with_the_edits_made_by_the_user_for_the_respective_item() {
			String updateQuery = "SELECT * FROM items WHERE name='Smart tv 889'";
			List<String> updatedData = db.selectArecord(updateQuery);
			
			// verify that the updated description match to the expected.
			System.out.print(updatedData.get(2));
			Assert.assertEquals(updatedData.get(2), "very nice and Smart tv 4k" );
		}
	
}