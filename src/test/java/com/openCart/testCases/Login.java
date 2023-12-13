package com.openCart.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.openCart.Base.Base;
import com.openCart.Utils.Utility;
import com.openCart.pages.AccountPage;
import com.openCart.pages.ForgottenPasswordPage;
import com.openCart.pages.HomePage;
import com.openCart.pages.LoginPage;

public class Login extends Base {

	WebDriver driver;

	HomePage homePage;

	LoginPage loginPage;
	
	AccountPage accountPage;
	

	public Login() {
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

	@Test(priority = 1, dataProvider = "testData")
	public void TC_LF_001(String email, String password) {

		loginPage = homePage.navigateToLogin();

		accountPage = loginPage.login(email, password);

		Assert.assertTrue(accountPage.displayStatusOfEditYourAccount(),
				"Edit your account information is not displayed");

	}

	@Test(priority = 2)
	public void TC_LF_002() {

		loginPage = homePage.navigateToLogin();

		loginPage.login(Utility.randomEmailString(), dataProp.getProperty("invalidPassword"));

		Assert.assertEquals(loginPage.noMatchForEmailAndPasswordText(),
				dataProp.getProperty("emailPasswordNoMatchwarningmessage"),
				"Expected Warning Message is not displayed");

	}

	@Test(priority = 3)
	public void TC_LF_003() {

		loginPage = homePage.navigateToLogin();

		loginPage.login(dataProp.getProperty("invalidEmail"), prop.getProperty("validPassword"));

		Assert.assertEquals(loginPage.noMatchForEmailAndPasswordText(),
				dataProp.getProperty("emailPasswordNoMatchwarningmessage"),
				"Expected Warning Message is not displayed");

	}

	@Test(priority = 4)
	public void TC_LF_004() {

		loginPage = homePage.navigateToLogin();

		loginPage.login(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));

		Assert.assertEquals(loginPage.noMatchForEmailAndPasswordText(),
				dataProp.getProperty("emailPasswordNoMatchwarningmessage"),
				"Expected Warning Message is not displayed");
	}

	@Test(priority=5)
	public void TC_LF_005() {

		loginPage = homePage.navigateToLogin();

		loginPage.clickOnLoginButton();

		Assert.assertEquals(loginPage.noMatchForEmailAndPasswordText(),
				dataProp.getProperty("emailPasswordNoMatchwarningmessage"),
				"Expected Warning Message is not displayed");

	}

	@Test(priority=6)
	public void TC_LF_006() {
		
		loginPage = homePage.navigateToLogin();

		Assert.assertTrue(loginPage.displayStatusOfForgottenPasswordOption());

		ForgottenPasswordPage forgottenPasswordPage =loginPage.clickOnForgottenPasswordOption();

		Assert.assertTrue(forgottenPasswordPage.displayStatusOfForgotYourPasswordHeading());

	}

	@Test(priority=7)
	public void TC_LF_008() {

		loginPage = homePage.navigateToLogin();

		Assert.assertEquals(loginPage.emailPlaceHolderType(), "E-Mail Address",
				"Email Address place holder is mis match");
		Assert.assertEquals(loginPage.passwordPlaceHolderType(), "Password", "Password place holder is mis match");
	}

	@Test(priority=8)
	public void TC_LF_013() throws InterruptedException {

		loginPage = homePage.navigateToLogin();

		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));

		Assert.assertEquals(loginPage.checkPasswordFieldType(), "password");

	}

	@DataProvider(name = "testData")
	public Object testData() {

		Object[][] data = { { "bajay1@gmail.com", "12345" }, { "bajay2@gmail.com", "123456" },
				{ "bajay3@gmail.com", "123456" } };

		return data;

	}

}
