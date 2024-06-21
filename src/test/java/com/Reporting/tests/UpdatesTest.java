package com.Reporting.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.locators.allPages.ReportingLoansPO;
import com.locators.allPages.ReportingUpdatesPO;
import com.locators.allPages.SideMenuPO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.url.AllPagesUrl;
import com.qa.utils.LoginPage;
import com.qa.utils.ReportingPage;
import com.qa.utils.Utils;

public class UpdatesTest extends Baseclass {

	@Test(priority = 1)
	public void validateReportingUpdatesPageVisibility() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the user can access the 'Updates' menu from the side menu options.")
					.assignCategory(reportingUpdates_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			// Call the userLoginProcess function from the utils login
			LoginPage.userLoginProcess(node, driver, getDataFromExcel(1), getDataFromExcel(2));

			// Click on the reporting
			Utils.clickOnMenu(node, driver, SideMenuPO.reporting);

			// Click on the update
			Utils.clickOnMenu(node, driver, SideMenuPO.update);

			// Wait for the visibility of the error
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the page");
			System.out.println("STEP1 : Waiting for the visibility of the page");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingUpdatesPO.runScriptButton);
			node.log(Status.INFO, "STEP2 : Page is visible");
			System.out.println("STEP2 : Page is visible");

			Thread.sleep(2000);
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			// Assert that Calculate Interest page is visible
			System.out.println("STEP3 : Asserting that Reporting Updates page is visible");
			node.log(Status.INFO, "STEP3 : Asserting that Reporting Updates page is visible");

			Utils.validateUrl(node, driver, currentUrl, AllPagesUrl.ReportingUpdatesPage,
					"validateReportingUpdatesPageVisibility");

		} catch (AssertionError validateReportingUpdatesPageVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateReportingUpdatesPageVisibility test in UpdatesTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateReportingUpdatesPageVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateReportingUpdatesPageVisibility.printStackTrace();
			node.fail(validateReportingUpdatesPageVisibility);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateReportingUpdatesPageVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateReportingUpdatesPageVisibility test in UpdatesTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateReportingUpdatesPageVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateReportingUpdatesPageVisibility.printStackTrace();
			node.fail(validateReportingUpdatesPageVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	@Test(priority = 2)
	public void validateReportingUpdatesPageSections() throws IOException {
		try {
			extenttest = extent.createTest("Verify if the user is able to view the Update Page ")
					.assignCategory(reportingUpdates_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingUpdatesPage();

			// Verify the section in Calculate Interest page
			node.log(Status.INFO, "STEP1 : Verify the section");
			System.out.println("STEP1 : Verify the section");

			IElementActions.assertTrue_usingXpath(node, driver, ReportingUpdatesPO.runScriptButton,
					"STEP2 : BUG: Run script button is not coming on Updates page",
					"STEP2 : EXPECTED: Run script button is coming on Updates page");
			IElementActions.assertTrue_usingXpath(node, driver, ReportingUpdatesPO.launchDate,
					"STEP3: BUG: Launch Date is not coming on Updates page",
					"STEP3 : EXPECTED:  Launch Date is coming on Updates page");
			IElementActions.assertTrue_usingXpath(node, driver, ReportingUpdatesPO.scheduled,
					"STEP4 : BUG: Scheduled is not coming on Updates page",
					"STEP4 : EXPECTED: Scheduled is coming on Updates page");
			IElementActions.assertTrue_usingXpath(node, driver, ReportingUpdatesPO.status,
					"STEP5 : BUG: Status is not coming on Updates page",
					"STEP5 : EXPECTED: Status is coming on Updates page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateReportingUpdatesPageSections", "Pass", driver);

		} catch (AssertionError validateReportingUpdatesPageSections) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateReportingUpdatesPageSections test in UpdatesTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateReportingUpdatesPageSections_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateReportingUpdatesPageSections.printStackTrace();
			node.fail(validateReportingUpdatesPageSections);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateReportingUpdatesPageSections) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateReportingUpdatesPageSections test in UpdatesTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateReportingUpdatesPageSections_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateReportingUpdatesPageSections.printStackTrace();
			node.fail(validateReportingUpdatesPageSections);
			Assert.fail();
			extent.flush();
		}
	}

	@Test(priority = 3)
	public void validateAutomatedDailyBatchRun() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system automatically calculates a batch run each night, updating the Reporting module with the previous day's activity.")
					.assignCategory(reportingUpdates_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingUpdatesPage();

			Thread.sleep(10000);

			String todayDate = Utils.getTodayDateFormatted();

			String dailyBatchRunAutomatedDate = IElementActions
					.createDynamicLocatorString(ReportingUpdatesPO.dailyBatchRunDate, "locatorValue", todayDate);

			IElementActions.assertTrue_usingXpath(node, driver, dailyBatchRunAutomatedDate,
					"STEP1 : BUG: Daily automated batch run is not coming on Updates page",
					"STEP1 : EXPECTED: Daily automated batch run is coming on Updates page");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateAutomatedDailyBatchRun", "Pass", driver);

		} catch (AssertionError validateAutomatedDailyBatchRun) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAutomatedDailyBatchRun test in UpdatesTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAutomatedDailyBatchRun_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAutomatedDailyBatchRun.printStackTrace();
			node.fail(validateAutomatedDailyBatchRun);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateAutomatedDailyBatchRun) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAutomatedDailyBatchRun test in UpdatesTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAutomatedDailyBatchRun_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAutomatedDailyBatchRun.printStackTrace();
			node.fail(validateAutomatedDailyBatchRun);
			Assert.fail();
			extent.flush();
		}
	}

	@Test(priority = 4)
	public void validateFirstDateinSingleSelectDateDropdown() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that when a user runs a script the respective script date and time are present in the Reporting>> Loans date Dropdown.")
					.assignCategory(reportingUpdates_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingUpdatesPage();

			Thread.sleep(10000);
			// Get first Done Success Launch Date
			node.log(Status.INFO, "STEP1 : Get the first Done Success Launch Date");
			System.out.println("STEP1 : Get the first Done Success Launch Date");
			String firstDoneSuccessLaunchDate = IElementActions
					.getElementText_usingXpath(node, driver, ReportingUpdatesPO.firstDoneSuccessLaunchDate)
					.substring(0, 10);

			// Click on the reporting
			Utils.clickOnMenu(node, driver, SideMenuPO.reportingLoans);

			// Wait for the visibility of the Page
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the page");
			System.out.println("STEP2 : Waiting for the visibility of the page");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.loansSingleSelectDateDropdown);
			node.log(Status.INFO, "STEP3 : Page is visible");
			System.out.println("STEP3 : Page is visible");

			// Click on the loans Single Select Date Dropdown
			IElementActions.clickelement_usingXpath(node, driver, ReportingLoansPO.loansSingleSelectDateDropdown);
			node.log(Status.INFO, "STEP4: Clicked on loans single select date dropdown");
			System.out.println("STEP4 : Clicked on loans single select date dropdown");

			// Get the first Option from loans single select date dropdown
			node.log(Status.INFO, "STEP5 : Get the first Option from loans single select date dropdown");
			System.out.println("STEP5 : Get the first Option from loans single select date dropdown");
			String firstDateInDropdown = IElementActions
					.getElementText_usingXpath(node, driver, ReportingLoansPO.singleSelectDatefirstOption)
					.substring(0, 10);

			// Convert the dd-MM-yyyy date format to dd/MM/yyyy
			String firstDateOption = firstDateInDropdown.replace("-", "/");

			IElementActions.assertEquals_usingString(node, driver, firstDoneSuccessLaunchDate, firstDateOption,
					"BUG: First date in loans single dropdown is not same as first Done_Success Launch Date",
					"PASS: First date in loans single dropdown is same as first Done_Success Launch Date");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateFirstDateinSingleSelectDateDropdown", "Pass", driver);

		} catch (AssertionError validateFirstDateinSingleSelectDateDropdown) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFirstDateinSingleSelectDateDropdown test in UpdatesTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFirstDateinSingleSelectDateDropdown_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFirstDateinSingleSelectDateDropdown.printStackTrace();
			node.fail(validateFirstDateinSingleSelectDateDropdown);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateFirstDateinSingleSelectDateDropdown) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFirstDateinSingleSelectDateDropdown test in UpdatesTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFirstDateinSingleSelectDateDropdown_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFirstDateinSingleSelectDateDropdown.printStackTrace();
			node.fail(validateFirstDateinSingleSelectDateDropdown);
			Assert.fail();
			extent.flush();
		}
	}

	@Test(priority = 5)
	public void validate25RecordsInPagination() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that when the user selects '25' from the pagination dropdown, the table correctly displays 25 records.")
					.assignCategory(reportingUpdates_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingUpdatesPage();

			IElementActions.pageRefresh();

			Thread.sleep(10000);

			// Pagination 25
			Utils.validatePagination(node, driver, 25, "validate25RecordsInPagination");

		} catch (AssertionError validate25RecordsInPagination) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validate25RecordsInPagination test in UpdatesTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validate25RecordsInPagination_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validate25RecordsInPagination.printStackTrace();
			node.fail(validate25RecordsInPagination);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validate25RecordsInPagination) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validate25RecordsInPagination test in UpdatesTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validate25RecordsInPagination_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validate25RecordsInPagination.printStackTrace();
			node.fail(validate25RecordsInPagination);
			Assert.fail();
			extent.flush();
		}
	}

	@Test(priority = 6)
	public void validate50RecordsInPagination() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that when the user selects '50' from the pagination dropdown, the table correctly displays 50 records.")
					.assignCategory(reportingUpdates_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Call the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingUpdatesPage();

			// Pagination 50
			Utils.validatePagination(node, driver, 50, "validate50RecordsInPagination");

		} catch (AssertionError validate50RecordsInPagination) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validate50RecordsInPagination test in UpdatesTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validate50RecordsInPagination_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validate50RecordsInPagination.printStackTrace();
			node.fail(validate50RecordsInPagination);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validate50RecordsInPagination) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validate50RecordsInPagination test in UpdatesTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validate50RecordsInPagination_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validate50RecordsInPagination.printStackTrace();
			node.fail(validate50RecordsInPagination);
			Assert.fail();
			extent.flush();
		}
	}

	@Test(priority = 7)
	public void validate75RecordsInPagination() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that when the user selects '75' from the pagination dropdown, the table correctly displays 75 records.")
					.assignCategory(reportingUpdates_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Call the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingUpdatesPage();

			// Pagination 75
			Utils.validatePagination(node, driver, 75, "validate75RecordsInPagination");

		} catch (AssertionError validate75RecordsInPagination) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validate75RecordsInPagination test in UpdatesTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validate75RecordsInPagination_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validate75RecordsInPagination.printStackTrace();
			node.fail(validate75RecordsInPagination);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validate75RecordsInPagination) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validate75RecordsInPagination test in UpdatesTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validate75RecordsInPagination_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validate75RecordsInPagination.printStackTrace();
			node.fail(validate75RecordsInPagination);
			Assert.fail();
			extent.flush();
		}
	}

	@Test(priority = 8)
	public void validateSpecificPageSelection() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that selecting a specific page number from the pagination control correctly displays the chosen page.")
					.assignCategory(reportingUpdates_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Call the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingUpdatesPage();

			// Get the launch date
			String firstRecordDateInFirstPage = ReportingPage.getLaunchDate(node, driver,
					ReportingUpdatesPO.firstRecordLaunchDate);

			// Thread.sleep(2000);
			IElementActions.scrollToBottom(driver);
			node.log(Status.INFO, "STEP1 : Scrolled down to the bottom of the page");
			System.out.println("STEP1 : Scrolled down to the bottom of the page");

			// Get specific page number selector dynamically
			String specificPageNumber = IElementActions.createDynamicLocatorString(ReportingUpdatesPO.speacificPage,
					"locatorValue", "3");

			// Get the current page number
			String currentPageBeforeClickingNext = ReportingPage.getCurrentPageNumber(node, driver,
					ReportingUpdatesPO.currentPage);

			// Click on the specific page
			IElementActions.clickelement_usingXpath(node, driver, specificPageNumber);
			node.log(Status.INFO, "STEP2 : Clicked on the specific page");
			System.out.println("STEP2 : Clicked on the specific page");

			// Get the launch date
			String firstRecordDateInSelectedPage = ReportingPage.getLaunchDate(node, driver,
					ReportingUpdatesPO.firstRecordLaunchDate);

			// Get the current page number
			String currentPageAfterClickingNext = ReportingPage.getCurrentPageNumber(node, driver,
					ReportingUpdatesPO.currentPage);

			IElementActions.assertEqualsFalse_usingString(node, driver, currentPageAfterClickingNext,
					currentPageBeforeClickingNext, "STEP3 : BUG: Next page number is same",
					"STEP3 : EXPECTED: Next page number is different");

			IElementActions.assertEqualsFalse_usingString(node, driver, firstRecordDateInSelectedPage,
					firstRecordDateInFirstPage, "STEP4 : BUG: Selected page is not displayed",
					"STEP4 : EXPECTED: Selected page is displayed");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateSpecificPageSelection", "Pass", driver);

		} catch (AssertionError validateSpecificPageSelection) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateSpecificPageSelection test in UpdatesTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateSpecificPageSelection_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSpecificPageSelection.printStackTrace();
			node.fail(validateSpecificPageSelection);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateSpecificPageSelection) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateSpecificPageSelection test in UpdatesTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateSpecificPageSelection_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSpecificPageSelection.printStackTrace();
			node.fail(validateSpecificPageSelection);
			Assert.fail();
			extent.flush();
		}
	}

	@Test(priority = 9)
	public void validateForwardNavigation() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that clicking on the forward navigation icon correctly navigates the user to the next page ")
					.assignCategory(reportingUpdates_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Call the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingUpdatesPage();

			// Get the launch date
			String firstRecordDateInFirstPage = ReportingPage.getLaunchDate(node, driver,
					ReportingUpdatesPO.firstRecordLaunchDate);

			// Get the current page number
			String currentPageBeforeClickingNext = ReportingPage.getCurrentPageNumber(node, driver,
					ReportingUpdatesPO.currentPage);

			// Click on the specific page
			IElementActions.clickelement_usingXpath(node, driver, ReportingUpdatesPO.nextButton);
			node.log(Status.INFO, "STEP1 : Clicked on the next button");
			System.out.println("STEP1 : Clicked on the next button");

			// Get the launch date
			String firstRecordDateInNextPage = ReportingPage.getLaunchDate(node, driver,
					ReportingUpdatesPO.firstRecordLaunchDate);

			// Thread.sleep(2000);

			// Get the current page number
			String currentPageAfterClickingNext = ReportingPage.getCurrentPageNumber(node, driver,
					ReportingUpdatesPO.currentPage);

			IElementActions.assertEqualsFalse_usingString(node, driver, currentPageAfterClickingNext,
					currentPageBeforeClickingNext, "STEP2 : BUG: Next page number is same",
					"STEP2 : EXPECTED: Next page number is different");

			IElementActions.assertEqualsFalse_usingString(node, driver, firstRecordDateInNextPage,
					firstRecordDateInFirstPage, "STEP3 : BUG: Next page is not displayed",
					"STEP3 : EXPECTED: Next page is displayed");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateForwardNavigation", "Pass", driver);

		} catch (AssertionError validateForwardNavigation) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateForwardNavigation test in UpdatesTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateForwardNavigation_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateForwardNavigation.printStackTrace();
			node.fail(validateForwardNavigation);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateForwardNavigation) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateForwardNavigation test in UpdatesTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateForwardNavigation_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateForwardNavigation.printStackTrace();
			node.fail(validateForwardNavigation);
			Assert.fail();
			extent.flush();
		}
	}

	@Test(priority = 10)
	public void validateBackwardNavigation() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that clicking on the backward navigation icon correctly navigates the user to the previous page")
					.assignCategory(reportingUpdates_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get the launch date
			String firstRecordDateInCurrentPage = ReportingPage.getLaunchDate(node, driver,
					ReportingUpdatesPO.firstRecordLaunchDate);

			// Get the current page number
			String currentPageBeforeClickingPrev = ReportingPage.getCurrentPageNumber(node, driver,
					ReportingUpdatesPO.currentPage);

			// Click on the specific page
			IElementActions.clickelement_usingXpath(node, driver, ReportingUpdatesPO.previousButton);
			node.log(Status.INFO, "STEP1 : Clicked on the previous button");
			System.out.println("STEP1 : Clicked on the previous button");

			// Get the launch date
			String firstRecordDateInPreviousPage = ReportingPage.getLaunchDate(node, driver,
					ReportingUpdatesPO.firstRecordLaunchDate);

			// Thread.sleep(2000);

			// Get the current page number
			String currentPageAfterClickingPrevious = ReportingPage.getCurrentPageNumber(node, driver,
					ReportingUpdatesPO.currentPage);

			IElementActions.assertEqualsFalse_usingString(node, driver, currentPageAfterClickingPrevious,
					currentPageBeforeClickingPrev, "STEP2 : BUG: Next page number is same",
					"STEP2 : EXPECTED: Next page number is different");

			IElementActions.assertEqualsFalse_usingString(node, driver, firstRecordDateInPreviousPage,
					firstRecordDateInCurrentPage, "STEP3 : BUG: Next page is not displayed",
					"STEP3 : EXPECTED: Next page is displayed");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateBackwardNavigation", "Pass", driver);

		} catch (AssertionError validateBackwardNavigation) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateBackwardNavigation test in UpdatesTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateBackwardNavigation_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBackwardNavigation.printStackTrace();
			node.fail(validateBackwardNavigation);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateBackwardNavigation) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateBackwardNavigation test in UpdatesTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateBackwardNavigation_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBackwardNavigation.printStackTrace();
			node.fail(validateBackwardNavigation);
			Assert.fail();
			extent.flush();
		}
	}

}
