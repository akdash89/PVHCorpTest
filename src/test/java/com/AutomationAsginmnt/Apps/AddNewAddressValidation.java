package com.AutomationAsginmnt.Apps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.AutomationAsignment.utility.ActionBot;
import com.AutomationAsignment.utility.ConfigReader;

public class AddNewAddressValidation {

	RemoteWebDriver driver;
	int timeOutPeriod;
	/* All WebElements are identified by @FindBy annotation */

	public AddNewAddressValidation(RemoteWebDriver driver) {

		this.driver = driver;

		// This initElements method will initialize all webelements

		PageFactory.initElements(driver, this);
		timeOutPeriod = Integer.parseInt(ConfigReader.getProperty("config.properties", "TIMEOUT"));

	}
	

	@FindBy(xpath = " //a[@aria-label='Bekijk mijn account']")
	WebElement MijnAccountBtn;

	public void clickonMijnAccountBtn() throws Exception {

		ActionBot.focusAndclick(driver, MijnAccountBtn);

	}
	
	@FindBy(xpath = "//a[starts-with(@data-testid, '/myaccount/addressbook?')]")
	WebElement AddressBookBtn;

	public void clickonAddressBookBtn() throws Exception {

		ActionBot.focusAndclick(driver, AddressBookBtn);

	}
	//*[contains(@data-testid,'address-add-button')]
	@FindBy(xpath = "//*[contains(@data-testid,'address-add-button')]")
	WebElement AddNewAddressBtn;

	public void clickonAddNewAddressBtn() throws Exception {

		ActionBot.focusAndclick(driver, AddNewAddressBtn);

	}
	@FindBy(xpath = "//*[contains(@id,'firstName')]")
	WebElement FirstName;
	
	public void fillFirstName(String firstName) throws Exception {

		ActionBot.enter_Text(driver, this.FirstName, firstName);

	}
	
	@FindBy(xpath = "//*[contains(@id,'firstName')]")
	WebElement LastName;
	
	public void fillLastName(String lastName) throws Exception {

		ActionBot.enter_Text(driver, this.LastName, lastName);

	}
	
	@FindBy(xpath = "//*[contains(@id,'address1')]")
	WebElement StreetName;
	
	public void fillStreetName(String streetName) throws Exception {

		ActionBot.enter_Text(driver, this.StreetName, streetName);

	}
	
	@FindBy(xpath = "//*[contains(@id,'address2')]")
	WebElement HouseNumber;
	
	public void fillHouseNumber(String houseNumber) throws Exception {

		ActionBot.enter_Text(driver, this.HouseNumber, houseNumber);

	}
	@FindBy(xpath = "//*[contains(@id,'city')]")
	WebElement PlaceName;
	
	public void fillPlaceName(String placeName) throws Exception {

		ActionBot.enter_Text(driver, this.PlaceName, placeName);

	}
	
	@FindBy(xpath = "//*[contains(@id,'zipCode')]")
	WebElement ZipCode;
	
	public void fillZipCode(String zipCode) throws Exception {

		ActionBot.enter_Text(driver, this.ZipCode, zipCode);

	}
	
	@FindBy(xpath = "//*[contains(@id,'phone1')]")
	WebElement PhoneNumber;
	
	public void fillPhoneNumber(String phoneNumber) throws Exception {

		ActionBot.enter_Text(driver, this.PhoneNumber, phoneNumber);

	}
	
	@FindBy(xpath = "//*[contains(@data-testid,'address-save-button')]")
	WebElement AddressSaveBtn;

	public void clickonAddressSaveBtn() throws Exception {

		ActionBot.focusAndclick(driver, AddressSaveBtn);

	}
	
	@FindBy(xpath = " //*[contains(@data-testid,'address-book-select')]")
	WebElement ViewAddressOption;

	public String viewAddedAddress(String address) throws Exception {

		  Select select = new Select(ViewAddressOption);
	      select.selectByVisibleText(address);
	      WebElement o = select.getFirstSelectedOption();
	      String selectedoption = o.getText();
		return selectedoption;

	}
}
