package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy (xpath= "(//input[@class='_1azps1NaN'])[1]") private WebElement userName;
	@FindBy (xpath= "//input[@type='password']") private WebElement password;
	@FindBy (xpath= "//button[@type='submit']") private WebElement loginButton;
	
	public LoginPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void sendUsername(String uName)
	{
		userName.sendKeys(uName);
	}
	
	public void sendPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	
	

}
