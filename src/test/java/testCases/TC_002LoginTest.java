package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;

public class TC_002LoginTest extends BaseTest{
	@Test(groups= {"Sanity", "Master"})
	public void verify_login()
	{
		logger.info("Test Case Started");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPass(p.getProperty("password"));
		lp.button();
		
		MyAccountPage ma=new MyAccountPage(driver);
		boolean target=ma.verify();
		Assert.assertTrue(target);
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("Test Case Finished");
	}

}
