package com.openCart.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.openCart.Base.Base;
import com.openCart.Utils.Utility;
import com.openCart.pages.AccountPage;
import com.openCart.pages.AccountSuccessPage;
import com.openCart.pages.HomePage;
import com.openCart.pages.LoginPage;
import com.openCart.pages.NewsletterPage;
import com.openCart.pages.RegisterPage;

public class Register extends Base {

	WebDriver driver;

	RegisterPage registerPage;

	HomePage homePage;

	AccountSuccessPage accountSuccessPage;

	AccountPage accountPage;

	NewsletterPage newsLetterPage;

	LoginPage loginPage;

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

		accountSuccessPage = registerPage.enterAndSubmitAllMandatoryField(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), Utility.randomEmailString(), dataProp.getProperty("telephoneNumber"),
				dataProp.getProperty("password"));

		Assert.assertEquals(accountSuccessPage.accountSuccessHeadingText(),
				dataProp.getProperty("accountSuccessfullyCreatedHeading"));

	}

	@Test(priority = 3)
	public void TC_RF_003() {

		registerPage = homePage.navigateToRegister();
		accountSuccessPage = registerPage.enterAndSubmitAllField(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), Utility.randomEmailString(), dataProp.getProperty("telephoneNumber"),
				dataProp.getProperty("password"));

		Assert.assertEquals(accountSuccessPage.accountSuccessHeadingText(),
				dataProp.getProperty("accountSuccessfullyCreatedHeading"));

		accountPage = accountSuccessPage.clickOnContinueButton();

		Assert.assertTrue(accountPage.displayStatusOfEditYourAccount());

	}

	@Test(priority = 4)
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

	@Test(priority = 5)
	public void TC_RF_005() {

		registerPage = homePage.navigateToRegister();
		accountSuccessPage = registerPage.enterAndSubmitAllField(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), Utility.randomEmailString(), dataProp.getProperty("telephoneNumber"),
				dataProp.getProperty("password"));

		Assert.assertEquals(accountSuccessPage.accountSuccessHeadingText(),
				dataProp.getProperty("accountSuccessfullyCreatedHeading"));

		accountPage = accountSuccessPage.clickOnContinueButton();

		Assert.assertTrue(accountPage.displayStatusOfEditYourAccount());

		newsLetterPage = accountPage.clickSubUnsubToNewsletterLink();

		Assert.assertTrue(newsLetterPage.verifyYesStatusOfRadioButton(), "Radio Button verification failed");

	}

	@Test(priority = 6)
	public void TC_RF_006() {

		registerPage = homePage.navigateToRegister();
		accountSuccessPage = registerPage.enterAndSubmitAllFieldWithNoRadioButton(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), Utility.randomEmailString(), dataProp.getProperty("telephoneNumber"),
				dataProp.getProperty("password"));

		Assert.assertEquals(accountSuccessPage.accountSuccessHeadingText(),
				dataProp.getProperty("accountSuccessfullyCreatedHeading"));

		accountPage = accountSuccessPage.clickOnContinueButton();

		Assert.assertTrue(accountPage.displayStatusOfEditYourAccount());

		newsLetterPage = accountPage.clickSubUnsubToNewsletterLink();

		Assert.assertTrue(newsLetterPage.verifyNoStatusOfRadioButton(), "Radio Button verification failed");

	}

	@Test(priority = 7)
	public void TC_RF_007() {

		registerPage = homePage.navigateToRegister();

		Assert.assertTrue(registerPage.displayStatusOfRegisterAccountHeading(),
				"Account Heading is not displayed, User is not at Account Register Page");

		loginPage = homePage.navigateToLogin();

		loginPage.clickContinueButton();

		Assert.assertTrue(registerPage.displayStatusOfRegisterAccountHeading(),
				"Account Heading is not displayed, User is not at Account Register Page");

		homePage.navigateToLogin();

		loginPage.clickRegisterLink();

		Assert.assertTrue(registerPage.displayStatusOfRegisterAccountHeading(),
				"Account Heading is not displayed, User is not at Account Register Page");

	}

	@Test(priority = 8)
	public void TC_RF_008() {

		registerPage = homePage.navigateToRegister();

		registerPage.enterAndSubmitAllField(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				Utility.randomEmailString(), dataProp.getProperty("telephoneNumber"), prop.getProperty("validPassword"),
				dataProp.getProperty("invalidPassword"));

		try {
			registerPage.displayStatusOfPasswordDoesNotMatchWarningMessage();
		} catch (Exception e) {
			Assert.fail("Validation of Password does not match warning message is Failed");
		}

	}

	@Test
	public void TC_RF_009() {
		registerPage = homePage.navigateToRegister();

		registerPage.enterAndSubmitAllField(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				prop.getProperty("validEmail"), dataProp.getProperty("telephoneNumber"),
				prop.getProperty("validPassword"), prop.getProperty("validPassword"));

		try {
			registerPage.displayStatusOfEmailIsAlreadyRegisteredWarningMessage();

		} catch (Exception e) {
			Assert.fail("Validation of  E-Mail Address is already registered! messaged Failed");
		}

	}
	
	//@Test
	public void TC_RF_010() {
		registerPage = homePage.navigateToRegister();
		
		
		registerPage.enterAndSubmitAllField(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"),
				"pavanol", dataProp.getProperty("telephoneNumber"),
				prop.getProperty("validPassword"), prop.getProperty("validPassword"));

		
		
	}

}
