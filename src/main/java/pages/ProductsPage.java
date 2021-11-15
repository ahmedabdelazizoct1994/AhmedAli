package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends PageBase {



	public ProductsPage(WebDriver driver) {
		super(driver);

	}
	/**** locators ****/

	@FindBy(xpath="//span[@class='title']")
	private WebElement ProductPageTitle ;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement addToCart;


	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement shoppingCartIcon;


	/**** methods and actions ****/

	public String ProductPageTitleText() {
		return ProductPageTitle.getText();

	}
	public void addProductToCart() {

		clickButton(addToCart);
		clickButton(shoppingCartIcon);
	}


}



