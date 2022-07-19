package testcases;


import org.testng.annotations.Test;

import utils.DP008;
import wrappers.GenericWrappers;

public class TC008 extends GenericWrappers {
	
	@Test(dataProvider="fetchdata",dataProviderClass=DP008.class)
	public void phpTravels(String firstname, String lastname, String email, String mobile, String company, String address, String addresss, String city, String state, String postal,
			String Country, String phone, String pass, String passw) {
		
		invokeApp("chrome", "https://www.phptravels.org/register.php");
		enterById("inputFirstName", firstname);
		enterById("inputLastName", lastname);
		enterById("inputEmail", email);
		enterById("inputPhone", mobile);
		enterById("inputCompanyName", company);
		enterById("inputAddress1", address);
		enterById("inputAddress2", addresss);
		enterById("inputCity", city);
		enterById("inputPostcode", postal);
		enterById("inputCountry", Country);
		selectVisibleTextById("stateselect", state);
		enterById("customfield2", phone);
		enterById("inputNewPassword1", pass);
		enterById("inputNewPassword2", passw);
		closeAllBrowsers();
		
		
	}
	
}


