package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import framework.businessobjects.User;
import framework.drivermanager.driverconfiguration.WebDriverInstance;
import framework.pages.BasePage;
import framework.pages.LoginPage;
import framework.util.PropertyProvider;

public class BaseTest {
	
	protected WebDriver driver;
	
	protected BasePage basePage;
	protected LoginPage loginPage;
	
	protected User user1;
	protected User user2;
	protected User user3;
	
	@BeforeClass
	public void setUp() {
		driver = WebDriverInstance.getInstance(); 
		
		initUsers();
		
		basePage = new BasePage(driver);
		loginPage = basePage.getToLoginPage();
	}
	
	@AfterClass
	public void tearDown() {
		WebDriverInstance.closeDriver();
		basePage = null;
		loginPage = null;
	}
	
	private void initUsers() {
		String email = PropertyProvider.getProperty("account", "email1");
		String password = PropertyProvider.getProperty("account", "password1");
		user1 = new User(email, password);
		
		email = PropertyProvider.getProperty("account", "email2");
		password = PropertyProvider.getProperty("account", "password2");
		user2 = new User(email, password);
		
		email = PropertyProvider.getProperty("account", "email3");
		password = PropertyProvider.getProperty("account", "password3");
		user3 = new User(email, password);
	}
}
