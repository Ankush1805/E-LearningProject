package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import setup.Base;

public class DemoClass {
	
	public static void main(String[] args) {
		
	
	
	WebDriver driver = Base.openChromeBrowser();
	
	driver.get("https://www.khanacademy.org/login");
	
	}

}
