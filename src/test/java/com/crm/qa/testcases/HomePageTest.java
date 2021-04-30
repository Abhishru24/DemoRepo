package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewCustomerPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;//to access LoginPage methods
	HomePage homePage;
	NewCustomerPage customerPage;
	
	
	
	// Constructor of class
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();// Calling from parent class
		loginPage = new LoginPage();// constructor of LoginPage class
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void HomePageTitleTest() {
		String homePagetitle = homePage.VerifyHomePageTitle();// accessing HomePage methods
		Assert.assertEquals(homePagetitle, "Guru99 Bank Manager HomePage","Home page title not matched");
	}
	@Test(priority = 2)
	public void VerifyUserNameLabelTest() {
		boolean flag = homePage.verifyCorrectUserName();
		Assert.assertTrue(flag);//If flag is true your assertion will pass
	}
	@Test(priority = 3)
	public void VerifyNewCustomerLink() throws InterruptedException {
		customerPage = homePage.ClickonNewCustomerLink();
		Thread.sleep(2000);
	}
	@AfterMethod
	public void TearDown() {
		driver.quit();// close all instances of driver
	}
}
