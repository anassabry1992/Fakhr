package ibtikar.Fakhr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase{

	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	//home register button
	@FindBy(xpath = "//a[@href='/ar/register']")
	WebElement homeRegBtn;
	
	//first name field
	@FindBy(name = "first_name")
	WebElement firNameField;
	
	//second name field
	@FindBy(name = "seconed_name")
	WebElement secNameField;
		
	//third name field
	@FindBy(name = "third_name")
	WebElement thrNameField;
	
	//family name field
	@FindBy(name = "family_name")
	WebElement famNameField;
		
	//id number field
	@FindBy(name = "id_number")
	WebElement idNumField;
	
	//mobile number field
	@FindBy(name = "mobile_number")
	WebElement mobNumField;
	
	//email field
	@FindBy(name = "email")
	WebElement emailField;
	
	//password field
	@FindBy(name = "password")
	WebElement passwordField;
	
	//confirmation password field
	@FindBy(name = "password_confirmation")
	WebElement confPasswordField;
	
	//terms and conditions checkbox
	@FindBy(className = "checkmark")
	WebElement termsCheckbox;
	
	//register button
	@FindBy(xpath = "*//form/div[9]/button")
	WebElement regBtn;
	
	//response message (repeated data)
	@FindBy(xpath = "*//div/div[1]/div/div[2]/p")
	WebElement resMsg;
	
	//close message button
	@FindBy(xpath = "*//div/div[1]/div/div[3]/button")
	WebElement closeBtn;
	
	//validation phone 1st digit field
	@FindBy(xpath = "*//input[@data-id='0']")
	WebElement dig1Field;
	
	//validation phone 2nd digit field
	@FindBy(xpath = "*//input[@data-id='1']")
	WebElement dig2Field;
		
	//validation phone 3rd digit field
	@FindBy(xpath = "*//input[@data-id='2']")
	WebElement dig3Field;
		
	//validation phone 4th digit field
	@FindBy(xpath = "*//input[@data-id='3']")
	WebElement dig4Field;
	
	//submit button
	@FindBy(xpath = "*//form/div[2]/button")
	WebElement submitBtn;
	
	//resend validation code button
	@FindBy(xpath = "*//div[3]/div[3]/div/div[3]/div/div/div/button")
	WebElement resendBtn;
	
	
	public void registerMethod(String firName, String secName, String thrName, String famName, String idNum,
			String mobNum, String email, String password, String confPassword) {
		homeRegBtn.click();
		firNameField.sendKeys(firName);
		secNameField.sendKeys(secName);
		thrNameField.sendKeys(thrName);
		famNameField.sendKeys(famName);
		idNumField.sendKeys(idNum);
		mobNumField.sendKeys(mobNum);
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		confPasswordField.sendKeys(confPassword);
		termsCheckbox.click();
		regBtn.click();
		}
	
	public String getResponseMsg() {
		return resMsg.getText();
	}
	
	public void closeResponseMsg() {
		closeBtn.click();
	}
	
	public void resendMethod() {
		resendBtn.click();
	}
	
	
}
