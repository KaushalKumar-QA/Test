package com.Reporting.tests;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.locators.allPages.FundingDatabasePO;
import com.locators.allPages.FundingNewFacilityPO;
import com.locators.allPages.LoansDatabasePO;
import com.locators.allPages.LoansNewLoanPO;
import com.locators.allPages.ReportingLoansPO;
import com.locators.allPages.ReportingUpdatesPO;
import com.locators.allPages.SideMenuPO;
import com.locators.allPages.TreasuryPortfolioPO;
import com.locators.allPages.UtilsPO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.url.AllPagesUrl;
import com.qa.utils.FundingPage;
import com.qa.utils.LoansPage;
import com.qa.utils.LoginPage;
import com.qa.utils.ReportingPage;
import com.qa.utils.TreasuryPage;
import com.qa.utils.Utils;

public class LoansTest extends Baseclass {

	@Test(priority = 1)
	public void validateReportingLoansPageVisibility() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the user can access the 'Loans' menu from the side menu options.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			// Call the userLoginProcess function from the utils login
			LoginPage.userLoginProcess(node, driver, getDataFromExcel(1), getDataFromExcel(2));

			// Click on the reporting
			Utils.clickOnMenu(node, driver, SideMenuPO.reporting);

			// Click on the loans
			Utils.clickOnMenu(node, driver, SideMenuPO.Loans);

			// Wait for the visibility of the error
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the page");
			System.out.println("STEP1 : Waiting for the visibility of the page");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.loansHeaderText);
			node.log(Status.INFO, "STEP2 : Page is visible");
			System.out.println("STEP2 : Page is visible");

			Thread.sleep(2000);
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			// Assert that Calculate Interest page is visible
			System.out.println("STEP3 : Asserting that Reporting Loans page is visible");
			node.log(Status.INFO, "STEP3 : Asserting that Reporting Loans page is visible");

			Utils.validateUrl(node, driver, currentUrl, AllPagesUrl.ReportingLoansPage,
					"validateReportingLoansPageVisibility");

		} catch (AssertionError validateReportingLoansPageVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateReportingLoansPageVisibility test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateReportingLoansPageVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateReportingLoansPageVisibility.printStackTrace();
			node.fail(validateReportingLoansPageVisibility);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateReportingLoansPageVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateReportingLoansPageVisibility test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateReportingLoansPageVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateReportingLoansPageVisibility.printStackTrace();
			node.fail(validateReportingLoansPageVisibility);
			Assert.fail();
			extent.flush();
		}

	}

	@Test(priority = 2)
	public void validateReportingLoansPageSections() throws IOException {
		try {
			extenttest = extent.createTest("Verify the Facility Reporting submodule")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Verify the section in Calculate Interest page
			node.log(Status.INFO, "STEP1 : Verify the section");
			System.out.println("STEP1 : Verify the section");

			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.loansHeaderText,
					"STEP2 : BUG: Loans header text is not coming on Loans page",
					"STEP2 : EXPECTED: Loans header text is coming on Loans page");
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.summaryTab,
					"STEP3: BUG: Summary is not coming on Loans page",
					"STEP3 : EXPECTED: Summary is coming on Loans page");
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.loanPortfolioTab,
					"STEP4: BUG: Loan Portfolio is not coming on Loans page",
					"STEP4 : EXPECTED: Loan Portfolio is coming on Loans page");
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.interest,
					"STEP5: BUG: Interest is not coming on Loans page",
					"STEP5 : EXPECTED: Interest is coming on Loans page");
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.credit,
					"STEP6: BUG: Credit is not coming on Loans page",
					"STEP6 : EXPECTED: Credit is coming on Loans page");
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.repayment,
					"STEP7: BUG: Repayment is not coming on Loans page",
					"STEP7 : EXPECTED: Repayment is coming on Loans page");
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.risk,
					"STEP8: BUG: Risk is not coming on Loans page", "STEP8 : EXPECTED: Risk is coming on Loans page");
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.lendingCriteria,
					"STEP9: BUG: Lending Criteria is not coming on Loans page",
					"STEP9 : EXPECTED: Lending Criteria is coming on Loans page");
			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateReportingLoansPageSections", "Pass", driver);

		} catch (AssertionError validateReportingLoansPageSections) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateReportingLoansPageSections test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateReportingLoansPageSections_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateReportingLoansPageSections.printStackTrace();
			node.fail(validateReportingLoansPageSections);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateReportingLoansPageSections) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateReportingLoansPageSections test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateReportingLoansPageSections_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateReportingLoansPageSections.printStackTrace();
			node.fail(validateReportingLoansPageSections);
			Assert.fail();
			extent.flush();
		}

	}

	@Test(priority = 3)
	public void validateFacilityFilterInitialState() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify initial state of the Filter field it will display default selection is All in the filter field dropdown.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the facility filter to be visible
			node.log(Status.INFO, "STEP1 : Waiting for the facility filter to be visible");
			System.out.println("STEP1 : Waiting for the facility filter to be visible");
			IWaitStrategy.waitForVisiblityDynamic(node, driver, ReportingLoansPO.facilityFilter, 180);
			node.log(Status.INFO, "STEP2 : Facility filter is visible");
			System.out.println("STEP2 : Facility filter is visible");

			String firstValue = IElementActions.getElementValue(node, driver, ReportingLoansPO.facilityFilter);

			IElementActions.assertEquals_usingString(node, driver, firstValue, "ALL",
					"BUG: Default selection is not 'All' in the facility filter field dropdown.",
					"PASS: Default selection is 'All' in the facility filter field dropdown.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityFilterInitialState", "Pass", driver);

		} catch (AssertionError validateFacilityFilterInitialState) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityFilterInitialState test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityFilterInitialState_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityFilterInitialState.printStackTrace();
			node.fail(validateFacilityFilterInitialState);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateFacilityFilterInitialState) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityFilterInitialState test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityFilterInitialState_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityFilterInitialState.printStackTrace();
			node.fail(validateFacilityFilterInitialState);
			Assert.fail();
			extent.flush();
		}

	}

	// TC_Reporting_Loans_004
	@Test(priority = 4)
	public void validateFacilityFilter() throws IOException {
		try {
			extenttest = extent.createTest("Verify that users can select a specific facility using the filter.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Get facility reference
			String facilityReference = getDataFromExcel(70);

			// Deviation
			double deviatedValue = Double.parseDouble(getDataFromExcel(12));

			// Create Dynamic Facility Reference Locator
			String facilityReferenceLocator = IElementActions
					.createDynamicLocatorString(ReportingLoansPO.facilityOptions, "locatorValue", facilityReference);

			// Wait for the visibility of the facility reference dropdown
			node.log(Status.INFO,
					"STEP1 : Waiting for the visibility of the facility reference dropdown to be clickable and visible");
			System.out.println(
					"STEP1 : Waiting for the visibility of the facility reference dropdown to be clickable and visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.facilityFilterBox);
			IWaitStrategy.WaitUntilElementClickable(node, driver, ReportingLoansPO.facilityFilterBox);
			node.log(Status.INFO, "STEP2 : Facility reference dropdown is clickable and visible");
			System.out.println("STEP2 : Facility reference dropdown is clickable and visible");

			// Click on the facility reference dropdown
			IElementActions.clickelement_usingXpath(node, driver, ReportingLoansPO.facilityFilterBox);
			node.log(Status.INFO, "STEP3 : Clicked on the facility reference dropdown");
			System.out.println("STEP3 : Clicked on the facility reference dropdown");

			// Wait for the visibility of the facility reference option
			node.log(Status.INFO, "STEP4 : Waiting for the visibility of the facility reference option");
			System.out.println("STEP4 : Waiting for the visibility of the facility reference option");
			IWaitStrategy.waitForVisiblity(node, driver, facilityReferenceLocator);
			node.log(Status.INFO, "STEP5 : Facility reference option is visible");
			System.out.println("STEP5 : Facility reference option is visible");

			// Get the option value
			String optionValue = IElementActions.getElementText_usingXpath(node, driver, facilityReferenceLocator);

			// Select loan from loan reference dropdown
			IElementActions.selectValueFromDropdown(node, driver, ReportingLoansPO.facilityFilter, optionValue);

			Thread.sleep(2000);
			// Get facility drawn value
			String drawnAmount = IElementActions.getElementText_usingXpath(node, driver, ReportingLoansPO.drawnAmount);

			// Get facility utilisation percentage in reporting
			Double utilisationPercentage = Utils.getTextAndParseToDouble(ReportingLoansPO.utilisationPercentage);

			// Call the loadDatabasePage function from the FundingPage
			FundingPage.loadDatabasePage();

			// Search record based on the provide loan reference and open it
			Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, FundingNewFacilityPO.reference,
					facilityReference, UtilsPO.editIcon, FundingNewFacilityPO.editLoanFacilityText);

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.summaryTab, FundingNewFacilityPO.loanFacilitySummaryText,
					"Facility Summary");

			// Wait for the visibility of the cash amount in summary page
			node.log(Status.INFO, "STEP6 : Waiting for the visibility of the cash amount in summary page");
			System.out.println("STEP6 : Waiting for the visibility of the cash amount in summary page");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.cashValue);
			node.log(Status.INFO, "STEP7 : Cash amount in summary page is visible");
			System.out.println("STEP7 : Cash amount in summary page is visible");

			// Get facility cash value
			String facilityCashValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingNewFacilityPO.facilityAmountValue);

			// Get facility utilisation percentage
			Double expectedUtilisationPercentage = Utils.getTextAndParseToDouble(FundingNewFacilityPO.utilisationValue);

			// Assert the drawn amount
			IElementActions.assertEquals_usingString(node, driver, drawnAmount, facilityCashValue,
					"STEP8 : BUG : The drawn amount corresponding to facility " + facilityReference + " is "
							+ drawnAmount + " and is not equal to expected " + facilityCashValue,
					"STEP8 : PASS : The drawn amount corresponding to facility " + facilityReference + " is "
							+ drawnAmount + " and is equal to expected " + facilityCashValue);

			// Perform assertion allowing for a difference .5 with a delta parameter
			Assert.assertEquals(utilisationPercentage, expectedUtilisationPercentage, deviatedValue,
					"Difference is greater than the acceptable range between facility utilisation in reporting "
							+ utilisationPercentage + " and the expected facility utilisation "
							+ expectedUtilisationPercentage);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityFilter", "Pass", driver);

		} catch (AssertionError validateFacilityFilter) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityFilter test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFacilityFilter_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityFilter.printStackTrace();
			node.fail(validateFacilityFilter);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityFilter) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityFilter test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFacilityFilter_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityFilter.printStackTrace();
			node.fail(validateFacilityFilter);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_005
	@Test(priority = 5)
	public void validateFilterPersistAcrossAction() throws IOException {
		try {
			extenttest = extent.createTest("Verify that selected filters persist across actions.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Select the Value from Facility Filter dropdown
			IElementActions.selectValueFromDropdownByIndex(node, driver, ReportingLoansPO.facilityFilter, 3);

			// Get the Selected Value From Facility Filter Dropdown
			String SelectedValue1 = IElementActions.getFirstValueFromDropdownByText(node, driver,
					ReportingLoansPO.facilityFilter);

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Click on Summary Tab
			Utils.clickOnTab(ReportingLoansPO.summaryTab, ReportingLoansPO.loansHeaderText, "Summary");

			// Get the Selected Value From Facility Filter Dropdown
			String SelectedValue2 = IElementActions.getFirstValueFromDropdownByText(node, driver,
					ReportingLoansPO.facilityFilter);

			// Assert that The previously selected Facility filters is still applied when
			// returning to the Facility Reporting page.
			IElementActions.assertEquals_usingString(node, driver, SelectedValue1, SelectedValue2,
					"STEP1 : BUG : The previously selected Facility filter " + SelectedValue1
							+ " is not applied when returning to the Facility Reporting page " + SelectedValue2,
					"STEP1 : PASS : The previously selected Facility filter " + SelectedValue1
							+ " is Still applied when returning to the Facility Reporting page " + SelectedValue2);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFilterPersistAcrossAction", "Pass", driver);

		} catch (AssertionError validateFilterPersistAcrossAction) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFilterPersistAcrossAction test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFilterPersistAcrossAction_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFilterPersistAcrossAction.printStackTrace();
			node.fail(validateFilterPersistAcrossAction);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFilterPersistAcrossAction) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFilterPersistAcrossAction test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFilterPersistAcrossAction_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFilterPersistAcrossAction.printStackTrace();
			node.fail(validateFilterPersistAcrossAction);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_006
	@Test(priority = 6)
	public void validateDateAndTimeDropdown() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the date and time dropdown.")
					.assignCategory(reportingLoans_tag + "_" + env);
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

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDateAndTimeDropdown", "Pass", driver);

		} catch (AssertionError validateDateAndTimeDropdown) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDateAndTimeDropdown test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDateAndTimeDropdown_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDateAndTimeDropdown.printStackTrace();
			node.fail(validateDateAndTimeDropdown);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDateAndTimeDropdown) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDateAndTimeDropdown test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDateAndTimeDropdown_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDateAndTimeDropdown.printStackTrace();
			node.fail(validateDateAndTimeDropdown);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_007
	@Test(priority = 7)
	public void validateDateAndTimeFilter() throws IOException {
		try {
			extenttest = extent.createTest("Verify that users can select a Date and time from the filter.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the visibility of the date time dropdown
			node.log(Status.INFO,
					"STEP1 : Waiting for the visibility of the date time dropdown to be clickable and visible");
			System.out.println(
					"STEP1 : Waiting for the visibility of the date time dropdown to be clickable and visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.dateFilterBox);
			IWaitStrategy.WaitUntilElementClickable(node, driver, ReportingLoansPO.dateFilterBox);
			node.log(Status.INFO, "STEP2 : Date time dropdown is clickable and visible");
			System.out.println("STEP2 : Date time dropdown is clickable and visible");

			// Click on the date time dropdown
			IElementActions.clickelement_usingXpath(node, driver, ReportingLoansPO.dateFilterBox);
			node.log(Status.INFO, "STEP3 : Clicked on the date time dropdown");
			System.out.println("STEP3 : Clicked on the date time dropdown");

			// Get Selected Value From Date and Time Dropdown
			String selectedDateAndTime = IElementActions.getFirstValueFromDropdownByText(node, driver,
					ReportingLoansPO.loansSingleSelectDateDropdown);

			// Get the option value
			String optionValue = IElementActions.getElementValue(node, driver,
					ReportingLoansPO.loansSingleSelectDateDropdown);

			// Assert selected and current date time value
			IElementActions.assertEquals_usingString(node, driver, selectedDateAndTime, optionValue,
					"STEP4 : BUG : The selected " + selectedDateAndTime + " and current date time " + optionValue
							+ " is not same",
					"STEP4 : PASS : The selected " + selectedDateAndTime + " and current date time " + optionValue
							+ " is same");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDateAndTimeFilter", "Pass", driver);

		} catch (AssertionError validateDateAndTimeFilter) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDateAndTimeFilter test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDateAndTimeFilter_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDateAndTimeFilter.printStackTrace();
			node.fail(validateDateAndTimeFilter);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDateAndTimeFilter) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDateAndTimeFilter test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDateAndTimeFilter_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDateAndTimeFilter.printStackTrace();
			node.fail(validateDateAndTimeFilter);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_008
	@Test(priority = 8)
	public void validateLendingCriteriaSections() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that Lending Criteria dropdown consists of three section i.e."
							+ "- Portfolio Criteria" + "- Regional Limit" + "- Map view")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Lending Criteria + Icon
			IElementActions.clickelement_usingXpath(node, driver, ReportingLoansPO.lendingCriteriaIcon);
			node.log(Status.INFO, "STEP1 : Clicked on '+' icon present at the Lending Criteria");
			System.out.println("STEP1 : Clicked on '+' icon present at the Lending Criteria");

			// Wait for the Visibility of Portfolio Criteria Section
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of Portfolio Criteria Section");
			System.out.println("STEP2 : Waiting for the visibility of Portfolio Criteria Section");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.portfolioCriteriaSection);
			node.log(Status.INFO, "STEP3 : The Portfolio Criteria Section is now visible");
			System.out.println("STEP3 : The Portfolio Criteria Section is now visible");

			// Check the visibility of Portfolio Criteria Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.portfolioCriteriaSection,
					"STEP4 : BUG: The Portfolio Criteria Section is not visible in Lending Criteria.",
					"STEP4 : EXPECTED: The Portfolio Criteria Section is visible in Lending Criteria.");

			// Check the visibility of Regional Limit Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.regionalLimitSection,
					"STEP5 : BUG: The Regional Limit Section is not visible in Lending Criteria.",
					"STEP5 : EXPECTED: The Regional Limit Section is visible in Lending Criteria.");

			// Check the visibility of Map View Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.mapViewSection,
					"STEP6 : BUG: The Map View Section is not visible in Lending Criteria.",
					"STEP6 : EXPECTED: The Map View Section is visible in Lending Criteria.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLendingCriteriaSections", "Pass", driver);

		} catch (AssertionError validateLendingCriteriaSections) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLendingCriteriaSections test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLendingCriteriaSections_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLendingCriteriaSections.printStackTrace();
			node.fail(validateLendingCriteriaSections);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLendingCriteriaSections) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLendingCriteriaSections test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLendingCriteriaSections_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLendingCriteriaSections.printStackTrace();
			node.fail(validateLendingCriteriaSections);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_009
	// TC_Reporting_Loans_011
	// TC_Reporting_Loans_015
	@Test(priority = 9)
	public void validateLendingCriteria() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the Lending Criteria")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Get facility reference
			String facilityReference = getDataFromExcel(70);

			// Create Dynamic Facility Reference Locator
			String facilityReferenceLocator = IElementActions
					.createDynamicLocatorString(ReportingLoansPO.facilityOptions, "locatorValue", facilityReference);

			// Wait for the visibility of the facility reference dropdown
			node.log(Status.INFO,
					"STEP1 : Waiting for the visibility of the facility reference dropdown to be clickable and visible");
			System.out.println(
					"STEP1 : Waiting for the visibility of the facility reference dropdown to be clickable and visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.facilityFilterBox);
			IWaitStrategy.WaitUntilElementClickable(node, driver, ReportingLoansPO.facilityFilterBox);
			node.log(Status.INFO, "STEP2 : Facility reference dropdown is clickable and visible");
			System.out.println("STEP2 : Facility reference dropdown is clickable and visible");

			// Click on the facility reference dropdown
			IElementActions.clickelement_usingXpath(node, driver, ReportingLoansPO.facilityFilterBox);
			node.log(Status.INFO, "STEP3 : Clicked on the facility reference dropdown");
			System.out.println("STEP3 : Clicked on the facility reference dropdown");

			// Wait for the visibility of the facility reference option
			node.log(Status.INFO, "STEP4 : Waiting for the visibility of the facility reference option");
			System.out.println("STEP4 : Waiting for the visibility of the facility reference option");
			IWaitStrategy.waitForVisiblity(node, driver, facilityReferenceLocator);
			node.log(Status.INFO, "STEP5 : Facility reference option is visible");
			System.out.println("STEP5 : Facility reference option is visible");

			// Get the option value
			String optionValue = IElementActions.getElementText_usingXpath(node, driver, facilityReferenceLocator);

			// Select loan from loan reference dropdown
			IElementActions.selectValueFromDropdown(node, driver, ReportingLoansPO.facilityFilter, optionValue);

			// Wait for the visibility of the '+' icon for the Lending Criteria
			node.log(Status.INFO,
					"STEP6 : Waiting for the visibility of the '+' icon for the Lending Criteria to be clickable and visible");
			System.out.println(
					"STEP6 : Waiting for the visibility of the '+' icon for the Lending Criteria to be clickable and visible");
			IWaitStrategy.waitForVisiblityDynamic(node, driver, ReportingLoansPO.lendingCriteriaIcon, 180);
			IWaitStrategy.WaitUntilElementClickable(node, driver, ReportingLoansPO.lendingCriteriaIcon);
			node.log(Status.INFO, "STEP7 : '+' icon for the Lending Criteria is clickable and visible");
			System.out.println("STEP7 : '+' icon for the Lending Criteria is clickable and visible");

			// Click on Lending Criteria + Icon
			IElementActions.clickelement_usingXpath(node, driver, ReportingLoansPO.lendingCriteriaIcon);
			node.log(Status.INFO, "STEP8 : Clicked on '+' icon present at the Lending Criteria");
			System.out.println("STEP8 : Clicked on '+' icon present at the Lending Criteria");

			// Wait for the Visibility of Portfolio Criteria values
			node.log(Status.INFO, "STEP9 : Waiting for the visibility of Portfolio Criteria values");
			System.out.println("STEP9 : Waiting for the visibility of Portfolio Criteria values");
			IWaitStrategy.waitForVisiblityDynamic(node, driver, ReportingLoansPO.portfolioValues, 180);
			node.log(Status.INFO, "STEP10 : The Portfolio Criteria values is now visible");
			System.out.println("STEP10 : The Portfolio Criteria values is now visible");

			Thread.sleep(2000);
			List<String> portfolioValues = Utils.extractTextFromElements(ReportingLoansPO.portfolioValues);

			List<String> regionalLimitValues = Utils.extractTextFromElements(ReportingLoansPO.regionalLimitValues);

			// Call the loadDatabasePage function from the FundingPage
			FundingPage.loadDatabasePage();

			// Search record based on the provide loan reference and open it
			Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, FundingNewFacilityPO.reference,
					facilityReference, UtilsPO.editIcon, FundingNewFacilityPO.editLoanFacilityText);

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.facilityStatusTab, FundingNewFacilityPO.drawdownsSection,
					"Facility Status");

			List<String> portfolioValuesInFacility = Utils
					.extractTextFromElements(FundingNewFacilityPO.portfolioValues);

			List<String> regionalLimitValuesInFacility = Utils
					.extractTextFromElements(FundingNewFacilityPO.regionalLimitValues);

			// Validate portfolio values
			Utils.validateList(portfolioValues, portfolioValuesInFacility,
					"Portfolio values in reporting loans is not equal to the portfolio values of corresponding facility",
					"Portfolio values in reporting loans is equal to the portfolio values of corresponding facility");

			// Validate regional values
			Utils.validateList(regionalLimitValues, regionalLimitValuesInFacility,
					"Regional limit values in reporting loans is not equal to the regional limit values of corresponding facility",
					"Regional limit values in reporting loans is equal to the regional limit values of corresponding facility");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLendingCriteria", "Pass", driver);

		} catch (AssertionError validateLendingCriteria) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLendingCriteria test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLendingCriteria_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLendingCriteria.printStackTrace();
			node.fail(validateLendingCriteria);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLendingCriteria) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLendingCriteria test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLendingCriteria_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLendingCriteria.printStackTrace();
			node.fail(validateLendingCriteria);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_010
	@Test(priority = 10)
	public void validateNewDate() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that new date is available to select from dropdown given that update has completed successfully")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingUpdatesPage();

			// Click on the run script button
			Utils.clickOnRunScriptButton();

			//
			Utils.refreshPagenTill(node, driver, 30, 2, ReportingUpdatesPO.firstRecordStatus,
					ReportingUpdatesPO.firstRecordStatusInProgress, ReportingUpdatesPO.firstRecordStatusError);

			String expectedTodayDate = Utils.getTodayDateFormatted();

			String actualLaunchDate = IElementActions.getElementText_usingXpath(node, driver,
					ReportingUpdatesPO.firstRecordLaunchDate);

			IElementActions.assertContains_usingString(node, driver, actualLaunchDate, expectedTodayDate,
					"STEP1 : BUG: Launch Date is not coming on Reporting Updates page",
					"STEP1 : EXPECTED:  Launch Date is coming on Reporting Updates page");

			String actualScheduled = IElementActions.getElementText_usingXpath(node, driver,
					ReportingUpdatesPO.firstRecordScheduledDate);

			IElementActions.assertContains_usingString(node, driver, actualScheduled, "MANUAL",
					"STEP2 : BUG: Scheduled is not coming on Reporting Updates page",
					"STEP2 : EXPECTED: Scheduled is coming on Reporting Updates page");

			// Check the status
			String status = FundingPage.checkStatus(ReportingUpdatesPO.firstRecordStatus,
					ReportingUpdatesPO.firstRecordStatusInProgress, ReportingUpdatesPO.firstRecordStatusError);
			node.log(Status.INFO, "STEP3 : " + status + " appears in status");
			System.out.println("STEP3 : " + status + " appears in status");

			// Verify the entry is added to the table
			IElementActions.assertContains_usingString(node, driver, status, "DONE_SUCCESS",
					"STEP4: BUG: " + status + " is coming on the record generated by runscript",
					"STEP4 : EXPECTED: DONE_SUCCESS is coming on the record generated by runscript");

			Thread.sleep(10000);
			// Get first Done Success Launch Date
			node.log(Status.INFO, "STEP5 : Get the first Done Success Launch Date");
			System.out.println("STEP5 : Get the first Done Success Launch Date");
			String firstDoneSuccessLaunchDate = IElementActions
					.getElementText_usingXpath(node, driver, ReportingUpdatesPO.firstDoneSuccessLaunchDate)
					.substring(0, 10);

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the visibility of the Page
			node.log(Status.INFO, "STEP6 : Waiting for the visibility of the page");
			System.out.println("STEP6 : Waiting for the visibility of the page");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.loansSingleSelectDateDropdown);
			node.log(Status.INFO, "STEP7 : Page is visible");
			System.out.println("STEP7 : Page is visible");

			// Click on the loans Single Select Date Dropdown
			IElementActions.clickelement_usingXpath(node, driver, ReportingLoansPO.loansSingleSelectDateDropdown);
			node.log(Status.INFO, "STEP8: Clicked on loans single select date dropdown");
			System.out.println("STEP8 : Clicked on loans single select date dropdown");

			// Get the first Option from loans single select date dropdown
			node.log(Status.INFO, "STEP9 : Get the first Option from loans single select date dropdown");
			System.out.println("STEP9 : Get the first Option from loans single select date dropdown");
			String firstDateInDropdown = IElementActions
					.getElementText_usingXpath(node, driver, ReportingLoansPO.singleSelectDatefirstOption)
					.substring(0, 10);

			// Convert the dd-MM-yyyy date format to dd/MM/yyyy
			String firstDateOption = firstDateInDropdown.replace("-", "/");

			IElementActions.assertEquals_usingString(node, driver, firstDoneSuccessLaunchDate, firstDateOption,
					"STEP10: BUG: First date in loans single dropdown is not same as first Done_Success Launch Date",
					"STEP10: PASS: First date in loans single dropdown is same as first Done_Success Launch Date");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateNewDate", "Pass", driver);

		} catch (AssertionError validateNewDate) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNewDate test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateNewDate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNewDate.printStackTrace();
			node.fail(validateNewDate);
			Assert.fail();
			extent.flush();

		} catch (Exception validateNewDate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNewDate test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateNewDate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNewDate.printStackTrace();
			node.fail(validateNewDate);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_012
	@Test(priority = 11)
	public void validateLendingCriteriaDataForAllFacility() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that data under Lending Criteria is displayed as '0' if 'All' is selected in the Facility dropdown filter,")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Lending Criteria + Icon
			IElementActions.clickelement_usingXpath(node, driver, ReportingLoansPO.lendingCriteriaIcon);
			node.log(Status.INFO, "STEP1 : Clicked on '+' icon present at the Lending Criteria");
			System.out.println("STEP1 : Clicked on '+' icon present at the Lending Criteria");

			// Wait for the Visibility of Portfolio Criteria values
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of Portfolio Criteria values");
			System.out.println("STEP2 : Waiting for the visibility of Portfolio Criteria values");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.portfolioValues);
			node.log(Status.INFO, "STEP3 : The Portfolio Criteria values is now visible");
			System.out.println("STEP3 : The Portfolio Criteria values is now visible");

			// Select the Value from Facility Filter dropdown
			IElementActions.selectValueFromDropdown(node, driver, ReportingLoansPO.facilityFilter, "ALL");

			Thread.sleep(2000);
			List<String> portfolioValues = Utils.extractTextFromElements(ReportingLoansPO.portfolioValues);

			List<String> regionalLimitValues = Utils.extractTextFromElements(ReportingLoansPO.regionalLimitValues);

			// Declare and initialize a list of strings with five "0" values
			List<String> expectedPortfolioValues = new ArrayList<>(Collections.nCopies(5, "0"));

			// Declare and initialize a list of strings with five "0" values
			List<String> expectedRegionalLimitValues = new ArrayList<>(Collections.nCopies(12, "0"));

			// Validate portfolio values
			Utils.validateList(portfolioValues, expectedPortfolioValues,
					"Portfolio values in reporting loans is not equal to the portfolio values of corresponding facility",
					"Portfolio values in reporting loans is equal to the portfolio values of corresponding facility");

			// Validate regional values
			Utils.validateList(regionalLimitValues, expectedRegionalLimitValues,
					"Regional limit values in reporting loans is not equal to the regional limit values of corresponding facility",
					"Regional limit values in reporting loans is equal to the regional limit values of corresponding facility");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLendingCriteriaDataForAllFacility", "Pass", driver);

		} catch (AssertionError validateLendingCriteriaDataForAllFacility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLendingCriteriaDataForAllFacility test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLendingCriteriaDataForAllFacility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLendingCriteriaDataForAllFacility.printStackTrace();
			node.fail(validateLendingCriteriaDataForAllFacility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLendingCriteriaDataForAllFacility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLendingCriteriaDataForAllFacility test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLendingCriteriaDataForAllFacility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLendingCriteriaDataForAllFacility.printStackTrace();
			node.fail(validateLendingCriteriaDataForAllFacility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_013
	@Test(priority = 12)
	public void validateLendingCriteriaColumns() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the data under Lending criteria displays in 2 columns i.e. one is in black and other is in green")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Lending Criteria + Icon
			IElementActions.clickelement_usingXpath(node, driver, ReportingLoansPO.lendingCriteriaIcon);
			node.log(Status.INFO, "STEP1 : Clicked on '+' icon present at the Lending Criteria");
			System.out.println("STEP1 : Clicked on '+' icon present at the Lending Criteria");

			// Wait for the Visibility of Portfolio Criteria values
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of Portfolio Criteria values");
			System.out.println("STEP2 : Waiting for the visibility of Portfolio Criteria values");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.portfolioValues);
			node.log(Status.INFO, "STEP3 : The Portfolio Criteria values is now visible");
			System.out.println("STEP3 : The Portfolio Criteria values is now visible");

			// Select the Value from Facility Filter dropdown
			IElementActions.selectValueFromDropdown(node, driver, ReportingLoansPO.facilityFilter, "ALL");

			String greenColor = "rgba(20, 178, 20, 1)";
			String redColor = "rgba(255, 85, 96, 1)";
			String blackColor = "rgba(87, 89, 98, 1)";

			// First column validation, finding all elements in the first column
			List<WebElement> portfolioFirstColumnElements = IElementActions.returnElements(node, driver,
					ReportingLoansPO.firstColumnPortfolioValues);

			// Validate each element in the first column
			for (WebElement element : portfolioFirstColumnElements) {
				// Get the value of the style attribute for the button element
				String colorValue = element.getCssValue("color");

				// Check if the style attribute contains the desired value
				if (colorValue.contains("rgba(20, 178, 20, 1)") || colorValue.contains("rgba(255, 85, 96, 1)")) {
					node.log(Status.INFO,
							"STEP4 : Data under portfolio criteria first column displayed in green or red value.");
					System.out.println(
							"STEP4 : Data under portfolio criteria first column displayed in green or red value.");
					Assert.assertTrue(true,
							"Data under portfolio criteria first column displayed in green or red value.");
				} else {
					node.log(Status.INFO,
							"STEP4 : Data under portfolio criteria first column is not displayed in green or red value.");
					System.out.println(
							"STEP4 : Data under portfolio criteria first column is not displayed in green or red value.");
					Assert.assertTrue(false,
							"Data under portfolio criteria first column is not displayed in green or red value.");
				}
			}

			// Second column validation, finding all elements in the second column
			List<WebElement> portfolioSecondColumnElements = IElementActions.returnElements(node, driver,
					ReportingLoansPO.portfolioValues);

			// Validate each element in the second column
			for (WebElement element : portfolioSecondColumnElements) {
				// Get the value of the style attribute for the button element
				String colorValue = element.getCssValue("color");

				// Check if the style attribute contains the desired value
				if (colorValue.contains(blackColor)) {
					node.log(Status.INFO,
							"STEP5 : Data under portfolio criteria second column displayed in black value.");
					System.out.println("STEP5 : Data under portfolio criteria second column displayed in black value.");
					Assert.assertTrue(true, "Data under portfolio criteria second column displayed in black value.");

				} else {
					node.log(Status.INFO,
							"STEP5 : Data under portfolio criteria second column is not displayed in black value.");
					System.out.println(
							"STEP5 : Data under portfolio criteria second column is not displayed in black value.");
					Assert.assertTrue(true,
							"Data under portfolio criteria second column is not displayed in black value.");
				}
			}

			// First column validation, finding all elements in the first column
			List<WebElement> regionalLimitFirstColumnElements = IElementActions.returnElements(node, driver,
					ReportingLoansPO.firstColumnRegionalLimitValues);

			// Validate each element in the first column
			for (WebElement element : regionalLimitFirstColumnElements) {
				// Get the value of the style attribute for the button element
				String colorValue = element.getCssValue("color");

				// Check if the style attribute contains the desired value
				if (colorValue.contains("rgba(20, 178, 20, 1)") || colorValue.contains("rgba(255, 85, 96, 1)")) {
					node.log(Status.INFO,
							"STEP6 : Data under regional limit first column displayed in green or red value.");
					System.out
							.println("STEP6 : Data under regional limit first column displayed in green or red value.");
					Assert.assertTrue(true, "Data under regional limit first column displayed in green or red value.");

				} else {
					node.log(Status.INFO,
							"STEP6 : Data under regional limit first column is not displayed in green or red value.");
					System.out.println(
							"STEP6 : Data under regional limit first column is not displayed in green or red value.");
					Assert.assertTrue(false,
							"Data under regional limit first column is not displayed in green or red value.");
				}
			}

			// Second column validation, finding all elements in the second column
			List<WebElement> regionalLimitSecondColumnElements = IElementActions.returnElements(node, driver,
					ReportingLoansPO.regionalLimitValues);

			// Validate each element in the second column
			for (WebElement element : regionalLimitSecondColumnElements) {
				// Get the value of the style attribute for the button element
				String colorValue = element.getCssValue("color");

				// Check if the style attribute contains the desired value
				if (colorValue.contains(blackColor)) {
					node.log(Status.INFO, "STEP7 : Data under regional limit second column displayed in black value.");
					System.out.println("STEP7 : Data under regional limit second column displayed in black value.");
					Assert.assertTrue(true, "Data under regional limit second column displayed in black value.");

				} else {
					node.log(Status.INFO,
							"STEP7 : Data under regional limit second column is not displayed in black value.");
					System.out.println(
							"STEP7 : Data under regional limit second column is not displayed in black value.");
					Assert.assertTrue(true, "Data under regional limit second column is not displayed in black value.");
				}
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLendingCriteriaColumns", "Pass", driver);

		} catch (AssertionError validateLendingCriteriaColumns) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLendingCriteriaColumns test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLendingCriteriaColumns_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLendingCriteriaColumns.printStackTrace();
			node.fail(validateLendingCriteriaColumns);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLendingCriteriaColumns) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLendingCriteriaColumns test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLendingCriteriaColumns_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLendingCriteriaColumns.printStackTrace();
			node.fail(validateLendingCriteriaColumns);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_014
	@Test(priority = 13)
	public void validateLendingCriteriaGreenTextDataColumns() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that data display in 1st column (Green text)  displays data similar to Funding > Database > Edit icon > Facility Status tab - Compliance section")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Get facility reference
			String facilityReference = getDataFromExcel(70);

			// Create Dynamic Facility Reference Locator
			String facilityReferenceLocator = IElementActions
					.createDynamicLocatorString(ReportingLoansPO.facilityOptions, "locatorValue", facilityReference);

			// Wait for the visibility of the facility reference dropdown
			node.log(Status.INFO,
					"STEP1 : Waiting for the visibility of the facility reference dropdown to be clickable and visible");
			System.out.println(
					"STEP1 : Waiting for the visibility of the facility reference dropdown to be clickable and visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.facilityFilterBox);
			IWaitStrategy.WaitUntilElementClickable(node, driver, ReportingLoansPO.facilityFilterBox);
			node.log(Status.INFO, "STEP2 : Facility reference dropdown is clickable and visible");
			System.out.println("STEP2 : Facility reference dropdown is clickable and visible");

			// Click on the facility reference dropdown
			IElementActions.clickelement_usingXpath(node, driver, ReportingLoansPO.facilityFilterBox);
			node.log(Status.INFO, "STEP3 : Clicked on the facility reference dropdown");
			System.out.println("STEP3 : Clicked on the facility reference dropdown");

			// Wait for the visibility of the facility reference option
			node.log(Status.INFO, "STEP4 : Waiting for the visibility of the facility reference option");
			System.out.println("STEP4 : Waiting for the visibility of the facility reference option");
			IWaitStrategy.waitForVisiblity(node, driver, facilityReferenceLocator);
			node.log(Status.INFO, "STEP5 : Facility reference option is visible");
			System.out.println("STEP5 : Facility reference option is visible");

			// Get the option value
			String optionValue = IElementActions.getElementText_usingXpath(node, driver, facilityReferenceLocator);

			// Select loan from loan reference dropdown
			IElementActions.selectValueFromDropdown(node, driver, ReportingLoansPO.facilityFilter, optionValue);

			// Click on Lending Criteria + Icon
			IElementActions.clickelement_usingXpath(node, driver, ReportingLoansPO.lendingCriteriaIcon);
			node.log(Status.INFO, "STEP6 : Clicked on '+' icon present at the Lending Criteria");
			System.out.println("STEP6 : Clicked on '+' icon present at the Lending Criteria");

			// Wait for the Visibility of Portfolio Criteria values
			node.log(Status.INFO, "STEP7 : Waiting for the visibility of Portfolio Criteria values");
			System.out.println("STEP7 : Waiting for the visibility of Portfolio Criteria values");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.portfolioValues);
			node.log(Status.INFO, "STEP8 : The Portfolio Criteria values is now visible");
			System.out.println("STEP8 : The Portfolio Criteria values is now visible");

			Thread.sleep(3000);
			List<String> portfolioValues = Utils.extractTextFromElements(ReportingLoansPO.firstColumnPortfolioValues);

			List<String> regionalLimitValues = Utils
					.extractTextFromElements(ReportingLoansPO.firstColumnRegionalLimitValues);

			// Call the loadDatabasePage function from the FundingPage
			FundingPage.loadDatabasePage();

			// Search record based on the provide loan reference and open it
			Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, FundingNewFacilityPO.reference,
					facilityReference, UtilsPO.editIcon, FundingNewFacilityPO.editLoanFacilityText);

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.facilityStatusTab, FundingNewFacilityPO.drawdownsSection,
					"Facility Status");

			Thread.sleep(2000);
			List<String> portfolioValuesInFacility = Utils
					.extractTextFromElements(FundingNewFacilityPO.firstColumnPortfolioValues);

			List<String> regionalLimitValuesInFacility = Utils
					.extractTextFromElements(FundingNewFacilityPO.firstColumnRegionalLimitValues);

			// Validate portfolio values
			Utils.validateList(portfolioValues, portfolioValuesInFacility,
					"First column portfolio values in reporting loans is not equal to the first column portfolio values of corresponding facility",
					"First column portfolio values in reporting loans is equal to the first column portfolio values of corresponding facility");

			// Validate regional values
			Utils.validateList(regionalLimitValues, regionalLimitValuesInFacility,
					"First column regional limit values in reporting loans is not equal to the first column regional limit values of corresponding facility",
					"First column regional limit values in reporting loans is equal to the first column regional limit values of corresponding facility");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLendingCriteriaGreenTextDataColumns", "Pass", driver);

		} catch (AssertionError validateLendingCriteriaGreenTextDataColumns) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLendingCriteriaGreenTextDataColumns test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLendingCriteriaGreenTextDataColumns_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLendingCriteriaGreenTextDataColumns.printStackTrace();
			node.fail(validateLendingCriteriaGreenTextDataColumns);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLendingCriteriaGreenTextDataColumns) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLendingCriteriaGreenTextDataColumns test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLendingCriteriaGreenTextDataColumns_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLendingCriteriaGreenTextDataColumns.printStackTrace();
			node.fail(validateLendingCriteriaGreenTextDataColumns);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_016
	@Test(priority = 14)
	public void validateLendingCriteriaIcons() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that user is able close and open the Lending Criteria on clicking on '+' or '-' icons.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Lending Criteria + Icon
			IElementActions.clickelement_usingXpath(node, driver, ReportingLoansPO.lendingCriteriaIcon);
			node.log(Status.INFO, "STEP1 : Clicked on '+' icon present at the Lending Criteria.");
			System.out.println("STEP1 : Clicked on '+' icon present at the Lending Criteria.");

			// Wait for the Visibility of Portfolio Criteria Section
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of Portfolio Criteria Section.");
			System.out.println("STEP2 : Waiting for the visibility of Portfolio Criteria Section.");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.portfolioCriteriaSection);
			node.log(Status.INFO,
					"STEP3 : The user succesfully clicked on Lending Criteria + icon and Lending criteria is Open.");
			System.out.println(
					"STEP3 : The user succesfully clicked on Lending Criteria + iconand Lending criteria is Open .");

			Thread.sleep(3000);
			// Click on Lending Criteria - Icon
			IElementActions.clickelement_usingXpath(node, driver, ReportingLoansPO.lendingCriteriaIcon);
			node.log(Status.INFO, "STEP4 : Clicked on '-' icon present at the Lending Criteria.");
			System.out.println("STEP4 : Clicked on '-' icon present at the Lending Criteria.");

			// Wait for the Invisibility of Portfolio Criteria Section
			node.log(Status.INFO, "STEP5 : Waiting for the Invisibility of Portfolio Criteria Section.");
			System.out.println("STEP5 : Waiting for the Invisibility of Portfolio Criteria Section.");
			IWaitStrategy.waitForInVisiblity(node, driver, ReportingLoansPO.portfolioCriteriaSection);
			node.log(Status.INFO,
					"STEP6 : The user succesfully clicked on Lending Criteria - icon and Lending criteria is Closed.");
			System.out.println(
					"STEP6 : The user succesfully clicked on Lending Criteria - iconand Lending criteria is Closed.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLendingCriteriaIcons", "Pass", driver);

		} catch (AssertionError validateLendingCriteriaIcons) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLendingCriteriaIcons test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLendingCriteriaIcons_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLendingCriteriaIcons.printStackTrace();
			node.fail(validateLendingCriteriaIcons);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLendingCriteriaIcons) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLendingCriteriaIcons test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLendingCriteriaIcons_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLendingCriteriaIcons.printStackTrace();
			node.fail(validateLendingCriteriaIcons);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_017
	@Test(priority = 15)
	public void validateByDefaultSummaryTabIsSelected() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the by default summary tab is selected")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			Thread.sleep(2000);
			// Get the Current URL
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			// Check that Bydefault Summary Tab is Selected
			if ((currentUrl.contains("summary"))) {
				node.log(Status.INFO, "STEP1 : PASS : The Bydefault Summary Tab is Selected");
				System.out.println("STEP1 : PASS : The Bydefault Summary Tab is Selected");
			} else {
				node.log(Status.INFO, "STEP2 : BUG : The Bydefault Summary Tab is not Selected");
				System.out.println("STEP2 : BUG :  The Bydefault Summary Tab is not Selected");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateByDefaultSummaryTabIsSelected", "Pass", driver);

		} catch (AssertionError validateByDefaultSummaryTabIsSelected) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateByDefaultSummaryTabIsSelected test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateByDefaultSummaryTabIsSelected_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateByDefaultSummaryTabIsSelected.printStackTrace();
			node.fail(validateByDefaultSummaryTabIsSelected);
			Assert.fail();
			extent.flush();

		} catch (Exception validateByDefaultSummaryTabIsSelected) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateByDefaultSummaryTabIsSelected test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateByDefaultSummaryTabIsSelected_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateByDefaultSummaryTabIsSelected.printStackTrace();
			node.fail(validateByDefaultSummaryTabIsSelected);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_018
	@Test(priority = 16)
	public void validateSummaryTabSectionsVisibility() throws IOException {
		try {
			extenttest = extent.createTest("Verify if the user is able to view the initial state the Summary tab ")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Select the Value from Facility Filter dropdown
			IElementActions.selectValueFromDropdownByIndex(node, driver, ReportingLoansPO.facilityFilter, 0);

			// Verify the section in Summary Page
			node.log(Status.INFO, "STEP1 : Verify the sections in Summary Page");
			System.out.println("STEP1 : Verify the sections in Summary Page ");

			// Check the visibility of Drawn Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.drawnSection,
					"STEP2 : BUG : The Drawn Section is not coming on Summary Page",
					"STEP2 : EXPECTED : The Drawn Section is coming on Summary Page");

			// Check the visibility of Utilisation Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.utilisationSection,
					"STEP3 : BUG : The Utilisation Section is not coming on Summary Page",
					"STEP3 : EXPECTED : The Utilisation Section is coming on Summary Page");

			// Check the visibility of Number of Loans Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.numberOfLoansSection,
					"STEP4 : BUG : The Number of Loans Section is not coming on Summary Page",
					"STEP4 : EXPECTED : The Number of Loans Section is coming on Summary Page");

			// Check the visibility of WA Maturity Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.wAMaturitySection,
					"STEP5 : BUG : The WA Maturity Section is not coming on Summary Page",
					"STEP5 : EXPECTED : The WA Maturity Section is coming on Summary Page");

			// Check the visibility of Average Loan Size Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.averageLoanSizeSection,
					"STEP6 : BUG : The Average Loan Size Section is not coming on Summary Page",
					"STEP6 : EXPECTED : The Average Loan Size Section is coming on Summary Page");

			// Check the visibility of Facility Interest Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.facilityInterestSection,
					"STEP7 : BUG : The Facility Interest Section is not coming on Summary Page",
					"STEP7 : EXPECTED : The Facility Interest Section is coming on Summary Page");

			// Check the visibility of Terminating Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.terminatingSection,
					"STEP8 : BUG : The Terminating Section is not coming on Summary Page",
					"STEP8 : EXPECTED : The Terminating Section is coming on Summary Page");

			// Check the visibility of Frozen Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.frozenSection,
					"STEP9 : BUG : The Frozen Section is not coming on Summary Page",
					"STEP9 : EXPECTED : The Frozen Section is coming on Summary Page");

			// Check the visibility of WA LTV Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.wALTVSection,
					"STEP10 : BUG : The WA LTV Section is not coming on Summary Page",
					"STEP10 : EXPECTED : The WA LTV Section is coming on Summary Page");

			// Check the visibility of 1st Charge Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.firstChargeSection,
					"STEP11 : BUG : The 1st Charge Section is not coming on Summary Page",
					"STEP11 : EXPECTED : The 1st Charge Section is coming on Summary Page");

			// Check the visibility of Max Loan Size Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.maxLoanSizeSection,
					"STEP12 : BUG : The Max Loan Size Section is not coming on Summary Page",
					"STEP12 : EXPECTED : The Max Loan Size Section is coming on Summary Page");

			// Check the visibility of Bridge Loan Interest Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.bridgeLoanInterestSection,
					"STEP13 : BUG : The Bridge Loan Interest Section is not coming on Summary Page",
					"STEP13 : EXPECTED : The Bridge Loan Interest Section is coming on Summary Page");

			// Check the visibility of Sum of Interest Returns Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.sumOfInterestReturnsSection,
					"STEP14 : BUG : The Sum of Interest Returns Section is not coming on Summary Page",
					"STEP14 : EXPECTED : The Sum of Interest Returns Section is coming on Summary Page");

			// Check the visibility of Credit Performance Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.creditPerformanceSection,
					"STEP15 : BUG : The Credit Performance Section is not coming on Summary Page",
					"STEP15 : EXPECTED : The Credit Performance Section is coming on Summary Page");

			// Check the visibility of Loans By Region Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.loansByRegionSection,
					"STEP16 : BUG : The Loans By Region Section is not coming on Summary Page",
					"STEP16 : EXPECTED : The Loans By Region Section is coming on Summary Page");

			// Check the visibility of Repayment Profile Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.repaymentProfileSection,
					"STEP17 : BUG : The Repayment Profile Section is not coming on Summary Page",
					"STEP17 : EXPECTED : The Repayment Profile Section is coming on Summary Page");

			// Check the visibility of Stress Scenarios Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.stressScenariosSection,
					"STEP18 : BUG : The Stress Scenarios Section is not coming on Summary Page",
					"STEP18 : EXPECTED : The Stress Scenarios Section is coming on Summary Page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateSummaryTabSectionsVisibility", "Pass", driver);

		} catch (AssertionError validateSummaryTabSectionsVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateSummaryTabSectionsVisibility test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateSummaryTabSectionsVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSummaryTabSectionsVisibility.printStackTrace();
			node.fail(validateSummaryTabSectionsVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateSummaryTabSectionsVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateSummaryTabSectionsVisibility test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateSummaryTabSectionsVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSummaryTabSectionsVisibility.printStackTrace();
			node.fail(validateSummaryTabSectionsVisibility);
			Assert.fail();
			extent.flush();

		}
	}

	// TC_Reporting_Loans_019
	@Test(priority = 17)
	public void validateDrawnAmount() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the 'Drawn' amount accurately represents the sum of all individual facilities, reflecting the total amount invested into LARA.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Drawn Amount
			double drawnAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.drawnAmount);

			// Calling the loadDatabasePage function from FundingPage and Navigate to the
			// Funding Database Page
			FundingPage.loadDatabasePage();

			// Get the Sum of All the facility Drawn Amount column
			double drawnAmountColumnSum = Utils.calculateSumOfList(FundingDatabasePO.drawnElements);

			// Assert that Drawn amount on Reporting Loans Page is Equal to the Sum of All
			// Facilities Drawn Amount
			IElementActions.assertEquals_usingDouble(node, driver, drawnAmount, drawnAmountColumnSum,
					"STEP1 : BUG : The Drawn amount on Reporting Loans Page " + drawnAmount
							+ " is not Equal to the Sum of All Facilities Drawn Amount : " + drawnAmountColumnSum,
					"STEP1 : PASS : The Drawn amount on Reporting Loans Page " + drawnAmount
							+ " is Equal to the Sum of All Facilities Drawn Amount : " + drawnAmountColumnSum);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDrawnAmount", "Pass", driver);

		} catch (AssertionError validateDrawnAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDrawnAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDrawnAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDrawnAmount.printStackTrace();
			node.fail(validateDrawnAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDrawnAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDrawnAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDrawnAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDrawnAmount.printStackTrace();
			node.fail(validateDrawnAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_020
	@Test(priority = 18)
	public void validateDrawnPercentage() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the percentage Drawn is displayed in the bottom right-hand corner of the tile.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the drawn Percentage
			double drawnPercentage = Utils.getTextAndParseToDouble(ReportingLoansPO.drwanPercentage);

			// Check the visibility of Drawn Percenatge
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.drwanPercentage,
					"STEP1 : BUG : The Drawn Percentage is not coming in Drawn Section on Summary Page",
					"STEP1 : EXPECTED : The Drawn Percentage: " + drawnPercentage
							+ " is coming in Drawn Section on Summary Page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDrawnPercentage", "Pass", driver);

		} catch (AssertionError validateDrawnPercentage) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDrawnPercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDrawnPercentage_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDrawnPercentage.printStackTrace();
			node.fail(validateDrawnPercentage);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDrawnPercentage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDrawnPercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDrawnPercentage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDrawnPercentage.printStackTrace();
			node.fail(validateDrawnPercentage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_021
	@Test(priority = 19)
	public void validateUtilisationAmount() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the 'Utilisation' accurately represents the total amount across all facilities currently allocated to loans")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Utilisation Amount
			double utilisationAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.utilisationAmount);

			// Calling the loadDatabasePage function from FundingPage and Navigate to the
			// Funding Database Page
			FundingPage.loadDatabasePage();

			// Get the Sum of All the facility Allocated Amount column
			double allocatedAmountColumnSum = Utils.calculateSumOfList(FundingDatabasePO.allocatedAmountElements);

			// Assert that The Utilisation amount on Reporting Loans Page is Equal to the
			// Sum of All Facilities Allocated Amount
			IElementActions.assertEquals_usingDouble(node, driver, utilisationAmount, allocatedAmountColumnSum,
					"STEP1 : BUG : The Utilisation Amount on Reporting Loans Page " + utilisationAmount
							+ " is not Equal to the Sum of All Facilities Allocated Amount : "
							+ allocatedAmountColumnSum,
					"STEP1 : PASS : The Utilisation Amount on Reporting Loans Page " + utilisationAmount
							+ " is Equal to the Sum of All Facilities Allocated Amount : " + allocatedAmountColumnSum);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateUtilisationAmount", "Pass", driver);

		} catch (AssertionError validateUtilisationAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateUtilisationAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateUtilisationAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateUtilisationAmount.printStackTrace();
			node.fail(validateUtilisationAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateUtilisationAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateUtilisationAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateUtilisationAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateUtilisationAmount.printStackTrace();
			node.fail(validateUtilisationAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_022
	@Test(priority = 20)
	public void validateUtilisationPercentage() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the percentage utilisation is displayed in the bottom right-hand corner of the tile.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Utilisation Percentage
			double utilisationPercentage = Utils.getTextAndParseToDouble(ReportingLoansPO.utilisationPercentage);

			// Check the visibility of Utilisation Percenatge
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.utilisationPercentage,
					"STEP1 : BUG : The Utilisation Percentage is not coming in Utilisation Section on Summary Page",
					"STEP1 : EXPECTED : The Utilisation Percentage: " + utilisationPercentage
							+ " is coming in Utilisation Section on Summary Page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateUtilisationPercentage", "Pass", driver);

		} catch (AssertionError validateUtilisationPercentage) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateUtilisationPercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateUtilisationPercentage_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateUtilisationPercentage.printStackTrace();
			node.fail(validateUtilisationPercentage);
			Assert.fail();
			extent.flush();

		} catch (Exception validateUtilisationPercentage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateUtilisationPercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateUtilisationPercentage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateUtilisationPercentage.printStackTrace();
			node.fail(validateUtilisationPercentage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_023
	@Test(priority = 21)
	public void validateUtilisationPercentageCalculation() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the percentage utilisation is calculated correctly as per the formula [(% Utilisation = Utilisation/Drawn)]")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingUpdatesPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Utilisation Amount
			double utilisationAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.utilisationAmount);

			// Get the Drawn Amount
			double drawnAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.drawnAmount);

			// Get the Utilisation Percentage
			double utilisationPercentage = Utils.getTextAndParseToDouble(ReportingLoansPO.utilisationPercentage);

			// Calculate the Utilisation Percentage
			double expectedUtilisationPercentage = (utilisationAmount / drawnAmount) * 100;

			// Round up expectedUtilisationPercentage value
			double roundedValue = Math.round(expectedUtilisationPercentage * 10.0) / 10.0;
			String formattedValue = String.format("%.1f", roundedValue);

			// Assert the Utilisation Percentage
			IElementActions.assertEquals_usingDouble(node, driver, utilisationPercentage,
					Double.parseDouble(formattedValue),
					"STEP1 : BUG : The Utilisation Percentage : " + utilisationPercentage
							+ " is not same as calculated from (utilisationAmount/drawnAmount)*100 : "
							+ Double.parseDouble(formattedValue),
					"STEP1 : PASS : The Utilisation Percentage : " + utilisationPercentage
							+ "is same as calculated from (utilisationAmount/drawnAmount)*100 : "
							+ Double.parseDouble(formattedValue));

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateUtilisationPercentageCalculation", "Pass", driver);

		} catch (AssertionError validateUtilisationPercentageCalculation) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateUtilisationPercentageCalculation test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateUtilisationPercentageCalculation_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateUtilisationPercentageCalculation.printStackTrace();
			node.fail(validateUtilisationPercentageCalculation);
			Assert.fail();
			extent.flush();

		} catch (Exception validateUtilisationPercentageCalculation) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateUtilisationPercentageCalculation test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateUtilisationPercentageCalculation_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateUtilisationPercentageCalculation.printStackTrace();
			node.fail(validateUtilisationPercentageCalculation);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_024
	@Test(priority = 22)
	public void validateLoanNumber() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the number of loans")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the total number of loans
			int numberOfLoansInReporting = Utils.getTextAndParseToInt(ReportingLoansPO.numberOfLoans);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Find all the loan references
			List<WebElement> loanReferences = IElementActions.returnElements(node, driver,
					TreasuryPortfolioPO.loanReferences);

			// Get total oan number
			int expectedLoanNumber = loanReferences.size();

			// Assert the total number of loans
			IElementActions.assertEquals_usingDouble(node, driver, numberOfLoansInReporting, expectedLoanNumber,
					"STEP1 : BUG : The loan number in reporting is " + numberOfLoansInReporting
							+ " and its not equal to the loan number in portfolio " + expectedLoanNumber,
					"STEP1 : PASS : The loan number in reporting is " + numberOfLoansInReporting
							+ " and its equal to the loan number in portfolio " + expectedLoanNumber);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanNumber", "Pass", driver);

		} catch (AssertionError validateLoanNumber) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanNumber test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanNumber_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanNumber.printStackTrace();
			node.fail(validateLoanNumber);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanNumber) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanNumber test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanNumber_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanNumber.printStackTrace();
			node.fail(validateLoanNumber);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_025
	@Test(priority = 23)
	public void validateWAMaturity() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the Weighted Average Maturity is calculated as per the below formula:"
							+ "sumproduct(allocatedAmount, residualMaturity)/sum of total facility allocated amount ")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the wAMaturity to be visible
			node.log(Status.INFO, "STEP1 : Waiting for the wAMaturity to be visible");
			System.out.println("STEP1 : Waiting for the wAMaturity to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.wAMaturity);
			node.log(Status.INFO, "STEP2 : WAMaturity is visible");
			System.out.println("STEP2 : WAMaturity is visible");

			Thread.sleep(1000);
			// Get the wAMaturity
			String waMaturityValue = IElementActions.getElementText_usingXpath(node, driver,
					ReportingLoansPO.wAMaturity);
			System.out.println("waMaturityValue " + waMaturityValue);

			// Split the text by space
			String[] parts = waMaturityValue.split(" ");

			String actualWAMaturity = parts[0];

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the facility amount
			int facilityAmount = Utils.getTextAndParseToInt(ReportingLoansPO.facilityAmount);

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.repayment, ReportingLoansPO.repaymentHeaderText, "Repayment");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Scroll to the element
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, ReportingLoansPO.repaymentAmount);
			node.log(Status.INFO, "STEP3 : Scrolled to the element");
			System.out.println("STEP3 : Scrolled to the element");

			// Wait for the repayment amount to be visible
			node.log(Status.INFO, "STEP4 : Waiting for the repayment amount to be visible");
			System.out.println("STEP4 : Waiting for the repayment amount to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.repaymentAmount);
			node.log(Status.INFO, "STEP5 : Repayment amount is visible");
			System.out.println("STEP5 : Repayment amount is visible");

			// Get the repayment amount
			List<Integer> repaymentAmountValue = Utils
					.extractIntegerValuesFromElements(ReportingLoansPO.repaymentAmount);

			// Get the time to maturity
			List<Integer> timeToMaturityValue = Utils.extractElementsGreaterThanZero(ReportingLoansPO.timeToMaturity);

			// Calculate the sumproduct
			long sumProduct = Utils.calculateSumProduct(repaymentAmountValue, timeToMaturityValue);

			sumProduct = sumProduct / facilityAmount;

			String expectedCalculatedValue = String.valueOf(sumProduct);

			// Assert waMaturity
			IElementActions.assertEquals_usingString(node, driver, actualWAMaturity, expectedCalculatedValue,
					"BUG : The waMaturity : " + actualWAMaturity
							+ " is not equal to the expected calculated waMaturity : " + expectedCalculatedValue,
					"PASS : The waMaturity : " + actualWAMaturity + " is equal to the expected calculated waMaturity : "
							+ expectedCalculatedValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateWAMaturity", "Pass", driver);

		} catch (AssertionError validateWAMaturity) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateWAMaturity test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateWAMaturity_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateWAMaturity.printStackTrace();
			node.fail(validateWAMaturity);
			Assert.fail();
			extent.flush();

		} catch (Exception validateWAMaturity) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateWAMaturity test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateWAMaturity_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateWAMaturity.printStackTrace();
			node.fail(validateWAMaturity);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_026
	@Test(priority = 24)
	public void validateAverageLoanSizePercentage() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the Average Loan Size Percentage.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the average loan size percentage to be visible
			node.log(Status.INFO, "STEP1 : Waiting for the average loan size percentage to be visible");
			System.out.println("STEP1 : Waiting for the average loan size percentage to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.averageLoanSizePercentage);
			node.log(Status.INFO, "STEP2 : Average loan size percentage is visible");
			System.out.println("STEP2 : Average loan size percentage is visible");

			Thread.sleep(1000);
			// Get the average loan size percentage value
			double averageLoanSizePercentageValue = Utils
					.getTextAndParseToDouble(ReportingLoansPO.averageLoanSizePercentage);

			// Get the Number of Loans
			int numberOfLoans = Utils.getTextAndParseToInt(ReportingLoansPO.numberOfLoans);

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for page loading to Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Allocated Amount
			double allocatedAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.allocatedAmount);

			// Get the Drawn Amount
			double drawnAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.drawnAmountValue);

			// Calculate the Average Loan Size
			double averageLoanSize = allocatedAmount / Double.valueOf(numberOfLoans);

			double calculatedAverageLoanSizePercentageValue = (averageLoanSize / drawnAmount) * 100;

			// Format the values to one decimal place
			DecimalFormat df = new DecimalFormat("#.#");
			String formattedValue = df.format(calculatedAverageLoanSizePercentageValue);

			double expectedAverageLoanSizePercentageValue = Double.parseDouble(formattedValue);

			// Assert that Average Loan Size Percentage
			IElementActions.assertEquals_usingDouble(node, driver, averageLoanSizePercentageValue,
					expectedAverageLoanSizePercentageValue,
					"STEP3 : BUG : The average loan size percentage : " + averageLoanSizePercentageValue
							+ " is not equal to the calculated value ((allocatedAmount/numberOfLoans)/total drawn)*100 : "
							+ expectedAverageLoanSizePercentageValue,
					"STEP3 : PASS : The average loan size percentage : " + averageLoanSizePercentageValue
							+ " is equal to the calculated value ((allocatedAmount/numberOfLoans)/total drawn)*100 : "
							+ expectedAverageLoanSizePercentageValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAverageLoanSizePercentage", "Pass", driver);

		} catch (AssertionError validateAverageLoanSizePercentage) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAverageLoanSizePercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAverageLoanSizePercentage_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAverageLoanSizePercentage.printStackTrace();
			node.fail(validateAverageLoanSizePercentage);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAverageLoanSizePercentage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAverageLoanSizePercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAverageLoanSizePercentage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAverageLoanSizePercentage.printStackTrace();
			node.fail(validateAverageLoanSizePercentage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_027
	@Test(priority = 25)
	public void validateFacilityInterest() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the Facility Interest is correctly calculated as per below formula:"
							+ "FacilityinterestRate = (interestRate / sumDrawnAmount)*100")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the facility interest to be visible
			node.log(Status.INFO, "STEP1 : Waiting for the facility interest to be visible");
			System.out.println("STEP1 : Waiting for the facility interest to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.facilityInterest);
			node.log(Status.INFO, "STEP2 : Facility interest is visible");
			System.out.println("STEP2 : Facility interest is visible");

			Thread.sleep(1000);
			// Get the facility interest value
			double facilityInterestValue = Utils.getTextAndParseToDouble(ReportingLoansPO.facilityInterest);

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for page loading to Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Drawn Amount
			double drawnAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.drawnAmountValue);

			// Click on Loan Interest Tab
			Utils.clickOnTab(ReportingLoansPO.interest, ReportingLoansPO.allocationValuesInInterest, "Loan Interest");

			// Waiting for page loading to Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the repayment amount
			List<Double> allocationValues = Utils
					.extractDoubleValuesFromElements(ReportingLoansPO.allocationValuesInInterest);

			// Get the annual interest rate value
			List<Double> annualInterestRateValue = Utils
					.extractPercentageToValueFromElements(ReportingLoansPO.annualInterestRateInInterestTab);

			// Calculate the sumproduct
			double sumProductInterestRate = Utils.calculateSumProductForDouble(allocationValues,
					annualInterestRateValue);

			sumProductInterestRate = (sumProductInterestRate / drawnAmount) * 100;

			String calculatedValue = Utils.getDecimalOneDigit(sumProductInterestRate);

			double expectedCalculatedValue = Double.parseDouble(calculatedValue);

			// Assert facility interest value
			IElementActions.assertEquals_usingDouble(node, driver, facilityInterestValue, expectedCalculatedValue,
					"BUG : The facility interest : " + facilityInterestValue
							+ "is not equal to the expected calculated facility interest : " + expectedCalculatedValue,
					"PASS : The facility interest : " + facilityInterestValue
							+ " is equal to the expected calculated facility interest : " + expectedCalculatedValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityInterest", "Pass", driver);

		} catch (AssertionError validateFacilityInterest) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityInterest test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFacilityInterest_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityInterest.printStackTrace();
			node.fail(validateFacilityInterest);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityInterest) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityInterest test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFacilityInterest_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityInterest.printStackTrace();
			node.fail(validateFacilityInterest);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_028
	@Test(priority = 26)
	public void validateTotalAmountsDuringTermination() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately calculates the total amount being taken out by investors during the termination process.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the terminating amount to be visible
			node.log(Status.INFO, "STEP1 : Waiting for the terminating amount to be visible");
			System.out.println("STEP1 : Waiting for the terminating amount to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.facilityInterest);
			node.log(Status.INFO, "STEP2 : Terminating amount is visible");
			System.out.println("STEP2 : Terminating amount interest is visible");

			Thread.sleep(1000);
			// Get the terminating value
			double terminatingAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.terminatingValue);

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for page loading to Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			WebElement facilityDropdown = IElementActions.returnElement(node, driver, ReportingLoansPO.facilityFilter);

			// Assuming node is the WebElement representing the dropdown
			Select dropdown = new Select(facilityDropdown);

			// Get all options from the dropdown
			List<WebElement> options = dropdown.getOptions();

			// Array to store facility amounts
			List<Integer> facilityAmounts = new ArrayList<>();

			// Initialize the variable to store the sum
			double sum = 0;

			// Loop through each option
			for (WebElement option : options) {
				// Select the option
				dropdown.selectByVisibleText(option.getText());

				// Wait for the facility amount to be visible
				IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.facilityAmount);

				boolean checkElementPresence = IElementActions.isElementAvailable(node, driver,
						ReportingLoansPO.terminationInLoanPortfolio);

				if (checkElementPresence) {

					// Get the facility amount after selecting the option
					int facilityAmount = Utils.getTextAndParseToInt(ReportingLoansPO.facilityAmount);

					sum += facilityAmount;

					// Add the facility amount to the array
					facilityAmounts.add(facilityAmount);
				}
			}

			// Assert terminating amount
			IElementActions.assertEquals_usingDouble(node, driver, terminatingAmount, sum,
					"BUG : The terminating amount : " + terminatingAmount
							+ " is not equal to the sum of the termination facility, facility amount" + sum,
					"PASS : The terminating amount : " + terminatingAmount
							+ " is equal to the sum of the termination facility, facility amount" + sum);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateTotalAmountsDuringTermination", "Pass", driver);

		} catch (AssertionError validateTotalAmountsDuringTermination) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateTotalAmountsDuringTermination test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateTotalAmountsDuringTermination_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalAmountsDuringTermination.printStackTrace();
			node.fail(validateTotalAmountsDuringTermination);
			Assert.fail();
			extent.flush();

		} catch (Exception validateTotalAmountsDuringTermination) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateTotalAmountsDuringTermination test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateTotalAmountsDuringTermination_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalAmountsDuringTermination.printStackTrace();
			node.fail(validateTotalAmountsDuringTermination);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_029
	@Test(priority = 27)
	public void validateFrozenTerminationEffectiveDrawnAmount() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the 'Frozen Termination Effective Drawn Amount' is the sum of all the loan facility Termination effective drawn amounts. s")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the facility filter to be visible
			node.log(Status.INFO, "STEP1 : Waiting for the facility filter to be visible");
			System.out.println("STEP1 : Waiting for the facility filter to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.facilityFilter);
			node.log(Status.INFO, "STEP2 : Facility filter is visible");
			System.out.println("STEP2 : Facility filter is visible");

			// Select the Value from Facility Filter dropdown
			IElementActions.selectValueFromDropdown(node, driver, ReportingLoansPO.facilityFilter, "ALL");

			// Wait for the frozen drawn to be visible
			node.log(Status.INFO, "STEP3 : Waiting for the facility drawn to be visible");
			System.out.println("STEP3 : Waiting for the facility drawn to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.frozenDrawn);
			node.log(Status.INFO, "STEP4 : Facility drawn is visible");
			System.out.println("STEP4 : Facility drawn is visible");

			// Get the frozen drawn value
			double frozenDrawn = Utils.getTextAndParseToDouble(ReportingLoansPO.frozenDrawn);

			// Call the loadDatabasePage function from the FundingPage
			FundingPage.loadDatabasePage();

			// Check cross icon is available or not
			boolean checkCrossIcon = IElementActions.isElementAvailable(node, driver, UtilsPO.headerSearchCrossIcon);

			// If cross icon is present, click on it to clear the search
			if (checkCrossIcon) {
				// Click on the cross icon to clear the search
				IElementActions.clickelement_usingXpath(node, driver, UtilsPO.headerSearchCrossIcon);
				node.log(Status.INFO, "STEP_0.001 : clicked on the cross icon");
				System.out.println("STEP_0.001 : clicked on the cross icon");
			}

			// Wait for the edit icon to be visible and clickable
			node.log(Status.INFO, "STEP5 : Waiting for the edit icon visible and clickable");
			System.out.println("STEP5 : Waiting for the edit icon to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, UtilsPO.editIcon);
			IWaitStrategy.WaitUntilElementClickable(node, driver, UtilsPO.editIcon);
			node.log(Status.INFO, "STEP6 : Edit icon is visible and clickable");
			System.out.println("STEP6 : Edit icon is visible and clickable");

			// Create locator based on the provided status
			String dropdownOption = IElementActions.createDynamicLocatorString(FundingDatabasePO.dropdownOption,
					"locator", "Termination Effective");

			// Clear result and select value from dropdown
			Utils.selectValueInDropdown(FundingDatabasePO.statusDropdown, dropdownOption);

			// Scroll vertically and horizontally to access loan table exclude checkbox
			Utils.scrollVerticalAndHorizontalToAccessTable(FundingDatabasePO.drawnSearchBoxMin,
					FundingDatabasePO.drawnSearchBoxMin, FundingDatabasePO.drawnElements);

			Thread.sleep(1000);
			// Get the drawn amount
			double drawntAmountValue = Utils.calculateSumOfList(FundingDatabasePO.drawnElements);

			// Assert frozen drawn
			IElementActions.assertEquals_usingDouble(node, driver, frozenDrawn, drawntAmountValue,
					"BUG : The frozen drawn : " + frozenDrawn
							+ " is not equal to the sum of the drawn amount of facility having Termination Effective status "
							+ drawntAmountValue,
					"PASS : The frozen drawn : " + frozenDrawn
							+ " is equal to the sum of the drawn amount of facility having Termination Effective status "
							+ drawntAmountValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFrozenTerminationEffectiveDrawnAmount", "Pass", driver);

		} catch (AssertionError validateFrozenTerminationEffectiveDrawnAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFrozenTerminationEffectiveDrawnAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFrozenTerminationEffectiveDrawnAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFrozenTerminationEffectiveDrawnAmount.printStackTrace();
			node.fail(validateFrozenTerminationEffectiveDrawnAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFrozenTerminationEffectiveDrawnAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFrozenTerminationEffectiveDrawnAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFrozenTerminationEffectiveDrawnAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFrozenTerminationEffectiveDrawnAmount.printStackTrace();
			node.fail(validateFrozenTerminationEffectiveDrawnAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_030
	@Test(priority = 28)
	public void validateFrozenTerminationEffectiveAllocatedAmount() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the 'Frozen Termination Effective Allocated Amount' is the sum of all the loan facility Allocated amounts. ")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the facility filter to be visible
			node.log(Status.INFO, "STEP1 : Waiting for the facility filter to be visible");
			System.out.println("STEP1 : Waiting for the facility filter to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.facilityFilter);
			node.log(Status.INFO, "STEP2 : Facility filter is visible");
			System.out.println("STEP2 : Facility filter is visible");

			// Select the Value from Facility Filter dropdown
			IElementActions.selectValueFromDropdown(node, driver, ReportingLoansPO.facilityFilter, "ALL");

			// Wait for the frozen allocated to be visible
			node.log(Status.INFO, "STEP3 : Waiting for the facility allocated to be visible");
			System.out.println("STEP3 : Waiting for the facility allocated to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.frozenAllocated);
			node.log(Status.INFO, "STEP4 : Facility allocated is visible");
			System.out.println("STEP4 : Facility allocated is visible");

			// Get the frozen allocated value
			double frozenAllocated = Utils.getTextAndParseToDouble(ReportingLoansPO.frozenAllocated);

			// Call the loadDatabasePage function from the FundingPage
			FundingPage.loadDatabasePage();

			// Check cross icon is available or not
			boolean checkCrossIcon = IElementActions.isElementAvailable(node, driver, UtilsPO.headerSearchCrossIcon);

			// If cross icon is present, click on it to clear the search
			if (checkCrossIcon) {
				// Click on the cross icon to clear the search
				IElementActions.clickelement_usingXpath(node, driver, UtilsPO.headerSearchCrossIcon);
				node.log(Status.INFO, "STEP_0.001 : clicked on the cross icon");
				System.out.println("STEP_0.001 : clicked on the cross icon");
			}

			// Wait for the edit icon to be visible and clickable
			node.log(Status.INFO, "STEP5 : Waiting for the edit icon visible and clickable");
			System.out.println("STEP5 : Waiting for the edit icon to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, UtilsPO.editIcon);
			IWaitStrategy.WaitUntilElementClickable(node, driver, UtilsPO.editIcon);
			node.log(Status.INFO, "STEP6 : Edit icon is visible and clickable");
			System.out.println("STEP6 : Edit icon is visible and clickable");

			// Create locator based on the provided status
			String dropdownOption = IElementActions.createDynamicLocatorString(FundingDatabasePO.dropdownOption,
					"locator", "Termination Effective");

			// Clear result and select value from dropdown
			Utils.selectValueInDropdown(FundingDatabasePO.statusDropdown, dropdownOption);

			// Scroll vertically and horizontally to access loan table exclude checkbox
			Utils.scrollVerticalAndHorizontalToAccessTable(FundingDatabasePO.allocatedAmountSearchBoxMin,
					FundingDatabasePO.allocatedAmountSearchBoxMin, FundingDatabasePO.allocatedAmountElements);

			Thread.sleep(1000);
			// Get the allocated amount
			double allocatedAmountValue = Utils.calculateSumOfList(FundingDatabasePO.allocatedAmountElements);

			// Assert frozen allocated
			IElementActions.assertEquals_usingDouble(node, driver, frozenAllocated, allocatedAmountValue,
					"BUG : The frozen allocated : " + frozenAllocated
							+ " is not equal to the sum of the allocated amount of facility having Termination Effective status "
							+ allocatedAmountValue,
					"PASS : The frozen allocated : " + frozenAllocated
							+ " is equal to the sum of the allocated amount of facility having Termination Effective status "
							+ allocatedAmountValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFrozenTerminationEffectiveAllocatedAmount", "Pass",
					driver);

		} catch (AssertionError validateFrozenTerminationEffectiveAllocatedAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFrozenTerminationEffectiveAllocatedAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFrozenTerminationEffectiveAllocatedAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFrozenTerminationEffectiveAllocatedAmount.printStackTrace();
			node.fail(validateFrozenTerminationEffectiveAllocatedAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFrozenTerminationEffectiveAllocatedAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFrozenTerminationEffectiveAllocatedAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFrozenTerminationEffectiveAllocatedAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFrozenTerminationEffectiveAllocatedAmount.printStackTrace();
			node.fail(validateFrozenTerminationEffectiveAllocatedAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_031
	@Test(priority = 29)
	public void validateVisibilityOfFrozenDrawnAndAllocated() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system correctly calculates the difference between the 'Frozen' state and the 'Drawn' amount as the sum of termination_effective_drawn_amount.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the frozen allocated to be visible
			node.log(Status.INFO, "STEP1 : Waiting for the facility allocated to be visible");
			System.out.println("STEP1 : Waiting for the facility allocated to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.frozenAllocated);
			node.log(Status.INFO, "STEP2 : Facility allocated is visible");
			System.out.println("STEP2 : Facility allocated is visible");

			// Check the visibility of frozen allocated
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.frozenAllocatedText,
					"STEP3 : BUG: Frozen allocated is not displayed in summary tab of reporting loans",
					"STEP3 : EXPECTED: Frozen allocated is displayed in summary tab of reporting loans");

			// Check the visibility of frozen drawn
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.frozenDrawnText,
					"STEP4 : BUG: Frozen drawn is not displayed in summary tab of reporting loans",
					"STEP4 : EXPECTED: Frozen drawn is displayed in summary tab of reporting loans");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateVisibilityOfFrozenDrawnAndAllocated", "Pass", driver);

		} catch (AssertionError validateVisibilityOfFrozenDrawnAndAllocated) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateVisibilityOfFrozenDrawnAndAllocated test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateVisibilityOfFrozenDrawnAndAllocated_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateVisibilityOfFrozenDrawnAndAllocated.printStackTrace();
			node.fail(validateVisibilityOfFrozenDrawnAndAllocated);
			Assert.fail();
			extent.flush();

		} catch (Exception validateVisibilityOfFrozenDrawnAndAllocated) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateVisibilityOfFrozenDrawnAndAllocated test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateVisibilityOfFrozenDrawnAndAllocated_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateVisibilityOfFrozenDrawnAndAllocated.printStackTrace();
			node.fail(validateVisibilityOfFrozenDrawnAndAllocated);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_032
	@Test(priority = 30)
	public void validateWeightedAverageLTV() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the Weighted Average LTV is correctly calculated as per below formula:"
							+ "WA LTV = SUMPRODUCT(LTV, Allocation)/Allocated of the loans")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the wALTV to be visible
			node.log(Status.INFO, "STEP1 : Waiting for the wALTV to be visible");
			System.out.println("STEP1 : Waiting for the wALTV to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.wALTVValue);
			node.log(Status.INFO, "STEP2 : WALTV is visible");
			System.out.println("STEP2 : WALTV is visible");

			// Get the deviation value from Excel
			double deviatedValue = Double.parseDouble(getDataFromExcel(12));

			Thread.sleep(1000);

			// Get the WALTV value
			double WALTV = Utils.getTextAndParseToDouble(ReportingLoansPO.wALTVValue);

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for page loading to Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Allocated Amount
			double allocatedAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.allocatedAmount);

			// Scroll to the element
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, ReportingLoansPO.currentLoanAmountSortIcon);
			node.log(Status.INFO, "STEP3 : Scrolled to the element");
			System.out.println("STEP3 : Scrolled to the element");

			// Wait for the sort icon to be visible and clickable
			node.log(Status.INFO, "STEP4 : Waiting for the LTV column to be visible");
			System.out.println("STEP4 : Waiting for the  LTV column to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.lTVColumnAllValues);
			node.log(Status.INFO, "STEP5 :  LTV column is visible");
			System.out.println("STEP5 : LTV column is visible");

			// Retrieve the LTV column values
			List<Double> LTVColumnAllValues = Utils
					.extractPercentageToValueFromElements(ReportingLoansPO.lTVColumnAllValues);

			// Retrieve the allocation values
			List<Double> allocationAllValues = Utils
					.extractDoubleValuesFromElements(ReportingLoansPO.allocationAllValues);

			// Calculate the sumproduct
			double sumProductWALTV = Utils.calculateSumProductForDouble(LTVColumnAllValues, allocationAllValues);

			sumProductWALTV = (sumProductWALTV / allocatedAmount) * 100;

			String calculatedValue = Utils.getDecimalOneDigit(sumProductWALTV);

			double expectedCalculatedValue = Double.parseDouble(calculatedValue);

			// Assert WALTV value
			Assert.assertEquals(WALTV, expectedCalculatedValue, deviatedValue,
					"Deviation is greater than expected value and the WALTV : " + WALTV
							+ " is not equal to the expected calculated WALTV : " + expectedCalculatedValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateWeightedAverageLTV", "Pass", driver);

		} catch (AssertionError validateWeightedAverageLTV) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateWeightedAverageLTV test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateWeightedAverageLTV_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateWeightedAverageLTV.printStackTrace();
			node.fail(validateWeightedAverageLTV);
			Assert.fail();
			extent.flush();

		} catch (Exception validateWeightedAverageLTV) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateWeightedAverageLTV test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateWeightedAverageLTV_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateWeightedAverageLTV.printStackTrace();
			node.fail(validateWeightedAverageLTV);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_033
	@Test(priority = 31)
	public void validateFirstChargePercentage() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the calculation of the 1st Charge Percentage.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Waiting for page loading to Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Wait for the wALTV to be visible
			node.log(Status.INFO, "STEP1 : Waiting for the first charge to be visible");
			System.out.println("STEP1 : Waiting for the first charge to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.firstChargeValue);
			node.log(Status.INFO, "STEP2 : First charge is visible");
			System.out.println("STEP2 : First charge is visible");

			// Get the deviation value from Excel
			double deviatedValue = Double.parseDouble(getDataFromExcel(12));

			Thread.sleep(1000);

			// Get the first charge value
			double firstChargeValue = Utils.getTextAndParseToDouble(ReportingLoansPO.firstChargeValue);

			Thread.sleep(1000);
			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for page loading to Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Allocated Amount
			double allocatedAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.allocatedAmount);

			// Scroll to the element
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, ReportingLoansPO.allocationAllValues);
			node.log(Status.INFO, "STEP3 : Scrolled to the element");
			System.out.println("STEP3 : Scrolled to the element");

			// Wait for the allocation to be visible
			node.log(Status.INFO, "STEP4 : Waiting for the allocation column to be visible");
			System.out.println("STEP4 : Waiting for the allocation column to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.allocationAllValues);
			node.log(Status.INFO, "STEP5 :  Allocation column is visible");
			System.out.println("STEP5 : Allocation column is visible");

			// Retrieve the allocation values
			List<Double> allocationAllValues = Utils
					.extractDoubleValuesFromElements(ReportingLoansPO.allocationAllValues);

			// Retrieve the charge values
			List<String> chargeValues = Utils.extractTextFromElements(ReportingLoansPO.chargeAllValues);

			String expectedChargeValue = "1st";
			double sum = 0;
			for (int i = 0; i < chargeValues.size(); i++) {

				String chargeValue = chargeValues.get(i);

				// Normalize both strings by converting to lowercase and trimming whitespace
				String normalizedStr1 = chargeValue.toLowerCase().trim();
				String normalizedStr2 = expectedChargeValue.toLowerCase().trim();

				chargeValue = chargeValue.trim();
				Double allocationAllValue = allocationAllValues.get(i);

				if (normalizedStr1.equals(normalizedStr2)) {
					sum += allocationAllValue;
				}
			}

			double calculatedValues = (sum * 100) / allocatedAmount;

			String formattedValue = Utils.getDecimalOneDigit(calculatedValues);

			double calculatedValue = Double.parseDouble(formattedValue);

			// Assert first charge value
			Assert.assertEquals(firstChargeValue, calculatedValue, deviatedValue,
					"Deviation is greater than expected value and the first charge value : " + firstChargeValue
							+ " is not equal to the expected calculated first charge value : " + calculatedValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFirstChargePercentage", "Pass", driver);

		} catch (AssertionError validateFirstChargePercentage) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFirstChargePercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFirstChargePercentage_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFirstChargePercentage.printStackTrace();
			node.fail(validateFirstChargePercentage);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFirstChargePercentage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFirstChargePercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFirstChargePercentage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFirstChargePercentage.printStackTrace();
			node.fail(validateFirstChargePercentage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_034
	@Test(priority = 32)
	public void validateMaxLoanSizePercentage() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the calculation of the Max Loan Size Percentage.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the max loan size to be visible
			node.log(Status.INFO, "STEP1 : Waiting for the max loan size to be visible");
			System.out.println("STEP1 : Waiting for the max loan size to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.maxLoanSizeValue);
			node.log(Status.INFO, "STEP2 : Max loan size is visible");
			System.out.println("STEP2 : Max loan size is visible");

			Thread.sleep(1000);

			// Get the max loan size value
			double maxLoanSize = Utils.getTextAndParseToDouble(ReportingLoansPO.maxLoanSizeValue);

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for page loading to Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Drawn Amount
			double drawnAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.drawnAmountValue);

			// Get the Max Loan Amount
			double maxLoanAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.maxLoanAmount);

			double calculatedMaxLoanAmountPercentage = (maxLoanAmount / drawnAmount) * 100;

			String formattedText = Utils.getDecimalOneDigit(calculatedMaxLoanAmountPercentage);

			double calculatedMaxLoanAmountPercentageValue = Double.parseDouble(formattedText);

			// Assert max loan size percentage
			IElementActions.assertEquals_usingDouble(node, driver, maxLoanSize, calculatedMaxLoanAmountPercentageValue,
					"STEP3 : BUG : The max loan size percentage : " + maxLoanSize
							+ " is not equal to the calculated value (maxLoanAmount / drawnAmount) * 100 : "
							+ calculatedMaxLoanAmountPercentageValue,
					"STEP3 : PASS : The max loan size percentage : " + maxLoanSize
							+ " is not equal to the calculated value (maxLoanAmount / drawnAmount) * 100 : "
							+ calculatedMaxLoanAmountPercentageValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateMaxLoanSizePercentage", "Pass", driver);

		} catch (AssertionError validateMaxLoanSizePercentage) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateMaxLoanSizePercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateMaxLoanSizePercentage_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMaxLoanSizePercentage.printStackTrace();
			node.fail(validateMaxLoanSizePercentage);
			Assert.fail();
			extent.flush();

		} catch (Exception validateMaxLoanSizePercentage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateMaxLoanSizePercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateMaxLoanSizePercentage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMaxLoanSizePercentage.printStackTrace();
			node.fail(validateMaxLoanSizePercentage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_035
	@Test(priority = 33)
	public void validateBridgeLoanInterestPercentage() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the calculation of the Bridge Loan Interest %."
					+ "loanInterestAverage = sumLoanInterest / numLoanInterest"
					+ "sumLoanInterest -> sum of annualInterestrate of all loans"
					+ "numLoanInterest -> number of loans").assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Wait for the bridge loan interest to be visible
			node.log(Status.INFO, "STEP1 : Waiting for the bridge loan interest to be visible");
			System.out.println("STEP1 : Waiting for the bridge loan interest to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.bridgeLoanInterestValue);
			node.log(Status.INFO, "STEP2 : Bridge loan interest is visible");
			System.out.println("STEP2 : Bridge loan interest is visible");

			Thread.sleep(1000);

			// Get the total number of loans
			double numberOfLoansInReporting = Utils.getTextAndParseToDouble(ReportingLoansPO.numberOfLoans);

			// Get the bridge loan interest value
			double bridgeLoanInterest = Utils.getTextAndParseToDouble(ReportingLoansPO.bridgeLoanInterestValue);

			// Click on Loan Interest Tab
			Utils.clickOnTab(ReportingLoansPO.interest, ReportingLoansPO.allocationValuesInInterest, "Loan Interest");

			// Waiting for page loading to Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the annual interest rate value
			double annualInterestRateValue = Utils.calculateSumOfList(ReportingLoansPO.annualInterestRateInInterestTab);

			// Calculate the bridge loan interest value
			double calculatedBridgeLoanInterest = annualInterestRateValue / numberOfLoansInReporting;

			String calculatedValue = Utils.getDecimalOneDigit(calculatedBridgeLoanInterest);

			double expectedCalculatedValue = Double.parseDouble(calculatedValue);

			// Assert value
			IElementActions.assertEquals_usingDouble(node, driver, bridgeLoanInterest, expectedCalculatedValue,
					"BUG : The bridge loan interest value : " + bridgeLoanInterest
							+ "is not equal to the expected calculated bridge loan interest % : "
							+ expectedCalculatedValue,
					"PASS : The bridge loan interest value : " + bridgeLoanInterest
							+ " is equal to the expected calculated bridge loan interest % : "
							+ expectedCalculatedValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateBridgeLoanInterestPercentage", "Pass", driver);

		} catch (AssertionError validateBridgeLoanInterestPercentage) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateBridgeLoanInterestPercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBridgeLoanInterestPercentage_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBridgeLoanInterestPercentage.printStackTrace();
			node.fail(validateBridgeLoanInterestPercentage);
			Assert.fail();
			extent.flush();

		} catch (Exception validateBridgeLoanInterestPercentage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateBridgeLoanInterestPercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBridgeLoanInterestPercentage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBridgeLoanInterestPercentage.printStackTrace();
			node.fail(validateBridgeLoanInterestPercentage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_036
	@Test(priority = 34)
	public void validateSumOfInterestReturnInPercentage() throws IOException {
		try {
			extenttest = extent
					.createTest(
							"Verify that the initial display of the 'Sum of Interest Return' is in percentage format.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();
			IElementActions.pageRefresh();

			// Wait for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Wait for the sum of interest return toggle to be visible
			node.log(Status.INFO, "STEP1 : Waiting for the sum of interest return toggle to be visible");
			System.out.println("STEP1 : Waiting for thesum of interest return toggle to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.percentageToggleOfSumOfInterest);
			node.log(Status.INFO, "STEP2 : Sum of interest return toggle is visible");
			System.out.println("STEP2 : Sum of interest return toggle is visible");

			Thread.sleep(1000);
			// Get toggle status
			String isActive = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					ReportingLoansPO.percentageToggleOfSumOfInterest, "aria-pressed");

			// Check toggle status
			if (isActive.contains("true")) {
				Assert.assertTrue(true,
						"The 'Sum of Interest Return' is initially displayed in percentage format i.e % toggle is active "
								+ isActive);
				System.out.println(
						"The 'Sum of Interest Return' is initially displayed in percentage format i.e % toggle is active "
								+ isActive);
				node.log(Status.PASS,
						"The 'Sum of Interest Return' is initially displayed in percentage format i.e % toggle is active "
								+ isActive);
			} else {
				Assert.assertTrue(false,
						"The 'Sum of Interest Return' is initially displayed in percentage format i.e % toggle is active "
								+ isActive);
				System.out.println(
						"The 'Sum of Interest Return' is initially displayed in percentage format i.e % toggle is active "
								+ isActive);
				node.log(Status.FAIL,
						"The 'Sum of Interest Return' is initially displayed in percentage format i.e % toggle is active "
								+ isActive);
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateSumOfInterestReturnInPercentage", "Pass", driver);

		} catch (AssertionError validateSumOfInterestReturnInPercentage) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateSumOfInterestReturnInPercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateSumOfInterestReturnInPercentager_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSumOfInterestReturnInPercentage.printStackTrace();
			node.fail(validateSumOfInterestReturnInPercentage);
			Assert.fail();
			extent.flush();

		} catch (Exception validateSumOfInterestReturnInPercentage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateSumOfInterestReturnInPercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateSumOfInterestReturnInPercentage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSumOfInterestReturnInPercentage.printStackTrace();
			node.fail(validateSumOfInterestReturnInPercentage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_037
	@Test(priority = 35)
	public void validateToggleBetweenPercentageOrCashAmount() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the user can toggle between percentage or cash amount.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();
			IElementActions.pageRefresh();

			// Wait for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Wait for the sum of interest return toggle to be visible
			node.log(Status.INFO, "STEP1 : Waiting for the sum of interest return toggle to be visible");
			System.out.println("STEP1 : Waiting for thesum of interest return toggle to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.percentageToggleOfSumOfInterest);
			node.log(Status.INFO, "STEP2 : Sum of interest return toggle is visible");
			System.out.println("STEP2 : Sum of interest return toggle is visible");

			Thread.sleep(1000);
			// Get percentage toggle status
			String getPercentageToggleStatus = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					ReportingLoansPO.percentageToggleOfSumOfInterest, "aria-pressed");

			// Get cash toggle status
			String getCashToggleOfSumOfInterestToggleStatus = IElementActions.getElementTextFromAttribute_usingXpath(
					node, driver, ReportingLoansPO.cashToggleOfSumOfInterest, "aria-pressed");

			// Click on the cash toggle button
			IElementActions.clickelement_usingXpath(node, driver, ReportingLoansPO.cashToggleOfSumOfInterest);
			node.log(Status.INFO, "STEP3 : Clicked on the cash toggle button");
			System.out.println("STEP3 : Clicked on the cash toggle button");

			Thread.sleep(1000);
			// Get percentage toggle status
			String getPercentageStatus = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					ReportingLoansPO.percentageToggleOfSumOfInterest, "aria-pressed");

			// Get cash toggle status
			String getCashStatus = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					ReportingLoansPO.cashToggleOfSumOfInterest, "aria-pressed");

			// Check toggle status
			if (getCashStatus.contains("true") && getPercentageStatus.contains("false")) {
				Assert.assertTrue(true, "The user able to toggle from percentage to cash i.e percentage "
						+ getPercentageStatus + " and cash " + getCashStatus);
				System.out.println("The user able to toggle from percentage to cash i.e percentage "
						+ getPercentageStatus + " and cash " + getCashStatus);
				node.log(Status.PASS, "The user able to toggle from percentage to cash i.e percentage "
						+ getPercentageStatus + " and cash " + getCashStatus);
			} else {
				Assert.assertTrue(false, "The user toggle status from percentage " + getPercentageStatus + " to cash "
						+ getCashStatus + " is not correct");
				System.out.println("The user toggle status from percentage " + getPercentageStatus + " to cash "
						+ getCashStatus + " is not correct");
				node.log(Status.FAIL, "The user toggle status from percentage " + getPercentageStatus + " to cash "
						+ getCashStatus + " is not correct");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateToggleBetweenPercentageOrCashAmount", "Pass", driver);

		} catch (AssertionError validateToggleBetweenPercentageOrCashAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateToggleBetweenPercentageOrCashAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateToggleBetweenPercentageOrCashAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateToggleBetweenPercentageOrCashAmount.printStackTrace();
			node.fail(validateToggleBetweenPercentageOrCashAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateToggleBetweenPercentageOrCashAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateToggleBetweenPercentageOrCashAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateToggleBetweenPercentageOrCashAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateToggleBetweenPercentageOrCashAmount.printStackTrace();
			node.fail(validateToggleBetweenPercentageOrCashAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_038
	@Test(priority = 36)
	public void validateSumOfInterestReturn() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the 'Sum of Interest Return' can be accurately displayed in cash amount")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();
			IElementActions.pageRefresh();

			// Get facility reference
			String facilityReference = getDataFromExcel(70);

			// Deviation
			double deviatedValue = Double.parseDouble(getDataFromExcel(12));

			// Create Dynamic Facility Reference Locator
			String facilityReferenceLocator = IElementActions
					.createDynamicLocatorString(ReportingLoansPO.facilityOptions, "locatorValue", facilityReference);

			// Wait for the visibility of the facility reference dropdown
			node.log(Status.INFO,
					"STEP1 : Waiting for the visibility of the facility reference dropdown to be clickable and visible");
			System.out.println(
					"STEP1 : Waiting for the visibility of the facility reference dropdown to be clickable and visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.facilityFilterBox);
			IWaitStrategy.WaitUntilElementClickable(node, driver, ReportingLoansPO.facilityFilterBox);
			node.log(Status.INFO, "STEP2 : Facility reference dropdown is clickable and visible");
			System.out.println("STEP2 : Facility reference dropdown is clickable and visible");

			// Click on the facility reference dropdown
			IElementActions.clickelement_usingXpath(node, driver, ReportingLoansPO.facilityFilterBox);
			node.log(Status.INFO, "STEP3 : Clicked on the facility reference dropdown");
			System.out.println("STEP3 : Clicked on the facility reference dropdown");

			// Wait for the visibility of the facility reference option
			node.log(Status.INFO, "STEP4 : Waiting for the visibility of the facility reference option");
			System.out.println("STEP4 : Waiting for the visibility of the facility reference option");
			IWaitStrategy.waitForVisiblity(node, driver, facilityReferenceLocator);
			node.log(Status.INFO, "STEP5 : Facility reference option is visible");
			System.out.println("STEP5 : Facility reference option is visible");

			// Get the option value
			String optionValue = IElementActions.getElementText_usingXpath(node, driver, facilityReferenceLocator);

			// Select loan from loan reference dropdown
			IElementActions.selectValueFromDropdown(node, driver, ReportingLoansPO.facilityFilter, optionValue);

			Thread.sleep(2000);
			// Click on the cash toggle button
			IElementActions.clickelement_usingXpath(node, driver, ReportingLoansPO.cashToggleOfSumOfInterest);
			node.log(Status.INFO, "STEP6 : Clicked on the cash toggle button");
			System.out.println("STEP6 : Clicked on the cash toggle button");

			Thread.sleep(1000);
			// Get percentage toggle status
			String getPercentageStatus = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					ReportingLoansPO.percentageToggleOfSumOfInterest, "aria-pressed");

			// Get cash toggle status
			String getCashStatus = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					ReportingLoansPO.cashToggleOfSumOfInterest, "aria-pressed");

			// Check toggle status
			if (getCashStatus.contains("true") && getPercentageStatus.contains("false")) {
				Assert.assertTrue(true, "The user able to toggle from percentage to cash i.e percentage "
						+ getPercentageStatus + " and cash " + getCashStatus);
				System.out.println("The user able to toggle from percentage to cash i.e percentage "
						+ getPercentageStatus + " and cash " + getCashStatus);
				node.log(Status.PASS, "The user able to toggle from percentage to cash i.e percentage "
						+ getPercentageStatus + " and cash " + getCashStatus);
			} else {
				Assert.assertTrue(false, "The user toggle status from percentage " + getPercentageStatus + " to cash "
						+ getCashStatus + " is not correct");
				System.out.println("The user toggle status from percentage " + getPercentageStatus + " to cash "
						+ getCashStatus + " is not correct");
				node.log(Status.FAIL, "The user toggle status from percentage " + getPercentageStatus + " to cash "
						+ getCashStatus + " is not correct");
			}

			// Get the value
			String firstMonthFirstYearValue = IElementActions.getElementText_usingXpath(node, driver,
					ReportingLoansPO.firstMonthFirstYearValueInSumOfInterest);

			// Call the loadDatabasePage function from the FundingPage
			FundingPage.loadDatabasePage();

			// Search record based on the provide loan reference and open it
			Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, FundingNewFacilityPO.reference,
					facilityReference, UtilsPO.editIcon, FundingNewFacilityPO.editLoanFacilityText);

			// Click on account balance
			Utils.waitAndClickOnTab(FundingNewFacilityPO.accountBalancesTab, FundingNewFacilityPO.balanceText,
					"Facility Account Balances");

			// Click on the interest button
			IElementActions.clickelement_usingXpath(node, driver, FundingNewFacilityPO.interestUnderAccountBalance);
			node.log(Status.INFO, "STEP7 : Clicked on the interest button");
			System.out.println("STEP7 : Clicked on the cash interest button");

			// Click on the 1Y button
			IElementActions.clickelement_usingXpath(node, driver, FundingNewFacilityPO.oneYear);
			node.log(Status.INFO, "STEP8 : Clicked on the 1Y button");
			System.out.println("STEP8 : Clicked on the 1Y button");

			String amount = firstMonthFirstYearValue.trim();

			// create Dynamic Locator for Asset Balance Opening Amount
			String assetBalanceOpeningAmountLocator = IElementActions.createDynamicLocatorString(
					FundingNewFacilityPO.dynamicInterestAmountValue, "locatorValue", amount);

			// Get the value
			String expectedFirstMonthFirstYearValue = IElementActions.getElementText_usingXpath(node, driver,
					assetBalanceOpeningAmountLocator);

			// Assert the fsum of interest value
			IElementActions.assertEquals_usingString(node, driver, firstMonthFirstYearValue,
					expectedFirstMonthFirstYearValue,
					"STEP9 : BUG : The sum of interest value in reporting loans " + firstMonthFirstYearValue
							+ " is not equal to expected sum of interest value in facility account balance "
							+ expectedFirstMonthFirstYearValue,
					"STEP9 : PASS : The sum of interest value in reporting loans " + firstMonthFirstYearValue
							+ " is equal to expected sum of interest value in facility account balance "
							+ expectedFirstMonthFirstYearValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateSumOfInterestReturn", "Pass", driver);

		} catch (AssertionError validateSumOfInterestReturn) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateSumOfInterestReturn test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateSumOfInterestReturn_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSumOfInterestReturn.printStackTrace();
			node.fail(validateSumOfInterestReturn);
			Assert.fail();
			extent.flush();

		} catch (Exception validateSumOfInterestReturn) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanNumber test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateSumOfInterestReturn_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSumOfInterestReturn.printStackTrace();
			node.fail(validateSumOfInterestReturn);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_039
	@Test(priority = 37)
	public void validateToggleBackToPercentageFromCashAmount() throws IOException {
		try {
			extenttest = extent
					.createTest(
							"Verify that the user can toggle back to the percentage after switching to cash amount.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();
			IElementActions.pageRefresh();

			// Wait for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Wait for the sum of interest return toggle to be visible
			node.log(Status.INFO, "STEP1 : Waiting for the sum of interest return toggle to be visible");
			System.out.println("STEP1 : Waiting for thesum of interest return toggle to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.percentageToggleOfSumOfInterest);
			node.log(Status.INFO, "STEP2 : Sum of interest return toggle is visible");
			System.out.println("STEP2 : Sum of interest return toggle is visible");

			Thread.sleep(1000);
			// Get percentage toggle status
			String getPercentageToggleStatus = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					ReportingLoansPO.percentageToggleOfSumOfInterest, "aria-pressed");

			// Get cash toggle status
			String getCashToggleOfSumOfInterestToggleStatus = IElementActions.getElementTextFromAttribute_usingXpath(
					node, driver, ReportingLoansPO.cashToggleOfSumOfInterest, "aria-pressed");

			// Click on the cash toggle button
			IElementActions.clickelement_usingXpath(node, driver, ReportingLoansPO.cashToggleOfSumOfInterest);
			node.log(Status.INFO, "STEP3 : Clicked on the cash toggle button");
			System.out.println("STEP3 : Clicked on the cash toggle button");

			Thread.sleep(1000);

			// Click on the percentage toggle button
			IElementActions.clickelement_usingXpath(node, driver, ReportingLoansPO.percentageToggleOfSumOfInterest);
			node.log(Status.INFO, "STEP4 : Clicked back on the percentage toggle button");
			System.out.println("STEP4 : Clicked back on the percentage toggle button");

			Thread.sleep(1000);
			// Get percentage toggle status
			String getBackPercentageStatus = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					ReportingLoansPO.percentageToggleOfSumOfInterest, "aria-pressed");

			// Get cash toggle status
			String getBackCashStatus = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					ReportingLoansPO.cashToggleOfSumOfInterest, "aria-pressed");

			// Check toggle status
			if (getBackPercentageStatus.contains("true") && getBackCashStatus.contains("false")) {
				Assert.assertTrue(true, "The user able to toggle from cash to percentage i.e percentage "
						+ getBackPercentageStatus + " and cash " + getBackCashStatus);
				System.out.println("The user able to toggle from cash to percentage i.e percentage "
						+ getBackPercentageStatus + " and cash " + getBackCashStatus);
				node.log(Status.PASS, "The user able to toggle from cash to percentage i.e percentage "
						+ getBackPercentageStatus + " and cash " + getBackCashStatus);
			} else {
				Assert.assertTrue(false, "The user toggle status from cash " + getBackCashStatus + " to percentage "
						+ getBackPercentageStatus + " is not correct");
				System.out.println("The user toggle status from cash " + getBackCashStatus + " to percentage "
						+ getBackPercentageStatus + " is not correct");
				node.log(Status.FAIL, "The user toggle status from cash " + getBackCashStatus + " to percentage "
						+ getBackPercentageStatus + " is not correct");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateToggleBackToPercentageFromCashAmount", "Pass", driver);

		} catch (AssertionError validateToggleBackToPercentageFromCashAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateToggleBackToPercentageFromCashAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateToggleBackToPercentageFromCashAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateToggleBackToPercentageFromCashAmount.printStackTrace();
			node.fail(validateToggleBackToPercentageFromCashAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateToggleBackToPercentageFromCashAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateToggleBackToPercentageFromCashAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateToggleBackToPercentageFromCashAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateToggleBackToPercentageFromCashAmount.printStackTrace();
			node.fail(validateToggleBackToPercentageFromCashAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_040
	@Test(priority = 38)
	public void validateInterestReturnRelativeToDrawnAmount() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the percentage display accurately represents the interest return relative to the drawn amount.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();
			IElementActions.pageRefresh();

			// Get facility reference
			String facilityReference = getDataFromExcel(70);

			// Get the deviation value from Excel
			double deviatedValue = Double.parseDouble(getDataFromExcel(12));

			// Create Dynamic Facility Reference Locator
			String facilityReferenceLocator = IElementActions
					.createDynamicLocatorString(ReportingLoansPO.facilityOptions, "locatorValue", facilityReference);

			// Wait for the visibility of the facility reference dropdown
			node.log(Status.INFO,
					"STEP1 : Waiting for the visibility of the facility reference dropdown to be clickable and visible");
			System.out.println(
					"STEP1 : Waiting for the visibility of the facility reference dropdown to be clickable and visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.facilityFilterBox);
			IWaitStrategy.WaitUntilElementClickable(node, driver, ReportingLoansPO.facilityFilterBox);
			node.log(Status.INFO, "STEP2 : Facility reference dropdown is clickable and visible");
			System.out.println("STEP2 : Facility reference dropdown is clickable and visible");

			// Click on the facility reference dropdown
			IElementActions.clickelement_usingXpath(node, driver, ReportingLoansPO.facilityFilterBox);
			node.log(Status.INFO, "STEP3 : Clicked on the facility reference dropdown");
			System.out.println("STEP3 : Clicked on the facility reference dropdown");

			// Wait for the visibility of the facility reference option
			node.log(Status.INFO, "STEP4 : Waiting for the visibility of the facility reference option");
			System.out.println("STEP4 : Waiting for the visibility of the facility reference option");
			IWaitStrategy.waitForVisiblity(node, driver, facilityReferenceLocator);
			node.log(Status.INFO, "STEP5 : Facility reference option is visible");
			System.out.println("STEP5 : Facility reference option is visible");

			// Get the option value
			String optionValue = IElementActions.getElementText_usingXpath(node, driver, facilityReferenceLocator);

			// Select loan from loan reference dropdown
			IElementActions.selectValueFromDropdown(node, driver, ReportingLoansPO.facilityFilter, optionValue);

			Thread.sleep(2000);

			// Get the value
			double drawnAmountValue = Utils.getTextAndParseToDouble(ReportingLoansPO.drawnAmount);

			// Get the value
			double actualFirstMonthFirstYearValue = Utils
					.getTextAndParseToDouble(ReportingLoansPO.firstMonthFirstYearValueInSumOfInterest);

			// Click on the cash toggle button
			IElementActions.clickelement_usingXpath(node, driver, ReportingLoansPO.cashToggleOfSumOfInterest);
			node.log(Status.INFO, "STEP6 : Clicked on the cash toggle button");
			System.out.println("STEP6 : Clicked on the cash toggle button");

			Thread.sleep(1000);
			// Get percentage toggle status
			String getPercentageStatus = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					ReportingLoansPO.percentageToggleOfSumOfInterest, "aria-pressed");

			// Get cash toggle status
			String getCashStatus = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					ReportingLoansPO.cashToggleOfSumOfInterest, "aria-pressed");

			// Check toggle status
			if (getCashStatus.contains("true") && getPercentageStatus.contains("false")) {
				Assert.assertTrue(true, "The user able to toggle from percentage to cash i.e percentage "
						+ getPercentageStatus + " and cash " + getCashStatus);
				System.out.println("The user able to toggle from percentage to cash i.e percentage "
						+ getPercentageStatus + " and cash " + getCashStatus);
				node.log(Status.PASS, "The user able to toggle from percentage to cash i.e percentage "
						+ getPercentageStatus + " and cash " + getCashStatus);
			} else {
				Assert.assertTrue(false, "The user toggle status from percentage " + getPercentageStatus + " to cash "
						+ getCashStatus + " is not correct");
				System.out.println("The user toggle status from percentage " + getPercentageStatus + " to cash "
						+ getCashStatus + " is not correct");
				node.log(Status.FAIL, "The user toggle status from percentage " + getPercentageStatus + " to cash "
						+ getCashStatus + " is not correct");
			}

			// Get the value
			double firstMonthFirstYearCashValue = Utils
					.getTextAndParseToDouble(ReportingLoansPO.firstMonthFirstYearValueInSumOfInterest);

			double calculatedValue = (firstMonthFirstYearCashValue / drawnAmountValue) * 100;

			String calculated = Utils.getDecimalOneDigit(calculatedValue);

			double expectedCalculatedValue = Double.parseDouble(calculated);

			// Assert the interest return relative to the drawn amount
			Assert.assertEquals(actualFirstMonthFirstYearValue, expectedCalculatedValue, deviatedValue,
					"Deviation is greater than expected value and the percentage : " + actualFirstMonthFirstYearValue
							+ " is not equal to expected (Interest Return/Drawn Amount)*100 "
							+ expectedCalculatedValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateInterestReturnRelativeToDrawnAmount", "Pass", driver);

		} catch (AssertionError validateInterestReturnRelativeToDrawnAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInterestReturnRelativeToDrawnAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestReturnRelativeToDrawnAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestReturnRelativeToDrawnAmount.printStackTrace();
			node.fail(validateInterestReturnRelativeToDrawnAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateInterestReturnRelativeToDrawnAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInterestReturnRelativeToDrawnAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestReturnRelativeToDrawnAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestReturnRelativeToDrawnAmount.printStackTrace();
			node.fail(validateInterestReturnRelativeToDrawnAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_041
	@Test(priority = 39)
	public void validateCreditPerformance() throws IOException {
		try {
			extenttest = extent.createTest("Verify the Credit performance ")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.credit, ReportingLoansPO.performingText, "Credit");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.performing,
					"STEP1 : BUG: Live is not displayed on credit loan reporting page",
					"STEP1 : EXPECTED: Live is displayed on credit loan reporting page");

			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.nintyDaysOverdue,
					"STEP2 : BUG: 90 days overdue is not displayed on credit loan reporting page",
					"STEP2 : EXPECTED: 90 days overdue is displayed on credit loan reporting page");

			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.nintyOneToOneEightyDaysOverdue,
					"STEP3 : BUG: 91-180 days overdue is not displayed on credit loan reporting page",
					"STEP3 : EXPECTED: 91-180 days overdue is displayed on credit loan reporting page");

			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.oneEightyDaysOverdue,
					"STEP4 : BUG: 180 days overdue is not displayed on credit loan reporting page",
					"STEP4 : EXPECTED: 180 days overdue is displayed on credit loan reporting page");

			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.repossessed,
					"STEP5 : BUG: Repossessed is not displayed on credit loan reporting page",
					"STEP5 : EXPECTED: Repossessed is displayed on credit loan reporting page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCreditPerformance", "Pass", driver);

		} catch (AssertionError validateCreditPerformance) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCreditPerformance test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCreditPerformance_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCreditPerformance.printStackTrace();
			node.fail(validateCreditPerformance);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCreditPerformance) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCreditPerformance test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCreditPerformance_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCreditPerformance.printStackTrace();
			node.fail(validateCreditPerformance);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_042
	@Test(priority = 40)
	public void validateLiveLoansPercentage() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the system accurately calculates the percentage of live loans")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the facility filter to be visible
			node.log(Status.INFO, "STEP1 : Waiting for the facility filter to be visible");
			System.out.println("STEP1 : Waiting for the facility filter to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.facilityFilter);
			node.log(Status.INFO, "STEP2 : Facility filter is visible");
			System.out.println("STEP2 : Facility filter is visible");

			// Get the deviation value from Excel
			double deviatedValue = Double.parseDouble(getDataFromExcel(12));

			// Select the Value from Facility Filter dropdown
			IElementActions.selectValueFromDropdown(node, driver, ReportingLoansPO.facilityFilter, "ALL");

			// Wait for the credit tab to be visible and clickable
			node.log(Status.INFO, "STEP3 : Waiting for the credit tab to be visible and clickable");
			System.out.println("STEP3 : Waiting for the credit tab to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.credit);
			node.log(Status.INFO, "STEP4 : Credit tab to be visible and clickable");
			System.out.println("STEP4 : Credit tab to be visible and clickable");

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.credit, ReportingLoansPO.performingText, "Credit");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the value
			double performingValue = Utils.getTextAndParseToDouble(ReportingLoansPO.performing);
			double nintyDaysOverdueValue = Utils.getTextAndParseToDouble(ReportingLoansPO.nintyDaysOverdue);
			double nintyOneToOneEightyDaysOverdueValue = Utils
					.getTextAndParseToDouble(ReportingLoansPO.nintyOneToOneEightyDaysOverdue);
			double oneEightyDaysOverdueValue = Utils.getTextAndParseToDouble(ReportingLoansPO.oneEightyDaysOverdue);
			double repossessedValue = Utils.getTextAndParseToDouble(ReportingLoansPO.repossessed);

			double calculatePerforming = 100 - (nintyDaysOverdueValue + nintyOneToOneEightyDaysOverdueValue
					+ oneEightyDaysOverdueValue + repossessedValue);

			String calculated = Utils.getDecimalOneDigit(calculatePerforming);
			double expectedCalculatedValue = Double.parseDouble(calculated);

			// Assert the performing value
			Assert.assertEquals(performingValue, expectedCalculatedValue, deviatedValue,
					"Deviation is greater than expected value and the performing value : " + performingValue
							+ " is not equal to expected value " + expectedCalculatedValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLiveLoansPercentage", "Pass", driver);

		} catch (AssertionError validateLiveLoansPercentage) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLiveLoansPercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLiveLoansPercentage_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLiveLoansPercentage.printStackTrace();
			node.fail(validateLiveLoansPercentage);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLiveLoansPercentage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLiveLoansPercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLiveLoansPercentage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLiveLoansPercentage.printStackTrace();
			node.fail(validateLiveLoansPercentage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_043
	@Test(priority = 41)
	public void validate90DaysOverdueLoanPercentage() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the percentage of loans that are 90 days overdue are calculated as per the below formula:"
							+ "(90 days overdue amount/Utilisation)*100")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the facility filter to be visible
			node.log(Status.INFO, "STEP1 : Waiting for the facility filter to be visible");
			System.out.println("STEP1 : Waiting for the facility filter to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.facilityFilter);
			node.log(Status.INFO, "STEP2 : Facility filter is visible");
			System.out.println("STEP2 : Facility filter is visible");

			// Select the Value from Facility Filter dropdown
			IElementActions.selectValueFromDropdown(node, driver, ReportingLoansPO.facilityFilter, "ALL");

			// Wait for the credit tab to be visible and clickable
			node.log(Status.INFO, "STEP3 : Waiting for the credit tab to be visible and clickable");
			System.out.println("STEP3 : Waiting for the credit tab to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.credit);
			node.log(Status.INFO, "STEP4 : Credit tab to be visible and clickable");
			System.out.println("STEP4 : Credit tab to be visible and clickable");

			Thread.sleep(2000);
			// Get the value
			double utilisationAmountValue = Utils.getTextAndParseToDouble(ReportingLoansPO.utilisationAmount);

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.credit, ReportingLoansPO.performingText, "Credit");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the value
			double nintyDaysOverdueValue = Utils.getTextAndParseToDouble(ReportingLoansPO.nintyDaysOverdue);

			// Get the value
			double nintyDaysOverdueAmountValue = Utils.getTextAndParseToDouble(ReportingLoansPO.nintyDaysOverdueAmount);

			double calculatedValue = (nintyDaysOverdueAmountValue / utilisationAmountValue) * 100;

			String calculated = Utils.getDecimalOneDigit(calculatedValue);
			double expectedCalculatedValue = Double.parseDouble(calculated);

			// Assert the 90 days overdue value
			IElementActions.assertEquals_usingDouble(node, driver, nintyDaysOverdueValue, expectedCalculatedValue,
					"STEP5 : BUG : The 90 days overdue % value " + nintyDaysOverdueValue
							+ " is not equal to expected calculated (90 days overdue amount/Utilisation)*100 value "
							+ expectedCalculatedValue,
					"STEP5 : PASS : The 90 days overdue % value " + nintyDaysOverdueValue
							+ " is equal to expected calculated (90 days overdue amount/Utilisation)*100 value "
							+ expectedCalculatedValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validate90DaysOverdueLoanPercentage", "Pass", driver);

		} catch (AssertionError validate90DaysOverdueLoanPercentage) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validate90DaysOverdueLoanPercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validate90DaysOverdueLoanPercentage_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validate90DaysOverdueLoanPercentage.printStackTrace();
			node.fail(validate90DaysOverdueLoanPercentage);
			Assert.fail();
			extent.flush();

		} catch (Exception validate90DaysOverdueLoanPercentage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validate90DaysOverdueLoanPercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validate90DaysOverdueLoanPercentage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validate90DaysOverdueLoanPercentage.printStackTrace();
			node.fail(validate90DaysOverdueLoanPercentage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_044
	@Test(priority = 42)
	public void validate91To180DaysOverdueLoanPercentage() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the percentage of loans that are 91-180 days overdue are calculated as per the below formula:\r\n"
							+ "(91-180 days overdue amount/Utilisation)*100")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the facility filter to be visible
			node.log(Status.INFO, "STEP1 : Waiting for the facility filter to be visible");
			System.out.println("STEP1 : Waiting for the facility filter to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.facilityFilter);
			node.log(Status.INFO, "STEP2 : Facility filter is visible");
			System.out.println("STEP2 : Facility filter is visible");

			// Get the deviation value from Excel
			double deviatedValue = Double.parseDouble(getDataFromExcel(12));

			// Select the Value from Facility Filter dropdown
			IElementActions.selectValueFromDropdown(node, driver, ReportingLoansPO.facilityFilter, "ALL");

			// Wait for the credit tab to be visible and clickable
			node.log(Status.INFO, "STEP3 : Waiting for the credit tab to be visible and clickable");
			System.out.println("STEP3 : Waiting for the credit tab to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.credit);
			node.log(Status.INFO, "STEP4 : Credit tab to be visible and clickable");
			System.out.println("STEP4 : Credit tab to be visible and clickable");

			Thread.sleep(2000);
			// Get the value
			double utilisationAmountValue = Utils.getTextAndParseToDouble(ReportingLoansPO.utilisationAmount);

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.credit, ReportingLoansPO.performingText, "Credit");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the value
			double nintyOneToOneEightyDaysOverdueValue = Utils
					.getTextAndParseToDouble(ReportingLoansPO.nintyOneToOneEightyDaysOverdue);

			// Get the value
			double nintyOneToOneEightyDaysOverdueAmountValue = Utils
					.getTextAndParseToDouble(ReportingLoansPO.nintyOneToOneEightyDaysOverdueAmount);

			double calculatedValue = (nintyOneToOneEightyDaysOverdueAmountValue / utilisationAmountValue) * 100;

			String calculated = Utils.getDecimalOneDigit(calculatedValue);
			double expectedCalculatedValue = Double.parseDouble(calculated);

			// Assert the 91-180 days overdue value
			Assert.assertEquals(nintyOneToOneEightyDaysOverdueValue, expectedCalculatedValue, deviatedValue,
					"Deviation is greater than expected value and the 91-180 days overdue % value: "
							+ nintyOneToOneEightyDaysOverdueValue
							+ " is not equal to expected calculated (91-180 days overdue amount/Utilisation)*100 value "
							+ expectedCalculatedValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validate91To180DaysOverdueLoanPercentage", "Pass", driver);

		} catch (AssertionError validate91To180DaysOverdueLoanPercentage) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validate91To180DaysOverdueLoanPercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validate91To180DaysOverdueLoanPercentage_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validate91To180DaysOverdueLoanPercentage.printStackTrace();
			node.fail(validate91To180DaysOverdueLoanPercentage);
			Assert.fail();
			extent.flush();

		} catch (Exception validate91To180DaysOverdueLoanPercentage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validate91To180DaysOverdueLoanPercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validate91To180DaysOverdueLoanPercentage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validate91To180DaysOverdueLoanPercentage.printStackTrace();
			node.fail(validate91To180DaysOverdueLoanPercentage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_045
	@Test(priority = 43)
	public void validate180DaysOverdueLoanPercentage() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the percentage of loans that are 180 days overdue are calculated as per the below formula:\r\n"
							+ "(180 days overdue amount/Utilisation)*100")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the facility filter to be visible
			node.log(Status.INFO, "STEP1 : Waiting for the facility filter to be visible");
			System.out.println("STEP1 : Waiting for the facility filter to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.facilityFilter);
			node.log(Status.INFO, "STEP2 : Facility filter is visible");
			System.out.println("STEP2 : Facility filter is visible");

			// Select the Value from Facility Filter dropdown
			IElementActions.selectValueFromDropdown(node, driver, ReportingLoansPO.facilityFilter, "ALL");

			// Wait for the credit tab to be visible and clickable
			node.log(Status.INFO, "STEP3 : Waiting for the credit tab to be visible and clickable");
			System.out.println("STEP3 : Waiting for the credit tab to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.credit);
			node.log(Status.INFO, "STEP4 : Credit tab to be visible and clickable");
			System.out.println("STEP4 : Credit tab to be visible and clickable");

			Thread.sleep(2000);
			// Get the value
			double utilisationAmountValue = Utils.getTextAndParseToDouble(ReportingLoansPO.utilisationAmount);

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.credit, ReportingLoansPO.performingText, "Credit");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the value
			double oneEightyDaysOverdueValue = Utils.getTextAndParseToDouble(ReportingLoansPO.oneEightyDaysOverdue);

			// Get the value
			double oneEightyDaysOverdueAmountValue = Utils
					.getTextAndParseToDouble(ReportingLoansPO.oneEightyDaysOverdueAmount);

			double calculatedValue = (oneEightyDaysOverdueAmountValue / utilisationAmountValue) * 100;

			String calculated = Utils.getDecimalOneDigit(calculatedValue);
			double expectedCalculatedValue = Double.parseDouble(calculated);

			// Assert the 180 days overdue value
			IElementActions.assertEquals_usingDouble(node, driver, oneEightyDaysOverdueValue, expectedCalculatedValue,
					"STEP5 : BUG : The 180 days overdue % value " + oneEightyDaysOverdueValue
							+ " is not equal to expected calculated (180 days overdue amount/Utilisation)*100 value "
							+ expectedCalculatedValue,
					"STEP5 : PASS : The 180 days overdue % value " + oneEightyDaysOverdueValue
							+ " is equal to expected calculated (180 days overdue amount/Utilisation)*100 value "
							+ expectedCalculatedValue);
			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validate180DaysOverdueLoanPercentage", "Pass", driver);

		} catch (AssertionError validate180DaysOverdueLoanPercentage) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validate180DaysOverdueLoanPercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validate180DaysOverdueLoanPercentage_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validate180DaysOverdueLoanPercentage.printStackTrace();
			node.fail(validate180DaysOverdueLoanPercentage);
			Assert.fail();
			extent.flush();

		} catch (Exception validate180DaysOverdueLoanPercentage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validate180DaysOverdueLoanPercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validate180DaysOverdueLoanPercentage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validate180DaysOverdueLoanPercentage.printStackTrace();
			node.fail(validate180DaysOverdueLoanPercentage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_046
	@Test(priority = 44)
	public void validatePercentageOfRepossessedLoans() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the percentage of loans that are Repossessed are calculated as per the below formula:\r\n"
							+ "(Repossessed amount/Utilisation)*100" + "")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the facility filter to be visible
			node.log(Status.INFO, "STEP1 : Waiting for the facility filter to be visible");
			System.out.println("STEP1 : Waiting for the facility filter to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.facilityFilter);
			node.log(Status.INFO, "STEP2 : Facility filter is visible");
			System.out.println("STEP2 : Facility filter is visible");

			// Select the Value from Facility Filter dropdown
			IElementActions.selectValueFromDropdown(node, driver, ReportingLoansPO.facilityFilter, "ALL");

			// Wait for the credit tab to be visible and clickable
			node.log(Status.INFO, "STEP3 : Waiting for the credit tab to be visible and clickable");
			System.out.println("STEP3 : Waiting for the credit tab to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.credit);
			node.log(Status.INFO, "STEP4 : Credit tab to be visible and clickable");
			System.out.println("STEP4 : Credit tab to be visible and clickable");

			Thread.sleep(2000);
			// Get the value
			double utilisationAmountValue = Utils.getTextAndParseToDouble(ReportingLoansPO.utilisationAmount);

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.credit, ReportingLoansPO.performingText, "Credit");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the value
			double repossessedValue = Utils.getTextAndParseToDouble(ReportingLoansPO.repossessed);

			// Get the value
			double repossessedAmountValue = Utils.getTextAndParseToDouble(ReportingLoansPO.repossessedAmount);

			double calculatedValue = (repossessedAmountValue / utilisationAmountValue) * 100;

			String calculated = Utils.getDecimalOneDigit(calculatedValue);
			double expectedCalculatedValue = Double.parseDouble(calculated);

			// Assert the repossessed value
			IElementActions.assertEquals_usingDouble(node, driver, repossessedValue, expectedCalculatedValue,
					"STEP5 : BUG : The repossessed % value " + repossessedValue
							+ " is not equal to expected calculated (repossessed amount/Utilisation)*100 value "
							+ expectedCalculatedValue,
					"STEP5 : PASS : The repossessed % value " + repossessedValue
							+ " is equal to expected calculated (repossessed amount/Utilisation)*100 value "
							+ expectedCalculatedValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validatePercentageOfRepossessedLoans", "Pass", driver);

		} catch (AssertionError validatePercentageOfRepossessedLoans) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePercentageOfRepossessedLoans test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePercentageOfRepossessedLoans_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePercentageOfRepossessedLoans.printStackTrace();
			node.fail(validatePercentageOfRepossessedLoans);
			Assert.fail();
			extent.flush();

		} catch (Exception validatePercentageOfRepossessedLoans) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePercentageOfRepossessedLoans test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePercentageOfRepossessedLoans_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePercentageOfRepossessedLoans.printStackTrace();
			node.fail(validatePercentageOfRepossessedLoans);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_047
	@Test(priority = 45)
	public void validatePerformingLoansPercentage() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the percentage of loans that are Performing are calculated as per the below formula:\r\n"
							+ "(Performing amount/Utilisation)*100" + "")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Wait for the facility filter to be visible
			node.log(Status.INFO, "STEP1 : Waiting for the facility filter to be visible");
			System.out.println("STEP1 : Waiting for the facility filter to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.facilityFilter);
			node.log(Status.INFO, "STEP2 : Facility filter is visible");
			System.out.println("STEP2 : Facility filter is visible");

			// Select the Value from Facility Filter dropdown
			IElementActions.selectValueFromDropdown(node, driver, ReportingLoansPO.facilityFilter, "ALL");

			// Wait for the credit tab to be visible and clickable
			node.log(Status.INFO, "STEP3 : Waiting for the credit tab to be visible and clickable");
			System.out.println("STEP3 : Waiting for the credit tab to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.credit);
			node.log(Status.INFO, "STEP4 : Credit tab to be visible and clickable");
			System.out.println("STEP4 : Credit tab to be visible and clickable");

			Thread.sleep(2000);
			// Get the value
			double utilisationAmountValue = Utils.getTextAndParseToDouble(ReportingLoansPO.utilisationAmount);

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.credit, ReportingLoansPO.performingText, "Credit");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the value
			double performingValue = Utils.getTextAndParseToDouble(ReportingLoansPO.performing);

			// Get the value
			double performingAmountValue = Utils.getTextAndParseToDouble(ReportingLoansPO.performingAmount);

			double calculatedValue = (performingAmountValue / utilisationAmountValue) * 100;

			String calculated = Utils.getDecimalOneDigit(calculatedValue);
			double expectedCalculatedValue = Double.parseDouble(calculated);

			// Assert the performing value
			IElementActions.assertEquals_usingDouble(node, driver, performingValue, expectedCalculatedValue,
					"STEP5 : BUG : The performing % value " + performingValue
							+ " is not equal to expected calculated (performing amount/Utilisation)*100 value "
							+ expectedCalculatedValue,
					"STEP5 : PASS : Theperforming % value " + performingValue
							+ " is equal to expected calculated (performing amount/Utilisation)*100 value "
							+ expectedCalculatedValue);
			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validatePerformingLoansPercentage", "Pass", driver);

		} catch (AssertionError validatePerformingLoansPercentage) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePerformingLoansPercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePerformingLoansPercentage_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePerformingLoansPercentage.printStackTrace();
			node.fail(validatePerformingLoansPercentage);
			Assert.fail();
			extent.flush();

		} catch (Exception validatePerformingLoansPercentage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePerformingLoansPercentage test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePerformingLoansPercentage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePerformingLoansPercentage.printStackTrace();
			node.fail(validatePerformingLoansPercentage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_052
	@Test(priority = 46)
	public void validateLoanPortfolioTab() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the Portfolio Tab")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Verify the section in Loan Portfolio Page
			node.log(Status.INFO, "STEP1 : Verify the section in Loan Portfolio Page");
			System.out.println("STEP1 : Verify the section in Loan Portfolio Page");

			// Check the visibility of Facility Amount Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.facilityAmountsSection,
					"STEP2 : BUG: The Facility Amount Section is not coming on Loan Portfolio Page",
					"STEP2 : EXPECTED: The Facility Amount Section is coming on Loan Portfolio Page");

			// Check the visibility of Loan Size Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.loanSizeSection,
					"STEP3 : BUG: The Loan Size Section is not coming on Loan Portfolio Page",
					"STEP3 : EXPECTED: The Loan Size Section is coming on Loan Portfolio Page");

			// Check the visibility of LTV Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.lTVSection,
					"STEP4 : BUG: The LTV Section is not coming on Loan Portfolio Page",
					"STEP4 : EXPECTED: The LTV Section is coming on Loan Portfolio Page");

			// Check the visibility of Charge Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.chargeSection,
					"STEP5 : BUG: The Charge Section is not coming on Loan Portfolio Page",
					"STEP5 : EXPECTED: The Charge Section is coming on Loan Portfolio Page");

			// Check the visibility of Key Stats Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.keyStatsSection,
					"STEP6 : BUG: The Key Stats Section is not coming on Loan Portfolio Page",
					"STEP6 : EXPECTED: The Key Stats Section is coming on Loan Portfolio Page");

			// Check the visibility of Loan Type Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.loanTypeSection,
					"STEP7 : BUG: The Loan Type Section is not coming on Loan Portfolio Page",
					"STEP7 : EXPECTED: The Loan Type Section is coming on Loan Portfolio Page");

			// Check the visibility of Top 5 Borrowers Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.top5BorrowersSection,
					"STEP8 : BUG: The Top 5 Borrowers Section is not coming on Loan Portfolio Page",
					"STEP8 : EXPECTED: The Top 5 Borrowers Section is coming on Loan Portfolio Page");

			// Check the visibility of Top 5 Loans Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.top5LoansSection,
					"STEP9 : BUG: The Top 5 Loans Section is not coming on Loan Portfolio Page",
					"STEP9 : EXPECTED: The Top 5 Loans Section is coming on Loan Portfolio Page");

			// Check the visibility of Loans Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.loansSection,
					"STEP10 : BUG: The Loans Section is not coming on Loan Portfolio Page",
					"STEP10 : EXPECTED: The Loans Section is coming on Loan Portfolio Page");

			// Check the visibility of Loans Table
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.loansTable,
					"STEP11 : BUG: The Loans Table Section is not coming on Loan Portfolio Page",
					"STEP11 : EXPECTED: The Loans Table Section is coming on Loan Portfolio Page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanPortfolioTab", "Pass", driver);

		} catch (AssertionError validateLoanPortfolioTab) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanPortfolioTab test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanPortfolioTab_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanPortfolioTab.printStackTrace();
			node.fail(validateLoanPortfolioTab);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanPortfolioTab) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanPortfolioTab test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanPortfolioTab_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanPortfolioTab.printStackTrace();
			node.fail(validateLoanPortfolioTab);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_053
	@Test(priority = 47)
	public void validateFacilityAmountSection() throws IOException {
		try {
			extenttest = extent.createTest("Verify that user is able to view initial state Facility Amount section")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Verify the Facility Amount section
			node.log(Status.INFO, "STEP1 : Verify the Facility Amount section");
			System.out.println("STEP1 : Verify the Facility Amount section");

			// Check the visibility of Facility Amount
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.facilityAmount,
					"STEP2 : BUG: The Facility Amount is not coming in Facility Amount Section.",
					"STEP2 : EXPECTED: The Facility Amount is coming in Facility Amount Section");

			// Check the visibility of Drawn Amount
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.drawnAmountValue,
					"STEP3 : BUG: The Drawn Amount is not coming in Facility Amount Section.",
					"STEP3 : EXPECTED: The Drawn Amount is coming in Facility Amount Section");

			// Check the visibility of Undrawn Amount
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.undrawnAmount,
					"STEP4 : BUG: The Undrawn Amount is not coming in Facility Amount Section.",
					"STEP4 : EXPECTED: The Undrawn Amount is coming in Facility Amount Section");

			// Check the visibility of Allocated Amount
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.allocatedAmount,
					"STEP5 : BUG: The Allocated Amount is not coming in Facility Amount Section.",
					"STEP5 : EXPECTED: The Allocated Amount is coming in Facility Amount Section");

			// Check the visibility of Cash Amount
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.cashAmount,
					"STEP6 : BUG: The Cash Amount is not coming in Facility Amount Section.",
					"STEP6 : EXPECTED: The Cash Amount is coming in Facility Amount Section");

			// Check the visibility of Frozen Cash TNG Amount
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.frozenCashTNGAmount,
					"STEP7 : BUG: The Frozen Cash TNG Amount is not coming in Facility Amount Section.",
					"STEP7 : EXPECTED: The Frozen Cash TNG Amount is coming in Facility Amount Section");

			// Check the visibility of Available Cash Amount
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.availableCashAmount,
					"STEP8 : BUG: The Available Cash Amount is not coming in Facility Amount Section.",
					"STEP8 : EXPECTED: The Available Cash Amount is coming in Facility Amount Section");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityAmountSection", "Pass", driver);

		} catch (AssertionError validateFacilityAmountSection) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityAmountSection test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityAmountSection_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityAmountSection.printStackTrace();
			node.fail(validateFacilityAmountSection);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityAmountSection) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityAmountSection test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityAmountSection_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityAmountSection.printStackTrace();
			node.fail(validateFacilityAmountSection);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_054
	@Test(priority = 48)
	public void validateFacilityAmount() throws IOException {
		try {
			extenttest = extent.createTest("Verify the 'Facility Amount'.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Facility Amount
			double facilityAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.facilityAmount);

			// Calling the loadDatabasePage function from FundingPage and Navigate to the
			// Funding Database Page
			FundingPage.loadDatabasePage();

			// Get the Sum of All the facility Amount column
			double amountColumnSum = Utils.calculateSumOfList(FundingDatabasePO.amountElements);

			// Assert that Facility Amount on Loan Portfolio Page is Equal to the Sum of All
			// Facilities Amount
			IElementActions.assertEquals_usingDouble(node, driver, facilityAmount, amountColumnSum,
					"STEP1 : BUG : The Facility Amount on Loan Portfolio Page : " + facilityAmount
							+ " is not Equal to the Sum of All Facilities Amount : " + amountColumnSum,
					"STEP1 : PASS : The Facility Amount on Loan Portfolio Page : " + facilityAmount
							+ " is Equal to the Sum of All Facilities Amount : " + amountColumnSum);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityAmount", "Pass", driver);

		} catch (AssertionError validateFacilityAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFacilityAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityAmount.printStackTrace();
			node.fail(validateFacilityAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFacilityAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityAmount.printStackTrace();
			node.fail(validateFacilityAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_055
	@Test(priority = 49)
	public void validateDrawnAmounts() throws IOException {
		try {
			extenttest = extent.createTest("Verify the 'Drawn' amount.").assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Drawn Amount
			double drawnAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.drawnAmountValue);

			// Calling the loadDatabasePage function from FundingPage and Navigate to the
			// Funding Database Page
			FundingPage.loadDatabasePage();

			// Get the Sum of All the facility Drawn Amount column
			double drawnAmountColumnSum = Utils.calculateSumOfList(FundingDatabasePO.drawnElements);

			// Set the acceptable difference
			int acceptableDifference = Integer.parseInt(getDataFromExcel(10));

			// Perform assertion allowing for a difference around 5 with a delta parameter
			Assert.assertEquals(drawnAmount, drawnAmountColumnSum, acceptableDifference,
					"Difference is greater than the acceptable range");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDrawnAmounts", "Pass", driver);

		} catch (AssertionError validateDrawnAmounts) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDrawnAmounts test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDrawnAmounts_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDrawnAmounts.printStackTrace();
			node.fail(validateDrawnAmounts);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDrawnAmounts) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDrawnAmounts test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDrawnAmounts_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDrawnAmounts.printStackTrace();
			node.fail(validateDrawnAmounts);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_056
	@Test(priority = 50)
	public void validateUnDrawnAmount() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the Undrawn amount is calculated as per the below formula:"
					+ "Facility Amount- Drawn Amount").assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Facility Amount
			double facilityAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.facilityAmount);

			// Get the Drawn Amount
			double drawnAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.drawnAmountValue);

			// Get the UnDrawn Amount
			double actualUnDrawnAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.undrawnAmount);

			// Calling the calculateDifference from Utils and perform the Substarction
			double expectedUndrawnAmount = Utils.calculateDifference(facilityAmount, drawnAmount);

			// Assert that UnDrawn Amount is Equal to the Facility Amount- Drawn Amount
			IElementActions.assertEquals_usingDouble(node, driver, actualUnDrawnAmount, expectedUndrawnAmount,
					"STEP1 : BUG : The Undrawn Amount : " + actualUnDrawnAmount
							+ "is not Equal to the Facility Amount- Drawn Amount : " + expectedUndrawnAmount,
					"STEP1 : PASS : The Undrawn Amount : " + actualUnDrawnAmount
							+ " is Equal to the Facility Amount- Drawn Amount : " + expectedUndrawnAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateUnDrawnAmount", "Pass", driver);

		} catch (AssertionError validateUnDrawnAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateUnDrawnAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateUnDrawnAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateUnDrawnAmount.printStackTrace();
			node.fail(validateUnDrawnAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateUnDrawnAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateUnDrawnAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateUnDrawnAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateUnDrawnAmount.printStackTrace();
			node.fail(validateUnDrawnAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_057
	@Test(priority = 51)
	public void validateAllocatedAmount() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the Allocated Amount is equal to the Utilisation amount at Summary tab")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Utilisation Amount
			double utilisationAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.utilisationAmount);

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Allocated Amount
			double allocatedAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.allocatedAmount);

			// Assert that Allocated Amount is Equal to the Utilisation Amount
			IElementActions.assertEquals_usingDouble(node, driver, allocatedAmount, utilisationAmount,
					"STEP1 : BUG : The Allocated Amount : " + allocatedAmount
							+ "is not Equal to the Utilisation Amount : " + utilisationAmount,
					"STEP1 : PASS : The Allocated Amount : " + allocatedAmount
							+ " is Equal to the Utilisation Amount : " + utilisationAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAllocatedAmount", "Pass", driver);

		} catch (AssertionError validateAllocatedAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAllocatedAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAllocatedAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocatedAmount.printStackTrace();
			node.fail(validateAllocatedAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAllocatedAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAllocatedAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAllocatedAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocatedAmount.printStackTrace();
			node.fail(validateAllocatedAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_058
	@Test(priority = 52)
	public void validateCashAmount() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the 'Cash' amount is equal to the Drawn Amount-Allocated Amount")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Get the deviation value from Excel
			double deviatedValue = Double.parseDouble(getDataFromExcel(10));

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Drawn Amount
			double drawnAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.drawnAmountValue);

			// Get the Allocated Amount
			double allocatedAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.allocatedAmount);

			// Get the Cash Amount
			double actualCashAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.cashAmount);

			// Calling the calculateDifference from Utils and perform the Substarction
			double expectedCashAmount = Utils.calculateDifference(drawnAmount, allocatedAmount);

			// Assert that Cash Amount is Equal to the Drawn Amount-Allocated Amount
			Assert.assertEquals(actualCashAmount, expectedCashAmount, deviatedValue,
					"Deviation is greater than expected value and the Cash Amount : " + actualCashAmount
							+ " is not Equal to the Drawn Amount-Allocated Amount : " + expectedCashAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashAmount", "Pass", driver);

		} catch (AssertionError validateCashAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCashAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashAmount.printStackTrace();
			node.fail(validateCashAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCashAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCashAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashAmount.printStackTrace();
			node.fail(validateCashAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_059
	@Test(priority = 53)
	public void validateFrozenCash() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the Frozen cash is equal to the Frozen TE Drawn Amount- Frozen TE Allocated Amount")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Get the deviation value from Excel
			double deviatedValue = Double.parseDouble(getDataFromExcel(10));

			// Get the Drawn Amount
			double drawnAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.frozenDrawn);

			// Get the Allocated Amount
			double allocatedAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.frozenAllocated);

			// Calling the calculateDifference from Utils and perform the Substarction
			double expectedCashAmount = Utils.calculateDifference(drawnAmount, allocatedAmount);

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Cash Amount
			double actualCashAmount = Utils.getValueAfterCurrencyInDouble(ReportingLoansPO.frozenCashTNGAmount);

			// Assert that Cash Amount is Equal to the Drawn Amount-Allocated Amount
			Assert.assertEquals(actualCashAmount, expectedCashAmount, deviatedValue,
					"Deviation is greater than expected value and the Frozen Cash Amount : " + actualCashAmount
							+ " is not Equal to the Frozen Drawn Amount-Frozen Allocated Amount : "
							+ expectedCashAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFrozenCash", "Pass", driver);

		} catch (AssertionError validateFrozenCash) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFrozenCash test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFrozenCash_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFrozenCash.printStackTrace();
			node.fail(validateFrozenCash);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFrozenCash) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFrozenCash test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFrozenCash_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFrozenCash.printStackTrace();
			node.fail(validateFrozenCash);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_060
	@Test(priority = 54)
	public void validateAvailableCash() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately calculates and displays the available cash, where Available Cash is equal to Cash - Frozen Cash")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Cash Amount
			double cashAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.cashAmount);

			// Get the frozen cash amount
			double frozenCashTNGAmount = Utils.getValueAfterCurrencyInDouble(ReportingLoansPO.frozenCashTNGAmount);

			// Calling the calculateDifference from Utils and perform the Substarction
			double expectedAvailableCash = Utils.calculateDifference(cashAmount, frozenCashTNGAmount);

			// Get the Available Cash
			double actualAvailableCash = Utils.getTextAndParseToDouble(ReportingLoansPO.availableCashAmount);

			// Assert that Available cash is equal to the cash- Frozen Cash.
			IElementActions.assertEquals_usingDouble(node, driver, actualAvailableCash, expectedAvailableCash,
					"BUG : The Available Cash Amount : " + actualAvailableCash
							+ "is not equal to the Cash - Frozen Cash : " + expectedAvailableCash,
					"PASS : The Available Cash Amount : " + actualAvailableCash
							+ " is equal to the Cash - Frozen Cash : " + expectedAvailableCash);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAvailableCash", "Pass", driver);

		} catch (AssertionError validateAvailableCash) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAvailableCash test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAvailableCash_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAvailableCash.printStackTrace();
			node.fail(validateAvailableCash);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAvailableCash) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAvailableCash test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAvailableCash_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAvailableCash.printStackTrace();
			node.fail(validateAvailableCash);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_061
	@Test(priority = 55)
	public void validateLoanSizeSection() throws IOException {
		try {
			extenttest = extent.createTest("Verify the Loan Size section")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Verify the Loan Size Section
			node.log(Status.INFO, "STEP1 : Verify the Loan Size Section.");
			System.out.println("STEP1 : Verify the Loan Size Section.");

			// Check the visibility of Min Option
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.minLabel,
					"STEP2 : BUG: The Min Option is not visible in Loan Size Section.",
					"STEP2 : EXPECTED: The Min Option is visible in Loan Size Section");

			// Check the visibility of Max Option
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.maxLabel,
					"STEP3 : BUG: The Max Option is not visible in Loan Size Section.",
					"STEP3 : EXPECTED: The Max Option is visible in Loan Size Section");

			// Check the visibility of Average Option
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.averageLabel,
					"STEP4 : BUG: The Average Option is not visible in Loan Size Section.",
					"STEP4 : EXPECTED: The Average Option is visible in Loan Size Section");

			// Check the visibility of Median Option
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.medianLabel,
					"STEP5 : BUG: The Median Option is not visible in Loan Size Section.",
					"STEP5 : EXPECTED: The Median Option is visible in Loan Size Section");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanSizeSection", "Pass", driver);

		} catch (AssertionError validateLoanSizeSection) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanSizeSection test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanSizeSection_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanSizeSection.printStackTrace();
			node.fail(validateLoanSizeSection);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanSizeSection) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanSizeSection test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanSizeSection_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanSizeSection.printStackTrace();
			node.fail(validateLoanSizeSection);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_062
	@Test(priority = 56)
	public void validateMinLoanSize() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the minimum loan size, including the loan amount and interest rate")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Get the deviation value from Excel
			double deviatedValue = Double.parseDouble(getDataFromExcel(12));

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for Page Loading To Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Min Loan Amount
			double minLoanAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.minLoanAmount);

			// Get the Min Loan Amount Interest Rate
			double actualMinLoanAmounntInterestPercentage = Utils
					.getTextAndParseToDouble(ReportingLoansPO.minLoanAmountInterestRate);

			// Sort the listing in ascending order
			Utils.sortListingInAscendin(ReportingLoansPO.currentLoanAmountSortIcon, "Current Loan Amount",
					ReportingLoansPO.currentLoanAmount);

			Thread.sleep(1000);
			// Get the Min Loan Amount from Loans Table
			double loansTableMinLoanAmount = Utils
					.getTextAndParseToDouble(ReportingLoansPO.currentLoanAmountFirstAmount);

			// Get the Allocated Amount
			double allocatedAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.allocatedAmount);

			// Calculate the Interest %
			double calculatedInterestPercentage = (loansTableMinLoanAmount / allocatedAmount) * 100;

			String calculatedValue = Utils.getDecimalOneDigit(calculatedInterestPercentage);

			double expectedInterestPercentage = Double.parseDouble(calculatedValue);

			// Assert that Min Loan Amount in Loan Size Section is same as Min Loan Amount
			// in Loans Table
			IElementActions.assertEquals_usingDouble(node, driver, minLoanAmount, loansTableMinLoanAmount,
					"STEP1 : BUG : The Min Loan Amount in Loan Size Section : " + minLoanAmount
							+ "is not Equal to the Min Loan Amount in Loans Table : " + loansTableMinLoanAmount,
					"STEP1 : PASS : The Min Loan Amount in Loan Size Section : " + minLoanAmount
							+ " is Equal to the Min Loan Amount in Loans Table : " + loansTableMinLoanAmount);

			// Assert that Min Loan Amount Interest % is same as calculated from
			// (loansTableMinLoanAmount / allocatedAmount) * 100
			Assert.assertEquals(actualMinLoanAmounntInterestPercentage, expectedInterestPercentage, deviatedValue,
					"Deviation is greater than expected value and the Min Loan Amount Interest %  : "
							+ actualMinLoanAmounntInterestPercentage
							+ " is not same as calculated from (loansTableMinLoanAmount / allocatedAmount) * 100 : "
							+ expectedInterestPercentage);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateMinLoanSize", "Pass", driver);

		} catch (AssertionError validateMinLoanSize) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateMinLoanSize test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateMinLoanSize_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMinLoanSize.printStackTrace();
			node.fail(validateMinLoanSize);
			Assert.fail();
			extent.flush();

		} catch (Exception validateMinLoanSize) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateMinLoanSize test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateMinLoanSize_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMinLoanSize.printStackTrace();
			node.fail(validateMinLoanSize);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_063
	@Test(priority = 57)
	public void validateMaxLoanSize() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the maximum loan size, including the loan amount and interest rate")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for Page Loading To Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Scroll to the element
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, ReportingLoansPO.currentLoanAmountSortIcon);
			node.log(Status.INFO, "STEP1 : Scrolled to the element");
			System.out.println("STEP1 : Scrolled to the element");

			// Wait for the sort icon to be visible and clickable
			node.log(Status.INFO, "STEP2 : Waiting for the sort icon to be visible and clickable");
			System.out.println("STEP2 : Waiting for the sort icon to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.currentLoanAmountSortIcon);
			node.log(Status.INFO, "STEP3 : Sort icon is visible and clickable");
			System.out.println("STEP3 : Sort icon is visible and clickable");

			// Sort the listing in descending order
			Utils.sortListingInDescendin(ReportingLoansPO.currentLoanAmountSortIcon, "Current Loan Amount",
					ReportingLoansPO.currentLoanAmount);

			// Get the Max Loan Amount
			double maxLoanAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.maxLoanAmount);

			// Get the Max Loan Amount Interest Rate
			double actualMaxLoanAmounntInterestPercentage = Utils
					.getTextAndParseToDouble(ReportingLoansPO.maxLoanAmountInterestRate);

			// Get the Max Loan Amount from Loans Table
			double loansTableMaxLoanAmount = Utils
					.getTextAndParseToDouble(ReportingLoansPO.currentLoanAmountFirstAmount);

			// Get the Allocated Amount
			double allocatedAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.allocatedAmount);

			// Calculate the Interest %
			double expectedInterestPercentageValue = (loansTableMaxLoanAmount / allocatedAmount) * 100;

			// Format the values to one decimal place
			DecimalFormat df = new DecimalFormat("#.#");
			String formattedValue = df.format(expectedInterestPercentageValue);

			double expectedInterestPercentage = Double.parseDouble(formattedValue);

			// Assert that Max Loan Amount in Loan Size Section is same as Max Loan Amount
			// in Loans Table
			IElementActions.assertEquals_usingDouble(node, driver, maxLoanAmount, loansTableMaxLoanAmount,
					"STEP4 : BUG : The Max Loan Amount in Loan Size Section : " + maxLoanAmount
							+ "is not Equal to the Max Loan Amount in Loans Table : " + loansTableMaxLoanAmount,
					"STEP4 : PASS : The Max Loan Amount in Loan Size Section : " + maxLoanAmount
							+ " is Equal to the Max Loan Amount in Loans Table : " + loansTableMaxLoanAmount);

			// Assert that Max Loan Amount Interest % is same as calculated from
			// (loansTableMinLoanAmount / allocatedAmount) * 100
			IElementActions.assertEquals_usingDouble(node, driver, actualMaxLoanAmounntInterestPercentage,
					expectedInterestPercentage,
					"STEP5 : BUG : The Max Loan Amount Interest %  : " + actualMaxLoanAmounntInterestPercentage
							+ " is not same as calculated from (loansTableMinLoanAmount / allocatedAmount) * 100 : "
							+ expectedInterestPercentage,
					"STEP5 : PASS : The Max Loan Amount Interest % : " + actualMaxLoanAmounntInterestPercentage
							+ " is same as calculated from (loansTableMinLoanAmount / allocatedAmount) * 100 : "
							+ expectedInterestPercentage);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateMaxLoanSize", "Pass", driver);

		} catch (AssertionError validateMaxLoanSize) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateMaxLoanSize test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateMaxLoanSize_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMaxLoanSize.printStackTrace();
			node.fail(validateMaxLoanSize);
			Assert.fail();
			extent.flush();

		} catch (Exception validateMaxLoanSize) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateMaxLoanSize test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateMaxLoanSize_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMaxLoanSize.printStackTrace();
			node.fail(validateMaxLoanSize);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_064
	@Test(priority = 58)
	public void validateAverageLoanAmount() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the Average loan size is calculated as per below formula:"
					+ "Allocated Amount/Number of Loans").assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Waiting for Page Loading To Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the deviation value from Excel
			double deviatedValue = Double.parseDouble(getDataFromExcel(12));

			// Get the Number of Loans
			int numberOfLoans = Utils.getTextAndParseToInt(ReportingLoansPO.numberOfLoans);

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for Page Loading To Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Allocated Amount
			double allocatedAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.allocatedAmount);

			// Get the Average Loan Amount
			double actualAverageLoanAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.averageLoanAmount);

			// Calculate the Expected Average Loan Amount
			double calculatedValue = allocatedAmount / Double.valueOf(numberOfLoans);

			String calculated = Utils.getDecimalOneDigit(calculatedValue);

			double expectedAverageLoanAmount = Double.parseDouble(calculated);

			// Assert that Average Loan Amount is Equal to the allocatedAmount /
			// numberOfLoans
			Assert.assertEquals(actualAverageLoanAmount, expectedAverageLoanAmount, deviatedValue,
					"Deviation is greater than expected value and the Average Loan Amount : " + actualAverageLoanAmount
							+ "is not Equal to the allocatedAmount / numberOfLoans : " + expectedAverageLoanAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAverageLoanAmount", "Pass", driver);

		} catch (AssertionError validateAverageLoanAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAverageLoanAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAverageLoanAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAverageLoanAmount.printStackTrace();
			node.fail(validateAverageLoanAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAverageLoanAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAverageLoanAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAverageLoanAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAverageLoanAmount.printStackTrace();
			node.fail(validateAverageLoanAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_065
	@Test(priority = 59)
	public void validateMedianLoanSize() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the Median loan size, including the loan amount and interest rate")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the median loan amount values
			String actualMedianLoanAmount = Utils.getFormattedText(ReportingLoansPO.medianLoanAmount);

			// Get the median loan amount interest rate values
			String actualMedianLoanAmountInterestRate = Utils
					.getFormattedText(ReportingLoansPO.medianLoanAmountInterestRate);

			List<String> currentLoanAmountValues = Utils
					.extractTextFromElementsAndRemoveCurrency(ReportingLoansPO.currentLoanAmountAllValues);

			// Calculate the median
			double median = Utils.calculateMedian(currentLoanAmountValues);

			// Format the rounded median
			String medianCalculated = Utils.getDecimalOneDigit(median);

			// Assert WAverageLTV
			IElementActions.assertEquals_usingString(node, driver, actualMedianLoanAmount, medianCalculated,
					"BUG : The loan amount median: " + actualMedianLoanAmount
							+ " is not equal to the expected calculated loan amount median : " + medianCalculated,
					"PASS : The loan amount median : " + actualMedianLoanAmount
							+ " is equal to the expected calculated loan amount median : " + medianCalculated);

			// Get the Allocated Amount
			double allocatedAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.allocatedAmount);

			// Scroll to the element
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, ReportingLoansPO.currentLoanAmountSortIcon);
			node.log(Status.INFO, "STEP1 : Scrolled to the element");
			System.out.println("STEP1 : Scrolled to the element");

			// Wait for the sort icon to be visible and clickable
			node.log(Status.INFO, "STEP2 : Waiting for the sort icon to be visible and clickable");
			System.out.println("STEP2 : Waiting for the sort icon to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.currentLoanAmountSortIcon);
			node.log(Status.INFO, "STEP3 : Sort icon is visible and clickable");
			System.out.println("STEP3 : Sort icon is visible and clickable");

			// Retrieve the loan amount values sum
			double currentLoanAmountSum = Utils.calculateSumOfList(ReportingLoansPO.currentLoanAmount);

			// Format the values to one decimal place
			DecimalFormat df = new DecimalFormat("#.0");

			double interestRate = (currentLoanAmountSum / allocatedAmount) * 100;
			String formattedValue = df.format(interestRate);

			// Assert loan interest rate
			IElementActions.assertEquals_usingString(node, driver, actualMedianLoanAmountInterestRate, formattedValue,
					"BUG : The median loan amount interest rate: " + actualMedianLoanAmountInterestRate
							+ "is not equal to the expected calculated median loan amount interest rate : "
							+ formattedValue,
					"PASS : The median loan amount interest rate: " + actualMedianLoanAmountInterestRate
							+ " is equal to the expected calculated median loan amount interest rate : "
							+ formattedValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateMedianLoanSize", "Pass", driver);

		} catch (

		AssertionError validateMedianLoanSize) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateMedianLoanSize test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateMedianLoanSize_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMedianLoanSize.printStackTrace();
			node.fail(validateMedianLoanSize);
			Assert.fail();
			extent.flush();

		} catch (Exception validateMedianLoanSize) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateMedianLoanSize test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateMedianLoanSize_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMedianLoanSize.printStackTrace();
			node.fail(validateMedianLoanSize);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_066
	@Test(priority = 60)
	public void validateLTVSection() throws IOException {
		try {
			extenttest = extent.createTest("Verify the LTV section.").assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Verify the LTV Section
			node.log(Status.INFO, "STEP1 : Verify the LTV Section.");
			System.out.println("STEP1 : Verify the LTV Section.");

			// Check the visibility of Min Option
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.lTVMinLabel,
					"STEP2 : BUG: The Min Option is not visible in LTV Section.",
					"STEP2 : EXPECTED: The Min Option is visible in LTV Section");

			// Check the visibility of Max Option
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.lTVMaxLabel,
					"STEP3 : BUG: The Max Option is not visible in LTV Section.",
					"STEP3 : EXPECTED: The Max Option is visible in LTV Section");

			// Check the visibility of W Average Option
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.wAverageLabel,
					"STEP4 : BUG: The W Average Option is not visible in LTV Section.",
					"STEP4 : EXPECTED: The W Average Option is visible in LTV Section");

			// Check the visibility of Median Option
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.lTVMedianLabel,
					"STEP5 : BUG: The Median Option is not visible in LTV Section.",
					"STEP5 : EXPECTED: The Median Option is visible in LTV Section");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLTVSection", "Pass", driver);

		} catch (AssertionError validateLTVSection) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLTVSection test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLTVSection_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLTVSection.printStackTrace();
			node.fail(validateLTVSection);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLTVSection) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLTVSection test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLTVSection_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLTVSection.printStackTrace();
			node.fail(validateLTVSection);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_067
	@Test(priority = 61)
	public void validateMinLTVRatio() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the Minimum Loan-to-Value (LTV) ratio is displayed correctly.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for Page Loading To Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Min LTV in LTV Section
			double minLTV = Utils.getPercentageTextAndParseToDouble(ReportingLoansPO.minLTV);

			// Sort the listing in descending order
			Utils.sortListingInAscendin(ReportingLoansPO.ltvSortIcon, "LTV", ReportingLoansPO.lTVColumnAllValues);

			// Get the First LTV Column Value
			double firstLTVColumnValue = Utils.getPercentageTextAndParseToDouble(ReportingLoansPO.lTVColumnFirstValue);

			// Assert that The min LTV in LTV Section is Equal to the First LTV Value in LTV
			// Column
			IElementActions.assertEquals_usingDouble(node, driver, minLTV, firstLTVColumnValue,
					"STEP1 : BUG : The Min LTV in LTV Section : " + minLTV
							+ "is not Equal to the First LTV Value in LTV Column : " + firstLTVColumnValue,
					"STEP1 : PASS : The Min LTV in LTV Section : " + minLTV
							+ " is Equal to the First LTV Value in LTV Column : " + firstLTVColumnValue);

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateMinLTVRatio", "Fail", driver);

		} catch (AssertionError validateMinLTVRatio) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateMinLTVRatio test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateMinLTVRatio_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMinLTVRatio.printStackTrace();
			node.fail(validateMinLTVRatio);
			Assert.fail();
			extent.flush();

		} catch (Exception validateMinLTVRatio) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateMinLTVRatio test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateMinLTVRatio_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMinLTVRatio.printStackTrace();
			node.fail(validateMinLTVRatio);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_068
	@Test(priority = 62)
	public void validateMaximumLoanToValueLTV() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the Maximum Loan-to-Value (LTV) ratio is displayed correctly.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the ltv values
			double actualMaxLTVValues = Utils.getTextAndParseToDouble(ReportingLoansPO.maxLTV);

			/// Retrieve the highest value
			double highestValue = Utils.getHighestValueFromList(ReportingLoansPO.ltvValues);

			// Assert max ltv values
			IElementActions.assertEquals_usingDouble(node, driver, actualMaxLTVValues, highestValue,
					"BUG : The max ltv : " + actualMaxLTVValues + "is not equal to the expected ltv : " + highestValue,
					"PASS : The max ltv : " + actualMaxLTVValues + " is equal to the expected ltv : " + highestValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAvailableCash", "Pass", driver);

		} catch (AssertionError validateAvailableCash) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAvailableCash test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAvailableCash_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAvailableCash.printStackTrace();
			node.fail(validateAvailableCash);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAvailableCash) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAvailableCash test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAvailableCash_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAvailableCash.printStackTrace();
			node.fail(validateAvailableCash);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_069
	@Test(priority = 63)
	public void validateAverageLoanToValueLTV() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the Average Loan-to-Value (LTV) ratio is displayed correctly."
							+ "WA LTV = SUMPRODUCT(LTV, Allocation)/Allocated of the loans")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the WAverageLTV values
			double WALTV = Utils.getTextAndParseToDouble(ReportingLoansPO.wAverageLTV);
			System.out.println("WALTV " + WALTV);

			// Get the Allocated Amount
			double allocatedAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.allocatedAmount);

			// Scroll to the element
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, ReportingLoansPO.currentLoanAmountSortIcon);
			node.log(Status.INFO, "STEP3 : Scrolled to the element");
			System.out.println("STEP3 : Scrolled to the element");

			// Wait for the sort icon to be visible and clickable
			node.log(Status.INFO, "STEP4 : Waiting for the LTV column to be visible");
			System.out.println("STEP4 : Waiting for the  LTV column to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.lTVColumnAllValues);
			node.log(Status.INFO, "STEP5 :  LTV column is visible");
			System.out.println("STEP5 : LTV column is visible");

			// Retrieve the LTV column values
			List<Double> LTVColumnAllValues = Utils
					.extractPercentageToValueFromElements(ReportingLoansPO.lTVColumnAllValues);

			// Retrieve the allocation values
			List<Double> allocationAllValues = Utils
					.extractDoubleValuesFromElements(ReportingLoansPO.allocationAllValues);

			// Calculate the sumproduct
			double sumProductWALTV = Utils.calculateSumProductForDouble(LTVColumnAllValues, allocationAllValues);

			sumProductWALTV = (sumProductWALTV / allocatedAmount) * 100;

			String calculatedValue = Utils.getDecimalOneDigit(sumProductWALTV);

			double expectedCalculatedValue = Double.parseDouble(calculatedValue);

			// Assert WALTV value
			IElementActions.assertEquals_usingDouble(node, driver, WALTV, expectedCalculatedValue,
					"BUG : The WALTV : " + WALTV + " is not equal to the expected calculated WALTV : "
							+ expectedCalculatedValue,
					"PASS : The WALTV : " + WALTV + " is equal to the expected calculated WALTV : "
							+ expectedCalculatedValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAverageLoanToValueLTV", "Pass", driver);

		} catch (AssertionError validateAverageLoanToValueLTV) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAverageLoanToValueLTV test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAverageLoanToValueLTV_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAverageLoanToValueLTV.printStackTrace();
			node.fail(validateAverageLoanToValueLTV);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAverageLoanToValueLTV) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAverageLoanToValueLTV test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAverageLoanToValueLTV_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAverageLoanToValueLTV.printStackTrace();
			node.fail(validateAverageLoanToValueLTV);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_070
	@Test(priority = 64)
	public void validateMedianLoanToValueLTV() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the Median Loan-to-Value (LTV) ratio is displayed correctly.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the LTVMedian values
			String actualLTVMedian = Utils.getFormattedText(ReportingLoansPO.lTVMedian);
			System.out.println("actualLTVMedian " + actualLTVMedian);

			List<String> lTVColumnValues = Utils
					.extractTextFromElementsAndRemoveCurrency(ReportingLoansPO.lTVColumnAllValues);

			// Calculate the median
			double median = Utils.calculateMedian(lTVColumnValues);

			// Format the rounded median
			String medianCalculated = Utils.getDecimalOneDigit(median);

			// Assert WAverageLTV
			IElementActions.assertEquals_usingString(node, driver, actualLTVMedian, medianCalculated,
					"BUG : The LTVMedian : " + actualLTVMedian + "is not equal to the expected calculated LTVMedian : "
							+ medianCalculated,
					"PASS : The LTVMedian : " + actualLTVMedian + " is equal to the expected calculated LTVMedian : "
							+ medianCalculated);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateMedianLoanToValueLTV", "Pass", driver);

		} catch (AssertionError validateMedianLoanToValueLTV) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateMedianLoanToValueLTV test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateMedianLoanToValueLTV_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMedianLoanToValueLTV.printStackTrace();
			node.fail(validateMedianLoanToValueLTV);
			Assert.fail();
			extent.flush();

		} catch (Exception validateMedianLoanToValueLTV) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateMedianLoanToValueLTV test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateMedianLoanToValueLTV_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMedianLoanToValueLTV.printStackTrace();
			node.fail(validateMedianLoanToValueLTV);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_077
	@Test(priority = 65)
	public void validateKeyStatsSection() throws IOException {
		try {
			extenttest = extent.createTest("Verify the Key Stats section")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Verify the Key Stats Section
			node.log(Status.INFO, "STEP1 : Verify the Key Stats Section.");
			System.out.println("STEP1 : Verify the Key Stats Section.");

			// Check the visibility of Number of Loans
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.numberOfLoan,
					"STEP2 : BUG: The Number of Loans is not visible in Key Stats Section.",
					"STEP2 : EXPECTED: The Number of Loans is visible in Key Stats Section");

			// Check the visibility of WA Maturity
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.wAMaturitys,
					"STEP3 : BUG: The WA Maturity is not visible in Key Stats Section.",
					"STEP3 : EXPECTED: The WA Maturity is visible in Key Stats Section");

			// Check the visibility of Interest Rate
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.interestRate,
					"STEP4 : BUG: The Interest Rate is not visible in Key Stats Section.",
					"STEP4 : EXPECTED: The Interest Rate is visible in Key Stats Section");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateKeyStatsSection", "Pass", driver);

		} catch (AssertionError validateKeyStatsSection) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateKeyStatsSection test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateKeyStatsSection_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateKeyStatsSection.printStackTrace();
			node.fail(validateKeyStatsSection);
			Assert.fail();
			extent.flush();

		} catch (Exception validateKeyStatsSection) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateKeyStatsSection test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateKeyStatsSection_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateKeyStatsSection.printStackTrace();
			node.fail(validateKeyStatsSection);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_078
	@Test(priority = 66)
	public void validateTotalNumberOfLoans() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the syatem correctly displays the number of loans in the user interface.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Waiting for Page Loading To Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Number of Loans in Summary Tab
			int expectedNumberOfLoans = Utils.getTextAndParseToInt(ReportingLoansPO.numberOfLoans);

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for Page Loading To Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Number of Loans in Loan Portfolio Tab
			String actualNumberOfLoans = IElementActions.getTextbyXpath(node, ReportingLoansPO.numberOfLoansValue)
					.substring(0, 2);

			// Assert that Number of Loans in Loan Portfolio Tab is same as Number of Loans
			// in Summary Tab
			IElementActions.assertEquals_usingInteger(node, driver, Integer.valueOf(actualNumberOfLoans),
					expectedNumberOfLoans,
					"STEP1 : BUG : Number of Loans in Loan Portfolio Tab : " + actualNumberOfLoans
							+ "is not same as Number of Loans in Summary Tab :" + expectedNumberOfLoans,
					"STEP1 : PASS : Number of Loans in Loan Portfolio Tab : " + actualNumberOfLoans
							+ "is same as Number of Loans in Summary Tab : " + expectedNumberOfLoans);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateTotalNumberOfLoans", "Pass", driver);

		} catch (AssertionError validateTotalNumberOfLoans) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateTotalNumberOfLoans test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTotalNumberOfLoans_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalNumberOfLoans.printStackTrace();
			node.fail(validateTotalNumberOfLoans);
			Assert.fail();
			extent.flush();

		} catch (Exception validateTotalNumberOfLoans) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateTotalNumberOfLoans test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTotalNumberOfLoans_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalNumberOfLoans.printStackTrace();
			node.fail(validateTotalNumberOfLoans);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_079
	@Test(priority = 67)
	public void validateWeightedAverageMaturity() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the calculation of the Weighted Average Maturity is accurate.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Waiting for Page Loading To Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the WA Maturity in Summary Tab
			String expectedWAMaturity = IElementActions.getTextbyXpath(node, ReportingLoansPO.wAMaturity).substring(0,
					2);

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for Page Loading To Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the WA Maturity in Loan Portfolio Tab
			String actualWAMaturity = IElementActions.getTextbyXpath(node, ReportingLoansPO.wAMaturityValue)
					.substring(0, 2);

			// Assert that WA Maturity in Loan Portfolio Tab is same as WA Maturity
			// in Summary Tab
			IElementActions.assertEquals_usingInteger(node, driver, Integer.parseInt(actualWAMaturity),
					Integer.parseInt(expectedWAMaturity),
					"STEP1 : BUG :WA Maturity in Loan Portfolio Tab : " + actualWAMaturity
							+ "is not same as WA Maturity in Summary Tab :" + expectedWAMaturity,
					"STEP1 : PASS : WA Maturity in Loan Portfolio Tab : " + actualWAMaturity
							+ "is same as WA Maturity in Summary Tab : " + expectedWAMaturity);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateWeightedAverageMaturity", "Pass", driver);

		} catch (AssertionError validateWeightedAverageMaturity) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateWeightedAverageMaturity test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateWeightedAverageMaturity_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateWeightedAverageMaturity.printStackTrace();
			node.fail(validateWeightedAverageMaturity);
			Assert.fail();
			extent.flush();

		} catch (Exception validateWeightedAverageMaturity) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateWeightedAverageMaturity test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateWeightedAverageMaturity_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateWeightedAverageMaturity.printStackTrace();
			node.fail(validateWeightedAverageMaturity);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_080
	@Test(priority = 68)
	public void validateInterestRateOnFullDrawn() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the interest rate on the full drawn balance is accurately calculated and displayed in the system")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Waiting for Page Loading To Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Facility Interest in Summary Tab
			double facilityInterest = Utils.getPercentageTextAndParseToDouble(ReportingLoansPO.facilityInterest);

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for Page Loading To Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Interest Rate in Loan Portfolio Tab
			double interestRate = Utils.getPercentageTextAndParseToDouble(ReportingLoansPO.interestRateValue);

			// Assert that Interest Rate in Loan Portfolio Tab is same as Facility Interest
			// in Summary Tab
			IElementActions.assertEquals_usingDouble(node, driver, interestRate, facilityInterest,
					"STEP1 : BUG :Interest Rate in Loan Portfolio Tab : " + interestRate
							+ "is not same as Facility Interest in Summary Tab :" + facilityInterest,
					"STEP1 : PASS : Interest Rate in Loan Portfolio Tab : " + interestRate
							+ "is same as Facility Interest in Summary Tab : " + facilityInterest);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateInterestRateOnFullDrawn", "Pass", driver);

		} catch (AssertionError validateInterestRateOnFullDrawn) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInterestRateOnFullDrawn test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestRateOnFullDrawn_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestRateOnFullDrawn.printStackTrace();
			node.fail(validateInterestRateOnFullDrawn);
			Assert.fail();
			extent.flush();

		} catch (Exception validateInterestRateOnFullDrawn) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInterestRateOnFullDrawn test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestRateOnFullDrawn_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestRateOnFullDrawn.printStackTrace();
			node.fail(validateInterestRateOnFullDrawn);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_087
	@Test(priority = 69)
	public void validateTop5Borrowers() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the top 5 borrowers along with their borrower number, borrower type, loan amount, and interest rate.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Allocated Amount
			double allocatedAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.allocatedAmount);

			List<String> actualTop5HighestValue = Utils
					.extractTextFromElements(ReportingLoansPO.top5BorrowerLoanAmount);

			List<String> actualTop5BorrowerReference = Utils
					.extractTextFromElementsAndRemoveCurrency(ReportingLoansPO.top5LoanBorrowerReference);

			List<String> actualTop5BorrowerType = Utils.extractTextFromElements(ReportingLoansPO.top5BorrowerType);

			List<String> actualTop5LoanInterestRate = Utils
					.extractTextFromElements(ReportingLoansPO.top5LoanBorrowerInterestRate);

			// Format the values to one decimal place
			// DecimalFormat df = new DecimalFormat("#.#");
			DecimalFormat df = new DecimalFormat("#.0");

			List<String> expectedInterestRateValues = new ArrayList<>();
			// Print each element of the ArrayList
			for (String loanAmount : actualTop5HighestValue) {
				double loanAmountValue = Utils.parseCurrencyValueToDouble(loanAmount);
				double interestRate = (loanAmountValue / allocatedAmount) * 100;
				expectedInterestRateValues.add(df.format(interestRate));
				System.out.println(df.format(interestRate));
			}

			// Validate top 5 interest rate
			Utils.validateStringList(actualTop5LoanInterestRate, expectedInterestRateValues,
					"STEP1 : Actual top 5 loans interest rate are not equal in loan database and expected  top 5 loan interest rate of reporting loans",
					"STEP1 : Actual top 5 loans interest rate are equal in loan database and expected  top 5 loan interest rate of reporting loans");

			// Calling the loadDatabasePage from LoansPage
			LoansPage.loadDatabasePage();

			// Check cross icon is available or not
			boolean checkCrossIcon = IElementActions.isElementAvailable(node, driver, UtilsPO.headerSearchCrossIcon);

			// If cross icon is present, click on it to clear the search
			if (checkCrossIcon) {
				// Click on the cross icon to clear the search
				IElementActions.clickelement_usingXpath(node, driver, UtilsPO.headerSearchCrossIcon);
				node.log(Status.INFO, "STEP_0.001 : clicked on the cross icon");
				System.out.println("STEP_0.001 : clicked on the cross icon");
			}

			// Wait for the sort icon to be visible and clickable
			node.log(Status.INFO, "STEP2 : Waiting for the sort icon to be visible and clickable");
			System.out.println("STEP2 : Waiting for the sort icon to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, LoansDatabasePO.amountSortIcon);
			node.log(Status.INFO, "STEP3 : Sort icon is visible and clickable");
			System.out.println("STEP3 : Sort icon is visible and clickable");

			// Sort the listing in descending order
			Utils.sortListingInDescendin(LoansDatabasePO.amountSortIcon, "Amount", LoansDatabasePO.amountValues);

			// Wait for the amount to be visible
			node.log(Status.INFO, "STEP4 : Waiting for the amount to be visible");
			System.out.println("STEP4 : Waiting for the amount to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, LoansDatabasePO.amountValues);
			node.log(Status.INFO, "STEP5 : Amount is visible");
			System.out.println("STEP5 : Amount is visible");

			Thread.sleep(1000);
			List<String> expectedMaxLoanAmountValues = Utils.getStarting5Values(LoansDatabasePO.amountValues);

			// Retrieve the borrower reference
			List<String> expectedBorrowerReferenceValue = Utils.getStarting5Values(LoansDatabasePO.borrowerReference);

			List<String> expectedBorrowerTyepValues = new ArrayList<>();
			// Print each element of the ArrayList
			for (String borrowerReferenceNumber : actualTop5BorrowerReference) {
				// Calling the loadDatabasePage from LoansPage
				LoansPage.loadDatabasePage();

				// Wait for the sort icon to be visible and clickable
				node.log(Status.INFO, "STEP6 : Waiting for the edit icon visible and clickable");
				System.out.println("STEP6 : Waiting for the edit icon to be visible and clickable");
				IWaitStrategy.waitForVisiblity(node, driver, UtilsPO.editIcon);
				IWaitStrategy.WaitUntilElementClickable(node, driver, UtilsPO.editIcon);
				node.log(Status.INFO, "STEP7 : Edit icon is visible and clickable");
				System.out.println("STEP7 : Edit icon is visible and clickable");

				Thread.sleep(1000);
				// Search record based on the provide loan reference and open it
				Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, LoansDatabasePO.borrowerRefSearchField,
						borrowerReferenceNumber, UtilsPO.editIcon, LoansNewLoanPO.editBridgeLoanHeaderText);

				// Get borrower value
				String value = IElementActions.getElementValue(node, driver, LoansNewLoanPO.activeBorrowerType);
				expectedBorrowerTyepValues.add(value);
			}

			// Validate top 5 borrower type
			Utils.validateStringList(actualTop5BorrowerType, expectedBorrowerTyepValues,
					"STEP8 : Actual top 5 loans borrower type are not equal in loan database and expected top 5 loan borrower type of reporting loans",
					"STEP8 : Actual top 5 loans borrower type are equal in loan database and expected top 5 loan borrower type of reporting loans");

			// Validate top 5 loan borrower
			Utils.validateStringList(actualTop5BorrowerReference, expectedBorrowerReferenceValue,
					"STEP9 : Actual top 5 loan borrower reference are not equal in loan database and expected top 5 loan borrower reference of reporting loans",
					"STEP9 : Actual top 5 loan borrower reference are equal in loan database and expected top 5 loan borrower reference of reporting loans");

			// Validate highest loan amount value
			Utils.validateStringList(actualTop5HighestValue, expectedMaxLoanAmountValues,
					"STEP10 : The loan with the maximum amount at the top of the loan database list is not equal to the top 5 loan of reporting loans",
					"STEP10 : The loan with the maximum amount at the top of the loan database list is displayed and is equal to the top 5 loan of reporting loans");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateTop5Borrowers", "Pass", driver);

		} catch (AssertionError validateTop5Borrowers) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateTop5Borrowers test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTop5Borrowers_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTop5Borrowers.printStackTrace();
			node.fail(validateTop5Borrowers);
			Assert.fail();
			extent.flush();

		} catch (Exception validateTop5Borrowers) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateTop5Borrowers test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTop5Borrowers_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTop5Borrowers.printStackTrace();
			node.fail(validateTop5Borrowers);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_088
	@Test(priority = 70)
	public void validateBorrowersInDescending() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays borrowers in descending order based on the loan amount")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			List<String> actualTop5BorrowerReference = Utils
					.extractTextFromElementsAndRemoveCurrency(ReportingLoansPO.top5LoanBorrowerReference);

			// Calling the loadDatabasePage from LoansPage
			LoansPage.loadDatabasePage();

			// Check cross icon is available or not
			boolean checkCrossIcon = IElementActions.isElementAvailable(node, driver, UtilsPO.headerSearchCrossIcon);

			// If cross icon is present, click on it to clear the search
			if (checkCrossIcon) {
				// Click on the cross icon to clear the search
				IElementActions.clickelement_usingXpath(node, driver, UtilsPO.headerSearchCrossIcon);
				node.log(Status.INFO, "STEP_0.001 : clicked on the cross icon");
				System.out.println("STEP_0.001 : clicked on the cross icon");
			}

			// Wait for the sort icon to be visible and clickable
			node.log(Status.INFO, "STEP1 : Waiting for the sort icon to be visible and clickable");
			System.out.println("STEP1 : Waiting for the sort icon to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, LoansDatabasePO.amountSortIcon);
			node.log(Status.INFO, "STEP2 : Sort icon is visible and clickable");
			System.out.println("STEP2 : Sort icon is visible and clickable");

			// Sort the listing in descending order
			Utils.sortListingInDescendin(LoansDatabasePO.amountSortIcon, "Amount", LoansDatabasePO.amountValues);

			// Wait for the borrower to be visible
			node.log(Status.INFO, "STEP3 : Waiting for the borrower to be visible");
			System.out.println("STEP3 : Waiting for the borrower to be visible");
			IWaitStrategy.waitForVisiblity(node, driver, LoansDatabasePO.borrowerReference);
			node.log(Status.INFO, "STEP4 : Borrower is visible");
			System.out.println("STEP4 : Borrower is visible");

			Thread.sleep(1000);
			// Retrieve the borrower reference
			List<String> expectedBorrowerReferenceValue = Utils.getStarting5Values(LoansDatabasePO.borrowerReference);

			// Validate top 5 loan borrower
			Utils.validateStringList(actualTop5BorrowerReference, expectedBorrowerReferenceValue,
					"STEP5 : Actual top 5 loan borrower reference in reporting are equal to the expected top 5 loan borrower reference of database",
					"STEP5 : Actual top 5 loan borrower reference in reporting are equal to the expected top 5 loan borrower reference of database");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateBorrowersInDescending", "Pass", driver);

		} catch (AssertionError validateBorrowersInDescending) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateBorrowersInDescending test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBorrowersInDescending_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBorrowersInDescending.printStackTrace();
			node.fail(validateBorrowersInDescending);
			Assert.fail();
			extent.flush();

		} catch (Exception validateBorrowersInDescending) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateBorrowersInDescending test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBorrowersInDescending_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBorrowersInDescending.printStackTrace();
			node.fail(validateBorrowersInDescending);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_089
	@Test(priority = 71)
	public void validateMaximumLoanAmountOnBorrower() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the system accurately displays the maximum loan amount at the top")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			Thread.sleep(2000);
			// List<String> actualTop5HighestValue =
			// Utils.extractTextFromElements(ReportingLoansPO.top5LoanAmount);

			List<String> actualTop5HighestValue = Utils
					.extractTextFromElements(ReportingLoansPO.top5BorrowerLoanAmount);

			// Calling the loadDatabasePage from LoansPage
			LoansPage.loadDatabasePage();

			// Check cross icon is available or not
			boolean checkCrossIcon = IElementActions.isElementAvailable(node, driver, UtilsPO.headerSearchCrossIcon);

			// If cross icon is present, click on it to clear the search
			if (checkCrossIcon) {
				// Click on the cross icon to clear the search
				IElementActions.clickelement_usingXpath(node, driver, UtilsPO.headerSearchCrossIcon);
				node.log(Status.INFO, "STEP_0.001 : clicked on the cross icon");
				System.out.println("STEP_0.001 : clicked on the cross icon");
			}

			// Wait for the sort icon to be visible and clickable
			node.log(Status.INFO, "STEP1 : Waiting for the sort icon to be visible and clickable");
			System.out.println("STEP1 : Waiting for the sort icon to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, LoansDatabasePO.amountSortIcon);
			node.log(Status.INFO, "STEP2 : Sort icon is visible and clickable");
			System.out.println("STEP2 : Sort icon is visible and clickable");

			// Sort the listing in descending order
			Utils.sortListingInDescendin(LoansDatabasePO.amountSortIcon, "Amount", LoansDatabasePO.amountValues);

			List<String> expectedMaxLoanAmountValues = Utils.getStarting5Values(LoansDatabasePO.amountValues);

			String actualMaxValue = actualTop5HighestValue.get(0);
			String expectedMaxValue = expectedMaxLoanAmountValues.get(0);

			// Validate highest loan amount value
			IElementActions.assertEquals_usingString(node, driver, actualMaxValue, expectedMaxValue,
					"STEP3 : The loan with the maximum amount at the top of the list " + actualMaxValue
							+ " is not equal to the expected max loan of reporting " + expectedMaxValue,
					"STEP3 : The loan with the maximum amount at the top of the list " + actualMaxValue
							+ " is equal to the expected max loan of reporting " + expectedMaxValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateMaximumLoanAmountOnBorrower", "Pass", driver);

		} catch (AssertionError validateMaximumLoanAmountOnBorrower) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateMaximumLoanAmountOnBorrower test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateMaximumLoanAmountOnBorrower_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMaximumLoanAmountOnBorrower.printStackTrace();
			node.fail(validateMaximumLoanAmountOnBorrower);
			Assert.fail();
			extent.flush();

		} catch (Exception validateMaximumLoanAmountOnBorrower) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateMaximumLoanAmountOnBorrower test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateMaximumLoanAmountOnBorrower_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMaximumLoanAmountOnBorrower.printStackTrace();
			node.fail(validateMaximumLoanAmountOnBorrower);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_090
	@Test(priority = 72)
	public void validateBorrowerTypeBelowBorrowerName() throws IOException {
		try {
			extenttest = extent
					.createTest(
							"Verify that the system accurately displays the borrower type below the borrower number")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			List<String> actualTop5BorrowerReference = Utils
					.extractTextFromElementsAndRemoveCurrency(ReportingLoansPO.top5LoanBorrowerReference);

			List<String> actualTop5BorrowerType = Utils.extractTextFromElements(ReportingLoansPO.top5BorrowerType);

			// Calling the loadDatabasePage from LoansPage
			LoansPage.loadDatabasePage();

			// Check cross icon is available or not
			boolean checkCrossIcon = IElementActions.isElementAvailable(node, driver, UtilsPO.headerSearchCrossIcon);

			// If cross icon is present, click on it to clear the search
			if (checkCrossIcon) {
				// Click on the cross icon to clear the search
				IElementActions.clickelement_usingXpath(node, driver, UtilsPO.headerSearchCrossIcon);
				node.log(Status.INFO, "STEP_0.001 : clicked on the cross icon");
				System.out.println("STEP_0.001 : clicked on the cross icon");
			}

			// Wait for the sort icon to be visible and clickable
			node.log(Status.INFO, "STEP1 : Waiting for the sort icon to be visible and clickable");
			System.out.println("STEP1 : Waiting for the sort icon to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, LoansDatabasePO.amountSortIcon);
			node.log(Status.INFO, "STEP2 : Sort icon is visible and clickable");
			System.out.println("STEP2 : Sort icon is visible and clickable");

			List<String> expectedBorrowerTyepValues = new ArrayList<>();
			// Print each element of the ArrayList
			for (String borrowerReferenceNumber : actualTop5BorrowerReference) {
				// Calling the loadDatabasePage from LoansPage
				LoansPage.loadDatabasePage();

				// Wait for the sort icon to be visible and clickable
				node.log(Status.INFO, "STEP3 : Waiting for the edit icon visible and clickable");
				System.out.println("STEP3 : Waiting for the edit icon to be visible and clickable");
				IWaitStrategy.waitForVisiblity(node, driver, UtilsPO.editIcon);
				IWaitStrategy.WaitUntilElementClickable(node, driver, UtilsPO.editIcon);
				node.log(Status.INFO, "STEP4 : Edit icon is visible and clickable");
				System.out.println("STEP4 : Edit icon is visible and clickable");

				Thread.sleep(1000);
				// Search record based on the provide loan reference and open it
				Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, LoansDatabasePO.borrowerRefSearchField,
						borrowerReferenceNumber, UtilsPO.editIcon, LoansNewLoanPO.editBridgeLoanHeaderText);

				// Get borrower value
				String value = IElementActions.getElementValue(node, driver, LoansNewLoanPO.activeBorrowerType);
				expectedBorrowerTyepValues.add(value);
			}

			// Validate top 5 borrower type
			Utils.validateStringList(actualTop5BorrowerType, expectedBorrowerTyepValues,
					"STEP5 : Actual top 5 loans borrower type are not equal in loan database and expected top 5 loan borrower type of reporting loans",
					"STEP85 : Actual top 5 loans borrower type are equal in loan database and expected top 5 loan borrower type of reporting loans");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateBorrowerTypeBelowBorrowerName", "Pass", driver);

		} catch (AssertionError validateBorrowerTypeBelowBorrowerName) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateBorrowerTypeBelowBorrowerName test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBorrowerTypeBelowBorrowerName_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBorrowerTypeBelowBorrowerName.printStackTrace();
			node.fail(validateBorrowerTypeBelowBorrowerName);
			Assert.fail();
			extent.flush();

		} catch (Exception validateBorrowerTypeBelowBorrowerName) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateBorrowerTypeBelowBorrowerName test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBorrowerTypeBelowBorrowerName_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBorrowerTypeBelowBorrowerName.printStackTrace();
			node.fail(validateBorrowerTypeBelowBorrowerName);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_091
	@Test(priority = 73)
	public void validateBorrowerInterestRate() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the system accurately displays the interest rate for each respective loan")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Allocated Amount
			double allocatedAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.allocatedAmount);

			List<String> actualTop5HighestValue = Utils
					.extractTextFromElements(ReportingLoansPO.top5BorrowerLoanAmount);

			List<String> actualTop5LoanInterestRate = Utils
					.extractTextFromElements(ReportingLoansPO.top5LoanBorrowerInterestRate);

			// Format the values to one decimal place
			// DecimalFormat df = new DecimalFormat("#.#");
			DecimalFormat df = new DecimalFormat("#.0");

			List<String> expectedInterestRateValues = new ArrayList<>();
			// Print each element of the ArrayList
			for (String loanAmount : actualTop5HighestValue) {
				double loanAmountValue = Utils.parseCurrencyValueToDouble(loanAmount);
				double interestRate = (loanAmountValue / allocatedAmount) * 100;
				expectedInterestRateValues.add(df.format(interestRate));
				System.out.println(df.format(interestRate));
			}

			// Validate top 5 interest rate
			Utils.validateStringList(actualTop5LoanInterestRate, expectedInterestRateValues,
					"STEP1 : Actual top 5 loans interest rate are not equal in loan database and expected  top 5 loan interest rate of reporting loans",
					"STEP1 : Actual top 5 loans interest rate are equal in loan database and expected  top 5 loan interest rate of reporting loans");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateBorrowerInterestRate", "Pass", driver);

		} catch (AssertionError validateBorrowerInterestRate) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateBorrowerInterestRate test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateBorrowerInterestRate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBorrowerInterestRate.printStackTrace();
			node.fail(validateBorrowerInterestRate);
			Assert.fail();
			extent.flush();

		} catch (Exception validateBorrowerInterestRate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateBorrowerInterestRate test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateBorrowerInterestRate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBorrowerInterestRate.printStackTrace();
			node.fail(validateBorrowerInterestRate);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_092
	@Test(priority = 74)
	public void validateTop5Loans() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the top 5 loans, including borrower name, loan disbursement date, loan amount, and interest rate")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Allocated Amount
			double allocatedAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.allocatedAmount);

			List<String> actualTop5HighestValue = Utils.extractTextFromElements(ReportingLoansPO.top5LoanAmount);

			List<String> actualTop5LoanInternalReference = Utils
					.extractTextFromElementsAndRemoveCurrency(ReportingLoansPO.top5LoanInternalReference);

			List<String> actualTop5LoanDisbursementDate = Utils
					.extractTextFromElements(ReportingLoansPO.top5LoanDisbursementDate);

			List<String> actualTop5LoanInterestRate = Utils
					.extractTextFromElements(ReportingLoansPO.top5LoanInterestRate);

			// Scroll to the element
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, ReportingLoansPO.currentLoanAmountSortIcon);
			node.log(Status.INFO, "STEP1 : Scrolled to the element");
			System.out.println("STEP1 : Scrolled to the element");

			// Wait for the sort icon to be visible and clickable
			node.log(Status.INFO, "STEP2 : Waiting for the sort icon to be visible and clickable");
			System.out.println("STEP2 : Waiting for the sort icon to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.currentLoanAmountSortIcon);
			node.log(Status.INFO, "STEP3 : Sort icon is visible and clickable");
			System.out.println("STEP3 : Sort icon is visible and clickable");

			// Sort the listing in descending order
			Utils.sortListingInDescendin(ReportingLoansPO.currentLoanAmountSortIcon, "Current Loan Amount",
					ReportingLoansPO.currentLoanAmount);

			// Retrieve the loan reference
			List<String> loanReferenceValue = Utils.getStarting5Values(ReportingLoansPO.loanReference);

			// Retrieve the internal reference
			List<String> expectedInternalReferenceValue = Utils.getStarting5Values(ReportingLoansPO.internalReference);

			// Retrieve the highest value
			List<String> expectedTop5HighestValue = Utils.getStarting5Values(ReportingLoansPO.currentLoanAmount);

			// Validate highest loan amount value
			Utils.validateList(actualTop5HighestValue, expectedTop5HighestValue,
					"STEP4 : Actual top 5 loans are not equal to the expected top 5 loans",
					"STEP4 : Actual top 5 loans are equal to the expected top 5 loans");

			// Validate top 5 loan borrower
			Utils.validateStringList(actualTop5LoanInternalReference, expectedInternalReferenceValue,
					"STEP5 : Actual top 5 loan internal reference are not equal to the expected top 5 loan internal reference",
					"STEP5 : Actual top 5 loan internal reference are equal to the expected top 5 loan internal reference");

			// Format the values to one decimal place
			DecimalFormat df = new DecimalFormat("#.#");

			List<String> expectedInterestRateValues = new ArrayList<>();
			// Print each element of the ArrayList
			for (String loanAmount : actualTop5HighestValue) {
				double loanAmountValue = Utils.parseCurrencyValueToDouble(loanAmount);
				double interestRate = (loanAmountValue / allocatedAmount) * 100;
				expectedInterestRateValues.add(df.format(interestRate));
			}

			// Validate top 5 interest rate
			Utils.validateStringList(actualTop5LoanInterestRate, expectedInterestRateValues,
					"STEP6 : Actual top 5 loans interest rate are not equal to the expected top 5 loan interest rate",
					"STEP6 : Actual top 5 loans interest rate are equal to the expected top 5 loan interest rate");

			List<String> expectedDisbursementValues = new ArrayList<>();
			// Print each element of the ArrayList
			for (String loanReferenceNumber : loanReferenceValue) {
				// Calling the loadDatabasePage from LoansPage
				LoansPage.loadDatabasePage();

				// Search record based on the provide loan reference and open it
				Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, LoansDatabasePO.loanRefSearchField,
						loanReferenceNumber, UtilsPO.editIcon, LoansNewLoanPO.editBridgeLoanHeaderText);

				// Click on summary tab
				Utils.clickOnTab(LoansNewLoanPO.summaryTab, LoansNewLoanPO.loanDetailsHeader, "Summary");

				// Get first row disbursement date
				String dateValue = IElementActions.getElementText_usingXpath(node, driver,
						LoansNewLoanPO.disbursementDate);

				dateValue = Utils.formatText(dateValue);
				expectedDisbursementValues.add(dateValue);
			}

			// Validate top 5 loan disbursement
			Utils.validateStringList(actualTop5LoanDisbursementDate, expectedDisbursementValues,
					"STEP7 : Actual top 5 loans disbursement are not equal to the expected top 5 loan disbursement",
					"STEP7 : Actual top 5 loans disbursement are equal to the expected top 5 loan disbursement");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateTop5Loans", "Pass", driver);

		} catch (AssertionError validateTop5Loans) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateTop5Loans test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTop5Loans_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTop5Loans.printStackTrace();
			node.fail(validateTop5Loans);
			Assert.fail();
			extent.flush();

		} catch (Exception validateTop5Loans) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateTop5Loans test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTop5Loans_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTop5Loans.printStackTrace();
			node.fail(validateTop5Loans);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_093
	@Test(priority = 75)
	public void validateLoanInDescending() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays loans in descending order based on the loan amount")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			List<String> actualTop5HighestValue = Utils.extractTextFromElements(ReportingLoansPO.top5LoanAmount);

			List<String> actualTop5LoanInternalReference = Utils
					.extractTextFromElementsAndRemoveCurrency(ReportingLoansPO.top5LoanInternalReference);

			// Scroll to the element
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, ReportingLoansPO.currentLoanAmountSortIcon);
			node.log(Status.INFO, "STEP1 : Scrolled to the element");
			System.out.println("STEP1 : Scrolled to the element");

			// Wait for the sort icon to be visible and clickable
			node.log(Status.INFO, "STEP2 : Waiting for the sort icon to be visible and clickable");
			System.out.println("STEP2 : Waiting for the sort icon to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.currentLoanAmountSortIcon);
			node.log(Status.INFO, "STEP3 : Sort icon is visible and clickable");
			System.out.println("STEP3 : Sort icon is visible and clickable");

			// Sort the listing in descending order
			Utils.sortListingInDescendin(ReportingLoansPO.currentLoanAmountSortIcon, "Current Loan Amount",
					ReportingLoansPO.currentLoanAmount);

			// Retrieve the internal reference
			List<String> expectedInternalReferenceValue = Utils.getStarting5Values(ReportingLoansPO.internalReference);

			// Retrieve the highest value
			List<String> expectedTop5HighestValue = Utils.getStarting5Values(ReportingLoansPO.currentLoanAmount);

			// Validate highest loan amount value
			Utils.validateList(actualTop5HighestValue, expectedTop5HighestValue,
					"STEP4 : Actual top 5 loans are not equal to the expected top 5 loans",
					"STEP4 : Actual top 5 loans are equal to the expected top 5 loans");

			// Validate top 5 loan borrower
			Utils.validateStringList(actualTop5LoanInternalReference, expectedInternalReferenceValue,
					"STEP5 : Actual top 5 loan internal reference are not equal to the expected top 5 loan internal reference",
					"STEP5 : Actual top 5 loan internal reference are equal to the expected top 5 loan internal reference");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanInDescending", "Pass", driver);

		} catch (AssertionError validateLoanInDescending) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanInDescending test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanInDescending_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanInDescending.printStackTrace();
			node.fail(validateLoanInDescending);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanInDescending) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanInDescending test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanInDescending_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanInDescending.printStackTrace();
			node.fail(validateLoanInDescending);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_094
	@Test(priority = 76)
	public void validateMaximumLoanAmount() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the system accurately displays the maximum loan amount at the top")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			Thread.sleep(2000);
			List<String> actualTop5HighestValue = Utils.extractTextFromElements(ReportingLoansPO.top5LoanAmount);

			// Calling the loadDatabasePage from LoansPage
			LoansPage.loadDatabasePage();

			// Check cross icon is available or not
			boolean checkCrossIcon = IElementActions.isElementAvailable(node, driver, UtilsPO.headerSearchCrossIcon);

			// If cross icon is present, click on it to clear the search
			if (checkCrossIcon) {
				// Click on the cross icon to clear the search
				IElementActions.clickelement_usingXpath(node, driver, UtilsPO.headerSearchCrossIcon);
				node.log(Status.INFO, "STEP_0.001 : clicked on the cross icon");
				System.out.println("STEP_0.001 : clicked on the cross icon");
			}

			// Wait for the sort icon to be visible and clickable
			node.log(Status.INFO, "STEP1 : Waiting for the sort icon to be visible and clickable");
			System.out.println("STEP1 : Waiting for the sort icon to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, LoansDatabasePO.amountSortIcon);
			node.log(Status.INFO, "STEP2 : Sort icon is visible and clickable");
			System.out.println("STEP2 : Sort icon is visible and clickable");

			// Sort the listing in descending order
			Utils.sortListingInDescendin(LoansDatabasePO.amountSortIcon, "Amount", LoansDatabasePO.amountValues);

			List<String> expectedMaxLoanAmountValues = Utils.getStarting5Values(LoansDatabasePO.amountValues);

			String actualMaxValue = actualTop5HighestValue.get(0);
			String expectedMaxValue = expectedMaxLoanAmountValues.get(0);

			// Validate highest loan amount value
			IElementActions.assertEquals_usingString(node, driver, actualMaxValue, expectedMaxValue,
					"STEP3 : The loan with the maximum amount at the top of the list " + actualMaxValue
							+ " is not equal to the expected max loan of reporting " + expectedMaxValue,
					"STEP3 : The loan with the maximum amount at the top of the list " + actualMaxValue
							+ " is equal to the expected max loan of reporting " + expectedMaxValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateMaximumLoanAmount", "Pass", driver);

		} catch (AssertionError validateMaximumLoanAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateMaximumLoanAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateMaximumLoanAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMaximumLoanAmount.printStackTrace();
			node.fail(validateMaximumLoanAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateMaximumLoanAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateMaximumLoanAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateMaximumLoanAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMaximumLoanAmount.printStackTrace();
			node.fail(validateMaximumLoanAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_095
	@Test(priority = 23)
	public void validateLoanDisbursementDate() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the loan disbursement date along with the borrower name in the user interface")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			List<String> actualTop5LoanInternalReference = Utils
					.extractTextFromElementsAndRemoveCurrency(ReportingLoansPO.top5LoanInternalReference);

			List<String> actualTop5LoanDisbursementDate = Utils
					.extractTextFromElements(ReportingLoansPO.top5LoanDisbursementDate);

			// Scroll to the element
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, ReportingLoansPO.currentLoanAmountSortIcon);
			node.log(Status.INFO, "STEP1 : Scrolled to the element");
			System.out.println("STEP1 : Scrolled to the element");

			// Wait for the sort icon to be visible and clickable
			node.log(Status.INFO, "STEP2 : Waiting for the sort icon to be visible and clickable");
			System.out.println("STEP2 : Waiting for the sort icon to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.currentLoanAmountSortIcon);
			node.log(Status.INFO, "STEP3 : Sort icon is visible and clickable");
			System.out.println("STEP3 : Sort icon is visible and clickable");

			// Sort the listing in descending order
			Utils.sortListingInDescendin(ReportingLoansPO.currentLoanAmountSortIcon, "Current Loan Amount",
					ReportingLoansPO.currentLoanAmount);

			// Retrieve the loan reference
			List<String> loanReferenceValue = Utils.getStarting5Values(ReportingLoansPO.loanReference);

			// Calling the loadDatabasePage from LoansPage
			LoansPage.loadDatabasePage();

			// Check cross icon is available or not
			boolean checkCrossIcon = IElementActions.isElementAvailable(node, driver, UtilsPO.headerSearchCrossIcon);

			// If cross icon is present, click on it to clear the search
			if (checkCrossIcon) {
				// Click on the cross icon to clear the search
				IElementActions.clickelement_usingXpath(node, driver, UtilsPO.headerSearchCrossIcon);
				node.log(Status.INFO, "STEP_0.001 : clicked on the cross icon");
				System.out.println("STEP_0.001 : clicked on the cross icon");
			}

			// Wait for the sort icon to be visible and clickable
			node.log(Status.INFO, "STEP4 : Waiting for the sort icon to be visible and clickable");
			System.out.println("STEP4 : Waiting for the sort icon to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, LoansDatabasePO.currentAmount);
			node.log(Status.INFO, "STEP5 : Sort icon is visible and clickable");
			System.out.println("STEP5 : Sort icon is visible and clickable");

			// Sort the listing in descending order
			Utils.sortListingInDescendin(LoansDatabasePO.currentAmount, "Current Amount",
					LoansDatabasePO.currentLoanAmount);

			List<String> expectedInternalReferenceValues = Utils.getStarting5Values(LoansDatabasePO.internalReference);

			// Validate top 5 loan borrower
			Utils.validateStringList(actualTop5LoanInternalReference, expectedInternalReferenceValues,
					"STEP6 : Actual top 5 loan internal reference are not equal to the expected top 5 loan internal reference",
					"STEP6 : Actual top 5 loan internal reference are equal to the expected top 5 loan internal reference");

			List<String> expectedDisbursementValues = new ArrayList<>();
			// Print each element of the ArrayList
			for (String loanReferenceNumber : loanReferenceValue) {
				// Calling the loadDatabasePage from LoansPage
				LoansPage.loadDatabasePage();

				// Search record based on the provide loan reference and open it
				Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, LoansDatabasePO.loanRefSearchField,
						loanReferenceNumber, UtilsPO.editIcon, LoansNewLoanPO.editBridgeLoanHeaderText);

				// Click on summary tab
				Utils.clickOnTab(LoansNewLoanPO.summaryTab, LoansNewLoanPO.loanDetailsHeader, "Summary");

				// Get first row disbursement date
				String dateValue = IElementActions.getElementText_usingXpath(node, driver,
						LoansNewLoanPO.disbursementDate);

				dateValue = Utils.formatText(dateValue);
				expectedDisbursementValues.add(dateValue);
			}

			// Validate top 5 loan disbursement
			Utils.validateStringList(actualTop5LoanDisbursementDate, expectedDisbursementValues,
					"STEP7 : Actual top 5 loans disbursement are not equal to the expected top 5 loan disbursement",
					"STEP7 : Actual top 5 loans disbursement are equal to the expected top 5 loan disbursement");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanDisbursementDate", "Pass", driver);

		} catch (AssertionError validateLoanDisbursementDate) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanDisbursementDate test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanDisbursementDate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanDisbursementDate.printStackTrace();
			node.fail(validateLoanDisbursementDate);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanDisbursementDate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanDisbursementDate test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanDisbursementDate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanDisbursementDate.printStackTrace();
			node.fail(validateLoanDisbursementDate);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_096
	@Test(priority = 78)
	public void validateInterestRate() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the system accurately displays the interest rate for each respective loan")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Get the Allocated Amount
			double allocatedAmount = Utils.getTextAndParseToDouble(ReportingLoansPO.allocatedAmount);

			List<String> actualTop5HighestValue = Utils.extractTextFromElements(ReportingLoansPO.top5LoanAmount);

			List<String> actualTop5LoanInterestRate = Utils
					.extractTextFromElements(ReportingLoansPO.top5LoanInterestRate);

			// Format the values to one decimal place
			DecimalFormat df = new DecimalFormat("#.#");

			List<String> expectedInterestRateValues = new ArrayList<>();
			// Print each element of the ArrayList
			for (String loanAmount : actualTop5HighestValue) {
				double loanAmountValue = Utils.parseCurrencyValueToDouble(loanAmount);
				double interestRate = (loanAmountValue / allocatedAmount) * 100;
				expectedInterestRateValues.add(df.format(interestRate));
			}

			// Validate top 5 interest rate
			Utils.validateStringList(actualTop5LoanInterestRate, expectedInterestRateValues,
					"STEP6 : Actual top 5 loans interest rate are not equal to the expected top 5 loan interest rate",
					"STEP6 : Actual top 5 loans interest rate are equal to the expected top 5 loan interest rate");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateInterestRate", "Pass", driver);

		} catch (AssertionError validateInterestRate) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInterestRate test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateInterestRate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestRate.printStackTrace();
			node.fail(validateInterestRate);
			Assert.fail();
			extent.flush();

		} catch (Exception validateInterestRate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInterestRate test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateInterestRate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestRate.printStackTrace();
			node.fail(validateInterestRate);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_097
	@Test(priority = 79)
	public void validateLoanAmount() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the loan amount with the respective borrower in the user interface")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// List<String> actualTop5HighestValue =
			// Utils.extractTextFromElements(ReportingLoansPO.top5LoanAmount);

			List<String> actualTop5LoanInternalReference = Utils
					.extractTextFromElementsAndRemoveCurrency(ReportingLoansPO.top5LoanInternalReference);

			// Scroll to the element
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, ReportingLoansPO.currentLoanAmountSortIcon);
			node.log(Status.INFO, "STEP1 : Scrolled to the element");
			System.out.println("STEP1 : Scrolled to the element");

			// Wait for the sort icon to be visible and clickable
			node.log(Status.INFO, "STEP2 : Waiting for the sort icon to be visible and clickable");
			System.out.println("STEP2 : Waiting for the sort icon to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.currentLoanAmountSortIcon);
			node.log(Status.INFO, "STEP3 : Sort icon is visible and clickable");
			System.out.println("STEP3 : Sort icon is visible and clickable");

			// Sort the listing in descending order
			Utils.sortListingInDescendin(ReportingLoansPO.currentLoanAmountSortIcon, "Current Loan Amount",
					ReportingLoansPO.currentLoanAmount);

			// Retrieve the loan reference
			List<String> loanReferenceValue = Utils.getStarting5Values(ReportingLoansPO.loanReference);

			List<String> expectedInternalReferenceValues = new ArrayList<>();
			// Print each element of the ArrayList
			for (String loanReferenceNumber : loanReferenceValue) {
				// Calling the loadDatabasePage from LoansPage
				LoansPage.loadDatabasePage();

				// Search record based on the provide loan reference and open it
				Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, LoansDatabasePO.loanRefSearchField,
						loanReferenceNumber, UtilsPO.editIcon, LoansNewLoanPO.editBridgeLoanHeaderText);

				// Get borrower value
				String value = IElementActions.getElementValue(node, driver,
						LoansNewLoanPO.bridgeLoanInternalReferenceField);

				expectedInternalReferenceValues.add(value);
			}

			// Validate loan borrower
			Utils.validateStringList(actualTop5LoanInternalReference, expectedInternalReferenceValues,
					"STEP4 : Actual top 5 loan internal reference are not equal to the expected loan internal reference",
					"STEP4 : Actual top 5 loan internal reference are equal to the expected loan internal reference");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanAmount", "Pass", driver);

		} catch (AssertionError validateLoanAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanAmount.printStackTrace();
			node.fail(validateLoanAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanAmount test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanAmount.printStackTrace();
			node.fail(validateLoanAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_098
	@Test(priority = 80)
	public void validateLoansTableColumnsVisibility() throws IOException {
		try {
			extenttest = extent.createTest("Verify if the user is able to view the initial state the Loans table ")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Verify the Loans Table Columns Visibility
			node.log(Status.INFO, "STEP1 : Verify the Loans Table Columns Visibility.");
			System.out.println("STEP1 : Verify the Loans Table Columns Visibility.");

			// Check the visibility of Loan Reference Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.loanReferenceColumnHeader,
					"STEP2 : BUG: The Loan Reference Column is not visible in Loans Table.",
					"STEP2 : EXPECTED: The Loan Reference Column is visible in Loans Table.");

			// Check the visibility of Internal Reference Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.internalReferenceColumnHeader,
					"STEP3 : BUG: The Internal Reference Column is not visible in Loans Table.",
					"STEP3 : EXPECTED: The Internal Reference Column is visible in Loans Table.");

			// Check the visibility of Comment Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.commentColumnHeader,
					"STEP4 : BUG: The Comment Column is not visible in Loans Table.",
					"STEP4 : EXPECTED: The Comment Column is visible in Loans Table.");

			// Check the visibility of Status Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.statusColumnHeader,
					"STEP5 : BUG: The Status Column is not visible in Loans Table.",
					"STEP5 : EXPECTED: The Status Column is visible in Loans Table.");

			// Check the visibility of Allocation Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.allocationColumnHeader,
					"STEP6 : BUG: The Allocation Column is not visible in Loans Table.",
					"STEP6 : EXPECTED: The Allocation Column is visible in Loans Table.");

			// Check the visibility of Current Loan Amount Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.currentLoanAmountColumnHeader,
					"STEP7 : BUG: The Current Loan Amount Column is not visible in Loans Table.",
					"STEP7 : EXPECTED: The Current Loan Amount Column is visible in Loans Table.");

			// Check the visibility of Repayment Date Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.repaymentDateColumnHeader,
					"STEP8 : BUG: The Repayment Date Column is not visible in Loans Table.",
					"STEP8 : EXPECTED: The Repayment Date Column is visible in Loans Table.");

			// Check the visibility of LTV Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.lTVColumnHeader,
					"STEP9 : BUG: The LTV Column is not visible in Loans Table.",
					"STEP9 : EXPECTED: The LTV Column is visible in Loans Table.");

			// Check the visibility of Charge Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.chargeColumnHeader,
					"STEP10 : BUG: The Charge Column is not visible in Loans Table.",
					"STEP10 : EXPECTED: The Charge Column is visible in Loans Table.");

			// Check the visibility of Annual Interest Rate Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.annualInterestRateColumnHeader,
					"STEP11 : BUG: The Annual Interest Rate Column is not visible in Loans Table.",
					"STEP11 : EXPECTED: The Annual Interest Rate Column is visible in Loans Table.");

			// Check the visibility of Property Address Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.propertyAddressColumnHeader,
					"STEP12 : BUG: The Property Address Column is not visible in Loans Table.",
					"STEP12 : EXPECTED: The Property Address Column is visible in Loans Table.");

			// Check the visibility of Region Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.regionColumnHeader,
					"STEP13 : BUG: The Region Column is not visible in Loans Table.",
					"STEP13 : EXPECTED: The Region Column is visible in Loans Table.");

			// Check the visibility of Property Type Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingLoansPO.propertyTypeColumnHeader,
					"STEP14 : BUG: The Property Type Column is not visible in Loans Table.",
					"STEP14 : EXPECTED: The Property Type Column is visible in Loans Table.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoansTableColumnsVisibility", "Pass", driver);

		} catch (AssertionError validateLoansTableColumnsVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoansTableColumnsVisibility test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoansTableColumnsVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoansTableColumnsVisibility.printStackTrace();
			node.fail(validateLoansTableColumnsVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoansTableColumnsVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoansTableColumnsVisibility test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoansTableColumnsVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoansTableColumnsVisibility.printStackTrace();
			node.fail(validateLoansTableColumnsVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_099
	// TC_Reporting_Loans_100
	@Test(priority = 81)
	public void validateLoansTableSortingOrder() throws IOException {
		try {
			extenttest = extent.createTest(
					"AscendingSortingOrder : Verify when user click on column heading toggle the rows in the table are sorted in ascending order of that category."
							+ "DescendingSortingOrder : Verify when user click on a column heading toggle a second time, the row  in the table are sorted in descending order of that category.")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for Page Loading To Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Validate Loan Referance Column Values are sorted in Ascending Oreder
			Utils.validateDataSortingBothOrder(ReportingLoansPO.loanReferenceSortIcon, "Loan Referance",
					ReportingLoansPO.loanReferenceAllValues, "validateLoanReferanceSorting", "stringValue");

			// Validate Internal Referance Column Values are sorted in Ascending Oreder
			Utils.validateDataSortingBothOrder(ReportingLoansPO.internalReferenceSortIcon, "Internal Referance",
					ReportingLoansPO.internalReferenceAllValues, "validateInternalReferanceSorting", "stringValue");

			// Clicked on the Comment Column Sort Icon
			IElementActions.clickelement_usingXpath(node, driver, ReportingLoansPO.commentSortIcon);
			node.log(Status.INFO, "STEP1 : Clicked on Comment Column Sort Icon");
			System.out.println("STEP1 : Clicked on Comment Column Sort Icon");

			// Validate Comment Column Values are sorted in Ascending Oreder
			Utils.validateDataSortingOrder(node, driver, ReportingLoansPO.commentAllValues, "validateCommentSorting",
					"stringValue");

			// Validate Status Column Values are sorted in Ascending Oreder
			Utils.validateDataSortingBothOrder(ReportingLoansPO.statusSortIcon, "Status",
					ReportingLoansPO.statusAllValues, "validateStatusSorting", "stringValue");

			// Validate Allocation Column Values are sorted in Ascending Oreder
			Utils.validateDataSortingBothOrder(ReportingLoansPO.allocationSortIcon, "Allocation",
					ReportingLoansPO.allocationAllValues, "validateAllocationSorting", "intValue");

			// Validate Current Loan Amount Column Values are sorted in Ascending Oreder
			Utils.validateDataSortingBothOrder(ReportingLoansPO.currentLoanAmountSortIcon, "Current Loan Amount",
					ReportingLoansPO.currentLoanAmountAllValues, "validateLoanAmountSorting", "intValue");

			// Validate LTV Column Values are sorted in Ascending Oreder
			Utils.validateDataSortingBothOrder(ReportingLoansPO.lTVColumnSortIcon, "LTV",
					ReportingLoansPO.lTVColumnAllValues, "validateLTVSorting", "intValue");

			// Validate Charge Column Values are sorted in Ascending Oreder
			Utils.validateDataSortingBothOrder(ReportingLoansPO.chargeSortIcon, "Charge",
					ReportingLoansPO.chargeAllValues, "validateChargeSorting", "stringValue");

			// Validate Annual Interest Rate Column Values are sorted in Ascending Oreder
			Utils.validateDataSortingBothOrder(ReportingLoansPO.annualInterestRateSortIcon, "Annual Interest Rate",
					ReportingLoansPO.anualInterestRateAllValues, "validateAnnualInterestRateSorting", "intValue");

			// Validate Region Column Values are sorted in Ascending Oreder
			Utils.validateDataSortingBothOrder(ReportingLoansPO.regionSortIcon, "Region",
					ReportingLoansPO.regionAllValues, "validateRegionSorting", "stringValue");

			// Validate Property Type Column Values are sorted in Ascending Oreder
			Utils.validateDataSortingBothOrder(ReportingLoansPO.propertyTypeSortIcon, "Property Type",
					ReportingLoansPO.propertyTypeAllValues, "validatePropertyTypeSorting", "stringValue");

			IElementActions.pageRefresh();
			// Scroll to the element
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, ReportingLoansPO.repaymentDateSortIcon);
			node.log(Status.INFO, "STEP2 : Scrolled to the element");
			System.out.println("STEP2 : Scrolled to the element");

			// Wait for the sort icon to be visible and clickable
			node.log(Status.INFO, "STEP3 : Waiting for the sort icon to be visible and clickable");
			System.out.println("STEP3 : Waiting for the sort icon to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingLoansPO.repaymentDateSortIcon);
			IWaitStrategy.WaitUntilElementClickable(node, driver, ReportingLoansPO.repaymentDateSortIcon);
			node.log(Status.INFO, "STEP4 : Sort icon is visible and clickable");
			System.out.println("STEP4 : Sort icon is visible and clickable");

			// Clicked on the Repayment Date Column Sort Icon
			IElementActions.clickelement_usingXpath(node, driver, ReportingLoansPO.repaymentDateSortIcon);
			node.log(Status.INFO, "STEP5 : Clicked on Repayment Date Column Sort Icon");
			System.out.println("STEP5 : Clicked on Repayment Date Column Sort Icon");

			Thread.sleep(1000);
			// Check the descending order for date column
			Utils.validateDateSorting(node, driver, ReportingLoansPO.repaymentDateAllValues, "ascending",
					"validateRepaymentDateSorting", "dd-MM-yyyy", "LocalDate");

		} catch (AssertionError validateLoansTableSortingOrder) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoansTableSortingOrder test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoansTableSortingOrder_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoansTableSortingOrder.printStackTrace();
			node.fail(validateLoansTableSortingOrder);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoansTableSortingOrder) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoansTableSortingOrder test in LoansTest class");

			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoansTableSortingOrder_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoansTableSortingOrder.printStackTrace();
			node.fail(validateLoansTableSortingOrder);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_101
	@Test(priority = 82)
	public void validateLoanReferenceValue() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the loan reference number in the loan reference column")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Wait For Page Loading To Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Getting the First Loan Reference column value
			String loanRefFirstValue = IElementActions.getElementText_usingXpath(node, driver,
					ReportingLoansPO.loanRefFirstValue);

			// Calling the loadDatabasePage function from the LoansPage
			LoansPage.loadDatabasePage();

			// Enter on search box of Loan Reference column
			Utils.enterValueInSearchBox(LoansDatabasePO.loanRefSearchField, loanRefFirstValue);

			// Getting the Loan Reference Value In Loan Database
			String loanRefValueInLoanDatabase = IElementActions.getElementText_usingXpath(node, driver,
					LoansDatabasePO.firstLoanRefRowValue);

			// Assert the Loan Reference
			IElementActions.assertEquals_usingString(node, driver, loanRefFirstValue, loanRefValueInLoanDatabase,
					"STEP1 : BUG : The Loan Reference in Reporting Loans Loan Portfolio tab " + loanRefFirstValue
							+ " is not found in Loan Database" + loanRefValueInLoanDatabase,
					"STEP1 : PASS : The Loan Reference in Reporting Loans Loan Portfolio tab " + loanRefFirstValue
							+ " is found in Loan Database " + loanRefValueInLoanDatabase);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanReferenceValue", "Pass", driver);

		} catch (AssertionError validateLoanReferenceValue) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanReferenceValue test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanReferenceValue_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanReferenceValue.printStackTrace();
			node.fail(validateLoanReferenceValue);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanReferenceValue) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanReferenceValue test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanReferenceValue_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanReferenceValue.printStackTrace();
			node.fail(validateLoanReferenceValue);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_102
	@Test(priority = 83)
	public void validateNavigationToEditBridgeLoanSummaryTab() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that when a user clicks on the Loan Reference number under the respective column, the system correctly navigates the user to the Edit Bridge Loan Page Summary tab")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Click on the Loan Reference Column First Loan Reference
			IElementActions.clickelement_usingXpath(node, driver, ReportingLoansPO.loanRefFirstValue);
			node.log(Status.INFO, "STEP1 : The Clicked on Loan Reference Column First Loan Reference.");
			System.out.println("STEP1 : The Clicked on Loan Reference Column First Loan Reference.");

			// Wait for the visibility of the Edit Bridge Loan Header Text
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the Edit Bridge Loan Header Text");
			System.out.println("STEP2 : Waiting for the visibility of the Edit Bridge Loan Header Text");
			IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.editBridgeLoanHeaderText);
			node.log(Status.INFO, "STEP3 :  Edit Bridge Loan Header Text is now visible");
			System.out.println("STEP3 :  Edit Bridge Loan Header Text is now visible");

			Thread.sleep(2000);

			// Getting the current URL
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			if ((currentUrl.contains("summary") && currentUrl.contains("bridge-loan/bl"))) {
				node.log(Status.INFO,
						"STEP4 : PASS : The clicking on Loan Ref Name ,user is naviagating to the the  Edit Bridge Loan Page Summary Tab");
				System.out.println(
						"STEP4 : PASS : The clicking on Loan Ref Name ,user is naviagating to the the  Edit Bridge Loan Page Summary Tab");
			} else {
				node.log(Status.INFO,
						"STEP4 : BUG : The clicking on Loan Ref Name ,the user is not naviagating to the the  Edit Bridge Loan Page Summary Tab");
				System.out.println(
						"STEP4 : BUG : The clicking on Loan Ref Name ,the user is not naviagating to the the  Edit Bridge Loan Page Summary Tab");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateNavigationToEditBridgeLoanSummaryTab", "Pass", driver);

		} catch (AssertionError validateNavigationToEditBridgeLoanSummaryTab) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNavigationToEditBridgeLoanSummaryTab test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNavigationToEditBridgeLoanSummaryTab_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNavigationToEditBridgeLoanSummaryTab.printStackTrace();
			node.fail(validateNavigationToEditBridgeLoanSummaryTab);
			Assert.fail();
			extent.flush();

		} catch (Exception validateNavigationToEditBridgeLoanSummaryTab) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNavigationToEditBridgeLoanSummaryTab test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNavigationToEditBridgeLoanSummaryTab_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNavigationToEditBridgeLoanSummaryTab.printStackTrace();
			node.fail(validateNavigationToEditBridgeLoanSummaryTab);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_103
	@Test(priority = 84)
	public void validateInternalReferenceCorrespondingToLoan() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the internal reference in the internal reference column for each respective loan")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Find all the loan references
			List<String> loanReferenceValue = Utils.extractTextFromElements(ReportingLoansPO.loanReference);

			// Find all the internal reference
			List<String> internalReferenceValue = Utils.extractTextFromElements(ReportingLoansPO.internalReference);

			// Calling the loadDatabasePageAndClearSearchResult function from the LoansPage
			LoansPage.loadDatabasePageAndClearSearchResult();

			// Find all the loan references
			List<String> loanReferenceInDatabase = Utils.extractTextFromElements(LoansDatabasePO.loanReference);

			// Find all the internal reference in database
			List<String> internalReferenceInDatabase = Utils.extractTextFromElements(LoansDatabasePO.internalReference);

			// Create a list to store the matched indexes or positions
			List<Integer> matchedIndexes = new ArrayList<>();

			// Iterate through loanReferenceValue and statusValue
			for (int i = 0; i < loanReferenceValue.size(); i++) {
				String loanRef = loanReferenceValue.get(i);
				String internalReference = internalReferenceValue.get(i);
				node.log(Status.INFO, "STEP1 : Loan reference in reporting is " + loanRef
						+ " and its internal reference value is " + internalReference);
				System.out.println("STEP1 : Loan reference in reporting is " + loanRef
						+ " and its internal reference value is " + internalReference);

				// Find the index of loanRef in loanReferenceInDatabase
				int indexInDatabase = loanReferenceInDatabase.indexOf(loanRef);

				// If the loan reference exists in the database
				if (indexInDatabase != -1) {

					// Record the index or position
					matchedIndexes.add(indexInDatabase);

					// Now, you have the index or position of loan reference in
					// loanReferenceInDatabase
					// You can use this index to access corresponding status in statusInDatabase
					String internalReferenceInDb = internalReferenceInDatabase.get(indexInDatabase);
					System.out.println("Internal reference in database: " + internalReferenceInDb);

					// Compare the internal reference
					if (internalReference.equals(internalReferenceInDb)) {
						// Internal reference matches
						node.log(Status.PASS, "STEP2 : Internal reference " + internalReference + " of loan reference "
								+ loanRef + " in reporting matches at index " + indexInDatabase + " in database");
						System.out.println("STEP2 : Internal reference " + internalReference + " of loan reference "
								+ loanRef + " in reporting matches at index " + indexInDatabase + " in database");
						Assert.assertTrue(true, "Internal reference " + internalReference + " of loan reference "
								+ loanRef + " in reporting matches at index " + indexInDatabase + " in database");
					} else {
						// Internal reference doesn't match
						node.log(Status.FAIL, "STEP2 : Internal reference " + internalReference + " of loan reference "
								+ loanRef + " in reporting doesn't match at index " + indexInDatabase + " in database");
						System.out.println("STEP2 : Internal reference " + internalReference + " of loan reference "
								+ loanRef + " in reporting doesn't match at index " + indexInDatabase + " in database");
						Assert.assertTrue(false, "Internal reference " + internalReference + " of loan reference "
								+ loanRef + " in reporting doesn't match at index " + indexInDatabase + " in database");
					}
				} else {
					// Loan reference not found in the database
					node.log(Status.FAIL, "STEP2 : Loan reference not found in the database: " + loanRef);
					System.out.println("STEP2 : Loan reference not found in the database: " + loanRef);
					Assert.assertTrue(false, "Loan reference not found in the database: " + loanRef);
				}
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateInternalReferenceCorrespondingToLoan", "Pass", driver);

		} catch (AssertionError validateInternalReferenceCorrespondingToLoan) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInternalReferenceCorrespondingToLoan test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateStatusCorrespondingToLoan_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInternalReferenceCorrespondingToLoan.printStackTrace();
			node.fail(validateInternalReferenceCorrespondingToLoan);
			Assert.fail();
			extent.flush();

		} catch (Exception validateInternalReferenceCorrespondingToLoan) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInternalReferenceCorrespondingToLoan test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInternalReferenceCorrespondingToLoan_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInternalReferenceCorrespondingToLoan.printStackTrace();
			node.fail(validateInternalReferenceCorrespondingToLoan);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_104
	@Test(priority = 85)
	public void validateStatusCorrespondingToLoan() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the system accurately displays the interest rate for each respective loan")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Find all the loan references
			List<String> loanReferenceValue = Utils.extractTextFromElements(ReportingLoansPO.loanReference);

			// Find all the status
			List<String> statusValue = Utils.extractTextFromElements(ReportingLoansPO.status);

			// Calling the loadDatabasePageAndClearSearchResult function from the LoansPage
			LoansPage.loadDatabasePageAndClearSearchResult();

			// Find all the loan references
			List<String> loanReferenceInDatabase = Utils.extractTextFromElements(LoansDatabasePO.loanReference);

			// Find all the status
			List<String> statusInDatabase = Utils.extractTextFromElements(LoansDatabasePO.status);

			// Create a list to store the matched indexes or positions
			List<Integer> matchedIndexes = new ArrayList<>();

			// Iterate through loanReferenceValue and statusValue
			for (int i = 0; i < loanReferenceValue.size(); i++) {
				String loanRef = loanReferenceValue.get(i);
				String status = statusValue.get(i);
				node.log(Status.INFO,
						"STEP1 : Loan reference in reporting is " + loanRef + " and its status value is " + status);
				System.out.println(
						"STEP1 : Loan reference in reporting is " + loanRef + " and its status value is " + status);

				// Find the index of loanRef in loanReferenceInDatabase
				int indexInDatabase = loanReferenceInDatabase.indexOf(loanRef);

				// If the loan reference exists in the database
				if (indexInDatabase != -1) {

					// Record the index or position
					matchedIndexes.add(indexInDatabase);

					// Now, you have the index or position of loan reference in
					// loanReferenceInDatabase
					// You can use this index to access corresponding status in statusInDatabase
					String statusInDb = statusInDatabase.get(indexInDatabase);
					System.out.println("statusInDb: " + statusInDb);

					// Compare the statuses
					if (status.equals(statusInDb)) {
						// Status matches
						node.log(Status.PASS, "STEP2 : Status " + status + " of loan reference " + loanRef
								+ " in reporting matches at index " + indexInDatabase + " in database");
						System.out.println("STEP2 : Status " + status + " of loan reference " + loanRef
								+ " in reporting matches at index " + indexInDatabase + " in database");
						Assert.assertTrue(true, "Status " + status + " of loan reference " + loanRef
								+ " in reporting matches at index " + indexInDatabase + " in database");
					} else {
						// Status doesn't match
						node.log(Status.FAIL, "STEP2 : Status " + status + " of loan reference " + loanRef
								+ " in reporting doesn't match at index " + indexInDatabase + " in database");
						System.out.println("STEP2 : Status " + status + " of loan reference " + loanRef
								+ " in reporting doesn't match at index " + indexInDatabase + " in database");
						Assert.assertTrue(false, "Status " + status + " of loan reference " + loanRef
								+ " in reporting doesn't match at index " + indexInDatabase + " in database");
					}
				} else {
					// Loan reference not found in the database
					node.log(Status.FAIL, "STEP2 : Loan reference not found in the database: " + loanRef);
					System.out.println("STEP2 : Loan reference not found in the database: " + loanRef);
					Assert.assertTrue(false, "Loan reference not found in the database: " + loanRef);
				}
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateStatusCorrespondingToLoan", "Pass", driver);

		} catch (AssertionError validateStatusCorrespondingToLoan) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateStatusCorrespondingToLoan test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateStatusCorrespondingToLoan_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateStatusCorrespondingToLoan.printStackTrace();
			node.fail(validateStatusCorrespondingToLoan);
			Assert.fail();
			extent.flush();

		} catch (Exception validateStatusCorrespondingToLoan) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateStatusCorrespondingToLoan test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateStatusCorrespondingToLoan_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateStatusCorrespondingToLoan.printStackTrace();
			node.fail(validateStatusCorrespondingToLoan);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_105
	@Test(priority = 86)
	public void validateAllocatedAmountCorrespondingToLoan() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the allocated amount for each respective loan under the allocation column")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Find all the loan references
			List<String> loanReferenceValue = Utils.extractTextFromElements(ReportingLoansPO.loanReference);

			// Find all the allocate loan amount
			List<String> allocateLoanAmountValue = Utils.extractTextFromElements(ReportingLoansPO.allocateLoanAmount);

			// Calling the loadDatabasePageAndClearSearchResult function from the LoansPage
			LoansPage.loadDatabasePageAndClearSearchResult();

			// Find all the loan references
			List<String> loanReferenceInDatabase = Utils.extractTextFromElements(LoansDatabasePO.loanReference);

			// Find all the allocate loan amount in database
			List<String> allocateLoanAmountInDatabase = Utils
					.extractTextFromElements(LoansDatabasePO.allocateLoanAmount);

			// Create a list to store the matched indexes or positions
			List<Integer> matchedIndexes = new ArrayList<>();

			// Iterate through loanReferenceValue and statusValue
			for (int i = 0; i < loanReferenceValue.size(); i++) {
				String loanRef = loanReferenceValue.get(i);
				String allocateLoanAmount = allocateLoanAmountValue.get(i);
				node.log(Status.INFO, "STEP1 : Loan reference in reporting is " + loanRef
						+ " and its allocate loan amount value is " + allocateLoanAmount);
				System.out.println("STEP1 : Loan reference in reporting is " + loanRef
						+ " and its allocate loan amount value is " + allocateLoanAmount);

				// Find the index of loanRef in loanReferenceInDatabase
				int indexInDatabase = loanReferenceInDatabase.indexOf(loanRef);

				// If the loan reference exists in the database
				if (indexInDatabase != -1) {

					// Record the index or position
					matchedIndexes.add(indexInDatabase);

					// Now, you have the index or position of loan reference in
					// loanReferenceInDatabase
					// You can use this index to access corresponding status in statusInDatabase
					String allocateLoanAmountInDb = allocateLoanAmountInDatabase.get(indexInDatabase);
					System.out.println("Allocate loan amount in database: " + allocateLoanAmountInDb);

					// Compare the allocate loan amount
					if (allocateLoanAmount.equals(allocateLoanAmountInDb)) {
						// Allocate loan amount matches
						node.log(Status.PASS,
								"STEP2 : Allocate loan amount " + allocateLoanAmount + " of loan reference " + loanRef
										+ " in reporting matches at index " + indexInDatabase + " in database");
						System.out.println("STEP2 : Allocate loan amount " + allocateLoanAmount + " of loan reference "
								+ loanRef + " in reporting matches at index " + indexInDatabase + " in database");
						Assert.assertTrue(true, "Allocate loan amount " + allocateLoanAmount + " of loan reference "
								+ loanRef + " in reporting matches at index " + indexInDatabase + " in database");
					} else {
						// Allocate loan amount doesn't match
						node.log(Status.FAIL,
								"STEP2 : Allocate loan amount " + allocateLoanAmount + " of loan reference " + loanRef
										+ " in reporting doesn't match at index " + indexInDatabase + " in database");
						System.out.println("STEP2 : Allocate loan amount " + allocateLoanAmount + " of loan reference "
								+ loanRef + " in reporting doesn't match at index " + indexInDatabase + " in database");
						Assert.assertTrue(false, "Allocate loan amount " + allocateLoanAmount + " of loan reference "
								+ loanRef + " in reporting doesn't match at index " + indexInDatabase + " in database");
					}
				} else {
					// Loan reference not found in the database
					node.log(Status.FAIL, "STEP2 : Loan reference not found in the database: " + loanRef);
					System.out.println("STEP2 : Loan reference not found in the database: " + loanRef);
					Assert.assertTrue(false, "Loan reference not found in the database: " + loanRef);
				}
			}
			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAllocatedAmountCorrespondingToLoan", "Pass", driver);

		} catch (AssertionError validateAllocatedAmountCorrespondingToLoan) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAllocatedAmountCorrespondingToLoan test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllocatedAmountCorrespondingToLoan_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocatedAmountCorrespondingToLoan.printStackTrace();
			node.fail(validateAllocatedAmountCorrespondingToLoan);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAllocatedAmountCorrespondingToLoan) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAllocatedAmountCorrespondingToLoan test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllocatedAmountCorrespondingToLoan_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocatedAmountCorrespondingToLoan.printStackTrace();
			node.fail(validateAllocatedAmountCorrespondingToLoan);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_106
	@Test(priority = 87)
	public void validateCurrentLoanAmountCorrespondingToLoan() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the current loan amount for each respective loan under the current loan amount column")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Find all the loan references
			List<String> loanReferenceValue = Utils.extractTextFromElements(ReportingLoansPO.loanReference);

			// Find all the current loan amount
			List<String> currentLoanAmountValue = Utils.extractTextFromElements(ReportingLoansPO.currentLoanAmount);

			// Calling the loadDatabasePageAndClearSearchResult function from the LoansPage
			LoansPage.loadDatabasePageAndClearSearchResult();

			// Find all the loan references
			List<String> loanReferenceInDatabase = Utils.extractTextFromElements(LoansDatabasePO.loanReference);

			// Find all the current loan amount in database
			List<String> currentLoanAmountInDatabase = Utils.extractTextFromElements(LoansDatabasePO.currentLoanAmount);

			// Create a list to store the matched indexes or positions
			List<Integer> matchedIndexes = new ArrayList<>();

			// Iterate through loanReferenceValue and statusValue
			for (int i = 0; i < loanReferenceValue.size(); i++) {
				String loanRef = loanReferenceValue.get(i);
				String currentLoanAmount = currentLoanAmountValue.get(i);
				node.log(Status.INFO, "STEP1 : Loan reference in reporting is " + loanRef
						+ " and its current loan amount value is " + currentLoanAmount);
				System.out.println("STEP1 : Loan reference in reporting is " + loanRef
						+ " and its current loan amount value is " + currentLoanAmount);

				// Find the index of loanRef in loanReferenceInDatabase
				int indexInDatabase = loanReferenceInDatabase.indexOf(loanRef);

				// If the loan reference exists in the database
				if (indexInDatabase != -1) {

					// Record the index or position
					matchedIndexes.add(indexInDatabase);

					// Now, you have the index or position of loan reference in
					// loanReferenceInDatabase
					// You can use this index to access corresponding status in statusInDatabase
					String currentLoanAmountInDb = currentLoanAmountInDatabase.get(indexInDatabase);
					System.out.println("Current loan amount in database: " + currentLoanAmountInDb);

					// Compare the current loan amount
					if (currentLoanAmount.equals(currentLoanAmountInDb)) {
						// Current loan amount matches
						node.log(Status.PASS, "STEP2 : Current loan amount " + currentLoanAmount + " of loan reference "
								+ loanRef + " in reporting matches at index " + indexInDatabase + " in database");
						System.out.println("STEP2 : Current loan amount " + currentLoanAmount + " of loan reference "
								+ loanRef + " in reporting matches at index " + indexInDatabase + " in database");
						Assert.assertTrue(true, "Current loan amount " + currentLoanAmount + " of loan reference "
								+ loanRef + " in reporting matches at index " + indexInDatabase + " in database");
					} else {
						// Current loan amount doesn't match
						node.log(Status.FAIL, "STEP2 : Current loan amount " + currentLoanAmount + " of loan reference "
								+ loanRef + " in reporting doesn't match at index " + indexInDatabase + " in database");
						System.out.println("STEP2 : Current loan amount " + currentLoanAmount + " of loan reference "
								+ loanRef + " in reporting doesn't match at index " + indexInDatabase + " in database");
						Assert.assertTrue(false, "Current loan amount " + currentLoanAmount + " of loan reference "
								+ loanRef + " in reporting doesn't match at index " + indexInDatabase + " in database");
					}
				} else {
					// Loan reference not found in the database
					node.log(Status.FAIL, "STEP2 : Loan reference not found in the database: " + loanRef);
					System.out.println("STEP2 : Loan reference not found in the database: " + loanRef);
					Assert.assertTrue(false, "Loan reference not found in the database: " + loanRef);
				}
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCurrentLoanAmountCorrespondingToLoan", "Pass", driver);

		} catch (AssertionError validateCurrentLoanAmountCorrespondingToLoan) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCurrentLoanAmountCorrespondingToLoan test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateInterestRate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCurrentLoanAmountCorrespondingToLoan.printStackTrace();
			node.fail(validateCurrentLoanAmountCorrespondingToLoan);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCurrentLoanAmountCorrespondingToLoan) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCurrentLoanAmountCorrespondingToLoan test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCurrentLoanAmountCorrespondingToLoan_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCurrentLoanAmountCorrespondingToLoan.printStackTrace();
			node.fail(validateCurrentLoanAmountCorrespondingToLoan);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_107
	@Test(priority = 88)
	public void validateRepaymentDateCorrespondingToLoan() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the Repayment Date for each respective loan under the Repayment Date column")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Find all the loan references
			List<String> loanReferenceValue = Utils.extractTextFromElements(ReportingLoansPO.loanReference);

			// Find all the repayment date
			List<String> repaymentDateValue = Utils.extractTextFromElements(ReportingLoansPO.repaymentDate);

			// Calling the loadDatabasePageAndClearSearchResult function from the LoansPage
			LoansPage.loadDatabasePageAndClearSearchResult();

			// Find all the loan references
			List<String> loanReferenceInDatabase = Utils.extractTextFromElements(LoansDatabasePO.loanReference);

			// Find all the repayment date in database
			List<String> repaymentDateInDatabase = Utils.extractTextFromElements(LoansDatabasePO.repaymentDate);

			// Create a list to store the matched indexes or positions
			List<Integer> matchedIndexes = new ArrayList<>();

			// Iterate through loanReferenceValue and statusValue
			for (int i = 0; i < loanReferenceValue.size(); i++) {
				String loanRef = loanReferenceValue.get(i);
				String repaymentDate = repaymentDateValue.get(i);
				node.log(Status.INFO, "STEP1 : Loan reference in reporting is " + loanRef
						+ " and its repayment date value is " + repaymentDate);
				System.out.println("STEP1 : Loan reference in reporting is " + loanRef
						+ " and its repayment date value is " + repaymentDate);

				// Find the index of loanRef in loanReferenceInDatabase
				int indexInDatabase = loanReferenceInDatabase.indexOf(loanRef);

				// If the loan reference exists in the database
				if (indexInDatabase != -1) {

					// Record the index or position
					matchedIndexes.add(indexInDatabase);

					// Now, you have the index or position of loan reference in
					// loanReferenceInDatabase
					// You can use this index to access corresponding status in statusInDatabase
					String repaymentDateInDb = repaymentDateInDatabase.get(indexInDatabase);
					System.out.println("Repayment date in database: " + repaymentDateInDb);

					// Compare the repayment date
					if (repaymentDate.equals(repaymentDateInDb)) {
						// Repayment date matches
						node.log(Status.PASS, "STEP2 : Repayment date " + repaymentDate + " of loan reference "
								+ loanRef + " in reporting matches at index " + indexInDatabase + " in database");
						System.out.println("STEP2 : Repayment date " + repaymentDate + " of loan reference " + loanRef
								+ " in reporting matches at index " + indexInDatabase + " in database");
						Assert.assertTrue(true, "Repayment date " + repaymentDate + " of loan reference " + loanRef
								+ " in reporting matches at index " + indexInDatabase + " in database");
					} else {
						// Repayment date doesn't match
						node.log(Status.FAIL, "STEP2 : Repayment date " + repaymentDate + " of loan reference "
								+ loanRef + " in reporting doesn't match at index " + indexInDatabase + " in database");
						System.out.println("STEP2 : Repayment date " + repaymentDate + " of loan reference " + loanRef
								+ " in reporting doesn't match at index " + indexInDatabase + " in database");
						Assert.assertTrue(false, "Repayment date " + repaymentDate + " of loan reference " + loanRef
								+ " in reporting doesn't match at index " + indexInDatabase + " in database");
					}
				} else {
					// Loan reference not found in the database
					node.log(Status.FAIL, "STEP2 : Loan reference not found in the database: " + loanRef);
					System.out.println("STEP2 : Loan reference not found in the database: " + loanRef);
					Assert.assertTrue(false, "Loan reference not found in the database: " + loanRef);
				}
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateRepaymentDateCorrespondingToLoan", "Pass", driver);

		} catch (AssertionError validateRepaymentDateCorrespondingToLoan) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateRepaymentDateCorrespondingToLoan test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRepaymentDateCorrespondingToLoan_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRepaymentDateCorrespondingToLoan.printStackTrace();
			node.fail(validateRepaymentDateCorrespondingToLoan);
			Assert.fail();
			extent.flush();

		} catch (Exception validateRepaymentDateCorrespondingToLoan) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateRepaymentDateCorrespondingToLoan test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRepaymentDateCorrespondingToLoan_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRepaymentDateCorrespondingToLoan.printStackTrace();
			node.fail(validateRepaymentDateCorrespondingToLoan);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_108
	@Test(priority = 89)
	public void validateLTVCorrespondingToLoan() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the LTV for each respective loan under the LTV column")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Find all the loan references
			List<String> loanReferenceValue = Utils.extractTextFromElements(ReportingLoansPO.loanReference);

			// Find all the ltv values
			List<String> ltvValues = Utils.extractTextFromElements(ReportingLoansPO.ltvValues);

			// Calling the loadDatabasePageAndClearSearchResult function from the LoansPage
			LoansPage.loadDatabasePageAndClearSearchResult();

			// Find all the loan references
			List<String> loanReferenceInDatabase = Utils.extractTextFromElements(LoansDatabasePO.loanReference);

			// Find all the ltv values in database
			List<String> ltvValuesInDatabase = Utils.extractTextFromElements(LoansDatabasePO.ltvValues);

			// Create a list to store the matched indexes or positions
			List<Integer> matchedIndexes = new ArrayList<>();

			// Iterate through loanReferenceValue and statusValue
			for (int i = 0; i < loanReferenceValue.size(); i++) {
				String loanRef = loanReferenceValue.get(i);
				loanRef = Utils.formatText(loanRef);
				String ltv = ltvValues.get(i);
				ltv = Utils.formatText(ltv);
				node.log(Status.INFO,
						"STEP1 : Loan reference in reporting is " + loanRef + " and its LTV value is " + ltv);
				System.out
						.println("STEP1 : Loan reference in reporting is " + loanRef + " and its LTV value is " + ltv);

				// Find the index of loanRef in loanReferenceInDatabase
				int indexInDatabase = loanReferenceInDatabase.indexOf(loanRef);

				// If the loan reference exists in the database
				if (indexInDatabase != -1) {

					// Record the index or position
					matchedIndexes.add(indexInDatabase);

					// Now, you have the index or position of loan reference in
					// loanReferenceInDatabase
					// You can use this index to access corresponding status in statusInDatabase
					String ltvValuesInDb = ltvValuesInDatabase.get(indexInDatabase);
					ltvValuesInDb = Utils.formatText(ltvValuesInDb);
					node.log(Status.INFO, "LTV values in database: " + ltvValuesInDb);
					System.out.println("LTV values in database: " + ltvValuesInDb);

					// Compare the LTV
					if (ltv.equals(ltvValuesInDb) || (Utils.isZeroLtv(ltv).equals(Utils.isZeroLtv(ltvValuesInDb)))) {
						// LTV matches
						node.log(Status.PASS, "STEP2 : LTV " + ltv + " of loan reference " + loanRef
								+ " in reporting matches at index " + indexInDatabase + " in database");
						System.out.println("STEP2 : LTV " + ltv + " of loan reference " + loanRef
								+ " in reporting matches at index " + indexInDatabase + " in database");
						Assert.assertTrue(true, "LTV " + ltv + " of loan reference " + loanRef
								+ " in reporting matches at index " + indexInDatabase + " in database");
					} else {
						// LTV doesn't match
						node.log(Status.FAIL, "STEP2 : LTV " + ltv + " of loan reference " + loanRef
								+ " in reporting doesn't match at index " + indexInDatabase + " in database");
						System.out.println("STEP2 : LTV " + ltv + " of loan reference " + loanRef
								+ " in reporting doesn't match at index " + indexInDatabase + " in database");
						Assert.assertTrue(false, "LTV " + ltv + " of loan reference " + loanRef
								+ " in reporting doesn't match at index " + indexInDatabase + " in database");
					}
				} else {
					// Loan reference not found in the database
					node.log(Status.FAIL, "STEP2 : Loan reference not found in the database: " + loanRef);
					System.out.println("STEP2 : Loan reference not found in the database: " + loanRef);
					Assert.assertTrue(false, "Loan reference not found in the database: " + loanRef);
				}
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLTVCorrespondingToLoan", "Pass", driver);

		} catch (AssertionError validateLTVCorrespondingToLoan) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLTVCorrespondingToLoan test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLTVCorrespondingToLoan_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLTVCorrespondingToLoan.printStackTrace();
			node.fail(validateLTVCorrespondingToLoan);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLTVCorrespondingToLoan) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLTVCorrespondingToLoan test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLTVCorrespondingToLoan_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLTVCorrespondingToLoan.printStackTrace();
			node.fail(validateLTVCorrespondingToLoan);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_109
	@Test(priority = 90)
	public void validatePropertyChargeCorrespondingToLoan() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the Property Charge for each respective loan under the Charge column")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Find all the loan references
			List<String> loanReferenceValue = Utils.extractTextFromElements(ReportingLoansPO.loanReference);

			// Find all the property charge
			List<String> propertyChargeValue = Utils.extractTextFromElements(ReportingLoansPO.propertyCharge);

			// Calling the loadDatabasePageAndClearSearchResult function from the LoansPage
			LoansPage.loadDatabasePageAndClearSearchResult();

			// Find all the loan references
			List<String> loanReferenceInDatabase = Utils.extractTextFromElements(LoansDatabasePO.loanReference);

			// Find all the property charge in database
			List<String> propertyChargeInDatabase = Utils.extractTextFromElements(LoansDatabasePO.propertyCharge);

			// Create a list to store the matched indexes or positions
			List<Integer> matchedIndexes = new ArrayList<>();

			// Iterate through loanReferenceValue and statusValue
			for (int i = 0; i < loanReferenceValue.size(); i++) {
				String loanRef = loanReferenceValue.get(i);
				String propertyCharge = propertyChargeValue.get(i);
				node.log(Status.INFO, "STEP1 : Loan reference in reporting is " + loanRef
						+ " and its  property charge value is " + propertyCharge);
				System.out.println("STEP1 : Loan reference in reporting is " + loanRef
						+ " and its  property charge value is " + propertyCharge);

				// Find the index of loanRef in loanReferenceInDatabase
				int indexInDatabase = loanReferenceInDatabase.indexOf(loanRef);

				// If the loan reference exists in the database
				if (indexInDatabase != -1) {

					// Record the index or position
					matchedIndexes.add(indexInDatabase);

					// Now, you have the index or position of loan reference in
					// loanReferenceInDatabase
					// You can use this index to access corresponding status in statusInDatabase
					String propertyChargeInDb = propertyChargeInDatabase.get(indexInDatabase);
					System.out.println("Property charge in database: " + propertyChargeInDb);

					// Compare the property charge
					if (propertyCharge.equals(propertyChargeInDb)) {
						// Property charge matches
						node.log(Status.PASS, "STEP2 : Property charge " + propertyCharge + " of loan reference "
								+ loanRef + " in reporting matches at index " + indexInDatabase + " in database");
						System.out.println("STEP2 : Property charge " + propertyCharge + " of loan reference " + loanRef
								+ " in reporting matches at index " + indexInDatabase + " in database");
						Assert.assertTrue(true, "Property charge " + propertyCharge + " of loan reference " + loanRef
								+ " in reporting matches at index " + indexInDatabase + " in database");
					} else {
						// Property charge doesn't match
						node.log(Status.FAIL, "STEP2 : Property charge " + propertyCharge + " of loan reference "
								+ loanRef + " in reporting doesn't match at index " + indexInDatabase + " in database");
						System.out.println("STEP2 : Property charge " + propertyCharge + " of loan reference " + loanRef
								+ " in reporting doesn't match at index " + indexInDatabase + " in database");
						Assert.assertTrue(false, "Property charge " + propertyCharge + " of loan reference " + loanRef
								+ " in reporting doesn't match at index " + indexInDatabase + " in database");
					}
				} else {
					// Loan reference not found in the database
					node.log(Status.FAIL, "STEP2 : Loan reference not found in the database: " + loanRef);
					System.out.println("STEP2 : Loan reference not found in the database: " + loanRef);
					Assert.assertTrue(false, "Loan reference not found in the database: " + loanRef);
				}
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validatePropertyChargeCorrespondingToLoan", "Pass", driver);

		} catch (AssertionError validatePropertyChargeCorrespondingToLoan) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePropertyChargeCorrespondingToLoan test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePropertyChargeCorrespondingToLoan_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePropertyChargeCorrespondingToLoan.printStackTrace();
			node.fail(validatePropertyChargeCorrespondingToLoan);
			Assert.fail();
			extent.flush();

		} catch (Exception validatePropertyChargeCorrespondingToLoan) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePropertyChargeCorrespondingToLoan test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePropertyChargeCorrespondingToLoan_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePropertyChargeCorrespondingToLoan.printStackTrace();
			node.fail(validatePropertyChargeCorrespondingToLoan);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_110
	@Test(priority = 91)
	public void validateAnnualInterestRateCorrespondingToLoan() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the Annual Interest Rate for each respective loan under the Annual Interest Rate column")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Find all the loan references
			List<String> loanReferenceValue = Utils.extractTextFromElements(ReportingLoansPO.loanReference);

			// Find all the annual interest rate
			List<String> annualInterestRateValue = Utils.extractTextFromElements(ReportingLoansPO.annualInterestRate);

			// Calling the loadDatabasePageAndClearSearchResult function from the LoansPage
			LoansPage.loadDatabasePageAndClearSearchResult();

			// Find all the loan references
			List<String> loanReferenceInDatabase = Utils.extractTextFromElements(LoansDatabasePO.loanReference);

			// Find all the annual interest rate in database
			List<String> annualInterestRateInDatabase = Utils
					.extractTextFromElements(LoansDatabasePO.annualInterestRate);

			// Create a list to store the matched indexes or positions
			List<Integer> matchedIndexes = new ArrayList<>();

			// Iterate through loanReferenceValue and statusValue
			for (int i = 0; i < loanReferenceValue.size(); i++) {
				String loanRef = loanReferenceValue.get(i);
				String annualInterestRate = annualInterestRateValue.get(i);
				node.log(Status.INFO, "STEP1 : Loan reference in reporting is " + loanRef
						+ " and its annual interest rate value is " + annualInterestRate);
				System.out.println("STEP1 : Loan reference in reporting is " + loanRef
						+ " and its annual interest rate value is " + annualInterestRate);

				// Find the index of loanRef in loanReferenceInDatabase
				int indexInDatabase = loanReferenceInDatabase.indexOf(loanRef);

				// If the loan reference exists in the database
				if (indexInDatabase != -1) {

					// Record the index or position
					matchedIndexes.add(indexInDatabase);

					// Now, you have the index or position of loan reference in
					// loanReferenceInDatabase
					// You can use this index to access corresponding annual interest rate in annual
					// interest rate in database
					String annualInterestRateInDb = annualInterestRateInDatabase.get(indexInDatabase);
					System.out.println("Annual interest rate in database: " + annualInterestRateInDb);

					// Compare the annual interest rate
					if (annualInterestRate.equals(annualInterestRateInDb)) {
						// Annual interest rate matches
						node.log(Status.PASS,
								"STEP2 : Annual interest rate " + annualInterestRate + " of loan reference " + loanRef
										+ " in reporting matches at index " + indexInDatabase + " in database");
						System.out.println("STEP2 : Annual interest rate " + annualInterestRate + " of loan reference "
								+ loanRef + " in reporting matches at index " + indexInDatabase + " in database");
						Assert.assertTrue(true, "Annual interest rate " + annualInterestRate + " of loan reference "
								+ loanRef + " in reporting matches at index " + indexInDatabase + " in database");
					} else {
						// Annual interest rate doesn't match
						node.log(Status.FAIL,
								"STEP2 : Annual interest rate " + annualInterestRate + " of loan reference " + loanRef
										+ " in reporting doesn't match at index " + indexInDatabase + " in database");
						System.out.println("STEP2 : Annual interest rate " + annualInterestRate + " of loan reference "
								+ loanRef + " in reporting doesn't match at index " + indexInDatabase + " in database");
						Assert.assertTrue(false, "Annual interest rate " + annualInterestRate + " of loan reference "
								+ loanRef + " in reporting doesn't match at index " + indexInDatabase + " in database");
					}
				} else {
					// Loan reference not found in the database
					node.log(Status.FAIL, "STEP2 : Loan reference not found in the database: " + loanRef);
					System.out.println("STEP2 : Loan reference not found in the database: " + loanRef);
					Assert.assertTrue(false, "Loan reference not found in the database: " + loanRef);
				}
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAnnualInterestRateCorrespondingToLoan", "Pass", driver);

		} catch (AssertionError validateAnnualInterestRateCorrespondingToLoan) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAnnualInterestRateCorrespondingToLoan test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAnnualInterestRateCorrespondingToLoan_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAnnualInterestRateCorrespondingToLoan.printStackTrace();
			node.fail(validateAnnualInterestRateCorrespondingToLoan);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAnnualInterestRateCorrespondingToLoan) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAnnualInterestRateCorrespondingToLoan test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAnnualInterestRateCorrespondingToLoan_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAnnualInterestRateCorrespondingToLoan.printStackTrace();
			node.fail(validateAnnualInterestRateCorrespondingToLoan);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_111
	@Test(priority = 92)
	public void validatePropertyAddressCorrespondingToLoan() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the Property Address for each respective loan under the Property Address column")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Find all the loan references
			List<String> loanReferenceValue = Utils.extractTextFromElements(ReportingLoansPO.loanReference);

			// Find all the property address
			List<String> propertyAddressValue = Utils.extractTextFromElements(ReportingLoansPO.propertyAddress);

			// Calling the loadDatabasePageAndClearSearchResult function from the LoansPage
			LoansPage.loadDatabasePageAndClearSearchResult();

			// Find all the loan references
			List<String> loanReferenceInDatabase = Utils.extractTextFromElements(LoansDatabasePO.loanReference);

			// Find all the property address in database
			List<String> propertyAddressInDatabase = Utils.extractTextFromElements(LoansDatabasePO.propertyAddress);

			// Create a list to store the matched indexes or positions
			List<Integer> matchedIndexes = new ArrayList<>();

			// Iterate through loanReferenceValue and statusValue
			for (int i = 0; i < loanReferenceValue.size(); i++) {
				String loanRef = loanReferenceValue.get(i);
				String propertyAddress = propertyAddressValue.get(i);
				node.log(Status.INFO, "STEP1 : Loan reference in reporting is " + loanRef
						+ " and its property address value is " + propertyAddress);
				System.out.println("STEP1 : Loan reference in reporting is " + loanRef
						+ " and its property address value is " + propertyAddress);

				// Find the index of loanRef in loanReferenceInDatabase
				int indexInDatabase = loanReferenceInDatabase.indexOf(loanRef);

				// If the loan reference exists in the database
				if (indexInDatabase != -1) {

					// Record the index or position
					matchedIndexes.add(indexInDatabase);

					// Now, you have the index or position of loan reference in
					// loanReferenceInDatabase
					// You can use this index to access corresponding property address in property
					// address database
					String propertyAddressInDb = propertyAddressInDatabase.get(indexInDatabase);
					System.out.println("Property address in database: " + propertyAddressInDb);

					// Compare the property address
					if (propertyAddress.equals(propertyAddressInDb)) {
						// Property address matches
						node.log(Status.PASS, "STEP2 : Property address " + propertyAddress + " of loan reference "
								+ loanRef + " in reporting matches at index " + indexInDatabase + " in database");
						System.out.println("STEP2 : Property address " + propertyAddress + " of loan reference "
								+ loanRef + " in reporting matches at index " + indexInDatabase + " in database");
						Assert.assertTrue(true, "Property address " + propertyAddress + " of loan reference " + loanRef
								+ " in reporting matches at index " + indexInDatabase + " in database");
					} else {
						// Property address doesn't match
						node.log(Status.FAIL, "STEP2 : Property address " + propertyAddress + " of loan reference "
								+ loanRef + " in reporting doesn't match at index " + indexInDatabase + " in database");
						System.out.println("STEP2 : Property address " + propertyAddress + " of loan reference "
								+ loanRef + " in reporting doesn't match at index " + indexInDatabase + " in database");
						Assert.assertTrue(false, "Property address " + propertyAddress + " of loan reference " + loanRef
								+ " in reporting doesn't match at index " + indexInDatabase + " in database");
					}
				} else {
					// Loan reference not found in the database
					node.log(Status.FAIL, "STEP2 : Loan reference not found in the database: " + loanRef);
					System.out.println("STEP2 : Loan reference not found in the database: " + loanRef);
					Assert.assertTrue(false, "Loan reference not found in the database: " + loanRef);
				}
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validatePropertyAddressCorrespondingToLoan", "Pass", driver);

		} catch (AssertionError validatePropertyAddressCorrespondingToLoan) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePropertyAddressCorrespondingToLoan test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePropertyAddressCorrespondingToLoan_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePropertyAddressCorrespondingToLoan.printStackTrace();
			node.fail(validatePropertyAddressCorrespondingToLoan);
			Assert.fail();
			extent.flush();

		} catch (Exception validatePropertyAddressCorrespondingToLoan) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePropertyAddressCorrespondingToLoan test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePropertyAddressCorrespondingToLoan_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePropertyAddressCorrespondingToLoan.printStackTrace();
			node.fail(validatePropertyAddressCorrespondingToLoan);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_112
	@Test(priority = 93)
	public void validateRegionCorrespondingToLoan() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the Region for each respective loan under the Region column")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Find all the loan references
			List<String> loanReferenceValue = Utils.extractTextFromElements(ReportingLoansPO.loanReference);

			// Find all the region
			List<String> regionValue = Utils.extractTextFromElements(ReportingLoansPO.region);

			// Calling the loadDatabasePageAndClearSearchResult function from the LoansPage
			LoansPage.loadDatabasePageAndClearSearchResult();

			// Find all the loan references
			List<String> loanReferenceInDatabase = Utils.extractTextFromElements(LoansDatabasePO.loanReference);

			// Find all the region in database
			List<String> regionInDatabase = Utils.extractTextFromElements(LoansDatabasePO.region);

			// Create a list to store the matched indexes or positions
			List<Integer> matchedIndexes = new ArrayList<>();

			// Iterate through loanReferenceValue and statusValue
			for (int i = 0; i < loanReferenceValue.size(); i++) {
				String loanRef = loanReferenceValue.get(i);
				String region = regionValue.get(i);
				node.log(Status.INFO,
						"STEP1 : Loan reference in reporting is " + loanRef + " and its region value is " + region);
				System.out.println(
						"STEP1 : Loan reference in reporting is " + loanRef + " and its region value is " + region);

				// Find the index of loanRef in loanReferenceInDatabase
				int indexInDatabase = loanReferenceInDatabase.indexOf(loanRef);

				// If the loan reference exists in the database
				if (indexInDatabase != -1) {

					// Record the index or position
					matchedIndexes.add(indexInDatabase);

					// Now, you have the index or position of loan reference in
					// loanReferenceInDatabase
					// You can use this index to access corresponding region in region database
					String regionInDb = regionInDatabase.get(indexInDatabase);
					System.out.println("Region in database: " + regionInDb);

					// Compare the region
					if (region.equals(regionInDb)) {
						// Region matches
						node.log(Status.PASS, "STEP2 : Region " + region + " of loan reference " + loanRef
								+ " in reporting matches at index " + indexInDatabase + " in database");
						System.out.println("STEP2 : Status " + region + " of loan reference " + loanRef
								+ " in reporting matches at index " + indexInDatabase + " in database");
						Assert.assertTrue(true, "Status " + region + " of loan reference " + loanRef
								+ " in reporting matches at index " + indexInDatabase + " in database");
					} else {
						// Region doesn't match
						node.log(Status.FAIL, "STEP2 : Status " + region + " of loan reference " + loanRef
								+ " in reporting doesn't match at index " + indexInDatabase + " in database");
						System.out.println("STEP2 : Status " + region + " of loan reference " + loanRef
								+ " in reporting doesn't match at index " + indexInDatabase + " in database");
						Assert.assertTrue(false, "Status " + region + " of loan reference " + loanRef
								+ " in reporting doesn't match at index " + indexInDatabase + " in database");
					}
				} else {
					// Loan reference not found in the database
					node.log(Status.FAIL, "STEP2 : Loan reference not found in the database: " + loanRef);
					System.out.println("STEP2 : Loan reference not found in the database: " + loanRef);
					Assert.assertTrue(false, "Loan reference not found in the database: " + loanRef);
				}
			}
			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateRegionCorrespondingToLoan", "Pass", driver);

		} catch (AssertionError validateRegionCorrespondingToLoan) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateRegionCorrespondingToLoan test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRegionCorrespondingToLoan_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRegionCorrespondingToLoan.printStackTrace();
			node.fail(validateRegionCorrespondingToLoan);
			Assert.fail();
			extent.flush();

		} catch (Exception validateRegionCorrespondingToLoan) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateRegionCorrespondingToLoan test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRegionCorrespondingToLoan_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRegionCorrespondingToLoan.printStackTrace();
			node.fail(validateRegionCorrespondingToLoan);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_Loans_113
	@Test(priority = 94)
	public void validatePropertyTypeCorrespondingToLoan() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the Property Type for each respective loan under the Property Type column")
					.assignCategory(reportingLoans_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingLoansPage function from the ReportingPage
			ReportingPage.loadReportingLoansPage();

			// Click on Loan Portfolio Tab
			Utils.clickOnTab(ReportingLoansPO.loanPortfolioTab, ReportingLoansPO.loansHeaderText, "Loan Portfolio");

			// Waiting for the Page Loading To complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Find all the loan references
			List<String> loanReferenceValue = Utils.extractTextFromElements(ReportingLoansPO.loanReference);

			// Find all the property type
			List<String> propertyTypeValue = Utils.extractTextFromElements(ReportingLoansPO.propertyType);

			// Calling the loadDatabasePageAndClearSearchResult function from the LoansPage
			LoansPage.loadDatabasePageAndClearSearchResult();

			// Find all the loan references
			List<String> loanReferenceInDatabase = Utils.extractTextFromElements(LoansDatabasePO.loanReference);

			// Find all the property type in database
			List<String> propertyTypeInDatabase = Utils.extractTextFromElements(LoansDatabasePO.propertyType);

			// Create a list to store the matched indexes or positions
			List<Integer> matchedIndexes = new ArrayList<>();

			// Iterate through loanReferenceValue and statusValue
			for (int i = 0; i < loanReferenceValue.size(); i++) {
				String loanRef = loanReferenceValue.get(i);
				String propertyType = propertyTypeValue.get(i);
				node.log(Status.INFO, "STEP1 : Loan reference in reporting is " + loanRef
						+ " and its property type value is " + propertyType);
				System.out.println("STEP1 : Loan reference in reporting is " + loanRef
						+ " and its property type value is " + propertyType);

				// Find the index of loanRef in loanReferenceInDatabase
				int indexInDatabase = loanReferenceInDatabase.indexOf(loanRef);

				// If the loan reference exists in the database
				if (indexInDatabase != -1) {

					// Record the index or position
					matchedIndexes.add(indexInDatabase);

					// Now, you have the index or position of loan reference in
					// loanReferenceInDatabase
					// You can use this index to access corresponding property type in property type
					// database
					String propertyTypeInDb = propertyTypeInDatabase.get(indexInDatabase);
					System.out.println("Property type in database: " + propertyTypeInDb);

					// Compare the statuses
					if (propertyType.equals(propertyTypeInDb)) {
						// Property type matches
						node.log(Status.PASS, "STEP2 : Property type " + propertyType + " of loan reference " + loanRef
								+ " in reporting matches at index " + indexInDatabase + " in database");
						System.out.println("STEP2 : Status " + propertyType + " of loan reference " + loanRef
								+ " in reporting matches at index " + indexInDatabase + " in database");
						Assert.assertTrue(true, "Status " + propertyType + " of loan reference " + loanRef
								+ " in reporting matches at index " + indexInDatabase + " in database");
					} else {
						// Property type doesn't match
						node.log(Status.FAIL, "STEP2 : Status " + propertyType + " of loan reference " + loanRef
								+ " in reporting doesn't match at index " + indexInDatabase + " in database");
						System.out.println("STEP2 : Status " + propertyType + " of loan reference " + loanRef
								+ " in reporting doesn't match at index " + indexInDatabase + " in database");
						Assert.assertTrue(false, "Status " + propertyType + " of loan reference " + loanRef
								+ " in reporting doesn't match at index " + indexInDatabase + " in database");
					}
				} else {
					// Loan reference not found in the database
					node.log(Status.FAIL, "STEP2 : Loan reference not found in the database: " + loanRef);
					System.out.println("STEP2 : Loan reference not found in the database: " + loanRef);
					Assert.assertTrue(false, "Loan reference not found in the database: " + loanRef);
				}
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validatePropertyTypeCorrespondingToLoan", "Pass", driver);

		} catch (AssertionError validatePropertyTypeCorrespondingToLoan) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePropertyTypeCorrespondingToLoan test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePropertyTypeCorrespondingToLoan_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePropertyTypeCorrespondingToLoan.printStackTrace();
			node.fail(validatePropertyTypeCorrespondingToLoan);
			Assert.fail();
			extent.flush();

		} catch (Exception validatePropertyTypeCorrespondingToLoan) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePropertyTypeCorrespondingToLoan test in LoansTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePropertyTypeCorrespondingToLoan_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePropertyTypeCorrespondingToLoan.printStackTrace();
			node.fail(validatePropertyTypeCorrespondingToLoan);
			Assert.fail();
			extent.flush();
		}
	}

}
