package Com.qa.ClassicCRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Com.qa.ClassicCRM.base.TestBase;

public class ContactsPage extends TestBase{

	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactlabel;
	
	@FindBy(name="title")
	WebElement TitleName;
	
	@FindBy(id="first_name")
	WebElement FirstName;
	
	@FindBy(id="surname")
	WebElement LastName;
	
	@FindBy(name="suffix")
	WebElement SuffixName;
	
	@FindBy(name="client_lookup")
	WebElement CompanyName;
	
	@FindBy(id="company_position")
	WebElement Position;
	
	@FindBy(id="department")
	WebElement Department;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement Savebtn;
	
	@FindBy(xpath="//a[contains(text(),'ada ada')]/../..//input[@name='contact_id']")
	WebElement checkbox;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifycontactslable() {
		return contactlabel.isDisplayed();
	}
	
	public void selectcontactsByName(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/../..//input[@name='contact_id']")).click();
	}
	
	public void CreateNewcontact(String title,String FtName,String LtName,String suffix,String ComName,
			String Pstion,String Dept) {
		
		Select select=new Select(TitleName);
		select.selectByVisibleText(title);		
		FirstName.sendKeys(FtName);
		LastName.sendKeys(LtName);
		Select select1=new Select(SuffixName);
		select1.selectByVisibleText(suffix);
		CompanyName.sendKeys(ComName);
		Position.sendKeys(Pstion);
		Department.sendKeys( Dept);
		Savebtn.click();
	}
}

