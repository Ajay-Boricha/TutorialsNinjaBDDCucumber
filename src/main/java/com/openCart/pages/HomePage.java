package com.openCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// object
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountOption;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	private WebElement loginOption;

	// actions
	public void clickOnMyAccount() {
		myAccountOption.click();
	}

	public void clickOnLogin() {
		loginOption.click();
	}

	public void navigateToLogin() {
		myAccountOption.click();
		loginOption.click();

	}

}
