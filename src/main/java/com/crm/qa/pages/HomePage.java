package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath ="//td[contains(text(),'Manger Id : mngr320737')]")
	WebElement userNameLabel;
	
	
	@FindBy(xpath ="//a[contains(text(),'New Customer')]")
	WebElement NewCustomerLink;
	
	@FindBy(xpath ="//a[contains(text(),'New Account')]")
	WebElement NewAccountLink;
	
	@FindBy(xpath ="//a[contains(text(),'Balance Enquiry')]")
	WebElement BalanceEnquiryLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String VerifyHomePageTitle() {
		return driver.getTitle();
	}
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	public NewAccountPage ClickonNewAccountLink() {
		NewAccountLink.click();
		
		return new NewAccountPage();//Clicking on NewAccount will land on New Accoutn Page
	}
	public NewCustomerPage ClickonNewCustomerLink() {
		NewCustomerLink.click();
		
		return new NewCustomerPage();//Clicking on NewAccount will land on New Accoutn Page
	}
	public BalanceEnquiryPage ClickonBalanceEnquiryLink() {
		BalanceEnquiryLink.click();
		
		return new BalanceEnquiryPage();//Clicking on NewAccount will land on New Accoutn Page
	}
	

	

}
