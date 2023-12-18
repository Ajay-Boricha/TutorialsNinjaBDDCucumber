package com.openCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWishListPage {

	WebDriver driver;
	
	public MyWishListPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//object 
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement addToCartButton;
	
	
	//actions
	public void clickAddToCartButton() {
		
		addToCartButton.click();
	}
	
	
}
