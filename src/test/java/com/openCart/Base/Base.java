package com.openCart.Base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	WebDriver driver;

	public Properties prop;

	public Properties dataProp;

	public static final int implicitly_Wait = 10;

	public Base() {

		prop = new Properties();

		dataProp = new Properties();

		try {
			File file2 = new File(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\openCart\\Config\\testData.properties");
			FileInputStream fis2 = new FileInputStream(file2);
			dataProp.load(fis2);
		} catch (Throwable e) {
			e.getStackTrace();
		}

		try {

			File file = new File(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\openCart\\Config\\config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} catch (Throwable e) {
			e.getStackTrace();
		}
	}

	public WebDriver initializeBrowserWithURL(String browserName) {

		if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitly_Wait));
		driver.get(prop.getProperty("URL"));

		return driver;
	}

}
