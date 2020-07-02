package selenium;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.io.Files;

public class SeleniumBasic {
	/*  Framework:  
	 * 
	 * 	-TestNg: Unit testing framework.Used to control 
	 *   your test cases. out of 400 I want to run 200 as smoke and 200 as regression.
	 * 
	 * 	-Data driven testing: best practise to drive data from external resources.
	 * 
	 *  -Maven: Build Management Tool.
	 *  
	 *  -Jenkins: Continuous Integration
	 *  
	 *  -Reports: Reports for framework tests
	 *  
	 *  -Log4j: Logging framework generates Logs
	 *  
	 *  -Page Object Mechanism: Design Pattern for Tests Development
	 * 
	 * */
	
	/* 
	 * 	TestNg: Unit testing framework.Used to control 
	 *   your test cases. out of 400 I want to run 200 as smoke and 200 as regression.
	 * 	
	 * 
	 */
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "/home/vishal/testing/selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		

		driver.close();
	}
}
