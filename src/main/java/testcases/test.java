package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class test {
@Test
	public void main() throws FindFailed, InterruptedException {
		// TODO Auto-generated method stub
		
		Screen screen = new Screen();
		Pattern login = new Pattern("C:\\Users\\HP\\Documents\\fbLogin.PNG");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		  ChromeDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://www.facebook.com");
		  screen.click(login);

	}

}
