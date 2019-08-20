package Com.qa.ClassicCRM.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import Com.qa.ClassicCRM.util.TestUtil;
import Com.qa.ClassicCRM.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() {

		try {

			prop = new Properties();
FileInputStream ip = new FileInputStream("D:\\Sharanu_Folder\\ClassicCRMTest-master"
		+ "\\src\\main\\java\\Com\\qa\\ClassicCRM\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void Initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("ff")) {
			System.setProperty("webdriver.gecko.driver", "D:/Sharanu_Folder/SELENIUM/geckodriver.exe");
			driver = new FirefoxDriver();;
		} else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:/Sharanu_Folder/SELENIUM/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

}
