package com.openCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgottenPasswordPage {
	
	WebDriver driver;
	
	public ForgottenPasswordPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//object
	
	@FindBy(xpath="//h1[normalize-space()='Forgot Your Password?']")
	private WebElement ForgotYourPasswordHeading;
	
	//action

	public boolean displayStatusOfForgotYourPasswordHeading() {
		return ForgotYourPasswordHeading.isDisplayed();
	}
	
}
