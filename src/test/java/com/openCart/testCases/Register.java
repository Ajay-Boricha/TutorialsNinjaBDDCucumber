package com.openCart.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.openCart.Base.Base;
import com.openCart.Utils.Utility;
import com.openCart.pages.HomePage;
import com.openCart.pages.RegisterPage;

public class Register extends Base {

	WebDriver driver;

	RegisterPage registerPage;

	HomePage homePage;

	public Register() {
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
	public void TC_RF_001() {

		registerPage = homePage.navigateToRegister();

		registerPage.enterAndSubmitAllMandatoryField(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), Utility.randomEmailString(), dataProp.getProperty("telephoneNumber"),
				dataProp.getProperty("password"));

		Assert.assertEquals(registerPage.accountSuccessHeadingText(),
				dataProp.getProperty("accountSuccessfullyCreatedHeading"));

	}

	@Test(priority = 2)
	public void TC_RF_004() {

		registerPage = homePage.navigateToRegister();

		registerPage.clickOnContinueButton();

		Assert.assertEquals(registerPage.privacyPolicyWarningMessageText(),
				dataProp.getProperty("privacyPolicyWarningMessageWarning"));

		Assert.assertEquals(registerPage.firstNameWarningMessageText(),
				dataProp.getProperty("firstNameWarningMessage"));

		Assert.assertEquals(registerPage.lastNameWarningMessageText(), dataProp.getProperty("lastNameWarningMesage"));

		Assert.assertEquals(registerPage.emailWarningMessageText(), dataProp.getProperty("emailWarningMessage"));

		Assert.assertEquals(registerPage.telephoneWarningMessageText(),
				dataProp.getProperty("telephoneNumberWarningMessage"));

		Assert.assertEquals(registerPage.passwordWarningMessageText(), dataProp.getProperty("passwordWarningMessage"));

	}

}
