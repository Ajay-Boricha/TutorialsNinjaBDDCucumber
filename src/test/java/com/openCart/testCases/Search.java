package com.openCart.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.openCart.Base.Base;
import com.openCart.pages.HomePage;

public class Search extends Base {

	WebDriver driver;

	HomePage homePage;

	public Search() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		driver = initializeBrowserWithURL(prop.getProperty("browserName"));

		homePage = new HomePage(driver);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void TC_SF_001() {

		homePage.enterSearch("iMac");
		homePage.clickOnSearchButton();

		Assert.assertTrue(homePage.displayStatusOfValidProduct(), "valid search product is not displayed");

	}

	@Test
	public void TC_SF_002() {

		homePage.enterSearch("Fitbit");
		homePage.clickOnSearchButton();

		Assert.assertEquals(homePage.noProductThatMatchTheCriteriaText(),
				"There is no product that matches the search criteria.", "Expected product message is not displayed");

	}

}
