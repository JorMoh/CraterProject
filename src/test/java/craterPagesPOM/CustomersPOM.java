package craterPagesPOM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class CustomersPOM {
	public CustomersPOM() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath = "//button[text()= ' New Customer']")
	public WebElement addNewCustomerBtn;
	
	@FindBy(xpath = "//h3[text()= 'New Customer']")
	public WebElement newCustomerHeader;
	
	@FindBy(xpath = "(//input[@name= 'name'])[1]")
	public WebElement basicInfoDisplayName;
	
	@FindBy(xpath = "//input[@name= 'email']")
	public WebElement basicInfoEmail;
	
	@FindBy(xpath = "(//input[@name= 'phone'])[1]")
	public WebElement basicInfoPhone;
	
	@FindBy(xpath = "//span[@class='translate-x-1 inline-block w-4 h-4 transition-transform bg-white rounded-full']")
	public WebElement portalAccess;
	
	@FindBy(xpath = "(//input[@name= 'address_name'])[1]")
	public WebElement billingAddressName;
	
	@FindBy(xpath = "(//input[@class='w-full absolute inset-0 outline-none appearance-none box-border border-0 text-sm "
			+ "font-sans bg-white rounded-md pl-3.5'])[2]")
	public WebElement billingAddressCountry;
	
	@FindBy(xpath = "//input[@name= 'billing.state']")
	public WebElement billingAddressState;
	
	@FindBy(xpath = "//input[@name= 'billing.city']")
	public WebElement billingAddressCity;
	
	@FindBy(xpath = "//textarea[@name= 'billing_street1']")
	public WebElement billingAddressStreet1;
	
	@FindBy(xpath = "//button[text()=' Copy from Billing']")
	public WebElement copyFromBillingBtn;
	
	@FindBy(xpath = "//div[@class='flex items-center justify-end']")
	public WebElement saveCustomerBtn;
	
	@FindBy(xpath = "//p[@class='text-sm leading-5 font-medium text-gray-900']")
	public WebElement successfulCustomerCreationMsg;
	
	@FindBy(xpath = "//p[text()='Customer created successfully']")
	public WebElement successfulCustomerCreationMsgCloseBtn;
	
	@FindBy(xpath = "//h6[@class='flex items-center']")
	public WebElement salesAndExpensesHeader;
	
	
	@FindBy(xpath = "(//p[@class='text-sm font-bold leading-5 text-black non-italic'])[1]")
	public WebElement customerPageDisplayName;
	
	@FindBy(xpath = "(//p[@class='text-sm font-bold leading-5 text-black non-italic'])[3]")
	public WebElement customerPageEmail;
	
	@FindBy(xpath = "(//p[@class='text-sm font-bold leading-5 text-black non-italic'])[4]")
	public WebElement customerPageCurrency;
	
	@FindBy(xpath = "(//p[@class='text-sm font-bold leading-5 text-black non-italic'])[5]")
	public WebElement customerPagePhone;
	
	

}