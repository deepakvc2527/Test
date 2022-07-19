 package testcases;


import org.testng.annotations.Test;

import utils.DP003;
import wrappers.GenericWrappers;

public class TC003 extends GenericWrappers{
	
    @Test(dataProvider="fetchData",dataProviderClass=DP003.class)
	public void irctcSaloonCheck(String name,String	organization,String	address,String mobile,String email,String reqfor,String originStation,
			String destStatn,String	Duration,String	coachDet,String	noOfPassengers,String noOfPasngrs,String purpose,String	service,String verifytxt) {
		
		invokeApp("chrome", "https://www.irctc.co.in/nget/train-search");
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div/div[2]/div/form/div[2]/button");
		clickByLink("HOLIDAYS");
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[2]/nav/ul/li[7]/ul/li[3]/a");
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[2]/nav/ul/li[7]/ul/li[3]/ul/li[2]/a");
		switchToLastWindow();
		clickById("sidebarCollapse");
		clickByLink("Charter");
		clickById("dismiss");
		waitProperty(5000);
		clickByLink("Enquiry Form");
		waitProperty(5000);
		enterByName("name", name);
		enterByName("organization", organization);
		enterByName("address", address);
		enterByName("mobile", mobile);
		enterByName("email", email);
		selectValueByName("requestFor", reqfor);
		enterByName("originStation", originStation);
		enterByName("destnStation", destStatn);
		clickByName("checkInDate");
		clickByXpath("//*[@id=\"enquiry\"]/div/form/div/div[9]/div/div/table/tbody/tr[5]/td[1]/span");
		clickByName("checkOutDate");
		clickByXpath("//*[@id=\"enquiry\"]/div/form/div/div[10]/div/div/table/tbody/tr[5]/td[2]/span");
		enterByName("durationPeriod", Duration);
		enterByName("coachDetails", coachDet);
		enterByXpath("//*[@id=\"enquiry\"]/div/form/div/div[13]/input", noOfPassengers);
		enterByXpath("//*[@id=\"enquiry\"]/div/form/div/div[14]/input", noOfPasngrs);
		enterByName("charterPurpose", purpose);
		enterByName("services", service);
		clickByXpath("//*[@id=\"enquiry\"]/div/form/div/div[17]/button");
		verifyTextByXpath("//*[@id=\"enquiry\"]/div/form/div/div[4]/span", verifytxt);
		closeAllBrowsers();
	}

}
