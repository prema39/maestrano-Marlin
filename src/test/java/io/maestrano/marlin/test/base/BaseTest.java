package io.maestrano.marlin.test.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import io.maestrano.marlin.utils.Constants;
import io.maestrano.marlin.utils.ExtentManager;
import io.maestrano.marlin.utils.Xls_Reader;

public class BaseTest {
	public static Xls_Reader xls = new Xls_Reader(Constants.DATA_XLS_PATH);

	protected WebDriver driver;
	protected ExtentReports extent = ExtentManager.getInstance();
	protected ExtentTest test;

	public void openBrowser(String browserType) {
		test.info("Opening browser: " + browserType);
		switch (browserType) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_EXE);
			driver = new ChromeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", "binaries/ie.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("please enter any browsername" + browserType);
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	public void navigate(String urlKey) {
		test.info("navgating to " + urlKey);
		driver.get(urlKey);
	}

	/****************** Reporting ***************/

	public void reportFailure(String failureMessage) {
		test.fail(failureMessage);
		takeScreenShot();
	}

	public void reportSkip(String skipMsg) {
		test.skip(skipMsg);
	}

	public void takeScreenShot() {
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String filePath = Constants.REPORTS_PATH + "screenshots/" + screenshotFile;
		// store screenshot in that file
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File(filePath));
			test.info("Screenshot--> ",
					MediaEntityBuilder.createScreenCaptureFromPath("./screenshots/" + screenshotFile).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/******************** Test Method *******************/

	@AfterMethod
	public void quit(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			reportFailure(result.getThrowable().toString());
		} else if (result.getStatus() == ITestResult.SKIP) {
			reportSkip(result.getThrowable().toString());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass("test passed");
		}

		// reporting
		extent.flush();

		if (driver != null) {

//			driver.quit();
		}
		System.out.println("*******************************************");
		System.out.println("*******************************************");
	}
}
