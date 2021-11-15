package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase{

	public CartPage(WebDriver driver) {
		super(driver);

	}
	/**** locators ****/
	@FindBy(xpath="//span[@class='title']")
	WebElement UserCartTitleTxt;

	@FindBy(xpath="//button[@id='checkout']")
	WebElement CheckoutButton;

	/**** methods and actions ****/

	public String getUserCartTitleTxt() {
		return UserCartTitleTxt.getText();
	}
	public void checkoutTheProduct() {
		clickButton(CheckoutButton);
	}
}
