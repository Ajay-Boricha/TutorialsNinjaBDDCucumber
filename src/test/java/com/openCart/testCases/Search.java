package com.openCart.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.openCart.Base.Base;

public class Search extends Base {

	WebDriver driver;

	public Search() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		driver = initializeBrowserWithURL("edge");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void TC_SF_001() {

		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("iMac");
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='iMac']")).isDisplayed(),
				"valid search product is not displayed");

	}

	@Test
	public void TC_SF_002() {

		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Fitbit");
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();

		String actualnoProductMessage = driver
				.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]"))
				.getText();

		Assert.assertEquals(actualnoProductMessage, "There is no product that matches the search criteria.",
				"Expected product message is not displayed");

	}

}
