package com.AutomationAsginmnt.Apps;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.AutomationAsignment.utility.ConfigReader;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TommyHController{
	static Logger logger = Logger.getLogger(TommyHController.class);
	private String appURL = null;
	TOMMYHILFIGERPOJO thPojo=new TOMMYHILFIGERPOJO();
	TommyHController(){
		
		thPojo.setUiEmail(ConfigReader.getProperty("UI.properties", "EMAIL"));
		thPojo.setUiPassword(ConfigReader.getProperty("UI.properties", "PASSWORD"));
		thPojo.setInCorrectUiPassword(ConfigReader.getProperty("UI.properties", "INCORRECTPASSWORD"));
		thPojo.setUierrorMessage(ConfigReader.getProperty("UI.properties", "ERRORMESSAGE"));
		thPojo.setFirstName(ConfigReader.getProperty("UI.properties", "FIRSTNAME"));
		thPojo.setLastName(ConfigReader.getProperty("UI.properties", "LASTNAME"));
		thPojo.setStreetName(ConfigReader.getProperty("UI.properties", "STREETNAME"));
		thPojo.setHouseName(ConfigReader.getProperty("UI.properties", "STREETNAME"));
		thPojo.setPlaceName(ConfigReader.getProperty("UI.properties", "PLACE"));
		thPojo.setZipCode(ConfigReader.getProperty("UI.properties", "POSTCODE"));
		thPojo.setPhoneNumber(ConfigReader.getProperty("UI.properties", "PHONE"));
	}

	public void launchApplication(RemoteWebDriver driver) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		appURL = ConfigReader.getProperty("UI.properties", "APPURL");
		driver.get(appURL);

	}

	public void LoginFlow(RemoteWebDriver driver, ExtentTest test)
			throws Exception {
		try {
			logger.info("Start Testcase ==>LoginFlow");
			test.log(Status.INFO,"In Home Page");
			LoginPageValidation lpv=new LoginPageValidation(driver);
			lpv.clickonAcceptCookiesBtn();
			test.log(Status.INFO, "Clicked on Accept Cookies");
			lpv.clickonSignInBtn();
			test.log(Status.INFO, "Click on Sign in Button");
			lpv.enterEmail(thPojo.getUiEmail());
			test.log(Status.INFO, "Entered Email ID");
			//lpv.enterPassword(thPojo.getInCorrectUiPassword());
			test.log(Status.INFO, "Entered InCorrect Password");
			lpv.clickonSubmitBtn();
			String errorMsg=lpv.getLoginErrorMessage();
			Assert.assertEquals(errorMsg, thPojo.getUierrorMessage());
			lpv.enterPassword(thPojo.getUiPassword());
			lpv.clickonSubmitBtn();
			test.log(Status.INFO, "Click on Submit Button");
			
		} catch (Exception e) {
			throw new Exception("Error occured in PLoginValidationFlow" + e.getMessage());
		}

	}
	
	public void AddNewAddressFlow(RemoteWebDriver driver, ExtentTest test)
			throws Exception {
		try {
			logger.info("Start Testcase ==>LoginFlow");
			test.log(Status.INFO,"In Home Page");
			AddNewAddressValidation ana=new AddNewAddressValidation(driver);
			test.log(Status.INFO, "Clicked on Mijn Account");
		    ana.clickonMijnAccountBtn();
		    test.log(Status.INFO, "Clicked on AddressBook");
		    ana.clickonAddressBookBtn();
		    test.log(Status.INFO, "Clicked on Add New Address Btn");
		    ana.clickonAddNewAddressBtn();
		    test.log(Status.INFO, "filled First Name");
		    ana.fillFirstName(thPojo.getFirstName());
		    test.log(Status.INFO, "filled Last Name");
		    ana.fillLastName(thPojo.getLastName());
		    test.log(Status.INFO, "filled Street Name");
		    ana.fillStreetName(thPojo.getStreetName());
		    test.log(Status.INFO, "filled House Number");
		    ana.fillHouseNumber(thPojo.getHouseName());
		    test.log(Status.INFO, "filled Place Name");
		    ana.fillPlaceName(thPojo.getPlaceName());
		    test.log(Status.INFO, "filled Zip Code");
		    ana.fillZipCode(thPojo.getZipCode());
		    test.log(Status.INFO, "filled Phone Number");
		    ana.fillPhoneNumber(thPojo.getPhoneNumber());
		    test.log(Status.INFO, "clicked On Address Save Btn");
		    ana.clickonAddressSaveBtn();
		    test.log(Status.INFO, "Verified newly added Address");
		    String addedAddress = ana.viewAddedAddress(thPojo.getStreetName());
		    Assert.assertEquals(addedAddress, thPojo.getUierrorMessage());
			
		} catch (Exception e) {
			throw new Exception("Error occured in AddNewAddressFlow" + e.getMessage());
		}

	}

}
