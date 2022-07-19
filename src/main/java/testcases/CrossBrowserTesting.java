package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {

	public WebDriver driver;

	  @Parameters("browser")

	  @BeforeClass

	 

	  public void beforeTest(String browser) {

	  
	  if(browser.equalsIgnoreCase("ie")) {
		 
	
		  System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
		  driver = new EdgeDriver();	  

	  }else if (browser.equalsIgnoreCase("chrome")) { 

		  
		  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		  driver = new ChromeDriver();

	  } 

	

	  driver.get("https://www.facebook.com"); 

	  }

	  

	  @Test public void login() throws InterruptedException {
		  
		  
        Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='login']")).click();

		}  

	  @AfterClass public void afterTest() {

			driver.quit();

		}

	}


