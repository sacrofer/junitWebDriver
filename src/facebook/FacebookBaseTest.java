package facebook;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class FacebookBaseTest {
	
	protected WebDriver driver;
	private static final String CHROME_DRIVER_NAME = "webdriver.chrome.driver";
	private static final String GENERIC_DRIVER_LOCATION = "C:\\testautomation\\libs\\drivers\\";
	private static final String CHROME_DRIVER_LOCATION = GENERIC_DRIVER_LOCATION + "chromedriver.exe";

	//@Before
	//@FileParameters("./data/facebooksetup.csv")
	public void setUp(String browser, String url) {
		ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
		System.setProperty(CHROME_DRIVER_NAME, CHROME_DRIVER_LOCATION);
	    driver = new ChromeDriver(ops);		
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    driver.get(url);
	}
	
	@After
	public void tearDown() {
		System.out.println("Destruye la configuracion");
		driver.quit();
	}
	
	protected void likeAllPhotos() {
		// TODO Auto-generated method stub
		
	}

	protected void gotoPhotos() {
		// TODO Auto-generated method stub
		
	}

	protected void searchFacebookFriend(String friendName) {
		// TODO Auto-generated method stub
		
	}

	protected void logIntoFacebook(String user, String password) {
		// TODO Auto-generated method stub
		
	}

}
