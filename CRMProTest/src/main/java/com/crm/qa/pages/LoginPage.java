package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory - OR:
	
			@FindBy(name="username")
			WebElement username;
			
			@FindBy(name="password")
			WebElement password;
			
			@FindBy(xpath="//input[@type='submit' and @value='Login' and @class='btn btn-small']")
			WebElement loginBtn;
			
			@FindBy(xpath="//a[text()='Sign Up']")
			WebElement signUpBtn;
			
			@FindBy(xpath="//img[contains(@class,'img-responsive')]")
			WebElement crmLogo;

			
			
			//Initializing the Page Objects
			public LoginPage()
			{
				PageFactory.initElements(driver, this);
			}
			
			
			//Actions:
			public String validateLoginPageTitle()
			{
				return driver.getTitle();
			}
			
			
			public boolean validateCRMImage()
			{
				return crmLogo.isDisplayed();
			}
			
			public HomePage login(String un, String pwd)
			{
				username.sendKeys(un);
				password.sendKeys(pwd);
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				loginBtn.click();
				
				return new HomePage();
			}

}
