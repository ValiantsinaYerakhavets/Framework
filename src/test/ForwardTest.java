package test;

import org.testng.annotations.Test;

import framework.pages.InboxPage;
import framework.pages.SettingsPage;

public class ForwardTest extends BaseTest
{
	@Test(enabled = false, description = "Not finished yet")
	public void setForwUser2() 
	{
		InboxPage inboxPage = loginPage.logIn(EMAIL2, PASSWORD2);

		SettingsPage setPage = inboxPage.settingsPage();
		setPage.setForwardToUser(EMAIL3);
		
		loginPage = setPage.logOut();
	}

	@Test(dependsOnMethods = "setForwUser2")
	public void confirmForwUser3() 
	{
		InboxPage inboxPage = loginPage.logIn(EMAIL3, PASSWORD3);

		inboxPage.confirmForwarding("Gmail Team");
		loginPage = inboxPage.logOut();
	}
	
	@Test(dependsOnMethods = "confirmForwUser3")
	public void createFilterUser2() 
	{
		InboxPage inboxPage = loginPage.logIn(EMAIL2, PASSWORD2);

		SettingsPage setPage = inboxPage.settingsPage();
		setPage.chooseCopyOfIncoming();
		setPage.createNewFilter(EMAIL1);
		
		loginPage = inboxPage.logOut();
	}
	
	@Test(dependsOnMethods = "createFilterUser2")
	public void sendLettersUser1() 
	{
		InboxPage inboxPage = loginPage.logIn(EMAIL1, PASSWORD1);

		inboxPage.writeLetter().sendLetter(EMAIL2, "test", "without att", false);
		inboxPage.writeLetter().sendLetter(EMAIL2, "test", "with att", true);
	}
}
