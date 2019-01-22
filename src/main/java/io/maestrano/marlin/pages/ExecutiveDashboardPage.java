package io.maestrano.marlin.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import io.maestrano.marlin.pages.base.BasePage;
import io.maestrano.marlin.utils.Constants;

public class ExecutiveDashboardPage extends BasePage {

	public ExecutiveDashboardPage(WebDriver baseTestDriver) {

		driver = baseTestDriver;
	}

	@FindBy(xpath = Constants.MARKETPLACE_XPATH)
	private WebElement marketplaceLink;

	@FindBy(xpath = Constants.DASHBOARD_NAV_XPATH)
	private WebElement dashboardNav;

	@FindBy(xpath = Constants.ADDDASHBOARD_XPATH)
	private WebElement addDashboard;

	@FindBy(xpath = Constants.ADDDASHBOARDNAME_XPATH)
	private WebElement addDashboardName;

	@FindBy(xpath = Constants.ADDDASHBOARDBTN_XPATH)
	private WebElement addDashboardBtn;

	@FindBy(xpath = Constants.GETSTARTEDDASHBOARD_XPATH)
	private WebElement getStartedDashboard;
	@FindBy(xpath = Constants.ADDMODULESDASHBOARD_XPATH)
	private WebElement addModules;

	@FindAll(@FindBy(how = How.XPATH, using = Constants.SELECTMODULES_XPATH))
	private List<WebElement> selectModules;
	@FindBy(xpath = Constants.ADDSELECTEDMODULES_XPATH)
	private WebElement addSelectedModules;

	@FindBy(xpath = Constants.HIDEADDMODULES_XPATH)
	private WebElement hideModules;

	@FindBy(xpath = Constants.ADDKPI_XPATH)
	private WebElement addKpi;

	@FindAll(@FindBy(how = How.XPATH, using = Constants.ALLKPI_XPATH))
	private List<WebElement> allKpi;
	
	@FindBy(xpath = Constants.DONEKPI_XPATH)
	private WebElement doneKPI;
	
	@FindBy(xpath = Constants.SAVE_XPATH)
	private WebElement saveModules;
	
	
	@FindBy(name = Constants.KPITIMEPERIOD_NAME)
	private WebElement kpiTimePeriod;
	
	@FindBy(name = Constants.SIGNOUT_XPATH)
	private WebElement signout;
	
	// click on marketplace button
	public void gotoMarketplace() {
		marketplaceLink.click();
	}

	public void addDashboard(String name) {

		addDashboard.click();
		addDashboardName.sendKeys(name);
		addDashboardBtn.click();

	}

	public void addModulesDashboard() {

		getStartedDashboard.click();
		addModules.click();

	}

	public void addSelectDashboard(String ModuleName,String KPIName, String timePeriod) throws InterruptedException {

		for (WebElement webElement : selectModules) {
			

			if (webElement.getText().equals(ModuleName)) {
				webElement.click();
				addSelectedModules.click();
				break;
			}

		}
		hideModules.click();
		
		addKpi.click();
		Thread.sleep(3000);
		
		for (WebElement webElement : allKpi) {
			System.out.println(webElement.getText());
			if (webElement.getText().contains(KPIName)) {
				webElement.click();
				
				kpiTimePeriod.sendKeys(timePeriod);
				Thread.sleep(2000);
				doneKPI.click();
				break;
			}
		}
		
		saveModules.click();
	}
	public void signOut() {
		signout.click();
	}

}
