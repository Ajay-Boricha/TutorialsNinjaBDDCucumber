package com.openCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDisplayPage {

	public WebDriver driver;

	public ProductDisplayPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// Object

	@FindBy(xpath = "//span[normalize-space()='Add to Cart']")
	private WebElement addToCartOption;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement addedProductToCartsuccessMessage;

	@FindBy(xpath = "//a[normalize-space()='shopping cart']")
	private WebElement shoppingCartLinkInSuccessMessage;

	@FindBy(xpath = "//button[@type='button']//i[@class='fa fa-heart']")
	private WebElement addToWishListButton;
	
	@FindBy(xpath="//a[normalize-space()='Apple Cinema 30\"']")
	private WebElement productLink;
	
	@FindBy(xpath="//body//div[@id='product-product']//div[@class='row']//div[@class='row']//div[2]//div[1]//div[3]//button[1]//span[1]")
	private WebElement addToCartatRelatedProductOption;

	// Actions

	public void clickAddToCartOption() {
		addToCartOption.click();
	}

	public boolean displayStatusOfAddedProductToCartsuccessMessage() {
		return addedProductToCartsuccessMessage.isDisplayed();
	}

	public ShoppingCartPage clickShoppingCartLinkInSuccessMessage() {
		shoppingCartLinkInSuccessMessage.click();

		return new ShoppingCartPage(driver);
	}

	public void clickAddToWishList() {
		addToWishListButton.click();
	}
	
	public void clickProductLink() {
		productLink.click();
	}
	
	public void clickAddToCartatRelatedProductOption() {
		addToCartatRelatedProductOption.click();
	}

}
