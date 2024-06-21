package com.qa.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.locators.allPages.FundingCalculateInterestPO;
import com.locators.allPages.FundingDatabasePO;
import com.locators.allPages.FundingInterestPaymentPO;
import com.locators.allPages.FundingManagementAccountsPO;
import com.locators.allPages.FundingNewFacilityPO;
import com.locators.allPages.PipelinePO;
import com.locators.allPages.ReportingManagementAccountsPO;
import com.locators.allPages.UtilsPO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.url.AllPagesUrl;

public class FundingPage extends Baseclass {

	/**
	 * The "loadCalculateInterestPage" function is used to load the Calculate
	 * Interest page under funding
	 *
	 * @author Daffodil Software Private Limited
	 * @version 1.0
	 * @since 20.12.2023
	 */
	public static void loadCalculateInterestPage() {
		IElementActions.pageRefresh();
		// Open the calculate interest page
		node.log(Status.INFO, "SUB-STEP_0.001 : Opening the Calculate Interest page under funding");
		System.out.println("SUB-STEP_0.001 : Opening the Calculate Interest page under funding");
		driver.get(AllPagesUrl.calculateInterestPage);
		// Wait for the visibility of Calculate Interest page
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of Calculate Interest page");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of Calculate Interest page");
		IWaitStrategy.waitForVisiblity(node, driver, FundingCalculateInterestPO.runScriptButton);
		IWaitStrategy.WaitUntilElementClickable(node, driver, FundingCalculateInterestPO.runScriptButton);
		node.log(Status.INFO, "SUB-STEP_0.003 : Calculate Interest page is visible");
		System.out.println("SUB-STEP_0.003 : Calculate Interest page is visible");
	}

	/**
	 * The "loadInterestPaymentPage" function is used to load the Interest Payment
	 * page under funding
	 *
	 * @author Daffodil Software Private Limited
	 * @version 1.0
	 * @since 27.12.2023
	 */
	public static void loadInterestPaymentPage() {
		// Open the interest payment page
		node.log(Status.INFO, "SUB-STEP_0.001 : Opening the Interest Payment page under funding");
		System.out.println("SUB-STEP_0.001 : Opening the Interest Payment page under funding");
		driver.get(AllPagesUrl.interestPaymentPage);
		// Wait for the visibility of Interest Payment page
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of Interest Payment page");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of Interest Payment page");
		IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.compile);
		IWaitStrategy.WaitUntilElementClickable(node, driver, FundingInterestPaymentPO.compile);
		node.log(Status.INFO, "SUB-STEP_0.003 : Interest Payment page is visible");
		System.out.println("SUB-STEP_0.003 : Interest Payment page is visible");
	}

	/**
	 * The "loadDatabasePage" function is used to load the database page under
	 * funding
	 *
	 * @author Daffodil Software Private Limited
	 * @version 1.0
	 * @since 27.12.2023
	 */
	public static void loadDatabasePage() {
		// Open the database page
		node.log(Status.INFO, "SUB-STEP_0.001 : Opening the Database page under funding");
		System.out.println("SUB-STEP_0.001 : Opening the Database page under funding");
		driver.get(AllPagesUrl.fundingDatabasePage);
		// Wait for the visibility of Database Interest page
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of Database page");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of Database page");
		IWaitStrategy.waitForVisiblity(node, driver, FundingDatabasePO.headerLoanFacilityDatabaseText);
		IWaitStrategy.waitForVisiblity(node, driver, FundingDatabasePO.internalReferenceFirstRowValue);
		node.log(Status.INFO, "SUB-STEP_0.003 : Database page is visible");
		System.out.println("SUB-STEP_0.003 : Database page is visible");
	}

	public static void loadManagementAccountsPage() {
		// Open the management accounts page
		node.log(Status.INFO, "SUB-STEP_0.001 : Opening the Management Accounts page under funding");
		System.out.println("SUB-STEP_0.001 : Opening the Management Accounts page under funding");
		driver.get(AllPagesUrl.fundingManagementAccounts);
		// Wait for the visibility of management accounts page
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of Management Accounts page");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of Management Accounts page");
		IWaitStrategy.waitForVisiblityDynamic(node, driver, FundingManagementAccountsPO.firstRecordLaunchDate, 150);
		IWaitStrategy.WaitUntilElementClickable(node, driver, FundingManagementAccountsPO.runScriptButton);
		node.log(Status.INFO, "SUB-STEP_0.003 : Management Accounts page is visible");
		System.out.println("SUB-STEP_0.003 : Management Accounts page is visible");
	}

	public static void loadDatabasePageAndClearSearchIfAny() {
		// Open the database page
		node.log(Status.INFO, "SUB-STEP_0.001 : Opening the Database page under funding");
		System.out.println("SUB-STEP_0.001 : Opening the Database page under funding");
		driver.get(AllPagesUrl.fundingDatabasePage);

		// Create an instance of JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Execute JavaScript to scroll horizontally to the end of the left
		js.executeScript("window.scrollTo(0, 0);");

		// Check cross icon is available or not
		boolean checkCrossIcon = IElementActions.isElementAvailable(node, driver, UtilsPO.headerSearchCrossIcon);

		// If cross icon is present, click on it to clear the search
		if (checkCrossIcon) {
			// Click on the cross icon to clear the search
			IElementActions.clickelement_usingXpath(node, driver, UtilsPO.headerSearchCrossIcon);
			node.log(Status.INFO, "STEP_0.001 : clicked on the cross icon");
			System.out.println("STEP_0.001 : clicked on the cross icon");
		}

		// Wait for the visibility of Database Interest page
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of Database page");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of Database page");
		IWaitStrategy.waitForVisiblity(node, driver, FundingDatabasePO.headerLoanFacilityDatabaseText);
		IWaitStrategy.waitForVisiblity(node, driver, FundingDatabasePO.internalReferenceFirstRowValue);
		node.log(Status.INFO, "SUB-STEP_0.003 : Database page is visible");
		System.out.println("SUB-STEP_0.003 : Database page is visible");
	}

	public static void loadNewFacilityPage() {
		// Open the New Facility page
		node.log(Status.INFO, "SUB-STEP_0.001 : Opening the New Facility page under funding");
		System.out.println("SUB-STEP_0.001 : Opening the New Facility page under funding");
		driver.get(AllPagesUrl.fundingNewFacilityPage);
		// Wait for the visibility of New Facility page
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of New Facility page");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of New Facility page");
		IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.newFacilityPageHeader);
		node.log(Status.INFO, "SUB-STEP_0.003 : New Facility page is visible");
		System.out.println("SUB-STEP_0.003 : New Facility page is visible");
	}

	public static void selectPastDataAndClickRunScript() throws InterruptedException {
		String formattedDate = Utils.getYesterdayDateFormatted();
		String pastDateElement = IElementActions.createDynamicLocatorString(FundingCalculateInterestPO.futureDate,
				"locatorValue", formattedDate);
		System.out.println("pastDateElement " + pastDateElement);
		node.log(Status.INFO, "pastDateElement " + pastDateElement);
		// Wait for the visibility of the entry
		node.log(Status.INFO, "STEP2 : Waiting for the visibility of the calender popup");
		System.out.println("STEP2 : Waiting for the visibility of the calender popup");
		IWaitStrategy.WaitUntilElementClickable(node, driver, FundingCalculateInterestPO.date);
		node.log(Status.INFO, "STEP3 : Calender popup is visible");
		System.out.println("STEP3 : Calender popup is visible");
		// Click on the date
		IElementActions.clickelement_usingXpath(node, driver, FundingCalculateInterestPO.date);
		node.log(Status.INFO, "STEP1 : clicked on the date");
		System.out.println("STEP1 : clicked on the date");
		// Wait for the visibility of the entry
		node.log(Status.INFO, "STEP2 : Waiting for the visibility of the calender popup");
		System.out.println("STEP2 : Waiting for the visibility of the calender popup");
		IWaitStrategy.waitForVisiblity(node, driver, FundingCalculateInterestPO.calenderMonth);
		node.log(Status.INFO, "STEP3 : Calender popup is visible");
		System.out.println("STEP3 : Calender popup is visible");
		// Click on the date
		IElementActions.clickelement_usingXpath(node, driver, pastDateElement);
		node.log(Status.INFO, "STEP1 : clicked on the past date");
		System.out.println("STEP1 : clicked on the past date");
		Utils.clickOnRunScriptButton();
	}

	public static String checkStatus(String xRecordDoneStatus, String xRecordInProgressStatus,
			String xRecordErrorStatus) {
		// Check if the span element is present for done status
		boolean isSpanPresent = IElementActions.isElementAvailable(node, driver, xRecordDoneStatus);
		// Check if the div element is present for progress status
		boolean isDivPresent = IElementActions.isElementAvailable(node, driver, xRecordInProgressStatus);
		// Check if the div element is present for error status
		boolean isDivErrorPresent = IElementActions.isElementAvailable(node, driver, xRecordErrorStatus);
		// Determine the status based on element presence
		String status = null;
		if (isSpanPresent) {
			status = IElementActions.getElementText_usingXpath(node, driver, xRecordDoneStatus);
		} else if (isDivPresent) {
			status = IElementActions.getElementText_usingXpath(node, driver, xRecordInProgressStatus);
		} else if (isDivErrorPresent) {
			status = IElementActions.getElementText_usingXpath(node, driver, xRecordErrorStatus);
		}
		return status;
	}

	public static String[] calculateDates(String selectedYear, String selectedMonth) throws InterruptedException {
		// Parse String values to integers
		int month = Integer.parseInt(selectedMonth);
		int year = Integer.parseInt(selectedYear);
		Thread.sleep(2000);
		// Calculate start and end dates
		LocalDate endDate = LocalDate.of(year, month, 15);
		LocalDate startDate = endDate.minusMonths(1).withDayOfMonth(15);
		// If 15th falls on Saturday or Sunday, pick previous Friday
		if (endDate.getDayOfWeek() == DayOfWeek.SATURDAY || endDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
			endDate = endDate.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
		}
		if (startDate.getDayOfWeek() == DayOfWeek.SATURDAY || startDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
			startDate = startDate.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
		}
		// Format dates as strings in "dd/MM/yyyy" format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String startDateString = startDate.format(formatter);
		String endDateString = endDate.format(formatter);
		// Return start and end dates as an array of strings
		return new String[] { startDateString, endDateString };
	}

	public static void loadInterestPaymentPageAndNavigateToStep2(String year, String month)
			throws FileNotFoundException, IOException {
		// Call the loadInterestPaymentPage function from the FundingPage
		FundingPage.loadInterestPaymentPage();
		// Call the navigetToHealthStepPage function from the FundingPage
		FundingPage.navigateToHealthStepPage(year, month);
	}

	public static void loadLatestInterestPaymentPageAndNavigateToStep2() throws FileNotFoundException, IOException {
		// Get current year and month
		String year = Utils.getCurrectYear();
		String month = Utils.getCurrentMonth();
		loadInterestPaymentPageAndNavigateToStep2(year, month);
	}

	public static void loadInterestPaymentPageAndNavigateToStep3(String year, String month)
			throws FileNotFoundException, IOException {
		loadInterestPaymentPageAndNavigateToStep2(year, month);
		// Call the navigateToStep function from the FundingPage
		FundingPage.navigateToStep(FundingInterestPaymentPO.monthOnMonthComparisonStep3);
		// Wait for the visibility of the loan amount
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the facility loan amount");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the facility loan amount");
		IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.facilityLoanAmount);
		node.log(Status.INFO, "SUB-STEP_0.002 : Facility loan amount is visible");
		System.out.println("SUB-STEP_0.002 : Facility loan amount is visible");
	}

	public static void loadInterestPaymentPageAndNavigateToStep4(String year, String month)
			throws FileNotFoundException, IOException {
		loadInterestPaymentPageAndNavigateToStep2(year, month);
		// Call the navigateToStep function from the FundingPage
		FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);
		// Wait for the visibility of the element
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the step4 page");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the step4 page");
		IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.bridgeLoanTable2);
		node.log(Status.INFO, "SUB-STEP_0.002 : Step4 page is visible");
		System.out.println("SUB-STEP_0.002 : Step4 page is visible");
	}

	public static void loadLatestInterestPaymentPageAndNavigateToStep4() throws FileNotFoundException, IOException {
		// Get current year and month
		String year = Utils.getCurrectYear();
		String month = Utils.getCurrentMonth();
		loadInterestPaymentPageAndNavigateToStep2(year, month);
		// Call the navigateToStep function from the FundingPage
		FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);
		// Wait for the visibility of the element
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the step4 page");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the step4 page");
		IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.bridgeLoanTable2);
		node.log(Status.INFO, "SUB-STEP_0.002 : Step4 page is visible");
		System.out.println("SUB-STEP_0.002 : Step4 page is visible");
	}

	public static void loadInterestPaymentPageAndNavigateToStep5(String year, String month)
			throws FileNotFoundException, IOException {
		loadInterestPaymentPageAndNavigateToStep2(year, month);
		// Call the navigateToStep function from the FundingPage
		FundingPage.navigateToStep(FundingInterestPaymentPO.accountingStep5);
		// Wait for the visibility of the element
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the step5 page");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the step5 page");
		IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.internalReferenceColumn);
		node.log(Status.INFO, "SUB-STEP_0.002 : Step5 page is visible");
		System.out.println("SUB-STEP_0.002 : Step5 page is visible");
	}

	public static void navigateToHealthStepPage(String year, String month) {
		// Wait for the visibility of year dropdown
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of year dropdown");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of year dropdown");
		IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.yearDropDown);
		IWaitStrategy.WaitUntilElementClickable(node, driver, FundingInterestPaymentPO.yearDropDown);
		node.log(Status.INFO, "SUB-STEP_0.002 : Year dropdown is visible and clickable");
		System.out.println("SUB-STEP_0.002 : Year dropdown is visible and clickable");
		// Select Year from Year Dropdown
		node.log(Status.INFO, "SUB-STEP_0.003 : Select the Year from the Year Dropdown");
		System.out.println("SUB-STEP_0.003 : Select the Year from the Year Dropdown");
		IElementActions.selectValueFromDropdown(node, driver, FundingInterestPaymentPO.yearDropDown, year);
		// Select Month from Month Dropdown
		node.log(Status.INFO, "SUB-STEP_0.004 : Select the Month from the Month Dropdown");
		System.out.println("SUB-STEP_0.004 : Select the Month from the Month Dropdown");
		IElementActions.selectValueFromDropdown(node, driver, FundingInterestPaymentPO.monthDropDown, month);
		// Scroll to the Today's Date
		IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingInterestPaymentPO.todaysDate);
		node.log(Status.INFO, "SUB-STEP_0.005 : Scrolled to the  today's date");
		System.out.println("SUB-STEP_0.005 : Scrolled to the today's date");
		// Wait for the visibility of the View interest Button
		node.log(Status.INFO, "SUB-STEP_0.006 : Waiting for the visibility of the view interest button");
		System.out.println("SUB-STEP_0.006 : Waiting for the visibility of the view interest button");
		IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.firstViewInterestButton);
		node.log(Status.INFO, "SUB-STEP_0.007 : The View interest button is visible");
		System.out.println("SUB-STEP_0.007 : The View interest button is visible");
		// Click on View interest first Button
		IElementActions.clickelement_usingXpath(node, driver, FundingInterestPaymentPO.firstViewInterestButton);
		node.log(Status.INFO, "SUB-STEP_0.008 : Clicked on the View Interest first Button");
		System.out.println("SUB-STEP_0.008 : Clicked on the View Interest first Button");
		// Wait for Page Load
		node.log(Status.INFO, "SUB-STEP_0.009 : Waiting for the complete page loding");
		System.out.println("SUB-STEP_0.009 : Waiting for the complete page loading");
		IWaitStrategy.WaitForPageLoadingToComplete(node, driver);
		node.log(Status.INFO, "SUB-STEP_0.0010 : Complete Page is load successfully");
		System.out.println("SUB-STEP_0.0010 : Complete Page is load successfully");
	}

	public static void validateFourSideArrowIcon(String arrowLocator, String popupLocator, String popupHeaderLocator,
			String message) {
		// Wait for the visibility Four Side Arrow icon
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of " + message + " Four Side Arrow icon");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of " + message + " Four Side Arrow icon");
		IWaitStrategy.waitForVisiblity(node, driver, arrowLocator);
		node.log(Status.INFO, "SUB-STEP_0.002 : The " + message + " Four Side Arrow icon is visible");
		System.out.println("SUB-STEP_0.002 : The " + message + " Four Side Arrow icon is visible");
		// Clicked on four side arrow icon
		IElementActions.clickelement_usingXpath(node, driver, arrowLocator);
		node.log(Status.INFO, "SUB-STEP_0.003 : Clicked on " + message + " Four Side Arrow icon");
		System.out.println("SUB-STEP_0.003 : Clicked on " + message + " Four Side Arrow icon");
		// Wait for the visibility of Popup
		node.log(Status.INFO, "SUB-STEP_0.004 : Waiting for the visibility " + message + " Details Popup");
		System.out.println("SUB-STEP_0.004 : Waiting for the visibility " + message + " Details Popup");
		IWaitStrategy.waitForVisiblity(node, driver, popupLocator);
		node.log(Status.INFO, "SUB-STEP_0.005 : The " + message + " Details Popup is visibile");
		System.out.println("SUB-STEP_0.005 : The " + message + " Details Popup is visibile");
		// Check the visibility of Popup Header
		IElementActions.assertTrue_usingXpath(node, driver, popupHeaderLocator,
				"SUB-STEP_0.006 : BUG: The " + message + " Details Header is not coming on All " + message
						+ " Details Popup",
				"SUB-STEP_0.006 : EXPECTED: The " + message + " Details Header is coming on " + message
						+ " Details Popup");
	}

	public static void clickOnDetailArrowIcon(String arrowLocator, String popupLocator) {
		// Clicked on icon
		IElementActions.clickelement_usingXpath(node, driver, arrowLocator);
		node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on detail arrow icon");
		System.out.println("SUB-STEP_0.001 : Clicked on detail arrow icon");
		// Wait for the visibility of element
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of element");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of element");
		IWaitStrategy.waitForVisiblity(node, driver, arrowLocator);
		node.log(Status.INFO, "SUB-STEP_0.003 : The element is visible");
		System.out.println("SUB-STEP_0.003 : The element is visible");
	}

	public static void navigateToStep(String step) {
		// Scroll up
		IElementActions.scrollToTop(driver);
		// Wait for the visibility of the step icon
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the stepper icon");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the stepper icon");
		IWaitStrategy.waitForVisiblity(node, driver, step);
		node.log(Status.INFO, "SUB-STEP_0.002 : The stepper icon is visible");
		System.out.println("SUB-STEP_0.002 : The stepper icon is visible");
		// Click on step icon
		IElementActions.clickelement_usingXpath(node, driver, step);
		node.log(Status.INFO, "SUB-STEP_0.003 : Clicked on the step");
		System.out.println("SUB-STEP_0.003 : Clicked on the step");
		// Wait for Page Load
		node.log(Status.INFO, "SUB-STEP_0.004 : Waiting for the complete page loding");
		System.out.println("SUB-STEP_0.004 : Waiting for the complete page loading");
		IWaitStrategy.WaitForPageLoadingToComplete(node, driver);
		node.log(Status.INFO, "SUB-STEP_0.005 : Complete Page is load successfully");
		System.out.println("SUB-STEP_0.005 : Complete Page is load successfully");
	}

	public static void validateDetailsTextArrowIcon(String detailsDownSideArrowIconLocator, String tableLocator,
			String detailsUpSideArrowIconLocator, String popupName, String testCaseName)
			throws FileNotFoundException, IOException {
		// Check the Visibility of Details text with arrow down icon
		IElementActions.assertTrue_usingXpath(node, driver, detailsDownSideArrowIconLocator,
				"SUB-STEP_0.001 : BUG: The Details text with arrow down icon is not coming on " + popupName
						+ " details Popup",
				"SUB-STEP_0.001 : EXPECTED: The Details text with arrow down icon is coming on " + popupName
						+ " details Popup");
		// Clicked On Down Arrow icon of Details Text
		IElementActions.clickelement_usingXpath(node, driver, detailsDownSideArrowIconLocator);
		node.log(Status.INFO, "SUB-STEP_0.002 : Clicked on Details Text Down Arrow icon");
		System.out.println("SUB-STEP_0.002 : Clicked on Details Text Down Arrow icon");
		// Check the visibility of Facility's Data Table
		IElementActions.assertTrue_usingXpath(node, driver, tableLocator,
				"SUB-STEP_0.003 : BUG: The facility's data table is not coming when clicked on Details down side arrow icon",
				"SUB-STEP_0.003 : EXPECTED: The facility's data table is coming when clicked on Details down side arrow icon");
		// Check if the 'double-up' is present in the class attribute
		boolean isArrowUp = IElementActions.checkAttributePresentInClass(detailsUpSideArrowIconLocator, "double-up");
		// Print the result
		if (isArrowUp) {
			node.log(Status.PASS,
					"SUB-STEP_0.004 : The User Successfully clicked on details text Down side Arrow icon and Down side Arrow is changed to Up side Arrow icon");
			System.out.println(
					"SUB-STEP_0.004 : The User Successfully clicked on details text Down side Arrow icon and Down side Arrow is changed to Up side Arrow icon");
			Assert.assertTrue(true,
					"The User Successfully clicked on details text Down side Arrow and Down side Arrow icon is changed to Up side Arrow icon");
			// Take screenshot
			IScreenAction.captureScreenShot_PassCase(testCaseName, "Pass", driver);
		} else {
			System.out.println(
					"SUB-STEP_0.004 : The User is not clicked on details text Down side Arrow icon and Down side Arrow is not changed to Up side Arrow icon");
			node.log(Status.FAIL,
					"SUB-STEP_0.004 : The User is not clicked on details text  Down side Arrow icon and Down side Arrow is not changed to Up side Arrow icon");
			Assert.assertTrue(false,
					"SUB-STEP_0.004 : The User is not clicked on details text Down side Arrow and Down side Arrow icon is not changed to Up side Arrow icon");
			// Take screenshot
			IScreenAction.captureScreenShot_PassCase(testCaseName, "Fail", driver);
		}
		// Refresh the Page
		IElementActions.pageRefresh();
	}

	public static void validatePopupClose(String closeButtonLocator, String popupLocator, String buttonName,
			String popupName) throws FileNotFoundException, IOException {
		// Check the visibility of Close Button
		IElementActions.assertTrue_usingXpath(node, driver, closeButtonLocator,
				"SUB-STEP_0.001 : BUG: The " + buttonName + " button is not coming on " + popupName + " Details popup",
				"SUB-STEP_0.001 : EXPECTED: The " + buttonName + " button is coming on " + popupName
						+ " Details popup");
		// Click on Close Button
		IElementActions.clickelement_usingXpath(node, driver, closeButtonLocator);
		node.log(Status.INFO, "SUB-STEP_0.002 : Clicked on " + buttonName + " Button");
		System.out.println("SUB-STEP_0.002 : Clicked on " + buttonName + " Button");
		// Check the invisibility of popup
		IElementActions.assertFalse_usingXpath(node, driver, popupLocator,
				"SUB-STEP_0.003 : BUG: After clicked on " + buttonName + " button " + popupName
						+ " Details popup is not closed",
				"SUB-STEP_0.003 : EXPECTED: After clicked on " + buttonName + " button " + popupName
						+ " Details popup is closed");
	}

	public static void bottomBackStepButton(String backStepButtonLocator, int currentStepNumber,
			String currentStepName) {
		// Scrolled Down to Bottom of the Page
		System.out.println("SUB-STEP_0.001 : Scrolled Down to Bottom of the Page");
		node.log(Status.INFO, "SUB-STEP_0.001 : Scrolled Down to Bottom of the Page");
		IElementActions.scrollToBottom(driver);
		// Check the visibility of Back Step Button
		IElementActions.assertTrue_usingXpath(node, driver, backStepButtonLocator,
				"SUB-STEP_0.002 : BUG: The Back Step Button is not coming in Step " + currentStepNumber + " i.e. "
						+ currentStepName,
				"SUB-STEP_0.002 : Pass: The Back Step Button is coming in Step " + currentStepNumber + " i.e. "
						+ currentStepName);
		// Clicked on Back Step Button
		IElementActions.clickelement_usingXpath(node, driver, backStepButtonLocator);
		System.out.println("SUB-STEP_0.003 : Clicked on Back Step Button");
		node.log(Status.INFO, "SUB-STEP_0.003 : Clicked on Back Step Button");
		// Wait for Page Load
		node.log(Status.INFO, "SUB-STEP_0.004 : Waiting for the complete page loding");
		System.out.println("SUB-STEP_0.004 : Waiting for the complete page loading");
		IWaitStrategy.WaitForPageLoadingToComplete(node, driver);
		node.log(Status.INFO, "SUB-STEP_0.005 : Complete Page is load successfully");
		System.out.println("SUB-STEP_0.005 : Complete Page is load successfully");
	}

	public static void bottomNextStepButton(String NextStepButtonLocator, int currentStepNumber,
			String currentStepName) {
		// Scrolled Down to Bottom of the Page
		System.out.println("SUB-STEP_0.001 : Scrolled Down to Bottom of the Page");
		node.log(Status.INFO, "SUB-STEP_0.001 : Scrolled Down to Bottom of the Page");
		IElementActions.scrollToBottom(driver);

		// Wait for the visibility of the step icon
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of the stepper icon");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of the stepper icon");
		IWaitStrategy.waitForVisiblity(node, driver, NextStepButtonLocator);
		node.log(Status.INFO, "SUB-STEP_0.003 : The stepper icon is visible");
		System.out.println("SUB-STEP_0.003 : The stepper icon is visible");

		// Check the visibility of Next Step Button
		IElementActions.assertTrue_usingXpath(node, driver, NextStepButtonLocator,
				"SUB-STEP_0.004 : BUG: The Next Step Button is not coming in Step " + currentStepNumber + " i.e. "
						+ currentStepName + "",
				"SUB-STEP_0.004 : PASS: The Next Step Button is coming in Step " + currentStepNumber + " i.e. "
						+ currentStepName + "");
		// Clicked on Next Step Button
		IElementActions.clickelement_usingXpath(node, driver, NextStepButtonLocator);
		System.out.println("SUB-STEP_0.005 : Clicked on Next Step Button");
		node.log(Status.INFO, "SUB-STEP_0.005 : Clicked on Next Step Button");
		// Wait for Page Load
		node.log(Status.INFO, "SUB-STEP_0.006 : Waiting for the complete page loding");
		System.out.println("SUB-STEP_0.006 : Waiting for the complete page loading");
		IWaitStrategy.WaitForPageLoadingToComplete(node, driver);
		node.log(Status.INFO, "SUB-STEP_0.007 : Complete Page is load successfully");
		System.out.println("SUB-STEP_0.007 : Complete Page is load successfully");
	}

	public static void verifyAllocationDifference(WebDriver driver) {
		// Identify the lists of elements representing Loan Allocation and Facility
		// Allocation
		List<WebElement> loanAllocationElements = IElementActions.returnElements(node, driver,
				FundingInterestPaymentPO.loanAllocations);
		List<WebElement> facilityAllocationElements = IElementActions.returnElements(node, driver,
				FundingInterestPaymentPO.facilityAllocations);
		List<WebElement> expectedDifferenceOfElements = IElementActions.returnElements(node, driver,
				FundingInterestPaymentPO.differences);
		// Check if the number of loan and facility elements is the same
		if (loanAllocationElements.size() != facilityAllocationElements.size()) {
			throw new RuntimeException(
					"Number of Loan Allocation elements does not match the number of Facility Allocation elements.");
		}
		// Loop through the elements and verify the allocation difference for each pair
		for (int i = 0; i < loanAllocationElements.size(); i++) {
			WebElement loanAllocationElement = loanAllocationElements.get(i);
			WebElement facilityAllocationElement = facilityAllocationElements.get(i);
			WebElement expectedDifferenceOfElement = expectedDifferenceOfElements.get(i);
			// Extract the text values of these elements
			String loanAllocationText = loanAllocationElement.getText().trim();
			String facilityAllocationText = facilityAllocationElement.getText().trim();
			String expectedDifferenceText = expectedDifferenceOfElement.getText().trim();
			String loanAllocationFormattedText = Utils.removeCurrencySymbol(loanAllocationText);
			String facilityAllocationFormattedText = Utils.removeCurrencySymbol(facilityAllocationText);
			String expectedDifferenceFormattedText = Utils.removeCurrencySymbol(expectedDifferenceText);
			// Convert text values to numeric types (double) for calculation
			double loanAllocation = Double.parseDouble(loanAllocationFormattedText);
			double facilityAllocation = Double.parseDouble(facilityAllocationFormattedText);
			double expectedDifference = Double.parseDouble(expectedDifferenceFormattedText);
			// Calculate the difference: Loan Allocation - Facility Allocation
			double difference = Math.abs(loanAllocation - facilityAllocation);
			// Assert the result against zero (or a threshold if needed)
			Assert.assertEquals(difference, expectedDifference,
					"The calculated difference is not zero for pair " + (i + 1) + " for Facility allocation "
							+ facilityAllocation + " and  Loan allocation " + loanAllocation);
		}
	}

	public static void closePopUp() {
		// Click on popup close button
		IElementActions.clickelement_usingXpath(node, driver, FundingInterestPaymentPO.crossIcon);
		node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on the close icon");
		System.out.println("SUB-STEP_0.001 : Clicked on the close icon");
		// Wait for the invisibility of the PopUp
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the invisibility of the popup");
		System.out.println("SUB-STEP_0.002 : Waiting for the invisibility of the popup");
		IWaitStrategy.waitForInVisiblity(node, driver, FundingInterestPaymentPO.popUp);
		node.log(Status.INFO, "SUB-STEP_0.003 : Popup is not visible");
		System.out.println("SUB-STEP_0.003 : Popup is not visible");
	}

	public static void clickIIcon(String iButtonLocator) {
		// Click on the I icon
		IElementActions.clickelement_usingXpath(node, driver, iButtonLocator);
		node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on the i icon");
		System.out.println("SUB-STEP_0.001 : Clicked on the i icon");
		// Wait for the visibility of the PopUp
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of the popup");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of the popup");
		IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.popUp);
		node.log(Status.INFO, "SUB-STEP_0.003 : Popup is visible");
		System.out.println("SUB-STEP_0.003 : Popup is visible");
	}

	public static void clickOnPlusIcon(String plusiconLocator, String tableSectionLocator) {
		// Click on theplus icon
		IElementActions.clickelement_usingXpath(node, driver, plusiconLocator);
		node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on the plus icon");
		System.out.println("SUB-STEP_0.001 : Clicked on the plus icon");
		// Wait for the visibility of the table section
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of the section");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of the section");
		IWaitStrategy.waitForVisiblity(node, driver, tableSectionLocator);
		node.log(Status.INFO, "SUB-STEP_0.003 : Section is visible");
		System.out.println("SUB-STEP_0.003 : Section is visible");
	}

	public static void loanIButton(String loanIButtonLocator, String popupLocator, String popupHeaderLocator) {
		// Wait for the visibility of the Loan 'i' Button
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the Loan 'i' Button");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the Loan 'i' Button");
		IWaitStrategy.waitForVisiblity(node, driver, loanIButtonLocator);
		node.log(Status.INFO, "SUB-STEP_0.002 : The Loan 'i' Button is visible");
		System.out.println("SUB-STEP_0.002 : The Loan 'i' Button is visible");
		// Click on Loan 'i' Button
		IElementActions.clickelement_usingXpath(node, driver, loanIButtonLocator);
		node.log(Status.INFO, "SUB-STEP_0.003 : Clicked on Loan 'i' button");
		System.out.println("SUB-STEP_0.003 : Clicked on Loan 'i' button");
		// Wait for the visibility of the Loan Interest Details Popup
		node.log(Status.INFO, "SUB-STEP_0.004 : Waiting for the visibility of the Loan Interest Details Popup");
		System.out.println("SUB-STEP_0.004 : Waiting for the visibility of the Loan Interest Details Popup");
		IWaitStrategy.waitForVisiblity(node, driver, popupLocator);
		node.log(Status.INFO, "SUB-STEP_0.005 : Loan Interest Details Popup is visible");
		System.out.println("SUB-STEP_0.005 : Loan Interest Details Popup is visible");
		// Check the visibility of Popup Header
		IElementActions.assertTrue_usingXpath(node, driver, popupHeaderLocator,
				"SUB-STEP_0.006 : BUG: The Loan Interest Details Header is not coming on Loan Interest Details Popup",
				"SUB-STEP_0.006 : EXPECTED: The Loan Interest Details Header is coming on Loan Interest Details Popup");
	}

	public static void facilityIButton(String facilityIButtonLocator, String popupLocator, String popupHeaderLocator) {
		// Wait for the visibility of the Facility 'i' Button
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the Facility 'i' Button");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the Facility 'i' Button");
		IWaitStrategy.waitForVisiblity(node, driver, facilityIButtonLocator);
		IWaitStrategy.WaitUntilElementClickable(node, driver, facilityIButtonLocator);
		node.log(Status.INFO, "SUB-STEP_0.002 : The Facility 'i' Button is visible");
		System.out.println("SUB-STEP_0.002 : The Facility 'i' Button is visible");
		// Click on Facility 'i' Button
		IElementActions.clickelement_usingXpath(node, driver, facilityIButtonLocator);
		node.log(Status.INFO, "SUB-STEP_0.003 : Clicked on Facility 'i' button");
		System.out.println("SUB-STEP_0.003 : Clicked on Facility 'i' button");
		// Wait for the visibility of the Interest Payment Details Popup
		node.log(Status.INFO, "SUB-STEP_0.004 : Waiting for the visibility of the Interest Payment Details Popup");
		System.out.println("SUB-STEP_0.004 : Waiting for the visibility of the Interest Payment Details Popup");
		IWaitStrategy.waitForVisiblity(node, driver, popupLocator);
		node.log(Status.INFO, "SUB-STEP_0.005 : Interest Payment Details Popup is visible");
		System.out.println("SUB-STEP_0.005 : Interest Payment Details Popup is visible");
		// Check the visibility of Popup Header
		IElementActions.assertTrue_usingXpath(node, driver, popupHeaderLocator,
				"SUB-STEP_0.006 : BUG: The Interest Payment Details Header is not coming on Interest Payment Details Popup",
				"SUB-STEP_0.006 : EXPECTED: The Interest Payment Details Header is coming on Interest Payment Details Popup");
	}

	public static String getHealthCheckStatus(WebDriver driver, String healthCheckName) {
		String healthCheckLocator = IElementActions.createDynamicLocatorString(
				FundingInterestPaymentPO.healthChecksValue, "locatorValue", healthCheckName);
		String status = IElementActions.getElementText_usingXpath(node, driver, healthCheckLocator);
		// Print the status for each health check
		System.out.println(healthCheckName + ": " + status);
		node.log(Status.INFO, "healthCheckName " + status);
		// Check the color and return the status
		return getStatusColor(status);
	}

	public static String getStatusColor(String status) {
		// Assuming that green and red colors are represented by specific classes
		if (status.equalsIgnoreCase("Yes")) {
			return "badge-success";
		} else if (status.equalsIgnoreCase("No")) {
			return "badge-danger";
		} else {
			return "Unknown";
		}
	}

	public static String determineOverallStatus(String... statuses) {
		// If all statuses are "Yes", return "green"; otherwise, return "red"
		for (String status : statuses) {
			if (!"badge-success".equalsIgnoreCase(status)) {
				return "No";
			}
		}
		return "Yes";
	}

	// Function to get the color of the loan record
	public static String getColor(WebElement loanRecord) {
		String classAttribute = loanRecord.getAttribute("class");
		if (classAttribute.contains("greenDisplay")) {
			return "green";
		} else if (classAttribute.contains("redDisplay")) {
			return "red";
		} else if (classAttribute.contains("yellowDisplay")) {
			return "yellow";
		} else {
			return "unknown";
		}
	}

	public static void clickOnAnyFacilityIButton(String facilityIButtonLocator, String popupLocator,
			String popupHeaderLocator) throws FileNotFoundException, IOException {
		String facility = getDataFromExcel(9);
		String facilityIIconLocator = IElementActions.createDynamicLocatorString(facilityIButtonLocator, "locatorValue",
				facility);
		// Calling the facilityIButton function from FundingPage
		FundingPage.facilityIButton(facilityIIconLocator, popupLocator, popupHeaderLocator);
	}

	public static void assertDateInRange(LocalDate date, LocalDate startDate, LocalDate endDate) {
		if (date.isBefore(startDate) || date.isAfter(endDate)) {
			System.out.println("Test case failed! Date " + date + " is not between " + startDate + " and " + endDate);
			node.log(Status.FAIL,
					"Test case failed! Date " + date + " is not between " + startDate + " and " + endDate);
		} else {
			System.out.println("Date " + date + " is in range.");
			node.log(Status.PASS, "Date " + date + " is in range.");
		}
	}

	public static void openFacilityLoanByUsingEditIcon() {
		// Wait for the visibility of edit icon
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of edit icon");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of edit icon");
		IWaitStrategy.waitForVisiblity(node, driver, UtilsPO.editIcon);
		node.log(Status.INFO, "SUB-STEP_0.002 : Edit icon is visible");
		System.out.println("SUB-STEP_0.002 : Edit icon is visible");

		// Click on the edit button
		IElementActions.clickelement_usingXpath(node, driver, UtilsPO.editIcon);
		node.log(Status.INFO, "SUB-STEP_0.003 : Clicked on the edit");
		System.out.println("SUB-STEP_0.003 : Clicked on the edit");

		// Wait for the visibility of facility loan page
		node.log(Status.INFO, "SUB-STEP_0.004 : Waiting for the visibility of facility loan page");
		System.out.println("SUB-STEP_0.004 : Waiting for the visibility of facility loan page");
		IWaitStrategy.waitForVisiblity(node, driver, FundingDatabasePO.facilityLoanText);
		node.log(Status.INFO, "SUB-STEP_0.005 : Facility loan page is visible");
		System.out.println("SUB-STEP_0.005 : Facility loan page is visible");
	}

	// Method to extract loan number using regular expressions
	public static String extractLoanFacilityNumber(String url) {
		Pattern pattern = Pattern.compile("/lf/(\\w+)/");
		Matcher matcher = pattern.matcher(url);
		if (matcher.find()) {
			return matcher.group(1);
		} else {
			return null; // Return null if no match is found
		}
	}

	public static void clickTitlesAndCheckSort(ExtentTest node, WebDriver driver, String sortIcon, String elements,
			String sortingOrder, String testCaseName, String dataType) throws InterruptedException {
		// Click on the sort icon
		IElementActions.clickelement_usingXpath(node, driver, sortIcon);
		node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on the sort icon to " + testCaseName);
		System.out.println("SUB-STEP_0.001 : Clicked on the sort icon to " + testCaseName);

		// Check the sorting order
		Utils.validateDataSortingOrder(node, driver, elements, testCaseName, dataType);
	}

	public static void createFacility(String amount) throws InterruptedException, FileNotFoundException, IOException {
		// Open new facility and enter amount in facility yab
		goToNewFacilityAndEnterAmountInFacility(amount);

		// Click on facility tab
		Utils.waitAndClickOnTab(FundingNewFacilityPO.summaryTab, FundingNewFacilityPO.loanFacilitySummaryText,
				"Facility Summary");

		IElementActions.scrollToBottom(driver);
		// Save loan
		Utils.saveLoan();

		Thread.sleep(2000);
		// Get the current URL
		String currentUrl = driver.getCurrentUrl();

		// Extract the loan number from the URL using regular expressions
		String loanFacilityNumber = FundingPage.extractLoanFacilityNumber(currentUrl);
		node.log(Status.INFO, "SUB-STEP_0.001 : Loan facility number is " + loanFacilityNumber);
		System.out.println("SUB-STEP_0.001 : Loan facility number is " + loanFacilityNumber);

		// Update created loan facility number on excel
		updateDataOnExcel(60, loanFacilityNumber);
	}

	public static void goToNewFacilityAndEnterAmountInFacility(String amount)
			throws InterruptedException, FileNotFoundException, IOException {
		// Calling the loadNewFacilityPage from FacilityePage
		FundingPage.loadNewFacilityPage();

		// Click on facility tab
		Utils.waitAndClickOnTab(FundingNewFacilityPO.facilityTab, FundingNewFacilityPO.amountInputField, "Facility");

		// Wait for the amount input field is visible and clickable
		System.out.println("SUB-STEP_0.001 : Waiting for the amount input field to be visible and clickable");
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the amount input field to be visible and clickable");
		IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.amountInputField);
		IWaitStrategy.WaitUntilElementClickable(node, driver, FundingNewFacilityPO.amountInputField);
		System.out.println("SUB-STEP_0.002 :  Amount input field is visible and clickable");
		node.log(Status.INFO, "SUB-STEP_0.002 : Amount input field is visible and clickable");

		// Click on the amount input field
		IElementActions.clickelement_usingXpath(node, driver, FundingNewFacilityPO.amountInputField);
		System.out.println("SUB-STEP_0.003 : Clicked on the amount input field");
		node.log(Status.INFO, "SUB-STEP_0.003 : Clicked on the amount input field ");

		// Enter the value in the amount input field
		IElementActions.sendKeys_usingXpath(node, driver, FundingNewFacilityPO.amountInputField, amount);
		System.out.println("SUB-STEP_0.004 : Entered the value in the amount input field.");
		node.log(Status.INFO, "SUB-STEP_0.004 : Entered the value in the amount input field.");
		IElementActions.pressEnter_usingXpath(node, driver, FundingNewFacilityPO.amountInputField);
	}

	public static void addDrawdown(String drawdownAmount, String date) throws InterruptedException {
		// Wait for the visibility of the drawdown
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the new drawdown button");
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the new drawdown button");
		IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.newDrawdownButton);
		System.out.println("SUB-STEP_0.002 : New drawdown button is visible.");
		node.log(Status.INFO, "SUB-STEP_0.002 : New drawdown button is visible.");

		// Click on the new drawdown button
		IElementActions.clickelement_usingXpath(node, driver, FundingNewFacilityPO.newDrawdownButton);
		System.out.println("SUB-STEP_0.003 : Clicked on the new drawdown button.");
		node.log(Status.INFO, "SUB-STEP_0.003 : Clicked on the new drawdown button.");

		// Wait for date field to be visible and clickable
		System.out.println("SUB-STEP_0.004 : Waiting for the date field to be visible and clickable");
		node.log(Status.INFO, "SUB-STEP_0.004 : Waiting for the date field to be visible and clickable");
		IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.drawdownDateInputField);
		System.out.println("SUB-STEP_0.005 : Date field is visible and clickable");
		node.log(Status.INFO, "SUB-STEP_0.005 : Date field is visible and clickable");

		// Click on the drawdown date input field.
		IElementActions.clickelement_usingXpath(node, driver, FundingNewFacilityPO.drawdownDateInputField);
		System.out.println("SUB-STEP_0.006 : Clicked on the drawdown date input field.");
		node.log(Status.INFO, "SUB-STEP_0.006 : Clicked on the drawdown date input field.");

		// Enter today's date
		Utils.enterDay(UtilsPO.calenderDay, date);
		System.out.println("SUB-STEP_0.007 : Entered the value in the drawdown date input field.");
		node.log(Status.INFO, "SUB-STEP_0.007 : Entered the value in the drawdown date input field.");

		// Wait for the drawdown amount field to be visible and clickable
		System.out.println("SUB-STEP_0.008 : Waiting for the drawdown amount field to be visibility and clickable");
		node.log(Status.INFO, "SUB-STEP_0.008 : Waiting for the drawdown amount field to be visibility and clickable");
		IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.drawdownAmountInputField);
		IWaitStrategy.WaitUntilElementClickable(node, driver, FundingNewFacilityPO.drawdownAmountInputField);
		System.out.println("SUB-STEP_0.009 : Drawdown amount field is visible and clickable.");
		node.log(Status.INFO, "SUB-STEP_0.009 : Drawdown amount field is visible and clickable.");

		// Enter amount
		IElementActions.sendKeys_usingXpath(node, driver, FundingNewFacilityPO.drawdownAmountInputField,
				drawdownAmount);
		System.out.println("SUB-STEP_0.0010 : Entered the value in the drawdown amount input field.");
		node.log(Status.INFO, "SUB-STEP_0.0010 : Entered the value in the drawdown amount input field.");

		// Wait for the drawdown save button to be clickable
		System.out.println("SUB-STEP_0.0011 : Waiting for the drawdown save button to be visible and clickable");
		node.log(Status.INFO, "SUB-STEP_0.0011 : Waiting for the drawdown save button to be visible and clickable");
		IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.drawdownSaveButton);
		IWaitStrategy.WaitUntilElementClickable(node, driver, FundingNewFacilityPO.drawdownSaveButton);
		System.out.println("SUB-STEP_0.0012 : Drawdown save button is visible and clickable.");
		node.log(Status.INFO, "SUB-STEP_0.0012 : Drawdown save button is visible and clickable.");

		// Click on the save button
		IElementActions.clickelement_usingXpath(node, driver, FundingNewFacilityPO.drawdownSaveButton);
		System.out.println("SUB-STEP_0.0013 : Clicked on the new drawdown save button.");
		node.log(Status.INFO, "SUB-STEP_0.0013 : Clicked on the new drawdown save button.");
	}

	public static void addRepayment(String repaymentAmount, String date) throws InterruptedException {
		IElementActions.scrollToTop(driver);
		// Wait for the visibility of the new repayment button
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the new repayment button");
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the new repayment button");
		IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.newRepaymentButton);
		System.out.println("SUB-STEP_0.002 : New repayment button is visible.");
		node.log(Status.INFO, "SUB-STEP_0.002 : New repayment button is visible.");

		// Click on the new repayment button
		IElementActions.clickelement_usingXpath(node, driver, FundingNewFacilityPO.newRepaymentButton);
		System.out.println("SUB-STEP_0.003 : Clicked on the new repayment button.");
		node.log(Status.INFO, "SUB-STEP_0.003 : Clicked on the new repayment button.");

		// Wait for date field to be visible and clickable
		System.out.println("SUB-STEP_0.004 : Waiting for the date field to be visible and clickable");
		node.log(Status.INFO, "SUB-STEP_0.004 : Waiting for the date field to be visible and clickable");
		IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.repaymentDateInputField);
		System.out.println("SUB-STEP_0.005 : Date field is visible and clickable");
		node.log(Status.INFO, "SUB-STEP_0.005 : Date field is visible and clickable");

		// Click on the repayment date input field.
		IElementActions.clickelement_usingXpath(node, driver, FundingNewFacilityPO.repaymentDateInputField);
		System.out.println("SUB-STEP_0.006 : Clicked on the repayment date input field.");
		node.log(Status.INFO, "SUB-STEP_0.006 : Clicked on the repayment date input field.");

		// Enter today's date
		Utils.enterDay(UtilsPO.calenderDay, date);
		System.out.println("SUB-STEP_0.007 : Entered the value in the repayment date input field.");
		node.log(Status.INFO, "SUB-STEP_0.007 : Entered the value in the repayment date input field.");

		// Wait for the repayment amount field to be visible and clickable
		System.out.println("SUB-STEP_0.008 : Waiting for the repayment amount field to be visibility and clickable");
		node.log(Status.INFO, "SUB-STEP_0.008 : Waiting for the repayment amount field to be visibility and clickable");
		IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.repaymentAmountInputField);
		IWaitStrategy.WaitUntilElementClickable(node, driver, FundingNewFacilityPO.repaymentAmountInputField);
		System.out.println("SUB-STEP_0.009 : Repayment amount field is visible and clickable.");
		node.log(Status.INFO, "SUB-STEP_0.009 : Repayment amount field is visible and clickable.");

		// Enter amount
		IElementActions.sendKeys_usingXpath(node, driver, FundingNewFacilityPO.repaymentAmountInputField,
				repaymentAmount);
		System.out.println("SUB-STEP_0.0010 : Entered the value in the repayment amount input field.");
		node.log(Status.INFO, "SUB-STEP_0.0010 : Entered the value in the repayment amount input field.");

		// Wait for the repayment save button to be clickable
		System.out.println("SUB-STEP_0.0011 : Waiting for the repayment save button to be visible and clickable");
		node.log(Status.INFO, "SUB-STEP_0.0011 : Waiting for the repayment save button to be visible and clickable");
		IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.repaymentSaveButton);
		IWaitStrategy.WaitUntilElementClickable(node, driver, FundingNewFacilityPO.repaymentSaveButton);
		System.out.println("SUB-STEP_0.0012 : Repayment save button is visible and clickable.");
		node.log(Status.INFO, "SUB-STEP_0.0012 : Repayment save button is visible and clickable.");

		// Click on the save button
		IElementActions.clickelement_usingXpath(node, driver, FundingNewFacilityPO.repaymentSaveButton);
		System.out.println("SUB-STEP_0.0013 : Clicked on the new repayment save button.");
		node.log(Status.INFO, "SUB-STEP_0.0013 : Clicked on the new repayment save button.");
	}

	public static void goToFacilityStatusAndAddDrawdown(String drawdownAmount, String date)
			throws InterruptedException {
		// Click on facility tab
		Utils.waitAndClickOnTab(FundingNewFacilityPO.facilityStatusTab, FundingNewFacilityPO.drawdownsSection,
				"Facility Status");

		// Add drawdown
		addDrawdown(drawdownAmount, date);
	}

	public static void openFacilityFromDatabase() throws InterruptedException, FileNotFoundException, IOException {
		// Call the loadDatabasePage function from the FundingPage
		FundingPage.loadDatabasePage();

		// Get facility reference
		String facilityReferenceNumber = getDataFromExcel(60);

		// Search record based on the provide loan reference and open it
		Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, FundingNewFacilityPO.reference,
				facilityReferenceNumber, UtilsPO.editIcon, FundingNewFacilityPO.editLoanFacilityText);
	}

	public static void openFacilityFromDatabaseAndGoToStatus()
			throws InterruptedException, FileNotFoundException, IOException {
		openFacilityFromDatabase();

		// Click on facility tab
		Utils.waitAndClickOnTab(FundingNewFacilityPO.facilityStatusTab, FundingNewFacilityPO.repaymentSection,
				"Facility Status");
	}

	public static String confirmRepayment(String confirmButton, String effectiveDate) throws InterruptedException {

		IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingNewFacilityPO.repaymentSection);

		// Wait for the visibility of confirm icon
		node.log(Status.INFO, "STEP1 : Waiting for the visibility of confirm icon");
		System.out.println("STEP1 : Waiting for the visibility of confirm icon");
		IWaitStrategy.waitForVisiblity(node, driver, confirmButton);
		IWaitStrategy.WaitUntilElementClickable(node, driver, confirmButton);
		node.log(Status.INFO, "STEP2 : Confirm icon is visible");
		System.out.println("STEP2 : Confirm icon is visible");

		// Click on the confirm button and wait for popup
		Utils.clickAndWait(confirmButton, "Confirm Icon", UtilsPO.popUp);

		if (effectiveDate.equals("today")) {
			// Get effective date
			effectiveDate = IElementActions.getElementValue(node, driver, FundingNewFacilityPO.effectiveDate);
		} else if (effectiveDate.equals("yesterday")) {

			// Get yesterday's date
			String yesterdayDate = Utils.getYesterdayDayFormatted();

			// Click on the effective date
			IElementActions.clickelement_usingXpath(node, driver, FundingNewFacilityPO.effectiveDate);
			node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on the effective date");
			System.out.println("SUB-STEP_0.001 : Clicked on the effective date");

			// Select day in effective date calender
			Utils.enterDay(UtilsPO.calenderDay, yesterdayDate);

			Thread.sleep(1000);
			// Get effective date
			effectiveDate = IElementActions.getElementValue(node, driver, FundingNewFacilityPO.effectiveDate);
		}

		node.log(Status.INFO, "Effective date " + effectiveDate);
		System.out.println("Effective date " + effectiveDate);

		// Click on the confirm button
		IElementActions.clickelement_usingXpath(node, driver, FundingNewFacilityPO.confirmButton);
		node.log(Status.INFO, "STEP3 : Clicked on the confirm button");
		System.out.println("STEP3 : Clicked on the confirm button");

		// Wait for the visibility of the PopUp
		node.log(Status.INFO, "STEP4 : Waiting for the visibility of the popup");
		System.out.println("STEP4 : Waiting for the visibility of the popup");
		IWaitStrategy.waitForVisiblity(node, driver, UtilsPO.popUp);
		node.log(Status.INFO, "STEP5 : Popup is visible");
		System.out.println("STEP5 : Popup is visible");

		// Click on popup close button
		IElementActions.clickelement_usingXpath(node, driver, PipelinePO.closeButtonInPopup);
		node.log(Status.INFO, "STEP6 : Clicked on the close icon");
		System.out.println("STEP6 : Clicked on the close icon");

		// Wait for the invisibility of the PopUp
		node.log(Status.INFO, "STEP7 : Waiting for the invisibility of the popup");
		System.out.println("STEP7 : Waiting for the invisibility of the popup");
		IWaitStrategy.waitForInVisiblity(node, driver, UtilsPO.popUp);
		node.log(Status.INFO, "STEP8 : Popup is not visible");
		System.out.println("STEP8 : Popup is not visible");

		return effectiveDate;
	}

	public static void openPreviewFromFundingManagementAccount() {

		// Call the loadManagementAccountsPage function from the FundingPage
		FundingPage.loadManagementAccountsPage();

		// Wait for the preview button to be visible and clickable
		node.log(Status.INFO, "STEP1 : Waiting for the preview button to be visible and clickable");
		System.out.println("STEP1 : Waiting for the preview button to be visible and clickable");
		IWaitStrategy.waitForVisiblityDynamic(node, driver, FundingManagementAccountsPO.firstRecordPreview, 150);
		IWaitStrategy.WaitUntilElementClickable(node, driver, FundingManagementAccountsPO.firstRecordPreview);
		node.log(Status.INFO, "STEP2 : Preview is visible and clickable");
		System.out.println("STEP2 : Preview is visible and clickable");

		// Click on the preview
		IElementActions.moveToElementAndClick_usingXpath(node, driver, FundingManagementAccountsPO.firstRecordPreview);
		node.log(Status.INFO, "STEP3 : Clicked on the preview button");
		System.out.println("STEP3 : Clicked on the preview button");

		// Wait for the visibility of the page
		node.log(Status.INFO, "STEP4 : Waiting for the visibility of the page");
		System.out.println("STEP4 : Waiting for the visibility of the page");
		IWaitStrategy.waitForVisiblityDynamic(node, driver, ReportingManagementAccountsPO.interestAnalysisText, 150);
		node.log(Status.INFO, "STEP5 : Page is visible");
		System.out.println("STEP5 : Page is visible");

		// Wait for the calculation period
		node.log(Status.INFO, "STEP6 : Waiting for the calculation period to be visible");
		System.out.println("STEP6 : Waiting for the calculation period to be visible");
		IWaitStrategy.waitForElementPresence(node, driver, ReportingManagementAccountsPO.calculationPeriod, 240);
		node.log(Status.INFO, "STEP7 : Calculation period is visible");
		System.out.println("STEP7 : Calculation period is visible");
	}

}
