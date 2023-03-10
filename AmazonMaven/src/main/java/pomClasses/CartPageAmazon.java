package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPageAmazon {

	//Variables
	    private WebDriver driver;
	
		@FindBy (xpath = "(//span[@class='a-declarative'])[2]//input")
		private WebElement deleteItemButton ;
		
		@FindBy (xpath = "//input[@value='Delete']")
		private WebElement deleteItemButton2 ;
		
		@FindBy (xpath = "//h1[contains(text(),'Your Amazon Cart ')]")
		private WebElement cartEmptyText ;
		


	//Constructor
	public CartPageAmazon(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}	
		
	
	
	//Methods
	public boolean deleteItemButtonStatus() {
		boolean result = deleteItemButton.isDisplayed();
		return result;
	}
	
	public void clickDeleteButton() {
		deleteItemButton2.click();
	}
	
	
	public String getEmptyCartMsgText() {
		String text = cartEmptyText.getText();
		return text;
	}
}

