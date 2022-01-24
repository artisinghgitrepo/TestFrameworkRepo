package com.excellence.qa.util;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	
	//Globally defined objects
	XSSFWorkbook wb;
	
	XSSFSheet sheet;
	
	//Call constructor and pass the file location so that it loads with the class
	
	public ReadExcelData(String excelPath) {
		
	
	try {
		//Obtain the test data file by creating object of File class
		
		File file= new File("C:\\Users\\arsingh\\eclipse-workspace\\testFramework\\src\\main\\java\\com\\excellence\\qa\\testdata\\TestData.xls");
		
		//Object of FileInputStream to obtain file in file system (loaded file as byte)
		
		FileInputStream fis= new FileInputStream(file);
		
		//Load complete file by creating object of workbook class
		
		wb= new XSSFWorkbook(fis);
		
		//Access the sheet in the excel file
		
		sheet= wb.getSheetAt(0);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		//If any exception comes, it will print message
		System.out.print(e.getMessage());
	} 
}
	
   //Create a method to read the data from file (method returns string)
	
	public String getData(String SheetNumber, int row, int col) {
		
		String data= sheet.getRow(row).getCell(col).getStringCellValue();
		
		return data;
	
	}
	
	
	
  
}
