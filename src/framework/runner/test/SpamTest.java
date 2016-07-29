package framework.runner.test;

import org.testng.annotations.Test;

import framework.exception.IllegalPageException;
import framework.ui.elements.LoginPage;

public class SpamTest extends BaseTest
{	
	 @Test
	  public void user1Test() throws IllegalPageException, InterruptedException 
	  {
		 	this.getToHomePage();
		 	LoginPage login = new LoginPage(driver);
			login.logIn(email1, password1);
			/*InboxPage inbox = new InboxPage(driver);
			inbox.writeLetter(email2, "test", "test");*/
	  }
	 /*
	  @Test(dependsOnMethods = "user1Test")
	  public void user2Test() throws InterruptedException, IllegalPageException 
	  {
		  	String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
		  	driver.findElement(By.linkText("urlLink")).sendKeys(selectLinkOpeninNewTab);
		  	
			this.getTo();
		  	LoginPage login = new LoginPage(driver);
			login.logIn(email2, password2);
			InboxPage inbox = new InboxPage(driver);
			inbox.reportSpam();
			
			boolean isPresent = inbox.checkSpam(email1, fullname1);
			Assert.assertEquals(isPresent, true);
	  }
	  */
}
