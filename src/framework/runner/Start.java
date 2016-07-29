package framework.runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import framework.exception.IllegalPageException;
import framework.ui.elements.InboxPage;
import framework.ui.elements.LoginPage;

public class Start 
{
	private final static String url = "https://mail.google.com";
	
	public static void main(String[] args)
	{
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		try 
		{
			/*
			LoginPage login = new LoginPage(driver);
			login.logIn("user1testmailbox@gmail.com", "user1testmailbox1111");
			InboxPage inbox = new InboxPage(driver);
			inbox.writeLetter("user2testmailbox@gmail.com", "test", "test");
			
			
			LoginPage login = new LoginPage(driver);
			login.logIn("user2testmailbox@gmail.com", "user2testmailbox2222");
			InboxPage inbox = new InboxPage(driver);
			inbox.reportSpam();
			inbox.checkSpam("user1testmailbox@gmail.com", "Name1 Surname1");
			*/
			
		} 
		catch (IllegalPageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.close();
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
