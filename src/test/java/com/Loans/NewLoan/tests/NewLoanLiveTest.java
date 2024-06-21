package com.Loans.NewLoan.tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.locators.allPages.LoansDatabasePO;
import com.locators.allPages.LoansNewLoanPO;
import com.locators.allPages.UtilsPO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.utils.LoansPage;
import com.qa.utils.LoginPage;
import com.qa.utils.Utils;

public class NewLoanLiveTest extends Baseclass {

	// TC_Loans_NewLoan_048
	@Test(priority = 1)
	public void validateRepaymentPopup() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that when the user selects 'Repayment' section, a pop-up appears as intended")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			// Calling the userLoginProcess function from the LoginPage
			LoginPage.userLoginProcess(node, driver, getDataFromExcel(1), getDataFromExcel(2));

			// Create loan and update status to live
			LoansPage.createLoanAndUpdateStatus("Live");

			// Calling the loadDatabasePage from LoansPage
			LoansPage.loadDatabasePage();

			// Get loan reference
			String loanReferenceNumber = getDataFromExcel(25);

			// Search record based on the provide loan reference and open it
			LoansPage.openRecordAndUpdateStatus(UtilsPO.headerSearchCrossIcon, LoansDatabasePO.loanRefSearchField,
					loanReferenceNumber, UtilsPO.editIcon, LoansNewLoanPO.editBridgeLoanHeaderText, "Live");

			// Click on loan tab
			Utils.clickOnTab(LoansNewLoanPO.loanTab, LoansNewLoanPO.loanDisbursementHeader, "Loan");

			// Click and wait
			Utils.clickAndWait(LoansNewLoanPO.repaymentButton, "Repayment", LoansNewLoanPO.repaymentPopup);

			// Check the visibility of repayment popup
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.repaymentPopup,
					"STEP1 : BUG: Repayment popup is not coming on clicking repayment button",
					"STEP1 : EXPECTED: Repayment popup is coming on clicking repayment button");

			// Check the visibility of repayment full option
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.repaymentTypeFull,
					"STEP2 : BUG: Full option is not coming on the repayment popup",
					"STEP2 : EXPECTED: Full option is coming on the repayment popup");

			// Check the visibility of repayment partial option
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.repaymentTypePartial,
					"STEP3 : BUG: Partial option is not coming on the repayment popup",
					"STEP3 : EXPECTED: Partial option is coming on the repayment popup");

			// Check the visibility of cancel option
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.cancelButton,
					"STEP4 : BUG: Cancel option is not coming on the repayment popup",
					"STEP4 : EXPECTED: Cancel option is coming on the repayment popup");

			// Check the visibility of next option
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.repaymentPopupNextButton,
					"STEP5 : BUG: Next option is not coming on the repayment popup",
					"STEP5 : EXPECTED: Next option is coming on the repayment popup");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateRepaymentPopup", "Pass", driver);

		} catch (AssertionError validateRepaymentPopup) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateRepaymentPopup test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateRepaymentPopup_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRepaymentPopup.printStackTrace();
			node.fail(validateRepaymentPopup);
			Assert.fail();
			extent.flush();
		} catch (Exception validateRepaymentPopup) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateRepaymentPopup test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateRepaymentPopup_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRepaymentPopup.printStackTrace();
			node.fail(validateRepaymentPopup);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Loans_NewLoan_049
	@Test(priority = 2)
	public void validateCancelInRepaymentPopup() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that when the user clicks 'Cancel' on Loan Repayment popup, popup is no longer displayed and loan is not repaid (no changes to loan status, cashflows or loan history)")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Click on loan tab
			Utils.clickOnTab(LoansNewLoanPO.loanTab, LoansNewLoanPO.loanDisbursementHeader, "Loan");

			// Get before status
			String beforeStatus = IElementActions.getElementText_usingXpath(node, driver,
					LoansNewLoanPO.loanStatusLabel);

			// Click and wait
			Utils.clickAndWait(LoansNewLoanPO.repaymentButton, "Repayment", LoansNewLoanPO.repaymentPopup);

			// Click on the cancel button
			IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.cancelButton);
			node.log(Status.INFO, "STEP1 : Clicked on the cancel button");
			System.out.println("STEP1 : Clicked on the cancel button");

			// Wait for the invisibility of repayment popup
			node.log(Status.INFO, "STEP2 : Waiting for the invisibility of the element");
			System.out.println("STEP2 : Waiting for the invisibility of the element");
			IWaitStrategy.waitForInVisiblity(node, driver, LoansNewLoanPO.repaymentPopup);
			node.log(Status.INFO, "STEP3 : The popup is not visible");
			System.out.println("STEP3 : The popup is not visible");

			// Assertion to verify that the popup is closed
			IElementActions.assertFalse_usingXpath(node, driver, LoansNewLoanPO.repaymentPopup,
					"STEP4 : Popup is still displayed after clicking close button",
					"STEP4 : Popup is not displayed after clicking close button");

			// Get after status
			String afterStatus = IElementActions.getElementText_usingXpath(node, driver,
					LoansNewLoanPO.loanStatusLabel);

			// Check before and after loan status
			if (beforeStatus.equals(afterStatus)) {
				Assert.assertTrue(true, " No changes to loan status");
				System.out.println("No changes to loan status.");
				node.log(Status.PASS, "No changes to loan status.");
			} else {
				Assert.assertTrue(false, beforeStatus + "is not same to " + afterStatus);
				System.out.println(beforeStatus + "is not same to " + afterStatus);
				node.log(Status.FAIL, beforeStatus + "is not same to " + afterStatus);
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCancelInRepaymentPopup", "Pass", driver);

		} catch (AssertionError validateCancelInRepaymentPopup) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCancelInRepaymentPopup test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCancelInRepaymentPopup_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCancelInRepaymentPopup.printStackTrace();
			node.fail(validateCancelInRepaymentPopup);
			Assert.fail();
			extent.flush();
		} catch (Exception validateCancelInRepaymentPopup) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCancelInRepaymentPopup test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCancelInRepaymentPopup_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCancelInRepaymentPopup.printStackTrace();
			node.fail(validateCancelInRepaymentPopup);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Loans_NewLoan_050
	@Test(priority = 3)
	public void validatePopupInFullRepayment() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that when the user selects 'Full' for 'Repayment Type,' and clicks next, a pop-up appears as intended")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Click on loan tab
			Utils.clickOnTab(LoansNewLoanPO.loanTab, LoansNewLoanPO.loanDisbursementHeader, "Loan");

			// Open repayment popup and go to effective date
			LoansPage.openRepaymentPopUpAndGoToEffectiveDate();

			// Check the visibility of repayment popup
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.repaymentPopup,
					"STEP1 : BUG: Repayment popup is not coming on clicking repayment button",
					"STEP1 : EXPECTED: Repayment popup is coming on clicking repayment button");

			// Check the visibility of effective date
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.effectiveDate,
					"STEP2 : BUG: Effective date is not coming on repayment popup",
					"STEP2 : EXPECTED: Effective date is coming on repayment popup");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validatePopupInFullRepayment", "Pass", driver);

		} catch (AssertionError validatePopupInFullRepayment) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePopupInFullRepayment test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatePopupInFullRepayment_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePopupInFullRepayment.printStackTrace();
			node.fail(validatePopupInFullRepayment);
			Assert.fail();
			extent.flush();
		} catch (Exception validatePopupInFullRepayment) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePopupInFullRepayment test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatePopupInFullRepayment_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePopupInFullRepayment.printStackTrace();
			node.fail(validatePopupInFullRepayment);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Loans_NewLoan_051
	@Test(priority = 4)
	public void validateCancelBeforeFullRepayment() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that when the user clicks 'Cancel' on the effective confirmation date popup, popup is no longer displayed and loan is not repaid (no changes to loan status, cashflows or loan history)")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Click on loan tab
			Utils.clickOnTab(LoansNewLoanPO.loanTab, LoansNewLoanPO.loanDisbursementHeader, "Loan");

			// Get before status
			String beforeStatus = IElementActions.getElementText_usingXpath(node, driver,
					LoansNewLoanPO.loanStatusLabel);

			// Open repayment popup and go to effective date
			LoansPage.openRepaymentPopUpAndGoToEffectiveDate();

			// Click on the cancel button
			IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.cancelButton);
			node.log(Status.INFO, "STEP1 : Clicked on the cancel button");
			System.out.println("STEP1 : Clicked on the cancel button");

			// Wait for the invisibility of repayment popup
			node.log(Status.INFO, "STEP2 : Waiting for the invisibility of the element");
			System.out.println("STEP2 : Waiting for the invisibility of the element");
			IWaitStrategy.waitForInVisiblity(node, driver, LoansNewLoanPO.repaymentPopup);
			node.log(Status.INFO, "STEP3 : The popup is not visible");
			System.out.println("STEP3 : The popup is not visible");

			// Assertion to verify that the popup is closed
			IElementActions.assertFalse_usingXpath(node, driver, LoansNewLoanPO.repaymentPopup,
					"STEP4 : Popup is still displayed after clicking close button",
					"STEP4 : Popup is not displayed after clicking close button");

			// Get after status
			String afterStatus = IElementActions.getElementText_usingXpath(node, driver,
					LoansNewLoanPO.loanStatusLabel);

			// Check before and after loan status
			if (beforeStatus.equals(afterStatus)) {
				Assert.assertTrue(true, " No changes to loan status");
				System.out.println("No changes to loan status.");
				node.log(Status.PASS, "No changes to loan status.");
			} else {
				Assert.assertTrue(false, beforeStatus + "is not same to " + afterStatus);
				System.out.println(beforeStatus + "is not same to " + afterStatus);
				node.log(Status.FAIL, beforeStatus + "is not same to " + afterStatus);
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCancelBeforeFullRepayment", "Pass", driver);

		} catch (AssertionError validateCancelBeforeFullRepayment) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCancelBeforeFullRepayment test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCancelBeforeFullRepayment_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCancelBeforeFullRepayment.printStackTrace();
			node.fail(validateCancelBeforeFullRepayment);
			Assert.fail();
			extent.flush();
		} catch (Exception validateCancelBeforeFullRepayment) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCancelBeforeFullRepayment test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCancelBeforeFullRepayment_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCancelBeforeFullRepayment.printStackTrace();
			node.fail(validateCancelBeforeFullRepayment);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Loans_NewLoan_052
	@Test(priority = 5)
	public void validateInterestRefundPopup() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that when the user has selected effective date, when they click 'Next' there is an interest refund popup displayed")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Click on loan tab
			Utils.clickOnTab(LoansNewLoanPO.loanTab, LoansNewLoanPO.loanDisbursementHeader, "Loan");

			// Open repayment popup and go to refund date
			LoansPage.openRepaymentPopUpAndGoToRefundDate();

			// Click on the refund date
			IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.refundDate);
			node.log(Status.INFO, "STEP1 : Clicked on the refund date");
			System.out.println("STEP1 : Clicked on the refund date");

			// Get tomorrow day
			String day = Utils.getTomorrowDayFormatted();

			// Select day in refund date calender
			Utils.enterDay(UtilsPO.calenderDay, day);

			// Get refund date
			WebElement refundDate = IElementActions.returnElement(node, driver, LoansNewLoanPO.refundDateInput);
			String refundDateAfter = refundDate.getAttribute("value");
			node.log(Status.INFO, "STEP2 : Refund date is " + refundDateAfter);
			System.out.println("STEP2 : Refund date is " + refundDateAfter);

			// Check the visibility of interest refund
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.interestRefund,
					"STEP3 : BUG: Interest refund is not coming on repayment",
					"STEP3 : EXPECTED: Interest refund is coming on repayment");

			// Check day before and after selection
			if (refundDateAfter.contains(day)) {
				Assert.assertTrue(true, " Updated interest refund day " + refundDateAfter);
				System.out.println("STEP4 : Changed interest refund day " + refundDateAfter);
				node.log(Status.PASS, "STEP4 : Changed interest refund day " + refundDateAfter);
			} else {
				Assert.assertTrue(false, "Interest refund day " + day + " is not updated " + refundDateAfter);
				System.out.println("STEP4 : Interest refund day " + day + " is not updated " + refundDateAfter);
				node.log(Status.FAIL, "STEP4 : Interest refund day " + day + " is not updated " + refundDateAfter);
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateInterestRefundPopup", "Pass", driver);

		} catch (AssertionError validateInterestRefundPopup) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInterestRefundPopup test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateInterestRefundPopup_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestRefundPopup.printStackTrace();
			node.fail(validateInterestRefundPopup);
			Assert.fail();
			extent.flush();
		} catch (Exception validateInterestRefundPopup) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInterestRefundPopup test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateInterestRefundPopup_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestRefundPopup.printStackTrace();
			node.fail(validateInterestRefundPopup);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Loans_NewLoan_053
	@Test(priority = 6)
	public void validateCancelInterestRefundPopup() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that when the user clicks 'Cancel' on the interest refund popup, popup is no longer displayed and loan is not repaid (no changes to the loan status, cashflows or loan history)")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Click on loan tab
			Utils.clickOnTab(LoansNewLoanPO.loanTab, LoansNewLoanPO.loanDisbursementHeader, "Loan");

			// Get before status
			String beforeStatus = IElementActions.getElementText_usingXpath(node, driver,
					LoansNewLoanPO.loanStatusLabel);

			// Open repayment popup and go to refund date
			LoansPage.openRepaymentPopUpAndGoToRefundDate();

			// Click on the cancel button
			IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.cancelButton);
			node.log(Status.INFO, "STEP1 : Clicked on the cancel button");
			System.out.println("STEP1 : Clicked on the cancel button");

			// Wait for the invisibility of repayment popup
			node.log(Status.INFO, "STEP2 : Waiting for the invisibility of the element");
			System.out.println("STEP2 : Waiting for the invisibility of the element");
			IWaitStrategy.waitForInVisiblity(node, driver, LoansNewLoanPO.repaymentPopup);
			node.log(Status.INFO, "STEP3 : The popup is not visible");
			System.out.println("STEP3 : The popup is not visible");

			// Assertion to verify that the popup is closed
			IElementActions.assertFalse_usingXpath(node, driver, LoansNewLoanPO.repaymentPopup,
					"STEP4 : Popup is still displayed after clicking close button",
					"STEP4 : Popup is not displayed after clicking close button");

			// Get after status
			String afterStatus = IElementActions.getElementText_usingXpath(node, driver,
					LoansNewLoanPO.loanStatusLabel);

			// Check before and after loan status
			if (beforeStatus.equals(afterStatus)) {
				Assert.assertTrue(true, " No changes to loan status");
				System.out.println("No changes to loan status.");
				node.log(Status.PASS, "No changes to loan status.");
			} else {
				Assert.assertTrue(false, beforeStatus + "is not same to " + afterStatus);
				System.out.println(beforeStatus + "is not same to " + afterStatus);
				node.log(Status.FAIL, beforeStatus + "is not same to " + afterStatus);
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCancelInterestRefundPopup", "Pass", driver);

		} catch (AssertionError validateCancelInterestRefundPopup) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCancelInterestRefundPopup test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCancelInterestRefundPopup_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCancelInterestRefundPopup.printStackTrace();
			node.fail(validateCancelInterestRefundPopup);
			Assert.fail();
			extent.flush();
		} catch (Exception validateCancelInterestRefundPopup) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCancelInterestRefundPopup test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCancelInterestRefundPopup_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCancelInterestRefundPopup.printStackTrace();
			node.fail(validateCancelInterestRefundPopup);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Loans_NewLoan_054
	@Test(priority = 7)
	public void validateWarningInInterestRefundPopup() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that when the user clicks 'Next' on the interest refund popup, there should be a warning confirmation message with the text")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Click on loan tab
			Utils.clickOnTab(LoansNewLoanPO.loanTab, LoansNewLoanPO.loanDisbursementHeader, "Loan");

			// Get the current URL
			String currentUrl = driver.getCurrentUrl();

			// Extract the loan number from the URL using regular expressions
			String loanNumber = LoansPage.extractLoanNumber(currentUrl);

			// Open repayment popup and go to refund date
			LoansPage.openRepaymentPopUpAndGoToRefundDate();

			// Get refund date
			WebElement refundDate = IElementActions.returnElement(node, driver, LoansNewLoanPO.refundDateInput);
			String refundDateAfter = refundDate.getAttribute("value");
			node.log(Status.INFO, "STEP1 : Refund date is " + refundDateAfter);
			System.out.println("STEP1 : Refund date is " + refundDateAfter);

			String expectedMessage = "You are about to book a full loan repayment for " + loanNumber + " as of "
					+ refundDateAfter + ".";

			// Click on the next button
			IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.repaymentPopupNextButton);
			node.log(Status.INFO, "STEP2 : Clicked on the next button on refund date popup to view warning message");
			System.out.println("STEP2 : Clicked on the next button on refund date popup to view warning message");

			// Wait for the visibility of warning message
			node.log(Status.INFO, "STEP3 : Waiting for the visibility of warning message");
			System.out.println("STEP3 : Waiting for the visibility of warning message");
			IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.warningMessageFirstLine);
			node.log(Status.INFO, "STEP4 : Warning message is visible");
			System.out.println("STEP4 : Warning message is visible");

			// Get actual warning message
			String actualMessage = IElementActions.getElementText_usingXpath(node, driver,
					LoansNewLoanPO.warningMessageFirstLine);

			// Assert the warning message
			IElementActions.assertEquals_usingString(node, driver, actualMessage, expectedMessage,
					"STEP5 : BUG : Warning message is not same", "STEP12 : PASS : Warning message is same");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateWarningInInterestRefundPopup", "Pass", driver);

		} catch (AssertionError validateWarningInInterestRefundPopup) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateWarningInInterestRefundPopup test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateWarningInInterestRefundPopup_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateWarningInInterestRefundPopup.printStackTrace();
			node.fail(validateWarningInInterestRefundPopup);
			Assert.fail();
			extent.flush();
		} catch (Exception validateWarningInInterestRefundPopup) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateWarningInInterestRefundPopup test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateWarningInInterestRefundPopup_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateWarningInInterestRefundPopup.printStackTrace();
			node.fail(validateWarningInInterestRefundPopup);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Loans_NewLoan_056
	@Test(priority = 8)
	public void validateRepaidStatusAfterConfirmationNo() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that when the user selects No for this final confirmation message, popup is no longer displayed and loan is not repaid (no changes to the loan status, cashflows or loan history)")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Click on loan tab
			Utils.clickOnTab(LoansNewLoanPO.loanTab, LoansNewLoanPO.loanDisbursementHeader, "Loan");

			// Get before status
			String beforeStatus = IElementActions.getElementText_usingXpath(node, driver,
					LoansNewLoanPO.loanStatusLabel);

			// Open repayment popup and go to confirmation popup
			LoansPage.openRepaymentPopUpAndGoToConfirmation();

			// Click on the no from warning popup
			IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.warningPopupNo);
			node.log(Status.INFO, "STEP1 : Clicked on the no from warning popup");
			System.out.println("STEP1 : Clicked on the no from warning popup");

			// Wait for the invisibility of warning popup
			node.log(Status.INFO, "STEP2 : Waiting for the invisibility of the warning popup");
			System.out.println("STEP2 : Waiting for the invisibility of the warning popup");
			IWaitStrategy.waitForInVisiblity(node, driver, LoansNewLoanPO.warningPopup);
			node.log(Status.INFO, "STEP3 : The warning popup is not visible");
			System.out.println("STEP3 : The warning popup is not visible");

			// Assertion to verify that the popup is closed
			IElementActions.assertFalse_usingXpath(node, driver, LoansNewLoanPO.warningPopup,
					"STEP4 : Warning popup is still displayed after clicking no button",
					"STEP4 : Warning popup is not displayed after clicking no button");

			// Wait for the visibility of status
			node.log(Status.INFO, "STEP5 : Waiting for the visibility of status");
			System.out.println("STEP5 : Waiting for the visibility of status");
			IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.popUpStatus);
			node.log(Status.INFO, "STEP6 : Popup with status is visible");
			System.out.println("STEP6 : Popup with status is visible");

			// Get status of popup
			WebElement popupTitle = IElementActions.returnElement(node, driver, LoansNewLoanPO.popUpStatus);
			String popupText = popupTitle.getText();

			// Perform assertions based on the popup status
			if (popupText.equals("ERROR")) {
				Assert.assertTrue(false, "Error popup appeared.");
				System.out.println("Error popup appeared.");
				node.log(Status.FAIL, "Error popup appeared.");
			} else if (popupText.equals("SUCCESS")) {
				// Click on the close button from success popup
				IElementActions.clickelement_usingXpath(node, driver, UtilsPO.closePopUp);
				node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on the close button from success popup");
				System.out.println("SUB-STEP_0.001 : Clicked on the close button from success popup");

				// Wait for the invisibility of warning popup
				node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the invisibility of the warning popup");
				System.out.println("SUB-STEP_0.002 : Waiting for the invisibility of the warning popup");
				IWaitStrategy.waitForInVisiblity(node, driver, UtilsPO.successPopup);
				node.log(Status.INFO, "SUB-STEP_0.003 : The warning popup is not visible");
				System.out.println("SUB-STEP_0.003 : The warning popup is not visible");

				// Assertion to verify that the popup is closed
				IElementActions.assertFalse_usingXpath(node, driver, UtilsPO.successPopup,
						"SUB-STEP_0.004 : Warning popup is still displayed after clicking no button",
						"SUB-STEP_0.004 : Warning popup is not displayed after clicking no button");
			}

			// Get after status
			String afterStatus = IElementActions.getElementText_usingXpath(node, driver,
					LoansNewLoanPO.loanStatusLabel);

			// Check before and after loan status
			if (beforeStatus.equals(afterStatus)) {
				Assert.assertTrue(true, " No changes to loan status");
				System.out.println("No changes to loan status.");
				node.log(Status.PASS, "No changes to loan status.");
			} else {
				Assert.assertTrue(false, beforeStatus + "is not same to " + afterStatus);
				System.out.println(beforeStatus + "is not same to " + afterStatus);
				node.log(Status.FAIL, beforeStatus + "is not same to " + afterStatus);
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateRepaidStatusAfterConfirmationNo", "Pass", driver);

		} catch (AssertionError validateRepaidStatusAfterConfirmationNo) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateRepaidStatusAfterConfirmationNo test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRepaidStatusAfterConfirmationNo_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRepaidStatusAfterConfirmationNo.printStackTrace();
			node.fail(validateRepaidStatusAfterConfirmationNo);
			Assert.fail();
			extent.flush();
		} catch (Exception validateRepaidStatusAfterConfirmationNo) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateRepaidStatusAfterConfirmationNo test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRepaidStatusAfterConfirmationNo_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRepaidStatusAfterConfirmationNo.printStackTrace();
			node.fail(validateRepaidStatusAfterConfirmationNo);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Loans_NewLoan_055
	@Test(priority = 9)
	public void validateRepaidStatusAfterConfirmationYes() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that when the user selects Yes for this final confirmation message, there is a success message displayed and after clicking off message the loan status has changed to Repaid")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Click on loan tab
			Utils.clickOnTab(LoansNewLoanPO.loanTab, LoansNewLoanPO.loanDisbursementHeader, "Loan");

			// Open repayment popup and go to effective date
			LoansPage.openRepaymentPopUpAndGoToEffectiveDate();

			// Get effective date
			WebElement effectiveDateLocator = IElementActions.returnElement(node, driver,
					LoansNewLoanPO.effectiveDateValue);
			String effectiveDate = effectiveDateLocator.getAttribute("value");
			node.log(Status.INFO, "STEP1 : Effective date is " + effectiveDate);
			System.out.println("STEP1 : Effective date is " + effectiveDate);

			// Update effective date on excel
			updateDataOnExcel(26, effectiveDate);

			// Click on the next button on repayment effective date popup
			IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.repaymentPopupNextButton);
			node.log(Status.INFO, "STEP2 : Clicked on the next button on repayment effective date popup");
			System.out.println("STEP2 : Clicked on the next button on repayment effective date popup");

			// Wait for the visibility of the refund date
			node.log(Status.INFO,
					"STEP3 : Waiting for the visibility of the refund date and for the next button to become clickable");
			System.out.println(
					"STEP3 : Waiting for the visibility of the refund date and for the next button to become clickable");
			IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.refundDate);
			IWaitStrategy.WaitUntilElementClickable(node, driver, LoansNewLoanPO.repaymentPopupNextButton);
			node.log(Status.INFO, "STEP4 : Refund date is visible and next button is clickable");
			System.out.println("STEP4 : Refund date is visible and next button is clickable");

			// Click on the next button
			IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.repaymentPopupNextButton);
			node.log(Status.INFO, "STEP5 : Clicked on the next button on refund date popup to view warning message");
			System.out.println("STEP5 : Clicked on the next button on refund date popup to view warning message");

			// Wait for the visibility of warning message
			node.log(Status.INFO,
					"STEP6 : Waiting for the visibility of warning message and for the yes button to become clickable");
			System.out.println(
					"STEP6 : Waiting for the visibility of warning message and for the yes button to become clickable");
			IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.warningMessageFirstLine);
			IWaitStrategy.WaitUntilElementClickable(node, driver, LoansNewLoanPO.warningPopupYes);
			node.log(Status.INFO, "STEP7 : Warning message is visible and yes button is clickable");
			System.out.println("STEP7 : Warning message is visible and yes button is clickable");

			// Click on the yes from warning popup
			IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.warningPopupYes);
			node.log(Status.INFO, "STEP8 : Clicked on the yes from warning popup");
			System.out.println("STEP8 : Clicked on the yes from warning popup");

			// Wait for the invisibility of warning popup
			node.log(Status.INFO, "STEP9 : Waiting for the invisibility of the warning popup");
			System.out.println("STEP9 : Waiting for the invisibility of the warning popup");
			IWaitStrategy.waitForInVisiblity(node, driver, UtilsPO.successPopup);
			node.log(Status.INFO, "STEP10 : The warning popup is not visible");
			System.out.println("STEP10 : The warning popup is not visible");

			// Assertion to verify that the popup is closed
			IElementActions.assertFalse_usingXpath(node, driver, UtilsPO.successPopup,
					"STEP11 : Warning popup is still displayed after clicking no button",
					"STEP11 : Warning popup is not displayed after clicking no button");

			// Get after status
			String afterStatus = IElementActions.getElementText_usingXpath(node, driver,
					LoansNewLoanPO.loanStatusLabel);

			// Check before and after loan status
			if (afterStatus.contains("Repaid")) {
				Assert.assertTrue(true, "The loan status is changed to Repaid");
				System.out.println("The loan status is changed to Repaid");
				node.log(Status.PASS, "The loan status is changed to Repaid");
			} else {
				Assert.assertTrue(false, afterStatus + " is coming and loan status is not changed to Repaid");
				System.out.println(afterStatus + " is coming and loan status is not changed to Repaid");
				node.log(Status.FAIL, afterStatus + " is coming and loan status is not changed to Repaid");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateRepaidStatusAfterConfirmationYes", "Pass", driver);

		} catch (AssertionError validateRepaidStatusAfterConfirmationYes) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateRepaidStatusAfterConfirmationYes test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRepaidStatusAfterConfirmationYes_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRepaidStatusAfterConfirmationYes.printStackTrace();
			node.fail(validateRepaidStatusAfterConfirmationYes);
			Assert.fail();
			extent.flush();
		} catch (Exception validateRepaidStatusAfterConfirmationYes) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateRepaidStatusAfterConfirmationYes test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRepaidStatusAfterConfirmationYes_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRepaidStatusAfterConfirmationYes.printStackTrace();
			node.fail(validateRepaidStatusAfterConfirmationYes);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Loans_NewLoan_057
	@Test(priority = 10)
	public void validateHistoryAfterFullRepayment() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that navigating to the Loan History tab, there is a new line item of Change Type = 'Status Change' where New Value = 'Repaid'")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Click on loan history tab
			Utils.clickOnTab(LoansNewLoanPO.loanHistoryTab, LoansNewLoanPO.editAmendsHeader, "Loan History");

			// Get first row change type
			String changeType = IElementActions.getElementText_usingXpath(node, driver,
					LoansNewLoanPO.firstRowChangeType);

			// Get first row new value
			String newValue = IElementActions.getElementText_usingXpath(node, driver, LoansNewLoanPO.firstRowNewValue);

			// Check change type and loan status
			if (changeType.contains("Status Change") && newValue.contains("Repaid")) {
				Assert.assertTrue(true, "The change type is Status Change and loan status is changed to Repaid");
				System.out.println("The change type is Status Change and loan status is changed to Repaid");
				node.log(Status.PASS, "The change type is Status Change and loan status is changed to Repaid");
			} else {
				Assert.assertTrue(false, changeType + " is not Status Change and " + newValue
						+ " is coming and loan status is not changed to Repaid");
				System.out.println(changeType + " is not Status Change and " + newValue
						+ " is coming and loan status is not changed to Repaid");
				node.log(Status.FAIL, changeType + " is not Status Change and " + newValue
						+ " is coming and loan status is not changed to Repaid");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateHistoryAfterFullRepayment", "Pass", driver);

		} catch (AssertionError validateHistoryAfterFullRepayment) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateHistoryAfterFullRepayment test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateHistoryAfterFullRepayment_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateHistoryAfterFullRepayment.printStackTrace();
			node.fail(validateHistoryAfterFullRepayment);
			Assert.fail();
			extent.flush();
		} catch (Exception validateHistoryAfterFullRepayment) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateHistoryAfterFullRepayment test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateHistoryAfterFullRepayment_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateHistoryAfterFullRepayment.printStackTrace();
			node.fail(validateHistoryAfterFullRepayment);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Loans_NewLoan_058
	@Test(priority = 11)
	public void validateCashflowAfterFullRepayment() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that navigating to the Cashflows tab, Loan Repayment cashflow is confirmed with the selected effective date ")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get effective date from excel
			String effectiveDate = getDataFromExcel(26);

			// Click on cashflows tab
			Utils.clickOnTab(LoansNewLoanPO.cashflowsTab, LoansNewLoanPO.cashflowsHeader, "Cashflows");

			// Get current effective date
			String actualEffectiveDate = IElementActions
					.getElementText_usingXpath(node, driver, LoansNewLoanPO.firstRowEffectiveDate).trim();

			// Get cashflow status
			String cashflowStatus = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					LoansNewLoanPO.firstRowConfirmationStatus, "class");

			// Assert the effective date value
			IElementActions.assertEquals_usingString(node, driver, actualEffectiveDate, effectiveDate,
					"BUG : The effective date in repayment popup " + effectiveDate + " and in cashflow "
							+ actualEffectiveDate + "is not same",
					"PASS : The effective date in repayment popup " + effectiveDate + " and in cashflow "
							+ actualEffectiveDate + "is not same");

			// Check status in cashflow
			if (cashflowStatus.contains("text-success")) {
				Assert.assertTrue(true, "Loan Repayment cashflow is confirmed");
				System.out.println("Loan Repayment cashflow is confirmed");
				node.log(Status.PASS, "Loan Repayment cashflow is confirmed");
			} else {
				Assert.assertTrue(false, "Cashflow status is " + cashflowStatus + " and is not success");
				System.out.println("Cashflow status is " + cashflowStatus + " and is not success");
				node.log(Status.FAIL, "Cashflow status is " + cashflowStatus + " and is not success");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashflowAfterFullRepayment", "Pass", driver);

		} catch (AssertionError validateCashflowAfterFullRepayment) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashflowAfterFullRepayment test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashflowAfterFullRepayment_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashflowAfterFullRepayment.printStackTrace();
			node.fail(validateCashflowAfterFullRepayment);
			Assert.fail();
			extent.flush();
		} catch (Exception validateCashflowAfterFullRepayment) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashflowAfterFullRepayment test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashflowAfterFullRepayment_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashflowAfterFullRepayment.printStackTrace();
			node.fail(validateCashflowAfterFullRepayment);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Loans_NewLoan_059
	@Test(priority = 12)
	public void validateSummayAfterFullRepayment() throws IOException {

		try {
			extenttest = extent.createTest("Verify that navigating to the Summary tab, the Current Loan Amount is £0")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Click on summary tab
			Utils.clickOnTab(LoansNewLoanPO.summaryTab, LoansNewLoanPO.loanDetailsHeader, "Summary");

			// Get current amount value
			String currentAmount = IElementActions.getElementText_usingXpath(node, driver,
					LoansNewLoanPO.currentAmountSummary);

			// Assert the current amount value
			IElementActions.assertEquals_usingString(node, driver, currentAmount, "£0",
					"BUG : The Current Loan Amount is not £0", "PASS : The Current Loan Amount is £0");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateSummayAfterFullRepayment", "Pass", driver);

		} catch (AssertionError validateSummayAfterFullRepayment) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateSummayAfterFullRepayment test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateSummayAfterFullRepayment_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSummayAfterFullRepayment.printStackTrace();
			node.fail(validateSummayAfterFullRepayment);
			Assert.fail();
			extent.flush();
		} catch (Exception validateSummayAfterFullRepayment) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateSummayAfterFullRepayment test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateSummayAfterFullRepayment_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSummayAfterFullRepayment.printStackTrace();
			node.fail(validateSummayAfterFullRepayment);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Loans_NewLoan_060
	@Test(priority = 13)
	public void validatePopupInPartialRepayment() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that when the user selects 'Partial' for 'Repayment Type,' a pop-up appears as intended")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Click on loan tab
			Utils.clickOnTab(LoansNewLoanPO.loanTab, LoansNewLoanPO.loanDisbursementHeader, "Loan");

			// Open partial repayment popup and go to effective date
			LoansPage.openPartialRepaymentPopUpAndGoToEffectiveDate();

			// Check the visibility of due payment
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.duePayment,
					"STEP1 : BUG: Due payment is not coming on repayment popup",
					"STEP1 : EXPECTED: Due payment is coming on repayment popup");

			// Check the visibility of partial amount
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.partialAmount,
					"STEP2 : BUG: Partial amount is not coming on repayment popup",
					"STEP2 : EXPECTED: Partial amount is coming on repayment popup");

			// Check the visibility of partial effective date
			IElementActions.assertTrue_usingXpath(node, driver, LoansNewLoanPO.partialEffectiveDate,
					"STEP3 : BUG: Partial effective date is not coming on repayment popup",
					"STEP3 : EXPECTED: Partial effective date is coming on repayment popup");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validatePopupInPartialRepayment", "Pass", driver);

		} catch (AssertionError validatePopupInPartialRepayment) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePopupInPartialRepayment test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePopupInPartialRepayment_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePopupInPartialRepayment.printStackTrace();
			node.fail(validatePopupInPartialRepayment);
			Assert.fail();
			extent.flush();
		} catch (Exception validatePopupInPartialRepayment) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePopupInPartialRepayment test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePopupInPartialRepayment_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePopupInPartialRepayment.printStackTrace();
			node.fail(validatePopupInPartialRepayment);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Loans_NewLoan_061
	// TC_Loans_NewLoan_062
	@Test(priority = 14)
	public void validateCashflowAndSummaryAfterPartialRepayment() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that navigating after partial repayment to the Cashflows tab, Loan Repayment cashflow is confirmed with the selected effective date and amount"
							+ "Verify that navigating to the Summary tab, the Current Amount decreased by the value of the partial repayment that was just confirmed")
					.assignCategory(loansNewLoan_tag + "_" + env);
			node = extenttest.createNode("Report");

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

			// Wait for the visibility of dropdown
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of dropdown");
			System.out.println("STEP1 : Waiting for the visibility of dropdown");
			IWaitStrategy.waitForVisiblity(node, driver, LoansDatabasePO.statusDropdown);
			node.log(Status.INFO, "STEP2 : Dropdown is visible");
			System.out.println("STEP2 : Dropdown is visible");

			Thread.sleep(2000);
			// Clear result and select value from dropdown
			Utils.selectValueInDropdown(LoansDatabasePO.statusDropdown, LoansDatabasePO.liveDropdownoption);

			// Click and enter on the amount filter
			IElementActions.clickClearAndInput_usingXpath(node, driver, LoansDatabasePO.amountMin, "100");
			node.log(Status.INFO, "STEP3 : Clicked and enetered on the amount filter");
			System.out.println("STEP3 : Clicked and enetered on the amount filter");

			// Wait for the visibility of Edit Icon
			node.log(Status.INFO, "STEP4 : Waiting for the visibility of Edit Icon");
			System.out.println("STEP4 : Waiting for the visibility of Edit Icon");
			IWaitStrategy.waitForVisiblity(node, driver, UtilsPO.editIcon);
			node.log(Status.INFO, "STEP5 : Edit Icon is visible");
			System.out.println("STEP5 : Edit Icon is visible");

			// Click on the Edit Icon
			IElementActions.clickelement_usingXpath(node, driver, UtilsPO.editIcon);
			node.log(Status.INFO, "STEP6 : clicked on the Edit Icon");
			System.out.println("STEP6 : clicked on the Edit Icon");

			// Wait for the visibility of page
			node.log(Status.INFO, "STEP7 : Waiting for the visibility of page");
			System.out.println("STEP7 : Waiting for the visibility of page");
			IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.editBridgeLoanHeaderText);
			node.log(Status.INFO, "STEP8 : page is visible");
			System.out.println("STEP8 : page is visible");

			// Click on summary tab
			Utils.clickOnTab(LoansNewLoanPO.summaryTab, LoansNewLoanPO.loanDetailsHeader, "Summary");

			// Get current amount value
			int currentAmountBeforeRepayment = Utils.getTextAndParseToInt(LoansNewLoanPO.currentAmountSummary);

			// Click on loan tab
			Utils.clickOnTab(LoansNewLoanPO.loanTab, LoansNewLoanPO.loanDisbursementHeader, "Loan");

			String loanPartialRepaymentAmount = "1";

			// Create a partial repayment and get effective date
			String effectiveDate = LoansPage.createPartialRepayment(loanPartialRepaymentAmount);

			// Click on cashflows tab
			Utils.clickOnTab(LoansNewLoanPO.cashflowsTab, LoansNewLoanPO.cashflowsHeader, "Cashflows");

			// Click on the start date
			IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.effectiveStartDate);
			node.log(Status.INFO, "STEP9 : Clicked on the start date");
			System.out.println("STEP9 : Clicked on the start date");

			// Get yesterday day
			String yesterday = Utils.getYesterdayDayFormatted();

			// Select day in refund date calender
			Utils.enterDay(UtilsPO.calenderDay, yesterday);

			// Click on the end date
			IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.effectiveEndDate);
			node.log(Status.INFO, "STEP10 : Clicked on the end date");
			System.out.println("STEP10 : Clicked on the end date");

			// Get tomorrow day
			String tomorrowDay = Utils.getTomorrowDayFormatted();

			// Select day in refund date calender
			Utils.enterDay(UtilsPO.calenderDay, tomorrowDay);

			// Get current effective date
			String actualEffectiveDate = IElementActions
					.getElementText_usingXpath(node, driver, LoansNewLoanPO.firstRowEffectiveDate).trim();

			// Assert the effective date value
			IElementActions.assertEquals_usingString(node, driver, actualEffectiveDate, effectiveDate,
					"BUG : The effective date in repayment popup " + effectiveDate + " and in cashflow "
							+ actualEffectiveDate + "is not same",
					"PASS : The effective date in repayment popup " + effectiveDate + " and in cashflow "
							+ actualEffectiveDate + "is same");

			// Click on summary tab
			Utils.clickOnTab(LoansNewLoanPO.summaryTab, LoansNewLoanPO.loanDetailsHeader, "Summary");

			// Get current amount value
			int currentAmountAfterRepayment = Utils.getTextAndParseToInt(LoansNewLoanPO.currentAmountSummary);

			// Get loan partial repayment amount
			int loanPartialRepaymentValue = Integer.parseInt(loanPartialRepaymentAmount);

			// Get expected amount value
			int expectedCurrentAmount = Utils.calculateDifference(currentAmountBeforeRepayment,
					loanPartialRepaymentValue);

			// Assert the current amount value
			IElementActions.assertEquals_usingInteger(node, driver, currentAmountAfterRepayment, expectedCurrentAmount,
					"BUG : The current amount before repayment is " + currentAmountBeforeRepayment
							+ " and is not decrease by " + loanPartialRepaymentValue
							+ " i.e current amount after repayment is " + currentAmountAfterRepayment,
					"PASS : The current amount before disbursement is " + currentAmountBeforeRepayment
							+ " and is decrease by " + loanPartialRepaymentValue
							+ " i.e current amount after repayment is " + currentAmountAfterRepayment);
			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashflowAndSummaryAfterPartialRepayment", "Pass", driver);

		} catch (AssertionError validateCashflowAndSummaryAfterPartialRepayment) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashflowAndSummaryAfterPartialRepayment test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashflowAndSummaryAfterPartialRepayment_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashflowAndSummaryAfterPartialRepayment.printStackTrace();
			node.fail(validateCashflowAndSummaryAfterPartialRepayment);
			Assert.fail();
			extent.flush();
		} catch (Exception validateCashflowAndSummaryAfterPartialRepayment) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashflowAndSummaryAfterPartialRepayment test in NewLoanTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashflowAndSummaryAfterPartialRepayment_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashflowAndSummaryAfterPartialRepayment.printStackTrace();
			node.fail(validateCashflowAndSummaryAfterPartialRepayment);
			Assert.fail();
			extent.flush();
		}
	}
}
