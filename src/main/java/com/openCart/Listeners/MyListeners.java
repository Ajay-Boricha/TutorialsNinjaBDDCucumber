package com.openCart.Listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.openCart.Utils.ExtentReport;
import com.openCart.Utils.Utility;

public class MyListeners implements ITestListener {

	ExtentReports extentReport;

	ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {

		extentReport = ExtentReport.generateExtentReports();
	}

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName() + " Starting executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.log(Status.PASS, result.getName() + " got successfully executed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		extentTest.log(Status.INFO, result.getThrowable());

		extentTest.log(Status.SKIP, result.getName() + " got skkiped");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		WebDriver driver = null;

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

		String destinationScreenshotPath=Utility.captireScreenshot(driver, result.getTestName());

		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);

		extentTest.log(Status.INFO, result.getThrowable());

		extentTest.log(Status.FAIL, result.getName() + " got Failed");

	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		
		String pathOfExtentReport= System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReports.html";
		
		File extentReportFile= new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReportFile.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		};
		
	}

}
