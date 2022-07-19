package testcases;


import org.testng.annotations.Test;

import utils.DP006;
import wrappers.GenericWrappers;

public class TC006 extends GenericWrappers {
	
	@Test(dataProvider="fetchdata", dataProviderClass=DP006.class)
	public void formCAndT(String userId,String password,String retypePwd,String secques,String secAns,String name,String gender,String dob,String designation,String email,
			String mobno,String	phone,String natn,String hname,String capacity,String address,String state, String city, String acctype, String accgrd,String hemail,String mcontact,String contact,
			String oname,String	oaddr,String ostate, String ocity,String oemail,String ophone,String omobno) {
		
		invokeApp("chrome", "https://indianfrro.gov.in/frro/FormC/menuuserreg.jsp");
		clickByLinkNoSnap("Sign Up (Registration)");
		enterById("u_id", userId);
		enterById("u_pwd", password);
		enterById("u_repwd", retypePwd);
		selectValueByName("u_secques", secques);
		enterById("u_secans", secAns);
		enterById("u_name", name);
		selectValueById("u_gender", gender);
		enterById("u_dob",dob);
		enterById("u_designation", designation);
		enterById("u_emailid", email);
		enterById("u_mobile", mobno);
		enterById("u_phone", phone);
		selectValueById("u_nationality", natn);
		enterById("name", hname);
		enterById("capacity", capacity);
		enterById("address", address);
		selectValueById("state", state);
		waitProperty(3000);
		selectValueById("city_distr", city);
		selectValueById("acco_type", acctype);
		waitProperty(3000);
		selectValueById("star_rat", accgrd);
		enterById("email", hemail);
		enterById("mcontact", mcontact);
		enterById("contact", contact);
		enterByName("name_o", oname);
		enterByName("address_o", oaddr);
		selectValueById("state_o", ostate);
		waitProperty(3000);
		selectValueById("citydistr_o", ocity);
		enterByName("emailid_o", oemail);
		enterByName("phoneno_o", ophone);
		enterByName("mobile_o", omobno);
		clickByName("add");
		enterByName("name_o", oname);
		enterByName("address_o", address);
		selectValueById("state_o", ostate);
		waitProperty(3000);
		selectValueById("citydistr_o", ocity);
		enterByName("emailid_o", oemail);
		enterByName("phoneno_o", ophone);
		enterByName("mobile_o", omobno);
		clickByName("add");
		enterByName("name_o", oname);
		enterByName("address_o", address);
		selectValueById("state_o", ostate);
		waitProperty(3000);
		selectValueById("citydistr_o", ocity);
		enterByName("emailid_o", oemail);
		enterByName("phoneno_o", ophone);
		enterByName("mobile_o", omobno);
		clickByName("add");
		closeAllBrowsers();
	}
}
