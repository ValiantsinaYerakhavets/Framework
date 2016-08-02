package framework.ui.elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends InboxPage
{
	private final static Logger LOG = LogManager.getLogger("eventLogger");
	
	@FindBy(xpath = "//a[text() = 'Forwarding and POP/IMAP']")
	private WebElement forwTab;
	
	@FindBy(xpath = "//a[contains(text(), 'Filters')]")
	private WebElement filtersTab;

	/**
	 *  Delete this slashes and write relative to this group message
	 */
	
	////////////////////////////////////////////////////////////////////////////////////////
	
	@FindBy(xpath = "//input[@value = 'Add a forwarding address']")
	private WebElement addForwButton;
	
	@FindBy(xpath = "//div[contains(text(), 'Please enter')]/div/input[@type = 'text']")
	private WebElement addForwInput;
	
	@FindBy(xpath = "//button[@name = 'next']")
	private WebElement nextButton;
	
	@FindBy(xpath = "//input[@value = 'Proceed']")
	private WebElement proceedButton;
	
	@FindBy(xpath = "//button[@name = 'ok']")
	private WebElement okButton;

	/**
	 * Same problem
	 */
	
	//-------------------------------------------------------------------------------------
	
	@FindBy(xpath = "//tbody/tr[td/span[contains(text(), 'a copy')]]/td/input[@type='radio']")
	private WebElement radioButton;
	
	@FindBy(xpath = "//span[text() = 'Create a new filter']")
	private WebElement createFilterLink;
	
	@FindBy(xpath = "//div[span/label[text() = 'From']]/span/input[@type='text']")
	private WebElement fromInput;
	
	@FindBy(xpath = "//span[label[text() = 'Has attachment']]/input[@type='checkbox']")
	private WebElement hasAttCheckBox;
	
	@FindBy(xpath = "//div[contains(text(), 'filter with')]")
	private WebElement createFilterWithLink;
	
	@FindBy(xpath = "//div[label[text() = 'Delete it']]/input[@type='checkbox']")
	private WebElement deleteCheckBox;
	
	@FindBy(xpath = "//div[label[contains(text(), 'Always mark')]]/input[@type='checkbox']")
	private WebElement markAsCheckBox;
	
	@FindBy(xpath = "//div[@role='button' and text()='Create filter']")
	private WebElement createFilterButton;
	
	public SettingsPage(WebDriver webDriver) 
	{
		super(webDriver);
	}

	public void setForwardToUser(String email)
	{
		forwTab.click();
		LOG.info("Clicking Forwarding and POP/IMAP");
		
		addForwButton.click();
		LOG.info("Clicking Add a forwarding address button");
		
		addForwInput.sendKeys(email);
		LOG.info("Entering email");
		
		nextButton.click();
		LOG.info("Clicking Next button");
		
		String currHandle = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles())
		{
		    driver.switchTo().window(winHandle);
		    LOG.info("Driver is switching to a new handle");
		}
		
		proceedButton.click();
		LOG.info("Clicking Proceed button");
		
		driver.switchTo().window(currHandle);
		LOG.info("Driver is returning to the main handle");
		
		okButton.click();
		LOG.info("Clicking Ok button");
	}
	
	public void chooseCopyOfIncoming()
	{
		radioButton.click();
		LOG.info("Choosing radiobutton \"Forward a copy of incoming mail to\"");
	}
	
	public void createNewFilter(String fromWhom)
	{
		filtersTab.click();
		LOG.info("Clicking Filters and Blocked Addresses");
		
		createFilterLink.click();
		LOG.info("Clicking Create a new filter");
		
		fromInput.sendKeys(fromWhom);
		LOG.info("Sending keys to From input");
		hasAttCheckBox.click();
		LOG.info("Has Attachment checkbox - check");
		createFilterWithLink.click();
		LOG.info("Clicking Create filter with this search");
		
		deleteCheckBox.click();
		LOG.info("Delete it checkbox - check");
		markAsCheckBox.click();
		LOG.info("Always mark it as important checkbox - check");
		createFilterButton.click();
		LOG.info("Clicking Create filter button");
	}
}
