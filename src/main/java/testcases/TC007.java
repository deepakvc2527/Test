package testcases;

import org.testng.annotations.Test;

import utils.DP007;
import wrappers.GenericWrappers;

public class TC007 extends GenericWrappers {
	
	@Test(dataProvider="fetchData",dataProviderClass=DP007.class)
	public void facebookLogin(String firstName, String lastName, String email, String confrimEmail, String password
			,String day, String month, String year, String gender ) {
		
		invokeApp("chrome", "http://www.facebook.com");
		clickByLink("Create New Account");
		waitProperty(5000);
		enterByName("firstname", firstName);
		enterByName("lastname", lastName);
		enterByName("reg_email__", email);
		enterByName("reg_email_confirmation__", confrimEmail);
		enterById("password_step_input", password);
		selectValueById("day", day);
		selectValueById("month", month);
		selectValueById("year", year);
		clickByXpath("(//*[@name='sex'])[2]");
		closeBrowser();
		
	}

}
