package framework.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.businessobjects.Message;

public class SpamPage extends InboxPage
{
	private final static Logger LOG = LogManager.getLogger("eventLogger");
	
	public SpamPage(WebDriver driver) 
	{
		super(driver);
	}
		
	public boolean checkSpam(Message msg)
	{
		String email = msg.getSender();
		
		String xPath = "//span[@email='" + email + "']";
		List<WebElement> elems = driver.findElements(By.xpath(xPath));
		
		LOG.info("Looking for the letter from " + email + " in Spam");
		
		return (elems.size()!=0);
	}
}
