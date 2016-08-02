package framework.driverManager.driverConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverInstance 
{
	private static WebDriver instance = null;
	
	private WebDriverInstance() {}

	/**
	 * Add factory method wich will provide you browserType and configuration method to configure your browser window and timeouts
     */
	
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
