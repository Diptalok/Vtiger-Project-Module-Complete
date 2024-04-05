package com.Object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Generic.Utilities.Selenium_Utilities;

public class Home_Page extends Selenium_Utilities{
	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[.=\"More\"]") private WebElement More;
	@FindBy(xpath="//a[.=\"Service Contracts\"]") private WebElement Service;
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]") private WebElement Adminstrator;
	@FindBy(linkText="Sign Out") private WebElement signOut;
	
	public void clickOnServiceContracts() {
		Service.click();
	}
	
	public void clickOnSignOut() {
		signOut.click();
	}

	public WebElement getMore() {
		return More;
	}

	public WebElement getAdminstrator() {
		return Adminstrator;
	}
	
	

}
