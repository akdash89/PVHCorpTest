package com.AutomationAsginmnt.Apps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutomationAsignment.utility.ActionBot;
import com.AutomationAsignment.utility.ConfigReader;

public class LoginPageValidation {

	RemoteWebDriver driver;
	int timeOutPeriod;
	/* All WebElements are identified by @FindBy annotation */

	public LoginPageValidation(RemoteWebDriver driver) {

		this.driver = driver;

		// This initElements method will initialize all webelements

		PageFactory.initElements(driver, this);
		timeOutPeriod = Integer.parseInt(ConfigReader.getProperty("config.properties", "TIMEOUT"));

	}
	

	@FindBy(xpath = "//*[contains(@data-testid,'Button-primary')]")
	WebElement AcceptCookiesBtn;

	public void clickonAcceptCookiesBtn() throws Exception {

		ActionBot.focusAndclick(driver, AcceptCookiesBtn);

	}

	@FindBy(xpath = "//*[contains(@data-testid,'sign-in-button')]")
	WebElement SignInBtn;

	public void clickonSignInBtn() throws Exception {

		ActionBot.focusAndclick(driver, SignInBtn);

	}
	
	@FindBy(xpath = "//*[contains(@name,'signin-email')]")
	WebElement EmailId;
	
	public void enterEmail(String email) throws Exception {

		ActionBot.enter_Text(driver, this.EmailId, email);

	}
	
	@FindBy(xpath = "//*[contains(@name,'signin-password')]")
	WebElement Password;
		
	public void enterPassword(String password) throws Exception {

	    ActionBot.enter_Text(driver, this.Password, password);

	}

	@FindBy(xpath = "//*[contains(@data-testid,'Button-primary')]")
	WebElement clickOnSubmitBtn;

	public void clickonSubmitBtn() throws Exception {

		ActionBot.focusAndclick(driver, clickOnSubmitBtn);

	}
	
	@FindBy(xpath = "//*[contains(@id,'signin-password-helper-text')]")
	WebElement getLoginErrorMsg;

	public String getLoginErrorMessage() throws Exception {

		String errorMsg = driver.findElement(By.xpath("//*[contains(@id,'signin-password-helper-text')]")).getText();
		
		return errorMsg;
	}
}
