package com.crm.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.Utilities.TestUtil;

public class TestBase {

	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		try {
			prop=new Properties();
			FileInputStream ip =new FileInputStream("C:\\Users\\rokommi\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\Config\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}
		
        catch(IOException e) {
        	e.printStackTrace();
			
		}
		
	}
	
	public static void Initialization()
	{
		String browsreName=prop.getProperty("browser");
		if(browsreName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\rokommi\\Downloads\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browsreName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\rokommi\\Downloads\\geckodriver");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
}