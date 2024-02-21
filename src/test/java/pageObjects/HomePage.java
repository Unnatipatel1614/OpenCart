package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		
	}
//	@FindBy(xpath="//a[@title='My Account']") 
//	WebElement lnkmyAccount2;
//  
	@FindBy(xpath="//span[normalize-space()='My Account']") 
	WebElement lnkmyAccount;

	
	@FindBy(xpath="//a[normalize-space()='Register']") 
	WebElement lnkregister;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement lnklogin;
	
	@FindBy(xpath="//input[@placeholder='Search']") 
	WebElement txtsearchbox;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']") 
	WebElement btnsearch;
	
	public void clickMyAccount()
	{
		lnkmyAccount.click();
	}
	
//	public void clickMyAccount(boolean x)
//	{
//		lnkmyAccount2.click();
//	}
//	
	public void clickRegister()
	{
		lnkregister.click();
	}

	public void clickLogin()
	{
		lnklogin.click();
	}
	
	public void enterProductName(String pName)
	{
		txtsearchbox.sendKeys(pName);
	}
	
	public void clickSearch()
	{
		btnsearch.click();
	}
}
