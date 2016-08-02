package framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverInstance 
{
	private static WebDriver instance = null;
	
	private WebDriverInstance() {}
	
	public static WebDriver getInstance()
	{
		if(instance == null)
		{
			instance = new FirefoxDriver();
		}
		return instance;
	}
	
	public static void closeDriver()
	{
		instance.quit();
		instance = null;
	}
}
