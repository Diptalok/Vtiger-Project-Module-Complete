package com.Object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServiceContracts_Page {
	public ServiceContracts_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[contains(@alt,\"Cr\")]") private WebElement Create;
	
	public void clickOnCreateNewServiceContract() {
		Create.click();
	}

}
