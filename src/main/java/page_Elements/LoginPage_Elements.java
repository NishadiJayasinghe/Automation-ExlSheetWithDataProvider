package page_Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTerms;

public class LoginPage_Elements extends BaseTerms{
	
	public static WebElement UserName() {
		
		WebElement UserName = getDriver().findElement(By.xpath("//input[@name ='uid']"));
		return UserName;
	}
	
	public static WebElement Password() {
		
		WebElement Password = getDriver().findElement(By.xpath("//input[@name ='password']"));
		return Password;
	}
	
	public static WebElement login() {
		
		WebElement login = getDriver().findElement(By.xpath("//input[@name ='btnLogin']"));
		return login;
	}
}
