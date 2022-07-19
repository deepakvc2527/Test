package testcases;


import org.testng.annotations.Test;

import utils.DP004;
import wrappers.GenericWrappers;

public class TC004 extends GenericWrappers {
	
	@Test(dataProvider="fetchData",dataProviderClass=DP004.class)
	public void irctcBookHotel(String email,String mobno,String city,String room, String guest,String title, String firstname,
			String lastname,String country,String state,String gst,String verifytxt) {
		
		invokeApp("chrome", "https://www.irctc.co.in");
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/p-dialog[2]/div/div/div[2]/div/form/div[2]/button");
		clickByLink("HOLIDAYS");
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[2]/nav/ul/li[7]/ul/li[3]/a");
		clickByXpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[2]/nav/ul/li[7]/ul/li[3]/ul/li[2]/a");
		switchToLastWindow();
		clickByXpath("/html/body/app-root/accommodation/div[2]/div[1]/ul/li[2]/a/div"); 
		switchToLastWindow();
		clickByLink("Login");
		waitProperty(3000);
		clickByLink("Guest User Login");
		waitProperty(3000);
		enterByName("email", email);
		enterByName("mobileNo", mobno);
		clickByXpath("//*[@id=\"profile\"]/div/form/div[3]/button");
		waitProperty(3000);
		enterById("filterText", city);
		waitProperty(3000);
		clickByXpath("//*[@id=\"scroll\"]/div[2]/div/app-hotelmodify/form/div[1]/searchbox/div/ul/li[1]/a");
		clickByName("dt12");
		waitProperty(2000);
		clickByXpath("//*[@id=\"owl-dt-picker-0\"]/div[2]/owl-date-time-calendar/div[2]/owl-date-time-month-view/table/tbody/tr[5]/td[3]/span");
		clickByName("dt13");
		waitProperty(3000);
		clickByXpath("//*[@id=\"owl-dt-picker-1\"]/div[2]/owl-date-time-calendar/div[2]/owl-date-time-month-view/table/tbody/tr[5]/td[4]/span");
		waitProperty(2000);
		clickById("user-data-wrapper-id");
		selectValueByName("hotelRoom", room);
		selectValueByName("hotelAdult", guest);
		clickByXpath("//*[@id=\"user-data-wrapper\"]/div[2]/button");
		clickByXpath("//*[@id=\"scroll\"]/div[2]/div/app-hotelmodify/form/div[5]/button");
		waitProperty(5000);
		clickByXpath("/html/body/app-root/app-fulllayout/app-hotellist/div[2]/div/div/div[3]/div[2]/a/div/div[2]/div/h5");
		switchToLastWindow();
		getTextByXpath("/html/body/app-root/app-fulllayout/app-hoteldetail/div[2]/div[1]/div/h5");
		//System.out.println("Hotel Name: "+actualText);
		getTextByXpath("/html/body/app-root/app-fulllayout/app-hoteldetail/div[2]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[2]/strong");
		//System.out.println("Price: "+actualText);
		clickByXpath("/html/body/app-root/app-fulllayout/app-hoteldetail/div[2]/div[2]/div[1]/div[2]/div/div[3]/button");
		waitProperty(3000);
		selectValueByName("title", title);
		enterByName("firstName", firstname);
		enterByName("lastName", lastname);
		selectValueByName("country", country);
		selectValueByName("state", state);
		selectValueByName("gst", gst);
		verifyTextByXpath("/html/body/app-root/app-fulllayout/app-paxdetail/div[1]/div/div/h5", getTextByXpath("/html/body/app-root/app-fulllayout/app-paxdetail/div[1]/div/div/h5"));
		verifyTextByXpath("/html/body/app-root/app-fulllayout/app-paxdetail/div[2]/div/div/div[2]/div[2]/div/div/div[3]/strong", getTextByXpath("/html/body/app-root/app-fulllayout/app-paxdetail/div[2]/div/div/div[2]/div[2]/div/div/div[3]/strong"));
		clickByXpath("/html/body/app-root/app-fulllayout/app-paxdetail/div[2]/div/div/div[3]/div/div/div/form/div[9]/button[2]");
		waitProperty(2000);
		clickByXpath("/html/body/app-root/app-fulllayout/app-summary/div[2]/div/div/div[2]/div[2]/form/div[1]/ul/li/label/span");
		clickByXpath("/html/body/app-root/app-fulllayout/app-summary/div[2]/div/div/div[2]/div[2]/form/div[2]/button[2]");
		waitProperty(3000);
		clickByXpath("//*[@id=\"modalOTP\"]/div/div/form/div/div[2]/button");
		verifyTextByXpath("//*[@id=\"modalOTP\"]/div/div/form/div/div[1]/span", verifytxt);
		closeAllBrowsers();
	}
	

}
