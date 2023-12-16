package com.openCart.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.openCart.Utils.ExtentReport;

public class MyListeners implements ITestListener{
	
	ExtentReports extentReport;
	
	@Override
	public void onStart(ITestContext context) {
		
		extentReport = ExtentReport.generateExtentReports();
		
		System.out.println("Execution of test is Started");
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName=result.getName();
		System.out.println(testName+" Starting executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName= result.getName();
		System.out.println(testName+" got successfully executed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName= result.getName();
		System.out.println(testName+" got skkiped");
		System.out.println(result.getThrowable());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName=result.getName();
		System.out.println(testName+" got Failed");
		System.out.println(result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Execution of test got Finished");
	}

}
