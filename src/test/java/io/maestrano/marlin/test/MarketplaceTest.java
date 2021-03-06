package io.maestrano.marlin.test;




import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.maestrano.marlin.pages.ExecutiveDashboardPage;
import io.maestrano.marlin.pages.LoginPage;
import io.maestrano.marlin.pages.MarketplacePage;

import io.maestrano.marlin.test.base.BaseTest;
import io.maestrano.marlin.utils.Constants;
import io.maestrano.marlin.utils.DataUtil;

public class MarketplaceTest extends BaseTest {
	String testName = "MarketplaceTest";
	

	@Test(dataProvider = "getData")
	public void doLogin(Hashtable<String, String> data) throws Exception {
		
		test = extent.createTest(testName);
		if (DataUtil.isTestExecutable(xls, testName) || data.get("Runmode").equals("N")) {
			throw new SkipException("runmode is set N");
		}
		openBrowser("chrome");
		navigate(Constants.URL_KEY);
		
		//loging in
		LoginPage loginPage = new LoginPage(driver);
		PageFactory.initElements(driver, loginPage);
		boolean actualResult = loginPage.doLogin(data.get("username"), data.get("password"));
		if (!actualResult) {
			Assert.fail("Login Failed");
		}

		
		//going to marktplace
		ExecutiveDashboardPage exedashPage = new ExecutiveDashboardPage(driver);
		PageFactory.initElements(driver, exedashPage);
		exedashPage.gotoMarketplace();
		
		Thread.sleep(5000);
		//going to dashboard
		MarketplacePage marketplacePage = new MarketplacePage(driver);
		PageFactory.initElements(driver, marketplacePage);
		marketplacePage.gotoDashboard();
		Thread.sleep(5000);
		//check dashboard
		PageFactory.initElements(driver, exedashPage);
		System.out.println(driver.findElements(By.xpath(Constants.DASHBOARD_NAV_XPATH)).size());
		
	}

	@DataProvider
	public Object[][] getData() {
		return DataUtil.getData(xls, testName);
	}
}
