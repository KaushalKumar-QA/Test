package com.Loans.NewLoan.tests;

import java.io.IOException;

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

public class DatabaseTest extends Baseclass {

	// TC_Database_001
	@Test(priority = 1)
	public void validateBridgeLoanDatabasePage() throws IOException {

		try {
			extenttest = extent.createTest("Verify user is able to view the Bridge Loan Database Page")
					.assignCategory(loansDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadLoginPage function from the login
			LoginPage.loadLoginPage();

			// Calling the userLoginProcess function from the LoginPage
			LoginPage.userLoginProcess(node, driver, getDataFromExcel(1), getDataFromExcel(2));

			// Click on the Loans Menu
			Utils.clickOnMenu(node, driver, SideMenuPO.loans);

			// Click on the Loans Database Sub Menu
			Utils.clickOnMenu(node, driver, SideMenuPO.loansDatabase);

			// Wait for the visibility of Loans Database page
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of Loans Database page");
			System.out.println("STEP1 : Waiting for the visibility of Loans Database page");
			IWaitStrategy.waitForVisiblity(node, driver, LoansDatabasePO.bridgeLoanDatabseText);
			node.log(Status.INFO, "STEP2 : Loans Database page is visible");
			System.out.println("STEP2 : Loans Database page is visible");

			Thread.sleep(2000);
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			// Assert that Database page is visible
			System.out.println("STEP3 : Asserting that Database page is visible");
			node.log(Status.INFO, "STEP3 : Asserting that Database page is visible");

			// Calling the validateUrl from Utils
			Utils.validateUrl(node, driver, currentUrl, AllPagesUrl.databasePage, "validateBridgeLoanDatabasePage");

		} catch (AssertionError validateBridgeLoanDatabasePage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateBridgeLoanDatabasePage test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBridgeLoanDatabasePage_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBridgeLoanDatabasePage.printStackTrace();
			node.fail(validateBridgeLoanDatabasePage);
			Assert.fail();
			extent.flush();
		} catch (Exception validateBridgeLoanDatabasePage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateBridgeLoanDatabasePage test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBridgeLoanDatabasePage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBridgeLoanDatabasePage.printStackTrace();
			node.fail(validateBridgeLoanDatabasePage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Database_002
	@Test(priority = 2)
	public void validateActionColumn() throws IOException {

		try {
			extenttest = extent
					.createTest(
							"Verify initial state of the Action Column it will display:Edit button and Delete button")
					.assignCategory(loansDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadDatabasePage from LoansPage
			LoansPage.loadDatabasePage();

			// Check the visibility of edit icon
			IElementActions.assertTrue_usingXpath(node, driver, UtilsPO.editIcon,
					"STEP1 : BUG : Edit icon is not coming under action on database page",
					"STEP1 : EXPECTED : Edit icon is coming under action on database page");

			// Check the visibility of delete icon
			IElementActions.assertTrue_usingXpath(node, driver, UtilsPO.deleteIcon,
					"STEP2 : BUG : Delete icon is not coming under action on database page",
					"STEP2 : EXPECTED : Delete icon is coming under action on database page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateActionColumn", "Pass", driver);

		} catch (AssertionError validateActionColumn) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateActionColumn test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateActionColumn_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateActionColumn.printStackTrace();
			node.fail(validateActionColumn);
			Assert.fail();
			extent.flush();
		} catch (Exception validateNewBridgeLoanPage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNewBridgeLoanPage test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateNewBridgeLoanPage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNewBridgeLoanPage.printStackTrace();
			node.fail(validateNewBridgeLoanPage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Database_019
	@Test(priority = 3)
	public void validateLoanSearchByInternalRef() throws IOException {

		try {
			extenttest = extent.createTest("Verfiy user is able search Loan by Internal Ref")
					.assignCategory(loansDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadDatabasePage from LoansPage
			LoansPage.loadDatabasePage();

			// Get loan internal reference
			String internalReferenceNumber = getDataFromExcel(28);

			// Search record based on the provide internal reference and open it
			Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, LoansDatabasePO.internalRefSearchField,
					internalReferenceNumber, UtilsPO.editIcon, LoansNewLoanPO.editBridgeLoanHeaderText);

			String internalReference = IElementActions.getElementText_usingXpath(node, driver,
					LoansNewLoanPO.internalReference);

			// Assert internal reference
			if (internalReference.toLowerCase().contains(internalReferenceNumber.toLowerCase())) {
				Assert.assertTrue(true, "The searched internal reference " + internalReferenceNumber
						+ "and the opened record's internal reference are the same, i.e.," + internalReference);
				System.out.println("The searched internal reference " + internalReferenceNumber
						+ "and the opened record's internal reference are the same, i.e.," + internalReference);
				node.log(Status.PASS, "The searched internal reference " + internalReferenceNumber
						+ "and the opened record's internal reference are the same, i.e.," + internalReference);
			} else {
				Assert.assertTrue(false, "The searched internal reference " + internalReferenceNumber
						+ "and the opened record's internal reference are not the same, i.e.," + internalReference);
				System.out.println("The searched internal reference " + internalReferenceNumber
						+ "and the opened record's internal reference are not the same, i.e.," + internalReference);
				node.log(Status.FAIL, "The searched internal reference " + internalReferenceNumber
						+ "and the opened record's internal reference are not the same, i.e.," + internalReference);
			}
			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanSearchByInternalRef", "Pass", driver);

		} catch (AssertionError validateLoanSearchByInternalRef) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanSearchByInternalRef test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanSearchByInternalRef_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanSearchByInternalRef.printStackTrace();
			node.fail(validateLoanSearchByInternalRef);
			Assert.fail();
			extent.flush();
		} catch (Exception validateLoanSearchByInternalRef) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanSearchByInternalRef test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanSearchByInternalRef_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanSearchByInternalRef.printStackTrace();
			node.fail(validateLoanSearchByInternalRef);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Database_021
	@Test(priority = 4)
	public void validateLoanSearchByLoanRef() throws IOException {

		try {
			extenttest = extent.createTest("Verfiy user is able search Loan by Loan Ref ")
					.assignCategory(loansDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadDatabasePage from LoansPage
			LoansPage.loadDatabasePage();

			// Get loan reference
			String loanReferenceNumber = getDataFromExcel(25);

			// Search record based on the provide loan reference and open it
			Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, LoansDatabasePO.loanRefSearchField,
					loanReferenceNumber, UtilsPO.editIcon, LoansNewLoanPO.editBridgeLoanHeaderText);

			Thread.sleep(2000);
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			// Assert loan reference
			if (currentUrl.contains(loanReferenceNumber)) {
				Assert.assertTrue(true, "The searched loan reference " + loanReferenceNumber
						+ "and the opened record's loan reference are the same, i.e.," + currentUrl);
				System.out.println("The searched loan reference " + loanReferenceNumber
						+ "and the opened record's loan reference are the same, i.e.," + currentUrl);
				node.log(Status.PASS, "The searched loan reference " + loanReferenceNumber
						+ "and the opened record's loan reference are the same, i.e.," + currentUrl);
			} else {
				Assert.assertTrue(false, "The searched loan reference " + loanReferenceNumber
						+ "and the opened record's loan reference are not the same, i.e.," + currentUrl);
				System.out.println("The searched loan reference " + loanReferenceNumber
						+ "and the opened record's loan reference are not the same, i.e.," + currentUrl);
				node.log(Status.FAIL, "The searched loan reference " + loanReferenceNumber
						+ "and the opened record's loan reference are not the same, i.e.," + currentUrl);
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanSearchByLoanRef", "Pass", driver);

		} catch (AssertionError validateLoanSearchByLoanRef) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanSearchByLoanRef test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanTabDetails_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanSearchByLoanRef.printStackTrace();
			node.fail(validateLoanSearchByLoanRef);
			Assert.fail();
			extent.flush();
		} catch (Exception validateLoanSearchByLoanRef) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanSearchByLoanRef test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanSearchByLoanRef_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanSearchByLoanRef.printStackTrace();
			node.fail(validateLoanSearchByLoanRef);
			Assert.fail();
			extent.flush();
		}
	}

}
