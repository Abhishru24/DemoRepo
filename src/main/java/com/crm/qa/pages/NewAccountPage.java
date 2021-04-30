package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class NewAccountPage extends TestBase {
	
	@FindBy(name="cusid")
	@CacheLookup
	WebElement CustomerId;
	
	@FindBy(name="selaccount")
	WebElement SelectAccount;
	
//	@FindBy(xpath ="//input[@name = 'inideposit']")
	@FindBy(xpath ="//table//tbody//tr[4]//td[2]//input[@name = 'inideposit']")
	WebElement InitialDeposit;
	
	
	@FindBy(xpath="//input[(@value= 'submit')]")
	WebElement btnSubmit;
	
	@FindBy(xpath="//p[text()='Account Generated Successfully!!!']")
	WebElement LabelAccountSuccess;
	
	@FindBy(xpath="//table//tbody//tr[1]//td[2]")
	WebElement NewAccountNumberCreated;
	
	
	
	public NewAccountPage() {
		PageFactory.initElements(driver, this);

	}
	public void CreateNewAccount(String intCustomerId,String AccountType,String intInitialDeposit) throws InterruptedException {
		
		CustomerId.sendKeys(intCustomerId);//26282
		
		Select select = new Select(SelectAccount);
		select.selectByVisibleText(AccountType);
		
		InitialDeposit.sendKeys(intInitialDeposit);
		Thread.sleep(2000);
		btnSubmit.click();
		
	}
	public boolean verifyLabelAccountSuccess(){
		return LabelAccountSuccess.isDisplayed();
	}
	public String GetNewAccountNumber() {
		String AccNumber = NewAccountNumberCreated.getAttribute("text");
		return AccNumber;
	}

}
