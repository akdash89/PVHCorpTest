package com.AutomationAsignment.utility;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestClassUtil {

	static Logger logger = Logger.getLogger(TestClassUtil.class);
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeSuite
	public void setup() {
		BasicConfigurator.configure();
		String path = System.getProperty("user.dir") + "//"
				+ ConfigReader.getProperty("Config.properties", "REPORT_PATH");
		htmlReporter = new ExtentHtmlReporter(path);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "MAC OS BIG SUR");
		extent.setSystemInfo("Host Name", "Amit");
		extent.setSystemInfo("Environment", "UAT");
		extent.setSystemInfo("User Name", "Amit");
		htmlReporter.config().setReportName("AUTOMATION PRACTICE -Automation Execution Report");

		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("REQRES API Execution Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		logger.info("---report Updated For tESTCASE---");

		System.out.println(result.getStatus() + "RESULT");
		if (result.getStatus() == ITestResult.FAILURE) {

			
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getMethodName() + " Test case FAILED due to below issues:",
					ExtentColor.RED));

			test.fail(result.getThrowable());
			

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			
			test.log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName() + " Test Case PASSED", ExtentColor.GREEN));
	} else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getMethod().getMethodName() + " Test Case SKIPPED", ExtentColor.BLUE));
			test.skip(result.getThrowable());
		}

		extent.flush();
	}
}
