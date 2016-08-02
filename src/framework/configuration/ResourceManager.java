package framework.configuration;

import java.util.ResourceBundle;

public class ResourceManager
{
	private static ResourceManager instance = null;
	
	private ResourceBundle bundle = ResourceBundle.getBundle("framework.configuration.prop");
	
	public static ResourceManager getInstance()
	{
		if(instance==null)
		{
			instance = new ResourceManager();
		}
		return instance;
	}
	
	public String getValue(Account key)
	{
		return bundle.getString(key.toString().toLowerCase());
	}
	
	public String getValue(Url key)
	{
		return bundle.getString(key.toString().toLowerCase());
	}
}
