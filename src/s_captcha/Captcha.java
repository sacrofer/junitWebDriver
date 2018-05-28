package s_captcha;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import s_generics.SuperParent;

public class Captcha extends SuperParent {
	
	@Test
	public void testCaptcha() {
		startBrowser("Firefox", "https://www.google.com/recaptcha/api2/demo");		
		insertData("This is", "My Name", "this.is.my.email@google.com");
	}
	
	public void insertData(String name, String lName, String eMail) {
		//name: input1
		//last name: input2
		//email: input3
		//class="recaptcha-checkbox-checkmark"
		//xpath = //*[contains(@class, 'recaptcha-checkbox-checkmark')]
		//ID = recaptcha-anchor-label
//		WebElement iname = driver.findElement(By.id("input1"));
//		//iname.clear();
//		iname.sendKeys(name);
//				
//		WebElement ilname = driver.findElement(By.id("input2"));
//		//ilname.clear();
//		ilname.sendKeys(lName);		
//		
//		WebElement iemail = driver.findElement(By.id("input3"));
//		//iemail.clear();
//		iemail.sendKeys(eMail);		
		
		WebElement captcha = driver.findElement(By.xpath("//*[contains(@class, 'rc-anchor-content')]"));
		//WebElement captcha = driver.findElement(By.className("rc-anchor-content"));
		//WebElement captcha = driver.findElement(By.id("recaptcha-anchor-label"));
		//WebElement captcha = driver.findElement(By.xpath("//*[contains(@class, 'recaptcha-checkbox-checkmark')]"));
		//WebElement captcha = driver.findElement(By.className("recaptcha-checkbox-checkmark"));
		captcha.click();
	}
}
