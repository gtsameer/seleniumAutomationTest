package com.Hrm.genericLib;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SampleListenerTest implements ITestListener{

	public void onTestFailure(ITestResult result) {
		String failureTestName= result.getMethod().getMethodName();
		try {
			ReportLib.getScreenshot(failureTestName);
		} catch (IOException e) {}
			
	}


	public void onTestSuccess(ITestResult result) {
		String passTestName= result.getMethod().getMethodName();
		System.out.println(passTestName+" got sucessfully executed");
		
	}


	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}


	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}


	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}


	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
