package com.openCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// object

	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement firstNameField;

	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement lastNameField;

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailField;

	@FindBy(xpath = "//input[@id='input-telephone']")
	private WebElement telephoneField;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@id='input-confirm']")
	private WebElement confirmPasswordField;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement pravicyPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	// action

	public void enterFirstName(String firstNameTest) {
		firstNameField.sendKeys(firstNameTest);
	}

	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}

	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);
	}

	public void enterTelephone(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}

	public void enterpassword(String passwordtext) {
		passwordField.sendKeys(passwordtext);
	}

	public void enterConfirmPassword(String passwordtext) {
		confirmPasswordField.sendKeys(passwordtext);
	}

	public void checkOnPrivacyPolicy() {
		pravicyPolicy.click();
	}

	public void clickOnContinueButton() {
		continueButton.click();
	}

	public void enterAndSubmitAllMandatoryField(String firstNameTest, String lastNameText, String emailText,
			String telephoneText, String passwordtext) {
		firstNameField.sendKeys(firstNameTest);
		lastNameField.sendKeys(lastNameText);
		emailField.sendKeys(emailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordtext);
		confirmPasswordField.sendKeys(passwordtext);
		pravicyPolicy.click();
		continueButton.click();

	}

}
