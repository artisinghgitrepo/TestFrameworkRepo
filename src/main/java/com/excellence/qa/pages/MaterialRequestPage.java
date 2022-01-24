package com.excellence.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.excellence.qa.base.BaseClass;

public class MaterialRequestPage extends BaseClass {
	
	@FindBy (xpath="//input[@id='high']")
	WebElement Priority;
	
	@FindBy (xpath="//input[@id='systemAdmin']")
	WebElement Department;
	
	@FindBy (xpath="//input[@id='hardware_type']")
	WebElement Item;
	
	@FindBy (xpath="//input[@id='usagetiimeframe']")
	WebElement UsageTime;
	
	@FindBy (xpath="//textarea[@id='hardware_detail']")
	WebElement ItemDetail;
	
	@FindBy (xpath="//textarea[@id='comments']")
	WebElement Comment;
	
	@FindBy (xpath="//input[@id='new']")
	WebElement Type;
	
	@FindBy (xpath="//button[@id='submit-leave']")
	WebElement Submit;
		
	
	public MaterialRequestPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Method to raise a material request through data provider (data driven approach)
	
	public void createMaterialRequest(String itemName, String usageTime, String itemDetail, String comment) {
		Priority.click();
		Department.click();
		Item.sendKeys(itemName);
		UsageTime.sendKeys(usageTime);
		ItemDetail.sendKeys(itemDetail);
		Comment.sendKeys(comment);
		Type.click();
		//This script to scroll down 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView();", Submit);
		js.executeScript("scroll(0, 250)");
		Submit.click();
	}


}
