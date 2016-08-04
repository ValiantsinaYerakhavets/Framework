package framework.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertyProvider 
{
	private final static Logger LOG = LogManager.getLogger("eventLogger");
	
	public static String getProperty(String fileName, String property) 
	{
		Properties properties = loadProperties(fileName);
		String value = properties.getProperty(property);
		return value;
	}
	
	private static Properties loadProperties(String fileName) 
	{
		String path = ".\\src\\resources\\" + fileName + ".properties";
		File file = new File(path);
		Properties properties = new Properties();
		if (!file.isDirectory()) 
		{
			try(FileInputStream input = new FileInputStream(file.getAbsolutePath()))
			{
				properties.load(input);
			} 
			catch (IOException e) 
			{
				LOG.error("Exception while trying to load props from: " + path.toString());
			}
		}
		return properties;
	}
}
