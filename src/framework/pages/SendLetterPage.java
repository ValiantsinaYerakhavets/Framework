package framework.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.businessobjects.Message;

public class SendLetterPage extends InboxPage
{
	private final static Logger LOG = LogManager.getLogger("eventLogger");
	
	@FindBy(xpath = "//textarea[@name = 'to']")
	private WebElement toWhomInput;
	
	@FindBy(xpath = "//input[@name = 'subjectbox']")
	private WebElement subjectInput;
	
	@FindBy(xpath = "//div[@role = 'textbox']")
	private WebElement messageInput;
	
	@FindBy(xpath = "//div[contains(text(), 'Send')]")
	private WebElement sendLetterButton;
	
	@FindBy(xpath = "//div[@aria-label = 'Attach files']")
	private WebElement attachFile;
	
	public SendLetterPage(WebDriver driver) 
	{
		super(driver);
	}
	
	public InboxPage sendLetter(Message msg)
	{						
		toWhomInput.sendKeys(msg.getRecipient());
		LOG.info("Entering to whom");
		subjectInput.sendKeys(msg.getSubject());
		LOG.info("Entering subject of the letter");
		messageInput.sendKeys(msg.getText());
		LOG.info("Entering text of the letter");
		
		if(!msg.getPath().isEmpty())
		{
			attachFiles();
		}
		
		sendLetterButton.click();
		
		return new InboxPage(this.driver);
	}
	
	public void attachFiles() ///////////////////////////////////////////////
	{						
		LOG.info("Attaching file to the letter");
	}
}
