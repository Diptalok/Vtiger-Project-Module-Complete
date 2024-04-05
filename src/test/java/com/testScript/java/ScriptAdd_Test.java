package com.testScript.java;

//import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Generic.Utilities.Base_Class;
import com.Object.Repository.Create_Service_Contracts;
import com.Object.Repository.Home_Page;
import com.Object.Repository.ServiceContracts_Page;
import com.Object.Repository.Validation;


@Listeners(com.Generic.Utilities.ListenersImplementation.class)
public class ScriptAdd_Test extends Base_Class {
	
	@Test (groups="RegressionSuite") //,retryAnalyzer=com.Generic.Utilities.RetryanalyzerImplementation.class
	public void service_Contract_Test() throws Exception {
		Home_Page hp = new Home_Page(driver);
		hp.mouseHover(driver, hp.getMore());
		hp.navigate(driver,"navigate");
		ServiceContracts_Page sc = new ServiceContracts_Page(driver);
		sc.clickOnCreateNewServiceContract();
		Create_Service_Contracts csc = new Create_Service_Contracts(driver);
		String SUB = eutil.readData("Sheet1", 1, 0);
		String TOT = eutil.readData("Sheet1", 1, 1);
		String USE = eutil.readData("Sheet1", 1, 2);
		csc.FillTheForm(SUB, TOT, USE);
		csc.dropDown(csc.getRealted(), "Organizations");
		csc.dropDown(csc.getType(), "Services");
		csc.dropDown(csc.getStatus(), "In Progress");
		csc.dropDown(csc.getTrackingUnit(), "Hours");
		csc.dropDown(csc.getPriority(), "Normal");
		csc.clickOnAddRelated();
		csc.clickOnAddRelated();
		csc.windowHandle(driver);
		csc.clickOnAddOrg();
		csc.parentWindow(driver);
		csc.clickOnStartDate();
		csc.clickOnsDate();
		//Assert.fail();
		csc.save();
		Validation v = new Validation(driver);
		v.validate(SUB);
	}
}
