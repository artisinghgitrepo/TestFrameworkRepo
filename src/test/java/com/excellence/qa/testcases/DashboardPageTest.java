package com.excellence.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.excellence.qa.base.BaseClass;
import com.excellence.qa.pages.DashboardPage;
import com.excellence.qa.pages.HolidayCalenderPage;
import com.excellence.qa.pages.LoginPage;

public class DashboardPageTest extends BaseClass {
	
	// Create object of LoginPage to use its methods (without login we can not move further)
	
		LoginPage loginpage_obj;
		
		//Created object of Dashboard page as login method returning the Dashboard page object
		DashboardPage dashboardPage_obj;
		
		//Create object of Holiday Calender page as on clicking on Leave application is returning leave application page
		HolidayCalenderPage holidayCalenderPage_obj;
		
	//Call current class constructor with super so that it will call BaseClass constructor where system properties are defined
		public DashboardPageTest() {
			super();
		}
		
		
	@BeforeMethod

	public void setup() throws InterruptedException {
		initialization();
		loginpage_obj=new LoginPage();	
		//holidayCalenderPage_obj= new HolidayCalenderPage();
		// Login is returning dashboard page object
		dashboardPage_obj= new DashboardPage();
		dashboardPage_obj= loginpage_obj.doLogin();
		
	}
	
	
	@Test 
	
	public void verifyClickingOnHolidayCalenderMenu() throws InterruptedException {
		
		dashboardPage_obj.clickonLeaveMenu();
		//Thread.sleep(5000);
		//dashboardPage_obj.waitTillHolidayCalenderMenuAvailable();
		Thread.sleep(5000);
		holidayCalenderPage_obj= dashboardPage_obj.openHolidayCalender();	
		System.out.println("modified code");
	}
	
	@Test
	
	public void openMaterialRequestForm() throws InterruptedException {
		dashboardPage_obj.clickOnTicketingMenu();
		Thread.sleep(5000);
		dashboardPage_obj.clickOnMaterialRequest();	
		
	}
	
	@AfterMethod

	public void closeBrowser() {
		driver.quit();
	}

}
