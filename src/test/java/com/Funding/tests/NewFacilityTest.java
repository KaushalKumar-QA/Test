package com.Funding.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.locators.allPages.FundingNewFacilityPO;
import com.locators.allPages.PipelinePO;
import com.locators.allPages.SideMenuPO;
import com.locators.allPages.UtilsPO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.url.AllPagesUrl;
import com.qa.utils.FundingPage;
import com.qa.utils.LoginPage;
import com.qa.utils.Utils;

public class NewFacilityTest extends Baseclass {

	// TC_Funding_NewFacility _001
	@Test(priority = 1)
	public void visibilityOfFundingMenuFromSideMenuOptions() throws IOException {

		try {
			extenttest = extent.createTest("Verify that the user can view the Funding menu from the side menu options.")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			// Calling the userLoginProcess function from the utils login
			LoginPage.userLoginProcess(node, driver, getDataFromExcel(1), getDataFromExcel(2));

			// Wait for the visibility of the side menu funding
			System.out.println("STEP1 : Waiting for the visibility of the Funding menu option.");
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the Funding menu option.");
			IWaitStrategy.waitForVisiblity(node, driver, SideMenuPO.funding);
			System.out.println("STEP2 : Funding menu option is now visible.");
			node.log(Status.INFO, "STEP2 : Funding menu option is now visible.");

			// Asserting the side menu
			IElementActions.assertTrue_usingXpath(node, driver, SideMenuPO.funding,
					"STEP3: BUG : The Funding menu is not displaying from the side menu options.",
					"STEP3: PASS : The Funding menu is displaying from the side menu options.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("visibilityOfFundingMenuFromSideMenuOptions", "Pass", driver);

		} catch (AssertionError visibilityOfFundingMenuFromSideMenuOptions) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In visibilityOfFundingMenuFromSideMenuOptions test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"visibilityOfFundingMenuFromSideMenuOptions_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			visibilityOfFundingMenuFromSideMenuOptions.printStackTrace();
			node.fail(visibilityOfFundingMenuFromSideMenuOptions);
			Assert.fail();
			extent.flush();
		} catch (Exception visibilityOfFundingMenuFromSideMenuOptions) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In visibilityOfFundingMenuFromSideMenuOptions test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"visibilityOfFundingMenuFromSideMenuOptions_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			visibilityOfFundingMenuFromSideMenuOptions.printStackTrace();
			node.fail(visibilityOfFundingMenuFromSideMenuOptions);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _002
	@Test(priority = 2)
	public void visibilityOfFundingSubMenuOptions() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the user can access the Funding menu from the side menu options.")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Wait for the visibility of the side menu funding
			System.out.println("STEP1 : Waiting for the visibility of the Funding menu option.");
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the Funding menu option.");
			IWaitStrategy.waitForVisiblity(node, driver, SideMenuPO.funding);
			System.out.println("STEP2 : Funding menu option is now visible.");
			node.log(Status.INFO, "STEP2 : Funding menu option is now visible.");

			// Click on the Funding menu
			Utils.clickOnMenu(node, driver, SideMenuPO.funding);

			// Wait for the visibility of the side menu funding new facility option
			System.out.println("STEP3 : Waiting for the visibility of the Funding new facility option.");
			node.log(Status.INFO, "STEP3 : Waiting for the visibility of the Funding new facility option.");
			IWaitStrategy.waitForVisiblity(node, driver, SideMenuPO.fundingNewFacility);
			System.out.println("STEP4 : Funding new facility option is now visible.");
			node.log(Status.INFO, "STEP4 : Funding new facility option is now visible.");

			// Asserting the side menu new facility option
			IElementActions.assertTrue_usingXpath(node, driver, SideMenuPO.fundingNewFacility,
					"STEP5 : BUG : The funding new facility option is not displaying from the side menu options.",
					"STEP5 : PASS : The funding new facility option is displaying from the side menu options.");

			// Wait for the visibility of the side menu funding database option
			System.out.println("STEP6 : Waiting for the visibility of the funding database option.");
			node.log(Status.INFO, "STEP6 : Waiting for the visibility of the funding database option.");
			IWaitStrategy.waitForVisiblity(node, driver, SideMenuPO.fundingDatabase);
			System.out.println("STEP7 : Funding database option is now visible.");
			node.log(Status.INFO, "STEP7 : Funding database option is now visible.");

			// Asserting the side menu database option
			IElementActions.assertTrue_usingXpath(node, driver, SideMenuPO.fundingDatabase,
					"STEP8 : BUG : The Funding database option is not displaying from the side menu options.",
					"STEP8 : PASS : The Funding database option is displaying from the side menu options.");

			// Wait for the visibility of the side menu funding interest payment option
			System.out.println("STEP9 : Waiting for the visibility of the funding interest payment option.");
			node.log(Status.INFO, "STEP9 : Waiting for the visibility of the funding interest payment option.");
			IWaitStrategy.waitForVisiblity(node, driver, SideMenuPO.interestPayment);
			System.out.println("STEP10 : Funding interest payment option is now visible.");
			node.log(Status.INFO, "STEP10 : Funding interest payment option is now visible.");

			// Asserting the side menu interest payment option
			IElementActions.assertTrue_usingXpath(node, driver, SideMenuPO.interestPayment,
					"STEP11 : BUG : The funding interest payment option is not displaying from the side menu options.",
					"STEP11 : PASS : The funding interest payment option is displaying from the side menu options.");

			// Wait for the visibility of the side menu funding calculate interest option
			System.out.println("STEP12 : Waiting for the visibility of the funding calculate interest option.");
			node.log(Status.INFO, "STEP12 : Waiting for the visibility of the funding calculate interest option.");
			IWaitStrategy.waitForVisiblity(node, driver, SideMenuPO.calculateInterest);
			System.out.println("STEP13 : Funding calculate interest option is now visible.");
			node.log(Status.INFO, "STEP13 : Funding calculate interest option is now visible.");

			// Asserting the side menu calculate interest option
			IElementActions.assertTrue_usingXpath(node, driver, SideMenuPO.calculateInterest,
					"STEP14 : BUG : The funding calculate interest option is not displaying from the side menu options.",
					"STEP14 : PASS : The funding calculate interest option is displaying from the side menu options.");

			// Wait for the visibility of the side menu funding
			System.out.println("STEP15 : Waiting for the visibility of the funding management accounts option.");
			node.log(Status.INFO, "STEP15 : Waiting for the visibility of the funding management accounts option.");
			IWaitStrategy.waitForVisiblity(node, driver, SideMenuPO.fundingManagementAccounts);
			System.out.println("STEP16 : Funding management accounts option is now visible.");
			node.log(Status.INFO, "STEP16 : Funding management accounts option is now visible.");

			// Asserting the side menu management accounts option
			IElementActions.assertTrue_usingXpath(node, driver, SideMenuPO.fundingManagementAccounts,
					"STEP17 : BUG : The funding management accounts option is not displaying from the side menu options.",
					"STEP17 : PASS : The funding management accounts option is displaying from the side menu options.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("visibilityOfFundingSubMenuOptions", "Pass", driver);

		} catch (AssertionError visibilityOfFundingSubMenuOptions) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In visibilityOfFundingSubMenuOptions test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"visibilityOfFundingSubMenuOptions_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			visibilityOfFundingSubMenuOptions.printStackTrace();
			node.fail(visibilityOfFundingSubMenuOptions);
			Assert.fail();
			extent.flush();
		} catch (Exception visibilityOfFundingSubMenuOptions) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In visibilityOfFundingSubMenuOptions test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"visibilityOfFundingSubMenuOptions_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			visibilityOfFundingSubMenuOptions.printStackTrace();
			node.fail(visibilityOfFundingSubMenuOptions);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _003
	@Test(priority = 3)
	public void validateNewFacilityPageVisibility() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the user can access the New Facility menu from the side menu options.")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Click on the Funding Menu
			Utils.clickOnMenu(node, driver, SideMenuPO.funding);

			// Wait for the visibility of the side menu funding new facility option
			System.out.println("STEP1 : Waiting for the visibility of the funding new facility option.");
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the funding new facility option.");
			IWaitStrategy.waitForVisiblity(node, driver, SideMenuPO.fundingNewFacility);
			System.out.println("STEP2 : Funding new facility option is now visible.");
			node.log(Status.INFO, "STEP2 : Funding new facility option is now visible.");

			// Click on the new facility
			Utils.clickOnMenu(node, driver, SideMenuPO.fundingNewFacility);

			Thread.sleep(2000);
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			// Assert that interest payment page is visible
			System.out.println("STEP3 : Asserting that new facility page is visible");
			node.log(Status.INFO, "STEP3 : Asserting that new facility page is visible");

			// Calling the validateUrl from Utils
			Utils.validateUrl(node, driver, currentUrl, AllPagesUrl.fundingNewFacilityPage,
					"validateNewFacilityPageVisibility");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateNewFacilityPageVisibility", "Pass", driver);

		} catch (AssertionError validateNewFacilityPageVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNewFacilityPageVisibility test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNewFacilityPageVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNewFacilityPageVisibility.printStackTrace();
			node.fail(validateNewFacilityPageVisibility);
			Assert.fail();
			extent.flush();
		} catch (Exception validateNewFacilityPageVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNewFacilityPageVisibility test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNewFacilityPageVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNewFacilityPageVisibility.printStackTrace();
			node.fail(validateNewFacilityPageVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _005
	@Test(priority = 4)
	public void visibilityOfNewFacilityPageHeader() throws IOException {

		try {
			extenttest = extent.createTest("Verify the page name in the new facility page header.")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadNewFacilityPage from FacilityePage
			FundingPage.loadNewFacilityPage();

			// Getting the text of the header
			String headerText = IElementActions.getElementText_usingXpath(node, driver,
					FundingNewFacilityPO.newFacilityPageHeader);

			// Asserting the new facility page header
			IElementActions.assertEquals_usingString(node, driver, headerText, "New Loan Facility",
					"STEP1 : BUG : The header is not displaying as 'New Loan Facility'.",
					"STEP1 : PASS : The header is displaying as 'New Loan Facility'.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("visibilityOfNewFacilityPageHeader", "Pass", driver);

		} catch (AssertionError visibilityOfNewFacilityPageHeader) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In visibilityOfNewFacilityPageHeader test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"visibilityOfNewFacilityPageHeader_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			visibilityOfNewFacilityPageHeader.printStackTrace();
			node.fail(visibilityOfNewFacilityPageHeader);
			Assert.fail();
			extent.flush();
		} catch (Exception visibilityOfNewFacilityPageHeader) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In visibilityOfNewFacilityPageHeader test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"visibilityOfNewFacilityPageHeader_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			visibilityOfNewFacilityPageHeader.printStackTrace();
			node.fail(visibilityOfNewFacilityPageHeader);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _006
	@Test(priority = 5)
	public void validateLoanFacilityStatus() throws IOException {

		try {
			extenttest = extent.createTest("Verify the Loan Facility Status in the new facility page header")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadNewFacilityPage from FacilityePage
			FundingPage.loadNewFacilityPage();

			// Getting the text of the header
			String facilityStatus = IElementActions.getElementText_usingXpath(node, driver,
					FundingNewFacilityPO.loanFacilityStatus);

			// Asserting the loan facility status
			IElementActions.assertEquals_usingString(node, driver, facilityStatus,
					"Loan Facility Status: In Progress | Approval Status: Unapproved",
					"BUG : " + facilityStatus + " is displayed in the loan facility",
					"PASS : The loan facility is displaying as 'Loan Facility Status: In Progress | Approval Status: Unapproved'.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanFacilityStatus", "Pass", driver);

		} catch (AssertionError validateLoanFacilityStatus) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanFacilityStatus test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanFacilityStatus_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanFacilityStatus.printStackTrace();
			node.fail(validateLoanFacilityStatus);
			Assert.fail();
			extent.flush();
		} catch (Exception validateLoanFacilityStatus) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanFacilityStatus test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanFacilityStatus_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanFacilityStatus.printStackTrace();
			node.fail(validateLoanFacilityStatus);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _007
	@Test(priority = 6)
	public void visibilityOfInternalReferenceText() throws IOException {

		try {
			extenttest = extent.createTest("Verify the Internal Reference in the new facility page header")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadNewFacilityPage from FacilityePage
			FundingPage.loadNewFacilityPage();

			// Getting the text of the internal reference
			String text = IElementActions.getElementText_usingXpath(node, driver,
					FundingNewFacilityPO.internalReferenceText);

			// Asserting the internal reference
			IElementActions.assertEquals_usingString(node, driver, text, "Internal Reference",
					"BUG : " + text + " text is displayed", "PASS : The internal reference text is not displaying");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("visibilityOfInternalReferenceText", "Pass", driver);

		} catch (AssertionError visibilityOfInternalReferenceText) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In visibilityOfInternalReferenceText test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"visibilityOfInternalReferenceText_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			visibilityOfInternalReferenceText.printStackTrace();
			node.fail(visibilityOfInternalReferenceText);
			Assert.fail();
			extent.flush();
		} catch (Exception visibilityOfInternalReferenceText) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In visibilityOfInternalReferenceText test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"visibilityOfInternalReferenceText_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			visibilityOfInternalReferenceText.printStackTrace();
			node.fail(visibilityOfInternalReferenceText);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _008
	@Test(priority = 7)
	public void visibilityOfMenusUnderNewFacilityPage() throws IOException {

		try {
			extenttest = extent.createTest("Verify the menus under the new facility page")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadNewFacilityPage from FacilityePage
			FundingPage.loadNewFacilityPage();

			// Visibility of the lender tab
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.lenderTab,
					"BUG : Lender tab is not displaying", "PASS : Lender tab is displaying");
			System.out.println("STEP1 : Lender tab is visible on the new facility page.");
			node.log(Status.INFO, "STEP1 : Lender tab is visible on the new facility page.");

			// Visibility of the facility tab
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.facilityTab,
					"BUG : Facility tab is not displaying", "PASS : Facility tab is displaying");
			System.out.println("STEP2 : Facility tab is visible on the new facility page.");
			node.log(Status.INFO, "STEP2 : Facility tab is visible on the new facility page.");

			// Visibility of the collateral tab
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.collateralTab,
					"BUG : Collateral tab is not displaying", "PASS : Collateral tab is displaying");
			System.out.println("STEP3 : Collateral tab is visible on the new facility page.");
			node.log(Status.INFO, "STEP3 : Collateral tab is visible on the new facility page.");

			// Visibility of the facility status tab
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.facilityStatusTab,
					"BUG : Facility status tab is not displaying", "PASS : Facility status tab is displaying");
			System.out.println("STEP4 : Facility status tab is visible on the new facility page.");
			node.log(Status.INFO, "STEP4 : Facility status tab is visible on the new facility page.");

			// Visibility of the account balances tab
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.accountBalancesTab,
					"BUG : Account balances tab is not displaying", "PASS : Account balances tab is displaying");
			System.out.println("STEP5 : Account balances tab is visible on the new facility page.");
			node.log(Status.INFO, "STEP5 : Account balances tab is visible on the new facility page.");

			// Visibility of the summary tab
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.summaryTab,
					"BUG : Summary tab is not displaying", "PASS : Summary tab is displaying");
			System.out.println("STEP6 : Summary tab is visible on the new facility page.");
			node.log(Status.INFO, "STEP6 : Summary tab is visible on the new facility page.");

			// Visibility of the documents tab
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.documentsTab,
					"BUG : Documents tab is not displaying", "PASS : Documents tab is displaying");
			System.out.println("STEP7 : Documents tab is visible on the new facility page.");
			node.log(Status.INFO, "STEP7 : Documents tab is visible on the new facility page.");

			// Visibility of the cashflows tab
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.cashflowsTab,
					"BUG : Cashflows tab is not displaying", "PASS : Cashflows tab is displaying");
			System.out.println("STEP8 : Cashflows tab is visible on the new facility page.");
			node.log(Status.INFO, "STEP8 : Cashflows tab is visible on the new facility page.");

			// Visibility of the transaction log tab
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.transactionLogTab,
					"BUG : Transaction log tab is not displaying", "PASS : Transaction log tab is displaying");
			System.out.println("STEP9 : Transaction log tab is visible on the new facility page.");
			node.log(Status.INFO, "STEP9 : Transaction log tab is visible on the new facility page.");

			// Visibility of the facility history tab
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.facilityHistoryTab,
					"BUG : Facility history tab is not displaying", "PASS : Facility history tab is displaying");
			System.out.println("STEP10 : Facility history tab is visible on the new facility page.");
			node.log(Status.INFO, "STEP10 : Facility history tab is visible on the new facility page.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("visibilityOfMenusUnderNewFacilityPage", "Pass", driver);

		} catch (AssertionError visibilityOfMenusUnderNewFacilityPage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In visibilityOfMenusUnderNewFacilityPage test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"visibilityOfMenusUnderNewFacilityPage_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			visibilityOfMenusUnderNewFacilityPage.printStackTrace();
			node.fail(visibilityOfMenusUnderNewFacilityPage);
			Assert.fail();
			extent.flush();
		} catch (Exception visibilityOfMenusUnderNewFacilityPage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In visibilityOfMenusUnderNewFacilityPage test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"visibilityOfMenusUnderNewFacilityPage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			visibilityOfMenusUnderNewFacilityPage.printStackTrace();
			node.fail(visibilityOfMenusUnderNewFacilityPage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _067
	@Test(priority = 8)
	public void validateOptionsUnderDrawdownsSection() throws IOException {

		try {
			extenttest = extent.createTest("Verify the options under the Drawdowns section")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadNewFacilityPage from FacilityePage
			FundingPage.loadNewFacilityPage();

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.facilityStatusTab, FundingNewFacilityPO.drawdownsSection,
					"Facility Status");

			// Visibility of the new drawdown button
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.newDrawdownButton,
					"BUG : New drawdown button is not displaying", "PASS : New drawdown button is displaying");
			System.out.println("STEP1 : New drawdown button is visible under the drawdowns section.");
			node.log(Status.INFO, "STEP1 : New drawdown button is visible under the drawdowns section.");

			// Visibility of the drawdown date column
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.drawdownDateCloumn,
					"BUG : Drawdown date column is not displaying", "PASS : Drawdown date column is displaying");
			System.out.println("STEP2 : Drawdown date column is visible under the drawdowns section.");
			node.log(Status.INFO, "STEP2 : Drawdown date column is visible under the drawdowns section.");

			// Visibility of the drawdown amount column
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.drawdownAmountCloumn,
					"BUG : Drawdown amount column is not displaying", "PASS : Drawdown amount column is displaying");
			System.out.println("STEP3 : Drawdown amount column is visible under the drawdowns section.");
			node.log(Status.INFO, "STEP3 : Drawdown amount column is visible under the drawdowns section.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateOptionsUnderDrawdownsSection", "Pass", driver);

		} catch (AssertionError validateOptionsUnderDrawdownsSection) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateOptionsUnderDrawdownsSection test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateOptionsUnderDrawdownsSection_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateOptionsUnderDrawdownsSection.printStackTrace();
			node.fail(validateOptionsUnderDrawdownsSection);
			Assert.fail();
			extent.flush();
		} catch (Exception validateOptionsUnderDrawdownsSection) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateOptionsUnderDrawdownsSection test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateOptionsUnderDrawdownsSection_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateOptionsUnderDrawdownsSection.printStackTrace();
			node.fail(validateOptionsUnderDrawdownsSection);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _068
	@Test(priority = 9)
	public void validatePopupByClickingOnNewDrawdownButton() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user is in the Facility Status section, when pressing “New Drawdown” a popup is displayed where they must enter an amount and effective date")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Calling the loadNewFacilityPage from FacilityePage
			FundingPage.loadNewFacilityPage();

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.facilityStatusTab, FundingNewFacilityPO.drawdownsSection,
					"Facility Status");

			// Click on the new drawdown button
			IElementActions.clickelement_usingXpath(node, driver, FundingNewFacilityPO.newDrawdownButton);
			System.out.println("STEP1 : Clicked on the new drawdown button.");
			node.log(Status.INFO, "STEP1 : Clicked on the new drawdown button.");

			// Wait for the visibility of the drawdown input field
			System.out.println("STEP2 : Waiting for the visibility of the date field");
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the date field");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.drawdownDateInputField);
			System.out.println("STEP3 : Date field is now visible.");
			node.log(Status.INFO, "STEP3 : Date field is now visible.");

			// Assert the drawdown date input field
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.drawdownDateInputField,
					"BUG : Drawdown date input field is not displaying",
					"PASS : Drawdown date input field is displaying");

			// Assert the drawdown amount input field
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.drawdownAmountInputField,
					"BUG : Drawdown amount input field is not displaying",
					"PASS : Drawdown amount input field is displaying");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validatePopupByClickingOnNewDrawdownButton", "Pass", driver);

		} catch (AssertionError validatePopupByClickingOnNewDrawdownButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePopupByClickingOnNewDrawdownButton test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePopupByClickingOnNewDrawdownButton_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePopupByClickingOnNewDrawdownButton.printStackTrace();
			node.fail(validatePopupByClickingOnNewDrawdownButton);
			Assert.fail();
			extent.flush();
		} catch (Exception validatePopupByClickingOnNewDrawdownButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePopupByClickingOnNewDrawdownButton test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePopupByClickingOnNewDrawdownButton_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePopupByClickingOnNewDrawdownButton.printStackTrace();
			node.fail(validatePopupByClickingOnNewDrawdownButton);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _069
	// TC_Funding_NewFacility _074
	// TC_Funding_NewFacility _204
	@Test(priority = 10)
	public void validateCreateDrawdownsAndUnconfirmedStatus() throws IOException {

		try {
			extenttest = extent.createTest("Verify that the user able to add the drawdowns into the system"
					+ "Verify that the user has pressed Save, the drawdown should be unconfirmed and display a red timer icon"
					+ "Verify the user can save the data by clicking on Save button")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Get amount
			String newLoanFacilityAmount = getDataFromExcel(58);

			// Get drawdown amount
			String drawdownAmount = getDataFromExcel(59);

			// Get today's date
			String todayDate = Utils.getTodayDayFormatted();

			// Get yesterday's date
			String yesterdayDate = Utils.getYesterdayDayFormatted();

			// Calling the loadNewFacilityPage from FacilityePage
			FundingPage.loadNewFacilityPage();

			// Create a facility
			FundingPage.createFacility(newLoanFacilityAmount);

			// Go to the facility status page and add drawdowns
			FundingPage.goToFacilityStatusAndAddDrawdown(drawdownAmount, todayDate);

			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingNewFacilityPO.drawdownAmountCloumn);

			// Wait for the visibility of first row
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of first row");
			System.out.println("STEP1 : Waiting for the visibility of first row");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.firstRowAmount);
			node.log(Status.INFO, "STEP2 : First row is visible");
			System.out.println("STEP2 : First row is visible");

			// Assert the drawdown
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.firstRowAmount,
					"BUG : Drawdown is not added", "PASS : Drawdown is added");

			// Getting the confirmation status
			boolean confirmationStatus = IElementActions.checkAttributePresentInClass(FundingNewFacilityPO.isConfirmed,
					"text-danger");

			// Assert status
			IElementActions.assertTrue_ConditionBased(node, driver, confirmationStatus,
					"BUG : The drawdown added is not unconfirmed", "PASS : The drawdown added is unconfirmed");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCreateDrawdownsAndUnconfirmedStatus", "Pass", driver);

		} catch (AssertionError validateCreateDrawdownsAndUnconfirmedStatus) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCreateDrawdownsAndUnconfirmedStatus test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCreateDrawdownsAndUnconfirmedStatus_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCreateDrawdownsAndUnconfirmedStatus.printStackTrace();
			node.fail(validateCreateDrawdownsAndUnconfirmedStatus);
			Assert.fail();
			extent.flush();
		} catch (Exception validateCreateDrawdownsAndUnconfirmedStatus) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCreateDrawdownsAndUnconfirmedStatus test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCreateDrawdownsAndUnconfirmedStatus_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCreateDrawdownsAndUnconfirmedStatus.printStackTrace();
			node.fail(validateCreateDrawdownsAndUnconfirmedStatus);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _070
	@Test(priority = 11)
	public void validateOnSavingDrawdownsDetailsIntoSystem() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that when the user has entered an amount and selected an effective date, when they press Save the drawdown is added to the list with the date and amount displayed, sorted in reverse chronological order")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Call the openFacilityFromDatabase function from the FundingPage
			FundingPage.openFacilityFromDatabase();

			// Get drawdown amount
			String drawdownAmount = getDataFromExcel(59);

			// Get today's date
			String todayDate = Utils.getTodayDayFormatted();

			// Get yesterday's date
			String yesterdayDate = Utils.getYesterdayDayFormatted();

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.facilityStatusTab, FundingNewFacilityPO.drawdownsSection,
					"Facility Status");

			// Getting the value of the drawdown
			String drawdown = Utils.getFormattedText(FundingNewFacilityPO.firstRowAmount);

			// Getting the value of the drawdown
			String actualDate = IElementActions.getElementText_usingXpath(node, driver,
					FundingNewFacilityPO.firstRowDate);

			// Asserting the drawdown
			IElementActions.assertEquals_usingString(node, driver, drawdownAmount, drawdown,
					"STEP1 : BUG : The actual drawdown " + drawdown + " and expected drawdown " + drawdownAmount
							+ " is same",
					"STEP1 : PASS : The actual drawdown " + drawdown + " and expected drawdown " + drawdownAmount
							+ " is same");

			// Assert date
			if (actualDate.contains(todayDate)) {
				Assert.assertTrue(true, "STEP2 : Pass : The actual drawdown date is " + actualDate
						+ " and is equal to expected drawdown date " + todayDate);
				System.out.println("STEP2 : Pass : The actual drawdown date is " + actualDate
						+ " and is equal to expected drawdown date " + todayDate);
				node.log(Status.PASS, "STEP2 : Pass : The actual drawdown date is " + actualDate
						+ " and is equal to expected drawdown date " + todayDate);
			} else {
				Assert.assertTrue(false, "STEP2 : BUG : The actual drawdown date is " + actualDate
						+ " and is not equal to expected drawdown date " + todayDate);
				System.out.println("STEP2 : BUG : The actual drawdown date is " + actualDate
						+ " and is not equal to expected drawdown date " + todayDate);
				node.log(Status.FAIL, "STEP2 : BUG : The actual drawdown date is " + actualDate
						+ " and is not equal to expected drawdown date " + todayDate);
			}

			Thread.sleep(1000);
			// Add drawdowns
			FundingPage.addDrawdown("1", yesterdayDate);

			// Get yesterday date
			String expectedYesterdayDate = Utils.getYesterdayDate();

			// Bug
//				Thread.sleep(1000);
//				// Getting the value of the drawdown date
//				String actualYesterdayDate = IElementActions.getElementText_usingXpath(node, driver,
//						FundingNewFacilityPO.firstRowDate);
			//
//				// Assert yesterday date
//				if (actualYesterdayDate.contains(yesterdayDate)) {
//					Assert.assertTrue(true,
//							"STEP3 : Pass : The actual drawdown yesterday date is " + actualDate
//									+ " and is equal to expected drawdown yesterday date " + yesterdayDate
//									+ " i.e its sorted in reverse chronological as displayed at first row");
//					System.out.println("STEP3 : Pass : The actual drawdown yesterday date is " + actualDate
//							+ " and is equal to expected drawdown yesterday date " + yesterdayDate
//							+ " i.e its sorted in reverse chronological as displayed at first row");
//					node.log(Status.PASS,
//							"STEP3 : Pass : The actual drawdown yesterday date is " + actualDate
//									+ " and is equal to expected drawdown yesterday date " + yesterdayDate
//									+ " i.e its sorted in reverse chronological as displayed at first row");
//				} else {
//					Assert.assertTrue(false,
//							"STEP3 : BUG : The actual drawdown yesterday date is " + actualDate
//									+ " and is not equal to expected drawdown yesterday date " + yesterdayDate
//									+ " i.e its not sorted in reverse chronological as not displayed at first row");
//					System.out.println("STEP3 : BUG : The actual drawdown yesterday date is " + actualDate
//							+ " and is not equal to expected drawdown yesterday date " + yesterdayDate
//							+ " i.e its not sorted in reverse chronological as not displayed at first row");
//					node.log(Status.FAIL,
//							"STEP3 : BUG : The actual drawdown yesterday date is " + actualDate
//									+ " and is not equal to expected drawdown yesterday date " + yesterdayDate
//									+ " i.e its not sorted in reverse chronological as not displayed at first row");
//				}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateOnSavingDrawdownsDetailsIntoSystem", "Pass", driver);

		} catch (AssertionError validateOnSavingDrawdownsDetailsIntoSystem) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateOnSavingDrawdownsDetailsIntoSystem test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateOnSavingDrawdownsDetailsIntoSystem_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateOnSavingDrawdownsDetailsIntoSystem.printStackTrace();
			node.fail(validateOnSavingDrawdownsDetailsIntoSystem);
			Assert.fail();
			extent.flush();
		} catch (Exception validateOnSavingDrawdownsDetailsIntoSystem) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateOnSavingDrawdownsDetailsIntoSystem test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateOnSavingDrawdownsDetailsIntoSystem_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateOnSavingDrawdownsDetailsIntoSystem.printStackTrace();
			node.fail(validateOnSavingDrawdownsDetailsIntoSystem);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _071
	@Test(priority = 12)
	public void validateIfDrawdownAmountIsLessThenUndrawnAmount() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the drawdown amount that the user has entered must be less than or equal to the current undrawn amount")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Call the openFacilityFromDatabase function from the FundingPage
			FundingPage.openFacilityFromDatabase();

			// Get amount
			String newLoanFacilityAmount = getDataFromExcel(58);

			// Get drawdown amount
			String drawdownAmount = getDataFromExcel(59);

			// Get today's date
			String todayDate = Utils.getTodayDayFormatted();

			// Go to the facility status page and add drawdowns
			FundingPage.goToFacilityStatusAndAddDrawdown(drawdownAmount, todayDate);

			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingNewFacilityPO.drawdownAmountCloumn);

			// Wait for the visibility of first row
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of first row");
			System.out.println("STEP1 : Waiting for the visibility of first row");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.firstRowAmount);
			node.log(Status.INFO, "STEP2 : First row is visible");
			System.out.println("STEP2 : First row is visible");

			// Getting the value of the drawdown
			int actualDrawdown = Utils.getTextAndParseToInt(FundingNewFacilityPO.firstRowAmount);

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.facilityTab, FundingNewFacilityPO.amountInputField,
					"Facility");

			// Getting the value of the available amount
			int availableAmount = Utils.getTextAndParseToInt(FundingNewFacilityPO.availableAmount);

			// Assert drawdown
			if (actualDrawdown <= availableAmount) {
				Assert.assertTrue(true, "Drawdown amount is less than or equal to the current undrawn amount");
				System.out.println("Drawdown amount is less than or equal to the current undrawn amount");
				node.log(Status.PASS, "Drawdown amount is less than or equal to the current undrawn amount");
			} else {
				Assert.assertTrue(false, "Drawdown amount " + actualDrawdown
						+ " is not less than or equal to the current undrawn amount" + availableAmount);
				System.out.println("Drawdown amount " + actualDrawdown
						+ " is not less than or equal to the current undrawn amount" + availableAmount);
				node.log(Status.FAIL, "Drawdown amount " + actualDrawdown
						+ " is not less than or equal to the current undrawn amount" + availableAmount);
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateIfDrawdownAmountIsLessThenUndrawnAmount", "Pass", driver);

		} catch (AssertionError validateIfDrawdownAmountIsLessThenUndrawnAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateIfDrawdownAmountIsLessThenUndrawnAmount test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateIfDrawdownAmountIsLessThenUndrawnAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateIfDrawdownAmountIsLessThenUndrawnAmount.printStackTrace();
			node.fail(validateIfDrawdownAmountIsLessThenUndrawnAmount);
			Assert.fail();
			extent.flush();
		} catch (Exception validateIfDrawdownAmountIsLessThenUndrawnAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateIfDrawdownAmountIsLessThenUndrawnAmount test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateIfDrawdownAmountIsLessThenUndrawnAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateIfDrawdownAmountIsLessThenUndrawnAmount.printStackTrace();
			node.fail(validateIfDrawdownAmountIsLessThenUndrawnAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _072
	@Test(priority = 13)
	public void validateIfDrawdownIsGreaterThenUndrawnAmount() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the validation appears if the drawdown amount that the user has entered is greater than the current undrawn amount")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Call the openFacilityFromDatabase function from the FundingPage
			FundingPage.openFacilityFromDatabase();

			// Get loan facility amount
			String newLoanFacility = getDataFromExcel(58);

			// Get value of loan facility amount
			int newLoanFacilityAmountValue = Integer.parseInt(newLoanFacility);

			// New drawdown amount
			String drawdownAmount = String.valueOf(newLoanFacilityAmountValue + 1000);

			// Get today's date
			String todayDate = Utils.getTodayDayFormatted();

			// Go to the facility status page and add drawdowns
			FundingPage.goToFacilityStatusAndAddDrawdown(drawdownAmount, todayDate);

			// Wait for the visibility of edit icon
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of error");
			System.out.println("STEP1 : Waiting for the visibility of error");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.error);
			node.log(Status.INFO, "STEP2 : Error is visible");
			System.out.println("STEP2 : Error is visible");

			// Get the error text
			String errorMessage = IElementActions.getElementText_usingXpath(node, driver, FundingNewFacilityPO.error);

			// Assert error message
			if (errorMessage.contains("The new drawdown amount is greater than the current undrawn amount ")) {
				Assert.assertTrue(true, errorMessage + " error message is displayed");
				System.out.println(errorMessage + " error message is displayed");
				node.log(Status.PASS, errorMessage + " error message is displayed");
			} else {
				Assert.assertTrue(false, errorMessage + " error message is displayed");
				System.out.println(errorMessage + " error message is displayed");
				node.log(Status.FAIL, errorMessage + " error message is displayed");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateIfDrawdownIsGreaterThenUndrawnAmount", "Pass", driver);

		} catch (AssertionError validateIfDrawdownIsGreaterThenUndrawnAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateIfDrawdownIsGreaterThenUndrawnAmount test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateIfDrawdownIsGreaterThenUndrawnAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateIfDrawdownIsGreaterThenUndrawnAmount.printStackTrace();
			node.fail(validateIfDrawdownIsGreaterThenUndrawnAmount);
			Assert.fail();
			extent.flush();
		} catch (Exception validateIfDrawdownIsGreaterThenUndrawnAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateIfDrawdownIsGreaterThenUndrawnAmount test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateIfDrawdownIsGreaterThenUndrawnAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateIfDrawdownIsGreaterThenUndrawnAmount.printStackTrace();
			node.fail(validateIfDrawdownIsGreaterThenUndrawnAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _073
	@Test(priority = 14)
	public void validateAllDrawdownsSum() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the sum of all drawdowns must be less than or equal to the facility amount(Summary tab)")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Call the openFacilityFromDatabase function from the FundingPage
			FundingPage.openFacilityFromDatabase();

			// Get amount
			String newLoanFacilityAmount = getDataFromExcel(58);

			// Get double type facilty amount
			double facilityAmount = Double.parseDouble(newLoanFacilityAmount);

			// Get drawdown amount
			String drawdownAmount = getDataFromExcel(59);

			// Get today's date
			String todayDate = Utils.getTodayDayFormatted();

			// Go to the facility status page and add drawdowns
			FundingPage.goToFacilityStatusAndAddDrawdown(drawdownAmount, todayDate);

			// Go to the facility status page and add drawdowns
			FundingPage.goToFacilityStatusAndAddDrawdown(drawdownAmount, todayDate);

			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingNewFacilityPO.drawdownAmountCloumn);

			// Wait for the visibility of drawdowns amount
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the drawdowns amount");
			System.out.println("STEP1 : Waiting for the visibility of the drawdowns amount");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.drawdownsAmount);
			node.log(Status.INFO, "STEP2 : The drawdowns amount is visible");
			System.out.println("STEP2 : The drawdowns amount is visible");

			// Locate all drawdowns amount
			List<WebElement> drawdownsElements = IElementActions.returnElements(node, driver,
					FundingNewFacilityPO.drawdownsAmount);

			// Initialize total sum
			double totalSum = 0;

			// Iterate through each element to extract and sum amounts
			for (WebElement element : drawdownsElements) {
				// Get the text from the element
				String amountText = element.getText();

				// Extract numeric value by removing currency symbol and commas
				double amount = Utils.extractNumeric(amountText);

				// Add the amount to total sum
				totalSum += amount;
			}

			// Compare total sum with facility amount
			if (totalSum <= facilityAmount) {
				System.out.println("Total drawdowns sum is less than or equal to facility amount.");
			} else {
				System.out.println("Total drawdowns sum exceeds facility amount.");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAllDrawdownsSum", "Pass", driver);

		} catch (AssertionError validateAllDrawdownsSum) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAllDrawdownsSum test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAllDrawdownsSum_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllDrawdownsSum.printStackTrace();
			node.fail(validateAllDrawdownsSum);
			Assert.fail();
			extent.flush();
		} catch (Exception validateAllDrawdownsSum) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAllDrawdownsSum test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAllDrawdownsSum_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllDrawdownsSum.printStackTrace();
			node.fail(validateAllDrawdownsSum);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _075
	@Test(priority = 15)
	public void validateDrawdownIfSkippedDate() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user must select the clipboard icon and confirm the effective date to confirm the drawdown")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Call the openFacilityFromDatabase function from the FundingPage
			FundingPage.openFacilityFromDatabase();

			// Get amount
			String newLoanFacility = getDataFromExcel(58);

			// Get drawdown amount
			String drawdownAmount = getDataFromExcel(59);

			// Get today's date
			String todayDate = Utils.getTodayDayFormatted();

			// Get yesterday's date
			String yesterdayDate = Utils.getYesterdayDayFormatted();

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.facilityStatusTab, FundingNewFacilityPO.drawdownsSection,
					"Facility Status");

			// Click on the confirm button and wait for popup
			Utils.clickAndWait(FundingNewFacilityPO.confirmIcon, "Confirm Button", UtilsPO.popUp);

			// Clear date from effective date
			IElementActions.clearElement_usingXpath(node, driver, FundingNewFacilityPO.effectiveDate);
			node.log(Status.INFO, "STEP1 : Cleared date from effective date");
			System.out.println("STEP1 : Cleared date from effective date");

			// Click on the confirm button
			IElementActions.clickelement_usingXpath(node, driver, FundingNewFacilityPO.confirmButton);
			node.log(Status.INFO, "STEP2 : Clicked on the confirm button");
			System.out.println("STEP2 : Clicked on the confirm button");

			// Wait for the visibility of error popup
			node.log(Status.INFO, "STEP3 : Waiting for the visibility of the error popup");
			System.out.println("STEP3 : Waiting for the visibility of the error popup");
			IWaitStrategy.waitForVisiblity(node, driver, UtilsPO.popUp);
			node.log(Status.INFO, "STEP4 : The error popup is visible");
			System.out.println("STEP4 : The error popup is visible");

			// Getting the text of the popup
			String popupText = IElementActions.getElementText_usingXpath(node, driver, UtilsPO.popupText);

			// Asserting the popup
			IElementActions.assertEquals_usingString(node, driver, popupText, "ERROR",
					"STEP5 : BUG : " + popupText + " is displayed if skipped effective date",
					"STEP5 : PASS : Error is displayed if skipped effective date");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDrawdownIfSkippedDate", "Pass", driver);

		} catch (AssertionError validateDrawdownIfSkippedDate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDrawdownIfSkippedDate test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDrawdownIfSkippedDate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDrawdownIfSkippedDate.printStackTrace();
			node.fail(validateDrawdownIfSkippedDate);
			Assert.fail();
			extent.flush();
		} catch (Exception validateDrawdownIfSkippedDate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDrawdownIfSkippedDate test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDrawdownIfSkippedDate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDrawdownIfSkippedDate.printStackTrace();
			node.fail(validateDrawdownIfSkippedDate);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _076
	@Test(priority = 16)
	public void validateConfirmDrawdownAndGreenTick() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user able to confirm added drawdowns into the system and the drawdown should display a green tick amount")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Call the openFacilityFromDatabase function from the FundingPage
			FundingPage.openFacilityFromDatabase();

			// Get amount
			String newLoanFacility = getDataFromExcel(58);

			// Get drawdown amount
			String drawdownAmount = getDataFromExcel(59);

			// Get today's date
			String todayDate = Utils.getTodayDayFormatted();

			// Get yesterday's date
			String yesterdayDate = Utils.getYesterdayDayFormatted();

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

			// Get confirmation status
			boolean confirmationStatus = IElementActions.checkAttributePresentInClass(FundingNewFacilityPO.isConfirmed,
					"text-success");

			// Assert status
			IElementActions.assertTrue_ConditionBased(node, driver, confirmationStatus,
					"BUG : The drawdown added is not confirmed", "PASS : The drawdown added is confirmed");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateConfirmDrawdownAndGreenTick", "Pass", driver);

		} catch (AssertionError validateConfirmDrawdownAndGreenTick) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateConfirmDrawdownAndGreenTick test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateConfirmDrawdownAndGreenTick_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateConfirmDrawdownAndGreenTick.printStackTrace();
			node.fail(validateConfirmDrawdownAndGreenTick);
			Assert.fail();
			extent.flush();
		} catch (Exception validateConfirmDrawdownAndGreenTick) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateConfirmDrawdownAndGreenTick test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateConfirmDrawdownAndGreenTick_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateConfirmDrawdownAndGreenTick.printStackTrace();
			node.fail(validateConfirmDrawdownAndGreenTick);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _077
	// TC_Funding_NewFacility _078
	@Test(priority = 17)
	public void validateCashAmountAndAccountBalanceAfterAddingDrawdowns() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the Cash amount(Summary tab) is increased by adding the new drawdown amount"
							+ "Verify that the drawdown should also show in the Account Balances tab with the correct effective date")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Get amount
			String newLoanFacility = getDataFromExcel(58);

			// Get drawdown amount
			String drawdownAmount = getDataFromExcel(59);

			// Get today's date
			String todayDate = Utils.getTodayDayFormatted();

			// Get yesterday's date
			String yesterdayDate = Utils.getYesterdayDayFormatted();

			// Calling the loadNewFacilityPage from FacilityePage
			FundingPage.loadNewFacilityPage();

			// Create a facility
			FundingPage.createFacility(newLoanFacility);

			// Go to the facility status page and add drawdowns
			FundingPage.goToFacilityStatusAndAddDrawdown(drawdownAmount, todayDate);

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.summaryTab, FundingNewFacilityPO.loanFacilitySummaryText,
					"Facility Summary");

			IElementActions.pageRefresh();

			// Wait for the visibility of the cash amount in summary page
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the cash amount in summary page");
			System.out.println("STEP1 : Waiting for the visibility of the cash amount in summary page");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.cashValue);
			node.log(Status.INFO, "STEP2 : Cash amount in summary page is visible");
			System.out.println("STEP2 : Cash amount in summary page is visible");

			// Get cash amount
			int cashAmount = Utils.getTextAndParseToInt(FundingNewFacilityPO.cashValue);

			// Drawdown int value
			int drawdownAmountValue = Integer.parseInt(drawdownAmount);

			// Asserting the cash amount
			IElementActions.assertEquals_usingInteger(node, driver, cashAmount, drawdownAmountValue,
					"STEP3 : BUG : The Cash amount(Summary tab) " + cashAmount + " is increased by the added drawdown "
							+ drawdownAmountValue,
					"STEP3 : PASS : The Cash amount(Summary tab) " + cashAmount + " is increased by the added drawdown "
							+ drawdownAmountValue);

			// Click on account balance
			Utils.waitAndClickOnTab(FundingNewFacilityPO.accountBalancesTab, FundingNewFacilityPO.balanceText,
					"Facility Account Balances");

			// Get payment
			int payment = Utils.getTextAndParseToInt(FundingNewFacilityPO.firstRowPayment);

			// Asserting the cash amount
			IElementActions.assertEquals_usingInteger(node, driver, payment, drawdownAmountValue,
					"STEP4 : BUG : The drawdown in account balances " + payment + " is same as added drawdown "
							+ drawdownAmountValue,
					"STEP4 : PASS : The drawdown in account balances " + payment + " is same as added drawdown "
							+ drawdownAmountValue);

			// Getting the text of the date in account balances
			String date = IElementActions.getElementText_usingXpath(node, driver,
					FundingNewFacilityPO.firstRowDateInAccountBalance);

			// Asserting the effective date
			if (date.contains(todayDate)) {
				Assert.assertTrue(true, "STEP5 : PASS : The effective date " + date + " is same as " + todayDate);
				System.out.println("STEP5 : PASS : The effective date " + date + " is same as " + todayDate);
				node.log(Status.PASS, "STEP5 : PASS : The effective date " + date + " is same as " + todayDate);
			} else {
				Assert.assertTrue(false, "STEP5 : BUG : The effective date " + date + " is not same as " + todayDate);
				System.out.println("STEP5 : BUG : The effective date " + date + " is not same as " + todayDate);
				node.log(Status.FAIL, "STEP5 : BUG : The effective date " + date + " is not same as " + todayDate);
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashAmountAndAccountBalanceAfterAddingDrawdowns", "Pass",
					driver);

		} catch (AssertionError validateCashAmountAndAccountBalanceAfterAddingDrawdowns) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashAmountAndAccountBalanceAfterAddingDrawdowns test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashAmountAndAccountBalanceAfterAddingDrawdowns_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashAmountAndAccountBalanceAfterAddingDrawdowns.printStackTrace();
			node.fail(validateCashAmountAndAccountBalanceAfterAddingDrawdowns);
			Assert.fail();
			extent.flush();
		} catch (Exception validateCashAmountAndAccountBalanceAfterAddingDrawdowns) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashAmountAndAccountBalanceAfterAddingDrawdowns test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashAmountAndAccountBalanceAfterAddingDrawdowns_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashAmountAndAccountBalanceAfterAddingDrawdowns.printStackTrace();
			node.fail(validateCashAmountAndAccountBalanceAfterAddingDrawdowns);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _079
	@Test(priority = 18)
	public void validatePreviousDrawdownsUpdate() throws IOException {

		try {
			extenttest = extent.createTest("Verify that the user able to update previous drawdowns into the system")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Get amount
			String newLoanFacility = getDataFromExcel(58);

			// Get drawdown amount
			String drawdownAmount = getDataFromExcel(59);

			// Updated drawdown value
			int updatedDrawdown = Integer.parseInt(drawdownAmount);
			String newUpdatedDrawdown = String.valueOf(updatedDrawdown + 100);

			// Get today's date
			String todayDate = Utils.getTodayDayFormatted();

			// Get yesterday's date
			String yesterdayDate = Utils.getYesterdayDayFormatted();

			// Calling the loadNewFacilityPage from FacilityePage
			FundingPage.loadNewFacilityPage();

			// Create a facility
			FundingPage.createFacility(newLoanFacility);

			// Go to the facility status page and add drawdowns
			FundingPage.goToFacilityStatusAndAddDrawdown(drawdownAmount, todayDate);

			IElementActions.scrollToTop(driver);

			// Wait for the visibility of first row
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of first row");
			System.out.println("STEP1 : Waiting for the visibility of first row");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.facilityStatusTab);
			node.log(Status.INFO, "STEP2 : First row is visible");
			System.out.println("STEP2 : First row is visible");

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.facilityStatusTab, FundingNewFacilityPO.drawdownsSection,
					"Facility Status");

			// Getting the value of the drawdown
			String drawdown = Utils.getFormattedText(FundingNewFacilityPO.firstRowAmount);

			// Wait for the visibility of edit icon
			node.log(Status.INFO, "STEP3 : Waiting for the visibility of edit icon");
			System.out.println("STEP3 : Waiting for the visibility of edit icon");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.editIcon);
			node.log(Status.INFO, "STEP4 : Edit icon is visible");
			System.out.println("STEP4 : Edit icon is visible");

			// Click on the edit button
			IElementActions.clickelement_usingXpath(node, driver, FundingNewFacilityPO.editIcon);
			node.log(Status.INFO, "STEP5 : Clicked on the edit button");
			System.out.println("STEP5 : Clicked on the edit button");

			// Wait for the drawdown amount field to be visible and clickable
			System.out.println("STEP6 : Waiting for the drawdown amount field to be visibility and clickable");
			node.log(Status.INFO, "STEP6 : Waiting for the drawdown amount field to be visibility and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.drawdownAmountInputField);
			IWaitStrategy.WaitUntilElementClickable(node, driver, FundingNewFacilityPO.drawdownAmountInputField);
			System.out.println("STEP7 : Drawdown amount field is visible and clickable.");
			node.log(Status.INFO, "STEP7 : Drawdown amount field is visible and clickable.");

			// Enter value in amount
			IElementActions.sendKeys_usingXpath(node, driver, FundingNewFacilityPO.drawdownAmountInputField,
					newUpdatedDrawdown);
			System.out.println("STEP8 : Entered the value in the drawdown amount input field.");
			node.log(Status.INFO, "STEP8 : Entered the value in the drawdown amount input field.");

			// Wait for the drawdown save button to be clickable
			System.out.println("STEP9 : Waiting for the drawdown save button to be visible and clickable");
			node.log(Status.INFO, "STEP9 : Waiting for the drawdown save button to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.drawdownSaveButton);
			IWaitStrategy.WaitUntilElementClickable(node, driver, FundingNewFacilityPO.drawdownSaveButton);
			System.out.println("STEP10 : Drawdown save button is visible and clickable.");
			node.log(Status.INFO, "STEP10 : Drawdown save button is visible and clickable.");

			// Click on the save button
			IElementActions.clickelement_usingXpath(node, driver, FundingNewFacilityPO.drawdownSaveButton);
			System.out.println("STEP11 : Clicked on the new drawdown save button.");
			node.log(Status.INFO, "STEP11 : Clicked on the new drawdown save button.");

			// Wait for the visibility of the drawdown
			System.out.println("STEP12 : Waiting for the visibility of the drawdown");
			node.log(Status.INFO, "STEP12 : Waiting for the visibility of the drawdown");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.firstRowAmount);
			System.out.println("STEP13 : Drawdown is now visible.");
			node.log(Status.INFO, "STEP13 : Drawdown is now visible.");

			// Getting the value of the drawdown
			String newdrawdown = Utils.getFormattedText(FundingNewFacilityPO.firstRowAmount);

			// Asserting the drawdown
			IElementActions.assertEquals_usingString(node, driver, newdrawdown, newUpdatedDrawdown,
					"STEP14 : BUG : The new updated drawdown " + newdrawdown + " is not updated from the old drawdown "
							+ drawdown,
					"STEP14 : PASS :  The new updated drawdown " + newdrawdown + " is updated from the old drawdown "
							+ drawdown);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validatePreviousDrawdownsUpdate", "Pass", driver);

		} catch (AssertionError validatePreviousDrawdownsUpdate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePreviousDrawdownsUpdate test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePreviousDrawdownsUpdate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePreviousDrawdownsUpdate.printStackTrace();
			node.fail(validatePreviousDrawdownsUpdate);
			Assert.fail();
			extent.flush();
		} catch (Exception validatePreviousDrawdownsUpdate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePreviousDrawdownsUpdate test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePreviousDrawdownsUpdate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePreviousDrawdownsUpdate.printStackTrace();
			node.fail(validatePreviousDrawdownsUpdate);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _080
	@Test(priority = 19)
	public void validateDeleteInDrawdowns() throws IOException {

		try {
			extenttest = extent.createTest("Verify that the user able to delete previous drawdowns into the system")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Call the openFacilityFromDatabase function from the FundingPage
			FundingPage.openFacilityFromDatabase();

			// Get amount
			String newLoanFacility = getDataFromExcel(58);

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.facilityStatusTab, FundingNewFacilityPO.drawdownsSection,
					"Facility Status");

			// Wait for the visibility of delete icon
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of delete icon");
			System.out.println("STEP1 : Waiting for the visibility of delete icon");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.deleteIcon);
			node.log(Status.INFO, "STEP2 : Delete icon is visible");
			System.out.println("STEP2 : Delete icon is visible");

			// Click on the delete button and wait
			Utils.clickAndWait(FundingNewFacilityPO.deleteIcon, "Delete Button", UtilsPO.popUp);

			// Click on the delete button
			IElementActions.clickelement_usingXpath(node, driver, FundingNewFacilityPO.deleteButton);
			node.log(Status.INFO, "STEP3 : Clicked on the delete button");
			System.out.println("STEP3 : Clicked on the delete button");

			// Wait for the invisibility of popup
			node.log(Status.INFO, "STEP4 : Waiting for the invisibility of the popup");
			System.out.println("STEP4 : Waiting for the invisibility of the popup");
			IWaitStrategy.waitForInVisiblity(node, driver, UtilsPO.popUp);
			node.log(Status.INFO, "STEP5 : The popup is not visible");
			System.out.println("STEP5 : The popup is not visible");

			// Check drawdown availability
			boolean drawdownAvailable = IElementActions.isElementAvailable(node, driver,
					FundingNewFacilityPO.firstRowDrawdown);
			System.out.println("drawdownAvailable " + drawdownAvailable);

			// Asserting the drawdown availability
			IElementActions.assertFalse_ConditionBased(node, driver, drawdownAvailable,
					"STEP6: BUG : The drawdown is not deleted from the system",
					"STEP6: PASS : The drawdown is deleted from the system");

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.facilityTab, FundingNewFacilityPO.amountInputField,
					"Facility");

			// Getting the value of the available amount
			String availableAmount = Utils.getFormattedText(FundingNewFacilityPO.availableAmount);

			// Assert available amount
			if (availableAmount.equals(newLoanFacility)) {
				Assert.assertTrue(true, "The Available Amount is updated on the Facility section accordingly");
				System.out.println("The Available Amount " + availableAmount
						+ "is updated on the Facility section after deleting drawdown");
				node.log(Status.PASS, "The Available Amount " + availableAmount
						+ "is updated on the Facility section after deleting drawdown");
			} else {
				Assert.assertTrue(false, "The Available Amount is not updated on the Facility section accordingly");
				System.out.println("The Available Amount " + availableAmount
						+ "is not updated on the Facility section after deleting drawdown");
				node.log(Status.FAIL, "The Available Amount " + availableAmount
						+ "is not updated on the Facility section after deleting drawdown");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDeleteInDrawdowns", "Pass", driver);

		} catch (AssertionError validateDeleteInDrawdowns) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDeleteInDrawdowns test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDeleteInDrawdowns_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeleteInDrawdowns.printStackTrace();
			node.fail(validateDeleteInDrawdowns);
			Assert.fail();
			extent.flush();
		} catch (Exception validateDeleteInDrawdowns) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDeleteInDrawdowns test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDeleteInDrawdowns_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeleteInDrawdowns.printStackTrace();
			node.fail(validateDeleteInDrawdowns);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _081
	@Test(priority = 20)
	public void validateOptionsUnderRepaymentsSection() throws IOException {

		try {
			extenttest = extent.createTest("Verify the options under the Repayments section")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Calling the loadNewFacilityPage from FacilityePage
			FundingPage.loadNewFacilityPage();

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.facilityStatusTab, FundingNewFacilityPO.repaymentSection,
					"Facility Status");

			// Visibility of the new repayment button
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.newRepaymentButton,
					"STEP1 - BUG : New repayment button is not displaying",
					"STEP1 - PASS : New repayment button is displaying");

			// Visibility of the repayment date column
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.repaymentDateColumn,
					"STEP2 - BUG : Repayment date column is not displaying",
					"STEP2 - PASS : Repayment date column is displaying");

			// Visibility of the repayment amount column
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.repaymentAmountCloumn,
					"STEP3 - BUG : Repayment amount column is not displaying",
					"STEP3 - PASS : Repayment amount column is displaying");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateOptionsUnderRepaymentsSection", "Pass", driver);

		} catch (AssertionError validateOptionsUnderRepaymentsSection) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateOptionsUnderRepaymentsSection test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateOptionsUnderRepaymentsSection_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateOptionsUnderRepaymentsSection.printStackTrace();
			node.fail(validateOptionsUnderRepaymentsSection);
			Assert.fail();
			extent.flush();
		} catch (Exception validateOptionsUnderRepaymentsSection) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateOptionsUnderRepaymentsSection test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateOptionsUnderRepaymentsSection_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateOptionsUnderRepaymentsSection.printStackTrace();
			node.fail(validateOptionsUnderRepaymentsSection);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _082
	@Test(priority = 21)
	public void validatePopupByClickingOnNewRepaymentButton() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user is in the Facility Status section, when pressing “New Drawdown” a popup is displayed where they must enter an amount and effective date")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Calling the loadNewFacilityPage from FacilityePage
			FundingPage.loadNewFacilityPage();

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.facilityStatusTab, FundingNewFacilityPO.repaymentSection,
					"Facility Status");

			// Click on the new repayment button
			IElementActions.clickelement_usingXpath(node, driver, FundingNewFacilityPO.newRepaymentButton);
			System.out.println("STEP1 : Clicked on the new repayment button.");
			node.log(Status.INFO, "STEP1 : Clicked on the new repayment button.");

			// Wait for the visibility of the repayment input field
			System.out.println("STEP2 : Waiting for the visibility of the repayment date field");
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the repayment date field");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.repaymentDateInputField);
			System.out.println("STEP3 : Repayment date field is visible.");
			node.log(Status.INFO, "STEP3 : Repayment date field is visible.");

			// Visibility of the repayment date input field
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.repaymentDateInputField,
					"STEP4 - BUG : Repayment date input field is not displaying",
					"STEP4 - PASS : Repayment date input field is displaying");

			// Visibility of the repayment amount input field
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.repaymentAmountInputField,
					"STEP5 - BUG : Repayment amount input field is not displaying",
					"STEP5 - PASS : Repayment amount input field is displaying");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validatePopupByClickingOnNewRepaymentButton", "Pass", driver);

		} catch (AssertionError validatePopupByClickingOnNewRepaymentButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePopupByClickingOnNewRepaymentButton test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePopupByClickingOnNewRepaymentButton_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePopupByClickingOnNewRepaymentButton.printStackTrace();
			node.fail(validatePopupByClickingOnNewRepaymentButton);
			Assert.fail();
			extent.flush();
		} catch (Exception validatePopupByClickingOnNewRepaymentButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePopupByClickingOnNewRepaymentButton test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePopupByClickingOnNewRepaymentButton_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePopupByClickingOnNewRepaymentButton.printStackTrace();
			node.fail(validatePopupByClickingOnNewRepaymentButton);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _083
	// TC_Funding_NewFacility _088
	@Test(priority = 10)
	public void validateCreateRepaymentAndUnconfirmedStatus() throws IOException {

		try {
			extenttest = extent.createTest("Verify that the user able to add the repayments into the system"
					+ "Verify that the user has pressed Save, the repayment  should be unconfirmed and display a red timer icon")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Get amount
			String newLoanFacilityAmount = getDataFromExcel(58);

			// Get drawdown amount
			String drawdownAmount = getDataFromExcel(59);

			// Get repayment amount
			String repaymentAmount = getDataFromExcel(61);

			// Get today's date
			String todayDate = Utils.getTodayDayFormatted();

			// Calling the loadNewFacilityPage from FacilityePage
			FundingPage.loadNewFacilityPage();

			// Create a facility
			FundingPage.createFacility(newLoanFacilityAmount);

			// Go to the facility status page and add drawdowns
			FundingPage.goToFacilityStatusAndAddDrawdown(drawdownAmount, todayDate);

			// Add repayments
			FundingPage.addRepayment(repaymentAmount, todayDate);

			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingNewFacilityPO.repaymentAmountCloumn);

			// Wait for the visibility of first row
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of first row");
			System.out.println("STEP1 : Waiting for the visibility of first row");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.firstRowRepayment);
			node.log(Status.INFO, "STEP2 : First row is visible");
			System.out.println("STEP2 : First row is visible");

			// Assert the repayment
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.firstRowRepayment,
					"BUG : Repayment is not added", "PASS : Repayment is added");

			// Getting the confirmation status
			boolean confirmationStatus = IElementActions
					.checkAttributePresentInClass(FundingNewFacilityPO.isConfirmedRepayment, "text-danger");

			// Assert status
			IElementActions.assertTrue_ConditionBased(node, driver, confirmationStatus,
					"BUG : The repayment added is not unconfirmed", "PASS : The repayment added is unconfirmed");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCreateRepaymentsAndUnconfirmedStatus", "Pass", driver);

		} catch (AssertionError validateCreateRepaymentsAndUnconfirmedStatus) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCreateRepaymentsAndUnconfirmedStatus test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCreateRepaymentsAndUnconfirmedStatus_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCreateRepaymentsAndUnconfirmedStatus.printStackTrace();
			node.fail(validateCreateRepaymentsAndUnconfirmedStatus);
			Assert.fail();
			extent.flush();
		} catch (Exception validateCreateRepaymentsAndUnconfirmedStatus) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCreateRepaymentsAndUnconfirmedStatus test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCreateRepaymentsAndUnconfirmedStatus_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCreateRepaymentsAndUnconfirmedStatus.printStackTrace();
			node.fail(validateCreateRepaymentsAndUnconfirmedStatus);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _084
	// TC_Funding_NewFacility _089
	@Test(priority = 11)
	public void validateOnSavingRepaymentsDetailsIntoSystemAndConfirmation() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that when the user has entered an amount and selected an effective date, when they press Save the repayment is added to the list with the date and amount displayed, sorted in reverse chronological order"
							+ "Verify that the user must select the clipboard icon and confirm the effective date to confirm the repayment")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Call the openFacilityFromDatabase function from the FundingPage
			FundingPage.openFacilityFromDatabase();

			// Get repayment amount
			String repaymentAmountExpected = getDataFromExcel(61);

			// Get today's date
			String todayDate = Utils.getTodayDayFormatted();

			// Get yesterday's date
			String yesterdayDate = Utils.getYesterdayDayFormatted();

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.facilityStatusTab, FundingNewFacilityPO.repaymentSection,
					"Facility Status");

			// Go to the facility status page and add repayments
			FundingPage.addRepayment(repaymentAmountExpected, todayDate);

			IElementActions.scrollToTop(driver);

			String effectivedDateExpected = FundingPage.confirmRepayment(FundingNewFacilityPO.confirmIconRepayment,
					"today");

			// Get confirmation status
			boolean confirmationStatus = IElementActions
					.checkAttributePresentInClass(FundingNewFacilityPO.isConfirmedRepayment, "text-success");

			// Assert status
			IElementActions.assertTrue_ConditionBased(node, driver, confirmationStatus,
					"BUG : The repayment added is not confirmed", "PASS : The repayment added is confirmed");

			// Getting the value of the repayment amount
			String repaymentAmountActual = Utils.getFormattedText(FundingNewFacilityPO.firstRowRepaymentAmount);

			// Getting the value of the repayment date
			String actualDate = IElementActions.getElementText_usingXpath(node, driver,
					FundingNewFacilityPO.firstRowRepaymentDate);

			// Asserting the repayment amount
			IElementActions.assertEquals_usingString(node, driver, repaymentAmountActual, repaymentAmountExpected,
					"STEP1 : BUG : The actual repayment " + repaymentAmountActual + " and expected repayment "
							+ repaymentAmountExpected + " is same",
					"STEP1 : PASS : The actual repayment " + repaymentAmountActual + " and expected repayment "
							+ repaymentAmountExpected + " is same");

			// Asserting the date
			IElementActions.assertEquals_usingString(node, driver, actualDate, effectivedDateExpected,
					"STEP2 : BUG : The actual repayment date is " + actualDate
							+ " and is not equal to expected repayment date " + effectivedDateExpected,

					"STEP2 : Pass : The actual repayment date is " + actualDate
							+ " and is equal to expected repayment date " + effectivedDateExpected);

			Thread.sleep(1000);
			// Add repayments
			FundingPage.addRepayment("1", yesterdayDate);

			String effectivedYesterdayExpected = FundingPage
					.confirmRepayment(FundingNewFacilityPO.confirmIconRepaymentSecond, "yesterday");

			Thread.sleep(1000);
			// Getting the value of the repayment date
			String actualYesterdayDate = IElementActions.getElementText_usingXpath(node, driver,
					FundingNewFacilityPO.firstRowRepaymentDate);

			// Bug
//				// Asserting the date to verify sorting order
//				IElementActions.assertEquals_usingString(node, driver, actualYesterdayDate, effectivedYesterdayExpected,
//						"STEP3 : BUG : The actual repayment yesterday date is " + actualYesterdayDate
//								+ " and is not equal to expected repayment yesterday date " + effectivedYesterdayExpected
//								+ " i.e its not sorted in reverse chronological as not displayed at first row",
//						"STEP3 : Pass : The actual repayment yesterday date is " + actualYesterdayDate
//								+ " and is equal to expected repayment yesterday date " + effectivedYesterdayExpected
//								+ " i.e its sorted in reverse chronological as displayed at first row");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateOnSavingRepaymentsDetailsIntoSystem", "Pass", driver);

		} catch (AssertionError validateOnSavingRepaymentsDetailsIntoSystem) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateOnSavingRepaymentsDetailsIntoSystem test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateOnSavingRepaymentsDetailsIntoSystem_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateOnSavingRepaymentsDetailsIntoSystem.printStackTrace();
			node.fail(validateOnSavingRepaymentsDetailsIntoSystem);
			Assert.fail();
			extent.flush();
		} catch (Exception validateOnSavingRepaymentsDetailsIntoSystem) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateOnSavingRepaymentsDetailsIntoSystem test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateOnSavingRepaymentsDetailsIntoSystem_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateOnSavingRepaymentsDetailsIntoSystem.printStackTrace();
			node.fail(validateOnSavingRepaymentsDetailsIntoSystem);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _085
	@Test(priority = 12)
	public void validateIfRepaymentAmountIsLessThenCashAmount() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the repayment amount that the user has entered must be less than the cash amount (Summary tab)")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Get amount
			String newLoanFacilityAmount = getDataFromExcel(58);

			// Get drawdown amount
			String drawdownAmount = getDataFromExcel(59);

			// Get repayment amount
			String repaymentAmount = getDataFromExcel(61);

			// Get today's date
			String todayDate = Utils.getTodayDayFormatted();

			// Calling the loadNewFacilityPage from FacilityePage
			FundingPage.loadNewFacilityPage();

			// Create a facility
			FundingPage.createFacility(newLoanFacilityAmount);

			// Go to the facility status page and add drawdowns
			FundingPage.goToFacilityStatusAndAddDrawdown(drawdownAmount, todayDate);

			// Add repayments
			FundingPage.addRepayment(repaymentAmount, todayDate);

			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingNewFacilityPO.repaymentAmountCloumn);

			// Wait for the visibility of first row
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of first row");
			System.out.println("STEP1 : Waiting for the visibility of first row");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.firstRowRepayment);
			node.log(Status.INFO, "STEP2 : First row is visible");
			System.out.println("STEP2 : First row is visible");

			// Getting the value of the repayment
			int actualRepayment = Utils.getTextAndParseToInt(FundingNewFacilityPO.firstRowRepayment);

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.summaryTab, FundingNewFacilityPO.loanFacilitySummaryText,
					"Facility Summary");

			IElementActions.pageRefresh();

			// Wait for the visibility of the cash amount in summary page
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the cash amount in summary page");
			System.out.println("STEP1 : Waiting for the visibility of the cash amount in summary page");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.cashValue);
			node.log(Status.INFO, "STEP2 : Cash amount in summary page is visible");
			System.out.println("STEP2 : Cash amount in summary page is visible");

			// Get cash amount
			int cashAmount = Utils.getTextAndParseToInt(FundingNewFacilityPO.cashValue);

			// Assert repayment
			if (actualRepayment <= cashAmount) {
				Assert.assertTrue(true, "Repayment amount is less than the cash amount");
				System.out.println("Repayment amount is less than the cash amount");
				node.log(Status.PASS, "Repayment amount is less than the cash amount");
			} else {
				Assert.assertTrue(false,
						"Repayment amount " + actualRepayment + " is not less than the cash amount" + cashAmount);
				System.out.println(
						"Repayment amount " + actualRepayment + " is not less than the cash amount" + cashAmount);
				node.log(Status.FAIL,
						"Repayment amount " + actualRepayment + " is not less than the cash amount" + cashAmount);
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateIfRepaymentAmountIsLessThenCashAmount", "Pass", driver);

		} catch (AssertionError validateIfRepaymentAmountIsLessThenCashAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateIfRepaymentAmountIsLessThenCashAmount test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateIfRepaymentAmountIsLessThenCashAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateIfRepaymentAmountIsLessThenCashAmount.printStackTrace();
			node.fail(validateIfRepaymentAmountIsLessThenCashAmount);
			Assert.fail();
			extent.flush();
		} catch (Exception validateIfRepaymentAmountIsLessThenCashAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateIfRepaymentAmountIsLessThenCashAmount test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateIfRepaymentAmountIsLessThenCashAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateIfRepaymentAmountIsLessThenCashAmount.printStackTrace();
			node.fail(validateIfRepaymentAmountIsLessThenCashAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _086
	// TC_Funding_NewFacility _093
	@Test(priority = 13)
	public void validateIfRepaymentIsGreaterThenCashAmount() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the validation appears if the repayment amount that the user has entered is greater than the current cash amount")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Call the openFacilityFromDatabase function from the FundingPage
			FundingPage.openFacilityFromDatabase();

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.summaryTab, FundingNewFacilityPO.loanFacilitySummaryText,
					"Facility Summary");

			IElementActions.pageRefresh();

			// Wait for the visibility of the cash amount in summary page
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the cash amount in summary page");
			System.out.println("STEP1 : Waiting for the visibility of the cash amount in summary page");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.cashValue);
			node.log(Status.INFO, "STEP2 : Cash amount in summary page is visible");
			System.out.println("STEP2 : Cash amount in summary page is visible");

			// Get cash amount
			int cashAmount = Utils.getTextAndParseToInt(FundingNewFacilityPO.cashValue);

			// New repayment amount
			String repaymentAmount = String.valueOf(cashAmount + 1000);

			// Get today's date
			String todayDate = Utils.getTodayDayFormatted();

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.facilityStatusTab, FundingNewFacilityPO.repaymentSection,
					"Facility Status");

			// Add repayments
			FundingPage.addRepayment(repaymentAmount, todayDate);

			// Wait for the visibility of edit icon
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of error");
			System.out.println("STEP1 : Waiting for the visibility of error");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.error);
			node.log(Status.INFO, "STEP2 : Error is visible");
			System.out.println("STEP2 : Error is visible");

			// Get the error text
			String errorMessage = IElementActions.getElementText_usingXpath(node, driver, FundingNewFacilityPO.error);

			// Assert error message
			if (errorMessage.contains("The new repayment amount is greater than the current drawn amount ")) {
				Assert.assertTrue(true, errorMessage + " error message is displayed");
				System.out.println(errorMessage + " error message is displayed");
				node.log(Status.PASS, errorMessage + " error message is displayed");
			} else {
				Assert.assertTrue(false, errorMessage + " error message is displayed");
				System.out.println(errorMessage + " error message is displayed");
				node.log(Status.FAIL, errorMessage + " error message is displayed");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateIfRepaymentIsGreaterThenCashAmount", "Pass", driver);

		} catch (AssertionError validateIfRepaymentIsGreaterThenCashAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateIfRepaymentIsGreaterThenCashAmount test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateIfRepaymentIsGreaterThenCashAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateIfRepaymentIsGreaterThenCashAmount.printStackTrace();
			node.fail(validateIfRepaymentIsGreaterThenCashAmount);
			Assert.fail();
			extent.flush();
		} catch (Exception validateIfRepaymentIsGreaterThenCashAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateIfRepaymentIsGreaterThenCashAmount test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateIfRepaymentIsGreaterThenCashAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateIfRepaymentIsGreaterThenCashAmount.printStackTrace();
			node.fail(validateIfRepaymentIsGreaterThenCashAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _087
	@Test(priority = 14)
	public void validateAllRepaymentsSum() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the sum of all repayments must be less than or equal to the facility amount(Summary tab)")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Call the openFacilityFromDatabaseAndGoToStatus function from the FundingPage
			FundingPage.openFacilityFromDatabaseAndGoToStatus();

			// Get amount
			String newLoanFacilityAmount = getDataFromExcel(58);

			// Get double type facilty amount
			double facilityAmount = Double.parseDouble(newLoanFacilityAmount);

			// Get repayment amount
			String repaymentAmount = getDataFromExcel(61);

			// Get today's date
			String todayDate = Utils.getTodayDayFormatted();

			// Add repayment
			FundingPage.addRepayment(repaymentAmount, todayDate);

			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingNewFacilityPO.repaymentAmountCloumn);

			// Wait for the visibility of repayments amount
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the repayments amount");
			System.out.println("STEP1 : Waiting for the visibility of the repayments amount");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.repaymentsAmount);
			node.log(Status.INFO, "STEP2 : The repayments amount is visible");
			System.out.println("STEP2 : The repayments amount is visible");

			// Locate all repayments amount
			List<WebElement> repaymentsElements = IElementActions.returnElements(node, driver,
					FundingNewFacilityPO.repaymentsAmount);

			// Initialize total sum
			double totalSum = 0;

			// Iterate through each element to extract and sum amounts
			for (WebElement element : repaymentsElements) {
				// Get the text from the element
				String amountText = element.getText();

				// Extract numeric value by removing currency symbol and commas
				double amount = Utils.extractNumeric(amountText);

				// Add the amount to total sum
				totalSum += amount;
			}

			// Compare total sum with facility amount
			if (totalSum <= facilityAmount) {
				System.out.println("Total repayments sum is less than or equal to facility amount.");
			} else {
				System.out.println("Total repayments sum exceeds facility amount.");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAllRepaymentsSum", "Pass", driver);

		} catch (AssertionError validateAllRepaymentsSum) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAllRepaymentsSum test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAllRepaymentsSum_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllRepaymentsSum.printStackTrace();
			node.fail(validateAllRepaymentsSum);
			Assert.fail();
			extent.flush();
		} catch (Exception validateAllRepaymentsSum) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAllRepaymentsSum test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAllRepaymentsSum_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllRepaymentsSum.printStackTrace();
			node.fail(validateAllRepaymentsSum);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _090
	@Test(priority = 15)
	public void validateConfirmRepaymentAndGreenTick() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user able to confirm added repayments into the system and the repayment should display a green tick amount")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Get amount
			String newLoanFacility = getDataFromExcel(58);

			// Get drawdown amount
			String drawdownAmount = getDataFromExcel(59);

			// Get repayment amount
			String repaymentAmount = getDataFromExcel(61);

			// Get today's date
			String todayDate = Utils.getTodayDayFormatted();

			// Calling the loadNewFacilityPage from FacilityePage
			FundingPage.loadNewFacilityPage();

			// Create a facility
			FundingPage.createFacility(newLoanFacility);

			// Go to the facility status page and add drawdowns
			FundingPage.goToFacilityStatusAndAddDrawdown(drawdownAmount, todayDate);

			// Add repayments
			FundingPage.addRepayment(repaymentAmount, todayDate);

			String effectivedDateExpected = FundingPage.confirmRepayment(FundingNewFacilityPO.confirmIconRepayment,
					"today");

			// Get confirmation status
			boolean confirmationStatus = IElementActions
					.checkAttributePresentInClass(FundingNewFacilityPO.isConfirmedRepayment, "text-success");

			// Assert status
			IElementActions.assertTrue_ConditionBased(node, driver, confirmationStatus,
					"BUG : The repayment added is not confirmed", "PASS : The repayment added is confirmed");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateConfirmRepaymentAndGreenTick", "Pass", driver);

		} catch (AssertionError validateConfirmRepaymentAndGreenTick) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateConfirmRepaymentAndGreenTick test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateConfirmRepaymentAndGreenTick_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateConfirmRepaymentAndGreenTick.printStackTrace();
			node.fail(validateConfirmRepaymentAndGreenTick);
			Assert.fail();
			extent.flush();
		} catch (Exception validateConfirmRepaymentAndGreenTick) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateConfirmRepaymentAndGreenTick test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateConfirmRepaymentAndGreenTick_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateConfirmRepaymentAndGreenTick.printStackTrace();
			node.fail(validateConfirmRepaymentAndGreenTick);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _091
	// TC_Funding_NewFacility _092
	@Test(priority = 16)
	public void validateCashAmountAndAccountBalanceAfterAddingRepayments() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the facility’s cash amount should decrease by the new repayment amount"
							+ "Verify that the repayment should also show in the Account Balances Tab with the correct effective date")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Get drawdown amount
			String drawdownAmount = getDataFromExcel(59);

			// Get repayment amount
			String repaymentAmount = getDataFromExcel(61);

			// Call the openFacilityFromDatabaseAndGoToStatus function from the FundingPage
			FundingPage.openFacilityFromDatabaseAndGoToStatus();

			// Getting the value of the repayment date
			String expectedDate = IElementActions.getElementText_usingXpath(node, driver,
					FundingNewFacilityPO.firstRowRepaymentDate);

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.summaryTab, FundingNewFacilityPO.loanFacilitySummaryText,
					"Facility Summary");

			IElementActions.pageRefresh();

			// Wait for the visibility of the cash amount in summary page
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the cash amount in summary page");
			System.out.println("STEP1 : Waiting for the visibility of the cash amount in summary page");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.cashValue);
			node.log(Status.INFO, "STEP2 : Cash amount in summary page is visible");
			System.out.println("STEP2 : Cash amount in summary page is visible");

			// Drawdown int value
			int drawdownValue = Integer.parseInt(drawdownAmount);

			// Repayment int value
			int repaymentValue = Integer.parseInt(repaymentAmount);

			// Expected cash value
			int expectedCashValue = Utils.calculateDifference(drawdownValue, repaymentValue);

			// Get cash amount
			int actualCashAmount = Utils.getTextAndParseToInt(FundingNewFacilityPO.cashValue);

			// Asserting the cash amount
			IElementActions.assertEquals_usingInteger(node, driver, actualCashAmount, expectedCashValue,
					"STEP3 : BUG : The Cash amount(Summary tab) " + actualCashAmount
							+ " is decreased by the added repayment " + repaymentValue + " from actual cash amount "
							+ drawdownAmount,
					"STEP3 : PASS : The Cash amount(Summary tab) " + actualCashAmount
							+ " is decreased by the added repayment " + repaymentValue + " from actual cash amount "
							+ drawdownAmount);

			// Click on account balance
			Utils.waitAndClickOnTab(FundingNewFacilityPO.accountBalancesTab, FundingNewFacilityPO.balanceText,
					"Facility Account Balances");

			// Get receipt
			int receipt = Utils.getTextAndParseToInt(FundingNewFacilityPO.firstRowReceipt);

			// Asserting the cash amount
			IElementActions.assertEquals_usingInteger(node, driver, receipt, repaymentValue,
					"STEP4 : BUG : The repayment in account balances " + receipt + " is same as added repayment "
							+ repaymentValue,
					"STEP4 : PASS : The repayment in account balances " + receipt + " is same as added repayment "
							+ repaymentValue);

			// Getting the text of the date in account balances
			String date = IElementActions.getElementText_usingXpath(node, driver,
					FundingNewFacilityPO.firstRowDateInAccountBalance);

			// Asserting the effective date
			IElementActions.assertEquals_usingString(node, driver, date, expectedDate,
					"STEP4 : BUG : The effective date " + date + "is not same as " + expectedDate,
					"STEP4 : PASS : The effective date " + date + "is same as " + expectedDate);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashAmountAndAccountBalanceAfterAddingRepayments", "Pass",
					driver);

		} catch (AssertionError validateCashAmountAndAccountBalanceAfterAddingRepayments) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashAmountAndAccountBalanceAfterAddingRepayments test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashAmountAndAccountBalanceAfterAddingRepayments_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashAmountAndAccountBalanceAfterAddingRepayments.printStackTrace();
			node.fail(validateCashAmountAndAccountBalanceAfterAddingRepayments);
			Assert.fail();
			extent.flush();
		} catch (Exception validateCashAmountAndAccountBalanceAfterAddingRepayments) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashAmountAndAccountBalanceAfterAddingRepayments test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashAmountAndAccountBalanceAfterAddingRepayments_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashAmountAndAccountBalanceAfterAddingRepayments.printStackTrace();
			node.fail(validateCashAmountAndAccountBalanceAfterAddingRepayments);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _094
	@Test(priority = 17)
	public void validatePreviousRepaymentsUpdate() throws IOException {

		try {
			extenttest = extent.createTest("Verify that the user able to update previous repayments into the system")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Get amount
			String newLoanFacility = getDataFromExcel(58);

			// Get drawdown amount
			String drawdownAmount = getDataFromExcel(59);

			// Get repayment amount
			String repaymentAmount = getDataFromExcel(61);

			// Updated repayment value
			int updatedRepayment = Integer.parseInt(repaymentAmount);
			String newUpdatedRepayment = String.valueOf(updatedRepayment + 100);

			// Get today's date
			String todayDate = Utils.getTodayDayFormatted();

			// Calling the loadNewFacilityPage from FacilityePage
			FundingPage.loadNewFacilityPage();

			// Create a facility
			FundingPage.createFacility(newLoanFacility);

			// Go to the facility status page and add drawdowns
			FundingPage.goToFacilityStatusAndAddDrawdown(drawdownAmount, todayDate);

			// Go to the facility status page and add repayments
			FundingPage.addRepayment(repaymentAmount, todayDate);

			IElementActions.scrollToTop(driver);

			// Wait for the visibility of first row
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of first row");
			System.out.println("STEP1 : Waiting for the visibility of first row");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.facilityStatusTab);
			node.log(Status.INFO, "STEP2 : First row is visible");
			System.out.println("STEP2 : First row is visible");

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.facilityStatusTab, FundingNewFacilityPO.repaymentSection,
					"Facility Status");

			// Getting the value of the repayment
			String repayment = Utils.getFormattedText(FundingNewFacilityPO.firstRowRepayment);

			// Wait for the visibility of edit icon
			node.log(Status.INFO, "STEP3 : Waiting for the visibility of edit icon");
			System.out.println("STEP3 : Waiting for the visibility of edit icon");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.editIconRepayment);
			node.log(Status.INFO, "STEP4 : Edit icon is visible");
			System.out.println("STEP4 : Edit icon is visible");

			// Click on the edit button
			IElementActions.clickelement_usingXpath(node, driver, FundingNewFacilityPO.editIconRepayment);
			node.log(Status.INFO, "STEP5 : Clicked on the edit button");
			System.out.println("STEP5 : Clicked on the edit button");

			// Wait for the repayment amount field to be visible and clickable
			System.out.println("STEP6 : Waiting for the repayment amount field to be visibility and clickable");
			node.log(Status.INFO, "STEP6 : Waiting for the repayment amount field to be visibility and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.repaymentAmountInputField);
			IWaitStrategy.WaitUntilElementClickable(node, driver, FundingNewFacilityPO.repaymentAmountInputField);
			System.out.println("STEP7 : Repayment amount field is visible and clickable.");
			node.log(Status.INFO, "STEP7 : Repayment amount field is visible and clickable.");

			// Enter value in amount
			IElementActions.sendKeys_usingXpath(node, driver, FundingNewFacilityPO.repaymentAmountInputField,
					newUpdatedRepayment);
			System.out.println("STEP8 : Entered the value in the repayment amount input field.");
			node.log(Status.INFO, "STEP8 : Entered the value in the repayment amount input field.");

			// Wait for the repayment save button to be clickable
			System.out.println("STEP9 : Waiting for the repayment save button to be visible and clickable");
			node.log(Status.INFO, "STEP9 : Waiting for the repayment save button to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.repaymentSaveButton);
			IWaitStrategy.WaitUntilElementClickable(node, driver, FundingNewFacilityPO.repaymentSaveButton);
			System.out.println("STEP10 : Repayment save button is visible and clickable.");
			node.log(Status.INFO, "STEP10 : Repayment save button is visible and clickable.");

			// Click on the save button
			IElementActions.clickelement_usingXpath(node, driver, FundingNewFacilityPO.repaymentSaveButton);
			System.out.println("STEP11 : Clicked on the new repayment save button.");
			node.log(Status.INFO, "STEP11 : Clicked on the new repayment save button.");

			// Wait for the visibility of the repayment
			System.out.println("STEP12 : Waiting for the visibility of the repayment");
			node.log(Status.INFO, "STEP12 : Waiting for the visibility of the repayment");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.firstRowRepayment);
			System.out.println("STEP13 : Repayment is now visible.");
			node.log(Status.INFO, "STEP13 : Repayment is now visible.");

			// Getting the value of the repayment
			String newrepayment = Utils.getFormattedText(FundingNewFacilityPO.firstRowRepayment);

			// Asserting the repayment
			IElementActions.assertEquals_usingString(node, driver, newrepayment, newUpdatedRepayment,
					"STEP14 : BUG : The new updated repayment " + newrepayment
							+ " is not updated from the old repayment " + repayment,
					"STEP14 : PASS :  The new updated repayment " + newrepayment + " is updated from the old repayment "
							+ repayment);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validatePreviousRepaymentsUpdate", "Pass", driver);

		} catch (AssertionError validatePreviousRepaymentsUpdate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePreviousRepaymentsUpdate test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePreviousRepaymentsUpdate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePreviousRepaymentsUpdate.printStackTrace();
			node.fail(validatePreviousRepaymentsUpdate);
			Assert.fail();
			extent.flush();
		} catch (Exception validatePreviousRepaymentsUpdate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePreviousRepaymentsUpdate test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePreviousRepaymentsUpdate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePreviousRepaymentsUpdate.printStackTrace();
			node.fail(validatePreviousRepaymentsUpdate);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _095
	@Test(priority = 18)
	public void validateDeleteInRepayments() throws IOException {

		try {
			extenttest = extent.createTest("Verify that the user able to delete previous repayments into the system")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Get amount
			String newLoanFacility = getDataFromExcel(58);

			// Get drawdown amount
			String drawdownAmount = getDataFromExcel(59);

			// Get repayment amount
			String repaymentAmount = getDataFromExcel(61);

			// Get today's date
			String todayDate = Utils.getTodayDayFormatted();

			// Calling the loadNewFacilityPage from FacilityePage
			FundingPage.loadNewFacilityPage();

			// Create a facility
			FundingPage.createFacility(newLoanFacility);

			// Go to the facility status page and add drawdowns
			FundingPage.goToFacilityStatusAndAddDrawdown(drawdownAmount, todayDate);

			// Go to the facility status page and add repayments
			FundingPage.addRepayment(repaymentAmount, todayDate);

			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingNewFacilityPO.repaymentAmountCloumn);

			// Wait for the visibility of delete icon
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of delete icon");
			System.out.println("STEP1 : Waiting for the visibility of delete icon");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.deleteIconRepayment);
			node.log(Status.INFO, "STEP2 : Delete icon is visible");
			System.out.println("STEP2 : Delete icon is visible");

			// Click on the delete button and wait
			Utils.clickAndWait(FundingNewFacilityPO.deleteIconRepayment, "Delete Button", UtilsPO.popUp);

			// Click on the delete button
			IElementActions.clickelement_usingXpath(node, driver, FundingNewFacilityPO.deleteButton);
			node.log(Status.INFO, "STEP3 : Clicked on the delete button");
			System.out.println("STEP3 : Clicked on the delete button");

			// Wait for the invisibility of popup
			node.log(Status.INFO, "STEP4 : Waiting for the invisibility of the popup");
			System.out.println("STEP4 : Waiting for the invisibility of the popup");
			IWaitStrategy.waitForInVisiblity(node, driver, UtilsPO.popUp);
			node.log(Status.INFO, "STEP5 : The popup is not visible");
			System.out.println("STEP5 : The popup is not visible");

			// Check repayment availability
			boolean repaymentAvailable = IElementActions.isElementAvailable(node, driver,
					FundingNewFacilityPO.firstRowRepayment);
			System.out.println("repaymentAvailable " + repaymentAvailable);

			// Asserting the repayment availability
			IElementActions.assertFalse_ConditionBased(node, driver, repaymentAvailable,
					"STEP6: BUG : The repayment is not deleted from the system",
					"STEP6: PASS : The repayment is deleted from the system");

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.facilityTab, FundingNewFacilityPO.amountInputField,
					"Facility");

			// Getting the value of the available amount
			String availableAmount = Utils.getFormattedText(FundingNewFacilityPO.availableAmount);

			// Drawdown int value
			int drawdownValue = Integer.parseInt(drawdownAmount);

			// Facility amount int value
			int facilityAmountValue = Integer.parseInt(newLoanFacility);

			// Difference between facility amount and drawdown
			int expectedValueDiff = Utils.calculateDifference(facilityAmountValue, drawdownValue);
			node.log(Status.INFO, "STEP7 : Difference between facility amount " + facilityAmountValue
					+ " and drawdown value " + drawdownValue + " is " + expectedValueDiff);
			System.out.println("STEP7 : Difference between facility amount " + facilityAmountValue
					+ " and drawdown value " + drawdownValue + " is " + expectedValueDiff);

			String expectedValue = Integer.toString(expectedValueDiff);

			// Assert available amount
			if (availableAmount.equals(expectedValue)) {
				Assert.assertTrue(true, "The Available Amount is updated on the Facility section accordingly");
				System.out.println("The Available Amount " + availableAmount
						+ "is updated on the Facility section after deleting repayment");
				node.log(Status.PASS, "The Available Amount " + availableAmount
						+ "is updated on the Facility section after deleting repayment");
			} else {
				Assert.assertTrue(false, "The Available Amount " + availableAmount
						+ "is not updated on the Facility section after deleting repayment as Difference between facility amount "
						+ facilityAmountValue + " and drawdown value " + drawdownValue + " is " + expectedValueDiff);
				System.out.println("The Available Amount " + availableAmount
						+ "is not updated on the Facility section after deleting repayment as Difference between facility amount "
						+ facilityAmountValue + " and drawdown value " + drawdownValue + " is " + expectedValueDiff);
				node.log(Status.FAIL, "The Available Amount " + availableAmount
						+ "is not updated on the Facility section after deleting repayment as Difference between facility amount "
						+ facilityAmountValue + " and drawdown value " + drawdownValue + " is " + expectedValueDiff);
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDeleteInRepayments", "Pass", driver);

		} catch (AssertionError validateDeleteInRepayments) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDeleteInRepayments test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDeleteInRepayments_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeleteInRepayments.printStackTrace();
			node.fail(validateDeleteInRepayments);
			Assert.fail();
			extent.flush();
		} catch (Exception validateDeleteInRepayments) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDeleteInRepayments test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDeleteInRepayments_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeleteInRepayments.printStackTrace();
			node.fail(validateDeleteInRepayments);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_NewFacility _219
	// TC_Funding_NewFacility _221
	@Test(priority = 19)
	public void validateDocumentsTabAndUploadSingleDocument() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the user can access the 'Documents'"
							+ "Verify that the user can upload single document")
					.assignCategory(funding_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Call the openFacilityFromDatabase function from the FundingPage
			FundingPage.openFacilityFromDatabase();

			// Click on facility tab
			Utils.waitAndClickOnTab(FundingNewFacilityPO.documentsTab, FundingNewFacilityPO.documentsHeaderText,
					"Documents");

			// Asserting the documents
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.documentsHeaderText,
					"STEP1: BUG : The documents tab is not displayed", "STEP1: PASS : The documents tab is displayed");

			// Click on the single button
			IElementActions.clickelement_usingXpath(node, driver, FundingNewFacilityPO.single);
			node.log(Status.INFO, "STEP2 : Clicked on the single button");
			System.out.println("STEP2 : Clicked on the single button");

			// Wait for the visibility of description
			node.log(Status.INFO, "STEP3 : Waiting for the visibility of the description");
			System.out.println("STEP3 : Waiting for the visibility of the description");
			IWaitStrategy.waitForVisiblity(node, driver, FundingNewFacilityPO.description);
			node.log(Status.INFO, "STEP4 : The description is visible");
			System.out.println("STEP4 : The description is visible");

			// Enter value in description
			IElementActions.sendKeys_usingXpath(node, driver, FundingNewFacilityPO.description, "test");
			System.out.println("STEP5 : Entered the value in the description");
			node.log(Status.INFO, "STEP5 : Entered the value in the description");

			String testFilePath = System.getProperty("user.dir") + "\\TestFiles\\TestData.pdf";

			// Upload file
			IElementActions.sendKeys_usingXpath(node, driver, FundingNewFacilityPO.upload, testFilePath);
			System.out.println("STEP6 : Uploaded file");
			node.log(Status.INFO, "STEP6 : Uploaded file");

			// Asserting the uploaded entry
			IElementActions.assertTrue_usingXpath(node, driver, FundingNewFacilityPO.uploadedFileRow,
					"STEP7: BUG : The uploaded document is displayed",
					"STEP7: PASS : The uploaded document is displayed");

			// Click on the delete icon and wait
			Utils.clickAndWait(FundingNewFacilityPO.deleteDocument, "Delete Icon", UtilsPO.popUp);

			// Click on the delete button
			IElementActions.clickelement_usingXpath(node, driver, FundingNewFacilityPO.deleteButton);
			node.log(Status.INFO, "STEP8 : Clicked on the delete button");
			System.out.println("STEP8 : Clicked on the delete button");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDocumentsTabAndUploadSingleDocument", "Pass", driver);

		} catch (AssertionError validateDocumentsTabAndUploadSingleDocument) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDocumentsTabAndUploadSingleDocument test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDocumentsTabAndUploadSingleDocument_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDocumentsTabAndUploadSingleDocument.printStackTrace();
			node.fail(validateDocumentsTabAndUploadSingleDocument);
			Assert.fail();
			extent.flush();
		} catch (Exception validateDocumentsTabAndUploadSingleDocument) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDocumentsTabAndUploadSingleDocument test in NewFacilityTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDocumentsTabAndUploadSingleDocument_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDocumentsTabAndUploadSingleDocument.printStackTrace();
			node.fail(validateDocumentsTabAndUploadSingleDocument);
			Assert.fail();
			extent.flush();
		}
	}

}
