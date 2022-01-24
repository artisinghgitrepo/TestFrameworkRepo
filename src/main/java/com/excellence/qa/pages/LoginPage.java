package com.excellence.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.excellence.qa.base.BaseClass;

public class LoginPage extends BaseClass {
	
	// Creating Page Object Repository (taking element's location and returning the elements)
	//We use @CacheLookup>locator will be saved in cache, instead of html dom of page it will give the locator from cache 
			//so speed wil be improved but we should use it for only those elements which is not gonna change by refreshing/dom 
			//structure should not be changed,otherwise it will throw stale element exception
	
		@FindBy (xpath="//input[@id='email']") 
		//@CacheLookup
		WebElement username;
		
	    @FindBy (xpath="//input[@id='password']")
		//@CacheLookup
		WebElement pass;

	    @FindBy (xpath ="//button[contains(text(),'Login')]")
	   // @CacheLookup

	    WebElement loginButton;
	    
	// Call class constructor to initialize the elements on the page ("this" means current class objects)
	    
    public LoginPage() {
	
	PageFactory.initElements(driver, this);
	
}	
    
   // Methods on all the elements 
    
   //Return the title of the page
    
    public String validateLoginPageTitle() {
    	return driver.getTitle();
    }
    
    // Method to login (Usename and password we are taking from config file)
    // After login dashboard will be returned that is why we are returning DashboardPage (in page factory will return using class name but in Test file we need to create object of the class)
    
       public DashboardPage doLogin() {
		
		username.sendKeys(prop.getProperty("Username"));
		
		pass.sendKeys(prop.getProperty("Password"));
		
		loginButton.submit();
		
		System.out.println("Login button is getting clicked succesfully");
		
		return new DashboardPage();
		
	}



}
