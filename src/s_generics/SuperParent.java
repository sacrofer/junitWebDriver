package s_generics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SuperParent {
	private static final String CHROME_DRIVER_NAME = "webdriver.chrome.driver";
	private static final String GENERIC_DRIVER_LOCATION = "C:\\testautomation\\libs\\drivers\\";
	private static final String CHROME_DRIVER_LOCATION = GENERIC_DRIVER_LOCATION + "chromedriver.exe";
	private static final String FIREFOX_DRIVER_NAME = "webdriver.gecko.driver";
	private static final String FIREFOX_DRIVER_LOCATION = GENERIC_DRIVER_LOCATION + "geckodriver.exe";
	protected static WebDriver driver = null;
	
	private boolean openUrl (String url) {
		if (driver != null) {
			driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
			
			if (!url.isEmpty()) {
				driver.get(url);
				return true;
			}else {
				System.out.println("URL cannot be empty");
				return false;			
			}
		}else {
			System.out.println("Driver is not initialized");
			return false;
		}
	}
	
	private void setupDriver (String browser) {		
		switch (browser){
			case "Chrome":
				ChromeOptions ops = new ChromeOptions();
		        ops.addArguments("--disable-notifications");
				System.setProperty(CHROME_DRIVER_NAME, CHROME_DRIVER_LOCATION);
			    driver = new ChromeDriver(ops);			    
			    break;
			case "Firefox":
				System.setProperty(FIREFOX_DRIVER_NAME, FIREFOX_DRIVER_LOCATION);
		        driver = new FirefoxDriver();
		        break;
			default:
				System.out.println("Driver cannot be initialized");
				driver = null;
				break;		
		}
	}
	
	protected void startBrowser (String browser, String url) {
		
		try {
			setupDriver(browser);
			openUrl(url);			
		}catch (Exception e){
			System.out.println("An error happened trying to open the url");
		}
	}
	
	@After
	public void baBye() {		
		driver.quit();
		//System.exit(-1);
	}
	
	public WebElement getCorrectElement (By by, String textToFind) {
		List<WebElement> elements = driver.findElements(by);
		for (WebElement element : elements) {
			if (element.getText().contains(textToFind))
				return element;
		}
		return null;		
	}
	
	public WebElement getCorrectElement (By by, String textToFind, String textToFind2) {
		List<WebElement> elements = driver.findElements(by);
		for (WebElement element : elements) {
			if (element.getText().contains(textToFind) && element.getText().contains(textToFind2))
				return element;
		}
		return null;		
	}
}
