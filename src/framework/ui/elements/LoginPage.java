package framework.ui.elements;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.exception.IllegalPageException;

public class LoginPage 
{
	private final static Logger LOG = LogManager.getLogger("eventLogger");
	private final WebDriver webDriver;
	
	@FindBy(xpath = "//input[@id = 'Email']")
	WebElement emailInput;
	
	@FindBy(xpath = "//input[@id = 'next']")
	WebElement nextButton;
	
	@FindBy(xpath = "//input[@name = 'Passwd']")
	WebElement passwordInput;
	
	@FindBy(xpath = "//input[@id = 'signIn']")
	WebElement signInButton;
	
	public LoginPage(WebDriver webDriver) throws IllegalPageException
	{
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	public void logIn(String login, String password) throws InterruptedException
	{
		this.setLogin(login);
		LOG.info("Setting login\t-\t" + login);
		
		nextButton.click();
		LOG.info("Clicking Next button");
		
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		this.setPassword(password);
		LOG.info("Setting password\t-\t" + password);
		
		signInButton.click();
		LOG.info("Clicking SignIn button");
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
