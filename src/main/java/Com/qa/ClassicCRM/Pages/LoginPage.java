package Com.qa.ClassicCRM.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.qa.ClassicCRM.base.TestBase;

public class LoginPage extends TestBase{

	// page factory or Object repository

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[text()='Sign Up']")
	WebElement signupBtn;

	@FindBy(xpath = "//a[@class='navbar-brand']")
	WebElement crmlogo;

	// initialize the current class variables

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateTitle() {
		return driver.getTitle();
	}

	public boolean validateImage() {
		return crmlogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
	}
}
