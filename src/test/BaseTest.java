package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import framework.drivermanager.driverconfiguration.WebDriverInstance;
import framework.pages.BasePage;
import framework.pages.LoginPage;
import framework.properties.PropertyProvider;

public class BaseTest 
{
	protected WebDriver driver;
	
	protected BasePage basePage;
	protected LoginPage loginPage;
	
	protected final String EMAIL1 = PropertyProvider.getProperty("account", "email1");
	protected final String EMAIL2 = PropertyProvider.getProperty("account", "email2");
	protected final String EMAIL3 = PropertyProvider.getProperty("account", "email3");
	
	protected final String PASSWORD1 = PropertyProvider.getProperty("account", "password1");
	protected final String PASSWORD2 = PropertyProvider.getProperty("account", "password2");
	protected final String PASSWORD3 = PropertyProvider.getProperty("account", "password3");
	
	@BeforeClass
	public void setUp()
	{
		driver = WebDriverInstance.getInstance();
		WebDriverInstance.setStartConf();
	
		basePage = new BasePage(driver);
		loginPage = basePage.getToLoginPage();
	}
	
	@AfterClass
	public void tearDown()
	{
		WebDriverInstance.closeDriver();
		basePage = null;
		loginPage = null;
	}
}
