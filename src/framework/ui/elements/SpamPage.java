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
		
	public boolean checkSpam(String email, String nameAndSurname)
	{
		String xPath = "//span[@email='" + email
				+ "' and @name = '" + nameAndSurname + "']";
		List<WebElement> elems = driver.findElements(By.xpath(xPath));
		return (elems.size()!=0);
	}
}
