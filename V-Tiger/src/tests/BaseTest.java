package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import libraries.AutoUtils;
import libraries.GenericExcel;
import libraries.IAutoConstants;
import pages.HomePage;
import pages.LoginPage;

public class BaseTest implements IAutoConstants {
	public WebDriver driver;
	@Parameters({"browser", "ito"})
    @BeforeClass
    public void LaunchApp(@Optional(LOCAL_KEY) String browser, 
    		@Optional(LOCAL_ITO) String ito) {
		if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
    	driver = new ChromeDriver();
    	long time = Long.parseLong(ito);
    	driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    	String url = AutoUtils.getValue(CONFIG_PATH, "url");
    	driver.get(url);
		}
    }
	
	@BeforeMethod
	public void signIn() {
		LoginPage login = new LoginPage(driver);
		String un = GenericExcel.getValue(XLPATH, "Sheet1", 0, 0);
		String pwd = GenericExcel.getValue(XLPATH, "Sheet1", 0, 1);
		login.setUserName(un);
		login.setPassword(pwd);
		login.clickLogin();
	}
	
	@AfterMethod
	public void signOut(ITestResult result) {
		int status = result.getStatus();
		if(status==1) {
			Reporter.log(result.getName()+"::"+"PASSED", true);
		}
		else {
			Reporter.log(result.getName()+"::"+"Failed", true);
			AutoUtils.getPhoto(driver, result.getName());
		}		
		HomePage h = new HomePage(driver);
		h.clickPersonIcon();
		h.clickSignOut();
	}
	
	@AfterClass
	public void CloseApp() {
		driver.quit();
	}
	
}
