package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Helper;

public class TestBase {

//  This  method to setup the  browser(Chrome) and navigates to SauceDemo Website
	public static WebDriver driver;
	@BeforeSuite
	public void startDriver() {
		WebDriverManager.chromedriver().setup();
		driver =  new ChromeDriver();

		
		driver.navigate().to("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}


	
	// Take screenshot when test case fail and add it in the Screenshot folder
		@AfterMethod
		public void screenshotOnFailure(ITestResult result) 
		{
			if (result.getStatus() == ITestResult.FAILURE)
			{
				System.out.println("Failed!");
				System.out.println("Taking Screenshot....");
				Helper.captureScreenshot(driver, result.getName());
			}
		}
		
		@AfterSuite
		public void stopDriver() {
			driver.quit();

		}
	}

