package testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.Test;

import utils.DP001;
import wrappers.GenericWrappers;

public class TC001 extends GenericWrappers {
 
	@Test(dataProvider="fetchData", dataProviderClass=DP001.class)
	public void irctcSignUp(String username,String password,String cnfrmpwd, String lang, String secque, String secans,String firstname,String middlename,String lastname,String occ, String month,String year, String country, String email,String mobno,
			String nationality,String flatno,String street,String area,String pincode,String state,String city,String po,String phone,
			String offFlatno,String offStreet,String offArea,String offPincode,String offState,String offCity,String OffPostoff,String offPhone) {
		
		invokeApp("chrome", "https://www.irctc.co.in/nget/train-search");
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div/div[2]/div/form/div[2]/button");
		clickByLink("REGISTER");
		waitProperty(3000);
		enterById("userName", username);
		enterById("usrPwd", password);
		enterById("cnfUsrPwd", cnfrmpwd);
		clickByXpath("//*[@id=\"ui-tabpanel-0\"]/div/div[5]/p-dropdown/div/div[2]/span");
		clickByXpath("//*[@id=\"ui-tabpanel-0\"]/div/div[5]/p-dropdown/div/div[4]/div/ul/p-dropdownitem[1]/li/span");
		clickByXpath("//*[@id=\"ui-tabpanel-0\"]/div/div[6]/p-dropdown/div/div[2]/span");
		clickByXpath("//*[@id=\"ui-tabpanel-0\"]/div/div[6]/p-dropdown/div/div[4]/div/ul/p-dropdownitem[3]/li/span");
		enterByXpath("//*[@id=\"ui-tabpanel-0\"]/div/div[7]/input", secans);
		clickByXpath("//*[@id=\"divMain\"]/div/app-user-registration/div/div/form/div/div[2]/div[2]/div[2]/button");
		enterById("firstName", firstname);
		enterById("middleName", middlename);
		enterById("lastname", lastname);
		clickByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[5]/p-dropdown/div/div[2]/span");
		clickByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[5]/p-dropdown/div/div[4]/div/ul/p-dropdownitem[3]/li/span");
		clickByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[6]/p-calendar/span/input");
		selectValueByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[6]/p-calendar/span/div/div/div[1]/div/select[1]", month);
		selectValueByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[6]/p-calendar/span/div/div/div[1]/div/select[2]", year);
		clickByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[6]/p-calendar/span/div/div/div[2]/table/tbody/tr[5]/td[2]/a");
		clickByXpath("//*[@id=\"married\"]/label");
		clickByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[9]/p-selectbutton/div/div[1]/span");
		selectVisibleTextByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[8]/select", country);
		enterById("email", email);
		enterById("mobile", mobno);
		selectVisibleTextByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[13]/select", nationality);
		clickByXpath("//*[@id=\"divMain\"]/div/app-user-registration/div/div/form/div/div[2]/div[2]/div[2]/button");
		enterById("resAddress1", flatno);
		enterById("resAddress2", street);
		enterById("resAddress3", area);
		enterByName("resPinCode", pincode);
		enterById("resState", state);
		selectValueByXpath("//*[@id=\"ui-tabpanel-2\"]/div/div[6]/select", city);
		enterByXpathKeys("//html/body", Keys.PAGE_DOWN);
		selectValueByXpath("//*[@id=\"ui-tabpanel-2\"]/div/div[7]/select", po);
		enterById("resPhone", phone);
		clickByXpath("//*[@id=\"no\"]/div/div[2]/span");
		enterById("offAddress1", offFlatno);
		enterById("offAddress2", offStreet);
		enterById("offAddress3", offArea);
		clickByXpath("//*[@id=\"ui-tabpanel-2\"]/div/div[10]/div[4]/p-dropdown/div/div[2]/span");
		clickByXpath("//*[@id=\"ui-tabpanel-2\"]/div/div[10]/div[4]/p-dropdown/div/div[4]/div/ul/p-dropdownitem[105]/li/span");
		enterById("offPinCode", offPincode);
		enterById("offState", offState);
		enterById("offCity", offCity);
		enterById("offPostOff", OffPostoff);
		enterById("offPhone", offPhone);
		enterByXpathKeys("//html/body", Keys.PAGE_DOWN);
		closeBrowser();
		}

	}


