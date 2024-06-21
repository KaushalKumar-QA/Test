package com.Funding.InterestPayment.tests;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.locators.allPages.FundingDatabasePO;
import com.locators.allPages.FundingInterestPaymentPO;
import com.locators.allPages.FundingNewFacilityPO;
import com.locators.allPages.LoansDatabasePO;
import com.locators.allPages.LoansNewLoanPO;
import com.locators.allPages.SideMenuPO;
import com.locators.allPages.TreasuryDatabasePO;
import com.locators.allPages.TreasurySinglePO;
import com.locators.allPages.UtilsPO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IMouseActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.url.AllPagesData;
import com.qa.utils.FundingPage;
import com.qa.utils.LoginPage;
import com.qa.utils.TreasuryPage;
import com.qa.utils.Utils;

public class InterestPaymentStep4Test extends Baseclass {

	// TC_InterestPayment_Step4_225
	@Test(priority = 1)
	public void validateTablesVisibilityInStep4() throws IOException {

		try {
			extenttest = extent.createTest("Verify that user is able to click on Step4")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			// Call the userLoginProcess function from the utils login
			LoginPage.userLoginProcess(node, driver, getDataFromExcel(1), getDataFromExcel(2));

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Check the visibility of Bridge Loan Table
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.bridgeLoanTable1,
					"STEP1 : BUG: The Bridge Loan Table is not coming in Step4",
					"STEP1 : EXPECTED: The Bridge Loan Table is coming in in Step4");

			// Check the visibility of Bridge Loan Table
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.bridgeLoanTable2,
					"STEP2 : BUG: The Bridge Loan Table is not coming in Step4",
					"STEP2 : EXPECTED: The Bridge Loan Table is coming in in Step4");

			// Check the visibility of Facility Rate Table
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.facilityRateTable,
					"STEP3 : BUG: The Facility Rate Table is not coming in Step4",
					"STEP3 : EXPECTED: The Facility Rate Table is coming in Step4");

			// Check the visibility of Actual Rate Table
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.actualRateTable,
					"STEP4 : BUG: The Actual Rate Table is not coming in Step4",
					"STEP4 : EXPECTED: The Actual Rate Table is coming in Step4");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateTablesVisibilityInStep4", "Pass", driver);

		} catch (AssertionError validateTablesVisibilityInStep4) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateTablesVisibilityInStep4 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateTablesVisibilityInStep4_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTablesVisibilityInStep4.printStackTrace();
			node.fail(validateTablesVisibilityInStep4);
			Assert.fail();
			extent.flush();

		} catch (Exception validateTablesVisibilityInStep4) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateTablesVisibilityInStep4 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateTablesVisibilityInStep4_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTablesVisibilityInStep4.printStackTrace();
			node.fail(validateTablesVisibilityInStep4);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_226
	@Test(priority = 2)
	public void validateBridgeLoanTableColumnsVisibility() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that user is able to view Columns present under the Bridge Loan table")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Check the visibility of Facility Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.facilityColumnName,
					"STEP1 : BUG: The Facility Column is not coming under Bridge Loan Table in Step4",
					"STEP1 : EXPECTED: The Facility Column is coming under Bridge Loan Table in Step4");

			// Check the visibility of Payable Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.payableColumnName,
					"STEP2 : BUG: The Payable Column is not coming under Bridge Loan Table in Step4",
					"STEP2 : EXPECTED: The Payable Column is coming under Bridge Loan Table in Step4");

			// Check the visibility of Carried Forward Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.carriedForwardColumnName,
					"STEP3 : BUG: The Carried Forward Column is not coming under Bridge Loan Table in Step4",
					"STEP3 : EXPECTED: The Carried Forward Column is coming under Bridge Loan Table in Step4");

			// Check the visibility of Calculated Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.bridgeLoanCalculatedColumnName,
					"STEP4 : BUG: The Calculated Column is not coming under Bridge Loan Table in Step4",
					"STEP4 : EXPECTED: The Calculated Column is coming under Bridge Loan Table in Step4");

			// Check the visibility of Last Month Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.bridgeLoanLastMonthColumnName,
					"STEP5 : BUG: The Last Month Column is not coming under Bridge Loan Table in Step4",
					"STEP5 : EXPECTED: The Last Month Column is coming under Bridge Loan Table in Step4");

			// Check the visibility of System Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.bridgeLoanSystemColumnName,
					"STEP6 : BUG: The System Column is not coming under Bridge Loan Table in Step4",
					"STEP6 : EXPECTED: The System Column is coming under Bridge Loan Table in Step4");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateBridgeLoanTableColumnsVisibility", "Pass", driver);

		} catch (AssertionError validateBridgeLoanTableColumnsVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateBridgeLoanTableColumnsVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBridgeLoanTableColumnsVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBridgeLoanTableColumnsVisibility.printStackTrace();
			node.fail(validateBridgeLoanTableColumnsVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateBridgeLoanTableColumnsVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateBridgeLoanTableColumnsVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBridgeLoanTableColumnsVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBridgeLoanTableColumnsVisibility.printStackTrace();
			node.fail(validateBridgeLoanTableColumnsVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_227
	@Test(priority = 3)
	public void validateFacilityRateTableColumnsVisibility() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that user is able to view Columns present under the Facility Rate table")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Check the visibility of Calculated Column
			IElementActions.assertTrue_usingXpath(node, driver,
					FundingInterestPaymentPO.facilityRateCalculatedColumnName,
					"STEP1 : BUG: The Calculated Column is not coming under Facility Rate Table in Step4",
					"STEP1 : EXPECTED: The Calculated Column is coming under Facility Rate Table in Step4");

			// Check the visibility of Last Month Column
			IElementActions.assertTrue_usingXpath(node, driver,
					FundingInterestPaymentPO.facilityRateLastMonthColumnName,
					"STEP2 : BUG: The Last Month Column is not coming under Facility Rate Table in Step4",
					"STEP2 : EXPECTED: The Last Month Column is coming under Facility Rate Table in Step4");

			// Check the visibility of System Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.facilityRateSystemColumnName,
					"STEP3 : BUG: The System Column is not coming under Facility Rate Table in Step4",
					"STEP3 : EXPECTED: The System Column is coming under Facility Rate Table in Step4");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityRateTableColumnsVisibility", "Pass", driver);

		} catch (AssertionError validateFacilityRateTableColumnsVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityRateTableColumnsVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityRateTableColumnsVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityRateTableColumnsVisibility.printStackTrace();
			node.fail(validateFacilityRateTableColumnsVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityRateTableColumnsVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityRateTableColumnsVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityRateTableColumnsVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityRateTableColumnsVisibility.printStackTrace();
			node.fail(validateFacilityRateTableColumnsVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_228
	@Test(priority = 4)
	public void validateActualRateTableColumnVisibility() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that user is able to view Columns present under the Actual Rate table")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Check the visibility of Annual Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.annualColumnName,
					"STEP1 : BUG: The Annual Column is not coming under Actual Rate Table in Step4",
					"STEP1 : EXPECTED: The Annual Column is coming under Actual Rate Table in Step4");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateActualRateTableColumnVisibility", "Pass", driver);

		} catch (AssertionError validateActualRateTableColumnVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateActualRateTableColumnVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateActualRateTableColumnVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateActualRateTableColumnVisibility.printStackTrace();
			node.fail(validateActualRateTableColumnVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateActualRateTableColumnVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateActualRateTableColumnVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateActualRateTableColumnVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateActualRateTableColumnVisibility.printStackTrace();
			node.fail(validateActualRateTableColumnVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_229
	@Test(priority = 5)
	public void validateFacilityNumbersVisibilityInStep4() throws IOException {

		try {
			extenttest = extent.createTest("Verify user is able to see the Facility Number under the Facility Column")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Check the visibility of Facility Numbers under the Facility Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.facilityNumbers,
					"STEP1 : BUG: The Facility Numbers under the Facility Column are not coming in step4",
					"STEP1 : EXPECTED: The Facility Numbers under the Facility Column are coming in step4");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityNumbersVisibilityInStep4", "Pass", driver);

		} catch (AssertionError validateFacilityNumbersVisibilityInStep4) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityNumbersVisibilityInStep4 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityNumbersVisibilityInStep4_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityNumbersVisibilityInStep4.printStackTrace();
			node.fail(validateFacilityNumbersVisibilityInStep4);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityNumbersVisibilityInStep4) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityNumbersVisibilityInStep4 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityNumbersVisibilityInStep4_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityNumbersVisibilityInStep4.printStackTrace();
			node.fail(validateFacilityNumbersVisibilityInStep4);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_230
	@Test(priority = 6)
	public void validatePayableAmountsVisibility() throws IOException {

		try {
			extenttest = extent.createTest("Verify user is able to see the payable amount under payable column")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Check the visibility Loan Regular Interest Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.loanRegularInterestAmount,
					"STEP1 : BUG: The Loan Regular Interest Amount is not coming on Loan Interest Details Popup",
					"STEP1 : EXPECTED: The Loan Regular Interest Amount is coming on Loan Interest Details Popup");

			// Check the visibility Loan Default Interest Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.loanDefaultInterestAmount,
					"STEP2 : BUG: The Loan Default Interest Amount is not coming on Loan Interest Details Popup",
					"STEP2 : EXPECTED: The Loan Default Interest Amount is coming on Loan Interest Details Popup");

			// Check the visibility Loan Default Interest Paid Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.loanDefaultInterestPaidAmount,
					"STEP3 : BUG: The Loan Default Interest Paid Amount is not coming on Loan Interest Details Popup",
					"STEP3 : EXPECTED: The Loan Default Interest Paid Amount is coming on Loan Interest Details Popup");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validatePayableAmountsVisibility", "Pass", driver);

		} catch (AssertionError validatePayableAmountsVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePayableAmountsVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePayableAmountsVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePayableAmountsVisibility.printStackTrace();
			node.fail(validatePayableAmountsVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validatePayableAmountsVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePayableAmountsVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePayableAmountsVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePayableAmountsVisibility.printStackTrace();
			node.fail(validatePayableAmountsVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_231
	@Test(priority = 7)
	public void validateLoanIButtonVisibility() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the user is able to see the (i) button of the loans under Payable column.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Check the visibility of Loan 'i' Button
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.loanIButton,
					"STEP1 : BUG: The loan 'i' button is not coming on Return Analysis Step 4",
					"STEP1 : EXPECTED: The loan 'i' button is coming on Return Analysis Step 4");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanIButtonVisibility", "Pass", driver);

		} catch (AssertionError validateLoanIButtonVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanIButtonVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanIButtonVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanIButtonVisibility.printStackTrace();
			node.fail(validateLoanIButtonVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanIButtonVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanIButtonVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanIButtonVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanIButtonVisibility.printStackTrace();
			node.fail(validateLoanIButtonVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_232
	// TC_InterestPayment_Step4_233
	@Test(priority = 8)
	public void validateLoanIButton() throws IOException {

		try {
			extenttest = extent.createTest("Verify that the user is able to click on the (i) button." + "_"
					+ "validateLoanInterestDetailsPopupVisibility : Verify that the when user clicks on the (i) button, the user is navigated to the Loan Interest Details  popup")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanIButton", "Pass", driver);

		} catch (AssertionError validateLoanIButton) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanIButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanIButton_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanIButton.printStackTrace();
			node.fail(validateLoanIButton);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanIButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanIButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanIButton_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanIButton.printStackTrace();
			node.fail(validateLoanIButton);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_234
	@Test(priority = 9)
	public void validateLoanInterestDetailsPopupSections() throws IOException {

		try {
			extenttest = extent.createTest("Verify the Loan Interest Details popup")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Check the visibility of Loan Details Section
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.loanDetailsSection,
					"STEP1 : BUG: The Loan Details Section is not coming on Loan Interest Details Popup",
					"STEP1 : EXPECTED: The Loan Details Section is coming on Loan Interest Details Popup");

			// Check the visibility of Month on Month Comparison Section
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.monthonMonthComparisonSection,
					"STEP2 : BUG: The Month on Month Comparison Section is not coming on Loan Interest Details Popup",
					"STEP2 : EXPECTED: The Month on Month Comparison Section is coming on Loan Interest Details Popup");

			// Check the visibility of Current Month Calculations Section
			IElementActions.assertTrue_usingXpath(node, driver,
					FundingInterestPaymentPO.currentMonthCalculationsSection,
					"STEP3 : BUG: The Current Month Calculations Section is not coming on Loan Interest Details Popup",
					"STEP3 : EXPECTED: The Current Month Calculations Section is coming on Loan Interest Details Popup");

			// Check the visibility of Data Table
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.loanInterestDetailsPopupTable,
					"STEP4 : BUG: The Data Table is not coming on Loan Interest Details Popup",
					"STEP4 : EXPECTED: The Data Table coming on Loan Interest Details Popup");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanInterestDetailsPopupSections", "Pass", driver);

		} catch (AssertionError validateLoanInterestDetailsPopupSections) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanInterestDetailsPopupSections test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanInterestDetailsPopupSections_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanInterestDetailsPopupSections.printStackTrace();
			node.fail(validateLoanInterestDetailsPopupSections);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanInterestDetailsPopupSections) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanInterestDetailsPopupSections test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanInterestDetailsPopupSections_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanInterestDetailsPopupSections.printStackTrace();
			node.fail(validateLoanInterestDetailsPopupSections);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_235
	@Test(priority = 10)
	public void validateLoanDetailsSection() throws IOException {

		try {
			extenttest = extent.createTest("Verify the Loan Details section")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Check the visibility Loan Regular Interest
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.loanRegularInterest,
					"STEP1 : BUG: The Loan Regular Interest is not coming on Loan Interest Details Popup",
					"STEP1 : EXPECTED: The Loan Regular Interest is coming on Loan Interest Details Popup");

			// Check the visibility Loan Regular Interest Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.loanRegularInterestAmount,
					"STEP2 : BUG: The Loan Regular Interest Amount is not coming on Loan Interest Details Popup",
					"STEP2 : EXPECTED: The Loan Regular Interest Amount is coming on Loan Interest Details Popup");

			// Check the visibility Loan Default Interest
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.loanDefaultInterest,
					"STEP3 : BUG: The Loan Default Interest is not coming on Loan Interest Details Popup",
					"STEP3 : EXPECTED: The Loan Default Interest is coming on Loan Interest Details Popup");

			// Check the visibility Loan Default Interest Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.loanDefaultInterestAmount,
					"STEP4 : BUG: The Loan Default Interest Amount is not coming on Loan Interest Details Popup",
					"STEP4 : EXPECTED: The Loan Default Interest Amount is coming on Loan Interest Details Popup");

			// Check the visibility Loan Default Interest Paid
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.loanDefaultInterestPaid,
					"STEP5 : BUG: The Loan Default Interest Paid is not coming on Loan Interest Details Popup",
					"STEP5 : EXPECTED: The Loan Default Interest Paid is coming on Loan Interest Details Popup");

			// Check the visibility Loan Default Interest Paid Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.loanDefaultInterestPaidAmount,
					"STEP6 : BUG: The Loan Default Interest Paid Amount is not coming on Loan Interest Details Popup",
					"STEP6 : EXPECTED: The Loan Default Interest Paid Amount is coming on Loan Interest Details Popup");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanDetailsSection", "Pass", driver);

		} catch (AssertionError validateLoanDetailsSection) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanDetailsSection test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanDetailsSection_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanDetailsSection.printStackTrace();
			node.fail(validateLoanDetailsSection);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanDetailsSection) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanDetailsSection test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanDetailsSection_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanDetailsSection.printStackTrace();
			node.fail(validateLoanDetailsSection);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_236
	@Test(priority = 11)
	public void validateMonthonMonthComparisonSection() throws IOException {

		try {
			extenttest = extent.createTest("Verify the  Month on Month Comparison section")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Check the visibility of Prior Payment
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.priorPayment,
					"STEP1 : BUG: The Prior Payment is not coming on Loan Interest Details Popup",
					"STEP1 : EXPECTED: The Prior Payment is coming on Loan Interest Details Popup");

			// Check the visibility of Prior Payment Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.priorPaymentAmount,
					"STEP2 : BUG: The Prior Payment Amount is not coming on Loan Interest Details Popup",
					"STEP2 : EXPECTED: The Prior Payment Amount is coming on Loan Interest Details Popup");

			// Check the visibility of Change due to:
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.changeDueTo,
					"STEP3 : BUG: The Change due to: is not coming on Loan Interest Details Popup",
					"STEP3 : EXPECTED: The Change due to: is coming on Loan Interest Details Popup");

			// Check the visibility of Day Count Fraction
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.dayCountFractions,
					"STEP4 : BUG: The Day Count Fraction is not coming on Loan Interest Details Popup",
					"STEP4 : EXPECTED: The Day Count Fraction is coming on Loan Interest Details Popup");

			// Check the visibility of Day Count Fraction Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.dayCountFractionAmount,
					"STEP5 : BUG: The Day Count Fraction Amount is not coming on Loan Interest Details Popup",
					"STEP5 : EXPECTED: The Day Count Fraction Amount is coming on Loan Interest Details Popup");

			// Check the visibility of Lending Rates
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.lendingRates,
					"STEP6 : BUG: The Lending Rates is not coming on Loan Interest Details Popup",
					"STEP6 : EXPECTED: The Lending Rates is coming on Loan Interest Details Popup");

			// Check the visibility of Lending Rates Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.lendingRatesAmount,
					"STEP7 : BUG: The Lending Rates Amount is not coming on Loan Interest Details Popup",
					"STEP7 : EXPECTED: The Lending Rates Amount is coming on Loan Interest Details Popup");

			// Check the visibility of Deployment
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deployment,
					"STEP8 : BUG: The Deployment is not coming on Loan Interest Details Popup",
					"STEP8 : EXPECTED: The Deployment is coming on Loan Interest Details Popup");

			// Check the visibility of Deployment Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deploymentAmount,
					"STEP9 : BUG: The Deployment Amount is not coming on Loan Interest Details Popup",
					"STEP9 : EXPECTED: The Deployment Amount is coming on Loan Interest Details Popup");

			// Check the visibility of Cash Interest
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.cashInterests,
					"STEP10 : BUG: The Cash Interest is not coming on Loan Interest Details Popup",
					"STEP10 : EXPECTED: The Cash Interest is coming on Loan Interest Details Popup");

			// Check the visibility of Cash Interest Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.cashInterestAmount,
					"STEP11 : BUG: The Cash Interest Amount is not coming on Loan Interest Details Popup",
					"STEP11 : EXPECTED: The Cash Interest Amount is coming on Loan Interest Details Popup");

			// Check the visibility of Interest Deferral
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestDeferral,
					"STEP12 : BUG: The Interest Deferral is not coming on Loan Interest Details Popup",
					"STEP12 : EXPECTED: The Interest Deferral is coming on Loan Interest Details Popup");

			// Check the visibility of Interest Deferral Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestDeferralAmount,
					"STEP13 : BUG: The Interest Deferral Amount is not coming on Loan Interest Details Popup",
					"STEP13 : EXPECTED: The Interest Deferral Amount is coming on Loan Interest Details Popup");

			// Check the visibility of Total change
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.totalChange,
					"STEP14 : BUG: The Total change	is not coming on Loan Interest Details Popup",
					"STEP14 : EXPECTED: The Total change is coming on Loan Interest Details Popup");

			// Check the visibility of Total change Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.totalChangeAmount,
					"STEP15 : BUG: The Total change	Amount is not coming on Loan Interest Details Popup",
					"STEP15 : EXPECTED: The Total change	Amount is coming on Loan Interest Details Popup");

			// Check the visibility of New Payment
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.newPayment,
					"STEP16 : BUG: The New Payment is not coming on Loan Interest Details Popup",
					"STEP16 : EXPECTED: The New Payment is coming on Loan Interest Details Popup");

			// Check the visibility of New Payment Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.newPaymentAmount,
					"STEP17 : BUG: The New Payment Amount is not coming on Loan Interest Details Popup",
					"STEP17 : EXPECTED: The New Payment Amount is coming on Loan Interest Details Popup");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateMonthonMonthComparisonSection", "Pass", driver);

		} catch (AssertionError validateMonthonMonthComparisonSection) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateMonthonMonthComparisonSection test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateMonthonMonthComparisonSection_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMonthonMonthComparisonSection.printStackTrace();
			node.fail(validateMonthonMonthComparisonSection);
			Assert.fail();
			extent.flush();

		} catch (Exception validateMonthonMonthComparisonSection) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateMonthonMonthComparisonSection test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateMonthonMonthComparisonSection_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMonthonMonthComparisonSection.printStackTrace();
			node.fail(validateMonthonMonthComparisonSection);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_237
	@Test(priority = 12)
	public void validateCurrentMonthCalculationsSection() throws IOException {

		try {
			extenttest = extent.createTest("Verify the Current Month Calculations section")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Check the visibility of Interest Payment Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestPayment,
					"STEP1 : BUG: The Interest Payment Amount is not coming on Loan Interest Details Popup",
					"STEP1 : EXPECTED: The Interest Payment Amount is coming on Loan Interest Details Popup");

			// Check the visibility of Interest Payment Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestPaymentAmount,
					"STEP2 : BUG: The Interest Payment Amount Value is not coming on Loan Interest Details Popup",
					"STEP2 : EXPECTED: The Interest Payment Amount Value is coming on Loan Interest Details Popup");

			// Check the visibility of Regular Interest
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.regularInterests,
					"STEP3 : BUG: The Regular Interest is not coming on Loan Interest Details Popup",
					"STEP3 : EXPECTED: The Regular Interest	is coming on Loan Interest Details Popup");

			// Check the visibility of Regular Interest Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.regularInterestAmount,
					"STEP4 : BUG: The Regular Interest Amount is not coming on Loan Interest Details Popup",
					"STEP4 : EXPECTED: The Regular Interest	Amount is coming on Loan Interest Details Popup");

			// Check the visibility of Interest Release
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestRelease,
					"STEP5 : BUG: The Interest Release is not coming on Loan Interest Details Popup",
					"STEP5 : EXPECTED: The Interest Release is coming on Loan Interest Details Popup");

			// Check the visibility of Interest Release Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestReleaseAmount,
					"STEP6 : BUG: The Interest Release Amount is not coming on Loan Interest Details Popup",
					"STEP6 : EXPECTED: The Interest Release Amount is coming on Loan Interest Details Popup");

			// Check the visibility of Cash Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.cashAmount,
					"STEP7 : BUG: The Cash Amount is not coming on Loan Interest Details Popup",
					"STEP7 : EXPECTED: The Cash Amount is coming on Loan Interest Details Popup");

			// Check the visibility of Cash Amount value
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.cashAmountValue,
					"STEP8 : BUG: The Cash Amount Value is not coming on Loan Interest Details Popup",
					"STEP8 : EXPECTED: The Cash Amount Value is coming on Loan Interest Details Popup");

			// Check the visibility of Deferred Interest C/F
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deferredInterestCF,
					"STEP9 : BUG: The Deferred Interest C/F is not coming on Loan Interest Details Popup",
					"STEP9 : EXPECTED: The Deferred Interest C/F is coming on Loan Interest Details Popup");

			// Check the visibility of Deferred Interest C/F Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deferredInterestCFAmount,
					"STEP10 : BUG: The Deferred Interest C/F Amount is not coming on Loan Interest Details Popup",
					"STEP10 : EXPECTED: The Deferred Interest C/F Amount is coming on Loan Interest Details Popup");

			// Check the visibility of Deferred Interest B/F
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deferredInterestBF,
					"STEP11 : BUG: The Deferred Interest B/F is not coming on Loan Interest Details Popup",
					"STEP11 : EXPECTED: The Deferred Interest B/F is coming on Loan Interest Details Popup");

			// Check the visibility of Deferred Interest B/F Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deferredInterestBFAmount,
					"STEP12 : BUG: The Deferred Interest B/F Amount is not coming on Loan Interest Details Popup",
					"STEP12 : EXPECTED: The Deferred Interest B/F Amount is coming on Loan Interest Details Popup");

			// Check the visibility of Deferred Interest This Period
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deferredInterestThisPeriod,
					"STEP13 : BUG: The Deferred Interest This Period is not coming on Loan Interest Details Popup",
					"STEP13 : EXPECTED: The Deferred Interest This Period is coming on Loan Interest Details Popup");

			// Check the visibility of Deferred Interest This Period Amount
			IElementActions.assertTrue_usingXpath(node, driver,
					FundingInterestPaymentPO.deferredInterestThisPeriodAmount,
					"STEP14 : BUG: The Deferred Interest This Period Amount is not coming on Loan Interest Details Popup",
					"STEP14 : EXPECTED: The Deferred Interest This Period Amount is coming on Loan Interest Details Popup");

			// Check the visibility of Deferred Interest Release
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deferredInterestRelease,
					"STEP15 : BUG: The Deferred Interest Release is not coming on Loan Interest Details Popup",
					"STEP15 : EXPECTED: The Deferred Interest Release is coming on Loan Interest Details Popup");

			// Check the visibility of Deferred Interest Release Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deferredInterestReleaseAmount,
					"STEP16 : BUG: The Deferred Interest Release Amount is not coming on Loan Interest Details Popup",
					"STEP16 : EXPECTED: The Deferred Interest Release Amount is coming on Loan Interest Details Popup");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCurrentMonthCalculationsSection", "Pass", driver);

		} catch (AssertionError validateCurrentMonthCalculationsSection) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCurrentMonthCalculationsSection test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCurrentMonthCalculationsSection_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCurrentMonthCalculationsSection.printStackTrace();
			node.fail(validateCurrentMonthCalculationsSection);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCurrentMonthCalculationsSection) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCurrentMonthCalculationsSection test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCurrentMonthCalculationsSection_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCurrentMonthCalculationsSection.printStackTrace();
			node.fail(validateCurrentMonthCalculationsSection);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_241
	@Test(priority = 13)
	public void validatePriorPaymentAmount() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the Prior Payment is calculated as per the below formula:"
							+ "Prior Payment = New Payment - Total Change")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the facilityIButton function from FundingPage
			FundingPage.facilityIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Calling the getTextAndParseToInt from Utils and get the New Payment Amount
			int newPaymentAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.newPaymentAmount);

			// Calling the getTextAndParseToInt from Utils and Get the Total Chnage Amount
			int totalChangeAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.totalChangeAmount);

			// Calling the getTextAndParseToInt from Utils and get the Prior Payment Amount
			int actualPriorPaymentAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.priorPaymentAmount);

			// Calling the calculateDifference from Utils and Calculate the Expected Prior
			// Payment Amount
			int expectedPriorPaymentAmount = Utils.calculateDifference(newPaymentAmount, totalChangeAmount);
			node.log(Status.INFO, "STEP1 : Calculated Expected Prior Payment Amount : " + expectedPriorPaymentAmount);
			System.out.println("STEP1 : Calculated Expected Prior Payment Amount : " + expectedPriorPaymentAmount);

			// Set the acceptable difference
			int acceptableDifference = Integer.parseInt(getDataFromExcel(10));

			// Perform assertion allowing for a difference around 5 with a delta parameter
			Assert.assertEquals(actualPriorPaymentAmount, expectedPriorPaymentAmount, acceptableDifference,
					"Difference is greater than the acceptable range");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validatePriorPaymentAmount", "Pass", driver);

		} catch (AssertionError validatePriorPaymentAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePriorPaymentAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatePriorPaymentAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePriorPaymentAmount.printStackTrace();
			node.fail(validatePriorPaymentAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validatePriorPaymentAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePriorPaymentAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatePriorPaymentAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePriorPaymentAmount.printStackTrace();
			node.fail(validatePriorPaymentAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_242
	@Test(priority = 14)
	public void validateCashInterestAndInterestDeferralValues() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user is able to see the amounts for the fields listed below, as calculated according to their respective formulas:"
							+ "- Change due to Day Count Fraction - No need to verify"
							+ "- Change due to Lending Rates -  No need to verify"
							+ "- Change due to Deployment  - No need to verify"
							+ "- Change due to Cash Interest = Step 2 > NIM Analysis > Cash Interest"
							+ "- Change due to Interest Deferral = negative of Step 2 > Deferred Interest Check > Sum (first row) > Change")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Get the Cash Interest Amount At NIM Popup
			String cashInterestAmountAtNIMPopup = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.cashInterestField);
			node.log(Status.INFO, "STEP1 : The Cash Interest Amount At NIM Popup : " + cashInterestAmountAtNIMPopup);
			System.out.println("STEP1 : The Cash Interest Amount At NIM Popup : " + cashInterestAmountAtNIMPopup);

			// Calling the closePopUp function from Funding Page
			FundingPage.closePopUp();

			// Get the Change Sum Amount
			String changeSumAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.changeSumValue);
			node.log(Status.INFO, "STEP2 : The Change Sum Amount : " + changeSumAmount);
			System.out.println("STEP2 : The Change Sum Amount : " + changeSumAmount);

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Calling the facilityIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Get the Cash Interest Amount
			String cashInterestAmountAtLoanInterestPopup = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.cashInterestAmount);
			node.log(Status.INFO, "STEP3 : The Cash Interest Amount : " + cashInterestAmountAtLoanInterestPopup);
			System.out.println("STEP3 : The Cash Interest Amount : " + cashInterestAmountAtLoanInterestPopup);

			// Get the Interest Deferral Amount
			String interestDeferralAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.interestDeferralAmount);
			node.log(Status.INFO, "STEP4 : The Interest Deferral Amount : " + interestDeferralAmount);
			System.out.println("STEP4 : The Interest Deferral Amount : " + interestDeferralAmount);

			// Assert the Cash Interest Amount
			IElementActions.assertEquals_usingString(node, driver, cashInterestAmountAtLoanInterestPopup,
					cashInterestAmountAtNIMPopup,
					"STEP5 : BUG : The Cash Interest Amount At Loan Interest Popup is not Same as Cash Interest Amount At NIM Popup",
					"STEP5 : PASS : The Cash Interest Amount At Loan Interest Popup is Same as Cash Interest Amount At NIM Popup");

			// Assert the Interest Deferral Amount
			IElementActions.assertEquals_usingString(node, driver, interestDeferralAmount, changeSumAmount,
					"STEP6 : BUG : The Interest Deferral Amount At Loan Interest Popup is not Same as Deferred Interest Change Sum Amount in Step2",
					"STEP6 : PASS : The Interest Deferral Amount At Loan Interest Popup is Same as Deferred Interest Change Sum Amount in Step2");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashInterestAndInterestDeferralValues", "Pass", driver);

		} catch (AssertionError validateCashInterestAndInterestDeferralValues) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashInterestAndInterestDeferralValues test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashInterestAndInterestDeferralValues_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashInterestAndInterestDeferralValues.printStackTrace();
			node.fail(validateCashInterestAndInterestDeferralValues);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCashInterestAndInterestDeferralValues) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashInterestAndInterestDeferralValues test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashInterestAndInterestDeferralValues_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashInterestAndInterestDeferralValues.printStackTrace();
			node.fail(validateCashInterestAndInterestDeferralValues);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_243
	@Test(priority = 15)
	public void validateTotalChangeAmount() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the 'Total change' amount is calculated as the sum of the Day Count Fraction,Lending Rates,Deployment,Cash Interest and Interest Deferral")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Call the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Calling the getTextAndParseToInt from Utils and get the Day Coun tFraction
			// Amount
			int dayCountFractionAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.dayCountFractionAmount);

			// Calling the getTextAndParseToInt from Utils and get the Lending Rates Amount
			int lendingRatesAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.lendingRatesAmount);

			// Calling the getTextAndParseToInt from Utils and get the deployment Amount
			int deploymentAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.deploymentAmount);

			// Calling the getTextAndParseToInt from Utils and get the Cash Interest Amount
			int cashInterestAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.cashInterestAmount);

			// Calling the getTextAndParseToInt from Utils and Interest Deferral Amount
			int interestDeferralAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.interestDeferralAmount);

			// Calling the getTextAndParseToInt from Utils and get the Total Change Amount
			int actualTotalChangeAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.totalChangeAmount);

			// Calling the calculateAddition from Utils and Calculate the Expected Total
			// change Amount
			int expectedTotalChangeAmount = Utils.calculateAddition(dayCountFractionAmount, lendingRatesAmount)
					+ Utils.calculateAddition(deploymentAmount, cashInterestAmount) + interestDeferralAmount;
			node.log(Status.INFO, "STEP1 : Calculated Expected Total change Amount : " + expectedTotalChangeAmount);
			System.out.println("STEP1 :  Calculated Expected Total change Amount : " + expectedTotalChangeAmount);

			// Set the acceptable difference
			int acceptableDifference = Integer.parseInt(getDataFromExcel(10));

			// Perform assertion allowing for a difference around 5 with a delta parameter
			Assert.assertEquals(actualTotalChangeAmount, expectedTotalChangeAmount, acceptableDifference,
					"Difference is greater than the acceptable range");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateTotalChangeAmount", "Pass", driver);

		} catch (AssertionError validateTotalChangeAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateTotalChangeAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTotalChangeAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalChangeAmount.printStackTrace();
			node.fail(validateTotalChangeAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateTotalChangeAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateTotalChangeAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTotalChangeAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalChangeAmount.printStackTrace();
			node.fail(validateTotalChangeAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_244
	@Test(priority = 16)
	public void validateNewPaymentAmount() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the New Payment amount is calculated as Interest Payment amount at Current month Calculation column on the same popup")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Get the New Payment Amount
			String newPaymentAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.newPaymentAmount);
			node.log(Status.INFO, "STEP1 : The New Payment Amount is " + newPaymentAmount);
			System.out.println("STEP1 : The New Payment Amount is " + newPaymentAmount);

			// Get the Interest Payment Amount
			String interestPaymentAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.interestPaymentAmount);
			node.log(Status.INFO, "STEP2 : The Interest Payment Amount is " + interestPaymentAmount);
			System.out.println("STEP2 : The Interest Payment Amount is " + interestPaymentAmount);

			// Assert that New Payment Amount is Same as Interest Payment Amount
			IElementActions.assertEquals_usingString(node, driver, newPaymentAmount, interestPaymentAmount,
					"STEP3 : BUG : The New Payment Amount is not Same as Interest Payment Amount",
					"STEP3 : PASS : The New Payment Amount is Same as Interest Payment Amount");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateNewPaymentAmount", "Pass", driver);

		} catch (AssertionError validateNewPaymentAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNewPaymentAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateNewPaymentAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNewPaymentAmount.printStackTrace();
			node.fail(validateNewPaymentAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateNewPaymentAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNewPaymentAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateNewPaymentAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNewPaymentAmount.printStackTrace();
			node.fail(validateNewPaymentAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_245
	@Test(priority = 17)
	public void validateInterestPaymentAmount() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the 'Interest Payment' amount is calculated as the sum of the Regular Interest,Interest Release and Cash Amount")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Calling the getTextAndParseToInt from Utils and get the Regular Interest
			// Amount
			int regularInterestAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.regularInterestAmount);

			// Calling the getTextAndParseToInt from Utils and get the Interest Release
			// Amount
			int interestReleaseAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.interestReleaseAmount);

			// Calling the getTextAndParseToInt from Utils and get the Cash Amount
			int cashAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.cashAmountValue);

			// Calling the getTextAndParseToInt from Utils and get the Actual Interest
			// Payment Amount
			int actualInterestPaymentAmount = Utils
					.getTextAndParseToInt(FundingInterestPaymentPO.interestPaymentAmount);

			// Calling the calculateAddition from Utils and Calculate the Expected Interest
			// Payment Amount
			int expectedInterestPaymentAmount = Utils.calculateAddition(regularInterestAmount, interestReleaseAmount)
					+ cashAmount;
			node.log(Status.INFO,
					"STEP1 : Calculated Expected Interest Payment Amount : " + expectedInterestPaymentAmount);
			System.out
					.println("STEP1 : Calculated Expected Interest Payment Amount : " + expectedInterestPaymentAmount);

			// Set the acceptable difference
			int acceptableDifference = Integer.parseInt(getDataFromExcel(10));

			// Perform assertion allowing for a difference around 5 with a delta parameter
			Assert.assertEquals(actualInterestPaymentAmount, expectedInterestPaymentAmount, acceptableDifference,
					"Difference is greater than the acceptable range");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateInterestPaymentAmount", "Pass", driver);

		} catch (AssertionError validateInterestPaymentAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInterestPaymentAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestPaymentAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestPaymentAmount.printStackTrace();
			node.fail(validateInterestPaymentAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateInterestPaymentAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInterestPaymentAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestPaymentAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestPaymentAmount.printStackTrace();
			node.fail(validateInterestPaymentAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_246
	@Test(priority = 18)
	public void validateCurrentMonthCalculationsFieldsAmounts() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user is able to see the amounts for the fields listed below, as calculated according to their respective formulas:"
							+ "Regular Interest = sum of regular interest column"
							+ "Interest Release = sum of default Interest paid column"
							+ "Cash amount can be found on the cash row at the bottom of the popup"
							+ "Deferred Interest C/F = sum of Carried Forward column"
							+ "Deferred Interest B/F = Carried Over"
							+ "Deferred Interest This Period = sum of Default Interest column"
							+ "Deferred Interest Release = sum of Default Interest Paid column" + "")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			String deviatedValue = getDataFromExcel(10);

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Validate regular Interest Amount
			Utils.validateSumForDoubleValues(FundingInterestPaymentPO.regularInterestAmount,
					FundingInterestPaymentPO.regularInterestsColumnInLoan, deviatedValue, "RegularInterest");

			// Validate interest Release Amount
			Utils.validateSumForDoubleValues(FundingInterestPaymentPO.interestReleaseAmount,
					FundingInterestPaymentPO.defaultInterestPaidColumnInLoan, deviatedValue, "InterestRelease");

			// Validate cash Amount Value
			Utils.validateSumForDoubleValues(FundingInterestPaymentPO.cashAmountValue,
					FundingInterestPaymentPO.adjustmentColumnInLoan, deviatedValue, "CashAmount");

			// Validate deferred Interest CFAmount
			Utils.validateSumForDoubleValues(FundingInterestPaymentPO.deferredInterestCFAmount,
					FundingInterestPaymentPO.carriedForwardColumnInLoan, deviatedValue, "DeferredInterestCF");

			// Validate deferred Interest This Period Amount
			// Get the deferredInterestThisPeriodAmount
			int lastPeriodNumberOfDaysValueInStep2 = Utils
					.getTextAndParseToInt(FundingInterestPaymentPO.deferredInterestThisPeriodAmount);

			// deferred Interest column is not present in loan popup on staging
			int deferredInterest = 0;
			node.log(Status.INFO,
					"STEP1 : DeferredInterest column is not coming in popup so considering 0 and deferredInterestThisPeriodAmount value is "
							+ lastPeriodNumberOfDaysValueInStep2);
			System.out.println(
					"STEP1 : DeferredInterest column is not coming in popup so considering 0 and deferredInterestThisPeriodAmount value is "
							+ lastPeriodNumberOfDaysValueInStep2);

			// Assert that Last Period Number of Days value is same in step3 and step2
			IElementActions.assertEquals_usingInteger(node, driver, lastPeriodNumberOfDaysValueInStep2,
					deferredInterest,
					"STEP2 : BUG: Deferred Interest This Period Amount value " + lastPeriodNumberOfDaysValueInStep2
							+ " is not same as deferredInterest " + deferredInterest,
					"STEP2 : EXPECTED: Deferred Interest This Period Amount value " + lastPeriodNumberOfDaysValueInStep2
							+ " is same as deferredInterest " + deferredInterest);

			// Validate deferred Interest Release Amount
			Utils.validateSumForDoubleValues(FundingInterestPaymentPO.deferredInterestReleaseAmount,
					FundingInterestPaymentPO.defaultInterestPaidColumnInLoan, deviatedValue, "DeferredInterestRelease");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCurrentMonthCalculationsFieldsAmounts", "Pass", driver);

		} catch (AssertionError validateCurrentMonthCalculationsFieldsAmounts) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCurrentMonthCalculationsFieldsAmounts test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCurrentMonthCalculationsFieldsAmounts_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCurrentMonthCalculationsFieldsAmounts.printStackTrace();
			node.fail(validateCurrentMonthCalculationsFieldsAmounts);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCurrentMonthCalculationsFieldsAmounts) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCurrentMonthCalculationsFieldsAmounts test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCurrentMonthCalculationsFieldsAmounts_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCurrentMonthCalculationsFieldsAmounts.printStackTrace();
			node.fail(validateCurrentMonthCalculationsFieldsAmounts);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_248
	@Test(priority = 19)
	public void validateLoanDefaultInterestValue() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that values of Loan Default Interest and Loan Default Interest Paid are same")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Get the Loan Default Interest Amount
			String loanDefaultInterestAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.loanDefaultInterestAmount);
			node.log(Status.INFO, "STEP1 : The Loan Default Interest Amount is " + loanDefaultInterestAmount);
			System.out.println("STEP1 : The Loan Default Interest Amount is " + loanDefaultInterestAmount);

			// Get the Loan Default Interest Paid Amount
			String loanDefaultInterestPaidAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.loanDefaultInterestPaidAmount);
			node.log(Status.INFO, "STEP2 : The Loan Default Interest Paid Amount is " + loanDefaultInterestPaidAmount);
			System.out.println("STEP2 : The Loan Default Interest Paid Amount is " + loanDefaultInterestPaidAmount);

			// Assert the Loan Default Interest Amount
			IElementActions.assertEquals_usingString(node, driver, loanDefaultInterestAmount,
					loanDefaultInterestPaidAmount,
					"STEP3 : BUG : The Loan Default Interest Amount is not Same as Loan Default Interest Paid Amount",
					"STEP3 : PASS : The Loan Default Interest Amount is Same as Loan Default Interest Paid Amount");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanDefaultInterestValue", "Pass", driver);

		} catch (AssertionError validateLoanDefaultInterestValue) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanDefaultInterestValue test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanDefaultInterestValue_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanDefaultInterestValue.printStackTrace();
			node.fail(validateLoanDefaultInterestValue);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanDefaultInterestValue) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanDefaultInterestValue test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanDefaultInterestValue_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanDefaultInterestValue.printStackTrace();
			node.fail(validateLoanDefaultInterestValue);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_249
	// TC_InterestPayment_Step4_250
	// TC_InterestPayment_Step4_251
	@Test(priority = 20)
	public void validateLoanColour() throws IOException {

		try {
			extenttest = extent.createTest(
					"ValidateGreen - Verify that when all days in the period are regular, then loan is displayed in green colour"
							+ "ValidateRed - Verify that when all days in the period are standard or default days, then loan is displayed in red colour"
							+ "ValidateOrange - Verify that when all days in the period are with a mixture of regular and standard/default days, then loan is displayed in Orange colour")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the getTextAndParseToInt from Utils and Get the this Period Number Of
			// Days
			int actualNumberOfDays = Utils.getTextAndParseToInt(FundingInterestPaymentPO.thisPeriodNumberOfDaysValue);

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Locate the elements listing loan records
			List<WebElement> loanRecords = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.rowsInLoan);
			List<WebElement> facilityReferenceList = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.referenceColumnInLoan);

			// Extract Regular Days and Standard Interest Days values from lists
			List<WebElement> regularDaysList = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.regularDaysColumnInLoan);
			List<WebElement> standardInterestDaysList = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.standardInterestDaysColumnInLoan);

			// Initialize lists for valid and invalid records
			List<String> validRecords = new ArrayList<>();
			List<String> invalidRecords = new ArrayList<>();

			// Iterate through loan records
			for (int i = 0; i < loanRecords.size(); i++) {
				WebElement loanRecord = loanRecords.get(i);
				String color = FundingPage.getColor(loanRecord);

				// Extract Regular Days and Standard Interest Days values
				WebElement regularDaysElement = regularDaysList.get(i);
				WebElement standardInterestDaysElement = standardInterestDaysList.get(i);
				WebElement facilityReferenceElement = facilityReferenceList.get(i);

				int regularDays = Integer.parseInt(regularDaysElement.getText());
				int standardInterestDays = Integer.parseInt(standardInterestDaysElement.getText());
				String facilityReference = facilityReferenceElement.getText();

				// Validate based on color
				if (color.equals("green") && regularDays == actualNumberOfDays && standardInterestDays == 0) {
					validRecords.add("Record " + (i + 1) + ": Regular Days: " + regularDays
							+ ", Standard Interest Days: " + standardInterestDays + ", Color: " + color
							+ ", Facility Reference: " + facilityReference);
				} else if (color.equals("red") && regularDays == 0 && standardInterestDays == actualNumberOfDays) {
					validRecords.add("Record " + (i + 1) + ": Regular Days: " + regularDays
							+ ", Standard Interest Days: " + standardInterestDays + ", Color: " + color
							+ ", Facility Reference: " + facilityReference);
				} else if (color.equals("yellow") && regularDays + standardInterestDays == actualNumberOfDays) {
					validRecords.add("Record " + (i + 1) + ": Regular Days: " + regularDays
							+ ", Standard Interest Days: " + standardInterestDays + ", Color: " + color
							+ ", Facility Reference: " + facilityReference);
				} else {
					invalidRecords.add("Record " + (i + 1) + ": Regular Days: " + regularDays
							+ ", Standard Interest Days: " + standardInterestDays + ", Color: " + color
							+ ", Facility Reference: " + facilityReference);
				}
			}

			// Print valid records
			System.out.println("Valid Records:");
			for (String validRecord : validRecords) {
				System.out.println(validRecord);
				node.log(Status.PASS, validRecord);
			}

			// Print invalid records
			System.out.println("\nInvalid Records:");
			for (String invalidRecord : invalidRecords) {
				System.out.println(invalidRecord);
				node.log(Status.FAIL, invalidRecord);
			}

			// Assert no invalid records
			assert invalidRecords.isEmpty() : "Some records are invalid: " + invalidRecords;

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanColour", "Pass", driver);

		} catch (AssertionError validateLoanColour) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanColour test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanColour_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanColour.printStackTrace();
			node.fail(validateLoanColour);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanColour) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanColour test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanColour_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanColour.printStackTrace();
			node.fail(validateLoanColour);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_252
	@Test(priority = 21)
	public void validateLoanInterestPopupTableColumnsVisibility() throws IOException {

		try {
			extenttest = extent.createTest("Verify the table listing column")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Check the visibility of Reference Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.reference,
					"STEP1 : BUG: The Reference Column is not coming on Loan Interest Details Popup in Step4",
					"STEP1 : EXPECTED: The Reference Column is coming on Loan Interest Details Popup in Step4");

			// Check the visibility of Scheduled Repayment Date Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.scheduledRepaymentDate,
					"STEP2 : BUG: The Scheduled Repayment Date Column is not coming on Loan Interest Details Popup in Step4",
					"STEP2 : EXPECTED: The Scheduled Repayment Date Column is coming on Loan Interest Details Popup in Step4");

			// Check the visibility of Revised Repayment Date Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.revisedRepaymentDate,
					"STEP3 : BUG: The Revised Repayment Date Column is not coming on Loan Interest Details Popup in Step4",
					"STEP3 : EXPECTED: The Revised Repayment Date Column is coming on Loan Interest Details Popup in Step4");

			// Check the visibility of Revision Date Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.revisionDate,
					"STEP4 : BUG: The Revision Date Column is not coming on Loan Interest Details Popup in Step4",
					"STEP4 : EXPECTED: The Revision Date Column is coming on Loan Interest Details Popup in Step4");

			// Check the visibility of Actual Repayment Date Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.actualRepaymentDate,
					"STEP5 : BUG: The Actual Repayment Date Column is not coming on Loan Interest Details Popup in Step4",
					"STEP5 : EXPECTED: The Actual Repayment Date Column is coming on Loan Interest Details Popup in Step4");

			// Check the visibility of Monthly Interest Rate Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.monthlyInterestRate,
					"STEP6 : BUG: The Monthly Interest Rate Column is not coming on Loan Interest Details Popup in Step4",
					"STEP6 : EXPECTED: The Monthly Interest Rate Column is coming on Loan Interest Details Popup in Step4");

			// Check the visibility of Default Interest Rate Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.defaultInterestRate,
					"STEP7 : BUG: The Default Interest Rate Column is not coming on Loan Interest Details Popup in Step4",
					"STEP7 : EXPECTED: The Default Interest Rate Column is coming on Loan Interest Details Popup in Step4");

			// Check the visibility of Regular Days Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.regularDays,
					"STEP8 : BUG: The Regular Days Column is not coming on Loan Interest Details Popup in Step4",
					"STEP8 : EXPECTED: The Regular Days Column is coming on Loan Interest Details Popup in Step4");

			// Check the visibility of Regular Interest Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.regularInterestColumnName,
					"STEP9 : BUG: The Regular Interest Column is not coming on Loan Interest Details Popup in Step4",
					"STEP9 : EXPECTED: The Regular Interest Column is coming on Loan Interest Details Popup in Step4");

			// Check the visibility of Standard Interest Days Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.standardInterestDays,
					"STEP10 : BUG: The Standard Interest Days Column is not coming on Loan Interest Details Popup in Step4",
					"STEP10 : EXPECTED: The Standard Interest Days Column is coming on Loan Interest Details Popup in Step4");

			// Check the visibility of Standard Interest Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.standardInterest,
					"STEP11 : BUG: The Standard Interest Column is not coming on Loan Interest Details Popup in Step4",
					"STEP11 : EXPECTED: The Standard Interest Column is coming on Loan Interest Details Popup in Step4");

			// Check the visibility of Expected Default Interest Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.expectedDefaultInterest,
					"STEP12 : BUG: The Expected Default Interest Column is not coming on Loan Interest Details Popup in Step4",
					"STEP12 : EXPECTED: The Expected Default Interest Column is coming on Loan Interest Details Popup in Step4");

			// Check the visibility of Adjustment Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.adjustment,
					"STEP13 : BUG: The Adjustment Column is not coming on Loan Interest Details Popup in Step4",
					"STEP13 : EXPECTED: The Adjustment Column is coming on Loan Interest Details Popup in Step4");

			// Check the visibility of Default Interest Paid Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.defaultInterestPaidColumnName,
					"STEP14 : BUG: The Default Interest Paid Column is not coming on Loan Interest Details Popup in Step4",
					"STEP14 : EXPECTED: The Default Interest Paid Column is coming on Loan Interest Details Popup in Step4");

			// Check the visibility of Brought Forward Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.broughtForward,
					"STEP15 : BUG: The Brought Forward Column is not coming on Loan Interest Details Popup in Step4",
					"STEP15 : EXPECTED: The Brought Forward Column is coming on Loan Interest Details Popup in Step4");

			// Check the visibility of Carried Forward Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.carriedForwardColumnNames,
					"STEP16 : BUG: The Carried Forward Column is not coming on Loan Interest Details Popup in Step4",
					"STEP16 : EXPECTED: The Carried Forward Column is coming on Loan Interest Details Popup in Step4");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanInterestPopupTableColumnsVisibility", "Pass", driver);

		} catch (AssertionError validateLoanInterestPopupTableColumnsVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanInterestPopupTableColumnsVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanInterestPopupTableColumnsVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanInterestPopupTableColumnsVisibility.printStackTrace();
			node.fail(validateLoanInterestPopupTableColumnsVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanInterestPopupTableColumnsVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanInterestPopupTableColumnsVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanInterestPopupTableColumnsVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanInterestPopupTableColumnsVisibility.printStackTrace();
			node.fail(validateLoanInterestPopupTableColumnsVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_253
	@Test(priority = 22)
	public void validateLoanReferenceNumbersVisibility() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify user is able to see the Loan Referance number under the Referance column")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Check the visibility of Loan Referance number values
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.loanReferencenumbersValues,
					"STEP1 : BUG: The Loan Referance numbers are not coming under the Referance column on Loan Interest Details Popup in Step4",
					"STEP1 : EXPECTED: The Loan Referance numbers are coming under the Referance column on Loan Interest Details Popup in Step4");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanReferenceNumbersVisibility", "Pass", driver);

		} catch (AssertionError validateLoanReferenceNumbersVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanReferenceNumbersVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanReferenceNumbersVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanReferenceNumbersVisibility.printStackTrace();
			node.fail(validateLoanReferenceNumbersVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanReferenceNumbersVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanReferenceNumbersVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanReferenceNumbersVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanReferenceNumbersVisibility.printStackTrace();
			node.fail(validateLoanReferenceNumbersVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_254
	@Test(priority = 23)
	public void validateScheduledRepaymentDateVisibility() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify user is able to see the Scheduled Repayment Date under the Scheduled Repayment Date column")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Check the visibility of Scheduled Repayment Date
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.scheduledRepaymentDateValues,
					"STEP1 : BUG: The Scheduled Repayment Dates are not coming under the Scheduled Repayment Date	column on Loan Interest Details Popup in Step4",
					"STEP1 : EXPECTED: The Scheduled Repayment Dates are coming under the Scheduled Repayment Date column on Loan Interest Details Popup in Step4");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateScheduledRepaymentDateVisibility", "Pass", driver);

		} catch (AssertionError validateScheduledRepaymentDateVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateScheduledRepaymentDateVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateScheduledRepaymentDateVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateScheduledRepaymentDateVisibility.printStackTrace();
			node.fail(validateScheduledRepaymentDateVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateScheduledRepaymentDateVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateScheduledRepaymentDateVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateScheduledRepaymentDateVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateScheduledRepaymentDateVisibility.printStackTrace();
			node.fail(validateScheduledRepaymentDateVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_255
	@Test(priority = 24)
	public void validateRevisedRepaymentDateVisibility() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify user is able to see the Revised Repayment Date under the Revised Repayment Date column")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Check the visibility of Revised Repayment Date
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.revisedRepaymentDateValues,
					"STEP1 : BUG: The Revised Repayment Dates are not coming under the Revised Repayment Date column on Loan Interest Details Popup in Step4",
					"STEP1 : EXPECTED: The Revised Repayment Dates are coming under the Revised Repayment Date column on Loan Interest Details Popup in Step4");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateRevisedRepaymentDateVisibility", "Pass", driver);

		} catch (AssertionError validateRevisedRepaymentDateVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateRevisedRepaymentDateVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRevisedRepaymentDateVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRevisedRepaymentDateVisibility.printStackTrace();
			node.fail(validateRevisedRepaymentDateVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateRevisedRepaymentDateVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateRevisedRepaymentDateVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRevisedRepaymentDateVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRevisedRepaymentDateVisibility.printStackTrace();
			node.fail(validateRevisedRepaymentDateVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_256
	@Test(priority = 25)
	public void validateRevisionDateVisibility() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify user is able to see the Revision Date under the Revision Date column")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Check the visibility of Revision Date
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.revisionDateValues,
					"STEP1 : BUG: The Revision Dates are not coming under the Revision Date column on Loan Interest Details Popup in Step4",
					"STEP1 : EXPECTED: The Revision Dates are coming under the Revision Date column on Loan Interest Details Popup in Step4");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateRevisionDateVisibility", "Pass", driver);

		} catch (AssertionError validateRevisionDateVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateRevisionDateVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRevisionDateVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRevisionDateVisibility.printStackTrace();
			node.fail(validateRevisionDateVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateRevisionDateVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateRevisionDateVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRevisionDateVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRevisionDateVisibility.printStackTrace();
			node.fail(validateRevisionDateVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_257
	@Test(priority = 26)
	public void validateActualRepaymentDateVisibility() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify user is able to see the Actual Repayment Date under the Actual Repayment Date column")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Check the visibility of Actual Repayment Date
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.actualRepaymentDateValues,
					"STEP1 : BUG: The Actual Repayment Dates are not coming under the Actual Repayment Date column on Loan Interest Details Popup in Step4",
					"STEP1 : EXPECTED: The Actual Repayment Dates are coming under the Actual Repayment Date column on Loan Interest Details Popup in Step4");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateActualRepaymentDateVisibility", "Pass", driver);

		} catch (AssertionError validateActualRepaymentDateVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateActualRepaymentDateVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateActualRepaymentDateVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateActualRepaymentDateVisibility.printStackTrace();
			node.fail(validateActualRepaymentDateVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateActualRepaymentDateVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateActualRepaymentDateVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateActualRepaymentDateVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateActualRepaymentDateVisibility.printStackTrace();
			node.fail(validateActualRepaymentDateVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_258
	@Test(priority = 27)
	public void validateMonthlyInterestRate() throws IOException {

		try {
			extenttest = extent.createTest("Verify the Monthly Interest Rate")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			String loanReferenceNumber = getDataFromExcel(13);

			// Create the Dynamic Locator for Reference Number
			String referenceNumberLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.referenceNumber, "locatorValue", loanReferenceNumber);

			// Create the Dynamic Locator for Monthly Interest Rate Value
			String monthlyInterestRateValueLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.monthlyInterestRateValue, "locatorValue", loanReferenceNumber);

			// Get the Reference Number
			String referenceNumber = IElementActions.getElementText_usingXpath(node, driver, referenceNumberLocator);
			node.log(Status.INFO, "STEP1 : Reference Number: " + referenceNumber);
			System.out.println("STEP1 : Reference Number: " + referenceNumber);

			// Calling the getTextAndParseToDouble from Utils and Get the Monthly Interest
			// Rate
			double actualMonthlyInterestRate = Utils.getTextAndParseToDouble(monthlyInterestRateValueLocator);

			// Calling the closePopUp function from FundingPage
			FundingPage.closePopUp();

			// Click on the Database Menu
			Utils.clickOnMenu(node, driver, SideMenuPO.loans);

			// Click on the Database SubMenu
			Utils.clickOnMenu(node, driver, SideMenuPO.loansDatabase);

			// Wait for the visibility of the Bridge Loan Database Header
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the Bridge Loan Database Header");
			System.out.println("STEP2 : Waiting for the visibility of Bridge Loan Database Header");
			IWaitStrategy.waitForVisiblity(node, driver, LoansDatabasePO.bridgeLoanDatabseText);
			node.log(Status.INFO, "STEP3 : Bridge Loan Database Header is visible");
			System.out.println("STEP3 : Bridge Loan Database Header is visible");

			// Calling the openRecordUsingSearch from Utils
			Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, LoansDatabasePO.loanRefSearchField,
					referenceNumber, UtilsPO.editIcon, LoansNewLoanPO.editBridgeLoanHeaderText);

			// Calling the clickOnTab function from Utils
			Utils.clickOnTab(LoansNewLoanPO.summaryTab, LoansNewLoanPO.loanDetailsHeader, "Summary");

			// Check the visibility of Annual Interest Rate Value
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.annualInterestRate,
					"STEP4 : BUG: The Annual Interest Rate Value is not coming under the Summary Tab On Edit Bridge Loan Page",
					"STEP4 : EXPECTED: The Annual Interest Rate Value is coming under the Summary Tab On Edit Bridge Loan Page");

			// Calling the getTextAndParseToDouble from Utils and Get the Annual Interest
			// Rate Value
			double annualInterestRate = Utils.getTextAndParseToDouble(LoansNewLoanPO.annualInterestRate);

			// Calculate Monthly Interest Rate
			double expectedMonthlyInterestRate = annualInterestRate / 12;
			node.log(Status.INFO, "STEP5 : Calculated Expected Monthly Interest Rate : " + expectedMonthlyInterestRate);
			System.out.println("STEP5 : Calculated Expected Monthly Interest Rate : " + expectedMonthlyInterestRate);

			// Assert the Monthly Interest Rate
			IElementActions.assertEquals_usingDouble(node, driver, actualMonthlyInterestRate,
					expectedMonthlyInterestRate,
					"STEP6 : BUG : The Monthly Interest Rate on Loan Interest Details Popup is not same as Calculated from [Annual Interest Rate/12] Formula",
					"STEP6 : PASS : The Monthly Interest Rate on Loan Interest Details Popup is same as Calculated from [Annual Interest Rate/12] Formula");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateMonthlyInterestRate", "Pass", driver);

		} catch (AssertionError validateMonthlyInterestRate) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateMonthlyInterestRate test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateMonthlyInterestRate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMonthlyInterestRate.printStackTrace();
			node.fail(validateMonthlyInterestRate);
			Assert.fail();
			extent.flush();

		} catch (Exception validateMonthlyInterestRate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateMonthlyInterestRate test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateMonthlyInterestRate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMonthlyInterestRate.printStackTrace();
			node.fail(validateMonthlyInterestRate);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_259
	@Test(priority = 28)
	public void validateDefaultInterestRate() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify the Default Interest Rate under the Default Interest column from the  Edit Bridge Loan, Loan tab")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			String loanReferenceNumber = getDataFromExcel(13);

			// Create the Dynamic Locator for Reference Number
			String referenceNumberLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.referenceNumber, "locatorValue", loanReferenceNumber);

			// Create the Dynamic Locator for Default Interest Rate Value
			String defaultInterestRateValueLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.defaultInterestRateValue, "locatorValue", loanReferenceNumber);

			// Get the referenceNumber
			String referenceNumber = IElementActions.getElementText_usingXpath(node, driver, referenceNumberLocator);
			node.log(Status.INFO, "STEP1 : Reference Number: " + referenceNumber);
			System.out.println("STEP1 : Reference Number: " + referenceNumber);

			// Get the Default Interest Rate
			String defaultInterestRateOnLoanInterestPopup = IElementActions.getElementText_usingXpath(node, driver,
					defaultInterestRateValueLocator);
			node.log(Status.INFO, "STEP2 : The First Default Interest Rate On Loan Interest Popup : "
					+ defaultInterestRateOnLoanInterestPopup);
			System.out.println("STEP2 : The First Default Interest Rate On Loan Interest Popup : "
					+ defaultInterestRateOnLoanInterestPopup);

			// Calling the closePopUp function from FundingPage
			FundingPage.closePopUp();

			// Click on the Database Menu
			Utils.clickOnMenu(node, driver, SideMenuPO.loans);

			// Click on the Database SubMenu
			Utils.clickOnMenu(node, driver, SideMenuPO.loansDatabase);

			// Wait for the visibility of the Bridge Loan Database Header
			node.log(Status.INFO, "STEP3 : Waiting for the visibility of the Bridge Loan Database Header");
			System.out.println("STEP3 : Waiting for the visibility of Bridge Loan Database Header");
			IWaitStrategy.waitForVisiblity(node, driver, LoansDatabasePO.bridgeLoanDatabseText);
			node.log(Status.INFO, "STEP4 : Bridge Loan Database Header is visible");
			System.out.println("STEP4 : Bridge Loan Database Header is visible");

			// Calling the openRecordUsingSearch from Utils
			Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, LoansDatabasePO.loanRefSearchField,
					referenceNumber, UtilsPO.editIcon, LoansNewLoanPO.editBridgeLoanHeaderText);

			// Calling the clickOnTab function from Utils
			Utils.clickOnTab(LoansNewLoanPO.loanTab, LoansNewLoanPO.loanDisbursementHeader, "Loan");

			// Scrolloed down to Interest Rates Section Header
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, LoansNewLoanPO.interestRatesSectionHeader);
			node.log(Status.INFO, "STEP5 : Scrolloed down to Interest Rates Section Header");
			System.out.println("STEP5 : Scrolloed down to Interest Rates Section Header");

			// Check the visibility of Default Interest Rate Value
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.defaultInterestRateField,
					"STEP6 : BUG: The Default Interest Rate Value is not coming under the Loan Tab On Edit Bridge Loan Page",
					"STEP6 : EXPECTED: The Default Interest Rate Value is coming under the Loan Tab On Edit Bridge Loan Page");

			// Check the visibility of Default Interest Rate Edit icon
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.defaultInterestRateEditIcon,
					"STEP7 : BUG: The Default Interest Rate Edit icon is not coming under the Loan Tab On Edit Bridge Loan Page",
					"STEP7 : EXPECTED: The Default Interest Rate Edit icon is coming under the Loan Tab On Edit Bridge Loan Page");

			// Clicked on Edit icon
			IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.defaultInterestRateEditIcon);
			node.log(Status.INFO, "STEP8 : Clicked on Default Interest Rate Edit icon");
			System.out.println("STEP8 : Clicked on Default Interest Rate Edit icon");

			// Get the Default Interest Rate
			Thread.sleep(3000);
			String defaultInterestRateUnderLoanTab = IElementActions.getElementText_usingXpath(node, driver,
					LoansNewLoanPO.currentValueField);
			node.log(Status.INFO,
					"STEP9 : The Default Interest Rate under Loan Tab : " + defaultInterestRateUnderLoanTab);
			System.out.println("STEP9 : The Default Interest Rate under Loan Tab : " + defaultInterestRateUnderLoanTab);

			// Assert the Default Interest Rate
			IElementActions.assertEquals_usingString(node, driver, defaultInterestRateOnLoanInterestPopup,
					defaultInterestRateUnderLoanTab,
					"STEP10 : BUG : The Default Interest Rate on Loan Interest Details Popup is not same as Default Interest Rate under Loan Tab on Edit Bridge Loan Page",
					"STEP10 : PASS : The Default Interest Rate on Loan Interest Details Popup is same as Default Interest Rate under Loan Tab on Edit Bridge Loan Page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDefaultInterestRate", "Pass", driver);

		} catch (AssertionError validateDefaultInterestRate) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDefaultInterestRate test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDefaultInterestRate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDefaultInterestRate.printStackTrace();
			node.fail(validateDefaultInterestRate);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDefaultInterestRate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDefaultInterestRate test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDefaultInterestRate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDefaultInterestRate.printStackTrace();
			node.fail(validateDefaultInterestRate);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_260
	// TC_InterestPayment_Step4_262
	@Test(priority = 29)
	public void validateRegularAndStandardDays() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify the Regular Days under the Regular Days column is calculated by Regular Days + Standard Interest Days <= This Period Number Of Days"
							+ "Verify the Standard Interest days under the Regular Days column is calculated by Regular Days + Standard Interest Days <= This Period Number Of Days")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the getTextAndParseToInt from Utils and Get the This Period Number Of
			// Days
			int actualNumberOfDays = Utils.getTextAndParseToInt(FundingInterestPaymentPO.thisPeriodNumberOfDaysValue);

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Locate the elements listing loan records
			List<WebElement> loanRecords = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.rowsInLoan);
			List<WebElement> facilityReferenceList = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.referenceColumnInLoan);

			// Extract Regular Days and Standard Interest Days values from lists
			List<WebElement> regularDaysList = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.regularDaysColumnInLoan);
			List<WebElement> standardInterestDaysList = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.standardInterestDaysColumnInLoan);

			// Initialize lists for valid and invalid records
			List<String> validRecords = new ArrayList<>();
			List<String> invalidRecords = new ArrayList<>();

			// Iterate through loan records
			for (int i = 0; i < loanRecords.size(); i++) {
				WebElement loanRecord = loanRecords.get(i);

				// Extract Regular Days and Standard Interest Days values
				WebElement regularDaysElement = regularDaysList.get(i);
				WebElement standardInterestDaysElement = standardInterestDaysList.get(i);
				WebElement facilityReferenceElement = facilityReferenceList.get(i);

				int regularDays = Integer.parseInt(regularDaysElement.getText());
				int standardInterestDays = Integer.parseInt(standardInterestDaysElement.getText());
				String facilityReference = facilityReferenceElement.getText();

				// Validate based on color
				if (regularDays == actualNumberOfDays && standardInterestDays == 0) {
					validRecords
							.add("Record " + (i + 1) + ": Regular Days: " + regularDays + ", Standard Interest Days: "
									+ standardInterestDays + ", Facility Reference: " + facilityReference);
				} else if (regularDays == 0 && standardInterestDays == actualNumberOfDays) {
					validRecords
							.add("Record " + (i + 1) + ": Regular Days: " + regularDays + ", Standard Interest Days: "
									+ standardInterestDays + ", Facility Reference: " + facilityReference);
				} else if (regularDays + standardInterestDays == actualNumberOfDays) {
					validRecords
							.add("Record " + (i + 1) + ": Regular Days: " + regularDays + ", Standard Interest Days: "
									+ standardInterestDays + ", Facility Reference: " + facilityReference);
				} else {
					invalidRecords
							.add("Record " + (i + 1) + ": Regular Days: " + regularDays + ", Standard Interest Days: "
									+ standardInterestDays + ", Facility Reference: " + facilityReference);
				}
			}

			// Print valid records
			System.out.println("Valid Records:");
			for (String validRecord : validRecords) {
				System.out.println(validRecord);
				node.log(Status.PASS, validRecord);
			}

			// Print invalid records
			System.out.println("\nInvalid Records:");
			for (String invalidRecord : invalidRecords) {
				System.out.println(invalidRecord);
				node.log(Status.FAIL, invalidRecord);
			}

			// Assert no invalid records
			assert invalidRecords.isEmpty() : "Some records are invalid: " + invalidRecords;

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanColour", "Pass", driver);

		} catch (AssertionError validateRegularAndStandardDays) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateRegularAndStandardDays test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRegularAndStandardDays_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRegularAndStandardDays.printStackTrace();
			node.fail(validateRegularAndStandardDays);
			Assert.fail();
			extent.flush();

		} catch (Exception validateRegularAndStandardDays) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateRegularAndStandardDays test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRegularAndStandardDays_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRegularAndStandardDays.printStackTrace();
			node.fail(validateRegularAndStandardDays);
			Assert.fail();
			extent.flush();

			// TODO: handle exception
		}

	}

	// TC_InterestPayment_Step4_261
	@Test(priority = 30)
	public void validateRegularInterest() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify the Regular Interest under the Regular Interest column Regular Interest = ((Monthly Interest Rate / Regular days)* Loan Current Amount)* Regular Days)")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			String loanReferenceNumber = getDataFromExcel(13);

			// Create the Dynamic Locator for Reference Number
			String referenceNumberLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.referenceNumber, "locatorValue", loanReferenceNumber);

			// Create the Dynamic Locator for Monthly Interest Rate Value
			String monthlyInterestRateValueLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.monthlyInterestRateValue, "locatorValue", loanReferenceNumber);

			// Create the Dynamic Locator for Regular Days Value Locator
			String regularDaysValueLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.regularDaysValue, "locatorValue", loanReferenceNumber);

			// Create the Dynamic Locator for Regular Interest Value Locator
			String regularInterestValueLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.regularInterestValue, "locatorValue", loanReferenceNumber);

			// Get the referenceNumber
			String referenceNumber = IElementActions.getElementText_usingXpath(node, driver, referenceNumberLocator);
			node.log(Status.INFO, "STEP1 : Reference Number: " + referenceNumber);
			System.out.println("STEP1 : Reference Number: " + referenceNumber);

			// Get the Monthly Interest Rate
			double monthlyInterestRate = Utils.getTextAndParseToDouble(monthlyInterestRateValueLocator);

			// Get the Regular Days Value
			double regularDays = Utils.getTextAndParseToDouble(regularDaysValueLocator);

			// Get the Regular Interest Value
			double actualRegularInterest = Utils.getTextAndParseToDouble(regularInterestValueLocator);

			// Calling the closePopUp function from FundingPage
			FundingPage.closePopUp();

			// Click on the Database Menu
			Utils.clickOnMenu(node, driver, SideMenuPO.loans);

			// Click on the Database SubMenu
			Utils.clickOnMenu(node, driver, SideMenuPO.loansDatabase);

			// Wait for the visibility of the Bridge Loan Database Header
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the Bridge Loan Database Header");
			System.out.println("STEP2 : Waiting for the visibility of Bridge Loan Database Header");
			IWaitStrategy.waitForVisiblity(node, driver, LoansDatabasePO.bridgeLoanDatabseText);
			node.log(Status.INFO, "STEP3 : Bridge Loan Database Header is visible");
			System.out.println("STEP3 : Bridge Loan Database Header is visible");

			// Calling the openRecordUsingSearch from Utils
			Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, LoansDatabasePO.loanRefSearchField,
					referenceNumber, UtilsPO.editIcon, LoansNewLoanPO.editBridgeLoanHeaderText);

			// Calling the clickOnTab function from Utils
			Utils.clickOnTab(LoansNewLoanPO.loanTab, LoansNewLoanPO.loanDisbursementHeader, "Loan");

			// Check the visibility of Current Amount Value
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.currentAmountValue,
					"STEP4 : BUG: The Current Amount Value is not coming under Loan Tab on Edit Bridge Loan Page",
					"STEP4 : EXPECTED: The Current Amount Value is coming under Loan Tab on Edit Bridge Loan Page");

			// Get the Current Amount Value
			double currentAmount = Utils.getTextAndParseToDouble(LoansNewLoanPO.currentAmountValue);

			double expectedRegularInterest = 0;
			// Check if the divisor is not zero to avoid division by zero
			if (regularDays != 0L) {

				expectedRegularInterest = ((monthlyInterestRate / regularDays) * currentAmount) * regularDays;

				// Print the result
				node.log(Status.INFO, "STEP5 : The Regular Interest calculated value is " + expectedRegularInterest);
				System.out.println("STEP5 : The Regular Interest calculated value is " + expectedRegularInterest);

			} else {
				node.log(Status.FAIL, "Error: Division by zero is not allowed.");
				System.out.println("Error: Division by zero is not allowed.");

			}

			// Assert the Regular Interest
			IElementActions.assertEquals_usingDouble(node, driver, actualRegularInterest, expectedRegularInterest,
					"STEP6 : BUG : The Regular Interest under the Regular Interest column on Loan Interest Details Popup is not same as Calculated from ((Monthly Interest Rate / Regular days)* Loan Current Amount)* Regular Days)] Formula",
					"STEP6 : PASS : The Regular Interest under the Regular Interest column on Loan Interest Details Popup is same as Calculated from ((Monthly Interest Rate / Regular days)* Loan Current Amount)* Regular Days)] Formula Formula");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateRegularInterest", "Pass", driver);

		} catch (AssertionError validateRegularInterest) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateRegularInterest test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateRegularInterest_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRegularInterest.printStackTrace();
			node.fail(validateRegularInterest);
			Assert.fail();
			extent.flush();

		} catch (Exception validateRegularInterest) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateRegularInterest test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateRegularInterest_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRegularInterest.printStackTrace();
			node.fail(validateRegularInterest);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_263
	@Test(priority = 31)
	public void validateStandardInterest() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify the Standard Interest under the Standard Interest column Standard Interest = ((Monthly Interest Rate / Stardard Interest Days)* Current Amount)* Stardard Interest Days")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			String loanReferenceNumber = getDataFromExcel(13);

			// Create the Dynamic Locator for Reference Number
			String referenceNumberLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.referenceNumber, "locatorValue", loanReferenceNumber);

			// Create the Dynamic Locator for Monthly Interest Rate Value
			String monthlyInterestRateValueLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.monthlyInterestRateValue, "locatorValue", loanReferenceNumber);

			// Create the Dynamic Locator for Standard Interest Days value
			String standardInterestDaysValueLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.standardInterestDaysValue, "locatorValue", loanReferenceNumber);

			// Create the Dynamic Locator for Standard Interest
			String standardInterestValueLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.standardInterestValue, "locatorValue", loanReferenceNumber);

			// Get the referenceNumber
			String referenceNumber = IElementActions.getElementText_usingXpath(node, driver, referenceNumberLocator);
			node.log(Status.INFO, "STEP1 : Reference Number: " + referenceNumber);
			System.out.println("STEP1 : Reference Number: " + referenceNumber);

			// Get the Monthly Interest Rate
			double monthlyInterestRate = Utils.getTextAndParseToDouble(monthlyInterestRateValueLocator);

			// Get the Standard Interest Days Value
			double standardInterestDays = Utils.getTextAndParseToDouble(standardInterestDaysValueLocator);

			// Get the Standard Interest Value
			double actualStandardInterest = Utils.getTextAndParseToDouble(standardInterestValueLocator);

			// Calling the closePopUp function from FundingPage
			FundingPage.closePopUp();

			// Click on the Database Menu
			Utils.clickOnMenu(node, driver, SideMenuPO.loans);

			// Click on the Database SubMenu
			Utils.clickOnMenu(node, driver, SideMenuPO.loansDatabase);

			// Wait for the visibility of the Bridge Loan Database Header
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the Bridge Loan Database Header");
			System.out.println("STEP2 : Waiting for the visibility of Bridge Loan Database Header");
			IWaitStrategy.waitForVisiblity(node, driver, LoansDatabasePO.bridgeLoanDatabseText);
			node.log(Status.INFO, "STEP3 : Bridge Loan Database Header is visible");
			System.out.println("STEP3 : Bridge Loan Database Header is visible");

			// Calling the openRecordUsingSearch from Utils
			Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, LoansDatabasePO.loanRefSearchField,
					referenceNumber, UtilsPO.editIcon, LoansNewLoanPO.editBridgeLoanHeaderText);

			// Calling the clickOnTab function from Utils
			Utils.clickOnTab(LoansNewLoanPO.loanTab, LoansNewLoanPO.loanDisbursementHeader, "Loan");

			// Check the visibility of Current Amount Value
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.currentAmountValue,
					"STEP4 : BUG: The Current Amount Value is not coming under Loan Tab on Edit Bridge Loan Page",
					"STEP4 : EXPECTED: The Current Amount Value is coming under Loan Tab on Edit Bridge Loan Page");

			// Get the Current Amount Value
			double currentAmount = Utils.getTextAndParseToDouble(LoansNewLoanPO.currentAmountValue);

			double expectedStandardInterest = 0;
			// Check if the divisor is not zero to avoid division by zero
			if (standardInterestDays != 0L) {

				expectedStandardInterest = ((monthlyInterestRate / standardInterestDays) * currentAmount)
						* standardInterestDays;

				// Print the result
				node.log(Status.INFO, "STEP5 : The Standard Interest calculated value is " + expectedStandardInterest);
				System.out.println("STEP5 : The Standard Interest calculated value is " + expectedStandardInterest);

			} else {
				node.log(Status.FAIL, "Error: Division by zero is not allowed.");
				System.out.println("Error: Division by zero is not allowed.");

			}

			// Assert the Standard Interest
			IElementActions.assertEquals_usingDouble(node, driver, actualStandardInterest, expectedStandardInterest,
					"STEP6 : BUG : The Standard Interest under the Standard Interest column on Loan Interest Details Popup is not same as Calculated from [((Monthly Interest Rate / Stardard Interest Days)* Current Amount)* Stardard Interest Days] Formula",
					"STEP6 : PASS : The Standard Interest under the Standard Interest column on Loan Interest Details Popup is same as Calculated from [((Monthly Interest Rate / Stardard Interest Days)* Current Amount)* Stardard Interest Days] Formula");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateStandardInterest", "Pass", driver);

		} catch (AssertionError validateStandardInterest) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateStandardInterest test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateStandardInterest_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateStandardInterest.printStackTrace();
			node.fail(validateStandardInterest);
			Assert.fail();
			extent.flush();

		} catch (Exception validateStandardInterest) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateStandardInterest test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateStandardInterest_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateStandardInterest.printStackTrace();
			node.fail(validateStandardInterest);
			Assert.fail();
			extent.flush();

			// TODO: handle exception
		}
	}

	// TC_InterestPayment_Step4_265
	@Test(priority = 32)
	public void validateBroughtForward() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify the Brought Forward under the Brought Forward column is equal to last month’s Carried Forward.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Month
			String month = getDataFromExcel(7);

			// Converting string to integer
			int monthNum = Integer.parseInt(month);
			monthNum = monthNum - 1;

			// Method 1: Using toString() method
			String previousMonth = Integer.toString(monthNum);

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			String loanReferenceNumber = getDataFromExcel(13);

			// Create the Dynamic Locator for Brought Forward Value
			String broughtForwardValueLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.broughtForwardValue, "locatorValue", loanReferenceNumber);

			// Create the Dynamic Locator for Carried Forward Value
			String carriedForwardValueLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.carriedForwardVal, "locatorValue", loanReferenceNumber);

			// Get the Brought Forward Value
			String broughtForwardValue = IElementActions.getElementText_usingXpath(node, driver,
					broughtForwardValueLocator);
			node.log(Status.INFO,
					"STEP1 : The Brought Forward Value On Loan Interest Details Popup : " + broughtForwardValue);
			System.out.println(
					"STEP1 : The Brought Forward Value On Loan Interest Details Popup : " + broughtForwardValue);

			// Calling the closePopUp function from FundingPage
			FundingPage.closePopUp();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), previousMonth);

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Get the Carried Forward Value
			String carriedForwardValue = IElementActions.getElementText_usingXpath(node, driver,
					carriedForwardValueLocator);
			node.log(Status.INFO,
					"STEP2 : The Carried Forward Value On Loan Interest Details Popup : " + carriedForwardValue);
			System.out.println(
					"STEP2 : The Carried Forward Value On Loan Interest Details Popup : " + carriedForwardValue);

			// Assert the Brought Forward Value
			IElementActions.assertEquals_usingString(node, driver, broughtForwardValue, carriedForwardValue,
					"STEP3 : BUG : The Brought Forward Value under the Brought Forward column is not equal to last month’s Carried Forward Value under the Carried Forward column",
					"STEP3 : PASS : The Brought Forward Value under the Brought Forward column is equal to last month’s Carried Forward Value under the Carried Forward column");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateBroughtForward", "Pass", driver);

		} catch (AssertionError validateBroughtForward) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateBroughtForward test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateBroughtForward_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBroughtForward.printStackTrace();
			node.fail(validateBroughtForward);
			Assert.fail();
			extent.flush();

		} catch (Exception validateBroughtForward) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateBroughtForward test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateBroughtForward_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBroughtForward.printStackTrace();
			node.fail(validateBroughtForward);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_266
	@Test(priority = 33)
	public void validateCarriedForwardforLoan() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify the Carried Forward under the Carried Forward column for loan is calculated by Brought Forward + Standard Interest - Default Interest Paid")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			String loanReferenceNumber = getDataFromExcel(13);

			// Create the Dynamic Locator for Brought Forward Value
			String broughtForwardValueLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.broughtForwardValue, "locatorValue", loanReferenceNumber);

			// Create the Dynamic Locator for Carried Forward Value
			String carriedForwardValueLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.carriedForwardVal, "locatorValue", loanReferenceNumber);

			// Create the Dynamic Locator for Standard Interest Value
			String standardInterestValueLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.standardInterestValue, "locatorValue", loanReferenceNumber);

			// Create the Dynamic Locator for Default Interest Paid Value
			String defaultInterestPaidValueLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.defaultInterestPaidVal, "locatorValue", loanReferenceNumber);

			// Get the Brought Forward
			int broughtForward = Utils.getTextAndParseToInt(broughtForwardValueLocator);

			// Get the Standard Interest
			int standardInterest = Utils.getTextAndParseToInt(standardInterestValueLocator);

			// Get the Default Interest Paid
			int defaultInterestPaid = Utils.getTextAndParseToInt(defaultInterestPaidValueLocator);

			// Get the Actual Carried Forward
			int actualCarriedForward = Utils.getTextAndParseToInt(carriedForwardValueLocator);

			// Calling the calculateAddition function from Utils
			int expectedCarriedForward = Utils.calculateAddition(broughtForward, standardInterest)
					- defaultInterestPaid;
			node.log(Status.INFO, "STEP1 : Calculated Carried Forward Value : " + expectedCarriedForward);
			System.out.println("STEP1 : Calculated Carried Forward Value : " + expectedCarriedForward);

			// Assert the Carried Forward Value
			IElementActions.assertEquals_usingInteger(node, driver, actualCarriedForward, expectedCarriedForward,
					"STEP2 : BUG : The Carried Forward for loan is not same as calculated from [Brought Forward + Standard Interest - Default Interest Paid] Formula",
					"STEP2 : PASS : The Carried Forward for loan is same as calculated from [Brought Forward + Standard Interest - Default Interest Paid] Formula");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCarriedForwardforLoan", "Pass", driver);

		} catch (AssertionError validateCarriedForwardforLoan) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCarriedForwardforLoan test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCarriedForwardforLoan_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCarriedForwardforLoan.printStackTrace();
			node.fail(validateCarriedForwardforLoan);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCarriedForwardforLoan) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCarriedForwardforLoan test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCarriedForwardforLoan_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCarriedForwardforLoan.printStackTrace();
			node.fail(validateCarriedForwardforLoan);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_267
	@Test(priority = 34)
	public void validateCarriedForwardforFacility() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify the Carried Forward under the Carried Forward column for facility is calculated by Carried Over + Default Interest - Default Interest Paid")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			String loanReferenceNumber = getDataFromExcel(13);

			// Create the Dynamic Locator for Carried Over Value
			String carriedOverValueLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.carriedOverValue, "locatorValue", loanReferenceNumber);

			// Create the Dynamic Locator for Default Interest Value
			String defaultInterestValueLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.defaultInterestValue, "locatorValue", loanReferenceNumber);

			// Create the Dynamic Locator for Default Interest Paid Value
			String defaultInterestPaidValueLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.defaultInterestPaidValue, "locatorValue", loanReferenceNumber);

			// Create the Dynamic Locator for Carried Forward Value
			String carriedForwardValueLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.carriedForwardValue, "locatorValue", loanReferenceNumber);

			// Get the Carried Over Value
			int carriedOver = Utils.getTextAndParseToInt(carriedOverValueLocator);

			// Get the Default Interest Value
			int defaultInterest = Utils.getTextAndParseToInt(defaultInterestValueLocator);

			// Get the Default Interest Paid Value
			int defaultInterestPaid = Utils.getTextAndParseToInt(defaultInterestPaidValueLocator);

			// Get the Carried Forward Value
			int actualCarriedForward = Utils.getTextAndParseToInt(carriedForwardValueLocator);

			// Calling the calculateAddition function from Utils
			int expectedCarriedForward = Utils.calculateAddition(carriedOver, defaultInterest) - defaultInterestPaid;
			node.log(Status.INFO, "STEP1 : Calculated Carried Forward Value : " + expectedCarriedForward);
			System.out.println("STEP1 : Calculated Carried Forward Value : " + expectedCarriedForward);

			// Assert the Carried Forward Value
			IElementActions.assertEquals_usingInteger(node, driver, actualCarriedForward, expectedCarriedForward,
					"STEP2 : BUG : The Carried Forward for Facility is not same as calculated from [Carried Over + Default Interest - Default Interest Paid] Formula",
					"STEP2 : PASS : The Carried Forward for Facility is same as calculated from [Carried Over + Default Interest - Default Interest Paid] Formula");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCarriedForwardforFacility", "Pass", driver);

		} catch (AssertionError validateCarriedForwardforFacility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCarriedForwardforFacility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCarriedForwardforFacility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCarriedForwardforFacility.printStackTrace();
			node.fail(validateCarriedForwardforFacility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCarriedForwardforFacility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCarriedForwardforFacility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCarriedForwardforFacility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCarriedForwardforFacility.printStackTrace();
			node.fail(validateCarriedForwardforFacility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_268
	@Test(priority = 35)
	public void validateInterestPaymentDetailsPopup() throws IOException {

		try {
			extenttest = extent.createTest("Verify the 'Interest Payment Details' popup")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Check the visibility of Facility Details Section
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.facilityDetailsSection,
					"STEP1 : BUG: The Facility Details Section is not coming on Interest Payment Details Popup in Step4",
					"STEP1 : EXPECTED: The Facility Details Section is coming on Interest Payment Details Popup in Step4");

			// Check the visibility of Month on Month Comparison Section
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.monthonMonthComparisonSection,
					"STEP2 : BUG: The Month on Month Comparison Section is not coming on Interest Payment Details Popup in Step4",
					"STEP2 : EXPECTED: The Month on Month Comparison Section is coming on Interest Payment Details Popup in Step4");

			// Check the visibility of Current Month Calculations Section
			IElementActions.assertTrue_usingXpath(node, driver,
					FundingInterestPaymentPO.currentMonthCalculationsSection,
					"STEP3 : BUG: The Current Month Calculations Section is not coming on Interest Payment Details Popup in Step4",
					"STEP3 : EXPECTED: The Current Month Calculations Section is coming on Interest Payment Details Popup in Step4");

			// Check the visibility of Facility Details Table
			IElementActions.assertTrue_usingXpath(node, driver,
					FundingInterestPaymentPO.interestPaymentDetailsPopupTable,
					"STEP4 : BUG: The Facility Details Table is not coming on Interest Payment Details Popup in Step4",
					"STEP4 : EXPECTED: The Facility Details Table is coming on Interest Payment Details Popup in Step4");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateInterestPaymentDetailsPopup", "Pass", driver);

		} catch (AssertionError validateInterestPaymentDetailsPopup) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInterestPaymentDetailsPopup test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestPaymentDetailsPopup_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestPaymentDetailsPopup.printStackTrace();
			node.fail(validateInterestPaymentDetailsPopup);
			Assert.fail();
			extent.flush();

		} catch (Exception validateInterestPaymentDetailsPopup) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInterestPaymentDetailsPopup test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestPaymentDetailsPopup_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestPaymentDetailsPopup.printStackTrace();
			node.fail(validateInterestPaymentDetailsPopup);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_269
	@Test(priority = 36)
	public void validateFacilityDetailsSection() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the following details are displayed to the user in the Facility Details section:"
							+ "-Facility Reference" + "-Start Period" + "-End Period" + "-Facility Amount"
							+ "-Drawn Amount" + "-Cash Rate")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Check the visibility of Facility Reference
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.facilityReference,
					"STEP1 : BUG: The Facility Reference is not coming under Facility Details Section on Interest Payment Details Popup in Step4",
					"STEP1 : EXPECTED: The Facility Reference is coming under Facility Details Section on Interest Payment Details Popup in Step4");

			// Check the visibility of Start Period
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.startPeriod,
					"STEP2 : BUG: The Start Period is not coming under Facility Details Section on Interest Payment Details Popup in Step4",
					"STEP2 : EXPECTED: The Start Period is coming under Facility Details Section on Interest Payment Details Popup in Step4");

			// Check the visibility of End Period
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.endPeriod,
					"STEP3 : BUG: The End Period is not coming under Facility Details Section on Interest Payment Details Popup in Step4",
					"STEP3 : EXPECTED: The End Period is coming under Facility Details Section on Interest Payment Details Popup in Step4");

			// Check the visibility of Facility Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.facilityAmount,
					"STEP4 : BUG: The Facility Amount is not coming under Facility Details Section on Interest Payment Details Popup in Step4",
					"STEP4 : EXPECTED: The Facility Amount is coming under Facility Details Section on Interest Payment Details Popup in Step4");

			// Check the visibility of Drawn Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.drawnAmount,
					"STEP5 : BUG: The Drawn Amount is not coming under Facility Details Section on Interest Payment Details Popup in Step4",
					"STEP5 : EXPECTED: The Drawn Amount is coming under Facility Details Section on Interest Payment Details Popup in Step4");

			// Check the visibility of Cash Rate
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.cashRate,
					"STEP6 : BUG: The Cash Rate is not coming under Facility Details Section on Interest Payment Details Popup in Step4",
					"STEP6 : EXPECTED: The Cash Rate is coming under Facility Details Section on Interest Payment Details Popup in Step4");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityDetailsSection", "Pass", driver);

		} catch (AssertionError validateFacilityDetailsSection) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityDetailsSection test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityDetailsSection_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityDetailsSection.printStackTrace();
			node.fail(validateFacilityDetailsSection);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityDetailsSection) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityDetailsSection test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityDetailsSection_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityDetailsSection.printStackTrace();
			node.fail(validateFacilityDetailsSection);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_270
	@Test(priority = 37)
	public void validateFieldDetails() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the correct details are visible to the user for the fields below:"
							+ "- Facility Reference" + "- Start Period" + "- End Period" + "")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			String facility = getDataFromExcel(9);

			// Create the Dynamic Locator for Facility
			String facilityLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.facilityRefInFacilityTable, "locatorValue", facility);

			// Check the visibility of Facility Reference Value
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.facilityReferenceValue,
					"STEP1 : BUG: The Facility Reference Value is not coming under Facility Details Section on Interest Payment Details Popup in Step4",
					"STEP1 : EXPECTED: The Facility Reference Value is coming under Facility Details Section on Interest Payment Details Popup in Step4");

			// Get the Facility Reference Value
			String actualfacilityReference = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.facilityReferenceValue);
			node.log(Status.INFO, "STEP2 : Facility Reference on Interest Payment Details Popup in Step4 : "
					+ actualfacilityReference);
			System.out.println("STEP2 : Facility Reference on Interest Payment Details Popup in Step4: "
					+ actualfacilityReference);

			/// Check the visibility of Start Period Date
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.startPeriodDate,
					"STEP3 : BUG: The Start Period Date is not coming under Facility Details Section on Interest Payment Details Popup in Step4",
					"STEP3 : EXPECTED: The Start Period Date is coming under Facility Details Section on Interest Payment Details Popup in Step4");

			// Get the Start Period Date
			String startPeriodDateValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.startPeriodDate);
			node.log(Status.INFO,
					"STEP4 : Start Period Date on Interest Payment Details Popup in Step4 : " + startPeriodDateValue);
			System.out.println(
					"STEP4 : Start Period Date on Interest Payment Details Popup in Step4 : " + startPeriodDateValue);

			// Calling the convertDashDateToSlash from Utils
			String startPeriodDate = Utils.convertDashDateToSlash(startPeriodDateValue);

			// Check the visibility of End Period Date
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.endPeriodDate,
					"STEP5 : BUG: The End Period Date is not coming under Facility Details Section on Interest Payment Details Popup in Step4",
					"STEP5 : EXPECTED: The End Period Date is coming under Facility Details Section on Interest Payment Details Popup in Step4");

			// Get the End Period Date
			String endPeriodDateValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.endPeriodDate);
			node.log(Status.INFO,
					"STEP6 : End Period Date on Interest Payment Details Popup in Step4 : " + endPeriodDateValue);
			System.out.println(
					"STEP6 : End Period Date on Interest Payment Details Popup in Step4 : " + endPeriodDateValue);

			// Calling the convertDashDateToSlash from Utils
			String endPeriodDate = Utils.convertDashDateToSlash(endPeriodDateValue);

			// Calling the closePopUp function from Funding Page
			FundingPage.closePopUp();

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.healthStep2);

			// Get the Facility in Step2
			String facilityReferenceInStep2 = IElementActions.getElementText_usingXpath(node, driver, facilityLocator);
			node.log(Status.INFO, "STEP7 : The Faclity in Step2 : " + facilityReferenceInStep2);
			System.out.println("STEP7 : The Faclity in Step2 : " + facilityReferenceInStep2);

			// Get the Calculation Start date in Stpe2
			String calculationStartDateInStep2 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.calculationStartDateField);
			node.log(Status.INFO, "STEP8 : Calculation Start Date in Step2 : " + calculationStartDateInStep2);
			System.out.println("STEP8 : Calculation Start Date in Step2 : " + calculationStartDateInStep2);

			// Get the Calculation End date in Step2
			String calculationEndDateInStep2 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.calculationEndDateField);
			node.log(Status.INFO, "STEP9 : Calculation End Date in Step2 : " + calculationEndDateInStep2);
			System.out.println("STEP9 : Calculation End Date in Step2 : " + calculationEndDateInStep2);

			// Assert the Facility Reference
			IElementActions.assertEquals_usingString(node, driver, actualfacilityReference, facilityReferenceInStep2,
					"STEP10 : BUG : The Facility Reference on Interest Payment Details Popup is not same as in Step2",
					"STEP10 : PASS : The Facility Reference on Interest Payment Details Popup is same as in Step2");

			// Assert the Start Period Date
			IElementActions.assertEquals_usingString(node, driver, startPeriodDate, calculationStartDateInStep2,
					"STEP11 : BUG : The Start Period Date on Interest Payment Details Popup is not same as Calculation Start Date in Step2",
					"STEP11 : PASS : The Start Period Date on Interest Payment Details Popup is same as Calculation Start Date in Step2");

			// Assert the End Period Date
			IElementActions.assertEquals_usingString(node, driver, endPeriodDate, calculationEndDateInStep2,
					"STEP12 : BUG : The End Period Date on Interest Payment Details Popup is not same as Calculation End Date in Step2",
					"STEP12 : PASS : The End Period Date on Interest Payment Details Popup is same as Calculation End Date in Step2");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFieldDetails", "Pass", driver);

		} catch (AssertionError validateFieldDetails) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFieldDetails test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFieldDetails_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFieldDetails.printStackTrace();
			node.fail(validateFieldDetails);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFieldDetails) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFieldDetails test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFieldDetails_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFieldDetails.printStackTrace();
			node.fail(validateFieldDetails);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_271
	@Test(priority = 38)
	public void validateFacilityAmount() throws IOException {

		try {
			extenttest = extent.createTest("Verify that the Facility Amount")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			String facility = getDataFromExcel(9);

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Get the Facility Amount
			String facilityAmountOnInterestPaymentDetailsPopup = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.facilityAmountValue);
			node.log(Status.INFO, "STEP1 : Facility Amount on Interest Payment Details Popup in Step4 : "
					+ facilityAmountOnInterestPaymentDetailsPopup);
			System.out.println("STEP1 : Facility Amount on Interest Payment Details Popup in Step4: "
					+ facilityAmountOnInterestPaymentDetailsPopup);

			// Calling the closePopUp function from Funding Page
			FundingPage.closePopUp();

			// Click on the Database SubMenu
			Utils.clickOnMenu(node, driver, SideMenuPO.fundingDatabase);

			// Call the openRecordUsingSearch from Utils
			Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, FundingDatabasePO.referenceSearchField, facility,
					UtilsPO.editIcon, FundingNewFacilityPO.editLoanFacilityText);

			// Calling the clickOnTab function from Utils
			Utils.clickOnTab(FundingNewFacilityPO.summaryTab, FundingNewFacilityPO.facilitySummaryHeader, "Summary");

			// Get the Facility Amount
			String facilityAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingNewFacilityPO.facilityAmountValue);
			node.log(Status.INFO, "STEP2 : The Facility Amount under Summary Tab : " + facilityAmount);
			System.out.println("STEP2 : The Facility Amount under Summary Tab : " + facilityAmount);

			// Assert the Facility Amount
			IElementActions.assertEquals_usingString(node, driver, facilityAmountOnInterestPaymentDetailsPopup,
					facilityAmount,
					"STEP3 : BUG : The Facility Amount on Interest Payment Details Popup is not same as Facility Amount under Summary Tab in Edit Loan Facility Page",
					"STEP3 : PASS : The Facility Amount on Interest Payment Details Popup is same as Facility Amount under Summary Tab in Edit Loan Facility Page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityAmount", "Pass", driver);

		} catch (AssertionError validateFacilityAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFacilityAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityAmount.printStackTrace();
			node.fail(validateFacilityAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFacilityAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityAmount.printStackTrace();
			node.fail(validateFacilityAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_272
	@Test(priority = 39)
	public void validateDrawnAmount() throws IOException {

		try {
			extenttest = extent.createTest("Verify the Drawn Amount")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			String facility = getDataFromExcel(9);

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Get the Drawn Amount
			int actualDrawnAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.drawnAmountValue);

			// Calling the closePopUp function from Funding Page
			FundingPage.closePopUp();

			// Click on the Database SubMenu
			Utils.clickOnMenu(node, driver, SideMenuPO.fundingDatabase);

			// Calling the openRecordUsingSearch from Utils
			Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, FundingDatabasePO.referenceSearchField, facility,
					UtilsPO.editIcon, FundingNewFacilityPO.editLoanFacilityText);

			// Calling the clickOnTab function from Utils
			Utils.clickOnTab(FundingNewFacilityPO.summaryTab, FundingNewFacilityPO.facilitySummaryHeader, "Summary");

			// Get the Cash Value
			int cashValue = Utils.getTextAndParseToInt(FundingNewFacilityPO.cashValue);

			// Get the Bridge Loans Value
			int bridgeLoansValue = Utils.getTextAndParseToInt(FundingNewFacilityPO.bridgeLoansValue);

			// Calling the calculateAddition from Utils
			int expectedDrawnAmount = Utils.calculateAddition(cashValue, bridgeLoansValue);

			// Assert the Drawn Amount
			IElementActions.assertEquals_usingInteger(node, driver, actualDrawnAmount, expectedDrawnAmount,
					"STEP1 : BUG : The Drawn Amount	on Interest Payment Details Popup is not same as Calculated from [Cash Value + Bridge Loans Value] Formula",
					"STEP1 : PASS :  The Drawn Amount on Interest Payment Details Popup is same as Calculated from [Cash Value + Bridge Loans Value] Formula");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDrawnAmount", "Pass", driver);

		} catch (AssertionError validateDrawnAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDrawnAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDrawnAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDrawnAmount.printStackTrace();
			node.fail(validateDrawnAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDrawnAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDrawnAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDrawnAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDrawnAmount.printStackTrace();
			node.fail(validateDrawnAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_273
	@Test(priority = 40)
	public void validateCashRate() throws IOException {

		try {
			extenttest = extent.createTest("Verify the Cash Rate")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			String facility = getDataFromExcel(9);

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Get the Cash Rate Value
			double actualCashRateValue = Utils.getTextAndParseToDouble(FundingInterestPaymentPO.cashRateValue);

			// Calling the closePopUp function from Funding Page
			FundingPage.closePopUp();

			// Click on the Database SubMenu
			Utils.clickOnMenu(node, driver, SideMenuPO.fundingDatabase);

			// Calling the openRecordUsingSearch from Utils
			Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, FundingDatabasePO.referenceSearchField, facility,
					UtilsPO.editIcon, FundingNewFacilityPO.editLoanFacilityText);

			// Calling the clickOnTab function from Utils
			Utils.clickOnTab(FundingNewFacilityPO.summaryTab, FundingNewFacilityPO.facilitySummaryHeader, "Summary");

			// Get the Cash Rate Value
			Thread.sleep(2000);
			double expectedCashRate = Utils.getTextAndParseToDouble(FundingNewFacilityPO.cashRateValue);

			// Assert the Cash Rate Value
			IElementActions.assertEquals_usingDouble(node, driver, actualCashRateValue, expectedCashRate,
					"STEP1 : BUG : The Cash Rate Value on Interest Payment Details Popup is not same as Cash Rate Value under Summary Tab in Edit Loan Facility Page",
					"STEP1 : PASS : The Cash Rate Value on Interest Payment Details Popup is same as Cash Rate Value under Summary Tab in Edit Loan Facility Page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashRate", "Pass", driver);

		} catch (AssertionError validateCashRate) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashRate test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCashRate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashRate.printStackTrace();
			node.fail(validateCashRate);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCashRate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashRate test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCashRate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashRate.printStackTrace();
			node.fail(validateCashRate);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_274
	// TC_InterestPayment_Step4_275
	@Test(priority = 41)
	public void validateNavigationToLoanFacilitySummaryPage() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the when user clicks on the 'Facility Reference', user is navigate to the Loan Facility Summary Page"
							+ "_"
							+ "ValidateClickedOnFacilityReferenceNumber :Verify that the user is able to click on the Facility Reference")

					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			String facility = getDataFromExcel(9);

			// Get the ParentWindowID
			String ParentWindowID = driver.getWindowHandle();

			// Click on Facility Reference Number
			IElementActions.clickelement_usingXpath(node, driver, FundingInterestPaymentPO.facilityReferenceValue);
			node.log(Status.INFO, "STEP1 : Clicked on Facility Reference Number");
			System.out.println("STEP1 : Clicked on Loan Facility Number");

			// Calling the switchToChildWindow from IElementActions
			IElementActions.switchToChildWindow();

			// Get the Current URL
			Thread.sleep(2000);
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			// Identify the prefix that comes right before the Facility Reference number
			String prefix = "/LFSummary/";

			// Find the index where the Facility Starts
			int facilityStartIndex = currentUrl.indexOf(prefix) + prefix.length();

			// Assuming the Facility is at the end, we can use substring from the start
			// index to the end of the string
			String facilityReferenceInURL = currentUrl.substring(facilityStartIndex);

			// Assert that The user is redirected to the new tab for the Loan Facility
			// Summary Page
			IElementActions.assertContains_usingString(node, driver, currentUrl, prefix,
					"STEP2 : BUG : The user is not redirected to the new tab for the Loan Facility Summary Page.",
					"STEP2 : PASS : The user is redirected to the new tab for the Loan Facility Summary Page.");

			// Assert that The user is redirected to Loan Facility Summary Page for clicked
			// Facility Refrence Number
			IElementActions.assertEquals_usingString(node, driver, facility, facilityReferenceInURL,
					"STEP3 : BUG : 	The user is not redirected to Loan Facility Summary Page for clicked Facility Refrence Number",
					"STEP3 : PASS : The user is redirected to Loan Facility Summary Page for clicked Facility Refrence Number");

			// Check the Visibiity of Loan Facility Summary Page Header
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.loanFacilitySummaryTextHeader,
					"STEP4 : BUG: The Loan Facility Summary Header is not coming On Loan Facility Summary Page",
					"STEP4 : EXPECTED: The Loan Facility Summary Header is coming On Loan Facility Summary Page");

			// Close child Window and Switch to Parent Window
			IElementActions.closeChildWindowAndSwitchToParent(ParentWindowID);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateNavigationToLoanFacilitySummaryPage", "Pass", driver);

		} catch (AssertionError validateNavigationToLoanFacilitySummaryPage) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNavigationToLoanFacilitySummaryPage test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNavigationToLoanFacilitySummaryPage_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNavigationToLoanFacilitySummaryPage.printStackTrace();
			node.fail(validateNavigationToLoanFacilitySummaryPage);
			Assert.fail();
			extent.flush();

		} catch (Exception validateNavigationToLoanFacilitySummaryPage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNavigationToLoanFacilitySummaryPage test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNavigationToLoanFacilitySummaryPage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNavigationToLoanFacilitySummaryPage.printStackTrace();
			node.fail(validateNavigationToLoanFacilitySummaryPage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_276
	@Test(priority = 42)
	public void validateMonthonMonthComparisonOnInterestPaymentPopup() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the following details are displayed to the user in the Month on month-on-month comparison section:"
							+ "-Prior Payment" + "Change due to: " + "-Day Count Fraction" + "-Lending Rates"
							+ "-Deployment" + "-Cash Interest" + "-Interest Deferral" + "-Total Change"
							+ "-New Payment ")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the facilityIButton function from FundingPage
			FundingPage.facilityIButton(FundingInterestPaymentPO.facilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Check the visibility of Prior Payment
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.priorPayment,
					"STEP1 : BUG: The Prior Payment is not coming on Interest Payment Details Popup",
					"STEP1 : EXPECTED: The Prior Payment is coming on Interest Payment Details Popup");

			// Check the visibility of Prior Payment Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.priorPaymentAmount,
					"STEP2 : BUG: The Prior Payment Amount is not coming on Interest Payment Details Popup",
					"STEP2 : EXPECTED: The Prior Payment Amount is coming on Interest Payment Details Popup");

			// Check the visibility of Change due to:
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.changeDueTo,
					"STEP3 : BUG: The Change due to: is not coming on Interest Payment Details Popup",
					"STEP3 : EXPECTED: The Change due to: is coming on Interest Payment Details Popup");

			// Check the visibility of Day Count Fraction
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.dayCountFractions,
					"STEP4 : BUG: The Day Count Fraction is not coming on Interest Payment Details Popup",
					"STEP4 : EXPECTED: The Day Count Fraction is coming on Interest Payment Details Popup");

			// Check the visibility of Day Count Fraction Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.dayCountFractionAmount,
					"STEP5 : BUG: The Day Count Fraction Amount is not coming on Interest Payment Details Popup",
					"STEP5 : EXPECTED: The Day Count Fraction Amount is coming on Interest Payment Details Popup");

			// Check the visibility of Lending Rates
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.lendingRates,
					"STEP6 : BUG: The Lending Rates is not coming on Interest Payment Details Popup",
					"STEP6 : EXPECTED: The Lending Rates is coming on Interest Payment Details Popup");

			// Check the visibility of Lending Rates Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.lendingRatesAmount,
					"STEP7 : BUG: The Lending Rates Amount is not coming on Interest Payment Details Popup",
					"STEP7 : EXPECTED: The Lending Rates Amount is coming on Interest Payment Details Popup");

			// Check the visibility of Deployment
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deployment,
					"STEP8 : BUG: The Deployment is not coming on Interest Payment Details Popup",
					"STEP8 : EXPECTED: The Deployment is coming on Interest Payment Details Popup");

			// Check the visibility of Deployment Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deploymentAmount,
					"STEP9 : BUG: The Deployment Amount is not coming on Interest Payment Details Popup",
					"STEP9 : EXPECTED: The Deployment Amount is coming on Interest Payment Details Popup");

			// Check the visibility of Cash Interest
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.cashInterests,
					"STEP10 : BUG: The Cash Interest is not coming on Interest Payment Details Popup",
					"STEP10 : EXPECTED: The Cash Interest is coming on Interest Payment Details Popup");

			// Check the visibility of Cash Interest Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.cashInterestAmount,
					"STEP11 : BUG: The Cash Interest Amount is not coming on Interest Payment Details Popup",
					"STEP11 : EXPECTED: The Cash Interest Amount is coming on Interest Payment Details Popup");

			// Check the visibility of Interest Deferral
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestDeferral,
					"STEP12 : BUG: The Interest Deferral is not coming on Interest Payment Details Popup",
					"STEP12 : EXPECTED: The Interest Deferral is coming on Interest Payment Details Popup");

			// Check the visibility of Interest Deferral Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestDeferralAmount,
					"STEP13 : BUG: The Interest Deferral Amount is not coming on Interest Payment Details Popup",
					"STEP13 : EXPECTED: The Interest Deferral Amount is coming on Interest Payment Details Popup");

			// Check the visibility of Total change
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.totalChange,
					"STEP14 : BUG: The Total change	is not coming on Interest Payment Details Popup",
					"STEP14 : EXPECTED: The Total change is coming on Interest Payment Details Popup");

			// Check the visibility of Total change Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.totalChangeAmount,
					"STEP15 : BUG: The Total change	Amount is not coming on Interest Payment Details Popup",
					"STEP15 : EXPECTED: The Total change	Amount is coming on Interest Payment Details Popup");

			// Check the visibility of New Payment
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.newPayment,
					"STEP16 : BUG: The New Payment is not coming on Interest Payment Details Popup",
					"STEP16 : EXPECTED: The New Payment is coming on Interest Payment Details Popup");

			// Check the visibility of New Payment Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.newPaymentAmount,
					"STEP17 : BUG: The New Payment Amount is not coming on Interest Payment Details Popup",
					"STEP17 : EXPECTED: The New Payment Amount is coming on Interest Payment Details Popup");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateMonthonMonthComparisonOnInterestPaymentPopup", "Pass",
					driver);

		} catch (AssertionError validateMonthonMonthComparisonOnInterestPaymentPopup) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateMonthonMonthComparisonOnInterestPaymentPopup test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateMonthonMonthComparisonOnInterestPaymentPopup_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMonthonMonthComparisonOnInterestPaymentPopup.printStackTrace();
			node.fail(validateMonthonMonthComparisonOnInterestPaymentPopup);
			Assert.fail();
			extent.flush();

		} catch (Exception validateMonthonMonthComparisonOnInterestPaymentPopup) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateMonthonMonthComparisonOnInterestPaymentPopup test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateMonthonMonthComparisonOnInterestPaymentPopup_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMonthonMonthComparisonOnInterestPaymentPopup.printStackTrace();
			node.fail(validateMonthonMonthComparisonOnInterestPaymentPopup);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_277
	@Test(priority = 43)
	public void validateIButtonVisibility() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the user is able to see the (i) button of  following details:"
							+ "Change due to:" + "-Day Count Fraction" + "-Lending Rates" + "-Deployment"
							+ "-Cash Interest" + "-Interest Deferral")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the facilityIButton function from FundingPage
			FundingPage.facilityIButton(FundingInterestPaymentPO.facilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Check the visibility of Day Count Fraction I Button
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.dayCountFractionIButton,
					"STEP1 : BUG: The Day Count Fraction I Button is not coming on Interest Payment Details Popup",
					"STEP1 : EXPECTED: The Day Count Fraction I Button is coming on Interest Payment Details Popup");

			// Check the visibility of Lending Rates I Button
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.lendingRatesIButton,
					"STEP2 : BUG: The Lending Rates I Button is not coming on Interest Payment Details Popup",
					"STEP2 : EXPECTED: The Lending Rates I Button is coming on Interest Payment Details Popup");

			// Check the visibility of Deployment I Button
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deploymentIButton,
					"STEP3 : BUG: The Deployment I Button is not coming on Interest Payment Details Popup",
					"STEP3 : EXPECTED: The Deployment I Button is coming on Interest Payment Details Popup");

			// Check the visibility of Cash Interest I Button
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.cashInterestIButton,
					"STEP4 : BUG: The Cash Interest I Button is not coming on Interest Payment Details Popup",
					"STEP4 : EXPECTED: The Cash Interest I Button is coming on Interest Payment Details Popup");

			// Check the visibility of Interest Deferral I Button
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestDeferralIButton,
					"STEP5 : BUG: The Interest Deferral I Button is not coming on Interest Payment Details Popup",
					"STEP5 : EXPECTED: The Interest Deferral I Button is coming on Interest Payment Details Popup");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateIButtonVisibility", "Pass", driver);

		} catch (AssertionError validateIButtonVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateIButtonVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateIButtonVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateIButtonVisibility.printStackTrace();
			node.fail(validateIButtonVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateIButtonVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateIButtonVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateIButtonVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateIButtonVisibility.printStackTrace();
			node.fail(validateIButtonVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_278
	// TC_InterestPayment_Step4_279
	// TC_InterestPayment_Step4_280
	@Test(priority = 44)
	public void validateTextOnIButton() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that user is able to view following text on hovering on the i icon present on the fields under the Month on Month comparison i.e."
							+ "Day Count Fraction - The difference due to the change in day count during the month"
							+ "Lending Rates - The difference due to the change in the average facility rates" + "_"
							+ "Verify that user is able to view following text on hovering on the i icon present on the fields under the Month on Month comparison i.e."
							+ "Deployment - The difference due to the change in the avearge amount deployed in bridge loans over the months"
							+ "Cash Interest - The difference due to the amount paid as cash interest."
							+ "Interest Deferral - The difference due to the change in the Deffered Interest C/F Balance "
							+ "_" + "Verify that the user is able to hover on the (i) button.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the facilityIButton function from FundingPage
			FundingPage.facilityIButton(FundingInterestPaymentPO.facilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Calling the mouseHover from IMouseActions
			IMouseActions.mouseHover(driver, FundingInterestPaymentPO.dayCountFractionIButton,
					"Day Count Fraction I Button");

			// Get the Text On Day Count Fraction I Button
			String dayCountFractionIButtonText = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					FundingInterestPaymentPO.dayCountFractionIButton, "title");
			node.log(Status.INFO, "STEP1 : Text On Day Count Fraction I Button : " + dayCountFractionIButtonText);
			System.out.println("STEP1 : Text On Day Count Fraction I Button : " + dayCountFractionIButtonText);

			// Calling the mouseHover from IMouseActions
			IMouseActions.mouseHover(driver, FundingInterestPaymentPO.lendingRatesIButton, "Lending Rates I Button");

			// Get the Text On Lending Rates I Button
			String lendingRatesIButtonText = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					FundingInterestPaymentPO.lendingRatesIButton, "title");
			node.log(Status.INFO, "STEP2 : Text on Lending Rates I Button : " + lendingRatesIButtonText);
			System.out.println("STEP2 : Text on Lending Rates I Button : " + lendingRatesIButtonText);

			// Calling the mouseHover from IMouseActions
			IMouseActions.mouseHover(driver, FundingInterestPaymentPO.deploymentIButton, "Deployment I Button");

			// Get the Text on Deployment I Button
			String deploymentIButtonText = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					FundingInterestPaymentPO.deploymentIButton, "title");
			node.log(Status.INFO, "STEP3 : Text on Deployment I Button : " + deploymentIButtonText);
			System.out.println("STEP3 : Text on Deployment I Button : " + deploymentIButtonText);

			// Calling the mouseHover from IMouseActions
			IMouseActions.mouseHover(driver, FundingInterestPaymentPO.cashInterestIButton, "Cash Interest I Button");

			// Get the Text on Cash Interest I Button
			String cashInterestIButtonText = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					FundingInterestPaymentPO.cashInterestIButton, "title");
			node.log(Status.INFO, "STEP4 : Text on Cash Interest I Button : " + cashInterestIButtonText);
			System.out.println("STEP4 : Text on Cash Interest I Button : " + cashInterestIButtonText);

			// Calling the mouseHover from IMouseActions
			IMouseActions.mouseHover(driver, FundingInterestPaymentPO.interestDeferralIButton,
					"Interest Deferral I Button");

			// Get the Text on Interest Deferral I Button
			String interestDeferralIButtonText = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					FundingInterestPaymentPO.interestDeferralIButton, "title");
			node.log(Status.INFO, "STEP5 : Text on Interest Deferral I Button : " + interestDeferralIButtonText);
			System.out.println("STEP5 : Text on Interest Deferral I Button : " + interestDeferralIButtonText);

			// Assert the Day Count Fraction I Button Tool Tip Message
			IElementActions.assertEquals_usingString(node, driver, dayCountFractionIButtonText,
					AllPagesData.dayCountFraction,
					"STEP6 : BUG : The Day Count Fraction I Button Tool Tip Message is not same as The difference due to the change in day count during the month",
					"STEP6 : PASS: The Day Count Fraction I Button Tool Tip Message is same as The difference due to the change in day count during the month");

			// Assert the Lending Rates I Button Tool Tip Message
			IElementActions.assertEquals_usingString(node, driver, lendingRatesIButtonText, AllPagesData.lendingRates,
					"STEP7 : BUG : The Lending Rates I Button Tool Tip Message is not same as The difference due to the change in the average facility rates",
					"STEP7 : PASS: The Lending Rates I Button Tool Tip Message is same as The difference due to the change in the average facility rates");

			// Assert the Deployment I Button Tool Tip Message
			IElementActions.assertEquals_usingString(node, driver, deploymentIButtonText, AllPagesData.deployment,
					"STEP8 : BUG : The Deployment I Button Tool Tip Message is not same as The difference due to the change in the avearge amount deployed in bridge loans over the months",
					"STEP8 : PASS: The Deployment I Button Tool Tip Message is same as The difference due to the change in the avearge amount deployed in bridge loans over the months");

			// Assert the Cash Interest I Button Tool Tip Message
			IElementActions.assertEquals_usingString(node, driver, cashInterestIButtonText, AllPagesData.cashInterest,
					"STEP9 : BUG : The Cash Interest I Button Tool Tip Message is not same as The difference due to the amount paid as cash interest",
					"STEP9 : PASS: The Cash Interest I Button Tool Tip Message is same as The difference due to the amount paid as cash interest");

			// Assert the Interest Deferral I Button Tool Tip Message
			IElementActions.assertEquals_usingString(node, driver, interestDeferralIButtonText,
					AllPagesData.interestDeferral,
					"STEP10 : BUG : The Interest Deferral I Button Tool Tip Message is not same as The difference due to the change in the Deffered Interest C/F Balance",
					"STEP10 : PASS: The Interest Deferral I Button Tool Tip Message is same as The difference due to the change in the Deffered Interest C/F Balance");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateTextOnIButton", "Pass", driver);

		} catch (AssertionError validateTextOnIButton) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateTextOnIButton test in validateIButtonTextOnDayCountAndLendingRates class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTextOnIButton_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTextOnIButton.printStackTrace();
			node.fail(validateTextOnIButton);
			Assert.fail();
			extent.flush();

		} catch (Exception validateTextOnIButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateTextOnIButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTextOnIButton_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTextOnIButton.printStackTrace();
			node.fail(validateTextOnIButton);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_281
	@Test(priority = 45)
	public void validatePriorPaymentAmountFigure() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user is able to see the Prior Payment amount figure as per the below formulas:"
							+ "Prior Payment = New Payment - Total Change" + "")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the facilityIButton function from FundingPage
			FundingPage.facilityIButton(FundingInterestPaymentPO.facilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Get the New Payment Amount
			int newPaymentAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.newPaymentAmount);

			// Get the Total Change Amount
			int totalChangeAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.totalChangeAmount);

			// Get the actual Prior Payment Amount
			int actualPriorPaymentAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.priorPaymentAmount);

			// Calling the calculateDifference from Utils and Calculate the Prior Payment
			// Amount
			int expectedPriorPaymentAmount = Utils.calculateDifference(newPaymentAmount, totalChangeAmount);
			node.log(Status.INFO, "STEP1 : Calculated Expected Prior Payment Amount : " + expectedPriorPaymentAmount);
			System.out.println("STEP1 : Calculated Expected Prior Payment Amount : " + expectedPriorPaymentAmount);

			// Assert the Prior Payment Amount
			IElementActions.assertEquals_usingInteger(node, driver, actualPriorPaymentAmount,
					expectedPriorPaymentAmount,
					"STEP2 : BUG : Prior Payment Amount is not same as calculated from [New Payment - Total Change] Formula",
					"STEP2 : PASS: Prior Payment Amount is same as calculated from [New Payment - Total Change] Formula");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validatePriorPaymentAmountFigure", "Pass", driver);

		} catch (AssertionError validatePriorPaymentAmountFigure) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePriorPaymentAmountFigure test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePriorPaymentAmountFigure_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePriorPaymentAmountFigure.printStackTrace();
			node.fail(validatePriorPaymentAmountFigure);
			Assert.fail();
			extent.flush();

		} catch (Exception validatePriorPaymentAmountFigure) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePriorPaymentAmountFigure test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePriorPaymentAmountFigure_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePriorPaymentAmountFigure.printStackTrace();
			node.fail(validatePriorPaymentAmountFigure);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_282
	@Test(priority = 46)
	public void validateCashInterestAndInterestDeferralAmounts() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user is able to see the amounts for the fields listed below, as calculated according to their respective formulas:"
							+ "- Change due to Day Count Fraction - No need to verify"
							+ "- Change due to Lending Rates - No need to verify"
							+ "- Change due to Deployment - No need to verify"
							+ "- Change due to Cash Interest = CurrentCashInterest - PriorCashInterest, where CurrentCashInterest is equal to Current Month Calculations > Cash Amount"
							+ "- Change due to Interest Deferral= PriorNetInterestDeferred - CurrentNetInterestDeferred, where"
							+ "NetInterestDeferred = sum(Default Interest) - sum(default interest paid)")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Month
			String month = getDataFromExcel(7);

			// Converting string to integer
			int monthNum = Integer.parseInt(month);
			monthNum = monthNum - 1;

			// Method 1: Using toString() method
			String previousMonth = Integer.toString(monthNum);

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), month);

			// Calling the facilityIButton function from FundingPage
			FundingPage.facilityIButton(FundingInterestPaymentPO.facilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Get the Cash Interest Amount
			int actualCashInterestAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.cashInterestAmount);

			// Get the Current Cash Interest
			int currentCashInterest = Utils.getTextAndParseToInt(FundingInterestPaymentPO.cashAmountValue);

			// Get the Interest Deferral Amount
			int actualInterestDeferralAmount = Utils
					.getTextAndParseToInt(FundingInterestPaymentPO.interestDeferralAmount);

			// Get the Default Interest Amount
			int currentDefaultInterestAmount = Utils
					.getTextAndParseToInt(FundingInterestPaymentPO.defaultInterestAmount);

			// Get the Default Interest Paid Amount
			int currentdefaultInterestPaidAmount = Utils
					.getTextAndParseToInt(FundingInterestPaymentPO.defaultInterestPaidAmount);

			// calculate the Current Net Interest Deferred Amount
			int CurrentNetInterestDeferred = Utils.calculateDifference(currentDefaultInterestAmount,
					currentdefaultInterestPaidAmount);
			node.log(Status.INFO,
					"STEP1 : Calculated Current Net Interest Deferred Amount : " + CurrentNetInterestDeferred);
			System.out
					.println("STEP1 : Calculated Current Net Interest Deferred Amount: " + CurrentNetInterestDeferred);

			// Call the closePopUp function from FundingPage
			FundingPage.closePopUp();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), previousMonth);

			// Calling the facilityIButton function from FundingPage
			FundingPage.facilityIButton(FundingInterestPaymentPO.facilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Get the Prior Cash Interest
			int priorCashInterest = Utils.getTextAndParseToInt(FundingInterestPaymentPO.cashAmountValue);

			// Get the Prior Default Interest Amount
			int priorDefaultInterestAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.defaultInterestAmount);

			// Get the Prior Default Interest Paid Amount
			int priorDefaultInterestPaidAmount = Utils
					.getTextAndParseToInt(FundingInterestPaymentPO.defaultInterestPaidAmount);

			// calculate the Prior Net Interest Deferred
			int priorNetInterestDeferred = Utils.calculateDifference(priorDefaultInterestAmount,
					priorDefaultInterestPaidAmount);
			node.log(Status.INFO,
					"STEP2 : Calculated Prior Net Interest Deferred Amount : " + priorNetInterestDeferred);
			System.out.println("STEP2 : Calculated Prior Net Interest Deferred Amount : " + priorNetInterestDeferred);

			// Calculate Expected Cash Interest Amount
			int expectedCashInterestAmount = Utils.calculateDifference(currentCashInterest, priorCashInterest);
			node.log(Status.INFO, "STEP3 : Calculated Expected Cash Interest Amount : " + expectedCashInterestAmount);
			System.out.println("STEP3 : Calculated Expected Cash Interest Amount : " + expectedCashInterestAmount);

			// Calculate Expected Interest Deferral Amount
			int expectedInterestDeferralAmount = Utils.calculateDifference(priorNetInterestDeferred,
					CurrentNetInterestDeferred);
			node.log(Status.INFO,
					"STEP4 : Calculated Expected Interest Deferral Amount : " + expectedInterestDeferralAmount);
			System.out.println(
					"STEP4 : Calculated Expected Interest Deferral Amount : " + expectedInterestDeferralAmount);

			// Assert the Cash Interest Amount
			IElementActions.assertEquals_usingInteger(node, driver, actualCashInterestAmount,
					expectedCashInterestAmount,
					"STEP5 : BUG : Cash Interest Amount is not same as calculated from [CurrentCashInterest - PriorCashInterest] Formula",
					"STEP5 : PASS: Cash Interest Amount is same as calculated from [CurrentCashInterest - PriorCashInterest] Formula");

			// Assert the Interest Deferral Amount
			IElementActions.assertEquals_usingInteger(node, driver, actualInterestDeferralAmount,
					expectedInterestDeferralAmount,
					"STEP6 : BUG : Interest Deferral Amount is not same as calculated from [PriorNetInterestDeferred - CurrentNetInterestDeferred] Formula",
					"STEP6 : PASS: Interest Deferral Amount is same as calculated from [PriorNetInterestDeferred - CurrentNetInterestDeferred] Formula");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashInterestAndInterestDeferralAmounts", "Pass", driver);

		} catch (AssertionError validateCashInterestAndInterestDeferralAmounts) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashInterestAndInterestDeferralAmounts test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashInterestAndInterestDeferralAmounts_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashInterestAndInterestDeferralAmounts.printStackTrace();
			node.fail(validateCashInterestAndInterestDeferralAmounts);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCashInterestAndInterestDeferralAmounts) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashInterestAndInterestDeferralAmounts test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashInterestAndInterestDeferralAmounts_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashInterestAndInterestDeferralAmounts.printStackTrace();
			node.fail(validateCashInterestAndInterestDeferralAmounts);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_283
	@Test(priority = 47)
	public void validateTotalChangeAmountFigure() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the 'Total Changes' amount is calculated as the sum of the below fields:"
							+ "- Day Count Fraction" + "- Lending Rates" + "- Deployment" + "- Cash Interest"
							+ "- Interest Deferral")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the facilityIButton function from FundingPage
			FundingPage.facilityIButton(FundingInterestPaymentPO.facilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Get the Day Count Fraction Amount
			int dayCountFractionAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.dayCountFractionAmount);

			// Get the Lending Rates Amount
			int lendingRatesAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.lendingRatesAmount);

			// Get the Deployment Amount
			int deploymentAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.deploymentAmount);

			// Get the Cash Interest Amount
			int cashInterestAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.cashInterestAmount);

			// Get the Interest Deferral Amount
			int interestDeferralAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.interestDeferralAmount);

			// Get Total Change Amount
			int actualTotalChangeAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.totalChangeAmount);

			// Calculate the Expected Total Change Amount
			int expectedTotalChangeAmount = Utils.calculateAddition(dayCountFractionAmount, lendingRatesAmount)
					+ Utils.calculateAddition(deploymentAmount, cashInterestAmount) + interestDeferralAmount;
			node.log(Status.INFO, "STEP1 : Calculated Expected Total change Amount : " + expectedTotalChangeAmount);
			System.out.println("STEP1 : Calculate Expected Total change Amount : " + expectedTotalChangeAmount);

			// Assert the Total Change Amount
			IElementActions.assertEquals_usingInteger(node, driver, actualTotalChangeAmount, expectedTotalChangeAmount,
					"STEP2 : BUG : Total change Amount is not same as calculated from [Day Count Fraction + Lending Rates + Deployment + Cash Interest + Interest Deferral] Formula ",
					"STEP2 : PASS: Total change Amount is same as calculated from [Day Count Fraction + Lending Rates + Deployment + Cash Interest + Interest Deferral] Formula ");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateTotalChangeAmountFigure", "Pass", driver);

		} catch (AssertionError validateTotalChangeAmountFigure) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateTotalChangeAmountFigure test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateTotalChangeAmountFigure_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalChangeAmountFigure.printStackTrace();
			node.fail(validateTotalChangeAmountFigure);
			Assert.fail();
			extent.flush();

		} catch (Exception validateTotalChangeAmountFigure) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateTotalChangeAmountFigure test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateTotalChangeAmountFigure_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalChangeAmountFigure.printStackTrace();
			node.fail(validateTotalChangeAmountFigure);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_284
	@Test(priority = 48)
	public void validateNewPaymentAmountFigure() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the new payment amount figure is the same as the Interest Payment amount")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the facilityIButton function from FundingPage
			FundingPage.facilityIButton(FundingInterestPaymentPO.facilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Get the New Payment Amount
			String newPaymentAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.newPaymentAmount);
			node.log(Status.INFO, "STEP1 : The New Payment Amount : " + newPaymentAmount);
			System.out.println("STEP1 : The New Payment Amount : " + newPaymentAmount);

			// Get the Interest Payment Amount
			String interestPaymentAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.interestPaymentAmount);
			node.log(Status.INFO, "STEP2 : The Interest Payment Amount : " + interestPaymentAmount);
			System.out.println("STEP2 : The Interest Payment Amount : " + interestPaymentAmount);

			// Assert that New Payment Amount is Same as Interest Payment Amount
			IElementActions.assertEquals_usingString(node, driver, newPaymentAmount, interestPaymentAmount,
					"STEP3 : BUG : The New Payment Amount is not Same as Interest Payment Amount",
					"STEP3 : PASS : The New Payment Amount is Same as Interest Payment Amount");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateNewPaymentAmountFigure", "Pass", driver);

		} catch (AssertionError validateNewPaymentAmountFigure) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNewPaymentAmountFigure test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNewPaymentAmountFigure_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNewPaymentAmountFigure.printStackTrace();
			node.fail(validateNewPaymentAmountFigure);
			Assert.fail();
			extent.flush();

		} catch (Exception validateNewPaymentAmountFigure) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNewPaymentAmountFigure test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNewPaymentAmountFigure_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNewPaymentAmountFigure.printStackTrace();
			node.fail(validateNewPaymentAmountFigure);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_285
	@Test(priority = 49)
	public void validateCurrentMonthCalculationsDetails() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the following details are displayed to the user in the Current Month Calculations section:"
							+ "-Interest Payment Amount" + "-Regular Interest" + "-Interest Release" + "-Cash Amount"
							+ "-Deferred Interest C/F" + "-Deferred Interest B/F" + "-Deferred Interest This Period"
							+ "-Deferred Interest Release")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the facilityIButton function from FundingPage
			FundingPage.facilityIButton(FundingInterestPaymentPO.facilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Check the visibility of Interest Payment Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestPayment,
					"STEP1 : BUG: The Interest Payment Amount is not coming on Interest Payment Details Popup",
					"STEP1 : EXPECTED: The Interest Payment Amount is coming on Interest Payment Details Popup");

			// Check the visibility of Interest Payment Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestPaymentAmount,
					"STEP2 : BUG: The Interest Payment Amount Value is not coming on Interest Payment Details Popup",
					"STEP2 : EXPECTED: The Interest Payment Amount Value is coming on Interest Payment Details Popup");

			// Check the visibility of Regular Interest
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.regularInterests,
					"STEP3 : BUG: The Regular Interest is not coming on Interest Payment Details Popup",
					"STEP3 : EXPECTED: The Regular Interest	is coming on Interest Payment Details Popup");

			// Check the visibility of Regular Interest Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.regularInterestAmount,
					"STEP4 : BUG: The Regular Interest Amount is not coming on Interest Payment Details Popup",
					"STEP4 : EXPECTED: The Regular Interest	Amount is coming on Interest Payment Details Popup");

			// Check the visibility of Interest Release
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestRelease,
					"STEP5 : BUG: The Interest Release is not coming on Interest Payment Details Popup",
					"STEP5 : EXPECTED: The Interest Release is coming on Interest Payment Details Popup");

			// Check the visibility of Interest Release Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestReleaseAmount,
					"STEP6 : BUG: The Interest Release Amount is not coming on Interest Payment Details Popup",
					"STEP6 : EXPECTED: The Interest Release Amount is coming on Interest Payment Details Popup");

			// Check the visibility of Cash Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.cashAmount,
					"STEP7 : BUG: The Cash Amount is not coming on Interest Payment Details Popup",
					"STEP7 : EXPECTED: The Cash Amount is coming on Interest Payment Details Popup");

			// Check the visibility of Cash Amount value
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.cashAmountValue,
					"STEP8 : BUG: The Cash Amount Value is not coming on Interest Payment Details Popup",
					"STEP8 : EXPECTED: The Cash Amount Value is coming on Interest Payment Details Popup");

			// Check the visibility of Deferred Interest C/F
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deferredInterestCF,
					"STEP9 : BUG: The Deferred Interest C/F is not coming on Interest Payment Details Popup",
					"STEP9 : EXPECTED: The Deferred Interest C/F is coming on Interest Payment Details Popup");

			// Check the visibility of Deferred Interest C/F Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deferredInterestCFAmount,
					"STEP10 : BUG: The Deferred Interest C/F Amount is not coming on Interest Payment Details Popup",
					"STEP10 : EXPECTED: The Deferred Interest C/F Amount is coming on Interest Payment Details Popup");

			// Check the visibility of Deferred Interest B/F
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deferredInterestBF,
					"STEP11 : BUG: The Deferred Interest B/F is not coming on Interest Payment Details Popup",
					"STEP11 : EXPECTED: The Deferred Interest B/F is coming on Interest Payment Details Popup");

			// Check the visibility of Deferred Interest B/F Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deferredInterestBFAmount,
					"STEP12 : BUG: The Deferred Interest B/F Amount is not coming on Interest Payment Details Popup",
					"STEP12 : EXPECTED: The Deferred Interest B/F Amount is coming on Interest Payment Details Popup");

			// Check the visibility of Deferred Interest This Period
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deferredInterestThisPeriod,
					"STEP13 : BUG: The Deferred Interest This Period is not coming on Loan Interest Payment Details Popup",
					"STEP13 : EXPECTED: The Deferred Interest This Period is coming on Interest Payment Details Popup");

			// Check the visibility of Deferred Interest This Period Amount
			IElementActions.assertTrue_usingXpath(node, driver,
					FundingInterestPaymentPO.deferredInterestThisPeriodAmount,
					"STEP14 : BUG: The Deferred Interest This Period Amount is not coming on Interest Payment Details Popup",
					"STEP14 : EXPECTED: The Deferred Interest This Period Amount is coming on Interest Payment Details Popup");

			// Check the visibility of Deferred Interest Release
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deferredInterestRelease,
					"STEP15 : BUG: The Deferred Interest Release is not coming on Interest Payment Details Popup",
					"STEP15 : EXPECTED: The Deferred Interest Release is coming on Interest Payment Details Popup");

			// Check the visibility of Deferred Interest Release Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deferredInterestReleaseAmount,
					"STEP16 : BUG: The Deferred Interest Release Amount is not coming on Interest Payment Details Popup",
					"STEP16 : EXPECTED: The Deferred Interest Release Amount is coming on Interest Payment Details Popup");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCurrentMonthCalculationsDetails", "Pass", driver);

		} catch (AssertionError validateCurrentMonthCalculationsDetails) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCurrentMonthCalculationsDetails test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCurrentMonthCalculationsDetails_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCurrentMonthCalculationsDetails.printStackTrace();
			node.fail(validateCurrentMonthCalculationsDetails);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCurrentMonthCalculationsDetails) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCurrentMonthCalculationsDetails test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCurrentMonthCalculationsDetails_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCurrentMonthCalculationsDetails.printStackTrace();
			node.fail(validateCurrentMonthCalculationsDetails);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_286
	@Test(priority = 50)
	public void validateInterestPaymentAmountFigure() throws IOException {

		try {
			extenttest = extent
					.createTest(
							"Verify that the 'Interest Payment' amount is calculated as the sum of the below fields:"
									+ "- Regular Interest" + "-Interest Release" + "-Cash Amount" + "")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.facilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Get the Regular Interest Amount
			int regularInterestAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.regularInterestAmount);

			// Get the Interest Release Amount
			int interestReleaseAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.interestReleaseAmount);

			// Get the Cash Amount
			int cashAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.cashAmountValue);

			// Get the Interest Payment Amount
			int actualInterestPaymentAmount = Utils
					.getTextAndParseToInt(FundingInterestPaymentPO.interestPaymentAmount);

			// Calling the calculateAddition from Utils and calculate the Interest Payment
			// Amount
			int expectedInterestPaymentAmount = Utils.calculateAddition(regularInterestAmount, interestReleaseAmount)
					+ cashAmount;
			node.log(Status.INFO,
					"STEP1 : Calculated Expected Interest Payment Amount : " + expectedInterestPaymentAmount);
			System.out
					.println("STEP1 : Calculated Expected Interest Payment Amount : " + expectedInterestPaymentAmount);

			// Assert the The Interest Payment Amount
			IElementActions.assertEquals_usingInteger(node, driver, actualInterestPaymentAmount,
					expectedInterestPaymentAmount,
					"STEP2 : BUG : The Interest Payment Amount is not same as Calculated from [Regular Interest+ Interest Release + Cash Amount] Formula",
					"STEP2 : PASS : The Interest Payment Amount is same as Calculated from [Regular Interest+ Interest Release + Cash Amount] Formula");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateInterestPaymentAmountFigure", "Pass", driver);

		} catch (AssertionError validateInterestPaymentAmountFigure) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInterestPaymentAmountFigure test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestPaymentAmountFigure_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestPaymentAmountFigure.printStackTrace();
			node.fail(validateInterestPaymentAmountFigure);
			Assert.fail();
			extent.flush();

		} catch (Exception validateInterestPaymentAmountFigure) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInterestPaymentAmountFigure test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestPaymentAmountFigure_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestPaymentAmountFigure.printStackTrace();
			node.fail(validateInterestPaymentAmountFigure);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_287
	@Test(priority = 51)
	public void validateFieldAmounts() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user is able to see the amounts for the fields listed below, as calculated according to their respective formulas:"
							+ "Regular Interest = sum of regular interest column"
							+ "Interest Release = sum of default Interest paid column"
							+ "Cash amount can be found on the cash row at the bottom of the popup"
							+ "Deferred Interest C/F = sum of Carried Forward column"
							+ "Deferred Interest B/F = Carried Over"
							+ "Deferred Interest This Period = sum of Default Interest column"
							+ "Deferred Interest Release = sum of Default Interest Paid column")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the facilityIButton function from FundingPage
			FundingPage.facilityIButton(FundingInterestPaymentPO.facilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Get the Regular Interest Amount
			String regularInterestAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.regularInterestAmount);
			node.log(Status.INFO, "STEP1 : The Regular Interest Amount : " + regularInterestAmount);
			System.out.println("STEP1 : The Regular Interest Amount : " + regularInterestAmount);

			// Get the Regular Interest Column Sum Amount
			String regualrInterestColumnSumAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.regualrInterestColumnSumAmount);
			node.log(Status.INFO,
					"STEP2 : The Sum of Regular Interest Column Amount : " + regualrInterestColumnSumAmount);
			System.out.println("STEP2 : The Sum of Regular Interest Column Amount : " + regualrInterestColumnSumAmount);

			// Assert the Regular Interest Amount
			IElementActions.assertEquals_usingString(node, driver, regularInterestAmount,
					regualrInterestColumnSumAmount,
					"STEP3 : BUG : The Regular Interest Amount is not Equal to the Sum of Regular Interest Column",
					"STEP3 : PASS : The Regular Interest Amount is Equal to the Sum of Regular Interest Column");

			// Get the Interest Release Amount
			String interestReleaseAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.interestReleaseAmount);
			node.log(Status.INFO, "STEP4 : The Interest Release Amount is " + interestReleaseAmount);
			System.out.println("STEP4 : The Interest Release Amount is " + interestReleaseAmount);

			// Get The Sum of Default Interest Paid Column Amount
			String defaultInterestPaidColumnSumAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.defaultInterestPaidAmount);
			node.log(Status.INFO,
					"STEP5 : The Sum of Default Interest Paid Column Amount : " + defaultInterestPaidColumnSumAmount);
			System.out.println(
					"STEP5 : The Sum of Default Interest Paid Column Amount : " + defaultInterestPaidColumnSumAmount);

			// Assert the Interest Release Amount
			IElementActions.assertEquals_usingString(node, driver, interestReleaseAmount,
					defaultInterestPaidColumnSumAmount,
					"STEP6 : BUG : The Interest Release Amount is not Equal to the Sum of Default Interest Paid Column",
					"STEP6 : PASS : The Interest Release Amount is Equal to the Sum of Default Interest Paid Column");

			// Get the cashAmount
			String cashAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.cashAmountValue);
			node.log(Status.INFO, "STEP7 : The cash amount is " + cashAmount);
			System.out.println("STEP7 : The cash amount is " + cashAmount);

			// Get cash amount under adjustment column
			String adjustmentColumnCashRowAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.adjustmentCashRow);
			node.log(Status.INFO, "STEP8 : The cash amount under adjustment column : " + adjustmentColumnCashRowAmount);
			System.out.println("STEP8 : The cash amount under adjustment column : " + adjustmentColumnCashRowAmount);

			// Assert the Cash Amount
			IElementActions.assertEquals_usingString(node, driver, cashAmount, adjustmentColumnCashRowAmount,
					"STEP9 : BUG : The cash amount is equal to the cash amount under adjustment column",
					"STEP9 : PASS : The cash amount is equal to the cash amount under adjustment column");

			// Get the Deferred Interest C/F Amount
			String deferredInterestCFAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.deferredInterestCFAmount);
			node.log(Status.INFO, "STEP10 : The Deferred Interest C/F Amount is " + deferredInterestCFAmount);
			System.out.println("STEP10 : The Deferred Interest C/F Amount is " + deferredInterestCFAmount);

			// Get The Sum of Carried Forward Column Amount
			String carriedForwardColumnSumAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.carriedForwardColumnSumAmount);
			node.log(Status.INFO,
					"STEP11 : The Sum of Carried Forward Column Amount : " + carriedForwardColumnSumAmount);
			System.out.println("STEP11 : The Sum of Carried Forward Column Amount : " + carriedForwardColumnSumAmount);

			// Assert the Deferred Interest C/F Amount
			IElementActions.assertEquals_usingString(node, driver, deferredInterestCFAmount,
					carriedForwardColumnSumAmount,
					"STEP12 : BUG : The Deferred Interest C/F Amount is not Equal to the sum of Carried Forward column Amount",
					"STEP12 : PASS : The Deferred Interest C/F Amount is Equal to the sum of Carried Forward column Amount");

			// Get the Deferred Interest B/F Amount
			String deferredInterestBFAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.deferredInterestBFAmount);
			node.log(Status.INFO, "STEP13 : The Deferred Interest B/F Amount is " + deferredInterestBFAmount);
			System.out.println("STEP13 : The Deferred Interest B/F Amount is " + deferredInterestBFAmount);

			// Get The Sum of Carried Over Column Amount
			String carriedOverColumnSumAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.carriedOverColumnSumAmount);
			node.log(Status.INFO, "STEP14 : The Sum of Carried Over Column Amount : " + carriedOverColumnSumAmount);
			System.out.println("STEP14 : The Sum of Carried Over Column Amount : " + carriedOverColumnSumAmount);

			// Assert the Deferred Interest B/F Amount
			IElementActions.assertEquals_usingString(node, driver, deferredInterestBFAmount, carriedOverColumnSumAmount,
					"STEP15 : BUG : The Deferred Interest B/F Amount is not Equal to the sum of Carried Over column Amount",
					"STEP15 : PASS : The Deferred Interest B/F Amount is Equal to the sum of Carried Over column Amount");

			// Get the Deferred Interest This Period Amount
			String deferredInterestThisPeriodAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.deferredInterestThisPeriodAmount);
			node.log(Status.INFO,
					"STEP16 : The Deferred Interest This Period Amount is " + deferredInterestThisPeriodAmount);
			System.out.println(
					"STEP16 : The Deferred Interest This Period Amount is " + deferredInterestThisPeriodAmount);

			// Get The Sum of Default Interest Column Amount
			String defaultInterestAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.defaultInterestAmount);
			node.log(Status.INFO, "STEP17 : The Sum of Default Interest Column Amount : " + defaultInterestAmount);
			System.out.println("STEP17 : The Sum of Default Interest Column Amount : " + defaultInterestAmount);

			// Assert the Deferred Interest This Period Amount
			IElementActions.assertEquals_usingString(node, driver, deferredInterestThisPeriodAmount,
					defaultInterestAmount,
					"STEP18 : BUG : The Deferred Interest This Period Amount is not Equal to the sum of Default Interest Column Amount",
					"STEP18 : PASS : The Deferred Interest This Period Amount is Equal to the sum of Default Interest Column Amount");

			// Get the Deferred Interest Release Amount
			String deferredInterestReleaseAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.deferredInterestReleaseAmount);
			node.log(Status.INFO, "STEP19 : The Deferred Interest Release Amount is " + deferredInterestReleaseAmount);
			System.out.println("STEP19 : The Deferred Interest Release Amount is " + deferredInterestReleaseAmount);

			// Assert the Deferred Interest Release Amount
			IElementActions.assertEquals_usingString(node, driver, deferredInterestReleaseAmount,
					defaultInterestPaidColumnSumAmount,
					"STEP20 : BUG : The Deferred Interest Release Amount is not Equal to the Sum of Default Interest Paid Column Amount",
					"STEP20 : PASS : The Deferred Interest Release Amount is Equal to the Sum of Default Interest Paid Column Amount");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFieldAmounts", "Pass", driver);

		} catch (AssertionError validateFieldAmounts) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFieldAmounts test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFieldAmounts_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFieldAmounts.printStackTrace();
			node.fail(validateFieldAmounts);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFieldAmounts) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFieldAmounts test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFieldAmounts_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFieldAmounts.printStackTrace();
			node.fail(validateFieldAmounts);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_288
	@Test(priority = 52)
	public void validateInterestPaymentPopupTableColumns() throws IOException {

		try {
			extenttest = extent
					.createTest("-Date Range as per selected" + "-Standard Default Days" + "-Regular Interest Days"
							+ "-Carried Over" + "-Default Interest" + "-Expected Default Interest" + "-Adjustment"
							+ "-Default Interest Paid" + "-Regular Interest" + "- Carried Forward" + "-Loan Rate"
							+ "-Default Loan Rate" + "-Facility Rate" + "-Default Facility Rate")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Get the start date
			String startDateString = IElementActions.getTextbyXpath(node, FundingInterestPaymentPO.calStartDate);
			node.log(Status.INFO, "STEP1 : " + startDateString + " is displayed in Start Date field");
			System.out.println("STEP1 : " + startDateString + " is displayed in Start Date field");

			// Get the end date
			String endDateString = IElementActions.getTextbyXpath(node, FundingInterestPaymentPO.calEndDate);
			node.log(Status.INFO, "STEP2 : " + endDateString + " is displayed in End Date field");
			System.out.println("STEP2 : " + endDateString + " is displayed in End Date field");

			// Convert start and end date strings to LocalDate objects
			LocalDate startDate = LocalDate.parse(startDateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			LocalDate endDate = LocalDate.parse(endDateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Check the visibility of Standard Default Days Column Header
			IElementActions.assertTrue_usingXpath(node, driver,
					FundingInterestPaymentPO.standardDefaultDaysColumnHeader,
					"STEP3 : BUG: The Standard Default Days	column Header is not coming under the Table on Interest Payment Details in Step4",
					"STEP3 : EXPECTED: The Standard Default Days column Header is coming under the Table on Interest Payment Details in Step4");

			// Check the visibility of Regular Interest Days Column Header
			IElementActions.assertTrue_usingXpath(node, driver,
					FundingInterestPaymentPO.regularInterestDaysColumnHeader,
					"STEP4 : BUG: The Regular Interest Days	column Header is not coming under the Table on Interest Payment Details in Step4",
					"STEP4 : EXPECTED: The Regular Interest Days column Header is coming under the Table on Interest Payment Details in Step4");

			// Check the visibility of Carried Over Column Header
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.carriedOverColumnHeader,
					"STEP5 : BUG: The Carried Over column Header is not coming under the Table on Interest Payment Details in Step4",
					"STEP5 : EXPECTED: The Carried Over column Header is coming under the Table on Interest Payment Details in Step4");

			// Check the visibility of Default Interest Column Header
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.defaultInterestColumnHeader,
					"STEP6 : BUG: The Default Interest column Header is not coming under the Table on Interest Payment Details in Step4",
					"STEP6 : EXPECTED: The Default Interest column Header is coming under the Table on Interest Payment Details in Step4");

			// Check the visibility of Expected Default Interest Column Header
			IElementActions.assertTrue_usingXpath(node, driver,
					FundingInterestPaymentPO.expectedDefaultInterestColumnHeader,
					"STEP7 : BUG: The Expected Default Interest column Header is not coming under the Table on Interest Payment Details in Step4",
					"STEP7 : EXPECTED: The Expected Default Interest column Header is coming under the Table on Interest Payment Details in Step4");

			// Check the visibility of Adjustment Column Header
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.adjsutmentColumnHeader,
					"STEP8 : BUG: The Adjustment column Header is not coming under the Table on Interest Payment Details in Step4",
					"STEP8 : EXPECTED: The Adjustment column Header is coming under the Table on Interest Payment Details in Step4");

			// Check the visibility of Default Interest Paid Column Header
			IElementActions.assertTrue_usingXpath(node, driver,
					FundingInterestPaymentPO.DefaultInterestPaidColumnHeader,
					"STEP9 : BUG: The Default Interest Paid column Header is not coming under the Table on Interest Payment Details in Step4",
					"STEP9 : EXPECTED: The Default Interest Paid column Header is coming under the Table on Interest Payment Details in Step4");

			// Check the visibility of Regular Interest Column Header
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.regularInterestColumnHeader,
					"STEP10 : BUG: The Regular Interest column Header is not coming under the Table on Interest Payment Details in Step4",
					"STEP10 : EXPECTED: The Regular Interest column Header is coming under the Table on Interest Payment Details in Step4");

			// Check the visibility of Carried Forward Column Header
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.carriedForwardColumnHeader,
					"STEP11 : BUG: The Carried Forward column Header is not coming under the Table on Interest Payment Details in Step4",
					"STEP11 : EXPECTED: The Carried Forward column Header is coming under the Table on Interest Payment Details in Step4");

			// Check the visibility of Loan Rate Column Header
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.loanRateColumnHeader,
					"STEP12 : BUG: The Loan Rate column Header is not coming under the Table on Interest Payment Details in Step4",
					"STEP12 : EXPECTED: The Loan Rate column Header is coming under the Table on Interest Payment Details in Step4");

			// Check the visibility of Default Loan Rate Column Header
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.defaultLoanRateColumnHeader,
					"STEP13 : BUG: The Default Loan Rate column Header is not coming under the Table on Interest Payment Details in Step4",
					"STEP13 : EXPECTED: The Default Loan Rate column Header is coming under the Table on Interest Payment Details in Step4");

			// Check the visibility of Facility Rate Column Header
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.facilityRateColumnHeader,
					"STEP14 : BUG: The Facility Rate column Header is not coming under the Table on Interest Payment Details in Step4",
					"STEP14 : EXPECTED: The Facility Rate column Header is coming under the Table on Interest Payment Details in Step4");

			// Check the visibility of Default Facility Rate Column Header
			IElementActions.assertTrue_usingXpath(node, driver,
					FundingInterestPaymentPO.defaultFacilityRateColumnHeader,
					"STEP15 : BUG: The Default Facility Rate column Header is not coming under the Table on Interest Payment Details in Step4",
					"STEP15 : EXPECTED: The Default Facility Rate column Header is coming under the Table on Interest Payment Details in Step4");

			// Fetch list of elements from another table (assuming dates are in a certain
			// format)
			List<WebElement> dateElements = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.datesInFacility);
			List<LocalDate> datesList = new ArrayList<>();

			// Convert date strings to LocalDate objects and store in a list
			for (WebElement dateElement : dateElements) {
				String dateStr = dateElement.getText();
				LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				datesList.add(date);
			}

			// Assertion
			for (LocalDate date : datesList) {
				FundingPage.assertDateInRange(date, startDate, endDate);
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateInterestPaymentPopupTableColumns", "Pass", driver);

		} catch (AssertionError validateInterestPaymentPopupTableColumns) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInterestPaymentPopupTableColumns test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestPaymentPopupTableColumns_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestPaymentPopupTableColumns.printStackTrace();
			node.fail(validateInterestPaymentPopupTableColumns);
			Assert.fail();
			extent.flush();

		} catch (Exception validateInterestPaymentPopupTableColumns) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInterestPaymentPopupTableColumns test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestPaymentPopupTableColumns_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestPaymentPopupTableColumns.printStackTrace();
			node.fail(validateInterestPaymentPopupTableColumns);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_289
	@Test(priority = 53)
	public void validateInterestAmount() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the user is able to see the Interest amount as per the date selected.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			String facility = getDataFromExcel(9);
			String loanReferenceNumber = getDataFromExcel(13);
			String dateForCheckingLoanAmount = getDataFromExcel(15);

			// Split date string into day, month, and year
			String[] dateParts = dateForCheckingLoanAmount.split("/");
			String day = dateParts[0];
			String month = dateParts[1];
			String year = dateParts[2];

			// LocalDate dateForAmount
			LocalDate dateForAmount = LocalDate.parse(dateForCheckingLoanAmount,
					DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			// Get the start date
			String startDateString = IElementActions.getTextbyXpath(node, FundingInterestPaymentPO.calStartDate);
			node.log(Status.INFO, "STEP1 : " + startDateString + " is displayed in Start Date field");
			System.out.println("STEP1 : " + startDateString + " is displayed in Start Date field");

			// Get the end date
			String endDateString = IElementActions.getTextbyXpath(node, FundingInterestPaymentPO.calEndDate);
			node.log(Status.INFO, "STEP2 : " + endDateString + " is displayed in End Date field");
			System.out.println("STEP2 : " + endDateString + " is displayed in End Date field");

			// Convert start and end date strings to LocalDate objects
			LocalDate startDate = LocalDate.parse(startDateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			LocalDate endDate = LocalDate.parse(endDateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			String loanReferenceNumberLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.loanReferenceNumber, "locatorValue", loanReferenceNumber);

			// Fetch list of elements from another table (assuming dates are in a certain
			// format)
			List<WebElement> dateElements = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.datesInFacility);
			List<LocalDate> datesList = new ArrayList<>();

			boolean isFail = false;
			int position = 0;
			int datePosition = -1; // Initialize datePosition to -1, indicating the date was not found

			if (dateForAmount.isBefore(startDate) || dateForAmount.isAfter(endDate)) {
				System.out.println(
						"Test case failed! Date " + dateForAmount + " is not between " + startDate + " and " + endDate);
				node.log(Status.FAIL,
						"Test case failed! Date " + dateForAmount + " is not between " + startDate + " and " + endDate);
				isFail = true;

			} else {
				System.out.println("Date " + dateForAmount + " is in range.");
				node.log(Status.PASS, "Date " + dateForAmount + " is in range.");

				// Convert date strings to LocalDate objects and store in a list
				for (WebElement dateElement : dateElements) {
					String dateStr = dateElement.getText();
					LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
					if (date.equals(dateForAmount)) { // Use equals method for comparison
						datePosition = position; // Set datePosition to the index of the matching date
						break;
					}
					position++;
				}

			}

			String count = Integer.toString(datePosition);

			String facilityLoanReferencesLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.facilityAmountForLoanReferences, "referenceLocatorValue",
					loanReferenceNumber);

			String loanReferenceAmountLocator = IElementActions
					.createDynamicLocatorString(facilityLoanReferencesLocator, "dateLocatorValue", count);

			// Click on the date
			String facilityAmountForLoanReferences = IElementActions.getElementText_usingXpath(node, driver,
					loanReferenceAmountLocator);
			node.log(Status.INFO, "STEP3 : Facility amount for loan references " + facilityAmountForLoanReferences);
			System.out.println("STEP3 : Facility amount for loan references " + facilityAmountForLoanReferences);

			// Calling the closePopUp function from Funding Page
			FundingPage.closePopUp();

			// Calling the openTreasuryAndEnterDetails from treasury
			TreasuryPage.openTreasuryAndEnterDetails(loanReferenceNumber);

			node.log(Status.INFO, "STEP15 : Waiting for the visibility of the treasury single table");
			System.out.println("STEP15 : Waiting for the visibility of the treasury single table");
			IWaitStrategy.waitForVisiblity(node, driver, TreasurySinglePO.table);
			node.log(Status.INFO, "STEP16 : Treasury single table is visible");
			System.out.println("STEP16 : Treasury single table is visible");

			String facilityAmountLoanReferencesLocator = IElementActions
					.createDynamicLocatorString(TreasurySinglePO.facilityCurrentAllocation, "locatorValue", facility);

			String facilityAllocationAmount = IElementActions.getElementText_usingXpath(node, driver,
					facilityAmountLoanReferencesLocator);
			node.log(Status.INFO, "STEP17 : Facility allocation amount " + facilityAllocationAmount);
			System.out.println("STEP17 : Facility allocation amount " + facilityAllocationAmount);

			// Assert
			IElementActions.assertEquals_usingString(node, driver, facilityAmountForLoanReferences,
					facilityAllocationAmount,
					"STEP18 : BUG : Facility allocation amount is same as in interest facility popup",
					"STEP18 : PASS : Facility allocation amount is same as in interest facility popup");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateInterestAmount", "Pass", driver);

		} catch (AssertionError validateInterestAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInterestAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateInterestAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestAmount.printStackTrace();
			node.fail(validateInterestAmount);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateInterestAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInterestAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateInterestAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestAmount.printStackTrace();
			node.fail(validateInterestAmount);
			Assert.fail();
			extent.flush();

			// TODO: handle exception
		}

	}

	// TC_InterestPayment_Step4_290
	@Test(priority = 54)
	public void validateLoanList() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the loan list is displayed to the user according to the date selected by the user.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			String facility = getDataFromExcel(9);

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Get the end date
			String endDateString = IElementActions.getTextbyXpath(node, FundingInterestPaymentPO.calEndDate);
			node.log(Status.INFO, "STEP2 : " + endDateString + " is displayed in End Date field");
			System.out.println("STEP2 : " + endDateString + " is displayed in End Date field");

			// Split date string into day, month, and year
			String[] dateParts = endDateString.split("/");
			String date = dateParts[0];
			String month = dateParts[1];
			String year = dateParts[2];

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Get the List of WebElements
			List<WebElement> facilityReferenceList = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.referenceColumnInFacility);

			// Create an ArrayList to store the elements
			List<String> facilityReferences = new ArrayList<>();

			// Iterate over the facility reference list and add elements to the ArrayList
			for (WebElement element : facilityReferenceList) {
				facilityReferences.add(element.getText());
			}

			// Print or process the elements in the ArrayList as needed
			for (String reference : facilityReferences) {
				System.out.println(reference); // Example: print the facility reference
			}

			// Calling the closePopUp function from Funding Page
			FundingPage.closePopUp();

			// Calling the loadTreasurySinglePage function from the TreasuryPage
			TreasuryPage.loadTreasuryDatabasePage();

			Utils.enterDate(TreasuryDatabasePO.allocationDate, UtilsPO.calenderMonth, month, UtilsPO.calenderYear, year,
					UtilsPO.calenderDay, date);

			node.log(Status.INFO, "STEP9 : Waiting for the visibility of the loan references");
			System.out.println("STEP9 : Waiting for the visibility of the loan references");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryDatabasePO.loanReferences);
			node.log(Status.INFO, "STEP10 : Loan references is visible");
			System.out.println("STEP10 : Loan references is visible");

			Thread.sleep(5000);

			List<WebElement> facilitiesReferenceInDatabase = IElementActions.returnElements(node, driver,
					TreasuryDatabasePO.facilities);

			int position = 0; // Initialize position as -1 (not found)
			for (int i = 0; i < facilitiesReferenceInDatabase.size(); i++) {
				String text = facilitiesReferenceInDatabase.get(i).getText();
				if (text.equals(facility)) {
					position = i + 1;

					break; // Stop searching once a match is found
				}
			}
			position = position + 2;

			String count = Integer.toString(position);

			// Create the Dynamic Locator for Facility Amount Loan Reference
			String facilityAmountLoanReferencesLocator = IElementActions.createDynamicLocatorString(
					TreasuryDatabasePO.facilityAmountForLoanReferences, "locatorValue", count);

			// Get the List of WebElements
			List<WebElement> facilityAmountForLoanReferences = IElementActions.returnElements(node, driver,
					facilityAmountLoanReferencesLocator);
			List<WebElement> loanReferences = IElementActions.returnElements(node, driver,
					TreasuryDatabasePO.loanReferences);

			// Create a separate ArrayList to store corresponding loan references
			List<String> nonZeroLoanReferences = new ArrayList<>();

			// Iterate over facility amounts and check if the value is not zero
			for (int i = 0; i < facilityAmountForLoanReferences.size(); i++) {
				WebElement facilityAmountElement = facilityAmountForLoanReferences.get(i);
				WebElement loanReferencesElement = loanReferences.get(i);
				String facilityAmountText = facilityAmountElement.getText();
				String loanReferencesText = loanReferencesElement.getText();
				if (!facilityAmountText.trim().equals("£0")) {
					// Add the corresponding loan reference to the list
					nonZeroLoanReferences.add(loanReferencesText);
				}
			}

			// Process the non-zero loan references as needed
			for (String loanReference : nonZeroLoanReferences) {

				System.out.println(loanReference);
			}

			System.out.println("facilityReferenceList size " + facilityReferenceList.size());
			System.out.println("nonZeroLoanReference size " + nonZeroLoanReferences.size());
			// Assert that the sizes of the two lists are equal
			if (facilityReferenceList.size() != nonZeroLoanReferences.size()) {
				System.out.println("Mismatch in sizes of facility reference and non-zero loan references lists.");
				node.log(Status.FAIL, "Mismatch in sizes of facility reference and non-zero loan references lists.");
				return; // Exit if the sizes don't match
			}

			// Iterate over both lists and compare each pair of loan references
			for (int i = 0; i < facilityReferences.size(); i++) {
				String facilityReference = facilityReferences.get(i);
				System.out.println("facilityReferences " + facilityReferences);
				String nonZeroLoanReference = nonZeroLoanReferences.get(i);
				System.out.println("nonZeroLoanReference " + nonZeroLoanReference);
				if (!facilityReferences.equals(nonZeroLoanReference)) {
					// Log the mismatched reference
					System.out.println("Mismatch found at index " + i + ": Facility Reference - " + facilityReferences
							+ ", Non-zero Loan Reference - " + nonZeroLoanReference);
					node.log(Status.FAIL, "Mismatch found at index " + i + ": Facility Reference - "
							+ facilityReferences + ", Non-zero Loan Reference - " + nonZeroLoanReference);
				}
			}

			// Assert pass if no mismatches were found
			System.out.println("Assertion: Test passed - References match.");
			node.log(Status.PASS, "Assertion: Test passed - References match.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanList", "Pass", driver);

		} catch (AssertionError validateLoanList) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanList test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanList_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanList.printStackTrace();
			node.fail(validateLoanList);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanList) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanList test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanList_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanList.printStackTrace();
			node.fail(validateLoanList);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_291
	// TC_InterestPayment_Step4_292
	@Test(priority = 55)
	public void validateRegularAndStandardDaysOfFacility() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the Standard Default Days is evaluated by Regular Interest Days + Standard Interest Days <= This Period Number Of Days."
							+ "Verify that the Regular Interest Days is evaluated by Regular Interest Days + Standard Interest Days <= This Period Number Of Days.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Get the This Period Number Of Days
			int actualNumberOfDays = Utils.getTextAndParseToInt(FundingInterestPaymentPO.thisPeriodNumberOfDaysValue);

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Locate the elements listing facility records
			List<WebElement> facilityRecords = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.rowsInFacility);

			// Get the List of WebElements
			List<WebElement> facilityReferenceList = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.referenceColumnInFacility);

			// Extract Regular Days and Standard Interest Days values from lists
			List<WebElement> regularDaysList = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.regularDaysColumnInFacility);
			List<WebElement> standardInterestDaysList = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.standardDefaultDaysColumnInFacility);

			// Initialize lists for valid and invalid records
			List<String> validRecords = new ArrayList<>();
			List<String> invalidRecords = new ArrayList<>();

			// Iterate through facility records
			for (int i = 0; i < facilityRecords.size() - 1; i++) {

				WebElement facilityRecord = facilityRecords.get(i);

				// Extract Regular Days and Standard Interest Days values
				WebElement regularDaysElement = regularDaysList.get(i);
				WebElement standardInterestDaysElement = standardInterestDaysList.get(i);
				WebElement facilityReferenceElement = facilityReferenceList.get(i);

				int regularDays = Integer.parseInt(regularDaysElement.getText());
				int standardInterestDays = Integer.parseInt(standardInterestDaysElement.getText());
				String facilityReference = facilityReferenceElement.getText();

				// Validate based on color
				if (regularDays + standardInterestDays <= actualNumberOfDays) {
					validRecords
							.add("Record " + (i + 1) + ": Regular Days: " + regularDays + ", Standard Interest Days: "
									+ standardInterestDays + ", Facility Reference: " + facilityReference);
				} else {
					invalidRecords
							.add("Record " + (i + 1) + ": Regular Days: " + regularDays + ", Standard Interest Days: "
									+ standardInterestDays + ", Facility Reference: " + facilityReference);
				}
			}

			// Print valid records
			System.out.println("Valid Records:");
			for (String validRecord : validRecords) {
				System.out.println(validRecord);
				node.log(Status.PASS, validRecord);
			}

			// Print invalid records
			System.out.println("\nInvalid Records:");
			for (String invalidRecord : invalidRecords) {
				System.out.println(invalidRecord);
				node.log(Status.FAIL, invalidRecord);
			}

			// Assert no invalid records
			assert invalidRecords.isEmpty() : "Some records are invalid: " + invalidRecords;

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateRegularAndStandardDaysOfFacility", "Pass", driver);

		} catch (AssertionError validateRegularAndStandardDaysOfFacility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateRegularAndStandardDaysOfFacility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRegularAndStandardDaysOfFacility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRegularAndStandardDaysOfFacility.printStackTrace();
			node.fail(validateRegularAndStandardDaysOfFacility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateRegularAndStandardDaysOfFacility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateRegularAndStandardDaysOfFacility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRegularAndStandardDaysOfFacility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRegularAndStandardDaysOfFacility.printStackTrace();
			node.fail(validateRegularAndStandardDaysOfFacility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_294
	@Test(priority = 56)
	public void validateDefaultInterestAmount() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the Default Interest  are calculated as per the below formulas:"
							+ "Default Interest = (Facility Rate/12)* Loan Amount")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refersh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			String loanReferenceNumber = getDataFromExcel(13);

			// Create the Dynamic Locator for Default Interest Value
			String defaultInterestValueLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.defaultInterestValue, "locatorValue", loanReferenceNumber);

			// Create the Dynamic Locator for Facility Rate
			String facilityRateLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.facilityRateValue, "locatorValue", loanReferenceNumber);

			// Get the Default Interest
			double actualDefaultInterest = Utils.getTextAndParseToDouble(defaultInterestValueLocator);

			// Get the Facility Rate
			double facilityRate = Utils.getTextAndParseToDouble(facilityRateLocator);

			// Close the Popup
			FundingPage.closePopUp();

			// Click on the Database Menu
			Utils.clickOnMenu(node, driver, SideMenuPO.loans);

			// Click on the Database SubMenu
			Utils.clickOnMenu(node, driver, SideMenuPO.loansDatabase);

			// Wait for the visibility of the Bridge Loan Database Header
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the Bridge Loan Database Header");
			System.out.println("STEP1 : Waiting for the visibility of Bridge Loan Database Header");
			IWaitStrategy.waitForVisiblity(node, driver, LoansDatabasePO.bridgeLoanDatabseText);
			node.log(Status.INFO, "STEP2 : Bridge Loan Database Header is visible");
			System.out.println("STEP2 : Bridge Loan Database Header is visible");

			// Calling the openRecordUsingSearch from Utils
			Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, LoansDatabasePO.loanRefSearchField,
					loanReferenceNumber, UtilsPO.editIcon, LoansNewLoanPO.editBridgeLoanHeaderText);

			// Calling the clickOnTab function from Utils
			Utils.clickOnTab(LoansNewLoanPO.loanTab, LoansNewLoanPO.loanDisbursementHeader, "Loan");

			// Check the visibility of Current Amount Value
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.currentAmountValue,
					"STEP3 : BUG: The Current Amount Value is not coming under the Loan Tab On Edit Bridge Loan Page",
					"STEP3 : EXPECTED: The Current Amount Value is coming under the Loan Tab On Edit Bridge Loan Page");

			// Get the Loan Amount
			double loanAmount = Utils.getTextAndParseToDouble(LoansNewLoanPO.currentAmountValue);

			// Calculate the Expected Default Interest
			double expectedDefaultInterest = (facilityRate / 12) * loanAmount;
			node.log(Status.INFO, "STEP4 : Calculated Default Interest Value : " + expectedDefaultInterest);
			System.out.println("STEP4 : Calculated Default Interest Value : " + expectedDefaultInterest);

			// Assert the Default Interest Value
			IElementActions.assertEquals_usingDouble(node, driver, actualDefaultInterest, expectedDefaultInterest,
					"STEP5 : BUG : The Default Interest under the Default Interest column on Interest Payment Details Popup is not same as Calculated from [(Facility Rate/12)* Loan Amount] Formula",
					"STEP5 : PASS : The Default Interest under the Default Interest column on Interest Payment Details Popup is same as Calculated from [(Facility Rate/12)* Loan Amount] Formula");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDefaultInterestAmount", "Pass", driver);

		} catch (AssertionError validateDefaultInterestAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDefaultInterestAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDefaultInterestAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDefaultInterestAmount.printStackTrace();
			node.fail(validateDefaultInterestAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDefaultInterestAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDefaultInterestAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDefaultInterestAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDefaultInterestAmount.printStackTrace();
			node.fail(validateDefaultInterestAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_296
	@Test(priority = 57)
	public void validateRegularInterestAmount() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the Regular Interest are calculated as per the below formulas:"
							+ "Interest of a day = (Facility  Rate ÷ (12* Regular Interest days ))*Loan amount"
							+ "Regular Interest = Interest of a day * 31")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			String loanReferenceNumber = getDataFromExcel(13);

			// Create the Dynamic Locator for Regular Interest Days Value
			String regularInterestDaysValueLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.regularInterestDaysValue, "locatorValue", loanReferenceNumber);

			// Create the Dynamic Locator for Facility Rate
			String facilityRateLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.facilityRateValue, "locatorValue", loanReferenceNumber);

			// Create the Dynamic Locator for Regular Interest
			String regualrInterestLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.regularInterestColumnValueFacility, "locatorValue", loanReferenceNumber);

			// Get the Regular Interest Days
			double regularInterestDays = Utils.getTextAndParseToDouble(regularInterestDaysValueLocator);

			// Get the Facility Rate
			double facilityRate = Utils.getTextAndParseToDouble(facilityRateLocator);

			// Get Regular Interest
			double actualregularInterest = Utils.getTextAndParseToDouble(regualrInterestLocator);

			// Close the Popup
			FundingPage.closePopUp();

			// Click on the Database Menu
			Utils.clickOnMenu(node, driver, SideMenuPO.loans);

			// Click on the Database SubMenu
			Utils.clickOnMenu(node, driver, SideMenuPO.loansDatabase);

			// Wait for the visibility of the Bridge Loan Database Header
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the Bridge Loan Database Header");
			System.out.println("STEP1 : Waiting for the visibility of Bridge Loan Database Header");
			IWaitStrategy.waitForVisiblity(node, driver, LoansDatabasePO.bridgeLoanDatabseText);
			node.log(Status.INFO, "STEP2 : Bridge Loan Database Header is visible");
			System.out.println("STEP2 : Bridge Loan Database Header is visible");

			// Calling the openRecordUsingSearch from Utils
			Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, LoansDatabasePO.loanRefSearchField,
					loanReferenceNumber, UtilsPO.editIcon, LoansNewLoanPO.editBridgeLoanHeaderText);

			// Calling the clickOnTab function from Utils
			Utils.clickOnTab(LoansNewLoanPO.loanTab, LoansNewLoanPO.loanDisbursementHeader, "Loan");

			// Check the visibility of Current Amount Value
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.currentAmountValue,
					"STEP3 : BUG: The Current Amount Value is not coming under the Loan Tab On Edit Bridge Loan Page",
					"STEP3 : EXPECTED: The Current Amount Value is coming under the Loan Tab On Edit Bridge Loan Page");

			// Get the Loan Amount
			double loanAmount = Utils.getTextAndParseToDouble(LoansNewLoanPO.currentAmountValue);

			double interestOfDay = 0;
			// Check if the divisor is not zero to avoid division by zero
			if (regularInterestDays != 0L) {

				interestOfDay = (facilityRate / (12 * regularInterestDays)) * loanAmount;

				// Print the result
				node.log(Status.INFO, "STEP4 : The Interest of a day calculated value is " + interestOfDay);
				System.out.println("STEP4 : The Interest of a day calculated value is" + interestOfDay);

			} else {
				node.log(Status.FAIL, "Error: Division by zero is not allowed.");
				System.out.println("Error: Division by zero is not allowed.");

			}

			// Calculate the Expected Regular Interest
			double expectedRegularInterest = interestOfDay * 31;
			node.log(Status.INFO, "STEP5 : Calculated Regular Interestt Value : " + expectedRegularInterest);
			System.out.println("STEP5 : Calculated Regular Interest Value : " + expectedRegularInterest);

			// Assert the Regular Interest Value
			IElementActions.assertEquals_usingDouble(node, driver, actualregularInterest, expectedRegularInterest,
					"STEP6 : BUG : The Regular Interest under the Regular Interest column on Interest Payment Details Popup is not same as Calculated from [interestOfDay * 31] Formula",
					"STEP6 : PASS : The Regular Interest under the Regular Interest column on Interest Payment Details Popup is same as Calculated from [interestOfDay * 31] Formula");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateRegularInterestAmount", "Pass", driver);

		} catch (AssertionError validateRegularInterestAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateRegularInterestAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRegularInterestAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRegularInterestAmount.printStackTrace();
			node.fail(validateRegularInterestAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateRegularInterestAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateRegularInterestAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRegularInterestAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRegularInterestAmount.printStackTrace();
			node.fail(validateRegularInterestAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_297
	@Test(priority = 58)
	public void validateLoanRatePercentage() throws IOException {

		try {
			extenttest = extent.createTest("Verify that the Loan Rate Percentage.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			String loanReferenceNumber = getDataFromExcel(13);

			// Create the Dynamic Locator for Loan Rate Value
			String loanRateValueLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.loanRateValue, "locatorValue", loanReferenceNumber);

			// Create the Dynamic Locator for Loan Reference Number
			String loanReferenceNumberLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.loanReferenceNumber, "locatorValue", loanReferenceNumber);

			// Get the loan Rate Value
			String loanRate = IElementActions.getElementText_usingXpath(node, driver, loanRateValueLocator);
			node.log(Status.INFO,
					"STEP1 : The Loan Rate Value on Interest Payment Details Popup in Step4 : " + loanRate);
			System.out.println("STEP1 : The Loan Rate Value on Interest Payment Details Popup in Step4: " + loanRate);

			// Get the ParentWindowID
			String ParentWindowID = driver.getWindowHandle();

			// Click on Loan Reference Number
			IElementActions.clickelement_usingXpath(node, driver, loanReferenceNumberLocator);
			node.log(Status.INFO, "STEP2: Clicked on Loan Reference Number");
			System.out.println("STEP2: Clicked on Loan Reference Number");

			// Calling the switchToChildWindow from IElementActions
			IElementActions.switchToChildWindow();

			// Get the Annual Interest Rate Value
			String annualInterestRate = IElementActions.getElementText_usingXpath(node, driver,
					LoansNewLoanPO.annualInterestRate);
			node.log(Status.INFO,
					"STEP3 : The Annual Interest Rate under the Loan Details section : " + annualInterestRate);
			System.out
					.println("STEP3 : The Annual Interest Rate under the Loan Details section: " + annualInterestRate);

			// Assert the Loan Rate Percentage
			IElementActions.assertEquals_usingString(node, driver, loanRate, annualInterestRate,
					"STEP4 : BUG : The Loan Rate Percentage is not same as Annual Interest Rate under the Loan Details section.",
					"STEP4 : PASS : The Loan Rate Percentage is same as Annual Interest Rate under the Loan Details section.");

			// Close child Window and Switch to Parent Window
			IElementActions.closeChildWindowAndSwitchToParent(ParentWindowID);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanRatePercentage", "Pass", driver);

		} catch (AssertionError validateLoanRatePercentage) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanRatePercentage test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanRatePercentage_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanRatePercentage.printStackTrace();
			node.fail(validateLoanRatePercentage);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanRatePercentage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanRatePercentage test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanRatePercentage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanRatePercentage.printStackTrace();
			node.fail(validateLoanRatePercentage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_299
	@Test(priority = 59)
	public void validateFacilityRate() throws IOException {

		try {
			extenttest = extent.createTest("Verify the Facility Rate")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			String loanReferenceNumber = getDataFromExcel(13);

			// Create the Dynamic Locator for Loan Rate Value
			String loanRateValueLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.loanRateValue, "locatorValue", loanReferenceNumber);

			// Create the Dynamic Locator for Facility Rate
			String facilityRateLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.facilityRateValue, "locatorValue", loanReferenceNumber);

			// Get the Facility Rate Value
			String facilityRate = IElementActions.getElementText_usingXpath(node, driver, facilityRateLocator);
			node.log(Status.INFO,
					"STEP1 : The Facility Rate Value under Facility Rate Column on Interest Payment Details Popup in Step4: "
							+ facilityRate);
			System.out.println(
					"STEP1 : The Facility Rate Value under Facility Rate Column on Interest Payment Details Popup in Step4: "
							+ facilityRate);

			// Get the loan Rate Value
			String loanRate = IElementActions.getElementText_usingXpath(node, driver, loanRateValueLocator);
			node.log(Status.INFO,
					"STEP2 : The Loan Rate Value under Loan Rate Column on Interest Payment Details Popup in Step4 : "
							+ loanRate);
			System.out.println(
					"STEP2 : The Loan Rate Value under Loan Rate Column on Interest Payment Details Popup in Step4: "
							+ loanRate);

			// Assert the Facility Rate Percentage
			IElementActions.assertEquals_usingString(node, driver, facilityRate, loanRate,
					"STEP3 : BUG : The Facility Rate percentage is not equal to the Loan Rate Percentage",
					"STEP3 : PASS : The Facility Rate percentage is equal to the Loan Rate Percentage");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityRate", "Pass", driver);

		} catch (AssertionError validateFacilityRate) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityRate test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFacilityRate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityRate.printStackTrace();
			node.fail(validateFacilityRate);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityRate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityRate test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFacilityRate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityRate.printStackTrace();
			node.fail(validateFacilityRate);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_300
	@Test(priority = 60)
	public void validateDefaultFacilityRate() throws IOException {

		try {
			extenttest = extent.createTest("Verify the Default Facility Rate")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			String loanReferenceNumber = getDataFromExcel(13);

			// Create the Dynamic Locator for Default Facility Rate Value
			String defaultFacilityRateLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.defaultFacilityRateValue, "locatorValue", loanReferenceNumber);

			// Create the Dynamic Locator for Default Loan Rate Value
			String defaultLoanRateValueLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.defaultLoanRateValue, "locatorValue", loanReferenceNumber);

			// Get the Default Facility Rate
			String defaultFacilityRate = IElementActions.getElementText_usingXpath(node, driver,
					defaultFacilityRateLocator);
			node.log(Status.INFO,
					"STEP1 : The Default Facility Rate Value under Default Facility Rate Column on Interest Payment Details Popup in Step4: "
							+ defaultFacilityRate);
			System.out.println(
					"STEP1 : The Default Facility Rate Value under Default Facility Rate Column on Interest Payment Details Popup in Step4: "
							+ defaultFacilityRate);

			// Get the Default loan Rate Value
			String defaultLoanRate = IElementActions.getElementText_usingXpath(node, driver,
					defaultLoanRateValueLocator);
			node.log(Status.INFO,
					"STEP2 : The Default Loan Rate Value under Default Loan Rate Column on Interest Payment Details Popup in Step4 : "
							+ defaultLoanRate);
			System.out.println(
					"STEP2 : The Default Loan Rate Value under Default Loan Rate Column on Interest Payment Details Popup in Step4: "
							+ defaultLoanRate);

			// Assert the Default Facility Rate Percentage
			IElementActions.assertEquals_usingString(node, driver, defaultFacilityRate, defaultLoanRate,
					"STEP3 : BUG : The Default Facility Rate percentage is not equal to the Default Loan Rate Percentage",
					"STEP3 : PASS : The Default Facility Rate percentage is equal to the Default Loan Rate Percentage");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDefaultFacilityRate", "Pass", driver);

		} catch (AssertionError validateDefaultFacilityRate) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDefaultFacilityRate test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDefaultFacilityRate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDefaultFacilityRate.printStackTrace();
			node.fail(validateDefaultFacilityRate);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDefaultFacilityRate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDefaultFacilityRate test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDefaultFacilityRate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDefaultFacilityRate.printStackTrace();
			node.fail(validateDefaultFacilityRate);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_301
	@Test(priority = 61)
	public void validateClickOnLoanReference() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that when the user clicks on the Loan Reference in the table listing under the Interest Payment Details popup, the user is navigated to the Bridge Loan Summary Page.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			String loanReferenceNumber = getDataFromExcel(13);

			// Create the Dynamic Locator for Loan Reference Number
			String loanReferenceNumberLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.loanReferenceNumber, "locatorValue", loanReferenceNumber);

			// Get the Loan Reference Number
			String loanReferenceNumberOnInterestDetailPopup = IElementActions.getElementText_usingXpath(node, driver,
					loanReferenceNumberLocator);
			node.log(Status.INFO, "STEP1 : Loan Reference Number on Interest Payment Details Popup in Step4 : "
					+ loanReferenceNumberOnInterestDetailPopup);
			System.out.println("STEP1 :Loan Reference Number on Interest Payment Details Popup in Step4: "
					+ loanReferenceNumberOnInterestDetailPopup);

			// Get the ParentWindowID
			String ParentWindowID = driver.getWindowHandle();

			// Click on Loan Reference Number
			IElementActions.clickelement_usingXpath(node, driver, loanReferenceNumberLocator);
			node.log(Status.INFO, "STEP2: Clicked on Loan Reference Number");
			System.out.println("STEP2: Clicked on Loan Reference Number");

			// Calling the switchToChildWindow from IElementActions
			IElementActions.switchToChildWindow();

			// Get the Current URL
			Thread.sleep(2000);
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			// Identify the prefix that comes right before the LB number
			String prefix = "/BLSummary/";

			// Find the index where the LB number starts
			int lbNumberStartIndex = currentUrl.indexOf(prefix) + prefix.length();

			// Assuming the LB number is at the end, we can use substring from the start
			// index to the end of the string
			String lbNumberInURL = currentUrl.substring(lbNumberStartIndex);

			// Assert that The user is redirected to the new tab for the Bridge Loan Summary
			// Page
			IElementActions.assertContains_usingString(node, driver, currentUrl, prefix,
					"STEP3 : BUG : The user is not redirected to the new tab for the Bridge Loan Summary Page.",
					"STEP3 : PASS : The user is redirected to the new tab for the Bridge Loan Summary Page.");

			// Assert that The user is redirected to Bridge Loan Summary Page for clicked
			// Loan Refrence Number
			IElementActions.assertEquals_usingString(node, driver, loanReferenceNumberOnInterestDetailPopup,
					lbNumberInURL,
					"STEP4 : BUG : The user is not redirected to Bridge Loan Summary Page for clicked Loan Refrence Number",
					"STEP4 : PASS : The user is redirected to Bridge Loan Summary Page for clicked Loan Refrence Number");

			// Check the Visibiity of Bridge Loan Summary Page Header
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.bridgeLoanSummaryTextHeader,
					"STEP5 : BUG: The Bridge Loan Summary Header is not coming On Bridge Loan Summary Page",
					"STEP5 : EXPECTED: The Bridge Loan Summary Header is coming On Bridge Loan Summary Page");

			// Close child Window and Switch to Parent Window
			IElementActions.closeChildWindowAndSwitchToParent(ParentWindowID);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateClickOnLoanReference", "Pass", driver);

		} catch (AssertionError validateClickOnLoanReference) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateClickOnLoanReference test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateClickOnLoanReference_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateClickOnLoanReference.printStackTrace();
			node.fail(validateClickOnLoanReference);
			Assert.fail();
			extent.flush();

		} catch (Exception validateClickOnLoanReference) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateClickOnLoanReference test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateClickOnLoanReference_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateClickOnLoanReference.printStackTrace();
			node.fail(validateClickOnLoanReference);
			Assert.fail();
			extent.flush();

			// TODO: handle exception
		}

	}

	// TC_InterestPayment_Step4_302
	@Test(priority = 62)
	public void validateInterestPaymentPopupCloseButton() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify  that the user is able to close the Interest Payment popup while clicking on the close button.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Calling the validatePopupClose function from FundingPage
			FundingPage.validatePopupClose(FundingInterestPaymentPO.closeButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup, "Close", "Interest Payment");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateInterestPaymentPopupCloseButton", "Pass", driver);

		} catch (AssertionError validateInterestPaymentPopupCloseButton) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInterestPaymentPopupCloseButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestPaymentPopupCloseButton_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestPaymentPopupCloseButton.printStackTrace();
			node.fail(validateInterestPaymentPopupCloseButton);
			Assert.fail();
			extent.flush();

		} catch (Exception validateInterestPaymentPopupCloseButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInterestPaymentPopupCloseButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestPaymentPopupCloseButton_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestPaymentPopupCloseButton.printStackTrace();
			node.fail(validateInterestPaymentPopupCloseButton);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step4_303
	@Test(priority = 63)
	public void validateInterestPaymentPopupXIcon() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user is able to close the Interest Payment popup while clicking on the X icon.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Calling the validatePopupClose function from FundingPage
			FundingPage.validatePopupClose(FundingInterestPaymentPO.closeButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup, "X Icon", "Interest Payment");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateInterestPaymentPopupXIcon", "Pass", driver);

		} catch (AssertionError validateInterestPaymentPopupXIcon) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInterestPaymentPopupXIcon test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestPaymentPopupXIcon_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestPaymentPopupXIcon.printStackTrace();
			node.fail(validateInterestPaymentPopupXIcon);
			Assert.fail();
			extent.flush();

		} catch (Exception validateInterestPaymentPopupXIcon) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInterestPaymentPopupXIcon test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestPaymentPopupXIcon_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestPaymentPopupXIcon.printStackTrace();
			node.fail(validateInterestPaymentPopupXIcon);
			Assert.fail();
			extent.flush();
		}
	}
}
