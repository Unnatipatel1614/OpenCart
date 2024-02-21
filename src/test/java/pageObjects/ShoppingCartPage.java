package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']") 
	WebElement btnitem;
	
	@FindBy(xpath="//strong[normalize-space()='View Cart']") 
	WebElement viewCart;
	
	@FindBy(xpath="//strong[normalize-space()='Total:']") 
	WebElement totalprice;
	
	@FindBy(xpath="//a[@class='btn btn-primary']") 
	WebElement btncheckout;
	
	public void clickOnItem()
	{
		btnitem.click();
	}
	
	public void clickonViewCart()
	{
		viewCart.click();
	}
	
	public String getTotalPrice()
	{
		return totalprice.getText();
	}
	
	public void clickoncheckOut()
	{
		btncheckout.click();
	}
}
