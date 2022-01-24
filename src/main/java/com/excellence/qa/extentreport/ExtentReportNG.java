package com.excellence.qa.extentreport;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.excellence.qa.base.BaseClass;

//INITIALISED EXTENT REPORT CLASS IN BASE CLASS TO USE IT PUBLICALLY 

//IReporter interface in TestNG (listener to generate report)
public class ExtentReportNG extends BaseClass {
	
	
//Below method returing extent reports
	public static ExtentReports extentReportSetUp() {
		
		//To specify the format of date
		SimpleDateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		
		// Create object of Date util
		Date date= new Date();
		
		// Now storing the date in the string
		String actualDate= dateFormat.format(date);
		
		//We can add into target folder (always refreshes) but below line will generate new report
		//Storing report path into string
		String path = (System.getProperty("user.dir")+"/target/Reports/extent_"+actualDate+".html");
		
		
		//Creating object of reporter which will create the report
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results for Excellence");
		reporter.config().setDocumentTitle("Test Results");
		
		//Creating object of extent reports class
		 extent =new ExtentReports();
		 
		 //Attaching the reporter to the extent report, which gonna generate report
		extent.attachReporter(reporter);
		
		//Setting system info
		extent.setSystemInfo("Sr. Test Engineer", "Arti Singh");
		
		return extent;
				
	}
}
