package com.AutomationAsginmnt.Apps;

import org.testng.annotations.Test;

import com.AutomationAsignment.utility.DefaultDriverManager;
import com.AutomationAsignment.utility.TestClassUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

/**
 * @author Amit
 *
 */
public class TOMMYHILFIGERTest extends TestClassUtil {
	static RemoteWebDriver driver;

	static TOMMYHILFIGERPOJO Practicepojo;

	@BeforeMethod
	public void launchApp() throws Exception {
		driver = new DefaultDriverManager().getDriver();
		Practicepojo = new TOMMYHILFIGERPOJO();
		new TommyHController().launchApplication(driver);
	}

	@Test
	public void testAutomationPracticeTest() throws Exception {
		String testCasename = new Object() {
		}.getClass().getEnclosingMethod().getName();
		test = extent.createTest(testCasename);
		new TommyHController().LoginFlow(driver, test);
        new TommyHController().AddNewAddressFlow(driver, test);
	}

	@AfterMethod
	public void teardown() {
		 driver.quit();
	}

}
