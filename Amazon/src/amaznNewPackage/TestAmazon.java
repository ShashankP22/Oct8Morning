package amaznNewPackage;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestAmazon {

	
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","F:\\selenium_files\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		
		//Main page
		WebElement searchBar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBar.click();
		searchBar.sendKeys("mobile phone");
		searchBar.clear();
		searchBar.sendKeys("mobile");
		
		WebElement searchIconClick = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchIconClick.click();
		
		//===================================================================================================
		//Search Result Page
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		
		
		WebElement searchResult2 = driver.findElement(By.xpath("(//div[@cel_widget_id='MAIN-SEARCH_RESULTS-2']//span)[11]"));
		Actions act = new Actions(driver);
		act.moveToElement(searchResult2).click().build().perform();
		
		//Switching to New tab opened
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		//===================================================================================================
		//Add to cart Page
		WebElement addToCartButton = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		addToCartButton.click();
		Thread.sleep(2000);
		
		driver.close();
		Thread.sleep(3000);
		driver.switchTo().window(addr.get(0));
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		
	
		//Click on cart icon
		WebElement cartIcon = driver.findElement(By.xpath("//div[@id='nav-cart-text-container']"));
		Actions act2 = new Actions(driver);
		act2.moveToElement(cartIcon).click().build().perform();
		
		
		//To verify url of shopping cart page
		String url = driver.getCurrentUrl();
		String actualURL = "https://www.amazon.in/gp/cart/view.html?ref_=nav_cart";
		if(url.equals(actualURL)) {
			System.out.println("URL matched");
		}
		else {
			System.out.println("URL not matched");
		}
		
		
		//To verify title of shopping cart page
		String title = driver.getTitle();
		String actualTitle = "Amazon.in Shopping Cart";
		if(title.equals(actualTitle)) {
			System.out.println("Title matched");
		}
		else {
			System.out.println("Title not matched");
		}
		
		
		//To verify item is getting added to cart
        Thread.sleep(3000);
		WebElement deleteItemButton = driver.findElement(By.xpath("(//span[@class='a-declarative'])[2]//input"));
		boolean result = deleteItemButton.isDisplayed();
		
		if(result) {
			System.out.println("Item is getting added to cart");
		}
		else {
			System.out.println("Item is not getting added to cart");
				
		}
		
		//To verify item is getting deleted or not
		Thread.sleep(3000);
		WebElement deleteItemButton2 = driver.findElement(By.xpath("//input[@value='Delete']"));
		deleteItemButton2.click();
		Thread.sleep(2000);
		
		WebElement cartEmptyText = driver.findElement(By.xpath("//h1[contains(text(),'Your Amazon Cart ')]"));
		String text = cartEmptyText.getText();
		String expectedText = "Your Amazon Cart is empty.";
		if(text.equals(expectedText)) {
			System.out.println("Item getting deleted succesfully");
		}
		else {
			System.out.println("Item not getting deleted .....!!!");
				
		}
		
		
		
		//Back to main page
		
		driver.navigate().back();
        driver.navigate().back();
		
		
		
		
		
	
		
		driver.quit();
		
		
		
		
		
		
		
}
}
