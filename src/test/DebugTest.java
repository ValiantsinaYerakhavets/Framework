package test;

import org.testng.annotations.Test;

import framework.pages.InboxPage;
import framework.pages.SettingsPage;

public class DebugTest extends BaseTest
{
	
	@Test(description = "to check working ability of the framework")
	public void debugTest() {
		InboxPage inboxPage = loginPage.logIn(user2);
		SettingsPage setPage = inboxPage.settingsPage();
		loginPage = setPage.logOut();
	}
	
}