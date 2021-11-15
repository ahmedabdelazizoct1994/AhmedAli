package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage  extends PageBase{

	public CheckoutOverviewPage(WebDriver driver) {
		super(driver);


	}


	/**** locators ****/
	@FindBy(xpath="//span[@class='title']")
	WebElement checkoutOverviewTitleTxt;
	@FindBy(xpath="//button[@id='finish']")
	WebElement finishButton;
	@FindBy(xpath="//*[ contains (text(), 'THANK YOU FOR YOUR ORDER' ) ]")
	private WebElement thanksMessage;


	/**** methods and actions ****/
	public String getCheckoutOverviewTitletxt() {
		return checkoutOverviewTitleTxt.getText();
	}
	public void finishCheckoutProcess() {
		clickButton(finishButton);
	}
	public String getThanksMessage() {
		return thanksMessage.getText();
	}

}
