package commons;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;
import io.netty.handler.timeout.TimeoutException;

public class CommonActions {
	
	WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(10));
	
	public void doClick(WebElement webElement) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
			webElement.click();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

}
