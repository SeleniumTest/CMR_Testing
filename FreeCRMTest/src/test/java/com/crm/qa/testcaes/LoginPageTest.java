package com.crm.qa.testcaes;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.HomePage;

public class LoginPageTest extends TestBase {
	
	LoginPage LoginPage;
	HomePage HomePage;
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp()
	{
		Initialization();
		 LoginPage=new LoginPage();
		 
	}
	@Test(priority=2)
	public void loginPageTitleTest()
	{
		String title=LoginPage.ValidateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	@Test(priority=3)
	public void CRMimgaeTest()
	{
		
		boolean flag=LoginPage.ValidateCRMImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=1)
	public void LoginTest()
	{
		HomePage=LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
