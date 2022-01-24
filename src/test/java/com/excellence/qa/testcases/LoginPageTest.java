package com.excellence.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.excellence.qa.base.BaseClass;
import com.excellence.qa.pages.DashboardPage;
import com.excellence.qa.pages.LoginPage;

public class LoginPageTest extends BaseClass {
	
// Create object of LoginPage to use its methods
	
	LoginPage loginpage_obj;
	//Created object of Dashboard page as login method returning the Dashboard page object
	DashboardPage dashboardPage_obj;
	
//Call current class constructor with super so that it will call BaseClass constructor where system properties are defined
	public LoginPageTest() {
		super();
	}
	
	
@BeforeMethod

public void setup() {
	initialization();
	loginpage_obj=new LoginPage();	
}

//Using Assert to validate the actual value is correct or not

@Test

public void verifyTitleOfPage() {
	String title= loginpage_obj.validateLoginPageTitle();
	Assert.assertEquals(title, "Excellence Center");
}

@Test

public void verifyLogin() {
	// Login method is returning Dasboard page object as we have also defined in page factory
	dashboardPage_obj = loginpage_obj.doLogin();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

@AfterMethod

public void closeBrowser() {
	driver.quit();
}
		

}
