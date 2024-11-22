package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegister;
import pageObjects.HomePage;
import testBase.BaseTest;

public class TC_001AccountRegistrationPage extends BaseTest {
	
	
	@Test(groups={"Regression" , "Master"})
	public void registration()
	{
		logger.info("***** Starting Testing *********");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickAccount();
		
		logger.info("Clicked on Account  link.......");
		hp.clickRegister();
		logger.info("Clicked on Registered link.......");
		AccountRegister ar=new AccountRegister(driver);
		logger.info("Providing Cutomer Detailss....");
		
		ar.setFirstName(randomeString().toUpperCase());
		ar.setLastName(randomeString().toUpperCase());
		ar.setEmail(randomeString() +"@gmail.com");
		ar.setTelephone(randomeNumber());
		
		String pwd= randomeAlphaNumeric();
		ar.setPassword(pwd);
		ar.setConPassword(pwd);
		ar.setRadio();
		ar.checkBox();
		ar.continueBtn();
		
		logger.info("Validating conf message......");
		String conmsg=ar.getConfirmationMsg();
		
		if(conmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed...");
			logger.debug("Debug logs......");
			Assert.assertTrue(false);
			
		}
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		
		logger.info("Test Finished........");
	}
	
	
}
