package framework.drivermanager.driverconfiguration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverInstance 
{
	private static WebDriver instance = null;
	
	private WebDriverInstance() {}

	public static WebDriver getInstance()
	{
		if(instance == null)
		{
			String browser = System.getProperty("browser");
			BrowserType type;
			try
			{
				type = BrowserType.valueOf(browser.toUpperCase());
			}
			catch(Exception e)
			{
				type = BrowserType.FIREFOX;
			}
			
			init(type);
		}
		return instance;
	}
	
	private static void init(BrowserType type)
	{
		switch(type)
		{
		case CHROME:
			instance = new ChromeDriver();
			break;
		case IE:
			instance = new InternetExplorerDriver();
			break;
		case FIREFOX:
			instance = new FirefoxDriver();
			break;
		}
	}
	
	public static void closeDriver()
	{
		instance.close();
		instance.quit();
		instance = null;
	}
	
	public static void setStartConf()
	{
		instance.manage().window().maximize();
		instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		instance.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	// bullshit
	
	public static String getInfo()
	{
		Capabilities info = ((RemoteWebDriver) instance).getCapabilities();
		String browserName = info.getBrowserName();
		String browserVersion = info.getVersion();

		return browserName + " " + browserVersion;
	}
}
