package test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import framework.pages.InboxPage;
import framework.pages.SpamPage;

public class SpamTest extends BaseTest
{	
	 @Test(enabled = true)
	  public void user1Test() throws InterruptedException 
	  {
			InboxPage inboxPage = loginPage.logIn(EMAIL1, PASSWORD1);
			inboxPage.writeLetter().sendLetter(EMAIL2, "test", "test", false);
			
			loginPage = inboxPage.logOut();
	  }
	 
	 @Parameters("name")
	  @Test(dependsOnMethods = "user1Test")
	  public void user2Test(String name) throws InterruptedException
	  {
			InboxPage inboxPage = loginPage.logIn(EMAIL2, PASSWORD2);
			inboxPage.reportSpam();
			
			SpamPage spamPage = inboxPage.spamFolder();
			boolean isPresent = spamPage.checkSpam(EMAIL1, name);
			Assert.assertEquals(isPresent, true);
	  }
}
