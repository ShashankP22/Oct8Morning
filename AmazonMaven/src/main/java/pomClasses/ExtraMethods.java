package pomClasses;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExtraMethods {
    //Variables
	private WebDriverWait wait;
	private JavascriptExecutor js;
	
	//Constructor
	public ExtraMethods(WebDriver driver) {
		wait = new WebDriverWait(driver,5);
		js = (JavascriptExecutor)driver;
	}
	
	
	//Methods
	public void applyExplicitWait(WebElement webElement) {
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	public void scrollDownBy100() {
		js.executeScript("window.scrollBy(0,100)");
	}
	
	public void scrollUpBy100() {
		js.executeScript("window.scrollBy(0,-100)");
	}
	
	public void scrollRightBy100() {
		js.executeScript("window.scrollBy(100,0)");
	}
	
	public void scrollLeftBy100() {
		js.executeScript("window.scrollBy(-100,0)");
	}
	

	
}
