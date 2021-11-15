package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase
{
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	/**** locators ****/
	@FindBy(xpath="//input[@id='user-name']")
	WebElement UserNameTxtBox ; 

	@FindBy(xpath="//input[@id='password']")
	WebElement passwordTxtBox ; 

	@FindBy(xpath="//input[@id='login-button']")
	WebElement loginBtn ; 

	/**** methods and actions ****/
	public void UserLogin(String UserName , String password) 
	{
		setTextElementText(UserNameTxtBox, UserName);
		setTextElementText(passwordTxtBox, password);
		clickButton(loginBtn);
	}
}
