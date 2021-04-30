package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewAccountPage;
import com.crm.qa.util.ExcelUtil;

public class NewAccountPageTest extends TestBase {
	
	LoginPage loginPage;//to access LoginPage methods
	HomePage homePage;
	NewAccountPage NewAccountPage;
	String sheetname = "NewAccount";
	
	
	public NewAccountPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();// Calling from parent class
		loginPage = new LoginPage();// constructor of LoginPage class
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@DataProvider(name="NewAccountData")
	public Object[][] getPageTestData() throws IOException {
		Object[][] data = ExcelUtil.getData(sheetname);
		return data;
		
	}
	@Test(dataProvider = "NewAccountData" )
	public void ValidateCreateNewAccount(String customerId,String AccountType,String InitDeposit) throws InterruptedException, IOException {
		NewAccountPage = homePage.ClickonNewAccountLink();
		//NewAccountPage.CreateNewAccount("121356","2000","Savings");//Account Id:91809
		NewAccountPage.CreateNewAccount(customerId,AccountType,InitDeposit);//Account Id:91809
		Thread.sleep(2000);
		Assert.assertTrue(NewAccountPage.verifyLabelAccountSuccess(), "Account not created..Validate your data");
		String AcNum = NewAccountPage.GetNewAccountNumber();
		System.out.println(AcNum);
		//ExcelUtil.setData("NewAccountCreated", AcNum);
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();// close all instances of driver//24230
	}
	

}
