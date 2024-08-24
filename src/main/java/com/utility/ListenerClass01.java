package com.utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.actionDriver.Action;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.base.BaseClass1;

public class ListenerClass01 extends ExtentManager implements ITestListener 
{
	
	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
		test = extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) 
	{
		// TODO Auto-generated method stub
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Pass Test case is: " + result.getName());
		}
	}

	public void onTestFailure(ITestResult result) 
	{
		// TODO Auto-generated method stub
		String imgPath = Action.screenShot(BaseClass1.driver, result.getName());
		
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			try {
				test.log(Status.FAIL,MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
				
				test.log(Status.FAIL,MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));	
				
				test.fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
				
			}
			
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}




	public void onTestSkipped(ITestResult result) 
	{
		// TODO Auto-generated method stub
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
		}
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) 
	{
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) 
	{
		// TODO Auto-generated method stub
		
	}


}

