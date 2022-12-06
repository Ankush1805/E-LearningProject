package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import setup.Base;
import utilities.Utility;

public class DemoClass {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
	
	
	WebDriver driver = Base.openChromeBrowser();
	
	driver.get("https://www.khanacademy.org/login");
	
	LoginPage loginPage = new LoginPage(driver);
	
	String username=Utility.getDataFromExcel("LoginData", 1, 0);
	loginPage.sendUsername(username);
	String password = Utility.getDataFromExcel("LoginData", 1, 1);
	loginPage.sendPassword(password);
	
	loginPage.clickOnLoginButton();
	
	DashboardPage dashboardPage = new DashboardPage(driver);
	
	dashboardPage.clickOnAccount();
	dashboardPage.clickOnLogout();
	
	driver.close();
	
	}

}
