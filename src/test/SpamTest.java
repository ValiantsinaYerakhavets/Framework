package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.main.pages.InboxPage;
import framework.main.pages.LoginPage;
import framework.main.pages.SpamPage;

public class SpamTest extends BaseTest
{	
	 @Test(enabled = true)
	  public void user1Test() throws InterruptedException 
	  {
		 	this.getToLoginPage();
		 	
		 	LoginPage login = new LoginPage(driver);
			login.logIn(email1, password1);
			
			InboxPage inbox = new InboxPage(driver);
			inbox.writeLetter().sendLetter(email2, "test", "test", false);
			
			inbox.logOut();
	  }
	 
	  @Test(dependsOnMethods = "user1Test")
	  public void user2Test() throws InterruptedException
	  {
		  	LoginPage login = new LoginPage(driver);
			login.logIn(email2, password2);
			
			InboxPage inbox = new InboxPage(driver);
			inbox.reportSpam();
			
			SpamPage spamPage = inbox.spamFolder();
			boolean isPresent = spamPage.checkSpam(email1, fullname1);
			Assert.assertEquals(isPresent, true);
	  }
}
