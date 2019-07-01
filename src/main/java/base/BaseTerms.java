package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTerms extends PropertyFileReader{
		
	    public static WebDriver driver ;
	    
	    public static final String EXPECT_TITLE = "Guru99 Bank Manager HomePage";
	    public static final String EXPECT_ERROR = "User or Password is not valid";
	    
	    
	    public static void LaunchBrowser() {
	        System.setProperty("webdriver.chrome.driver", "E:\\software\\chromedriver_win32\\chromedriver.exe\\");
	        driver = new ChromeDriver();
	        driver.get(getPropertyValue("BaseUrl"));
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	        
	    }
	    public static WebDriver getDriver() {
	        return driver;
	    }
	    
	    
	    public static void type(WebElement element, String value) {
			  
			  element.sendKeys(value);
		  }
		  
		  public static void click(WebElement element) {
			  
			  element.click();
		  }
	
	
}
