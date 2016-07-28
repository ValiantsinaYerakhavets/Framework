package framework.configuration;

import java.util.ResourceBundle;

public class AccountResourceManager
{
	private final static AccountResourceManager instance = new AccountResourceManager();
	
	private ResourceBundle bundle = ResourceBundle.getBundle("framework.configuration.accounts");
	
	public static AccountResourceManager getInstance()
	{
		return instance;
	}
	
	public String getValue(String key)
	{
		return bundle.getString(key);
	}
}
