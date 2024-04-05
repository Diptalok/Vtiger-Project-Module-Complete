package com.Object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	public Login_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name") private WebElement useredt;
	@FindBy(name="user_password") private WebElement passedt;
	@FindBy(id="submitButton") private WebElement lgnbtn;
	
	public void logIntoApp(String user, String pass) {
		useredt.sendKeys(user);
		passedt.sendKeys(pass);
		lgnbtn.click();
	}

}
