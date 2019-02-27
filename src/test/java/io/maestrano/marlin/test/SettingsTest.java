package io.maestrano.marlin.test;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.maestrano.marlin.pages.ExecutiveDashboardPage;
import io.maestrano.marlin.pages.LoginPage;
import io.maestrano.marlin.pages.SettingsPage;
import io.maestrano.marlin.test.base.BaseTest;
import io.maestrano.marlin.utils.Constants;
import io.maestrano.marlin.utils.DataUtil;

public class SettingsTest extends BaseTest {
	String testName = "SettingsTest";

	@Test(dataProvider = "getData")
	public void settingsTest(Hashtable<String, String> data) throws Exception {
		test = extent.createTest(testName);
		if (DataUtil.isTestExecutable(xls, testName) || data.get("Runmode").equals("N")) {
			throw new SkipException("runmode is set N");
		}
		openBrowser("chrome");
		navigate(Constants.URL_KEY);

		// loging in
		LoginPage loginPage = new LoginPage(driver);
		PageFactory.initElements(driver, loginPage);
		boolean actualResult = loginPage.doLogin(data.get("username"), data.get("password"));
		if (!actualResult) {
			Assert.fail("Login Failed");
		}

		ExecutiveDashboardPage exeDashboardPage = new ExecutiveDashboardPage(driver);
		
		PageFactory.initElements(driver, exeDashboardPage);
		exeDashboardPage.goToSettings();

		Thread.sleep(6000);
		
		SettingsPage settingspage = new SettingsPage(driver);
		
		PageFactory.initElements(driver, settingspage);
		settingspage.goToManageDashboard();
		settingspage.clickOnAddDashboardLink();
		
		
		
	}

	@DataProvider
	public Object[][] getData() {
		return DataUtil.getData(xls, testName);
	}
}
