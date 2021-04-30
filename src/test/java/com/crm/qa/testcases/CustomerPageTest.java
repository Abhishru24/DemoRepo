package com.crm.qa.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewCustomerPage;

public class CustomerPageTest extends TestBase {
	
	LoginPage loginPage;//to access LoginPage methods
	HomePage homePage;
	NewCustomerPage customerPage;
	
	public CustomerPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();// Calling from parent class
		loginPage = new LoginPage();// constructor of LoginPage class
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		customerPage = homePage.ClickonNewCustomerLink();//Click on link of New Customer
	}
	
	@Test(priority=1)
	public void VerifyAddNewCustomerLabel() {
		Assert.assertTrue("Add New Customer label is not dispalyed", customerPage.VerifyAddNewCustomerLabel());
	}
//	@Test()
//	public void CreateNewCustomer() {
//		
//	}
//	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();// close all instances of driver
	}
}
