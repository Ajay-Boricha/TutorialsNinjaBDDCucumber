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

	public static final int implicitly_Wait = 10;

	public Base() {

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

	public void loadPropertiesFile() {

		prop = new Properties();

		try {

			File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\openCart\\Config\\config.properties");

			FileInputStream fis = new FileInputStream(file);

			prop.load(fis);
		} catch (Throwable e) {
			e.getStackTrace();
		}

	}
}
