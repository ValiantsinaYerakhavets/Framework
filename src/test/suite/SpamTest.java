package test.suite;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import framework.businessobjects.Message;
import framework.pages.InboxPage;
import test.BaseTest;

public class SpamTest extends BaseTest
{	
	 @Parameters("name")
	 @Test(enabled = true)
	  public void spamTest(String name)
	  {		 	
			InboxPage inboxPage = loginPage.logIn(user1);
			Message msg = new Message(user2.getEmail(), "test", "test");
			inboxPage.writeLetter().sendLetter(msg);
			loginPage = inboxPage.logOut();
	 
			inboxPage = loginPage.logIn(user2);
			inboxPage.reportSpam();
			boolean isPresent = inboxPage.spamFolder().checkSpam(msg);
			Assert.assertEquals(isPresent, true);
	  }
}
