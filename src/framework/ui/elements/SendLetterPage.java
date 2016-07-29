package framework.ui.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendLetterPage extends InboxPage
{
	@FindBy(xpath = "//textarea[@name = 'to']")
	private WebElement toWhomInput;
	
	@FindBy(xpath = "//input[@name = 'subjectbox']")
	private WebElement subjectInput;
	
	@FindBy(xpath = "//div[@role = 'textbox']")
	private WebElement messageInput;
	
	@FindBy(xpath = "//div[contains(text(), 'Send')]")
	private WebElement sendLetterButton;
	
	public SendLetterPage(WebDriver webDriver) 
	{
		super(webDriver);
	}
	
	public InboxPage sendLetter(String toWhom, String subject, String message)
	{						
		toWhomInput.sendKeys(toWhom);
		subjectInput.sendKeys(subject);
		messageInput.sendKeys(message);
		
		sendLetterButton.click();
		
		return new InboxPage(this.webDriver);
	}
}
