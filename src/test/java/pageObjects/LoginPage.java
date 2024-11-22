package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy (xpath="//input[@id='input-email']")
	WebElement txt_email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_password;
	
	@FindBy (xpath="//input[@value='Login']")
	WebElement btn;
	
	public void setEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void setPass(String pass)
	{
		txt_password.sendKeys(pass);
	}
	
	public void button()
	{
		btn.click();
	}
}
