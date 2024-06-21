package com.Funding.InterestPayment.tests;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.locators.allPages.FundingInterestPaymentPO;
import com.locators.allPages.LoansDatabasePO;
import com.locators.allPages.LoansNewLoanPO;
import com.locators.allPages.UtilsPO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.url.AllPagesData;
import com.qa.utils.FundingPage;
import com.qa.utils.LoansPage;
import com.qa.utils.LoginPage;
import com.qa.utils.Utils;

public class InterestPaymentStep2Test extends Baseclass {

	// TC_Funding_Interest _012
	@Test(priority = 1)
	public void validateHealthIsHighlighted() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the Step2 health is highlighted when the user is in step2 of the interest page")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			// Calling the userLoginProcess function from the utils login
			LoginPage.userLoginProcess(node, driver, getDataFromExcel(1), getDataFromExcel(2));

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Check if the 'step--current' is present in the class attribute
			boolean isHighlighted = IElementActions.checkAttributePresentInClass(FundingInterestPaymentPO.healthStep,
					"step--current");

			// Print the result
			if (isHighlighted) {
				node.log(Status.INFO, "SUB-STEP_0.001 :The Step 2 Health is highlighted");
				System.out.println("SUB-STEP_0.001 : The Step 2 Health is highlighted");

				Assert.assertTrue(true, "The Step 2 Health is highlighted");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateHealthStepIsHighlighted", "Pass", driver);
			} else {
				System.out.println("SUB-STEP_0.001 : The Step 2 Health is not highlighted");
				node.log(Status.INFO, "SUB-STEP_0.001 :The Step 2 Health is not highlighted");

				Assert.assertTrue(false, "The Step 2 Health is not highlighted");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateHealthIsHighlighted", "Fail", driver);
			}

		} catch (AssertionError validateHealthIsHighlighted) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateHealthIsHighlighted test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateHealthIsHighlighted_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateHealthIsHighlighted.printStackTrace();
			node.fail(validateHealthIsHighlighted);
			Assert.fail();
			extent.flush();

		} catch (Exception validateHealthIsHighlighted) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateHealthIsHighlighted test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateHealthIsHighlighted_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateHealthIsHighlighted.printStackTrace();
			node.fail(validateHealthIsHighlighted);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _013
	@Test(priority = 2)
	public void validateHealthStepDetails() throws IOException {

		try {
			extenttest = extent.createTest("Verify the details on the Step 2 health")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Check the visibility of Interest Payment Date Label
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestPaymentDateLabel,
					"STEP1 : BUG: The interest payment date label is not coming in health step on interest payment page",
					"STEP1 : EXPECTED: The interest payment date label is coming in health step on interest payment page");

			// Check the visibility of Interest Payment Date Field
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestPaymentDateField,
					"STEP2 : BUG: The interest payment date field is not coming in health step on interest payment page",
					"STEP2 : EXPECTED: The interest payment date field is coming in health step on interest payment page");

			// Check the visibility of Calculation start date label
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.calculationStartDateLabel,
					"STEP3 : BUG: The Calculation start date label is not coming in health step on interest payment page",
					"STEP3 : EXPECTED: The Calculation start date label is coming in health step on interest payment page");

			// Check the visibility of Calculation start date field
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.calculationStartDateField,
					"STEP4 : BUG: The Calculation start date field is not coming in health step on interest payment page",
					"STEP4 : EXPECTED: The Calculation start date field is coming in health step on interest payment page");

			// Check the visibility of Calculation end date label
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.calculationEndDateLabel,
					"STEP5 : BUG: The Calculation end date label is not coming in health step on interest payment page",
					"STEP5 : EXPECTED: The Calculation end date label is coming in health step on interest payment page");

			// Check the visibility of Calculation end date field
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.calculationEndDateField,
					"STEP6 : BUG: The Calculation end date field is not coming in health step on interest payment page",
					"STEP6 : EXPECTED: The Calculation end date field is coming in health step on interest payment page");

			// Check the visibility of Tolerance section
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.tolerance,
					"STEP7 : BUG: The Tolerance section is not coming in health step on interest payment page",
					"STEP7 : EXPECTED: Tolerance section is coming in health step on interest payment page");

			// Check the visibility of System Health Check
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.systemHealthCheck,
					"STEP8 : BUG: The System Health Check is not coming in health step on interest payment page",
					"STEP8 : EXPECTED: The System Health Check is coming in health step on interest payment page");

			// Check the visibility of All Allocations Balanced
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.allAllocationsBalanced,
					"STEP9 : BUG: The All Allocations Balanced is not coming in health step on interest payment page",
					"STEP9 : EXPECTED: The All Allocations Balanced is coming in health step on interest payment page");

			// Scroll to the System Health Check
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingInterestPaymentPO.systemHealthCheck);
			node.log(Status.INFO, "STEP10 : Scrolled to the  System Health Check");
			System.out.println("STEP10 : Scrolled to the System Health Check");

			// Check the visibility of All Allocations Balanced Four Side Arrow Icon
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.allAllocationFourSideArrowIcon,
					"STEP11 : BUG: The All Allocations Balanced four side arrow icon is not coming in health step on interest payment page",
					"STEP11 : EXPECTED: The All Allocations Balanced four side arrow icon is coming in health step on interest payment page");

			// Check the visibility of NIM Analysis
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.nimAnalysis,
					"STEP12 : BUG: The NIM Analysis is not coming in health step on interest payment page",
					"STEP12 : EXPECTED:  The NIM Analysis is coming in health step on interest payment page");

			// Check the visibility of NIM Analysis Four Side Arrow Icon
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					"STEP13 : BUG: The NIM Analysis four side arrow icon is not coming in health step on interest payment page",
					"STEP13 : EXPECTED: The NIM Analysis four side arrow icon is coming in health step on interest payment page");

			// Check the visibility of Reserves
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.reserves,
					"STEP14 : BUG: The Reserves is not coming in health step on interest payment page",
					"STEP14 : EXPECTED: The Reserves is coming in health step on interest payment page");

			// Check the visibility of Reserves Four Side Arrow Icon
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.reservesFourSideArrowIcon,
					"STEP15 : BUG: The Reserves four side arrow icon is not coming in health step on interest payment page",
					"STEP15 : EXPECTED: The Reserves four side arrow icon is coming in health step on interest payment page");

			// Check the visibility of Reserves Release
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.reserveReleases,
					"STEP16 : BUG: The Reserves Release is not coming in health step on interest payment page",
					"STEP16 : EXPECTED: The Reserves Release is coming in health step on interest payment page");

			// Check the visibility of Reserves Release Four Side Arrow Icon
			IElementActions.assertTrue_usingXpath(node, driver,
					FundingInterestPaymentPO.reserveReleasesFourSideArrowIcon,
					"STEP17 : BUG: The Reserves Release four side arrow icon is not coming in health step on interest payment page",
					"STEP17 : EXPECTED: The Reserves Release four side arrow icon is coming in health step on interest payment page");

			// Check the visibility of Forecast Tolerance
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.forecastTolerance,
					"STEP18 : BUG: The Forecast Tolerance is not coming in health step on interest payment page",
					"STEP18 : EXPECTED: The Forecast Tolerance is coming in health step on interest payment page");

			// Check the visibility of Bridge Loan Rate Difference Tolerance
			IElementActions.assertTrue_usingXpath(node, driver,
					FundingInterestPaymentPO.bridgeLoanRateDifferenceTolerance,
					"STEP19 : BUG: The Bridge Loan Rate Difference Tolerance is not coming in health step on interest payment page",
					"STEP19 : EXPECTED: The Bridge Loan Rate Difference Tolerance is coming in health step on interest payment page");

			// Check the visibility of Facility Rate Max Difference Tolerance
			IElementActions.assertTrue_usingXpath(node, driver,
					FundingInterestPaymentPO.facilityRateMaxDifferenceTolerance,
					"STEP20 : BUG: The Facility Rate Max Difference Tolerance is not coming in health step on interest payment page",
					"STEP20 : EXPECTED:  The Facility Rate Max Difference Tolerance is coming in health step on interest payment page");

			// Check the visibility of Facility section
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.facility,
					"STEP21 : BUG: The Facility section is not coming in health step on interest payment page",
					"STEP21 : EXPECTED: The Facility section is coming in health step on interest payment page");

			// Check the visibility of Carried Forward section
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.carriedForward,
					"STEP22 : BUG: The Carried Forward Section is not coming in health step on interest payment page",
					"STEP22 : EXPECTED: The Carried Forward Section is coming in health step on interest payment page");

			// Check the visibility of Forecasted Section
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.forecasted,
					"STEP23 : BUG: The Forecasted Section is not coming in health step on interest payment page",
					"STEP23 : EXPECTED: The Forecasted Section is coming in health step on interest payment page");

			// Check the visibility of Difference Section
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.difference,
					"STEP24 : BUG: The Difference Section is not coming in health step on interest payment page",
					"STEP24 : EXPECTED: The Difference Section is coming in health step on interest payment page");

			// Scroll to Health
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingInterestPaymentPO.health);
			node.log(Status.INFO, "STEP25 : Scrolled up to the health");
			System.out.println("STEP25 : Scrolled up to the health");

			// Check the visibility of Day Count Fraction Section
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.dayCountFraction,
					"STEP26 : BUG: The Day Count Fraction Section is not coming in health step on interest payment page",
					"STEP26 : EXPECTED: The Day Count Fraction Section is coming in health step on interest payment page");

			// Check the visibility of Day Count Fraction Table
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.dayCountFractionTable,
					"STEP27 : BUG: The Day Count Fraction table is not coming in health step on interest payment page",
					"STEP27 : EXPECTED: The Day Count Fraction table is coming in health step on interest payment page");

			// Check the visibility of Deferred Interest Check Section
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deferredInterestCheck,
					"STEP28 : BUG: The Deferred Interest Check section is not coming in health step on interest payment page",
					"STEP28 : EXPECTED: The Deferred Interest Check section is coming in health step on interest payment page");

			// Check the visibility of Deferred Interest Check Table
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deferredInterestCheckTable,
					"STEP29 : BUG: The Deferred Interest Check table is not coming in health step on interest payment page",
					"STEP29 : EXPECTED: The Deferred Interest Check table is coming in health step on interest payment page");

			// Check the visibility of Deployment Change Check (Weighted Average) Section
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deploymentChangeCheck,
					"STEP30 : BUG: The Deployment Change Check (Weighted Average) section is not coming in health step on interest payment page",
					"STEP30 : EXPECTED: The Deployment Change Check (Weighted Average) section is coming in health step on interest payment page");

			// Check the visibility of Deployment Change Check (Weighted Average) Table
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deploymentChangeCheckTable,
					"STEP31 : BUG: The Deployment Change Check (Weighted Average) table is not coming in health step on interest payment page",
					"STEP31 : EXPECTED: The Deployment Change Check (Weighted Average) table is coming in health step on interest payment page");

			// Check the visibility of Rate Changes Check (by Deployment and Cohort) Section
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.rateChangesCheck,
					"STEP32 : BUG: The Rate Changes Check (by Deployment and Cohort) section is not coming in health step on interest payment page",
					"STEP32 : EXPECTED: The Rate Changes Check (by Deployment and Cohort) section is coming in health step on interest payment page");

			// Check the visibility of Rate Changes Check (by Deployment and Cohort) Table
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.rateChangesCheckTable,
					"STEP33 : BUG: The Rate Changes Check (by Deployment and Cohort) table is not coming in health step on interest payment page",
					"STEP33 : EXPECTED: The Rate Changes Check (by Deployment and Cohort) table is coming in health step on interest payment page");

			// Check the visibility of Regular Interest Check Section
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.regularInterestCheck,
					"STEP34 : BUG: The Regular Interest Check section is not coming in health step on interest payment page",
					"STEP34 : EXPECTED: The Regular Interest Check section is coming in health step on interest payment page");

			// Check the visibility of Regular Interest Check Table
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.regularInterestCheckATable,
					"STEP35 : BUG: The Regular Interest Check table is not coming in health step on interest payment page",
					"STEP35 : EXPECTED: The Regular Interest Check table is coming in health step on interest payment page");

			// Scroll to Bottom of the page
			IElementActions.scrollToBottom(driver);
			node.log(Status.INFO, "STEP36 : Scroll Webpage to the bottom of the page");
			System.out.println("STEP36 : Scroll webpage to bottom of the page");

			// Check the visibility of Back Step Button
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.backStepButton,
					"STEP37 : BUG: The Back Step Button is not coming in health step on interest payment page",
					"STEP37 : EXPECTED: The Back Step Button is coming in health step on interest payment page");

			// Check the visibility of Next Step Button
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.nextStepButton,
					"STEP38 : BUG: The Next Step Button is not coming in health step on interest payment page",
					"STEP38 : EXPECTED: The Next Step Button is coming in health step on interest payment page");

			// Check the visibility of New payment link text
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.newPaymentLinkText,
					"STEP39 : BUG: The New payment link text is not coming in health step on interest payment page",
					"STEP39 : EXPECTED: The New payment link text is coming in health step on interest payment page");

			// Check the visibility of Re-Calculate Tolerance Button
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.reCalculateToleranceButton,
					"STEP40 : BUG: The Re-Calculate Tolerance Button is not coming in health step on interest payment page",
					"STEP40 : EXPECTED: The Re-Calculate Tolerance Button is coming in health step on interest payment page");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateHealthStepDetails", "Pass", driver);

		} catch (AssertionError validateHealthStepDetails) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateHealthStepDetails test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateHealthStepDetails_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateHealthStepDetails.printStackTrace();
			node.fail(validateHealthStepDetails);
			Assert.fail();
			extent.flush();

		} catch (Exception validateHealthStepDetails) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateHealthStepDetails test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateHealthStepDetails_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateHealthStepDetails.printStackTrace();
			node.fail(validateHealthStepDetails);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _014
	@Test(priority = 3)
	public void validateInterestPaymentDate() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the interest payment date matches the 'Calculation End Date', and ensure that the 'Calculation End Date' is fetched from Step 1 (Compile), which was previously selected.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPage function from the FundingPage
			FundingPage.loadInterestPaymentPage();

			String year = getDataFromExcel(6);
			String month = getDataFromExcel(7);

			// Select Year from Year Dropdown
			IElementActions.selectValueFromDropdown(node, driver, FundingInterestPaymentPO.yearDropDown, year);
			node.log(Status.INFO, "STEP1 : Selected Year from the Year Dropdown");
			System.out.println("STEP1 : Selected Year from the Year Dropdown");

			// Select Month from Month Dropdown
			IElementActions.selectValueFromDropdown(node, driver, FundingInterestPaymentPO.monthDropDown, month);
			node.log(Status.INFO, "STEP2 : Selected Month from the Month Dropdown");
			System.out.println("STEP2 : Selected Month from the Month Dropdown");

			// Waiting for the visibility of Calculation End Date
			node.log(Status.INFO, "STEP3 : Waiting for the visibility of Calculation End Date");
			System.out.println("STEP3 : Waiting for the visibility of Calculation End Date");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.calEndDate);
			node.log(Status.INFO, "STEP4 : Calculation End Date is visible");
			System.out.println("STEP4 : Calculation End Date is visible");

			// Get the compile step calculation end date
			String compileStepCalEndDate = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.calEndDate);
			node.log(Status.INFO, "STEP5 : The compile step calculation end date : " + compileStepCalEndDate);
			System.out.println("STEP5 : The compile step calculation end date : " + compileStepCalEndDate);

			// Scroll to the Today's Date
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingInterestPaymentPO.todaysDate);
			node.log(Status.INFO, "STEP6 : Scrolled to the  today's date");
			System.out.println("STEP6 : Scrolled to the today's date");

			// Click on View interest first Button
			IElementActions.clickelement_usingXpath(node, driver, FundingInterestPaymentPO.firstViewInterestButton);
			node.log(Status.INFO, "STEP7 : clicked on the first View Interest Button");
			System.out.println("STEP7 : clicked on the first View Interest Button");

			// Wait for Page Load
			node.log(Status.INFO, "STEP8 : Waiting for the complete page loding");
			System.out.println("STEP8 : Waiting for the complete page loading");
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);
			node.log(Status.INFO, "STEP9 : Complete Page is load successfully");
			System.out.println("STEP9 : Complete Page is load successfully");

			// Get the interest payment date
			String interestPaymentDate = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.interestPaymentDateField);
			node.log(Status.INFO, "STEP10 : The interest payment date : " + interestPaymentDate);
			System.out.println("STEP10 : The interest payment date : " + interestPaymentDate);

			// Get the health step calculation end date
			String healthStepCalEndDate = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.calculationEndDateField);
			node.log(Status.INFO, "STEP11 : Get the health step calculation end date : " + healthStepCalEndDate);
			System.out.println("STEP11 : Get the health step calculation end date : " + compileStepCalEndDate);

			// Assert the Interest payment Date
			IElementActions.assertEquals_usingString(node, driver, healthStepCalEndDate, interestPaymentDate,
					"STEP12 : BUG : Interest payment date is not same as calculation end date",
					"STEP12 : PASS : Interest payment date is same as calculation end date");

			// Assert the Health Step Calculation End Date
			IElementActions.assertEquals_usingString(node, driver, compileStepCalEndDate, healthStepCalEndDate,
					"STEP13 : BUG : Health step calculation end date is not same as compile step calculation end date",
					"STEP13 : PASS : Health step calculation end date is same as compile step calculation end date");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateInterestPaymentDate", "Pass", driver);

		} catch (AssertionError validateInterestPaymentDate) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInterestPaymentDate test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateInterestPaymentDate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestPaymentDate.printStackTrace();
			node.fail(validateInterestPaymentDate);
			Assert.fail();
			extent.flush();

		} catch (Exception validateInterestPaymentDate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInterestPaymentDate test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateInterestPaymentDate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestPaymentDate.printStackTrace();
			node.fail(validateInterestPaymentDate);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _015
	@Test(priority = 4)
	public void validateCalculationStartDate() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the 'Calculation Start Date' is fetched from Step 1 (Compile), which was previously selected.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPage function from the FundingPage
			FundingPage.loadInterestPaymentPage();

			String year = getDataFromExcel(6);
			String month = getDataFromExcel(7);

			// Select Year from Year Dropdown
			IElementActions.selectValueFromDropdown(node, driver, FundingInterestPaymentPO.yearDropDown, year);
			node.log(Status.INFO, "STEP1 : Selected the Year from the Year Dropdown");
			System.out.println("STEP1 : Selected the Year from the Year Dropdown");

			// Select Month from Month Dropdown
			IElementActions.selectValueFromDropdown(node, driver, FundingInterestPaymentPO.monthDropDown, month);
			node.log(Status.INFO, "STEP2 : Selected the Month from the Month Dropdown");
			System.out.println("STEP2 : Selected the Month from the Month Dropdown");

			// Waiting for the visibility of Calculation Start Date
			node.log(Status.INFO, "STEP3 : Waiting for the visibility of Calculation Start Date");
			System.out.println("STEP3 : Waiting for the visibility of Calculation Start Date");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.calStartDate);
			node.log(Status.INFO, "STEP4 : Calculation Start Date is visible");
			System.out.println("STEP4 : Calculation Start Date is visible");

			// Get the compile step calculation Start date
			String compileStepCalStartDate = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.calStartDate);
			node.log(Status.INFO, "STEP5 : The compile step calculation start date : " + compileStepCalStartDate);
			System.out.println("STEP5 : The compile step calculation start date : " + compileStepCalStartDate);

			// Scroll to the Today's Date
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingInterestPaymentPO.todaysDate);
			node.log(Status.INFO, "STEP6 : Scrolled to the  today's date");
			System.out.println("STEP6 : Scrolled to the today's date");

			// Click on View interest first Button
			IElementActions.clickelement_usingXpath(node, driver, FundingInterestPaymentPO.firstViewInterestButton);
			node.log(Status.INFO, "STEP7 : clicked on the View Interest first Button");
			System.out.println("STEP7 : clicked on the View Interest first Button");

			// Wait for Page Load
			node.log(Status.INFO, "STEP8 : Waiting for the complete page loding");
			System.out.println("STEP8 : Waiting for the complete page loading");
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);
			node.log(Status.INFO, "STEP9 : Complete Page is load successfully");
			System.out.println("STEP9 : Complete Page is load successfully");

			// Get the health step calculation Start date
			String healthStepCalStartDate = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.calculationStartDateField);
			node.log(Status.INFO, "STEP10 : The health step calculation start date : " + healthStepCalStartDate);
			System.out.println("STEP10 : The health step calculation start date : " + healthStepCalStartDate);

			// Assert the Health Step Calculation Start Date
			IElementActions.assertEquals_usingString(node, driver, compileStepCalStartDate, healthStepCalStartDate,
					"STEP11 : BUG: Health step calculation start date is not same as compile step calculation start date",
					"STEP11 : PASS: Health step calculation start date is same as compile step calculation start date");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateCalculationStartDate", "Pass", driver);

		} catch (AssertionError validateCalculationStartDate) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCalculationStartDate test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCalculationStartDate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCalculationStartDate.printStackTrace();
			node.fail(validateCalculationStartDate);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCalculationStartDate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCalculationStartDate test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCalculationStartDate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCalculationStartDate.printStackTrace();
			node.fail(validateCalculationStartDate);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _016
	// TC_Funding_Interest _017
	@Test(priority = 5)
	public void validateSysetmHealthStatus() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the System Health Check displays green if all the health checks are green:"
							+ "Verify that if not all the health checks are displayed as green, the system health will be displayed as red.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Create dynamic locator for different tables
			String systemHealthLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.systemHealthCheckValue, "locatorValue", AllPagesData.systemHealthCheck);

			// Fetch values and colors for each health check
			String allAllocationsBalancedStatus = FundingPage.getHealthCheckStatus(driver,
					AllPagesData.allAllocationsBalancedCheck);
			String nimAnalysisStatus = FundingPage.getHealthCheckStatus(driver, AllPagesData.nimAnalysisCheck);
			String reservesStatus = FundingPage.getHealthCheckStatus(driver, AllPagesData.reservesCheck);
			String reserveReleasesStatus = FundingPage.getHealthCheckStatus(driver, AllPagesData.reserveReleasesCheck);
			String forecastToleranceStatus = FundingPage.getHealthCheckStatus(driver,
					AllPagesData.forecastToleranceCheck);
			String bridgeLoanRateDifferenceStatus = FundingPage.getHealthCheckStatus(driver,
					AllPagesData.bridgeLoanRateDifferenceToleranceCheck);
			String facilityRateMaxDifferenceStatus = FundingPage.getHealthCheckStatus(driver,
					AllPagesData.facilityRateMaxDifferenceToleranceCheck);

			// Determine overall System Health Check status
			String overallStatus = FundingPage.determineOverallStatus(allAllocationsBalancedStatus, nimAnalysisStatus,
					reservesStatus, reserveReleasesStatus, forecastToleranceStatus, bridgeLoanRateDifferenceStatus,
					facilityRateMaxDifferenceStatus);

			// Print overall status
			System.out.println("Overall Calculated System Health Check Status: " + overallStatus);
			node.log(Status.INFO, "Overall Calculated System Health Check Status:  : " + overallStatus);

			String systemHealthValue = IElementActions.getElementText_usingXpath(node, driver, systemHealthLocator);

			String overallCurrentSystemStatus = FundingPage
					.determineOverallStatus(FundingPage.getStatusColor(systemHealthValue));
			System.out.println("Current System Status " + overallCurrentSystemStatus);
			node.log(Status.INFO, "Current System Status " + overallCurrentSystemStatus);

			// Assert the System Health Locator status based on overall status
			if (overallCurrentSystemStatus.equalsIgnoreCase(overallStatus)) {
				Assert.assertTrue(true, "System Health status " + overallCurrentSystemStatus
						+ " is same as overallStatus " + overallStatus);

			} else {
				Assert.assertTrue(false, "System Health status " + overallCurrentSystemStatus
						+ " is not same as overallStatus " + overallStatus);
			}

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateSysetmHealthStatus", "Pass", driver);

		} catch (AssertionError validateSysetmHealthStatus) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateSysetmHealthStatus test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateSysetmHealthStatus_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSysetmHealthStatus.printStackTrace();
			node.fail(validateSysetmHealthStatus);
			Assert.fail();
			extent.flush();

		} catch (Exception validateSysetmHealthStatus) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateSysetmHealthStatus test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateSysetmHealthStatus_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSysetmHealthStatus.printStackTrace();
			node.fail(validateSysetmHealthStatus);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _018
	// TC_Funding_Interest _019
	@Test(priority = 6)
	public void validateAllAllocationsFourSideArrowIcon() throws IOException {

		try {
			extenttest = extent.createTest("Verify that the user is able to click on the four side arrow icon" + "_"
					+ "AllocationsBalancedDetailsPopupVisibility: Verify that the 'Allocations Balanced Details' popup opens and"
					+ " is displayed to the user when they click on the four-sided arrow icon.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.allAllocationFourSideArrowIcon,
					FundingInterestPaymentPO.allocationsBalancedPopup,
					FundingInterestPaymentPO.allocationsBalancedPopupHeader, "All Allocations Balanced");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateAllAllocationsFourSideArrowIcon", "Pass", driver);

		} catch (AssertionError validateAllAllocationsFourSideArrowIcon) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAllAllocationsFourSideArrowIcon test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllAllocationsFourSideArrowIcon_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllAllocationsFourSideArrowIcon.printStackTrace();
			node.fail(validateAllAllocationsFourSideArrowIcon);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAllAllocationsFourSideArrowIcon) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAllAllocationsFourSideArrowIcon test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllAllocationsFourSideArrowIcon_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllAllocationsFourSideArrowIcon.printStackTrace();
			node.fail(validateAllAllocationsFourSideArrowIcon);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _020
	// TC_Funding_Interest _021
	@Test(priority = 7)
	public void validateAllocationsBalancedPopupDetails() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the following sections are displayed on the 'Allocations Balanced Details' popup:"
							+ "-Allocations Balanced Analysis"
							+ "- Table listing [Date Difference and Amount Difference column]" + "_"
							+ "DetailsTextwithDownArrowIconVisibility: Verify that the user is able to see the 'Details text with arrow down icon'")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.allAllocationFourSideArrowIcon,
					FundingInterestPaymentPO.allocationsBalancedPopup,
					FundingInterestPaymentPO.allocationsBalancedPopupHeader, "All Allocations Balanced");

			// Check the visibility of Allocations Balanced Analysis text
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.allocationsBalancedAnalysis,
					"STEP1 : BUG: The Allocations Balanced Analysis text is not coming on All Allocations Balanced Details Popup",
					"STEP1 : EXPECTED: The Allocations Balanced Analysis text is coming on All Allocations Balanced Details Popup");

			// Check the visibility of Details Text with Arrow Down Icon
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon,
					"STEP2 : BUG: The Details Text with Arrow Down Icon is not coming on All Allocations Balanced Details Popup",
					"STEP2 : EXPECTED: The Details Text with Arrow Down Icon is coming on All Allocations Balanced Details Popup");

			// Check the visibility of Date Differecce column header
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.dateDifference,
					"STEP3 : BUG: The Date Differecce column header is not coming on All Allocations Balanced Details Popup",
					"STEP3 : EXPECTED: The Date Differecce column header is coming on All Allocations Balanced Details Popup");

			// Check the visibility of Amount Differecce column header
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.amountDifference,
					"STEP4 : BUG: The Amount Differecce column header is not coming on All Allocations Balanced Details Popup",
					"STEP4 : EXPECTED: The Amount Differecce column header is coming on All Allocations Balanced Details Popup");

			// Check the visibility of Date Difference column values
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.dateDifferenceValues,
					"STEP5 : BUG: The Date Difference column values are not coming in Date Difference column on All Allocations Balanced Details Popup",
					"STEP5 : EXPECTED: The Date Difference column values are coming in Date Difference column on All Allocations Balanced Details Popup");

			// Check the visibility of Amount Difference column values
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.amountDifferenceValues,
					"STEP6 : BUG: The Amount Difference column values are not coming in Amount Difference column on All Allocations Balanced Details Popup",
					"STEP6 : EXPECTED: The Amount Difference column values are coming in Amount Difference column on All Allocations Balanced Details Popup");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateAllAllocationsFourSideArrowIcon", "Pass", driver);

		} catch (AssertionError validateAllAllocationsFourSideArrowIcon) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAllAllocationsFourSideArrowIcon test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllAllocationsFourSideArrowIcon_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllAllocationsFourSideArrowIcon.printStackTrace();
			node.fail(validateAllAllocationsFourSideArrowIcon);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAllAllocationsFourSideArrowIcon) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAllAllocationsFourSideArrowIcon test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllAllocationsFourSideArrowIcon_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllAllocationsFourSideArrowIcon.printStackTrace();
			node.fail(validateAllAllocationsFourSideArrowIcon);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _022
	@Test(priority = 8)
	public void validateDetailsArrowDownIcon() throws IOException {

		try {
			extenttest = extent.createTest("Verify that the user is able to click on the Details arrow down icon.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2
			// of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.allAllocationFourSideArrowIcon,
					FundingInterestPaymentPO.allocationsBalancedPopup,
					FundingInterestPaymentPO.allocationsBalancedPopupHeader, "All Allocations Balanced");

			// Calling the validateDetailsTextArrowIcon function from Funding page
			FundingPage.validateDetailsTextArrowIcon(FundingInterestPaymentPO.detailsArrowIcon,
					FundingInterestPaymentPO.facilityAllocationTable, FundingInterestPaymentPO.detailsUpSideArrowIcon,
					"All Allocations Balanced", "validateDetailsArrowDownIcon");

		} catch (AssertionError validateDetailsArrowDownIcon) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDetailsArrowDownIcon test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDetailsArrowDownIcon_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDetailsArrowDownIcon.printStackTrace();
			node.fail(validateDetailsArrowDownIcon);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDetailsArrowDownIcon) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDetailsArrowDownIcon test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDetailsArrowDownIcon_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDetailsArrowDownIcon.printStackTrace();
			node.fail(validateDetailsArrowDownIcon);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _023
	@Test(priority = 9)
	public void validateFacilitysTotalAllocationVisibility() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user can view the list of each facility's total allocation in a table format, detailed date-wise when clicking on the Details dropdown arrow icon.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			String facilityReference = getDataFromExcel(9);

			// create Dynamic Locator for Facility All Allocations
			String facilityAllAllocationsLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.facilityAllAllocations, "locatorValue", facilityReference);

			String facilityAllocationAllDatesLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.facilityAllocationAllDates, "locatorValue", facilityReference);

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.allAllocationFourSideArrowIcon,
					FundingInterestPaymentPO.allocationsBalancedPopup,
					FundingInterestPaymentPO.allocationsBalancedPopupHeader, "All Allocations Balanced");

			// Clicked On Down Arrow icon of Details Text
			IElementActions.clickelement_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon);
			node.log(Status.INFO, "STEP1 : Clicked on Details Text Down Arrow icon");
			System.out.println("STEP1 : Clicked on Details Text Down Arrow icon");

			// Check the visibility of facility allocation for each date
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.facilityAllocations,
					"STEP2 : BUG: The Facility Allocations are not coming date wise on All Allocations Balanced Details Popup",
					"STEP2 : EXPECTED: The Facility Allocations are coming date wise on All Allocations Balanced Details Popup");

			// Check the visibility of facility allocation
			IElementActions.assertTrue_usingXpath(node, driver, facilityAllAllocationsLocator,
					"STEP3 : BUG: The Facility Allocations are not coming",
					"STEP3 : EXPECTED: The Facility Allocations are coming");

			// Check the visibility of facility allocation for each date
			IElementActions.assertTrue_usingXpath(node, driver, facilityAllocationAllDatesLocator,
					"STEP4 : BUG: The Facility Allocations are not coming date wise on All Allocations Balanced Details Popup",
					"STEP4 : EXPECTED: The Facility Allocations are coming date wise on All Allocations Balanced Details Popup");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilitysTotalAllocationVisibility", "PASS", driver);

		} catch (AssertionError validateFacilitysTotalAllocationVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilitysTotalAllocationVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilitysTotalAllocationVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilitysTotalAllocationVisibility.printStackTrace();
			node.fail(validateFacilitysTotalAllocationVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilitysTotalAllocationVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilitysTotalAllocationVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilitysTotalAllocationVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilitysTotalAllocationVisibility.printStackTrace();
			node.fail(validateFacilitysTotalAllocationVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _024
	@Test(priority = 10)
	public void validateCloseButton() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user is able to close the All Allocations Balanced popup while clicking on the close button.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.allAllocationFourSideArrowIcon,
					FundingInterestPaymentPO.allocationsBalancedPopup,
					FundingInterestPaymentPO.allocationsBalancedPopupHeader, "All Allocations Balanced");

			// Calling the validatePopupClose function from Funding Page
			FundingPage.validatePopupClose(FundingInterestPaymentPO.closeButton,
					FundingInterestPaymentPO.allocationsBalancedPopup, "Close", "All Allocations Balanced");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateCloseButton", "PASS", driver);

		} catch (AssertionError validateCloseButton) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCloseButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCloseButton_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCloseButton.printStackTrace();
			node.fail(validateCloseButton);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCloseButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCloseButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCloseButton_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCloseButton.printStackTrace();
			node.fail(validateCloseButton);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _025
	@Test(priority = 11)
	public void validateXIconButton() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user is able to close the All Allocations Balanced popup while clicking on the X icon.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.allAllocationFourSideArrowIcon,
					FundingInterestPaymentPO.allocationsBalancedPopup,
					FundingInterestPaymentPO.allocationsBalancedPopupHeader, "All Allocations Balanced");

			// Calling the validatePopupClose function from Funding Page
			FundingPage.validatePopupClose(FundingInterestPaymentPO.closeButton,
					FundingInterestPaymentPO.allocationsBalancedPopup, "X Icon", "All Allocations Balanced");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateXIconButton", "PASS", driver);

		} catch (AssertionError validateXIconButton) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateXIconButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateXIconButton_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateXIconButton.printStackTrace();
			node.fail(validateXIconButton);
			Assert.fail();
			extent.flush();

		} catch (Exception validateXIconButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateXIconButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateXIconButton_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateXIconButton.printStackTrace();
			node.fail(validateXIconButton);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _026
	@Test(priority = 12)
	public void validateFacilityTableDetails() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the user is able to see the following details:" + "-Date Range column-wise"
							+ "-Difference" + "-Loan Allocation" + "-Facility Allocation" + "-All Facility ref list")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.allAllocationFourSideArrowIcon,
					FundingInterestPaymentPO.allocationsBalancedPopup,
					FundingInterestPaymentPO.allocationsBalancedPopupHeader, "All Allocations Balanced");

			// Check the visibility of Details Text with Arrow Down Icon
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon,
					"STEP1 : BUG: The Details Text with Arrow Down Icon is not coming on All Allocations Balanced Details Popup",
					"STEP1 : EXPECTED: The Details Text with Arrow Down Icon is coming on All Allocations Balanced Details Popup");

			// Clicked On Down Arrow icon of Details Text
			IElementActions.clickelement_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon);
			node.log(Status.INFO, "STEP2 : Clicked on Details Text Down Arrow icon");
			System.out.println("STEP2 : Clicked on Details Text Down Arrow icon");

			// Check the visibility of dates
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.dates,
					"STEP3 : BUG: The Dates are not coming column wise on All Allocations Balanced Details Popup",
					"STEP3 : EXPECTED: The Dates are coming column wise on All Allocations Balanced Details Popup");

			// Check the visibility of diffrence for each date
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.differences,
					"STEP4 : BUG: The Differences are not coming date wise on All Allocations Balanced Details Popup",
					"STEP4 : EXPECTED: The Differences are coming date wise on All Allocations Balanced Details Popup");

			// Check the visibility of loan allocation for each date
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.loanAllocations,
					"STEP5 : BUG: The Loan Allocations are not coming date wise on All Allocations Balanced Details Popup",
					"STEP5 : EXPECTED: The Loan Allocations are coming date wise on All Allocations Balanced Details Popup");

			// Check the visibility of facility allocation for each date
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.facilityAllocations,
					"STEP6 : BUG: The Facility Allocations are not coming date wise on All Allocations Balanced Details Popup",
					"STEP6 : EXPECTED: The Facility Allocations are coming date wise on All Allocations Balanced Details Popup");

			// Check the visibility of All facilities reference list
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.allFacilitiesRefList,
					"STEP7 : BUG: The All facilites reference list is not coming on All Allocations Balanced Details Popup",
					"STEP7 : EXPECTED: The All facilites reference list is coming on All Allocations Balanced Details Popup");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityTableDetails", "PASS", driver);

		} catch (AssertionError validateFacilityTableDetails) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityTableDetails test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFacilityTableDetails_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityTableDetails.printStackTrace();
			node.fail(validateFacilityTableDetails);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityTableDetails) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityTableDetails test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFacilityTableDetails_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityTableDetails.printStackTrace();
			node.fail(validateFacilityTableDetails);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _029
	@Test(priority = 13)
	public void validateLoanAndFacilityAllocationDifference() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the Difference is calculated as Loan Allocation - Facility Allocation.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.allAllocationFourSideArrowIcon,
					FundingInterestPaymentPO.allocationsBalancedPopup,
					FundingInterestPaymentPO.allocationsBalancedPopupHeader, "All Allocations Balanced");

			// Check the visibility of Details Text with Arrow Down Icon
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon,
					"STEP1 : BUG: The Details Text with Arrow Down Icon is not coming on All Allocations Balanced Details Popup",
					"STEP1 : EXPECTED: The Details Text with Arrow Down Icon is coming on All Allocations Balanced Details Popup");

			// Clicked On Down Arrow icon of Details Text
			FundingPage.clickOnDetailArrowIcon(FundingInterestPaymentPO.detailsArrowIcon,
					FundingInterestPaymentPO.dates);

			// Verify the allocation difference for multiple loan and facility pairs
			FundingPage.verifyAllocationDifference(driver);

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanAndFacilityAllocationDifference", "PASS", driver);

		} catch (AssertionError validateLoanAndFacilityAllocationDifference) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanAndFacilityAllocationDifference test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanAndFacilityAllocationDifference_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanAndFacilityAllocationDifference.printStackTrace();
			node.fail(validateLoanAndFacilityAllocationDifference);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanAndFacilityAllocationDifference) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanAndFacilityAllocationDifference test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanAndFacilityAllocationDifference_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanAndFacilityAllocationDifference.printStackTrace();
			node.fail(validateLoanAndFacilityAllocationDifference);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _031
	@Test(priority = 15)
	public void validateAllAlocationHealthStatus() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the if 'Difference' is not equal to zero of any date then the entire health check will therefore display as red")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Fetch values and colors for each health check
			String allAllocationsBalancedValue = FundingPage.getHealthCheckStatus(driver,
					AllPagesData.allAllocationsBalancedCheck);
			System.out.println("Step1 : All Allocations Balanced Value is " + allAllocationsBalancedValue);
			node.log(Status.INFO, "Step1 : All Allocations Balanced Value is " + allAllocationsBalancedValue);

			// Calling the determineOverallStatus from FundingPage
			String actualStatus = FundingPage
					.determineOverallStatus(FundingPage.getStatusColor(allAllocationsBalancedValue));
			System.out.println("Step2 : Current All Allocations Balanced Status " + actualStatus);
			node.log(Status.INFO, "Step2 : Current All Allocations Balanced Status " + actualStatus);

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.allAllocationFourSideArrowIcon,
					FundingInterestPaymentPO.allocationsBalancedPopup,
					FundingInterestPaymentPO.allocationsBalancedPopupHeader, "All Allocations Balanced");

			boolean isAmountDifferencePresent = IElementActions.isElementPresent(driver,
					FundingInterestPaymentPO.amountDifferenceValues);
			node.log(Status.INFO, "Step3 : Amount is visibile " + isAmountDifferencePresent);
			System.out.println("Step3 : Amount is visibile " + isAmountDifferencePresent);

			// Assert the System Health Locator status based on overall status
			if (isAmountDifferencePresent) {

				IElementActions.assertEquals_usingString(node, driver, "No", actualStatus,
						"BUG: Difference in amount is present, but not matching with red(No) status " + actualStatus,
						"PASS: Difference in amount is present, and matching with red(No) status " + actualStatus);

			} else {
				IElementActions.assertEquals_usingString(node, driver, "Yes", actualStatus,
						"BUG: Difference in amount is present, but not matching with green(Yes) status " + actualStatus,
						"PASS: Difference in amount is present, and matching with green(Yes) status " + actualStatus);
			}

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateAllAlocationHealthStatus", "PASS", driver);

		} catch (AssertionError validateAllAlocationHealthStatus) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAllAlocationHealthStatus test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllAlocationHealthStatus_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllAlocationHealthStatus.printStackTrace();
			node.fail(validateAllAlocationHealthStatus);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAllAlocationHealthStatus) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAllAlocationHealthStatus test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllAlocationHealthStatus_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllAlocationHealthStatus.printStackTrace();
			node.fail(validateAllAlocationHealthStatus);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _032
	@Test(priority = 16)
	public void validateSortIconVisibility() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the user is able to see the sorting in the below column:"
							+ "-Date Difference" + "-Amount Difference")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.allAllocationFourSideArrowIcon,
					FundingInterestPaymentPO.allocationsBalancedPopup,
					FundingInterestPaymentPO.allocationsBalancedPopupHeader, "All Allocations Balanced");

			// Check the visibility of Sort icon of Date Difference column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.dateDifferenceSortIcon,
					"STEP1 : BUG: The sort Icon is not coming in date difference column header on All Allocations Balanced Details Popup",
					"STEP1 : EXPECTED: The sort Icon is coming in date difference column header on All Allocations Balanced Details Popup");

			// Check the visibility of Sort icon of Amount Difference column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.amountDifferenceSortIcon,
					"STEP2 : BUG: The sort Icon is not coming in amount difference column header on All Allocations Balanced Details Popup",
					"STEP2 : EXPECTED: The sort Icon is coming in amount difference column header on All Allocations Balanced Details Popup");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateSortIconVisibility", "PASS", driver);

		} catch (AssertionError validateSortIconVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateSortIconVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateSortIconVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSortIconVisibility.printStackTrace();
			node.fail(validateSortIconVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateSortIconVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateSortIconVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateSortIconVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSortIconVisibility.printStackTrace();
			node.fail(validateSortIconVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _033
	@Test(priority = 17)
	public void validateDateAndAmountDifferenceSorting() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the user is able to see the sorting in the below column:"
							+ "-Date Difference" + "-Amount Difference")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.allAllocationFourSideArrowIcon,
					FundingInterestPaymentPO.allocationsBalancedPopup,
					FundingInterestPaymentPO.allocationsBalancedPopupHeader, "All Allocations Balanced");

			// Check the visibility of Sort icon of Date Difference column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.dateDifferenceSortIcon,
					"STEP1 : BUG: The sort Icon is not coming in date difference column header on All Allocations Balanced Details Popup",
					"STEP1 : EXPECTED: The sort Icon is coming in date difference column header on All Allocations Balanced Details Popup");

			// Check the ascending order for Date Difference column
			Utils.validateDateSorting(node, driver, FundingInterestPaymentPO.dateDifferenceValues, "ascending",
					"validateDateAndAmountDifferenceSorting", "dd/MM/yyyy", "LocalDate");

			// Check the visibility of Sort icon of Amount Difference column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.amountDifferenceSortIcon,
					"STEP2 : BUG: The sort Icon is not coming in amount difference column header on All Allocations Balanced Details Popup",
					"STEP2 : EXPECTED: The sort Icon is coming in amount difference column header on All Allocations Balanced Details Popup");

			// Check the ascending order for Amount Difference column
			Utils.validateDataSorting(node, driver, FundingInterestPaymentPO.amountDifferenceValues, "ascending",
					"validateDateAndAmountDifferenceSorting");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDateAndAmountDifferenceSorting", "PASS", driver);

		} catch (AssertionError validateDateAndAmountDifferenceSorting) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDateAndAmountDifferenceSorting test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDateAndAmountDifferenceSorting_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDateAndAmountDifferenceSorting.printStackTrace();
			node.fail(validateDateAndAmountDifferenceSorting);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDateAndAmountDifferenceSorting) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDateAndAmountDifferenceSorting test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDateAndAmountDifferenceSorting_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDateAndAmountDifferenceSorting.printStackTrace();
			node.fail(validateDateAndAmountDifferenceSorting);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _034
	@Test(priority = 18)
	public void validateNonZeroAmountDifferenceDate() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user can see only those dates in the table list where the amount difference is not equal to zero."
							+ "-Date Difference" + "-Amount Difference")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.allAllocationFourSideArrowIcon,
					FundingInterestPaymentPO.allocationsBalancedPopup,
					FundingInterestPaymentPO.allocationsBalancedPopupHeader, "All Allocations Balanced");

			// Clicked On Down Arrow icon of Details Text
			FundingPage.clickOnDetailArrowIcon(FundingInterestPaymentPO.detailsArrowIcon,
					FundingInterestPaymentPO.dates);

			List<WebElement> differenceDates = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.dates);

			List<WebElement> differenceOfFacilityLoanAllocation = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.differences);

			// Declare a list to store elements with differences greater than 0
			List<Integer> expectedDifference = new ArrayList<>();

			// Declare a list to store elements dates having differences greater than 0
			List<String> expectedDifferenceDates = new ArrayList<>();

			// Declare a list to store elements with differences greater than 0
			List<Integer> actualAmountDifference = new ArrayList<>();

			// Declare a list to store elements dates having differences greater than 0
			List<String> actualDifferenceDates = new ArrayList<>();

			// Loop through the elements and verify the allocation difference for each pair
			for (int i = 0; i < differenceOfFacilityLoanAllocation.size(); i++) {
				WebElement differenceOfAllocationElement = differenceOfFacilityLoanAllocation.get(i);
				// Extract the text values of these elements
				String differenceOfAllocationText = differenceOfAllocationElement.getText().trim();
				int differenceOfAllocation = Utils.removeCurrencyAndParseToInt(differenceOfAllocationText);

				WebElement differenceDatesElement = differenceDates.get(i);
				// Extract the text values of these elements
				String differenceDatesText = differenceDatesElement.getText().trim();
				String desiredDateString = Utils.convertDashDateToSlash(differenceDatesText);

				if (differenceOfAllocation != 0) {
					expectedDifference.add(differenceOfAllocation);
					expectedDifferenceDates.add(desiredDateString);
				}

				List<WebElement> dateDifferenceOfElements = IElementActions.returnElements(node, driver,
						FundingInterestPaymentPO.dateDifferenceValues);
				WebElement dateDifferenceOfElement = dateDifferenceOfElements.get(i);
				// Extract the text values of these elements
				String dateDifferenceText = dateDifferenceOfElement.getText().trim();
				actualDifferenceDates.add(dateDifferenceText);

				List<WebElement> amountDifferenceOfElements = IElementActions.returnElements(node, driver,
						FundingInterestPaymentPO.amountDifferenceValues);
				WebElement amountDifferenceOfElement = amountDifferenceOfElements.get(i);
				// Extract the text values of these elements
				String amountDifferencText = amountDifferenceOfElement.getText().trim();
				int amountDifference = Utils.removeCurrencyAndParseToInt(amountDifferencText);
				actualAmountDifference.add(amountDifference);
			}

			// Compare the two lists
			Assert.assertEquals(actualDifferenceDates, expectedDifferenceDates, "Actual dates value "
					+ actualDifferenceDates + " do not match with expected dates value " + expectedDifferenceDates);

			// Compare the two lists
			Assert.assertEquals(actualAmountDifference, expectedDifference,
					"Actual amount difference value " + actualAmountDifference
							+ " do not match with expected amount difference value " + expectedDifference);
			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateNonZeroAmountDifferenceDate", "PASS", driver);

		} catch (AssertionError validateNonZeroAmountDifferenceDate) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNonZeroAmountDifferenceDate test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNonZeroAmountDifferenceDate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNonZeroAmountDifferenceDate.printStackTrace();
			node.fail(validateNonZeroAmountDifferenceDate);
			Assert.fail();
			extent.flush();

		} catch (Exception validateNonZeroAmountDifferenceDate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNonZeroAmountDifferenceDate test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNonZeroAmountDifferenceDate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNonZeroAmountDifferenceDate.printStackTrace();
			node.fail(validateNonZeroAmountDifferenceDate);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _035
	// TC_Funding_Interest _036
	@Test(priority = 19)
	public void validateNIMAnalysisFourSideArrowIcon() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the user is able to click on the four side arrow icon" + "_"
							+ "NIMAnalysisDetailsPopupVisibility: Verify that the 'NIM Analysis Details' popup "
							+ "opens and is displayed to the user when they click on the four-sided arrow icon.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateNIMAnalysisFourSideArrowIcon", "Pass", driver);

		} catch (AssertionError validateNIMAnalysisFourSideArrowIcon) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNIMAnalysisFourSideArrowIcon test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNIMAnalysisFourSideArrowIcon_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNIMAnalysisFourSideArrowIcon.printStackTrace();
			node.fail(validateNIMAnalysisFourSideArrowIcon);
			Assert.fail();
			extent.flush();

		} catch (Exception validateNIMAnalysisFourSideArrowIcon) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNIMAnalysisFourSideArrowIcon test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNIMAnalysisFourSideArrowIcon_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNIMAnalysisFourSideArrowIcon.printStackTrace();
			node.fail(validateNIMAnalysisFourSideArrowIcon);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _037
	@Test(priority = 20)
	public void validateNIMAnalysisPopupDetails() throws IOException {

		try {
			extenttest = extent
					.createTest(
							"Verify that the following fields are displayed on the 'NIM Analysis Details' popup:\r\n"
									+ "-Interest Income" + "-Interest Expense" + "-Net Interest Margin"
									+ "-Cash Interest" + "-Regular Interest" + "-Default Interest"
									+ "-Net Interest Margin" + "-NIM Check" + "-Close[Button]" + "-X icon")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Check the visibility of interest Income field
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestIncomeField,
					"STEP1 : BUG: The interest income field is not coming on NIM Analysis Details Popup",
					"STEP1 : EXPECTED: The interest income field is coming on NIM Analysis Details Popup");

			// Check the visibility of interest expense field
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestExpenseField,
					"STEP2 : BUG: The interest expense field is not coming on NIM Analysis Details Popup",
					"STEP2 : EXPECTED: The interest expense field is coming on NIM Analysis Details Popup");

			// Check the visibility of net interest margin field
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.netInterestMarginField,
					"STEP3 : BUG: The net interest margin field is not coming on NIM Analysis Details Popup",
					"STEP3 : EXPECTED: The net interest margin field is coming on NIM Analysis Details Popup");

			// Check the visibility of nim Check
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.nimCheck,
					"STEP4 : BUG: The nim Check is not coming on NIM Analysis Details Popup",
					"STEP4 : EXPECTED: The nim Check is coming on NIM Analysis Details Popup");

			// Check the visibility of cash interest field
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.cashInterestField,
					"STEP5 : BUG: The cash interest field is not coming on NIM Analysis Details Popup",
					"STEP5 : EXPECTED: The cash interest field field is coming on NIM Analysis Details Popup");

			// Check the visibility of regualr interest field
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.regularInterestField,
					"STEP6 : BUG: The regular interest field is not coming on NIM Analysis Details Popup",
					"STEP6 : EXPECTED: The regular interest field is coming on NIM Analysis Details Popup");

			// Check the visibility of default interest field
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.defaultInterestField,
					"STEP7 : BUG: The default interest field is not coming on NIM Analysis Details Popup",
					"STEP7 : EXPECTED: The default interest field is coming on NIM Analysis Details Popup");

			// Check the visibility of net interest margin field
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.netInterestMarginsField,
					"STEP8 : BUG: The net interest margin field is not coming on NIM Analysis Details Popup",
					"STEP8 : EXPECTED: The net interest margin field is coming on NIM Analysis Details Popup");

			// Check the visibility of X icon Button
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.closeButton,
					"STEP9 : BUG: The X icon Button is not coming on NIM Analysis Details Popup",
					"STEP9 : EXPECTED: The X icon Button is coming on NIM Analysis Details Popup");

			// Check the visibility of close Button
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.closeButton,
					"STEP10 : BUG: The close Button is not coming on NIM Analysis Details Popup",
					"STEP10 : EXPECTED: The close Button is coming on NIM Analysis Details Popup");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateNIMAnalysisPopupDetails", "Pass", driver);

		} catch (AssertionError validateNIMAnalysisPopupDetails) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNIMAnalysisPopupDetails test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNIMAnalysisPopupDetails_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNIMAnalysisPopupDetails.printStackTrace();
			node.fail(validateNIMAnalysisPopupDetails);
			Assert.fail();
			extent.flush();

		} catch (Exception validateNIMAnalysisPopupDetails) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNIMAnalysisPopupDetails test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNIMAnalysisPopupDetails_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNIMAnalysisPopupDetails.printStackTrace();
			node.fail(validateNIMAnalysisPopupDetails);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _038
	@Test(priority = 21)
	public void validateInterestIncomeAmount() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the Interest Income amount displayed matches the "
							+ "payable loan value shown in the Facility section under Step 2.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Scroll down to Facility Header
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingInterestPaymentPO.facility);
			node.log(Status.INFO, "STEP1 : Scrolled down to Facility Header");
			System.out.println("STEP1 : Scrolled down to Facility Header");

			// Get the Facility Loan Amount
			String facilityLoanAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.facilityLoanAmount);
			node.log(Status.INFO, "STEP2 : The Facility Loan Amount : " + facilityLoanAmount);
			System.out.println("STEP2 : The Facility Loan Amount : " + facilityLoanAmount);

			// Scroll up to system Health Check
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingInterestPaymentPO.systemHealthCheck);
			node.log(Status.INFO, "STEP3 : Scrolled up to System Health Check label");
			System.out.println("STEP3 : Scrolled up to System Health Check label");

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Check the visibility of interest Income field
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestIncomeField,
					"STEP4 : BUG: The interest income field is not coming on NIM Analysis Details Popup",
					"STEP4 : EXPECTED: The interest income field is coming on NIM Analysis Details Popup");

			// Get the Interest Income Amount
			String interestIncomeAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.interestIncomeField);
			node.log(Status.INFO, "STEP5 : The Interest Income Amount : " + interestIncomeAmount);
			System.out.println("STEP5 : The Interest Income Amount : " + interestIncomeAmount);

			// Assert the Interest Income Amount
			IElementActions.assertEquals_usingString(node, driver, interestIncomeAmount, facilityLoanAmount,
					"STEP6 : BUG : Interest Income Amount is not same as Facility Loan Amount",
					"STEP6 : PASS : Interest Income Amount is same as Facility Loan Amount");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateInterestIncomeAmount", "Pass", driver);

		} catch (AssertionError validateInterestIncomeAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInterestIncomeAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateInterestIncomeAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestIncomeAmount.printStackTrace();
			node.fail(validateInterestIncomeAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateInterestIncomeAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInterestIncomeAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateInterestIncomeAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestIncomeAmount.printStackTrace();
			node.fail(validateInterestIncomeAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _039
	@Test(priority = 22)
	public void validateInterestExpenseAmount() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the Interest Expense amount displayed matches the total"
							+ "facility amount shown in the Facility section under Step 2.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Scroll down to Facility Header
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingInterestPaymentPO.facility);
			node.log(Status.INFO, "STEP1 : Scrolled down to Facility Header");
			System.out.println("STEP1 : Scrolled down to Facility Header");

			// Get the Facility Total Amount
			String facilityTotalAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.totalLoanAmount);
			node.log(Status.INFO, "STEP2 : The facility Total Amount : " + facilityTotalAmount);
			System.out.println("STEP2 : The facility Total Amount : " + facilityTotalAmount);

			// Scroll up to system Health Check
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingInterestPaymentPO.systemHealthCheck);
			node.log(Status.INFO, "STEP3 : Scrolled up to System Health Check label");
			System.out.println("STEP3 : Scrolled up to System Health Check label");

			// Call the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Check the visibility of interest expense field
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestExpenseField,
					"STEP4 : BUG: The interest expense field is not coming on NIM Analysis Details Popup",
					"STEP4 : EXPECTED: The interest expense field is coming on NIM Analysis Details Popup");

			// Get the Interest Expense Amount
			String interestExpenseAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.interestExpenseField);
			node.log(Status.INFO, "STEP5 : The Interest Expense Amount : " + interestExpenseAmount);
			System.out.println("STEP5 : The Interest Expense Amount : " + interestExpenseAmount);

			// Assert the Interest Expense Amount
			IElementActions.assertEquals_usingString(node, driver, interestExpenseAmount, facilityTotalAmount,
					"STEP6 : BUG : Interest Expense Amount is not same as Facility Total Amount",
					"STEP6 : PASS : Interest Expense Amount is same as Facility Total Amount");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateInterestExpenseAmount", "Pass", driver);

		} catch (AssertionError validateInterestExpenseAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInterestExpenseAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestExpenseAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestExpenseAmount.printStackTrace();
			node.fail(validateInterestExpenseAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateInterestExpenseAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInterestExpenseAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestExpenseAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestExpenseAmount.printStackTrace();
			node.fail(validateInterestExpenseAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _040
	@Test(priority = 23)
	public void validateNetInterestMarginAmount() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify the Net Interest Margin is calculated as [Income - Interest Expense].")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Get the Interest Income Amount
			int interestIncomeAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.interestIncomeField);

			// Get the Interest Expense Amount
			int interestExpenseAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.interestExpenseField);

			// Get the Interest Margin Amount
			int actualNetInterestMarginAmount = Utils
					.getTextAndParseToInt(FundingInterestPaymentPO.netInterestMarginField);

			// Calling calculateDifference function from Utils
			int expectedNetInterestMarginAmount = Utils.calculateDifference(interestIncomeAmount,
					interestExpenseAmount);
			node.log(Status.INFO, "STEP1 : Calculated Net Interest Margin Amount : " + expectedNetInterestMarginAmount);
			System.out.println(
					"STEP1 :  Calculated Expected Net Interest Margin Amount : " + expectedNetInterestMarginAmount);

			// Assert the Net Interest Margin Amount
			IElementActions.assertEquals_usingInteger(node, driver, actualNetInterestMarginAmount,
					expectedNetInterestMarginAmount,
					"STEP2 :  BUG : The Net Interest Margin is not same as calculated from [Income - Interest Expense] formula",
					"STEP2 : PASS : The Net Interest Margin is same as calculated from [Income - Interest Expense] formula");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateNetInterestMarginAmount", "Pass", driver);

		} catch (AssertionError validateNetInterestMarginAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNetInterestMarginAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNetInterestMarginAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNetInterestMarginAmount.printStackTrace();
			node.fail(validateNetInterestMarginAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateNetInterestMarginAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNetInterestMarginAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNetInterestMarginAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNetInterestMarginAmount.printStackTrace();
			node.fail(validateNetInterestMarginAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _041
	@Test(priority = 24)
	public void validateCashInterestAmount() throws IOException {

		try {
			extenttest = extent.createTest("Verify the Cash Interest is equal to the Facility totals cash interest")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Call the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Check the visibility of cash interest field
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.cashInterestField,
					"STEP1 : BUG: The cash interest field is not coming on NIM Analysis Details Popup",
					"STEP1 : EXPECTED: The cash interest field field is coming on NIM Analysis Details Popup");

			// Get the Cash Interest Amount
			String cashInterestAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.cashInterestField);
			node.log(Status.INFO, "STEP2 : The Cash Interest Amount : " + cashInterestAmount);
			System.out.println("STEP2 : The Cash Interest Amount : " + cashInterestAmount);

			// Check the Visibility of Details text with arrow down icon
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon,
					"STEP3 : BUG: The Details text with arrow down icon is not coming on NIM Analysis Details Popup",
					"STEP3 : EXPECTED: The Details text with arrow down icon is coming on NIM Analysis Details Popup");

			// Click on Details text with down arrow icon
			IElementActions.clickelement_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon);
			node.log(Status.INFO, "STEP4 : Clicked on Details text with arrow down icon");
			System.out.println("STEP4 : Clicked on Details text with arrow down icon");

			// Check the Visibility of facility totals cash interest amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.facilityTotalsCashInterest,
					"STEP5 : BUG: The facility totals cash interest is not coming on NIM Analysis Details Popup",
					"STEP5 : EXPECTED: The facility totals cash interest is coming on NIM Analysis Details Popup");

			// Get the facility totals cash interest amount
			String facilityTotalsCashInterestAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.facilityTotalsCashInterest);
			node.log(Status.INFO,
					"STEP6 : The Facility Totals Cash Interest Amount : " + facilityTotalsCashInterestAmount);
			System.out
					.println("STEP6 : The Facility Totals Cash Interest Amount : " + facilityTotalsCashInterestAmount);

			// Assert the Cash Interest Amount
			IElementActions.assertEquals_usingString(node, driver, cashInterestAmount, facilityTotalsCashInterestAmount,
					"STEP7 : BUG: The Cash Interest Amount is not same as facility totals cash interest amount",
					"STEP7 : PASS : The Cash Interest Amount is same as facility totals cash interest amount");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashInterestAmount", "Pass", driver);

		} catch (AssertionError validateCashInterestAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashInterestAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCashInterestAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashInterestAmount.printStackTrace();
			node.fail(validateCashInterestAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCashInterestAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashInterestAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCashInterestAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashInterestAmount.printStackTrace();
			node.fail(validateCashInterestAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _042
	@Test(priority = 25)
	public void validateRegularInterestAmount() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify the Regular Interest is calculated as [loans regular interest - Facility totals regular interest].")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Check the Visibility of Details text with arrow down icon
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon,
					"STEP1 : BUG: The Details text with arrow down icon is not coming on NIM Analysis Details Popup",
					"STEP1 : EXPECTED: The Details text with arrow down icon is coming on NIM Analysis Details Popup");

			// Click on Details text with down arrow icon
			IElementActions.clickelement_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon);
			node.log(Status.INFO, "STEP2 : Clicked on Details text with arrow down icon");
			System.out.println("STEP2 : Clicked on Details text with arrow down icon");

			// Get the Loans Regular Interest Amount
			int loansRegularInterest = Utils.getTextAndParseToInt(FundingInterestPaymentPO.loansRegularInterest);

			// Get the Facility Totals Regular Interest Amount
			int facilityTotalsRegularInterest = Utils
					.getTextAndParseToInt(FundingInterestPaymentPO.facilityTotalsRegularInterest);

			// Get the Actual Regular Interest
			int actualRegularInterest = Utils.getTextAndParseToInt(FundingInterestPaymentPO.regularInterestField);

			// Call calculateDifference function from Utils
			int expectedRegualarInterestAmount = Utils.calculateDifference(loansRegularInterest,
					facilityTotalsRegularInterest);
			node.log(Status.INFO, "STEP3 : Calculated Regualar Interest Amount : " + expectedRegualarInterestAmount);
			System.out.println("STEP63:  Calculate Regualar Interest Amount : " + expectedRegualarInterestAmount);

			// Assert the Regular Interest Amount
			IElementActions.assertEquals_usingInteger(node, driver, actualRegularInterest,
					expectedRegualarInterestAmount,
					"STEP4 : BUG : The Regular Interest Amount is not same as calculated from [loans regular interest - Facility totals regular interest]formula",
					"STEP4 : PASS : The Regular Interest Amount is same as calculated from [loans regular interest - Facility totals regular interest]formula");

			// Take screenshot
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

	// TC_Funding_Interest _043
	@Test(priority = 26)
	public void validateDefaultInterestAmount() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the Default Interest is calculated as [Loans default interest paid - Facility totals default interest paid]")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Check the Visibility of Details text with arrow down icon
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon,
					"STEP1 : BUG: The Details text with arrow down icon is not coming on NIM Analysis Details Popup",
					"STEP1 : EXPECTED: The Details text with arrow down icon is coming on NIM Analysis Details Popup");

			// Click on Details text with down arrow icon
			IElementActions.clickelement_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon);
			node.log(Status.INFO, "STEP2 : Clicked on Details text with arrow down icon");
			System.out.println("STEP2 : Clicked on Details text with arrow down icon");

			// Get the Loans Default Interest Paid
			int loansDefaultInterestPaid = Utils
					.getTextAndParseToInt(FundingInterestPaymentPO.loansDefaultInterestPaid);

			// Get the Facility Totals Default Interest Paid Amount
			int facilityTotalsDefaultInterestPaid = Utils
					.getTextAndParseToInt(FundingInterestPaymentPO.facilityTotalsDefaultInterestPaid);

			// Get the Default Interest Amount
			int actualDefaultInterestAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.defaultInterestField);

			// Calling calculateDifference function from Utils
			int expectedDefaultInterestAmount = Utils.calculateDifference(loansDefaultInterestPaid,
					facilityTotalsDefaultInterestPaid);
			node.log(Status.INFO, "STEP3 : Calculateed Default Interest Amount : " + expectedDefaultInterestAmount);
			System.out.println("STEP3 :  Calculateed Default Interest Amount : " + expectedDefaultInterestAmount);

			// Set the acceptable difference
			int acceptableDifference = Integer.parseInt(getDataFromExcel(10));

			// Perform assertion allowing for a difference around 5 with a delta parameter
			Assert.assertEquals(actualDefaultInterestAmount, expectedDefaultInterestAmount, acceptableDifference,
					"Difference is greater than the acceptable range");

			// Take screenshot
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

	// TC_Funding_Interest _044
	@Test(priority = 27)
	public void validateNetInterestMargin() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify the Net Interest Margin is calculated as Interest [Regular Interest + Default Interest - Cash Interest].")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Get the Cash Interest
			int cashInterest = Utils.getTextAndParseToInt(FundingInterestPaymentPO.cashInterestField);

			// Get the Regular Interest
			int regularInterest = Utils.getTextAndParseToInt(FundingInterestPaymentPO.regularInterestField);

			// Get the Default Interest Amount
			int defaultInterest = Utils.getTextAndParseToInt(FundingInterestPaymentPO.defaultInterestField);

			// Get the Net Interest Margin Amount
			int actualNetInterestMargin = Utils.getTextAndParseToInt(FundingInterestPaymentPO.netInterestMarginsField);

			// Calling the calculateAddition and calculateDifference functions from Utils
			int expectedNetInterestMargin = Utils.calculateAddition(regularInterest, defaultInterest)
					- Utils.calculateDifference(cashInterest, 0);
			node.log(Status.INFO, "STEP1 : Calculated Net Interest Margin Amount : " + expectedNetInterestMargin);
			System.out.println("STEP1 :  Calculated Net Interest Margin Amount : " + expectedNetInterestMargin);

			// Assert the Net Interest Margin Amount
			IElementActions.assertEquals_usingInteger(node, driver, actualNetInterestMargin, expectedNetInterestMargin,
					"STEP2 : BUG: The Net Interest Margin Amount is not same as calculated from [Regular Interest + Default Interest - Cash Interest]formula",
					"STEP2 : PASS: The Net Interest Margin amount is same as calculated from [Regular Interest + Default Interest - Cash Interest]formula");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateNetInterestMargin", "Pass", driver);

		} catch (AssertionError validateNetInterestMargin) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNetInterestMargin test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateNetInterestMargin_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNetInterestMargin.printStackTrace();
			node.fail(validateNetInterestMargin);
			Assert.fail();
			extent.flush();

		} catch (Exception validateNetInterestMargin) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNetInterestMargin test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateNetInterestMargin_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNetInterestMargin.printStackTrace();
			node.fail(validateNetInterestMargin);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _045
	@Test(priority = 28)
	public void validateDetailsTextArrowIconVisibility() throws IOException {

		try {
			extenttest = extent.createTest("Verify that the user is able to see the 'Details text with arrow icon'.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Check the Visibility of Details text with arrow down icon
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon,
					"STEP1 : BUG: The Details text with arrow down icon is not coming on NIM Analysis Details Popup",
					"STEP1 : EXPECTED: The Details text with arrow down icon is coming on NIM Analysis Details Popup");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDetailsTextArrowIconVisibility", "Pass", driver);

		} catch (AssertionError validateDetailsTextArrowIconVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDetailsTextArrowIconVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDetailsTextArrowIconVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDetailsTextArrowIconVisibility.printStackTrace();
			node.fail(validateDetailsTextArrowIconVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDetailsTextArrowIconVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDetailsTextArrowIconVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDetailsTextArrowIconVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDetailsTextArrowIconVisibility.printStackTrace();
			node.fail(validateDetailsTextArrowIconVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _046
	@Test(priority = 29)
	public void validateAllAllocationsDetailsArrowDownIcon() throws IOException {

		try {
			extenttest = extent.createTest("Verify that the user is able to click on the Details arrow down icon.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Calling the validateDetailsTextArrowIcon function from Funding page
			FundingPage.validateDetailsTextArrowIcon(FundingInterestPaymentPO.detailsArrowIcon,
					FundingInterestPaymentPO.facilityDataTable, FundingInterestPaymentPO.detailsUpSideArrowIcon,
					"NIM Analysis", "validateAllAllocationsDetailsArrowDownIcon");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateAllAllocationsDetailsArrowDownIcon", "Pass", driver);

		} catch (AssertionError validateAllAllocationsDetailsArrowDownIcon) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAllAllocationsDetailsArrowDownIcon test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllAllocationsDetailsArrowDownIcon_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllAllocationsDetailsArrowDownIcon.printStackTrace();
			node.fail(validateAllAllocationsDetailsArrowDownIcon);
			Assert.fail();
			extent.flush();

		} catch (Exception validateAllAllocationsDetailsArrowDownIcon) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAllAllocationsDetailsArrowDownIcon test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllAllocationsDetailsArrowDownIcon_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllAllocationsDetailsArrowDownIcon.printStackTrace();
			node.fail(validateAllAllocationsDetailsArrowDownIcon);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _048
	@Test(priority = 30)
	public void validateNIMAnalysisPopupCloseButton() throws IOException {

		try {
			node = extent.createTest(
					"Verify that the user is able to close the NIM Analysis popup while clicking on the close button.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Calling the validatePopupClose function from Funding Page
			FundingPage.validatePopupClose(FundingInterestPaymentPO.closeButton,
					FundingInterestPaymentPO.nimAnalysisPopup, "Close", "NIM Analysis");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateNIMAnalysisPopupCloseButton", "Pass", driver);

		} catch (AssertionError validateNIMAnalysisPopupCloseButton) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNIMAnalysisPopupCloseButton test in InterestPaymentTest class");

			// Take the failed cupase screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNIMAnalysisPopupCloseButton_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNIMAnalysisPopupCloseButton.printStackTrace();
			node.fail(validateNIMAnalysisPopupCloseButton);
			Assert.fail();
			extent.flush();

		} catch (Exception validateNIMAnalysisPopupCloseButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNIMAnalysisPopupCloseButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNIMAnalysisPopupCloseButton_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNIMAnalysisPopupCloseButton.printStackTrace();
			node.fail(validateNIMAnalysisPopupCloseButton);
			Assert.fail();
			extent.flush();

		}
	}

	// TC_Funding_Interest _049
	@Test(priority = 31)
	public void validateNIMAnalysisPopupXIconButton() throws IOException {

		try {
			node = extent.createTest(
					"Verify that the user is able to close the NIM Analysis popup while clicking on the X icon.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Calling the validatePopupClose function from Funding Page
			FundingPage.validatePopupClose(FundingInterestPaymentPO.closeButton,
					FundingInterestPaymentPO.nimAnalysisPopup, "X Icon", "NIM Analysis");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateNIMAnalysisPopupXIconButton", "Pass", driver);

		} catch (AssertionError validateNIMAnalysisPopupXIconButton) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNIMAnalysisPopupXIconButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNIMAnalysisPopupXIconButton_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNIMAnalysisPopupXIconButton.printStackTrace();
			node.fail(validateNIMAnalysisPopupXIconButton);
			Assert.fail();
			extent.flush();

		} catch (Exception validateNIMAnalysisPopupXIconButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNIMAnalysisPopupXIconButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNIMAnalysisPopupXIconButton_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNIMAnalysisPopupXIconButton.printStackTrace();
			node.fail(validateNIMAnalysisPopupXIconButton);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _050
	// TC_Funding_Interest _047
	@Test(priority = 32)
	public void validateNimAnalysisFacilityTablesDetails() throws IOException {

		try {
			extenttest = extent.createTest("Verify that the user is able to see the following details:"
					+ "-Loans column" + "-Facility Totals column" + "- All Facility ref list" + "-Interest Income"
					+ "-Interest Expense" + "-Cash Interest" + "-Regular Interest" + "Reserve Details" + "- Loans"
					+ "-Facility Totals" + "-Default Interest" + "-Default Interest Paid" + "_"
					+ "validateTableListingFormatVisibility : Verify that the user is able to see the details in the Table listing format.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Check the Visibility of Details text with arrow down icon
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon,
					"STEP1 : BUG: The Details text with arrow down icon is not coming on NIM Analysis Details Popup",
					"STEP1 : EXPECTED: The Details text with arrow down icon is coming on NIM Analysis Details Popup");

			// Click on Details text with down arrow icon
			IElementActions.clickelement_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon);
			node.log(Status.INFO, "STEP2 : Clicked on Details text with arrow down icon");
			System.out.println("STEP2 : Clicked on Details text with arrow down icon");

			// Check the visibility of Loans column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.loansColumn,
					"STEP3 : BUG: The Loans column is not coming on NIM Analysis Details Popup",
					"STEP3 : EXPECTED: The Loans column is coming on NIM Analysis Details Popup");

			// Check the visibility of Facility Totals column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.facilityTotalsColumn,
					"STEP4 : BUG: The Facility Totals column is not coming on NIM Analysis Details Popup",
					"STEP4 : EXPECTED: The Facility Totals column is coming on NIM Analysis Details Popup");

			// Check the visibility of All Facility Reference List
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.facilityRefList,
					"STEP5 : BUG: The All Facility Reference List is not coming on NIM Analysis Details Popup",
					"STEP5 : EXPECTED: The All Facility Reference List is coming on NIM Analysis Details Popup");

			// Check the visibility of Interest Income
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestIncome,
					"STEP6 : BUG: The Interest Income is not coming on NIM Analysis Details Popup",
					"STEP6 : EXPECTED: The Interest Income is coming on NIM Analysis Details Popup");

			// Check the visibility of Interest Expense
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestExpense,
					"STEP7 : BUG: The Interest Expense is not coming on NIM Analysis Details Popup",
					"STEP7 : EXPECTED: The Interest Expense is coming on NIM Analysis Details Popup");

			// Check the visibility of Cash Interest
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.cashInterest,
					"STEP8 : BUG: The Cash Interest is not coming on NIM Analysis Details Popup",
					"STEP8 : EXPECTED: The Cash Interest is coming on NIM Analysis Details Popup");

			// Check the visibility of Regular Interest
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.regularInterest,
					"STEP9 : BUG: The Regular Interest is not coming on NIM Analysis Details Popup",
					"STEP9 : EXPECTED: The Regular Interest is coming on NIM Analysis Details Popup");

			// Check the visibility of Reserve Details
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.reserveDetails,
					"STEP10 : BUG: The Reserve Details is not coming on NIM Analysis Details Popup",
					"STEP10 : EXPECTED: The Reserve Details is coming on NIM Analysis Details Popup");

			// Check the visibility of Loans column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.loans,
					"STEP11 : BUG: The Loans column is not coming on NIM Analysis Details Popup",
					"STEP11 : EXPECTED: The Loans column is coming on NIM Analysis Details Popup");

			// Check the visibility of Facility Totals column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.facilityTotals,
					"STEP12 : BUG: The Facility Totals column is not coming on NIM Analysis Details Popup",
					"STEP12 : EXPECTED: The Facility Totals column is coming on NIM Analysis Details Popup");

			// Check the visibility of Default Interest
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.defaultInterest,
					"STEP13 : BUG: The Default Interest is not coming on NIM Analysis Details Popup",
					"STEP13 : EXPECTED: The Default Interest is coming on NIM Analysis Details Popup");

			// Check the visibility of Default Interest Paid
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.defaultInterestPaid,
					"STEP14 : BUG: The Default Interest Paid is not coming on NIM Analysis Details Popup",
					"STEP14 : EXPECTED: The Default Interest Paid is coming on NIM Analysis Details Popup");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateNimAnalysisFacilityTablesDetails", "Pass", driver);

		} catch (AssertionError validateNimAnalysisFacilityTablesDetails) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNimAnalysisFacilityTablesDetails test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNimAnalysisFacilityTablesDetails_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNimAnalysisFacilityTablesDetails.printStackTrace();
			node.fail(validateNimAnalysisFacilityTablesDetails);
			Assert.fail();
			extent.flush();

		} catch (Exception validateNimAnalysisFacilityTablesDetails) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNimAnalysisFacilityTablesDetails test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNimAnalysisFacilityTablesDetails_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNimAnalysisFacilityTablesDetails.printStackTrace();
			node.fail(validateNimAnalysisFacilityTablesDetails);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _051
	@Test(priority = 33)
	public void validateInterestIncomeAtNIMS() throws IOException {

		try {
			extenttest = extent
					.createTest("Validate the Interest Income at NIMS is equal to the Interest Payment Amount "
							+ "under Current Month Calculation column at Loan Interest Details at Step 4.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Get the Interest Income Amount
			String interestIncomeAmountAtNIMPopup = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.interestIncomeField);
			node.log(Status.INFO,
					"STEP1 : The Interest Income Amount At NIM Popup : " + interestIncomeAmountAtNIMPopup);
			System.out.println("STEP1 : The Interest Income Amount At NIM Popup : " + interestIncomeAmountAtNIMPopup);

			// Calling the closePopUp function from the FundingPage
			FundingPage.closePopUp();

			// Navigate to Step4
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Get the Interest Payment Amount
			String interestPaymentAmountAtLoanInterestPopup = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.interestPaymentAmount);
			node.log(Status.INFO, "STEP2 : The Interest Payment Amount At Loan Interest Details Popup : "
					+ interestPaymentAmountAtLoanInterestPopup);
			System.out.println("STEP2 : The Interest Payment Amount At Loan Interest Details Popup : "
					+ interestPaymentAmountAtLoanInterestPopup);

			// Assert the Interest Income Amount
			IElementActions.assertEquals_usingString(node, driver, interestIncomeAmountAtNIMPopup,
					interestPaymentAmountAtLoanInterestPopup,
					"STEP3 : BUG: The Interest Income Amount At NIM Popup is not same as Interest Payment Amount At Loan Interest Details Popup",
					"STEP3 : PASS: The Interest Income Amount At NIM Popup is same as Interest Payment Amount At Loan Interest Details Popup");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateInterestIncomeAtNIMS", "Pass", driver);

		} catch (AssertionError validateInterestIncomeAtNIMS) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInterestIncomeAtNIMS test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateInterestIncomeAtNIMS_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestIncomeAtNIMS.printStackTrace();
			node.fail(validateInterestIncomeAtNIMS);
			Assert.fail();
			extent.flush();

		} catch (Exception validateInterestIncomeAtNIMS) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInterestIncomeAtNIMS test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateInterestIncomeAtNIMS_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestIncomeAtNIMS.printStackTrace();
			node.fail(validateInterestIncomeAtNIMS);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _052
	@Test(priority = 34)
	public void validateInterestExpenseOfEachFacility() throws IOException {

		try {
			extenttest = extent.createTest("Validate the Interest Expenses of each facility.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Check the Visibility of Details text with arrow down icon
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon,
					"STEP1 : BUG: The Details text with arrow down icon is not coming on NIM Analysis Details Popup",
					"STEP1 : EXPECTED: The Details text with arrow down icon is coming on NIM Analysis Details Popup");

			// Click on Details text with down arrow icon
			IElementActions.clickelement_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon);
			node.log(Status.INFO, "STEP2 : Clicked on Details text with arrow down icon");
			System.out.println("STEP2 : Clicked on Details text with arrow down icon");

			String facilityReference = getDataFromExcel(9);

			// create Dynamic Locator for Interest Expense Amount
			String facilityInterestExpenseAmountLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.anyFacilityInterestExpenseAmount, "locatorValue", facilityReference);

			// Check the visibility of Facility Interest Expense Amount
			IElementActions.assertTrue_usingXpath(node, driver, facilityInterestExpenseAmountLocator,
					"STEP3 : BUG: The facility interest expense amount is not coming on NIM Analysis Details popup",
					"STEP3 : EXPECTED: The facility interest expense amount is coming on NIM Analysis Details popup");

			// Get the Facility Interest Expense Amount
			String facilityInterestExpenseAmountAtNIMPOpup = IElementActions.getElementText_usingXpath(node, driver,
					facilityInterestExpenseAmountLocator);
			node.log(Status.INFO, "STEP4 : The facility Interest Expense Amount on NIM Analysis Details popup : "
					+ facilityInterestExpenseAmountAtNIMPOpup);
			System.out.println("STEP4 : The facility Interest Expense Amount on NIM Analysis Details popup: "
					+ facilityInterestExpenseAmountAtNIMPOpup);

			// Calling the closePopUp from FundingPage
			FundingPage.closePopUp();

			// Calling the navigateToStep function from the FundingPage
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Check the visibility of Interest Payment Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestPaymentAmount,
					"STEP5 : BUG: The interest payment amount is not coming on interest payment details popup",
					"STEP5 : EXPECTED: The interest payment amount is coming on interest payment details popup");

			// Get the Interest Payment Amount
			String interestPaymentAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.interestPaymentAmount);
			node.log(Status.INFO,
					"STEP6 : The Interest Payment Amount on Interest Payment Details popup : " + interestPaymentAmount);
			System.out.println(
					"STEP6 : The Interest Payment Amount on Interest Payment Details popup : " + interestPaymentAmount);

			// Assert the Facility Interest Expense Amount
			IElementActions.assertEquals_usingString(node, driver, facilityInterestExpenseAmountAtNIMPOpup,
					interestPaymentAmount,
					"STEP7 : BUG: Facility Interest Expense Amount on NIM Popup is not same as Interest Payment Amount on Interest Payment Details popup in step4",
					"STEP7 : PASS: Facility Interest Expense Amount on NIM Popup is same as Interest Payment Amount on Interest Payment Details popup in step4");

			// Assert the All Facilities Interest Expense Amount
			IElementActions.assertEquals_usingString(node, driver, facilityInterestExpenseAmountAtNIMPOpup,
					interestPaymentAmount,
					" STEP8 : BUG: All Facilities Interest Expense Amount on NIM Popup is not same as Interest Payment Amount on Interest Payment Details popup in step4",
					"STEP8 : PASS: All Facilities Interest Expense Amount on NIM Popup is same as Interest Payment Amount on Interest Payment Details popup in step4");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateInterestExpenseOfEachFacility", "Pass", driver);

		} catch (AssertionError validateInterestExpenseOfEachFacility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInterestExpenseOfEachFacility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestExpenseOfEachFacility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestExpenseOfEachFacility.printStackTrace();
			node.fail(validateInterestExpenseOfEachFacility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateInterestExpenseOfEachFacility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInterestExpenseOfEachFacility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestExpenseOfEachFacility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestExpenseOfEachFacility.printStackTrace();
			node.fail(validateInterestExpenseOfEachFacility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _053
	@Test(priority = 35)
	public void validateCashInterestOfEachFacility() throws IOException {

		try {
			extenttest = extent.createTest("Validate the Cash Interest of each facility.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Call the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Check the Visibility of Details text with arrow down icon
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon,
					"STEP1 : BUG: The Details text with arrow down icon is not coming on NIM Analysis Details Popup",
					"STEP1 : EXPECTED: The Details text with arrow down icon is coming on NIM Analysis Details Popup");

			// Click on Details text with down arrow icon
			IElementActions.clickelement_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon);
			node.log(Status.INFO, "STEP2 : Clicked on Details text with arrow down icon");
			System.out.println("STEP2 : Clicked on Details text with arrow down icon");

			String facilityReference = getDataFromExcel(9);

			// create Dynamic Locator for Cash Interest Amount
			String facilityCashInterestAmountLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.anyFacilityCashInterestAmount, "locatorValue", facilityReference);

			// Check the visibility of Cash Interest Amount
			IElementActions.assertTrue_usingXpath(node, driver, facilityCashInterestAmountLocator,
					"STEP3 : BUG: The facility cash interest amount is not coming on NIM Analysis Details popup",
					"STEP3 : EXPECTED: The facility cash interest amount is coming on NIM Analysis Details popup");

			// Get the Facility Cash Interest Amount
			String facilityCashInterestAmount = IElementActions.getElementText_usingXpath(node, driver,
					facilityCashInterestAmountLocator);
			node.log(Status.INFO, "STEP4 : The Facility Cash Interest Amount :" + facilityCashInterestAmount);
			System.out.println("STEP4 : The Facility Cash Interest Amount : " + facilityCashInterestAmount);

			// Calling the closePopUp from FundingPage
			FundingPage.closePopUp();

			// Calling the navigateToStep function from the FundingPage
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Check the visibility Cash Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.cashAmountValue,
					"STEP5 : BUG: The cash amount is not coming on interest payment details popup",
					"STEP5 : EXPECTED: The cash amount is coming on interest payment details popup");

			// Get the Cash Amount
			String cashAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.cashAmountValue);
			node.log(Status.INFO, "STEP6 : The Cash Amount : " + cashAmount);
			System.out.println("STEP6 : Get the Cash Amount : " + cashAmount);

			// Assert the Facility Cash Interest Amount
			IElementActions.assertEquals_usingString(node, driver, facilityCashInterestAmount, cashAmount,
					"STEP7 : BUG: Facility Cash Interest Amount on NIM Popup is not same as Cash Amount on Interest Payment Details popup in step4",
					"STEP7 : PASS: Facility Cash Interest Amount on NIM Popup is same as Cash Amount on Interest Payment Details popup in step4");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashInterestOfEachFacility", "Pass", driver);

		} catch (AssertionError validateCashInterestOfEachFacility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashInterestOfEachFacility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashInterestOfEachFacility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashInterestOfEachFacility.printStackTrace();
			node.fail(validateCashInterestOfEachFacility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCashInterestOfEachFacility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashInterestOfEachFacility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashInterestOfEachFacility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashInterestOfEachFacility.printStackTrace();
			node.fail(validateCashInterestOfEachFacility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _054
	@Test(priority = 36)
	public void validateRegularInterestOfEachFacility() throws IOException {

		try {
			extenttest = extent.createTest("Validate the Regular Interest of each facility.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Call the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Check the Visibility of Details text with arrow down icon
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon,
					"STEP1 : BUG: The Details text with arrow down icon is not coming on NIM Analysis Details Popup",
					"STEP1 : EXPECTED: The Details text with arrow down icon is coming on NIM Analysis Details Popup");

			// Click on Details text with down arrow icon
			IElementActions.clickelement_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon);
			node.log(Status.INFO, "STEP2 : Clicked on Details text with arrow down icon");
			System.out.println("STEP2 : Clicked on Details text with arrow down icon");

			String facilityReference = getDataFromExcel(9);

			// Create Dynamic Locator for Regular Interest Amount
			String facilityRegularInterestAmountLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.anyFacilityRegualrInterestAmount, "locatorValue", facilityReference);

			// Check the visibility of Regular Interest Amount
			IElementActions.assertTrue_usingXpath(node, driver, facilityRegularInterestAmountLocator,
					"STEP3 : BUG: The Facility Regular Interest Amount is not coming on NIM Analysis Details popup",
					"STEP3 : EXPECTED: The Facility Regular Interest Amount is coming on NIM Analysis Details popup");

			// Get the Facility Regular Interest Amount
			String facilityRegularInterestAmount = IElementActions.getElementText_usingXpath(node, driver,
					facilityRegularInterestAmountLocator);
			node.log(Status.INFO, "STEP4 : The Facility Regular Interest Amount on NIM Analysis Details popup : "
					+ facilityRegularInterestAmount);
			System.out.println("STEP4 : The Facility Regular Interest Amount on NIM Analysis Details popup : "
					+ facilityRegularInterestAmount);

			// Calling the closePopUp from FundingPage
			FundingPage.closePopUp();

			// Calling the navigateToStep function from the FundingPage
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Check the visibility of Regular Interest
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.regularInterestAmount,
					"STEP5 : BUG: The Regular Interest is not coming on Interest Payment Details popup",
					"STEP5 : EXPECTED: The Regular Interest is coming on Interest Payment Details popup");

			// Get the Regular Interest
			String regularInterest = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.regularInterestAmount);
			node.log(Status.INFO,
					"STEP6 : The Regular Interest Amount on Interest Payment Details popup : " + regularInterest);
			System.out.println(
					"STEP6 : The Regular Interest Amount on Interest Payment Details popup : " + regularInterest);

			// Assert the Facility Regular Interest Amount
			IElementActions.assertEquals_usingString(node, driver, facilityRegularInterestAmount, regularInterest,
					"STEP7 : BUG: Facility Regular Interest Amount on NIM Popup is not same as Regular Interest on Interest Payment Details popup in step4",
					"STEP7 : PASS: Facility Regular Interest Amount on NIM Popup is same as Regular Interest on Interest Payment Details popup in step4");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateRegularInterestOfEachFacility", "Pass", driver);

		} catch (AssertionError validateRegularInterestOfEachFacility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateRegularInterestOfEachFacility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRegularInterestOfEachFacility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRegularInterestOfEachFacility.printStackTrace();
			node.fail(validateRegularInterestOfEachFacility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateRegularInterestOfEachFacility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateRegularInterestOfEachFacility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRegularInterestOfEachFacility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRegularInterestOfEachFacility.printStackTrace();
			node.fail(validateRegularInterestOfEachFacility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _055
	@Test(priority = 37)
	public void validateResrveDetailsLoanAmount() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the loan amount displayed under 'Reverse Details' is fetched from the Loan Interest Details popup when click on the loan (i) button under the step 4.")
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

			// Check the Visibility of Details text with arrow down icon
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon,
					"STEP1 : BUG: The Details text with arrow down icon is not coming on NIM Analysis Details Popup",
					"STEP1 : EXPECTED: The Details text with arrow down icon is coming on NIM Analysis Details Popup");

			// Click on Details text with down arrow icon
			IElementActions.clickelement_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon);
			node.log(Status.INFO, "STEP2 : Clicked on Details text with arrow down icon");
			System.out.println("STEP2 : Clicked on Details text with arrow down icon");

			// Check the visibility of Loans Default Interest Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.loansDefaultInterestAmount,
					"STEP3 : BUG: The Loans Default Interest Amount is not coming on NIM Analysis Details Popup",
					"STEP3 : EXPECTED: The Loans Default Interest Amount is coming on NIM Analysis Details Popup");

			// Get the Loans Default Interest Amount
			String loansDefaultInterestAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.loansDefaultInterestAmount);
			node.log(Status.INFO, "STEP4 : Loans Default Interest Amount on NIM Analysis Details Popup : "
					+ loansDefaultInterestAmount);
			System.out.println("STEP4 : Loans Default Interest Amount on NIM Analysis Details Popup : "
					+ loansDefaultInterestAmount);

			// Calling the closePopUp function from FundingPage
			FundingPage.closePopUp();

			// Calling the navigateToStep function from the FundingPage
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Check the visibility Loan Default Interest
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.loansDefaultInterest,
					"STEP5 : BUG: The Loan Default Interest is not coming on loan interest details popup",
					"STEP5 : EXPECTED: The Loan Default Interest is coming on loan interest details popup");

			// Get the Loan Default Interest Amount
			String loanDefaultInterestAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.loansDefaultInterest);
			node.log(Status.INFO, "STEP6 : The Loan Default Interest Amount on loan interest details popup : "
					+ loanDefaultInterestAmount);
			System.out.println("STEP6 : The Loan Default Interest Amount on loan interest details popup : "
					+ loanDefaultInterestAmount);

			// Assert the Loans Default Interest Amount
			IElementActions.assertEquals_usingString(node, driver, loansDefaultInterestAmount,
					loanDefaultInterestAmount,
					"STEP7 : BUG : Loans Default Interest Amount on NIM Popup is not same as Loan Default Interest Amount on Loan Interest Details popup",
					"STEP7 : PASS : Loans Default Interest Amount on NIM Popup is same as Loan Default Interest Amount Loan Interest Details popup");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateResrveDetailsLoanAmount", "Pass", driver);

		} catch (AssertionError validateResrveDetailsLoanAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateResrveDetailsLoanAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateResrveDetailsLoanAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateResrveDetailsLoanAmount.printStackTrace();
			node.fail(validateResrveDetailsLoanAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateResrveDetailsLoanAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateResrveDetailsLoanAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateResrveDetailsLoanAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateResrveDetailsLoanAmount.printStackTrace();
			node.fail(validateResrveDetailsLoanAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _056
	@Test(priority = 38)
	public void validateDefaultInterestOfEachFacility() throws IOException {

		try {
			extenttest = extent.createTest("Validate the Default Interest of each facility.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Call the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Check the Visibility of Details text with arrow down icon
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon,
					"STEP1 : BUG: The Details text with arrow down icon is not coming on NIM Analysis Details Popup",
					"STEP1 : EXPECTED: The Details text with arrow down icon is coming on NIM Analysis Details Popup");

			// Click on Details text with down arrow icon
			IElementActions.clickelement_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon);
			node.log(Status.INFO, "STEP2 : Clicked on Details text with arrow down icon");
			System.out.println("STEP2 : Clicked on Details text with arrow down icon");

			String facilityReference = getDataFromExcel(9);

			// Create Dynamic Locator for Default Interest Amount
			String facilityDefaultInterestAmountLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.anyFacilityDefaultInterest, "locatorValue", facilityReference);

			// Check the visibility of Facility Default Interest Amount
			IElementActions.assertTrue_usingXpath(node, driver, facilityDefaultInterestAmountLocator,
					"STEP3 : BUG: The Facility Default Interest Amount is not coming on NIM Analysis Details popup",
					"STEP3 : EXPECTED: The Facility Default Interest Amount is coming on NIM Analysis Details popup");

			// Get the Facility Default Interest Amount
			String facilityDefaultInterestAmount = IElementActions.getElementText_usingXpath(node, driver,
					facilityDefaultInterestAmountLocator);
			node.log(Status.INFO, "STEP4 : Facility Default Interest Amount on NIM Analysis Details popup : "
					+ facilityDefaultInterestAmount);
			System.out.println("STEP4 : Facility Default Interest Amount on NIM Analysis Details popup : "
					+ facilityDefaultInterestAmount);

			// Calling the closePopUp from FundingPage
			FundingPage.closePopUp();

			// Calling the navigateToStep function from the FundingPage
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Check the visibility Default Interest Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.defaultInterestAmount,
					"STEP5 : BUG: The Default Interest Amount is not coming on Interest Payment Details popup",
					"STEP5 : EXPECTED: The Default Interest Amount is coming on Interest Payment Details popup");

			// Get the Default Interest Amount
			String defaultInterestAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.defaultInterestAmount);
			node.log(Status.INFO,
					"STEP6 : The Default Interest Amount on Interest Payment Details popup : " + defaultInterestAmount);
			System.out.println(
					"STEP6 : The Default Interest Amount on Interest Payment Details popup : " + defaultInterestAmount);

			// Assert the Facility Default Interest Amount
			IElementActions.assertEquals_usingString(node, driver, facilityDefaultInterestAmount, defaultInterestAmount,
					"STEP7 : BUG: Facility Default Interest Amount on NIM Popup is not same as Default Interest Amount on Interest Payment Details popup in step4",
					"STEP7 : PASS: Facility Default Interest Amount on NIM Popup is same as Default Interest Amount on Interest Payment Details popup in step4");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDefaultInterestOfEachFacility", "Pass", driver);

		} catch (AssertionError validateDefaultInterestOfEachFacility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDefaultInterestOfEachFacility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDefaultInterestOfEachFacility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDefaultInterestOfEachFacility.printStackTrace();
			node.fail(validateDefaultInterestOfEachFacility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDefaultInterestOfEachFacility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDefaultInterestOfEachFacility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDefaultInterestOfEachFacility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDefaultInterestOfEachFacility.printStackTrace();
			node.fail(validateDefaultInterestOfEachFacility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _057
	@Test(priority = 39)
	public void validateDefaultInterestPaidEachFacility() throws IOException {

		try {
			extenttest = extent.createTest("Validate the Default Interest paid of each facility.")
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

			// Check the Visibility of Details text with arrow down icon
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon,
					"STEP1 : BUG: The Details text with arrow down icon is not coming on NIM Analysis Details Popup",
					"STEP1 : EXPECTED: The Details text with arrow down icon is coming on NIM Analysis Details Popup");

			// Click on Details text with down arrow icon
			IElementActions.clickelement_usingXpath(node, driver, FundingInterestPaymentPO.detailsArrowIcon);
			node.log(Status.INFO, "STEP2 : Clicked on Details text with arrow down icon");
			System.out.println("STEP2 : Clicked on Details text with arrow down icon");

			String facilityReference = getDataFromExcel(9);

			// Create Dynamic Locator for Default Interest Paid Amount
			String facilityDefaultInterestPaidAmountLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.anyFacilityDefaultInterestPaid, "locatorValue", facilityReference);

			// Check the visibility of Facility Default Interest Paid Amount
			IElementActions.assertTrue_usingXpath(node, driver, facilityDefaultInterestPaidAmountLocator,
					"STEP3 : BUG: The Facility Default Interest Paid Amount is not coming on NIM Analysis Details popup",
					"STEP3 : EXPECTED: The Facility Default Interest Paid Amount is coming on NIM Analysis Details popup");

			// Get the Facility Default Interest Paid Amount
			String facilityDefaultInterestPaidAmount = IElementActions.getElementText_usingXpath(node, driver,
					facilityDefaultInterestPaidAmountLocator);
			node.log(Status.INFO, "STEP4 : Facility Default Interest Paid Amount on NIM Analysis Details popup : "
					+ facilityDefaultInterestPaidAmount);
			System.out.println("STEP4 : Facility Default Interest Paid Amount on NIM Analysis Details Popup : "
					+ facilityDefaultInterestPaidAmount);

			// Calling the closePopUp from FundingPage
			FundingPage.closePopUp();

			// Calling the navigateToStep function from the FundingPage
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Calling the clickOnAnyFacilityIButton function from FundingPage
			FundingPage.clickOnAnyFacilityIButton(FundingInterestPaymentPO.dynamicFacilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Check the visibility Default Interest Paid Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.defaultInterestPaidAmount,
					"STEP5 : BUG: The Default Interest Paid Amount is not coming on Interest Payment Details popup",
					"STEP5 : EXPECTED: The Default Interest Paid Amount is coming on Interest Payment Details popup");

			// Get the Default Interest Paid Amount
			String defaultInterestPaidAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.defaultInterestPaidAmount);
			node.log(Status.INFO, "STEP6 : The Default Interest Paid Amount on Interest Payment Details popup :"
					+ defaultInterestPaidAmount);
			System.out.println("STEP6 : The Default Interest Paid Amount on Interest Payment Details popup :"
					+ defaultInterestPaidAmount);

			// Assert the Facility Default Interest Paid Amount
			IElementActions.assertEquals_usingString(node, driver, facilityDefaultInterestPaidAmount,
					defaultInterestPaidAmount,
					"STEP7 : BUG : Facility Default Interest Paid Amount on NIM Popup is not same as Default Interest Paid Amount on Interest Payment Details popup in step4",
					"STEP7 : PASS : Facility Default Interest Paid Amount on NIM Popup is same as Default Interest Paid Amount on Interest Payment Details popup in step4");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDefaultInterestPaidEachFacility", "Pass", driver);

		} catch (AssertionError validateDefaultInterestPaidEachFacility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDefaultInterestPaidEachFacility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDefaultInterestPaidEachFacility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDefaultInterestPaidEachFacility.printStackTrace();
			node.fail(validateDefaultInterestPaidEachFacility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDefaultInterestPaidEachFacility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDefaultInterestPaidEachFacility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDefaultInterestPaidEachFacility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDefaultInterestPaidEachFacility.printStackTrace();
			node.fail(validateDefaultInterestPaidEachFacility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _097
	@Test(priority = 40)
	public void validateLoanAmountOfFacilty() throws IOException {

		try {
			extenttest = extent.createTest("Verify the Facility Loan Amount and Loan Amount of any facility")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling loadInterestPaymentPageAndNavigateToStep2 function to access step2 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			String facilityReference = getDataFromExcel(9);

			// Create Dynamic Locator for Facility Loan Amount
			String facilityLoanAmountLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.anyFacilityLoanAmount, "locatorValue", facilityReference);

			// Get the Facility Loan Amount In Step2
			String facilityLoanAmountInStep2 = IElementActions.getElementText_usingXpath(node, driver,
					facilityLoanAmountLocator);

			// Get the All Facility Loan Amount In Step2
			String allFacilityLoanAmountInStep2 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.facilityLoanAmount);

			// Calling the navigateToStep function from the FundingPage
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysis);

			// Wait for the visibility of the loan amount
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the facility loan amount");
			System.out.println("STEP1 : Waiting for the visibility of the facility loan amount");
			IWaitStrategy.waitForVisiblity(node, driver, facilityLoanAmountLocator);
			node.log(Status.INFO, "STEP2 : Facility loan amount is visible");
			System.out.println("STEP2 : Facility loan amount is visible");

			// Get the Facility Loan Amount In Step4
			String facilityLoanAmountInStep4 = IElementActions.getElementText_usingXpath(node, driver,
					facilityLoanAmountLocator);

			// Get the All Facility Loan Amount In Step4
			String allFacilityLoanAmountInStep4 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.facilityLoanAmount);

			// Assert the Facility Loan Amount
			IElementActions.assertEquals_usingString(node, driver, facilityLoanAmountInStep2, facilityLoanAmountInStep4,
					"STEP3 : BUG: Facility Loan Amount is not same in step2 and step4",
					"STEP3 : EXPECTED: Facility Loan Amount is same in step2 and step4");

			// Assert the All Facilities Loan Amount
			IElementActions.assertEquals_usingString(node, driver, allFacilityLoanAmountInStep2,
					allFacilityLoanAmountInStep4,
					"STEP4 : BUG: All Facilities Loan Amount of is not same in step2 and step4",
					"STEP4 : EXPECTED: All Facilities Loan Amount is same in step2 and step4");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanAmountOfFacilty", "Pass", driver);

		} catch (AssertionError validateLoanAmountOfFacilty) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanAmountOfFacilty test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanAmountOfFacilty_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanAmountOfFacilty.printStackTrace();
			node.fail(validateLoanAmountOfFacilty);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanAmountOfFacilty) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanAmountOfFacilty test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanAmountOfFacilty_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanAmountOfFacilty.printStackTrace();
			node.fail(validateLoanAmountOfFacilty);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _098
	@Test(priority = 41)
	public void validateTotalLoanAmountOfFacilities() throws IOException {

		try {
			extenttest = extent.createTest("Verify the total facility Amount")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Set the acceptable difference
			String acceptableDifference = getDataFromExcel(10);

			// Calling loadInterestPaymentPageAndNavigateToStep2 function to access step2 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateSumForDoubleValues from Utils
			Utils.validateSumForDoubleValues(FundingInterestPaymentPO.totalLoanAmount,
					FundingInterestPaymentPO.facilitiesLoanAmount, acceptableDifference, "FacilityAmount");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateTotalLoanAmountOfFacilities", "Pass", driver);

		} catch (AssertionError validateTotalLoanAmountOfFacilities) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateTotalLoanAmountOfFacilities test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateTotalLoanAmountOfFacilities_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalLoanAmountOfFacilities.printStackTrace();
			node.fail(validateTotalLoanAmountOfFacilities);
			Assert.fail();
			extent.flush();

		} catch (Exception validateTotalLoanAmountOfFacilities) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateTotalLoanAmountOfFacilities test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateTotalLoanAmountOfFacilities_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalLoanAmountOfFacilities.printStackTrace();
			node.fail(validateTotalLoanAmountOfFacilities);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _099
	@Test(priority = 42)
	public void validateLoanAmountOfAllFacilities() throws IOException {

		try {
			extenttest = extent.createTest("Verify the each facility Amount")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep2 function to access step2 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Scroll to the facilityRateMaxDifferenceTolerance
			IElementActions.scrollbyJSExecutorUsingElementPath(driver,
					FundingInterestPaymentPO.facilityRateMaxDifferenceTolerance);
			node.log(Status.INFO, "STEP1 : Scrolled to the  today's date");
			System.out.println("STEP1 : Scrolled to the today's date");

			// Wait for Page Load
			node.log(Status.INFO, "STEP2 : Waiting for the complete page loding");
			System.out.println("STEP2 : Waiting for the complete page loading");
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.totalLoanAmount);
			node.log(Status.INFO, "STEP3 : Complete Page is load successfully");
			System.out.println("STEP3 : Complete Page is load successfully");

			// Locate the list element by its XPath
			List<WebElement> elementsInStep2 = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.facilitiesLoanAmount);

			// Initialize a List to store facility amounts as strings
			List<String> facilityAmountsInStep2 = new ArrayList<>();

			// Iterate through each element in the list
			for (WebElement element : elementsInStep2) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				facilityAmountsInStep2.add(elementValue);
			}

			// Print or use the List of facility amounts as needed
			System.out.println("Facility Amounts in step2: " + facilityAmountsInStep2);

			// Calling the navigateToStep function from the FundingPage
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysis);

			// Wait for the visibility of the facilitiesLoanAmount
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the facility loan amount");
			System.out.println("STEP1 : Waiting for the visibility of the facility loan amount");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.facilitiesLoanAmount);
			node.log(Status.INFO, "STEP2 : Facility loan amount is visible");
			System.out.println("STEP2 : Facility loan amount is visible");

			// Locate the list element by its XPath
			List<WebElement> elementsInStep4 = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.facilitiesLoanAmount);

			// Initialize a List to store facility amounts as strings
			List<String> facilityAmountsInStep4 = new ArrayList<>();

			// Iterate through each element in the list
			for (WebElement element : elementsInStep4) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				facilityAmountsInStep4.add(elementValue);
			}

			// Print or use the List of facility amounts as needed
			System.out.println("Facility Amounts in step4: " + facilityAmountsInStep4);

			// Perform assertion for each pair of values in the lists
			boolean allValuesMatch = true;

			for (int i = 0; i < facilityAmountsInStep2.size(); i++) {
				String valueFromList1 = facilityAmountsInStep2.get(i);
				String valueFromList2 = facilityAmountsInStep4.get(i);

				// Check if the values match
				if (!valueFromList1.equals(valueFromList2)) {
					allValuesMatch = false;
					System.out.println("Values at position " + i + " do not match:");
					System.out.println("List 1: " + valueFromList1);
					System.out.println("List 2: " + valueFromList2);
				}
			}

			// Perform the final assertion based on the matching status
			Assert.assertTrue(allValuesMatch, "Not all values in the lists match");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateTotalLoanAmountOfFacilities", "Pass", driver);

		} catch (AssertionError validateTotalLoanAmountOfFacilities) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateTotalLoanAmountOfFacilities test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateTotalLoanAmountOfFacilities_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalLoanAmountOfFacilities.printStackTrace();
			node.fail(validateTotalLoanAmountOfFacilities);
			Assert.fail();
			extent.flush();

		} catch (Exception validateTotalLoanAmountOfFacilities) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateTotalLoanAmountOfFacilities test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateTotalLoanAmountOfFacilities_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalLoanAmountOfFacilities.printStackTrace();
			node.fail(validateTotalLoanAmountOfFacilities);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _100
	@Test(priority = 43)
	public void validateLoanCarriedForwardLoanAmount() throws IOException {

		try {
			extenttest = extent.createTest("Verify the Carried Forward Loan Amount")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep2 function to access step2 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Get the Facility Carried Forward Loan Amount in Step2
			String facilityCarriedForwardLoanAmountInStep2 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.facilityCarriedForwardLoanAmount);

			// Calling the navigateToStep function from the FundingPage
			FundingPage.navigateToStep(FundingInterestPaymentPO.monthOnMonthComparisonStep3);

			// Wait for the visibility of the facilityCarriedForwardLoanAmount
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the Carried forward loan amount");
			System.out.println("STEP1 : Waiting for the visibility of the Carried forward loan amount");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.facilityCarriedForwardLoanAmount);
			node.log(Status.INFO, "STEP2 : Carried forward loan amount is visible");
			System.out.println("STEP2 : Carried forward loan amount is visible");

			// Get the Facility Carried Forward Loan Amount in Step3
			String facilityCarriedForwardLoanAmountInStep3 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.facilityCarriedForwardLoanAmount);

			// Assert the Carried Forward Loan Amount
			IElementActions.assertEquals_usingString(node, driver, facilityCarriedForwardLoanAmountInStep2,
					facilityCarriedForwardLoanAmountInStep3,
					"STEP3 : BUG:  Carried forward loan amount is not same in step2 and step3",
					"STEP3 : EXPECTED:  Carried forward loan amount is same in step2 and step3");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanCarriedForwardLoanAmount", "Pass", driver);

		} catch (AssertionError validateLoanCarriedForwardLoanAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanCarriedForwardLoanAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanCarriedForwardLoanAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanCarriedForwardLoanAmount.printStackTrace();
			node.fail(validateLoanCarriedForwardLoanAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanCarriedForwardLoanAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanCarriedForwardLoanAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanCarriedForwardLoanAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanCarriedForwardLoanAmount.printStackTrace();
			node.fail(validateLoanCarriedForwardLoanAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _101
	@Test(priority = 44)
	public void validateTotalCarriedForwardLoanAmount() throws IOException {

		try {
			extenttest = extent.createTest("Verify the total Carried Forward Amount")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep2 function to access step2 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Scroll to the facilityRateMaxDifferenceTolerance
			IElementActions.scrollbyJSExecutorUsingElementPath(driver,
					FundingInterestPaymentPO.facilityRateMaxDifferenceTolerance);
			node.log(Status.INFO, "STEP1 : Scrolled to the  today's date");
			System.out.println("STEP1 : Scrolled to the today's date");

			// Wait for Page Load
			node.log(Status.INFO, "STEP2 : Waiting for the complete page loding");
			System.out.println("STEP2 : Waiting for the complete page loading");
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.totalLoanAmount);
			node.log(Status.INFO, "STEP3 : Complete Page is load successfully");
			System.out.println("STEP3 : Complete Page is load successfully");

			// Get the Total Carried Forward Loan Amount Value
			String totalCarriedForwardLoanAmountValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.totalCarriedForwardAmount);
			// Remove the currency symbol and comma
			String cleanedAmountString = totalCarriedForwardLoanAmountValue.replace("£", "").replace(",", "");

			// Convert the cleaned string to a numerical value
			double totalCarriedForwardLoanAmount = Double.parseDouble(cleanedAmountString);
			node.log(Status.INFO, "STEP4 : Total carried forward loan amount " + totalCarriedForwardLoanAmount);
			System.out.println("STEP4 : Total carried forward loan amount " + totalCarriedForwardLoanAmount);

			// Locate the list element by its XPath
			List<WebElement> elements = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.facilitiesCarriedForwardAmount);

			// Initialize the variable to store the sum
			double sum = 0;

			// Iterate through each element in the list
			for (WebElement element : elements) {

				String getCarriedForwardLoanAmountValue = element.getText();
				String formattedAmountString = getCarriedForwardLoanAmountValue.replace("£", "").replace(",", "");

				// Get the numerical value from the element and add it to the sum
				double elementValue = Double.parseDouble(formattedAmountString);
				sum += elementValue;
			}

			node.log(Status.INFO, "STEP5 : Total carried forward loan amount sum is " + sum);
			System.out.println("STEP5 : Total carried forward loan amount sum is " + sum);

			// Set the acceptable difference
			double acceptableDifference = Double.parseDouble(getDataFromExcel(10));

			// Perform assertion allowing for a difference 5 with a delta parameter
			Assert.assertEquals(sum, totalCarriedForwardLoanAmount, acceptableDifference,
					"Difference is greater than the acceptable range");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateTotalCarriedForwardLoanAmount", "Pass", driver);

		} catch (AssertionError validateTotalCarriedForwardLoanAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateTotalCarriedForwardLoanAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateTotalCarriedForwardLoanAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalCarriedForwardLoanAmount.printStackTrace();
			node.fail(validateTotalCarriedForwardLoanAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateTotalCarriedForwardLoanAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateTotalCarriedForwardLoanAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateTotalCarriedForwardLoanAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalCarriedForwardLoanAmount.printStackTrace();
			node.fail(validateTotalCarriedForwardLoanAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _102
	@Test(priority = 45)
	public void validateCarriedForwardAmountOfAllFacilities() throws IOException {

		try {
			extenttest = extent.createTest("Verify the each Carried Forward facility Amount")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep2 function to access step2 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Scroll to the facilityRateMaxDifferenceTolerance
			IElementActions.scrollbyJSExecutorUsingElementPath(driver,
					FundingInterestPaymentPO.facilityRateMaxDifferenceTolerance);
			node.log(Status.INFO, "STEP1 : Scrolled to the facility rate max difference tolerance");
			System.out.println("STEP1 : Scrolled to the facility rate max difference tolerance");

			// Wait for Page Load
			node.log(Status.INFO, "STEP2 : Waiting for the complete page loding");
			System.out.println("STEP2 : Waiting for the complete page loading");
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.totalLoanAmount);
			node.log(Status.INFO, "STEP3 : Complete Page is load successfully");
			System.out.println("STEP3 : Complete Page is load successfully");

			// Get the Total Carried Forward Loan Amount Value
			String totalCarriedForwardLoanAmountValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.totalCarriedForwardAmount);

			// Locate the list element by its XPath
			List<WebElement> elementsInStep2 = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.facilitiesCarriedForwardAmount);

			// Initialize a List to store facility amounts as strings
			List<String> facilityCarriedForwardAmountsInStep2 = new ArrayList<>();

			// Iterate through each element in the list
			for (WebElement element : elementsInStep2) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				facilityCarriedForwardAmountsInStep2.add(elementValue);
			}

			// Print or use the List of facility amounts as needed
			System.out.println("Facility Carried Forward Amounts in step2: " + facilityCarriedForwardAmountsInStep2);

			// Call the navigateToStep function from the FundingPage
			FundingPage.navigateToStep(FundingInterestPaymentPO.monthOnMonthComparisonStep3);

			// Wait for the visibility of the carriedForwardText
			node.log(Status.INFO, "STEP4 : Waiting for the visibility of the carried forward");
			System.out.println("STEP4 : Waiting for the visibility of the carried forward");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.carriedForwardText);
			node.log(Status.INFO, "STEP5 : Carried forward is visible");
			System.out.println("STEP5 : Carried forward is visible");

			// Locate the list element by its XPath or any other suitable method
			List<WebElement> elementsInStep3 = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.facilitiesCarriedForwardAmountInStep3);

			// Initialize a List to store facility amounts as strings
			List<String> facilityCarriedForwardAmountsInStep3 = new ArrayList<>();

			// Iterate through each element in the list
			for (WebElement element : elementsInStep3) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				facilityCarriedForwardAmountsInStep3.add(elementValue);
			}

			// Print or use the List of facility amounts as needed
			System.out.println("Facility Carried Forward Amounts in step3: " + facilityCarriedForwardAmountsInStep3);

			// Perform assertion for each pair of values in the lists
			boolean allValuesMatch = true;

			for (int i = 0; i < facilityCarriedForwardAmountsInStep2.size(); i++) {
				String valueFromList1 = facilityCarriedForwardAmountsInStep2.get(i);
				String valueFromList2 = facilityCarriedForwardAmountsInStep3.get(i);

				// Check if the values match
				if (!valueFromList1.equals(valueFromList2)) {
					allValuesMatch = false;
					System.out.println("Values at position " + i + " do not match:");
					System.out.println("List 1: " + valueFromList1);
					System.out.println("List 2: " + valueFromList2);
				}
			}

			// Perform the final assertion based on the matching status
			Assert.assertTrue(allValuesMatch, "Not all values in the lists match");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateCarriedForwardAmountOfAllFacilities", "Pass", driver);

		} catch (AssertionError validateCarriedForwardAmountOfAllFacilities) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCarriedForwardAmountOfAllFacilities test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCarriedForwardAmountOfAllFacilities_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCarriedForwardAmountOfAllFacilities.printStackTrace();
			node.fail(validateCarriedForwardAmountOfAllFacilities);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCarriedForwardAmountOfAllFacilities) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCarriedForwardAmountOfAllFacilities test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCarriedForwardAmountOfAllFacilities_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCarriedForwardAmountOfAllFacilities.printStackTrace();
			node.fail(validateCarriedForwardAmountOfAllFacilities);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _103
	@Test(priority = 46)
	public void validateForecastedValue() throws IOException {

		try {
			extenttest = extent.createTest("Verify the Forecasted Value")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep2 function to access step2 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Create Dynamic Locator for Forecast
			String forecastLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.forecastTableInStep3, "locatorValue", AllPagesData.forecastTableHeader);

			// Scroll to the facilityRateMaxDifferenceTolerance
			IElementActions.scrollbyJSExecutorUsingElementPath(driver,
					FundingInterestPaymentPO.facilityRateMaxDifferenceTolerance);
			node.log(Status.INFO, "STEP1 : Scrolled to the facility rate max difference tolerance");
			System.out.println("STEP1 : Scrolled to the facility rate max difference tolerance");

			// Wait for Page Load
			node.log(Status.INFO, "STEP2 : Waiting for the complete page loding");
			System.out.println("STEP2 : Waiting for the complete page loading");
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.facilitiesForecastedAmount);
			node.log(Status.INFO, "STEP3 : Complete Page is load successfully");
			System.out.println("STEP3 : Complete Page is load successfully");

			// Locate the list element by its XPath
			List<WebElement> elementsInStep2 = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.facilitiesForecastedAmount);

			// Initialize a List to store facility forecasted amounts as strings
			List<String> facilityForecastedAmountsInStep2 = new ArrayList<>();

			// Get the Facility Forecasted Loan Amount
			String facilityForecastedLoanAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.facilityForecastedLoanAmount);

			facilityForecastedAmountsInStep2.add(facilityForecastedLoanAmount);

			// Iterate through each element in the list
			for (WebElement element : elementsInStep2) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				facilityForecastedAmountsInStep2.add(elementValue);
			}

			// Print or use the List of facility amounts as needed
			System.out.println("Facility Carried Forward Amounts in step2: " + facilityForecastedAmountsInStep2);

			// Call the navigateToStep function from the FundingPage
			FundingPage.navigateToStep(FundingInterestPaymentPO.monthOnMonthComparisonStep3);

			// Scroll Horizontal to Last
			IElementActions.scrollHorizontalToLast(driver);

			// Wait for the visibility of the carriedForwardText
			node.log(Status.INFO, "STEP4 : Waiting for the visibility of the carrid forward");
			System.out.println("STEP4 : Waiting for the visibility of the carrid forward");
			IWaitStrategy.waitForVisiblity(node, driver, forecastLocator);
			node.log(Status.INFO, "STEP5 : Carreid forward is visible");
			System.out.println("STEP5 : Carried forward is visible");

			// Locate the list element by its XPath
			List<WebElement> elementsInStep3 = IElementActions.returnElements(node, driver, forecastLocator);

			// Initialize a List to store facility amounts as strings
			List<String> facilityForecastedAmountsInStep3 = new ArrayList<>();

			// Iterate through each element in the list
			for (WebElement element : elementsInStep3) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				facilityForecastedAmountsInStep3.add(elementValue);
			}

			// Print or use the List of facility amounts as needed
			System.out.println("Facility Carried Forward Amounts in step3: " + facilityForecastedAmountsInStep3);

			// Perform assertion for each pair of values in the lists
			boolean allValuesMatch = true;

			for (int i = 0; i < facilityForecastedAmountsInStep2.size(); i++) {
				String valueFromList1 = facilityForecastedAmountsInStep2.get(i);
				String valueFromList2 = facilityForecastedAmountsInStep3.get(i);

				// Check if the values match
				if (!valueFromList1.equals(valueFromList2)) {
					allValuesMatch = false;
					System.out.println("Values at position " + i + " do not match:");
					System.out.println("List 1: " + valueFromList1);
					System.out.println("List 2: " + valueFromList2);
				}
			}

			// Perform the final assertion based on the matching status
			Assert.assertTrue(allValuesMatch, "Not all values in the lists match");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateForecastedValue", "Pass", driver);

		} catch (AssertionError validateForecastedValue) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateForecastedValue test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateForecastedValue_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateForecastedValue.printStackTrace();
			node.fail(validateForecastedValue);
			Assert.fail();
			extent.flush();

		} catch (Exception validateForecastedValue) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateForecastedValue test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateForecastedValue_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateForecastedValue.printStackTrace();
			node.fail(validateForecastedValue);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _104
	@Test(priority = 47)
	public void validateForecastPercentage() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify the % Difference is calculated as  100 * (Facility Payable- Forcasted) / (Facility Payable)")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Deviation
			double deviatedValue = Double.parseDouble(getDataFromExcel(12));

			// Calling loadInterestPaymentPageAndNavigateToStep2 function to access step2 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Locate the list element by its XPath
			List<WebElement> facilitiesLoanAmount = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.facilitiesLoanAmount);

			// Locate the list element by its XPath
			List<WebElement> facilitiesForecastedAmount = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.facilitiesForecastedAmount);

			// Locate the list element by its XPath
			List<WebElement> facilitiesForecastPercentage = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.facilitiesDifferencePercentage);

			// Get the Payable Loan Amount
			String payableLoanAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.facilityLoanAmount);

			// Get the Forecasted Loan Amount
			String forecastedLoanAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.facilityForecastedLoanAmount);

			// Get the Loan Forecast Percentage
			String loanForecastPercentage = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.totalDifferencePercentage);

			// Check for payableLoanAmountValue
			int payableLoanValue = Utils.parseCurrencyValue(payableLoanAmount);
			node.log(Status.INFO, "Step1- Payable loan value is " + payableLoanValue);
			System.out.println("Step1 - Payable loan value is " + payableLoanValue);

			// Check for forecastLoanValue
			int forecastLoanValue = Utils.parseCurrencyValue(forecastedLoanAmount);
			node.log(Status.INFO, "Step2- Forecast loan value is " + forecastLoanValue);
			System.out.println("Step2 - Forecast loan value is " + forecastLoanValue);

			// Check for loanForecastPercentage
			double loanForecastPercentageValue = Utils.parseCurrencyValueToDouble(loanForecastPercentage);
			node.log(Status.INFO, "Step3- Forecast percentage loan value is " + loanForecastPercentageValue);
			System.out.println("Step3- Forecast percentage loan value is " + loanForecastPercentageValue);

			// Calling the calculateDifference function from Utils
			int loanDiff = Utils.calculateDifference(payableLoanValue, forecastLoanValue);
			node.log(Status.INFO,
					"Step4- Calculated difference between Loan this month payable and  Loan Forecast is " + loanDiff);
			System.out.println(
					"Step4- Calculated difference between Loan this month payable and  Loan Forecast is " + loanDiff);

			double loanResult = 0;
			// Format the result to one decimal place
			DecimalFormat df = new DecimalFormat("#.#");
			// Check if the divisor is not zero to avoid division by zero
			if (payableLoanValue != 0L) {
				// Perform division
				loanResult = ((double) loanDiff / payableLoanValue) * 100;

				loanResult = Double.parseDouble(df.format(loanResult));

				// Print the result
				node.log(Status.PASS, "STEP-01 : Loan Forecast percentage calculated value is " + loanResult);
				System.out.println("STEP-01 : Loan Forecast percentage calculated value is " + loanResult);

			} else {
				node.log(Status.FAIL, "Error: Division by zero is not allowed.");
				System.out.println("Error: Division by zero is not allowed.");

			}

			double loanDifference = Utils.calculateDifference(loanResult, loanForecastPercentageValue);
			node.log(Status.INFO, "Step5 - Difference between actual and expected  Forecast percentage loan value is "
					+ loanDifference);
			System.out.println("Step5 - Difference between actual and expected  Forecast percentage loan value is "
					+ loanDifference);

			// TestNG assertion with deviation check
			Assert.assertTrue(loanDifference <= deviatedValue,
					"Deviation for the  Forecast difference percentage loan is " + loanDifference);

			int checkAllElements = 0;
			double totalDifference = 0;
			// Add values index-wise
			for (int i = 0; i < facilitiesForecastPercentage.size() - 1; i++) {

				int diff = 0;

				int thisMonthPayable = Utils.parseCurrencyValue(facilitiesLoanAmount.get(i).getText());
				node.log(Status.INFO, "Step1- This month payable is " + thisMonthPayable);
				System.out.println("Step1 - This month payable is " + thisMonthPayable);

				int forecast = Utils.parseCurrencyValue(facilitiesForecastedAmount.get(i).getText());
				node.log(Status.INFO, "Step2- Forecast value is " + forecast);
				System.out.println("Step2 - Forecast value is  " + forecast);

				diff = Utils.calculateDifference(thisMonthPayable, forecast);
				node.log(Status.INFO, "Step3- Calculated This month payable and Forecast difference is " + diff);
				System.out.println("Step3- Calculated This month payable and Forecast difference is " + diff);

				double forecastPercentageValue = Utils
						.parseCurrencyValueToDouble(facilitiesForecastPercentage.get(i).getText());
				node.log(Status.INFO, "Step4- Forecast percentage value is " + forecastPercentageValue);
				System.out.println("Step4 - Forecast percentage value is  " + forecastPercentageValue);

				double totalResult = 0;

				// Check if the divisor is not zero to avoid division by zero
				if (thisMonthPayable != 0L) {
					// Perform division
					totalResult = ((double) diff / thisMonthPayable) * 100;

					totalResult = Double.parseDouble(df.format(totalResult));

					// Print the result
					node.log(Status.PASS, "STEP-01 : Forecast percentage calculated value is " + totalResult);
					System.out.println("STEP-01 : Forecast percentage calculated value is " + totalResult);

				} else {
					node.log(Status.FAIL, "Error: Division by zero is not allowed.");
					System.out.println("Error: Division by zero is not allowed.");

				}

				totalDifference = Utils.calculateDifference(totalResult, forecastPercentageValue);

				node.log(Status.INFO, "Step5 - Difference between actual and expected  Forecast percentage value is "
						+ totalDifference);
				System.out.println("Step5 - Difference between actual and expected  Forecast percentage value is "
						+ totalDifference);

				if (totalDifference > deviatedValue) {
					checkAllElements++;
				}

			}

			// TestNG assertion with deviation check
			Assert.assertTrue(totalDifference <= deviatedValue, "Deviation for the total is " + totalDifference);

			// Print the result
			if (checkAllElements == 0) {

				Assert.assertTrue(true, "All values are correct");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateForecastPercentage", "Pass", driver);
			} else {

				Assert.assertTrue(false,
						"Difference between actual and expected Forecast Percentage value is greater than "
								+ deviatedValue + " for " + checkAllElements + " elements");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateForecastPercentage", "Fail", driver);

			}
		} catch (AssertionError validateForecastPercentage) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateForecastPercentage test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateForecastPercentage_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateForecastPercentage.printStackTrace();
			node.fail(validateForecastPercentage);
			Assert.fail();
			extent.flush();

		} catch (Exception validateForecastPercentage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateForecastPercentage test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateForecastPercentage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateForecastPercentage.printStackTrace();
			node.fail(validateForecastPercentage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _105
	@Test(priority = 48)
	public void validateDayCountFractionSection() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the following details are displayed under the Day count section:"
							+ "-Last Period Number of Days" + "-This Period Number of Days" + "-This Month DCF"
							+ "-DCF Adjustment")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep2 function to access step2 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Scroll Horizontal to Last
			IElementActions.scrollHorizontalToLast(driver);

			// Wait for the visibility of the lastPeriodNumberOfDays
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the Carried forward");
			System.out.println("STEP1 : Waiting for the visibility of the Carried forward");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.lastPeriodNumberOfDays);
			node.log(Status.INFO, "STEP2 : Carried forward is visible");
			System.out.println("STEP2 : Carried forward is visible");

			// Check the visibility of Last Period Number Of Days
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.lastPeriodNumberOfDays,
					"STEP3 : BUG: Last Period Number Of Days is not coming on Interest Paymente page",
					"STEP3 : EXPECTED: Last Period Number Of Days is coming on Interest Paymente page");

			// Check the visibility of This Period Number Of Days
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.thisPeriodNumberOfDays,
					"STEP4 : BUG: This Period Number Of Days is not coming on Interest Paymente page",
					"STEP4 : EXPECTED: This Period Number Of Days is coming on Interest Paymente page");

			// Check the visibility of Last Month DCF
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.lastMonthDCF,
					"STEP5 : BUG: Last Month DCF is not coming on Interest Paymente page",
					"STEP5 : EXPECTED: Last Month DCF is coming on Interest Paymente page");

			// Check the visibility of This Month DCF
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.thisMonthDCF,
					"STEP6 : BUG: This Month DCF is not coming on Interest Paymente page",
					"STEP6 : EXPECTED:TYhis Month DCF is coming on Interest Paymente page");

			// Check the visibility of DCF Adjustment
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.DCFAdjustment,
					"STEP7 : BUG: DCF Adjustment is not coming on Interest Paymente page",
					"STEP7 : EXPECTED: DCF Adjustment is coming on Interest Paymente page");

			// Check the visibility of Last Period Number Of Days value
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.lastPeriodNumberOfDaysValue,
					"STEP8 : BUG: Last Period Number Of Days value is not coming on Interest Paymente page",
					"STEP8 : EXPECTED: Last Period Number Of Days value is coming on Interest Paymente page");

			// Check the visibility of This Period Number Of Days Value
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.thisPeriodNumberOfDaysValue,
					"STEP9 : BUG: This Period Number Of Days value is not coming on Interest Paymente page",
					"STEP9 : EXPECTED: This Period Number Of Days value is coming on Interest Paymente page");

			// Check the visibility of Last Month DCF value
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.lastMonthDCFValue,
					"STEP10 : BUG: Last Month DCF value is not coming on Interest Paymente page",
					"STEP10 : EXPECTED: Last Month DCF value is coming on Interest Paymente page");

			// Check the visibility of This Month DCF value
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.thisMonthDCFValue,
					"STEP11 : BUG: This Month DCF value is not coming on Interest Paymente page",
					"STEP11 : EXPECTED:TYhis Month DCF value is coming on Interest Paymente page");

			// Check the visibility of DCF Adjustment value
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.DCFAdjustmentValue,
					"STEP12 : BUG: DCF Adjustment value is not coming on Interest Paymente page",
					"STEP12 : EXPECTED: DCF Adjustment value is coming on Interest Paymente page");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDayCountFractionSection", "Pass", driver);

		} catch (AssertionError validateDayCountFractionSection) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDayCountFractionSection test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDayCountFractionSection_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDayCountFractionSection.printStackTrace();
			node.fail(validateDayCountFractionSection);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDayCountFractionSection) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateForecastedValue test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDayCountFractionSection_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDayCountFractionSection.printStackTrace();
			node.fail(validateDayCountFractionSection);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _106
	@Test(priority = 49)
	public void validateLastPeriodNumberOfDaysInStep2() throws IOException {

		try {
			extenttest = extent.createTest(
					"Step2 - Verify that the Last Period Number of Days is equal to the total number of days in the previous interest period.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			String selectedYear = getDataFromExcel(6);
			String selectedMonth = getDataFromExcel(7);

			// Calling loadInterestPaymentPageAndNavigateToStep2 function to access step2 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(selectedYear, selectedMonth);

			// Scroll Horizontal to Last
			IElementActions.scrollHorizontalToLast(driver);

			// Wait for the visibility of the lastPeriodNumberOfDays
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the Last Period Number Of Days");
			System.out.println("STEP1 : Waiting for the visibility of the Last Period Number Of Days");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.lastPeriodNumberOfDays);
			node.log(Status.INFO, "STEP2 : Last Period Number Of Days is visible");
			System.out.println("STEP2 : Last Period Number Of Days is visible");

			// Get the lastPeriodNumberOfDays
			String actualLastPeriodNumberOfDays = IElementActions.getTextbyXpath(node,
					FundingInterestPaymentPO.lastPeriodNumberOfDaysValue);

			// Convert the string to an integer
			int intMonthValue = Integer.parseInt(selectedMonth);
			int intPreviousMonthValue = intMonthValue - 1;

			// Convert the result back to a string
			String previousMonth = String.valueOf(intPreviousMonthValue);

			// Get the Previous Month Dates
			String[] previousMonthDates = FundingPage.calculateDates(selectedYear, previousMonth);

			// Get the Days Difference Previous Month
			long daysDifferencePreviousMonth = Utils.getNumberOfDaysBetweenTwoDates(previousMonthDates[0],
					previousMonthDates[1]);
			node.log(Status.INFO, "STEP3 : Number of days between the two dates: " + daysDifferencePreviousMonth);
			System.out.println("STEP3 : Number of days between the two dates: " + daysDifferencePreviousMonth);

			// Convert the long to a String using String.valueOf()
			String expectedLastPeriodNumberOfDays = String.valueOf(daysDifferencePreviousMonth);

			// Assert the Last Period Number Of Days
			IElementActions.assertEquals_usingString(node, driver, actualLastPeriodNumberOfDays,
					expectedLastPeriodNumberOfDays,
					"STEP4 : BUG:  Actual Last Period Number Of Days" + actualLastPeriodNumberOfDays
							+ " is not matching with expected days " + expectedLastPeriodNumberOfDays,
					"STEP4 : EXPECTED: Actual Last Period Number Of Days " + actualLastPeriodNumberOfDays
							+ " is matching with expected days " + expectedLastPeriodNumberOfDays);

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateLastPeriodNumberOfDaysInStep2", "Pass", driver);

		} catch (AssertionError validateLastPeriodNumberOfDaysInStep2) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLastPeriodNumberOfDaysInStep2 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLastPeriodNumberOfDaysInStep2_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLastPeriodNumberOfDaysInStep2.printStackTrace();
			node.fail(validateLastPeriodNumberOfDaysInStep2);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLastPeriodNumberOfDaysInStep2) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLastPeriodNumberOfDaysInStep2 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLastPeriodNumberOfDaysInStep2_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLastPeriodNumberOfDaysInStep2.printStackTrace();
			node.fail(validateLastPeriodNumberOfDaysInStep2);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _107
	@Test(priority = 50)
	public void validateThisPeriodNumberOfDaysValue() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the This Period Number of Days is equal to the total number of days in the current interest period.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");
			String selectedYear = getDataFromExcel(6);
			String selectedMonth = getDataFromExcel(7);

			// Calling loadInterestPaymentPageAndNavigateToStep2 function to access step2 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(selectedYear, selectedMonth);

			// Scroll to Last
			IElementActions.scrollHorizontalToLast(driver);

			// Wait for the visibility of the lastPeriodNumberOfDays
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the Last Period Number Of Days");
			System.out.println("STEP1 : Waiting for the visibility of the Last Period Number Of Days");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.lastPeriodNumberOfDays);
			node.log(Status.INFO, "STEP2 : Last Period Number Of Days is visible");
			System.out.println("STEP2 : Last Period Number Of Days is visible");

			// Get the thisPeriodNumberOfDays
			String actualThisPeriodNumberOfDays = IElementActions.getTextbyXpath(node,
					FundingInterestPaymentPO.thisPeriodNumberOfDaysValue);
			node.log(Status.INFO, "STEP3 : This Period Number Of Days : " + actualThisPeriodNumberOfDays);
			System.out.println("STEP3 : This Period Number Of Days : " + actualThisPeriodNumberOfDays);

			// Calling the calculateDates function from FundingPage and get start and end
			// dates
			String[] dates = FundingPage.calculateDates(selectedYear, selectedMonth);

			// Calling the getNumberOfDaysBetweenTwoDates from Utils
			long daysDifferenceThisMonth = Utils.getNumberOfDaysBetweenTwoDates(dates[0], dates[1]);
			node.log(Status.INFO, "STEP4 : Number of days between the two dates: " + daysDifferenceThisMonth);
			System.out.println("STEP4 : Number of days between the two dates: " + daysDifferenceThisMonth);

			// Convert the long to a String using String.valueOf()
			String expectedThisPeriodNumberOfDays = String.valueOf(daysDifferenceThisMonth);

			// Assert This Period Number Of Days
			IElementActions.assertEquals_usingString(node, driver, actualThisPeriodNumberOfDays,
					expectedThisPeriodNumberOfDays,
					"STEP5 : BUG:  Actual This Period Number Of Days" + actualThisPeriodNumberOfDays
							+ " is not matching with expected days " + expectedThisPeriodNumberOfDays,
					"STEP5 : EXPECTED: Actual This Period Number Of Days " + actualThisPeriodNumberOfDays
							+ " is matching with expected days " + expectedThisPeriodNumberOfDays);
			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateThisPeriodNumberOfDaysValue", "Pass", driver);

		} catch (AssertionError validateThisPeriodNumberOfDaysValue) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateThisPeriodNumberOfDaysValue test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateThisPeriodNumberOfDaysValue_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateThisPeriodNumberOfDaysValue.printStackTrace();
			node.fail(validateThisPeriodNumberOfDaysValue);
			Assert.fail();
			extent.flush();

		} catch (Exception validateThisPeriodNumberOfDaysValue) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateThisPeriodNumberOfDaysValue test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateThisPeriodNumberOfDaysValue_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateThisPeriodNumberOfDaysValue.printStackTrace();
			node.fail(validateThisPeriodNumberOfDaysValue);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _108
	@Test(priority = 51)
	public void validateLastMonthDCFValue() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the Last Month DCF is calculated as per the below formula:"
							+ "(Last Period Number of Days)/(Last Period Number of Days)")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");
			String selectedYear = getDataFromExcel(6);
			String selectedMonth = getDataFromExcel(7);

			// Calling loadInterestPaymentPageAndNavigateToStep2 function to access step2 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(selectedYear, selectedMonth);

			// Scroll to Last
			IElementActions.scrollHorizontalToLast(driver);

			// Scroll Horizontally to Day Count Fraction Table
			Thread.sleep(1000);
			IElementActions.scrollHorizontally(driver, FundingInterestPaymentPO.dayCountFractionTable, 1000);

			// Scroll to Top
			Thread.sleep(1000);
			IElementActions.scrollToTop(driver);

			// Wait for the visibility of the lastMonthDCFValue
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the last month DCF value");
			System.out.println("STEP1 : Waiting for the visibility of the last month DCF value");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.lastMonthDCFValue);
			node.log(Status.INFO, "STEP2 : Last month DCF value is visible");
			System.out.println("STEP2 : Last month DCF value is visible");

			// Get the Last Period Number Of Days
			String lastPeriodNumberOfDays = IElementActions.getTextbyXpath(node,
					FundingInterestPaymentPO.lastPeriodNumberOfDaysValue);
			node.log(Status.INFO, "STEP3 : The Last Period Number Of Days : " + lastPeriodNumberOfDays);
			System.out.println("STEP3 : The Last Period Number Of Days : " + lastPeriodNumberOfDays);

			// Get the This Period Number Of Days
			String thisPeriodNumberOfDays = IElementActions.getTextbyXpath(node,
					FundingInterestPaymentPO.thisPeriodNumberOfDaysValue);
			node.log(Status.INFO, "STEP4 : This Period Number Of Days : " + thisPeriodNumberOfDays);
			System.out.println("STEP4 : This Period Number Of Days : " + thisPeriodNumberOfDays);

			// Get the Last Month DCF Value
			Double actualLastMonthDCFValue = Utils
					.getPercentageTextAndParseToDouble(FundingInterestPaymentPO.lastMonthDCFValue);
			node.log(Status.INFO, "STEP5 : The Last Month DCF Value " + actualLastMonthDCFValue);
			System.out.println("STEP5 : The Last Month DCF Value " + actualLastMonthDCFValue);

			Double lastPeriodNumberOfDaysValue = IElementActions.parseStringToDoubleWithTwoDecimal(driver,
					lastPeriodNumberOfDays);
			Double thisPeriodNumberOfDaysValue = IElementActions.parseStringToDoubleWithTwoDecimal(driver,
					thisPeriodNumberOfDays);

			Double result = 0.0;
			// Check if the divisor is not zero to avoid division by zero
			if (thisPeriodNumberOfDaysValue != 0.0) {
				// Perform division
				result = lastPeriodNumberOfDaysValue / thisPeriodNumberOfDaysValue;

				// Print the result
				node.log(Status.INFO, "STEP-01 : Result of division " + result);
				System.out.println("STEP-01 : Result of division " + result);

			} else {
				node.log(Status.FAIL, "Error: Division by zero is not allowed.");
				System.out.println("Error: Division by zero is not allowed.");

			}

			// Set the acceptable difference
			double acceptableDifference = Double.parseDouble(getDataFromExcel(10));

			// Perform assertion allowing for a difference around 5 with a delta parameter
			Assert.assertEquals(actualLastMonthDCFValue, result, acceptableDifference,
					"Difference is greater than the acceptable range");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateLastMonthDCFValue", "Pass", driver);

		} catch (AssertionError validateLastMonthDCFValue) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLastMonthDCFValue test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLastMonthDCFValue_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLastMonthDCFValue.printStackTrace();
			node.fail(validateLastMonthDCFValue);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLastMonthDCFValue) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLastMonthDCFValue test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLastMonthDCFValue_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLastMonthDCFValue.printStackTrace();
			node.fail(validateLastMonthDCFValue);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _109
	@Test(priority = 52)
	public void validateThisMonthDCFValue() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the This Month DCF is calculated as per the below formula:"
							+ "(This Period Number of Days)/(This Period Number of Days)")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");
			String selectedYear = getDataFromExcel(6);
			String selectedMonth = getDataFromExcel(7);

			// Calling loadInterestPaymentPageAndNavigateToStep2 function to access step2 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(selectedYear, selectedMonth);

			// Scroll to Last
			IElementActions.scrollHorizontalToLast(driver);

			// Scroll Horizontally to Day Count Fraction Table
			Thread.sleep(1000);
			IElementActions.scrollHorizontally(driver, FundingInterestPaymentPO.dayCountFractionTable, 1000);

			// Scroll to Top
			Thread.sleep(1000);
			IElementActions.scrollToTop(driver);

			// Wait for the visibility of the thisMonthDCFValue
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the this month DCF value");
			System.out.println("STEP1 : Waiting for the visibility of the this month DCF value");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.thisMonthDCFValue);
			node.log(Status.INFO, "STEP2 : This month DCF value is visible");
			System.out.println("STEP2 : This month DCF value is visible");

			// Get the Last Period Number Of Days
			String lastPeriodNumberOfDays = IElementActions.getTextbyXpath(node,
					FundingInterestPaymentPO.lastPeriodNumberOfDaysValue);
			node.log(Status.INFO, "STEP3 : The Last Period Number Of Days : " + lastPeriodNumberOfDays);
			System.out.println("STEP3 : The Last Period Number Of Days : " + lastPeriodNumberOfDays);

			// Get the This Period Number Of Days
			String thisPeriodNumberOfDays = IElementActions.getTextbyXpath(node,
					FundingInterestPaymentPO.thisPeriodNumberOfDaysValue);
			node.log(Status.INFO, "STEP4 : This Period Number Of Days : " + thisPeriodNumberOfDays);
			System.out.println("STEP4 : This Period Number Of Days : " + thisPeriodNumberOfDays);

			// Get the This Month DCF Value
			Double actualThisMonthDCFValue = Utils
					.getPercentageTextAndParseToDouble(FundingInterestPaymentPO.thisMonthDCFValue);
			node.log(Status.INFO, "STEP5 : This Month DCF Value : " + actualThisMonthDCFValue);
			System.out.println("STEP5 : This Month DCF Value : " + actualThisMonthDCFValue);

			// Parse the Last Period Number Of Days to Double
			Double lastPeriodNumberOfDaysValue = IElementActions.parseStringToDoubleWithTwoDecimal(driver,
					lastPeriodNumberOfDays);

			// Parse the This Period Number Of Days to Double
			Double thisPeriodNumberOfDaysValue = IElementActions.parseStringToDoubleWithTwoDecimal(driver,
					thisPeriodNumberOfDays);

			Double result = 0.0;
			// Check if the divisor is not zero to avoid division by zero
			if (lastPeriodNumberOfDaysValue != 0L) {
				// Perform division
				result = thisPeriodNumberOfDaysValue / lastPeriodNumberOfDaysValue;

				// Print the result
				node.log(Status.INFO, "STEP-01 : Result of division " + result);
				System.out.println("STEP-01 : Result of division " + result);

			} else {
				node.log(Status.FAIL, "Error: Division by zero is not allowed.");
				System.out.println("Error: Division by zero is not allowed.");

			}

			// Set the acceptable difference
			double acceptableDifference = Double.parseDouble(getDataFromExcel(10));

			// Perform assertion allowing for a difference around 5 with a delta parameter
			Assert.assertEquals(actualThisMonthDCFValue, result, acceptableDifference,
					"Difference is greater than the acceptable range");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateThisMonthDCFValue", "Pass", driver);

		} catch (AssertionError validateThisMonthDCFValue) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateThisMonthDCFValue test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateThisMonthDCFValue_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateThisMonthDCFValue.printStackTrace();
			node.fail(validateThisMonthDCFValue);
			Assert.fail();
			extent.flush();

		} catch (Exception validateThisMonthDCFValue) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateThisMonthDCFValue test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateThisMonthDCFValue_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateThisMonthDCFValue.printStackTrace();
			node.fail(validateThisMonthDCFValue);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _110
	@Test(priority = 53)
	public void validateDCFAdjustmentValue() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the DCF Adjustment (%) is calculated as per the below formula:"
							+ "100*(This Month DCF - Last Month DCF) / (Last Month DCF)")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			String selectedYear = getDataFromExcel(6);
			String selectedMonth = getDataFromExcel(7);

			// Calling loadInterestPaymentPageAndNavigateToStep2 function to access step2 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(selectedYear, selectedMonth);

			// Scroll Horizontal to Last
			IElementActions.scrollHorizontalToLast(driver);

			// Scroll Horizontally to Day Count Fraction Table
			Thread.sleep(1000);
			IElementActions.scrollHorizontally(driver, FundingInterestPaymentPO.dayCountFractionTable, 1000);

			// Scroll To Top
			Thread.sleep(1000);
			IElementActions.scrollToTop(driver);

			// Wait for the visibility of the DCFAdjustmentValue
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the DCF Adjustment");
			System.out.println("STEP1 : Waiting for the visibility of the DCF Adjustment");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.DCFAdjustmentValue);
			node.log(Status.INFO, "STEP2 : DCF Adjustment value is visible");
			System.out.println("STEP2 : DCF Adjustment value is visible");

			// Get the This Month DCF Value
			String actualThisMonthDCFValue = IElementActions.getTextbyXpath(node,
					FundingInterestPaymentPO.thisMonthDCFValue);
			node.log(Status.INFO, "STEP3 : This Month DCF Value : " + actualThisMonthDCFValue);
			System.out.println("STEP3 : This Month DCF Value : " + actualThisMonthDCFValue);

			// Get the Last Month DCF Value
			String actualLastMonthDCFValue = IElementActions.getTextbyXpath(node,
					FundingInterestPaymentPO.lastMonthDCFValue);
			node.log(Status.INFO, "STEP4 :The Last Month DCF Value : " + actualLastMonthDCFValue);
			System.out.println("STEP4 : The Last Month DCF Value : " + actualLastMonthDCFValue);

			// Get the DCFAdjustmentValue
			Double actualDCFAdjustmentValue = Utils
					.getTextAndParseToDouble(FundingInterestPaymentPO.DCFAdjustmentValue);
			node.log(Status.INFO, "STEP5 : actualDCFAdjustmentValue " + actualDCFAdjustmentValue);
			System.out.println("STEP5 : actualDCFAdjustmentValue " + actualDCFAdjustmentValue);

			// Parse the Last Month DCF Value to Double
			Double lastMonthDCFValue = IElementActions.parseStringToDoubleWithTwoDecimal(driver,
					actualLastMonthDCFValue);

			// Parse This Month DCF Value to Double
			Double thisMonthDCFValue = IElementActions.parseStringToDoubleWithTwoDecimal(driver,
					actualThisMonthDCFValue);

			Double result = 0.0;

			// Check if the divisor is not zero to avoid division by zero
			if (lastMonthDCFValue != 0.0) {
				// Perform division
				result = 100 * (thisMonthDCFValue - lastMonthDCFValue) / lastMonthDCFValue;

				// Print the result
				node.log(Status.INFO, "STEP-01 : Result of division " + result);
				System.out.println("STEP-01 : Result of division " + result);

			} else {
				node.log(Status.FAIL, "Error: Division by zero is not allowed.");
				System.out.println("Error: Division by zero is not allowed.");

			}

			// Set the acceptable difference
			double acceptableDifference = Double.parseDouble(getDataFromExcel(10));

			// Perform assertion allowing for a difference around 5 with a delta parameter
			Assert.assertEquals(actualDCFAdjustmentValue, result, acceptableDifference,
					"Difference is greater than the acceptable range");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateLastMonthDCFValue", "Pass", driver);

		} catch (AssertionError validateLastMonthDCFValue) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLastMonthDCFValue test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLastMonthDCFValue_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLastMonthDCFValue.printStackTrace();
			node.fail(validateLastMonthDCFValue);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLastMonthDCFValue) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLastMonthDCFValue test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLastMonthDCFValue_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLastMonthDCFValue.printStackTrace();
			node.fail(validateLastMonthDCFValue);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _111
	@Test(priority = 54)
	public void validateDeferredInterestCheckTableDetails() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the following column names are displayed:" + "-Internal Reference" + "-Reference"
							+ "-Last Month" + "-This Month" + "-Change" + "-[Day Count:" + "Last Month / This Month]")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Scrolled Down to Day Count Fraction
			System.out.println("STEP1 : Scrolled down to Day Count Fraction");
			node.log(Status.INFO, "STEP1 : Scrolled down to Day Count Fraction");
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingInterestPaymentPO.dayCountFraction);

			// Check the visibility of Internal Reference Column
			IElementActions.assertTrue_usingXpath(node, driver,
					FundingInterestPaymentPO.deferredInternalReferenceColumn,
					"STEP2 : BUG: The Internal Reference Column is not coming in Deferred Interest Check Table in Step2",
					"STEP2 : EXPECTED: The Internal Reference Column is coming in Deferred Interest Check Table in Step2");

			// Check the visibility of Reference Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deferredReferenceColumn,
					"STEP3 : BUG: The Reference Column is not coming in Deferred Interest Check Table in Step2",
					"STEP3 : EXPECTED: The Reference Column is coming in Deferred Interest Check Table in Step2");

			// Check the visibility of Last Month Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deferredLastMonthColumn,
					"STEP4 : BUG: The Last Month Column is not coming in Deferred Interest Check Table in Step2",
					"STEP4 : EXPECTED: The Last Month Column is coming in Deferred Interest Check Table in Step2");

			// Check the visibility of This Month Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deferredThisMonthColumn,
					"STEP5 : BUG: This Month Column is not coming in Deferred Interest Check Table in Step2",
					"STEP5 : EXPECTED: This Month Column is coming in Deferred Interest Check Table in Step2");

			// Check the visibility of Change Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deferredChangeColumn,
					"STEP6 : BUG: The Change Column is not coming in Deferred Interest Check Table in Step2",
					"STEP6 : EXPECTED: The Change Column is coming in Deferred Interest Check Table in Step2");

			// Check the visibility of Day Count Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deferredDayCountColumn,
					"STEP7 : BUG: The Day Count Column is not coming in Deferred Interest Check Table in Step2",
					"STEP7 : EXPECTED: The Day Count Column is coming in Deferred Interest Check Table in Step2");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDeferredInterestCheckTableDetails", "Pass", driver);

		} catch (AssertionError validateDeferredInterestCheckTableDetails) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDeferredInterestCheckTableDetails test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDeferredInterestCheckTableDetails_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeferredInterestCheckTableDetails.printStackTrace();
			node.fail(validateDeferredInterestCheckTableDetails);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDeferredInterestCheckTableDetails) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDeferredInterestCheckTableDetails test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDeferredInterestCheckTableDetails_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeferredInterestCheckTableDetails.printStackTrace();
			node.fail(validateDeferredInterestCheckTableDetails);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _112
	@Test(priority = 55)
	public void validateLoangeneratedDeferredInterest() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user is able to see loan generated deferred interest in this month or the prior month if  either Default Days > 0 or Standard Interest Days > 0 in this/prior month.")
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

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), month);

			String loanReferenceNumber = getDataFromExcel(14);

			// Create Dynamic Locator for Day count
			String dayCountLocator = IElementActions.createDynamicLocatorString(FundingInterestPaymentPO.dayCountValue,
					"locatorValue", loanReferenceNumber);

			// Create Dynamic Locator for Standard Interest Days
			String standardInterestDaysLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.standardInterestDaysValue, "locatorValue", loanReferenceNumber);

			// Get the Day count value of Deferred Table
			String dayCountValue = IElementActions.getElementText_usingXpath(node, driver, dayCountLocator);
			node.log(Status.INFO, "STEP1 : The Day count value of Deferred Table is : " + dayCountValue);
			System.out.println("STEP1 : The Day count value of Deferred Table is : " + dayCountValue);

			String[] parts = dayCountValue.split("/");
			String actuallastMonthDays = parts[0].replace("[", "");
			node.log(Status.INFO, "STEP2 : Actual Last Month Days : " + actuallastMonthDays);
			System.out.println("STEP2 : Actual Last Month Days : " + actuallastMonthDays);

			String actualThisMonthDays = parts[1].replace("]", "");
			node.log(Status.INFO, "STEP3 : Actual This Month Days : " + actualThisMonthDays);
			System.out.println("STEP3 : Actual This Month Days : " + actualThisMonthDays);

			// Navigate to Step 4
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Get the This Month Standard Interest Days Value
			String expectedThisMonthStandardInterestDays = IElementActions.getElementText_usingXpath(node, driver,
					standardInterestDaysLocator);
			node.log(Status.INFO,
					"STEP4 : This Month Standard Interest Days Value is : " + expectedThisMonthStandardInterestDays);
			System.out.println(
					"STEP4 : This Month Standard Interest Days Value is : " + expectedThisMonthStandardInterestDays);

			// Close the Popup
			FundingPage.closePopUp();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), previousMonth);

			// Navigate to Step 4
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Get the Last Month Standard Interest Days Value
			String expectedLastMonthStandardInterestDays = IElementActions.getElementText_usingXpath(node, driver,
					standardInterestDaysLocator);
			node.log(Status.INFO,
					"STEP5 : Last Month Standard Interest Days Value is : " + expectedLastMonthStandardInterestDays);
			System.out.println(
					"STEP5 : Last Month Standard Interest Days Value is : " + expectedLastMonthStandardInterestDays);

			// Assert the Month Day Count of Deferred Table
			IElementActions.assertEquals_usingString(node, driver, actualThisMonthDays,
					expectedThisMonthStandardInterestDays,
					"STEP6 : BUG : This Month day count of Deferred Table is not equal to the Standard Interest days of This month On Loan Interet Details Popup",
					"STEP6 : PASS : This Month day count of Deferred Table is equal to the Standard Interest days of This month On Loan Interet Details Popup");

			// Assert the Last Month Day Count of Deferred Table
			IElementActions.assertEquals_usingString(node, driver, actuallastMonthDays,
					expectedLastMonthStandardInterestDays,
					"STEP7 : BUG : Last Month day count of Deferred Table is not equal to the Standard Interest days of Last month On Loan Interet Details Popup",
					"STEP7 : PASS : Last Month day count of Deferred Table is equal to the Standard Interest days of Last month On Loan Interet Details Popup");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoangeneratedDeferredInterest", "Pass", driver);

		} catch (AssertionError validateLoangeneratedDeferredInterest) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoangeneratedDeferredInterest test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoangeneratedDeferredInterest_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoangeneratedDeferredInterest.printStackTrace();
			node.fail(validateLoangeneratedDeferredInterest);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoangeneratedDeferredInterest) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoangeneratedDeferredInterest test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoangeneratedDeferredInterest_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoangeneratedDeferredInterest.printStackTrace();
			node.fail(validateLoangeneratedDeferredInterest);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _113
	// @Test(priority = 56)
	public void validateNoLoanInDeferredInterestCheck() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user is able to view no loan in the Deferred Interest Check table which has both Last Month and This Month day count as 0, i.e. for any loan in the table, given the day count column [x,y], at least one of x or y should be > 0.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Locate the elements listing Loan Reference Values
			List<WebElement> loanReferenceValues = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.allReferenceValues);

			// Locate the elements listing Day count values
			List<WebElement> dayCountValues = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.allDayCountValues);

			// Initialize lists for valid and invalid records
			List<String> validRecords = new ArrayList<>();
			List<String> invalidRecords = new ArrayList<>();

			// Iterate through Loan Reference Values
			for (int i = 0; i < loanReferenceValues.size(); i++) {

				// Extract Loan Reference Number
				WebElement loanReferenceValue = loanReferenceValues.get(i);
				String loanRefrence = loanReferenceValue.getText();

				// Extract Day count values
				WebElement dayCountElement = dayCountValues.get(i);
				String dayCountValue = dayCountElement.getText();
				node.log(Status.INFO, "The Day Count Value for " + loanRefrence + " is  : " + dayCountValue);
				System.out.println("The Day Count Value for " + loanRefrence + " is  : " + dayCountValue);

				String[] parts = dayCountValue.split("/");
				String lastMonthDays = parts[0].replace("[", "");
				String thisMonthDays = parts[1].replace("]", "");

				int lastMonthDaysCount = Integer.parseInt(lastMonthDays);
				int thisMonthDaysCount = Integer.parseInt(thisMonthDays);

				// Validate based on Day count
				if (lastMonthDaysCount == 0 && thisMonthDaysCount == 0) {
					invalidRecords.add(loanRefrence);
				} else {
					validRecords.add(loanRefrence);
				}
			}

			// Print valid records
			System.out.println("Valid Records:");
			for (String validRecord : validRecords) {
				System.out.println(validRecord);
				node.log(Status.PASS, validRecord);
			}

			// Print invalid records
			System.out.println("Invalid Records:");
			for (String invalidRecord : invalidRecords) {
				System.out.println(invalidRecord);
				node.log(Status.FAIL, invalidRecord);
			}

			// Assert no invalid records
			assert invalidRecords.isEmpty() : "Some records are invalid: " + invalidRecords;

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateNoLoanInDeferredInterestCheck", "Pass", driver);

		} catch (AssertionError validateNoLoanInDeferredInterestCheck) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNoLoanInDeferredInterestCheck test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNoLoanInDeferredInterestCheck_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNoLoanInDeferredInterestCheck.printStackTrace();
			node.fail(validateNoLoanInDeferredInterestCheck);
			Assert.fail();
			extent.flush();

		} catch (Exception validateNoLoanInDeferredInterestCheck) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNoLoanInDeferredInterestCheck test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNoLoanInDeferredInterestCheck_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNoLoanInDeferredInterestCheck.printStackTrace();
			node.fail(validateNoLoanInDeferredInterestCheck);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _114
	@Test(priority = 57)
	public void validateInternalReference() throws IOException {

		try {
			extenttest = extent.createTest("Verify the Internal Reference and Reference")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			String loanReferenceNumber = getDataFromExcel(14);

			// Create Dynamic Locator for internal Reference
			String internalReferenceLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.internalReferenceValue, "locatorValue", loanReferenceNumber);

			// Create Dynamic Locator for Reference
			String referenceLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.referenceValue, "locatorValue", loanReferenceNumber);

			// Get the Internal Reference Value from Deferred Interest Check Table
			String internalReferenceValue = IElementActions.getElementText_usingXpath(node, driver,
					internalReferenceLocator);
			node.log(Status.INFO,
					"STEP1 : Internal Reference Value Under Deferred Interest Check Table : " + internalReferenceValue);
			System.out.println(
					"STEP1 : Internal Reference Value Under Deferred Interest Check Table: " + internalReferenceValue);

			// Get the Reference Value from Deferred Interest Check Table
			String referenceValue = IElementActions.getElementText_usingXpath(node, driver, referenceLocator);
			node.log(Status.INFO, "STEP2 : Reference Value Under Deferred Interest Check Table : " + referenceValue);
			System.out.println("STEP2 : Reference Value Under Deferred Interest Check Table : " + referenceValue);

			// Calling the loadDatabasePage from LoansPage
			LoansPage.loadDatabasePage();

			// Call the openRecordUsingSearch from Utils
			Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, LoansDatabasePO.loanRefSearchField,
					referenceValue, UtilsPO.editIcon, LoansNewLoanPO.editBridgeLoanHeaderText);

			// Get the Reference Value on Edit Bridge loan Page
			String internalReference = IElementActions
					.getElementText_usingXpath(node, driver, LoansNewLoanPO.internalReference).substring(21);
			node.log(Status.INFO, "STEP5 : Internal Reference Value on Edit Bridge Loan Page : " + internalReference);
			System.out.println("STEP5 : Internal Reference Value on Edit Bridge Loan Page  : " + internalReference);

			// Assert the Internal Reference
			IElementActions.assertEquals_usingString(node, driver, internalReferenceValue, internalReference,
					"STEP6 : BUG : The Internal Reference Under Deferred Interest Check Table in Step2 is not same as Internal Reference on Edit Bridge Loan Page",
					"STEP6 : PASS :  The Internal Reference Under Deferred Interest Check Table in Step2 is same as Internal Reference on Edit Bridge Loan Page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateInternalReference", "Pass", driver);

		} catch (AssertionError validateInternalReference) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInternalReference test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateInternalReference_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInternalReference.printStackTrace();
			node.fail(validateInternalReference);
			Assert.fail();
			extent.flush();

		} catch (Exception validateInternalReference) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInternalReference test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateInternalReference_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInternalReference.printStackTrace();
			node.fail(validateInternalReference);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _115
	@Test(priority = 58)
	public void validateLastMonthValue() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the Last Month Value is calculated by Default Interest + Standard Interest - Default Interest Paid in the previous month")
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

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), month);

			String loanReferenceNumber = getDataFromExcel(14);

			// Create Dynamic Locator for Last Month
			String lastMonthLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.lastMonthValue, "locatorValue", loanReferenceNumber);

			// Create Dynamic Locator for Standard Interest
			String standardInterestLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.standardInterestValue, "locatorValue", loanReferenceNumber);

			// Create Dynamic Locator for Default Interest Paid
			String defaultInterestPaidLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.defaultInterestPaidVal, "locatorValue", loanReferenceNumber);

			// Calling the getTextAndParseToInt from Utils
			int actuallastMonth = Utils.getTextAndParseToInt(lastMonthLocator);

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), previousMonth);

			// Navigate to Step 4
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Calling the getTextAndParseToInt from Utils and get Standard Interest
			int standardInterest = Utils.getTextAndParseToInt(standardInterestLocator);

			// Calling the getTextAndParseToInt from Utils and get Default Interest Paid
			int defaultInterestPaid = Utils.getTextAndParseToInt(defaultInterestPaidLocator);

			// Calculate Expected Last Month Value
			int defaultInterest = 0;
			int expectedlastMonth = defaultInterest + Utils.calculateDifference(standardInterest, defaultInterestPaid);
			node.log(Status.INFO, "STEP1 : Calculated Last Month Value : " + expectedlastMonth);
			System.out.println("STEP1 :  Calculated Last Month Value : " + expectedlastMonth);

			// Set the acceptable difference
			int acceptableDifference = Integer.parseInt(getDataFromExcel(10));

			// Perform assertion allowing for a difference around 5 with a delta parameter
			Assert.assertEquals(actuallastMonth, expectedlastMonth, acceptableDifference,
					"Difference is greater than the acceptable range");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLastMonthValue", "Pass", driver);

		} catch (AssertionError validateLastMonthValue) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLastMonthValue test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLastMonthValue_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLastMonthValue.printStackTrace();
			node.fail(validateLastMonthValue);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLastMonthValue) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLastMonthValue test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLastMonthValue_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLastMonthValue.printStackTrace();
			node.fail(validateLastMonthValue);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _116
	@Test(priority = 59)
	public void validateThisMonthValue() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the This Month Value is calculated by Default Interest + Standard Interest - Default Interest Paid of the current month")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			String loanReferenceNumber = getDataFromExcel(14);

			// Create Dynamic Locator for This Month
			String thisMonthLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.thisMonthValue, "locatorValue", loanReferenceNumber);

			// Create Dynamic Locator for Standard Interest
			String standardInterestLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.standardInterestValue, "locatorValue", loanReferenceNumber);

			// Create Dynamic Locator for Default Interest Paid
			String defaultInterestPaidLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.defaultInterestPaidVal, "locatorValue", loanReferenceNumber);

			// Calling the getTextAndParseToInt from Utils
			int actualThisMonth = Utils.getTextAndParseToInt(thisMonthLocator);

			// Navigate to Step 4
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Calling the getTextAndParseToInt from Utils and get the Standard Interest
			int standardInterest = Utils.getTextAndParseToInt(standardInterestLocator);

			// Calling the getTextAndParseToInt from Utils and get the Default Interest Paid
			int defaultInterestPaid = Utils.getTextAndParseToInt(defaultInterestPaidLocator);

			// Calling the calculateDifference from Utils and Calculate Expected This Month
			// Value
			int defaultInterest = 0;
			int expectedThisMonth = defaultInterest + Utils.calculateDifference(standardInterest, defaultInterestPaid);
			node.log(Status.INFO, "STEP1 : Calculated This Month Value : " + expectedThisMonth);
			System.out.println("STEP1 :  Calculated This Month Value : " + expectedThisMonth);

			// Assert This Month Value
			IElementActions.assertEquals_usingInteger(node, driver, actualThisMonth, expectedThisMonth,
					"STEP2 : BUG : This Month Value is not same as calculated by [Default Interest + Standard Interest - Default Interest Paid] of the current month",
					"STEP2 : PASS : This Month Value is same as calculated by [Default Interest + Standard Interest - Default Interest Paid] of the current month");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateThisMonthValue", "Pass", driver);

		} catch (AssertionError validateThisMonthValue) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateThisMonthValue test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateThisMonthValue_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateThisMonthValue.printStackTrace();
			node.fail(validateThisMonthValue);
			Assert.fail();
			extent.flush();

		} catch (Exception validateThisMonthValue) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateThisMonthValue test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateThisMonthValue_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateThisMonthValue.printStackTrace();
			node.fail(validateThisMonthValue);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _117
	@Test(priority = 60)
	public void validateDeferredChangeSumAmount() throws IOException {

		try {
			extenttest = extent.createTest("Verify that the Change is equal to [This month- Last Month]")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Scrolled Down to Day Count Fraction
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingInterestPaymentPO.dayCountFraction);
			System.out.println("STEP1 : Scrolled down to Day Count Fraction");
			node.log(Status.INFO, "STEP1 : Scrolled down to Day Count Fraction");

			// Calling the getTextAndParseToInt function from Utils and get This Month
			// Amount
			int thisMonthAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.deferredthisMonthSumAmount);

			// Calling the getTextAndParseToInt function from Utils and get Last Month
			// Amount
			int lastMonthAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.deferredLastMonthSumAmount);

			// Calling the getTextAndParseToInt function from Utils and get Change Sum
			// Amount
			int actualChangeSumAmount = Utils.getTextAndParseToInt(FundingInterestPaymentPO.deferredChangeSumAmount);

			// Calling calculateDifference function from Utils
			int expectedChangeSumAmount = Utils.calculateDifference(thisMonthAmount, lastMonthAmount);
			node.log(Status.INFO, "STEP2 : Calculated Change Sum Amount : " + expectedChangeSumAmount);
			System.out.println("STEP2 :  Calculated Change Sum Amount : " + expectedChangeSumAmount);

			// Set the acceptable difference
			int acceptableDifference = Integer.parseInt(getDataFromExcel(10));

			// Perform assertion allowing for a difference around 5 with a delta parameter
			Assert.assertEquals(actualChangeSumAmount, expectedChangeSumAmount, acceptableDifference,
					"Difference is greater than the acceptable range");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDeferredChangeSumAmount", "Pass", driver);

		} catch (AssertionError validateDeferredChangeSumAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDeferredChangeSumAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDeferredChangeSumAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeferredChangeSumAmount.printStackTrace();
			node.fail(validateDeferredChangeSumAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDeferredChangeSumAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDeferredChangeSumAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDeferredChangeSumAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeferredChangeSumAmount.printStackTrace();
			node.fail(validateDeferredChangeSumAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _118
	@Test(priority = 61)
	public void validateDeferredDayCount() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify the Day count calculated as [Last Month / This Month] and the Last Month and This Month value is Standard Default Days on the Loan Interest Details popup under step-4 ")
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

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), month);

			String loanReferenceNumber = getDataFromExcel(14);

			// Create Dynamic Locator for Day Count
			String dayCountLocator = IElementActions.createDynamicLocatorString(FundingInterestPaymentPO.dayCountValue,
					"locatorValue", loanReferenceNumber);

			// Create Dynamic Locator for Standard Interest Days
			String standardInterestDaysLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.standardInterestDaysValue, "locatorValue", loanReferenceNumber);

			// Calling the getTextAndParseToInt from Utils
			String actualdayCountValue = IElementActions.getElementText_usingXpath(node, driver, dayCountLocator);
			System.out.println("STEP1 : The Day count value of Deferred Table : " + actualdayCountValue);
			node.log(Status.INFO, "STEP1 : The Day count value of Deferred Table : " + actualdayCountValue);

			// Navigate to Step 4
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Get the This Month Standard Interest Days
			String thisMonthStandardInterestDays = IElementActions.getElementText_usingXpath(node, driver,
					standardInterestDaysLocator);
			System.out.println("STEP2 : This Month Standard Interest Days on Loan interest Details Popup : "
					+ thisMonthStandardInterestDays);
			node.log(Status.INFO, "STEP2 : This Month Standard Interest Days on Loan interest Details Popup : "
					+ thisMonthStandardInterestDays);

			// Close the Popup
			FundingPage.closePopUp();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), previousMonth);

			// Navigate to Step 4
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Get the Last Month Standard Interest Days
			String lastMonthStandardInterestDays = IElementActions.getElementText_usingXpath(node, driver,
					standardInterestDaysLocator);
			System.out.println("STEP3 : Last Month Standard Interest Days on Loan interest Details Popup : "
					+ lastMonthStandardInterestDays);
			node.log(Status.INFO, "STEP3 : Last Month Standard Interest Days on Loan interest Details Popup : "
					+ lastMonthStandardInterestDays);

			// Concatenate the lastMonthStandardInterestDays and
			// thisMonthStandardInterestDays
			String expecteddayCountValue = "[" + lastMonthStandardInterestDays + "/" + thisMonthStandardInterestDays
					+ "]";
			System.out.println("STEP4 : Expected Day Count Value is  : " + expecteddayCountValue);
			node.log(Status.INFO, "STEP4 : Expected Day Count Value is : " + expecteddayCountValue);

			// Assert the Day count value of Deferred Table
			IElementActions.assertEquals_usingString(node, driver, actualdayCountValue, expecteddayCountValue,
					"STEP5 : BUG : The Day count value of Deferred Table is not equal to the Day count value of Standard Interest Days on Loan Interest Details Popup",
					"STEP5 : PASS : The Day count value of Deferred Table is equal to the Day count value of Standard Interest Days on Loan Interest Details Popup");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDeferredDayCount", "Pass", driver);

		} catch (AssertionError validateDeferredDayCount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDeferredDayCount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDeferredDayCount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeferredDayCount.printStackTrace();
			node.fail(validateDeferredDayCount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDeferredDayCount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDeferredDayCount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDeferredDayCount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeferredDayCount.printStackTrace();
			node.fail(validateDeferredDayCount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _123
	@Test(priority = 62)
	public void validateRateChangesCheckDetails() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the following column names are displayed:" + "-Rate Cohort"
							+ "-Last Month Deployment" + "-This Month Deployment" + "-Change")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Scrolled Down to Rate Changes Check
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingInterestPaymentPO.rateChangesCheck);
			System.out.println("STEP1 : Scrolled down to Rate Changes Check");
			node.log(Status.INFO, "STEP1 : Scrolled down to Rate Changes Check");

			// Check the visibility of Rate Cohort Column Name
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.rateCohortColumnName,
					"STEP2 : BUG: The Rate Cohort Column Name is not coming in Rate Changes Check Table in Step2",
					"STEP2 : EXPECTED: The Rate Cohort Column Name is coming in Rate Changes Check Table in Step2");

			// Check the visibility of Last Month Deployment Column Name
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.lastMonthDeploymentColumnName,
					"STEP3 : BUG: The Last Month Deployment Column Name is not coming in Rate Changes Check Table in Step2",
					"STEP3 : EXPECTED: The Last Month Deployment Column Name is coming in Rate Changes Check Table in Step2");

			// Check the visibility of This Month Deployment Column Name
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.thisMonthDeploymentColumnName,
					"STEP4 : BUG: This Month Deployment Column Name is not coming in Rate Changes Check Table in Step2",
					"STEP4 : EXPECTED: This Month Deployment Column Name is coming in Rate Changes Check Table in Step2");

			// Check the visibility of Change Column Name
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.rateChangesChageColumnName,
					"STEP5 : BUG: The Change Column Name is not coming in Rate Changes Check Table in Step2",
					"STEP5 : EXPECTED: The Change Column Name is coming in Rate Changes Check Table in Step2");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateRateChangesCheckDetails", "Pass", driver);

		} catch (AssertionError validateRateChangesCheckDetails) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateRateChangesCheckDetails test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRateChangesCheckDetails_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRateChangesCheckDetails.printStackTrace();
			node.fail(validateRateChangesCheckDetails);
			Assert.fail();
			extent.flush();

		} catch (Exception validateRateChangesCheckDetails) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateRateChangesCheckDetails test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRateChangesCheckDetails_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRateChangesCheckDetails.printStackTrace();
			node.fail(validateRateChangesCheckDetails);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _144
	@Test(priority = 63)
	public void validateBackAndNextStepButtonVisibility() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user is able to see the Back step and Next step button on the step-2 page.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Scrolled Down to Bottom of the Page
			IElementActions.scrollToBottom(driver);
			System.out.println("STEP1 : Scrolled Down to Bottom of the Page");
			node.log(Status.INFO, "STEP1 : Scrolled Down to Bottom of the Page");

			// Check the visibility of Back Step Button
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.backStepButton,
					"STEP2 : BUG: The Back Step Button is not coming in Step2",
					"STEP2 : EXPECTED: The Back Step Button is coming in in Step2");

			// Check the visibility of Next Step Button
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.nextStepButton,
					"STEP3 : BUG: The Next Step Button is not coming in Step2",
					"STEP3 : EXPECTED: The Next Step Button is coming in Step2");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateBackAndNextStepButtonVisibility", "Pass", driver);

		} catch (AssertionError validateBackAndNextStepButtonVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateBackAndNextStepButtonVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBackAndNextStepButtonVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBackAndNextStepButtonVisibility.printStackTrace();
			node.fail(validateBackAndNextStepButtonVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateBackAndNextStepButtonVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateBackAndNextStepButtonVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBackAndNextStepButtonVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBackAndNextStepButtonVisibility.printStackTrace();
			node.fail(validateBackAndNextStepButtonVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _145
	@Test(priority = 64)
	public void validateHealthBackAndNextStepButton() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user is able to click on  the Back step and Next step button on the step-2 page.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the bottomBackStepButton function from Funding Page
			FundingPage.bottomBackStepButton(FundingInterestPaymentPO.backStepButton, 2, "Health");

			// Check if the 'step--current' is present in the class attribute
			boolean Step1IsHighlighted = IElementActions
					.checkAttributePresentInClass(FundingInterestPaymentPO.compileStep, "step--current");

			// Assert that user is Redirected to Previous Step
			IElementActions.assertTrue_usingboolean(node, driver, Step1IsHighlighted,
					"STEP1 : BUG: After clicked on Back Step Button User is not redirected to Step1  i.e.Compile",
					"STEP1 : PASS : After clicked on Back Step Button User is redirected to Step1  i.e.Compile");

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the bottomNextStepButton function from Funding Page
			FundingPage.bottomNextStepButton(FundingInterestPaymentPO.nextStepButton, 2, "Health");

			// Check if the 'step--current' is present in the class attribute
			boolean Step3IsHighlighted = IElementActions
					.checkAttributePresentInClass(FundingInterestPaymentPO.monthOnMonthComparisonStep, "step--current");

			// Assert that After clicked on Next Step Button User is redirected to Step3
			IElementActions.assertTrue_usingboolean(node, driver, Step3IsHighlighted,
					"STEP2 : BUG: After clicked on Next Step Button User is not redirected to Step3 i.e.Month on Month Comparison",
					"STEP2 : PASS : After clicked on Next Step Button User is redirected to Step3 i.e.Month on Month Comparison");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateHealthBackAndNextStepButton", "Pass", driver);

		} catch (AssertionError validateHealthBackAndNextStepButton) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateHealthBackAndNextStepButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateHealthBackAndNextStepButton_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateHealthBackAndNextStepButton.printStackTrace();
			node.fail(validateHealthBackAndNextStepButton);
			Assert.fail();
			extent.flush();

		} catch (Exception validateHealthBackAndNextStepButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateHealthBackAndNextStepButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateHealthBackAndNextStepButton_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateHealthBackAndNextStepButton.printStackTrace();
			node.fail(validateHealthBackAndNextStepButton);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _146
	@Test(priority = 65)
	public void validateHealthBackStepButton() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the when user is click on the Back step button, the user is navigate to step-1")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the bottomBackStepButton function from Funding Page
			FundingPage.bottomBackStepButton(FundingInterestPaymentPO.backStepButton, 2, "Health");

			// Check if the 'step--current' is present in the class attribute
			boolean StepIsHighlighted = IElementActions
					.checkAttributePresentInClass(FundingInterestPaymentPO.compileStep, "step--current");

			// Assert that After clicked on Back Step Button User is redirected to Step1
			IElementActions.assertTrue_usingboolean(node, driver, StepIsHighlighted,
					"STEP1 :  BUG : After clicked on Back Step Button User is not redirected to Step1 i.e.Compile",
					"STEP1 :  PASS : After clicked on Back Step Button User is redirected to Step1 i.e.Compile");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateHealthBackStepButton", "Pass", driver);

		} catch (AssertionError validateHealthBackStepButton) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateHealthBackStepButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateHealthBackStepButton_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateHealthBackStepButton.printStackTrace();
			node.fail(validateHealthBackStepButton);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateHealthBackStepButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateHealthBackStepButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateHealthBackStepButton_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateHealthBackStepButton.printStackTrace();
			node.fail(validateHealthBackStepButton);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _147
	@Test(priority = 66)
	public void validateHealthNextStepButton() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the when user is click on the Next step button, the user is navigate to the next step(step-3)")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the bottomNextStepButton function from Funding Page
			FundingPage.bottomNextStepButton(FundingInterestPaymentPO.nextStepButton, 2, "Health");

			// Check if the 'step--current' is present in the class attribute
			boolean StepIsHighlighted = IElementActions
					.checkAttributePresentInClass(FundingInterestPaymentPO.monthOnMonthComparisonStep, "step--current");

			// Assert that After clicked on Next Step Button User is redirected to Step3
			IElementActions.assertTrue_usingboolean(node, driver, StepIsHighlighted,
					"STEP1 : BUG: After clicked on Next Step Button User is not redirected to Step3  i.e.Month on Month Comparison",
					"STEP1 : PASS : After clicked on Next Step Button User is redirected to Step3  i.e.Month on Month Comparison");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateHealthNextStepButton", "Pass", driver);

		} catch (AssertionError validateHealthNextStepButton) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateHealthNextStepButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateHealthNextStepButton_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateHealthNextStepButton.printStackTrace();
			node.fail(validateHealthNextStepButton);
			Assert.fail();
			extent.flush();

		} catch (Exception validateHealthNextStepButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateHealthNextStepButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateHealthNextStepButton_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateHealthNextStepButton.printStackTrace();
			node.fail(validateHealthNextStepButton);
			Assert.fail();
			extent.flush();
		}
	}
}
