package io.maestrano.marlin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.maestrano.marlin.pages.base.BasePage;
import io.maestrano.marlin.utils.Constants;

public class SettingsPage extends BasePage {

	public SettingsPage(WebDriver baseTestDriver) {

		driver = baseTestDriver;
	}

	@FindBy(xpath = Constants.MANAGEDASHBOARDS_XPATH)
	private WebElement manageDashboard;
	

	@FindBy(xpath = Constants.ADDDASHBOARD2_XPATH)
	private WebElement adddashboard2;

	public void goToManageDashboard() {

		explicit_xpath(Constants.MANAGEDASHBOARDS_XPATH, 50);
		manageDashboard.click();

	}
	public void clickOnAddDashboardLink() {

		explicit_xpath(Constants.ADDDASHBOARD2_XPATH, 50);
		adddashboard2.click();


}
}