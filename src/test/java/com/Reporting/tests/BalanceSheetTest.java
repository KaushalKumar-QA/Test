package com.Reporting.tests;

import java.io.IOException;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.locators.allPages.FundingDatabasePO;
import com.locators.allPages.FundingNewFacilityPO;
import com.locators.allPages.LoansDatabasePO;
import com.locators.allPages.LoansNewLoanPO;
import com.locators.allPages.PipelinePO;
import com.locators.allPages.ReportingBalanceSheetPO;
import com.locators.allPages.SideMenuPO;
import com.locators.allPages.UtilsPO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IMouseActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.url.AllPagesUrl;
import com.qa.utils.FundingPage;
import com.qa.utils.LoansPage;
import com.qa.utils.LoginPage;
import com.qa.utils.ReportingPage;
import com.qa.utils.Utils;

public class BalanceSheetTest extends Baseclass {
	// TC_Reporting_BalanceSheet_001
	@Test(priority = 1)
	public void validateReportingBalanceSheetPageVisibility() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the user can access the 'Balance Sheet' menu from the side menu options.")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			// Calling the userLoginProcess function from the utils login
			LoginPage.userLoginProcess(node, driver, getDataFromExcel(1), getDataFromExcel(2));

			// Click on the reporting module
			Utils.clickOnMenu(node, driver, SideMenuPO.reporting);

			// Move to Balance Sheet menu and click on it
			IElementActions.moveToElementAndClick_usingXpath(node, driver, SideMenuPO.balanceSheet);
			node.log(Status.INFO, "STEP1 : Clicked on the Balance sheet menu under Reporting");
			System.out.println("STEP1 : Clicked on the Balance sheet menu under Reporting");

			// Wait for the visibility of the balance sheet header text
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the balance sheet header text");
			System.out.println("STEP2 : Waiting for the visibility of the balance sheet header text");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.balanceSheetHeader);
			node.log(Status.INFO, "STEP3 : Balance sheet header text is now visible");
			System.out.println("STEP3 : Balance sheet header text is now visible");

			Thread.sleep(2000);
			// Getting the current URL
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			// Assert that Reporting Balance Sheet Page is visible
			System.out.println("STEP4 : Asserting that Reporting Balance Sheet Page is visible");
			node.log(Status.INFO, "STEP4 : Asserting that Reporting Balance Sheet Page is visible");

			// Calling the validateUrl from Utils
			Utils.validateUrl(node, driver, currentUrl, AllPagesUrl.ReportingBalanceSheetPage,
					"validateReportingBalanceSheetPageVisibility");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateReportingBalanceSheetPageVisibility", "Pass", driver);

		} catch (AssertionError validateReportingBalanceSheetPageVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateReportingBalanceSheetPageVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateReportingBalanceSheetPageVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateReportingBalanceSheetPageVisibility.printStackTrace();
			node.fail(validateReportingBalanceSheetPageVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateReportingBalanceSheetPageVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateReportingBalanceSheetPageVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateReportingBalanceSheetPageVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateReportingBalanceSheetPageVisibility.printStackTrace();
			node.fail(validateReportingBalanceSheetPageVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_002
	@Test(priority = 2)
	public void validateReportingBalanceSheetPageTabs() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify the user is able to view the Balance Sheet page with the following tabs i.e."
							+ "-Balance Sheet Summary" + "-Balance Sheet Details" + "-Cash Balance" + "-Loan Acount"
							+ "-Funding Account")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Check the visibility of Balance Sheet Summary Tab
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.balanceSheetSummary,
					"STEP1 : BUG: Balance sheet summary tab is not coming on Balance sheet page",
					"STEP1 : EXPECTED: Balance sheet summary tab is coming on Balance sheet page");

			// Check the visibility of Balance Sheet Detail Tab
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.balanceSheetDetail,
					"STEP2 : BUG: Balance Sheet Detail tab is not coming on Balance sheet page",
					"STEP2 : EXPECTED: Balance Sheet Detail tab is coming on Balance sheet page");

			// Check the visibility of Cash Balance Tab
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.cashBalance,
					"STEP3 : BUG: Cash Balance tab is not coming on Balance sheet page",
					"STEP3 : EXPECTED: Cash Balance tab is coming on Balance sheet page");

			// Check the visibility of Loan Account Tab
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.loanAccount,
					"STEP4 : BUG: Loan Account tab is not coming on Balance sheet page",
					"STEP4 : EXPECTED: Loan Account tab is coming on Balance sheet page");

			// Check the visibility of Funding Account Tab
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.fundingAccount,
					"STEP5 : BUG: Funding Account tab is not coming on Balance sheet page",
					"STEP5 : EXPECTED: Funding Account tab is coming on Balance sheet page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateReportingBalanceSheetPageTabs", "Pass", driver);

		} catch (AssertionError validateReportingBalanceSheetPageTabs) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateReportingBalanceSheetPageTabs test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateReportingBalanceSheetPageTabs_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateReportingBalanceSheetPageTabs.printStackTrace();
			node.fail(validateReportingBalanceSheetPageTabs);
			Assert.fail();
			extent.flush();

		} catch (Exception validateReportingBalanceSheetPageTabs) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateReportingBalanceSheetPageTabs test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateReportingBalanceSheetPageTabs_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateReportingBalanceSheetPageTabs.printStackTrace();
			node.fail(validateReportingBalanceSheetPageTabs);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_003
	@Test(priority = 3)
	public void validateBalanceSheetSummerySectionsVisibility() throws IOException {
		try {
			extenttest = extent.createTest("Verify the user is able to view the Balance Sheet Summary tab")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Verify the section in Balance Sheet Summary Page
			node.log(Status.INFO, "STEP1 : Verify the sections in the Balance Sheet Summary Page");
			System.out.println("STEP1 : Verify the sections in the Balance Sheet Summary Page");

			// Check the visibility of Search by Month text
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.searchByMonth,
					"STEP2 : BUG : Search by Month text is not coming on Balance Sheet Summary Page",
					"STEP2 : EXPECTED : Search by Month text is coming on Balance Sheet Summary Page");

			// Check the visibility of Search by Month Input Field
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.searchByMonthInputField,
					"STEP3 : BUG : Search by Month Input Field is not coming on Balance Sheet Summary Page",
					"STEP3 : EXPECTED : Search by Month Input Field is coming on Balance Sheet Summary Page");

			// Check the visibility of Custom Search Text
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.customSearch,
					"STEP4 : BUG : Custom Search text is not coming on Balance Sheet Summary Page",
					"STEP4 : EXPECTED : Custom Search text is coming on Balance Sheet Summary Page");

			// Check the visibility of Custom Search Input Field
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.customSearchInputField,
					"STEP5 : BUG : Custom Search Input Field is not coming on Balance Sheet Summary Page",
					"STEP5 : EXPECTED : Custom Search Input Field is coming on Balance Sheet Summary Page");

			// Check the visibility of Asset Text
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.asset,
					"STEP6 : BUG: Asset text is not coming on Balance Sheet Summary Page",
					"STEP6 : EXPECTED: Asset text is coming on Balance Sheet Summary Page");

			// Check the visibility of Liabilities Text
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.liabilities,
					"STEP7 : BUG: Liabilities text is not coming on Balance Sheet Summary Page",
					"STEP7 : EXPECTED: Liabilities text is coming on Balance Sheet Summary Page");

			// Check the visibility of Loan Amount Text
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.loanAmount,
					"STEP8 : BUG: Loan Amount text is not coming on Balance Sheet Summary Page",
					"STEP8 : EXPECTED: Loan Amount text is coming on Balance Sheet Summary Page");

			// Check the visibility of Facility Amount Text
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.facilityAmount,
					"STEP9 : BUG: Facility Amount text is not coming on Balance Sheet Summary Page",
					"STEP9 : EXPECTED: Facility Amount text is coming on Balance Sheet Summary Page");

			// Check the visibility of Cash Amount Text
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.cashAmount,
					"STEP10 : BUG: Cash Amount text is not coming on Balance Sheet Summary Page",
					"STEP10 : EXPECTED: Cash Amount text is coming on Balance Sheet Summary Page");

			// Check the visibility of Loan Balance Table
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.loanBalanceTable,
					"STEP11 : BUG: Loan Balance Table text is not coming on Balance Sheet Summary Page",
					"STEP11 : EXPECTED: Loan Balance Table text is coming on Balance Sheet Summary Page");

			// Check the visibility of Facility Balance Table
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.facilityBalanceTable,
					"STEP12 : BUG: Facility Balance Table is not coming on Balance Sheet Summary Page",
					"STEP12 : EXPECTED: Facility Balance Table is coming on Balance Sheet Summary Page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateBalanceSheetSummerySectionsVisibility", "Pass", driver);

		} catch (AssertionError validateBalanceSheetSummerySectionsVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateBalanceSheetSummerySectionsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBalanceSheetSummerySectionsVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBalanceSheetSummerySectionsVisibility.printStackTrace();
			node.fail(validateBalanceSheetSummerySectionsVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateBalanceSheetSummerySectionsVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateBalanceSheetSummerySectionsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBalanceSheetSummerySectionsVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBalanceSheetSummerySectionsVisibility.printStackTrace();
			node.fail(validateBalanceSheetSummerySectionsVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_004
	@Test(priority = 4)
	public void validateAssetAndLiabilitiesAmountVisibility() throws IOException {
		try {
			extenttest = extent.createTest("Verify that user is able to view the Asset and Liabilities amount")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Check the Visibility of Asset Amount
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.assetAmountValue,
					"STEP1 : BUG: Asset Amount is not coming on Balance Sheet Summary Page",
					"STEP1 : EXPECTED: Asset Amount "
							+ IElementActions.getTextbyXpath(node, ReportingBalanceSheetPO.assetAmountValue)
							+ " is coming on Balance Sheet Summary Page");

			// Check the Visibility of Liabilities Amount
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.liabilitiesAmountValue,
					"STEP2 : BUG: Liabilities Amount is not Balance Sheet Summary Page",
					"STEP2 : EXPECTED: Liabilities Amount "
							+ IElementActions.getTextbyXpath(node, ReportingBalanceSheetPO.liabilitiesAmountValue)
							+ " is coming on Balance Sheet Summary Page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAssetAndLiabilitiesAmountVisibility", "Pass", driver);

		} catch (AssertionError validateAssetAndLiabilitiesAmountVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAssetAndLiabilitiesAmountVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAssetAndLiabilitiesAmountVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAssetAndLiabilitiesAmountVisibility.printStackTrace();
			node.fail(validateAssetAndLiabilitiesAmountVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAssetAndLiabilitiesAmountVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAssetAndLiabilitiesAmountVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAssetAndLiabilitiesAmountVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAssetAndLiabilitiesAmountVisibility.printStackTrace();
			node.fail(validateAssetAndLiabilitiesAmountVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_005
	@Test(priority = 5)
	public void validateAssetAmountValue() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that user is able to get the Asset amount displayed is equal to the sum of the Loan Amount and Cash Amount")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Getting value of the Asset Amount
			double assertAmountValue = Utils.getTextAndParseToDouble(ReportingBalanceSheetPO.assetAmountValue);

			// Getting value of the Loan Amount
			double loanAmountValue = Utils.getTextAndParseToDouble(ReportingBalanceSheetPO.loanAmountValue);

			// Getting value of the Cash Amount
			double cashAmountValue = Utils.getTextAndParseToDouble(ReportingBalanceSheetPO.cashAmountValue);

			// Asserting the Asset Amount is the sum of Loan and Cash Amount
			IElementActions.assertEquals_usingDouble(node, driver, assertAmountValue, loanAmountValue + cashAmountValue,
					"STEP1 : BUG : The Asset Amount " + assertAmountValue + " is not sum of the Loan and Cash Amount."
							+ loanAmountValue + cashAmountValue,
					"STEP1 : PASS : The Asset Amount " + assertAmountValue + " is sum of the Loan and Cash Amount."
							+ loanAmountValue + cashAmountValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAssetAmountValue", "Pass", driver);

		} catch (AssertionError validateAssetAmountValue) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAssetAmountValue test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAssetAmountValue_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAssetAmountValue.printStackTrace();
			node.fail(validateAssetAmountValue);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAssetAmountValue) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAssetAmountValue test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAssetAmountValue_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAssetAmountValue.printStackTrace();
			node.fail(validateAssetAmountValue);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_006
	@Test(priority = 6)
	public void validateLiabilitiesAmountValue() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the user is able to get Liability amount equal to the Facilities Amount")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Getting value of the Liabilities Amount
			double liabilitiesAmountValue = Utils
					.getTextAndParseToDouble(ReportingBalanceSheetPO.liabilitiesAmountValue);

			// Getting value of the Facilities Amount
			double facilitiesAmountValue = Utils.getTextAndParseToDouble(ReportingBalanceSheetPO.facilitiesAmountValue);

			// Asserting that the Liabilities Amount equal to the Facilities Amount
			IElementActions.assertEquals_usingDouble(node, driver, liabilitiesAmountValue, facilitiesAmountValue,
					"STEP1 : BUG : The Liabilities Amount is " + liabilitiesAmountValue
							+ "  not same with the Facilities Amount." + facilitiesAmountValue,
					"STEP1 : PASS : The Liabilities Amount is " + liabilitiesAmountValue
							+ " same with the Facilities Amount." + facilitiesAmountValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLiabilitiesAmountValue", "Pass", driver);

		} catch (AssertionError validateLiabilitiesAmountValue) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLiabilitiesAmountValue test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLiabilitiesAmountValue_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLiabilitiesAmountValue.printStackTrace();
			node.fail(validateLiabilitiesAmountValue);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLiabilitiesAmountValue) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLiabilitiesAmountValue test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLiabilitiesAmountValue_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLiabilitiesAmountValue.printStackTrace();
			node.fail(validateLiabilitiesAmountValue);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_007
	@Test(priority = 7)
	public void validateLoanAmountIsSumOfAllBorrowerLoanAmount() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that Loan Amount is equals to the sum of all borrower Loan amount present in the Loan Balance table")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Getting value of the loan amount
			double loanAmountValue = Utils.getTextAndParseToDouble(ReportingBalanceSheetPO.loanAmountValue);

			// Calling calculateSumOfList from the Utils Class
			double borrowerLoanAmountsValue = Utils.calculateSumOfList(ReportingBalanceSheetPO.loanBalanceAmountValue);

			// Set the Acceptable Difference
			int acceptableDifference = Integer.parseInt(getDataFromExcel(10));

			// Perform Assertion Allowing for a Difference Around 5 with a Delta Parameter
			Assert.assertEquals(loanAmountValue, borrowerLoanAmountsValue, acceptableDifference,
					"Difference is greater than the acceptable range");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanAmountIsSumOfAllBorrowerLoanAmount", "Pass", driver);

		} catch (AssertionError validateLoanAmountIsSumOfAllBorrowerLoanAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanAmountIsSumOfAllBorrowerLoanAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanAmountIsSumOfAllBorrowerLoanAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanAmountIsSumOfAllBorrowerLoanAmount.printStackTrace();
			node.fail(validateLoanAmountIsSumOfAllBorrowerLoanAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanAmountIsSumOfAllBorrowerLoanAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanAmountIsSumOfAllBorrowerLoanAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanAmountIsSumOfAllBorrowerLoanAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanAmountIsSumOfAllBorrowerLoanAmount.printStackTrace();
			node.fail(validateLoanAmountIsSumOfAllBorrowerLoanAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_008
	@Test(priority = 8)
	public void validateFacilitiesAmountIsSumOfAllFacilityAmount() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that Facilities Amount is equals to the sum of all Facility amount present in the Facility Balance table")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Getting value of the facilities amount
			double facilitiesAmountValue = Utils.getTextAndParseToDouble(ReportingBalanceSheetPO.facilitiesAmountValue);

			// Calling calculateSumOfList from the Utils Class
			double facilityBalanceAmountsValue = Utils
					.calculateSumOfListExceptUndefinedValue(ReportingBalanceSheetPO.facilityBalanceAmountValue);

			// Set the Acceptable Difference
			int acceptableDifference = Integer.parseInt(getDataFromExcel(10));

			// Perform Assertion Allowing for a Difference Around 5 with a Delta Parameter
			Assert.assertEquals(facilitiesAmountValue, facilityBalanceAmountsValue, acceptableDifference,
					"Difference is greater than the acceptable range");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilitiesAmountIsSumOfAllFacilityAmount", "Pass",
					driver);

		} catch (AssertionError validateFacilitiesAmountIsSumOfAllFacilityAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilitiesAmountIsSumOfAllFacilityAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilitiesAmountIsSumOfAllFacilityAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilitiesAmountIsSumOfAllFacilityAmount.printStackTrace();
			node.fail(validateFacilitiesAmountIsSumOfAllFacilityAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilitiesAmountIsSumOfAllFacilityAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilitiesAmountIsSumOfAllFacilityAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilitiesAmountIsSumOfAllFacilityAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilitiesAmountIsSumOfAllFacilityAmount.printStackTrace();
			node.fail(validateFacilitiesAmountIsSumOfAllFacilityAmount);
			Assert.fail();
			extent.flush();
		}

	}

	// TC_Reporting_BalanceSheet_009
	@Test(priority = 9)
	public void validateValuesOnApplyingCustomSearchCalender() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that when user select date from the Custom search calendar then values will update and match the selected date")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			String year = Utils.getCurrectYear();
			String month = Utils.getCurrentMonth();
			String day = Utils.getTodayDayFormatted();

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Getting Value of the Facilities Amount before Search
			double facilitiesAmount = Utils.getTextAndParseToDouble(ReportingBalanceSheetPO.facilitiesAmountValue);

			// Getting Value of the Loan Amount before Search
			double loanAmount = Utils.getTextAndParseToDouble(ReportingBalanceSheetPO.loanAmountValue);

			// Getting value of the Cash Amount before Search
			double cashAmount = Utils.getTextAndParseToDouble(ReportingBalanceSheetPO.cashAmountValue);

			// Calling enterDate from Utils to Select Date from Calendar
			Utils.enterDate(ReportingBalanceSheetPO.customSearchInputField, UtilsPO.calenderMonth, month,
					UtilsPO.calenderYear, year, UtilsPO.calenderDay, day);

			// Click on the Custom Search Button
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.customSearchButton);
			node.log(Status.INFO, "STEP1 : The Clicked on the Custom Search Button.");
			System.out.println("STEP1 : The Clicked on the Custom Search Button.");

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Getting value of the Facilities Amount after Search
			double updatedFacilitiesAmount = Utils
					.getTextAndParseToDouble(ReportingBalanceSheetPO.facilitiesAmountValue);

			// Getting value of the Loan Amount after Search
			double updatedLoanAmount = Utils.getTextAndParseToDouble(ReportingBalanceSheetPO.loanAmountValue);

			// Getting value of the Cash Amount after Search
			double updatedCashAmount = Utils.getTextAndParseToDouble(ReportingBalanceSheetPO.cashAmountValue);

			// Assert the Facilities Amount
			IElementActions.assertEqualsFalse_usingDouble(node, driver, updatedFacilitiesAmount, facilitiesAmount,
					"STEP2 : BUG : The Facilities Amount before Search " + facilitiesAmount
							+ " is same as Facilities Amount after Search" + updatedFacilitiesAmount,
					"STEP2 : PASS : The Facilities Amount before Search " + facilitiesAmount
							+ " is not same as Facilities Amount after Search" + updatedFacilitiesAmount);

			// Assert the Loan amount
			IElementActions.assertEqualsFalse_usingDouble(node, driver, updatedLoanAmount, loanAmount,
					"STEP3 : BUG : The Loan Amount before Search " + loanAmount + " is same as Loan Amount after Search"
							+ updatedLoanAmount,
					"STEP3 : PASS : The Loan Amount before Search " + loanAmount
							+ " is not same as Loan Amount after Search" + updatedLoanAmount);

			// Assert the Cash Amount
			IElementActions.assertEqualsFalse_usingDouble(node, driver, updatedCashAmount, cashAmount,
					"STEP4 : BUG : The Cash Amount before Search " + cashAmount + " is same as Cash Amount after Search"
							+ updatedCashAmount,
					"STEP4 : PASS : The Cash Amount before Search " + cashAmount
							+ " is not same as Cash Amount after Search" + updatedCashAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateValuesOnApplyingCustomSearchCalender", "Pass", driver);

		} catch (AssertionError validateValuesOnApplyingCustomSearchCalender) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateValuesOnApplyingCustomSearchCalender test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateValuesOnApplyingCustomSearchCalender_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateValuesOnApplyingCustomSearchCalender.printStackTrace();
			node.fail(validateValuesOnApplyingCustomSearchCalender);
			Assert.fail();
			extent.flush();

		} catch (Exception validateValuesOnApplyingCustomSearchCalender) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateValuesOnApplyingCustomSearchCalender test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateValuesOnApplyingCustomSearchCalender_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateValuesOnApplyingCustomSearchCalender.printStackTrace();
			node.fail(validateValuesOnApplyingCustomSearchCalender);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_010
	@Test(priority = 10)
	public void validateCustomSearchCalenderPopup() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify when the user clicks on the Custom Search Date field calendar is getting open")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on the Custom Search Input Field
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.customSearchInputField);
			node.log(Status.INFO, "STEP1 : Clicked on Custom Search Input Field.");
			System.out.println("STEP1 : Clicked on Custom Search Input Field.");

			// Wait for the visibility of the calendar
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the Calendar");
			System.out.println("STEP2 : Waiting for the visibility of the Calendar");
			IWaitStrategy.waitForVisiblity(node, driver, UtilsPO.calenderMonth);
			node.log(Status.INFO, "STEP3 : The Calendar is now visible");
			System.out.println("STEP3 : The Calendar is now visible");

			// Assert that the Clicking on the Custom Search Date input field then
			// Calender is open
			IElementActions.assertTrue_usingXpath(node, driver, UtilsPO.calenderMonth,
					"STEP4 : BUG : Clicking on the Custom Search Date input field then Calendar is not open.",
					"STEP4 : PASS : Clicking on the Custom Search Date input field then Calendar is open.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCustomSearchCalenderPopup", "Pass", driver);

		} catch (AssertionError validateCustomSearchCalenderPopup) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCustomSearchCalenderPopup test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCustomSearchCalenderPopup_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCustomSearchCalenderPopup.printStackTrace();
			node.fail(validateCustomSearchCalenderPopup);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCustomSearchCalenderPopup) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCustomSearchCalenderPopup test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCustomSearchCalenderPopup_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCustomSearchCalenderPopup.printStackTrace();
			node.fail(validateCustomSearchCalenderPopup);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_011
	@Test(priority = 11)
	public void validateCustomFieldInitialSelectedDate() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify the initial state of the calendar selected as a previous month last date by default on clicking on the calendar.")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refreshing the page
			IElementActions.pageRefresh();

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Wait for the visibility of the calendar
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the custom search input field");
			System.out.println("STEP1 : Waiting for the visibility of the custom search input field");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.customSearchInputField);
			node.log(Status.INFO, "STEP2 : The Custom Search input field is now visible");
			System.out.println("STEP2 : The Custom Search input field is now visible");

			// Getting the attribute value of the selected custom search field
			String selcetedCustomSearchDate = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					ReportingBalanceSheetPO.customSearchInputField, "value");

			// Calling getLastDayOfPreviousMonth from utils
			String lastDayOfPreviousMonth = Utils.getLastDayOfPreviousMonth();

			// Assert the Custom Search Selected Date
			IElementActions.assertEquals_usingString(node, driver, selcetedCustomSearchDate, lastDayOfPreviousMonth,
					"STEP3 : BUG : The selceted date " + selcetedCustomSearchDate
							+ " does not match with the previous month last date " + lastDayOfPreviousMonth,
					"STEP3 : PASS : The selceted date " + selcetedCustomSearchDate
							+ " is matched with the previous month last date" + lastDayOfPreviousMonth);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCustomFieldInitialSelectedDate", "Pass", driver);

		} catch (AssertionError validateCustomFieldInitialSelectedDate) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCustomFieldInitialSelectedDate test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCustomFieldInitialSelectedDate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCustomFieldInitialSelectedDate.printStackTrace();
			node.fail(validateCustomFieldInitialSelectedDate);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCustomFieldInitialSelectedDate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCustomFieldInitialSelectedDate test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCustomFieldInitialSelectedDate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCustomFieldInitialSelectedDate.printStackTrace();
			node.fail(validateCustomFieldInitialSelectedDate);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_012
	@Test(priority = 12)
	public void validateAppliedDateInCustomSearchField() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify when the user selects a date from the calendar date picker, the same date is populated in the Date field and the calendar date picker should close automatically.")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			String year = Utils.getCurrectYear();
			String month = Utils.getCurrentMonth();
			String day = Utils.getTodayDayFormatted();

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling enterDate from Utils to select Date From Calendar
			Utils.enterDate(ReportingBalanceSheetPO.customSearchInputField, UtilsPO.calenderMonth, month,
					UtilsPO.calenderYear, year, UtilsPO.calenderDay, day);

			Thread.sleep(1000);
			// Getting the attribute value of the selected custom search field
			String selcetedCustomSearchDate = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					ReportingBalanceSheetPO.customSearchInputField, "value");
			node.log(Status.INFO, "STEP1 : Selected date is " + selcetedCustomSearchDate);
			System.out.println("STEP1 : Selected date is " + selcetedCustomSearchDate);

			// Assert the selected date
			IElementActions.assertTrue_ConditionBased(node, driver, selcetedCustomSearchDate.contains(day),
					"STEP1 : BUG : The selected date from calendar is not populated in the custom search field",
					"STEP1 : PASS : The selected date from calendar is populated in the custom search field");

			// Assert the selected month
			IElementActions.assertTrue_ConditionBased(node, driver, selcetedCustomSearchDate.contains(month),
					"STEP2 : BUG : The selected month from calendar is not populated in the custom search field",
					"STEP2 : PASS : The selected month from calendar is populated in the custom search field");

			// Assert the selected year
			IElementActions.assertTrue_ConditionBased(node, driver, selcetedCustomSearchDate.contains(year),
					"STEP3 : BUG : The selected year from calendar is not populated in the custom search field",
					"STEP3 : PASS : The selected year from calendar is populated in the custom search field");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAppliedDateInCustomSearchField", "Pass", driver);

		} catch (AssertionError validateAppliedDateInCustomSearchField) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAppliedDateInCustomSearchField test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAppliedDateInCustomSearchField_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAppliedDateInCustomSearchField.printStackTrace();
			node.fail(validateAppliedDateInCustomSearchField);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAppliedDateInCustomSearchField) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAppliedDateInCustomSearchField test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAppliedDateInCustomSearchField_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAppliedDateInCustomSearchField.printStackTrace();
			node.fail(validateAppliedDateInCustomSearchField);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_013
	@Test(priority = 13)
	public void validateCalendarClosedOnClickedOutside() throws IOException {
		try {
			extenttest = extent
					.createTest(
							"Verify when the user clicks outside the calendar date picker then calendar gets closed.")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on the Custom Search Date field
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.customSearchInputField);
			node.log(Status.INFO, "STEP1 : Clicked on Custom Search Date field");
			System.out.println("STEP1 : Clicked on Custom Search Date field");

			// Wait for the visibility of the calendar
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of calendar");
			System.out.println("STEP2 : Waiting for the visibility of the calendar");
			IWaitStrategy.waitForVisiblity(node, driver, UtilsPO.calenderMonth);
			node.log(Status.INFO, "STEP3 : The calendar is now visible");
			System.out.println("STEP3 : The calendar is now visible");

			// Calling mouseHoverByOffsetAndClick from IMouseActions
			IMouseActions.mouseHoverByOffsetAndClick(836, 129);

			// Assert the calendar popup
			IElementActions.assertFalse_usingXpath(node, driver, UtilsPO.calenderMonth,
					"STEP4 : BUG : After clicking outside the datepicker calendar is not getting closed.",
					"STEP4 : PASS : After clicking outside the datepicker calendar is getting closed.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCalendarClosedOnClickedOutside", "Pass", driver);

		} catch (AssertionError validateCalendarClosedOnClickedOutside) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCalendarClosedOnClickedOutside test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCalendarClosedOnClickedOutside_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCalendarClosedOnClickedOutside.printStackTrace();
			node.fail(validateCalendarClosedOnClickedOutside);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCalendarClosedOnClickedOutside) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCalendarClosedOnClickedOutside test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCalendarClosedOnClickedOutside_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCalendarClosedOnClickedOutside.printStackTrace();
			node.fail(validateCalendarClosedOnClickedOutside);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_014
	@Test(priority = 14)
	public void validateCalendarMonthsOnClickSearchByMonth() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that when user select search by month calendar it will dispaly only months to select on calendar")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Call the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

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

			// Assert the The calendar display only months for selection, without days or
			// years
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.allMonthsCalendar,
					"STEP4 : BUG : The calendar is not display only months for selection, without days or years",
					"STEP4 : PASS : The calendar display only months for selection, without days or years");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCalendarMonthsOnClickSearchByMonth", "Pass", driver);

		} catch (AssertionError validateCalendarMonthsOnClickSearchByMonth) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCalendarMonthsOnClickSearchByMonth test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCalendarMonthsOnClickSearchByMonth_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCalendarMonthsOnClickSearchByMonth.printStackTrace();
			node.fail(validateCalendarMonthsOnClickSearchByMonth);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCalendarMonthsOnClickSearchByMonth) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCalendarMonthsOnClickSearchByMonth test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCalendarMonthsOnClickSearchByMonth_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCalendarMonthsOnClickSearchByMonth.printStackTrace();
			node.fail(validateCalendarMonthsOnClickSearchByMonth);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_015
	@Test(priority = 15)
	public void validateCalendarYearByForwardAndBackwordArrow() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that user can select the year form calendar for Search by Month option using forward and backword arrows")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on the search by month field
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.searchByMonthInputField);
			node.log(Status.INFO, "STEP1 : The Clicked on Search By Month input field");
			System.out.println("STEP1 : The Clicked on Search By Month input field");

			// Wait for the visibility of the calendar
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the months in calendar");
			System.out.println("STEP2 : Waiting for the visibility of the months in calendar");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.allMonthsCalendar);
			node.log(Status.INFO, "STEP3 : Months in calendar is now visible");
			System.out.println("STEP3 : Months in calendar is now visible");

			// Getting the current year
			int currentYear = LocalDate.now().getYear();

			// Click on the calendar previous arrow
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.calendarPreviousArrrow);
			node.log(Status.INFO, "STEP4 : The Clicked on Calender revious Arrow Icon");
			System.out.println("STEP4 : The Clicked on Calender Previous Arrow Icon");

			// Getting the calendar year value from the field
			String previousYearFieldValue = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					ReportingBalanceSheetPO.calendarYear, "value");

			// Assert the Previous Year
			IElementActions.assertTrue_ConditionBased(node, driver,
					Integer.parseInt(previousYearFieldValue) < currentYear,
					"STEP5 : BUG : The Previous year " + previousYearFieldValue
							+ " is not selectable by clicking previous arrow",
					"STEP5 : PASS : The Previous year " + previousYearFieldValue
							+ " is selectable by clicking previous arrow");

			// Click on the calendar next arrow
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.calendarNextArrow);
			node.log(Status.INFO, "STEP6 : The Clicked on Calender Next Arrow Icon");
			System.out.println("STEP6 : The Clicked on Calender Next Arrow Icon");

			// Getting the calendar year value from the field
			String nextYearFieldValue = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					ReportingBalanceSheetPO.calendarYear, "value");

			// Assert the Next Year
			IElementActions.assertTrue_ConditionBased(node, driver, Integer.parseInt(nextYearFieldValue) == currentYear,
					"STEP7 : BUG : The Next Year " + nextYearFieldValue + " is not selectable by clicking next arrow",
					"STEP7 : PASS : The Next Year " + nextYearFieldValue + " is selectable by clicking next arrow");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCalendarYearByForwardAndBackwordArrow", "Pass", driver);

		} catch (AssertionError validateCalendarYearByForwardAndBackwordArrow) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCalendarYearByForwardAndBackwordArrow test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCalendarYearByForwardAndBackwordArrow_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCalendarYearByForwardAndBackwordArrow.printStackTrace();
			node.fail(validateCalendarYearByForwardAndBackwordArrow);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCalendarYearByForwardAndBackwordArrow) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCalendarYearByForwardAndBackwordArrow test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCalendarYearByForwardAndBackwordArrow_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCalendarYearByForwardAndBackwordArrow.printStackTrace();
			node.fail(validateCalendarYearByForwardAndBackwordArrow);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_016
	@Test(priority = 16)
	public void validateUpdatedAmountsAfterSearchByMonth() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that when user select month and click on Search field then the values for Loans, Facilities, and Cash should be updated to match the selected date")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Getting value of the Facilities Amount before search
			double facilitiesAmount = Utils.getTextAndParseToDouble(ReportingBalanceSheetPO.facilitiesAmountValue);

			// Getting value of the Loan Amount before search
			double loanAmount = Utils.getTextAndParseToDouble(ReportingBalanceSheetPO.loanAmountValue);

			// Getting value of the Cash Amount before search
			double cashAmount = Utils.getTextAndParseToDouble(ReportingBalanceSheetPO.cashAmountValue);

			// Click on the Search by Month Input Field
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.searchByMonthInputField);
			node.log(Status.INFO, "STEP1 : The Clicked on Search by Month Input Field");
			System.out.println("STEP1 : The Clicked on Search by Month Input Field");

			// Wait for the visibility of the calendar
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the months in calendar");
			System.out.println("STEP2 : Waiting for the visibility of the months in calendar");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.allMonthsCalendar);
			node.log(Status.INFO, "STEP3 : The Months in calendar is now visible");
			System.out.println("STEP3 : The Months in calendar is now visible");

			// Select the January Month
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.januaryMonth);
			node.log(Status.INFO, "STEP4 : The Clicked on Jan Month");
			System.out.println("STEP4 : The Clicked on Jan Month");

			// Click on the Search Button
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.searchByMonthSearchButton);
			node.log(Status.INFO, "STEP5 : The Clicked on Search Button");
			System.out.println("STEP5 : The Clicked on Search Button");

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Wait for the visibility of the Facilities Amount
			node.log(Status.INFO, "STEP6 : Waiting for the visibility of the Facilities Amount");
			System.out.println("STEP6 : Waiting for the visibility of the Facilities Amount");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.facilitiesAmountValue);
			node.log(Status.INFO, "STEP7 :The Facilities Amount is now visible");
			System.out.println("STEP7 : The Facilities Amount is now visible");

			// Getting value of the Facilities Amount after search
			double updatedFacilitiesAmount = Utils
					.getTextAndParseToDouble(ReportingBalanceSheetPO.facilitiesAmountValue);

			// Getting value of the Loan Amount after search
			double updatedLoanAmount = Utils.getTextAndParseToDouble(ReportingBalanceSheetPO.loanAmountValue);

			// Getting value of the Cash Amount after search
			double updatedCashAmount = Utils.getTextAndParseToDouble(ReportingBalanceSheetPO.cashAmountValue);

			// Assert the Updated Facilities Amount
			IElementActions.assertEqualsFalse_usingDouble(node, driver, updatedFacilitiesAmount, facilitiesAmount,
					"STEP8 : BUG : The Facilities Amount Before Search is " + facilitiesAmount
							+ " is same Facilities Amount After Search" + updatedFacilitiesAmount,
					"STEP8 : PASS : The Facilities Amount Before Search is " + facilitiesAmount
							+ " is not same Facilities Amount After Search" + updatedFacilitiesAmount);

			// Assert the Updated Loan Amount
			IElementActions.assertEqualsFalse_usingDouble(node, driver, updatedLoanAmount, loanAmount,
					"STEP9 : BUG : The Loan Amount Before Search is " + loanAmount
							+ " is same Loan Amount After Search " + loanAmount,
					"STEP9 : PASS : The Loan Amount Before Search is " + loanAmount
							+ " is not same Loan Amount After Search " + loanAmount);

			// Assert the Updated Cash Amount
			IElementActions.assertEqualsFalse_usingDouble(node, driver, updatedCashAmount, cashAmount,
					"STEP10 : BUG : The Cash Amount Before Search is " + cashAmount
							+ " is same Cash Amount After Search " + loanAmount,
					"STEP10 : PASS :The Cash Amount Before Search is " + cashAmount
							+ " is not same Cash Amount After Search " + loanAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateUpdatedAmountsAfterSearchByMonth", "Pass", driver);

		} catch (AssertionError validateUpdatedAmountsAfterSearchByMonth) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateUpdatedAmountsAfterSearchByMonth test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateUpdatedAmountsAfterSearchByMonth_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateUpdatedAmountsAfterSearchByMonth.printStackTrace();
			node.fail(validateUpdatedAmountsAfterSearchByMonth);
			Assert.fail();
			extent.flush();

		} catch (Exception validateUpdatedAmountsAfterSearchByMonth) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateUpdatedAmountsAfterSearchByMonth test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateUpdatedAmountsAfterSearchByMonth_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateUpdatedAmountsAfterSearchByMonth.printStackTrace();
			node.fail(validateUpdatedAmountsAfterSearchByMonth);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_017
	@Test(priority = 17)
	public void validateAmountsWithoutSearchBySelectMonth() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify when user select month then values for Loans,Facilities and Cash will not update without clicking on Search field")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Wait for the visibility of the facilities amount
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the Facilities Amount");
			System.out.println("STEP1 : Waiting for the visibility of the Facilities Amount");
			IWaitStrategy.waitForVisiblityDynamic(node, driver, ReportingBalanceSheetPO.facilitiesAmountValue, 150);
			node.log(Status.INFO, "STEP2 : The Facilities Amount is now visible");
			System.out.println("STEP2 : The Facilities Amount is now visible");

			// Getting value of the Facilities Amount
			double facilitiesAmount = Utils.getTextAndParseToDouble(ReportingBalanceSheetPO.facilitiesAmountValue);

			// Getting value of the Loan Amount
			double loanAmount = Utils.getTextAndParseToDouble(ReportingBalanceSheetPO.loanAmountValue);

			// Getting value of the Cash Amount
			double cashAmount = Utils.getTextAndParseToDouble(ReportingBalanceSheetPO.cashAmountValue);

			// Click on the Search by Month Input Field
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.searchByMonthInputField);
			node.log(Status.INFO, "STEP3 : The Clicked on Search by Month Input Field");
			System.out.println("STEP3 : The Clicked on Search by Month Input Field");

			// Wait for the visibility of the calendar
			node.log(Status.INFO, "STEP4 : Waiting for the visibility of the months in calendar");
			System.out.println("STEP4 : Waiting for the visibility of the months in calendar");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.allMonthsCalendar);
			node.log(Status.INFO, "STEP5 : Months in calendar is now visible");
			System.out.println("STEP5 : Months in calendar is now visible");

			// Select the January month
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.januaryMonth);
			node.log(Status.INFO, "STEP6 : The Clicked on Jan Month");
			System.out.println("STEP6 : The Clicked on Jan Month");

			// Wait for the visibility of the Facilities Amount
			node.log(Status.INFO, "STEP7 : Waiting for the visibility of the Facilities Amount");
			System.out.println("STEP7 : Waiting for the visibility of the Facilities Amount");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.facilitiesAmountValue);
			node.log(Status.INFO, "STEP8 : Facilities Amount is now visible");
			System.out.println("STEP8 : Facilities Amount is now visible");

			// Getting value of the Facilities Amount
			double updatedFacilitiesAmount = Utils
					.getTextAndParseToDouble(ReportingBalanceSheetPO.facilitiesAmountValue);

			// Getting value of the Loan Amount
			double updatedLoanAmount = Utils.getTextAndParseToDouble(ReportingBalanceSheetPO.loanAmountValue);

			// Getting value of the Cash Amount
			double updatedCashAmount = Utils.getTextAndParseToDouble(ReportingBalanceSheetPO.cashAmountValue);

			// Assert the Facilities Amount is not updated
			IElementActions.assertEquals_usingDouble(node, driver, updatedFacilitiesAmount, facilitiesAmount,
					"STEP9 : BUG : After selecting month without search, Facilities Amount is updated.",
					"STEP9 : PASS : After selecting month without search, Facilities Amount is not updated");

			// Assert the Loan Amount is not updated
			IElementActions.assertEquals_usingDouble(node, driver, updatedLoanAmount, loanAmount,
					"STEP10 : BUG : After selecting month without search, Loan Amount is updated",
					"STEP10 : PASS : After selecting month without search, Loan Amount is not updated");

			// Assert the Cash Amount is not updated
			IElementActions.assertEquals_usingDouble(node, driver, updatedCashAmount, cashAmount,
					"STEP11 : BUG : After selecting month without search, Cash Amount is updated",
					"STEP11 : PASS : After selecting month without search, Cash Amount is not updated");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAmountsWithoutSearchBySelectMonth", "Pass", driver);

		} catch (AssertionError validateAmountsWithoutSearchBySelectMonth) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAmountsWithoutSearchBySelectMonth test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAmountsWithoutSearchBySelectMonth_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAmountsWithoutSearchBySelectMonth.printStackTrace();
			node.fail(validateAmountsWithoutSearchBySelectMonth);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAmountsWithoutSearchBySelectMonth) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAmountsWithoutSearchBySelectMonth test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAmountsWithoutSearchBySelectMonth_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAmountsWithoutSearchBySelectMonth.printStackTrace();
			node.fail(validateAmountsWithoutSearchBySelectMonth);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_018
	@Test(priority = 18)
	public void validateMonthCalendarClosedOnClickedOutside() throws IOException {
		try {
			extenttest = extent
					.createTest(
							"Verify when the user clicks outside the calendar date picker then calendar gets closed.")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on the Search by Month Input Field
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.searchByMonthInputField);
			node.log(Status.INFO, "STEP1 : The Clicked on the Search by Month Input Field");
			System.out.println("STEP1 : The Clicked on the Search by Month Input Field");

			// Wait for the visibility of the calendar
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the months in calendar");
			System.out.println("STEP2 : Waiting for the visibility of the months in calendar");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.allMonthsCalendar);
			node.log(Status.INFO, "STEP3 : Months in calendar is now visible");
			System.out.println("STEP3 : Months in calendar is now visible");

			// Call mouseHoverByOffsetAndClick from IMouseActions
			IMouseActions.mouseHoverByOffsetAndClick(300, 150);

			// Wait for the invisibility of the calendar
			node.log(Status.INFO, "STEP4 : Waiting for the invisibility of the calendar");
			System.out.println("STEP4 : Waiting for the invisibility of the calendar");
			IWaitStrategy.waitForInVisiblity(node, driver, ReportingBalanceSheetPO.allMonthsCalendar);
			node.log(Status.INFO, "STEP5 : Calendar is now invisible");
			System.out.println("STEP5 : Calendar is now invisible");

			// Asserting the calendar popup
			IElementActions.assertFalse_usingXpath(node, driver, ReportingBalanceSheetPO.allMonthsCalendar,
					"STEP6 : BUG : After clicking outside the datepicker Calender is not getting closed.",
					"STEP6 : PASS : After clicking outside the datepicker Calender is getting closed.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateMonthCalendarClosedOnClickedOutside", "Pass", driver);

		} catch (AssertionError validateMonthCalendarClosedOnClickedOutside) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateMonthCalendarClosedOnClickedOutside test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateMonthCalendarClosedOnClickedOutside_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMonthCalendarClosedOnClickedOutside.printStackTrace();
			node.fail(validateMonthCalendarClosedOnClickedOutside);
			Assert.fail();
			extent.flush();

		} catch (Exception validateMonthCalendarClosedOnClickedOutside) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateMonthCalendarClosedOnClickedOutside test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateMonthCalendarClosedOnClickedOutside_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMonthCalendarClosedOnClickedOutside.printStackTrace();
			node.fail(validateMonthCalendarClosedOnClickedOutside);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_019
	@Test(priority = 19)
	public void validateLoanBalanceTableColumns() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify if the user is able to view the  Loans Balance table with the following columns i.e."
							+ "-Inernal Reference" + "-Loan Ref" + "-Amount")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Verify the columns of the Loan Balance Table
			node.log(Status.INFO, "STEP1 : Verify the columns of Loan Balance Table.");
			System.out.println("STEP1 : Verify the columns of Loan Balance Table");

			// Check the visibility of Internal Reference Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.loanBalanceInternalRefColumn,
					"STEP2 : BUG: The Internal Reference column is not coming under Loan Balance Table.",
					"STEP2 : EXPECTED: The Internal Reference column is coming under Loan Balance Table.");

			// Check the visibility of Loan Reference Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.loanBalanceLoanRefColumn,
					"STEP3 : BUG: The Loan Reference column is not coming under Loan Balance Table",
					"STEP3 : EXPECTED: The Loan Reference column is coming under Loan Balance Table");

			// Check the visibility of Amount Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.loanBalanceAmountColumn,
					"STEP4 : BUG: The Amount column is not coming under Loan Balance Table",
					"STEP4 : EXPECTED: The Amount column is coming under Loan Balance Table");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanBalanceTableColumns", "Pass", driver);

		} catch (AssertionError validateLoanBalanceTableColumns) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanBalanceTableColumns test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanBalanceTableColumns_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanBalanceTableColumns.printStackTrace();
			node.fail(validateLoanBalanceTableColumns);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanBalanceTableColumns) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanBalanceTableColumns test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanBalanceTableColumns_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanBalanceTableColumns.printStackTrace();
			node.fail(validateLoanBalanceTableColumns);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_020
	@Test(priority = 20)
	public void validateLoanBalanceAmountColumnDataSorting() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify when user click on a column heading toggle a second time, the row  in the table are sorted in descending order of that category.")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Clicked on the amount column sort icon twice and validate list
			Utils.validateDescendingOrder(node, driver, "Amount", ReportingBalanceSheetPO.loanBalanceAmountColumnToggle,
					ReportingBalanceSheetPO.loanBalanceAmountColumnValue, "validateLoanBalanceAmountColumnDataSorting");

		} catch (AssertionError validateLoanBalanceAmountColumnDataSorting) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanBalanceAmountColumnDataSorting test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanBalanceAmountColumnDataSorting_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanBalanceAmountColumnDataSorting.printStackTrace();
			node.fail(validateLoanBalanceAmountColumnDataSorting);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanBalanceAmountColumnDataSorting) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanBalanceAmountColumnDataSorting test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanBalanceAmountColumnDataSorting_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanBalanceAmountColumnDataSorting.printStackTrace();
			node.fail(validateLoanBalanceAmountColumnDataSorting);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_021
	@Test(priority = 21)
	public void validateLoanBalanceLoanRefColumnDataSorting() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the Loan Reference number in the Loan Reference column in descending order on again clicking on heading")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Sort the listing in descending order
			Utils.sortListingInDescendin(ReportingBalanceSheetPO.loanBalanceLoanRefColumnToggle, "Loan Reference",
					ReportingBalanceSheetPO.loanBalanceLoanRefColumnValue);

			// Check the descending order for the element column
			Utils.validateDataSorting(node, driver, ReportingBalanceSheetPO.loanBalanceLoanRefColumnValue, "descending",
					"validateLoanBalanceLoanRefColumnDataSorting");

		} catch (AssertionError validateLoanBalanceLoanRefColumnDataSorting) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanBalanceLoanRefColumnDataSorting test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanBalanceLoanRefColumnDataSorting_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanBalanceLoanRefColumnDataSorting.printStackTrace();
			node.fail(validateLoanBalanceLoanRefColumnDataSorting);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanBalanceLoanRefColumnDataSorting) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanBalanceLoanRefColumnDataSorting test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanBalanceLoanRefColumnDataSorting_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanBalanceLoanRefColumnDataSorting.printStackTrace();
			node.fail(validateLoanBalanceLoanRefColumnDataSorting);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_022
	@Test(priority = 22)
	public void validateLoanBalanceRefNameInLoanDatabase() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the Internal Reference in the Internal Reference column for each respective loan")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Getting the First Loan Reference column value
			String loanBalanceLoanRefNo = IElementActions.getElementText_usingXpath(node, driver,
					ReportingBalanceSheetPO.firstLoanBalanceLoanRefColumnValue);

			// Getting the first Loan Internal Reference Name
			String loanBalanceInternalRefName = IElementActions.getElementText_usingXpath(node, driver,
					ReportingBalanceSheetPO.firstLoanBalanceInternalRefName);

			// Calling the loadDatabasePage from LoansPage
			LoansPage.loadDatabasePage();

			// Enter on search box of internal reference column
			Utils.enterValueInSearchBox(LoansDatabasePO.loanRefSearchField, loanBalanceLoanRefNo);

			// Getting the First Internal Reference Name
			String loanDatabaseInternalRefName = IElementActions.getElementText_usingXpath(node, driver,
					LoansDatabasePO.firstLoanInternalRefNameRowValue);

			// Assert the Internal Reference Name
			IElementActions.assertEquals_usingString(node, driver, loanDatabaseInternalRefName,
					loanBalanceInternalRefName,
					"STEP1 : BUG : The Loan Balance Internal Reference Name " + loanBalanceInternalRefName
							+ " is not same as " + loanDatabaseInternalRefName,
					"STEP1 : PASS : The Loan Balance Internal Reference Name " + loanBalanceInternalRefName
							+ " is same as " + loanDatabaseInternalRefName);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanBalanceRefNameInLoanDatabase", "Pass", driver);

		} catch (AssertionError validateLoanBalanceRefNameInLoanDatabase) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanBalanceRefNameInLoanDatabase test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanBalanceRefNameInLoanDatabase_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanBalanceRefNameInLoanDatabase.printStackTrace();
			node.fail(validateLoanBalanceRefNameInLoanDatabase);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanBalanceRefNameInLoanDatabase) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanBalanceRefNameInLoanDatabase test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanBalanceRefNameInLoanDatabase_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanBalanceRefNameInLoanDatabase.printStackTrace();
			node.fail(validateLoanBalanceRefNameInLoanDatabase);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_023
	@Test(priority = 23)
	public void validateNavigateEditBridgeLoanPageFromLoanBalance() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that when user clicks on Internal Referance name then user navigate to the Edit Bridge Loan>> Summary tab of New Loan module.")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on the Internal Reference Column First Name
			IElementActions.clickelement_usingXpath(node, driver,
					ReportingBalanceSheetPO.firstLoanBalanceInternalRefName);
			node.log(Status.INFO, "STEP1 : The Clicked on Internal Reference Column First Name");
			System.out.println("STEP1 : The Clicked on Internal Reference Column First Name");

			// Wait for the visibility of the Edit Bridge Loan Header Text
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the Edit Bridge Loan Header Text");
			System.out.println("STEP2 : Waiting for the visibility of the Edit Bridge Loan Header Text");
			IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.editBridgeLoanHeaderText);
			node.log(Status.INFO, "STEP3 :  Edit Bridge Loan Header Text is now visible");
			System.out.println("STEP3 :  Edit Bridge Loan Header Text is now visible");

			// Assert the Edit Bridge Loan Header Text
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.editBridgeLoanHeaderText,
					"STEP4 : BUG : The user is not navigating to the Edit Bridge Loan Summary Page from Loan Balance Table",
					"STEP4 : PASS : The user is navigating to the Edit Bridge Loan Summary Page from Loan Balance Table");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateNavigateEditBridgeLoanPageFromLoanBalance", "Pass",
					driver);

		} catch (AssertionError validateNavigateEditBridgeLoanPageFromLoanBalance) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNavigateEditBridgeLoanPageFromLoanBalance test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNavigateEditBridgeLoanPageFromLoanBalance_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNavigateEditBridgeLoanPageFromLoanBalance.printStackTrace();
			node.fail(validateNavigateEditBridgeLoanPageFromLoanBalance);
			Assert.fail();
			extent.flush();

		} catch (Exception validateNavigateEditBridgeLoanPageFromLoanBalance) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNavigateEditBridgeLoanPageFromLoanBalance test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNavigateEditBridgeLoanPageFromLoanBalance_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNavigateEditBridgeLoanPageFromLoanBalance.printStackTrace();
			node.fail(validateNavigateEditBridgeLoanPageFromLoanBalance);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_024
	@Test(priority = 24)
	public void validateLoanRefNoInLoanDatabase() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the Loan Reference number in the Loan Reference column")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Getting the First Loan Reference Column Value
			String loanBalanceLoanRefNo = IElementActions.getElementText_usingXpath(node, driver,
					ReportingBalanceSheetPO.firstLoanBalanceLoanRefColumnValue);

			// Calling the loadDatabasePage from LoansPage
			LoansPage.loadDatabasePage();

			// Wait for the visibility of the loan reference search field
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the loan reference search field");
			System.out.println("STEP1 : Waiting for the visibility of the loan reference search field");
			IWaitStrategy.waitForVisiblity(node, driver, LoansDatabasePO.loanRefSearchField);
			node.log(Status.INFO, "STEP2 : Loan reference search field is now visible");
			System.out.println("STEP2 : Loan reference search field is now visible");

			// Enter on search box of loan reference column
			Utils.enterSearchTextAndValidate(UtilsPO.headerSearchCrossIcon, LoansDatabasePO.loanRefSearchField,
					loanBalanceLoanRefNo, LoansDatabasePO.firstLoanRefRowValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanRefNoInLoanDatabase", "Pass", driver);

		} catch (AssertionError validateLoanRefNoInLoanDatabase) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanRefNoInLoanDatabase test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanRefNoInLoanDatabase_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanRefNoInLoanDatabase.printStackTrace();
			node.fail(validateLoanRefNoInLoanDatabase);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanRefNoInLoanDatabase) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanRefNoInLoanDatabase test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanRefNoInLoanDatabase_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanRefNoInLoanDatabase.printStackTrace();
			node.fail(validateLoanRefNoInLoanDatabase);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_025
	@Test(priority = 25)
	public void validateLoanBalanceAmountInLoanDatabase() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the  loan amount for each respective loan under the Amount column")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Getting the first loan reference column value
			String loanBalanceLoanRefNo = IElementActions.getElementText_usingXpath(node, driver,
					ReportingBalanceSheetPO.firstLoanBalanceLoanRefColumnValue);

			// Getting the first loan balance amount column value
			String loanBalanceAmountValue = IElementActions.getElementText_usingXpath(node, driver,
					ReportingBalanceSheetPO.firstLoanBalanceAmountColumnValue);

			// Calling the loadDatabasePage from LoansPage
			LoansPage.loadDatabasePage();

			// Enter on search box of loan reference column
			Utils.enterValueInSearchBox(LoansDatabasePO.loanRefSearchField, loanBalanceLoanRefNo);

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.progressBar);

			// Getting the first current amount column value
			String loanDatabaseLoanAmountValue = IElementActions.getElementText_usingXpath(node, driver,
					LoansDatabasePO.firstLoanCurrentAmountRowValue);

			// Assert the Loan Amount
			IElementActions.assertEquals_usingString(node, driver, loanDatabaseLoanAmountValue, loanBalanceAmountValue,
					"STEP1 : BUG : The Loan Balance Amount " + loanBalanceAmountValue
							+ " does not appear in the Loan Database" + loanDatabaseLoanAmountValue,
					"STEP1 : PASS : The Loan Balance Amount " + loanBalanceAmountValue + " Appear in the Loan Database"
							+ loanDatabaseLoanAmountValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanBalanceAmountInLoanDatabase", "Pass", driver);

		} catch (AssertionError validateLoanBalanceAmountInLoanDatabase) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanBalanceAmountInLoanDatabase test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanBalanceAmountInLoanDatabase_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanBalanceAmountInLoanDatabase.printStackTrace();
			node.fail(validateLoanBalanceAmountInLoanDatabase);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanBalanceAmountInLoanDatabase) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanBalanceAmountInLoanDatabase test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanBalanceAmountInLoanDatabase_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanBalanceAmountInLoanDatabase.printStackTrace();
			node.fail(validateLoanBalanceAmountInLoanDatabase);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_029
	@Test(priority = 26)
	public void validateAmountsWhenUserPerformLoanDisbursement() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that when a user performs any loan disbursement, the corresponding amount is displayed under the 'Amount' column for the specific reference")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Load new loan
			LoansPage.loadNewLoanPage();

			// Create loan
			LoansPage.createLoan("tomorrow");

			// Update status
			LoansPage.updateStatus("Live");

			// Get loan disbursement
			String loanDisbursementValue = getDataFromExcel(29);

			// Click on summary tab
			Utils.clickOnTab(LoansNewLoanPO.summaryTab, LoansNewLoanPO.loanDetailsHeader, "Summary");

			// Get current amount value
			int currentAmountBeforeDisbursement = Utils.getTextAndParseToInt(LoansNewLoanPO.currentAmountSummary);

			// Add a loan disbursement cash flow
			LoansPage.addCashflow(LoansNewLoanPO.paymentAddNewCashflow, LoansNewLoanPO.loanDisbursement,
					loanDisbursementValue);

			// Wait for the visibility of first row cashflow amount
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of first row cashflow amount");
			System.out.println("STEP1 : Waiting for the visibility of first row cashflow amount");
			IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.firstRowCashflowAmount);
			node.log(Status.INFO, "STEP2 : The first row cashflow amount is visible");
			System.out.println("STEP2 : The first row cashflow amount is visible");

			// Get loan disbursement amount
			int loanDisbursementAmount = Utils.getTextAndParseToInt(LoansNewLoanPO.firstRowCashflowAmount);

			// Approve the cashflow
			LoansPage.approveCashflow(LoansNewLoanPO.firstRowCashflowAmount);

			// Get loan reference
			String loanReference = getDataFromExcel(25);

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Call the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Get the loan amount
			String loanAmount = ReportingPage
					.getElementValue(ReportingBalanceSheetPO.amountCorrespondingToLoanOrFacility, loanReference);

			String expectedLoanAmount = Utils.formatText(loanAmount);

			// Assert the facility amount
			IElementActions.assertEquals_usingString(node, driver, loanDisbursementValue, expectedLoanAmount,
					"STEP3 : BUG : Loan disbursement value is " + loanDisbursementValue
							+ " and is not equal to the loan amount value in balancesheet " + expectedLoanAmount,
					"STEP3 : EXPECTED : Loan disbursement value is " + loanDisbursementValue
							+ "  and is equal to the loan amount value in balancesheet " + expectedLoanAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAmountsWhenUserPerformLoanDisbursement", "Pass", driver);

		} catch (AssertionError validateAmountsWhenUserPerformLoanDisbursement) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAmountsWhenUserPerformLoanDisbursement test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAmountsWhenUserPerformLoanDisbursement_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAmountsWhenUserPerformLoanDisbursement.printStackTrace();
			node.fail(validateAmountsWhenUserPerformLoanDisbursement);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAmountsWhenUserPerformLoanDisbursement) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAmountsWhenUserPerformLoanDisbursement test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAmountsWhenUserPerformLoanDisbursement_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAmountsWhenUserPerformLoanDisbursement.printStackTrace();
			node.fail(validateAmountsWhenUserPerformLoanDisbursement);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_030
	@Test(priority = 27)
	public void validateUpdatedDisbursedAmount() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that when a user performs any loan disbursement, the loan amount is updated by the disbursed amount")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get loan reference
			String loanReference = getDataFromExcel(25);

			// Get loan disbursement
			String loanDisbursementValue = getDataFromExcel(29);

			// Calling the loadDatabasePage from LoansPage
			LoansPage.loadDatabasePage();

			// Search record based on the provide loan reference and open it
			Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, LoansDatabasePO.loanRefSearchField,
					loanReference, UtilsPO.editIcon, LoansNewLoanPO.editBridgeLoanHeaderText);

			// Add a loan disbursement cash flow
			LoansPage.addCashflow(LoansNewLoanPO.paymentAddNewCashflow, LoansNewLoanPO.loanDisbursement,
					loanDisbursementValue);

			// Wait for the visibility of first row cashflow amount
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of first row cashflow amount");
			System.out.println("STEP1 : Waiting for the visibility of first row cashflow amount");
			IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.firstRowCashflowAmount);
			node.log(Status.INFO, "STEP2 : The first row cashflow amount is visible");
			System.out.println("STEP2 : The first row cashflow amount is visible");

			// Get loan disbursement amount
			int loanDisbursementAmount = Utils.getTextAndParseToInt(LoansNewLoanPO.firstRowCashflowAmount);

			// Approve the cashflow
			LoansPage.approveCashflow(LoansNewLoanPO.firstRowCashflowAmount);

			// Click on summary tab
			Utils.clickOnTab(LoansNewLoanPO.summaryTab, LoansNewLoanPO.loanDetailsHeader, "Summary");

			// Get current amount value
			String currentAmount = IElementActions.getElementText_usingXpath(node, driver,
					LoansNewLoanPO.currentAmountSummary);

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Call the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Get the updated loan amount
			String actualUpdatedLoanAmount = ReportingPage
					.getElementValue(ReportingBalanceSheetPO.amountCorrespondingToLoanOrFacility, loanReference);

			// Assert the updated loan amount
			IElementActions.assertEquals_usingString(node, driver, actualUpdatedLoanAmount, currentAmount,
					"STEP3 : BUG : Loan disbursement amount is " + currentAmount
							+ " and is equal to the updated loan amount " + actualUpdatedLoanAmount,
					"STEP3 : EXPECTED : Loan disbursement amount is " + currentAmount
							+ " and is equal to the updated loan amount " + actualUpdatedLoanAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateUpdatedDisbursedAmount", "Pass", driver);

		} catch (AssertionError validateUpdatedDisbursedAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateUpdatedDisbursedAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateUpdatedDisbursedAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateUpdatedDisbursedAmount.printStackTrace();
			node.fail(validateUpdatedDisbursedAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateUpdatedDisbursedAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateUpdatedDisbursedAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateUpdatedDisbursedAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateUpdatedDisbursedAmount.printStackTrace();
			node.fail(validateUpdatedDisbursedAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_031
	@Test(priority = 28)
	public void validateFacilityBalanceTableColumnsVisibility() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify if the user is able to view the Facility Balance table wih the following columns i.e."
							+ "-Internal Referance" + "-Facility Ref" + "-Amount")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Verify the columns of the Facility Balance Table
			node.log(Status.INFO, "STEP1 : Verify the Facility Balance Table Columns Visibility.");
			System.out.println("STEP1 :  Verify the Facility Balance Table Columns Visibility.");

			// Check the visibility of Internal Reference Column
			IElementActions.assertTrue_usingXpath(node, driver,
					ReportingBalanceSheetPO.facilityBalanceInternalRefColumn,
					"STEP2 : BUG: The Internal Reference column is not coming under Facility Balance Table.",
					"STEP2 : EXPECTED: The Internal Reference column is coming under Facility Balance Table.");

			// Check the visibility of Facility Reference Column
			IElementActions.assertTrue_usingXpath(node, driver,
					ReportingBalanceSheetPO.facilityBalanceFacilityRefColumn,
					"STEP3 : BUG: The Facility Reference column is not coming under Facility Balance Table",
					"STEP3 : EXPECTED: The Facility Reference column is coming under Facility Balance Table");

			// Check the visibility of Amount Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.facilityBalanceAmountColumn,
					"STEP4 : BUG: The Amount column is not coming under Facility Balance Table",
					"STEP4 : EXPECTED: The Amount column is coming under Facility Balance Table");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityBalanceTableColumnsVisibility", "Pass", driver);

		} catch (AssertionError validateFacilityBalanceTableColumnsVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityBalanceTableColumnsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityBalanceTableColumnsVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityBalanceTableColumnsVisibility.printStackTrace();
			node.fail(validateFacilityBalanceTableColumnsVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityBalanceTableColumnsVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityBalanceTableColumnsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityBalanceTableColumnsVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityBalanceTableColumnsVisibility.printStackTrace();
			node.fail(validateFacilityBalanceTableColumnsVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_032
	@Test(priority = 29)
	public void validateFacilityBalanceTableAscendingOrderDataSorting() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify when user click on a column heading toggle for Facility Ref for 1st  time, the row  in the table are sorted in ascending order of that category.")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Scroll, click sort icon, confirm sorting
			ReportingPage.scrollAndClickToCheckSort(ReportingBalanceSheetPO.facilityBalanceFacilityRefColumnToggle,
					"Facility Reference", ReportingBalanceSheetPO.facilityBalanceFacilityRefColumnValue, "ascending",
					"validateFacilityBalanceTableAscendingOrderDataSorting", "singleClick");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityBalanceTableAscendingOrderDataSorting", "Pass",
					driver);

		} catch (AssertionError validateFacilityBalanceTableAscendingOrderDataSorting) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityBalanceTableAscendingOrderDataSorting test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityBalanceTableAscendingOrderDataSorting_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityBalanceTableAscendingOrderDataSorting.printStackTrace();
			node.fail(validateFacilityBalanceTableAscendingOrderDataSorting);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityBalanceTableAscendingOrderDataSorting) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityBalanceTableAscendingOrderDataSorting test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityBalanceTableAscendingOrderDataSorting_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityBalanceTableAscendingOrderDataSorting.printStackTrace();
			node.fail(validateFacilityBalanceTableAscendingOrderDataSorting);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_033
	@Test(priority = 30)
	public void validateFacilityReferenceDataSorting() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify when user click on a column heading toggle for Facility Ref for a second time, the row  in the table are sorted in descending order of that category.")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Scroll, click sort icon, confirm sorting
			ReportingPage.scrollAndClickToCheckSort(ReportingBalanceSheetPO.facilityBalanceFacilityRefColumnToggle,
					"Facility Reference", ReportingBalanceSheetPO.facilityBalanceFacilityRefColumnValue, "descending",
					"validateFacilityReferenceDataSorting", "doubleClick");

		} catch (AssertionError validateFacilityReferenceDataSorting) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityReferenceDataSorting test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityReferenceDataSorting_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityReferenceDataSorting.printStackTrace();
			node.fail(validateFacilityReferenceDataSorting);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityReferenceDataSorting) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityReferenceDataSorting test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityReferenceDataSorting_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityReferenceDataSorting.printStackTrace();
			node.fail(validateFacilityReferenceDataSorting);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_034
	@Test(priority = 31)
	public void validateInternalRefNoInLoanDatabase() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the Internal Reference in the Internal Reference column for each respective Facility Balance")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Getting the First Internal Reference Column Value
			String firstInternalRefValue = IElementActions.getElementText_usingXpath(node, driver,
					ReportingBalanceSheetPO.firstFacilityBalanceInternalRefColumnValue);

			// Calling the loadDatabasePage from LoansPage
			LoansPage.loadDatabasePage();

			// Wait for the Visibility of the Internal Reference Search Field
			node.log(Status.INFO, "STEP1 : Waiting for the Visibility of the Internal Reference Search Field");
			System.out.println("STEP1 : Waiting for the Visibility of the Internal Reference Search Field");
			IWaitStrategy.waitForVisiblity(node, driver, LoansDatabasePO.internalRefSearchField);
			node.log(Status.INFO, "STEP2 : Internal Reference Search Field is now visible");
			System.out.println("STEP2 : Internal Reference Search Field is now visible");

			// Calling the enterSearchTextAndValidate from Utils class
			Utils.enterSearchTextAndValidate(UtilsPO.headerSearchCrossIcon, LoansDatabasePO.internalRefSearchField,
					firstInternalRefValue, LoansDatabasePO.firstLoanInternalRefNameRowValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateInternalRefNoInLoanDatabase", "Pass", driver);

		} catch (AssertionError validateInternalRefNoInLoanDatabase) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInternalRefNoInLoanDatabase test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInternalRefNoInLoanDatabase_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInternalRefNoInLoanDatabase.printStackTrace();
			node.fail(validateInternalRefNoInLoanDatabase);
			Assert.fail();
			extent.flush();

		} catch (Exception validateInternalRefNoInLoanDatabase) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInternalRefNoInLoanDatabase test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInternalRefNoInLoanDatabase_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInternalRefNoInLoanDatabase.printStackTrace();
			node.fail(validateInternalRefNoInLoanDatabase);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_035
	@Test(priority = 32)
	public void validateNavigationToEditLoanFacilitySummaryTab() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that when user clicks on Internal Referance name then user navigate to the Edit Loan Facility>> Summary tab of New Facility")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on the Internal Reference Column First Name
			IElementActions.clickelement_usingXpath(node, driver,
					ReportingBalanceSheetPO.firstFacilityBalanceInternalRefColumnValue);
			node.log(Status.INFO, "STEP1 : The Clicked on Internal Reference Column First Name");
			System.out.println("STEP1 : The Clicked on Internal Reference Column First Name");

			// Wait for the visibility of the Edit Loan Facility Header Text
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the Edit Loan Facility Header Text");
			System.out.println("STEP2 : Waiting for the visibility of the Edit Loan Facility Header Text");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.editLoanFacilityText);
			node.log(Status.INFO, "STEP3 :  Edit Loan Facility Header Text is now visible");
			System.out.println("STEP3 :  Edit Loan Facility Header Text is now visible");

			Thread.sleep(2000);

			// Getting the current URL
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			if ((currentUrl.contains("summary") && currentUrl.contains("loan-facility/lf"))) {
				node.log(Status.INFO,
						"STEP4 : PASS : The clicking on Internal Ref Name ,user is naviagating to the the Edit Loan Facility Summary Tab");
				System.out.println(
						"STEP4 : PASS : The clicking on Internal Ref Name ,user is naviagating to the the Edit Loan Facility Summary Tab");
			} else {
				node.log(Status.INFO,
						"STEP4 : BUG : The clicking on Internal Ref Name ,the user is not naviagating to the the Edit Loan Facility Summary Tab");
				System.out.println(
						"STEP4 : BUG : The clicking on Internal Ref Name ,the user is not naviagating to the the Edit Loan Facility Summary Tab");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateNavigationToEditLoanFacilitySummaryTab", "Pass", driver);

		} catch (AssertionError validateNavigationToEditLoanFacilitySummaryTab) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNavigationToEditLoanFacilitySummaryTab test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNavigationToEditLoanFacilitySummaryTab_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNavigationToEditLoanFacilitySummaryTab.printStackTrace();
			node.fail(validateNavigationToEditLoanFacilitySummaryTab);
			Assert.fail();
			extent.flush();

		} catch (Exception validateNavigationToEditLoanFacilitySummaryTab) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNavigationToEditLoanFacilitySummaryTab test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNavigationToEditLoanFacilitySummaryTab_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNavigationToEditLoanFacilitySummaryTab.printStackTrace();
			node.fail(validateNavigationToEditLoanFacilitySummaryTab);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_036
	@Test(priority = 33)
	public void validateFacilityRefNumber() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the Facility Reference Number in the Facility Ref column")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Getting the First Facility Reference Column Value
			String firstFacilityRefValue = IElementActions.getElementText_usingXpath(node, driver,
					ReportingBalanceSheetPO.firstFacilityBalanceFacilityRefColumnValue);

			// Calling the loadDatabasePage from FundingPage
			FundingPage.loadDatabasePage();

			// Wait for the Visibility of the Reference Search Field
			node.log(Status.INFO, "STEP1 : Waiting for the Visibility of the Reference Search Field");
			System.out.println("STEP1 : Waiting for the Visibility of the Reference Search Field");
			IWaitStrategy.waitForVisiblity(node, driver, FundingDatabasePO.referenceSearchBox);
			node.log(Status.INFO, "STEP2 : The Reference Search Field is now visible");
			System.out.println("STEP2 : The Reference Search Field is now visible");

			// Calling the enterSearchTextAndValidate from Utils class
			Utils.enterSearchTextAndValidate(UtilsPO.headerSearchCrossIcon, FundingDatabasePO.referenceSearchBox,
					firstFacilityRefValue, FundingDatabasePO.referenceFirstRowValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityRefNumber", "Pass", driver);

		} catch (AssertionError validateFacilityRefNumber) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityRefNumber test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFacilityRefNumber_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityRefNumber.printStackTrace();
			node.fail(validateFacilityRefNumber);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityRefNumber) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityRefNumber test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFacilityRefNumber_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityRefNumber.printStackTrace();
			node.fail(validateFacilityRefNumber);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_037
	@Test(priority = 34)
	public void validateNavigationToEditLoanFacilitySummaryPage() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that when a user clicks on the Facility Reference number under the respective column, the system correctly navigates the user to the Edit Loan Facility>> Summary tab of  Funding module")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Facility Reference Column First Facility Ref
			IElementActions.clickelement_usingXpath(node, driver,
					ReportingBalanceSheetPO.firstFacilityBalanceFacilityRefColumnValue);
			node.log(Status.INFO, "STEP1 : The Clicked on Facility Reference Column First Facility Ref");
			System.out.println("STEP1 :  The Clicked on Facility Reference Column First Facility Ref");

			// Wait for the visibility of the Edit Loan Facility Header Text
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the Edit Loan Facility Header Text");
			System.out.println("STEP2 : Waiting for the visibility of the Edit Loan Facility Header Text");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.editLoanFacilityText);
			node.log(Status.INFO, "STEP3 :  Edit Loan Facility Header Text is now visible");
			System.out.println("STEP3 :  Edit Loan Facility Header Text is now visible");

			Thread.sleep(2000);

			// Getting the current URL
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			if ((currentUrl.contains("summary") && currentUrl.contains("loan-facility/lf"))) {
				node.log(Status.INFO,
						"STEP4 : PASS : The clicking on Facility Ref ,user is naviagating to the the Edit Loan Facility Summary Tab");
				System.out.println(
						"STEP4 : PASS : The clicking on Facility Ref ,user is naviagating to the the Edit Loan Facility Summary Tab");
			} else {
				node.log(Status.INFO,
						"STEP4 : BUG : The clicking on Facility Ref ,user is not naviagating to the the Edit Loan Facility Summary Tab");
				System.out.println(
						"STEP4 : BUG : The clicking on Facility Ref ,user is not naviagating to the the Edit Loan Facility Summary Tab");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateNavigationToEditLoanFacilitySummaryPage", "Pass", driver);

		} catch (AssertionError validateNavigationToEditLoanFacilitySummaryPage) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNavigationToEditLoanFacilitySummaryPage test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNavigationToEditLoanFacilitySummaryPage_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNavigationToEditLoanFacilitySummaryPage.printStackTrace();
			node.fail(validateNavigationToEditLoanFacilitySummaryPage);
			Assert.fail();
			extent.flush();

		} catch (Exception validateNavigationToEditLoanFacilitySummaryPage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNavigationToEditLoanFacilitySummaryPage test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNavigationToEditLoanFacilitySummaryPage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNavigationToEditLoanFacilitySummaryPage.printStackTrace();
			node.fail(validateNavigationToEditLoanFacilitySummaryPage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_038
	@Test(priority = 35)
	public void validateFacilityAmountInFundingDatabase() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the Facility amount for each respective Facility under the Amount column.")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Getting the first Facility Reference column value
			String firstFacilityRefValue = IElementActions.getElementText_usingXpath(node, driver,
					ReportingBalanceSheetPO.firstFacilityBalanceFacilityRefColumnValue);

			// Getting the First Amount Column Value
			String firstAmountValue = IElementActions.getElementText_usingXpath(node, driver,
					ReportingBalanceSheetPO.firstFacilityBalanceAmountColumnValue);

			// Calling the loadDatabasePage from FundingPage
			FundingPage.loadDatabasePage();

			// Calling the enterSearchTextAndValidate from Utils class
			Utils.enterSearchTextAndValidate(UtilsPO.headerSearchCrossIcon, FundingDatabasePO.referenceSearchBox,
					firstFacilityRefValue, FundingDatabasePO.referenceFirstRowValue);

			// Getting the first Drawn column value
			String drawncolumnFirstValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingDatabasePO.drawnFirstRowValue);

			// Assert the Amount
			IElementActions.assertEquals_usingString(node, driver, drawncolumnFirstValue, firstAmountValue,
					"STEP1 : BUG : The Facility Balance Amount " + firstAmountValue
							+ " does not appear in the Funding Database" + drawncolumnFirstValue,
					"STEP1 : PASS : BUG : The Facility Balance Amount " + firstAmountValue
							+ " appear in the Funding Database " + drawncolumnFirstValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityAmountInFundingDatabase", "Pass", driver);

		} catch (AssertionError validateFacilityAmountInFundingDatabase) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityAmountInFundingDatabase test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityAmountInFundingDatabase_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityAmountInFundingDatabase.printStackTrace();
			node.fail(validateFacilityAmountInFundingDatabase);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityAmountInFundingDatabase) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityAmountInFundingDatabase test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityAmountInFundingDatabase_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityAmountInFundingDatabase.printStackTrace();
			node.fail(validateFacilityAmountInFundingDatabase);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_042
	@Test(priority = 36)
	public void validateFacilityDisbursement() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that when a user performs any Facility disbursement, the corresponding amount is displayed under the 'Amount' column for the specific reference")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Scroll to the element vertically
			IElementActions.scrollbyJSExecutorUsingElementPath(driver,
					ReportingBalanceSheetPO.firstFacilityBalanceFacilityRefColumnValue);
			node.log(Status.INFO, "STEP1 : Scrolled to the element vertically");
			System.out.println("STEP1 : Scrolled to the element vertically");

			// Wait for the visibility of facility amount
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of facility balance amount");
			System.out.println("STEP2 : Waiting for the visibility of facility balance amount");
			IWaitStrategy.waitForVisiblity(node, driver,
					ReportingBalanceSheetPO.firstFacilityBalanceFacilityRefColumnValue);
			node.log(Status.INFO, "STEP3 : The facility balance amount is visible");
			System.out.println("STEP3 : The facility balance amount is visible");

			// Get the facility balance amount
			String actualFacilityAmount = IElementActions.getElementText_usingXpath(node, driver,
					ReportingBalanceSheetPO.firstFacilityBalanceAmountColumnValue);

			// Get facility reference
			String facilityReferenceNumber = IElementActions.getElementText_usingXpath(node, driver,
					ReportingBalanceSheetPO.firstFacilityBalanceFacilityRefColumnValue);

			facilityReferenceNumber = facilityReferenceNumber.trim();
			System.out.println("facilityReferenceNumber " + facilityReferenceNumber);

			// Call the loadDatabasePage function from the FundingPage
			FundingPage.loadDatabasePage();

			// Search record based on the provide loan reference and open it
			Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, FundingNewFacilityPO.reference,
					facilityReferenceNumber, UtilsPO.editIcon, FundingNewFacilityPO.editLoanFacilityText);

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.facilityTab, FundingNewFacilityPO.amountInputField,
					"Facility");

			// Getting the value of the available amount of facility
			String availableAmount = IElementActions.getElementValue(node, driver,
					FundingNewFacilityPO.amountInputField);

			if (actualFacilityAmount.equalsIgnoreCase("-")) {
				// Assert the facility balance amount

				IElementActions.assertEquals_usingString(node, driver, availableAmount, "£0",
						"STEP4 : BUG : Facility balance amount in balancesheet is " + actualFacilityAmount
								+ "  and is not equal to the expected available amount " + availableAmount
								+ " of facility " + facilityReferenceNumber,
						"STEP4 : EXPECTED : Facility balance amount in balancesheet is " + actualFacilityAmount
								+ " and is equal to the expected available amount " + availableAmount + " of facility "
								+ facilityReferenceNumber);
			} else {
				// Assert the facility balance amount
				IElementActions.assertEquals_usingString(node, driver, actualFacilityAmount, availableAmount,
						"STEP4 : BUG : Facility balance amount in balancesheet is " + actualFacilityAmount
								+ " and is not equal to the available amount " + availableAmount + " of facility "
								+ facilityReferenceNumber,
						"STEP4 : EXPECTED : Facility balance amount in balancesheet is " + actualFacilityAmount
								+ " and is equal to the available amount " + availableAmount + " of facility "
								+ facilityReferenceNumber);
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityDisbursement", "Pass", driver);

		} catch (AssertionError validateFacilityDisbursement) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityDisbursement test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFacilityDisbursement_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityDisbursement.printStackTrace();
			node.fail(validateFacilityDisbursement);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityDisbursement) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityDisbursement test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFacilityDisbursement_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityDisbursement.printStackTrace();
			node.fail(validateFacilityDisbursement);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_045
	@Test(priority = 37)
	public void validateBalanceSheetDetailsSectionsVisibility() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify if the user is able to view the Balance Sheet Details tab with following sections i.e"
							+ "-Search by Month" + "-Custom Search" + "-Asset Balance" + "- Cash Balance"
							+ "--Loan Balance" + "-Facilities Balance" + "-Loan Balance table"
							+ "-Facility Balance table")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Verify the Balance Sheet Detail Sections Visibility
			node.log(Status.INFO, "STEP1 : Verify the Balance Sheet Detail Sections Visibility.");
			System.out.println("STEP1 :  Verify the Balance Sheet Detail Sections Visibility.");

			// Check the visibility of Search by Month Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.searchByMonthSection,
					"STEP2 : BUG: The Search by Month Section is not coming on Balance Sheet Detail Page.",
					"STEP2 : EXPECTED: The Search by Month Section is coming on Balance Sheet Detail Page.");

			// Check the visibility of Custom Search Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.customSearchSection,
					"STEP3 : BUG: The Custom Search Section is not coming on Balance Sheet Detail Page.",
					"STEP3 : EXPECTED: The Custom Search Section is coming on Balance Sheet Detail Page.");

			// Check the visibility of Asset Balance Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.assetBalanceSection,
					"STEP4 : BUG: The Asset Balance Section is not coming on Balance Sheet Detail Page.",
					"STEP4 : EXPECTED: The Asset Balance Section is coming on Balance Sheet Detail Page.");

			// Check the visibility of Cash Balance Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.cashBalanceSection,
					"STEP5 : BUG: The Cash Balance Section is not coming on Balance Sheet Detail Page.",
					"STEP5 : EXPECTED: The Cash Balance Section is coming on Balance Sheet Detail Page.");

			// Check the visibility of Loan Balance Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.loanBalanceSection,
					"STEP6 : BUG: The Loan Balance Section is not coming on Balance Sheet Detail Page.",
					"STEP6 : EXPECTED: The Loan Balance Section is coming on Balance Sheet Detail Page.");

			// Check the visibility of Facilities Balance Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.facilitiesBalanceSection,
					"STEP7 : BUG: The Facilities Balance Section is not coming on Balance Sheet Detail Page.",
					"STEP7 : EXPECTED: The Facilities Balance Section is coming on Balance Sheet Detail Page.");

			// Check the visibility of Loan Balance Table
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.loanBalanceTable,
					"STEP8 : BUG: The Loan Balance Table is not coming on Balance Sheet Detail Page.",
					"STEP8 : EXPECTED: The Loan Balance Table is coming on Balance Sheet Detail Page.");

			// Check the visibility of Facility Balance Table
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.facilityBalanceTable,
					"STEP9 : BUG: The Facility  Balance Table is not coming on Balance Sheet Detail Page.",
					"STEP9 : EXPECTED: The Facility Balance Table is coming on Balance Sheet Detail Page.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateBalanceSheetDetailsSectionsVisibility", "Pass", driver);

		} catch (AssertionError validateBalanceSheetDetailsSectionsVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateBalanceSheetDetailsSectionsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBalanceSheetDetailsSectionsVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBalanceSheetDetailsSectionsVisibility.printStackTrace();
			node.fail(validateBalanceSheetDetailsSectionsVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateBalanceSheetDetailsSectionsVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateBalanceSheetDetailsSectionsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBalanceSheetDetailsSectionsVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBalanceSheetDetailsSectionsVisibility.printStackTrace();
			node.fail(validateBalanceSheetDetailsSectionsVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_046
	@Test(priority = 38)
	public void validateAssetBalanceSectionAmountsVisibility() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that user able to see Opening, Total In, Total Out and Closing Balance for Asset Balance section")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// create Dynamic Locator for Asset Balance Opening Amount
			String assetBalanceOpeningAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.assetBalanceAmount, "locatorValue", "Opening");

			// create Dynamic Locator for Asset Balance Closing Amount
			String assetBalanceClosingAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.assetBalanceAmount, "locatorValue", "Closing");

			// create Dynamic Locator for Asset Balance Total In Amount
			String assetBalanceTotalInAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.assetBalanceAmount, "locatorValue", "Total In");

			// create Dynamic Locator for Asset Balance Total Out Amount
			String assetBalanceTotalOutAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.assetBalanceAmount, "locatorValue", "Total Out");

			// Verify the Asset Balance Sections Amounts Visibility.
			node.log(Status.INFO, "STEP1 : Verify the Asset Balance Sections Amounts Visibility.");
			System.out.println("STEP1 :  Verify the Asset Balance Sections Amounts Visibility.");

			// Check the visibility of Opening Amount
			IElementActions.assertTrue_usingXpath(node, driver, assetBalanceOpeningAmountLocator,
					"STEP2 : BUG: The Opening Amount is not coming in Asset Balance section",
					"STEP2 : EXPECTED: The Opening Amount is coming in Asset Balance section");

			// Check the visibility of Closing Amount
			IElementActions.assertTrue_usingXpath(node, driver, assetBalanceClosingAmountLocator,
					"STEP3 : BUG: The Closing Amount is not coming in Asset Balance section",
					"STEP3 : EXPECTED: The Closing Amount is coming in Asset Balance section");

			// Check the visibility of Total In Amount
			IElementActions.assertTrue_usingXpath(node, driver, assetBalanceTotalInAmountLocator,
					"STEP4 : BUG: The Total In Amount is not coming in Asset Balance section",
					"STEP4 : EXPECTED: The Total In Amount is coming in Asset Balance section");

			// Check the visibility of Total Out Amount
			IElementActions.assertTrue_usingXpath(node, driver, assetBalanceTotalOutAmountLocator,
					"STEP5 : BUG: The Total Out Amount is not coming in Asset Balance section",
					"STEP5 : EXPECTED: The Total Out Amount is coming in Asset Balance section");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAssetBalanceSectionAmountsVisibility", "Pass", driver);

		} catch (AssertionError validateAssetBalanceSectionAmountsVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAssetBalanceSectionAmountsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAssetBalanceSectionAmountsVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAssetBalanceSectionAmountsVisibility.printStackTrace();
			node.fail(validateAssetBalanceSectionAmountsVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAssetBalanceSectionAmountsVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAssetBalanceSectionAmountsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAssetBalanceSectionAmountsVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAssetBalanceSectionAmountsVisibility.printStackTrace();
			node.fail(validateAssetBalanceSectionAmountsVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_047
	@Test(priority = 39)
	public void validateAssetBalanceAmount() throws IOException {

		try {
			extenttest = extent.createTest("Verify that Asset balance will be the sum of the Loan and Cash balance")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// create Dynamic Locator for Loan Balance Opening Amount
			String loanBalanceOpeningAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.loanBalanceAmount, "locatorValue", "Opening");

			// create Dynamic Locator for Loan Balance Closing Amount
			String loanBalanceClosingAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.loanBalanceAmount, "locatorValue", "Closing");

			// create Dynamic Locator for Cash Balance Opening Amount
			String cashBalanceOpeningAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.cashBalanceAmount, "locatorValue", "Opening");

			// create Dynamic Locator for Cash Balance Closing Amount
			String cashBalanceClosingAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.cashBalanceAmount, "locatorValue", "Closing");

			// create Dynamic Locator for Asset Balance Opening Amount
			String assetBalanceOpeningAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.assetBalanceAmount, "locatorValue", "Opening");

			// create Dynamic Locator for Asset Balance Closing Amount
			String assetBalanceClosingAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.assetBalanceAmount, "locatorValue", "Closing");

			// Wait for the Page Loading to complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Getting value of the Loan Balance Opening Amount
			int loanBalanceOpeningAmount = Utils.getTextAndParseToInt(loanBalanceOpeningAmountLocator);

			// Getting value of the Loan Balance Closing Amount
			int loanBalanceClosingAmount = Utils.getTextAndParseToInt(loanBalanceClosingAmountLocator);

			// Getting value of the Cash Balance Opening Amount
			int cashBalanceOpeningAmount = Utils.getTextAndParseToInt(cashBalanceOpeningAmountLocator);

			// Getting value of the Cash Balance Closing Amount
			int cashBalanceClosingAmount = Utils.getTextAndParseToInt(cashBalanceClosingAmountLocator);

			// Getting value of the Asset Balance Opening Amount
			int actualAssetBalanceOpeningAmount = Utils.getTextAndParseToInt(assetBalanceOpeningAmountLocator);

			// Getting value of the Asset Balance Closing Amount
			int actualAssetBalanceClosingAmount = Utils.getTextAndParseToInt(assetBalanceClosingAmountLocator);

			// Calling the calculateAddition from Utils and Perform the Addition
			int expectedAssetBalanceOpeningAmount = Utils.calculateAddition(loanBalanceOpeningAmount,
					cashBalanceOpeningAmount);
			node.log(Status.INFO, "STEP1 : The sum of Loan Balance and Cash Balance Opening Amount : "
					+ expectedAssetBalanceOpeningAmount);
			System.out.println("STEP1 :  The sum of Loan Balance and Cash Balance Opening Amount : "
					+ expectedAssetBalanceOpeningAmount);

			// Calling the calculateAddition from Utils and Perform the Addition
			int expectedAssetBalanceClosingAmount = Utils.calculateAddition(loanBalanceClosingAmount,
					cashBalanceClosingAmount);
			node.log(Status.INFO, "STEP2 : The sum of Loan Balance and Cash Balance Closing Amount : "
					+ expectedAssetBalanceClosingAmount);
			System.out.println("STEP2 :  The sum of Loan Balance and Cash Balance Closing Amount : "
					+ expectedAssetBalanceClosingAmount);

			// Assert that the Asset Balance Opening Amount is the sum of Loan Balance
			// and Cash Balance Opening Amount
			IElementActions.assertEquals_usingInteger(node, driver, actualAssetBalanceOpeningAmount,
					expectedAssetBalanceOpeningAmount,
					"STEP3 : BUG : The Asset Balance Opening Amount " + actualAssetBalanceOpeningAmount
							+ " is not sum of Loan Balance and Cash Balance Opening Amount : "
							+ expectedAssetBalanceOpeningAmount,
					"STEP3 : PASS : The Asset Balance Opening Amount " + actualAssetBalanceOpeningAmount
							+ " is sum of Loan Balance and Cash Balance Opening Amount : "
							+ expectedAssetBalanceOpeningAmount);

			// Assert that the Asset Balance Closing Amount is the sum of Loan Balance
			// and Cash Balance Closing Amount
			IElementActions.assertEquals_usingInteger(node, driver, actualAssetBalanceClosingAmount,
					expectedAssetBalanceClosingAmount,
					"STEP4 : BUG : The Asset Balance Closing Amount " + actualAssetBalanceClosingAmount
							+ " is not sum of Loan Balance and Cash Balance Closing Amount : "
							+ expectedAssetBalanceClosingAmount,
					"STEP4 : PASS : The Asset Balance Closing Amount " + actualAssetBalanceClosingAmount
							+ " is sum of Loan Balance and Cash Balance Closing Amount : "
							+ expectedAssetBalanceClosingAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAssetBalanceAmount", "Pass", driver);

		} catch (AssertionError validateAssetBalanceAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAssetBalanceAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAssetBalanceAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAssetBalanceAmount.printStackTrace();
			node.fail(validateAssetBalanceAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAssetBalanceAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAssetBalanceAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAssetBalanceAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAssetBalanceAmount.printStackTrace();
			node.fail(validateAssetBalanceAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_048
	@Test(priority = 40)
	public void validateAssetAndFacilitiesBalanceEqualAmount() throws IOException {

		try {
			extenttest = extent.createTest("Verify that  Asset and Facility balances is always be equal.")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// create Dynamic Locator for Asset Balance Opening Amount
			String assetBalanceOpeningAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.assetBalanceAmount, "locatorValue", "Opening");

			// create Dynamic Locator for Asset Balance Closing Amount
			String assetBalanceClosingAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.assetBalanceAmount, "locatorValue", "Closing");

			// create Dynamic Locator for Asset Balance Total In Amount
			String assetBalanceTotalInAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.assetBalanceAmount, "locatorValue", "Total In");

			// create Dynamic Locator for Asset Balance Total Out Amount
			String assetBalanceTotalOutAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.assetBalanceAmount, "locatorValue", "Total Out");

			// create Dynamic Locator for facilities Balance Opening Amount
			String facilitiesBalanceOpeningAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.facilitiesBalanceAmount, "locatorValue", "Opening");

			// create Dynamic Locator for facilities Balance Closing Amount
			String facilitiesBalanceClosingAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.facilitiesBalanceAmount, "locatorValue", "Closing");

			// create Dynamic Locator for facilities Balance Total In Amount
			String facilitiesBalanceTotalInAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.facilitiesBalanceAmount, "locatorValue", "Total In");

			// create Dynamic Locator for facilities Balance Total Out Amount
			String facilitiesBalanceTotalOutAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.facilitiesBalanceAmount, "locatorValue", "Total Out");

			// Wait for the Page Loading to complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Getting value of the Asset Balance Opening Amount
			int assetBalanceOpeningAmount = Utils.getTextAndParseToInt(assetBalanceOpeningAmountLocator);

			// Getting value of the Asset Balance Closing Amount
			int assetBalanceClosingAmount = Utils.getTextAndParseToInt(assetBalanceClosingAmountLocator);

			// Getting value of the Asset Balance Total In Amount
			int assetBalanceTotalInAmount = Utils.getTextAndParseToInt(assetBalanceTotalInAmountLocator);

			// Getting value of the Asset Balance Total Out Amount
			int assetBalanceTotalOutAmount = Utils.getTextAndParseToInt(assetBalanceTotalOutAmountLocator);

			// Getting value of the Facilities Balance Opening Amount
			int facilitiesBalanceOpeningAmount = Utils.getTextAndParseToInt(facilitiesBalanceOpeningAmountLocator);

			// Getting value of the Facilities Balance Closing Amount
			int facilitiesBalanceClosingAmount = Utils.getTextAndParseToInt(facilitiesBalanceClosingAmountLocator);

			// Getting value of the Facilities Balance Total In Amount
			int facilitiesBalanceTotalInAmount = Utils.getTextAndParseToInt(facilitiesBalanceTotalInAmountLocator);

			// Getting value of the Facilities Balance Total Out Amount
			int facilitiesBalanceTotalOutAmount = Utils.getTextAndParseToInt(facilitiesBalanceTotalOutAmountLocator);

			// Assert that the Asset Balance Opening Amount is Equal to the Facilities
			// Balance Opening Amount
			IElementActions.assertEquals_usingInteger(node, driver, assetBalanceOpeningAmount,
					facilitiesBalanceOpeningAmount,
					"STEP1 : BUG : The Asset Balance Opening Amount " + assetBalanceOpeningAmount
							+ " is not Equal to the Facilities Balance Opening Amount :"
							+ facilitiesBalanceOpeningAmount,
					"STEP1 : PASS : The Asset Balance Opening Amount " + assetBalanceOpeningAmount
							+ " is Equal to the Facilities Balance Opening Amount :" + facilitiesBalanceOpeningAmount);

			// Assert that the Asset Balance Closing Amount is Equal to the Facilities
			// Balance Closing Amount
			IElementActions.assertEquals_usingInteger(node, driver, assetBalanceClosingAmount,
					facilitiesBalanceClosingAmount,
					"STEP2 : BUG : The Asset Balance Closing Amount " + assetBalanceClosingAmount
							+ " is not Equal to the Facilities Balance Closing Amount :"
							+ facilitiesBalanceClosingAmount,
					"STEP2 : PASS : The Asset Balance Closing Amount " + assetBalanceClosingAmount
							+ " is Equal to the Facilities Balance Closing Amount :" + facilitiesBalanceClosingAmount);

			// Assert that the Asset Balance Total In Amount is Equal to the Facilities
			// Balance Total In Amount
			IElementActions.assertEquals_usingInteger(node, driver, assetBalanceTotalInAmount,
					facilitiesBalanceTotalInAmount,
					"STEP3 : BUG : The Asset Balance Total In Amount " + assetBalanceTotalInAmount
							+ " is not Equal to the Facilities Balance Total In Amount :"
							+ facilitiesBalanceTotalInAmount,
					"STEP3 : PASS : The Asset Balance Total In Amount " + assetBalanceTotalInAmount
							+ " is Equal to the Facilities Balance Total In Amount :" + facilitiesBalanceTotalInAmount);

			// Assert that the Asset Balance Total Out Amount is Equal to the Facilities
			// Balance Total Out Amount
			IElementActions.assertEquals_usingInteger(node, driver, assetBalanceTotalOutAmount,
					facilitiesBalanceTotalOutAmount,
					"STEP4 : BUG : The Asset Balance Total Out Amount " + assetBalanceTotalOutAmount
							+ " is not Equal to the Facilities Balance Total Out Amount :"
							+ facilitiesBalanceTotalOutAmount,
					"STEP4 : PASS : The Asset Balance Total Out Amount " + assetBalanceTotalOutAmount
							+ " is Equal to the Facilities Balance Total Out Amount :"
							+ facilitiesBalanceTotalOutAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAssetAndFacilitiesBalanceEqualAmount", "Pass", driver);

		} catch (AssertionError validateAssetAndFacilitiesBalanceEqualAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAssetAndFacilitiesBalanceEqualAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAssetAndFacilitiesBalanceEqualAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAssetAndFacilitiesBalanceEqualAmount.printStackTrace();
			node.fail(validateAssetAndFacilitiesBalanceEqualAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAssetAndFacilitiesBalanceEqualAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAssetAndFacilitiesBalanceEqualAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAssetAndFacilitiesBalanceEqualAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAssetAndFacilitiesBalanceEqualAmount.printStackTrace();
			node.fail(validateAssetAndFacilitiesBalanceEqualAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_049
	@Test(priority = 41)
	public void validateCashBalanceSectionAmountsVisibility() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify the user is able to view the Cash Balance with the following fields i.e."
							+ "-Opening" + "-Closing" + "-Loan In" + "-Loan Out" + "-Facilities In" + "-Facilities Out")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// create Dynamic Locator for Cash Balance Opening Amount
			String cashBalanceOpeningAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.cashBalanceAmount, "locatorValue", "Opening");

			// create Dynamic Locator for Cash Balance Closing Amount
			String cashBalanceClosingAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.cashBalanceAmount, "locatorValue", "Closing");

			// create Dynamic Locator for Cash Balance Loan In Amount
			String cashBalanceLoanInAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.cashBalanceAmount, "locatorValue", "Loan In");

			// create Dynamic Locator for Cash Balance Loan Out Amount
			String cashBalanceLoanOutAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.cashBalanceAmount, "locatorValue", "Loan Out");

			// create Dynamic Locator for Cash Balance Facilities In Amount
			String cashBalanceFacilitiesInAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.cashBalanceAmount, "locatorValue", "Facilities In");

			// create Dynamic Locator for Cash Balance Facilities Out Amount
			String cashBalanceFacilitiesOutAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.cashBalanceAmount, "locatorValue", "Facilities Out");

			// Verify the Cash Balance Sections Amounts Visibility.
			node.log(Status.INFO, "STEP1 : Verify the Cash Balance Sections Amounts Visibility.");
			System.out.println("STEP1 :  Verify the Cash Balance Sections Amounts Visibility.");

			// Check the visibility of Opening Amount
			IElementActions.assertTrue_usingXpath(node, driver, cashBalanceOpeningAmountLocator,
					"STEP2 : BUG: The Opening Amount is not coming in Cash Balance section",
					"STEP2 : EXPECTED: The Opening Amount is coming in Cash Balance section");

			// Check the visibility of Closing Amount
			IElementActions.assertTrue_usingXpath(node, driver, cashBalanceClosingAmountLocator,
					"STEP3 : BUG: The Closing Amount is not coming in Cash Balance section",
					"STEP3 : EXPECTED: The Closing Amount is coming in Cash Balance section");

			// Check the visibility of Loan In Amount
			IElementActions.assertTrue_usingXpath(node, driver, cashBalanceLoanInAmountLocator,
					"STEP4 : BUG: The Loan In Amount is not coming in Cash Balance section",
					"STEP4 : EXPECTED: The Loan In Amount is coming in Cash Balance section");

			// Check the visibility of Loan Out Amount
			IElementActions.assertTrue_usingXpath(node, driver, cashBalanceLoanOutAmountLocator,
					"STEP5 : BUG: The Loan Out Amount is not coming in Cash Balance section",
					"STEP5 : EXPECTED: The Loan Out Amount is coming in Cash Balance section");

			// Check the visibility of Facilities In Amount
			IElementActions.assertTrue_usingXpath(node, driver, cashBalanceFacilitiesInAmountLocator,
					"STEP6 : BUG: The Facilities In Amount is not coming in Cash Balance section",
					"STEP6 : EXPECTED: The Facilities In Amount is coming in Cash Balance section");

			// Check the visibility of Facilities Out Amount
			IElementActions.assertTrue_usingXpath(node, driver, cashBalanceFacilitiesOutAmountLocator,
					"STEP7 : BUG: The Facilities Out Amount is not coming in Cash Balance section",
					"STEP7 : EXPECTED: The Facilities Out Amount is coming in Cash Balance section");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashBalanceSectionAmountsVisibility", "Pass", driver);

		} catch (AssertionError validateCashBalanceSectionAmountsVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashBalanceSectionAmountsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceSectionAmountsVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceSectionAmountsVisibility.printStackTrace();
			node.fail(validateCashBalanceSectionAmountsVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCashBalanceSectionAmountsVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashBalanceSectionAmountsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceSectionAmountsVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceSectionAmountsVisibility.printStackTrace();
			node.fail(validateCashBalanceSectionAmountsVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_050
	@Test(priority = 42)
	public void validateCashBalanceSectionOpeningAmount() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that user is able to see Opening Balance for Cash is equal to the Opening Facilities Balance - Opening Loan Balance")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// create Dynamic Locator for facilities Balance Opening Amount
			String facilitiesBalanceOpeningAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.facilitiesBalanceAmount, "locatorValue", "Opening");

			// create Dynamic Locator for Loan Balance Opening Amount
			String loanBalanceOpeningAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.loanBalanceAmount, "locatorValue", "Opening");

			// create Dynamic Locator for Cash Balance Opening Amount
			String cashBalanceOpeningAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.cashBalanceAmount, "locatorValue", "Opening");

			// Wait for the Page Loading to complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Getting value of the Facilities Balance Opening Amount
			int facilitiesBalanceOpeningAmount = Utils.getTextAndParseToInt(facilitiesBalanceOpeningAmountLocator);

			// Getting value of the Loan Balance Opening Amount
			int loanBalanceOpeningAmount = Utils.getTextAndParseToInt(loanBalanceOpeningAmountLocator);

			// Getting value of the Cash Balance Opening Amount
			int actualCashBalanceOpeningAmount = Utils.getTextAndParseToInt(cashBalanceOpeningAmountLocator);

			// Calling the calculateDifference from Utils and perform the Substraction
			int expectedCashBalanceOpeningAmount = Utils.calculateDifference(facilitiesBalanceOpeningAmount,
					loanBalanceOpeningAmount);

			// Assert that Opening Balance for Cash is equal to the Opening Facilities
			// Balance - Opening Loan Balance
			IElementActions.assertEquals_usingInteger(node, driver, actualCashBalanceOpeningAmount,
					expectedCashBalanceOpeningAmount,
					"STEP1 : BUG : The Cash Balance Opening Amount " + actualCashBalanceOpeningAmount
							+ " is not Equal to the Opening Facilities Balance - Opening Loan Balance :"
							+ expectedCashBalanceOpeningAmount,
					"STEP1 : PASS :The Cash Balance Opening Amount " + actualCashBalanceOpeningAmount
							+ " is Equal to the Opening Facilities Balance - Opening Loan Balance : "
							+ expectedCashBalanceOpeningAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashBalanceSectionOpeningAmount", "Pass", driver);

		} catch (AssertionError validateCashBalanceSectionOpeningAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashBalanceSectionOpeningAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceSectionOpeningAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceSectionOpeningAmount.printStackTrace();
			node.fail(validateCashBalanceSectionOpeningAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCashBalanceSectionOpeningAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashBalanceSectionOpeningAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceSectionOpeningAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceSectionOpeningAmount.printStackTrace();
			node.fail(validateCashBalanceSectionOpeningAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_051
	@Test(priority = 43)
	public void validateCashBalanceSectionClosingAmount() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that Cash balance for Closing will be equal to the difference between the Closing Facility balance and the  Closing Loan balance")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// create Dynamic Locator for facilities Balance Closing Amount
			String facilitiesBalanceClosingAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.facilitiesBalanceAmount, "locatorValue", "Closing");

			// create Dynamic Locator for Loan Balance Closing Amount
			String loanBalanceClosingAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.loanBalanceAmount, "locatorValue", "Closing");

			// create Dynamic Locator for Cash Balance Closing Amount
			String cashBalanceClosingAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.cashBalanceAmount, "locatorValue", "Closing");

			// Wait for the Page Loading to complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Getting value of the Facilities Balance Closing Amount
			int facilitiesBalanceClosingAmount = Utils.getTextAndParseToInt(facilitiesBalanceClosingAmountLocator);

			// Getting value of the Loan Balance Closing Amount
			int loanBalanceClosingAmount = Utils.getTextAndParseToInt(loanBalanceClosingAmountLocator);

			// Getting value of the Cash Balance Closing Amount
			int actualCashBalanceClosingAmount = Utils.getTextAndParseToInt(cashBalanceClosingAmountLocator);

			// Calling the calculateDifference from Utils and perform the Substraction
			int expectedCashBalanceClosingAmount = Utils.calculateDifference(facilitiesBalanceClosingAmount,
					loanBalanceClosingAmount);

			// Assert that the Cash Balance Closing Amount is equal to the Facilities
			// Balance Closing Amount - Loan Balance Closing Amount
			IElementActions.assertEquals_usingInteger(node, driver, actualCashBalanceClosingAmount,
					expectedCashBalanceClosingAmount,
					"STEP1 : BUG : The Cash Balance Closing Amount " + actualCashBalanceClosingAmount
							+ " is not Equal to the Facilities Balance Closing Amount - Loan Balance Closing Amount :"
							+ expectedCashBalanceClosingAmount,
					"STEP1 : PASS : The Cash Balance Closing Amount " + actualCashBalanceClosingAmount
							+ " is Equal to the Facilities Balance Closing Amount - Loan Balance Closing Amount : "
							+ expectedCashBalanceClosingAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashBalanceSectionClosingAmount", "Pass", driver);

		} catch (AssertionError validateCashBalanceSectionClosingAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashBalanceSectionClosingAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceSectionClosingAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceSectionClosingAmount.printStackTrace();
			node.fail(validateCashBalanceSectionClosingAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCashBalanceSectionClosingAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashBalanceSectionClosingAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceSectionClosingAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceSectionClosingAmount.printStackTrace();
			node.fail(validateCashBalanceSectionClosingAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_052
	@Test(priority = 44)
	public void validateCashBalanceSectionLoanInAmount() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that Loan in is equals to the Total In under the Loan Balance section.")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// create Dynamic Locator for Cash Balance Loan In Amount
			String cashBalanceLoanInAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.cashBalanceAmount, "locatorValue", "Loan In");

			// create Dynamic Locator for Loan Balance Total In Amount
			String loanBalanceTotalInAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.loanBalanceAmount, "locatorValue", "Total In");

			// Wait for the Page Loading to complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Getting value of the Cash Balance Loan In Amount
			int cashBalanceLoanInAmount = Utils.getTextAndParseToInt(cashBalanceLoanInAmountLocator);

			// Getting value of the Loan Balance Total In Amount
			int loanBalanceTotalInAmount = Utils.getTextAndParseToInt(loanBalanceTotalInAmountLocator);

			// Assert that the Cash Balance Loan In Amount is Equal to the Loan Balance
			// Total In Amount
			IElementActions.assertEquals_usingInteger(node, driver, cashBalanceLoanInAmount, loanBalanceTotalInAmount,
					"STEP1 : BUG : The Cash Balance Loan In Amount " + cashBalanceLoanInAmount
							+ " is not Equal to the Loan Balance Total In Amount :" + loanBalanceTotalInAmount,
					"STEP1 : PASS : The Cash Balance Loan In Amount " + cashBalanceLoanInAmount
							+ " is Equal to the Loan Balance Total In Amount : " + loanBalanceTotalInAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashBalanceSectionLoanInAmount", "Pass", driver);

		} catch (AssertionError validateCashBalanceSectionLoanInAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashBalanceSectionLoanInAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceSectionLoanInAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceSectionLoanInAmount.printStackTrace();
			node.fail(validateCashBalanceSectionLoanInAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCashBalanceSectionLoanInAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashBalanceSectionLoanInAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceSectionLoanInAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceSectionLoanInAmount.printStackTrace();
			node.fail(validateCashBalanceSectionLoanInAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_053
	@Test(priority = 45)
	public void validateCashBalanceSectionLoanOutAmount() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that Loan out is equals to the Total Out under the Loan Balance section")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// create Dynamic Locator for Cash Balance Loan Out Amount
			String cashBalanceLoanOutAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.cashBalanceAmount, "locatorValue", "Loan Out");

			// create Dynamic Locator for Loan Balance Total Out Amount
			String loanBalanceTotalOutAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.loanBalanceAmount, "locatorValue", "Total Out");

			// Wait for the Page Loading to complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Getting value of the Cash Balance Loan Out Amount
			int cashBalanceLoanOutAmount = Utils.getTextAndParseToInt(cashBalanceLoanOutAmountLocator);

			// Getting value of the Loan Balance Total Out Amount
			int loanBalanceTotalOutAmount = Utils.getTextAndParseToInt(loanBalanceTotalOutAmountLocator);

			// Assert that the Cash Balance Loan Out Amount is Equal to the Loan Balance
			// Total Out Amount
			IElementActions.assertEquals_usingInteger(node, driver, cashBalanceLoanOutAmount, loanBalanceTotalOutAmount,
					"STEP1 : BUG : The Cash Balance Loan Out Amount " + cashBalanceLoanOutAmount
							+ " is not Equal to the Loan Balance Total Out Amount :" + loanBalanceTotalOutAmount,
					"STEP1 : PASS : The Cash Balance Loan Out Amount " + cashBalanceLoanOutAmount
							+ " is Equal to the Loan Balance Total Out Amount : " + loanBalanceTotalOutAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashBalanceSectionLoanOutAmount", "Pass", driver);

		} catch (AssertionError validateCashBalanceSectionLoanOutAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashBalanceSectionLoanOutAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceSectionLoanOutAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceSectionLoanOutAmount.printStackTrace();
			node.fail(validateCashBalanceSectionLoanOutAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCashBalanceSectionLoanOutAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashBalanceSectionLoanOutAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceSectionLoanOutAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceSectionLoanOutAmount.printStackTrace();
			node.fail(validateCashBalanceSectionLoanOutAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_054
	@Test(priority = 46)
	public void validateCashBalanceSectionFacilitiesInAmount() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that Facilities In equals to the Total In under Facility Balance section.")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// create Dynamic Locator for Cash Balance Facilities In Amount
			String cashBalanceFacilitiesInAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.cashBalanceAmount, "locatorValue", "Facilities In");

			// create Dynamic Locator for Facilities Balance Total In Amount
			String facilitiesBalanceTotalInAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.facilitiesBalanceAmount, "locatorValue", "Total In");

			// Wait for the Page Loading to complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Getting value of the Cash Balance Facilities In Amount
			int cashBalanceFacilitiesInAmount = Utils.getTextAndParseToInt(cashBalanceFacilitiesInAmountLocator);

			// Getting value of the Facilities Balance Total In Amount
			int facilitiesBalanceTotalInAmount = Utils.getTextAndParseToInt(facilitiesBalanceTotalInAmountLocator);

			// Assert that the Cash Balance Facilities In Amount is Equal to the Facilities
			// Balance Total In Amount
			IElementActions.assertEquals_usingInteger(node, driver, cashBalanceFacilitiesInAmount,
					facilitiesBalanceTotalInAmount,
					"STEP1 : BUG : The Cash Balance Facilities In Amount " + cashBalanceFacilitiesInAmount
							+ " is not Equal to the Facilities Balance Total In Amount :"
							+ facilitiesBalanceTotalInAmount,
					"STEP1 : PASS : The Cash Balance Facilities In Amount " + cashBalanceFacilitiesInAmount
							+ " is Equal to the Facilities Balance Total In Amount : "
							+ facilitiesBalanceTotalInAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashBalanceSectionFacilitiesInAmount", "Pass", driver);

		} catch (AssertionError validateCashBalanceSectionFacilitiesInAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashBalanceSectionFacilitiesInAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceSectionFacilitiesInAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceSectionFacilitiesInAmount.printStackTrace();
			node.fail(validateCashBalanceSectionFacilitiesInAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCashBalanceSectionFacilitiesInAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashBalanceSectionFacilitiesInAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceSectionFacilitiesInAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceSectionFacilitiesInAmount.printStackTrace();
			node.fail(validateCashBalanceSectionFacilitiesInAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_055
	@Test(priority = 47)
	public void validateCashBalanceSectionFacilitiesOutAmount() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that Facility Out is equals to the Total Out under Facility Balance section.")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// create Dynamic Locator for Cash Balance Facilities Out Amount
			String cashBalanceFacilitiesOutAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.cashBalanceAmount, "locatorValue", "Facilities Out");

			// create Dynamic Locator for Facilities Balance Total Out Amount
			String facilitiesBalanceTotalOutAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.facilitiesBalanceAmount, "locatorValue", "Total Out");

			// Wait for the Page Loading to complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Getting value of the Cash Balance Facilities Out Amount
			int cashBalanceFacilitiesOutAmount = Utils.getTextAndParseToInt(cashBalanceFacilitiesOutAmountLocator);

			// Getting value of the Facilities Balance Total Out Amount
			int facilitiesBalanceTotalOutAmount = Utils.getTextAndParseToInt(facilitiesBalanceTotalOutAmountLocator);

			// Assert that the Cash Balance Facilities Out Amount is Equal to the Facilities
			// Balance Total Out Amount
			IElementActions.assertEquals_usingInteger(node, driver, cashBalanceFacilitiesOutAmount,
					facilitiesBalanceTotalOutAmount,
					"STEP1 : BUG : The Cash Balance Facilities Out Amount " + cashBalanceFacilitiesOutAmount
							+ " is not Equal to the Facilities Balance Total Out Amount :"
							+ facilitiesBalanceTotalOutAmount,
					"STEP1 : PASS : The Cash Balance Facilities Out Amount " + cashBalanceFacilitiesOutAmount
							+ " is Equal to the Facilities Balance Total Out Amount : "
							+ facilitiesBalanceTotalOutAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashBalanceSectionFacilitiesOutAmount", "Pass", driver);

		} catch (AssertionError validateCashBalanceSectionFacilitiesOutAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashBalanceSectionFacilitiesOutAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceSectionFacilitiesOutAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceSectionFacilitiesOutAmount.printStackTrace();
			node.fail(validateCashBalanceSectionFacilitiesOutAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCashBalanceSectionFacilitiesOutAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashBalanceSectionFacilitiesOutAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceSectionFacilitiesOutAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceSectionFacilitiesOutAmount.printStackTrace();
			node.fail(validateCashBalanceSectionFacilitiesOutAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_056
	@Test(priority = 48)
	public void validateLoanBalanceTableColumnsVisibility() throws IOException {

		try {
			extenttest = extent
					.createTest(
							"Verify that user is able to view the following columns under the Loan Balance section i.e."
									+ "- Internal Reference" + "- Reference" + "- Opening Balance" + "- Disbursements"
									+ "- Repayments" + "- Closing Balance")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Verify the columns of the Loan Balance Table
			node.log(Status.INFO, "STEP1 : Verify the columns of Loan Balance Table.");
			System.out.println("STEP1 : Verify the columns of Loan Balance Table");

			// Check the visibility of Internal Reference Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.loanBalanceInternalRefColumn,
					"STEP2 : BUG: The Internal Reference column is not coming under Loan Balance Table.",
					"STEP2 : EXPECTED: The Internal Reference column is coming under Loan Balance Table.");

			// Check the visibility of Reference Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.referenceColumn,
					"STEP3 : BUG: The Reference column is not coming under Loan Balance Table",
					"STEP3 : EXPECTED: The Reference column is coming under Loan Balance Table");

			// Check the visibility of Opening Balance Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.openingBalanceColumn,
					"STEP4 : BUG: The Opening Balance column is not coming under Loan Balance Table",
					"STEP4 : EXPECTED: The Opening Balance column is coming under Loan Balance Table");

			// Check the visibility of Disbursements Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.disbursementsColumn,
					"STEP5 : BUG: The Disbursements column is not coming under Loan Balance Table",
					"STEP5 : EXPECTED: The Disbursements column is coming under Loan Balance Table");

			// Check the visibility of Repayments Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.repaymentsColumn,
					"STEP6 : BUG: The Repayments column is not coming under Loan Balance Table",
					"STEP6 : EXPECTED: The Repayments column is coming under Loan Balance Table");

			// Check the visibility of Closing Balance Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.closingBalanceColumn,
					"STEP7 : BUG: The Closing Balance column is not coming under Loan Balance Table",
					"STEP7 : EXPECTED: The Closing Balance column is coming under Loan Balance Table");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanBalanceTableColumnsVisibility", "Pass", driver);

		} catch (AssertionError validateLoanBalanceTableColumnsVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanBalanceTableColumnsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanBalanceTableColumnsVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanBalanceTableColumnsVisibility.printStackTrace();
			node.fail(validateLoanBalanceTableColumnsVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanBalanceTableColumnsVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanBalanceTableColumnsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanBalanceTableColumnsVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanBalanceTableColumnsVisibility.printStackTrace();
			node.fail(validateLoanBalanceTableColumnsVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_057
	@Test(priority = 49)
	public void validateNavigationToNewLoanSummaryTab() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that user is redirected to the Summary tab of New Loan module on clicking on the Internal Reference name or Reference name")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Click on Internal Reference Column First Internal Reference
			IElementActions.clickelement_usingXpath(node, driver,
					ReportingBalanceSheetPO.firstLoanBalanceInternalRefName);
			node.log(Status.INFO, "STEP1 : The Clicked on Internal Reference Column First Internal Reference");
			System.out.println("STEP1 :  The Clicked on Internal Reference Column First Internal Reference");

			// Wait for the visibility of the Edit Bridge Loan Header Text
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the Edit Bridge Loan Header Text");
			System.out.println("STEP2 : Waiting for the visibility of the Edit Bridge Loan Header Text");
			IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.editBridgeLoanHeaderText);
			node.log(Status.INFO, "STEP3 : The Edit Bridge Loan Header Text is now visible");
			System.out.println("STEP3 : The Edit Bridge Loan Header Text is now visible");

			Thread.sleep(2000);

			// Getting the current URL
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			if ((currentUrl.contains("summary") && currentUrl.contains("bridge-loan/bl"))) {
				node.log(Status.INFO,
						"STEP4 : PASS : The clicking on Internal Reference ,user is redirected to the Summary tab of New Loan module");
				System.out.println(
						"STEP4 : PASS : The clicking on Internal Reference ,user is redirected to the Summary tab of New Loan module");
			} else {
				node.log(Status.INFO,
						"STEP4 : BUG : The clicking on Internal Reference ,user is not redirected to the Summary tab of New Loan module");
				System.out.println(
						"STEP4 : BUG : The clicking on Internal Reference ,user is not redirected to the Summary tab of New Loan module");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateNavigationToNewLoanSummaryTab", "Pass", driver);

		} catch (AssertionError validateNavigationToNewLoanSummaryTab) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNavigationToNewLoanSummaryTab test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNavigationToNewLoanSummaryTab_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNavigationToNewLoanSummaryTab.printStackTrace();
			node.fail(validateNavigationToNewLoanSummaryTab);
			Assert.fail();
			extent.flush();

		} catch (Exception validateNavigationToNewLoanSummaryTab) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNavigationToNewLoanSummaryTab test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNavigationToNewLoanSummaryTab_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNavigationToNewLoanSummaryTab.printStackTrace();
			node.fail(validateNavigationToNewLoanSummaryTab);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_060
	@Test(priority = 50)
	public void validateLoanBlanceTableAscendingOrderDataSorting() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify when user click on a column heading toggle a first time, the row  in the table are sorted in ascending order of that category."
							+ "Loan Balance" + "- Internal Reference" + "- Reference" + "- Opening Balance"
							+ "- Disbursements" + "- Repayments" + "- Closing Balance")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// The Click on Internal Reference Column Toggle Icon
			IElementActions.clickelement_usingXpath(node, driver,
					ReportingBalanceSheetPO.loanBalanceInternalRefColumnToggle);
			node.log(Status.INFO, "STEP1 : The Clicked on Loan Balance Table Internal Reference Column Toggle Icon");
			System.out.println("STEP1 : The Clicked on Loan Balance Table Internal Reference Column Toggle Icon");

			// Check the Ascending order for Internal Reference Column
			Utils.validateDataSortingOrder(node, driver, ReportingBalanceSheetPO.loanBalanceInternalRefColumnValue,
					"validateLoanBlanceTableAscendingOrderDataSorting", "stringValue");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanBlanceTableAscendingOrderDataSorting", "Pass",
					driver);

		} catch (AssertionError validateLoanBlanceTableAscendingOrderDataSorting) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanBlanceTableAscendingOrderDataSorting test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanBlanceTableAscendingOrderDataSorting_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanBlanceTableAscendingOrderDataSorting.printStackTrace();
			node.fail(validateLoanBlanceTableAscendingOrderDataSorting);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanBlanceTableAscendingOrderDataSorting) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanBlanceTableAscendingOrderDataSorting test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanBlanceTableAscendingOrderDataSorting_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanBlanceTableAscendingOrderDataSorting.printStackTrace();
			node.fail(validateLoanBlanceTableAscendingOrderDataSorting);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_061
	@Test(priority = 51)
	public void validateLoanBalanceTableDescendingOrderDataSorting() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify when user click on a column heading toggle a second time, the row  in the table are sorted in descending  order of that category."
							+ "- Internal Reference" + "- Reference" + "- Opening Balance" + "- Disbursements"
							+ "- Repayments" + "- Closing Balance")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Clicked on the internal reference column sort icon twice and validate list
			ReportingPage.scrollAndClickToSort(ReportingBalanceSheetPO.loanBalanceInternalRefColumnToggle,
					"Internal Reference", "doubleClick");

			Utils.validateDataSortingOrder(node, driver, ReportingBalanceSheetPO.loanBalanceInternalRefColumnValue,
					"validateInternalReferenceSorting", "stringValue");

			// Scroll, click sort icon, confirm sorting
			ReportingPage.scrollAndClickToCheckSort(ReportingBalanceSheetPO.loanBalanceLoanRefColumnToggle, "Reference",
					ReportingBalanceSheetPO.loanBalanceLoanRefColumnValue, "descending", "validateReferenceSorting",
					"doubleClick");

			// Clicked on the Amount column sort icon twice and validate list
			Utils.validateDescendingOrder(node, driver, "Amount", ReportingBalanceSheetPO.loanBalanceAmountColumnToggle,
					ReportingBalanceSheetPO.loanBalanceAmountColumnValue, "validateAmountSorting");

			// Clicked on the Disbursements column sort icon twice and validate list
			Utils.validateDescendingOrder(node, driver, "Disbursements",
					ReportingBalanceSheetPO.loanBalanceDisbursementsColumnToggle,
					ReportingBalanceSheetPO.loanBalanceDisbursementsColumnValue, "validateDisbursementsSorting");

			// Clicked on the Repayments column sort icon twice and validate list
			Utils.validateDescendingOrder(node, driver, "Repayments",
					ReportingBalanceSheetPO.loanBalanceRepaymentsColumnToggle,
					ReportingBalanceSheetPO.loanBalanceRepaymentsColumnValue, "validateRepaymentsSorting");

			// Clicked on the Closing Balance column sort icon twice and validate list
			Utils.validateDescendingOrder(node, driver, "Closing Balance",
					ReportingBalanceSheetPO.loanBalanceClosingBalanceColumnToggle,
					ReportingBalanceSheetPO.loanBalanceClosingBalanceColumnValue, "validateClosingBalanceSorting");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanBalanceTableDescendingOrderDataSorting", "Pass",
					driver);

		} catch (AssertionError validateLoanBalanceTableDescendingOrderDataSorting) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanBalanceTableDescendingOrderDataSorting test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanBalanceTableDescendingOrderDataSorting_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanBalanceTableDescendingOrderDataSorting.printStackTrace();
			node.fail(validateLoanBalanceTableDescendingOrderDataSorting);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanBalanceTableDescendingOrderDataSorting) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanBalanceTableDescendingOrderDataSorting test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanBalanceTableDescendingOrderDataSorting_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanBalanceTableDescendingOrderDataSorting.printStackTrace();
			node.fail(validateLoanBalanceTableDescendingOrderDataSorting);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_062
	@Test(priority = 52)
	public void validateDisbursementsAmountVisibility() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the Disbursements Amount for each respective loan under the Disbursements column")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Check the visibility of Disbursements Amount
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.disbursementColumnValues,
					"STEP1 : BUG: The Disbursements Amount is not coming in Disbursements Column.",
					"STEP1 : EXPECTED: The Disbursements Amount is coming in Disbursements Column.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDisbursementsAmountVisibility", "Pass", driver);

		} catch (AssertionError validateDisbursementsAmountVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDisbursementsAmountVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDisbursementsAmountVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDisbursementsAmountVisibility.printStackTrace();
			node.fail(validateDisbursementsAmountVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDisbursementsAmountVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDisbursementsAmountVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDisbursementsAmountVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDisbursementsAmountVisibility.printStackTrace();
			node.fail(validateDisbursementsAmountVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_063
	@Test(priority = 53)
	public void validateRepaymentsAmountVisibility() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the Repayments Amount for each respective loan under the Repayments column")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Check the visibility of Repayments Amount
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.repaymentsColumnValues,
					"STEP1 : BUG: The Repayments Amount is not coming in Repayments Column.",
					"STEP1 : EXPECTED: The Repayments Amount is coming in Repayments Column.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateRepaymentsAmountVisibility", "Pass", driver);

		} catch (AssertionError validateRepaymentsAmountVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateRepaymentsAmountVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRepaymentsAmountVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRepaymentsAmountVisibility.printStackTrace();
			node.fail(validateRepaymentsAmountVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateRepaymentsAmountVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateRepaymentsAmountVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRepaymentsAmountVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRepaymentsAmountVisibility.printStackTrace();
			node.fail(validateRepaymentsAmountVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_064
	@Test(priority = 54)
	public void validateClosingBalanceAmountVisibility() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the Closing Balance for each respective loan under the Closing Balance column")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Check the visibility of Closing Balance Amount
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.closingBalanceColumnValues,
					"STEP1 : BUG: The Closing Balance Amount is not coming in Closing Balance Column.",
					"STEP1 : EXPECTED: The Closing Balance Amount is coming in Closing Balance Column.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateClosingBalanceAmountVisibility", "Pass", driver);

		} catch (AssertionError validateClosingBalanceAmountVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateClosingBalanceAmountVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateClosingBalanceAmountVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateClosingBalanceAmountVisibility.printStackTrace();
			node.fail(validateClosingBalanceAmountVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateClosingBalanceAmountVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateClosingBalanceAmountVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateClosingBalanceAmountVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateClosingBalanceAmountVisibility.printStackTrace();
			node.fail(validateClosingBalanceAmountVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_065
	@Test(priority = 55)
	public void validateFacilityBalanceTableColumnVisibility() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that user is able to view the following columns under the Facility Balance section i.e."
							+ "- Internal Reference" + "- Reference" + "-Opening Balance" + "-Drawdowns" + "-Repayments"
							+ "-Closing Balance")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Verify the columns of the Facility Balance Table
			node.log(Status.INFO, "STEP1 : Verify the columns of Facility Balance Table.");
			System.out.println("STEP1 : Verify the columns of Facility Balance Table");

			// Check the visibility of Internal Reference Column
			IElementActions.assertTrue_usingXpath(node, driver,
					ReportingBalanceSheetPO.facilityBalanceInternalRefColumn,
					"STEP2 : BUG: The Internal Reference column is not coming under Facility Balance Table.",
					"STEP2 : EXPECTED: The Internal Reference column is coming under Facility Balance Table.");

			// Check the visibility of Reference Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.facilityBalanceReferenceColumn,
					"STEP3 : BUG: The Reference column is not coming under Facility Balance Table",
					"STEP3 : EXPECTED: The Reference column is coming under Facility Balance Table");

			// Check the visibility of Opening Balance Column
			IElementActions.assertTrue_usingXpath(node, driver,
					ReportingBalanceSheetPO.facilityBalanceOpeningBalanceColumn,
					"STEP4 : BUG: The Opening Balance column is not coming under Facility Balance Table",
					"STEP4 : EXPECTED: The Opening Balance column is coming under Facility Balance Table");

			// Check the visibility of Drawdowns Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.drawdownsColumn,
					"STEP5 : BUG: The Drawdowns column is not coming under Facility Balance Table",
					"STEP5 : EXPECTED: The Drawdowns column is coming under Facility Balance Table");

			// Check the visibility of Repayments Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.facilityBalancerepaymentsColumn,
					"STEP6 : BUG: The Repayments column is not coming under Facility Balance Table",
					"STEP6 : EXPECTED: The Repayments column is coming under Facility Balance Table");

			// Check the visibility of Closing Balance Column
			IElementActions.assertTrue_usingXpath(node, driver,
					ReportingBalanceSheetPO.facilityBalanceclosingBalanceColumn,
					"STEP7 : BUG: The Closing Balance column is not coming under Facility Balance Table",
					"STEP7 : EXPECTED: The Closing Balance column is coming under Facility Balance Table");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityBalanceTableColumnVisibility", "Pass", driver);

		} catch (AssertionError validateFacilityBalanceTableColumnVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityBalanceTableColumnVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityBalanceTableColumnVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityBalanceTableColumnVisibility.printStackTrace();
			node.fail(validateFacilityBalanceTableColumnVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityBalanceTableColumnVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityBalanceTableColumnVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityBalanceTableColumnVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityBalanceTableColumnVisibility.printStackTrace();
			node.fail(validateFacilityBalanceTableColumnVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_066
	@Test(priority = 56)
	public void validateNavigationToFundingSummaryTab() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that user is redirected to the Summary tab of Funding module on clicking on the Internal Reference name or Facility Ref name")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Click on on the Internal Reference name
			IElementActions.clickelement_usingXpath(node, driver,
					ReportingBalanceSheetPO.firstFacilityBalanceInternalRefColumnValue);
			node.log(Status.INFO, "STEP1 : The Clicked on Internal Reference Column First Internal Reference");
			System.out.println("STEP1 :  The Clicked on Internal Reference Column First Internal Reference");

			// Wait for the visibility of the Edit Loan Facility Header Text
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the Edit Loan Facility Header Text");
			System.out.println("STEP2 : Waiting for the visibility of the Edit Loan Facility Header Text");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.editLoanFacilityText);
			node.log(Status.INFO, "STEP3 : The Edit Loan Facility Header Text is now visible");
			System.out.println("STEP3 : The Edit Loan Facility Header Text is now visible");

			Thread.sleep(2000);

			// Getting the current URL
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			if ((currentUrl.contains("summary") && currentUrl.contains("loan-facility/lf"))) {
				node.log(Status.INFO,
						"STEP4 : PASS : The clicking on Internal Reference ,user is redirected to the Summary tab of Funding module");
				System.out.println(
						"STEP4 : PASS : The clicking on Internal Reference ,user is redirected to the Summary tab of Funding module");
			} else {
				node.log(Status.INFO,
						"STEP4 : BUG : The clicking on Internal Reference ,user is not redirected to the Summary tab of Funding module");
				System.out.println(
						"STEP4 : BUG : The clicking on Internal Reference ,user is not redirected to the Summary tab of Funding module");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateNavigationToFundingSummaryTab", "Pass", driver);

		} catch (AssertionError validateNavigationToFundingSummaryTab) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNavigationToFundingSummaryTab test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNavigationToFundingSummaryTab_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNavigationToFundingSummaryTab.printStackTrace();
			node.fail(validateNavigationToFundingSummaryTab);
			Assert.fail();
			extent.flush();

		} catch (Exception validateNavigationToFundingSummaryTab) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNavigationToFundingSummaryTab test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNavigationToFundingSummaryTab_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNavigationToFundingSummaryTab.printStackTrace();
			node.fail(validateNavigationToFundingSummaryTab);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_069
	@Test(priority = 57)
	public void validateFacilityBlanceTableAscendingOrderDataSorting() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify when user click on a column heading toggle a first time, the row  in the table are sorted in ascending order of that category."
							+ "- Internal Reference" + "- Reference" + "- Opening Balance" + "- Drawdowns"
							+ "- Repayments" + "- Closing Balance")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Wait for the visibility of the facility balance internal reference
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the facility balance internal reference");
			System.out.println("STEP1 : Waiting for the visibility of the facility balance internal reference");
			IWaitStrategy.waitForVisiblity(node, driver,
					ReportingBalanceSheetPO.facilityBalanceInternalRefColumnToggle);
			node.log(Status.INFO, "STEP2 : The facility balance internal reference is now visible");
			System.out.println("STEP2 : The facility balance internal reference is now visible");

			// The Click on Internal Reference Column Toggle Icon
			IElementActions.clickelement_usingXpath(node, driver,
					ReportingBalanceSheetPO.facilityBalanceInternalRefColumnToggle);
			node.log(Status.INFO, "STEP3 : Clicked on Facility Balance Table Internal Reference Column Toggle Icon");
			System.out.println("STEP3 : Clicked on Facility Balance Table Internal Reference Column Toggle Icon");

			// Check the Ascending order for Internal Reference Column Values
			Utils.validateDataSortingOrder(node, driver, ReportingBalanceSheetPO.facilityBalanceInternalRefColumnToggle,
					"validateFacilityBlanceTableAscendingOrderDataSorting", "stringValue");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityBlanceTableAscendingOrderDataSorting", "Pass",
					driver);

		} catch (AssertionError validateFacilityBlanceTableAscendingOrderDataSorting) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityBlanceTableAscendingOrderDataSorting test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityBlanceTableAscendingOrderDataSorting_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityBlanceTableAscendingOrderDataSorting.printStackTrace();
			node.fail(validateFacilityBlanceTableAscendingOrderDataSorting);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityBlanceTableAscendingOrderDataSorting) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityBlanceTableAscendingOrderDataSorting test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityBlanceTableAscendingOrderDataSorting_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityBlanceTableAscendingOrderDataSorting.printStackTrace();
			node.fail(validateFacilityBlanceTableAscendingOrderDataSorting);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_070
	@Test(priority = 58)
	public void validateFacilityBlanceTableDescendingOrderDataSorting() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify when user click on a column heading toggle a second time, the row  in the table are sorted in descending order of that category."
							+ "- Internal Reference" + "- Reference" + "- Opening Balance" + "- Drawdowns"
							+ "- Repayments" + "- Closing Balance")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Clicked on the facility balance internal reference column sort icon twice and
			// validate list
			ReportingPage.scrollAndClickToSort(ReportingBalanceSheetPO.facilityBalanceInternalRefColumnToggle,
					"Facility Balance Internal Reference", "doubleClick");

			Utils.validateDataSortingOrder(node, driver, ReportingBalanceSheetPO.facilityBalanceInternalRefColumnValue,
					"validateFacilityBlanceTableDescendingOrderDataSorting", "stringValue");

		} catch (AssertionError validateFacilityBlanceTableDescendingOrderDataSorting) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityBlanceTableDescendingOrderDataSorting test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityBlanceTableDescendingOrderDataSorting_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityBlanceTableDescendingOrderDataSorting.printStackTrace();
			node.fail(validateFacilityBlanceTableDescendingOrderDataSorting);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityBlanceTableDescendingOrderDataSorting) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityBlanceTableDescendingOrderDataSorting test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityBlanceTableDescendingOrderDataSorting_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityBlanceTableDescendingOrderDataSorting.printStackTrace();
			node.fail(validateFacilityBlanceTableDescendingOrderDataSorting);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_071
	@Test(priority = 59)
	public void validateDrawdownsAmountVisibility() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the Drawdowns Amount for each respective loan under the Drawdown column.")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Check the visibility of Drawdowns Amount
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.drawdownsColumnValues,
					"STEP1 : BUG: The Drawdowns Amount is not coming in Drawdowns Column.",
					"STEP1 : EXPECTED: The Drawdowns Amount is coming in Drawdowns Column.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDrawdownsAmountVisibility", "Pass", driver);

		} catch (AssertionError validateDrawdownsAmountVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDrawdownsAmountVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDrawdownsAmountVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDrawdownsAmountVisibility.printStackTrace();
			node.fail(validateDrawdownsAmountVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDrawdownsAmountVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDrawdownsAmountVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDrawdownsAmountVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDrawdownsAmountVisibility.printStackTrace();
			node.fail(validateDrawdownsAmountVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_072
	@Test(priority = 60)
	public void validateFacilityTableRepaymentsAmountVisibility() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the Repayments Amount for each respective loan under the Repayments column")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Check the visibility of Repayments Amount
			IElementActions.assertTrue_usingXpath(node, driver,
					ReportingBalanceSheetPO.facilityBalanceRepaymentsColumnValues,
					"STEP1 : BUG: The Repayments Amount is not coming in Repayments Column.",
					"STEP1 : EXPECTED: The Repayments Amount is coming in Repayments Column.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityTableRepaymentsAmountVisibility", "Pass", driver);

		} catch (AssertionError validateFacilityTableRepaymentsAmountVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityTableRepaymentsAmountVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityTableRepaymentsAmountVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityTableRepaymentsAmountVisibility.printStackTrace();
			node.fail(validateFacilityTableRepaymentsAmountVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityTableRepaymentsAmountVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityTableRepaymentsAmountVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityTableRepaymentsAmountVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityTableRepaymentsAmountVisibility.printStackTrace();
			node.fail(validateFacilityTableRepaymentsAmountVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_073
	@Test(priority = 61)
	public void validateFacilityTableClosingBalanceAmountVisibility() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the system accurately displays the Closing Balance for each respective loan under the Closing Balance column")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Check the visibility of Closing Balance Amount
			IElementActions.assertTrue_usingXpath(node, driver,
					ReportingBalanceSheetPO.facilityBalanceClosingBalanceColumnValues,
					"STEP1 : BUG: The Closing Balance Amount is not coming in Closing Balance Column.",
					"STEP1 : EXPECTED: The Closing Balance Amount is coming in Closing Balance Column.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityTableClosingBalanceAmountVisibility", "Pass",
					driver);

		} catch (AssertionError validateFacilityTableClosingBalanceAmountVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityTableClosingBalanceAmountVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityTableClosingBalanceAmountVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityTableClosingBalanceAmountVisibility.printStackTrace();
			node.fail(validateFacilityTableClosingBalanceAmountVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityTableClosingBalanceAmountVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityTableClosingBalanceAmountVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityTableClosingBalanceAmountVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityTableClosingBalanceAmountVisibility.printStackTrace();
			node.fail(validateFacilityTableClosingBalanceAmountVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_074
	@Test(priority = 62)
	public void validateValuesUpdateBasedOnCustomDateRange() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that when user select the custom date range from the Custom search calendar then values will update and match the selected date")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// create Dynamic Locator for Cash Balance Opening Amount
			String cashBalanceOpeningAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.cashBalanceAmount, "locatorValue", "Opening");

			// create Dynamic Locator for Cash Balance Closing Amount
			String cashBalanceClosingAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.cashBalanceAmount, "locatorValue", "Closing");

			// create Dynamic Locator for Loan Balance Opening Amount
			String loanBalanceOpeningAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.loanBalanceAmount, "locatorValue", "Opening");

			// create Dynamic Locator for Loan Balance Closing Amount
			String loanBalanceClosingAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.loanBalanceAmount, "locatorValue", "Closing");

			// create Dynamic Locator for facilities Balance Opening Amount
			String facilitiesBalanceOpeningAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.facilitiesBalanceAmount, "locatorValue", "Opening");

			// create Dynamic Locator for facilities Balance Closing Amount
			String facilitiesBalanceClosingAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.facilitiesBalanceAmount, "locatorValue", "Closing");

			// Wait for the Page Loading to complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Getting value of the Cash Balance Opening Amount Before Search
			int cashBalanceOpeningAmount = Utils.getTextAndParseToInt(cashBalanceOpeningAmountLocator);

			// Getting value of the Cash Balance Closing Amount Before Search
			int cashBalanceClosingAmount = Utils.getTextAndParseToInt(cashBalanceClosingAmountLocator);

			// Getting value of the Loan Balance Opening Amount Before Search
			int loanBalanceOpeningAmount = Utils.getTextAndParseToInt(loanBalanceOpeningAmountLocator);

			// Getting value of the Loan Balance Closing Amount Before Search
			int loanBalanceClosingAmount = Utils.getTextAndParseToInt(loanBalanceClosingAmountLocator);

			// Getting value of the Facilities Balance Opening Amount Before Search
			int facilitiesBalanceOpeningAmount = Utils.getTextAndParseToInt(facilitiesBalanceOpeningAmountLocator);

			// Getting value of the Facilities Balance Closing Amount Before Search
			int facilitiesBalanceClosingAmount = Utils.getTextAndParseToInt(facilitiesBalanceClosingAmountLocator);

			// Calling enterDate from Utils to select Start Date From Calender
			Utils.enterDate(ReportingBalanceSheetPO.customSearchStartDateField, UtilsPO.calenderMonth, "4",
					UtilsPO.calenderYear, "2024", UtilsPO.calenderDay, "11");

			// Calling enterDate from Utils to select End Date From Calender
			Utils.enterDate(ReportingBalanceSheetPO.customSearchEndDateField, UtilsPO.calenderMonth, "4",
					UtilsPO.calenderYear, "2024", UtilsPO.calenderDay, "12");

			// Click on the Search Button
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.customSearchButton);
			node.log(Status.INFO, "STEP1 : The Clicked on Search Button");
			System.out.println("STEP1 : The Clicked on Search Button");

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Wait for the Page Loading to complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Getting value of the Cash Balance Opening Amount After Search
			int updatedCashBalanceOpeningAmount = Utils.getTextAndParseToInt(cashBalanceOpeningAmountLocator);

			// Getting value of the Cash Balance Closing Amount After Search
			int updatedCashBalanceClosingAmount = Utils.getTextAndParseToInt(cashBalanceClosingAmountLocator);

			// Getting value of the Loan Balance Opening Amount After Search
			int updatedLoanBalanceOpeningAmount = Utils.getTextAndParseToInt(loanBalanceOpeningAmountLocator);

			// Getting value of the Loan Balance Closing Amount After Search
			int updatedLoanBalanceClosingAmount = Utils.getTextAndParseToInt(loanBalanceClosingAmountLocator);

			// Getting value of the Facilities Balance Opening Amount After Search
			int updatedFacilitiesBalanceOpeningAmount = Utils
					.getTextAndParseToInt(facilitiesBalanceOpeningAmountLocator);

			// Getting value of the Facilities Balance Closing Amount After Search
			int updatedFacilitiesBalanceClosingAmount = Utils
					.getTextAndParseToInt(facilitiesBalanceClosingAmountLocator);

			// Assert the Updated Cash Balance Opening Amount
			IElementActions.assertEquals_usingInteger(node, driver, cashBalanceOpeningAmount,
					updatedCashBalanceOpeningAmount,
					"STEP2 : BUG : The Cash Balance Opening Amount Before Search " + cashBalanceOpeningAmount
							+ " is not updated After Search " + updatedCashBalanceOpeningAmount,
					"STEP2 : PASS : The Cash Balance Opening Amount Before Search " + cashBalanceOpeningAmount
							+ " is Successfully Updated After Search " + updatedCashBalanceOpeningAmount);

			// Assert the Updated Cash Balance Closing Amount
			IElementActions.assertEquals_usingInteger(node, driver, cashBalanceClosingAmount,
					updatedCashBalanceClosingAmount,
					"STEP3 : BUG : The Cash Balance Closing Amount Before Search " + cashBalanceClosingAmount
							+ " is not updated After Search " + updatedCashBalanceClosingAmount,
					"STEP3 : PASS : The Cash Balance Closing Amount Before Search " + cashBalanceClosingAmount
							+ " is Successfully Updated After Search " + updatedCashBalanceClosingAmount);

			// Assert the Updated Loan Balance Opening Amount
			IElementActions.assertEquals_usingInteger(node, driver, loanBalanceOpeningAmount,
					updatedLoanBalanceOpeningAmount,
					"STEP4 : BUG : The Loan Balance Opening Amount Before Search " + loanBalanceOpeningAmount
							+ " is not updated After Search " + updatedLoanBalanceOpeningAmount,
					"STEP4 : PASS : The Loan Balance Opening Amount Before Search " + loanBalanceOpeningAmount
							+ " is Successfully Updated After Search " + updatedLoanBalanceOpeningAmount);

			// Assert the Updated Loan Balance Closing Amount
			IElementActions.assertEquals_usingInteger(node, driver, loanBalanceClosingAmount,
					updatedLoanBalanceClosingAmount,
					"STEP5 : BUG : The Loan Balance Closing Amount Before Search  " + loanBalanceClosingAmount
							+ " is not updated After Search " + updatedLoanBalanceClosingAmount,
					"STEP5 : PASS : The Loan Balance Closing Amount Before Search " + loanBalanceClosingAmount
							+ " is Successfully Updated After Search " + updatedLoanBalanceClosingAmount);

			// Assert the Updated Facilities Balance Opening Amount
			IElementActions.assertEquals_usingInteger(node, driver, facilitiesBalanceOpeningAmount,
					updatedFacilitiesBalanceOpeningAmount,
					"STEP6: BUG : The Facilities Balance Opening Amount Before Search " + facilitiesBalanceOpeningAmount
							+ " is not updated After Search " + updatedFacilitiesBalanceOpeningAmount,
					"STEP6 : PASS : The Facilities Balance Opening Amount Before Search "
							+ facilitiesBalanceOpeningAmount + " is Successfully Updated After Search "
							+ updatedFacilitiesBalanceOpeningAmount);

			// Assert the Updated Facilities Balance Closing Amount
			IElementActions.assertEquals_usingInteger(node, driver, facilitiesBalanceClosingAmount,
					updatedFacilitiesBalanceClosingAmount,
					"STEP7 : BUG : The Facilities Balance Closing Amount Before Search  "
							+ facilitiesBalanceClosingAmount + " is not updated After Search "
							+ updatedFacilitiesBalanceClosingAmount,
					"STEP7 : PASS : The Facilities Balance Closing Amount Before Search "
							+ facilitiesBalanceClosingAmount + " is Successfully Updated After Search "
							+ updatedFacilitiesBalanceClosingAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateValuesUpdateBasedOnCustomDateRange", "Pass", driver);

		} catch (AssertionError validateValuesUpdateBasedOnCustomDateRange) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateValuesUpdateBasedOnCustomDateRange test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateValuesUpdateBasedOnCustomDateRange_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateValuesUpdateBasedOnCustomDateRange.printStackTrace();
			node.fail(validateValuesUpdateBasedOnCustomDateRange);
			Assert.fail();
			extent.flush();

		} catch (Exception validateValuesUpdateBasedOnCustomDateRange) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateValuesUpdateBasedOnCustomDateRange test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateValuesUpdateBasedOnCustomDateRange_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateValuesUpdateBasedOnCustomDateRange.printStackTrace();
			node.fail(validateValuesUpdateBasedOnCustomDateRange);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_075
	@Test(priority = 63)
	public void validateCustomSearchStartAndEndDateCalendarPopup() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify when user clicks on Custom Search Start Date and End Date field calendar is getting open")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Click on the Custom Search Start Date Input Field
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.customSearchStartDateField);
			node.log(Status.INFO, "STEP1 : The Clicked on Custom Search Start Date Input Field.");
			System.out.println("STEP1 : The Clicked on Custom Search Start Date Input Field.");

			// Wait for the visibility of the calendar
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the Calendar");
			System.out.println("STEP2 : Waiting for the visibility of the Calendar");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.calenderPopup);
			node.log(Status.INFO, "STEP3 : The Calendar is now visible");
			System.out.println("STEP3 : The Calendar is now visible");

			// Assert that the Clicking on the Custom Search Start Date Input Field then
			// Calendar is open
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.calenderPopup,
					"STEP4 : BUG : Clicking on the Custom Search Start Date input field then Calendar is not open.",
					"STEP4 : PASS : Clicking on the Custom Search Start Date input field then Calendar is open.");

			// Click on the Custom Search End Date Input Field
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.customSearchEndDateField);
			node.log(Status.INFO, "STEP5 : The Clicked on Custom Search End Date Input Field.");
			System.out.println("STEP5 : The Clicked on Custom Search End Date Input Field.");

			// Wait for the visibility of the calendar
			node.log(Status.INFO, "STEP6 : Waiting for the visibility of the Calendar");
			System.out.println("STEP6 : Waiting for the visibility of the Calendar");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.calenderPopup);
			node.log(Status.INFO, "STEP7 : The Calendar is now visible");
			System.out.println("STEP7 : The Calendar is now visible");

			// Assert that the Clicking on the Custom Search End Date Input Field then
			// Calendar is open
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.calenderPopup,
					"STEP8 : BUG : Clicking on the Custom Search End Date input field then Calendar is not open.",
					"STEP8 : PASS : Clicking on the Custom Search End Date input field then Calendar is open.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCustomSearchStartAndEndDateCalendarPopup", "Pass",
					driver);

		} catch (AssertionError validateCustomSearchStartAndEndDateCalendarPopup) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCustomSearchStartAndEndDateCalendarPopup test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCustomSearchStartAndEndDateCalendarPopup_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCustomSearchStartAndEndDateCalendarPopup.printStackTrace();
			node.fail(validateCustomSearchStartAndEndDateCalendarPopup);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCustomSearchStartAndEndDateCalendarPopup) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCustomSearchStartAndEndDateCalendarPopup test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCustomSearchStartAndEndDateCalendarPopup_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCustomSearchStartAndEndDateCalendarPopup.printStackTrace();
			node.fail(validateCustomSearchStartAndEndDateCalendarPopup);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_076
	@Test(priority = 64)
	public void validateDefaultDateIsCurrentDate() throws IOException {
		try {
			extenttest = extent.createTest("Verify default date selection is the Current Date")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Wait for the visibility of the start date
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the start date to be clickable and visible");
			System.out.println("STEP1 : Waiting for the visibility of the start date to be clickable and visible");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.startDate);
			IWaitStrategy.WaitUntilElementClickable(node, driver, ReportingBalanceSheetPO.startDate);
			node.log(Status.INFO, "STEP2 : Start date is clickable and visible");
			System.out.println("STEP2 : Start date is clickable and visible");

			Thread.sleep(5000);
			// Click on the start date
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.startDate);
			node.log(Status.INFO, "STEP3 : Clicked on start date");
			System.out.println("STEP3 :  Clicked on start date");

			// Wait for the visibility of the calendar
			node.log(Status.INFO, "STEP4 : Waiting for the visibility of the calendar");
			System.out.println("STEP4 : Waiting for the visibility of the calendar");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.dateCalender);
			node.log(Status.INFO, "STEP5 : Calendar is visible now");
			System.out.println("STEP5 : Calendar is visible now");

			String year = Utils.getCurrectYear();
			String month = Utils.getCurrentMonthName();
			String day = Utils.getTodayDayFormatted();
			String date = month + " " + day + ", " + year;

			// Create Dynamic Date Locator
			String dateLocator = IElementActions.createDynamicLocatorString(ReportingBalanceSheetPO.dynamicDate,
					"locatorValue", date);

			String startDateTabindex = IElementActions.getElementTextFromAttribute_usingXpath(node, driver, dateLocator,
					"tabindex");

			// Assert the current start date
			IElementActions.assertEquals_usingString(node, driver, startDateTabindex, "0",
					"STEP6 : BUG : The default date selected in the start date field is not the current date i.e "
							+ startDateTabindex,
					"STEP6 : PASS : The default date selected in the start date field is the current date i.e tabindex "
							+ startDateTabindex);

			// Click on the end date
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.endDate);
			node.log(Status.INFO, "STEP7 : Clicked on end date");
			System.out.println("STEP7 :  Clicked on end date");

			// Wait for the visibility of the calendar
			node.log(Status.INFO, "STEP8 : Waiting for the visibility of the calendar");
			System.out.println("STEP8 : Waiting for the visibility of the calendar");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.dateCalender);
			node.log(Status.INFO, "STEP9 : Calendar is visible now");
			System.out.println("STEP9 : Calendar is visible now");

			String endDateTabindex = IElementActions.getElementTextFromAttribute_usingXpath(node, driver, dateLocator,
					"tabindex");

			// Assert the current end date
			IElementActions.assertEquals_usingString(node, driver, endDateTabindex, "0",
					"STEP10 : BUG : The default date selected in the end date field is not the current date i.e "
							+ startDateTabindex,
					"STEP10 : PASS : The default date selected in the end date field is the current date i.e tabindex "
							+ startDateTabindex);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDefaultDateIsCurrentDate", "Pass", driver);

		} catch (AssertionError validateDefaultDateIsCurrentDate) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDefaultDateIsCurrentDate test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDefaultDateIsCurrentDate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDefaultDateIsCurrentDate.printStackTrace();
			node.fail(validateDefaultDateIsCurrentDate);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDefaultDateIsCurrentDate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDefaultDateIsCurrentDate test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDefaultDateIsCurrentDate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDefaultDateIsCurrentDate.printStackTrace();
			node.fail(validateDefaultDateIsCurrentDate);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_077
	@Test(priority = 65)
	public void validateSelectStartAndEndDateFromCalendar() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify user is able to select date from calendar date picker in the Date field after that calendar date picker get closed automatically.")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get current day, year and month
			String day = Utils.getTodayDayFormatted();
			String month = Utils.getCurrentMonth();
			String year = Utils.getCurrectYear();

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Wait for the visibility of the start date
			node.log(Status.INFO,
					"STEP1 : Waiting for the visibility of the custom search start date to be clickable and visible");
			System.out.println(
					"STEP1 : Waiting for the visibility of the custom search start date to be clickable and visible");
			IWaitStrategy.waitForVisiblityDynamic(node, driver, ReportingBalanceSheetPO.customSearchStartDateField,
					150);
			IWaitStrategy.WaitUntilElementClickable(node, driver, ReportingBalanceSheetPO.customSearchStartDateField);
			node.log(Status.INFO, "STEP2 : Custom search start date is clickable and visible");
			System.out.println("STEP2 : Custom search start date is clickable and visible");

			// Calling enterDate from Utils to select Custom Search Start Date From Calender
			Utils.enterDate(ReportingBalanceSheetPO.customSearchStartDateField, UtilsPO.calenderMonth, month,
					UtilsPO.calenderYear, year, UtilsPO.calenderDay, day);

			// Assert After Selecting the Start Date the Custom Search Start Date Calendar
			// is getting closed.
			IElementActions.assertFalse_usingXpath(node, driver, ReportingBalanceSheetPO.calenderPopup,
					"STEP2 : BUG :  After Selecting the Start Date Custom Search Start Date Calendar is not getting closed.",
					"STEP2 : PASS : After Selecting the Start Date the Custom Search Start Date Calendar is getting closed.");

			// Getting the attribute value of the selected custom search Start Date field
			String selcetedCustomSearchStartDate = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					ReportingBalanceSheetPO.customSearchStartDateField, "value");

			// Assert the Custom Search Start Date field
			IElementActions.assertTrue_ConditionBased(node, driver, selcetedCustomSearchStartDate.contains(day),
					"STEP3 : BUG : The selected Start Date from calendar is not Populated in Start Date Field",
					"STEP3 : PASS : The selected Start Date from calendar is Populated in Start Date Field");

			// Calling enterDate from Utils to select Custom Search End Date From Calender
			Utils.enterDate(ReportingBalanceSheetPO.customSearchEndDateField, UtilsPO.calenderMonth, month,
					UtilsPO.calenderYear, year, UtilsPO.calenderDay, day);

			// After Selecting the End Date the Custom Search End Date Calendar is getting
			// closed.
			IElementActions.assertFalse_usingXpath(node, driver, ReportingBalanceSheetPO.calenderPopup,
					"STEP4 : BUG : After Selecting the End Date the Custom Search End Date Calendar is not getting closed.",
					"STEP4 : PASS : After Selecting the End Date the Custom Search End Date Calendar is getting closed.");

			// Getting the attribute value of the selected custom search End Date field
			String selcetedCustomSearchEndDate = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					ReportingBalanceSheetPO.customSearchEndDateField, "value");

			// Assert the Custom Search End Date field
			IElementActions.assertTrue_ConditionBased(node, driver, selcetedCustomSearchEndDate.contains(day),
					"STEP5 : BUG : The selected End Date from calendar is not Populated in End Date Field",
					"STEP5 : PASS : The selected End Date from calendar is Populated in End Date Field");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateSelectStartAndEndDateFromCalendar", "Pass", driver);

		} catch (AssertionError validateSelectStartAndEndDateFromCalendar) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateSelectStartAndEndDateFromCalendar test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateSelectStartAndEndDateFromCalendar_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSelectStartAndEndDateFromCalendar.printStackTrace();
			node.fail(validateSelectStartAndEndDateFromCalendar);
			Assert.fail();
			extent.flush();

		} catch (Exception validateSelectStartAndEndDateFromCalendar) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateSelectStartAndEndDateFromCalendar test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateSelectStartAndEndDateFromCalendar_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSelectStartAndEndDateFromCalendar.printStackTrace();
			node.fail(validateSelectStartAndEndDateFromCalendar);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_078
	@Test(priority = 66)
	public void validateStartAndEndDateCalendarClose() throws IOException {
		try {
			extenttest = extent
					.createTest(
							"Verify when user clicks outside the calendar date picker then calendar should be close")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Click on the Custom Search Start Date field
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.customSearchStartDateField);
			node.log(Status.INFO, "STEP1 : Clicked on Custom Search Start Date field");
			System.out.println("STEP1 : Clicked on Custom Search Start Date field");

			// Wait for the visibility of the Custom Search Start Date calendar
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of Custom Search Start Date Calendar");
			System.out.println("STEP2 : Waiting for the visibility of Custom Search Start Date Calendar");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.calenderPopup);
			node.log(Status.INFO, "STEP3 : The Custom Search Start Date Calendar is now visible");
			System.out.println("STEP3 : The Custom Search Start Date Calendar is now visible");

			// Calling mouseHoverByOffsetAndClick from IMouseActions
			IMouseActions.mouseHoverByOffsetAndClick(836, 129);

			// Assert the calendar popup
			IElementActions.assertFalse_usingXpath(node, driver, ReportingBalanceSheetPO.calenderPopup,
					"STEP4 : BUG : After clicking outside the Start Date datepicker Calendar is not getting closed.",
					"STEP4 : PASS : After clicking outside the Start Date datepicker Calendar is getting closed.");

			// Click on the Custom Search End Date field
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.customSearchEndDateField);
			node.log(Status.INFO, "STEP5 : Clicked on Custom Search End Date field");
			System.out.println("STEP5 : Clicked on Custom Search End Date field");

			// Wait for the visibility of the Custom Search End Date calendar
			node.log(Status.INFO, "STEP6 : Waiting for the visibility of Custom Search End Date Calendar");
			System.out.println("STEP6 : Waiting for the visibility of Custom Search End Date Calendar");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.calenderPopup);
			node.log(Status.INFO, "STEP7 : The Custom Search End Date Calendar is now visible");
			System.out.println("STEP7 : The Custom Search End Date Calendar is now visible");

			// Click on the outside
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.balanceSheetHeader);
			node.log(Status.INFO, "STEP8 : Clicked on outside");
			System.out.println("STEP8 : Clicked on outside");

			// Assert the calendar popup
			IElementActions.assertFalse_usingXpath(node, driver, ReportingBalanceSheetPO.calenderPopup,
					"STEP9 : BUG : After clicking outside the End Date datepicker Calendar is not getting closed.",
					"STEP9 : PASS : After clicking outside the End Date datepicker Calendar is getting closed.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateStartAndEndDateCalendarClose", "Pass", driver);

		} catch (AssertionError validateStartAndEndDateCalendarClose) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateStartAndEndDateCalendarClose test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateStartAndEndDateCalendarClose_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateStartAndEndDateCalendarClose.printStackTrace();
			node.fail(validateStartAndEndDateCalendarClose);
			Assert.fail();
			extent.flush();

		} catch (Exception validateStartAndEndDateCalendarClose) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateStartAndEndDateCalendarClose test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateStartAndEndDateCalendarClose_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateStartAndEndDateCalendarClose.printStackTrace();
			node.fail(validateStartAndEndDateCalendarClose);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_079
	@Test(priority = 67)
	public void validateSearchByMonthCalendarMonths() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that when user select search by month calendar it will dispaly only months to select on calendar")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Call the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Clicked on Search By Month Input Field
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.searchByMonthInputField);
			node.log(Status.INFO, "STEP1 : The Clicked on Search By Month input field");
			System.out.println("STEP1 : The Clicked on Search By Month input field");

			// Wait for the visibility of the calendar
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the months in calendar");
			System.out.println("STEP2 : Waiting for the visibility of the months in calendar");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.allMonthsCalendar);
			node.log(Status.INFO, "STEP3 : The Months in calendar is now visible");
			System.out.println("STEP3 : The Months in calendar is now visible");

			// Assert the The calendar display only months for selection, without days or
			// years
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.allMonthsCalendar,
					"STEP4 : BUG : The calendar is not display only months for selection, without days or years",
					"STEP4 : PASS : The calendar display only months for selection, without days or years");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateSearchByMonthCalendarMonths", "Pass", driver);

		} catch (AssertionError validateSearchByMonthCalendarMonths) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateSearchByMonthCalendarMonths test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateSearchByMonthCalendarMonths_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSearchByMonthCalendarMonths.printStackTrace();
			node.fail(validateSearchByMonthCalendarMonths);
			Assert.fail();
			extent.flush();

		} catch (Exception validateSearchByMonthCalendarMonths) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateSearchByMonthCalendarMonths test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateSearchByMonthCalendarMonthsByMonth_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSearchByMonthCalendarMonths.printStackTrace();
			node.fail(validateSearchByMonthCalendarMonths);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_080
	@Test(priority = 68)
	public void validateSelectYearFromCalendarForSearchByMonth() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that user can select the year from calendar for Search by month option")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// String year = "2023";

			String year = Utils.getCurrectYear();

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Call the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Clicked on Search By Month Input Field
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.searchByMonthInputField);
			node.log(Status.INFO, "STEP1 : The Clicked on Search By Month input field");
			System.out.println("STEP1 : The Clicked on Search By Month input field");

			// Waiting for the visibility of the calendar Year dropdown
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the calendar Year dropdown");
			System.out.println("STEP2 :  Waiting for the visibility of the calendar Year dropdown");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.calendarYear);
			node.log(Status.INFO, "STEP3 : The Calendar Year dropdown is now visible");
			System.out.println("STEP3 : The Calendar Year dropdown is now visible");

			// Select the Year From the Year Dropdown
			IElementActions.selectByValueFromDropdown(node, driver, ReportingBalanceSheetPO.calendarYear, year);

			// Getting the attribute value of the selected Search by Month Calendar Year
			// dropdown
			String selcectedYear = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					ReportingBalanceSheetPO.calendarYear, "value");

			// Assert the Year dropdown
			IElementActions.assertTrue_ConditionBased(node, driver, selcectedYear.contains(year),
					"STEP4 : BUG : The user is not able to select the year from calendar year dropdown for Search by month option.",
					"STEP4 : PASS : The user is able to select the year from calendar year dropdown for Search by month option.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateSelectYearFromCalendarForSearchByMonth", "Pass", driver);

		} catch (AssertionError validateSelectYearFromCalendarForSearchByMonth) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateSelectYearFromCalendarForSearchByMonth test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateSelectYearFromCalendarForSearchByMonth_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSelectYearFromCalendarForSearchByMonth.printStackTrace();
			node.fail(validateSelectYearFromCalendarForSearchByMonth);
			Assert.fail();
			extent.flush();

		} catch (Exception validateSelectYearFromCalendarForSearchByMonth) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateSelectYearFromCalendarForSearchByMonth test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateSelectYearFromCalendarForSearchByMonth_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSelectYearFromCalendarForSearchByMonth.printStackTrace();
			node.fail(validateSelectYearFromCalendarForSearchByMonth);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_081
	@Test(priority = 69)
	public void validateCalendarYearByForwardAndBackwordArrows() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that user can select the year form calendar for Search by Month option using forward and backword arrows")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Call the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Click on the search by month field
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.searchByMonthInputField);
			node.log(Status.INFO, "STEP1 : The Clicked on Search By Month input field");
			System.out.println("STEP1 : The Clicked on Search By Month input field");

			// Wait for the visibility of the calendar
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the months in calendar");
			System.out.println("STEP2 : Waiting for the visibility of the months in calendar");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.allMonthsCalendar);
			node.log(Status.INFO, "STEP3 : The Months in calendar is now visible");
			System.out.println("STEP3 : The Months in calendar is now visible");

			// Getting the current year
			int currentYear = LocalDate.now().getYear();

			// Click on the calendar previous arrow
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.calendarPreviousArrrow);
			node.log(Status.INFO, "STEP4 : The Clicked on Calender Previous Arrow Icon");
			System.out.println("STEP4 : The Clicked on Calender Previous Arrow Icon");

			// Getting the calendar year value from the field
			String previousYearFieldValue = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					ReportingBalanceSheetPO.calendarYear, "value");

			// Assert the Previous Year
			IElementActions.assertTrue_ConditionBased(node, driver,
					Integer.parseInt(previousYearFieldValue) < currentYear,
					"STEP5 : BUG : The Previous year " + previousYearFieldValue
							+ " is not selectable by clicking previous arrow",
					"STEP5 : PASS : The Previous year " + previousYearFieldValue
							+ " is selectable by clicking previous arrow");

			// Click on the calendar next arrow
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.calendarNextArrow);
			node.log(Status.INFO, "STEP6 : The Clicked on Calender Next Arrow Icon");
			System.out.println("STEP6 : The Clicked on Calender Next Arrow Icon");

			// Getting the calendar year value from the field
			String nextYearFieldValue = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					ReportingBalanceSheetPO.calendarYear, "value");

			// Assert the Next Year
			IElementActions.assertTrue_ConditionBased(node, driver, Integer.parseInt(nextYearFieldValue) == currentYear,
					"STEP7 : BUG : The Next Year " + nextYearFieldValue + " is not selectable by clicking next arrow",
					"STEP7 : PASS : The Next Year " + nextYearFieldValue + " is selectable by clicking next arrow");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCalendarYearByForwardAndBackwordArrows", "Pass", driver);

		} catch (AssertionError validateCalendarYearByForwardAndBackwordArrows) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCalendarYearByForwardAndBackwordArrows test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCalendarYearByForwardAndBackwordArrows_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCalendarYearByForwardAndBackwordArrows.printStackTrace();
			node.fail(validateCalendarYearByForwardAndBackwordArrows);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCalendarYearByForwardAndBackwordArrows) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCalendarYearByForwardAndBackwordArrows test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCalendarYearByForwardAndBackwordArrows_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCalendarYearByForwardAndBackwordArrows.printStackTrace();
			node.fail(validateCalendarYearByForwardAndBackwordArrows);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_082
	@Test(priority = 70)
	public void validateUpdatedAmountsAfterSelectingSearchByMonths() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that when user select month and click on Search field then the current values for opening and closing balances for Cash, Loans and Facilities will be updated to match the selected date")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// create Dynamic Locator for Cash Balance Opening Amount
			String cashBalanceOpeningAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.cashBalanceAmount, "locatorValue", "Opening");

			// create Dynamic Locator for Cash Balance Closing Amount
			String cashBalanceClosingAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.cashBalanceAmount, "locatorValue", "Closing");

			// create Dynamic Locator for Loan Balance Opening Amount
			String loanBalanceOpeningAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.loanBalanceAmount, "locatorValue", "Opening");

			// create Dynamic Locator for Loan Balance Closing Amount
			String loanBalanceClosingAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.loanBalanceAmount, "locatorValue", "Closing");

			// create Dynamic Locator for facilities Balance Opening Amount
			String facilitiesBalanceOpeningAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.facilitiesBalanceAmount, "locatorValue", "Opening");

			// create Dynamic Locator for facilities Balance Closing Amount
			String facilitiesBalanceClosingAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.facilitiesBalanceAmount, "locatorValue", "Closing");

			// Wait for the Page Loading to complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Getting value of the Cash Balance Opening Amount Before Search
			int cashBalanceOpeningAmount = Utils.getTextAndParseToInt(cashBalanceOpeningAmountLocator);

			// Getting value of the Cash Balance Closing Amount Before Search
			int cashBalanceClosingAmount = Utils.getTextAndParseToInt(cashBalanceClosingAmountLocator);

			// Getting value of the Loan Balance Opening Amount Before Search
			int loanBalanceOpeningAmount = Utils.getTextAndParseToInt(loanBalanceOpeningAmountLocator);

			// Getting value of the Loan Balance Closing Amount Before Search
			int loanBalanceClosingAmount = Utils.getTextAndParseToInt(loanBalanceClosingAmountLocator);

			// Getting value of the Facilities Balance Opening Amount Before Search
			int facilitiesBalanceOpeningAmount = Utils.getTextAndParseToInt(facilitiesBalanceOpeningAmountLocator);

			// Getting value of the Facilities Balance Closing Amount Before Search
			int facilitiesBalanceClosingAmount = Utils.getTextAndParseToInt(facilitiesBalanceClosingAmountLocator);

			// Click on the Search by Month Input Field
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.searchByMonthInputField);
			node.log(Status.INFO, "STEP1 : The Clicked on Search by Month Input Field");
			System.out.println("STEP1 : The Clicked on Search by Month Input Field");

			// Wait for the visibility of the calendar
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the months in calendar");
			System.out.println("STEP2 : Waiting for the visibility of the months in calendar");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.allMonthsCalendar);
			node.log(Status.INFO, "STEP3 : The Months in calendar is now visible");
			System.out.println("STEP3 : The Months in calendar is now visible");

			// Select the January Month
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.januaryMonth);
			node.log(Status.INFO, "STEP4 : The Clicked on Jan Month");
			System.out.println("STEP4 : The Clicked on Jan Month");

			// Click on the Search Button
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.searchByMonthSearchButton);
			node.log(Status.INFO, "STEP5 : The Clicked on Search Button");
			System.out.println("STEP5 : The Clicked on Search Button");

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Wait for the Page Loading to complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Getting value of the Cash Balance Opening Amount After Search
			int updatedCashBalanceOpeningAmount = Utils.getTextAndParseToInt(cashBalanceOpeningAmountLocator);

			// Getting value of the Cash Balance Closing Amount After Search
			int updatedCashBalanceClosingAmount = Utils.getTextAndParseToInt(cashBalanceClosingAmountLocator);

			// Getting value of the Loan Balance Opening Amount After Search
			int updatedLoanBalanceOpeningAmount = Utils.getTextAndParseToInt(loanBalanceOpeningAmountLocator);

			// Getting value of the Loan Balance Closing Amount After Search
			int updatedLoanBalanceClosingAmount = Utils.getTextAndParseToInt(loanBalanceClosingAmountLocator);

			// Getting value of the Facilities Balance Opening Amount After Search
			int updatedFacilitiesBalanceOpeningAmount = Utils
					.getTextAndParseToInt(facilitiesBalanceOpeningAmountLocator);

			// Getting value of the Facilities Balance Closing Amount After Search
			int updatedFacilitiesBalanceClosingAmount = Utils
					.getTextAndParseToInt(facilitiesBalanceClosingAmountLocator);

			// Assert the Updated Cash Balance Opening Amount
			IElementActions.assertEqualsFalse_usingInteger(node, driver, cashBalanceOpeningAmount,
					updatedCashBalanceOpeningAmount,
					"STEP6 : BUG : The Cash Balance Opening Amount Before Search  " + cashBalanceOpeningAmount
							+ " is not updated After Search " + updatedCashBalanceOpeningAmount,
					"STEP6 : PASS : The Cash Balance Opening Amount Before Search " + cashBalanceOpeningAmount
							+ " is Successfully Updated After Search " + updatedCashBalanceOpeningAmount);

			// Assert the Updated Cash Balance Closing Amount
			IElementActions.assertEqualsFalse_usingInteger(node, driver, cashBalanceClosingAmount,
					updatedCashBalanceClosingAmount,
					"STEP7 : BUG : The Cash Balance Closing Amount Before Search " + cashBalanceClosingAmount
							+ " is not updated After Search " + updatedCashBalanceClosingAmount,
					"STEP7 : PASS : The Cash Balance Closing Amount Before Search " + cashBalanceClosingAmount
							+ " is Successfully Updated After Search " + updatedCashBalanceClosingAmount);

			// Assert the Updated Loan Balance Opening Amount
			IElementActions.assertEqualsFalse_usingInteger(node, driver, loanBalanceOpeningAmount,
					updatedLoanBalanceOpeningAmount,
					"STEP8 : BUG : The Loan Balance Opening Amount Before Search " + loanBalanceOpeningAmount
							+ " is not updated After Search " + updatedLoanBalanceOpeningAmount,
					"STEP8 : PASS : The Loan Balance Opening Amount Before Search " + loanBalanceOpeningAmount
							+ " is Successfully Updated After Search " + updatedLoanBalanceOpeningAmount);

			// Assert the Updated Loan Balance Closing Amount
			IElementActions.assertEqualsFalse_usingInteger(node, driver, loanBalanceClosingAmount,
					updatedLoanBalanceClosingAmount,
					"STEP9 : BUG : The Loan Balance Closing Amount Before Search  " + loanBalanceClosingAmount
							+ " is not updated After Search " + updatedLoanBalanceClosingAmount,
					"STEP9 : PASS : The Loan Balance Closing Amount Before Search " + loanBalanceClosingAmount
							+ " is Successfully Updated After Search " + updatedLoanBalanceClosingAmount);

			// Assert the Updated Facilities Balance Opening Amount
			IElementActions.assertEqualsFalse_usingInteger(node, driver, facilitiesBalanceOpeningAmount,
					updatedFacilitiesBalanceOpeningAmount,
					"STEP10: BUG : The Facilities Balance Opening Amount Before Search "
							+ facilitiesBalanceOpeningAmount + " is not updated After Search "
							+ updatedFacilitiesBalanceOpeningAmount,
					"STEP10 : PASS : The Facilities Balance Opening Amount Before Search "
							+ facilitiesBalanceOpeningAmount + " is Successfully Updated After Search "
							+ updatedFacilitiesBalanceOpeningAmount);

			// Assert the Updated Facilities Balance Closing Amount
			IElementActions.assertEqualsFalse_usingInteger(node, driver, facilitiesBalanceClosingAmount,
					updatedFacilitiesBalanceClosingAmount,
					"STEP11 : BUG : The Facilities Balance Closing Amount Before Search  "
							+ facilitiesBalanceClosingAmount + " is not updated After Search "
							+ updatedFacilitiesBalanceClosingAmount,
					"STEP11 : PASS : The Facilities Balance Closing Amount Before Search "
							+ facilitiesBalanceClosingAmount + " is Successfully Updated After Search "
							+ updatedFacilitiesBalanceClosingAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateUpdatedAmountsAfterSelectingSearchByMonths", "Pass",
					driver);

		} catch (AssertionError validateUpdatedAmountsAfterSelectingSearchByMonths) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateUpdatedAmountsAfterSelectingSearchByMonths test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateUpdatedAmountsAfterSelectingSearchByMonths_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateUpdatedAmountsAfterSelectingSearchByMonths.printStackTrace();
			node.fail(validateUpdatedAmountsAfterSelectingSearchByMonths);
			Assert.fail();
			extent.flush();

		} catch (Exception validateUpdatedAmountsAfterSelectingSearchByMonths) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateUpdatedAmountsAfterSelectingSearchByMonths test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateUpdatedAmountsAfterSelectingSearchByMonths_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateUpdatedAmountsAfterSelectingSearchByMonths.printStackTrace();
			node.fail(validateUpdatedAmountsAfterSelectingSearchByMonths);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_083
	@Test(priority = 71)
	public void validateAmountsNotUpdated() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that when user select month and click on Search field then the current values for opening and closing balances for Cash, Loans and Facilities will be updated to match the selected date")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// create Dynamic Locator for Cash Balance Opening Amount
			String cashBalanceOpeningAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.cashBalanceAmount, "locatorValue", "Opening");

			// create Dynamic Locator for Cash Balance Closing Amount
			String cashBalanceClosingAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.cashBalanceAmount, "locatorValue", "Closing");

			// create Dynamic Locator for Loan Balance Opening Amount
			String loanBalanceOpeningAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.loanBalanceAmount, "locatorValue", "Opening");

			// create Dynamic Locator for Loan Balance Closing Amount
			String loanBalanceClosingAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.loanBalanceAmount, "locatorValue", "Closing");

			// create Dynamic Locator for facilities Balance Opening Amount
			String facilitiesBalanceOpeningAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.facilitiesBalanceAmount, "locatorValue", "Opening");

			// create Dynamic Locator for facilities Balance Closing Amount
			String facilitiesBalanceClosingAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.facilitiesBalanceAmount, "locatorValue", "Closing");

			// Wait for the Page Loading to complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Getting value of the Cash Balance Opening Amount Before Search
			int cashBalanceOpeningAmount = Utils.getTextAndParseToInt(cashBalanceOpeningAmountLocator);

			// Getting value of the Cash Balance Closing Amount Before Search
			int cashBalanceClosingAmount = Utils.getTextAndParseToInt(cashBalanceClosingAmountLocator);

			// Getting value of the Loan Balance Opening Amount Before Search
			int loanBalanceOpeningAmount = Utils.getTextAndParseToInt(loanBalanceOpeningAmountLocator);

			// Getting value of the Loan Balance Closing Amount Before Search
			int loanBalanceClosingAmount = Utils.getTextAndParseToInt(loanBalanceClosingAmountLocator);

			// Getting value of the Facilities Balance Opening Amount Before Search
			int facilitiesBalanceOpeningAmount = Utils.getTextAndParseToInt(facilitiesBalanceOpeningAmountLocator);

			// Getting value of the Facilities Balance Closing Amount Before Search
			int facilitiesBalanceClosingAmount = Utils.getTextAndParseToInt(facilitiesBalanceClosingAmountLocator);

			// Click on the Search by Month Input Field
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.searchByMonthInputField);
			node.log(Status.INFO, "STEP1 : The Clicked on Search by Month Input Field");
			System.out.println("STEP1 : The Clicked on Search by Month Input Field");

			// Wait for the visibility of the calendar
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the months in calendar");
			System.out.println("STEP2 : Waiting for the visibility of the months in calendar");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.allMonthsCalendar);
			node.log(Status.INFO, "STEP3 : The Months in calendar is now visible");
			System.out.println("STEP3 : The Months in calendar is now visible");

			// Select the January Month
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.januaryMonth);
			node.log(Status.INFO, "STEP4 : The Clicked on Jan Month");
			System.out.println("STEP4 : The Clicked on Jan Month");

			// Getting value of the Cash Balance Opening Amount After Search
			int updatedCashBalanceOpeningAmount = Utils.getTextAndParseToInt(cashBalanceOpeningAmountLocator);

			// Getting value of the Cash Balance Closing Amount After Search
			int updatedCashBalanceClosingAmount = Utils.getTextAndParseToInt(cashBalanceClosingAmountLocator);

			// Getting value of the Loan Balance Opening Amount After Search
			int updatedLoanBalanceOpeningAmount = Utils.getTextAndParseToInt(loanBalanceOpeningAmountLocator);

			// Getting value of the Loan Balance Closing Amount After Search
			int updatedLoanBalanceClosingAmount = Utils.getTextAndParseToInt(loanBalanceClosingAmountLocator);

			// Getting value of the Facilities Balance Opening Amount After Search
			int updatedFacilitiesBalanceOpeningAmount = Utils
					.getTextAndParseToInt(facilitiesBalanceOpeningAmountLocator);

			// Getting value of the Facilities Balance Closing Amount After Search
			int updatedFacilitiesBalanceClosingAmount = Utils
					.getTextAndParseToInt(facilitiesBalanceClosingAmountLocator);

			// Assert the Cash Balance Opening Amount
			IElementActions.assertEquals_usingInteger(node, driver, cashBalanceOpeningAmount,
					updatedCashBalanceOpeningAmount,
					"STEP6 : BUG : The Cash Balance Opening Amount Before Selecting Month  " + cashBalanceOpeningAmount
							+ " is updated After Selecting the Month " + updatedCashBalanceOpeningAmount,
					"STEP6 : PASS : The Cash Balance Opening Amount Before Selecting Month " + cashBalanceOpeningAmount
							+ " is Same as After Selecting the Month " + updatedCashBalanceOpeningAmount);

			// Assert the Cash Balance Closing Amount
			IElementActions.assertEquals_usingInteger(node, driver, cashBalanceClosingAmount,
					updatedCashBalanceClosingAmount,
					"STEP7 : BUG : The Cash Balance Closing Amount Before Selecting Month " + cashBalanceClosingAmount
							+ " is updated After Selecting the Month " + updatedCashBalanceClosingAmount,
					"STEP7 : PASS : The Cash Balance Closing Amount Before Selecting Month " + cashBalanceClosingAmount
							+ " is Same as After Selecting the Month " + updatedCashBalanceClosingAmount);

			// Assert the Loan Balance Opening Amount
			IElementActions.assertEquals_usingInteger(node, driver, loanBalanceOpeningAmount,
					updatedLoanBalanceOpeningAmount,
					"STEP8 : BUG : The Loan Balance Opening Amount Before Selecting Month " + loanBalanceOpeningAmount
							+ " is updated After Selecting the Month " + updatedLoanBalanceOpeningAmount,
					"STEP8 : PASS : The Loan Balance Opening Amount Before Selecting Month " + loanBalanceOpeningAmount
							+ " is Same as After Selecting the Month " + updatedLoanBalanceOpeningAmount);

			// Assert the Loan Balance Closing Amount
			IElementActions.assertEquals_usingInteger(node, driver, loanBalanceClosingAmount,
					updatedLoanBalanceClosingAmount,
					"STEP9 : BUG : The Loan Balance Closing Amount Before Selecting Month  " + loanBalanceClosingAmount
							+ " is updated After Selecting the Month " + updatedLoanBalanceClosingAmount,
					"STEP9 : PASS : The Loan Balance Closing Amount Before Selecting Month " + loanBalanceClosingAmount
							+ " is Same as After Selecting the Month " + updatedLoanBalanceClosingAmount);

			// Assert the Facilities Balance Opening Amount
			IElementActions.assertEquals_usingInteger(node, driver, facilitiesBalanceOpeningAmount,
					updatedFacilitiesBalanceOpeningAmount,
					"STEP10: BUG : The Facilities Balance Opening Amount Before Selecting Month "
							+ facilitiesBalanceOpeningAmount + " is updated After Selecting the Month "
							+ updatedFacilitiesBalanceOpeningAmount,
					"STEP10 : PASS : The Facilities Balance Opening Amount Before Selecting Month "
							+ facilitiesBalanceOpeningAmount + " is Same as After Selecting the Month "
							+ updatedFacilitiesBalanceOpeningAmount);

			// Assert the Facilities Balance Closing Amount
			IElementActions.assertEquals_usingInteger(node, driver, facilitiesBalanceClosingAmount,
					updatedFacilitiesBalanceClosingAmount,
					"STEP11 : BUG : The Facilities Balance Closing Amount Before Selecting Month  "
							+ facilitiesBalanceClosingAmount + " is updated After Selecting the Month "
							+ updatedFacilitiesBalanceClosingAmount,
					"STEP11 : PASS : The Facilities Balance Closing Amount Before Selecting Month "
							+ facilitiesBalanceClosingAmount + " is Same as After Selecting the Month "
							+ updatedFacilitiesBalanceClosingAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAmountsNotUpdated", "Pass", driver);

		} catch (AssertionError validateAmountsNotUpdated) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAmountsNotUpdated test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAmountsNotUpdated_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAmountsNotUpdated.printStackTrace();
			node.fail(validateAmountsNotUpdated);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAmountsNotUpdated) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAmountsNotUpdated test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAmountsNotUpdated_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAmountsNotUpdated.printStackTrace();
			node.fail(validateAmountsNotUpdated);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_084
	@Test(priority = 72)
	public void validateCalendarDatePickerClosedOnClickedOutside() throws IOException {
		try {
			extenttest = extent
					.createTest(
							"Verify when user clicks outside the calendar date picker then calendar should be close")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Click on the Search By Month Date field
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.searchByMonthInputField);
			node.log(Status.INFO, "STEP1 : Clicked on Search By Month field");
			System.out.println("STEP1 : Clicked on Search By Month field");

			// Wait for the visibility of the calendar
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of calendar");
			System.out.println("STEP2 : Waiting for the visibility of calendar");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.searchByMonthCalendarPopup);
			node.log(Status.INFO, "STEP3 : The Calendar is now visible");
			System.out.println("STEP3 : The Calendar is now visible");

			// Wait for the visibility of the text
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.balanceSheetHeader);

			Thread.sleep(1000);
			// Click on the outside
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.balanceSheetHeader);
			node.log(Status.INFO, "STEP4 : Clicked on outside");
			System.out.println("STEP4 : Clicked on outside");

			// Wait for the invisibility of the calendar
			node.log(Status.INFO, "STEP5 : Waiting for the invisibility of calendar");
			System.out.println("STEP5 : Waiting for the invisibility of calendar");
			IWaitStrategy.waitForInvisiblity(node, driver, ReportingBalanceSheetPO.searchByMonthCalendarPopup, 60);
			node.log(Status.INFO, "STEP6 : The calendar is not visible now");
			System.out.println("STEP6 : The calendar is not visible now");

			// Assert the calendar popup
			IElementActions.assertFalse_usingXpath(node, driver, ReportingBalanceSheetPO.searchByMonthCalendarPopup,
					"STEP7 : BUG : After clicking outside the Search by Month calendar Datepicker is not getting closed.",
					"STEP7 : PASS : After clicking outside the Search by Month calendar Datepicker is getting closed.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCalendarDatePickerClosedOnClickedOutside", "Pass",
					driver);

		} catch (AssertionError validateCalendarDatePickerClosedOnClickedOutside) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCalendarDatePickerClosedOnClickedOutside test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCalendarDatePickerClosedOnClickedOutside_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCalendarDatePickerClosedOnClickedOutside.printStackTrace();
			node.fail(validateCalendarDatePickerClosedOnClickedOutside);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCalendarDatePickerClosedOnClickedOutside) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCalendarDatePickerClosedOnClickedOutside test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCalendarDatePickerClosedOnClickedOutside_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCalendarDatePickerClosedOnClickedOutside.printStackTrace();
			node.fail(validateCalendarDatePickerClosedOnClickedOutside);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_085
	@Test(priority = 73)
	public void validateCustomSearchWithoutEndDate() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify when user is not able to search Balance sheet page details without selecting end date in custom search.")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			String year = Utils.getCurrectYear();
			String month = Utils.getCurrentMonth();
			String day = Utils.getTodayDayFormatted();

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Calling enterDate from Utils to select Custom Search Start Date From Calender
			Utils.enterDate(ReportingBalanceSheetPO.customSearchStartDateField, UtilsPO.calenderMonth, month,
					UtilsPO.calenderYear, year, UtilsPO.calenderDay, day);

			// Click on the Search Button
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.customSearchButton);
			node.log(Status.INFO, "STEP1 : The Clicked on Search Button");
			System.out.println("STEP1 : The Clicked on Search Button");

			// Wait for the visibility of the Custom Search Error Popup
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of Custom Search Error Popup");
			System.out.println("STEP2 : Waiting for the visibility of Custom Search Error Popup");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.customSearchErrorPopup);
			node.log(Status.INFO, "STEP3 : The Custom Search Error Popup is now visible");
			System.out.println("STEP3 : The Custom Search Error Popup is now visible");

			// Get the Text of Error Message
			String errorMessage = IElementActions.getElementText_usingXpath(node, driver,
					ReportingBalanceSheetPO.customSearchErrorMessage);

			// Check the visibility of Error Message
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.customSearchErrorMessage,
					"STEP4 : BUG:  When the user search the Balance Sheet Detail without Selecting End Date then "
							+ errorMessage + "error message is not visible",
					"STEP4 : EXPECTED:  When the user search the Balance Sheet Detail without Selecting End Date then "
							+ errorMessage + "error message is visible");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCustomSearchWithoutEndDate", "Pass", driver);

		} catch (AssertionError validateCustomSearchWithoutEndDate) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCustomSearchWithoutEndDate test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCustomSearchWithoutEndDate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCustomSearchWithoutEndDate.printStackTrace();
			node.fail(validateCustomSearchWithoutEndDate);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCustomSearchWithoutEndDate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCustomSearchWithoutEndDate test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCustomSearchWithoutEndDate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCustomSearchWithoutEndDate.printStackTrace();
			node.fail(validateCustomSearchWithoutEndDate);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_086
	@Test(priority = 74)
	public void validateCustomSearchWithoutStartDate() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify when user is not able to search Balance sheet page details without selecting end date in custom search.")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			String year = Utils.getCurrectYear();
			String month = Utils.getCurrentMonth();
			String day = Utils.getTodayDayFormatted();

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Calling enterDate from Utils to select Custom Search End Date From Calender
			Utils.enterDate(ReportingBalanceSheetPO.customSearchEndDateField, UtilsPO.calenderMonth, month,
					UtilsPO.calenderYear, year, UtilsPO.calenderDay, day);

			// Click on the Search Button
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.customSearchButton);
			node.log(Status.INFO, "STEP1 : The Clicked on Search Button");
			System.out.println("STEP1 : The Clicked on Search Button");

			// Wait for the visibility of the Custom Search Error Popup
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of Custom Search Error Popup");
			System.out.println("STEP2 : Waiting for the visibility of Custom Search Error Popup");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingBalanceSheetPO.customSearchErrorPopup);
			node.log(Status.INFO, "STEP3 : The Custom Search Error Popup is now visible");
			System.out.println("STEP3 : The Custom Search Error Popup is now visible");

			// Get the Text of Error Message
			String errorMessage = IElementActions.getElementText_usingXpath(node, driver,
					ReportingBalanceSheetPO.customSearchErrorMessage);

			// Check the visibility of Error Message
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.customSearchErrorMessage,
					"STEP4 : BUG:  When the user search the Balance Sheet Detail without Selecting Start Date then "
							+ errorMessage + "error message is not visible",
					"STEP4 : EXPECTED:  When the user search the Balance Sheet Detail without Selecting Start Date then "
							+ errorMessage + "error message is visible");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCustomSearchWithoutStartDate", "Pass", driver);

		} catch (AssertionError validateCustomSearchWithoutStartDate) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCustomSearchWithoutStartDate test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCustomSearchWithoutStartDate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCustomSearchWithoutStartDate.printStackTrace();
			node.fail(validateCustomSearchWithoutStartDate);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCustomSearchWithoutStartDate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCustomSearchWithoutStartDate test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCustomSearchWithoutStartDate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCustomSearchWithoutStartDate.printStackTrace();
			node.fail(validateCustomSearchWithoutStartDate);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_087
	@Test(priority = 75)
	public void validateLoanBalanceAmountsVisibility() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that user able to see Opening, Total In, Total Out and Closing Balance for Loan Balance section")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Waiting for the Page Loading To Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// create Dynamic Locator for Loan Balance Opening Amount
			String loanBalanceOpeningAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.loanBalanceAmount, "locatorValue", "Opening");

			// create Dynamic Locator for Loan Balance Closing Amount
			String loanBalanceClosingAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.loanBalanceAmount, "locatorValue", "Closing");

			// create Dynamic Locator for Loan Balance Total In Amount
			String loanBalanceTotalInAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.loanBalanceAmount, "locatorValue", "Total In");

			// create Dynamic Locator for Loan Balance Total Out Amount
			String loanBalanceTotalOutAmountLocator = IElementActions
					.createDynamicLocatorString(ReportingBalanceSheetPO.loanBalanceAmount, "locatorValue", "Total Out");

			// Check the visibility of Loan Balance Opening Amount
			IElementActions.assertTrue_usingXpath(node, driver, loanBalanceOpeningAmountLocator,
					"STEP1 : BUG: The Opening Amount is not coming in Loan Balance section",
					"STEP1 : EXPECTED: The Opening Amount is coming in Loan Balance section");

			// Check the visibility of Loan Balance Closing Amount
			IElementActions.assertTrue_usingXpath(node, driver, loanBalanceClosingAmountLocator,
					"STEP2 : BUG: The Closing Amount is not coming in Loan Balance section",
					"STEP2 : EXPECTED: The Closing Amount is coming in Loan Balance section");

			// Check the visibility of Loan Balance Total In Amount
			IElementActions.assertTrue_usingXpath(node, driver, loanBalanceTotalInAmountLocator,
					"STEP3 : BUG: The Total In Amount is not coming in Loan Balance section",
					"STEP3 : EXPECTED: The Total In Amount is coming in Loan Balance section");

			// Check the visibility of Loan Balance Total Out Amount
			IElementActions.assertTrue_usingXpath(node, driver, loanBalanceTotalOutAmountLocator,
					"STEP4 : BUG: The Total Out Amount is not coming in Loan Balance section",
					"STEP4 : EXPECTED: The Total Out Amount is coming in Loan Balance section");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanBalanceAmountsVisibility", "Pass", driver);

		} catch (AssertionError validateLoanBalanceAmountsVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanBalanceAmountsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanBalanceAmountsVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanBalanceAmountsVisibility.printStackTrace();
			node.fail(validateLoanBalanceAmountsVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanBalanceAmountsVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanBalanceAmountsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanBalanceAmountsVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanBalanceAmountsVisibility.printStackTrace();
			node.fail(validateLoanBalanceAmountsVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_099
	@Test(priority = 76)
	public void validateFacilitiesBalanceAmountsVisibility() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that user able to see Opening, Total In, Total Out and Closing Balance for Facilities Balance section.")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Balance Sheet Detail Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetDetail, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Detail");

			// Waiting for the Page Loading To Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// create Dynamic Locator for Facilities Balance Opening Amount
			String facilitiesBalanceOpeningAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.facilitiesBalanceAmount, "locatorValue", "Opening");

			// create Dynamic Locator for Facilities Balance Closing Amount
			String facilitiesBalanceClosingAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.facilitiesBalanceAmount, "locatorValue", "Closing");

			// create Dynamic Locator for Facilities Balance Total In Amount
			String facilitiesBalanceTotalInAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.facilitiesBalanceAmount, "locatorValue", "Total In");

			// create Dynamic Locator for Facilities Balance Total Out Amount
			String facilitiesBalanceTotalOutAmountLocator = IElementActions.createDynamicLocatorString(
					ReportingBalanceSheetPO.facilitiesBalanceAmount, "locatorValue", "Total Out");

			// Check the visibility of Facilities Balance Opening Amount
			IElementActions.assertTrue_usingXpath(node, driver, facilitiesBalanceOpeningAmountLocator,
					"STEP1 : BUG: The Opening Amount is not coming in Facilities Balance section",
					"STEP1 : EXPECTED: The Opening Amount is coming in Facilities Balance section");

			// Check the visibility of Facilities Balance Closing Amount
			IElementActions.assertTrue_usingXpath(node, driver, facilitiesBalanceClosingAmountLocator,
					"STEP2 : BUG: The Closing Amount is not coming in Facilities Balance section",
					"STEP2 : EXPECTED: The Closing Amount is coming in Facilities Balance section");

			// Check the visibility of Facilities Balance Total In Amount
			IElementActions.assertTrue_usingXpath(node, driver, facilitiesBalanceTotalInAmountLocator,
					"STEP3 : BUG: The Total In Amount is not coming in Facilities Balance section",
					"STEP3 : EXPECTED: The Total In Amount is coming in Facilities Balance section");

			// Check the visibility of Facilities Balance Total Out Amount
			IElementActions.assertTrue_usingXpath(node, driver, facilitiesBalanceTotalOutAmountLocator,
					"STEP4 : BUG: The Total Out Amount is not coming in Facilities Balance section",
					"STEP4 : EXPECTED: The Total Out Amount is coming in Facilities Balance section");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilitiesBalanceAmountsVisibility", "Pass", driver);

		} catch (AssertionError validateFacilitiesBalanceAmountsVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilitiesBalanceAmountsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilitiesBalanceAmountsVisibilityvalidateFacilitiesBalanceSectionAmountsVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilitiesBalanceAmountsVisibility.printStackTrace();
			node.fail(validateFacilitiesBalanceAmountsVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilitiesBalanceAmountsVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilitiesBalanceAmountsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilitiesBalanceAmountsVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilitiesBalanceAmountsVisibility.printStackTrace();
			node.fail(validateFacilitiesBalanceAmountsVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_102
	@Test(priority = 77)
	public void validateCashBalanceSectionsVisibility() throws IOException {
		try {
			extenttest = extent
					.createTest(
							"Verify if the user is able to view the Cash Balance tab with the following sections i.e."
									+ "-Funding Account" + "-Loan Account" + "-Current Cash Amount" + "-All"
									+ "-Payments" + "-Receipts" + "-Cash Balance table")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Cash Balance Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.cashBalance, ReportingBalanceSheetPO.balanceSheetHeader,
					"Cash Balance");

			// Verify the section in Cash Balance Page
			node.log(Status.INFO, "STEP1 : Verify the sections in the Cash Balance Page");
			System.out.println("STEP1 : Verify the sections in the Cash Balance Page");

			// Check the visibility of Funding Account Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.fundingAccountSection,
					"STEP2 : BUG : The Funding Account Section is not coming On Cash Balance Page",
					"STEP2 : EXPECTED : The Funding Account Section is coming On Cash Balance Page");

			// Check the visibility of Loan Account Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.loanAccountSection,
					"STEP3 : BUG : The Loan Account Section is not coming On Cash Balance Page",
					"STEP3 : EXPECTED : The Loan Account Section is coming On Cash Balance Page");

			// Check the visibility of Current Cash Amount Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.currentCashAmountSection,
					"STEP4 : BUG : The Current Cash Amount Section is not coming On Cash Balance Page",
					"STEP4 : EXPECTED : The Current Cash Amount Section is coming On Cash Balance Page");

			// Check the visibility of All Button Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.allButton,
					"STEP5 : BUG : The All Button Section is not coming On Cash Balance Page",
					"STEP5 : EXPECTED : The All Button Section is coming On Cash Balance Page");

			// Check the visibility of Payments Button Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.paymentsButton,
					"STEP6 : BUG : The Payments Button Section is not coming On Cash Balance Page",
					"STEP6 : EXPECTED : The Payments Button Section is coming On Cash Balance Page");

			// Check the visibility of Receipts Button Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.receiptsButton,
					"STEP7 : BUG : The Receipts Button Section is not coming On Cash Balance Page",
					"STEP7 : EXPECTED : The Receipts Button Section is coming On Cash Balance Page");

			// Check the visibility of Cash Balance Table
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.cashBalanceTable,
					"STEP8 : BUG : The Cash Balance Table is not coming On Cash Balance Page",
					"STEP8 : EXPECTED : The Cash Balance Table is coming On Cash Balance Page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashBalanceSectionsVisibility", "Pass", driver);

		} catch (AssertionError validateCashBalanceSectionsVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashBalanceSectionsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceSectionsVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceSectionsVisibility.printStackTrace();
			node.fail(validateCashBalanceSectionsVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCashBalanceSectionsVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashBalanceSectionsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceSectionsVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceSectionsVisibility.printStackTrace();
			node.fail(validateCashBalanceSectionsVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_105
	@Test(priority = 78)
	public void validateCurrentCashAmount() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the Current Cash Amount is equal to the difference between the Funding Account Amount and the Loan Account Amount")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Cash Balance Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.cashBalance, ReportingBalanceSheetPO.balanceSheetHeader,
					"Cash Balance");

			// Wait for the Page Loading To Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Getting value of the Funding Account Amount
			int fundingAccountAmount = Utils.getTextAndParseToInt(ReportingBalanceSheetPO.fundingAccountAmount);

			// Getting value of the Loan Account Amount
			int loanAccountAmount = Utils.getTextAndParseToInt(ReportingBalanceSheetPO.loanAccountAmount);

			// Getting value of the Current Cash Amount
			int actualCurrentCashAmount = Utils.getTextAndParseToInt(ReportingBalanceSheetPO.currentCashAmount);

			// Calling the calculateDifference from Utils and perform the Substraction
			int expectedCurrentCashAmount = Utils.calculateDifference(fundingAccountAmount, loanAccountAmount);

			// Assert that Current Cash Amount is equal to the calculated
			// difference between the Funding Account Amount and the Loan Account Amount
			IElementActions.assertEquals_usingInteger(node, driver, actualCurrentCashAmount, expectedCurrentCashAmount,
					"STEP1 : BUG : The Current Cash Amount " + actualCurrentCashAmount
							+ " is not equal to the calculated difference between the Funding Account Amount and the Loan Account Amount :"
							+ expectedCurrentCashAmount,
					"STEP1 : PASS : The Current Cash Amount " + actualCurrentCashAmount
							+ " is equal to the calculated difference between the Funding Account Amount and the Loan Account Amount : "
							+ expectedCurrentCashAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCurrentCashAmount", "Pass", driver);

		} catch (AssertionError validateCurrentCashAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCurrentCashAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCurrentCashAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCurrentCashAmount.printStackTrace();
			node.fail(validateCurrentCashAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCurrentCashAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCurrentCashAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCurrentCashAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCurrentCashAmount.printStackTrace();
			node.fail(validateCurrentCashAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_106
	@Test(priority = 79)
	public void validateCashBalanceTableColumnsVisibility() throws IOException {
		try {
			extenttest = extent
					.createTest(
							"Verify if the user is able to view the Cash Balance table with the following columns i.e."
									+ "-Date" + "-Internal Referance" + "-Referance" + "-Transaction" + "-Payments"
									+ "-Receipts" + "-Cash Balance")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Cash Balance Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.cashBalance, ReportingBalanceSheetPO.balanceSheetHeader,
					"Cash Balance");

			// Verify the section in Cash Balance Table columns
			node.log(Status.INFO, "STEP1 : Verify the Cash Balance Table columns");
			System.out.println("STEP1 : Verify the Cash Balance Table columns");

			// Check the visibility of Date Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.dateColumn,
					"STEP2 : BUG : The Date column is not coming in Cash Balance Table",
					"STEP2 : EXPECTED : The Date column is coming in Cash Balance Table");

			// Check the visibility of Internal Reference Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.internalReferenceColumn,
					"STEP3 : BUG : The Internal Reference column is not coming in Cash Balance Table",
					"STEP3 : EXPECTED : The Internal Reference column is coming in Cash Balance Table");

			// Check the visibility of Reference Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.referenceColumns,
					"STEP4 : BUG : The Reference column is not coming in Cash Balance Table",
					"STEP4 : EXPECTED : The Reference column is coming in Cash Balance Table");

			// Check the visibility of Transaction Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.transactionColumn,
					"STEP5 : BUG : The Transaction column is not coming in Cash Balance Table",
					"STEP5 : EXPECTED : The Transaction column is coming in Cash Balance Table");

			// Check the visibility of Payments Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.paymentsColumn,
					"STEP6 : BUG : The Payments column is not coming in Cash Balance Table",
					"STEP6 : EXPECTED : The Payments column is coming in Cash Balance Table");

			// Check the visibility of Receipts Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.receiptsColumn,
					"STEP7 : BUG : The Receipts column is not coming in Cash Balance Table",
					"STEP7 : EXPECTED : The Receipts column is coming in Cash Balance Table");

			// Check the visibility of Cash Balance Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.cashBalanceColumn,
					"STEP8 : BUG : The Cash Balance column is not coming in Cash Balance Table",
					"STEP8 : EXPECTED : The Cash Balance column is coming in Cash Balance Table");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashBalanceTableColumnsVisibility", "Pass", driver);

		} catch (AssertionError validateCashBalanceTableColumnsVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashBalanceTableColumnsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceTableColumnsVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceTableColumnsVisibility.printStackTrace();
			node.fail(validateCashBalanceTableColumnsVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCashBalanceTableColumnsVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashBalanceTableColumnsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceTableColumnsVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceTableColumnsVisibility.printStackTrace();
			node.fail(validateCashBalanceTableColumnsVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_116
	@Test(priority = 80)
	public void validateCashBalanceColumn() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the Cash Balance is displayed under the 'Cash Balance' column for the respective payments")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Cash Balance Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.cashBalance, ReportingBalanceSheetPO.balanceSheetHeader,
					"Cash Balance");

			// Check the visibility of Cash Balance Values
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.cashBalanceColumnValues,
					"STEP1 : BUG : The Cash Balance is not displayed under the 'Cash Balance' column for the respective payments.",
					"STEP1 : EXPECTED : The Cash Balance is displayed under the 'Cash Balance' column for the respective payments.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashBalanceColumn", "Pass", driver);

		} catch (AssertionError validateCashBalanceColumn) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashBalanceColumn test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCashBalanceColumn_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceColumn.printStackTrace();
			node.fail(validateCashBalanceColumn);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCashBalanceColumn) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashBalanceColumn test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCashBalanceColumn_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceColumn.printStackTrace();
			node.fail(validateCashBalanceColumn);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_117
	@Test(priority = 81)
	public void validatePaymentAndReceiptColumns() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that when the user selects 'ALL,' both payment and receipt entries are displayed in the table")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Cash Balance Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.cashBalance, ReportingBalanceSheetPO.balanceSheetHeader,
					"Cash Balance");

			// Click on the All Button
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.allButton);
			node.log(Status.INFO, "STEP1 : Clicked on All Button");
			System.out.println("STEP1 : Clicked on All Button");

			// Check the visibility of Payments column Values
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.paymentsColumnValues,
					"STEP2 : BUG : Selecting the 'All' then Payment entries are not displayed in the table ",
					"STEP2 : EXPECTED : Selecting the 'All' then Payment entries are displayed in the table");

			// Check the visibility of Receipts column Values
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.receiptsColumnValues,
					"STEP3 : BUG : Selecting the 'All' then Receipts entries are not displayed in the table",
					"STEP3 : EXPECTED : Selecting the 'All' then Receipts entries are displayed in the table");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validatePaymentAndReceiptColumns", "Pass", driver);

		} catch (AssertionError validatePaymentAndReceiptColumns) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePaymentAndReceiptColumns test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePaymentAndReceiptColumns_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePaymentAndReceiptColumns.printStackTrace();
			node.fail(validatePaymentAndReceiptColumns);
			Assert.fail();
			extent.flush();

		} catch (Exception validatePaymentAndReceiptColumns) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePaymentAndReceiptColumns test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePaymentAndReceiptColumns_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePaymentAndReceiptColumns.printStackTrace();
			node.fail(validatePaymentAndReceiptColumns);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_121
	// TC_Reporting_BalanceSheet_122
	@Test(priority = 82)
	public void validateCashBalanceForReceipt() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that when a user performs receipt transactions, the cash balance increases")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Cash Balance Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.cashBalance, ReportingBalanceSheetPO.balanceSheetHeader,
					"Cash Balance");

			// Get Cash Balance Column First Amount
			int firstCashBalanceAmount = Utils
					.getTextAndParseToInt(ReportingBalanceSheetPO.cashBalanceColumnFirstValue);
			System.out.println("firstCashBalanceAmount " + firstCashBalanceAmount);

			// Get amount
			String newLoanFacilityAmount = getDataFromExcel(58);

			// Get drawdown amount
			String drawdownAmount = getDataFromExcel(59);

			// Get today's date
			String todayDate = Utils.getTodayDayFormatted();

			// Get yesterday's date
			// String yesterdayDate = Utils.getYesterdayDayFormatted();

			// Calling the loadNewFacilityPage from FacilityePage
			FundingPage.loadNewFacilityPage();

			// Create a facility
			FundingPage.createFacility(newLoanFacilityAmount);

			// Go to the facility status page and add drawdowns
			FundingPage.goToFacilityStatusAndAddDrawdown(drawdownAmount, todayDate);

			IElementActions.scrollToTop(driver);

			// Wait for the visibility of confirm icon
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of confirm icon");
			System.out.println("STEP1 : Waiting for the visibility of confirm icon");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.confirmIcon);
			IWaitStrategy.WaitUntilElementClickable(node, driver, FundingNewFacilityPO.confirmIcon);
			node.log(Status.INFO, "STEP2 : Confirm icon is visible");
			System.out.println("STEP2 : Confirm icon is visible");

			// Click on the confirm button and wait for popup
			Utils.clickAndWait(FundingNewFacilityPO.confirmIcon, "Confirm Button", UtilsPO.popUp);

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

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Enter current date in custom search
			ReportingPage.enterDateInCustomFieldAndSearch();

			// Click on Cash Balance Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.cashBalance, ReportingBalanceSheetPO.balanceSheetHeader,
					"Cash Balance");

			// Get Cash Balance Column First Amount
			int cashBalanceAmountAfterReceipt = Utils
					.getTextAndParseToInt(ReportingBalanceSheetPO.cashBalanceColumnFirstValue);

			int cashDifference = Utils.calculateDifference(cashBalanceAmountAfterReceipt, firstCashBalanceAmount);

			int drawdownValue = Integer.parseInt(drawdownAmount);

			// Assert the Cash Balance Amount
			IElementActions.assertEquals_usingInteger(node, driver, cashDifference, drawdownValue,
					"STEP9 : BUG : The previous cash Balance is " + firstCashBalanceAmount
							+ " and the increased after receipt type payment i.e drawdown of " + drawdownValue
							+ " is not equal to expected increased cash value is " + cashBalanceAmountAfterReceipt,
					"STEP9 : PASS : The previous cash Balance is " + firstCashBalanceAmount
							+ " and is increased after receipt type payment i.e drawdown of " + drawdownValue
							+ " and expected increased cash value is " + cashBalanceAmountAfterReceipt);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashBalanceForReceipt", "Pass", driver);

		} catch (AssertionError validateCashBalanceForReceipt) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashBalanceForReceipt test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceForReceipt_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceForReceipt.printStackTrace();
			node.fail(validateCashBalanceForReceipt);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCashBalanceForReceipt) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashBalanceForReceipt test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceForReceipt_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceForReceipt.printStackTrace();
			node.fail(validateCashBalanceForReceipt);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_120
	@Test(priority = 83)
	public void validateCashBalanceForPayments() throws IOException {
		try {
			extenttest = extent.createTest("Verify that when a user performs payments, the cash balance decreases")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Cash Balance Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.cashBalance, ReportingBalanceSheetPO.balanceSheetHeader,
					"Cash Balance");

			// Get Cash Balance Column First Amount
			int firstCashBalanceAmount = Utils
					.getTextAndParseToInt(ReportingBalanceSheetPO.cashBalanceColumnFirstValue);

			// Get facility reference
			String facilityReference = getDataFromExcel(60);

			// Get repayment amount
			String repaymentAmount = getDataFromExcel(61);

			// Get today's date
			String todayDate = Utils.getTodayDayFormatted();

			// Call the loadDatabasePage function from the FundingPage
			FundingPage.loadDatabasePage();

			// Search record based on the provide loan reference and open it
			Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, FundingNewFacilityPO.reference,
					facilityReference, UtilsPO.editIcon, FundingNewFacilityPO.editLoanFacilityText);

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.facilityStatusTab, FundingNewFacilityPO.drawdownsSection,
					"Facility Status");

			// Add repayments
			FundingPage.addRepayment(repaymentAmount, todayDate);

			String effectivedDateExpected = FundingPage.confirmRepayment(FundingNewFacilityPO.confirmIconRepayment,
					"today");

			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingNewFacilityPO.repaymentAmountCloumn);

			// Wait for the visibility of first row
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of first row");
			System.out.println("STEP1 : Waiting for the visibility of first row");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.firstRowRepayment);
			node.log(Status.INFO, "STEP2 : First row is visible");
			System.out.println("STEP2 : First row is visible");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Cash Balance Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.cashBalance, ReportingBalanceSheetPO.balanceSheetHeader,
					"Cash Balance");

			// Get Cash Balance Column First Amount
			int cashBalanceAmountAfterPayment = Utils
					.getTextAndParseToInt(ReportingBalanceSheetPO.cashBalanceColumnFirstValue);

			int cashDifference = Utils.calculateDifference(firstCashBalanceAmount, cashBalanceAmountAfterPayment);

			int repaymentValue = Integer.parseInt(repaymentAmount);

			// Assert the Cash Balance Amount
			IElementActions.assertEquals_usingInteger(node, driver, cashDifference, repaymentValue,
					"STEP3 : BUG : The previous cash Balance is " + firstCashBalanceAmount
							+ " and is decreased after payment i.e repayment of " + repaymentValue
							+ " is not equal to expected decreased cash value is " + cashBalanceAmountAfterPayment,
					"STEP3 : PASS : The previous cash Balance is " + firstCashBalanceAmount
							+ " and is decreased after the payment i.e repayment of " + repaymentValue
							+ " and expected decreased cash value is " + cashBalanceAmountAfterPayment);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashBalanceForReceipt", "Pass", driver);

		} catch (AssertionError validateCashBalanceForPayments) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashBalanceForPayments test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceForPayments_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceForPayments.printStackTrace();
			node.fail(validateCashBalanceForPayments);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCashBalanceForPayments) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashBalanceForPayments test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceForPayments_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceForPayments.printStackTrace();
			node.fail(validateCashBalanceForPayments);
			Assert.fail();
			extent.flush();
		}
	}

	// Test Case Sheet Line no 290 Test Case
	@Test(priority = 84)
	public void validateSortingOfCashBalanceTable() throws IOException {
		try {
			extenttest = extent
					.createTest(
							"Verify that the default sort order for the table is in reverse chronological date order")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Cash Balance Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.cashBalance, ReportingBalanceSheetPO.balanceSheetHeader,
					"Cash Balance");

			// Check the descending order for date column
			Utils.validateDateSorting(node, driver, ReportingBalanceSheetPO.dateColumnValues, "descending",
					"validateSortingOfCashBalanceTable", "dd-MM-yyyy", "LocalDate");

		} catch (AssertionError validateSortingOfCashBalanceTable) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateSortingOfCashBalanceTable test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateSortingOfCashBalanceTable_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSortingOfCashBalanceTable.printStackTrace();
			node.fail(validateSortingOfCashBalanceTable);
			Assert.fail();
			extent.flush();

		} catch (Exception validateSortingOfCashBalanceTable) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateSortingOfCashBalanceTable test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateSortingOfCashBalanceTable_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSortingOfCashBalanceTable.printStackTrace();
			node.fail(validateSortingOfCashBalanceTable);
			Assert.fail();
			extent.flush();
		}
	}

	// Test Case Sheet Line no 291 Test Case
	@Test(priority = 85)
	public void validateCashBalanceValueInTopRowOfCashBalanceTable() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that for 'All', the Cash Balance value in the top row of the table is equal to the Cash Amount in Balance Sheet Summary, with the correct custom search date selected")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Cash Balance Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.cashBalance, ReportingBalanceSheetPO.balanceSheetHeader,
					"Cash Balance");

			// Click on the All Button
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.allButton);
			node.log(Status.INFO, "STEP1 : Clicked on All Button");
			System.out.println("STEP1 : Clicked on All Button");

			// Get the Date column First Date
			String date = IElementActions.getElementText_usingXpath(node, driver,
					ReportingBalanceSheetPO.dateColumnFirstValue);
			node.log(Status.INFO, "STEP2 : First Date in Cash Balance Table : " + date);
			System.out.println("STEP2 : First Date in Cash Balance Table : " + date);

			// Get Cash Balance Column First Amount
			int firstCashBalanceAmount = Utils
					.getTextAndParseToInt(ReportingBalanceSheetPO.cashBalanceColumnFirstValue);

			// Click on Balance Sheet Summary Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetSummary, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Summary");

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Wait for the custom search to be visible and clickable
			node.log(Status.INFO, "STEP3 : Waiting for the custom search to be visible and clickable");
			System.out.println("STEP3 : Waiting for the custom search to be visible and clickable");
			IWaitStrategy.waitForVisiblityDynamic(node, driver, ReportingBalanceSheetPO.customSearchInputField, 150);
			IWaitStrategy.WaitUntilElementClickable(node, driver, ReportingBalanceSheetPO.customSearchInputField);
			node.log(Status.INFO, "STEP4 : Custom search is visible and clickable");
			System.out.println("STEP4 : Custom search is visible and clickable");

			// Or if using the array version
			String[] dateParts = Utils.extractDateParts(date);

			Thread.sleep(1000);
			// Calling enterDate from Utils to select Date From Calendar
			Utils.enterDate(ReportingBalanceSheetPO.customSearchField, UtilsPO.calenderMonth, dateParts[1],
					UtilsPO.calenderYear, dateParts[2], UtilsPO.calenderDay, dateParts[0]);

			// Click on the Custom Search Button
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.customSearchButton);
			node.log(Status.INFO, "STEP5 : The Clicked on the Custom Search Button.");
			System.out.println("STEP5 : The Clicked on the Custom Search Button.");

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Getting value of the Cash Amount
			int cashAmount = Utils.getTextAndParseToInt(ReportingBalanceSheetPO.cashAmountValue);

			// Assert the Cash Balance Amount
			IElementActions.assertEquals_usingInteger(node, driver, firstCashBalanceAmount, cashAmount,
					"STEP6 : BUG : The Cash Balance for the top row in Cash Balance tab " + firstCashBalanceAmount
							+ " is not equal to the Cash Amount in Balance Sheet Summary " + cashAmount,
					"STEP6 : PASS : The Cash Balance for the top row in Cash Balance tab " + firstCashBalanceAmount
							+ "  is equal to the Cash Amount in Balance Sheet Summary " + cashAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashBalanceValueInTopRowOfCashBalanceTable", "Pass",
					driver);

		} catch (AssertionError validateCashBalanceValueInTopRowOfCashBalanceTable) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashBalanceValueInTopRowOfCashBalanceTable test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceValueInTopRowOfCashBalanceTable_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceValueInTopRowOfCashBalanceTable.printStackTrace();
			node.fail(validateCashBalanceValueInTopRowOfCashBalanceTable);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCashBalanceValueInTopRowOfCashBalanceTable) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashBalanceValueInTopRowOfCashBalanceTable test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashBalanceValueInTopRowOfCashBalanceTable_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashBalanceValueInTopRowOfCashBalanceTable.printStackTrace();
			node.fail(validateCashBalanceValueInTopRowOfCashBalanceTable);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_129
	@Test(priority = 86)
	public void validateLoanAccountSectionsVisibility() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify if the user is able to view the Loan Account atb with following sections i.e."
							+ "-Total Loan Disbursements" + "-Total Loan Repayments" + "-Current Loan Balance" + "-All"
							+ "-Payments" + "-Receipts" + "-Cash Balance table")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Loan Account Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.loanAccount, ReportingBalanceSheetPO.balanceSheetHeader,
					"Loan Account");

			// Verify the section in Loan Account Page
			node.log(Status.INFO, "STEP1 : Verify the sections in the Loan Account Page");
			System.out.println("STEP1 : Verify the sections in the Loan Account Page");

			// Check the visibility of Total Loan Disbursements Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.totalLoanDisbursementsSection,
					"STEP2 : BUG : Total Loan Disbursements Section is not coming On Loan Account Page",
					"STEP2 : EXPECTED : Total Loan Disbursements Section is coming On Loan Account Page");

			// Check the visibility of Total Loan Repayments Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.totalLoanRepaymentsSection,
					"STEP3 : BUG : Total Loan Repayments Section is not coming On Loan Account Page",
					"STEP3 : EXPECTED : Total Loan Repayments Section is coming On Loan Account Page");

			// Check the visibility of Current Loan Balance Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.currentLoanBalanceSection,
					"STEP4 : BUG : The Current Loan Balance Section is not coming On Loan Account Page",
					"STEP4 : EXPECTED : The Current Loan Balance Section is coming On Loan Account Page");

			// Check the visibility of All Button Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.allButton,
					"STEP5 : BUG : The All Button Section is not coming On Loan Account Page",
					"STEP5 : EXPECTED : The All Button Section is coming On Loan Account Page");

			// Check the visibility of Payments Button Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.paymentsButton,
					"STEP6 : BUG : The Payments Button Section is not coming On Loan Account Page",
					"STEP6 : EXPECTED : The Payments Button Section is coming On Loan Account Page");

			// Check the visibility of Receipts Button Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.receiptsButton,
					"STEP7 : BUG : The Receipts Button Section is not coming On Loan Account Page",
					"STEP7 : EXPECTED : The Receipts Button Section is coming On Loan Account Page");

			// Check the visibility of Cash Balance Table
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.cashBalanceTable,
					"STEP8 : BUG : The Cash Balance Table is not coming On Loan Account Page",
					"STEP8 : EXPECTED : The Cash Balance Table is coming On Loan Account Page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanAccountSectionsVisibility", "Pass", driver);

		} catch (AssertionError validateLoanAccountSectionsVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanAccountSectionsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanAccountSectionsVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanAccountSectionsVisibility.printStackTrace();
			node.fail(validateLoanAccountSectionsVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanAccountSectionsVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanAccountSectionsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanAccountSectionsVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanAccountSectionsVisibility.printStackTrace();
			node.fail(validateLoanAccountSectionsVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_130
	@Test(priority = 87)
	public void validateCurrentLoanBalance() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that Current Loan Balance is equal to the difference between the Total Loan Disbursements and Total Loan Repayments")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Loan Account Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.loanAccount, ReportingBalanceSheetPO.balanceSheetHeader,
					"Loan Account");

			// Wait for the Page Loading To Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Getting value of the Total Loan Disbursements Amount
			int totalLoanDisbursementsAmount = Utils
					.getTextAndParseToInt(ReportingBalanceSheetPO.totalLoanDisbursementsAmount);

			// Getting value of the Total Loan Repayments Amount
			int totalLoanRepaymentsAmount = Utils
					.getTextAndParseToInt(ReportingBalanceSheetPO.totalLoanRepaymentsAmount);

			// Getting value of the Current Loan Balance Amount
			int actualCurrentLoanBalanceAmount = Utils
					.getTextAndParseToInt(ReportingBalanceSheetPO.currentLoanBalanceAmount);

			// Calling the calculateDifference from Utils and perform the Substraction
			int expectedCurrentLoanBalanceAmount = Utils.calculateDifference(totalLoanDisbursementsAmount,
					totalLoanRepaymentsAmount);

			// Assert that The Current Loan Balance is exactly equal to the
			// calculated difference between the Total Loan Disbursements and Total Loan
			// Repayments
			IElementActions.assertEquals_usingInteger(node, driver, actualCurrentLoanBalanceAmount,
					expectedCurrentLoanBalanceAmount,
					"STEP1 : BUG : The Current Loan Balance Amount " + actualCurrentLoanBalanceAmount
							+ " is not equal to the calculated difference between the Total Loan Disbursements Amount and Total Loan Repayments Amount :"
							+ expectedCurrentLoanBalanceAmount,
					"STEP1 : PASS : The Current Loan Balance Amount " + actualCurrentLoanBalanceAmount
							+ " is equal to the calculated difference between the Total Loan Disbursements Amount and Total Loan Repayments Amount : "
							+ expectedCurrentLoanBalanceAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCurrentLoanBalance", "Pass", driver);

		} catch (AssertionError validateCurrentLoanBalance) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCurrentLoanBalance test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCurrentLoanBalance_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCurrentLoanBalance.printStackTrace();
			node.fail(validateCurrentLoanBalance);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCurrentLoanBalance) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCurrentLoanBalance test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCurrentLoanBalance_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCurrentLoanBalance.printStackTrace();
			node.fail(validateCurrentLoanBalance);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_133
	@Test(priority = 88)
	public void validateLoanAccountTabTableColumns() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify if the user is able to view the Cash Balance table with the columns i.e."
							+ "-Action" + "-Date" + "-Internal Referance" + "-Referance" + "-Transaction"
							+ "-Disbursement" + "-Repayments" + "-Loan Balance")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Loan Account Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.loanAccount, ReportingBalanceSheetPO.balanceSheetHeader,
					"Loan Account");

			// Verify the section in Cash Balance Table columns
			node.log(Status.INFO, "STEP1 : Verify the Cash Balance Table columns");
			System.out.println("STEP1 : Verify the Cash Balance Table columns");

			// Check the visibility of Action Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.actionColumnHeader,
					"STEP2 : BUG : The Action column is not coming in Cash Balance Table",
					"STEP2 : EXPECTED : The Action column is coming in Cash Balance Table");

			// Check the visibility of Date Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.dateColumn,
					"STEP3 : BUG : The Date column is not coming in Cash Balance Table",
					"STEP3 : EXPECTED : The Date column is coming in Cash Balance Table");

			// Check the visibility of Internal Reference Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.internalReferenceColumn,
					"STEP4 : BUG : The Internal Reference column is not coming in Cash Balance Table",
					"STEP4 : EXPECTED : The Internal Reference column is coming in Cash Balance Table");

			// Check the visibility of Reference Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.referenceColumns,
					"STEP5 : BUG : The Reference column is not coming in Cash Balance Table",
					"STEP5 : EXPECTED : The Reference column is coming in Cash Balance Table");

			// Check the visibility of Transaction Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.transactionColumn,
					"STEP6 : BUG : The Transaction column is not coming in Cash Balance Table",
					"STEP6 : EXPECTED : The Transaction column is coming in Cash Balance Table");

			// Check the visibility of Disbursements Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.disbursementsColumnHeader,
					"STEP7 : BUG : The Disbursements column is not coming in Cash Balance Table",
					"STEP7 : EXPECTED : The Disbursements column is coming in Cash Balance Table");

			// Check the visibility of Repayments Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.repaymentsColumnHeader,
					"STEP8 : BUG : The Repayments column is not coming in Cash Balance Table",
					"STEP8 : EXPECTED : The Repayments column is coming in Cash Balance Table");

			// Check the visibility of Loan Balance Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.loanBalanceColumnHeader,
					"STEP9 : BUG : The Loan Balance column is not coming in Cash Balance Table",
					"STEP9 : EXPECTED : The Loan Balance column is coming in Cash Balance Table");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanAccountTabTableColumns", "Pass", driver);

		} catch (AssertionError validateLoanAccountTabTableColumns) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanAccountTabTableColumns test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanAccountTabTableColumns_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanAccountTabTableColumns.printStackTrace();
			node.fail(validateLoanAccountTabTableColumns);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanAccountTabTableColumns) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanAccountTabTableColumns test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanAccountTabTableColumns_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanAccountTabTableColumns.printStackTrace();
			node.fail(validateLoanAccountTabTableColumns);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_137
	@Test(priority = 89)
	public void validateDefaultSortOrderOfCashBalanceTable() throws IOException {
		try {
			extenttest = extent
					.createTest(
							"Verify that the default sort order for the table is in reverse chronological date order")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Loan Account Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.loanAccount, ReportingBalanceSheetPO.balanceSheetHeader,
					"Loan Account");

			// Check the descending order for date column
			Utils.validateDateSorting(node, driver, ReportingBalanceSheetPO.dateColumnInLoanAccount, "descending",
					"validateDefaultSortOrderOfCashBalanceTable", "dd-MM-yyyy", "LocalDate");

		} catch (AssertionError validateDefaultSortOrderOfCashBalanceTable) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDefaultSortOrderOfCashBalanceTable test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDefaultSortOrderOfCashBalanceTable_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDefaultSortOrderOfCashBalanceTable.printStackTrace();
			node.fail(validateDefaultSortOrderOfCashBalanceTable);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDefaultSortOrderOfCashBalanceTable) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDefaultSortOrderOfCashBalanceTable test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDefaultSortOrderOfCashBalanceTable_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDefaultSortOrderOfCashBalanceTable.printStackTrace();
			node.fail(validateDefaultSortOrderOfCashBalanceTable);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_143
	@Test(priority = 90)
	public void validateLoanBalanceAmount() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the Loan Balance amount is displayed under the 'Loan Balance' column")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Loan Account Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.loanAccount, ReportingBalanceSheetPO.balanceSheetHeader,
					"Loan Account");

			// Check the visibility of Loan Balance Amount
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.loanBalanceColumnValues,
					"STEP1 : BUG : The Loan Balance Amounts are not coming under the Loan Balance column in Cash Balance Table",
					"STEP1 : EXPECTED : The Loan Balance Amounts are coming under the Loan Balance column in Cash Balance Table");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanBalanceAmount", "Pass", driver);

		} catch (AssertionError validateLoanBalanceAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanBalanceAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanBalanceAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanBalanceAmount.printStackTrace();
			node.fail(validateLoanBalanceAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanBalanceAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanBalanceAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanBalanceAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanBalanceAmount.printStackTrace();
			node.fail(validateLoanBalanceAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// Test Case sheet line no 321 Test Case
	@Test(priority = 91)
	public void validateLoanBalanceValueInTopRowOfCashBalanceTable() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that for 'All', the Loan Balance value in the top row of the table is equal to the Loan Amount in Balance Sheet Summary, with the correct custom search date selected")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Loan Account Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.loanAccount, ReportingBalanceSheetPO.balanceSheetHeader,
					"Loan Account");

			// Click on the All Button
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.allButton);
			node.log(Status.INFO, "STEP1 : Clicked on All Button");
			System.out.println("STEP1 : Clicked on All Button");

			// Get the Date column First Date
			String date = IElementActions.getElementText_usingXpath(node, driver,
					ReportingBalanceSheetPO.dateColumnFirstDate);
			node.log(Status.INFO, "STEP2 : First Date in Cash Balance Table : " + date);
			System.out.println("STEP2 : First Date in Cash Balance Table : " + date);

			// Get Loan Balance Column First Amount
			int firstLoanBalanceAmount = Utils.getTextAndParseToInt(ReportingBalanceSheetPO.loanBalanceFirstAmount);

			// Click on Balance Sheet Summary Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetSummary, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Summary");

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Wait for the custom search to be visible and clickable
			node.log(Status.INFO, "STEP3 : Waiting for the custom search to be visible and clickable");
			System.out.println("STEP3 : Waiting for the custom search to be visible and clickable");
			IWaitStrategy.waitForVisiblityDynamic(node, driver, ReportingBalanceSheetPO.customSearchInputField, 150);
			IWaitStrategy.WaitUntilElementClickable(node, driver, ReportingBalanceSheetPO.customSearchInputField);
			node.log(Status.INFO, "STEP4 : Custom search is visible and clickable");
			System.out.println("STEP4 : Custom search is visible and clickable");

			// Or if using the array version
			String[] dateParts = Utils.extractDateParts(date);

			Thread.sleep(1000);
			// Calling enterDate from Utils to select Date From Calendar
			Utils.enterDate(ReportingBalanceSheetPO.customSearchField, UtilsPO.calenderMonth, dateParts[1],
					UtilsPO.calenderYear, dateParts[2], UtilsPO.calenderDay, dateParts[0]);

			// Click on the Custom Search Button
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.customSearchButton);
			node.log(Status.INFO, "STEP5 : The Clicked on the Custom Search Button.");
			System.out.println("STEP5 : The Clicked on the Custom Search Button.");

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Getting value of the Loan Amount
			int loanAmount = Utils.getTextAndParseToInt(ReportingBalanceSheetPO.loanAmountValue);

			// Assert the Loan Balance Amount
			IElementActions.assertEquals_usingInteger(node, driver, firstLoanBalanceAmount, loanAmount,
					"STEP6 : BUG : The Loan Balance Amount for the top row in Cash Balance tab "
							+ firstLoanBalanceAmount + " is not equal to the Loan Amount in Balance Sheet Summary "
							+ loanAmount,
					"STEP6 : PASS :The Loan Balance Amount for the top row in Cash Balance tab "
							+ firstLoanBalanceAmount + " is equal to the Loan Amount in Balance Sheet Summary "
							+ loanAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanBalanceValueInTopRowOfCashBalanceTable", "Pass",
					driver);

		} catch (AssertionError validateLoanBalanceValueInTopRowOfCashBalanceTable) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanBalanceValueInTopRowOfCashBalanceTable test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanBalanceValueInTopRowOfCashBalanceTable_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanBalanceValueInTopRowOfCashBalanceTable.printStackTrace();
			node.fail(validateLoanBalanceValueInTopRowOfCashBalanceTable);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanBalanceValueInTopRowOfCashBalanceTable) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanBalanceValueInTopRowOfCashBalanceTable test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanBalanceValueInTopRowOfCashBalanceTable_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanBalanceValueInTopRowOfCashBalanceTable.printStackTrace();
			node.fail(validateLoanBalanceValueInTopRowOfCashBalanceTable);

			Assert.fail();
			extent.flush();
		}
	}

	// Test Case Sheet Line no 324 Test Case
	@Test(priority = 92)
	public void validateFundingAccountSectionsVisibility() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify if the user is able to view the initial state of the Funding Account Page")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Funding Account Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.fundingAccount, ReportingBalanceSheetPO.balanceSheetHeader,
					"Funding Account");

			// Verify the section in Funding Account Page
			node.log(Status.INFO, "STEP1 : Verify the sections in the Funding Account Page");
			System.out.println("STEP1 : Verify the sections in the Funding Account Page");

			// Check the visibility of Total Facility Drawdowns Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.totalFacilityDrawdownsSection,
					"STEP2 : BUG : Total Facility Drawdowns Section is not coming On Funding Account Page",
					"STEP2 : EXPECTED : Total Facility Drawdowns Section is coming On Funding Account Page");

			// Check the visibility of Total Facility Repayments Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.totalFacilityRepaymentsSection,
					"STEP3 : BUG : Total Facility Repayments Section is not coming On Funding Account Page",
					"STEP3 : EXPECTED : Total Facility Repayments Section is coming On Funding Account Page");

			// Check the visibility of Current Allocated Amount Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.currentAllocatedAmountSection,
					"STEP4 : BUG : The Current Allocated Amount Section is not coming On Funding Account Page",
					"STEP4 : EXPECTED : The Current Allocated Amount Section is coming On Funding Account Page");

			// Check the visibility of All Button Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.allButton,
					"STEP5 : BUG : The All Button Section is not coming On Funding Account Page",
					"STEP5 : EXPECTED : The All Button Section is coming On Funding Account Page");

			// Check the visibility of Payments Button Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.paymentsButton,
					"STEP6 : BUG : The Payments Button Section is not coming On Funding Account Page",
					"STEP6 : EXPECTED : The Payments Button Section is coming On Funding Account Page");

			// Check the visibility of Receipts Button Section
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.receiptsButton,
					"STEP7 : BUG : The Receipts Button Section is not coming On Funding Account Page",
					"STEP7 : EXPECTED : The Receipts Button Section is coming On Funding Account Page");

			// Check the visibility of Cash Balance Table
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.cashBalanceTable,
					"STEP8 : BUG : The Cash Balance Table is not coming On Funding Account Page",
					"STEP8 : EXPECTED : The Cash Balance Table is coming On Funding Account Page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFundingAccountSectionsVisibility", "Pass", driver);

		} catch (AssertionError validateFundingAccountSectionsVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFundingAccountSectionsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFundingAccountSectionsVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFundingAccountSectionsVisibility.printStackTrace();
			node.fail(validateFundingAccountSectionsVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFundingAccountSectionsVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFundingAccountSectionsVisibility test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFundingAccountSectionsVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFundingAccountSectionsVisibility.printStackTrace();
			node.fail(validateFundingAccountSectionsVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_170
	@Test(priority = 93)
	public void validateCurrentAllocatedAmount() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that Current Allocated Amount is equal to the difference between the Total Facility Drawdowns and Total Facility Repayments")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Funding Account Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.fundingAccount, ReportingBalanceSheetPO.balanceSheetHeader,
					"Funding Account");

			// Wait for the Page Loading To Complete
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Getting value of the Total Facility Drawdowns Amount
			int totalFacilityDrawdownsAmount = Utils
					.getTextAndParseToInt(ReportingBalanceSheetPO.totalFacilityDrawdownsAmount);

			// Getting value of the Total Facility Repayments Amount
			int totalFacilityRepaymentsAmount = Utils
					.getTextAndParseToInt(ReportingBalanceSheetPO.totalFacilityRepaymentsAmount);

			// Getting value of the Current Allocated Amount
			int actualCurrentAllocatedAmount = Utils
					.getTextAndParseToInt(ReportingBalanceSheetPO.currentAllocatedAmount);

			// Calling the calculateDifference from Utils and perform the Substraction
			int expectedCurrentAllocatedAmount = Utils.calculateDifference(totalFacilityDrawdownsAmount,
					totalFacilityRepaymentsAmount);

			// Set the acceptable difference
			int acceptableDifference = Integer.parseInt(getDataFromExcel(10));

			// Perform assertion allowing for a difference around 5 with a delta parameter
			Assert.assertEquals(actualCurrentAllocatedAmount, expectedCurrentAllocatedAmount, acceptableDifference,
					"Difference is greater than the acceptable range");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCurrentAllocatedAmount", "Pass", driver);

		} catch (AssertionError validateCurrentAllocatedAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCurrentAllocatedAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCurrentAllocatedAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCurrentAllocatedAmount.printStackTrace();
			node.fail(validateCurrentAllocatedAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCurrentAllocatedAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCurrentAllocatedAmount test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCurrentAllocatedAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCurrentAllocatedAmount.printStackTrace();
			node.fail(validateCurrentAllocatedAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_173
	@Test(priority = 94)
	public void validateFundingAccountTabTableColumns() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify if the user is able to view the initial state of the Cash Balance table")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Funding Account Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.fundingAccount, ReportingBalanceSheetPO.balanceSheetHeader,
					"Funding Account");

			// Verify the section in Cash Balance Table columns
			node.log(Status.INFO, "STEP1 : Verify the Cash Balance Table columns in Funding Account Tab ");
			System.out.println("STEP1 : Verify the Cash Balance Table columns in Funding Account Tab");

			// Check the visibility of Action Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.actionColumnHeader,
					"STEP2 : BUG : The Action column is not coming in Cash Balance Table",
					"STEP2 : EXPECTED : The Action column is coming in Cash Balance Table");

			// Check the visibility of Date Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.dateColumn,
					"STEP3 : BUG : The Date column is not coming in Cash Balance Table",
					"STEP3 : EXPECTED : The Date column is coming in Cash Balance Table");

			// Check the visibility of Internal Reference Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.internalReferenceColumn,
					"STEP4 : BUG : The Internal Reference column is not coming in Cash Balance Table",
					"STEP4 : EXPECTED : The Internal Reference column is coming in Cash Balance Table");

			// Check the visibility of Reference Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.referenceColumns,
					"STEP5 : BUG : The Reference column is not coming in Cash Balance Table",
					"STEP5 : EXPECTED : The Reference column is coming in Cash Balance Table");

			// Check the visibility of Transaction Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.transactionColumn,
					"STEP6 : BUG : The Transaction column is not coming in Cash Balance Table",
					"STEP6 : EXPECTED : The Transaction column is coming in Cash Balance Table");

			// Check the visibility of Repayment Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.repaymentColumnHeader,
					"STEP7 : BUG : The Repayment column is not coming in Cash Balance Table",
					"STEP7 : EXPECTED : The Repayment column is coming in Cash Balance Table");

			// Check the visibility of Drawdown Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.drawdownColumnHeader,
					"STEP8 : BUG : The Drawdown column is not coming in Cash Balance Table",
					"STEP8 : EXPECTED : The Drawdown column is coming in Cash Balance Table");

			// Check the visibility of Amount Allocated Column
			IElementActions.assertTrue_usingXpath(node, driver, ReportingBalanceSheetPO.amountAllocatedColumnHeader,
					"STEP9 : BUG : The Amount Allocated column is not coming in Cash Balance Table",
					"STEP9 : EXPECTED : The Amount Allocated column is coming in Cash Balance Table");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFundingAccountTabTableColumns", "Pass", driver);

		} catch (AssertionError validateFundingAccountTabTableColumns) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFundingAccountTabTableColumns test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFundingAccountTabTableColumns_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFundingAccountTabTableColumns.printStackTrace();
			node.fail(validateFundingAccountTabTableColumns);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFundingAccountTabTableColumns) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFundingAccountTabTableColumns test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFundingAccountTabTableColumns_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFundingAccountTabTableColumns.printStackTrace();
			node.fail(validateFundingAccountTabTableColumns);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Reporting_BalanceSheet_177
	@Test(priority = 95)
	public void validateReverseChronologicalOrderOfCashBalanceTable() throws IOException {
		try {
			extenttest = extent
					.createTest(
							"Verify that the default sort order for the table is in reverse chronological date order")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Funding Account Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.fundingAccount, ReportingBalanceSheetPO.balanceSheetHeader,
					"Funding Account");

			// Check the descending order for date column
			Utils.validateDateSorting(node, driver, ReportingBalanceSheetPO.dateColumnInFundingAccount, "descending",
					"validateReverseChronologicalOrderOfCashBalanceTable", "dd-MM-yyyy", "LocalDate");

		} catch (AssertionError validateReverseChronologicalOrderOfCashBalanceTable) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateReverseChronologicalOrderOfCashBalanceTable test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateReverseChronologicalOrderOfCashBalanceTable_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateReverseChronologicalOrderOfCashBalanceTable.printStackTrace();
			node.fail(validateReverseChronologicalOrderOfCashBalanceTable);
			Assert.fail();
			extent.flush();

		} catch (Exception validateReverseChronologicalOrderOfCashBalanceTable) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateReverseChronologicalOrderOfCashBalanceTable test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateReverseChronologicalOrderOfCashBalanceTable_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateReverseChronologicalOrderOfCashBalanceTable.printStackTrace();
			node.fail(validateReverseChronologicalOrderOfCashBalanceTable);
			Assert.fail();
			extent.flush();
		}
	}

	// Test Case sheet line no 351 Test Case
	@Test(priority = 96)
	public void validateAllocatedAmountValueInTopRowOfCashBalanceTable() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that for 'All', the Allocated Amount value in the top row of the table is equal to the Current Allocated  Amount in Funding Account tab")
					.assignCategory(reportingBalanceSheet_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadReportingBalanceSheetPage function from the ReportingPage
			ReportingPage.loadReportingBalanceSheetPage();

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Click on Funding Account Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.fundingAccount, ReportingBalanceSheetPO.balanceSheetHeader,
					"Funding Account");

			// Click on the All Button
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.allButton);
			node.log(Status.INFO, "STEP1 : Clicked on All Button");
			System.out.println("STEP1 : Clicked on All Button");

			// Get the Date column First Date
			String date = IElementActions.getElementText_usingXpath(node, driver,
					ReportingBalanceSheetPO.dateColumnFirstDate);
			node.log(Status.INFO, "STEP2 : First Date in Cash Balance Table : " + date);
			System.out.println("STEP2 : First Date in Cash Balance Table : " + date);

			// Get Amount Allocated Column First Amount
			int amountAllocatedFirstAmount = Utils
					.getTextAndParseToInt(ReportingBalanceSheetPO.amountAllocatedFirstAmount);

			// Click on Balance Sheet Summary Tab
			Utils.clickOnTab(ReportingBalanceSheetPO.balanceSheetSummary, ReportingBalanceSheetPO.balanceSheetHeader,
					"Balance Sheet Summary");

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Wait for the custom search to be visible and clickable
			node.log(Status.INFO, "STEP3 : Waiting for the custom search to be visible and clickable");
			System.out.println("STEP3 : Waiting for the custom search to be visible and clickable");
			IWaitStrategy.waitForVisiblityDynamic(node, driver, ReportingBalanceSheetPO.customSearchInputField, 150);
			IWaitStrategy.WaitUntilElementClickable(node, driver, ReportingBalanceSheetPO.customSearchInputField);
			node.log(Status.INFO, "STEP4 : Custom search is visible and clickable");
			System.out.println("STEP4 : Custom search is visible and clickable");

			// Or if using the array version
			String[] dateParts = Utils.extractDateParts(date);

			Thread.sleep(1000);
			// Calling enterDate from Utils to select Date From Calendar
			Utils.enterDate(ReportingBalanceSheetPO.customSearchField, UtilsPO.calenderMonth, dateParts[1],
					UtilsPO.calenderYear, dateParts[2], UtilsPO.calenderDay, dateParts[0]);

			// Click on the Custom Search Button
			IElementActions.clickelement_usingXpath(node, driver, ReportingBalanceSheetPO.customSearchButton);
			node.log(Status.INFO, "STEP5 : The Clicked on the Custom Search Button.");
			System.out.println("STEP5 : The Clicked on the Custom Search Button.");

			// Calling the spinner from Utils
			Utils.spinner(ReportingBalanceSheetPO.spinner);

			// Getting value of the Asset Amount
			int assetAmount = Utils.getTextAndParseToInt(ReportingBalanceSheetPO.assetAmountValue);

			// Assert the Amount Allocated
			IElementActions.assertEquals_usingInteger(node, driver, amountAllocatedFirstAmount, assetAmount,
					"STEP6 : BUG : The Amount Allocated for the top row in Cash Balance tab "
							+ amountAllocatedFirstAmount + " is not equal to the Asset Amount in Balance Sheet Summary "
							+ assetAmount,
					"STEP6 : PASS : The Amount Allocated for the top row in Cash Balance tab "
							+ amountAllocatedFirstAmount + " is equal to the Asset Amount in Balance Sheet Summary "
							+ assetAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAllocatedAmountValueInTopRowOfCashBalanceTable", "Pass",
					driver);

		} catch (AssertionError validateAllocatedAmountValueInTopRowOfCashBalanceTable) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAllocatedAmountValueInTopRowOfCashBalanceTable test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllocatedAmountValueInTopRowOfCashBalanceTable_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocatedAmountValueInTopRowOfCashBalanceTable.printStackTrace();
			node.fail(validateAllocatedAmountValueInTopRowOfCashBalanceTable);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAllocatedAmountValueInTopRowOfCashBalanceTable) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAllocatedAmountValueInTopRowOfCashBalanceTable test in BalanceSheetTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllocatedAmountValueInTopRowOfCashBalanceTable_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocatedAmountValueInTopRowOfCashBalanceTable.printStackTrace();
			node.fail(validateAllocatedAmountValueInTopRowOfCashBalanceTable);

			Assert.fail();
			extent.flush();
		}
	}
}