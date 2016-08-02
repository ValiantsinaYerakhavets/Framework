package framework.runner.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import framework.configuration.Account;
import framework.configuration.ResourceManager;
import framework.configuration.Url;
import framework.driver.WebDriverInstance;
import framework.ui.elements.LoginPage;
import framework.ui.elements.SettingsPage;

public class BaseTest 
{
	protected WebDriver driver;
	protected ResourceManager bundle = ResourceManager.getInstance();;
	
	protected final String email1 = bundle.getValue(Account.EMAIL1);
	protected final String email2 = bundle.getValue(Account.EMAIL2);
	protected final String email3 = bundle.getValue(Account.EMAIL3);
	
	protected final String password1 = bundle.getValue(Account.PASSWORD1);
	protected final String password2 = bundle.getValue(Account.PASSWORD2);
	protected final String password3 = bundle.getValue(Account.PASSWORD3);
	
	protected final String fullname1 = bundle.getValue(Account.FULLNAME1);
	
	@BeforeClass
	public void setUp()
	{
		driver = WebDriverInstance.getInstance();
	}
	
	@AfterClass
	public void tearDown()
	{
		//WebDriverInstance.closeDriver();
	}
	
	public void getToLoginPage()
	{
		driver.get(bundle.getValue(Url.LOGIN));
	}
	
	public void getToSettingsPage()
	{
		driver.get(bundle.getValue(Url.SETTINGS));
	}
}
