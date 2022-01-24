package com.excellence.qa.testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.excellence.qa.base.BaseClass;
import com.excellence.qa.pages.DashboardPage;
import com.excellence.qa.pages.LeaveApplicationPage;
import com.excellence.qa.pages.LoginPage;

public class LeaveApplicationPageTest extends BaseClass {
	
	LoginPage loginpage_obj;
	
	DashboardPage dashboardPage_obj;
	
	LeaveApplicationPage leaveApplicationPage_obj;
	
	public LeaveApplicationPageTest() {
		super();
	}
	
	@BeforeMethod

	public void setup() throws InterruptedException {
		initialization();
		loginpage_obj=new LoginPage();	
		dashboardPage_obj= new DashboardPage();
		dashboardPage_obj= loginpage_obj.doLogin();
		Thread.sleep(3000);
		dashboardPage_obj= new DashboardPage();
		dashboardPage_obj.clickonLeaveMenu();
		Thread.sleep(5000);
		dashboardPage_obj.openLeaveApplicationForm();
		Thread.sleep(5000);
		leaveApplicationPage_obj= new LeaveApplicationPage();
		
	}
	
	@Test(enabled=false)
	
	public void submitLeaveApplication() throws InterruptedException {

		leaveApplicationPage_obj.clickOnTypeOfLeave();
		
		leaveApplicationPage_obj.selectTypeOfLeave();
		
		leaveApplicationPage_obj.clickOnFullDay();
		
		leaveApplicationPage_obj.enterFromDate();
		
		leaveApplicationPage_obj.enterToDate();
		
		leaveApplicationPage_obj.enterReason();
		
		Thread.sleep(5000);
	
		leaveApplicationPage_obj.submitForm();
		Thread.sleep(5000);
		leaveApplicationPage_obj.confirm();
		
		
	}
	
	@Test
	
	public void verificationOfAppliedLeave() {
		
		String actualLeave= leaveApplicationPage_obj.verifyAppliedLeave();
		
		//List<String> actualLeaveArrayList = new ArrayList<String>(Arrays.asList(actualLeaveArray));
		//List<String> actualLeaveArrayList = new ArrayList<String>(Arrays.asList(leaveApplicationPage_obj.verifyAppliedLeave()));
		Assert.assertTrue(actualLeave.contains("testing"),"Applied leave is not matching with search result");
		
		
	}
	
	@AfterMethod

	public void closeBrowser() {
		driver.quit();
	}

}
