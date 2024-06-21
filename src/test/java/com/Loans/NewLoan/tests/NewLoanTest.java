package com.Loans.NewLoan.tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.locators.allPages.LoansDatabasePO;
import com.locators.allPages.LoansNewLoanPO;
import com.locators.allPages.SideMenuPO;
import com.locators.allPages.UtilsPO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.url.AllPagesUrl;
import com.qa.utils.LoansPage;
import com.qa.utils.LoginPage;
import com.qa.utils.Utils;

public class NewLoanTest extends Baseclass {

	// TC_Loans_NewLoan_001
	@Test(priority = 1)
	public void validateBorrowerPageVisibility() throws IOException {

		try {
			extenttest = extent.createTest("Verify that the user can access the 'Borrower' Page")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadLoginPage function from the login
			LoginPage.loadLoginPage();

			// Calling the userLoginProcess function from the LoginPage
			LoginPage.userLoginProcess(node, driver, getDataFromExcel(1), getDataFromExcel(2));

			// Click on the Loans Menu
			Utils.clickOnMenu(node, driver, SideMenuPO.loans);

			// Click on the New Loan Sub Menu
			Utils.clickOnMenu(node, driver, SideMenuPO.newLoan);

			// Wait for the visibility of the New Bridge Loan Header Text
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the page");
			System.out.println("STEP1 : Waiting for the visibility of the page");
			IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.newBridgeLoanHeaderText);
			node.log(Status.INFO, "STEP2 : Page is visible");
			System.out.println("STEP2 : Page is visible");

			Thread.sleep(2000);
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			// Assert that Borrower page is visible
			System.out.println("STEP3 : Asserting that Borrower page is visible");
			node.log(Status.INFO, "STEP3 : Asserting that Borrower page is visible");

			// Calling the validateUrl from Utils
			Utils.validateUrl(node, driver, currentUrl, AllPagesUrl.newLoanPage, "validateBorrowerPageVisibility");

		} catch (AssertionError validateBorrowerPageVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateBorrowerPageVisibility test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBorrowerPageVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBorrowerPageVisibility.printStackTrace();
			node.fail(validateBorrowerPageVisibility);
			Assert.fail();
			extent.flush();
		} catch (Exception validateBorrowerPageVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateBorrowerPageVisibility test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBorrowerPageVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBorrowerPageVisibility.printStackTrace();
			node.fail(validateBorrowerPageVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Loans_NewLoan_002
	@Test(priority = 2)
	public void validateNewBridgeLoanPage() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify if the user is able to view the initial state of the New Bridge Loan page")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadNewLoanPage from LoansPage
			LoansPage.loadNewLoanPage();

			// Check the visibility of Bridge Loan Internal Reference Field
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.bridgeLoanInternalReferenceField,
					"STEP1 : BUG : Bridge Loan Internal Reference Field is not coming under Borrower Tab on New Bridge Loan page",
					"STEP1 : EXPECTED : Bridge Loan Internal Reference Field is coming under Borrower Tab on New Bridge Loan page");

			// Check the visibility of Borrower Type
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.borrowerType,
					"STEP2 : BUG : Borrower Type is not coming under Borrower Tab on New Bridge Loan page",
					"STEP2 : EXPECTED : Borrower Type is coming under Borrower Tab on New Bridge Loan page");

			// Check the visibility of Loan Status
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.loanStatus,
					"STEP3 : BUG : Loan Status is not coming under Borrower Tab on New Bridge Loan page",
					"STEP3 : EXPECTED : Loan Status is coming under Borrower Tab on New Bridge Loan page");

			// Check the visibility of Approval Status Label
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.ApprovalStatusLabel,
					"STEP4 : BUG : Approval Status Label is not coming under Borrower Tab on New Bridge Loan page",
					"STEP4 : EXPECTED : Approval Status Label is coming under Borrower Tab on New Bridge Loan page");

			// Check the visibility of Approval Status
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.ApprovalStatus,
					"STEP5 : BUG : Approval Status is not coming under Borrower Tab on New Bridge Loan page",
					"STEP5 : EXPECTED : Approval Status is coming under Borrower Tab on New Bridge Loan page");

			// Check the visibility of Loan Status Label
			String status = IElementActions.getElementText_usingXpath(node, driver, LoansNewLoanPO.loanStatusLabel);

			// Split the string by the pipe character (|)
			String[] parts = status.split("\\|");

			// Iterate through the parts to find the one containing "Review"
			String loanStatus = parts[0].trim();

			// Output the review status
			if (loanStatus.contains("Review")) {
				Assert.assertTrue(true, loanStatus + " is displayed under Borrower Tab on New Bridge Loan page.");
				System.out.println(loanStatus + " is displayed under Borrower Tab on New Bridge Loan page.");
				node.log(Status.PASS, loanStatus + " is displayed under Borrower Tab on New Bridge Loan page.");
			} else {
				Assert.assertTrue(false,
						"Loan Status Review is not displayed under Borrower Tab on New Bridge Loan page.");
				System.out.println("Loan Status Review is not displayed under Borrower Tab on New Bridge Loan page.");
				node.log(Status.FAIL,
						"Loan Status Review is not displayed under Borrower Tab on New Bridge Loan page.");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateNewBridgeLoanPage", "Pass", driver);

		} catch (AssertionError validateNewBridgeLoanPage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNewBridgeLoanPage test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateNewBridgeLoanPage_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNewBridgeLoanPage.printStackTrace();
			node.fail(validateNewBridgeLoanPage);
			Assert.fail();
			extent.flush();
		} catch (Exception validateNewBridgeLoanPage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNewBridgeLoanPage test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateNewBridgeLoanPage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNewBridgeLoanPage.printStackTrace();
			node.fail(validateNewBridgeLoanPage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Loans_NewLoan_003
	@Test(priority = 3)
	public void validateBridgeLoanInternalReferenceField() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that user is able to enter Bridge Loan Internal Reference in the field")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Get bridge loan internal reference
			String bridgeLoanInternalReference = getDataFromExcel(17);

			// Enter the Value in Bridge Loan Internal Reference Field
			IElementActions.sendKeys_usingXpath(node, driver, LoansNewLoanPO.bridgeLoanInternalReferenceField,
					bridgeLoanInternalReference);
			node.log(Status.INFO, "STEP1 : Entered the Value in Bridge Loan Internal Reference Field");
			System.out.println("STEP1 : Entered the Value in Bridge Loan Internal Reference Field");

			// Get Internal Reference
			String internalReference = IElementActions
					.getElementText_usingXpath(node, driver, LoansNewLoanPO.internalReference).substring(21);
			node.log(Status.INFO, "STEP2 : Updated Internal Reference is : " + internalReference);
			System.out.println("STEP2 : Updated Internal Reference is : " + internalReference);

			// Assert that Bridge Loan Internal Reference is updated correctly
			IElementActions.assertEquals_usingString(node, driver, bridgeLoanInternalReference, internalReference,
					"STEP3 : BUG : The Bridge Loan Internal Reference is not updated correctly",
					"STEP3 : PASS : The Bridge Loan Internal Reference is updated correctly");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateBridgeLoanInternalReferenceField", "Pass", driver);

		} catch (AssertionError validateBridgeLoanInternalReferenceField) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateBridgeLoanInternalReferenceField test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBridgeLoanInternalReferenceField_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBridgeLoanInternalReferenceField.printStackTrace();
			node.fail(validateBridgeLoanInternalReferenceField);
			Assert.fail();
			extent.flush();
		} catch (Exception validateBridgeLoanInternalReferenceField) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateBridgeLoanInternalReferenceField test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBridgeLoanInternalReferenceField_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBridgeLoanInternalReferenceField.printStackTrace();
			node.fail(validateBridgeLoanInternalReferenceField);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Loans_NewLoan_023
	@Test(priority = 4)
	public void validateLoanTabDetails() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify the user is able to view the initial state of the Loan tab and following fields and sections get displayed i.e."
							+ "-Loan Disbursement" + "-Repayment" + "-Fees" + "-Interest Rates"
							+ "-Interest Payment Dates" + "-Broker" + "-Contractual Details" + "-Redemption Request"
							+ "-Loan Status" + "-Approval Status" + "-Internal Reference" + "-Previouse button"
							+ "-Next button" + "-Facility Disbursement" + "-Bullet Upsize" + "-Extension" + "-Repayment"
							+ "")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Calling the clickOnTab from Utils
			Utils.clickOnTab(LoansNewLoanPO.loanTab, LoansNewLoanPO.loanDisbursementHeader, "Loan");

			// Check the visibility of Loan Disbursement Section
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.loanDisbursementSection,
					"STEP1 : BUG : Loan Disbursement Section is not coming under Loan Tab on New Bridge Loan page",
					"STEP1 : EXPECTED : Loan Disbursement Section is coming under Loan Tab on New Bridge Loan page");

			// Check the visibility of Repayment Section
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.repaymentSection,
					"STEP2 : BUG : Repayment Section is not coming under Loan Tab on New Bridge Loan page",
					"STEP2 : EXPECTED : Repayment Section is coming under Loan Tab on New Bridge Loan page");

			// Check the visibility of Fees Section
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.feesSection,
					"STEP3 : BUG : Fees Section is not coming under Loan Tab on New Bridge Loan page",
					"STEP3 : EXPECTED : Fees Section is coming under Loan Tab on New Bridge Loan page");

			// Check the visibility of Interest Rates Section
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.interestRatesSection,
					"STEP4 : BUG : Interest Rates Section is not coming under Loan Tab on New Bridge Loan page",
					"STEP4 : EXPECTED : Interest Rates Section is coming under Loan Tab on New Bridge Loan page");

			// Check the visibility of Interest Payment Dates Section
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.interestPaymentDateSection,
					"STEP5 : BUG : Interest Payment Dates Section is not coming under Loan Tab on New Bridge Loan page",
					"STEP5 : EXPECTED : Interest Payment Dates Section is coming under Loan Tab on New Bridge Loan page");

			// Check the visibility of Broker Section
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.brokerSection,
					"STEP6 : BUG : Broker Section is not coming under Loan Tab on New Bridge Loan page",
					"STEP6 : EXPECTED : Broker Section is coming under Loan Tab on New Bridge Loan page");

			// Check the visibility of Contractual Details Section
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.contractualDetailsSection,
					"STEP7 : BUG : Contractual Details Section is not coming under Loan Tab on New Bridge Loan page",
					"STEP7 : EXPECTED : Contractual Details Section is coming under Loan Tab on New Bridge Loan page");

			// Check the visibility of Redemption Request Section
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.redemptionRequestSection,
					"STEP8 : BUG : Redemption Request Section is not coming under Loan Tab on New Bridge Loan page",
					"STEP8 : EXPECTED : Redemption Request Section is coming under Loan Tab on New Bridge Loan page");

			// Check the Visibility of Loan Status
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.loanStatusLabel,
					"STEP9 : BUG : Loan Status is not coming under Loan Tab on New Bridge Loan page",
					"STEP9 : EXPECTED : Loan Status is coming under Loan Tab on New Bridge Loan page");

			// Check the visibility of Approval Status
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.ApprovalStatusLabel,
					"STEP10 : BUG : Approval Status is not coming under Loan Tab on New Bridge Loan page",
					"STEP10 : EXPECTED : Approval Status is coming under Loan Tab on New Bridge Loan page");

			// Check the Visibility of Internal Reference
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.internalReference,
					"STEP11 : BUG : Internal Reference is not coming under Loan Tab on New Bridge Loan page",
					"STEP11 : EXPECTED : Internal Reference is coming under Loan Tab on New Bridge Loan page");

			// Check the visibility of Previouse Button
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.previousButton,
					"STEP12 : BUG : Previouse Button is not coming under Loan Tab on New Bridge Loan page",
					"STEP12 : EXPECTED : Previouse Button is coming under Loan Tab on New Bridge Loan page");

			// Check the visibility of Next Button
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.nextButton,
					"STEP13 : BUG : Next Button is not coming under Loan Tab on New Bridge Loan page",
					"STEP13 : EXPECTED : Next Button is coming under Loan Tab on New Bridge Loan page");

			// Check the visibility of Facility Disbursement
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.facilityDisbursement,
					"STEP14 : BUG : Facility Disbursement is not coming under Loan Tab on New Bridge Loan page",
					"STEP14 : EXPECTED : Facility Disbursement is coming under Loan Tab on New Bridge Loan page");

			// Check the visibility of Bullet Upsize
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.bulletUpsize,
					"STEP15 : BUG : Bullet Upsize is not coming under Loan Tab on New Bridge Loan page",
					"STEP15 : EXPECTED : Bullet Upsize is coming under Loan Tab on New Bridge Loan page");

			// Check the visibility of Extension
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.extension,
					"STEP16 : BUG : Extension is not coming under Loan Tab on New Bridge Loan page",
					"STEP16 : EXPECTED : Extension is coming under Loan Tab on New Bridge Loan page");

			// Check the visibility of Repayment
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.repayment,
					"STEP17 : BUG : Repayment is not coming under Loan Tab on New Bridge Loan page",
					"STEP17 : EXPECTED : Repayment is coming under Loan Tab on New Bridge Loan page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanTabDetails", "Pass", driver);

		} catch (AssertionError validateLoanTabDetails) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanTabDetails test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanTabDetails_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanTabDetails.printStackTrace();
			node.fail(validateLoanTabDetails);
			Assert.fail();
			extent.flush();
		} catch (Exception validateLoanTabDetails) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanTabDetails test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanTabDetails_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanTabDetails.printStackTrace();
			node.fail(validateLoanTabDetails);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Loans_NewLoan_125
	// TC_Loans_NewLoan_469
	@Test(priority = 5)
	public void validateLoanStatusLive() throws IOException {

		try {
			extenttest = extent.createTest("Verify that if current date < Payment Date, loan has status Live"
					+ "ValidateSave - Verify that the user is able to successfully save all entered information")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Load new loan
			LoansPage.loadNewLoanPage();

			// Create loan
			LoansPage.createLoan("tomorrow");

			// Update status
			LoansPage.updateStatus("Overdue");

			// Check the visibility of Loan Status Label
			String status = IElementActions.getElementText_usingXpath(node, driver, LoansNewLoanPO.loanStatusLabel);

			// Split the string by the pipe character (|)
			String[] parts = status.split("\\|");

			// Iterate through the parts to find the one containing "Review"
			String loanStatus = parts[0].trim();

			// Output the review status
			if (loanStatus.contains("Live")) {
				Assert.assertTrue(true, loanStatus + " is displayed under Borrower Tab on New Bridge Loan page.");
				System.out.println(loanStatus + " is displayed under Borrower Tab on New Bridge Loan page.");
				node.log(Status.PASS, loanStatus + " is displayed under Borrower Tab on New Bridge Loan page.");
			} else {
				Assert.assertTrue(false,
						"Loan Status Live is not displayed under Borrower Tab on New Bridge Loan page.");
				System.out.println("Loan Status Live is not displayed under Borrower Tab on New Bridge Loan page.");
				node.log(Status.FAIL, "Loan Status Live is not displayed under Borrower Tab on New Bridge Loan page.");
			}
			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanStatusLive", "Pass", driver);

		} catch (AssertionError validateLoanStatusLive) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanStatusLive test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanStatusLive_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanStatusLive.printStackTrace();
			node.fail(validateLoanStatusLive);
			Assert.fail();
			extent.flush();
		} catch (Exception validateLoanStatusLive) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanStatusLive test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanStatusLive_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanStatusLive.printStackTrace();
			node.fail(validateLoanStatusLive);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Loans_NewLoan_126
	@Test(priority = 6)
	public void validateLoanStatusOverdue() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that if current date >= Payment Date, loan has status Overdue (system should automatically change loan status to overdue once current date >= Payment Date ")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Load new loan
			LoansPage.loadNewLoanPage();

			// Create loan
			LoansPage.createLoan("today");

			// Update status
			LoansPage.updateStatus("Live");

			// Check the visibility of Loan Status Label
			String status = IElementActions.getElementText_usingXpath(node, driver, LoansNewLoanPO.loanStatusLabel);

			// Split the string by the pipe character (|)
			String[] parts = status.split("\\|");

			// Iterate through the parts to find the one containing "Review"
			String loanStatus = parts[0].trim();

			// Output the review status
			if (loanStatus.contains("Overdue")) {
				Assert.assertTrue(true, loanStatus + " is displayed under Borrower Tab on New Bridge Loan page.");
				System.out.println(loanStatus + " is displayed under Borrower Tab on New Bridge Loan page.");
				node.log(Status.PASS, loanStatus + " is displayed under Borrower Tab on New Bridge Loan page.");
			} else {
				Assert.assertTrue(false,
						"Loan Status Overdue is not displayed under Borrower Tab on New Bridge Loan page.");
				System.out.println("Loan Status Overdue is not displayed under Borrower Tab on New Bridge Loan page.");
				node.log(Status.FAIL,
						"Loan Status Overdue is not displayed under Borrower Tab on New Bridge Loan page.");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanStatusOverdue", "Pass", driver);

		} catch (AssertionError validateLoanStatusOverdue) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanStatusOverdue test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanStatusOverdue_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanStatusOverdue.printStackTrace();
			node.fail(validateLoanStatusOverdue);
			Assert.fail();
			extent.flush();
		} catch (Exception validateLoanStatusOverdue) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanStatusOverdue test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanStatusOverdue_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanStatusOverdue.printStackTrace();
			node.fail(validateLoanStatusOverdue);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Loans_NewLoan_127
	@Test(priority = 7)
	public void validatePaymentDateInLoanHistory() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that once user has selected date from the calendar, when they press Save at the bottom of the screen, the new date is saved and appears as a change to the Payment Date in the Loan History tab with the correct Old Value, New Value and Created Date")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadDatabasePage from LoansPage
			LoansPage.loadDatabasePage();

			// Get loan reference
			String loanReferenceNumber = getDataFromExcel(25);

			// Search record based on the provide loan reference and open it
			Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, LoansDatabasePO.loanRefSearchField,
					loanReferenceNumber, UtilsPO.editIcon, LoansNewLoanPO.editBridgeLoanHeaderText);

			// Click on loan history tab
			Utils.clickOnTab(LoansNewLoanPO.loanHistoryTab, LoansNewLoanPO.editAmendsHeader, "Loan History");

			// Get today's date
			String todayDate = Utils.getTodayDateFormatted();

			// Get first row old value
			String oldValue = IElementActions.getElementText_usingXpath(node, driver, LoansNewLoanPO.firstRowOldValue);

			// Get first row new value
			String newValue = IElementActions.getElementText_usingXpath(node, driver, LoansNewLoanPO.firstRowNewValue);

			// Get first row created date value
			String createdDate = IElementActions.getElementText_usingXpath(node, driver,
					LoansNewLoanPO.firstRowCreatedDateValue);

			// Check old and new value
			if (!oldValue.equals(newValue)) {
				Assert.assertTrue(true, "The status is changed");
				System.out.println("The status is changed");
				node.log(Status.PASS, "The status is changed");
			} else {
				Assert.assertTrue(false, oldValue + " is equal to " + newValue);
				System.out.println(oldValue + " is equal to " + newValue);
				node.log(Status.FAIL, oldValue + " is equal to " + newValue);
			}

			// Check created date and today's date
			if (createdDate.contains(todayDate)) {
				Assert.assertTrue(true, "The created date " + createdDate + " and today's date are same");
				System.out.println("The created date " + createdDate + " and today's date are same");
				node.log(Status.PASS, "The created date " + createdDate + " and today's date are same");
			} else {
				Assert.assertTrue(false, "The created date " + createdDate + " and today's date are not same");
				System.out.println("The created date " + createdDate + " and today's date are not same");
				node.log(Status.FAIL, "The created date " + createdDate + " and today's date are not same");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validatePaymentDateInLoanHistory", "Pass", driver);

		} catch (AssertionError validatePaymentDateInLoanHistory) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePaymentDateInLoanHistory test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePaymentDateInLoanHistory_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePaymentDateInLoanHistory.printStackTrace();
			node.fail(validatePaymentDateInLoanHistory);
			Assert.fail();
			extent.flush();
		} catch (Exception validatePaymentDateInLoanHistory) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePaymentDateInLoanHistory test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePaymentDateInLoanHistory_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePaymentDateInLoanHistory.printStackTrace();
			node.fail(validatePaymentDateInLoanHistory);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Loans_NewLoan_482
	@Test(priority = 8)
	public void validateCashflowTab() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user is able to access and view the Cashflow tab i.e. Action, Confirmed, Scheduled date, Effective date, Payment/Receipt, Payment Type, Expected Cashflow Amount, Adjustable Amount, Actual Cashflow Amount, Outstanding Amount")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadDatabasePage from LoansPage
			LoansPage.loadDatabasePage();

			// Get loan reference
			String loanReferenceNumber = getDataFromExcel(25);

			// Search record based on the provide loan reference and open it
			Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, LoansDatabasePO.loanRefSearchField,
					loanReferenceNumber, UtilsPO.editIcon, LoansNewLoanPO.editBridgeLoanHeaderText);

			// Click on cashflows tab
			Utils.clickOnTab(LoansNewLoanPO.cashflowsTab, LoansNewLoanPO.cashflowsHeader, "Cashflows");

			// Check the visibility of action
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.action,
					"STEP1 : BUG: Action is not coming on cashflows tab",
					"STEP1 : EXPECTED: Action is coming on cashflows tab");

			// Check the visibility of confirmed
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.confirmed,
					"STEP2 : BUG: Confirmed is not coming on cashflows tab",
					"STEP2 : EXPECTED: Confirmed is coming on cashflows tab");

			// Check the visibility of schedule date
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.scheduleDate,
					"STEP3 : BUG: Schedule date is not coming on cashflows tab",
					"STEP3 : EXPECTED: Schedule date is coming on cashflows tab");

			// Check the visibility of effective date cashflow
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.effectiveDateCashflow,
					"STEP4 : BUG: Effective date cashflow is not coming on cashflows tab",
					"STEP4 : EXPECTED: Effective date cashflow is coming on cashflows tab");

			// Check the visibility of payment receipt
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.PaymentReceipt,
					"STEP5 : BUG: Payment Receipt is not coming on cashflows tab",
					"STEP5 : EXPECTED: Payment Receipt is coming on cashflows tab");

			// Check the visibility of payment type
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.paymentType,
					"STEP6 : BUG: Payment type is not coming on cashflows tab",
					"STEP6 : EXPECTED: Payment type is coming on cashflows tab");

			// Check the visibility of expected cashflow amount
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.expectedCashflowAmount,
					"STEP7 : BUG: Expected cashflow amount is not coming on cashflows tab",
					"STEP7 : EXPECTED: Expected cashflow amount is coming on cashflows tab");

			// Check the visibility of adjustment amount
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.adjustmentAmount,
					"STEP8 : BUG: Adjustment amount is not coming on cashflows tab",
					"STEP8 : EXPECTED: Adjustment amount is coming on cashflows tab");

			// Check the visibility of actual cashflow amount
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.actualCashflowAmount,
					"STEP9 : BUG: Actual cashflow amount is not coming on cashflows tab",
					"STEP9 : EXPECTED: Actual cashflow amount is coming on cashflows tab");

			// Check the visibility of outstanding amount
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.outstandingAmount,
					"STEP10 : BUG: Outstanding amount is not coming on cashflows tab",
					"STEP10 : EXPECTED: Outstanding amount is coming on cashflows tab");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashflowTab", "Pass", driver);

		} catch (AssertionError validateCashflowTab) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashflowTab test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanTabDetails_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashflowTab.printStackTrace();
			node.fail(validateCashflowTab);
			Assert.fail();
			extent.flush();
		} catch (Exception validateCashflowTab) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashflowTab test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCashflowTab_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashflowTab.printStackTrace();
			node.fail(validateCashflowTab);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Loans_NewLoan_586
	@Test(priority = 9)
	public void validateCurrentAmountAfterDisbursement() throws IOException {

		try {
			extenttest = extent.createTest(
					"When confirming a Loan Disbursement cashflow of value £x, the Current Amount in the Summary tab should increase by £x")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Load new loan
			LoansPage.loadNewLoanPage();

			// Create loan
			LoansPage.createLoan("tomorrow");

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

			// Click on summary tab
			Utils.clickOnTab(LoansNewLoanPO.summaryTab, LoansNewLoanPO.loanDetailsHeader, "Summary");

			// Get current amount value
			int currentAmountAfterDisbursement = Utils.getTextAndParseToInt(LoansNewLoanPO.currentAmountSummary);

			// Calculate the expected current amount
			int expectedCurrentAmount = Utils.calculateAddition(currentAmountBeforeDisbursement,
					loanDisbursementAmount);

			// Assert the current amount value
			IElementActions.assertEquals_usingInteger(node, driver, currentAmountAfterDisbursement,
					expectedCurrentAmount,
					"BUG : The current amount before disbursement is " + currentAmountBeforeDisbursement
							+ " and is not increase by " + loanDisbursementAmount
							+ " i.e current amount after disbursement is " + currentAmountAfterDisbursement,
					"PASS : The current amount before disbursement is " + currentAmountBeforeDisbursement
							+ " and is increase by " + loanDisbursementAmount
							+ " i.e current amount after disbursement is " + currentAmountAfterDisbursement);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCurrentAmountAfterDisbursement", "Pass", driver);

		} catch (AssertionError validateCurrentAmountAfterDisbursement) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCurrentAmountAfterDisbursement test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCurrentAmountAfterDisbursement_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCurrentAmountAfterDisbursement.printStackTrace();
			node.fail(validateCurrentAmountAfterDisbursement);
			Assert.fail();
			extent.flush();
		} catch (Exception validateCurrentAmountAfterDisbursement) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCurrentAmountAfterDisbursement test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCurrentAmountAfterDisbursement_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCurrentAmountAfterDisbursement.printStackTrace();
			node.fail(validateCurrentAmountAfterDisbursement);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Loans_NewLoan_587
	@Test(priority = 10)
	public void validateCurrentAmountAfterRepayment() throws IOException {

		try {
			extenttest = extent.createTest(
					"When confirming a Loan Repayment cashflow of value £y, the Current Amount in the Summary tab should decrease by £y")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get loan repayment
			int loanRepayment = Integer.parseInt(getDataFromExcel(29));
			loanRepayment = loanRepayment - 1;

			// Calling the loadDatabasePage from LoansPage
			LoansPage.loadDatabasePage();

			// Get loan reference
			String loanReferenceNumber = getDataFromExcel(25);

			// Search record based on the provide loan reference and open it
			Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, LoansDatabasePO.loanRefSearchField,
					loanReferenceNumber, UtilsPO.editIcon, LoansNewLoanPO.editBridgeLoanHeaderText);

			// Click on summary tab
			Utils.clickOnTab(LoansNewLoanPO.summaryTab, LoansNewLoanPO.loanDetailsHeader, "Summary");

			// Get current amount value
			int currentAmountBeforeRepayment = Utils.getTextAndParseToInt(LoansNewLoanPO.currentAmountSummary);

			// Add a loan repayment cash flow
			LoansPage.addCashflow(LoansNewLoanPO.receiptAddNewCashflow, LoansNewLoanPO.loanRepayment,
					String.valueOf(loanRepayment));

			// Click on dropdown and select option
			LoansPage.clickDropdownAndItsOption(LoansNewLoanPO.paymentReceiptDropdown,
					LoansNewLoanPO.receiptDropdownoption);

			// Wait for the visibility of first row cashflow amount
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of first row cashflow amount");
			System.out.println("STEP1 : Waiting for the visibility of first row cashflow amount");
			IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.firstRowCashflowAmount);
			node.log(Status.INFO, "STEP2 : The first row cashflow amount is visible");
			System.out.println("STEP2 : The first row cashflow amount is visible");

			// Get loan Repayment amount
			int loanRepaymentAmount = Utils.getTextAndParseToInt(LoansNewLoanPO.firstRowCashflowAmount);

			LoansPage.approveCashflow(LoansNewLoanPO.firstRowCashflowAmount);

			// Click on summary tab
			Utils.clickOnTab(LoansNewLoanPO.summaryTab, LoansNewLoanPO.loanDetailsHeader, "Summary");

			// Get current amount value
			int currentAmountAfterRepayment = Utils.getTextAndParseToInt(LoansNewLoanPO.currentAmountSummary);

			// Calculate the expected current amount
			int expectedCurrentAmount = Utils.calculateDifference(currentAmountBeforeRepayment, loanRepaymentAmount);

			// Assert the current amount value
			IElementActions.assertEquals_usingInteger(node, driver, currentAmountAfterRepayment, expectedCurrentAmount,
					"BUG : The current amount before repayment is " + currentAmountBeforeRepayment
							+ " and is not decrease by " + loanRepaymentAmount
							+ " i.e current amount after repayment is " + currentAmountAfterRepayment,
					"PASS : The current amount before disbursement is " + currentAmountBeforeRepayment
							+ " and is decrease by " + loanRepaymentAmount + " i.e current amount after repayment is "
							+ currentAmountAfterRepayment);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCurrentAmountAfterRepayment", "Pass", driver);

		} catch (AssertionError validateCurrentAmountAfterRepayment) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCurrentAmountAfterRepayment test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCurrentAmountAfterRepayment_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCurrentAmountAfterRepayment.printStackTrace();
			node.fail(validateCurrentAmountAfterRepayment);
			Assert.fail();
			extent.flush();
		} catch (Exception validateCurrentAmountAfterRepayment) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCurrentAmountAfterRepayment test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCurrentAmountAfterRepayment_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCurrentAmountAfterRepayment.printStackTrace();
			node.fail(validateCurrentAmountAfterRepayment);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Loans_NewLoan_588
	@Test(priority = 11)
	public void validateNotRepaidLoans() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that for loans which are not repaid (i.e. loans which have status Live, Overdue or Enforced) then the scheduled Repayment Cashflow with schedule date equal to Payment Date (found in the Loans tab) should have Expected Cashflow Amount = Actual Cashflow Amount = Current Amount (Current Amount found in the Loan Details tile of Summary tab)")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Load new loan
			LoansPage.loadNewLoanPage();

			// Create loan
			LoansPage.createLoan("tomorrow");

			// Click on loan tab
			Utils.clickOnTab(LoansNewLoanPO.loanTab, LoansNewLoanPO.loanDisbursementHeader, "Loan");

			// Get payement date
			WebElement payementDate = IElementActions.returnElement(node, driver, LoansNewLoanPO.payementDateValue);
			String payementDateValue = payementDate.getAttribute("value");
			node.log(Status.INFO, "STEP2 : Payement date  is " + payementDateValue);
			System.out.println("STEP2 :  Payement date is " + payementDateValue);

			// Click on summary tab
			Utils.clickOnTab(LoansNewLoanPO.summaryTab, LoansNewLoanPO.loanDetailsHeader, "Summary");

			// Get amount value
			int amount = Utils.getTextAndParseToInt(LoansNewLoanPO.amountSummary);

			// Click on cashflows tab
			Utils.clickOnTab(LoansNewLoanPO.cashflowsTab, LoansNewLoanPO.cashflowsHeader, "Cashflows");

			// Get schedule date
			String scheduleDate = IElementActions.getElementText_usingXpath(node, driver,
					LoansNewLoanPO.firstRowScheduleDate);

			// Get expected cashflow amount
			int expectedCashflowAmount = Utils.getTextAndParseToInt(LoansNewLoanPO.firstRowCashflowAmount);

			// Get actual cashflow amount
			int actualCashflowAmount = Utils.getTextAndParseToInt(LoansNewLoanPO.firstRowActualCashflowAmount);

			// Check created date and today's date
			if (payementDateValue.equals(scheduleDate)
					&& (expectedCashflowAmount == actualCashflowAmount && expectedCashflowAmount == amount)) {
				Assert.assertTrue(true,
						"Schedule date " + scheduleDate + "equal to Payment Date " + payementDateValue
								+ " and Expected Cashflow Amount " + expectedCashflowAmount
								+ " is equal to Actual Cashflow Amount " + actualCashflowAmount
								+ " and is equal to summary tab amount " + amount);
				System.out.println("Schedule date " + scheduleDate + "equal to Payment Date " + payementDateValue
						+ " and Expected Cashflow Amount " + expectedCashflowAmount
						+ " is equal to Actual Cashflow Amount " + actualCashflowAmount
						+ " and is equal to summary tab amount " + amount);
				node.log(Status.PASS,
						"Schedule date " + scheduleDate + "equal to Payment Date " + payementDateValue
								+ " and Expected Cashflow Amount " + expectedCashflowAmount
								+ " is equal to Actual Cashflow Amount " + actualCashflowAmount
								+ " and is equal to summary tab amount " + amount);
			} else {
				Assert.assertTrue(false, "Schedule date " + scheduleDate + " and Payment Date " + payementDateValue
						+ " and Expected Cashflow Amount " + expectedCashflowAmount + " , Actual Cashflow Amount "
						+ actualCashflowAmount + " and summary tab amount " + amount + " are not equal");
				System.out.println("Schedule date " + scheduleDate + " and Payment Date " + payementDateValue
						+ " and Expected Cashflow Amount " + expectedCashflowAmount + " , Actual Cashflow Amount "
						+ actualCashflowAmount + " and summary tab amount " + amount + " are not equal");
				node.log(Status.FAIL, "Schedule date " + scheduleDate + " and Payment Date " + payementDateValue
						+ " and Expected Cashflow Amount " + expectedCashflowAmount + " , Actual Cashflow Amount "
						+ actualCashflowAmount + " and summary tab amount " + amount + " are not equal");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateNotRepaidLoans", "Pass", driver);

		} catch (AssertionError validateNotRepaidLoans) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNotRepaidLoans test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateNotRepaidLoans_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNotRepaidLoans.printStackTrace();
			node.fail(validateNotRepaidLoans);
			Assert.fail();
			extent.flush();
		} catch (Exception validateNotRepaidLoans) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNotRepaidLoans test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateNotRepaidLoans_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNotRepaidLoans.printStackTrace();
			node.fail(validateNotRepaidLoans);
			Assert.fail();
			extent.flush();
		}
	}

}
