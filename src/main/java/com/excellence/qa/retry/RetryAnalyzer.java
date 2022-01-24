package com.excellence.qa.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.excellence.qa.base.BaseClass;

//This is implementing IRetryAnalyzer interface to use (override) its unimplemented methods
public class RetryAnalyzer implements IRetryAnalyzer{
	
	//Initializing the counter
	int counter=0;
	int retryLimit=2;

	public boolean retry(ITestResult result) {
		
		if(counter<retryLimit) {
			counter++;
			return true;
		}
		
		return false;
	}

}
