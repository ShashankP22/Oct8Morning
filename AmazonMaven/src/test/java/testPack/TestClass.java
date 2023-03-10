package testPack;



import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.AddToCartPageAmazon;
import pomClasses.CartPageAmazon;

import pomClasses.MainPageAmazon;
import pomClasses.SearchResultPageAmazon;
import utils.Utility;

public class TestClass extends Utility{
	
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
	
		
		System.out.println("Hello");
		
		System.setProperty("webdriver.chrome.driver","F:\\selenium_files\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		//Object declaration of all pom classes
		MainPageAmazon mainPageAmazon = new MainPageAmazon(driver);
        SearchResultPageAmazon searchResultPageAmazon = new SearchResultPageAmazon(driver);
		AddToCartPageAmazon addToCartPageAmazon = new AddToCartPageAmazon(driver);
		CartPageAmazon cartPageAmazon = new CartPageAmazon(driver);



		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		//========================================================================================
		
		mainPageAmazon.searchForProduct("mobile");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		
//		ExtraMethods extraMethods = new ExtraMethods(driver); 
//		extraMethods.scrollDownBy100();
//		extraMethods.scrollDownBy100();
//		extraMethods.scrollDownBy100();
		Thread.sleep(4000);
//		extraMethods.scrollUpBy100();
//		extraMethods.scrollUpBy100();
		
		//========================================================================================
		searchResultPageAmazon.clickOn2ndResult();
		
		//Switching to New tab opened
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		//========================================================================================
		addToCartPageAmazon.clickAddToCartButton();
		Thread.sleep(2000);
		
		driver.close();
		Thread.sleep(3000);
		driver.switchTo().window(addr.get(0));
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		searchResultPageAmazon.clickOnCartIcon(driver);
		//========================================================================================
		//To verify url of shopping cart page
		String url = driver.getCurrentUrl();
		String actualURL = "https://www.amazon.in/gp/cart/view.html?ref_=nav_cart";
		if(url.equals(actualURL)) {
			System.out.println("URL matched");
		}
		else {
			System.out.println("URL not matched");
		}
		//========================================================================================
		//To verify title of shopping cart page
		String title = driver.getTitle();
		String actualTitle = "Amazon.in Shopping Cart";
		if(title.equals(actualTitle)) {
			System.out.println("Title matched");
		}
		else {
			System.out.println("Title not matched");
		}
		//========================================================================================
		//To verify item is getting added to cart
		Thread.sleep(3000);
		boolean result = cartPageAmazon.deleteItemButtonStatus();
		
		if(result) {
			System.out.println("Item is getting added to cart");
		}
		else {
			System.out.println("Item is not getting added to cart");
				
		}
		//========================================================================================
		//To verify item is getting deleted or not
		Thread.sleep(3000);
		
		cartPageAmazon.clickDeleteButton();
		Thread.sleep(2000);
		
		String actualText = cartPageAmazon.getEmptyCartMsgText();
		String expectedText = "Your Amazon Cart is empty.";
		if(actualText.equals(expectedText)) {
			System.out.println("Item getting deleted succesfully");
		}
		else {
			System.out.println("Item not getting deleted .....!!!");
				
		}
		//========================================================================================

		driver.navigate().back();
        driver.navigate().back();
		
		driver.quit();
		
//		String data = Utility.getDataFromExcel("Sheet1", 5, 0);
//		System.out.println(data);
		
		




		
		
		
}
}
