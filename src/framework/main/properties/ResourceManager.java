package framework.main.properties;

import java.util.ResourceBundle;

public class ResourceManager
{
	private static ResourceManager instance = null;
	
	private ResourceBundle bundle = ResourceBundle.getBundle("framework.resources.account");
	
	public static ResourceManager getInstance()
	{
		if(instance==null)
		{
			instance = new ResourceManager();
		}
		return instance;
	}
	
	public String getValue(ResourceEnum key)
	{
		return bundle.getString(key.toString().toLowerCase());
	}
}
