package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutInformationPage extends PageBase{

	public CheckoutInformationPage(WebDriver driver) {
		super(driver);

	}

	/**** locators ****/
	@FindBy(xpath="//span[@class='title']")
	WebElement CheckoutInformationTitleTxt;
	@FindBy(xpath="//input[@id='first-name']")
	WebElement firstNameTxtbox;
	@FindBy(xpath="//input[@id='last-name']")
	WebElement lastNameTxtbox;
	@FindBy(xpath="//input[@id='postal-code']")
	WebElement postalCodeTxtBox;
	@FindBy(xpath="//input[@id='continue']")
	WebElement continueButton;


	/**** methods and actions ****/
	public String getCheckoutInfoTitleTxt() {
		return CheckoutInformationTitleTxt.getText();


	}

	public void fillCheckutInfomation(String fname,String lname,String postalCode) {
		setTextElementText(firstNameTxtbox,fname);
		setTextElementText(lastNameTxtbox, lname);
		setTextElementText(postalCodeTxtBox, postalCode);
		clickButton(continueButton);
	}

}
