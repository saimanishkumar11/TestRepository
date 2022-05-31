package PageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OHRMTest {
	String driverPath = "C:\\Users\\kushal\\eclipse-workspace\\AutomationCG\\drivers\\chromedriver.exe";
	WebDriver driver;
	LoginPage objLogin;
	HomePage objHomePage;
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	@Test(priority=0)
	public void test_Home_Page_Appear_Correct() {
		objLogin = new LoginPage(driver);
		objLogin.loginToOHRM("Admin","admin123");
		objHomePage = new HomePage(driver);
		Assert.assertTrue(objHomePage.getHomePageDashboardUserName().matches("^Welcome [A-Z|a-z]+"));
		driver.close();
	}
	}