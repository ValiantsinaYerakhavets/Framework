package framework.runner.test;

import org.testng.annotations.Test;

import framework.ui.elements.InboxPage;
import framework.ui.elements.LoginPage;
import framework.ui.elements.SettingsPage;

public class ForwardTest extends BaseTest
{
	@Test
	public void setForwUser2() 
	{
		this.getToLoginPage();
		LoginPage login = new LoginPage(driver);
		login.logIn(email2, password2);

		this.getToSettingsPage();
		SettingsPage setPage = new SettingsPage(driver);
		setPage.setForwardToUser(email3);
		setPage.logOut();
		setPage.chooseAccount();
	}
	
	@Test(dependsOnMethods = "setForwUser2")
	public void confirmForwUser3() 
	{
		LoginPage login = new LoginPage(driver);
		InboxPage inbox = login.logIn(email3, password3);

		inbox.confirmForwarding("Gmail Team");
		inbox.logOut();
	}
	
	@Test(dependsOnMethods = "confirmForwUser3")
	public void createFilterUser2() 
	{
		LoginPage login = new LoginPage(driver);
		InboxPage inbox = login.logIn(email2, password2);

		this.getToSettingsPage();
		SettingsPage setPage = new SettingsPage(driver);
		setPage.chooseCopyOfIncoming();
		setPage.createNewFilter(email1);
		
		inbox.logOut();
	}
}
