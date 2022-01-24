package com.excellence.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.excellence.qa.base.BaseClass;

public class HolidayCalenderPage extends BaseClass {
	
	@FindBy (xpath="/html/body/div[1]/main/div[4]/div/div[3]/div/div[1]/div/h5")
	WebElement HolidayLabel;
	
	@FindBy (xpath="/html/body/div[1]/main/div[4]/div/div[3]/div/div[2]/div/h5")
	WebElement RestrictedHolidayLabel;
	
	public HolidayCalenderPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyHolidayLabel() {
		
	return HolidayLabel.getText();
		
	}
	
    public String verifyRestrictedHolidayLabel() {
    	return RestrictedHolidayLabel.getText();
		
	}
	
	
	

}
