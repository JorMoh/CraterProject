package step_definitions_UI;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import craterPagesPOM.CommonPOM;
import craterPagesPOM.CustomersPOM;
import craterPagesPOM.ItemsPOM;
import craterPagesPOM.LoginPOM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Driver;
import utils.dataReader;
import utils.BrowserUtils;
import utils.DButils;

public class AddNewItem_successfully {
	
	
	LoginPOM login = new LoginPOM();
	CommonPOM common = new CommonPOM();
	ItemsPOM  item = new ItemsPOM();
	BrowserUtils  utils = new BrowserUtils();
	DButils db = new DButils();
	String newItemName = "Smart tv ";
	


	@Given("user navigates on Items Menu Link and clicks on it")
	public void user_navigates_on_items_menu_link_and_clicks_on_it() {
		common.itemsTab.click();
		Assert.assertTrue(common.itemsTab.isDisplayed());
	}




@Given("clicks on  Add Item")
public void clicks_on_add_item() {
	utils.waitUntilElementVisible(item.addItemBtn);
item.addItemBtn.click();	

}

@When("user enters the details for :Name,price,unit and DESCRIPTION.")
public void user_enters_the_details_for_name_price_unit_and_description() {
	newItemName = newItemName + utils.randomNumber();
	utils.waitUntilElementVisible(item.nameField);
	item.nameField.sendKeys(newItemName);
	item.priceField.sendKeys("66644");
	item.unitField.click();
	item.unitFieldbox.click();
	item.descriptionField.sendKeys("very nice and Smart tv 4k ");
	
}

@When("user clicks on Save Item  button.")
public void user_clicks_on_save_item_button() {
	item.saveItemBtn.click();
}

@Then("user should see a flash message : “Success! Item created  successfully” with a close button to the right.")
public void user_should_see_a_flash_message_success_item_created_successfully_with_a_close_button_to_the_right() {
	utils.waitUntilElementVisible(item.itemCreatedMsg);
	Assert.assertTrue(item.itemCreatedMsg.isDisplayed());
}

@Then("user should be navigated to the item page.")
public void user_should_be_navigated_to_the_item_page() {
 Assert.assertTrue(common.itemsTab.isDisplayed());

	
	
}

@Then("user should be able to view the  item added within the Items table")
public void user_should_be_able_to_view_the_item_added_within_the_items_table() {
	WebElement newItem = Driver.getDriver().findElement(By.xpath("//a[text()='"+newItemName+"']"));
	Assert.assertTrue(newItem.isDisplayed());
}


@Then("The item information entered for the following sections:Name,price,unit and DESCRIPTION. should be saved in the application")
public void the_item_information_entered_for_the_following_sections_name_price_unit_and_description_should_be_saved_in_the_application() {
	System.out.println("New LG Tv1 with number: " + newItemName);
	db = new DButils();
	String query = "SELECT * FROM items WHERE name='"+newItemName+"';";
	List<String> itemsData = db.selectArecord(query);
	System.out.println("ITEM ID: " + itemsData.get(0));
	System.out.println("ITEM NAME: " + itemsData.get(1));

	Assert.assertEquals(itemsData.get(1), newItemName);
}



	
}
