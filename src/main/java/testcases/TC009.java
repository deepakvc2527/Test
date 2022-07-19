package testcases;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import utils.DP009;
import wrappers.GenericWrappers;

public class TC009 extends GenericWrappers {
	
	@Test(dataProvider="fetchdata", dataProviderClass=DP009.class)
	public  void panIndia(String title, String fname, String mname, String lname, String ffname, String fmname, String flname, String mobile, String email, String income, 
			String dob, String add, String addr, String city, String pin, String state, String offname, String offadd, String offaddr, String offcity, String offstate, String offpin,
			String identity, String address, String dobb, String aadhar, String offaddrproof) {
		
		invokeApp("chrome", "https://www.panind.com/india/new_pan/");
		enterById("pan_title", title);
		enterById("pan_firstname", fname);
		enterById("pan_middlename", mname);
		enterById("pan_lastname", lname);
		enterById("pan_fatherfirstname", ffname);
		enterById("pan_fathermiddlename", fmname);
		enterById("pan_fatherlastname", flname);
		enterById("pan_mobilenumber", mobile);
		enterById("pan_email", email);
		enterById("pan_sourceofincome", income);
		clickById("office");
		enterById("pan_dob", dob);
		enterByName("pan_addressline1", add);
		enterByName("pan_addressline2", addr);
		enterByName("pan_cityname", city);
		enterByXpathKeys("//html/body", Keys.PAGE_DOWN);
		enterById("pan_pincode", pin);
		enterById("pan_state", state);
		enterById("pan_officename", offname);
		enterById("pan_officeaddressline1", offadd);
		enterById("pan_officeaddressline2", offaddr);
		enterById("pan_officecityname", offcity);
		enterById("pan_officestate", offstate);
		enterById("pan_officepincode", offpin);
		selectVisibleTextById("pan_identityproof", identity);
		selectVisibleTextById("pan_addressproof", address);
		selectVisibleTextById("pan_DOBproof", dobb);
		selectVisibleTextById("pan_aadhaarproof", aadhar);
		selectVisibleTextById("pan_officeaddressproof", offaddrproof);
		enterByXpathKeys("//html/body", Keys.PAGE_DOWN);
		clickById("pan_source");
		closeBrowser();
		
	}

}
