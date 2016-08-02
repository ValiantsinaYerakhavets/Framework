package framework.util.page;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	private final static Logger LOG = LogManager.getLogger("eventLogger");
	private final WebDriver driver;
	
	@FindBy(xpath = "//input[@id = 'Email']")
	WebElement emailInput;
	
	@FindBy(xpath = "//input[@id = 'next']")
	WebElement nextButton;
	
	@FindBy(xpath = "//input[@name = 'Passwd']")
	WebElement passwordInput;
	
	@FindBy(xpath = "//input[@id = 'signIn']")
	WebElement signInButton;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
