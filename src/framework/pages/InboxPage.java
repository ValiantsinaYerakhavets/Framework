package framework.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.businessobjects.Message;
import framework.util.Switcher;

public class InboxPage extends BasePage
{
	private final static Logger LOG = LogManager.getLogger("eventLogger");
	
	@FindBy(xpath = "//div[contains(text(), 'COMPOSE')]")
	protected WebElement writeLetterButton;
	
	@FindBy(xpath = "//span[@role = 'checkbox']/div[@role='presentation']")
	protected WebElement selectLetterBox;
	
	@FindBy(xpath = "//div[@aria-label = 'Report spam']")
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
	
	@FindBy(xpath = "//a[@rel='noreferrer']")
	private WebElement forwLink;
	
	public InboxPage(WebDriver webDriver) 
	{
		super(webDriver);
	}

	// common methods 
	
	public LoginPage logOut()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(accountsButton));
		accountsButton.click();
		signOutButton.click();
		
		LOG.info("Successfully logged out");
		return new LoginPage(this.driver);
	}
	
	public boolean letterPresent(Message message)
	{
		String fromWhom = message.getSender();
		LOG.info("Checking if letter from " + fromWhom + " is present");

		String xPath = "//span[@name = '" + fromWhom + "']";
		List<WebElement> elems = driver.findElements(By.xpath(xPath));
		return (elems.size()!=0);
	}
	
	public void readLetter(Message message)
	{
		if(letterPresent(message))
		{
			String fromWhom = message.getSender();
			LOG.info("Letter from " + fromWhom + " is present. Opening it");
			
			String xPath = "//span[@name = '" + fromWhom + "']";
			driver.findElement(By.xpath(xPath)).click();
		}
	}
	
	public final void reportSpam()
	{
		selectLetterBox.click();
		reportSpamButton.click();
		LOG.info("Selecting all mails and marking it as spam");
	}
	
	public final void clearInbox()
	{
		selectLetterBox.click();
		deleteButton.click();
		LOG.info("Selecting all mails in the checkbox and deleting it");
	}
	
	// Forward test method
	
	public final void confirmForwarding(Message message)
	{
		readLetter(message);
		
		LOG.info("Clicking link from the letter");
		forwLink.click();
		
		Switcher.switchToOtherHandle(driver);
		LOG.info("Driver switched to a new handle");
		
		driver.findElement(By.xpath("//input[@value='Confirm']")).click();
		driver.close();
		
		Switcher.switchToHomeHandle(driver);
		LOG.info("Driver returned to the main handle");
	}

	// go to...
	
	public SpamPage spamFolder()
	{
		searchInput.sendKeys("in:spam");
		searchButton.click();
		LOG.info("Going to Spam folder");
		
		return new SpamPage(this.driver);
	}
	
	public SendLetterPage writeLetter()
	{
		writeLetterButton.click();
		
		return new SendLetterPage(this.driver);
	}
	
	public SettingsPage settingsPage()
	{
		String url = driver.getCurrentUrl().replace("inbox", "settings");
		driver.get(url);
		LOG.info("Going to settings");
		
		return new SettingsPage(this.driver);
	}
	
}
