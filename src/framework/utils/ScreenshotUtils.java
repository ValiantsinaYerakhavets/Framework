package framework.utils;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils 
{
	private final static Logger LOG = LogManager.getLogger("eventLogger");
	
	public static String makeScreenshot(WebDriver driver)
	{
		ResourceBundle bundle = ResourceBundle.getBundle("framework.utils.path");
		String path = bundle.getString("path");
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileUtils.copyFile(scrFile, new File(path));
		}
		catch (IOException e) 
		{
			LOG.error(e.getStackTrace());
		}
		return path;
	}
}
