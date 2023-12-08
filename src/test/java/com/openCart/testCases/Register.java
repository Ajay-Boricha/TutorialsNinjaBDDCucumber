package com.openCart.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.openCart.Base.Base;
import com.openCart.Utils.Utility;

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

		System.out.println("Hello");

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();

		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Ajay");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("B");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utility.randomEmailString());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		Assert.assertEquals(
				driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText(),
				"Your Account Has Been Created!");

	}

	@Test(priority = 2)
	public void TC_RF_004() {

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String actualFirstNameWarningMessage = driver
				.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]"))
				.getText();
		String actualLastNameWarningMessage = driver
				.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]"))
				.getText();
		String actualEMailWarningMessage = driver
				.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]"))
				.getText();
		String actualTelephoneWarningMessage = driver
				.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]"))
				.getText();
		String actualPasswordWarningMessage = driver
				.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]"))
				.getText();

		Assert.assertEquals(actualFirstNameWarningMessage, "First Name must be between 1 and 32 characters!");
		Assert.assertEquals(actualLastNameWarningMessage, "Last Name must be between 1 and 32 characters!");
		Assert.assertEquals(actualEMailWarningMessage, "E-Mail Address does not appear to be valid!");
		Assert.assertEquals(actualTelephoneWarningMessage, "Telephone must be between 3 and 32 characters!");
		Assert.assertEquals(actualPasswordWarningMessage, "Password must be between 4 and 20 characters!");

	}

}
