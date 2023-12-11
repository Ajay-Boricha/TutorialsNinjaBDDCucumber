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

	public Login() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		driver = initializeBrowserWithURL(prop.getProperty("browserName"));
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

	@Test(priority = 1, dataProvider= "testData")
	public void TC_LF_001(String email, String password) {

		homePage = new HomePage(driver);
		homePage.navigateToLogin();

		LoginPage loginPage = new LoginPage(driver);
		
		//loginPage.enterEmail(prop.getProperty("validEmail"));
		//loginPage.enterPassword(prop.getProperty("validPassword"));
		
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		
		loginPage.clickOnLoginButton();

		AccountPage accountPage = new AccountPage(driver);

		Assert.assertTrue(accountPage.displayStatusOfEditYourAccount(),
				"Edit your account information is not displayed");

	}

	@Test(priority = 2)
	public void TC_LF_002() {

		homePage = new HomePage(driver);
		homePage.navigateToLogin();

		loginPage = new LoginPage(driver);
		loginPage.enterEmail(Utility.randomEmailString());
		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();

		Assert.assertEquals(loginPage.noMatchForEmailAndPasswordText(),
				dataProp.getProperty("emailPasswordNoMatchwarningmessage"),
				"Expected Warning Message is not displayed");

	}

	@Test(priority = 3)
	public void TC_LF_003() {

		homePage = new HomePage(driver);
		homePage.navigateToLogin();

		loginPage = new LoginPage(driver);
		loginPage.enterEmail(dataProp.getProperty("invalidEmail"));
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();

		Assert.assertEquals(loginPage.noMatchForEmailAndPasswordText(),
				dataProp.getProperty("emailPasswordNoMatchwarningmessage"),
				"Expected Warning Message is not displayed");

	}

	@Test(priority = 4)
	public void TC_LF_004() {

		homePage = new HomePage(driver);
		homePage.navigateToLogin();

		loginPage = new LoginPage(driver);
		loginPage.enterEmail(prop.getProperty("validEmail"));
		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();

		Assert.assertEquals(loginPage.noMatchForEmailAndPasswordText(),
				dataProp.getProperty("emailPasswordNoMatchwarningmessage"),
				"Expected Warning Message is not displayed");
	}

	@Test
	public void TC_LF_005() {

		homePage = new HomePage(driver);
		homePage.navigateToLogin();

		loginPage = new LoginPage(driver);
		loginPage.clickOnLoginButton();

		Assert.assertEquals(loginPage.noMatchForEmailAndPasswordText(),
				dataProp.getProperty("emailPasswordNoMatchwarningmessage"),
				"Expected Warning Message is not displayed");

	}
	
	@Test
	public void TC_LF_006() {
		homePage = new HomePage(driver);
		homePage.navigateToLogin();
				
		loginPage = new LoginPage(driver);
		
		Assert.assertTrue(loginPage.displayStatusOfForgottenPasswordOption());

		
		loginPage.clickOnForgottenPasswordOption();
		
		ForgottenPasswordPage forgottenPasswordPage = new ForgottenPasswordPage(driver);
		
		Assert.assertTrue(forgottenPasswordPage.displayStatusOfForgotYourPasswordHeading());
		
	}

	@Test
	public void TC_LF_008() {
		homePage = new HomePage(driver);
		homePage.navigateToLogin();

		LoginPage loginPage = new LoginPage(driver);

		Assert.assertEquals(loginPage.emailPlaceHolderType(), "E-Mail Address",
				"Email Address place holder is mis match");
		Assert.assertEquals(loginPage.passwordPlaceHolderType(), "Password", "Password place holder is mis match");
	}

	@Test
	public void TC_LF_013() throws InterruptedException {

		homePage = new HomePage(driver);
		homePage.navigateToLogin();

		loginPage = new LoginPage(driver);

		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));

		Assert.assertEquals(loginPage.checkPasswordFieldType(), "password");

	}

	@DataProvider(name= "testData")
	public Object testData() {

		Object[][] data = { { "bajay1@gmail.com", "12345" }, { "bajay2@gmail.com", "123456" },
				{ "bajay3@gmail.com", "123456" } };
		
		return data;

	}
	


}
