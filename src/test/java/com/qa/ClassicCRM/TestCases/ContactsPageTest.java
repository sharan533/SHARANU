package com.qa.ClassicCRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.qa.ClassicCRM.Pages.ContactsPage;
import Com.qa.ClassicCRM.Pages.HomePage;
import Com.qa.ClassicCRM.Pages.LoginPage;
import Com.qa.ClassicCRM.base.TestBase;
import Com.qa.ClassicCRM.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	String sheetName = "Contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() {
		Initialization();
		loginpage = new LoginPage();
		testutil = new TestUtil();
		contactspage = new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchtoframe();
		homepage.clickOnContactsLink();
	}

	@Test(priority = 3)
	public void verifyContactspageLable() {
		Assert.assertTrue(contactspage.verifycontactslable(), "contacts lable is missing");
	}

	@Test(priority = 1)
	public void selectMultipleContactsTest() {
		contactspage.selectcontactsByName("ada ada");
	}

	@Test(priority = 2)
	public void selectsingleContactsTest() {
		contactspage.selectcontactsByName("ada ada");
		contactspage.selectcontactsByName("Alfia Alfia");
		contactspage.selectcontactsByName("apv srikrishna");
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][]=TestUtil.getTestdata(sheetName);
		return data;
	}

	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void ValidateCreateNewContactTest(String title, String firstName, String LastName, String suffix,
			String Comapany, String Position, String Department) {
		homepage.clickOnNewContactLink();
		contactspage.CreateNewcontact(title, firstName, LastName, suffix, Comapany, Position, Department);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
