package framework.main.drivermanager.driverconfiguration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

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
	
	/**
	 * Add factory method wich will provide you browserType and configuration method 
	 * to configure your browser window and timeouts
     */
	
	public static void setStartConf()
	{
		instance.manage().window().maximize();
		instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		instance.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	public static String getInfo()
	{
		Capabilities info = ((RemoteWebDriver) instance).getCapabilities();
		String browserName = info.getBrowserName();
		String browserVersion = info.getVersion();

		return browserName + " " + browserVersion;
	}
}
