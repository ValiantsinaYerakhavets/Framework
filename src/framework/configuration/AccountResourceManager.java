package framework.configuration;

import java.util.ResourceBundle;

public class AccountResourceManager
{
	private static AccountResourceManager instance = null;
	
	private ResourceBundle bundle = ResourceBundle.getBundle("framework.configuration.accounts");
	
	public static AccountResourceManager getInstance()
	{
		if(instance==null)
		{
			instance = new AccountResourceManager();
		}
		return instance;
	}
	
	public String getValue(Account key)
	{
		return bundle.getString(key.toString().toLowerCase());
	}
}
