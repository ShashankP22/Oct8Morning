package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPageAmazon {

	//Variables
	private WebDriver driver;
	
	@FindBy (xpath = "//input[@id='add-to-cart-button']")
	private WebElement addToCartButton;
	
	
	
	
	
	//Constructor
	public AddToCartPageAmazon(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	
	
	
	//Methods
	public void clickAddToCartButton() {
		addToCartButton.click();
	}
}
