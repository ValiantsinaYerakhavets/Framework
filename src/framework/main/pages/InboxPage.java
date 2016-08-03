package framework.main.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import framework.main.properties.ResourceEnum;

public class InboxPage 
{
	private final static Logger LOG = LogManager.getLogger("eventLogger");
	protected final WebDriver driver;
	
	private String homeHandle;
	
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
	protected WebElement forwLink;
	
	public InboxPage(WebDriver webDriver) 
	{
		this.driver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	// common methods 
	
	public void logOut()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(accountsButton));
		accountsButton.click();
		LOG.info("Clicking Accounts button");
		signOutButton.click();
		LOG.info("Clicking SignOut button");
	}
	
	public boolean letterPresent(String fromWhom)
	{
		LOG.info("Checking if letter from " + fromWhom + " is present");

		String xPath = "//span[@name = '" + fromWhom + "']";
		List<WebElement> elems = driver.findElements(By.xpath(xPath));
		return (elems.size()!=0);
	}
	
	public void readLetter(String fromWhom)
	{
		if(letterPresent(fromWhom))
		{
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
	
	public final void confirmForwarding(String fromWhom)
	{
		readLetter(fromWhom);
		
		LOG.info("Clicking link from the letter");
		forwLink.click();
		
		LOG.info("Waiting page to load");
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		switchToOtherHandle();
		
		driver.findElement(By.xpath("//input[@value='Confirm']")).click();
		LOG.info("Clicking Confirm button");
		driver.close();
		
		switchToHomeHandle();
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
		LOG.info("Clicking Compose button");
		
		return new SendLetterPage(this.driver);
	}
	
	public SettingsPage settingsPage(String settings)
	{
		driver.get(settings);
		LOG.info("Going to settings");
		
		return new SettingsPage(this.driver);
	}
	
	// helpers
	
	public void switchToOtherHandle()
	{
		homeHandle = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles())
		{
			if(!winHandle.equals(homeHandle))
		    {
				driver.switchTo().window(winHandle);
				LOG.info("Driver is switching to a new handle");
		    	break;
		    }
		}
	}
	
	public void switchToHomeHandle()
	{
		driver.switchTo().window(homeHandle);
		LOG.info("Driver is returning to the main handle");
		homeHandle = null;
	}
}
