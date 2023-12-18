package com.openCart.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	WebDriver driver;

	public static String randomEmailString() {

		Date date = new Date();

		return "ajay" + date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";

	}
	
	public void getTestDataFromExcel(String TestData1) throws IOException {
		
		File file = new File("C:\\Users\\Ajay\\openCart\\openCart\\src\\test\\java\\src\\test\\resources\\DataDrivenTestData.xlsx");
		
		FileInputStream fis= new FileInputStream(file);
		
		XSSFWorkbook book= new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet(TestData1);
		int rows=sheet.getLastRowNum();
		int cols =sheet.getRow(0).getLastCellNum();
		
		Object[][] data= new Object[rows][cols]; 
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				data[i][j]=new Object[rows][cols];
			}
		}
		
	}
	
	public static String captireScreenshot(WebDriver driver, String testName) {
		File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String destinationScreenshotPath = "C:\\Users\\Ajay\\openCart\\openCart\\Sceenshots\\" + testName + ".png";

		try {
			FileHandler.copy(srcScreenshot, new File(destinationScreenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return destinationScreenshotPath;
	}
	
	

}
