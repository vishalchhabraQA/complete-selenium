package automation.extentreports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportsTest {

	ExtentReports er; //defined globally, so that other methods can use its methods and properties
	
	@BeforeTest
	public void beforeTest() {
		//gives project path, no matter on which system u are working
		String path = System.getProperty("user.dir")+"/extent-reports-folder/index.html"; //so index.html is the file which will have extent reports
		
		ExtentSparkReporter esr = new ExtentSparkReporter(path); //responsible for creating report
		//esr object is responsible for doing all extent reports configuration
		esr.config().setReportName("extent-report-web-automation-report");
		esr.config().setDocumentTitle("extent-report-title");
		
		er = new ExtentReports(); //responsible for driving all your reporting execution
		er.attachReporter(esr); 
		er.setSystemInfo("Tester", "Vishal Chhabra");
	}
	
	
	@Test
	public void display() {
		ExtentTest et = er.createTest("test name display"); //now extent report will continuously monitor this test and generates data.
		System.setProperty("webdriver.chrome.driver", "/home/vishal/testing/selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com/");
		System.out.println(driver.getTitle());
//		et.addScreenCaptureFromBase64String(s); //take screenshot
		et.fail("test failed!"); //forcefully/intentionally fail a test
		driver.close(); 
		er.flush(); //to stop extent report from monitoring this test after completion of test
	}
}
