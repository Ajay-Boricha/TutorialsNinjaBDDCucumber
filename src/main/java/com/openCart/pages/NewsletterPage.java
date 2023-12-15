package com.openCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsletterPage {

	WebDriver driver;

	public NewsletterPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// object
	
	@FindBy(xpath = "//input[@value='1']")
	private WebElement yesRadioButton;
	
	@FindBy(xpath="//input[@value='0']")
	private WebElement noRadioButton;

	
	
	// actions
	
	public boolean verifyYesStatusOfRadioButton() {
		return yesRadioButton.isSelected();
	}

	public boolean verifyNoStatusOfRadioButton() {
		return noRadioButton.isSelected();
	}
}
