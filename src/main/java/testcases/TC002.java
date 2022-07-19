package testcases;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import utils.DP002;
import wrappers.GenericWrappers;

public class TC002 extends GenericWrappers{

	@Test(dataProvider="fetchData",dataProviderClass=DP002.class)
	public void irctcBookUrCoach(String userId,String password,String confrmPassword,String secques, String	secAns, String month, String year, String email,String occ, String firstName,
			String middleName,String lastName,String natn,String flatNo,String street,String area, String country,
			String mobno,String pincode,String city,String state,String po,String resFlatno,String resStreet,String resArea,String offcountry,String rMobno,String	rPincode,String cityoff,String stateoff,String offpo) {
		
		invokeApp("chrome", "https://www.irctc.co.in/nget/train-search");
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div/div[2]/div/form/div[2]/button");
		clickByLink("HOLIDAYS");
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[2]/nav/ul/li[7]/ul/li[3]/a");
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[2]/nav/ul/li[7]/ul/li[3]/ul/li[2]/a");
		switchToLastWindow();
		clickById("sidebarCollapse");
		clickByLink("Book Your Coach/Train");
		switchToLastWindow();
		clickByLink("New User? Signup");
		enterById("userId", userId);
		enterById("password", password);
		enterById("cnfPassword", confrmPassword);
		selectVisibleTextByXpath("//*[@id=\"secQstn\"]",secques);
		enterById("secAnswer", secAns);
		clickById("dateOfBirth");
		selectValueByClassName("ui-datepicker-month", month);
		selectValueByClassName("ui-datepicker-year", year);
		clickByLink("25");
		clickById("gender0");
		clickById("maritalStatus0");
		enterById("email", email);
		selectValueById("occupation", occ);
		enterById("fname", firstName);
		enterById("mname", middleName);
		enterById("lname", lastName);
		selectValueById("natinality", natn);
		enterById("flatNo", flatNo);
		enterById("street", street);
		enterById("area", area);
		selectValueById("country", country);
		enterById("mobile", mobno);
		enterByIdTxtKeys("pincode", pincode, Keys.TAB);
		selectValueById("city", city);
		selectValueById("state", state);
		selectValueById("postOffice", po);
		enterByXpathKeys("//html/body", Keys.PAGE_DOWN);
		waitProperty(5000);
		clickById("sameAddresses1");
		enterById("flatNoOffice", resFlatno);
		enterById("streetOffice", resStreet);
		enterById("areaOffice", resArea);
		selectValueById("countryOffice", offcountry);
		enterById("mobileOffice", rMobno);
		enterById("pincodeOffice", rPincode);
		clickByXpath("//html");
		selectValueById("cityOffice", cityoff);
		selectValueById("stateOffice", stateoff);
		selectValueById("postOfficeOffice",offpo);
		closeAllBrowsers();
	}

}
