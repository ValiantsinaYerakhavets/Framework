package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import framework.main.pages.InboxPage;
import framework.main.pages.LoginPage;
import framework.main.pages.SettingsPage;

public class ForwardTest extends BaseTest
{
	@Parameters({"settings"})
	@Test
	public void setForwUser2(String settings) 
	{
		this.getToLoginPage();
		LoginPage login = new LoginPage(driver);
		InboxPage inboxPage = login.logIn(email2, password2);

		SettingsPage setPage = inboxPage.settingsPage(settings);
		setPage.setForwardToUser(email3);
		
		setPage.logOut();
	}
	
	@Test(dependsOnMethods = "setForwUser2")
	public void confirmForwUser3() 
	{
		LoginPage login = new LoginPage(driver);
		InboxPage inbox = login.logIn(email3, password3);

		inbox.confirmForwarding("Gmail Team");
		inbox.logOut();
	}
	
	@Parameters({"settings"})
	@Test(dependsOnMethods = "confirmForwUser3")
	public void createFilterUser2(String settings) 
	{
		LoginPage login = new LoginPage(driver);
		InboxPage inbox = login.logIn(email2, password2);

		SettingsPage setPage = inbox.settingsPage(settings);
		setPage.chooseCopyOfIncoming();
		setPage.createNewFilter(email1);
		
		inbox.logOut();
	}
	
	@Test(dependsOnMethods = "createFilterUser2")
	public void sendLettersUser1() 
	{
		this.getToLoginPage();
		LoginPage login = new LoginPage(driver);
		InboxPage inbox = login.logIn(email1, password1);

		inbox.writeLetter().sendLetter(email2, "test", "without att", false);
		inbox.writeLetter().sendLetter(email2, "test", "with att", true);
		
		inbox.logOut();
	}
}
