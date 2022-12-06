package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pageObjects.LoginPage;
import setup.Base;
import utilities.Utility;

public class LoginPageTest {
	
	private WebDriver driver;
	private LoginPage loginPage;
	private int testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@Parameters ("browser")
	
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		reporter=new ExtentHtmlReporter ("test-output\\ExtentReport\\Extent.Html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		if(browserName.equals("Chrome"))
		{
			driver=Base.openChromeBrowser();
		}
		if(browserName.equals("Edge"))
		{
			driver=Base.openEdgeBrowser();
		}
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void createPOMObjects()
	{
		loginPage = new LoginPage(driver);
	}
	
	@BeforeMethod
	public void launchApplication()
	{
		driver.get("https://www.khanacademy.org/login");
	}
	
	@Test 
	public void loginTest() throws EncryptedDocumentException, IOException
	{	testID=1101;
		
		String uNameData = Utility.getDataFromExcel("LoginData", 1, 0);
		loginPage.sendUsername(uNameData);
		
		String passData = Utility.getDataFromExcel("LoginData", 1, 1);
		loginPage.sendPassword(passData);
		
		loginPage.clickOnLoginButton();
	}
	
	@AfterMethod
	public void logoutFromApplication(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreen(driver,testID);
		}
		System.out.println("Logout");
	}
	
	@AfterClass
	public void clearObjects()
	{
		LoginPage loginPage=null;
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
		System.gc();
	}
	
	

}
