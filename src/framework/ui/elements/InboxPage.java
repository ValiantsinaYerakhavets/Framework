package framework.ui.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.exception.IllegalPageException;

public class InboxPage 
{
	private final WebDriver webDriver;
	private final String title;
	
	private By writeLetterButton = By.xpath("//div[contains(text(), 'НАПИСАТЬ')]");
	
	private By toWhomInput = By.xpath("//textarea[@name = 'to']");
	private By subjectInput = By.xpath("//input[@name = 'subjectbox']");
	private By messageInput = By.xpath("//div[@role = 'textbox']");
	private By sendLetterButton = By.xpath("//div[contains(text(), 'Отправить')]");
	
	private By selectLetterBox = By.xpath("//span[@role = 'checkbox']/div[@role='presentation']");
	private By reportSpamButton = By.xpath("//div[@aria-label = 'Report spam' or @aria-label = 'В спам!']");
	private By deleteButton = By.xpath("//div[@aria-label = 'Удалить']");
	
	private By searchInput = By.xpath("//input[@aria-label='Поиск']");
	private By searchButton =  By.xpath("//button[@aria-label='Поиск Gmail']");
	
	private By accountsButton = By.xpath("//a[contains(@title, 'Аккаунт Google')]");
	private By exitButton = By.xpath("//a[text() = 'Выйти']");
	
	private final String spamLetterXPathStart = "//span[@email='";
	private final String spamLetterXPathEnd = "']";
	
	public InboxPage(WebDriver webDriver) throws IllegalPageException
	{
		this.webDriver = webDriver;
		this.title = "@gmail.com - Gmail";
		
		System.out.println(webDriver.getTitle());
		if(!webDriver.getTitle().contains(title))
		{
			throw new IllegalPageException("It's Not InboxPage!");
		}
	}
	
	public void writeLetter(String toWhom, String subject, String message)
	{
		webDriver.findElement(writeLetterButton).click();
				
		webDriver.findElement(toWhomInput).sendKeys(toWhom);
		webDriver.findElement(subjectInput).sendKeys(subject);
		webDriver.findElement(messageInput).sendKeys(message);
		
		webDriver.findElement(sendLetterButton).click();
	}
	
	public void reportSpam()
	{
		webDriver.findElement(selectLetterBox).click();
		webDriver.findElement(reportSpamButton).click();
	}
	
	public boolean checkSpam(String email, String nameAndSurname)
	{
		webDriver.findElement(searchInput).sendKeys("in:spam");
		webDriver.findElement(searchButton).click();
		
		List<WebElement> elems = webDriver.findElements(By.xpath(spamLetterXPathStart + email
				+ "' and @name = '" +
				nameAndSurname + spamLetterXPathEnd));
		return (elems.size()!=0);
	}
	
	public void logOut()
	{
		webDriver.findElement(accountsButton).click();
		webDriver.findElement(exitButton).click();
	}
	
	public void clearInbox()
	{
		webDriver.findElement(selectLetterBox).click();
		webDriver.findElement(deleteButton).click();
	}
	
	
	/*
	By moreButton = By.xpath("//span[@role='button']/span[text()='More']");
	By spamButton = By.xpath("//a[contains(text(), 'Spam')]");
	By unreadListItem = By.xpath("//div[@role = 'menuitem'][@selector = 'unread']");
	*/
}
