package framework.runner.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import framework.configuration.Account;
import framework.configuration.AccountResourceManager;
import framework.driverUtil.WebDriverInstance;

public class BaseTest 
{
	protected WebDriver driver;
	protected AccountResourceManager bundle = AccountResourceManager.getInstance();;
	
	protected final String email1 = bundle.getValue(Account.EMAIL1);
	protected final String email2 = bundle.getValue(Account.EMAIL2);
	protected final String password1 = bundle.getValue(Account.PASSWORD1);
	protected final String password2 = bundle.getValue(Account.PASSWORD2);
	protected final String fullname1 = bundle.getValue(Account.FULLNAME1);
	
	@BeforeClass
	public void setUp()
	{
		driver = WebDriverInstance.getInstance();
	}
	
	@AfterClass
	public void tearDown()
	{
		WebDriverInstance.closeDriver();
	}
	
	public void getToHomePage()
	{
		driver.get(bundle.getValue(Account.URL));
	}
}
