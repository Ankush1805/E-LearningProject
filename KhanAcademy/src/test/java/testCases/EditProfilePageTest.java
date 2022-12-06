package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
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

import pageObjects.DashboardPage;
import pageObjects.EditProfilePage;
import setup.Base;
import utilities.Utility;

public class EditProfilePageTest {
	
	private WebDriver driver;
	private EditProfilePage editProfilePage;
	private DashboardPage dashboardpage;
	int testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@Parameters ("browser")
	
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		reporter = new ExtentHtmlReporter("test-output\\ExtentReport\\Extent.Html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		if(browserName.equals("Chrome"))
		{
			driver=Base.openChromeBrowser();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void createPOMObjects()
	{
		dashboardpage = new DashboardPage(driver);
		editProfilePage = new EditProfilePage(driver);
	}
	
	@BeforeMethod
	public void launchApplication()
	{
		driver.get("https://www.khanacademy.org/profile/me/courses");
	}
	
	@Test (priority = -1)
	public void editProfileTest1() throws EncryptedDocumentException, IOException
	{ testID = 201;
	
		dashboardpage.clickOnEditProfileButton();
		
		String nickname = Utility.getDataFromExcel("EditProfileData", 1, 0);
		editProfilePage.sendNickname(nickname);
		
		String username = Utility.getDataFromExcel("EditProfileData", 1, 1);
		editProfilePage.sendNickname(username);
		
		String bio = Utility.getDataFromExcel("EditProfileData", 1, 2);
		editProfilePage.sendNickname(bio);
		
		editProfilePage.clickOnSaveButton();
	}
	
	@Test (priority = 0)
	public void editProfileTest2() throws EncryptedDocumentException, IOException
	{ testID = 202;
	
	 	dashboardpage.clickOnEditProfileButton();
		
		String nickname = Utility.getDataFromExcel("EditProfileData", 2, 0);
		editProfilePage.sendNickname(nickname);
		
		String username = Utility.getDataFromExcel("EditProfileData", 2, 1);
		editProfilePage.sendNickname(username);
		
		String bio = Utility.getDataFromExcel("EditProfileData", 2, 2);
		editProfilePage.sendNickname(bio);
		
		editProfilePage.clickOnSaveButton();
	}
	
	@Test (priority = 1)
	public void editProfileTest3() throws EncryptedDocumentException, IOException
	{ testID = 203;
	
		dashboardpage.clickOnEditProfileButton();
		
		String nickname = Utility.getDataFromExcel("EditProfileData", 3, 0);
		editProfilePage.sendNickname(nickname);
		
		String username = Utility.getDataFromExcel("EditProfileData", 3, 1);
		editProfilePage.sendNickname(username);
		
		String bio = Utility.getDataFromExcel("EditProfileData", 3, 2);
		editProfilePage.sendNickname(bio);
		
		editProfilePage.clickOnSaveButton();
	}
	
	@AfterMethod
	public void logoutFromApplication(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreen(driver, testID);
		}
		
	}
	
	@AfterClass
	public void clearObjects()
	{
		dashboardpage = null;
		editProfilePage = null;
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
		System.gc();
	}
	
	
	
	

}
