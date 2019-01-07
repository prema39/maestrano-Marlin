package io.maestrano.marlin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.maestrano.marlin.pages.base.BasePage;
import io.maestrano.marlin.utils.Constants;

public class QuickBooksLoginPage extends BasePage{

	public QuickBooksLoginPage(WebDriver baseTestDriver) {
		
		driver = baseTestDriver;
	}
	@FindBy(id = Constants.QUICKBOOKSUSERNAME_ID)
	private WebElement username;
	
	@FindBy(id = Constants.QUICKBOOKSPASSWORD_ID)
	private WebElement password;
	
	@FindBy(id = Constants.QUICKBOOKSSIGNINBTN_ID)
	private WebElement signin;
	
	
	//click on marketplace button
	public void loginToQuickbooks(String user, String pass) {
		
		explicit_id(Constants.QUICKBOOKSUSERNAME_ID, 30);
		
		username.sendKeys(user);
		password.sendKeys(pass);
		
		signin.click();
		
	}
	
	
}
