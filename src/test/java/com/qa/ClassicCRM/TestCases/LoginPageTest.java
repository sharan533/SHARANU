package com.qa.ClassicCRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.qa.ClassicCRM.Pages.HomePage;
import Com.qa.ClassicCRM.Pages.LoginPage;
import Com.qa.ClassicCRM.base.TestBase;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;

	// all properties will be initialized
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() {
		Initialization();
		loginpage = new LoginPage();
	}

	@Test(priority = 2)
	public void loginPageTitleTest() {
		String title = loginpage.validateTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority = 1)
	public void crmlogoImageTest() {
		boolean flag = loginpage.validateImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void LoginTest() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
