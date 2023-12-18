package com.openCart.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.openCart.Base.Base;
import com.openCart.pages.HomePage;
import com.openCart.pages.LoginPage;
import com.openCart.pages.MyWishListPage;
import com.openCart.pages.ProductDisplayPage;
import com.openCart.pages.ShoppingCartPage;

public class AddToCart extends Base {

	public WebDriver driver;

	HomePage homePage;

	public AddToCart() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		driver = initializeBrowserWithURL("firefox");
		homePage = new HomePage(driver);
	}

	@AfterMethod
	public void tearDown() {

		// driver.quit();
	}

	@Test(priority = 1)
	public void TC_ATC_001() {

		ProductDisplayPage productDisplay = homePage.enterSearchAndClickOnSearchButton("iMac");

		productDisplay.addToCartOption();

		Assert.assertTrue(productDisplay.displayStatusOfAddedProductToCartsuccessMessage(),
				"Validation of Added Product To Cart Success Message Failed");

		ShoppingCartPage shoppingCartPage = productDisplay.clickShoppingCartLinkInSuccessMessage();

		Assert.assertTrue(shoppingCartPage.displayStatusOfAddedToCartProduct(),
				"Validation of Product that is in shopping cart Failed");

	}

	@Test(priority = 2)
	public void TC_ATC_002() {

		LoginPage loginPage = homePage.navigateToLogin();

		loginPage.login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));

		ProductDisplayPage productDisplay = homePage.enterSearchAndClickOnSearchButton("iMac");

		productDisplay.clickAddToWishList();

		MyWishListPage myWishList = homePage.clickWishListOption();

		myWishList.clickAddToCartButton();

		Assert.assertTrue(productDisplay.displayStatusOfAddedProductToCartsuccessMessage(),
				"Validation of Added Product To Cart Success Message Failed");

		ShoppingCartPage shoppingCartPage = homePage.clickShoppingCartOption();

		Assert.assertTrue(shoppingCartPage.displayStatusOfAddedToCartProduct(),
				"Validation of Product that is in shopping cart Failed");

	}

	@Test(priority = 3)
	public void TC_ATC_003() {

		ProductDisplayPage productDisplay = homePage.enterSearchAndClickOnSearchButton("iMac");

		productDisplay.addToCartOption();

		Assert.assertTrue(productDisplay.displayStatusOfAddedProductToCartsuccessMessage(),
				"Validation of Added Product To Cart Success Message Failed");

		homePage.clickBlackCartButton();
		ShoppingCartPage shoppingCartPage = homePage.clickViewCartOptionInPopUp();

		Assert.assertTrue(shoppingCartPage.displayStatusOfAddedToCartProduct(),
				"Validation of Product that is in shopping cart Failed");

	}

	@Test(priority = 4)
	public void TC_ATC_004() {

		ProductDisplayPage productDisplay = homePage.enterSearchAndClickOnSearchButton("Apple Cinema 30");
		productDisplay.clickProductLink();

		productDisplay.clickAddToCartatRelatedProductOption();

		Assert.assertTrue(productDisplay.displayStatusOfAddedProductToCartsuccessMessage(),
				"Validation of Added Product To Cart Success Message Failed");

		ShoppingCartPage shoppingCartPage = productDisplay.clickShoppingCartLinkInSuccessMessage();

		Assert.assertTrue(shoppingCartPage.displayStatusOfAddedToCartProduct(),
				"Validation of Product that is in shopping cart Failed");
	}

}
