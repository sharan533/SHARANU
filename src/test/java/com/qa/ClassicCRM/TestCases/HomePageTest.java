package com.qa.ClassicCRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.qa.ClassicCRM.Pages.ContactsPage;
import Com.qa.ClassicCRM.Pages.HomePage;
import Com.qa.ClassicCRM.Pages.LoginPage;
import Com.qa.ClassicCRM.base.TestBase;
import Com.qa.ClassicCRM.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	public HomePageTest() {
		super();
	}

	// test cases should be separated --- independent with each other
	// Before each test cases ---- launch the browser and login
	// After each test cases --- close the browser
	@BeforeMethod
	public void Setup() {
		Initialization();
		loginpage = new LoginPage();
		testutil = new TestUtil();
		contactspage=new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=2)
	public void verifyHomePageTitleTest() {
		String homepageTitle = homepage.VerifyHomePageTitle();
		Assert.assertEquals(homepageTitle, "CRMPRO", "homepage title not matched");
	}

	@Test(priority=1)
	public void verifyUsernameTest() {
		testutil.switchtoframe();
		Assert.assertTrue(homepage.verifycorrectUsername());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		testutil.switchtoframe();
		contactspage=homepage.clickOnContactsLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
