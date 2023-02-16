package amaznNewPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class RoughTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","F:\\selenium_files\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/r.php?locale=en_GB&display=page");
		
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
		
		
		
	}
		
		
	
}
