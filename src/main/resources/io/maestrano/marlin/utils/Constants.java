
package io.maestrano.marlin.utils;

public class Constants {

	public static String URL_KEY = "https://marlin-frontend2.uat.marlin.maestrano.io/user/login";

	// loginPage
	public static final String EMAIL_NAME = "email";
	public static final String PASS_NAME = "password";
	public static final String LOGIN_XPATH = "//form[@name='form']/div[3]/button";

	public static final String SIGNOUT_XPATH = "//*[@data-pt-name='bb_hd_signout']";

	// marketplace
	public static final String DASHBOARD_XPATH = "//*[@data-pt-name='bb_hd_dashboard']";
	public static final String PROCEED_XPATH = "//button[contains(text(),'Proceed')]";
	public static final String ALLAPPS_XPATH = "//div/article";

	// dashboard
	public static final String MARKETPLACE_XPATH = "//*[@data-pt-name='bb_hd_marketplace']";
	public static final String DASHBOARD_NAV_XPATH = "//*[@class=\"dashboard-nav\"]";
	public static final String ADDDASHBOARD_XPATH = "//*[@data-pt-name=\"bb_hd_close_create_dash\"]";
	public static final String ADDDASHBOARDNAME_XPATH = "//*[@placeholder=\"Dashboard's name\"]";
	public static final String ADDDASHBOARDBTN_XPATH = "//*[@data-pt-name=\"bb_hd_confirmAddDashboard\"]";
	public static final String GETSTARTEDDASHBOARD_XPATH = "//*[@data-pt-name=\"bb_lnk_getstarted\"]";
	public static final String ADDMODULESDASHBOARD_XPATH = "//a[contains(text(),'Add module')]";
	public static final String SELECTMODULES_XPATH = "//*[@class=\"tile\"]";
	public static final String ADDSELECTEDMODULES_XPATH = "//*[text()='Add to dashboard']";
	public static final String HIDEADDMODULES_XPATH = "//*[@data-pt-name=\"bb_ft_collapseaddmodule\"]";
	public static final String ADDKPI_XPATH = "//*[@data-pt-name=\"bb_mm_more_dashboard_kpi\"]";
	public static final String ALLKPI_XPATH = "//li/ul/li[@class=\"ng-star-inserted\"]";
	public static final String KPITIMEPERIOD_NAME="timePeriod";
	public static final String DONEKPI_XPATH = "//*[text()='Done']";
	public static final String SAVE_XPATH = "//*[text()='Save']";
	
	
	//quickbooks login
	public static final String QUICKBOOKSUSERNAME_ID = "ius-userid";
	public static final String QUICKBOOKSPASSWORD_ID = "ius-password";
	public static final String QUICKBOOKSSIGNINBTN_ID = "ius-sign-in-submit-btn";
	
	//Settings
	public static final String SETTINGSICON_XPATH ="//a[@rel='setting']";
			//"(//nav[@class='utility-nav ml-auto d-flex justify-content-end align-items-center']//span[@class='ng-star-inserted'])";
	
	// config
	public static String REPORTS_PATH = System.getProperty("user.dir") + "/Reports/";
	public static String DATA_XLS_PATH = System.getProperty("user.dir") + "/Data.xlsx";
	public static String CHROMEDRIVER_EXE = "/Users/premalathaeddyam/eclipse-workspace/chromedriver";
	public static String DATA_XLS_SHEET = "Data";
	public static String TESTCASE_XLS_SHEET = "Testcases";
	public static String RUNMODE_XLS = "Runmode";
	public static String TESTCASENAME_XLS = "TestCaseName";

}
