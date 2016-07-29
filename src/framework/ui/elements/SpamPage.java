package framework.ui.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SpamPage extends InboxPage
{
	public SpamPage(WebDriver webDriver) 
	{
		super(webDriver);
	}
	
	private String xPath;
	
	public boolean checkSpam(String email, String nameAndSurname)
	{
		xPath = "//span[@email='" + email
				+ "' and @name = '" + nameAndSurname + "']";
		List<WebElement> elems = webDriver.findElements(By.xpath(xPath));
		return (elems.size()!=0);
	}
}
