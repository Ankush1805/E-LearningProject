package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
private WebDriver driver;
	
	@FindBy (xpath = "//span[text()='Edit Profile']") 
	private WebElement editProfileButton;
	
	@FindBy (xpath = "//span[@class='_wozql4 _13hnk7qk']")
	private WebElement accountDropdown;
	
	@FindBy (xpath = "//span[text()='Log out']")
	private WebElement logout;
	
	
	public DashboardPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}


	public void clickOnEditProfileButton() 
	{
		
		editProfileButton.click();
	}
	
	public void clickOnAccount()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(accountDropdown));
		accountDropdown.click();
	}
	
	public void clickOnLogout()
	{
		logout.click();
	}
	

}
