package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffHomePage {

	WebDriver driver;
	
	public RediffHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Page Factory Annotations: FindBy:-
	 */
	
	@FindBy(id="srchword")
	WebElement searchInput;
	
//	By searchInput = By.id("srchword");
	
	public WebElement getSearchInput() {
//		return driver.findElement(searchInput);
		return searchInput;
	}
}
