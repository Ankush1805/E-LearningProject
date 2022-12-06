package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import setup.Base;
import utilities.Utility;

public class LogoutTest {
	
	private WebDriver driver;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	int testID;
	static ExtentHtmlReporter reporter;
	static ExtentTest test;
	
	@Parameters ("browser")
	
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		reporter = new ExtentHtmlReporter("test-output\\ExtentReport\\Extent.Html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		if(browserName.equals("Chrome"))
		{
			driver=Base.openChromeBrowser();
		}	
	}
	
	@BeforeClass
	public void createPOMObjects()
	{
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
	}
	
	@BeforeMethod
	public void loginIntoApplication() throws EncryptedDocumentException, IOException
	{
		driver.get("https://www.khanacademy.org/login");
		
		String username=Utility.getDataFromExcel("LoginData", 1, 0);
		loginPage.sendUsername(username);
		String password = Utility.getDataFromExcel("LoginData", 1, 1);
		loginPage.sendPassword(password);
		
		loginPage.clickOnLoginButton();
	}
	
	@Test
	public void logoutTest()
	{
		dashboardPage.clickOnAccount();
		dashboardPage.clickOnLogout();
	}
	
	@AfterClass
	public void clearObjects()
	{
		loginPage = null;
		dashboardPage = null;
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
		System.gc();
	}
	
	
	
	
	
	
	
	

}
