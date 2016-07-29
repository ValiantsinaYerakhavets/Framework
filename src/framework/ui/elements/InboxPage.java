package framework.ui.elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InboxPage 
{
	private final static Logger LOG = LogManager.getRootLogger();
	protected final WebDriver webDriver;
	
	@FindBy(xpath = "//div[@aria-lable = 'Settings']")
	protected WebElement settingsButton;
	
	@FindBy(xpath = "//div[@role = 'menuitem']/div[text() = 'Settings']")
	protected WebElement settingsMenuItem;
	
	@FindBy(xpath = "//div[contains(text(), 'COMPOSE')]")
	protected WebElement writeLetterButton;
	
	@FindBy(xpath = "//span[@role = 'checkbox']/div[@role='presentation']")
	protected WebElement selectLetterBox;
	
	@FindBy(xpath = "//div[@aria-label = 'Report spam'")
	protected WebElement reportSpamButton;
	
	@FindBy(xpath = "//div[@aria-label = 'Delete']")
	protected WebElement deleteButton;
	
	@FindBy(xpath = "//input[@aria-label='Search']")
	protected WebElement searchInput;
	
	@FindBy(xpath = "//button[@aria-label='Search Gmail']")
	protected WebElement searchButton;
	
	@FindBy(xpath = "//a[contains(@title, 'Google Account')]")
	protected WebElement accountsButton;
	
	@FindBy(xpath = "//a[text() = 'Sign out']")
	protected WebElement signOutButton;
	
	public InboxPage(WebDriver webDriver) 
	{
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public void reportSpam()
	{
		selectLetterBox.click();
		reportSpamButton.click();
		LOG.info("Selecting all mails and marking it as spam");
	}
	
	public void clearInbox()
	{
		selectLetterBox.click();
		deleteButton.click();
		LOG.info("Selecting all mails in the checkbox and deleting it");
	}
	
	public void logOut()
	{
		accountsButton.click();
		LOG.info("Clicking Accounts button");
		signOutButton.click();
		LOG.info("Clicking SignOut button");
	}
	
	//////////////////////////////////////////////////////////////////////
	
	public SpamPage goToSpam()
	{
		searchInput.sendKeys("in:spam");
		searchButton.click();
		
		return new SpamPage(this.webDriver);
	}
	
	public SendLetterPage goToSendLetter()
	{
		writeLetterButton.click();
		
		return new SendLetterPage(this.webDriver);
	}
	
	public SettingsPage goToSettings()
	{
		settingsButton.click();
		settingsMenuItem.click();
		
		return new SettingsPage(this.webDriver);
	}
}
