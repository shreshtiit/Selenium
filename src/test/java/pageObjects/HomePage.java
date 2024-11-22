package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy (xpath="//span[normalize-space()='My Account']")
	WebElement clcaccount;
	
	@FindBy (xpath="//a[normalize-space()='Register']")
	WebElement clcregister;
	
	@FindBy (linkText ="Login")
	WebElement clkLogin;
	
	public void clickAccount() 
	{
		clcaccount.click();
	}
	
	public void clickRegister()
	{
		clcregister.click();
	}
	
	public void clickLogin()
	{
		clkLogin.click();
	}
}
