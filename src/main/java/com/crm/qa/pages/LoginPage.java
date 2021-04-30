package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {//Class extends other class

	//Page Factory - OR:
	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@role = 'presentation']")
	WebElement Guru99Logo;
	
	//Initializing page objects
	public LoginPage() {//constructor of class
		
		PageFactory.initElements(driver, this);//all the variables declared above will be initialized to driver---this indicates current class object
		
	}
	
	//actions
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean ValidateLogoImage() {
		return Guru99Logo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		//HomePage is landing of LoginPage--after clicking on login button it is going to homepage --that is why it should return HomePage class object
		
		return new HomePage();
	}
}


