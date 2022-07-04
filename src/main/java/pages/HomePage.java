package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	WebDriver driver;
	
	// 1st way: most common way to write, you must know how to do that
	@FindBy(xpath = "//em[@id='cms-homepage-header-logo-unauth' and @class='cms-icon cms-sprite-loggedout ms-3']")
	public static WebElement logo; // Why they used the static keyword? 
	
	// 2nd way: not common, here forgotUserId
	By forgotUserId = By.id("cms-forgot-userid");
	
	// 3rd way: tough, you need to recognize if used in your office, no need to use this in your framework
	@FindBy(how = How.XPATH, using = "//a[text()='Password']")
	public WebElement forgotPassword;
	
	@FindBy(how = How.XPATH, using = "//button[@id='cms-login-submit']")
	public WebElement loginButton;
	
	// most common way
	public boolean verifyLogo() {
		boolean flag = logo.isDisplayed(); // logo webElement used here
		System.out.println("Logo is dispayed: " + flag);
		return flag;
	}
	
	public void clickForgotUserId() {
		driver.findElement(forgotUserId).click(); // forgotUserId webElement used here
	}
	
	public boolean verifyLoginButton() {
		boolean loginBtn = loginButton.isEnabled() ; // loginButton webElement used here
		System.out.println("Login Button is enabled: " + loginBtn);
		return loginBtn;
	}
	
	
	
	
	
	

}
