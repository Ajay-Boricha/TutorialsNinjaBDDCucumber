package com.openCart.pages;

import org.openqa.selenium.Keys;
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
	
	// Register Account Header WebElements Objects
	@FindBy(xpath = "//h1[normalize-space()='Register Account']")
	private WebElement registerAccountHeading;
	
	
	// Your Personal Details WebElements Objects
	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement fieldfirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement fieldLastName;

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement fieldEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	private WebElement telephoneField;
	
	
	// Your Password WebElements Objects	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@id='input-confirm']")
	private WebElement confirmPasswordField;
	
	
	// Newsletter WebElements Objects	
	@FindBy(xpath = "//label[normalize-space()='Yes']")
	private WebElement yesRadioButton;

	@FindBy(xpath = "//input[@value='0']")
	private WebElement noRadioButton;
	
	
	// Privacy WebElements Objects	
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement pravicyPolicyCheckbox;
	
	// Continue WebElements Objects	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	
	// Warning message WebElements Objects	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement privacyPolicyWarningMessage;

	@FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement firstNameWarningMessage;

	@FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement lastNameWarningMessage;

	@FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement emailWarningMessage;

	@FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	private WebElement telePhoneWarningMessage;

	@FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement passwordWarningMessage;

	@FindBy(xpath = "//div[@class='text-danger']")
	private WebElement passwordDoesNotMatchWarningMessage;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement emailIsAlreadyRegisteredWarningMessage;
	
	
	// Labels WebElements Objects	
	@FindBy(xpath = "//label[normalize-space()='First Name']")
	private WebElement firstNameLabel;

	
	
	
	// Your Personal Details, Your Password, Newsletter, Privacy and Continue  Actions Methods
	public void enterFirstName(String firstNameTest) {
		fieldfirstName.sendKeys(firstNameTest);
	}

	public void enterLastName(String lastNameText) {
		fieldLastName.sendKeys(lastNameText);
	}

	public void enterEmail(String emailText) {
		fieldEmail.sendKeys(emailText);
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

	public void clickOnPrivacyPolicy() {
		pravicyPolicyCheckbox.click();
	}
	
	public boolean checkStatusOfPrivacyPolicy() {		
		return  pravicyPolicyCheckbox.isSelected();
	}

	public void clickOnContinueButton() {
		continueButton.click();
	}
	
	public boolean checkStatusofPrivacyPolicyWarningMessage() {
		return privacyPolicyWarningMessage.isDisplayed();
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

	public String validationMessageOfemail() {
		return fieldEmail.getAttribute("validationMessage");
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

	public AccountSuccessPage enterAndSubmitAllMandatoryField(String firstNameTest, String lastNameText,
			String emailText, String telephoneText, String passwordtext) {
		fieldfirstName.sendKeys(firstNameTest);
		fieldLastName.sendKeys(lastNameText);
		fieldEmail.sendKeys(emailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordtext);
		confirmPasswordField.sendKeys(passwordtext);
		pravicyPolicyCheckbox.click();
		continueButton.click();

		return new AccountSuccessPage(driver);

	}

	public AccountSuccessPage enterAndSubmitAllMandatoryField(String firstNameTest, String lastNameText,
			String emailText, String telephoneText, String passwordtext, String incorrectPasswordText) {

		fieldfirstName.sendKeys(firstNameTest);
		fieldLastName.sendKeys(lastNameText);
		fieldEmail.sendKeys(emailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordtext);
		confirmPasswordField.sendKeys(incorrectPasswordText);
		pravicyPolicyCheckbox.click();
		continueButton.click();

		return new AccountSuccessPage(driver);

	}

	public AccountSuccessPage enterAndSubmitAllField(String firstNameTest, String lastNameText, String emailText,
			String telephoneText, String passwordtext) {

		yesRadioButton.click();

		enterAndSubmitAllMandatoryField(firstNameTest, lastNameText, emailText, telephoneText, passwordtext);

		return new AccountSuccessPage(driver);
	}

	public AccountSuccessPage enterAndSubmitAllFieldWithNoRadioButton(String firstNameTest, String lastNameText,
			String emailText, String telephoneText, String passwordtext) {

		noRadioButton.click();

		enterAndSubmitAllMandatoryField(firstNameTest, lastNameText, emailText, telephoneText, passwordtext);

		return new AccountSuccessPage(driver);

	}

	public AccountSuccessPage enterAndSubmitAllField(String firstNameTest, String lastNameText, String emailText,
			String telephoneText, String passwordtext, String incorrectPasswordText) {

		yesRadioButton.click();

		enterAndSubmitAllMandatoryField(firstNameTest, lastNameText, emailText, telephoneText, passwordtext,
				incorrectPasswordText);

		return new AccountSuccessPage(driver);
	}
	
	public void enterAndSubmitAllMandatoryFieldwithoutPrivacyPolicy(String firstNameTest, String lastNameText,
			String emailText, String telephoneText, String passwordtext) {
		
		fieldfirstName.sendKeys(firstNameTest);
		fieldLastName.sendKeys(lastNameText);
		fieldEmail.sendKeys(emailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordtext);
		confirmPasswordField.sendKeys(passwordtext);
		continueButton.click();

	}

	public AccountSuccessPage enterAndSubmitAllFieldWithKeyboard(String firstNameTest, String lastNameText, String emailText,
			String telephoneText, String passwordtext) {

		yesRadioButton.click();
		
		fieldfirstName.sendKeys(firstNameTest);
		fieldfirstName.sendKeys(Keys.TAB);
		
		fieldLastName.sendKeys(lastNameText);
		fieldLastName.sendKeys(Keys.TAB);
		
		fieldEmail.sendKeys(emailText);
		fieldEmail.sendKeys(Keys.TAB);
		
		telephoneField.sendKeys(telephoneText);
		telephoneField.sendKeys(Keys.TAB);
		
		passwordField.sendKeys(passwordtext);
		passwordField.sendKeys(Keys.TAB);
		
		confirmPasswordField.sendKeys(passwordtext);
		confirmPasswordField.sendKeys(Keys.TAB);
		
		pravicyPolicyCheckbox.click();
		pravicyPolicyCheckbox.sendKeys(Keys.ENTER);
		//continueButton.click();


		return new AccountSuccessPage(driver);
	}

	public boolean verifyPlaceHolder() {

		String firstNamePlaceHolder = fieldfirstName.getAttribute("placeholder");
		String lastNamePlaceHolder = fieldLastName.getAttribute("placeholder");
		String emailPlaceHolder = fieldEmail.getAttribute("placeholder");
		String telephonePlaceHolder = telephoneField.getAttribute("placeholder");
		String passwordPlaceHolder = passwordField.getAttribute("placeholder");
		String confirmPasswordPlaceHolder = confirmPasswordField.getAttribute("placeholder");

		if (firstNamePlaceHolder.equals("First Name") && lastNamePlaceHolder.equals("Last Name")
				&& emailPlaceHolder.equals("E-Mail") && telephonePlaceHolder.equals("Telephone")
				&& passwordPlaceHolder.equals("Password") && confirmPasswordPlaceHolder.equals("Password Confirm")) {
			return true;
		} else {
			return false;
		}

	}

	public void validateAstrick() {
		System.out.println(firstNameLabel.getText());
	}

}
