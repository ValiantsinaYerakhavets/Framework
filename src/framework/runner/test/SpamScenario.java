package framework.runner.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.configuration.AccountParameter;
import framework.configuration.AccountResourceManager;
import framework.exception.IllegalPageException;
import framework.ui.elements.InboxPage;
import framework.ui.elements.LoginPage;

public class SpamScenario 
{
	String url = "https://mail.google.com";
	WebDriver driver;
	
	AccountResourceManager bundle = AccountResourceManager.getInstance();
	
	String email1 = bundle.getValue(AccountParameter.EMAIL1);
	String email2 = bundle.getValue(AccountParameter.EMAIL2);
	String password1 = bundle.getValue(AccountParameter.PASSWORD1);
	String password2 = bundle.getValue(AccountParameter.PASSWORD2);
	String fullname1 = bundle.getValue(AccountParameter.FULLNAME1);
	
	@BeforeTest
	public void prepareWebDriver()
	{
		 driver = new FirefoxDriver();
		 driver.get(url);
	}
	
	 @Test
	  public void user1Test() throws IllegalPageException, InterruptedException 
	  {
		 	LoginPage login = new LoginPage(driver);
			login.logIn(email1, password1);
			InboxPage inbox = new InboxPage(driver);
			inbox.writeLetter(email2, "test", "test");
	  }
	 
	  @Test(dependsOnMethods = "user1Test")
	  public void user2Test() throws InterruptedException, IllegalPageException 
	  {
		  	String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
		  	driver.findElement(By.linkText("urlLink")).sendKeys(selectLinkOpeninNewTab);
		  	
			driver.get(url);
		  	LoginPage login = new LoginPage(driver);
			login.logIn(email2, password2);
			InboxPage inbox = new InboxPage(driver);
			inbox.reportSpam();
			
			boolean isPresent = inbox.checkSpam(email1, fullname1);
			Assert.assertEquals(isPresent, true);
	  }
}
