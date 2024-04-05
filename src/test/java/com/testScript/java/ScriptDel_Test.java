package com.testScript.java;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Generic.Utilities.Base_Class;
import com.Object.Repository.Delete_Page;


@Listeners(com.Generic.Utilities.ListenersImplementation.class)
public class ScriptDel_Test extends Base_Class {
	
	@Test (retryAnalyzer=com.Generic.Utilities.RetryanalyzerImplementation.class)
	public void service_Contract_Test() throws Exception {
		Thread.sleep(20000);
		sutil.navigate(driver, "nextUrl");
		Delete_Page dp = new Delete_Page(driver);
		dp.select();
		dp.delete();
		sutil.alertAccept(driver);
	}
}
