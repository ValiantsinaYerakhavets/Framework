package framework.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import framework.drivermanager.driverconfiguration.WebDriverInstance;

public class ScreenshotListener extends TestListenerAdapter
{
	private final static Logger LOG = LogManager.getLogger("eventLogger");

	@Override
	public void onTestFailure(ITestResult tr)
	{
		WebDriver driver = WebDriverInstance.getInstance();
		
		this.makeScreenshot(driver);

		LOG.info("Screenshot captured");
	}
	
	public void makeScreenshot(WebDriver driver)
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = ".//screens//";
		String name = scrFile.getName();
		try 
		{
			FileUtils.copyFile(scrFile, new File(path + name));
		}
		catch (IOException e) 
		{
			LOG.error(e.getStackTrace());
		}
	}
}
