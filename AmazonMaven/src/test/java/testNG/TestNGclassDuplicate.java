package testNG;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import pomClasses.AddToCartPageAmazon;
import pomClasses.CartPageAmazon;
import pomClasses.MainPageAmazon;
import pomClasses.SearchResultPageAmazon;

public class TestNGclassDuplicate {
    
	  static WebDriver driver;
	
	
	@BeforeClass
	public void launchBrowser() {
		
		System.out.println("Before Class");
		
		
		System.setProperty("webdriver.chrome.driver","F:\\selenium_files\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
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
		js.executeScript("window.scrollBy(0,400)");
		
		SearchResultPageAmazon searchResultPageAmazon = new SearchResultPageAmazon(driver);
		searchResultPageAmazon.clickOn2ndResult();
		
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
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
		System.out.println("Test - 1");
		
		String url = driver.getCurrentUrl();
		String actualURL = "https://www.amazon.in/gp/cart/view.html?ref_=nav_cart";
		if(url.equals(actualURL)) {
			System.out.println("PASSED");
		}
		else {
			System.out.println("FAILED");
		}
	}
	
	@Test (priority = 2,enabled =true)
	public void verifyTitleOfCartPage() {
		System.out.println("Test - 2");
		
		String title = driver.getTitle();
		String actualTitle = "Amazon.in Shopping Cart";
		if(title.equals(actualTitle)) {
			System.out.println("PASSED");
		}
		else {
			System.out.println("FAILED");
		}
	}
	
	@Test (priority = 3,enabled =true)
	public void verifyItemAddedToCart() throws InterruptedException {
		System.out.println("Test - 3");
		
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
	
	
	@Test (priority=1,enabled =true)
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
	public void backToHomePage() {
		System.out.println("After Method");
		
		driver.navigate().back();
        driver.navigate().back();
	}
	@AfterClass
	public void clearPOMobjects() {
		System.out.println("After Class");
		
		driver.quit();
	}
	
	
}
