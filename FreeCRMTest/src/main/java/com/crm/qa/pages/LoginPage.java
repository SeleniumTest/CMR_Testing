package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	WebElement LoginBtn;
	@FindBy(xpath="//input[@value='Login']")
	WebElement SignUpBtn;
	@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement Logoimg;

	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String ValidateLoginPageTitle() {
		
		
		return driver.getTitle();
	}
	
	public Boolean ValidateCRMImage() {
		
		return Logoimg.isDisplayed();
		
	}
	
	
	public HomePage Login(String un,String Pwd)
	{
		username.sendKeys(un);
		password.sendKeys(Pwd);
		LoginBtn.submit();
		
		return new HomePage();
	}
	
	
}
