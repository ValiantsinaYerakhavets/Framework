package framework.util;

import org.openqa.selenium.WebDriver;

public class Switcher {

	private static String homeHandle;
	
	public static void switchToOtherHandle(WebDriver driver) {
		homeHandle = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()) {
			if(!winHandle.equals(homeHandle)) {
				driver.switchTo().window(winHandle);
		    	break;
		    }
		}
	}
	
	public static void switchToHomeHandle(WebDriver driver) {
		driver.switchTo().window(homeHandle);
		homeHandle = null;
	}
	
}
