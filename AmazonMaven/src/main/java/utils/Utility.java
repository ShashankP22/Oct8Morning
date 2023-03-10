package utils;

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
import org.openqa.selenium.io.FileHandler;



public class Utility {

	//method to capture screenshot
	public static void captureScreenshot(WebDriver driver,String TestID) throws IOException {
		
		TakesScreenshot t = (TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date date = new Date();
		
	
		String display = dateFormat.format(date);
		

		
//		String arr [] = display.split(" ");
//		String datePrint = arr[0];
//		String timePrint = arr[1];
//		
//		File dest = new File("test-output/FailedTestsScreenshots/"
//                +TestID+"(Date(dd-mm-yyyy) "
//	             +datePrint+" Time(hr-min-sec) "
//                +timePrint+").png");
		
//		File dest = new File("F:\\Softwre Testing\\Automation\\Rough folder\\Selenium SS\\"+ TestID+"("+display+").png" );
		File dest = new File("test-output/FailedTestsScreenshots/"+TestID+"("+display+").png" );

        FileHandler.copy(src, dest);
		
	}
	
	
	
	//method to fetch data from excel
	public static String getDataFromExcel(String sheetName,int row,int column) throws EncryptedDocumentException, IOException {
		
		String data;
		
		String path = "F:\\\\Softwre Testing\\\\Automation\\\\Rough folder\\\\SeleniumDataPractice.xlsx";
		FileInputStream file = new FileInputStream(path);
		
		
		try {
	
			 data = WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		}
		catch(IllegalStateException e) {
			String path2 = "F:\\\\Softwre Testing\\\\Automation\\\\Rough folder\\\\SeleniumDataPractice.xlsx";
			FileInputStream file2 = new FileInputStream(path2);
			double data2 = WorkbookFactory.create(file2).getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
			
		
			//data = String.valueOf(data2);
			//data = ""+data2;
			data = Double.toString(data2);
			
		}
		
		
		return data;
	}
	
	
	
	//Write method to fetch html table data.Return type will be collection
	

	
	
}
