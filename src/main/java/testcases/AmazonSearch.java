package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class AmazonSearch {
	
@Test

	public void amazon() {
		// TODO Auto-generated method stub

		
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	  ChromeDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.in");
	  WebElement search = driver.findElementByXPath("//select[@id='searchDropdownBox']");
	  System.out.println(search.getAttribute("title"));
		driver.findElementById("twotabsearchtextbox").sendKeys("oneplus");
		driver.findElementById("nav-search-submit-button").click();
		List<WebElement> all = driver.findElementsByXPath("//span[starts-with(text(),'OnePlus')]");
		//System.out.println(all.size());
		for(WebElement items:all) {
			//WebElement linktext = driver.findElement(By.partialLinkText("OnePlus"));
			//String links = linktext.getAttribute("innerHTML");
			//String text = items.getText();
			//System.out.println("linktexts: "+links);
			//System.out.println("text: "+text);
			
			/*String results = items.getText();
if(results.contains("OnePlus")) {
				System.out.println(results); */
			System.out.println(items.getText());
			}
			

			
		}
		
		
		
	}


