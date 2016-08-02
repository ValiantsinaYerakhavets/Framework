package framework.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.util.page.InboxPage;
import framework.util.page.LoginPage;
import framework.util.page.SendLetterPage;
import framework.util.page.SpamPage;

public class SpamTest extends BaseTest
{	
	 @Test(enabled = false)
	  public void user1Test() throws InterruptedException 
	  {
		 	this.getToLoginPage();
		 	
		 	LoginPage login = new LoginPage(driver);
			login.logIn(email1, password1);
			
			InboxPage inbox = new InboxPage(driver);
			SendLetterPage sendPage = inbox.goToSendLetter();
			sendPage.sendLetter(email2, "test", "test");
			
			sendPage.logOut();
	  }
	 
	  @Test(dependsOnMethods = "user1Test")
	  public void user2Test() throws InterruptedException
	  {
		  	LoginPage login = new LoginPage(driver);
			login.logIn(email2, password2);
			
			InboxPage inbox = new InboxPage(driver);
			inbox.reportSpam();
			
			SpamPage spamPage = inbox.goToSpam();
			boolean isPresent = spamPage.checkSpam(email1, fullname1);
			Assert.assertEquals(isPresent, true);
	  }
	  
}
