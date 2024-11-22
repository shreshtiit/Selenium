package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegister extends BasePage {

	public AccountRegister (WebDriver driver) 
	{
		super (driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_firstname;
	
	@FindBy (xpath="//input[@id='input-lastname']")
	WebElement txt_lastname;
	
	@FindBy (xpath="//input[@id='input-email']")
	WebElement txt_email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txt_telephone;
	
	@FindBy (xpath="//input[@id='input-password']")
	WebElement txt_password;
	
	@FindBy (xpath="//input[@id='input-confirm']")
	WebElement txt_cnfpassword;
	
	@FindBy (xpath="//label[normalize-space()='Yes']")
	WebElement rd_btn;
	
	@FindBy (xpath="//input[@name='agree']")
	WebElement chck_box;
	
	@FindBy (xpath="//input[@value='Continue']")
	WebElement clc_continue;
	
	@FindBy (xpath ="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconfirmation;
	
	public void setFirstName(String fname)
	{
		txt_firstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txt_lastname.sendKeys(lname);
	}
	
	public void setEmail (String eml)
	{
		txt_email.sendKeys(eml);
	}
	
	public void setTelephone(String tel)
	{
		txt_telephone.sendKeys(tel);
	}
	
	public void setPassword(String pass)
	{
		txt_password.sendKeys(pass);
	}
	
	public void setConPassword(String pass)
	{
		txt_cnfpassword.sendKeys(pass);
	}
	
	public void setRadio()
	{
		rd_btn.click();
	}
	
	public void checkBox()
	{
		chck_box.click();
	}
	
	public void continueBtn()
	{
		clc_continue.click();
	}
	
	public String getConfirmationMsg()
	{
		try {
			return (msgconfirmation.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
	}
}
