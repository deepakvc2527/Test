package testcases;


import org.testng.annotations.Test;

import utils.DP011;
import wrappers.GenericWrappers;

public class TC0011 extends GenericWrappers {

	@Test(dataProvider="fetchdata",dataProviderClass=DP011.class)
	public void confirmationAlert(String verifytxt1,String verifytxt2) {
		
		invokeApp("chrome", "https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		waitProperty(5000);
		switchToFrame("iframeResult");
		clickByXpathNoSnap("/html/body/button");
		getAlertText();
		acceptAlert();
		verifyTextById("demo", verifytxt1);
		Refresh();
		waitProperty(5000);
		switchToFrame("iframeResult");
		clickByXpathNoSnap("/html/body/button");
		getAlertText();
		dismissAlert();
		verifyTextById("demo", verifytxt2);
		switchToDefaultCont();
		clickById("tryhome");
		closeBrowser();
	}

}
