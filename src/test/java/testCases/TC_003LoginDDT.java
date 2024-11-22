package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;
import utilities.DataProviders;

public class TC_003LoginDDT extends BaseTest{
		@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups= "Datadriven")
		public void verify_loginDDT(String email, String pwd, String exp)
		{
			logger.info("Starting Testt........");
			try {
			HomePage hp=new HomePage(driver);
			hp.clickAccount();
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(email);
			lp.setPass(pwd);
			lp.button();
			
			MyAccountPage ma=new MyAccountPage(driver);
			boolean target=ma.verify();
			Assert.assertTrue(target);
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(target==true)
				{
					ma.clickLogout();
					Assert.assertTrue(true);
					
				}
			} 
			else 
			{
				Assert.assertTrue(false);
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(target==true)
				{
					ma.clickLogout();
					Assert.assertTrue(false);
					
				}
			} 
			else 
			{
				Assert.assertTrue(true);
			}
			} catch(Exception e) {
				Assert.fail();
			}
			logger.info("Finished  Testt........");
		}
	}

