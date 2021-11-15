package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {



	protected WebDriver drvier ; 


	// create constructor 
	public PageBase(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}


//common methods will be used more than once
	protected static void clickButton(WebElement button) 
	{
		button.click();
	}

	protected static void setTextElementText(WebElement textElement , String value) 
	{
		textElement.sendKeys(value);
	}

}
