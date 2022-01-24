package com.excellence.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.excellence.qa.base.BaseClass;

public class WebDriverListener extends BaseClass implements WebDriverEventListener{
	
	//This class is implementing WebDriverEventListener interface to use its unimplemented method, after implementing just mouse hover on this class it will tell to add all unimplemented class

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigating to" + url);
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to" + url);
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating to privious page");
		
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated to privious page");
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating to next page");
		
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated to next page");
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
// for below two methods we have to print the by using object of By not WebElement, otherwise it will give you the error
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find the " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found the " + by.toString() + "element");
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on" + element.toString());
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on" + element.toString());
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occoured: " + error);
		
		try {
			TestUtil.takeScreenshotAtEndOfTest();
		}
		catch(IOException e) {
        e.printStackTrace();
			
		}
		
	}

}
