package framework.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import framework.driverManager.driverConfiguration.WebDriverInstance;
import framework.util.properties.ResourceEnum;
import framework.util.properties.ResourceManager;

public class BaseTest 
{
	protected WebDriver driver;
	protected ResourceManager bundle = ResourceManager.getInstance();;
	
	protected final String email1 = bundle.getValue(ResourceEnum.EMAIL1);
	protected final String email2 = bundle.getValue(ResourceEnum.EMAIL2);
	protected final String email3 = bundle.getValue(ResourceEnum.EMAIL3);
	
	protected final String password1 = bundle.getValue(ResourceEnum.PASSWORD1);
	protected final String password2 = bundle.getValue(ResourceEnum.PASSWORD2);
	protected final String password3 = bundle.getValue(ResourceEnum.PASSWORD3);
	
	protected final String fullname1 = bundle.getValue(ResourceEnum.FULLNAME1);
	
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
		driver.get(bundle.getValue(ResourceEnum.LOGIN));
	}
	
	public void getToSettingsPage()
	{
		driver.get(bundle.getValue(ResourceEnum.SETTINGS));
	}
}