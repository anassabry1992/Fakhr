package ibtikar.Fakhr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//home login button
	@FindBy(xpath = "//a[@href='/ar/login']")
	WebElement homeLoginBtn;
		
	//user name field
	@FindBy(name = "username")
	WebElement userNameField;
		
	//password field
	@FindBy(name = "password")
	WebElement passwordField;
	
	//login button
	@FindBy(xpath = "*//form/div[4]/button")
	WebElement loginBtn;
		
	//response message (repeated data)
	@FindBy(xpath = "*//div/div[1]/div/div[2]/p")
	WebElement resMsg;
	
	public void loginMethod(String username,String password) {
		
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
	}
	
	public String getResponseMessage() {
		return resMsg.getText();
	}
	
}
