package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class NewCustomerPage extends TestBase {
	
	@FindBy(xpath = "//p[contains(text(),'Add New Customer')]")
	WebElement Contactslabel;
	
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement SubmitBtn;
	
	@FindBy(xpath = "//input[@value='Reset']")
	WebElement ResetBtn;
	
	public NewCustomerPage() {
		PageFactory.initElements(driver, this);

	}
	public boolean VerifyAddNewCustomerLabel() {
		return Contactslabel.isDisplayed();
	}
	
	
	
	

}
