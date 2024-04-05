package com.Generic.Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryanalyzerImplementation implements IRetryAnalyzer {
	int no = 0;
	int count = 2;
	@Override
	public boolean retry(ITestResult result) {
		while(no<count) {
			no++;
			return true;
		}
		return false;
	}

}
