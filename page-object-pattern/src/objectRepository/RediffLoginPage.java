package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffLoginPage {

	
	
	WebDriver driver;
	
	public RediffLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By username = By.id("login1");

	By password = By.id("password");
	
	By signInBtn = By.name("proceed");
	
	By homeLink = By.linkText("rediff.com");
	
	public WebElement getUserNameInput() {
		return driver.findElement(username);
	}
	
	public WebElement getPasswordInput() {
		return driver.findElement(password);
	}
	
	public WebElement getSignInBtn() {
		return driver.findElement(signInBtn);
	}
	
	public WebElement getHomeLink() {
		return driver.findElement(homeLink);
	}
}
