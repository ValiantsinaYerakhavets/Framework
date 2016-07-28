package framework.ui.elements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.exception.IllegalPageException;

public class LoginPage 
{
	private final WebDriver webDriver;
	
	private final String title = "Gmail";
	
	By emailInput = By.xpath("//input[@id = 'Email']");
	By nextButton = By.xpath("//input[@id = 'next']");
	By passwordInput = By.xpath("//input[@name = 'Passwd']");
	By signInButton = By.xpath("//input[@id = 'signIn']");
	
	public LoginPage(WebDriver webDriver) throws IllegalPageException
	{
		this.webDriver = webDriver;

		if(!webDriver.getTitle().equals(title))
		{
			throw new IllegalPageException("It's Not GmailLoginPage!");
		}
	}
	
	public void logIn(String login, String password) throws InterruptedException
	{
		this.setLogin(login);
		webDriver.findElement(nextButton).click();
		
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		this.setPassword(password);
		webDriver.findElement(signInButton).click();
	}
	
	private void setLogin(String email)
	{
		webDriver.findElement(emailInput).sendKeys(email);
	}
	
	private void setPassword(String password)
	{
		webDriver.findElement(passwordInput).sendKeys(password);
	}
}
