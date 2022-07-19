package testcases;


import org.testng.annotations.Test;

import utils.DP010;
import wrappers.GenericWrappers;

public class TC0010 extends GenericWrappers {
	
	@Test
	public void simpleAlert() {
		
		invokeApp("chrome", "https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
		waitProperty(5000);
		switchToFrame(1);
		clickByXpathNoSnap("/html/body/button");
		waitProperty(3000);
		getAlertTextReturnVal();
		waitProperty(3000);
		acceptAlert();
		switchToDefaultCont();
		clickById("tryhome");
		closeBrowser();
		
		
	}

}
