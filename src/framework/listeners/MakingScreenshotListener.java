package framework.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import framework.driverManager.driverConfiguration.WebDriverInstance;
import framework.util.screenshot.ScreenshotUtils;

public class MakingScreenshotListener extends TestListenerAdapter
{
	private final static Logger LOG = LogManager.getLogger("eventLogger");

	/**
	 * Why you separated screenShot method and this?
	 * What the purpose?
	 * @param testResult
     */
	public void onTestFailure(ITestResult testResult)
	{
		WebDriver driver = WebDriverInstance.getInstance();
		
		String screenshot = ScreenshotUtils.makeScreenshot(driver);

		String msg = "Screenshot captured. Saved in " + screenshot;
		LOG.info(msg);
		LOG.info("Screenshot captured. Saved in " + screenshot); // you could do smth like this
	}
}
