package com.excellence.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.excellence.qa.util.TestUtil;
import com.excellence.qa.util.WebDriverListener;

public class BaseClass {
	
public static WebDriver driver;
	
	public static Properties prop;
	
	//initialised extent report and test to use globally
	public static ExtentReports extent;
	public static ExtentTest test;
	
	// craeting object of EventFiringWebDriver class used to wrap webdriver around to throw events
	public static EventFiringWebDriver eventDriver;
	// Create object of WebDriverListener class where all the unimlemented methods are available
	public static WebDriverListener webDriverListener;
	
	// Config Properties file read
	
	// Class constructor, so that input file is loaded before initialization (when class is loading, code within constructor is called)
	public BaseClass() {
		
	try {
		 prop= new Properties();
		    
			FileInputStream fis= new FileInputStream("C:\\Users\\arsingh\\eclipse-workspace\\testFramework\\src\\main\\java\\com\\excellence\\qa\\config\\config.properties");
			prop.load(fis);
		
	}	
	catch (FileNotFoundException e){
		e.printStackTrace();		
	}
	catch (IOException e) {
		e.printStackTrace();		
	}
		
	}
	
	
	
	// Initialization of the browsers
	public void initialization() {
		
		
	// Checking which browser to choose (from config file)	
		String browserName= prop.getProperty("Browser");
	
	if (browserName.equals("FF"))
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\arsingh\\eclipse-workspace\\testFramework\\driver\\geckodriver.exe");
		driver= new FirefoxDriver();
		
	}
	else if (browserName.equals("Chrome")){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\arsingh\\eclipse-workspace\\testFramework\\driver\\chromedriver.exe");	
	driver= new ChromeDriver();
	}
	
	//After opening the browser create the object of EventFiringWebDriver and WebDriverListener (eventHandler) classes
	
	eventDriver= new EventFiringWebDriver(driver);
	
	webDriverListener= new WebDriverListener();
	
	// EventFiringWebDriver class has a register method Register method to register our implementation of WebDriverEventListner to listen to the WebDriver events 
	eventDriver.register(webDriverListener);
	
	//Assign object of EventFiringWebDriver to driver
	
	driver= eventDriver;
	
	// Maximize the window
	driver.manage().window().maximize();
	
	// Delete all cookies
	driver.manage().deleteAllCookies();
	
	//Pageload timeout and we are getting time dynamically from TestUtil class (we can also define it into config file
	driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Time, TimeUnit.SECONDS);
	
	driver.manage().timeouts().implicitlyWait(TestUtil.Implicitely_Wait, TimeUnit.SECONDS);
	
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	
	// Open the url
	driver.get(prop.getProperty("Weburl"));
	}
	

}
