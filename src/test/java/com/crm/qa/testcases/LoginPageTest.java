package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	// Constructor of class
	public LoginPageTest() {
		super();// for initialization of properties from config file---super class constructor
				// will be called
	}

	@BeforeMethod
	public void setup() {
		initialization();// Calling from parent class
		loginPage = new LoginPage();// constructor of LoginPage class
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.ValidateLoginPageTitle();// accessing LoginPage methods
		Assert.assertEquals(title, "Guru99 Bank Home Page");
	}
	@Test(priority = 2)
	public void HomeLogoTest() {
		boolean flag = loginPage.ValidateLogoImage();
		Assert.assertTrue(flag);//If flag is true your assertion will pass
	}
	@Test(priority = 3)
	public void LoginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//getting values from config.properties
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();// close all instances of driver
	}

}
