package com.qa.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.qa.BrowserStackSetup.BrowserStackSetup;
import com.qa.paths.BaseclassPaths;
import com.qa.paths.WebdriverPaths;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.testlistener.TestListeners;

@Listeners(TestListeners.class)
public class Baseclass {

	public static String env;
	public static String url;
	public static String Browser;
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest extenttest;
	public static ExtentTest node;
	public static WebDriver driver;
	public static Properties configFile = new Properties();
	public static String systemOsName = System.getProperty("os.name");
	public static String commonChromeWebdriverPath = System.getProperty("user.dir") + "/Chromedriver/chromedriver";
	public static String commonFirefoxWebdriverPath = System.getProperty("user.dir") + "/FirefoxDriver/geckodriver";
	public static String linuxOS = "Linux";
	public static String login_tag = "Login";
	public static String funding_tag = "Funding";
	public static String fundingCalculateInterest_tag = "Funding_CalculateInterest";
	public static String fundingDatabase_tag = "Funding_Database";
	public static String fundingInterestPayement_tag = "Funding_InterestPayement";
	public static String fundingManagementAccounts_tag = "Funding_ManagementAccounts";
	public static String loans_tag = "Loans";
	public static String loansNewLoan_tag = "Loan_NewLoan";
	public static String loansDatabase_tag = "Loan_Database";
	public static String pipeline_tag = "Pipeline";
	public static String treasurySingle_tag = "Treasury_Single";
	public static String treasuryPortfolio_tag = "Treasury_Portfolio";
	public static String treasuryDatabase_tag = "Treasury_Database";
	public static String reportingUpdates_tag = "Reporting_Updates";
	public static String reportingBalanceSheet_tag = "Reporting_BalanceSheet";
	public static String reportingLoans_tag = "Reporting_Loans";
	public static String administration_tag = "Administration";
	public static String investor_tag = "Investor";
	public static String Mac = "Mac OS X";
	public static String commonChromeWebdriverPath_mac = System.getProperty("user.dir")
			+ "/Chromedriver/chromedrivermac";
	public static File src;

	@BeforeSuite
	public static void setUp() throws Exception {
		// Config Property File
		File ConfigFile = new File(System.getProperty("user.dir") + "/ConfigFile/Config.properties");
		FileInputStream fileInput3 = null;
		fileInput3 = new FileInputStream(ConfigFile);
		configFile.load(fileInput3);
		// Initializing the property method by calling property function from
		// BaseclassPaths
		BaseclassPaths.property();
		// Create object of baseclasspath and access its variable
		BaseclassPaths obj = new BaseclassPaths();
		env = configFile.getProperty("Environment");
		// Create report folder in project root
		IScreenAction.createDirectoryForReport();
		// Launch the webdriver as per browser selected in config file
		Browser = configFile.getProperty("Browser");
		if (Browser.equalsIgnoreCase("chrome")) {
			// Call Chrome function WebdriverPaths class
			WebdriverPaths.Webdriver_chrome();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			// Call Firefox function for WebdriverPaths class
			WebdriverPaths.Webdriver_firefox();
		}
		// Input the Browser=BrowserStackChrome in Config file
		// if you want to run your code in Browserstack Chrome
		else if (Browser.equalsIgnoreCase("BrowserStackChrome")) {
			System.out.println("STEP1 : User is runing the code in Browserstack Chrome");
			// Call setupBrowserstack from Browserstack class
			driver = BrowserStackSetup.setupChromeBrowserstack();
		}
		// Extent Report Setup
		reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/QA-Report/AutomationReport_"
				+ IScreenAction.getFileExtension() + "Spark.html").viewConfigurer().viewOrder()
						.as(new ViewName[] { ViewName.CATEGORY, ViewName.DASHBOARD, ViewName.TEST, ViewName.EXCEPTION,
								ViewName.AUTHOR, ViewName.DEVICE, ViewName.LOG })
						.apply();
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("OS", systemOsName);
		extent.setSystemInfo("Host Name", "Demo");
		extent.setSystemInfo("Environment", env);
		extent.setSystemInfo("Url", url);
		extent.setSystemInfo("User Name", "Mitali Jaiswal");
		reporter.config().setDocumentTitle("Automation-Testing");
		reporter.config().setReportName("Project-AutomationReport");
		reporter.config().setTheme(Theme.DARK);
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			node.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " :Test case FAILED due to below issues:",
					ExtentColor.RED));
			node.log(Status.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			node.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " :Test Case PASSED", ExtentColor.GREEN));
		} else if (result.getStatus() == ITestResult.SKIP) {
			node.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " :Test Case SKIPPED ", ExtentColor.YELLOW));
		}
	}

	public static String getDataFromExcel(int col2RowValue) throws IOException, FileNotFoundException {
		if (BaseclassPaths.environment.equalsIgnoreCase("Staging")) {
			System.out.println("User is running the code on Staging so fetching the TestData as per that");
			// Import excel sheet.
			src = new File("./StagingTestData.xlsx");
		}
		ArrayList<Object> arrObj = new ArrayList<Object>();
		FileInputStream fs = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet workSheet = workbook.getSheetAt(0);
		int totalRowCount = workSheet.getLastRowNum() + 1;
		int totalColoumnCount = workSheet.getRow(0).getLastCellNum();
		Iterator<Row> row = workSheet.rowIterator();
		int column_num = 0;
		for (int i = 0; i < totalColoumnCount; i++) {
			if (workSheet.getRow(0).getCell(i).getStringCellValue().trim().equals("InputDataValue"))
				column_num = i;
		}
		if (workSheet.getRow(col2RowValue).getCell(column_num).getCellTypeEnum() == CellType.STRING) {
			return workSheet.getRow(col2RowValue).getCell(column_num).toString();
		} else {
			return NumberToTextConverter
					.toText(workSheet.getRow(col2RowValue).getCell(column_num).getNumericCellValue());
		}
	}

	public static void updateDataOnExcel(int col2RowValue, String data) throws IOException, FileNotFoundException {
		if (BaseclassPaths.environment.equalsIgnoreCase("Staging")) {
			System.out.println("User is running the code on Staging so fetching the TestData as per that");
			// Import excel sheet.
			src = new File("./StagingTestData.xlsx");
		}
		ArrayList<Object> arrObj = new ArrayList<Object>();
		FileInputStream fs = new FileInputStream(src);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet workSheet = workbook.getSheetAt(0);
		int totalColoumnCount = workSheet.getRow(0).getLastCellNum();
		// Iterator<Row> row = workSheet.rowIterator();
		int column_num = 0;
		for (int i = 0; i < totalColoumnCount; i++) {
			if (workSheet.getRow(0).getCell(i).getStringCellValue().trim().equals("InputDataValue"))
				column_num = i;
		}
		// Get or create the row
		Row row = workSheet.getRow(col2RowValue);
		if (row == null) {
			row = workSheet.createRow(col2RowValue);
		}
		// Get or create the cell
		Cell cell = row.getCell(column_num);
		if (cell == null) {
			cell = row.createCell(column_num);
		}
		// Set the cell value
		cell.setCellValue(data);
		// Save the changes to the Excel file
		FileOutputStream fos = new FileOutputStream("./StagingTestData.xlsx");
		workbook.write(fos);
		fos.close();
		System.out.println(
				"Value '" + data + "' written to row " + col2RowValue + ", column " + column_num + " in Excel file.");

	}

	@AfterSuite
	public void tearDown() {
		// driver.quit();
		extent.flush();
	}
}
