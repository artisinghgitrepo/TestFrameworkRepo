package com.excellence.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.excellence.qa.base.BaseClass;

public class LeaveApplicationPage extends BaseClass {
	
	
	@FindBy (xpath="//body/div[1]/main[1]/div[4]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]/div[1]/div[1]/div[1]")
	WebElement TypeOfLeaveDrop;
	
	@FindBy (xpath="//body/div[1]/main[1]/div[4]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[3]/a[1]/span[1]")
	WebElement CLOption;
	
	@FindBy (xpath="//body/div[1]/main[1]/div[4]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/label[1]")
	WebElement FullDayRadio;
	
	@FindBy (xpath="//body/div[1]/main[1]/div[4]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[2]/label[1]")
	WebElement HalfDayRadio;
	
	@FindBy (xpath="//body/div[1]/main[1]/div[4]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[3]/label[1]")
	WebElement ShortLeaveRadio;
	
	@FindBy (xpath="//input[@id='date_from']")
	WebElement LeaveAppliedFrom;
	
	@FindBy (xpath="//input[@id='date_to']")
	WebElement LeaveAppliedTo;
	
	@FindBy (xpath="//textarea[@id='reason']")
	WebElement Reason;
	
	@FindBy (xpath="//button[@id='submit-leave']")
	WebElement Submit;
	
	@FindBy (xpath="//button[@id='153e1bb3-f21e-4397-babc-ae7c41b14602']")
	WebElement ConfirmationOk;
	
	//Find out the leaves table
	@FindBy (xpath="//table[@id='dataTables-leave']")
	WebElement LeaveTable;
	
	public LeaveApplicationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnTypeOfLeave() {
		TypeOfLeaveDrop.click();
		System.out.println("Leave type clicked");
		
	}
	
	public void selectTypeOfLeave() {
		CLOption.click();
		System.out.println("Leave type selected");
		
	}
	
	public void clickOnFullDay() {
		FullDayRadio.click();
		System.out.println("Full day selected");
		
	}
	
    public void clickOnHalfDay() {
    	HalfDayRadio.click();
		
	}

    public void clickOnShortLeave() {
    	ShortLeaveRadio.click();
	
    }
    
    public void enterFromDate() {
    	LeaveAppliedFrom.sendKeys("2021-04-15");
    	LeaveAppliedFrom.sendKeys(Keys.ENTER);
    	System.out.println("From date entered");
    	
    }
    
    public void enterToDate() {
    	LeaveAppliedTo.sendKeys("2021-04-15");
    	LeaveAppliedTo.sendKeys(Keys.ENTER);
    	System.out.println("To date enetered");
    	
    }
    
    public void enterReason() {
    	Reason.sendKeys("Going out of station");
    	System.out.println("Reason entered");
    }
    
    public void submitForm() {
    	// explicit wait - to wait for the compose button to be click-able
    	//WebDriverWait wait = new WebDriverWait(driver,30);
    	//wait.until(ExpectedConditions.visibilityOfElementLocated((By) Submit));
    	Submit.click();
    }
	
	public void confirm() {
		ConfirmationOk.click();
	}	
	
	public String verifyAppliedLeave() {
		
		String colValue="";
		//create a List of WebElements that represent each row in the table
		List<WebElement> leaveTableRows= LeaveTable.findElements(By.tagName("tr"));
		String[] myArray = new String[leaveTableRows.size()];
		leaveTableRows.toArray(myArray);
		
		// And iterate over them, getting the cells 
		for (WebElement row : leaveTableRows) { 
		    List<WebElement> cells = row.findElements(By.tagName("td")); 

		    // Print the contents of each cell
		    for (WebElement cell : cells) { 
		        //System.out.println(cell.getText());
		        		colValue=cell.getText();
		        		System.out.println(colValue);
		    }
		}
		//System.out.println(colValue);
		return colValue;
	}


}
