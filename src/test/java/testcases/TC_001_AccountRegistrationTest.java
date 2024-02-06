package testcases;


import org.testng.Assert;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseClass;
import pageObjects.AccountRegistrationPage;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	
	
    @Test(groups= {"regression","master"})
	public void verifyAccountRegistrationTest()
	{
    	logger.info("****** TC_001_AccountRegistrationTest started ******");
    	try
		{
    	HomePage hp = new HomePage(driver);
		
		
		
		hp.clickMyAccount();
		logger.info("clicked on MyAccount");
		
		hp.clickRegister();
		logger.info("clicked on register");
		
		AccountRegistrationPage aregp = new AccountRegistrationPage(driver);
    	
		logger.info("entering user info....");
		aregp.setFirstName(randomeString().toUpperCase());
    	aregp.setLastName(randomeString().toUpperCase());
    	aregp.setEmail(randomeString()+"@gmail.com");
    	aregp.setTelephone(randomeNumber());;
    	
    	String password=randomeAlphaNumeric();
    	aregp.setPassword(password);
    	aregp.setConfirmPassword(password);
    	
    	aregp.setPrivacyPolicy();
    	
    	aregp.clickcontinue();
    	logger.info("clicked on continue button....");
    	
    	String msg = aregp.getConfirmationMSG();
    	
		
    	logger.info("Validating expected message..");
    	
    	if(msg.equals("Your Account Has Been Created!"))
    	{
    		logger.info("test passed...");;
    		Assert.assertTrue(true);
    	}
    	else
    	{
    		logger.error("test failed...");
    		Assert.fail();
    	}
    	
    	//Assert.assertEquals(msg, "Your Account Has Been Created...!");
		}
    
		catch(Exception e)
		{
			logger.error("test fail");
			Assert.fail();
		}
    	logger.info("****** TC_001_AccountRegistrationTest finished ******");
    	
	}
	
}
