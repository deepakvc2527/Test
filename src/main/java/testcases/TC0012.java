package testcases;


import org.testng.annotations.Test;

import utils.DP012;
import wrappers.GenericWrappers;

public class TC0012 extends GenericWrappers {

	@Test(dataProvider="fetchdata",dataProviderClass=DP012.class)
	public void promptAlert(String textone, String texttwo) {
		
		invokeApp("chrome", "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		waitProperty(5000);
		switchToFrame(1);
		clickByXpathNoSnap("/html/body/button");
		InputAlertText(textone);
		getAlertText();
		acceptAlert();
		verifyTextContainsById("demo", textone);
		Refresh();
		waitProperty(5000);
		switchToFrame(1);
		clickByXpathNoSnap("/html/body/button");
		InputAlertText(texttwo);
		getAlertText();
		dismissAlert();
		verifyNoTextContainsById("demo", texttwo);
		switchToDefaultCont();
		clickById("tryhome");
		closeBrowser();
	}

}
