package test_Cases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.ExcelReader;
import page_Operations.LoginPage_Operations;

public class LoginPage_TestCase extends LoginPage_Operations{
	
	  @DataProvider(name = "guru99LoginDataProvider")
	  public Object[][] guru99LoginDataProvider() throws Exception {
	     
	      Object[][] arrayObject = ExcelReader.getExcelData("Resources/DataSheets/goruBankSiteLogin.xlsx", "Sheet1");
	      return arrayObject;
	  }
	
	
	
@Test(description = "login with correct credentials", dataProvider = "guru99LoginDataProvider")
public void TestProcedure(String UserName, String Password) throws Exception {
	
	  initiateWebdriver();
	  InputUserName(UserName);
	  InputPassword(Password);
	  ClickLogin();
	  veriifyLogin();
	  getDriver().close();
	  
}
}
