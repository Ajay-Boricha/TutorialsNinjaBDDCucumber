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
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	private WebElement registerOption;

	// actions
	public void clickOnMyAccount() {
		myAccountOption.click();
	}

	public void clickOnLogin() {
		loginOption.click();
	}

	public LoginPage navigateToLogin() {
		myAccountOption.click();
		loginOption.click();
		return new LoginPage(driver);

	}
	
	public void navigateToRegister() {
		myAccountOption.click();
		registerOption.click();
	}

}
