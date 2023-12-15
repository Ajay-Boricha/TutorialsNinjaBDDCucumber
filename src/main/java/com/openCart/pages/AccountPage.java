package com.openCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	WebDriver driver;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// object

	@FindBy(xpath = "//a[normalize-space()='Edit your account information']")
	private WebElement editYourAccountInfoOption;

	@FindBy(xpath = "//a[normalize-space()='Subscribe / unsubscribe to newsletter']")
	private WebElement subUnsubToNewsletterLink;

	// actions

	public boolean displayStatusOfEditYourAccount() {
		boolean displayStatusOfAccount = editYourAccountInfoOption.isDisplayed();
		return displayStatusOfAccount;
	}

	public NewsletterPage clickSubUnsubToNewsletterLink() {
		subUnsubToNewsletterLink.click();
		return new NewsletterPage(driver);
	}

}
