package framework.ui.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends InboxPage
{
	@FindBy(xpath = "//a[text() = 'Forwarding and POP/IMAP']")
	private WebElement forwButton;
	
	@FindBy(xpath = "//input[@value = 'Add a forwarding address']")
	private WebElement addForwButton;
	
	@FindBy(xpath = "//div[contains(text(), 'Please enter')]/input[@type = 'text']")
	private WebElement addForwInput;
	
	@FindBy(xpath = "//button[@name = 'next']")
	private WebElement nextButton;
	
	@FindBy(xpath = "//tbody/tr[td/label/span[text()='all mail']]/td/input[@type='radio']")
	private WebElement allMailRadioButton;
	
	@FindBy(xpath = "//input[@value = 'Proceed']")
	private WebElement proceedButton;
	
	public SettingsPage(WebDriver webDriver) 
	{
		super(webDriver);
	}

	public void setForwardToUser()
	{
		
	}
}
