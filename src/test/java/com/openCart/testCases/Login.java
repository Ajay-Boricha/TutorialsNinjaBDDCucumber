package com.openCart.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.openCart.Base.Base;
import com.openCart.Utils.Utility;

public class Login extends Base {

	WebDriver driver;

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

	@Test(priority = 1)
	public void TC_LF_001() {

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		Assert.assertTrue(
				driver.findElement(By.xpath("//a[normalize-space()='Edit your account information']")).isDisplayed(),
				"Edit your account information is not displayed");

	}

	@Test(priority = 2)
	public void TC_LF_002() {

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utility.randomEmailString());
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataProp.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		String actualWarningMessageDisplayed = driver
				.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();

		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchwarningmessage");

		Assert.assertEquals(actualWarningMessageDisplayed, expectedWarningMessage,
				"Expected Warning Message is not displayed");

	}

	@Test(priority = 3)
	public void TC_LF_003() {

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(dataProp.getProperty("invalidEmail"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		String actualWarningMessageDisplayed = driver
				.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();

		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchwarningmessage");

		Assert.assertEquals(actualWarningMessageDisplayed, expectedWarningMessage,
				"Expected Warning Message is not displayed");

	}

	@Test(priority = 4)
	public void TC_LF_004() {

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataProp.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		String actualWarningMessageDisplayed = driver
				.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();

		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchwarningmessage");

		Assert.assertEquals(actualWarningMessageDisplayed, expectedWarningMessage,
				"Expected Warning Message is not displayed");

	}

	@Test
	public void TC_LF_005() {

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		String actualWarningMessageDisplayed = driver
				.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();

		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchwarningmessage");

		Assert.assertEquals(actualWarningMessageDisplayed, expectedWarningMessage,
				"Expected Warning Message is not displayed");

	}

	@Test
	public void TC_LF_013() throws InterruptedException {

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();

		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(dataProp.getProperty("invalidPassword"));

		String actualPasswordFieldType = driver.findElement(By.xpath("//input[@id='input-password']"))
				.getAttribute("type");

		Assert.assertEquals(actualPasswordFieldType, "password");

	}

}
