package com.openCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// object
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement enterEmail;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement enterPassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButton;

	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement noMatchForEmailAndPassword;

	// Actions
	public void enterEmail(String emailText) {
		enterEmail.sendKeys(emailText);
	}

	public void enterPassword(String passwordTest) {
		enterPassword.sendKeys(passwordTest);
	}
	
	public String checkPasswordFieldType() {
		return enterPassword.getAttribute("type");
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public String noMatchForEmailAndPasswordText() {
		return noMatchForEmailAndPassword.getText();
	}

}
