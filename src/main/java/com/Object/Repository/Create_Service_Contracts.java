package com.Object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Generic.Utilities.Selenium_Utilities;

public class Create_Service_Contracts extends Selenium_Utilities{
	public Create_Service_Contracts(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="subject") private WebElement Subject;
	@FindBy(id="sc_related_to_type") private WebElement Realted;
	@FindBy(name="tracking_unit") private WebElement TrackingUnit;
	@FindBy(name="contract_status") private WebElement Status;
	@FindBy(name="contract_priority") private WebElement Priority;
	@FindBy(name="contract_type") private WebElement Type;
	
	public WebElement getType() {
		return Type;
	}

	public WebElement getRealted() {
		return Realted;
	}

	public WebElement getTrackingUnit() {
		return TrackingUnit;
	}

	public WebElement getStatus() {
		return Status;
	}

	public WebElement getPriority() {
		return Priority;
	}

	@FindBy(id="total_units") private WebElement total_units;
	@FindBy(id="used_units") private WebElement used_units;
	@FindBy(xpath="//input[@value=\"  Save  \"]") private WebElement save;
	@FindBy(id="jscal_trigger_start_date") private WebElement startDate;
	@FindBy(xpath="//td[.=\"28\"]") private WebElement sDate;
	
	
	public void FillTheForm(String sub,String total,String used) {
		Subject.sendKeys(sub);
		total_units.sendKeys(total);
		used_units.sendKeys(used);
	}
	
	public void clickOnStartDate() {
		startDate.click();
	}
	
	public void clickOnsDate() {
		sDate.click();
	}
	
	public void save() {
		save.click();
	}
	
	@FindBy(xpath="//img[@title=\"Select\"]") private WebElement addRelated;
	
	public void clickOnAddRelated() {
		addRelated.click();
	}
	
	@FindBy(xpath="//a[.=\"DS Solutions\"]") private WebElement addOrg;
	
	public void clickOnAddOrg() {
		addOrg.click();
	}

}
