package io.maestrano.marlin.test;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.maestrano.marlin.pages.LoginPage;
import io.maestrano.marlin.screenrecord.MyScreenRecorder;
import io.maestrano.marlin.test.base.BaseTest;
import io.maestrano.marlin.utils.Constants;
import io.maestrano.marlin.utils.DataUtil;

public class LoginTest extends BaseTest {
	
	String testName = "LoginTest";

	@Test(dataProvider = "getData")
	public void doLogin(Hashtable<String, String> data) throws Exception {
		
		
		test = extent.createTest(testName);

		if (DataUtil.isTestExecutable(xls, testName) || data.get("Runmode").equals("N")) {
			throw new SkipException("runmode is set N");
		}

		openBrowser("chrome");
		navigate(Constants.URL_KEY);

		LoginPage loginPage = new LoginPage(driver);
		PageFactory.initElements(driver, loginPage);

		boolean actualResult = loginPage.doLogin(data.get("username"), data.get("password"));
		
		
		//TODO: fix this true and false
		Assert.assertTrue(actualResult);
		
		
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = DataUtil.getData(xls, testName);

		return data;
	}

}
