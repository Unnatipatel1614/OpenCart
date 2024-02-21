package testcases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_005_AddToCartPage extends BaseClass {

	@Test(groups= {"master"})
	public void verify_AddToCart()
	{
		logger.info(" Starting TC_005_AddToCartPage test ");
		HomePage hp = new HomePage(driver);
		hp.enterProductName("iPhone");
		hp.clickSearch();
		
		SearchPage sp = new SearchPage(driver);
		
		if(sp.isProductExist("iPhone"))
		{
			sp.SelectProduct("iPhone");
			sp.setQuantity("2");
			sp.addToCart();
			
		}
		logger.info(" Finished TC_005_AddToCartPage test ");
		
	}
}
