package framework.runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import framework.ui.elements.InboxPage;
import framework.ui.elements.LoginPage;
import framework.ui.elements.SettingsPage;

public class Start 
{
	private final static String url = "https://mail.google.com";
	
	public static void main(String[] args)
	{
		
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		try 
		{
			
			LoginPage login = new LoginPage(driver);
			login.logIn("user1testmailbox@gmail.com", "user1testmailbox1111");
			InboxPage inbox = new InboxPage(driver);
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
