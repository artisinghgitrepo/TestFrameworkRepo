package com.excellence.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.excellence.qa.base.BaseClass;

public class DashboardPage extends BaseClass {
	
	// Creating Page Object Repository
	
	@FindBy (xpath="000000000//span[contains(text(),'Leaves')]")
	WebElement LeaveMenu;
	
	@FindBy (xpath= "//ul[@class='6_leave_management']/li[1]/a")
	WebElement HolidayCalenderMenu;
	
	@FindBy (xpath= "//body/div[1]/main[1]/div[4]/div[1]/div[2]/div[2]/ul[6]/li[2]/a[1]")
	WebElement LeaveApplicationMenu;
	
	@FindBy (xpath="//span[contains(text(),'Ticketing')]")
	WebElement TicketingMenu;
	
	@FindBy (xpath="//body/div[1]/main[1]/div[4]/div[1]/div[2]/div[2]/ul[16]/li[2]/a[1]")
	WebElement MaterialRequestMenu;
	
	// Call class constructor to initialize the elements on the page ("this" means current class objects)	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	// Methods on all the elements
	
	//Method to open Leave application sub menu
	
	public void clickonLeaveMenu() throws InterruptedException {
		//This will scroll the page till the element is found
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", LeaveMenu);
		LeaveMenu.click();
		System.out.println("Leave menu is getting clicked succesfully");
	}
	
	
	//Method to open Holiday Calendar (method will return Holiday calendar page)
	
	public HolidayCalenderPage openHolidayCalender() throws InterruptedException {
		
		//This will scroll the page till the element is found
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", HolidayCalenderMenu);
		
		HolidayCalenderMenu.click();
		
		return new HolidayCalenderPage();
	}
	
   //Method to open Leave Application form (method will return leave application form)
	
	public LeaveApplicationPage openLeaveApplicationForm() {
		
		LeaveApplicationMenu.click();
		
		return new LeaveApplicationPage();
		
	}
	//Method to click on Ticketing menu
	
	public void clickOnTicketingMenu() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", LeaveMenu);
		TicketingMenu.click();
		System.out.println("Ticketing menu is getting clicked succesfully");
			
	}
	//Method to click on Material Request menu
	
	public MaterialRequestPage clickOnMaterialRequest() {
		MaterialRequestMenu.click();
		return new MaterialRequestPage();
	}


	
}
