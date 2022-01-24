package com.excellence.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excellence.qa.base.BaseClass;
import com.excellence.qa.pages.DashboardPage;
import com.excellence.qa.pages.LoginPage;
import com.excellence.qa.pages.MaterialRequestPage;
import com.excellence.qa.util.TestUtil;

public class MaterialRequestPageTest extends BaseClass {
	
	LoginPage loginpage_obj;
	
	DashboardPage dashboardPage_obj;
	
	MaterialRequestPage materialRequestPage_obj;
	
	//Giving sheet name here
	String sheetName="Material";
	
	public MaterialRequestPageTest() {
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
		dashboardPage_obj.clickOnTicketingMenu();
		Thread.sleep(5000);
		dashboardPage_obj.clickOnMaterialRequest();
		Thread.sleep(5000);
		materialRequestPage_obj= new MaterialRequestPage();	
	}
	
	//Using data provide to get test data from excel
	@DataProvider
	
	public Object[][] getTestDataFromSheet() throws Exception {
		
		Object [][] data= TestUtil.getTestData(sheetName);
		
		return data;
	}
	
	//Giving data provider name in the test annotation
	@Test(dataProvider="getTestDataFromSheet")
	
	public void raiseMaterialRequest(String itemName, String usageTime, String itemDetail, String comment) throws Exception {
		materialRequestPage_obj.createMaterialRequest(itemName, usageTime, itemDetail, comment);
		
	}
	
	
	@AfterMethod

	public void closeBrowser() {
		driver.quit();
		
	}
	

}
