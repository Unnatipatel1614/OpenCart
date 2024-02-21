package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_004_SearchProductTest extends BaseClass{

	@Test(groups= {"master"})
	public void verify_productSearch()
	{
		logger.info(" Starting TC_004_SearchProductTest ");
		try {
		HomePage hp=new HomePage(driver);
		hp.enterProductName("iPhone");
		hp.clickSearch();
		
		SearchPage sp = new SearchPage(driver);
		sp.isProductExist("iPhone");
		Assert.assertEquals(sp.isProductExist("iPhone"), true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info(" Finished TC_004_SearchProductTest ");
	}
}
