package com.excellence.qa.util;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.excellence.qa.base.BaseClass;
import com.excellence.qa.extentreport.ExtentReportNG;

public class TestNGListener extends BaseClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		// Below To create nodes(e.g. test case name) into report, returning object of Extent Test
		
		test= extent.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		//To log into the extent report
		test.log(Status.PASS, "Test Case " +result.getMethod().getMethodName()+ "is Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		
		test.log(Status.FAIL, "Test Case " + result.getMethod().getMethodName()+ "is failed");
		
		//To log the exceptions in the report
		test.log(Status.FAIL, result.getThrowable());
		
		//To attach the screenshot of failed cases
		
			String destFile;
			try {
				destFile = TestUtil.takeScreenshotAtEndOfTest();
				test.addScreenCaptureFromPath(destFile, "Failed Screenshot");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		
		//Setting up the extent report and returning extent report
		extent = ExtentReportNG.extentReportSetUp();
		
	}

	public void onFinish(ITestContext context) {
		
		//To close the report after generating the report
		extent.flush();
		
		//flush() writes the content of the buffer to the destination and makes the buffer empty for further data to 
		//store but it does not closes the stream permanently. That means you can still write some more data to 
		//the stream. But close() closes the stream permanently.
		
		//ITestContext stores the information about the tests
		
		//ITestResult stores the information about test result
		
	}
	

}
