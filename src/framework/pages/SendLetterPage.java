package framework.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	
	public SendLetterPage(WebDriver webDriver) 
	{
		super(webDriver);
	}
	
	public InboxPage sendLetter(String toWhom, String subject, String message, boolean att)
	{						
		toWhomInput.sendKeys(toWhom);
		LOG.info("Entering to whom");
		subjectInput.sendKeys(subject);
		LOG.info("Entering subject of the letter");
		messageInput.sendKeys(message);
		LOG.info("Entering text of the letter");
		
		if(att)
		{
			attachFiles();
		}
		
		sendLetterButton.click();
		
		return new InboxPage(this.driver);
	}
	
	public void attachFiles()
	{						
		LOG.info("Attaching file to the letter");
	
		attachFile.sendKeys("C:\\Users\\Valiantsina_Yerakhavets@epam.com\\Task\\Framework\\report.log");
	}
}
