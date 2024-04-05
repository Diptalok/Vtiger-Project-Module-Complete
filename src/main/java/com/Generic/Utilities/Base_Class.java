package com.Generic.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Parameters;

import com.Object.Repository.Home_Page;
import com.Object.Repository.Login_Page;

public class Base_Class {
	
	public WebDriver driver;
	public static WebDriver sDriver;
	public Selenium_Utilities sutil = new Selenium_Utilities();
	public PropertiesFile_Utilities putil = new PropertiesFile_Utilities();
	public ExcelFile_Utility eutil = new ExcelFile_Utility();
	
	@BeforeSuite(groups="RegressionSuite")
	public void DBconfig() {
		System.out.println("DB connection successful");
	}
	
	//@Parameters("Browser")
	@BeforeClass
	public void BrowserLaunch(/*String BROWSER*/) {
		driver=new ChromeDriver();
		/*if(BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		}
		else if(BROWSER.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equals("Chrome")) {
			driver = new ChromeDriver();
		}*/
		sDriver = driver;
		sutil.maximizeWindow(driver);
		sutil.implicitWait(driver);
		System.out.println("Browser launch successful");
	}
	
	@BeforeMethod
	public void logIntoApplication() throws Exception {
		String URL = putil.readData("url");
		String USER = putil.readData("username");
		String PASS = putil.readData("password");
		driver.get(URL);
		Login_Page lp = new Login_Page(driver);
		lp.logIntoApp(USER,PASS);
		System.out.println("Log in successful");
	}
	
	@AfterMethod
	public void signOut() {
		Home_Page hp = new Home_Page(driver);
		hp.mouseHover(driver,hp.getAdminstrator());
		hp.clickOnSignOut();
		System.out.println("Sign out successful");
	}
	
	@AfterClass
	public void BrowserClose() {
		driver.quit();
		System.out.println("Browser closure successful");
	}
	
	@AfterSuite
	public void DBclose() {
		System.out.println("DB closure successful");
	}

}
