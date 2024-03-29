package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;

	HomePage homePage;
	
	ContactsPage contactsPage;
	
	TestUtil testUtil;
	
	String sheetName = "contacts";
	
	
	public ContactsPageTest()
	{
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		
		testUtil = new TestUtil();

		loginPage = new LoginPage();
		
		contactsPage = new ContactsPage();
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		testUtil.switchToFrame();
		
		contactsPage = homePage.clickOnContactsLink();
		
	}
	
	
	@Test(priority = 1)
	public void verifyContactsPageLabel()
	{
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the label");
		
	}
	
	
	@Test(priority = 2)
	public void selectSingleContactsTest()
	{
		contactsPage.selectContactsByName("test2 test2");
	}
	
	
	
	
	@Test(priority = 3)
	public void selectMultipleContactsTest()
	{
		contactsPage.selectContactsByName("test sample");
		
		contactsPage.selectContactsByName("test2 test2");
	}
	
	
	
	@DataProvider
	public Object [][] getCRMTestData()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		
		return data;
		 
	}
	
	
	
	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company)
	{
		
		homePage.clickOnNewContactLink();
		
	//	contactsPage.createnewNewContact("Mr.", "Tom", "Peter", "Google");
		
		contactsPage.createnewNewContact(title, firstName, lastName, company);
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}	

	
}
