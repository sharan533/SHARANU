package Com.qa.ClassicCRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.qa.ClassicCRM.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'User: Naveen AutomationLabs')]")
	WebElement userNameLable;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement NewContactsLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement DealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement TasksLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String VerifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifycorrectUsername() {
		return userNameLable.isDisplayed();
	}

	public ContactsPage clickOnContactsLink() {
		ContactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		DealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOntasksLink() {
		TasksLink.click();
		return new TasksPage();
	}

	public void clickOnNewContactLink() {
		Actions act = new Actions(driver);
		act.moveToElement(ContactsLink).build().perform();
		NewContactsLink.click();
	}
}
