package com.openCart.testCases;

import org.openqa.selenium.By;
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

	public Register() {
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

	@Test(priority = 1)
	public void TC_RF_001() {

		HomePage homePage = new HomePage(driver);
		homePage.navigateToRegister();

		RegisterPage registerPage = new RegisterPage(driver);

		registerPage.enterAndSubmitAllMandatoryField(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), Utility.randomEmailString(), dataProp.getProperty("telephoneNumber"),
				dataProp.getProperty("password"));

		String actualAccountSucesssHeading = driver
				.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();

		Assert.assertEquals(actualAccountSucesssHeading, dataProp.getProperty("accountSuccessfullyCreatedHeading"));

	}

	@Test(priority = 2)
	public void TC_RF_004() {

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String actualPrivacyPolicyWarningMessage = driver
				.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertEquals(actualPrivacyPolicyWarningMessage,
				dataProp.getProperty("privacyPolicyWarningMessageWarning"));

		String actualFirstNameWarningMessage = driver
				.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]"))
				.getText();
		Assert.assertEquals(actualFirstNameWarningMessage, dataProp.getProperty("firstNameWarningMessage"));

		String actualLastNameWarningMessage = driver
				.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]"))
				.getText();
		Assert.assertEquals(actualLastNameWarningMessage, dataProp.getProperty("lastNameWarningMesage"));

		String actualEMailWarningMessage = driver
				.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]"))
				.getText();
		Assert.assertEquals(actualEMailWarningMessage, dataProp.getProperty("emailWarningMessage"));

		String actualTelephoneWarningMessage = driver
				.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]"))
				.getText();
		Assert.assertEquals(actualTelephoneWarningMessage, dataProp.getProperty("telephoneNumberWarningMessage"));

		String actualPasswordWarningMessage = driver
				.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]"))
				.getText();
		Assert.assertEquals(actualPasswordWarningMessage, dataProp.getProperty("passwordWarningMessage"));

	}

}
