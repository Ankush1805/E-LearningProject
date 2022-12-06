package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProfilePage {
	
	private WebDriver driver;
	
	@FindBy (xpath = "//input[@id='nickname']") 
	private WebElement nicknameTextField;
	
	@FindBy (xpath = "//input[@id='username']")
	private WebElement usernameTextField;
	
	@FindBy (xpath = "//textarea[@id='bio-picker']")
	private WebElement bioTextarea;
	
	@FindBy (xpath = "//span[text()='Save']")
	private WebElement saveButton;
	
	@FindBy (xpath = "//span[text()='Cancel']")
	private WebElement cancelButton;
	
	public EditProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public void sendNickname(String nickname)
	{
		nicknameTextField.sendKeys(nickname);
	}
	
	public void sendUsername(String username)
	{
		usernameTextField.sendKeys(username);
	}
	
	public void sendBio(String bio)
	{
		bioTextarea.sendKeys(bio);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	public void clickOnCancelButtonButton()
	{
		cancelButton.click();
	}
	
	
	
	

}
