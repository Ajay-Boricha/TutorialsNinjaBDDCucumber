package com.openCart.Utils;

import java.util.Date;

import org.openqa.selenium.WebDriver;

public class Utility {

	WebDriver driver;

	public static String randomEmailString() {

		Date date = new Date();

		return "ajay" + date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";

	}

}
