package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import objectRepository.RediffHomePage;
import objectRepository.RediffLoginPage;

public class LoginPageTest {

	@Test
	public void login() {
		
//		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "/home/vishal/testing/selenium/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		RediffLoginPage rlp = new RediffLoginPage(driver);
		rlp.getUserNameInput().sendKeys("abc@gmail.com");
		rlp.getPasswordInput().sendKeys("1234567890");
		rlp.getSignInBtn().click();
		rlp.getHomeLink().click();
		
		RediffHomePage rhp = new RediffHomePage(driver);
		rhp.getSearchInput().sendKeys("Vishal Chhabra");
		
	}
	
	
}
