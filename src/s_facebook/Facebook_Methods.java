package s_facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import s_generics.SuperParent;

public class Facebook_Methods extends SuperParent {
	public boolean LoginSucceeds(String usr, String pwd) {		
		WebElement campoUsuario = driver.findElement(By.id("email"));
		WebElement campoPassword = driver.findElement(By.id("pass"));
		WebElement botonLogin = driver.findElement(By.xpath("//input[@data-testid='royal_login_button']"));
		
		campoUsuario.clear();
		campoUsuario.sendKeys(usr);
		campoPassword.clear();
		campoPassword.sendKeys(pwd);
		botonLogin.click();
		
		String xPath = "//div[@data-click='profile_icon']";
		
		WebElement profileIcon = null;
		try {
			profileIcon = driver.findElement(By.xpath(xPath));
		} catch (Exception e) {
			System.out.println("Profile icon does not exist or there was an error");			
			e.printStackTrace();
			//Babye();
		}
		
		if (profileIcon.isDisplayed() && profileIcon != null )
			return true;
		else
			return false;
	}
	
	public boolean NameExists(String name) {
		WebElement search = driver.findElement(By.name("q"));
		search.clear();
		search.sendKeys(name);
		
		try {
			WebElement searchBtn = driver.findElement(By.xpath("//button[@data-testid='facebar_search_button']"));
			searchBtn.click();
		} catch (Exception e) {
			System.out.println("Search button not found");
			e.printStackTrace();	
			//Babye();
		}
		
		return (driver.findElement(By.partialLinkText(name)).isDisplayed()) ? true : false;
	}
	
	public void AddFriend(String name, String details) {
		if (NameExists(name)) {
			System.out.println("Name found");
			String xPath = "//div[contains(@class, '_2yer')]";
			WebElement myFriend = GetCorrectElement(By.xpath(xPath), details);			
			
			if (myFriend != null) {
				xPath = "//button[contains(@class, 'FriendRequestAdd')]";
				myFriend.findElement(By.xpath(xPath)).click();
				System.out.println("Congratulations!\nYou have sent a friend request to: " + name + " / " + details);
				//Babye();
			} else {
				System.out.println("I found at least one " + name + " but none with these details: " + details);
				//Babye();
			}
		}else {
			System.out.println("I couldn't find this name: " + name);
			//Babye();
		}
	}
}
