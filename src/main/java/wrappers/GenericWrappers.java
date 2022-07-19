package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericWrappers implements Wrappers {
	
	RemoteWebDriver driver;

	public void invokeApp(String browser, String url) {
		// TODO Auto-generated method stub
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("ie")) {
				System.setProperty("wedriver.ie.driver", "./drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			
            driver.manage().window().maximize();
            driver.get(url);
            System.out.println("The browser "+browser+" is launched with the url "+url+" successfully");
		} catch (SessionNotCreatedException e) {
			// TODO Auto-generated catch block
			System.err.println("The browser "+browser+" is not launched due to session not created error");
		} catch (InvalidArgumentException e) {
			// TODO: handle exception
			System.err.println("The browser "+browser+" is not launched as the url "+url+" does not contains http/https");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The browser "+browser+" is not launched due to unknown error");
		} finally {
			takeSnap();
		}
	}

	public void enterById(String idValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(idValue).sendKeys(data);
			System.out.println("The element with id "+idValue+" is entered with data "+data);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with id "+idValue+" is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with id "+idValue+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with id "+idValue+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with id "+idValue+" is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The element with id "+idValue+" is not entered with data "+data+" due to unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		
		try {
			driver.findElementByName(nameValue).sendKeys(data);
			System.out.println("The element with name "+nameValue+" is entered with data "+data);
		} catch (NoSuchElementException e) {
			System.err.println("The element with name "+nameValue+" is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with name "+nameValue+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with name "+nameValue+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with name "+nameValue+" is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The element with name "+nameValue+" is not entered with data "+data+" due to an unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			System.out.println("The element with xpath "+xpathValue+" is entered with data "+data);
		} catch (NoSuchElementException e) {
			System.err.println("The element with xpath "+xpathValue+" is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with xpath "+xpathValue+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with xpath "+xpathValue+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with xpath "+xpathValue+" is not stable in the application");
		} catch(WebDriverException e) {
			System.err.println("The element with xpath "+xpathValue+" is not enetered with data "+data+"due to unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void verifyTitle(String title) {
		// TODO Auto-generated method stub
		try {
			String actualTitle = driver.getTitle();
			if(actualTitle.equals(title)) {
				System.out.println("The title of the page "+actualTitle+" is matched with the expected title "+title);
			} else {
				System.err.println("The title of the page "+actualTitle+" is not matched with the expected title "+title);
			}
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("The title of the page "+title+" is not verified due to an unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		 try {
			String actualText = driver.findElementById(id).getText();
			 if(actualText.equals(text)) {
				 System.out.println("The element with id "+id+" is holding the text "+actualText+" is matched with the expected text "+text);
			 } else {
					 System.err.println("The element with id "+id+" is holding the text "+actualText+" is not matched with the expected text "+text);
				 }
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with id"+id+"is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with id"+id+"is not visible in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+" is not stable in the application");
		}catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with id"+id+"is not verified due to an unknown error");
		} finally {
			takeSnap();
		}
		 
		 }
		

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String actualText = driver.findElementByXPath(xpath).getText();
			if(actualText.equals(text)) {
				System.out.println("The element with xpath "+xpath+" holding the text "+actualText+" is matched with the expected text "+text);
			} else {
				System.err.println("The element with xpath "+xpath+" holding the text "+actualText+" is not matched with the expected text "+text);
			}
		} catch (ElementNotVisibleException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with xpath "+xpath+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpath+" is not interactable in the application");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpath+" is not found in the DOM");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpath+" is not stable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpath+" is not verified due to an unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String actualText = driver.findElementByXPath(xpath).getText();
			if(actualText.contains(text)) {
				System.out.println("The element with xpath "+xpath+" holding the text "+actualText+" contains the text "+text);
			} else {
				System.err.println("The element with xpath "+xpath+" holding the text "+actualText+" does not contains the text "+text);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with xpath "+xpath+" is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpath+" is not visible in the application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpath+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpath+" is not stable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpath+" is not verified due to an unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void clickById(String id) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(id).click();
			
		System.out.println("The element with id "+id+" is Clicked");
		} catch (ElementClickInterceptedException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with id "+id+" is not clickable in the application");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+" is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+" is not visible in the application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+" is not stable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+" is not clicked due to an unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void clickByClassName(String classVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByClassName(classVal).click();
			System.out.println("The element with ClassName "+classVal+" is Clicked");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with ClassName "+classVal+" is not found in the DOM");
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			System.err.println("The element with ClassName "+classVal+" is not clickable in the application");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with ClassName "+classVal+" is not visible in the application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with ClassName "+classVal+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with ClasName "+classVal+" is not stable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with ClassName "+classVal+" is not clicked due to an unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void clickByName(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(name).click();
			System.out.println("The element with name "+name+" is Clicked");
		} catch (ElementClickInterceptedException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with name "+name+" is not clickable in the application");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with name "+name+" is not visible in the application");
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println("The element with name "+name+" is not found in the DOM");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with name "+name+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with name "+name+" is not stable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with name "+name+" is not clicked due to an unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void clickByLink(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("The element with LinkText "+name+" is Clicked");
		} catch (ElementClickInterceptedException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with LinkText "+name+" is not clickable in the application");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with LinkText "+name+" is not visible in the application");
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println("The element with LinkText "+name+" is not found in the DOM");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with LinkText "+name+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with LinkText "+name+" is not stable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with LinkText "+name+" is not clicked due to an unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("The element with LinkText "+name+" is Clicked");
		} catch (ElementClickInterceptedException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with LinkText "+name+" is not clickable in the application");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with LinkText "+name+" is not visible in the application");
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println("The element with LinkText "+name+" is not found in the DOM");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with LinkText "+name+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with LinkText "+name+" is not stable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with LinkText "+name+" is not clicked due to an unknown error");
		}
		
	}

	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("The element with xpath "+xpathVal+" is Clicked");
		} catch (ElementClickInterceptedException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with xpath "+xpathVal+" is not clickable in the application");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+" is not visible in the application");
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+" is not found in the DOM");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("the element with xpath "+xpathVal+" is not stable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+" is not clicked due to an unexpected error");
		} finally {
			takeSnap();
		}
		 
	}

	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("The element with xpath "+xpathVal+" is Clicked");
		} catch (ElementClickInterceptedException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with xpath "+xpathVal+" is not clickable in the application");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+" is not visible in the application");
		}catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+" is not found in the DOM");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("the element with xpath "+xpathVal+" is not stable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+" is not clicked due to an unexpected error");
		}
		
	}

	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		String actualText=null;
		try {
			 actualText = driver.findElementById(idVal).getText(); 
			System.out.println("The element with id "+idVal+"is getting the corresponding text "+actualText);
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with id "+idVal+"is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with id "+idVal+"is not visible in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("the element with id "+idVal+"is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with id "+idVal+"is not stable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with id "+idVal+"is not getting the corresponding text due to unknown error");
		} finally {
			takeSnap();
		}
		
		return actualText;
	}

	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		String actualText = null;
		try {
			actualText = driver.findElementByXPath(xpathVal).getText();
			System.out.println("The element with xpath "+xpathVal+"is getting the corresponding text");
		} catch (NoSuchElementException  e) {
			// TODO Auto-generated catch block
			System.err.println("The element with xpath "+xpathVal+"is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+"is not visible in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+"is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+"is not stable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+"is not getting the corresponding text due to unknown error");
		} finally {
			takeSnap();
		}
		
		return actualText;
	}

	public void selectVisibleTextById(String id, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement visibletext = driver.findElementById(id);
			Select sel = new Select(visibletext);
			sel.selectByVisibleText(value);
			System.out.println("The element with id "+id+"is selected by the visible text "+value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with id "+id+"is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+"is not visible in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+"is not interactable in the application");
		} catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.out.println("The element with id "+id+"is not selected using the visible text"+value+" since it is disabled");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+"is not stable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+"is not selected by the visible text"+value+" due to unknown error");
		} finally {
			takeSnap();
		}
	}

	public void selectIndexById(String id, int value) {
		// TODO Auto-generated method stub
		try {
			WebElement index = driver.findElementById(id);
			Select sele = new Select(index);
			sele.selectByIndex(value);
			System.out.println("The element with id "+id+"is selected by the corresponding index value"+value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with id "+id+"is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+"is not visible in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+"is not interactable in the application");
		} catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+"is not selectable using the index value "+value+"since it is diabled");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+"is not stable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+"is not selectable using index value "+value+"due to unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		try {
			Set<String> allwinids = driver.getWindowHandles();
			for(String eachid:allwinids) {
				driver.switchTo().window(eachid);
				break;
			}
			System.out.println("The control is now moved to Parent window");
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.err.println("The control cannot be moved to parent window since there is no such window found");
		} catch (SessionNotCreatedException e) {
			// TODO: handle exception
			System.err.println("The control cannot be moved to parent window, since Session id is not created for that window");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The control cannot be moved to parent window due to unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		try {
			Set<String> allwinid = driver.getWindowHandles();
			for(String eachid:allwinid) {
				driver.switchTo().window(eachid);
			}
			System.out.println("The control is now moved to the last window");
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.err.println("The control cannot be movwd to last window since there is no such window found");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The control cannot be moved to last window due to unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().accept();
			System.out.println("The opened alert is accepted in the application");
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("There is no alert present in the application to accept ");
		} catch (UnhandledAlertException e) {
			// TODO: handle exception
			System.err.println("The alert cannot be accepted because of some unexpected error occured in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The opened alert is not accepted in the application due to unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("The opened alert is dismissed in the application");
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("There is no alert present in the application to dismiss");
		} catch (UnhandledAlertException e) {
			// TODO: handle exception
			System.err.println("The alert cannot be dismissed due to some unexpected error occured in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The opened alert cannot be dismissed in the application due to unknown error");
		} finally {
			takeSnap();
		}
		
		
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		
		String actualText = null;
		try {
			actualText = driver.switchTo().alert().getText();
			System.out.println("The text from the alert "+actualText+" has been captured");
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("There is no alert in the application to gettext");
		} catch (UnhandledAlertException e) {
			// TODO: handle exception
			System.err.println("The alert text cannot be captured due to some unexpected error in the application");
		} catch (WebDriverException e) {
			System.err.println("The alert text cannot be captured due to an unknown error");
			// TODO: handle exception
		}
		
		return actualText;
	}

	public void takeSnap() {
		// TODO Auto-generated method stub
		try {
			
			File tmp = driver.getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenshots/snap1.jpeg");
			FileUtils.copyFile(tmp, dest);
		
			System.out.println("Snapshot of the browser is taken for the application");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("Unable to take snapshot of the browser due to unknown error");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Unable to take snapshot of the browser due to IO invalid");
		}
		
		
		
	}

	public void closeBrowser() {
		// TODO Auto-generated method stub
		try {
			driver.close();
			System.out.println("The current opened window of the browser is closed successfully");
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.err.println("Unable to close the window of the browser since no such window is active");
		} catch (SessionNotCreatedException e) {
			// TODO: handle exception
			System.err.println("Unable to close the active window due to unknown error ");
		} 
		
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		try {
			driver.quit();
			System.out.println("All the opned browsers of the application are closed successfully");
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			System.err.println("Unable to close the browsers since there is no such window opened");
		} catch (SessionNotCreatedException e) {
			// TODO: handle exception
			System.err.println("Unable to close the browsers since the session id's are not created");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("Unable to close the browsers due to unknown error");
		} 
	}

	public void waitProperty(long time) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(time);
			System.out.println("The execution waited for "+time+"ms");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.err.println("Error occurred during wait");
		}
		
	}

	public void selectValueByXpath(String xpathVal, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement valuexpath = driver.findElementByXPath(xpathVal);
			Select selxv = new Select(valuexpath);
			selxv.selectByValue(value);
			System.out.println("The element with xpath "+xpathVal+"is selected by the value "+value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with xpath "+xpathVal+"is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+"is not visible in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+"is not interactable in the application");
		} catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.out.println("The element with xpath "+xpathVal+"is not selected using the value"+value+" since it is disabled");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+"is not stable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+"is not selected by the value"+value+" due to unknown error");
		} finally {
			takeSnap();
		}
	}

	public void selectVisibleTextByXpath(String xpathVal, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement visxpath = driver.findElementByXPath(xpathVal);
			Select selxvt = new Select(visxpath);
			selxvt.selectByVisibleText(value);
			System.out.println("The element with xpath "+xpathVal+"is selected by the visible text "+value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with xpath "+xpathVal+"is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+"is not visible in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+"is not interactable in the application");
		} catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.out.println("The element with xpath "+xpathVal+"is not selected using the visible text"+value+" since it is disabled");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+"is not stable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+"is not selected by the visible text"+value+" due to unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void selectIndexByXpath(String xpathVal, int value) {
		// TODO Auto-generated method stub
		try {
			WebElement indexx = driver.findElementByXPath(xpathVal);
			Select selix = new Select(indexx);
			selix.selectByIndex(value);
			System.out.println("The element with xpath "+xpathVal+"is selected by the corresponding index value"+value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with xpath "+xpathVal+"is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+"is not visible in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+"is not interactable in the application");
		} catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+"is not selectable using the index value "+value+"since it is diabled");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+"is not stable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with xpath "+xpathVal+"is not selectable using index value "+value+"due to unknown error");
		} finally {
			takeSnap();
		}
	}

	public void enterByXpathKeys(String xpathVal, Keys keyval) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal).sendKeys(keyval);
			System.out.println("The element with xpath "+xpathVal+" is performed with action "+keyval);
		} catch (NoSuchElementException e) {
			System.err.println("The element with xpath "+xpathVal+" is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with xpath "+xpathVal+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with xpath "+xpathVal+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with xpath "+xpathVal+" is not stable in the application");
		} catch(WebDriverException e) {
			System.err.println("The element with xpath "+xpathVal+" is not not performed with action "+keyval+"due to unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void selectValueByClassName(String name, String classVal) {
		// TODO Auto-generated method stub
		try {
			WebElement clsval = driver.findElementByClassName(name);
			Select selcv = new Select(clsval);
			selcv.selectByValue(classVal);
			System.out.println("The element with classname "+name+"is selected by the value "+classVal);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with classname "+name+"is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with classname "+name+"is not visible in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with classname "+name+"is not interactable in the application");
		} catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.out.println("The element with classname "+name+"is not selected using the value"+classVal+" since it is disabled");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with classname "+name+"is not stable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with classname "+name+"is not selected by the value"+classVal+" due to unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void selectValueById(String id, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement idval = driver.findElementById(id);
			Select seliv = new Select(idval);
			seliv.selectByValue(value);
			System.out.println("The element with id "+id+"is selected by the value "+value);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with id "+id+"is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+"is not visible in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+"is not interactable in the application");
		} catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.out.println("The element with id "+id+"is not selected using the value"+value+" since it is disabled");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with classname "+id+"is not stable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with classname "+id+"is not selected by the value"+value+" due to unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void enterByIdTxtKeys(String id, String val, Keys keyval) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(id).sendKeys(val,keyval);
			System.out.println("The element with id "+id+" is entered with data "+val+" and performed with action "+keyval);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with id "+id+" is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with id "+id+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with id "+id+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with id "+id+" is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The element with id "+id+" is not entered with data "+val+" or the key action"+keyval+ "is not performed due to unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void selectValueByName(String name, String namval) {
		// TODO Auto-generated method stub
		try {
			WebElement nmval = driver.findElementByName(name);
			Select selnv = new Select(nmval);
			selnv.selectByValue(namval);
			System.out.println("The element with name "+name+"is selected by the value "+namval);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with name "+name+"is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with name "+name+"is not visible in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with name "+name+"is not interactable in the application");
		} catch (ElementNotSelectableException e) {
			// TODO: handle exception
			System.out.println("The element with classname "+name+"is not selected using the value"+namval+" since it is disabled");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with classname "+name+"is not stable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with name "+name+"is not selected by the value"+namval+" due to unknown error");
		} finally {
			takeSnap();
		}
		
		
	}

	public void switchToFrame(int indval) {
		// TODO Auto-generated method stub
		
		try {
			driver.switchTo().frame(indval);
			System.out.println("The pointer is switched to the frame with value"+indval);
		} catch (NoSuchFrameException e) {
			// TODO Auto-generated catch block
			System.err.println("The frame with value"+indval+" is not found in the DOM");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("Couldn't locate the frame with value "+indval+"due to some unknown error");
		}
		
	}

	public void switchToFrame(String strval) {
		// TODO Auto-generated method stub
		
		try {
			driver.switchTo().frame(strval);
			System.out.println("The pointer is switched to the frame with string"+strval);
		} catch (NoSuchFrameException e) {
			// TODO Auto-generated catch block
			System.err.println("The frame with string"+strval+" is not found in the DOM");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("Couldn't locate the frame with string "+strval+"due to some unknown error");
		}
		
		
	}

	public void switchToFrame(WebElement webval) {
		// TODO Auto-generated method stub
		
		try {
			driver.switchTo().frame(webval);
			System.out.println("The pointer is switched to the frame with webelement"+webval);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with element "+webval+"is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with element "+webval+"is not visible in the application");
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with element "+webval+"is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with element "+webval+"is not stable in the application");
		} catch (NoSuchFrameException e) {
			// TODO Auto-generated catch block
			System.err.println("The frame with web element"+webval+" is not found in the DOM");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("Couldn't locate the web element with value "+webval+"due to some unknown error");
		}
		
		
	}

	public void switchToDefaultCont() {
		// TODO Auto-generated method stub
		
		try {
			driver.switchTo().defaultContent();
			System.out.println("The pointer is now switched to the main/default frame");
		} catch (NoSuchFrameException e) {
			// TODO Auto-generated catch block
			System.err.println("The default frame is not found in the DOM");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("Couldn't switch to default frame due to some unknown error");
		}
		
	}

	public String getAlertTextReturnVal() {
		// TODO Auto-generated method stub
		String text = null;
		try {
			text = driver.switchTo().alert().getText();
			System.out.println("The alert text "+text+" has been captured");
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("There is no alert in the application to gettext");
		} catch (UnhandledAlertException e) {
			// TODO: handle exception
			System.err.println("The alert text cannot be captured due to some unexpected error in the application");
		} catch (WebDriverException e) {
			System.err.println("The alert text cannot be captured due to an unknown error");
			// TODO: handle exception
		}
		return text;
	}

	public void Refresh() {
		// TODO Auto-generated method stub
		
		try {
			driver.navigate().refresh();
			System.out.println("The page has been refreshed successfully");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("The page cannot be refreshed due to some unknown error");
		}
		
	}

	public void InputAlertText(String data) {
		// TODO Auto-generated method stub
		
		try {
			driver.switchTo().alert().sendKeys(data);
			System.out.println("The opened alert is entered with data"+data);
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			System.err.println("There is no alert present in the application to accept ");
		} catch (UnhandledAlertException e) {
			// TODO: handle exception
			System.err.println("The alert cannot be accepted because of some unexpected error occured in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The opened alert is not entered with given input due to unknown error");
		} 
	}

	public void verifyTextContainsById(String id, String text) {
		// TODO Auto-generated method stub
		
		try {
			String actualText = driver.findElementById(id).getText();
			if(actualText.contains(text)) {
				System.out.println("The element with id "+id+" holding the text "+actualText+" contains the text "+text);
			} else {
				System.err.println("The element with id "+id+" holding the text "+actualText+" does not contains the text "+text);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with id "+id+" is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+" is not visible in the application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+" is not stable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+" is not verified due to an unknown error");
		} finally {
			takeSnap();
		}
		
		
	}

	public void verifyNoTextContainsById(String id, String text) {
		// TODO Auto-generated method stub
		
		try {
			String actualText = driver.findElementById(id).getText();
			if(!actualText.contains(text)) {
				System.out.println("The element with id "+id+" holding the text "+actualText+" does not contain the text "+text);
			} else {
				System.err.println("The element with id "+id+" holding the text "+actualText+"  contains the text "+text);
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with id "+id+" is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+" is not visible in the application");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+" is not stable in the application");
		} catch (WebDriverException e) {
			// TODO: handle exception
			System.err.println("The element with id "+id+" is not verified due to an unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void enterByXpathTxtKeys(String xpath, String val, Keys keyval) {
		// TODO Auto-generated method stub
		
		try {
			driver.findElementByXPath(xpath).sendKeys(val,keyval);
			System.out.println("The element with xpath "+xpath+" is entered with data "+val+" and performed with action "+keyval);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("The element with xpath "+xpath+" is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with xpath "+xpath+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with xpath "+xpath+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with xpath "+xpath+" is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The element with xpath "+xpath+" is not entered with data "+val+" or the key action"+keyval+ "is not performed due to unknown error");
		} finally {
			takeSnap();
		}
		
	}

	public void enterByClassName(String className, String data) {
		// TODO Auto-generated method stub
		
		try {
			driver.findElementByClassName(className).sendKeys(data);
			System.out.println("The element with className "+className+" is entered with data "+data);
		} catch (NoSuchElementException e) {
			System.err.println("The element with className "+className+" is not found in the DOM");
		} catch (ElementNotVisibleException e) {
			System.err.println("The element with className "+className+" is not visible in the application");
		} catch (ElementNotInteractableException e) {
			System.err.println("The element with className "+className+" is not interactable in the application");
		} catch (StaleElementReferenceException e) {
			System.err.println("The element with className "+className+" is not stable in the application");
		} catch (WebDriverException e) {
			System.err.println("The element with className "+className+" is not entered with data "+data+" due to an unknown error");
		} finally {
			takeSnap();
		}
		
	}

	
	}


	

	
