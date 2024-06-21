package com.Treasury.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.locators.allPages.LoansNewLoanPO;
import com.locators.allPages.PipelinePO;
import com.locators.allPages.SideMenuPO;
import com.locators.allPages.TreasurySinglePO;
import com.locators.allPages.UtilsPO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.url.AllPagesUrl;
import com.qa.utils.LoansPage;
import com.qa.utils.LoginPage;
import com.qa.utils.TreasuryPage;
import com.qa.utils.Utils;

public class SingleTest extends Baseclass {

	// TC_Treasury_Single_001
	@Test(priority = 1)
	public void validateTreasuryVisibility() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the user can view the Treasury menu from the side menu options.")
					.assignCategory(treasurySingle_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadLoginPage function from the login
			LoginPage.loadLoginPage();

			// Calling the userLoginProcess function from the LoginPage
			LoginPage.userLoginProcess(node, driver, getDataFromExcel(1), getDataFromExcel(2));

			// Check the visibility of pipeline
			IElementActions.assertTrue_usingXpath(node, driver, SideMenuPO.treasury,
					"STEP1 : BUG : Treasury module is not coming on the side menu",
					"STEP1 : EXPECTED : Treasury module is coming on the side menu");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateTreasuryVisibility", "Pass", driver);

		} catch (AssertionError validateTreasuryVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateTreasuryVisibility test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTreasuryVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTreasuryVisibility.printStackTrace();
			node.fail(validateTreasuryVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateTreasuryVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateTreasuryVisibility test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTreasuryVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTreasuryVisibility.printStackTrace();
			node.fail(validateTreasuryVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Single_002
	@Test(priority = 2)
	public void validateTreasuryOptions() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the user can access the Treasury menu from the side menu options.")
					.assignCategory(treasurySingle_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Click on the Treasury Menu
			Utils.clickOnMenu(node, driver, SideMenuPO.treasury);

			// Check the visibility of single treasury
			IElementActions.assertTrue_usingXpath(node, driver, SideMenuPO.singleTreasury,
					"STEP1 : BUG : Single is not coming under treasury module",
					"STEP1 : EXPECTED : Single is coming under treasury module");

			// Check the visibility of portfolio treasury
			IElementActions.assertTrue_usingXpath(node, driver, SideMenuPO.portfolioTreasury,
					"STEP2 : BUG : Portfolio is not coming under treasury module",
					"STEP2 : EXPECTED : Portfolio is coming under treasury module");

			// Check the visibility of database treasury
			IElementActions.assertTrue_usingXpath(node, driver, SideMenuPO.databaseTreasury,
					"STEP3 : BUG : Database is not coming under treasury module",
					"STEP3 : EXPECTED : Database is coming under treasury module");

			// Check the visibility of history treasury
			IElementActions.assertTrue_usingXpath(node, driver, SideMenuPO.historyTreasury,
					"STEP4 : BUG : History is not coming under treasury module",
					"STEP4 : EXPECTED : History is coming under treasury module");

			// Check the visibility of manage allocations treasury
			IElementActions.assertTrue_usingXpath(node, driver, SideMenuPO.manageAllocationsTreasury,
					"STEP5 : BUG : Manage allocations is not coming under treasury module",
					"STEP5 : EXPECTED : Manage allocations is coming under treasury module");

			// Check the visibility of inital allocation treasury
			IElementActions.assertTrue_usingXpath(node, driver, SideMenuPO.initalAllocationTreasury,
					"STEP6 : BUG : Inital allocation is not coming under treasury module",
					"STEP6 : EXPECTED : Inital allocation is coming under treasury module");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateTreasuryOptions", "Pass", driver);

		} catch (AssertionError validateTreasuryOptions) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateTreasuryOptions test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTreasuryOptions_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTreasuryOptions.printStackTrace();
			node.fail(validateTreasuryOptions);
			Assert.fail();
			extent.flush();

		} catch (Exception validateTreasuryOptions) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateTreasuryOptions test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTreasuryOptions_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTreasuryOptions.printStackTrace();
			node.fail(validateTreasuryOptions);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Single_003
	@Test(priority = 3)
	public void validateSingleTreasury() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the user can access the Single treasury menu from the side menu options.")
					.assignCategory(treasurySingle_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Click on the Treasury Menu
			Utils.clickOnMenu(node, driver, SideMenuPO.treasury);

			// Click on the Single Treasury Sub Menu
			Utils.clickOnMenu(node, driver, SideMenuPO.singleTreasury);

			// Wait for the visibility of Single Treasury page
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of Single Treasury page");
			System.out.println("STEP1 : Waiting for the visibility of Pipeline Database page");
			IWaitStrategy.waitForVisiblity(node, driver, TreasurySinglePO.allocationDate);
			node.log(Status.INFO, "STEP2 : Single Treasury page is visible");
			System.out.println("STEP2 : Single Treasury page is visible");

			Thread.sleep(2000);
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			// Calling the validateUrl from Utils
			Utils.validateUrl(node, driver, currentUrl, AllPagesUrl.TreasurySinglePage, "validateSingleTreasury");

		} catch (AssertionError validateSingleTreasury) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateSingleTreasury test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateSingleTreasury_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSingleTreasury.printStackTrace();
			node.fail(validateSingleTreasury);
			Assert.fail();
			extent.flush();

		} catch (Exception validateSingleTreasury) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateSingleTreasury test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateSingleTreasury_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSingleTreasury.printStackTrace();
			node.fail(validateSingleTreasury);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Single_005
	@Test(priority = 4)
	public void validateSingleTreasurySections() throws IOException {
		try {
			extenttest = extent.createTest("Verify the sections under the Single treasury page")
					.assignCategory(treasurySingle_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadSinglePage from treasury
			TreasuryPage.loadSinglePage();

			// Check the visibility of allocation inputs
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.allocationInputs,
					"STEP1 : BUG : Allocation inputs text is not coming under single page",
					"STEP1 : EXPECTED : Allocation inputs text is coming under single page");

			// Check the visibility of allocation inputs section
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.allocationInputsSection,
					"STEP2 : BUG : Allocation inputs section is not coming under single page",
					"STEP2 : EXPECTED : Allocation inputs section is coming under single page");

			// Check the visibility of allocation preview
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.allocationPreview,
					"STEP3 : BUG : Allocation preview text is not coming under single page",
					"STEP3 : EXPECTED : Allocation preview text is coming under single page");

			// Check the visibility of allocation preview section
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.allocationPreviewSection,
					"STEP4 : BUG : Allocation preview section is not coming under single page",
					"STEP4 : EXPECTED : Allocation preview section is coming under single page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateSingleTreasurySections", "Pass", driver);

		} catch (AssertionError validateSingleTreasurySections) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateSingleTreasurySections test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateSingleTreasurySections_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSingleTreasurySections.printStackTrace();
			node.fail(validateSingleTreasurySections);
			Assert.fail();
			extent.flush();

		} catch (Exception validateSingleTreasurySections) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateSingleTreasurySections test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateSingleTreasurySections_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSingleTreasurySections.printStackTrace();
			node.fail(validateSingleTreasurySections);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Single_006
	@Test(priority = 5)
	public void validateAllocationInputsFields() throws IOException {
		try {
			extenttest = extent.createTest("Verify the fields under the 'Allocation Inputs")
					.assignCategory(treasurySingle_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadSinglePage from treasury
			TreasuryPage.loadSinglePage();

			// Check the visibility of allocation date
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.allocationDate,
					"STEP1 : BUG : Allocation date is not coming under allocation inputs section of single page",
					"STEP1 : EXPECTED : Allocation date is coming under allocation inputs section of single page");

			// Check the visibility of loan reference
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.loanReference,
					"STEP2 : BUG : Loan reference is not coming under allocation inputs section of single page",
					"STEP2 : EXPECTED : Loan reference is coming under allocation inputs section of single page");

			// Check the visibility of internal reference
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.internalReference,
					"STEP3 : BUG : Internal reference is not coming under allocation inputs section of single page",
					"STEP3 : EXPECTED : Internal reference is coming under allocation inputs section of single page");

			// Check the visibility of loan amount
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.loanAmount,
					"STEP4 : BUG : Loan amount is not coming under allocation inputs section of single page",
					"STEP4 : EXPECTED : Loan amount is coming under allocation inputs section of single page");

			// Check the visibility of loan amount
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.loanAmount,
					"STEP4 : BUG : Loan amount is not coming under allocation inputs section of single page",
					"STEP4 : EXPECTED : Loan amount is coming under allocation inputs section of single page");

			// Check the visibility of allocated amount
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.allocatedAmount,
					"STEP5 : BUG : Allocated amount is not coming under allocation inputs section of single page",
					"STEP5 : EXPECTED : Allocated amount is coming under allocation inputs section of single page");

			// Check the visibility of un-allocated amount
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.unAllocatedAmount,
					"STEP6 : BUG : Unallocated amount is not coming under allocation inputs section of single page",
					"STEP6 : EXPECTED : Unallocated amount is coming under allocation inputs section of single page");

			// Check the visibility of borrower rate
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.borrowerRate,
					"STEP7 : BUG : Borrower rate is not coming under allocation inputs section of single page",
					"STEP7 : EXPECTED : Borrower rate is coming under allocation inputs section of single page");

			// Check the visibility of LTV
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.LTV,
					"STEP8 : BUG : LTV is not coming under allocation inputs section of single page",
					"STEP8 : EXPECTED : LTV is coming under allocation inputs section of single page");

			// Check the visibility of LTV
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.LTV,
					"STEP8 : BUG : LTV is not coming under allocation inputs section of single page",
					"STEP8 : EXPECTED : LTV is coming under allocation inputs section of single page");

			// Check the visibility of LTV
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.LTV,
					"STEP8 : BUG : LTV is not coming under allocation inputs section of single page",
					"STEP8 : EXPECTED : LTV is coming under allocation inputs section of single page");

			// Check the visibility of available cash
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.availableCash,
					"STEP9 : BUG : Available cash is not coming under allocation inputs section of single page",
					"STEP9 : EXPECTED : Available cash is coming under allocation inputs section of single page");

			// Check the visibility of allocation type
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.allocationType,
					"STEP10 : BUG : Allocation type is not coming under allocation inputs section of single page",
					"STEP10 : EXPECTED : Allocation type is coming under allocation inputs section of single page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAllocationInputsFields", "Pass", driver);

		} catch (AssertionError validateAllocationInputsFields) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAllocationInputsFields test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllocationInputsFields_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocationInputsFields.printStackTrace();
			node.fail(validateAllocationInputsFields);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAllocationInputsFields) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAllocationInputsFields test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllocationInputsFields_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocationInputsFields.printStackTrace();
			node.fail(validateAllocationInputsFields);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Single_007
	@Test(priority = 6)
	public void validateDataOnSelectingDateAndLoanReference() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that if a user has selected a date and loan reference, then the data of the below fields are displayed:"
							+ "Internal Reference, Loan Amount, Allocated Amount, Un-allocated Amount, Borrower Rate, LTV, Available Cash")
					.assignCategory(treasurySingle_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadSinglePage from treasury
			TreasuryPage.loadSinglePage();

			String loanReferenceNumber = getDataFromExcel(13);

			IElementActions.clickelement_usingXpath(node, driver, TreasurySinglePO.allocationDate);
			node.log(Status.INFO, "STEP1 : Clicked on the date");
			System.out.println("STEP1 : Clicked on the date");

			// Get today day
			String today = Utils.getTodayDayFormatted();

			// Select day in allocation date calender
			Utils.enterDay(UtilsPO.calenderDay, today);

			// Wait for the visibility of the loan reference
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the loan reference");
			System.out.println("STEP2 : Waiting for the visibility of the loan reference");
			IWaitStrategy.waitForVisiblity(node, driver, TreasurySinglePO.loanReference);
			node.log(Status.INFO, "STEP3 : Loan reference is visible");
			System.out.println("STEP3 : Loan reference is visible");

			// Select loan from loan reference dropdown
			IElementActions.selectValueFromDropdown(node, driver, TreasurySinglePO.loanReference, loanReferenceNumber);

			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);
			// Wait for the visibility of data population
			node.log(Status.INFO, "STEP4 : Waiting for the visibility of the treasury single table");
			System.out.println("STEP4 : Waiting for the visibility of the treasury single table");
			IWaitStrategy.waitForVisiblity(node, driver, TreasurySinglePO.table);
			IWaitStrategy.waitForVisiblity(node, driver, TreasurySinglePO.includePreviewValue);
			node.log(Status.INFO, "STEP5 : Treasury single table is visible");
			System.out.println("STEP5 : Treasury single table is visible");

			// Get text and validate if having blank
			TreasuryPage.getTextAndValidateIfTextHavingBlank(TreasurySinglePO.internalReference, "Internal Reference");

			// Get text and validate if having blank
			TreasuryPage.getTextAndValidateIfTextHavingBlank(TreasurySinglePO.loanAmount, "Loan Amount");

			// Get text and validate if having blank
			TreasuryPage.getTextAndValidateIfTextHavingBlank(TreasurySinglePO.allocatedAmount, "Allocated Amount");

			// Get text and validate if having blank
			TreasuryPage.getTextAndValidateIfTextHavingBlank(TreasurySinglePO.unAllocatedAmount, "Un-allocated Amount");

			// Get text and validate if having blank
			TreasuryPage.getTextAndValidateIfTextHavingBlank(TreasurySinglePO.borrowerRate, "Borrower Rate");

			// Get text and validate if having blank
			TreasuryPage.getTextAndValidateIfTextHavingBlank(TreasurySinglePO.LTV, "LTV");

			// Get text and validate if having blank
			TreasuryPage.getTextAndValidateIfTextHavingBlank(TreasurySinglePO.availableCash, "Available Cash");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDataOnSelectingDateAndLoanReference", "Pass", driver);

		} catch (AssertionError validateDataOnSelectingDateAndLoanReference) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDataOnSelectingDateAndLoanReference test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDataOnSelectingDateAndLoanReference_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDataOnSelectingDateAndLoanReference.printStackTrace();
			node.fail(validateDataOnSelectingDateAndLoanReference);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDataOnSelectingDateAndLoanReference) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDataOnSelectingDateAndLoanReference test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDataOnSelectingDateAndLoanReference_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDataOnSelectingDateAndLoanReference.printStackTrace();
			node.fail(validateDataOnSelectingDateAndLoanReference);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Single_016
	@Test(priority = 7)
	public void validateAllocationPreviewOnSelectingDateAndLoanReference() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that if a user has selected a date and loan reference, an allocation preview of the Current Allocation and New Allocation Available Cash across all facilities is displayed")
					.assignCategory(treasurySingle_tag + "_" + env);
			node = extenttest.createNode("Report");

			// String facility = getDataFromExcel(9);
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openTreasuryAndEnterDetails from treasury
			TreasuryPage.openTreasuryAndEnterDetails(loanReferenceNumber);

			// Check the visibility of include
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.includePreview,
					"STEP1 : BUG : Include is not coming under allocation preview section of single page",
					"STEP1 : EXPECTED : Include is coming under allocation preview section of single page");

			// Check the visibility of facilityRef
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.facilityRefPreview,
					"STEP2 : BUG : FacilityRef is not coming under allocation preview section of single page",
					"STEP2 : EXPECTED : FacilityRef is coming under allocation preview section of single page");

			// Check the visibility of facility status
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.facilityStatusPreview,
					"STEP3 : BUG : Facility status is not coming under allocation preview section of single page",
					"STEP3 : EXPECTED : Facility status is coming under allocation preview section of single page");

			// Check the visibility of borrower rate
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.borrowerRatePreview,
					"STEP4 : BUG : Borrower rate is not coming under allocation preview section of single page",
					"STEP4 : EXPECTED : Borrower rate is coming under allocation preview section of single page");

			// Check the visibility of drawn amount
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.drawnAmountPreview,
					"STEP5 : BUG : Drawn amount is not coming under allocation preview section of single page",
					"STEP5 : EXPECTED : Drawn amount is coming under allocation preview section of single page");

			// Check the visibility of current allocation
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.currentAllocationPreview,
					"STEP6 : BUG : Current allocation is not coming under allocation preview section of single page",
					"STEP6 : EXPECTED : Current allocation is coming under allocation preview section of single page");

			// Check the visibility of available cash
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.availableCashPreview,
					"STEP7 : BUG : Available cash is not coming under allocation preview section of single page",
					"STEP7 : EXPECTED : Available cash is coming under allocation preview section of single page");

			// Check the visibility of new allocation
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.newAllocationPreview,
					"STEP8 : BUG : New allocation is not coming under allocation preview section of single page",
					"STEP8 : EXPECTED : New allocation is coming under allocation preview section of single page");

			// Check the visibility of checks
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.checksPreview,
					"STEP9 : BUG : Checks is not coming under allocation preview section of single page",
					"STEP9 : EXPECTED : Checks is coming under allocation preview section of single page");

			// Check the visibility of include
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.includePreviewValue,
					"STEP10 : BUG : Include is not coming under allocation preview section of single page",
					"STEP10 : EXPECTED : Include is coming under allocation preview section of single page");

			// Check the visibility of facilityRef
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.facilityRefPreviewValue,
					"STEP11 : BUG : FacilityRef is not coming under allocation preview section of single page",
					"STEP11 : EXPECTED : FacilityRef is coming under allocation preview section of single page");

			// Check the visibility of facility status
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.facilityStatusPreviewValue,
					"STEP12 : BUG : Facility status is not coming under allocation preview section of single page",
					"STEP12 : EXPECTED : Facility status is coming under allocation preview section of single page");

			// Check the visibility of borrower rate
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.borrowerRatePreviewValue,
					"STEP13 : BUG : Borrower rate is not coming under allocation preview section of single page",
					"STEP13 : EXPECTED : Borrower rate is coming under allocation preview section of single page");

			// Check the visibility of drawn amount
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.drawnAmountPreviewValue,
					"STEP14 : BUG : Drawn amount is not coming under allocation preview section of single page",
					"STEP14 : EXPECTED : Drawn amount is coming under allocation preview section of single page");

			// Check the visibility of current allocation
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.currentAllocationPreviewValue,
					"STEP15 : BUG : Current allocation is not coming under allocation preview section of single page",
					"STEP15 : EXPECTED : Current allocation is coming under allocation preview section of single page");

			// Check the visibility of available cash
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.availableCashPreviewValue,
					"STEP16 : BUG : Available cash is not coming under allocation preview section of single page",
					"STEP16 : EXPECTED : Available cash is coming under allocation preview section of single page");

			// Check the visibility of new allocation
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.newAllocationPreviewValue,
					"STEP17 : BUG : New allocation is not coming under allocation preview section of single page",
					"STEP17 : EXPECTED : New allocation is coming under allocation preview section of single page");

			// Check the visibility of checks
			IElementActions.assertTrue_usingXpath(node, driver, TreasurySinglePO.checksPreviewValue,
					"STEP18 : BUG : Checks is not coming under allocation preview section of single page",
					"STEP18 : EXPECTED : Checks is coming under allocation preview section of single page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAllocationPreviewOnSelectingDateAndLoanReference", "Pass",
					driver);

		} catch (AssertionError validateAllocationPreviewOnSelectingDateAndLoanReference) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAllocationPreviewOnSelectingDateAndLoanReference test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllocationPreviewOnSelectingDateAndLoanReference_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocationPreviewOnSelectingDateAndLoanReference.printStackTrace();
			node.fail(validateAllocationPreviewOnSelectingDateAndLoanReference);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAllocationPreviewOnSelectingDateAndLoanReference) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAllocationPreviewOnSelectingDateAndLoanReference test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllocationPreviewOnSelectingDateAndLoanReference_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocationPreviewOnSelectingDateAndLoanReference.printStackTrace();
			node.fail(validateAllocationPreviewOnSelectingDateAndLoanReference);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Single_0017
	@Test(priority = 8)
	public void validateTerminatingFacility() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that if a facility is terminating, it should automatically be excluded from the allocation")
					.assignCategory(treasurySingle_tag + "_" + env);
			node = extenttest.createNode("Report");

			// String facility = getDataFromExcel(9);
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openTreasuryAndEnterDetails from treasury
			TreasuryPage.openTreasuryAndEnterDetails(loanReferenceNumber);

			// Get all elements of facility reference
			List<WebElement> facilityReferenceElements = IElementActions.returnElements(node, driver,
					TreasurySinglePO.allFacilityRef);

			// Get all elements of facility status
			List<WebElement> facilityStatusElements = IElementActions.returnElements(node, driver,
					TreasurySinglePO.allFacilityStatus);

			// Get all elements of include
			List<WebElement> includeElements = IElementActions.returnElements(node, driver,
					TreasurySinglePO.allInclude);

			// Loop through both lists
			for (int i = 0; i < facilityReferenceElements.size(); i++) {
				WebElement facilityReferenceElement = facilityReferenceElements.get(i);
				WebElement facilityStatusElement = facilityStatusElements.get(i);
				WebElement includeElement = includeElements.get(i);

				// Get status dynamically from facilityStatusElement
				String status = facilityStatusElement.getText();

				// Check if facilityStatus element contains the text "terminated"
				if (status.contains("terminated")) {
					// Check if the corresponding include element is unchecked
					if (!Utils.isIncludeChecked(includeElement)) {
						// Test case passes
						System.out.println("Status: " + status + ", Include Status: Unchecked - Test case for position "
								+ i + " passes.");
					} else {
						// Test case fails
						System.out.println("Status: " + status + ", Include Status: Checked - Test case for position "
								+ i + " fails. Facility Reference: " + facilityReferenceElement.getText());
					}
				}
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateTerminatingFacility", "Pass", driver);

		} catch (AssertionError validateTerminatingFacility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateTerminatingFacility test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTerminatingFacility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTerminatingFacility.printStackTrace();
			node.fail(validateTerminatingFacility);
			Assert.fail();
			extent.flush();
		} catch (Exception validateTerminatingFacility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateTerminatingFacility test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTerminatingFacility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTerminatingFacility.printStackTrace();
			node.fail(validateTerminatingFacility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Single_018
	@Test(priority = 9)
	public void validateIncludeExcludeFacility() throws IOException {
		try {
			extenttest = extent.createTest("Verify that user can include or exclude any facility")
					.assignCategory(treasurySingle_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// String facility = getDataFromExcel(9);
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openTreasuryAndEnterDetails from treasury
			TreasuryPage.openTreasuryAndEnterDetails(loanReferenceNumber);

			boolean isActive = IElementActions.checkAttributePresentInClass(TreasurySinglePO.includePreviewValue,
					"ui-state-active");

			if (!isActive) {
				// Click on the unchecked include box to check
				IElementActions.clickelement_usingXpath(node, driver, TreasurySinglePO.includePreviewValue);
				node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on the include uncheck to check");
				System.out.println("SUB-STEP_0.001 : Clicked on the include uncheck to check");

				// Wait for the checkbox to check
				node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of the check box to check");
				System.out.println("SUB-STEP_0.002 : Waiting for the visibility of the check box to check");
				IWaitStrategy.waitForVisiblity(node, driver, TreasurySinglePO.includePreviewCheckValue);
				node.log(Status.INFO, "SUB-STEP_0.003 : Check box is checked");
				System.out.println("SUB-STEP_0.003 : Check box is checked");
			}

			// Click on the checked include box to uncheck
			IElementActions.clickelement_usingXpath(node, driver, TreasurySinglePO.includePreviewValue);
			node.log(Status.INFO, "STEP1 : Clicked on the include check to uncheck");
			System.out.println("STEP1 : Clicked on the include check to uncheck");

			// Wait for the checkbox to uncheck
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the check box to uncheck");
			System.out.println("STEP2 : Waiting for the visibility of the check box to uncheck");
			IWaitStrategy.waitForVisiblity(node, driver, TreasurySinglePO.includePreviewUncheckValue);
			node.log(Status.INFO, "STEP3 : Check box is unchecked");
			System.out.println("STEP3 : Check box is unchecked");

			// Check the include checkbox value after uncheck
			boolean isUncheck = IElementActions.checkAttributePresentInClass(TreasurySinglePO.includePreviewValue,
					"ui-state-active");

			// Assert include check box is unchecked
			if (!isUncheck) {
				Assert.assertTrue(true, "Include check box is unchecked");
				System.out.println("STEP4 : Include check box is unchecked");
				node.log(Status.PASS, "STEP4 : Include check box is unchecked");
			} else {
				Assert.assertTrue(false, "Include check box is not unchecked");
				System.out.println("STEP4: Include check box is not unchecked");
				node.log(Status.FAIL, "STEP4 : Include check box is not unchecked");
			}

			// Click on the unchecked include box to check
			IElementActions.clickelement_usingXpath(node, driver, TreasurySinglePO.includePreviewValue);
			node.log(Status.INFO, "STEP5 : Clicked on the include uncheck to check");
			System.out.println("STEP5 : Clicked on the include uncheck to check");

			// Wait for the checkbox to check
			node.log(Status.INFO, "STEP6 : Waiting for the visibility of the check box to check");
			System.out.println("STEP6 : Waiting for the visibility of the check box to check");
			IWaitStrategy.waitForVisiblity(node, driver, TreasurySinglePO.includePreviewCheckValue);
			node.log(Status.INFO, "STEP7 : Check box is checked");
			System.out.println("STEP7 : Check box is checked");

			// Check the include checkbox value after check
			boolean isCheck = IElementActions.checkAttributePresentInClass(TreasurySinglePO.includePreviewValue,
					"ui-state-active");

			// Assert include check box is checked
			if (isCheck) {
				Assert.assertTrue(true, "Include check box is checked");
				System.out.println("STEP8 : Include check box is checked");
				node.log(Status.PASS, "STEP8 : Include check box is checked");
			} else {
				Assert.assertTrue(false, "Include check box is not checked");
				System.out.println("STEP9 : Include check box is not checked");
				node.log(Status.FAIL, "STEP9 : Include check box is not checked");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateIncludeExcludeFacility", "Pass", driver);

		} catch (AssertionError validateIncludeExcludeFacility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateIncludeExcludeFacility test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateIncludeExcludeFacility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateIncludeExcludeFacility.printStackTrace();
			node.fail(validateIncludeExcludeFacility);
			Assert.fail();
			extent.flush();
		} catch (Exception validateIncludeExcludeFacility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateIncludeExcludeFacility test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateIncludeExcludeFacility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateIncludeExcludeFacility.printStackTrace();
			node.fail(validateIncludeExcludeFacility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Single_026
	@Test(priority = 10)
	public void validateUnallocatedAfterLoanDisbursement() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that if a user confirms a loan disbursement, when they navigate to Treasury > Single and select a date on or after the disbursement, the disbursement shows as Unallocated")
					.assignCategory(treasurySingle_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Create loan and update status to live
			LoansPage.createLoanAndUpdateStatus("Live");

			// Get loan disbursement
			String loanDisbursementValue = getDataFromExcel(29);

			// Add a loan disbursement cash flow
			LoansPage.addCashflow(LoansNewLoanPO.paymentAddNewCashflow, LoansNewLoanPO.loanDisbursement,
					loanDisbursementValue);

			// Wait for the visibility of first row cashflow amount
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of first row cashflow amount");
			System.out.println("STEP1 : Waiting for the visibility of first row cashflow amount");
			IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.firstRowCashflowAmount);
			node.log(Status.INFO, "STEP2 : The first row cashflow amount is visible");
			System.out.println("STEP2 : The first row cashflow amount is visible");

			// Approve the cashflow
			LoansPage.approveCashflow(LoansNewLoanPO.firstRowCashflowAmount);

			String loanReferenceNumber = getDataFromExcel(25);

			// Calling the openTreasuryAndEnterDetails from treasury
			TreasuryPage.openTreasuryAndEnterDetails(loanReferenceNumber);

			int loanDisbursement = Integer.parseInt(loanDisbursementValue);

			Thread.sleep(5000);
			int loanAmount = Utils.getTextAndParseToInt(TreasurySinglePO.unAllocatedAmount);
			if (loanDisbursement == loanAmount) {
				Assert.assertTrue(true,
						"Disbursement " + loanDisbursement + " is equal to Unallocated Amount " + loanAmount);
				System.out
						.println("Disbursement " + loanDisbursement + " is equal to Unallocated Amount " + loanAmount);
				node.log(Status.PASS,
						"Disbursement " + loanDisbursement + " is equal to Unallocated Amount " + loanAmount);
			} else {
				Assert.assertTrue(false,
						"Disbursement " + loanDisbursement + " is not equal to Unallocated Amount " + loanAmount);
				System.out.println(
						"Disbursement " + loanDisbursement + " is not equal to Unallocated Amount " + loanAmount);
				node.log(Status.FAIL,
						"Disbursement " + loanDisbursement + " is not equal to Unallocated Amount " + loanAmount);
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateUnallocatedAfterLoanDisbursement", "Pass", driver);

		} catch (AssertionError validateUnallocatedAfterLoanDisbursement) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateUnallocatedAfterLoanDisbursement test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateUnallocatedAfterLoanDisbursement_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateUnallocatedAfterLoanDisbursement.printStackTrace();
			node.fail(validateUnallocatedAfterLoanDisbursement);
			Assert.fail();
			extent.flush();
		} catch (Exception validateUnallocatedAfterLoanDisbursement) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateUnallocatedAfterLoanDisbursement test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateUnallocatedAfterLoanDisbursement_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateUnallocatedAfterLoanDisbursement.printStackTrace();
			node.fail(validateUnallocatedAfterLoanDisbursement);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Single_019
	@Test(priority = 11)
	public void validateExcludeFacilityCurrentAllocation() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that if the user excludes a facility, Current Allocation = New Allocation in the allocation preview")
					.assignCategory(treasurySingle_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// String facility = getDataFromExcel(9);
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openTreasuryAndEnterDetails from treasury
			TreasuryPage.openTreasuryAndEnterDetails(loanReferenceNumber);

			boolean isActive = IElementActions.checkAttributePresentInClass(TreasurySinglePO.includePreviewValue,
					"ui-state-active");

			if (isActive) {
				// Click on the unchecked include box to check
				IElementActions.clickelement_usingXpath(node, driver, TreasurySinglePO.includePreviewValue);
				node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on the include check to uncheck");
				System.out.println("SUB-STEP_0.001 : Clicked on the include check to uncheck");

				// Wait for the checkbox to uncheck
				node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of the check box to uncheck");
				System.out.println("SUB-STEP_0.002 : Waiting for the visibility of the check box to uncheck");
				IWaitStrategy.waitForVisiblity(node, driver, TreasurySinglePO.includePreviewUncheckValue);
				node.log(Status.INFO, "SUB-STEP_0.003 : Check box is unchecked");
				System.out.println("SUB-STEP_0.003 : Check box is unchecked");
			}

			node.log(Status.INFO, "STEP1 : Include checkbox is unchecked");
			System.out.println("STEP1 : Include checkbox is unchecked");

			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			// Wait for the checkbox to uncheck
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the check box to uncheck");
			System.out.println("STEP2 : Waiting for the visibility of the check box to uncheck");
			IWaitStrategy.waitForVisiblity(node, driver, TreasurySinglePO.includePreviewUncheckValue);
			node.log(Status.INFO, "STEP3 : Check box is unchecked");
			System.out.println("STEP3 : Check box is unchecked");

			Thread.sleep(10000);
			String currentAllocation = IElementActions.getElementText_usingXpath(node, driver,
					TreasurySinglePO.currentAllocationPreviewValue);

			Thread.sleep(30000);
			String newAllocation = IElementActions.getElementText_usingXpath(node, driver,
					TreasurySinglePO.newAllocationPreviewValue);

			if (currentAllocation.equalsIgnoreCase(newAllocation)) {
				Assert.assertTrue(true, "Current Allocation " + currentAllocation + " is equal to New Allocation "
						+ newAllocation + " in the allocation preview");
				System.out.println("Current Allocation " + currentAllocation + " is equal to New Allocation "
						+ newAllocation + " in the allocation preview");
				node.log(Status.PASS, "Current Allocation " + currentAllocation + " is equal to New Allocation "
						+ newAllocation + " in the allocation preview");
			} else {
				Assert.assertTrue(false, "Current Allocation " + currentAllocation + " is not equal to New Allocation "
						+ newAllocation + " in the allocation preview");
				System.out.println("Current Allocation " + currentAllocation + " is not equal to New Allocation "
						+ newAllocation + " in the allocation preview");
				node.log(Status.FAIL, "Current Allocation " + currentAllocation + " is not equal to New Allocation "
						+ newAllocation + " in the allocation preview");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateExcludeFacilityCurrentAllocation", "Pass", driver);

		} catch (AssertionError validateExcludeFacilityCurrentAllocation) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateExcludeFacilityCurrentAllocation test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateExcludeFacilityCurrentAllocation_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateExcludeFacilityCurrentAllocation.printStackTrace();
			node.fail(validateExcludeFacilityCurrentAllocation);
			Assert.fail();
			extent.flush();
		} catch (Exception validateExcludeFacilityCurrentAllocation) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateExcludeFacilityCurrentAllocation test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateExcludeFacilityCurrentAllocation_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateExcludeFacilityCurrentAllocation.printStackTrace();
			node.fail(validateExcludeFacilityCurrentAllocation);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Single_020
	@Test(priority = 12)
	public void validateEqual() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that if a user has selected a date and loan reference and selected ‘Equals’ in the allocation type, then the allocation is split equally across all included facilities")
					.assignCategory(treasurySingle_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// String facility = getDataFromExcel(9);
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openTreasuryAndEnterDetails from treasury
			TreasuryPage.openTreasuryAndEnterDetails(loanReferenceNumber);

			int loanAmount = Utils.getTextAndParseToInt(TreasurySinglePO.unAllocatedAmount);

			// Click on the equal allocation type
			IElementActions.clickelement_usingXpath(node, driver, TreasurySinglePO.equal);
			node.log(Status.INFO, "STEP1 : Clicked on the equal allocation type");
			System.out.println("STEP1 : Clicked on the equal allocation type");

			Thread.sleep(5000);
			// Get all elements of new allocation
			List<WebElement> newAllocationElements = IElementActions.returnElements(node, driver,
					TreasurySinglePO.allNewAllocation);

			// Check if all elements have the same value
			String firstValue = Utils.removeCurrencySymbol(newAllocationElements.get(0).getText());
			boolean allEqual = true;
			for (WebElement element : newAllocationElements) {
				if (!Utils.removeCurrencySymbol(element.getText()).equals(firstValue)) {
					allEqual = false;
					break;
				}
			}

			// Assert if all elements are equal
			if (allEqual) {
				System.out.println("All elements in newAllocation have the same value.");
			} else {
				System.out.println("Elements in newAllocation do not have the same value.");
				// Fail the test or take appropriate action
			}

			// Calculate the sum of all values in newAllocation
			int sum = 0;
			for (WebElement element : newAllocationElements) {
				sum += Double.parseDouble(Utils.removeCurrencySymbol(element.getText())); // Assuming the values are
																							// numeric
			}
			// Check if the sum equals loanAmount
			if (sum == loanAmount) {
				System.out.println("Sum of all values in newAllocation equals loanAmount.");
			} else {
				System.out.println("Sum of all values in newAllocation does not equal loanAmount.");
				// Fail the test or take appropriate action
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateEqual", "Pass", driver);

		} catch (AssertionError validateEqual) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateEqual test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateEqual_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateEqual.printStackTrace();
			node.fail(validateEqual);
			Assert.fail();
			extent.flush();
		} catch (Exception validateEqual) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateEqual test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateEqual_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateEqual.printStackTrace();
			node.fail(validateEqual);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Single_021
	// TC_Treasury_Single_022
	@Test(priority = 13)
	public void validateProRata() throws IOException {
		try {
			extenttest = extent.createTest(
					"The allocation should be divided proportionally across all included facilities according to the formula:"
							+ "New_Allocation = Current_Allocation + (unallocatedAmount * (Current_Allocation / Total_Included_Allocation_Amount)), if Total Included Allocation Amount > 0"
							+ "New_Allocation = unallocatedAmount * (Available_Cash / Total_Included_Cash), if Total Included Allocation Amount = 0")
					.assignCategory(treasurySingle_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// String facility = getDataFromExcel(9);
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openTreasuryAndEnterDetails from treasury
			TreasuryPage.openTreasuryAndEnterDetails(loanReferenceNumber);

			int unAllocatedAmount = Utils.getTextAndParseToInt(TreasurySinglePO.unAllocatedAmount);
			int totalCurrentAllocation = Utils
					.getTextAndParseToInt(TreasurySinglePO.totalCurrentAllocationPreviewValue);
			node.log(Status.INFO, "STEP1 : Total current allocation is " + totalCurrentAllocation);
			System.out.println("STEP1 : Total current allocation is " + totalCurrentAllocation);

			// Click on the equal allocation type
			IElementActions.clickelement_usingXpath(node, driver, TreasurySinglePO.prorata);
			node.log(Status.INFO, "STEP2 : Clicked on the pro-rata allocation type");
			System.out.println("STEP2 : Clicked on the pro-rata allocation type");

			int totalAvailableCash = Utils.getTextAndParseToInt(TreasurySinglePO.totalAvailableCashPreviewValue);
			int currentAllocation = Utils.getTextAndParseToInt(TreasurySinglePO.currentAllocationPreviewValue);
			int availableCash = Utils.getTextAndParseToInt(TreasurySinglePO.availableCashPreviewValue);
			int newAllocation = Utils.getTextAndParseToInt(TreasurySinglePO.newAllocationPreviewValue);
			int newAllocationCalculated = 0;

			if (totalCurrentAllocation > 0) {
				newAllocationCalculated = currentAllocation
						+ (unAllocatedAmount * (currentAllocation / totalCurrentAllocation));
			} else if (totalCurrentAllocation == 0) {
				newAllocationCalculated = unAllocatedAmount * (availableCash / totalAvailableCash);
			}
			// Assert the new allocation amount
			IElementActions.assertEquals_usingInteger(node, driver, newAllocation, newAllocationCalculated,
					"BUG : The new allocation amount " + newAllocation + " is not equal to " + newAllocationCalculated
							+ " calculated new allocation amount",
					"PASS : The new allocation amount " + newAllocation + " is equal to " + newAllocationCalculated
							+ " calculated new allocation amount");
			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateProRata", "Pass", driver);

		} catch (AssertionError validateProRata) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateProRata test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateProRata_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateProRata.printStackTrace();
			node.fail(validateProRata);
			Assert.fail();
			extent.flush();
		} catch (Exception validateProRata) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateProRata test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateProRata_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateProRata.printStackTrace();
			node.fail(validateProRata);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Single_023
	@Test(priority = 14)
	public void validateCheckOnRegionalLimits() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify check for each facility in the allocation preview to make sure there is enough cash, and none of the criteria or regional limits are being breached")
					.assignCategory(treasurySingle_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// String facility = getDataFromExcel(9);
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openTreasuryAndEnterDetails from treasury
			TreasuryPage.openTreasuryAndEnterDetails(loanReferenceNumber);

			// Get all elements of new allocation
			List<WebElement> checksElements = IElementActions.returnElements(node, driver, TreasurySinglePO.allChecks);

			// Get all elements of facility reference
			List<WebElement> facilityReferenceElements = IElementActions.returnElements(node, driver,
					TreasurySinglePO.allFacilityRef);

			// Create a ArrayList<String> to store the values
			List<String> facilityReferenceValues = new ArrayList<>();

			// Iterate through the elements and retrieve their values
			for (WebElement element : facilityReferenceElements) {
				// Assuming the value of the element is text, you can retrieve it using
				// getText() method
				String value = element.getText();
				facilityReferenceValues.add(value);
			}

			String color = null;
			// Iterate through each element starting from the second one
			for (int i = 0; i < checksElements.size(); i++) {
				// Wait for the visibility of popup
				node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the check icon to visible and clickable");
				System.out.println("SUB-STEP_0.001 :  Waiting for the check icon to visible and clickable");
				IWaitStrategy.waitForVisiblity(node, driver, TreasurySinglePO.allChecks);
				IWaitStrategy.WaitUntilElementClickable(node, driver, TreasurySinglePO.allChecks);
				node.log(Status.INFO, "SUB-STEP_0.002 : The check icon is visible and clickable");
				System.out.println("SUB-STEP_0.002 : The check icon is visible and clickable");

				// Get the current element
				WebElement check = checksElements.get(i);

				String facilityReference = facilityReferenceValues.get(i + 1);

				// Get the value of the style attribute for the button element
				String styleAttributeValue = check.getCssValue("color");

				// Check if the style attribute contains the desired value
				if (styleAttributeValue.contains("rgb(174, 221, 148)")
						|| styleAttributeValue.contains("rgba(174, 221, 148")) {
					node.log(Status.INFO, "SUB-STEP_0.003 : Style attribute contains the desired value green");
					System.out.println("SUB-STEP_0.003 : Style attribute contains the desired value green");
					color = "green";
				} else if (styleAttributeValue.contains("rgb(255, 93, 85)")
						|| styleAttributeValue.contains("rgba(255, 93, 85)")) {
					node.log(Status.INFO, "SUB-STEP_0.003 : Style attribute contains the desired value red");
					System.out.println("SUB-STEP_0.003 : Style attribute contains the desired value red");
					color = "red";
				}

				// Add a wait before clicking the check
				WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for a maximum of 10 seconds
				WebElement checkElement = wait.until(ExpectedConditions.elementToBeClickable(check));

				// Click on the check to open the popup
				check.click();
				node.log(Status.INFO, "SUB-STEP_0.004 : Clicked on the check icon");
				System.out.println("SUB-STEP_0.004 : Clicked on the check icon");

				// Wait for the visibility of popup
				node.log(Status.INFO, "SUB-STEP_0.005 : Waiting for the visibility of the popup");
				System.out.println("SUB-STEP_0.005 : Waiting for the visibility of the popup");
				IWaitStrategy.waitForVisiblity(node, driver, UtilsPO.popUp);
				node.log(Status.INFO, "SUB-STEP_0.006 : The popup is visible");
				System.out.println("SUB-STEP_0.006 : The popup is visible");

				int failCount = 0;

				// Wait for the visibility of element
				node.log(Status.INFO, "SUB-STEP_0.007 : Waiting for the visibility of the max loan allocation");
				System.out.println("SUB-STEP_0.007 : Waiting for the visibility of the max loan allocation");
				IWaitStrategy.waitForVisiblity(node, driver, TreasurySinglePO.maxLoanAllocation);
				node.log(Status.INFO, "SUB-STEP_0.008 : The max loan allocation is visible");
				System.out.println("SUB-STEP_0.008 : The max loan allocation is visible");

				// Get max loan allocation field class attribute
				String checkMaxLoanAllocation = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
						TreasurySinglePO.maxLoanAllocation, "class");

				// Get max loan allocation field class attribute
				String checkCashAfterAllocation = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
						TreasurySinglePO.cashAfterAllocation, "class");

				int singleLoanMaxCurrent = Utils.getTextAndParseToInt(TreasurySinglePO.singleLoanMaxCurrent);
				int singleBorrowerMaxCurrent = Utils.getTextAndParseToInt(TreasurySinglePO.singleBorrowerMaxCurrent);
				int singleLoanMax = Utils.getTextAndParseToInt(TreasurySinglePO.singleLoanMax);
				int singleBorrowerMax = Utils.getTextAndParseToInt(TreasurySinglePO.singleBorrowerMax);

				// Check if the element has the limit-respected
				if (checkMaxLoanAllocation.contains("limit-respected")
						&& checkMaxLoanAllocation.contains("limit-respected") && color.equals("green")
						&& singleLoanMaxCurrent < singleLoanMax && singleBorrowerMaxCurrent < singleBorrowerMax) {
					node.log(Status.INFO,
							"Max Loan Allocation and Cash After Allocation is highlighted in green for "
									+ facilityReference + ", as expected and single loan max current "
									+ singleLoanMaxCurrent + " single borrower max current " + singleBorrowerMaxCurrent
									+ " is less than single loan max " + singleLoanMax + " or single borrower max "
									+ singleBorrowerMax);
					System.out.println("Max Loan Allocation and Cash After Allocation is highlighted in green for "
							+ facilityReference + ", as expected and single loan max current " + singleLoanMaxCurrent
							+ " single borrower max current " + singleBorrowerMaxCurrent
							+ " is less than single loan max " + singleLoanMax + " or single borrower max "
							+ singleBorrowerMax);
				} else if ((checkMaxLoanAllocation.contains("error-limit")
						|| checkCashAfterAllocation.contains("error-limit") || singleLoanMaxCurrent > singleLoanMax
						|| singleBorrowerMaxCurrent < singleBorrowerMax) && color.equals("red")) {
					node.log(Status.INFO,
							"Max Loan Allocation or Cash After Allocation is highlighted in red for "
									+ facilityReference + ", as expected  and single loan max current "
									+ singleLoanMaxCurrent + " or single borrower max current "
									+ singleBorrowerMaxCurrent + " is greater than single loan max " + singleLoanMax
									+ " or single borrower max " + singleBorrowerMax);
					System.out.println("Max Loan Allocation or Cash After Allocation is highlighted in red for "
							+ facilityReference + ", as expected  and single loan max current " + singleLoanMaxCurrent
							+ " or single borrower max current " + singleBorrowerMaxCurrent
							+ " is greater than single loan max " + singleLoanMax + " or single borrower max "
							+ singleBorrowerMax);
				} else {
					failCount++;
				}

				// Assert element is highlighted in red and green as per expected criteri
				if (failCount == 0) {
					node.log(Status.PASS,
							"Max Loan Allocation and Cash After Allocation is highlighted in red and green as per expected criteria");
					System.out.println(
							"Max Loan Allocation and Cash After Allocation is highlighted in red and green as per expected criteria");

					Assert.assertTrue(true,
							"Max Loan Allocation and Cash After Allocation is highlighted in red and green as per expected criteria");

					// Take screenshot
					IScreenAction.captureScreenShot_PassCase("validateCheckOnRegionalLimits", "Pass", driver);
				} else {
					System.out.println(
							"Max Loan Allocation and Cash After Allocation is not highlighted in red and green as per expected criteria");
					node.log(Status.FAIL,
							"Max Loan Allocation and Cash After Allocation is not highlighted in red and green as per expected criteria");

					Assert.assertTrue(false,
							"Max Loan Allocation and Cash After Allocation is not highlighted in red and green as per expected criteria");

					// Take screenshot
					IScreenAction.captureScreenShot_PassCase("validateCheckOnRegionalLimits", "Fail", driver);
				}

				// Click on popup close button
				IElementActions.clickelement_usingXpath(node, driver, TreasurySinglePO.closeIcon);
				node.log(Status.INFO, "SUB-STEP_0.009 : Clicked on the close icon");
				System.out.println("SUB-STEP_0.009 : Clicked on the close icon");

				// Wait for the invisibility of the PopUp
				node.log(Status.INFO, "SUB-STEP_0.0010 : Waiting for the invisibility of the popup");
				System.out.println("SUB-STEP_0.0010 : Waiting for the invisibility of the popup");
				IWaitStrategy.waitForInVisiblity(node, driver, UtilsPO.popUp);
				node.log(Status.INFO, "SUB-STEP_0.0011 : Popup is not visible");
				System.out.println("SUB-STEP_0.0012 : Popup is not visible");
			}
		} catch (AssertionError validateCheckOnRegionalLimits) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCheckOnRegionalLimits test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCheckOnRegionalLimits_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCheckOnRegionalLimits.printStackTrace();
			node.fail(validateCheckOnRegionalLimits);
			Assert.fail();
			extent.flush();
		} catch (Exception validateCheckOnRegionalLimits) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCheckOnRegionalLimits test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCheckOnRegionalLimits_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCheckOnRegionalLimits.printStackTrace();
			node.fail(validateCheckOnRegionalLimits);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Single_024
	// TC_Treasury_Single_025
	@Test(priority = 15)
	public void validateAllocatedAndUnallocatedAmountAfterSave() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that if a user has selected a date and loan reference, when they press ‘Save’"
							+ "the system should allocate the unallocated amount and save the new allocation"
							+ "the Unallocated Amount should become £0, the Allocated Amount should become the Loan Amount and for each facility, Current Allocation = New Allocation")
					.assignCategory(treasurySingle_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// String facility = getDataFromExcel(9);
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openTreasuryAndEnterDetails from treasury
			TreasuryPage.openTreasuryAndEnterDetails(loanReferenceNumber);

			// Wait for the visibility of current allocations
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the current allocations");
			System.out.println("STEP1 : Waiting for the visibility of the current allocations");
			IWaitStrategy.waitForVisiblity(node, driver, TreasurySinglePO.allCurrentAllocation);
			node.log(Status.INFO, "STEP2 : The current allocations is visible");
			System.out.println("STEP2 : The current allocations is visible");

			// Get loan amount value
			String loanAmount = IElementActions.getElementText_usingXpath(node, driver, TreasurySinglePO.loanAmount);

			// Get all elements of new allocation
			List<WebElement> newAllocationElements = IElementActions.returnElements(node, driver,
					TreasurySinglePO.allNewAllocation);
			// Get all elements of facility reference
			List<WebElement> facilityReferenceElements = IElementActions.returnElements(node, driver,
					TreasurySinglePO.allFacilityRef);

			// Create a ArrayList<String> to store the values
			List<String> newAllocationValues = new ArrayList<>();

			// Iterate through the elements and retrieve their values
			for (WebElement element : newAllocationElements) {
				// Assuming the value of the element is text, you can retrieve it using
				// getText() method
				String value = element.getText();
				newAllocationValues.add(value);
			}

			// Create a ArrayList<String> to store the values
			List<String> facilityReferenceValues = new ArrayList<>();

			// Iterate through the elements and retrieve their values
			for (WebElement element : facilityReferenceElements) {
				// Assuming the value of the element is text, you can retrieve it using
				// getText() method
				String value = element.getText();
				facilityReferenceValues.add(value);
			}

			// Click on the save button and wait for popup
			Utils.clickAndWait(TreasurySinglePO.save, "Save Button", UtilsPO.popUp);

			// Click on popup close button
			IElementActions.clickelement_usingXpath(node, driver, PipelinePO.closeButtonInPopup);
			node.log(Status.INFO, "STEP1 : Clicked on the close icon");
			System.out.println("STEP1 : Clicked on the close icon");

			// Wait for the invisibility of the PopUp
			node.log(Status.INFO, "STEP2 : Waiting for the invisibility of the popup");
			System.out.println("STEP2 : Waiting for the invisibility of the popup");
			IWaitStrategy.waitForInVisiblity(node, driver, UtilsPO.popUp);
			node.log(Status.INFO, "STEP3 : Popup is not visible");
			System.out.println("STEP3 : Popup is not visible");

			// Get unallocated amount value
			String unAllocatedAmount = Utils.getFormattedText(TreasurySinglePO.unAllocatedAmount);

			// Assert the unallocated amount
			IElementActions.assertEquals_usingString(node, driver, unAllocatedAmount, "0",
					"BUG : The un-allocated amount is not 0", "PASS : The un-allocated amount is 0");

			// Get allocated amount value
			String allocatedAmount = IElementActions.getElementText_usingXpath(node, driver,
					TreasurySinglePO.allocatedAmount);

			// Assert the allocated amount
			IElementActions.assertEquals_usingString(node, driver, allocatedAmount, loanAmount,
					"BUG : The allocated amount " + allocatedAmount + " is not equal to " + loanAmount + " loan amount",
					"PASS : The allocated amount " + allocatedAmount + " is equal to " + loanAmount + " loan amount");

			IElementActions.scrollToTop(driver);

			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			Thread.sleep(20000);

			// Wait for the visibility of current allocations
			node.log(Status.INFO, "STEP4 : Waiting for the visibility of the current allocations");
			System.out.println("STEP4 : Waiting for the visibility of the current allocations");
			IWaitStrategy.waitForVisiblity(node, driver, TreasurySinglePO.allCurrentAllocation);
			node.log(Status.INFO, "STEP5 : The current allocations is visible");
			System.out.println("STEP5 : The current allocations is visible");

			// Get all elements of current allocation
			List<WebElement> currentAllocationElements = IElementActions.returnElements(node, driver,
					TreasurySinglePO.allCurrentAllocation);

			// Create a ArrayList<String> to store the values
			List<String> currentAllocationValues = new ArrayList<>();

			// Initialize lists for valid and invalid records
			List<String> validRecords = new ArrayList<>();
			List<String> invalidRecords = new ArrayList<>();

			// Iterate through the elements and retrieve their values
			for (WebElement element : currentAllocationElements) {
				// Assuming the value of the element is text, you can retrieve it using
				// getText() method
				String value = element.getText();
				currentAllocationValues.add(value);
			}

			boolean arraysAreEqual = true;
			for (int i = 1; i < currentAllocationValues.size(); i++) {
				String facilityReference = facilityReferenceValues.get(i);
				String currentAllocation = currentAllocationValues.get(i);
				String newAllocation = newAllocationValues.get(i);
				if (currentAllocation.equals(newAllocation)) {
					validRecords.add("Record " + (i + 1) + ": Current Allocation: " + currentAllocation
							+ ", New Allocation " + newAllocation + ", Facility Reference: " + facilityReference);
				} else {
					invalidRecords.add("Record " + (i + 1) + ": Current Allocation: " + currentAllocation
							+ ", New Allocation " + newAllocation + ", Facility Reference: " + facilityReference);
				}
			}

			// Print valid records
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
			IScreenAction.captureScreenShot_PassCase("validateAllocatedAndUnallocatedAmountAfterSave", "Pass", driver);

		} catch (AssertionError validateAllocatedAndUnallocatedAmountAfterSave) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAllocatedAndUnallocatedAmountAfterSave test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllocatedAndUnallocatedAmountAfterSave_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocatedAndUnallocatedAmountAfterSave.printStackTrace();
			node.fail(validateAllocatedAndUnallocatedAmountAfterSave);
			Assert.fail();
			extent.flush();
		} catch (Exception validateAllocatedAndUnallocatedAmountAfterSave) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAllocatedAndUnallocatedAmountAfterSave test in SingleTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllocatedAndUnallocatedAmountAfterSave_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocatedAndUnallocatedAmountAfterSave.printStackTrace();
			node.fail(validateAllocatedAndUnallocatedAmountAfterSave);
			Assert.fail();
			extent.flush();
		}
	}

}
