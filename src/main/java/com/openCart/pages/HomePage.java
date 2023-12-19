package com.openCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// Object

	// Header WebElements Objects

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement myAccountOption;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	private WebElement loginOption;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	private WebElement registerOption;

	@FindBy(xpath = "//span[normalize-space()='Shopping Cart']")
	private WebElement shoppingCartOption;

	@FindBy(xpath = "//span[normalize-space()='Wish List (1)']")
	private WebElement wishListOption;

	// Navigation Bar WebElements Objects

	@FindBy(xpath = "//a[normalize-space()='Desktops']")
	private WebElement linkNavBarDesktop;

	@FindBy(xpath = "//a[normalize-space()='Show AllDesktops']")
	private WebElement linkShowAllDesktops;

	// Page WebElements Objects

	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchField;

	@FindBy(xpath = "//i[@class='fa fa-search']")
	private WebElement searchButton;

	@FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	private WebElement blackCartButton;

	@FindBy(xpath = "//strong[normalize-space()='View Cart']")
	private WebElement viewCartOptionInPopUp;

	@FindBy(xpath = "//a[normalize-space()='iMac']")
	private WebElement validProduct;

	@FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
	private WebElement noProductThatMatchTheCriteria;

	@FindBy(xpath = "//a[3]")
	private WebElement LinkMacSubCategory;

	// Header Actions Methods
	public void clickOnMyAccount() {
		myAccountOption.click();
	}

	public void clickOnLogin() {
		loginOption.click();
	}

	public RegisterPage navigateToRegister() {
		myAccountOption.click();
		registerOption.click();
		return new RegisterPage(driver);
	}

	public LoginPage navigateToLogin() {
		myAccountOption.click();
		loginOption.click();
		return new LoginPage(driver);
	}

	public MyWishListPage clickWishListOption() {
		wishListOption.click();
		return new MyWishListPage(driver);
	}

	public ShoppingCartPage clickShoppingCartOption() {
		shoppingCartOption.click();

		return new ShoppingCartPage(driver);
	}

	// Page Actions Methods

	public void enterSearch(String productName) {
		searchField.sendKeys(productName);
	}

	public ProductDisplayPage clickOnSearchButton() {
		searchButton.click();
		return new ProductDisplayPage(driver);
	}

	public void clickBlackCartButton() {
		blackCartButton.click();
	}

	public ShoppingCartPage clickViewCartOptionInPopUp() {
		viewCartOptionInPopUp.click();
		return new ShoppingCartPage(driver);
	}

	// Navigation Bar Actions Methods

	public void hoverMouseOverDesktopLink() {
		Actions action = new Actions(driver);

		action.moveToElement(linkNavBarDesktop).perform();
	}

	public void clicklinkShowAllDesktops() {

		linkShowAllDesktops.click();
	}

	public boolean displayStatusOfValidProduct() {
		return validProduct.isDisplayed();
	}

	public String noProductThatMatchTheCriteriaText() {
		return noProductThatMatchTheCriteria.getText();
	}

	public ProductDisplayPage enterSearchAndClickOnSearchButton(String productName) {
		searchField.sendKeys(productName);
		searchButton.click();
		return new ProductDisplayPage(driver);
	}

	// Sub Category options on left side

	public void clicklinkMacSubCategory() {
		LinkMacSubCategory.click();
	}

}
