package test.suite;

import org.testng.annotations.Test;

import framework.businessobjects.Message;
import framework.pages.InboxPage;
import framework.pages.SettingsPage;
import test.BaseTest;

public class ForwardTest extends BaseTest
{
	@Test(description = "Not finished yet")
	public void setForwUser2() 
	{
		InboxPage inboxPage = loginPage.logIn(user2);

		SettingsPage setPage = inboxPage.settingsPage();
		setPage.setForwardToUser(user3);
		loginPage = setPage.logOut();
	}

	@Test(dependsOnMethods = "setForwUser2")
	public void confirmForwUser3() 
	{
		InboxPage inboxPage = loginPage.logIn(user3);

		inboxPage.confirmForwarding(new Message("forwarding-noreply@google.com"));
		loginPage = inboxPage.logOut();
	}
	
	@Test(dependsOnMethods = "confirmForwUser3")
	public void createFilterUser2() 
	{
		InboxPage inboxPage = loginPage.logIn(user2);

		SettingsPage setPage = inboxPage.settingsPage();
		setPage.chooseCopyOfIncoming();
		setPage.createNewFilter(user1);
		
		loginPage = inboxPage.logOut();
	}
	
	@Test(dependsOnMethods = "createFilterUser2")
	public void sendLettersUser1() 
	{
		InboxPage inboxPage = loginPage.logIn(user1);

		Message msg = new Message(user2.getEmail(), "test", "without att");
		inboxPage.writeLetter().sendLetter(msg);
		
		//msg.setPath(path);
		inboxPage.writeLetter().sendLetter(msg);
	}
}
