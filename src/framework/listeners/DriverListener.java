package framework.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class DriverListener extends AbstractWebDriverEventListener {
	
	private final static Logger LOG = LogManager.getLogger("eventLogger");

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		LOG.debug("Navigated to " + url);
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		LOG.debug("Navigated back");
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		LOG.debug("Navigated forward");
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		LOG.debug("Navigated refresh");
	}
	
	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		if(element!=null) {
			LOG.debug("Found element located: " + this.getLocator(element));
		}
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		LOG.debug("Clicked element located " + this.getLocator(element));
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		LOG.debug("Changed value of located " + this.getLocator(element));
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		LOG.debug("Executed script: " + script);
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		LOG.debug("An exception has been throwed: " + throwable.getMessage());
	}
	
	private String getLocator(WebElement element) {
		int i = element.toString().indexOf("xpath");
		String str = element.toString().substring(i);
		return str.substring(0, str.length()-1);
	}
}
