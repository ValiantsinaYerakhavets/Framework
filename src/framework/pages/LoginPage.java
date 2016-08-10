package framework.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.businessobjects.User;

public class LoginPage extends BasePage {
	
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
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public InboxPage logIn(User user) {
		String login = user.getEmail();
		String password = user.getPassword();
		
		emailInput.sendKeys(login);
		
		nextButton.click();
		
		passwordInput.sendKeys(password);
		
		if(forgetMeCheckBox.isSelected()) {
			forgetMeCheckBox.click();
		}
		
		signInButton.click();
		
		LOG.info("Successfully logged in");
		return new InboxPage(driver);
	}
}
