package testNG;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import browser.Browser;
import pomClasses.AddToCartPageAmazon;
import pomClasses.CartPageAmazon;
import pomClasses.MainPageAmazon;
import pomClasses.SearchResultPageAmazon;
import utils.Utility;

public class TestNGclass extends Browser {
    
	static WebDriver driver;
	static String TestID;
	
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@Parameters("Browser")
	  
	@BeforeTest
	public void openBrowser(String browserName) {
		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		
			if(browserName.equals("Chrome")) {
				driver = Browser.openChromeBrowser();
//				System.setProperty("webdriver.chrome.driver","F:\\selenium_files\\chromedriver_win32\\chromedriver.exe");
//				driver = new ChromeDriver();
				
				
			}
			
//			if(browserName.equals("Firefox")) {
//				
//				Browser.openFirefoxBrowser();
////				System.setProperty("webdriver.gecko.driver","F:\\selenium_files\\chromedriver_win32\\geckodriver.exe");
////				driver = new FirefoxDriver();
//			}
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
	
	}
	
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		System.out.println("----------------------------");
		System.out.println("Before Method");
		
		driver.get("https://www.amazon.in/");
		
		MainPageAmazon mainPageAmazon = new MainPageAmazon(driver);
		mainPageAmazon.searchForProduct("mobile");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)");
		
		SearchResultPageAmazon searchResultPageAmazon = new SearchResultPageAmazon(driver);
		searchResultPageAmazon.clickOn2ndResult();
		
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		Thread.sleep(3000);
//		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		
		AddToCartPageAmazon addToCartPageAmazon = new AddToCartPageAmazon(driver);
		addToCartPageAmazon.clickAddToCartButton();
		Thread.sleep(2000);
		
		driver.close();
		Thread.sleep(3000);
		driver.switchTo().window(addr.get(0));
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		
		searchResultPageAmazon.clickOnCartIcon(driver);
	}
	
	@Test (priority = 4,enabled =true)
	public void verifyURLofCartPage() {
		TestID = "HEAL-2";
		System.out.println("Test - 1");
		
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://www.amazon.in/gp/cart/view.html?ref_=nav_cart";
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Amazon.in Sho Cart";
		
		String actualTitle2 = driver.getTitle();
		String expectedTitle2 = "Amazon.in Shopping Cart";

		//String expectedURL = "https://www.amazon.in/gp/cart/view.html?ref_=nav_cart";
		
		
		Assert.assertEquals(actualURL, expectedURL,"URL is Wrong");
		System.out.println("hard assert executed");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualTitle, expectedTitle);
		System.out.println("soft assert 1 executed");
		soft.assertEquals(actualTitle2, expectedTitle2);
		System.out.println("soft assert 2 executed");
		
		
		
//		if(url.equals(actualURL)) {
//			System.out.println("PASSED");
//		}
//		else {
//			System.out.println("FAILED");
//		}
		
		soft.assertAll();
		
	}
	
	@Test (priority = 2,enabled =false)
	public void verifyTitleOfCartPage() {
		System.out.println("Test - 2");
		TestID = "HEAL-3";
		
		String title = driver.getTitle();
		String actualTitle = "Amazon.in Shopping Cart";
		if(title.equals(actualTitle)) {
			System.out.println("PASSED");
		}
		else {
			System.out.println("FAILED");
		}
	}
	
	@Test (priority = 3,enabled =false)
	public void verifyItemAddedToCart() throws InterruptedException {
		System.out.println("Test - 3");
		TestID = "HEAL-4";
		
		Thread.sleep(3000);
		CartPageAmazon cartPageAmazon = new CartPageAmazon(driver);
		boolean result = cartPageAmazon.deleteItemButtonStatus();
		
		if(result) {
			System.out.println("PASSED");
		}
		else {
			System.out.println("FAILED");
				
		}
	}
	
	
	@Test (priority=1,enabled =false)
	public static void verifyItemGettingDeletedFromCart() throws InterruptedException {
		System.out.println("Test - 4");
	
		Thread.sleep(3000);
		CartPageAmazon cartPageAmazon = new CartPageAmazon(driver);
		cartPageAmazon.clickDeleteButton();
		Thread.sleep(3000);
		
		String actualText = cartPageAmazon.getEmptyCartMsgText();
		String expectedText = "Your Amazon Cart is empty.";
		if(actualText.equals(expectedText)) {
			System.out.println("PASSED");
		}
		else {
			System.out.println("FAILED");
				
		}
		
		
		
	}
	
	

	@AfterMethod
	public void backToHomePage(ITestResult result) throws IOException {
		System.out.println("After Method");
		
		if(ITestResult.FAILURE==result.getStatus()) {
		
		Utility.captureScreenshot(driver, TestID);
		}

		
		driver.navigate().back();
        driver.navigate().back();
	}
	@AfterClass
	public void clearPOMobjects() {
		System.out.println("After Class");
		
		driver.quit();
	}
	
	
}
