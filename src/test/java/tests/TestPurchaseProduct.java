package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.CartPage;
import pages.CheckoutInformationPage;
import pages.CheckoutOverviewPage;
import pages.LoginPage;
import pages.ProductsPage;



public class TestPurchaseProduct extends TestBase{

	//***** variables *****// 
	LoginPage loginPageObject;
	ProductsPage productPageObject;
	CartPage cartPageObject;
	CheckoutInformationPage checkoutInfoPageObject;
	CheckoutOverviewPage checkoutOverviewPageObject;
	JsonDataReader jsonReader = new JsonDataReader(); 




	//***** methods *****//
	@Test(priority=1,alwaysRun=true,description = "User login with valid data in sauceDemo website")

	public void UserCanLoginSuccssfully() throws Exception 
	{

		jsonReader.JsonReaderMethod();

		loginPageObject = new LoginPage(driver); 
		productPageObject=new ProductsPage(driver);

		loginPageObject.UserLogin(jsonReader.UserName,jsonReader.Password);

		Assert.assertEquals(productPageObject.ProductPageTitleText(), "PRODUCTS");
	}


	@Test(priority=2,dependsOnMethods ="UserCanLoginSuccssfully", description = "User adds product to his cart")
	public void UserCanAddProductsTOCart(){

		productPageObject=new ProductsPage(driver);
		cartPageObject=new CartPage(driver);
		productPageObject.addProductToCart();

		Assert.assertEquals(cartPageObject.getUserCartTitleTxt(), "YOUR CART");

	}

	@Test(priority=3,dependsOnMethods="UserCanAddProductsTOCart",description = "User checkout the product ")
	public void UserCheckoutProduct(){

		cartPageObject=new CartPage(driver);
		checkoutInfoPageObject=new CheckoutInformationPage(driver);

		cartPageObject.checkoutTheProduct();
		Assert.assertEquals(checkoutInfoPageObject.getCheckoutInfoTitleTxt(), "CHECKOUT: YOUR INFORMATION");

	}

	@Test(priority=4, dependsOnMethods = "UserCheckoutProduct",description = "User fills his data into checkout form (fname,...)")
	public void userFillCheckoutInfo(){
		checkoutInfoPageObject=new CheckoutInformationPage(driver);
		checkoutOverviewPageObject= new CheckoutOverviewPage(driver);

		checkoutInfoPageObject.fillCheckutInfomation(jsonReader.firstName,jsonReader.lastName,jsonReader.postalCode);
		Assert.assertEquals(checkoutOverviewPageObject.getCheckoutOverviewTitletxt(), "CHECKOUT: OVERVIEW");
	}


	@Test(priority=5,dependsOnMethods="userFillCheckoutInfo",description = "User submits his order")
	public void userFinsihCheckoutProcess(){

		checkoutOverviewPageObject= new CheckoutOverviewPage(driver);
		checkoutOverviewPageObject.finishCheckoutProcess();
		assertEquals(checkoutOverviewPageObject.getThanksMessage(), "THANK YOU FOR YOUR ORDER");

	}







}
