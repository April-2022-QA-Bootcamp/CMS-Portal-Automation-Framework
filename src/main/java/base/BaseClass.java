package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadConfigFile;

public class BaseClass {
	public static WebDriver driver;
	
	@BeforeMethod
	public void setUp(String browser) {
		settingUpDriver(browser);
		ReadConfigFile.getInstance();
		driver.get(ReadConfigFile.getUrl()); // I will confirm you again
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ReadConfigFile.getPageLoadTime()));
		ReadConfigFile.getInstance();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ReadConfigFile.getImplicitlyWaitTime()));		
	}
		
	public WebDriver settingUpDriver(String driverName) { // return type parameterized method
		if(driverName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (driverName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver = new FirefoxDriver(); 
		} else if (driverName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
			driver = new EdgeDriver(); 
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}	
		return driver;
	}
	
	@AfterMethod
	public void tearUp() {
		driver.quit();
	}
	
	
	
	
	


}
