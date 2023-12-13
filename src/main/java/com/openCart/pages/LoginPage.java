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
	private WebElement enterEmail;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement enterPassword;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement noMatchForEmailAndPassword;
	
	@FindBy(xpath="//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
	private WebElement forgottenPasswordButton;

	// Actions
	public void enterEmail(String emailText) {
		enterEmail.sendKeys(emailText);
	}

	public void enterPassword(String passwordText) {
		enterPassword.sendKeys(passwordText);
	}
	
	public String checkPasswordFieldType() {
		return enterPassword.getAttribute("type");
	}
	
	public String  emailPlaceHolderType() {
		return enterEmail.getAttribute("placeholder");
	}
	
	public String passwordPlaceHolderType() {
		return enterPassword.getAttribute("placeholder");
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public ForgottenPasswordPage clickOnForgottenPasswordOption() {
		forgottenPasswordButton.click();
		return new ForgottenPasswordPage(driver);
	}
	
	public String noMatchForEmailAndPasswordText() {
		return noMatchForEmailAndPassword.getText();
	}
	
	public boolean displayStatusOfForgottenPasswordOption() {
		return forgottenPasswordButton.isDisplayed();
		
	}
	
	public AccountPage login(String emailText, String passwordText) {
		enterEmail.sendKeys(emailText);
		enterPassword.sendKeys(passwordText);
		loginButton.click();
		return new AccountPage(driver);
	}

}
