package com.Generic.Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener {

	public ExtentReports report;
	public ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " Test Execution Started");
		test = report.createTest("Service Contracts");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " Test Execution Passed");
		test.log(Status.PASS, "Test Execution passed");
		
		Selenium_Utilities s = new Selenium_Utilities();
		try {
			String path = s.screenshot(Base_Class.sDriver, "validation Screenshot for passed script");
			test.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " Test Execution Failed");
		test.log(Status.FAIL, "Test Execution failed");
		
		Selenium_Utilities s = new Selenium_Utilities();
		try {
			String path = s.screenshot(Base_Class.sDriver, "validation Screenshot for failed script");
			test.addScreenCaptureFromPath(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " Test Execution Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println(context.getAllTestMethods()+" Test Suite Started");
		Java_Utility j = new Java_Utility();
		String date = j.getDate();
		
		ExtentSparkReporter rep = new ExtentSparkReporter(".//Extent Report/Reports "+date+".html");
		rep.config().setDocumentTitle("Execution Report");
		rep.config().setReportName("Service Contract Report");
		rep.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(rep);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base url", "http://localhost.8888/");
		report.setSystemInfo("Reporter Name", "Diptalok");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(context.getAllTestMethods() + " Test Suite Finished");
		report.flush();
	}

}
