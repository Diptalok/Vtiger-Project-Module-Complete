package com.Object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Validation {
	public Validation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[contains(.,\"[\")]") private WebElement Information;
	
	public void validate(String value) {
		if (Information.getText().contains(value)) {
			System.out.println("Test case is passed");
		}
	}
}
