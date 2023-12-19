package com.openCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	WebDriver driver;
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}

	//Object
	
	@FindBy(xpath="//body[1]/div[2]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")
	private WebElement productName;
	

	@FindBy(xpath="(//a[contains(text(),'MacBook')])[2]")
	private WebElement productNameMacBook;
	
	//Actions
	
	public boolean displayStatusOfAddedToCartProduct() {
		
		if(productName.getText().equalsIgnoreCase("iMac")) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean displayStatusOfAddedMacBookToCartProduct() {
		return productNameMacBook.isDisplayed();
	}
	
}
