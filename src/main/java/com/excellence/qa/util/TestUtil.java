package com.excellence.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.excellence.qa.base.BaseClass;

public class TestUtil extends BaseClass {
	
	
//Below are static variables, so that if we want to change the page load time/wait then we can change it from this class instead of entering in the script


	public static long Page_Load_Time= 80;
	public static long Implicitely_Wait=80;
	
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\arsingh\\eclipse-workspace\\testFramework\\src\\main\\java\\com\\excellence\\qa\\testdata\\TestData.xlsx";

	static Workbook book;
	static Sheet sheet;
	
	static Row rw;
	static Cell cell;

//Method to read data from excel
	public static Object[][] getTestData(String sheetName) {
		
		//Object of FileInputStream to obtain file in file system (loaded file as byte)
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(fis);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		
		
	//Length of row and column	
	int rowLength=sheet.getLastRowNum();
	
//OR	int rowLength=sheet.getLastRowNum()-sheet.getFirstRowNum();
	
	int cellLength=sheet.getRow(0).getLastCellNum();
	
		//Create object of 2D array
	
	Object[][] data = new Object[rowLength][cellLength];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < rowLength; i++) {
			for (int k = 0; k < cellLength; k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	

	//Method to take screenshots (to use its path into other classes we have to define return type so that we will store its path for further use)

	public static String takeScreenshotAtEndOfTest() throws IOException {
		// Convert webdriver to take screenshot
		TakesScreenshot scrshot= ((TakesScreenshot) driver);
		
		//Take screenshot and store into scrFile with the method of TakesScreenshot interface
		File scrFile= scrshot.getScreenshotAs(OutputType.FILE);
		
		//"user.dir" is the current working directory, below to get to current working directory
		//String currentDir = System.getProperty("user.dir");
		
		String destFile = (System.getProperty("user.dir")+ "/target/screenshots/" + System.currentTimeMillis() + ".png");
		
		//File destFile= new File (currentDir + "/screenshots1/" + System.currentTimeMillis() + ".png");
        
		//Copy file to desired location with help of FileUtils apache utility 
		FileUtils.copyFile(scrFile, new File(destFile));
		
		//FileUtils.copyFile(scrFile, destFile);
		return destFile;


}
}
