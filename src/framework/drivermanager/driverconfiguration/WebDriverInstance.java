package framework.drivermanager.driverconfiguration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import framework.listeners.DriverListener;

public class WebDriverInstance {
	
	private static WebDriver instance = null;
	
	private WebDriverInstance() { }

	public static WebDriver getInstance() {
		if(instance == null) {
			String browser = System.getProperty("browser");
			BrowserType type;
			
			try {
				type = BrowserType.valueOf(browser.toUpperCase());
			} catch(Exception e) {
				type = BrowserType.FIREFOX;
			}
			
			init(type);
			
			setStartConf();
			setEventListener();
		}
		return instance;
	}
	
	private static void init(BrowserType type) {
		switch(type) {
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
	
	public static void closeDriver() {
		instance.close();
		instance.quit();
		instance = null;
	}
	
	public static void setStartConf() {
		instance.manage().window().maximize();
		instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		instance.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	public static void setEventListener() {
		EventFiringWebDriver driver = new EventFiringWebDriver(instance);
        DriverListener driverListener = new DriverListener();
        driver.register(driverListener);
        instance = driver;
	}

}
