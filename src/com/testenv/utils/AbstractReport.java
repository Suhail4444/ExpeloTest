package com.testenv.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class AbstractReport implements FileConstants
{

	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest logger;
	static String reportDir = "";
    static String reportName = "";
    
	@BeforeSuite(alwaysRun = true) 
	public void startReport()
	{
		File file = new File("./Reports");
		if (!file.exists())
		{
			file.mkdir();
		}
		reportName = "TestReport_"+new SimpleDateFormat("ddmmSsS").format(new Date()) + ".html";
		String string = "./Reports/" + reportName;
		reportDir = string;
		htmlReporter = new ExtentHtmlReporter(string);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setDocumentTitle("Sample Automation Report");
		htmlReporter.config().setReportName("Sample Automation Report");
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SKIP)
		{
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		}
		SeleniumUtils.quitDriver();
	}

	public void getMethodName()
	{
		final StackTraceElement e = Thread.currentThread().getStackTrace()[2];
		final String s = e.getClassName();
		logger = extent.createTest(s.substring(s.lastIndexOf('.') + 1, s.length()) + " | " + e.getMethodName());
	}

	public static void testInfo(String message)
	{
		logger.log(Status.INFO, MarkupHelper.createLabel(message, ExtentColor.BLUE));
	}
	
	@AfterSuite(alwaysRun = true)
	public void endReport() throws Exception
	{
		extent.flush();
	}
}
