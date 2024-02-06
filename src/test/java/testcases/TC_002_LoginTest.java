package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups= {"sanity","master"})
	public void verify_Login() {

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
			lp.setemailaddress(p.getProperty("email"));

			lp.setPassword(p.getProperty("password"));
			lp.clickLogin(); // login button from login page
			logger.info("clicked on login button");

			// MyAccount page
			MyAccountPage mcp = new MyAccountPage(driver);

			boolean targetPage = mcp.isMyaccountpageExists();

			if (targetPage == true) {
				logger.info("Login test passed....");
				Assert.assertTrue(true);
			} else {
				logger.error("Login test failed....");
				Assert.fail();
			}
		} catch (Exception e) {
			logger.error("Login test failed....");
			Assert.fail();
		}
		logger.info("***** Finished TC_002_LoginTest *****");
		// mcp.clickLogout();

	}
}
