package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	
	public void verify_LoginDDT(String email, String password, String exp) {

		logger.info("***** Starting TC_002_LoginTest ***** ");
		logger.debug("capturing application debug logs...");

		try {

			// HomePage
			HomePage hp = new HomePage(driver);
		   
			hp.clickMyAccount(); // login link under my account
			logger.info("clicked on MyAccount link on the home page..");

			hp.clickLogin();
			logger.info("clicked on Login link under my account..");

			// Loginpage
			LoginPage lp = new LoginPage(driver);
			logger.info("Entering valid email and password");
			lp.setemailaddress(email);

			lp.setPassword(password);
			lp.clickLogin(); // login button from login page
			logger.info("clicked on login button");

			// MyAccount page
			MyAccountPage mcp = new MyAccountPage(driver);

			boolean targetPage = mcp.isMyaccountpageExists();
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{
					mcp.clickLogout();
					logger.info("Login test passed....");
					Assert.assertTrue(true);
				}
				else
				{
					logger.error("Login test failed....");
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					mcp.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		
		catch(Exception e)
		{
			logger.error("Login test failed....");
			Assert.fail();
		}
		}
}
