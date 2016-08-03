package framework.main.listeners;

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

import framework.main.drivermanager.driverconfiguration.WebDriverInstance;

public class MakingScreenshotListener extends TestListenerAdapter
{
	private final static Logger LOG = LogManager.getLogger("eventLogger");

	@Override
	//@Parameters("path")
	public void onTestFailure(ITestResult tr)
	{
		WebDriver driver = WebDriverInstance.getInstance();
		
		String screenshot = this.makeScreenshot(driver);

		LOG.info("Screenshot captured. Saved in " + screenshot);
	}
	
	public String makeScreenshot(WebDriver driver)
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = "C://Users//Valiantsina_Yerakhavets@epam.com//Tasks//Framework//screens//";
		String name = scrFile.getName();
		try 
		{
			FileUtils.copyFile(scrFile, new File(path + name));
		}
		catch (IOException e) 
		{
			LOG.error(e.getStackTrace());
		}
		return path;
	}
}
