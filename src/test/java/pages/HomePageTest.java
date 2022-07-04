package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseClass;

public class HomePageTest {
	HomePage homePage;
	BaseClass baseClass;
	WebDriver driver;
	Properties properties;
	
	@BeforeMethod
	
	public void setUpHomePage() {
		baseClass = new BaseClass();
		baseClass.setUp("chrome");
		homePage = PageFactory.initElements(driver, HomePage.class); // very very important interview que
	}
	
	@Test (enabled = true, priority = 1)
	public void logoTest(){
		Assert.assertTrue(homePage.verifyLogo(), "Application Logo is not displayed ...");
	}
/*	
	@Test(enabled = true, priority = 2)
	public void titleTest() {
		String expected = "CMS Enterprise Portal";
		String actual = driver.getTitle();
		System.out.println("The title of the Home Page is: " + actual );
		Assert.assertEquals(actual,  expected, "Home Page Title doesn't match ....");
	}
	
	@Test(enabled = true, priority = 3)
	public void userIdTest() {
		homePage.clickForgotUserId();
		System.out.println("The current url is: "+driver.getCurrentUrl());
		boolean Header =  driver.findElement(By.xpath("//h1[text()='Forgot User ID']")).isDisplayed();
		Assert.assertTrue(Header, "Forgot User Id is not displayed ...");
	}
	
	@Test(enabled = true, priority = 4)
	public void loginButtonTest() {
		SoftAssert softAssert = new SoftAssert();
		homePage.verifyLoginButton();
		softAssert.assertTrue(true);
		softAssert.assertAll();
	}
*/	
	@AfterMethod
	public void tearUp() {
		driver.quit();
	}
	
	
	
	
	
	
	

}
