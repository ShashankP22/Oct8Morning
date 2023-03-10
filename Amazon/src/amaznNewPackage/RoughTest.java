package amaznNewPackage;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;


public class RoughTest {

	public static void main(String[] args) throws EncryptedDocumentException, InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver","F:\\selenium_files\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/r.php?locale=en_GB&display=page");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Thread.sleep(3000);
		
		String path = "F:\\Softwre Testing\\Automation\\Rough folder\\SeleniumDataPractice.xlsx";
		FileInputStream file = new FileInputStream(path);
		String testCaseName = WorkbookFactory.create(file).getSheet("TestCasesRBI").getRow(1).getCell(1).getStringCellValue();
		
		
		TakesScreenshot t = (TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();
		String display = dateFormat.format(date);
		String arr [] = display.split(" ");
		String datePrint = arr[0];
		String timePrint = arr[1];
		
		
		
		File dest = new File("F:\\Softwre Testing\\Automation\\Rough folder\\Selenium SS\\"
		                     +testCaseName+"(Date(dd-mm-yyyy) "
				             +datePrint+" Time(hrs-min-sec) "
		                     +timePrint+").png");
		FileHandler.copy(src, dest);
		
		driver.quit();

		
		
//===============================================================================================================
		//Google meet functionality automate
		
//		System.setProperty("webdriver.chrome.driver","F:\\selenium_files\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://meet.google.com/");
//		driver.manage().window().maximize();
//		
//		Thread.sleep(3000);
//		WebElement selectLanguage = driver.findElement(By.xpath("//select[@name='lang-selector']"));
//		
//		JavascriptExecutor js = (JavascriptExecutor)driver ;
//		js.executeScript("arguments[0].scrollIntoView(true);",selectLanguage);
//		
//		Thread.sleep(3000);
//		Select drpLanguageSelect= new Select(driver.findElement(By.name("lang-selector")));
////		drpLanguageSelect.selectByVisibleText("अंग्रेज़ी (अमेरिका) - English (United States)");
////		drpLanguageSelect.selectByIndex(10);
//		drpLanguageSelect.selectByValue("/intl/en/meet/");
//		
//		Thread.sleep(3000);
//
//		
//		
//		
//		WebElement enterCode = driver.findElement(By.xpath("(//input[@placeholder='Enter meeting code'])[2]"));
//		enterCode.sendKeys("tobantfjqa");
//		
//		Thread.sleep(3000);
//		
//		WebElement joinButton = driver.findElement(By.xpath("(//span[@class='cta_text'])[4]"));
//		joinButton.click();
//		
//		
//		Thread.sleep(3000);
//		
//				
//		WebElement micButton = driver.findElement(By.xpath("(//div[@role='button'])[1]"));
//		Actions act = new Actions(driver);
//		act.moveToElement(micButton).click().build().perform();
//		
//		
//		
//		WebElement cameraButton = driver.findElement(By.xpath("(//div[@role='button'])[2]"));
//		Actions act2 = new Actions(driver);
//		act2.moveToElement(cameraButton).click().build().perform();
//		
//		
//		
//		WebElement joinButton2 = driver.findElement(By.xpath("//span[text()='Join now']"));
//		joinButton2.click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
		
		
	
}
