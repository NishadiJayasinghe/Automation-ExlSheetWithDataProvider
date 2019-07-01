package page_Operations;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import page_Elements.LoginPage_Elements;

public class LoginPage_Operations extends LoginPage_Elements{

		public static void initiateWebdriver() throws Exception {
	   
	        LaunchBrowser();
	    }
	    
		
	    public static void InputUserName(String UserName) throws Exception {
	      
	        type(LoginPage_Elements.UserName(), UserName);
	        
	    }
	    
		
	    public static void InputPassword(String Password) throws Exception {
	    	
	        type(LoginPage_Elements.Password(), Password);
	        
	    }
	    
		
	    public static void ClickLogin() {
			click(LoginPage_Elements.login());
	      
	    }
	    
		
		 public static void veriifyLogin () {
		 try{
		        
		      Alert alt = getDriver().switchTo().alert();
		        String actualBoxtitle = alt.getText();
		        alt.accept();
		        if (actualBoxtitle.contains(EXPECT_ERROR)) { 
		            System.out.println("Test case : Passed got expected error alert");
		        } else {
		            System.out.println("Test case : Failed didn't get expected error alert");
		        }
		    }
		catch (NoAlertPresentException Ex){
		    String actualTitle = getDriver().getTitle();

		        if (actualTitle.contains(EXPECT_TITLE)) {
		            System.out.println("Test case : Passed, navigated to the correct page");
		        } else {
		            System.out.println("Test case : Failed, didn't get the expected title");
		        }
		}     
		}

}
