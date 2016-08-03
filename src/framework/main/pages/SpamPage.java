package framework.main.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SpamPage extends InboxPage
{
	private final static Logger LOG = LogManager.getLogger("eventLogger");
	
	public SpamPage(WebDriver webDriver) 
	{
		super(webDriver);
	}
		
	public boolean checkSpam(String email, String nameAndSurname)
	{
		String xPath = "//span[@email='" + email
				+ "' and @name = '" + nameAndSurname + "']";
		List<WebElement> elems = driver.findElements(By.xpath(xPath));
		
		LOG.info("Looking for the letter from " + email + " in Spam");
		
		return (elems.size()!=0);
	}
}
