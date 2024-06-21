package com.qa.utils;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.locators.allPages.ReportingBalanceSheetPO;
import com.locators.allPages.ReportingLoansPO;
import com.locators.allPages.ReportingManagementAccountsPO;
import com.locators.allPages.ReportingUpdatesPO;
import com.locators.allPages.UtilsPO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.url.AllPagesUrl;

public class ReportingPage extends Baseclass {

	/**
	 * The "loadReportingUpdatesPage" function is used to load the update page under
	 * reporting
	 *
	 * @author Daffodil Software Private Limited
	 * @version 1.0
	 * @since 20.12.2023
	 */
	public static void loadReportingUpdatesPage() {
		// Open the Reporting Updates
		node.log(Status.INFO, "SUB-STEP_0.001 : Opening the Reporting Updates page under Reporting");
		System.out.println("SUB-STEP_0.001 :  Opening the Reporting Updates page under Reporting");
		driver.get(AllPagesUrl.ReportingUpdatesPage);
		// Wait for the visibility of Calculate Interest page
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of Reporting Updates page");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of Reporting Updates page");
		IWaitStrategy.waitForVisiblity(node, driver, ReportingUpdatesPO.runScriptButton);
		IWaitStrategy.WaitUntilElementClickable(node, driver, ReportingUpdatesPO.runScriptButton);
		node.log(Status.INFO, "SUB-STEP_0.003 : Reporting Updates page is visible");
		System.out.println("SUB-STEP_0.003 : Reporting Updates page is visible");
	}

	public static void loadReportingManagementAccountsPage() {
		// Open the management accounts page
		node.log(Status.INFO, "SUB-STEP_0.001 : Opening the Management Accounts page under reporting");
		System.out.println("SUB-STEP_0.001 : Opening the Management Accounts page under reporting");
		driver.get(AllPagesUrl.reportingManagementAccounts);
		// Wait for the visibility of management accounts page
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of the page");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of the page");
		IWaitStrategy.waitForVisiblityDynamic(node, driver, ReportingManagementAccountsPO.interestAnalysisText, 150);
		node.log(Status.INFO, "SUB-STEP_0.003 : Page is visible");
		System.out.println("SUB-STEP_0.003 : Page is visible");
	}

	/**
	 * The "loadReportingLoansPage" function is used to load the loans page under
	 * reporting
	 *
	 * @author Daffodil Software Private Limited
	 * @version 1.0
	 * @since 20.12.2023
	 */
	public static void loadReportingLoansPage() {
		// Open the Reporting Updates
		node.log(Status.INFO, "SUB-STEP_0.001 : Opening the Reporting Loans page under Reporting");
		System.out.println("SUB-STEP_0.001 :  Opening the Reporting Loans page under Reporting");
		driver.get(AllPagesUrl.ReportingLoansPage);

		// Waiting for the Page Loading To complete
		IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

		// Wait for the visibility of Calculate Interest page
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of Reporting Loans page");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of Reporting Loans page");
		IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.loansHeaderText);
		IWaitStrategy.WaitUntilElementClickable(node, driver, ReportingLoansPO.loansHeaderText);
		node.log(Status.INFO, "SUB-STEP_0.003 : Reporting Loans page is visible");
		System.out.println("SUB-STEP_0.003 : Reporting Loans page is visible");
	}

	public static String getLaunchDate(ExtentTest node, WebDriver driver, String launchDateLocator) {
		// Wait for the visibility of the row
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the first record");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the first record");
		IWaitStrategy.waitForVisiblity(node, driver, launchDateLocator);
		IWaitStrategy.waitForVisiblityAndPresence(node, driver, launchDateLocator);
		node.log(Status.INFO, "SUB-STEP_0.002 : First record on the page is visible");
		System.out.println("SUB-STEP_0.002 : First record on the page is visible");
		String launchDate = IElementActions.getElementText_usingXpath(node, driver, launchDateLocator);
		node.log(Status.INFO, "SUB-STEP_0.003 : First record date on the page is " + launchDate);
		System.out.println("SUB-STEP_0.003 : First record date on the page is " + launchDate);
		return launchDate;
	}

	public static String getCurrentPageNumber(ExtentTest node, WebDriver driver, String currentPageNumberLocator) {
		IElementActions.scrollToBottom(driver);
		node.log(Status.INFO, "SUB-STEP_0.001 : Scrolled down to the bottom of the page");
		System.out.println("SUB-STEP_0.001 : Scrolled down to the bottom of the page");
		// Wait for the visibility of the specific page
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of the next page first record");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of the next page first record");
		IWaitStrategy.waitForVisiblity(node, driver, currentPageNumberLocator);
		IWaitStrategy.waitForVisiblityAndPresence(node, driver, currentPageNumberLocator);
		node.log(Status.INFO, "SUB-STEP_0.003: First record on the next page is visible");
		System.out.println("SUB-STEP_0.003 : First record on the next page is visible");
		String currentPageNumber = IElementActions.getElementText_usingXpath(node, driver, currentPageNumberLocator);
		node.log(Status.INFO, "SUB-STEP_0.004 : Current page is " + currentPageNumber);
		System.out.println("SUB-STEP_0.004 : Current page is " + currentPageNumber);
		return currentPageNumber;
	}

	/**
	 * The "loadReportingBalanceSheetPage" function is used to load the Balance
	 * sheet page under Reporting
	 *
	 * @author Daffodil Software Private Limited
	 * @version 1.0
	 * @since 20.12.2023
	 */
	public static void loadReportingBalanceSheetPage() {
		// Open the Reporting Balance Sheet Page
		node.log(Status.INFO, "SUB-STEP_0.001 : Opening the Reporting Balance Sheet page under Reporting");
		System.out.println("SUB-STEP_0.001 :  Opening the Reporting Balance Sheet page under Reporting");
		driver.get(AllPagesUrl.ReportingBalanceSheetPage);
		IWaitStrategy.WaitForPageLoadingToComplete(node, driver);
		// Wait for the visibility of Balance Sheet Page
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of Reporting Balance Sheet page");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of Reporting Balance Sheet page");
		IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.loanAmountValue);
		IWaitStrategy.WaitUntilElementClickable(node, driver, ReportingBalanceSheetPO.balanceSheetDetail);
		node.log(Status.INFO, "SUB-STEP_0.003 : Reporting Balance Sheet page is visible");
		System.out.println("SUB-STEP_0.003 : Reporting Balance Sheet page is visible");
	}

	public static void enterDateInCustomFieldAndSearch() {
		// Clicked on Search By Month Input Field
		IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.searchByMonthInputField);
		node.log(Status.INFO, "STEP1 : The Clicked on Search By Month input field");
		System.out.println("STEP1 : The Clicked on Search By Month input field");

		// Wait for the visibility of the calendar
		node.log(Status.INFO, "STEP2 : Waiting for the visibility of the months in calendar");
		System.out.println("STEP2 : Waiting for the visibility of the months in calendar");
		IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.allMonthsCalendar);
		node.log(Status.INFO, "STEP3 : Months in calendar is now visible");
		System.out.println("STEP3 : Months in calendar is now visible");

		String year = Utils.getCurrectYear();
		String month = Utils.getCurrentMonth();
		String day = Utils.getTodayDayFormatted();

		// Calling enterDate from Utils to select Date From Calendar
		Utils.enterDate(ReportingBalanceSheetPO.customSearchInputField, UtilsPO.calenderMonth, month,
				UtilsPO.calenderYear, year, UtilsPO.calenderDay, day);

		// Clicked on search button
		IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.customSearchButton);
		node.log(Status.INFO, "STEP4 : Clicked on search button");
		System.out.println("STEP4 : Clicked on search button");

		// Wait for the calendar to be visible and clickable
		node.log(Status.INFO, "STEP5 : Waiting for the visibility of elements");
		System.out.println("STEP5 : Waiting for the visibility of elements");
		IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.searchByMonthInputField);
		IWaitStrategy.WaitUntilElementClickable(node, driver, ReportingBalanceSheetPO.searchByMonthInputField);
		IWaitStrategy.waitForInvisiblity(node, driver, ReportingBalanceSheetPO.loadingAfterSearch, 100);
		node.log(Status.INFO, "STEP6 : Elements is now visible");
		System.out.println("STEP6 : Elements is now visible");
	}

	public static String getElementValue(String element, String reference) throws InterruptedException {
		// Enter current date in custom search
		ReportingPage.enterDateInCustomFieldAndSearch();

		Thread.sleep(2000);
		// Create the dynamic locator for loan reference
		String loanReferenceLocator = IElementActions.createDynamicLocatorString(element, "locatorValue", reference);

		// Scroll to the element vertically
		IElementActions.scrollbyJSExecutorUsingElementPath(driver, loanReferenceLocator);
		node.log(Status.INFO, "STEP3 : Scrolled to the element vertically");
		System.out.println("STEP3 : Scrolled to the element vertically");

		// Wait for the visibility of loan amount
		node.log(Status.INFO, "STEP4 : Waiting for the visibility of loan amount");
		System.out.println("STEP4 : Waiting for the visibility of loan amount");
		IWaitStrategy.waitForVisiblity(node, driver, loanReferenceLocator);
		node.log(Status.INFO, "STEP5 : The loan amount is visible");
		System.out.println("STEP5 : The loan amount is visible");

		String value = IElementActions.getElementText_usingXpath(node, driver, loanReferenceLocator);
		return value;
	}

	public static void scrollAndClickToCheckSort(String sortIcon, String elementName, String valuesLocator,
			String order, String testcaseName, String clickType) throws InterruptedException {

		// Calling the spinner from Utils
		Utils.spinner(ReportingBalanceSheetPO.spinner);

		// Scroll to the element
		IElementActions.scrollbyJSExecutorUsingElementPath(driver, sortIcon);
		IElementActions.scrollHorizontally(driver, sortIcon, -10);
		node.log(Status.INFO, "STEP1 : Scrolled to the element");
		System.out.println("STEP1 : Scrolled to the element");

		// Wait for the sort icon to be visible and clickable
		node.log(Status.INFO, "STEP2 : Waiting for the sort icon to be visible and clickable");
		System.out.println("STEP2 : Waiting for the sort icon to be visible and clickable");
		IWaitStrategy.waitForVisiblityDynamic(node, driver, sortIcon, 150);
		IWaitStrategy.WaitUntilElementClickable(node, driver, sortIcon);
		node.log(Status.INFO, "STEP3 : Sort icon is visible and clickable");
		System.out.println("STEP3 : Sort icon is visible and clickable");

		// Extract elements and store them in a list
		List<String> originalData = Utils.extractTextFromElements(valuesLocator);

		for (String element : originalData) {
			System.out.println(element);
		}

		// Switch statement for single and double clicks
		switch (clickType) {
		case "singleClick":
			Thread.sleep(2000);
			// Click first time on the element
			IElementActions.clickelement_usingXpath(node, driver, sortIcon);
			node.log(Status.INFO, "STEP4 : Clicked first time on the " + elementName);
			System.out.println("STEP4 : Clicked first time on the " + elementName);
			break;
		case "doubleClick":
			Thread.sleep(2000);
			// Click twice
			Utils.clickTwice(sortIcon, elementName);
			break;
		}

		// Wait for the sort icon to be visible and clickable
		node.log(Status.INFO, "STEP5 : Waiting for the sort icon to be visible and clickable");
		System.out.println("STEP5 : Waiting for the sort icon to be visible and clickable");
		IWaitStrategy.waitForVisiblity(node, driver, sortIcon);
		IWaitStrategy.waitForVisiblity(node, driver, sortIcon);
		IWaitStrategy.WaitUntilElementClickable(node, driver, sortIcon);
		node.log(Status.INFO, "STEP6 : Sort icon is visible and clickable");
		System.out.println("STEP6 : Sort icon is visible and clickable");

		// Check the descending order for the element column
		Utils.validateDataSorting(node, driver, valuesLocator, order, testcaseName);
	}

	public static void scrollAndClickToSort(String sortIcon, String elementName, String clickType)
			throws InterruptedException {

		// Calling the spinner from Utils
		Utils.spinner(ReportingBalanceSheetPO.spinner);

		// Scroll to the element
		IElementActions.scrollbyJSExecutorUsingElementPath(driver, sortIcon);
		node.log(Status.INFO, "STEP1 : Scrolled to the element");
		System.out.println("STEP1 : Scrolled to the element");

		// Wait for the sort icon to be visible and clickable
		node.log(Status.INFO, "STEP2 : Waiting for the sort icon to be visible and clickable");
		System.out.println("STEP2 : Waiting for the sort icon to be visible and clickable");
		IWaitStrategy.waitForVisiblity(node, driver, sortIcon);
		IWaitStrategy.WaitUntilElementClickable(node, driver, sortIcon);
		node.log(Status.INFO, "STEP3 : Sort icon is visible and clickable");
		System.out.println("STEP3 : Sort icon is visible and clickable");

		// Switch statement for single and double clicks
		switch (clickType) {
		case "singleClick":
			Thread.sleep(2000);
			// Click first time on the element
			IElementActions.clickelement_usingXpath(node, driver, sortIcon);
			node.log(Status.INFO, "STEP4 : Clicked first time on the " + elementName);
			System.out.println("STEP4 : Clicked first time on the " + elementName);
			break;
		case "doubleClick":
			Thread.sleep(2000);
			// Click twice
			Utils.clickTwice(sortIcon, elementName);
			break;
		}

		// Wait for the sort icon to be visible and clickable
		node.log(Status.INFO, "STEP5 : Waiting for the sort icon to be visible and clickable");
		System.out.println("STEP5 : Waiting for the sort icon to be visible and clickable");
		IWaitStrategy.waitForVisiblity(node, driver, sortIcon);
		IWaitStrategy.waitForVisiblity(node, driver, sortIcon);
		IWaitStrategy.WaitUntilElementClickable(node, driver, sortIcon);
		node.log(Status.INFO, "STEP6 : Sort icon is visible and clickable");
		System.out.println("STEP6 : Sort icon is visible and clickable");
	}

}
