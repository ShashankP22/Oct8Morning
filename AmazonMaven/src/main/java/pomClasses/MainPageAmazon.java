package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageAmazon {

	//Variables
	private WebDriver driver;
	
	@FindBy (xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchBar;
	
	@FindBy (xpath = "//input[@id='nav-search-submit-button']")
	private WebElement searchIconClick;
	
	
	
	//Constructor
	public MainPageAmazon(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	
	
	
	//Methods
	public void searchForProduct(String productText) {
		searchBar.click();
		searchBar.sendKeys(productText);
		searchIconClick.click();
	}
	
	
	
}
