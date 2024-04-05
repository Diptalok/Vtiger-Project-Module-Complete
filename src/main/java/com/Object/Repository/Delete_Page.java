package com.Object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Delete_Page {
	public Delete_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="selectall") private WebElement selectAll;
	@FindBy(xpath="//input[@value=\"Delete\"]") private WebElement delete;
	
	public void select() {
		selectAll.click();
	}
	
	public void delete() {
		delete.click();
	}
	
}
