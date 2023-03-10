package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPageAmazon {

	//Variables
	private WebDriver driver;
	private Actions act;
	
	@FindBy (xpath = "(//div[@cel_widget_id='MAIN-SEARCH_RESULTS-2']//span)[11]")
	private WebElement searchResult2;
	
	@FindBy (xpath = "//div[@id='nav-cart-text-container']")
	private WebElement cartIcon;
	
	
	//Constructor
	public SearchResultPageAmazon(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		act = new Actions(driver);
	}
	
	
	
	
	
	//Methods
	public void clickOn2ndResult() {
		//Actions act = new Actions(driver);
		act.moveToElement(searchResult2).click().build().perform();
	}
	
	public void clickOnCartIcon(WebDriver driver) {
		//Actions act2 = new Actions(driver);
		act.moveToElement(cartIcon).click().build().perform();
	}
}
