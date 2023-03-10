package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	
	
	public static WebDriver openChromeBrowser() {
		//System.setProperty("webdriver.chrome.driver","F:\\selenium_files\\chromedriver_win32\\chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver","src/test/resources/browserFiles/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		return driver;
		
	}
	
	
	
	public static WebDriver openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver","src/test/resources/browserFiles/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
		
	}
	
}
