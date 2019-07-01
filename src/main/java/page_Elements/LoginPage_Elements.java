package page_Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTerms;

public class LoginPage_Elements extends BaseTerms{
	
	public static WebElement UserName() {
		
		WebElement UserName = getDriver().findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
		return UserName;
	}
	
	public static WebElement Password() {
		
		WebElement Password = getDriver().findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
		return Password;
	}
	
	public static WebElement login() {
		
		WebElement login = getDriver().findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]"));
		return login;
	}
}
