package framework.pages;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	private final static Logger LOG = LogManager.getLogger("eventLogger");
	
	@FindBy(xpath = "//input[@id = 'Email']")
	WebElement emailInput;
	
	@FindBy(xpath = "//input[@id = 'next']")
	WebElement nextButton;
	
	@FindBy(xpath = "//input[@name = 'Passwd']")
	WebElement passwordInput;
	
	@FindBy(xpath = "//input[@id = 'signIn']")
	WebElement signInButton;
	
	@FindBy(xpath = "//input[@id = 'PersistentCookie']")
	WebElement forgetMeCheckBox;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	public InboxPage logIn(String login, String password) 
	{
		this.setLogin(login);
		LOG.info("Setting login\t-\t" + login);
		
		nextButton.click();
		LOG.info("Clicking Next button");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		this.setPassword(password);
		LOG.info("Setting password\t-\t" + password);
		
		if(forgetMeCheckBox.isSelected())
		{
			forgetMeCheckBox.click();
			LOG.info("Clicking checkbox not to stay in");
		}
		
		signInButton.click();
		LOG.info("Clicking SignIn button");
		
		return new InboxPage(driver);
	}
	
	private void setLogin(String email)
	{
		emailInput.sendKeys(email);
	}
	
	private void setPassword(String password)
	{
		passwordInput.sendKeys(password);
	}
}
