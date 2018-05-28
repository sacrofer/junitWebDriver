package s_imdb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import s_generics.SuperParent;

public class Imdb_Methods extends SuperParent {
	protected void searchMovie(String movie, String year) throws MovieNotFound {
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.clear();
		searchBox.sendKeys(movie);
		
		WebElement searchBtn = driver.findElement(By.id("navbar-submit-button"));
		searchBtn.click();
		
		locateCorrectMovie(movie, year);
	}
	
	protected void locateCorrectMovie(String movie, String year) throws MovieNotFound {
		By by = By.className("result_text");
		WebElement correctElement = getCorrectElement(by, movie, year);
		
		if (correctElement != null) {
			correctElement.findElement(By.linkText(movie)).click();
			System.out.println(movie + " from " + year + " found");
		}else{
			System.out.println("Test FAILED - " + movie + " from " + year + " NOT found");
			throw new MovieNotFound("Test FAILED - " + movie + " from " + year + " NOT found");
			////Babye();
			//how to fail the case. It's currently passing if we reach this else
				//Throw an exception
		}
	}
	
	protected void verifyMovie (String movie, String year, String director) {
		if (driver.getTitle().contains(movie) && driver.getTitle().contains(year)) {
			verifyDirector(director);
		}else {
			System.out.println("Looking for movie by name and year failed");
			//Babye();			
		}
	}
	
	protected void verifyDirector(String director) {
		if (isDirectorInMainPage(director)) {
			System.out.println("Test Passed");
		}else if(isDirectorInDetails(director)) {
			System.out.println("Test Passed");
		}else {
			System.out.println("Test FAILED - Director not found");
			//Babye();
		}
	}

	private boolean isDirectorInMainPage(String director) {
		By xPath = By.xpath("//span[@itemprop='director']");
		
		WebElement correctElement = getCorrectElement (xPath, director);		
		
		return (correctElement != null) ?  true :  false;
	}

	private boolean isDirectorInDetails(String director) {
		System.out.println("Director is not in main page let's try in the details");		
		String xPath = "//a[@href='fullcredits/?ref_=tt_ov_st_sm']";
		
		try {			
			WebElement DetailsLink = driver.findElement(By.xpath(xPath));			
			DetailsLink.click();
		} catch (Exception e) {
			e.printStackTrace();
			//Babye();
		}
		xPath = "//*[contains(text(), 'Directed by')]/following-sibling::table[1]//a[contains(text(), '" + director + "')]";
		
		if (driver.findElement(By.xpath(xPath)).isDisplayed())
			return true;
		
		return false;		
	}	
}
