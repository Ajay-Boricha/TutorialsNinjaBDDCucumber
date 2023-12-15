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
	
	@FindBy(xpath="//h1[normalize-space()='Register Account']")
	private WebElement registerAccountHeading;

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
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	private WebElement yesRadioButton;
	
	@FindBy(xpath="//input[@value='0']")
	private WebElement noRadioButton;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement pravicyPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement privacyPolicyWarningMessage;
	
	@FindBy(xpath="//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement firstNameWarningMessage;

	@FindBy(xpath="//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement lastNameWarningMessage;
	
	@FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement emailWarningMessage;
	
	@FindBy(xpath="//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	private WebElement telePhoneWarningMessage;
	
	@FindBy(xpath="//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement passwordWarningMessage;
	
	@FindBy(xpath="//div[@class='text-danger']")
	private WebElement passwordDoesNotMatchWarningMessage;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement emailIsAlreadyRegisteredWarningMessage;
	
	
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
	
	public void selectYesRadioButtonforNewsletter() {
		yesRadioButton.click();
	}
	
	public void selectNoRadioButtonforNewsletter() {
		noRadioButton.click();
	}

	public void checkOnPrivacyPolicy() {
		pravicyPolicy.click();
	}

	public void clickOnContinueButton() {
		continueButton.click();
	}
	
	public String privacyPolicyWarningMessageText() {
		return privacyPolicyWarningMessage.getText();
	}
	
	public String firstNameWarningMessageText() {
		return firstNameWarningMessage.getText();
	}
	
	public String lastNameWarningMessageText() {
		return lastNameWarningMessage.getText();
	}
	
	public String emailWarningMessageText() {
		return emailWarningMessage.getText();
	}
	
	public String telephoneWarningMessageText() {
		return telePhoneWarningMessage.getText();
	}
	
	public String passwordWarningMessageText() {
		return passwordWarningMessage.getText();
	}
	
	public boolean displayStatusOfRegisterAccountHeading() {
		return registerAccountHeading.isDisplayed();
	}
	
	public boolean displayStatusOfPasswordDoesNotMatchWarningMessage() {
		return passwordDoesNotMatchWarningMessage.isDisplayed();
	}
	
	public boolean displayStatusOfEmailIsAlreadyRegisteredWarningMessage() {
		return emailIsAlreadyRegisteredWarningMessage.isDisplayed();
	}

	public AccountSuccessPage enterAndSubmitAllMandatoryField(String firstNameTest, String lastNameText, String emailText,
			String telephoneText, String passwordtext) {
		firstNameField.sendKeys(firstNameTest);
		lastNameField.sendKeys(lastNameText);
		emailField.sendKeys(emailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordtext);
		confirmPasswordField.sendKeys(passwordtext);
		pravicyPolicy.click();
		continueButton.click();
		
		return new AccountSuccessPage(driver);

	}
	
	public AccountSuccessPage enterAndSubmitAllField(String firstNameTest, String lastNameText, String emailText,
			String telephoneText, String passwordtext) {
		firstNameField.sendKeys(firstNameTest);
		lastNameField.sendKeys(lastNameText);
		emailField.sendKeys(emailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordtext);
		confirmPasswordField.sendKeys(passwordtext);
		yesRadioButton.click();
		pravicyPolicy.click();
		continueButton.click();

		return new AccountSuccessPage(driver);
	}
	
	public AccountSuccessPage enterAndSubmitAllFieldWithNoRadioButton(String firstNameTest, String lastNameText, String emailText,
			String telephoneText, String passwordtext) {
		firstNameField.sendKeys(firstNameTest);
		lastNameField.sendKeys(lastNameText);
		emailField.sendKeys(emailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordtext);
		confirmPasswordField.sendKeys(passwordtext);
		noRadioButton.click();		
		pravicyPolicy.click();
		continueButton.click();
		
		return new AccountSuccessPage(driver);

	}
	
	public AccountSuccessPage enterAndSubmitAllField(String firstNameTest, String lastNameText, String emailText,
			String telephoneText, String passwordtext, String incorrectPasswordText) {
		firstNameField.sendKeys(firstNameTest);
		lastNameField.sendKeys(lastNameText);
		emailField.sendKeys(emailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordtext);
		confirmPasswordField.sendKeys(incorrectPasswordText);
		yesRadioButton.click();
		pravicyPolicy.click();
		continueButton.click();

		return new AccountSuccessPage(driver);
	}
	


}
