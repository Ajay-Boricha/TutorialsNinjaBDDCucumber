package com.openCart.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	public static ExtentReports generateExtentReports() {

		ExtentReports extentReport = new ExtentReports();

		File file = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReports.html");
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);

		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setDocumentTitle("Tutorial Ninja Automation test");
		sparkReport.config().setReportName("TN Automation Report");
		sparkReport.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss a");

		Properties prop = new Properties();
		File file1 = new File(
				System.getProperty("user.dir") + "src\\main\\java\\com\\openCart\\Config\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(file1);
			prop.load(fis);

		} catch (Throwable e) {
			e.printStackTrace();
		}

		extentReport.setSystemInfo("Application URL", prop.getProperty("URL"));
		extentReport.setSystemInfo("Browser Name", prop.getProperty("browserName"));
		extentReport.setSystemInfo("Email ID", prop.getProperty("validEmail"));
		extentReport.setSystemInfo("Password", prop.getProperty("validPassword"));
		
		extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("Os Name", System.getProperty("os.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		extentReport.attachReporter(sparkReport);
		
		return extentReport;

	}

}
