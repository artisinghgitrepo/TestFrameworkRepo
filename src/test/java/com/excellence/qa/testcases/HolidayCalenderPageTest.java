package com.excellence.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.excellence.qa.base.BaseClass;
import com.excellence.qa.pages.DashboardPage;
import com.excellence.qa.pages.HolidayCalenderPage;
import com.excellence.qa.pages.LoginPage;

public class HolidayCalenderPageTest extends BaseClass {
	
	HolidayCalenderPage holidayCalenderPage_obj;
	
	LoginPage loginpage_obj;
	
	DashboardPage dashboardPage_obj;
	
	public HolidayCalenderPageTest() {
		super();
	}
	
	
	@BeforeMethod

	public void setup() throws InterruptedException {
		initialization();
		holidayCalenderPage_obj= new HolidayCalenderPage();
		loginpage_obj=new LoginPage();	
		loginpage_obj.doLogin();
		Thread.sleep(3000);
		// To reach to holiday calendar we need to go through below steps
		dashboardPage_obj= new DashboardPage();
		dashboardPage_obj.clickonLeaveMenu();
		Thread.sleep(3000);
		dashboardPage_obj.openHolidayCalender();
		
	}
	
	@Test
	
	public void verifyHoliday() {
		
		String holidaylabel= holidayCalenderPage_obj.verifyHolidayLabel();
		
		String expectedHolidaylabel= "HOLIDAY";
		
		Assert.assertEquals(holidaylabel,expectedHolidaylabel,"Holiday label does't match");
		
	}
	
	@Test
	
	public void verifyRestrictedHoliday() {
		
		String restrictedHolidayLabel= holidayCalenderPage_obj.verifyRestrictedHolidayLabel();
		
		String expectedRestrictedHolidayLabel= "RESTRICTED HOLIDAY";
		
Assert.assertEquals(restrictedHolidayLabel, expectedRestrictedHolidayLabel, "RestrictedHoliday label does not match");
		
	}
	
	
	@AfterMethod

	public void closeBrowser() {
		driver.quit();
	}	

}
