package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliTest {

	public static void main(String[] args) throws Exception {
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
