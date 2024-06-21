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
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.url.AllPagesData;
import com.qa.utils.FundingPage;
import com.qa.utils.LoginPage;
import com.qa.utils.Utils;

public class InterestPaymentStep3Test extends Baseclass {

	// TC_Funding_Interest _148
	@Test(priority = 1)
	public void validateMonthonMonthComparisonStepHighlighted() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the Step3 icon is highlighted  in blue color when the user is in step3 of the interest page")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			// Call the userLoginProcess function from the utils login
			LoginPage.userLoginProcess(node, driver, getDataFromExcel(1), getDataFromExcel(2));

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Check if the 'step--current' is present in the class attribute
			boolean isHighlighted = IElementActions
					.checkAttributePresentInClass(FundingInterestPaymentPO.monthOnMonthComparisonStep, "step--current");

			// Print the result
			if (isHighlighted) {
				node.log(Status.PASS, "SUB-STEP_0.01 :The Step 3 Month on Month Comparison is highlighted");
				System.out.println("SUB-STEP_0.01 : The Step 3 Month on Month Comparison is highlighted");

				Assert.assertTrue(true, "The Step 3 Month on Month Comparison is highlighted");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateMonthonMonthComparisonStepHighlighted", "Pass",
						driver);
			} else {
				System.out.println("SUB-STEP_0.01 : The Step 3 Month on Month Comparison is not highlighted");
				node.log(Status.FAIL, "SUB-STEP_0.01 : The Step 3 Month on Month Comparison is not highlighted");

				Assert.assertTrue(false, "The Step 3 Month on Month Comparison is not highlighted");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateMonthonMonthComparisonStepHighlighted", "Fail",
						driver);
			}

		} catch (AssertionError validateMonthonMonthComparisonStepHighlighted) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateMonthonMonthComparisonStepHighlighted test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateMonthonMonthComparisonStepHighlighted_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMonthonMonthComparisonStepHighlighted.printStackTrace();
			node.fail(validateMonthonMonthComparisonStepHighlighted);
			Assert.fail();
			extent.flush();

		} catch (Exception validateMonthonMonthComparisonStepHighlighted) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateMonthonMonthComparisonStepHighlighted test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateMonthonMonthComparisonStepHighlighted_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMonthonMonthComparisonStepHighlighted.printStackTrace();
			node.fail(validateMonthonMonthComparisonStepHighlighted);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _149
	@Test(priority = 2)
	public void validateLastPeriodNumberOfDaysInStep3() throws IOException {

		try {
			extenttest = extent.createTest("Step3 -Verify the Last Period Number of Days")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep2 function to access step2 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Get the Last Period Number of Days value in step2
			String lastPeriodNumberOfDaysValueInStep2 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.lastPeriodNumberOfDaysValue);
			node.log(Status.INFO,
					"STEP1 : Last Period Number of Days value in step2 is " + lastPeriodNumberOfDaysValueInStep2);
			System.out.println(
					"STEP1 : Last Period Number of Days value in step2 is " + lastPeriodNumberOfDaysValueInStep2);

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.monthOnMonthComparisonStep3);

			// Check the visibility of Last Period Number of Days value in step3
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.lastPeriodNumberDaysValue,
					"STEP2 : BUG: The Last Period Number of Days value is not coming in step3",
					"STEP2 : EXPECTED: The Last Period Number of Days value is coming in step3");

			// Get the Last Period Number of Days value in step3
			String lastPeriodNumberOfDaysValueInStep3 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.lastPeriodNumberDaysValue);
			node.log(Status.INFO,
					"STEP3 : Last Period Number of Days value in step3 is " + lastPeriodNumberOfDaysValueInStep3);
			System.out.println(
					"STEP3 : Last Period Number of Days value in step3 is " + lastPeriodNumberOfDaysValueInStep3);

			// Assert Last Period Number of Days value
			IElementActions.assertEquals_usingString(node, driver, lastPeriodNumberOfDaysValueInStep3,
					lastPeriodNumberOfDaysValueInStep2,
					"STEP4 : BUG: Last Period Number of Days value is not same in step3 and step2",
					"STEP4 : EXPECTED: Last Period Number of Days value is same in step3 and step2");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateLastPeriodNumberOfDaysInStep3", "Pass", driver);

		} catch (AssertionError validateLastPeriodNumberOfDaysInStep3) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLastPeriodNumberOfDaysInStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLastPeriodNumberOfDaysInStep3_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLastPeriodNumberOfDaysInStep3.printStackTrace();
			node.fail(validateLastPeriodNumberOfDaysInStep3);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLastPeriodNumberOfDaysInStep3) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLastPeriodNumberOfDaysInStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLastPeriodNumberOfDaysInStep3_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLastPeriodNumberOfDaysInStep3.printStackTrace();
			node.fail(validateLastPeriodNumberOfDaysInStep3);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _150
	@Test(priority = 3)
	public void validateThisPeriodNumberOfDays() throws IOException {

		try {
			extenttest = extent.createTest("Verify the This Period Number of Days")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep2 function to access step2 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Get This Period Number of Days value in step2
			String thisPeriodNumberOfDaysValueInStep2 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.thisPeriodNumberOfDaysValue);
			node.log(Status.INFO,
					"STEP1 : This Period Number of Days value in step2 is " + thisPeriodNumberOfDaysValueInStep2);
			System.out.println(
					"STEP1 : This Period Number of Days value in step2 is " + thisPeriodNumberOfDaysValueInStep2);

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.monthOnMonthComparisonStep3);

			// Check the visibility of This Period Number of Days value in step3
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.thisPeriodNumberDaysValue,
					"STEP2 : BUG: This Period Number of Days value is not coming in step3",
					"STEP2 : EXPECTED: This Period Number of Days value is coming in step3");

			// Get This Period Number of Days value in step3
			String thisPeriodNumberOfDaysValueInStep3 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.thisPeriodNumberDaysValue);
			node.log(Status.INFO,
					"STEP3 : This Period Number of Days value in step3 is " + thisPeriodNumberOfDaysValueInStep3);
			System.out.println(
					"STEP3 : This Period Number of Days value in step3 is " + thisPeriodNumberOfDaysValueInStep3);

			// Assert that This Period Number of Days value is same in step3 and step2
			IElementActions.assertEquals_usingString(node, driver, thisPeriodNumberOfDaysValueInStep3,
					thisPeriodNumberOfDaysValueInStep2,
					"STEP4 : BUG: This Period Number of Days value is not same in step3 and step2",
					"STEP4 : EXPECTED: This Period Number of Days value is same in step3 and step2");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateThisPeriodNumberOfDays", "Pass", driver);

		} catch (AssertionError validateThisPeriodNumberOfDays) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateThisPeriodNumberOfDays test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateThisPeriodNumberOfDays_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateThisPeriodNumberOfDays.printStackTrace();
			node.fail(validateThisPeriodNumberOfDays);
			Assert.fail();
			extent.flush();

		} catch (Exception validateThisPeriodNumberOfDays) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateThisPeriodNumberOfDays test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateThisPeriodNumberOfDays_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateThisPeriodNumberOfDays.printStackTrace();
			node.fail(validateThisPeriodNumberOfDays);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _151
	@Test(priority = 4)
	public void validateLastMonthDCF() throws IOException {

		try {
			extenttest = extent.createTest("Verify the Last Month DCF")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep2 function to access step2 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Scroll horizontally to last in the table
			IElementActions.scrollHorizontalToLast(driver);

			// Scroll horizontally in Table
			Thread.sleep(1000);
			IElementActions.scrollHorizontally(driver, FundingInterestPaymentPO.dayCountFractionTable, 1000);

			// Scroll to Top of the Page
			Thread.sleep(1000);
			IElementActions.scrollToTop(driver);

			// Get the Last Month DCF value in step2
			String lastMonthDCFValueInStep2 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.lastMonthDCFValue);
			node.log(Status.INFO, "STEP1 : The Last Month DCF value in step2 is " + lastMonthDCFValueInStep2);
			System.out.println("STEP1 : The Last Month DCF value in step2 is " + lastMonthDCFValueInStep2);

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.monthOnMonthComparisonStep3);

			// Check the visibility of Last Month DCF value in step3
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.lastMonthDCFValueInStep3,
					"STEP2 : BUG: The Last Month DCF value is not coming in step3",
					"STEP2 : EXPECTED: The Last Month DCF value is coming in step3");

			// Get the Last Month DCF value in step3
			String lastMonthDCFValueInStep3 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.lastMonthDCFValueInStep3);
			node.log(Status.INFO, "STEP3 : The Last Month DCF value in step3 is " + lastMonthDCFValueInStep3);
			System.out.println("STEP3 : The Last Month DCF value in step3 is " + lastMonthDCFValueInStep3);

			// Assert that Last Month DCF value is same in step3 and step2
			IElementActions.assertEquals_usingString(node, driver, lastMonthDCFValueInStep3, lastMonthDCFValueInStep2,
					"STEP4 : BUG: The Last Month DCF value is not same in step3 and step2",
					"STEP4 : EXPECTED: The Last Month DCF value is same in step3 and step2");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateLastMonthDCF", "Pass", driver);

		} catch (AssertionError validateLastMonthDCF) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLastMonthDCF test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLastMonthDCF_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLastMonthDCF.printStackTrace();
			node.fail(validateLastMonthDCF);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLastMonthDCF) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLastMonthDCF test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLastMonthDCF_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLastMonthDCF.printStackTrace();
			node.fail(validateLastMonthDCF);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _152
	@Test(priority = 5)
	public void validateThisMonthDCF() throws IOException {

		try {
			extenttest = extent.createTest("Verify the This Month DCF")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep2 function to access step2 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Scroll horizontally to last in the table
			IElementActions.scrollHorizontalToLast(driver);

			// Scroll horizontally in Table
			Thread.sleep(1000);
			IElementActions.scrollHorizontally(driver, FundingInterestPaymentPO.dayCountFractionTable, 1000);

			// Scroll to Top in Page
			Thread.sleep(1000);
			IElementActions.scrollToTop(driver);

			// Get This Month DCF value in step2
			String thisMonthDCFValueInStep2 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.thisMonthDCFValue);
			node.log(Status.INFO, "STEP1 : This Month DCF value in step2 is " + thisMonthDCFValueInStep2);
			System.out.println("STEP1 : This Month DCF value in step2 is " + thisMonthDCFValueInStep2);

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.monthOnMonthComparisonStep3);

			// Scroll Horizontally To Last in Table
			IElementActions.scrollHorizontalToLast(driver);

			// Scroll Horizontally in Table
			Thread.sleep(1000);
			IElementActions.scrollHorizontally(driver, FundingInterestPaymentPO.dataTableInStep3, 1000);

			// Scroll to Top of page
			Thread.sleep(1000);
			IElementActions.scrollToTop(driver);

			// Check the visibility of This Month DCF value in step3
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.thisMonthDCFValueInstep3,
					"STEP2 : BUG: This Month DCF value is not coming in step3",
					"STEP2 : EXPECTED: This Month DCF value is coming in step3");

			// Get This Month DCF value in step3
			String thisMonthDCFValueInStep3 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.thisMonthDCFValueInstep3);
			node.log(Status.INFO, "STEP3 : This Month DCF value in step3 is " + thisMonthDCFValueInStep3);
			System.out.println("STEP3 : This Month DCF value in step3 is " + thisMonthDCFValueInStep3);

			// Assert that This Month DCF value is same in step3 and step2
			IElementActions.assertEquals_usingString(node, driver, thisMonthDCFValueInStep3, thisMonthDCFValueInStep2,
					"STEP4 : BUG: This Month DCF value is not same in step3 and step2",
					"STEP4 : EXPECTED: This Month DCF value is same in step3 and step2");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateThisMonthDCF", "Pass", driver);

		} catch (AssertionError validateThisMonthDCF) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateThisMonthDCF test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateThisMonthDCF_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateThisMonthDCF.printStackTrace();
			node.fail(validateThisMonthDCF);
			Assert.fail();
			extent.flush();

		} catch (Exception validateThisMonthDCF) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateThisMonthDCF test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateThisMonthDCF_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateThisMonthDCF.printStackTrace();
			node.fail(validateThisMonthDCF);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _153
	@Test(priority = 6)
	public void validateDCFAdjustmentValueInStep3() throws IOException {

		try {
			extenttest = extent.createTest("Verify the DCF Adjustment(%)")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Check the visibility of Last Month DCF value in step3
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.lastMonthDCFValueInStep3,
					"STEP1 : BUG: The Last Month DCF value is not coming in step3",
					"STEP1 : EXPECTED: The Last Month DCF value is coming in step3");

			// Get the Last Month DCF value in step3
			String actualLastMonthDCFValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.lastMonthDCFValueInStep3);
			node.log(Status.INFO, "STEP2 : The Last Month DCF value in step3 is " + actualLastMonthDCFValue);
			System.out.println("STEP2 : The Last Month DCF value in step3 is " + actualLastMonthDCFValue);

			// Scroll To Last in Table
			IElementActions.scrollHorizontalToLast(driver);
			// Scroll in Table
			Thread.sleep(1000);
			IElementActions.scrollHorizontally(driver, FundingInterestPaymentPO.dataTableInStep3, 1000);
			// Scroll to Top
			Thread.sleep(1000);
			IElementActions.scrollToTop(driver);

			// Check the visibility of This Month DCF value in step3
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.thisMonthDCFValueInstep3,
					"STEP3 : BUG: This Month DCF value is not coming in step3",
					"STEP3 : EXPECTED: This Month DCF value is coming in step3");

			// Get This Month DCF value in step3
			String actualThisMonthDCFValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.thisMonthDCFValueInstep3);
			node.log(Status.INFO, "STEP4 : This Month DCF value in step3 is " + actualThisMonthDCFValue);
			System.out.println("STEP4 : This Month DCF value in step3 is " + actualThisMonthDCFValue);

			// Check the visibility of DCF Adjustment (%) value in step3
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.dCFAdjustmentValueInstep3,
					"STEP5 : BUG: The DCF Adjustment (%) value is not coming in step3",
					"STEP5 : EXPECTED: The DCF Adjustment (%) value is coming in step3");

			// Get the DCFAdjustmentValue
			Double actualDCFAdjustmentValue = Utils
					.getTextAndParseToDouble(FundingInterestPaymentPO.dCFAdjustmentValueInstep3);
			node.log(Status.INFO, "STEP6 : actualDCFAdjustmentValue " + actualDCFAdjustmentValue);
			System.out.println("STEP6 : actualDCFAdjustmentValue " + actualDCFAdjustmentValue);

			Double lastMonthDCFValue = IElementActions.parseStringToDoubleWithTwoDecimal(driver,
					actualLastMonthDCFValue);
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
				node.log(Status.INFO, "Error: Division by zero is not allowed.");
				System.out.println("Error: Division by zero is not allowed.");

			}

			// Set the acceptable difference
			double acceptableDifference = Double.parseDouble(getDataFromExcel(10));

			// Perform assertion allowing for a difference around 5 with a delta parameter
			Assert.assertEquals(actualDCFAdjustmentValue, result, acceptableDifference,
					"Difference is greater than the acceptable range");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDCFAdjustmentValueInStep3", "Pass", driver);

		} catch (AssertionError validateDCFAdjustmentValueInStep3) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDCFAdjustmentValueInStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDCFAdjustmentValueInStep3_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDCFAdjustmentValueInStep3.printStackTrace();
			node.fail(validateDCFAdjustmentValueInStep3);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDCFAdjustmentValueInStep3) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDCFAdjustmentValueInStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDCFAdjustmentValueInStep3_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDCFAdjustmentValueInStep3.printStackTrace();
			node.fail(validateDCFAdjustmentValueInStep3);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _154
	@Test(priority = 7)
	public void validateDifferenceToleranceValueInStep3() throws IOException {

		try {
			extenttest = extent.createTest("Verify the Difference Tolerance")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep2 function to access step2 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Scroll down to Reserves Label
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingInterestPaymentPO.reserves);
			node.log(Status.INFO, "STEP1 : Scrolled down to Reserves Label");
			System.out.println("STEP1 : Scrolled down to Reserves Label");

			// Get Forecast Tolerance value in step2
			String forecastToleranceValueInStep2 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.forecastToleranceField);
			node.log(Status.INFO, "STEP2 : The Forecast Tolerance value in step2 is " + forecastToleranceValueInStep2);
			System.out.println("STEP2 : The Forecast Tolerance value in step2 is " + forecastToleranceValueInStep2);

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.monthOnMonthComparisonStep3);

			// Scroll To Last in Table
			IElementActions.scrollHorizontalToLast(driver);

			// Scroll in Table
			Thread.sleep(1000);
			IElementActions.scrollHorizontally(driver, FundingInterestPaymentPO.dataTableInStep3, 1000);

			// Scroll to Top
			Thread.sleep(1000);
			IElementActions.scrollToTop(driver);

			// Check the visibility of Difference Tolerance value in step3
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.differenceToleranceValue,
					"STEP3 : BUG: The Difference Tolerance value is not coming in step3",
					"STEP3 : EXPECTED: The Difference Tolerance value is coming in step3");

			// Get The Difference Tolerance value in step3
			String differenceToleranceValueInStep3 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.differenceToleranceValue);
			node.log(Status.INFO,
					"STEP4 : The Difference Tolerance value in step3 is " + differenceToleranceValueInStep3);
			System.out.println("STEP4 : The Difference Tolerance value in step3 is " + differenceToleranceValueInStep3);

			// Assert the Difference Tolerance value
			IElementActions.assertEquals_usingString(node, driver, differenceToleranceValueInStep3,
					forecastToleranceValueInStep2,
					"STEP5 : BUG: The Difference Tolerance value in step3 is not same as Forecast Tolerance value in step2",
					"STEP5 : EXPECTED: The Difference Tolerance value in step3 is same as Forecast Tolerance value in step2");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDifferenceToleranceValueInStep3", "Pass", driver);

		} catch (AssertionError validateDifferenceToleranceValueInStep3) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDifferenceToleranceValueInStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDifferenceToleranceValueInStep3_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDifferenceToleranceValueInStep3.printStackTrace();
			node.fail(validateDifferenceToleranceValueInStep3);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDifferenceToleranceValueInStep3) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDifferenceToleranceValueInStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDifferenceToleranceValueInStep3_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDifferenceToleranceValueInStep3.printStackTrace();
			node.fail(validateDifferenceToleranceValueInStep3);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _155
	@Test(priority = 8)
	public void validateLoanAmountOfFaciltyInStep3() throws IOException {

		try {
			extenttest = extent.createTest("Verify the Facility Loan Amount")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Get the Facility Loan Amount in Step3
			String facilityLoanAmountInStep3 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.facilityLoanAmount);
			node.log(Status.INFO, "STEP1 : Facility loan amount in step3 is " + facilityLoanAmountInStep3);
			System.out.println("STEP1 : Facility loan amount in step3 is " + facilityLoanAmountInStep3);

			// Calling the navigateToStep function from the FundingPage
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Wait for the visibility of the loan amount
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the facility loan amount");
			System.out.println("STEP2 : Waiting for the visibility of the facility loan amount");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.facilityLoanAmount);
			node.log(Status.INFO, "STEP3 : Facility loan amount is visible");
			System.out.println("STEP3 : Facility loan amount is visible");

			// Get the Facility Loan Amount in Step4
			String facilityLoanAmountInStep4 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.facilityLoanAmount);
			node.log(Status.INFO, "STEP4 : Facility loan amount in step4 is " + facilityLoanAmountInStep4);
			System.out.println("STEP4 : Facility loan amount in step4 is " + facilityLoanAmountInStep4);

			// Assert Facility Loan Amount
			IElementActions.assertEquals_usingString(node, driver, facilityLoanAmountInStep3, facilityLoanAmountInStep4,
					"STEP5 : BUG: Facility Loan Amount is not same in step3 and step4",
					"STEP5 : EXPECTED: Facility Loan Amount is same in step3 and step4");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanAmountOfFaciltyInStep3", "Pass", driver);

		} catch (AssertionError validateLoanAmountOfFaciltyInStep3) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanAmountOfFaciltyInStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanAmountOfFacilty_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanAmountOfFaciltyInStep3.printStackTrace();
			node.fail(validateLoanAmountOfFaciltyInStep3);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanAmountOfFaciltyInStep3) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanAmountOfFaciltyInStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanAmountOfFacilty_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanAmountOfFaciltyInStep3.printStackTrace();
			node.fail(validateLoanAmountOfFaciltyInStep3);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _156
	@Test(priority = 9)
	public void validateLoanAmountOfAllFacilitiesInStep3() throws IOException {

		try {
			extenttest = extent.createTest("Verify the each facility Amount")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Locate the list element by its XPath
			List<WebElement> elementsInStep3 = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.facilitiesLoanAmount);

			// Initialize a List to store facility amounts as strings
			List<String> facilityAmountsInStep3 = new ArrayList<>();

			// Iterate through each element in the list
			for (WebElement element : elementsInStep3) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				facilityAmountsInStep3.add(elementValue);
			}

			// Print or use the List of facility amounts as needed
			System.out.println("Facility Amounts in step3: " + facilityAmountsInStep3);

			Thread.sleep(2000);
			// Call the navigateToStep function from the FundingPage
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Wait for the visibility of the facilitiesPayableAmountInStep4
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the loan amount");
			System.out.println("STEP1 : Waiting for the visibility of the loan amount");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.facilitiesPayableAmountInStep4);
			node.log(Status.INFO, "STEP2 : Loan amount is visible");
			System.out.println("STEP2 : Loan amount is visible");

			// Locate the list element by its XPath
			List<WebElement> elementsInStep4 = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.facilitiesPayableAmountInStep4);

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

			for (int i = 0; i < facilityAmountsInStep3.size(); i++) {
				String valueFromList1 = facilityAmountsInStep3.get(i);
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
			IScreenAction.captureScreenShot_PassCase("validateLoanAmountOfAllFacilitiesInStep3", "Pass", driver);

		} catch (AssertionError validateLoanAmountOfAllFacilitiesInStep3) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanAmountOfAllFacilitiesInStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanAmountOfAllFacilitiesInStep3_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanAmountOfAllFacilitiesInStep3.printStackTrace();
			node.fail(validateLoanAmountOfAllFacilitiesInStep3);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanAmountOfAllFacilitiesInStep3) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanAmountOfAllFacilitiesInStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanAmountOfAllFacilitiesInStep3_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanAmountOfAllFacilitiesInStep3.printStackTrace();
			node.fail(validateLoanAmountOfAllFacilitiesInStep3);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _157
	@Test(priority = 10)
	public void validateLoanCarriedForwardAmountInStep3() throws IOException {

		try {
			extenttest = extent.createTest("Verify the Carried Forward Loan Amount in step3")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Get the Facility Carried Forward Loan Amount In Step3
			String facilityCarriedForwardLoanAmountInStep3 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.facilityCarriedForwardLoanAmount);

			// Calling the navigateToStep function from the FundingPage
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Wait for the visibility of the facilityCarridForwardLoanAmount
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the carrid forward loan amount");
			System.out.println("STEP1 : Waiting for the visibility of the carrid forward loan amount");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.facilityCarriedForwardLoanAmount);
			node.log(Status.INFO, "STEP2 : Carried forward loan amount is visible");
			System.out.println("STEP2 : Carried forward loan amount is visible");

			// Get the Facility Carried Forward Loan Amount In Step4
			String facilityCarriedForwardLoanAmountInStep4 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.facilityCarriedForwardLoanAmount);
			node.log(Status.INFO, "STEP3 : The Facility Carried Forward Loan Amount In Step4 :"
					+ facilityCarriedForwardLoanAmountInStep4);
			System.out.println("STEP3 : The Facility Carried Forward Loan Amount In Step4 :"
					+ facilityCarriedForwardLoanAmountInStep4);

			// Assert the Carried Forward Loan Amount
			IElementActions.assertEquals_usingString(node, driver, facilityCarriedForwardLoanAmountInStep3,
					facilityCarriedForwardLoanAmountInStep4,
					"STEP4 : BUG :  Carried forward loan amount is not same in step2 and step4",
					"STEP4 : EXPECTED :  Carried forward loan amount is same in step2 and step4");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanCarriedForwardAmountInStep3", "Pass", driver);

		} catch (AssertionError validateLoanCarriedForwardAmountInStep3) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanCarriedForwardAmountInStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanCarriedForwardAmountInStep3_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanCarriedForwardAmountInStep3.printStackTrace();
			node.fail(validateLoanCarriedForwardAmountInStep3);
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

	// TC_Funding_Interest _158
	@Test(priority = 11)
	public void validateCarriedForwardAmountOfAllFacilitiesInStep3() throws IOException {

		try {
			extenttest = extent.createTest("Verify the each Carried Forward facility Amount in step3")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Locate the list element by its XPath
			List<WebElement> elementsInStep3 = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.facilitiesCarriedForwardAmount);

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

			// Calling the navigateToStep function from the FundingPage
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Wait for the visibility of the carridForwardText
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the carrid forward");
			System.out.println("STEP1 : Waiting for the visibility of the carrid forward");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.carriedForwardText);
			node.log(Status.INFO, "STEP2 : Carrid forward is visible");
			System.out.println("STEP2 : Carrid forward is visible");

			// Locate the list element by its XPath or any other suitable method
			List<WebElement> elementsInStep4 = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.facilitiesCarridForwardAmountInStep4);

			// Initialize a List to store facility amounts as strings
			List<String> facilityCarriedForwardAmountsInStep4 = new ArrayList<>();

			// Iterate through each element in the list
			for (WebElement element : elementsInStep4) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				facilityCarriedForwardAmountsInStep4.add(elementValue);
			}

			// Print or use the List of facility amounts as needed
			System.out.println("Facility Carried Forward Amounts in step4: " + facilityCarriedForwardAmountsInStep4);

			// Perform assertion for each pair of values in the lists
			boolean allValuesMatch = true;

			for (int i = 0; i < facilityCarriedForwardAmountsInStep3.size(); i++) {
				String valueFromList1 = facilityCarriedForwardAmountsInStep3.get(i);
				String valueFromList2 = facilityCarriedForwardAmountsInStep4.get(i);

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
			IScreenAction.captureScreenShot_PassCase("validateCarriedForwardAmountOfAllFacilitiesInStep3", "Pass",
					driver);

		} catch (AssertionError validateCarriedForwardAmountOfAllFacilitiesInStep3) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCarriedForwardAmountOfAllFacilitiesInStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCarriedForwardAmountOfAllFacilitiesInStep3_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCarriedForwardAmountOfAllFacilitiesInStep3.printStackTrace();
			node.fail(validateCarriedForwardAmountOfAllFacilitiesInStep3);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCarriedForwardAmountOfAllFacilitiesInStep3) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCarriedForwardAmountOfAllFacilitiesInStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCarriedForwardAmountOfAllFacilitiesInStep3_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCarriedForwardAmountOfAllFacilitiesInStep3.printStackTrace();
			node.fail(validateCarriedForwardAmountOfAllFacilitiesInStep3);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _159
	@Test(priority = 12)
	public void validatePriorMonthPayment() throws IOException {

		try {
			extenttest = extent.createTest("Verify the Prior Month Payment")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Month
			String month = getDataFromExcel(7);

			// Converting string to integer
			int monthNum = Integer.parseInt(month);
			monthNum = monthNum - 1;

			// Method 1: Using toString() method
			String previousMonth = Integer.toString(monthNum);

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), month);

			// Get the Loan Prior Month Payment
			String loanPriorMonthPayment = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.loanPriorMonthPayment);
			System.out.println("STEP01 : The Loan Prior Month Payment " + loanPriorMonthPayment);
			node.log(Status.INFO, "STEP01 : The Loan Prior Month Payment " + loanPriorMonthPayment);

			// Locate the list element by its XPath
			List<WebElement> priorMonthPayment = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.priorMonthPayments);

			// Initialize a List to store facility amounts as strings
			List<String> priorMonthPaymentForSelectedMonth = new ArrayList<>();

			// Iterate through each element in the list
			for (WebElement element : priorMonthPayment) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				priorMonthPaymentForSelectedMonth.add(elementValue);
			}

			// Print or use the List of facility amounts as needed
			System.out.println("STEP02 : Prior month payment for selected month " + priorMonthPaymentForSelectedMonth);
			node.log(Status.INFO,
					"STEP02 : Prior month payment for selected month " + priorMonthPaymentForSelectedMonth);

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), previousMonth);

			// Get the Payable Loan Amount
			String payableLoanAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.facilityLoanAmount);
			System.out.println("STEP03 : The Payable Loan Amount : " + loanPriorMonthPayment);
			node.log(Status.INFO, "STEP03 : The Payable Loan Amount : " + loanPriorMonthPayment);

			// Locate the list element by its XPath or any other suitable method
			List<WebElement> facilityPayable = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.thisMonthPayableTable);

			// Initialize a List to store facility amounts as strings
			List<String> facilityPayableForPreviousMonth = new ArrayList<>();

			// Iterate through each element in the list
			for (WebElement element : facilityPayable) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				facilityPayableForPreviousMonth.add(elementValue);
			}

			// Print or use the List of facility amounts as needed
			System.out.println("STEP02 : Facility payable amounts in step3 for previous month: "
					+ facilityPayableForPreviousMonth);
			node.log(Status.INFO, "STEP02 : Facility payable amounts in step3 for previous month: "
					+ facilityPayableForPreviousMonth);

			// Perform assertion for each pair of values in the lists
			boolean allValuesMatch = true;

			for (int i = 0; i < priorMonthPaymentForSelectedMonth.size(); i++) {
				String valueFromList1 = priorMonthPaymentForSelectedMonth.get(i);
				String valueFromList2 = facilityPayableForPreviousMonth.get(i);

				// Check if the values match
				if (!valueFromList1.equals(valueFromList2)) {
					allValuesMatch = false;
					System.out.println("Values at position " + i + " do not match:");
					node.log(Status.INFO, "Values at position " + i + " do not match:");
					System.out.println("List 1: " + valueFromList1);
					node.log(Status.INFO, "List 1: " + valueFromList1);
					System.out.println("List 2: " + valueFromList2);
					node.log(Status.INFO, "List 2: " + valueFromList2);
				}
			}

			// Perform the final assertion based on the matching status
			Assert.assertTrue(allValuesMatch, "Not all values in the lists match");

			// Assert calculation start date
			IElementActions.assertEquals_usingString(node, driver, loanPriorMonthPayment, payableLoanAmount,
					"BUG : Prior month payment for selected month " + loanPriorMonthPayment
							+ " is not matching with the facility payable amounts in step3 for previous month:"
							+ payableLoanAmount,
					"PASS : Prior month payment for selected month " + loanPriorMonthPayment
							+ " is matching with the facility payable amounts in step3 for previous month:"
							+ payableLoanAmount);

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validatePriorMonthPayment", "Pass", driver);

		} catch (AssertionError validatePriorMonthPayment) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePriorMonthPayment test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatePriorMonthPayment_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePriorMonthPayment.printStackTrace();
			node.fail(validatePriorMonthPayment);
			Assert.fail();
			extent.flush();

		} catch (Exception validatePriorMonthPayment) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePriorMonthPayment test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatePriorMonthPayment_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePriorMonthPayment.printStackTrace();
			node.fail(validatePriorMonthPayment);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _160
	// TC_Funding_Interest _161
	@Test(priority = 13)
	public void validatePlusButtonAndColumnsInDeferralTable() throws IOException {

		try {
			extenttest = extent.createTest(
					"PlusButton - Verify that the user can expand the Deferral table by clicking on the (+) button"
							+ "ColumnsInDeferralTable - Verify that the Deferral table expended, the Last Month, this Month and Difference column name is displayed to the user.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling clickOnPlusIcon function to expand the table
			FundingPage.clickOnPlusIcon(FundingInterestPaymentPO.deferralPlusButton,
					FundingInterestPaymentPO.deferralSection);

			// Check the visibility of Deferral section
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deferralSection,
					"STEP1 : BUG: Deferral section is not coming", "STEP1 : EXPECTED: Deferral section is not coming");

			// Get the Deferral Last Month
			String deferralLastMonth = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.deferralLastMonth);
			System.out.println("STEP02 : The Deferral Last Month : " + deferralLastMonth);
			node.log(Status.INFO, "STEP02 : The Deferral Last Month : " + deferralLastMonth);

			// Get the Deferral This Month
			String deferralThisMonth = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.deferralThisMonth);
			System.out.println("STEP03 : The Deferral This Month : " + deferralThisMonth);
			node.log(Status.INFO, "STEP03 : The Deferral This Month : " + deferralThisMonth);

			// Get the Deferral Difference
			String deferralDifference = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.deferralDifference);
			System.out.println("STEP04 : The Deferral Difference : " + deferralDifference);
			node.log(Status.INFO, "STEP04 : The Deferral Difference : " + deferralDifference);

			// Assert the Last Month
			IElementActions.assertEquals_usingString(node, driver, deferralLastMonth, "Last Month",
					"STEP5 : BUG: Last Month is not displayed", "STEP5 : EXPECTED: Last Month is displayed");

			// Assert This Month
			IElementActions.assertEquals_usingString(node, driver, deferralThisMonth, "this Month",
					"STEP6 : BUG: This Month is not displayed", "STEP6 : EXPECTED: This Month is displayed");

			// Assert the Difference
			IElementActions.assertEquals_usingString(node, driver, deferralDifference, "Difference",
					"STEP7 : BUG: Difference is not displayed", "STEP7 : EXPECTED: Difference is displayed");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validatePlusButtonAndColumnsInDeferralTable", "Pass", driver);

		} catch (AssertionError validatePlusButtonAndColumnsInDeferralTable) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePlusButtonAndColumnsInDeferralTable test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePlusButtonAndColumnsInDeferralTable_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePlusButtonAndColumnsInDeferralTable.printStackTrace();
			node.fail(validatePlusButtonAndColumnsInDeferralTable);
			Assert.fail();
			extent.flush();

		} catch (Exception validatePlusButtonAndColumnsInDeferralTable) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePlusButtonAndColumnsInDeferralTable test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePlusButtonAndColumnsInDeferralTable_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePlusButtonAndColumnsInDeferralTable.printStackTrace();
			node.fail(validatePlusButtonAndColumnsInDeferralTable);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _162
	@Test(priority = 14)
	public void validateDeferralLastMonth() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the Last Month values displayed as the Previous month This Month values.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Month
			String month = getDataFromExcel(7);

			// Converting string to integer
			int monthNum = Integer.parseInt(month);
			monthNum = monthNum - 1;

			// Method 1: Using toString() method
			String previousMonth = Integer.toString(monthNum);

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), month);

			// Calling clickOnPlusIcon function to expand the table
			FundingPage.clickOnPlusIcon(FundingInterestPaymentPO.deferralPlusButton,
					FundingInterestPaymentPO.deferralSection);

			// Get the Deferral Last Month Loan Value
			String deferralLastMonthLoanValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.deferralLastMonthLoanValue);
			// Print or use the List of facility amounts as needed
			System.out.println(
					"STEP01 : Deferral last month column value for selected month " + deferralLastMonthLoanValue);
			node.log(Status.INFO,
					"STEP01 : Deferral last month column value for selected month " + deferralLastMonthLoanValue);

			// Locate the list element by its XPath
			List<WebElement> deferralLastMonthValue = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.deferralLastMonthValues);

			// Initialize a List to store facility amounts as strings
			List<String> deferralLastMonthValuetForSelectedMonth = new ArrayList<>();

			// Iterate through each element in the list
			for (WebElement element : deferralLastMonthValue) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				deferralLastMonthValuetForSelectedMonth.add(elementValue);
			}

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), previousMonth);

			// Calling clickOnPlusIcon function to expand the table
			FundingPage.clickOnPlusIcon(FundingInterestPaymentPO.deferralPlusButton,
					FundingInterestPaymentPO.deferralSection);

			// Get the Deferral This month Loan value
			String deferralThisMonthLoanValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.deferralThisMonthLoanValue);
			// Print or use the List of facility amounts as needed
			System.out.println("STEP02 : Deferral This month Column value for selected previous month: "
					+ deferralThisMonthLoanValue);
			node.log(Status.INFO, "STEP02 :  Deferral This month Column value for selected previous month:  "
					+ deferralThisMonthLoanValue);

			// Locate the list element by its XPath or any other suitable method
			List<WebElement> deferralThisMonthValue = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.deferralThisMonthValues);

			// Initialize a List to store facility amounts as strings
			List<String> deferralThisMonthValueForPreviousMonth = new ArrayList<>();

			// Iterate through each element in the list
			for (WebElement element : deferralThisMonthValue) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				deferralThisMonthValueForPreviousMonth.add(elementValue);
			}

			// Perform assertion for each pair of values in the lists
			boolean allValuesMatch = true;

			for (int i = 0; i < deferralLastMonthValuetForSelectedMonth.size(); i++) {
				String valueFromList1 = deferralLastMonthValuetForSelectedMonth.get(i);
				String valueFromList2 = deferralThisMonthValueForPreviousMonth.get(i);
				System.out.println("List 1: " + valueFromList1);
				node.log(Status.INFO, "List 1: " + valueFromList1);
				System.out.println("List 2: " + valueFromList2);
				node.log(Status.INFO, "List 2: " + valueFromList2);

				// Check if the values match
				if (!valueFromList1.equals(valueFromList2)) {
					allValuesMatch = false;
					System.out.println("Values at position " + i + " do not match:");
					node.log(Status.INFO, "Values at position " + i + " do not match:");
					System.out.println("List 1: " + valueFromList1);
					node.log(Status.INFO, "List 1: " + valueFromList1);
					System.out.println("List 2: " + valueFromList2);
					node.log(Status.INFO, "List 2: " + valueFromList2);
				}
			}

			// Perform the final assertion based on the matching status
			Assert.assertTrue(allValuesMatch, "Not all values in the lists match");

			// Assert calculation start date
			IElementActions.assertEquals_usingString(node, driver, deferralLastMonthLoanValue,
					deferralThisMonthLoanValue,
					"BUG : Deferral Last month column value for selected month " + deferralLastMonthLoanValue
							+ " is matching with the Deferral This month column value for previous month:"
							+ deferralThisMonthLoanValue,
					"PASS : Deferral Last month column value for selected month " + deferralLastMonthLoanValue
							+ " is matching with the Deferral This month column value for previous month:"
							+ deferralThisMonthLoanValue);

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDeferralLastMonth", "Pass", driver);

		} catch (AssertionError validateDeferralLastMonth) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDeferralLastMonth test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDeferralLastMonth_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeferralLastMonth.printStackTrace();
			node.fail(validateDeferralLastMonth);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDeferralLastMonth) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDeferralLastMonth test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDeferralLastMonth_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeferralLastMonth.printStackTrace();
			node.fail(validateDeferralLastMonth);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _163
	@Test(priority = 15)
	public void validateDeferralThisMonth() throws IOException {

		try {
			extenttest = extent.createTest("Verify that the this month is calculated as per below formula:"
					+ "For Loans, sum(Default Interest column) + sum(Standard Interest column) - sum(Default Interest paid column)"
					+ "For Facilties, sum(Default Interest column) - sum(Default Interest Paid column) (columns found in facility i button of step 4, sums shown in white first row)")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get the Value from Excel
			double deviatedValue = Double.parseDouble(getDataFromExcel(10));

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling clickOnPlusIcon function to expand the table
			FundingPage.clickOnPlusIcon(FundingInterestPaymentPO.deferralPlusButton,
					FundingInterestPaymentPO.deferralSection);

			// Get the Deferral This month loan value
			Double deferralThisMonthLoanValue = Utils
					.getTextAndParseToDouble(FundingInterestPaymentPO.deferralThisMonthLoanValue);
			System.out.println("STEP01 : Deferral This month loan value is: " + deferralThisMonthLoanValue);
			node.log(Status.INFO, "STEP01 :  Deferral This month loan value is:  " + deferralThisMonthLoanValue);

			// Extract the values from the elements
			double thisMonthValue = Utils.getTextAndParseToDouble(FundingInterestPaymentPO.deferralThisMonthValue);
			System.out.println("STEP02 : Deferral This month facility value is: " + thisMonthValue);
			node.log(Status.INFO, "STEP02 :  Deferral This month facility value is:  " + thisMonthValue);

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Calling the loanIButton function from FundingPage
			FundingPage.loanIButton(FundingInterestPaymentPO.loanIButton,
					FundingInterestPaymentPO.loanInterestDetailsPopup,
					FundingInterestPaymentPO.loanInterestDetailsPopupHeader);

			// Get sum of Default Interest column, column not visible on staging so taking
			// value 0 as shared on query sheet
			double sumLoanDefaultInterest = 0;

			// Get sum of Default Interest paid column
			double sumLoanDefaultInterestPaid = Utils
					.calculateSumOfList(FundingInterestPaymentPO.defaultInterestPaidColumnInLoan);
			System.out.println("STEP03 : Default Interest Paid sum is: " + sumLoanDefaultInterestPaid);
			node.log(Status.INFO, "STEP03 : Default Interest Paid sum is: " + sumLoanDefaultInterestPaid);

			// Get sum of Standard Interest paid column
			double sumLoanStandardInterest = Utils
					.calculateSumOfList(FundingInterestPaymentPO.standardInterestsColumnInLoan);
			System.out.println("STEP04 : Standard Interest Paid sum is: " + sumLoanStandardInterest);
			node.log(Status.INFO, "STEP04 : Standard Interest Paid sum is: " + sumLoanStandardInterest);

			double sumLoan = Utils.calculateAddition(sumLoanDefaultInterest, sumLoanDefaultInterestPaid);

			sumLoan = Utils.calculateAddition(sumLoan, sumLoanStandardInterest);
			System.out
					.println("STEP05 : Sum of DefaultInterest, DefaultInterestPaid and StandardInterest is " + sumLoan);
			node.log(Status.INFO,
					"STEP05 : Sum of DefaultInterest, DefaultInterestPaid and StandardInterest is " + sumLoan);

			// Calling the closePopUp function from FundingPage
			FundingPage.closePopUp();

			// Calling the facilityIButton function from FundingPage
			FundingPage.facilityIButton(FundingInterestPaymentPO.facilityIButton,
					FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Extract the values from the elements
			double defaultInterestSumInFacility = Utils
					.getTextAndParseToDouble(FundingInterestPaymentPO.defaultInterestSumInFacility);
			System.out.println(
					"STEP06 : Default Interest column sum in facility popup is: " + defaultInterestSumInFacility);
			node.log(Status.INFO,
					"STEP06 : Default Interest column sum in facility popup is: " + defaultInterestSumInFacility);

			// Get the Default Interest Paid
			double defaultInterestPaidSumInFacility = Utils
					.getTextAndParseToDouble(FundingInterestPaymentPO.defaultInterestPaidSumInFacility);
			System.out.println("STEP07 : Default Interest Paid column sum in facility popup is "
					+ defaultInterestPaidSumInFacility);
			node.log(Status.INFO, "STEP07 : Default Interest Paid column sum in facility popup is"
					+ defaultInterestPaidSumInFacility);

			// Calling the calculateDifference from Utils
			double diff = Utils.calculateDifference(defaultInterestSumInFacility, defaultInterestPaidSumInFacility);
			System.out.println(
					"STEP08 : Calculated difference between defaultInterest sum and defaultInterestPaid sum in facility popup is "
							+ diff);
			node.log(Status.INFO,
					"STEP08 : Calculated difference between defaultInterest sum and defaultInterestPaid sum in facility popup is "
							+ diff);

			// Assert this month value
			Assert.assertEquals(thisMonthValue, diff, deviatedValue);

			// Assert this month loan value
			Assert.assertEquals(deferralThisMonthLoanValue, sumLoan, deviatedValue);

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDeferralThisMonth", "Pass", driver);

		} catch (AssertionError validateDeferralThisMonth) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDeferralThisMonth test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDeferralThisMonth_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeferralThisMonth.printStackTrace();
			node.fail(validateDeferralThisMonth);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDeferralThisMonth) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDeferralThisMonth test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDeferralThisMonth_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeferralThisMonth.printStackTrace();
			node.fail(validateDeferralThisMonth);
			Assert.fail();
			extent.flush();
		}
	}

//		TC_Funding_Interest _164
	@Test(priority = 16)
	public void validateDifferenceInDeferralTable() throws IOException {

		try {
			extenttest = extent.createTest("Verify that the Difference is equal to the [This month- Last Month] value.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling clickOnPlusIcon function to expand the table
			FundingPage.clickOnPlusIcon(FundingInterestPaymentPO.deferralPlusButton,
					FundingInterestPaymentPO.deferralSection);

			// Extract the values from the elements
			int thisMonthValue = Utils.getTextAndParseToInt(FundingInterestPaymentPO.deferralLastMonthValue);
			int lastMonthValue = Utils.getTextAndParseToInt(FundingInterestPaymentPO.deferralThisMonthValue);
			int differenceValue = Utils.getTextAndParseToInt(FundingInterestPaymentPO.deferralDifferenceValue);

			// Calculate the difference using the reusable function
			int difference = Utils.calculateDifference(thisMonthValue, lastMonthValue);
			System.out.println(difference);

			// Set the acceptable difference
			int acceptableDifference = 1;

			// Perform assertion allowing for a difference around 1 with a delta parameter
			Assert.assertEquals(difference, differenceValue, acceptableDifference,
					"Difference is greater than the acceptable range");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDifferenceInDeferralTable", "Pass", driver);

		} catch (AssertionError validateDifferenceInDeferralTable) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDifferenceInDeferralTable test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDifferenceInDeferralTable_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDifferenceInDeferralTable.printStackTrace();
			node.fail(validateDifferenceInDeferralTable);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDifferenceInDeferralTable) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDifferenceInDeferralTable test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDifferenceInDeferralTable_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDifferenceInDeferralTable.printStackTrace();
			node.fail(validateDifferenceInDeferralTable);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _165
	// TC_Funding_Interest _166
	// TC_Funding_Interest _167
	@Test(priority = 17)
	public void validateDeferralIButton() throws IOException {

		try {
			extenttest = extent.createTest(
					"checkIButtonVisibility - Verify that the user is able to see the (i) button of each row list."
							+ "checkIButtonIsClickable - Verify that the user is able to click on each (i) button."
							+ "checkPopUp - Verify that the when user is click on the (i) button, Deferral Calculations popup is open and displayed to the user.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			String headerExpectedText = "Deferral Calculations";

			// create Dynamic Locator for Popup header Text
			String headerLocator = IElementActions.createDynamicLocatorString(FundingInterestPaymentPO.popUpHeaderText,
					"locatorValue", headerExpectedText);

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Check the visibility of Deferral First I button
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deferralFirstIButtonsAfterLoan,
					"STEP1 : BUG: Deferral first I button is not coming",
					"STEP1 : EXPECTED: Deferral first I button is coming");

			// Calling clickIIcon function to open the popup
			FundingPage.clickIIcon(FundingInterestPaymentPO.deferralFirstIButtonsAfterLoan);

			// Check the visibility of Deferral popup
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.popUp,
					"STEP2 : BUG: Deferral popup is not coming", "STEP2 : EXPECTED: Deferral popup is coming");

			// Get the PopUp Header Text
			String popUpHeaderText = IElementActions.getElementText_usingXpath(node, driver, headerLocator);
			node.log(Status.INFO, "STEP3 : The PopUp Header Text : " + popUpHeaderText);
			System.out.println("STEP3 : The PopUp Header Text : " + popUpHeaderText);

			// Assert that the difference is equal to the expected difference
			IElementActions.assertEquals_usingString(node, driver, popUpHeaderText, headerExpectedText,
					"STEP4 : BUG: Verification failed! The header text " + popUpHeaderText
							+ " is not Deferral Calculations",
					"STEP4 : EXPECTED: Verification successful! The header text is " + headerExpectedText);

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDeferralIButton", "Pass", driver);

		} catch (AssertionError validateDeferralIButton) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDeferralIButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDeferralIButton_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeferralIButton.printStackTrace();
			node.fail(validateDeferralIButton);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDeferralIButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDeferralIButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDeferralIButton_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeferralIButton.printStackTrace();
			node.fail(validateDeferralIButton);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _168
	// TC_Funding_Interest _169
	// TC_Funding_Interest _171
	@Test(priority = 18)
	public void validateDeferralPopupAndCloseButton() throws IOException {

		try {
			extenttest = extent.createTest(
					"checkPopupDetails - Verify the details on the 'Deferral Calculation' popup: Current Period Deferred, Last Period Deferred, Difference, X icon"
							+ "checkCloseButtonIsClickable - Verify that the user is able to click on the X icon."
							+ "checkPopUpClose - Verify that the user is able to close the 'Deferral Calculation popup while clicking on the X icon.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling clickIIcon function to open the popup
			FundingPage.clickIIcon(FundingInterestPaymentPO.deferralFirstIButtonsAfterLoan);

			// Check the Visibility of Current period deferred text
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.currentPeriodDeferred,
					"STEP1 : BUG: Current period deferred text is not coming",
					"STEP1 : EXPECTED: Current period deferred text is coming");

			// Check the Visibility of Last period deferred text
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.lastPeriodDeferred,
					"STEP2 : BUG: Last period deferred text is not coming",
					"STEP2 : EXPECTED: Last period deferred text is coming");

			// Check the Visibility of Difference text
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.differenceTextInPopup,
					"STEP3 : BUG: Difference text is not coming in popup",
					"STEP3 : EXPECTED: Difference text is coming in popup");

			// Check the Visibility of Close option
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.crossIcon,
					"STEP4 : BUG: Close option is not coming in popup",
					"STEP4 : EXPECTED: Close option is coming in popup");

			// Calling closePopUp function to close the popup
			FundingPage.closePopUp();

			// Assert the Popup is closed
			IElementActions.assertFalse_usingXpath(node, driver, FundingInterestPaymentPO.popUp,
					"STEP5 : BUG: Popup is not closed", "STEP5 : EXPECTED: Popup is closed");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDeferralPopupAndCloseButton", "Pass", driver);

		} catch (AssertionError validateDeferralPopupAndCloseButton) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDeferralPopupAndCloseButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDeferralPopupAndCloseButton_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeferralPopupAndCloseButton.printStackTrace();
			node.fail(validateDeferralPopupAndCloseButton);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDeferralPopupAndCloseButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDeferralPopupAndCloseButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDeferralPopupAndCloseButton_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeferralPopupAndCloseButton.printStackTrace();
			node.fail(validateDeferralPopupAndCloseButton);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _170
	@Test(priority = 19)
	public void validateDeferralPopupData() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the Current Period Deferred, Last Period Deferred and Difference figure is same the Deferral table[Last Month, This Month, Difference]")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling clickOnPlusIcon function to expand the table
			FundingPage.clickOnPlusIcon(FundingInterestPaymentPO.deferralPlusButton,
					FundingInterestPaymentPO.deferralSection);

			// Get the Deferral This Month Value
			String deferralThisMonthValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.deferralThisMonthValue);

			// Get the Deferral Last Month Value
			String deferralLastMonthValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.deferralLastMonthValue);

			// Get the Deferral Difference Value
			String deferralDifferenceValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.deferralDifferenceValue);

			// Calling clickIIcon function to open the popup
			FundingPage.clickIIcon(FundingInterestPaymentPO.deferralFirstIButtonsAfterLoan);

			// Get the First Value
			String currentPeriodDeferredValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.firstValue);

			// Get the Last Period Deferred Value
			String lastPeriodDeferredValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.secondValue);

			// Get the Deferral Value in Popup
			String differenceValueInPopup = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.thirdValue);

			// Calling closePopUp function to close the popup
			FundingPage.closePopUp();

			// Assert the Deferral This Month Value
			IElementActions.assertEquals_usingString(node, driver, deferralThisMonthValue, currentPeriodDeferredValue,
					"STEP1 : BUG: Verification failed! The deferral this month value in table " + deferralThisMonthValue
							+ "is not equal to the value in popup " + currentPeriodDeferredValue,
					"STEP1 : EXPECTED: Verification successful!The deferral this month value in table "
							+ deferralThisMonthValue + " is equal to the value in popup " + currentPeriodDeferredValue);

			// Assert the Deferral Last Month Value
			IElementActions.assertEquals_usingString(node, driver, deferralLastMonthValue, lastPeriodDeferredValue,
					"STEP2 : BUG: Verification failed! The deferral this month value in table " + deferralLastMonthValue
							+ "is not equal to the value in popup " + lastPeriodDeferredValue,
					"STEP2 : EXPECTED: Verification successful!The deferral this month value in table "
							+ deferralLastMonthValue + " is equal to the value in popup " + lastPeriodDeferredValue);

			// Assert the the Deferral Difference Value
			IElementActions.assertEquals_usingString(node, driver, deferralDifferenceValue, differenceValueInPopup,
					"STEP3 : BUG: Verification failed! The deferral Difference value in table "
							+ deferralDifferenceValue + "is not equal to the value in popup " + differenceValueInPopup,
					"STEP3 : EXPECTED: Verification successful!The deferral Difference value in table "
							+ deferralDifferenceValue + " is equal to the value in popup " + differenceValueInPopup);

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDeferralPopupData", "Pass", driver);

		} catch (AssertionError validateDeferralPopupData) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDeferralPopupData test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDeferralPopupData_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeferralPopupData.printStackTrace();
			node.fail(validateDeferralPopupData);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDeferralPopupData) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDeferralPopupData test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDeferralPopupData_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeferralPopupData.printStackTrace();
			node.fail(validateDeferralPopupData);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _172
	// TC_Funding_Interest _173
	@Test(priority = 20)
	public void validatePlusButtonAndColumnsInDeploymentTable() throws IOException {

		try {
			extenttest = extent.createTest(
					"PlusButton - Verify that the user can expand the Deployment table by clicking on the (+) button"
							+ "ColumnsInDeploymentTable - Verify that the Deployment table expended, the Last Month, this Month and Difference column name is displayed to the user.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling clickOnPlusIcon function to expand the table
			FundingPage.clickOnPlusIcon(FundingInterestPaymentPO.deploymentPlusButton,
					FundingInterestPaymentPO.deploymentSection);

			// Check the Visibility of Deployment section
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deploymentSection,
					"STEP1 : BUG: Deployment section is not coming",
					"STEP1 : EXPECTED: Deployment section is not coming");

			// Get the Deployment Last Month
			String deploymentLastMonth = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.deploymentLastMonth);
			node.log(Status.INFO, "STEP2 : The Deployment Last Month Value : " + deploymentLastMonth);
			System.out.println("STEP2 : The Deployment Last Month Value : " + deploymentLastMonth);

			// Get the Deployment This Month
			String deploymentThisMonth = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.deploymentThisMonth);
			node.log(Status.INFO, "STEP3 : The Deployment This Month Value : " + deploymentThisMonth);
			System.out.println("STEP3 : The Deployment This Month Value : " + deploymentThisMonth);

			// Get the Deployment Difference
			String deploymentDifference = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.deploymentDifference);
			node.log(Status.INFO, "STEP4 : The Deployment Difference Value : " + deploymentDifference);
			System.out.println("STEP4 : The Deployment Difference Value : " + deploymentDifference);

			// Assert the Last Month Value
			IElementActions.assertEquals_usingString(node, driver, deploymentLastMonth, "Last Month",
					"STEP5 : BUG: Last Month is not displayed", "STEP5 : EXPECTED: Last Month is displayed");

			// Assert the This Month Value
			IElementActions.assertEquals_usingString(node, driver, deploymentThisMonth, "this Month",
					"STEP6 : BUG: This Month is not displayed", "STEP6 : EXPECTED: This Month is displayed");

			// Assert the Difference is displayed
			IElementActions.assertEquals_usingString(node, driver, deploymentDifference, "Difference",
					"STEP7 : BUG: Difference is not displayed", "STEP7 : EXPECTED: Difference is displayed");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validatePlusButtonAndColumnsInDeploymentTable", "Pass", driver);

		} catch (AssertionError validatePlusButtonAndColumnsInDeploymentTable) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePlusButtonAndColumnsInDeploymentTable test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePlusButtonAndColumnsInDeploymentTable_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePlusButtonAndColumnsInDeploymentTable.printStackTrace();
			node.fail(validatePlusButtonAndColumnsInDeploymentTable);
			Assert.fail();
			extent.flush();

		} catch (Exception validatePlusButtonAndColumnsInDeploymentTable) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePlusButtonAndColumnsInDeploymentTable test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePlusButtonAndColumnsInDeploymentTable_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePlusButtonAndColumnsInDeploymentTable.printStackTrace();
			node.fail(validatePlusButtonAndColumnsInDeploymentTable);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _174
	@Test(priority = 21)
	public void validateDeploymentLastMonth() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the Last Month WA Deployment is same as the Deployment table[Last Month]")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Month
			String month = getDataFromExcel(7);

			// Converting string to integer
			int monthNum = Integer.parseInt(month);
			monthNum = monthNum - 1;

			// Method 1: Using toString() method
			String previousMonth = Integer.toString(monthNum);

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), month);

			// Calling clickOnPlusIcon function to expand the table
			FundingPage.clickOnPlusIcon(FundingInterestPaymentPO.deploymentPlusButton,
					FundingInterestPaymentPO.deploymentSection);

			// Get the Deployment last month Value
			String deploymentLastMonthLoanValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.deploymentLastMonthLoanValue);
			// Print or use the List of facility amounts as needed
			System.out.println(
					"STEP01 : Deployment last month column value for selected month " + deploymentLastMonthLoanValue);
			node.log(Status.INFO,
					"STEP01 : Deployment last month column value for selected month " + deploymentLastMonthLoanValue);

			// Locate the list element by its XPath
			List<WebElement> deploymentLastMonthValue = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.deploymentLastMonthValues);

			// Initialize a List to store facility amounts as strings
			List<String> deploymentLastMonthValuetForSelectedMonth = new ArrayList<>();

			// Iterate through each element in the list
			for (WebElement element : deploymentLastMonthValue) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				deploymentLastMonthValuetForSelectedMonth.add(elementValue);
			}

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), previousMonth);

			// Calling clickOnPlusIcon function to expand the table
			FundingPage.clickOnPlusIcon(FundingInterestPaymentPO.deploymentPlusButton,
					FundingInterestPaymentPO.deploymentSection);

			// Get the Deployment This month column value
			String deploymentThisMonthLoanValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.deploymentThisMonthLoanValue);
			// Print or use the List of facility amounts as needed
			System.out.println("STEP02 : Deployment This month column value for selected previous month: "
					+ deploymentThisMonthLoanValue);
			node.log(Status.INFO, "STEP02 :  Deployment This month column value for selected previous month:  "
					+ deploymentThisMonthLoanValue);

			// Locate the list element by its XPath or any other suitable method
			List<WebElement> deploymentThisMonthValue = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.deploymentThisMonthValues);

			// Initialize a List to store facility amounts as strings
			List<String> deploymentThisMonthValueForPreviousMonth = new ArrayList<>();

			// Iterate through each element in the list
			for (WebElement element : deploymentThisMonthValue) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				deploymentThisMonthValueForPreviousMonth.add(elementValue);
			}

			// Perform assertion for each pair of values in the lists
			boolean allValuesMatch = true;

			for (int i = 0; i < deploymentLastMonthValuetForSelectedMonth.size(); i++) {
				String valueFromList1 = deploymentLastMonthValuetForSelectedMonth.get(i);
				String valueFromList2 = deploymentThisMonthValueForPreviousMonth.get(i);
				System.out.println("List 1: " + valueFromList1);
				node.log(Status.INFO, "List 1: " + valueFromList1);
				System.out.println("List 2: " + valueFromList2);
				node.log(Status.INFO, "List 2: " + valueFromList2);

				// Check if the values match
				if (!valueFromList1.equals(valueFromList2)) {
					allValuesMatch = false;
					System.out.println("Values at position " + i + " do not match:");
					node.log(Status.INFO, "Values at position " + i + " do not match:");
					System.out.println("List 1: " + valueFromList1);
					node.log(Status.INFO, "List 1: " + valueFromList1);
					System.out.println("List 2: " + valueFromList2);
					node.log(Status.INFO, "List 2: " + valueFromList2);
				}
			}

			// Perform the final assertion based on the matching status
			Assert.assertTrue(allValuesMatch, "Not all values in the lists match");

			// Assert Deployment Last month column value
			IElementActions.assertEquals_usingString(node, driver, deploymentLastMonthLoanValue,
					deploymentThisMonthLoanValue,
					"STEP03 : BUG : Deployment Last month column value for selected month "
							+ deploymentLastMonthLoanValue
							+ " is matching with the Deployment This month column value for previous month:"
							+ deploymentThisMonthLoanValue,
					"STEP03 : PASS : Deployment Last month column value for selected month "
							+ deploymentLastMonthLoanValue
							+ " is matching with the Deployment This month column value for previous month:"
							+ deploymentThisMonthLoanValue);

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDeploymentLastMonth", "Pass", driver);

		} catch (AssertionError validateDeploymentLastMonth) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDeploymentLastMonth test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDeploymentLastMonth_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeploymentLastMonth.printStackTrace();
			node.fail(validateDeploymentLastMonth);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDeploymentLastMonth) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDeploymentLastMonth test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDeploymentLastMonth_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeploymentLastMonth.printStackTrace();
			node.fail(validateDeploymentLastMonth);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _175
	@Test(priority = 22)
	public void validateDeploymentThisMonth() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the This Month WA Deployment is equal to the value in the first row of the Rate Changes Check (by Deployment and Cohort) table in Step 2.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling clickOnPlusIcon function to expand the table
			FundingPage.clickOnPlusIcon(FundingInterestPaymentPO.deploymentPlusButton,
					FundingInterestPaymentPO.deploymentSection);

			// Get the Deployment This Month Column Value
			String deploymentThisMonthLoanValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.deploymentThisMonthLoanValue);
			// Print or use the List of facility amounts as needed
			System.out.println(
					"STEP01 : Deployment this month column value for selected month " + deploymentThisMonthLoanValue);
			node.log(Status.INFO,
					"STEP01 : Deployment this month column value for selected month " + deploymentThisMonthLoanValue);

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.healthStep2);

			// value in the first row of the Rate Changes Check (by Deployment and Cohort)
			// table in Step 2
			String thisMonthLoanValueInRateCohort = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.thisMonthRateCohortLoan);
			// Print or use the List of facility amounts as needed
			System.out.println("STEP02 : Deployment this month loan RateCohort value for selected month "
					+ thisMonthLoanValueInRateCohort);
			node.log(Status.INFO, "STEP02 : Deployment this month loan RateCohort value for selected month "
					+ thisMonthLoanValueInRateCohort);

			// Assert Deployment This Month Loan Value
			IElementActions.assertEquals_usingString(node, driver, deploymentThisMonthLoanValue,
					thisMonthLoanValueInRateCohort,
					"STEP03 : BUG : Deployment This month loan value is " + deploymentThisMonthLoanValue
							+ " not matching with the Deployment This month loan value for RateCohort:"
							+ thisMonthLoanValueInRateCohort,
					"STEP03 : PASS : Deployment This month loan value is " + deploymentThisMonthLoanValue
							+ " is matching with the Deployment This month loan value for RateCohort:"
							+ thisMonthLoanValueInRateCohort);

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDeploymentThisMonth", "Pass", driver);

		} catch (AssertionError validateDeploymentThisMonth) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDeploymentThisMonth test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDeploymentThisMonth_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeploymentThisMonth.printStackTrace();
			node.fail(validateDeploymentThisMonth);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDeploymentThisMonth) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDeploymentThisMonth test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDeploymentThisMonth_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeploymentThisMonth.printStackTrace();
			node.fail(validateDeploymentThisMonth);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _176
	@Test(priority = 23)
	public void validateDifferenceInDeploymentTable() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the Difference (Monthly Deployment Delta) is equal to  the  100*(This Month WA Deployment - Last Month WA Deployment)/(Last Month WA Deployment) value.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling clickOnPlusIcon function to expand the table
			FundingPage.clickOnPlusIcon(FundingInterestPaymentPO.deploymentPlusButton,
					FundingInterestPaymentPO.deploymentSection);

			// Extract the values from the elements
			int thisMonthValue = Utils.getTextAndParseToInt(FundingInterestPaymentPO.deploymentLastMonthValue);
			int lastMonthValue = Utils.getTextAndParseToInt(FundingInterestPaymentPO.deploymentThisMonthValue);
			Double differenceValue = Utils.getTextAndParseToDouble(FundingInterestPaymentPO.deploymentDifferenceValue);

			// Calling the calculateDifference from Utils
			int difference = Utils.calculateDifference(thisMonthValue, lastMonthValue);
			System.out.println(difference);

			int result = 0;
			// Check if the divisor is not zero to avoid division by zero
			if (lastMonthValue != 0L) {
				// Perform division
				result = (difference / lastMonthValue) * 100;

				// Print the result
				node.log(Status.INFO, "STEP-01 : Result of division " + result);
				System.out.println("STEP-01 : Result of division " + result);

			} else {
				node.log(Status.INFO, "Error: Division by zero is not allowed.");
				System.out.println("Error: Division by zero is not allowed.");
			}

			// Set the acceptable difference
			double acceptableDifference = Double.parseDouble(getDataFromExcel(10));

			// Perform assertion allowing for a difference around 1 with a delta parameter
			Assert.assertEquals(differenceValue, result, acceptableDifference,
					"Difference is greater than the acceptable range");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDifferenceInDeploymentTable", "Pass", driver);

		} catch (AssertionError validateDifferenceInDeploymentTable) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDifferenceInDeploymentTable test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDifferenceInDeploymentTable_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDifferenceInDeploymentTable.printStackTrace();
			node.fail(validateDifferenceInDeploymentTable);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDifferenceInDeploymentTable) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDifferenceInDeploymentTable test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDifferenceInDeploymentTable_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDifferenceInDeploymentTable.printStackTrace();
			node.fail(validateDifferenceInDeploymentTable);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _177
	// TC_Funding_Interest _178
	// TC_Funding_Interest _179
	@Test(priority = 24)
	public void validateDeploymentIButton() throws IOException {

		try {
			extenttest = extent.createTest(
					"checkIButtonVisibility - Verify that the user is able to see the (i) button of each row list."
							+ "checkIButtonIsClickable - Verify that the user is able to click on each (i) button."
							+ "checkPopUp - Verify that the when user is click on the (i) button, Deployment Difference Calculations popup is open and displayed to the user.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			String headerExpectedText = "Deployment Difference Calculations";

			// Create Dynamic Locator for Header Text
			String headerLocator = IElementActions.createDynamicLocatorString(FundingInterestPaymentPO.popUpHeaderText,
					"locatorValue", headerExpectedText);

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Check the Visibility of Deployment first I button
			IElementActions.assertTrue_usingXpath(node, driver,
					FundingInterestPaymentPO.deploymentFirstIButtonsAfterLoan,
					"STEP1 : BUG: Deployment first I button is not coming",
					"STEP1 : EXPECTED: Deployment first I button is coming");

			// Click on deployment I button
			IElementActions.clickelement_usingXpath(node, driver,
					FundingInterestPaymentPO.deploymentFirstIButtonsAfterLoan);
			node.log(Status.INFO, "STEP2 : Clicked on the deployment plus button");
			System.out.println("STEP2 : Clicked on the deployment plus button");

			// Wait for the visibility of the deployment PopUp
			node.log(Status.INFO, "STEP3 : Waiting for the visibility of the deployment popup");
			System.out.println("STEP3 : Waiting for the visibility of the deployment popup");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.popUp);
			node.log(Status.INFO, "STEP4 : Deployment popup is visible");
			System.out.println("STEP4 : Deployment popup is visible");

			// Check the Visibility of Deployment popup
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.popUp,
					"STEP5 : BUG: Deployment popup is not coming", "STEP5 : EXPECTED: Deployment popup is coming");

			// Get the Popup Header Text
			String popUpHeaderText = IElementActions.getElementText_usingXpath(node, driver, headerLocator);

			// Assert Popup Header Text
			IElementActions.assertEquals_usingString(node, driver, popUpHeaderText, headerExpectedText,
					"STEP6 : BUG: Verification failed! The header text " + popUpHeaderText
							+ " is not Deployment Difference Calculations",
					"STEP6 : EXPECTED: Verification successful! The header text is " + headerExpectedText);

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDeploymentIButton", "Pass", driver);

		} catch (AssertionError validateDeploymentIButton) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDeploymentIButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDeploymentIButton_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeploymentIButton.printStackTrace();
			node.fail(validateDeploymentIButton);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDeploymentIButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDeploymentIButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDeploymentIButton_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeploymentIButton.printStackTrace();
			node.fail(validateDeploymentIButton);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _180
	// TC_Funding_Interest _181
	// TC_Funding_Interest _187
	@Test(priority = 25)
	public void validateDeploymentPopupAndCloseButton() throws IOException {

		try {
			extenttest = extent.createTest(
					"checkPopupDetails - Verify the details on the 'Deployment Difference Calculations' popup: Last Month WA Deployment, This Month WA Deployment, Monthly Deployment Delta, Last Month Interest (Total), Deployment Calculation, X icon"
							+ "checkCloseButtonIsClickable - Verify that the user is able to click on the X icon."
							+ "checkPopUpClose - Verify that the user is able to close the 'Deployment Calculation popup while clicking on the X icon.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling clickIIcon function to open the popup
			FundingPage.clickIIcon(FundingInterestPaymentPO.deploymentFirstIButtonsAfterLoan);

			// Check the Visibility of Last Month WA Deployment text
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.lastMonthWADeployment,
					"STEP1 : BUG: Last Month WA Deployment text is not coming",
					"STEP1 : EXPECTED: Last Month WA Deployment text is coming");

			// Check the Visibility of This Month WA Deployment text
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.thisMonthWADeployment,
					"STEP2 : BUG: This Month WA Deployment text is not coming",
					"STEP2 : EXPECTED: This Month WA Deployment text is coming");

			// Check the Visibility of Month Deployment Delta text
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.monthDeploymentDelta,
					"STEP3 : BUG: Month Deployment Delta text is not coming in popup",
					"STEP3 : EXPECTED: Month Deployment Delta text is coming in popup");

			// Check the Visibility of Last Month Interest text
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.lastMonthInterest,
					"STEP4 : BUG: Last Month Interest text is not coming in popup",
					"STEP4 : EXPECTED: Last Month Interest text is coming in popup");

			// Check the Visibility of Deployment Calculation text
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.deploymentCalculation,
					"STEP5 : BUG: Deployment Calculation text is not coming in popup",
					"STEP5 : EXPECTED: Deployment Calculation text is coming in popup");

			// Check the Visibility of Last Month WA Deployment text
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.crossIcon,
					"STEP6 : BUG: Close option is not coming in popup",
					"STEP6 : EXPECTED: Close option is coming in popup");

			// Calling closePopUp function to close the popup
			FundingPage.closePopUp();

			// Assert the Popup is closed
			IElementActions.assertFalse_usingXpath(node, driver, FundingInterestPaymentPO.popUp,
					"STEP7 : BUG: Popup is not closed", "STEP7 : EXPECTED: Popup is closed");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDeploymentPopupAndCloseButton", "Pass", driver);

		} catch (AssertionError validateDeploymentPopupAndCloseButton) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDeploymentPopupAndCloseButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDeploymentPopupAndCloseButton_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeploymentPopupAndCloseButton.printStackTrace();
			node.fail(validateDeploymentPopupAndCloseButton);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDeploymentPopupAndCloseButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDeploymentPopupAndCloseButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDeploymentPopupAndCloseButton_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeploymentPopupAndCloseButton.printStackTrace();
			node.fail(validateDeploymentPopupAndCloseButton);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _182
	// TC_Funding_Interest _183
	// TC_Funding_Interest _184
	@Test(priority = 26)
	public void validateDeploymentTableDataWithPopup() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the Last Month WA Deployment is same as the Deployment table[Last Month]"
							+ "Verify that the This Month WA Deployment is same as the Deployment table[Last Month]"
							+ "Verify that the Monthly Deployment Delta is calculated as per the below formula:(This Month WA Deployment - Last Month WA Deployment)/(Last Month WA Deployment)*100")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling clickOnPlusIcon function to expand the table
			FundingPage.clickOnPlusIcon(FundingInterestPaymentPO.deploymentPlusButton,
					FundingInterestPaymentPO.deploymentSection);

			// Get the Deployment Last Month Value
			String deploymentLastMonthValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.deploymentLastMonthValue);

			// Get the Deployment This Month Value
			String deploymentThisMonthValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.deploymentThisMonthValue);

			// Get the Deployment Difference Value
			String deploymentDifferenceValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.deploymentDifferenceValue);

			// Calling clickIIcon function to open the popup
			FundingPage.clickIIcon(FundingInterestPaymentPO.deploymentFirstIButtonsAfterLoan);

			// Get the Last Month WA Deployment Value
			String lastMonthWADeploymentValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.firstValue);

			// Get the This Month WA Deployment Value
			String thisMonthWADeploymentValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.secondValue);

			// Get the Month Deployment Delta Value
			String monthDeploymentDeltaValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.thirdValue);

			// Calling closePopUp function to close the popup
			FundingPage.closePopUp();

			// Assert The deployment Last Month value
			IElementActions.assertEquals_usingString(node, driver, deploymentLastMonthValue, lastMonthWADeploymentValue,
					"STEP1 : BUG: Verification failed! The deployment Last Month value in table "
							+ deploymentLastMonthValue + "is not equal to the value in popup "
							+ lastMonthWADeploymentValue,
					"STEP1 : EXPECTED: Verification successful!The deployment Last Month value in table "
							+ deploymentLastMonthValue + " is equal to the value in popup "
							+ lastMonthWADeploymentValue);

			// Assert the deployment This Month value
			IElementActions.assertEquals_usingString(node, driver, deploymentThisMonthValue, thisMonthWADeploymentValue,
					"STEP2 : BUG: Verification failed! The deployment This Month value in table "
							+ deploymentThisMonthValue + "is not equal to the value in popup "
							+ thisMonthWADeploymentValue,
					"STEP2 : EXPECTED: Verification successful!The deployment This Month value in table "
							+ deploymentThisMonthValue + " is equal to the value in popup "
							+ thisMonthWADeploymentValue);

			// Assert the deployment Difference value
			IElementActions.assertEquals_usingString(node, driver, deploymentDifferenceValue, monthDeploymentDeltaValue,
					"STEP3 : BUG: Verification failed! The deployment Difference value in table "
							+ deploymentDifferenceValue + "is not equal to the value in popup "
							+ monthDeploymentDeltaValue,
					"STEP3 : EXPECTED: Verification successful!The deployment Difference value in table "
							+ deploymentDifferenceValue + " is equal to the value in popup "
							+ monthDeploymentDeltaValue);

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDeploymentTableDataWithPopup", "Pass", driver);

		} catch (AssertionError validateDeploymentTableDataWithPopup) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDeploymentTableDataWithPopup test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDeploymentTableDataWithPopup_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeploymentTableDataWithPopup.printStackTrace();
			node.fail(validateDeploymentTableDataWithPopup);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDeploymentTableDataWithPopup) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDeploymentTableDataWithPopup test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDeploymentTableDataWithPopup_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeploymentTableDataWithPopup.printStackTrace();
			node.fail(validateDeploymentTableDataWithPopup);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _186
	@Test(priority = 27)
	public void validateDeploymentCalculation() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the Deployment Calculation is calculated as per the below formula:"
							+ "Monthly Deployment Delta * Last Month Interest (Total)")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling clickIIcon function to open the popup
			FundingPage.clickIIcon(FundingInterestPaymentPO.deploymentFirstIButtonsAfterLoan);

			// Get the Month Deployment Delta Value
			double monthDeploymentDeltaValue = Utils
					.getPercentageTextAndParseToDouble(FundingInterestPaymentPO.thirdValue);

			// Get the Last Month Interest Value
			int lastMonthInterestValue = Utils.getTextAndParseToInt(FundingInterestPaymentPO.fourthValue);

			// Get the Deployment Calculation Value
			Double deploymentCalculationValue = Utils
					.getPercentageTextAndParseToDouble(FundingInterestPaymentPO.fifthValue);

			double calculatedValue = monthDeploymentDeltaValue * lastMonthInterestValue;

			// Set the acceptable difference
			double acceptableDifference = Double.parseDouble(getDataFromExcel(10));

			// Perform assertion allowing for a difference around 5 with a delta parameter
			Assert.assertEquals(calculatedValue, deploymentCalculationValue, acceptableDifference,
					"Difference is greater than the acceptable range");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDeploymentCalculation", "Pass", driver);

		} catch (AssertionError validateDeploymentCalculation) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDeploymentCalculation test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDeploymentCalculation_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeploymentCalculation.printStackTrace();
			node.fail(validateDeploymentCalculation);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDeploymentCalculation) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDeploymentCalculation test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDeploymentCalculation_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDeploymentCalculation.printStackTrace();
			node.fail(validateDeploymentCalculation);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _188
	// TC_Funding_Interest _189
	@Test(priority = 28)
	public void validatePlusButtonAndColumnsInRateTable() throws IOException {

		try {
			extenttest = extent.createTest(
					"PlusButton - Verify that the user can expand the Rate table by clicking on the (+) button"
							+ "ColumnsInRateTable - Verify that the Rate table expended, the Last Month, this Month and Difference column name is displayed to the user.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling clickOnPlusIcon function to expand the table
			FundingPage.clickOnPlusIcon(FundingInterestPaymentPO.ratePlusButton, FundingInterestPaymentPO.rateSection);

			// Check the Visibility of Rate section
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.rateSection,
					"STEP1 : BUG: Rate section is not coming", "STEP1 : EXPECTED: Rate section is not coming");

			// Get the Rate Last Month
			String rateLastMonth = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.rateLastMonth);
			node.log(Status.INFO, "STEP2 : The Rate Last Month : " + rateLastMonth);
			System.out.println("STEP2 : The Rate Last Month : " + rateLastMonth);

			// Get the Rate This Month
			String rateThisMonth = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.rateThisMonth);
			node.log(Status.INFO, "STEP3 : The Rate This Month : " + rateThisMonth);
			System.out.println("STEP3 : The Rate This Month : " + rateThisMonth);

			// Get the Rate Difference
			String rateDifference = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.rateDifference);
			node.log(Status.INFO, "STEP4 : The Rate Difference : " + rateDifference);
			System.out.println("STEP4 : The Rate Difference : " + rateDifference);

			// Assert the Last Month is displayed
			IElementActions.assertEquals_usingString(node, driver, rateLastMonth, "Last Month",
					"STEP5 : BUG: Last Month is not displayed", "STEP5 : EXPECTED: Last Month is displayed");

			// Assert the This Month is displayed
			IElementActions.assertEquals_usingString(node, driver, rateThisMonth, "this Month",
					"STEP6 : BUG: this Month is not displayed", "STEP6 : EXPECTED: this Month is displayed");

			// Assert the Difference is displayed
			IElementActions.assertEquals_usingString(node, driver, rateDifference, "Difference",
					"STEP7 : BUG: Difference is not displayed", "STEP7 : EXPECTED: Difference is displayed");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validatePlusButtonAndColumnsInRateTable", "Pass", driver);

		} catch (AssertionError validatePlusButtonAndColumnsInRateTable) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePlusButtonAndColumnsInRateTable test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePlusButtonAndColumnsInRateTable_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePlusButtonAndColumnsInRateTable.printStackTrace();
			node.fail(validatePlusButtonAndColumnsInRateTable);
			Assert.fail();
			extent.flush();

		} catch (Exception validatePlusButtonAndColumnsInRateTable) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePlusButtonAndColumnsInRateTable test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePlusButtonAndColumnsInRateTable_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePlusButtonAndColumnsInRateTable.printStackTrace();
			node.fail(validatePlusButtonAndColumnsInRateTable);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _190
	@Test(priority = 29)
	public void validateLastMonthInRateStep3() throws IOException {

		try {
			extenttest = extent.createTest("Verify the last month in the rate table")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling clickOnPlusIcon function to expand the table
			FundingPage.clickOnPlusIcon(FundingInterestPaymentPO.ratePlusButton, FundingInterestPaymentPO.rateSection);

			// Locate the list element by its XPath
			List<WebElement> elementsInStep3 = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.lastMonthRates);

			// Initialize a List to store facility amounts as strings
			List<String> lastMonthRateInStep3 = new ArrayList<>();

			// Iterate through each element in the list
			for (WebElement element : elementsInStep3) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				lastMonthRateInStep3.add(elementValue);
			}

			// Print or use the List of facility amounts as needed
			System.out.println("Facility Amounts in step3: " + lastMonthRateInStep3);

			Thread.sleep(2000);

			// Calling the navigateToStep function from the FundingPage
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Wait for the visibility of the facilitiesPayableAmountInStep4
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the loan amount");
			System.out.println("STEP1 : Waiting for the visibility of the loan amount");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.bridgeLoanLastMonth);
			node.log(Status.INFO, "STEP2 : Loan amount is visible");
			System.out.println("STEP2 : Loan amount is visible");

			// Locate the list element by its XPath
			List<WebElement> elementsInStep4 = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.bridgeLoanLastMonth);

			// Initialize a List to store facility amounts as strings
			List<String> lastMonthRateInStep4 = new ArrayList<>();

			// Iterate through each element in the list
			for (WebElement element : elementsInStep4) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				lastMonthRateInStep4.add(elementValue);
			}

			// Print or use the List of facility amounts as needed
			System.out.println("Facility Amounts in step4: " + lastMonthRateInStep4);

			// Perform assertion for each pair of values in the lists
			boolean allValuesMatch = true;

			for (int i = 0; i < lastMonthRateInStep3.size(); i++) {
				String valueFromList1 = lastMonthRateInStep3.get(i);
				String valueFromList2 = lastMonthRateInStep4.get(i);

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
			IScreenAction.captureScreenShot_PassCase("validateLastMonthInRateStep3", "Pass", driver);

		} catch (AssertionError validateLastMonthInRateStep3) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLastMonthInRateStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLastMonthInRateStep3_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLastMonthInRateStep3.printStackTrace();
			node.fail(validateLastMonthInRateStep3);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLastMonthInRateStep3) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLastMonthInRateStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLastMonthInRateStep3_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLastMonthInRateStep3.printStackTrace();
			node.fail(validateLastMonthInRateStep3);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _191
	@Test(priority = 30)
	public void validateThisMonthInRateStep3() throws IOException {

		try {
			extenttest = extent.createTest("Verify the this month in the rate table")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling clickOnPlusIcon function to expand the table
			FundingPage.clickOnPlusIcon(FundingInterestPaymentPO.ratePlusButton, FundingInterestPaymentPO.rateSection);

			// Locate the list element by its XPath
			List<WebElement> elementsInStep3 = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.thisMonthRates);

			// Initialize a List to store facility amounts as strings
			List<String> thisMonthRateInStep3 = new ArrayList<>();

			// Iterate through each element in the list
			for (WebElement element : elementsInStep3) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				thisMonthRateInStep3.add(elementValue);
			}

			// Print or use the List of facility amounts as needed
			System.out.println("Facility Amounts in step3: " + thisMonthRateInStep3);

			Thread.sleep(2000);
			// Call the navigateToStep function from the FundingPage
			FundingPage.navigateToStep(FundingInterestPaymentPO.returnAnalysisStep4);

			// Wait for the visibility of the facilitiesPayableAmountInStep4
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the loan amount");
			System.out.println("STEP1 : Waiting for the visibility of the loan amount");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.bridgeLoanCalculated);
			node.log(Status.INFO, "STEP2 : Loan amount is visible");
			System.out.println("STEP2 : Loan amount is visible");

			// Locate the list element by its XPath
			List<WebElement> elementsInStep4 = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.bridgeLoanCalculated);

			// Initialize a List to store facility amounts as strings
			List<String> systemRateInStep4 = new ArrayList<>();

			// Iterate through each element in the list
			for (WebElement element : elementsInStep4) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				systemRateInStep4.add(elementValue);
			}

			// Print or use the List of facility amounts as needed
			System.out.println("Facility Amounts in step4: " + systemRateInStep4);

			// Perform assertion for each pair of values in the lists
			boolean allValuesMatch = true;

			for (int i = 0; i < thisMonthRateInStep3.size(); i++) {
				String valueFromList1 = thisMonthRateInStep3.get(i);
				String valueFromList2 = systemRateInStep4.get(i);

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
			IScreenAction.captureScreenShot_PassCase("validateThisMonthInRateStep3", "Pass", driver);

		} catch (AssertionError validateThisMonthInRateStep3) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateThisMonthInRateStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateThisMonthInRateStep3_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateThisMonthInRateStep3.printStackTrace();
			node.fail(validateThisMonthInRateStep3);
			Assert.fail();
			extent.flush();

		} catch (Exception validateThisMonthInRateStep3) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateThisMonthInRateStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateThisMonthInRateStep3_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateThisMonthInRateStep3.printStackTrace();
			node.fail(validateThisMonthInRateStep3);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _192
	@Test(priority = 31)
	public void validateDifferenceInRateTable() throws IOException {

		try {
			extenttest = extent.createTest("Verify that the Difference is equal to the [This month- Last Month] value.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling clickOnPlusIcon function to expand the table
			FundingPage.clickOnPlusIcon(FundingInterestPaymentPO.ratePlusButton, FundingInterestPaymentPO.rateSection);

			// Extract the values from the elements
			Double thisMonthValue = Utils.getTextAndParseToDouble(FundingInterestPaymentPO.rateLastMonthValue);
			Double lastMonthValue = Utils.getTextAndParseToDouble(FundingInterestPaymentPO.rateThisMonthValue);
			Double differenceValue = Utils.getTextAndParseToDouble(FundingInterestPaymentPO.rateDifferenceValue);

			// Calculate the difference using the reusable function
			double difference = Utils.calculateDifference(thisMonthValue, lastMonthValue);
			System.out.println(difference);

			// Set the acceptable difference
			double acceptableDifference = Double.parseDouble(getDataFromExcel(10));

			// Perform assertion allowing for a difference around 5 with a delta parameter
			Assert.assertEquals(difference, differenceValue, acceptableDifference,
					"Difference is greater than the acceptable range");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDifferenceInRateTable", "Pass", driver);

		} catch (AssertionError validateDifferenceInRateTable) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDifferenceInRateTable test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDifferenceInRateTable_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDifferenceInRateTable.printStackTrace();
			node.fail(validateDifferenceInRateTable);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDifferenceInRateTable) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDifferenceInRateTable test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDifferenceInRateTable_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDifferenceInRateTable.printStackTrace();
			node.fail(validateDifferenceInRateTable);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _193
	// TC_Funding_Interest _194
	// TC_Funding_Interest _195
	@Test(priority = 32)
	public void validateRateIButton() throws IOException {

		try {
			extenttest = extent.createTest(
					"checkIButtonVisibility - Verify that the user is able to see the (i) button of each row list."
							+ "checkIButtonIsClickable - Verify that the user is able to click on each (i) button."
							+ "checkPopUp - Verify that the when user is click on the (i) button, Bridge Loan Rate Difference Calculations popup is open and displayed to the user.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			String headerExpectedText = "Bridge Loan Rate Difference Calculations";

			// Create Dynamic Locator for Popup Header Text
			String headerLocator = IElementActions.createDynamicLocatorString(FundingInterestPaymentPO.popUpHeaderText,
					"locatorValue", headerExpectedText);

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Check the Visibility of First I Button
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.rateFirstIButtonsAfterLoan,
					"STEP1 : BUG: Rate first I button is not coming",
					"STEP1 : EXPECTED: Rate first I button is coming");

			// Calling clickIIcon function to open the popup
			FundingPage.clickIIcon(FundingInterestPaymentPO.rateFirstIButtonsAfterLoan);

			// Check the Visibility of Rate popup
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.popUp,
					"STEP2 : BUG: Rate popup is not coming", "STEP2 : EXPECTED: Rate popup is coming");

			// Get the Popup Header Text
			String popUpHeaderText = IElementActions.getElementText_usingXpath(node, driver, headerLocator);

			// Assert the Popup Header Text
			IElementActions.assertEquals_usingString(node, driver, popUpHeaderText, headerExpectedText,
					"STEP3 : BUG: Verification failed! The header text " + popUpHeaderText
							+ " is not Rate Difference Calculations",
					"STEP3 : EXPECTED: Verification successful! The header text is " + headerExpectedText);

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateRateIButton", "Pass", driver);

		} catch (AssertionError validateRateIButton) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateRateIButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateRateIButton_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRateIButton.printStackTrace();
			node.fail(validateRateIButton);
			Assert.fail();
			extent.flush();

		} catch (Exception validateRateIButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateRateIButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateRateIButton_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRateIButton.printStackTrace();
			node.fail(validateRateIButton);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _196
	// TC_Funding_Interest _197
	// TC_Funding_Interest _203
	@Test(priority = 33)
	public void validateRatePopupAndCloseButton() throws IOException {

		try {
			extenttest = extent.createTest(
					"checkPopupDetails - Verify that the user is able to see the following details on the 'Bridge Loan Rate Difference Calculations' popup:Last Month Bridge Loan Rate, This Month Bridge Loan Rate, Monthly Difference, Last Month Interest (Total), Rate Calculation, X icon"
							+ "checkCloseButtonIsClickable - Verify that the user is able to click on the X icon."
							+ "checkPopUpClose - Verify that the user is able to close the 'Rate Calculation popup while clicking on the X icon.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling clickIIcon function to open the popup
			FundingPage.clickIIcon(FundingInterestPaymentPO.rateFirstIButtonsAfterLoan);

			// Check the Visibility of Last Month WA Rate text
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.firstValue,
					"STEP1 : BUG: Last Month WA Rate text is not coming",
					"STEP1 : EXPECTED: Last Month WA Rate text is coming");

			// Check the Visibility of This Month WA Rate text
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.secondValue,
					"STEP2 : BUG: This Month WA Rate text is not coming",
					"STEP2 : EXPECTED: This Month WA Rate text is coming");

			// Check the Visibility of Month Rate Delta text
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.thirdValue,
					"STEP3 : BUG: Month Rate Delta text is not coming in popup",
					"STEP3 : EXPECTED: Month Rate Delta text is coming in popup");

			// Check the Visibility of Last Month Interest text
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.fourthValue,
					"STEP4 : BUG: Last Month Interest text is not coming in popup",
					"STEP4 : EXPECTED: Last Month Interest text is coming in popup");

			// Check the Visibility of Rate Calculation text
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.fifthValue,
					"STEP5 : BUG: Rate Calculation text is not coming in popup",
					"STEP5 : EXPECTED: Rate Calculation text is coming in popup");

			// Check the Visibility of Close option
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.crossIcon,
					"STEP6 : BUG: Close option is not coming in popup",
					"STEP6 : EXPECTED: Close option is coming in popup");

			// Calling closePopUp function to close the popup
			FundingPage.closePopUp();

			// Assert the Popup is closed
			IElementActions.assertFalse_usingXpath(node, driver, FundingInterestPaymentPO.popUp,
					"STEP7 : BUG: Popup is not closed", "STEP7 : EXPECTED: Popup is closed");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateRatePopupAndCloseButton", "Pass", driver);

		} catch (AssertionError validateRatePopupAndCloseButton) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateRatePopupAndCloseButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRatePopupAndCloseButton_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRatePopupAndCloseButton.printStackTrace();
			node.fail(validateRatePopupAndCloseButton);
			Assert.fail();
			extent.flush();

		} catch (Exception validateRatePopupAndCloseButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateRatePopupAndCloseButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRatePopupAndCloseButton_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRatePopupAndCloseButton.printStackTrace();
			node.fail(validateRatePopupAndCloseButton);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _198
	// TC_Funding_Interest _199
	// TC_Funding_Interest _200
	@Test(priority = 34)
	public void validateRateTableDataWithPopup() throws IOException {

		try {
			extenttest = extent.createTest(
					"LastMonth - Verify that the Last Month Bridge Loan Rate is the same as the Rate table[Last Month]"
							+ "ThisMonth - Verify that the This Month Bridge Loan Rate is same as the Rate table[Last Month]"
							+ "Difference - Verify that the Monthly Difference is calculated as per the below formula:\r\n"
							+ "This Month Bridge Loan Rate - Last Month Bridge Loan Rate")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling clickOnPlusIcon function to expand the table
			FundingPage.clickOnPlusIcon(FundingInterestPaymentPO.ratePlusButton, FundingInterestPaymentPO.rateSection);

			// Get the Rate Last Month Value
			String rateLastMonthValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.rateLastMonthValue);

			// Get the Rate This Month Value
			String rateThisMonthValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.rateThisMonthValue);

			// Get the Rate Difference Value
			String rateDifferenceValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.rateDifferenceValue);

			// Calling clickIIcon function to open the popup
			FundingPage.clickIIcon(FundingInterestPaymentPO.rateFirstIButtonsAfterLoan);

			// Get the Last Month Bridge Loan Value
			String lastMonthBridgeLoanValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.firstValue);

			// Get the This Month Bridge Loan Value
			String thisMonthBridgeLoanValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.secondValue);

			// Get the Monthly Difference Value
			String monthlyDifferenceValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.thirdValue);

			// Calling closePopUp function to close the popup
			FundingPage.closePopUp();

			// Assert the Last Month value
			IElementActions.assertEquals_usingString(node, driver, rateLastMonthValue, lastMonthBridgeLoanValue,
					"STEP1 : BUG: Verification failed! The rate Last Month value in table " + rateLastMonthValue
							+ "is not equal to the value in popup " + lastMonthBridgeLoanValue,
					"STEP1 : EXPECTED: Verification successful!The rate Last Month value in table " + rateLastMonthValue
							+ " is equal to the value in popup " + lastMonthBridgeLoanValue);

			// Assert This Month value
			IElementActions.assertEquals_usingString(node, driver, rateThisMonthValue, thisMonthBridgeLoanValue,
					"STEP2 : BUG: Verification failed! The rate This Month value in table " + rateThisMonthValue
							+ "is not equal to the value in popup " + thisMonthBridgeLoanValue,
					"STEP2 : EXPECTED: Verification successful!The rate This Month value in table " + rateThisMonthValue
							+ " is equal to the value in popup " + thisMonthBridgeLoanValue);

			// Assert the rate Difference value
			IElementActions.assertEquals_usingString(node, driver, rateDifferenceValue, monthlyDifferenceValue,
					"STEP3 : BUG: Verification failed! The rate Difference value in table " + rateDifferenceValue
							+ "is not equal to the value in popup " + monthlyDifferenceValue,
					"STEP3 : EXPECTED: Verification successful!The rate Difference value in table "
							+ rateDifferenceValue + " is equal to the value in popup " + monthlyDifferenceValue);

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateRateTableDataWithPopup", "Pass", driver);

		} catch (AssertionError validateRateTableDataWithPopup) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateRateTableDataWithPopup test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRateTableDataWithPopup_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRateTableDataWithPopup.printStackTrace();
			node.fail(validateRateTableDataWithPopup);
			Assert.fail();
			extent.flush();

		} catch (Exception validateRateTableDataWithPopup) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateRateTableDataWithPopup test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRateTableDataWithPopup_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRateTableDataWithPopup.printStackTrace();
			node.fail(validateRateTableDataWithPopup);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest_202
	@Test(priority = 35)
	public void validateRateCalculation() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the Rate Calculation is calculated as per the below formula:\r\n"
							+ "Monthly Difference * Last Month Interest (Total)")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling clickIIcon function to open the popup
			FundingPage.clickIIcon(FundingInterestPaymentPO.rateFirstIButtonsAfterLoan);

			// Get the Monthly Difference Value
			double monthlyDifferenceValue = Utils
					.getPercentageTextAndParseToDouble(FundingInterestPaymentPO.thirdValue);

			// Get the Last Month Interest Value
			int lastMonthInterestValue = Utils.getTextAndParseToInt(FundingInterestPaymentPO.fourthValue);

			// Get the Rate Calculation Value
			Double rateCalculationValue = Utils.getTextAndParseToDouble(FundingInterestPaymentPO.fifthValue);

			double calculatedValue = monthlyDifferenceValue * lastMonthInterestValue;

			// Set the acceptable difference
			double acceptableDifference = Double.parseDouble(getDataFromExcel(10));

			// Perform assertion allowing for a difference around 5 with a delta parameter
			Assert.assertEquals(calculatedValue, rateCalculationValue, acceptableDifference,
					"Difference is greater than the acceptable range");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateRateCalculation", "Pass", driver);

		} catch (AssertionError validateRateCalculation) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateRateCalculation test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateRateCalculation_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRateCalculation.printStackTrace();
			node.fail(validateRateCalculation);
			Assert.fail();
			extent.flush();

		} catch (Exception validateRateCalculation) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateRateCalculation test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateRateCalculation_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRateCalculation.printStackTrace();
			node.fail(validateRateCalculation);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _204
	// TC_Funding_Interest _205
	// TC_Funding_Interest _206
	@Test(priority = 36)
	public void validateDayCountIButton() throws IOException {

		try {
			extenttest = extent.createTest(
					"checkIButtonVisibility - Verify that the user is able to see the (i) button of each row list."
							+ "checkIButtonIsClickable - Verify that the user is able to click on each (i) button."
							+ "checkPopUp - Verify that the when user is click on the (i) button, Day Count Difference Calculations popup is open and displayed to the user.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			String headerExpectedText = "Day Count Difference Calculations";

			// Create Dynamic Locator for Popup Header Text
			String headerLocator = IElementActions.createDynamicLocatorString(FundingInterestPaymentPO.popUpHeaderText,
					"locatorValue", headerExpectedText);

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Check the Visibility of Day count first I button
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.dayCountFirstIButtonsAfterLoan,
					"STEP1 : BUG: Day count first I button is not coming",
					"STEP1 : EXPECTED: Day count first I button is coming");

			// Calling clickIIcon function to open the popup
			FundingPage.clickIIcon(FundingInterestPaymentPO.dayCountFirstIButtonsAfterLoan);

			// Check the Visibility of Day count popup
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.popUp,
					"STEP2 : BUG: Day count popup is not coming", "STEP2 : EXPECTED: Day count popup is coming");

			// Get the Popup Header Text
			String popUpHeaderText = IElementActions.getElementText_usingXpath(node, driver, headerLocator);

			// Assert the Popup Header Text
			IElementActions.assertEquals_usingString(node, driver, popUpHeaderText, headerExpectedText,
					"STEP3 : BUG: Verification failed! The header text " + popUpHeaderText + " is not "
							+ headerExpectedText,
					"STEP3 : EXPECTED: Verification successful! The header text is " + headerExpectedText);

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDayCountIButton", "Pass", driver);

		} catch (AssertionError validateDayCountIButton) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDayCountIButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDayCountIButton_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDayCountIButton.printStackTrace();
			node.fail(validateDayCountIButton);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDayCountIButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDayCountIButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDayCountIButton_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDayCountIButton.printStackTrace();
			node.fail(validateDayCountIButton);
			Assert.fail();
			extent.flush();
		}
	}

//	TC_Funding_Interest _207
//	TC_Funding_Interest _208
//	TC_Funding_Interest _215
	@Test(priority = 37)
	public void validateDayCountPopupAndCloseButton() throws IOException {

		try {
			extenttest = extent.createTest(
					"checkPopupDetails - Verify that the user is able to see the following details on the 'Day Count Difference Calculations' popup: Last Month DCF, This Month DCF, Monthly Delta, Last Month Interest (Total), Day Count Calculation, X icon"
							+ "checkCloseButtonIsClickable - Verify that the user is able to click on the X icon."
							+ "checkPopUpClose - Verify that the user is able to close the 'Day Count Calculation popup while clicking on the X icon.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling clickIIcon function to open the popup
			FundingPage.clickIIcon(FundingInterestPaymentPO.dayCountFirstIButtonsAfterLoan);

			// Check the Visibility of Last Month DCF text
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.firstValue,
					"STEP1 : BUG: Last Month DCF text is not coming",
					"STEP1 : EXPECTED: Last Month DCF text is coming");

			// Check the Visibility of This Month DCF text
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.secondValue,
					"STEP2 : BUG: This Month DCF text is not coming",
					"STEP2 : EXPECTED: This Month DCF text is coming");

			// Check the Visibility of Monthly Delta text
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.thirdValue,
					"STEP3 : BUG: Monthly Delta text is not coming in popup",
					"STEP3 : EXPECTED: Monthly Delta text is coming in popup");

			// Check the Visibility of Last Month Interest text
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.fourthValue,
					"STEP4 : BUG: Last Month Interest text is not coming in popup",
					"STEP4 : EXPECTED: Last Month Interest text is coming in popup");

			// Check the Visibility of Day count Calculation text
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.fifthValue,
					"STEP5 : BUG: Day count Calculation text is not coming in popup",
					"STEP5 : EXPECTED: Day count Calculation text is coming in popup");

			// Check the Visibility of Close option
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.crossIcon,
					"STEP6 : BUG: Close option is not coming in popup",
					"STEP6 : EXPECTED: Close option is coming in popup");

			// Calling closePopUp function to close the popup
			FundingPage.closePopUp();

			// Assert the Popup is closed
			IElementActions.assertFalse_usingXpath(node, driver, FundingInterestPaymentPO.popUp,
					"STEP7 : BUG: Popup is not closed", "STEP7 : EXPECTED: Popup is closed");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDayCountPopupAndCloseButton", "Pass", driver);

		} catch (AssertionError validateDayCountPopupAndCloseButton) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDayCountPopupAndCloseButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDayCountPopupAndCloseButton_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDayCountPopupAndCloseButton.printStackTrace();
			node.fail(validateDayCountPopupAndCloseButton);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDayCountPopupAndCloseButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDayCountPopupAndCloseButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDayCountPopupAndCloseButton_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDayCountPopupAndCloseButton.printStackTrace();
			node.fail(validateDayCountPopupAndCloseButton);
			Assert.fail();
			extent.flush();
		}
	}

//	TC_Funding_Interest _209
//	TC_Funding_Interest _210
	@Test(priority = 38)
	public void validateDayCountPopupData() throws IOException {

		try {
			extenttest = extent.createTest(
					"LastMonth - Verify that the Last Month DCF value is matched with step 3 page Last Month DCF."
							+ "ThisMonth - Verify that the This Month DCF value is matched with step 3 page This Month DCF.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Get the Last Month DCF From Step3 Header
			String lastMonthDCFFromStep3Header = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.lastMonthDCFValueInStep3);

			// Get the This Month DCF From Step3 Header
			String thisMonthDCFFromStep3Header = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.thisMonthDCFValueInstep3);

			// Wait for the visibility of the day count Section
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the day count section");
			System.out.println("STEP1 : Waiting for the visibility of the day count section");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.dayCountSection);
			node.log(Status.INFO, "STEP2 : Day count section is visible");
			System.out.println("STEP2 : Day count section is visible");

			// Calling clickIIcon function to open the popup
			FundingPage.clickIIcon(FundingInterestPaymentPO.dayCountFirstIButtonsAfterLoan);

			// Get the Last Month DCF PopUp Value
			String lastMonthDCFPopUpValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.firstValue);

			// Get the This Month DCF PopUp Value
			String thisMonthDCFPopUpValue = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.secondValue);

			// Assert The day count Last Month value
			IElementActions.assertEquals_usingString(node, driver, lastMonthDCFFromStep3Header, lastMonthDCFPopUpValue,
					"STEP3 : BUG: Verification failed! The day count Last Month value in table "
							+ lastMonthDCFFromStep3Header + "is not equal to the value in popup "
							+ lastMonthDCFPopUpValue,
					"STEP3 : EXPECTED: Verification successful!The day count Last Month value in table "
							+ lastMonthDCFFromStep3Header + " is equal to the value in popup "
							+ lastMonthDCFPopUpValue);

			// Assert the day count This Month value
			IElementActions.assertEquals_usingString(node, driver, thisMonthDCFFromStep3Header, thisMonthDCFPopUpValue,
					"STEP4 : BUG: Verification failed! The day count This Month value in table "
							+ thisMonthDCFFromStep3Header + "is not equal to the value in popup "
							+ thisMonthDCFPopUpValue,
					"STEP4 : EXPECTED: Verification successful!The day count This Month value in table "
							+ thisMonthDCFFromStep3Header + " is equal to the value in popup "
							+ thisMonthDCFPopUpValue);

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDayCountPopupData", "Pass", driver);

		} catch (AssertionError validateDayCountPopupData) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDayCountPopupData test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDayCountPopupData_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDayCountPopupData.printStackTrace();
			node.fail(validateDayCountPopupData);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDayCountPopupData) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDayCountPopupData test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDayCountPopupData_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDayCountPopupData.printStackTrace();
			node.fail(validateDayCountPopupData);
			Assert.fail();
			extent.flush();
		}
	}

//TC_Funding_Interest _211
	@Test(priority = 39)
	public void validateMonthlyDeltaInDayCountPopup() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the Monthly Delta is calculated as per the below formula:\r\n"
							+ "% change in Last Month DCF and This Month DCF")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling clickIIcon function to open the popup
			FundingPage.clickIIcon(FundingInterestPaymentPO.dayCountFirstIButtonsAfterLoan);

			// Extract the values from the elements
			Double thisMonthValue = Utils.getTextAndParseToDouble(FundingInterestPaymentPO.firstValue);
			Double lastMonthValue = Utils.getTextAndParseToDouble(FundingInterestPaymentPO.secondValue);
			Double monthlyDeltaValue = Utils.getTextAndParseToDouble(FundingInterestPaymentPO.thirdValue);

			// Calculate the difference using the reusable function
			double difference = Utils.calculateDifference(lastMonthValue, thisMonthValue);

			// Calculate the Monthly Delta Value
			double expectedMonthlyDeltaValue = difference * 100;

			// Set the acceptable difference
			double acceptableDifference = Double.parseDouble(getDataFromExcel(10));

			// Perform assertion allowing for a difference around 5 with a delta parameter
			Assert.assertEquals(monthlyDeltaValue, expectedMonthlyDeltaValue, acceptableDifference,
					"Difference is greater than the acceptable range");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateMonthlyDeltaInDayCountPopup", "Pass", driver);

		} catch (AssertionError validateMonthlyDeltaInDayCountPopup) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateMonthlyDeltaInDayCountPopup test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateMonthlyDeltaInDayCountPopup_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMonthlyDeltaInDayCountPopup.printStackTrace();
			node.fail(validateMonthlyDeltaInDayCountPopup);
			Assert.fail();
			extent.flush();

		} catch (Exception validateMonthlyDeltaInDayCountPopup) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateMonthlyDeltaInDayCountPopup test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateMonthlyDeltaInDayCountPopup_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMonthlyDeltaInDayCountPopup.printStackTrace();
			node.fail(validateMonthlyDeltaInDayCountPopup);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest_213
	@Test(priority = 40)
	public void validateDayCountCalculation() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the Day Count Calculation is calculated as per the below formula:"
							+ "Monthly Delta * Last Month Interest (Total)")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling clickIIcon function to open the popup
			FundingPage.clickIIcon(FundingInterestPaymentPO.dayCountFirstIButtonsAfterLoan);

			// Get the Monthly Difference Value
			double monthlyDifferenceValue = Utils
					.getPercentageTextAndParseToDouble(FundingInterestPaymentPO.thirdValue);

			// Get the Last Month Interest Value
			int lastMonthInterestValue = Utils.getTextAndParseToInt(FundingInterestPaymentPO.fourthValue);

			// Get the Day Count Calculation Value
			Double dayCountCalculationValue = Utils.getTextAndParseToDouble(FundingInterestPaymentPO.fifthValue);

			// Get the Calculated Value
			double calculatedValue = monthlyDifferenceValue * lastMonthInterestValue;

			// Set the acceptable difference
			double acceptableDifference = Double.parseDouble(getDataFromExcel(10));

			// Perform assertion allowing for a difference around 5 with a delta parameter
			Assert.assertEquals(calculatedValue, dayCountCalculationValue, acceptableDifference,
					"Difference is greater than the acceptable range");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDayCountCalculation", "Pass", driver);

		} catch (AssertionError validateDayCountCalculation) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDayCountCalculation test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDayCountCalculation_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDayCountCalculation.printStackTrace();
			node.fail(validateDayCountCalculation);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDayCountCalculation) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDayCountCalculation test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDayCountCalculation_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDayCountCalculation.printStackTrace();
			node.fail(validateDayCountCalculation);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _214
	@Test(priority = 41)
	public void validateDayCountTableDataWithPopup() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the Day count calculated calculation is displayed on the Day count table and Day count figure value is same in both place.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Wait for the visibility of the day countSection
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the day count section");
			System.out.println("STEP1 : Waiting for the visibility of the day count section");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.dayCountSection);
			node.log(Status.INFO, "STEP2 : Day count section is visible");
			System.out.println("STEP2 : Day count section is visible");

			// Get the Day Count Calculation Value In Table
			String dayCountCalculationValueInTable = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.dayCountCalculationValueInTable);

			// Calling clickIIcon function to open the popup
			FundingPage.clickIIcon(FundingInterestPaymentPO.dayCountFirstIButtonsAfterLoan);

			// Get the Day Count Calculation Value In Popup
			String dayCountCalculationValueInPopUp = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.fifthValue);

			// Assert the day count Last Month value
			IElementActions.assertEquals_usingString(node, driver, dayCountCalculationValueInTable,
					dayCountCalculationValueInPopUp,
					"STEP3 : BUG: Verification failed! The day count Last Month value in table "
							+ dayCountCalculationValueInTable + "is not equal to the value in popup "
							+ dayCountCalculationValueInPopUp,
					"STEP3 : EXPECTED: Verification successful!The day count Last Month value in table "
							+ dayCountCalculationValueInTable + " is equal to the value in popup "
							+ dayCountCalculationValueInPopUp);

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDayCountTableDataWithPopup", "Pass", driver);

		} catch (AssertionError validateDayCountTableDataWithPopup) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDayCountTableDataWithPopup test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDayCountTableDataWithPopup_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDayCountTableDataWithPopup.printStackTrace();
			node.fail(validateDayCountTableDataWithPopup);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDayCountTableDataWithPopup) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDayCountTableDataWithPopup test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDayCountTableDataWithPopup_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDayCountTableDataWithPopup.printStackTrace();
			node.fail(validateDayCountTableDataWithPopup);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _216
	@Test(priority = 42)
	public void validateForecast() throws IOException {

		try {
			extenttest = extent.createTest("Verify that the Forecast is calculated as per the below formula:"
					+ "Prior Month Payment + Deferral column + Deployment column + Rate column + Day Count column")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the Page
			IElementActions.pageRefresh();

			int deviatedValue = Integer.parseInt(getDataFromExcel(10));

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Create dynamic locator for different tables
			String priorMonthPaymentTableLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.blueSingleColumnTable, "locatorValue",
					AllPagesData.priorMonthPaymentTableHeader);
			String deferralTableLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.blueSingleColumnTable, "locatorValue", AllPagesData.deferralTableHeader);
			String deploymentTableLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.blueSingleColumnTable, "locatorValue", AllPagesData.deploymentTableHeader);
			String rateTableLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.blueSingleColumnTable, "locatorValue", AllPagesData.rateTableHeader);
			String dayCountTableLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.blueSingleColumnTable, "locatorValue", AllPagesData.dayCountTableHeader);
			String forecastLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.forecastTableInStep3, "locatorValue", AllPagesData.forecastTableHeader);

			// Assuming each list corresponds to a column in a table
			List<WebElement> priorMonthPaymentValues = IElementActions.returnElements(node, driver,
					priorMonthPaymentTableLocator);

			// Get the List of WebElements
			List<WebElement> deferralTableLocatorValues = IElementActions.returnElements(node, driver,
					deferralTableLocator);

			// Get the List of WebElements
			List<WebElement> deploymentTableLocatorValues = IElementActions.returnElements(node, driver,
					deploymentTableLocator);

			// Get the List of WebElements
			List<WebElement> rateTableLocatorValues = IElementActions.returnElements(node, driver, rateTableLocator);

			// Get the List of WebElements
			List<WebElement> dayCountTableLocatorValues = IElementActions.returnElements(node, driver,
					dayCountTableLocator);

			// Get the List of WebElements
			List<WebElement> forecastValues = IElementActions.returnElements(node, driver, forecastLocator);

			// Add values index-wise
			for (int i = 0; i < forecastValues.size(); i++) {
				int priorMonthPayment = Utils.parseCurrencyValue(priorMonthPaymentValues.get(i).getText());
				int deferral = Utils.parseCurrencyValue(deferralTableLocatorValues.get(i).getText());
				int deployment = Utils.parseCurrencyValue(deploymentTableLocatorValues.get(i).getText());
				int rate = Utils.parseCurrencyValue(rateTableLocatorValues.get(i).getText());
				int dayCount = Utils.parseCurrencyValue(dayCountTableLocatorValues.get(i).getText());

				// Calculate the sum adjusting for negative values
				int sum = 0;

				sum = priorMonthPayment + deferral + deployment + rate + dayCount;

				// Get the Forecast Value
				int forecastValue = Utils.parseCurrencyValue(forecastValues.get(i).getText());

				// thirdListValues.add(forecastValue);
				node.log(Status.INFO, "Step1 - Sum is " + sum + " and forecast value " + forecastValue);
				System.out.println("Step1 - Sum is " + sum + " and forecast value " + forecastValue);

				int difference = Math.abs(sum - forecastValue);
				node.log(Status.INFO,
						"Step2 - Difference between actual and expected  Forecast value is " + difference);
				System.out.println("Step2 - Difference between actual and expected  Forecast value is " + difference);

				// TestNG assertion with deviation check
				Assert.assertTrue(difference <= deviatedValue,
						"Difference between actual and expected Forecast value is greater than " + deviatedValue
								+ " at index " + i + " is " + difference);
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateForecast", "Pass", driver);

		} catch (AssertionError validateForecast) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateForecast test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateForecast_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateForecast.printStackTrace();
			node.fail(validateForecast);
			Assert.fail();
			extent.flush();

		} catch (Exception validateForecast) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateForecast test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateForecast_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateForecast.printStackTrace();
			node.fail(validateForecast);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _217
	@Test(priority = 43)
	public void validateForecastDiff() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the Forecast Diff [Total] is calculated as per the below formula:"
							+ "This Month Payable - Forecast")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");
			// Deviation
			int deviatedValue = Integer.parseInt(getDataFromExcel(10));

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Create dynamic locator for different tables
			String forecastLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.forecastTableInStep3, "locatorValue", AllPagesData.forecastTableHeader);
			String forecastDiffLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.forecastTableInStep3, "locatorValue",
					AllPagesData.forecastDiffTotalTableHeader);
			String thisMonthPayableLoanAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.thisMonthPayableLoanAmount);

			// Get all web elements
			List<WebElement> thisMonthPayableValues = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.thisMonthPayableTable);
			List<WebElement> forecastValues = IElementActions.returnElements(node, driver, forecastLocator);
			List<WebElement> forecastDiffValues = IElementActions.returnElements(node, driver, forecastDiffLocator);

			// Calculate the sum adjusting for negative values
			int totalDiff = 0;

			// Check for total this month payable
			int totalThisMonthPayable = Utils.parseCurrencyValue(thisMonthPayableLoanAmount);
			node.log(Status.INFO, "Step1- Total this month payable is " + totalThisMonthPayable);
			System.out.println("Step1 - Total this month payable is " + totalThisMonthPayable);

			// Check for forecast Total Value
			int forecastTotalValue = Utils.parseCurrencyValue(forecastValues.get(0).getText());
			node.log(Status.INFO, "Step2- Forecast Total value is " + forecastTotalValue);
			System.out.println("Step2 - Forecast Total value is  " + forecastTotalValue);

			// Calling the calculateDifference from Utils
			totalDiff = Utils.calculateDifference(totalThisMonthPayable, forecastTotalValue);
			node.log(Status.INFO,
					"Step3- Calculated difference between Total this month payable and  Forecast Total is "
							+ totalDiff);
			System.out.println("Step3- Calculated difference between Total this month payable and  Forecast Total is  "
					+ totalDiff);

			// Check for forecast Diff Total Value
			int forecastDiffTotalValue = Utils.parseCurrencyValue(forecastDiffValues.get(0).getText());
			node.log(Status.INFO, "Step4- Forecast difference(total) total value is " + forecastDiffTotalValue);
			System.out.println("Step4 - Forecast difference(total) total value is  " + forecastDiffTotalValue);

			// Check Total Difference
			int totalDifference = Math.abs(totalDiff - forecastDiffTotalValue);
			node.log(Status.INFO,
					"Step5 - Difference between actual and expected  Forecast difference(total) total value is "
							+ totalDifference);
			System.out.println(
					"Step5 - Difference between actual and expected  Forecast difference(total) total value is "
							+ totalDifference);

			int checkAllElements = 0;

			// Add values index-wise
			for (int i = 0; i < forecastValues.size() - 1; i++) {

				int diff = 0;

				// Check for This month payable
				int thisMonthPayable = Utils.parseCurrencyValue(thisMonthPayableValues.get(i).getText());
				node.log(Status.INFO, "Step1- This month payable is " + thisMonthPayable);
				System.out.println("Step1 - This month payable is " + thisMonthPayable);

				// Check for Forecast value
				int forecast = Utils.parseCurrencyValue(forecastValues.get(i + 1).getText());
				node.log(Status.INFO, "Step2- Forecast value is " + forecast);
				System.out.println("Step2 - Forecast value is  " + forecast);

				// Calling the calculateDifference from Utils
				diff = Utils.calculateDifference(thisMonthPayable, forecast);
				node.log(Status.INFO, "Step3- Calculated This month payable and Forecast difference is " + diff);
				System.out.println("Step3- Calculated This month payable and Forecast difference is " + diff);

				// Check for Forecast difference total value
				int forecastDiffValue = Utils.parseCurrencyValue(forecastDiffValues.get(i + 1).getText());
				node.log(Status.INFO, "Step4- Forecast difference total value is " + forecastDiffValue);
				System.out.println("Step4 - Forecast difference total value is  " + forecastDiffValue);

				int difference = Math.abs(diff - forecastDiffValue);
				node.log(Status.INFO,
						"Step5 - Difference between actual and expected  Forecast difference total value is "
								+ difference);
				System.out.println("Step5 - Difference between actual and expected  Forecast difference total value is "
						+ difference);

				if (difference > deviatedValue) {
					checkAllElements++;
				}
			}

			// TestNG assertion with deviation check
			Assert.assertTrue(totalDifference <= deviatedValue, "Deviation for the total is " + totalDifference);

			// Print the result
			if (checkAllElements == 0) {

				Assert.assertTrue(true, "All values are correct");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateForecastDiff", "Pass", driver);
			} else {

				Assert.assertTrue(false,
						"Difference between actual and expected Forecast difference total value is greater than "
								+ deviatedValue + " for " + checkAllElements + " elements");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateForecastDiff", "Fail", driver);
			}

		} catch (AssertionError validateForecastDiff) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateForecastDiff test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateForecastDiff_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateForecastDiff.printStackTrace();
			node.fail(validateForecastDiff);
			Assert.fail();
			extent.flush();

		} catch (Exception validateForecastDiff) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateForecastDiff test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateForecastDiff_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateForecastDiff.printStackTrace();
			node.fail(validateForecastDiff);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _218
	@Test(priority = 44)
	public void validateForecastDiffPercentage() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the Forecast Diff(%) is calculated as per the below formula:\r\n"
							+ "100 * ((Forecast Diff (Total))/(This Month Payable))")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Get this Month Payable Loan Amount
			String thisMonthPayableLoanAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.thisMonthPayableLoanAmount);

			// Create dynamic locator for different tables
			String forecastDiffLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.forecastTableInStep3, "locatorValue",
					AllPagesData.forecastDiffTotalTableHeader);
			String forecastDiffPercentageLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.forecastTableInStep3, "locatorValue",
					AllPagesData.forecastDiffPercentageTableHeader);

			// Get all web elements
			List<WebElement> thisMonthPayableValues = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.thisMonthPayableTable);
			List<WebElement> forecastDiffValues = IElementActions.returnElements(node, driver, forecastDiffLocator);
			List<WebElement> forecastDiffPercentageValues = IElementActions.returnElements(node, driver,
					forecastDiffPercentageLocator);

			// Format the result to one decimal place
			DecimalFormat df = new DecimalFormat("#.#");

			// Deviation
			int deviatedValue = Integer.parseInt(getDataFromExcel(10));

			// Check for Total this month payable
			int totalThisMonthPayable = Utils.parseCurrencyValue(thisMonthPayableLoanAmount);
			node.log(Status.INFO, "Step1- Total this month payable is " + totalThisMonthPayable);
			System.out.println("Step1 - Total this month payable is " + totalThisMonthPayable);

			// Check for Total Forecast diff total value
			int totalForecastDiffValue = Utils.parseCurrencyValue(forecastDiffValues.get(0).getText());
			node.log(Status.INFO, "Step2-Total Forecast diff total value is " + totalForecastDiffValue);
			System.out.println("Step2 - Total Forecast diff total value is  " + totalForecastDiffValue);

			double totalResult = 0;
			// Check if the divisor is not zero to avoid division by zero
			if (totalThisMonthPayable != 0L) {
				// Perform division
				totalResult = ((double) totalForecastDiffValue / totalThisMonthPayable) * 100;

				totalResult = Double.parseDouble(df.format(totalResult));

				// Print the result
				node.log(Status.INFO, "STEP-01 : Total Forecast diff percentage calculated value is " + totalResult);
				System.out.println("STEP-01 : Total Forecast diff percentage calculated value is " + totalResult);

			} else {
				node.log(Status.FAIL, "Error: Division by zero is not allowed.");
				System.out.println("Error: Division by zero is not allowed.");
			}

			// Check for Forecast difference percentage total value
			double forecastDiffPercentageTotalValue = Utils
					.parseCurrencyValueToDouble(forecastDiffPercentageValues.get(0).getText());
			node.log(Status.INFO,
					"Step4- Forecast difference percentage total value is " + forecastDiffPercentageTotalValue);
			System.out.println(
					"Step4 - Forecast difference percentage total value is  " + forecastDiffPercentageTotalValue);

			// Calling the calculateDifference from Utils
			double totalDifference = Utils.calculateDifference(totalResult, forecastDiffPercentageTotalValue);
			node.log(Status.INFO,
					"Step5 - Difference between actual and expected  Forecast difference percentage total value is "
							+ totalDifference);
			System.out.println(
					"Step5 - Difference between actual and expected  Forecast difference percentage total value is "
							+ totalDifference);

			int checkAllElements = 0;

			// Add values index-wise
			for (int i = 0; i < forecastDiffValues.size() - 1; i++) {

				// Check for This month payable
				int thisMonthPayable = Utils.parseCurrencyValue(thisMonthPayableValues.get(i).getText());
				node.log(Status.INFO, "Step1- This month payable is " + thisMonthPayable);
				System.out.println("Step1 - This month payable is " + thisMonthPayable);

				// Check for Forecast diff value
				int forecastDiff = Utils.parseCurrencyValue(forecastDiffValues.get(i + 1).getText());
				node.log(Status.INFO, "Step2- Forecast diff value is " + forecastDiff);
				System.out.println("Step2 - Forecast diff value is  " + forecastDiff);

				double result = 0.0;
				// Check if the divisor is not zero to avoid division by zero
				if (thisMonthPayable != 0L) {
					// Perform division

					result = ((double) forecastDiff / thisMonthPayable) * 100;

					result = Double.parseDouble(df.format(result));

					// Print the result
					node.log(Status.INFO, "STEP-01 : Forecast diff percentage calculated value is " + result);
					System.out.println("STEP-01 : Forecast diff percentage calculated value is " + result);

				} else {
					node.log(Status.INFO, "Error: Division by zero is not allowed.");
					System.out.println("Error: Division by zero is not allowed.");
				}

				// Get the Forecast difference percentage value
				double forecastDiffPercentageValue = Utils
						.parseCurrencyValueToDouble(forecastDiffPercentageValues.get(i + 1).getText());
				node.log(Status.INFO, "Step4- Forecast difference percentage value is " + forecastDiffPercentageValue);
				System.out.println("Step4 - Forecast difference percentage value is  " + forecastDiffPercentageValue);

				// Calling the calculateDifference From Utils
				double difference = Utils.calculateDifference(result, forecastDiffPercentageValue);
				node.log(Status.INFO,
						"Step5 - Difference between actual and expected  Forecast difference percentage value is "
								+ difference);
				System.out.println(
						"Step5 - Difference between actual and expected  Forecast difference percentage value is "
								+ difference);

				if (difference > deviatedValue) {
					checkAllElements++;
				}
			}

			// TestNG assertion with deviation check
			Assert.assertTrue(totalDifference <= deviatedValue, "Deviation for the loan is " + totalDifference);

			// Print the result
			if (checkAllElements == 0) {

				Assert.assertTrue(true, "All values are correct");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateForecastDiffPercentage", "Pass", driver);
			} else {

				Assert.assertTrue(false,
						"Difference between actual and expected Forecast difference percentage value is greater than "
								+ deviatedValue + " for " + checkAllElements + " elements");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateForecastDiffPercentage", "Fail", driver);
			}

		} catch (AssertionError validateForecastDiffPercentage) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateForecastDiffPercentage test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateForecastDiffPercentage_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateForecastDiffPercentage.printStackTrace();
			node.fail(validateForecastDiffPercentage);
			Assert.fail();
			extent.flush();

		} catch (Exception validateForecastDiffPercentage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateForecastDiffPercentage test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateForecastDiffPercentage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateForecastDiffPercentage.printStackTrace();
			node.fail(validateForecastDiffPercentage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _219
	// TC_Funding_Interest _220
	@Test(priority = 45)
	public void validateForecastTolerance() throws IOException {

		try {
			extenttest = extent.createTest(
					"VerifyIfExceeds - Verify that the Forecast Diff (%) is highlighted in red if the forecast tolerance exceeds the set Difference Tolerance (currently set at 2%)."
							+ "VerifyIfNotExceeds - Verify that the Forecast Diff (%) is not highlighted in red if the forecast tolerance does not exceed the set Difference Tolerance.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Create dynamic locator for different tables
			String forecastDiffPercentageLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.forecastTableInStep3, "locatorValue",
					AllPagesData.forecastDiffPercentageTableHeader);

			// Get the Difference tolerance value
			double differenceToleranceValue = Utils
					.getTextAndParseToDouble(FundingInterestPaymentPO.differenceToleranceValue);
			node.log(Status.INFO, "Step1- Difference tolerance value is " + differenceToleranceValue);
			System.out.println("Step1 - Difference tolerance value is " + differenceToleranceValue);

			// Get the List of WebElement
			List<WebElement> forecastDiffPercentageElements = IElementActions.returnElements(node, driver,
					forecastDiffPercentageLocator);

			int failCount = 0;
			// Iterate through each Forecast Diff (%) element
			for (WebElement forecastDiffPercentageElement : forecastDiffPercentageElements) {
				// Get the text of the Forecast Diff (%)
				String forecastDiffPercentageText = forecastDiffPercentageElement.getText();

				// Parse the forecast diff percentage as a double
				double forecastDiffPercentage = Double.parseDouble(forecastDiffPercentageText.replace("%", ""));
				System.out.println("Step2 - Forecast Diff Percentage value is " + forecastDiffPercentage);
				node.log(Status.INFO, "Step2 - Forecast Diff Percentage value is " + forecastDiffPercentage);

				// get class attribute
				String elementAttribute = forecastDiffPercentageElement.getAttribute("class");

				// Verify if the forecast diff exceeds the set Difference Tolerance
				if (forecastDiffPercentage > differenceToleranceValue) {

					// Check if the element has the red class
					if (forecastDiffPercentageElement.getAttribute("class").contains("current-amount-p2")) {

						node.log(Status.INFO,
								"Forecast Diff (%) " + forecastDiffPercentage + " is highlighted in red, as expected.");
						System.out.println(
								"Forecast Diff (%) " + forecastDiffPercentage + " is highlighted in red, as expected.");
					} else {
						node.log(Status.INFO, "Forecast Diff (%) " + forecastDiffPercentage
								+ " does not have the expected red highlighting.");
						System.out.println("Forecast Diff (%) " + forecastDiffPercentage
								+ " does not have the expected red highlighting.");
						failCount++;
					}
				} else {

					// Check if the element has the non-red class
					if (forecastDiffPercentageElement.getAttribute("class").contains("current-amount-p")) {
						node.log(Status.INFO, "Forecast Diff (%) " + forecastDiffPercentage
								+ " within set tolerance, no red highlighting.");
						System.out.println("Forecast Diff (%) " + forecastDiffPercentage
								+ " within set tolerance, no red highlighting.");
					} else {
						node.log(Status.INFO, "Unexpected class " + elementAttribute + " found for Forecast Diff (%). "
								+ forecastDiffPercentage);
						System.out.println("Unexpected class " + elementAttribute + " found for Forecast Diff (%). "
								+ forecastDiffPercentage);
						failCount++;
					}
				}
			}

			// Print the result
			if (failCount == 0) {
				Assert.assertTrue(true, "All values are correct");
			} else {
				Assert.assertTrue(false, " Forecast Diff (%) color is not correct for " + failCount + " elements");
			}

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateForecastDiffPercentage", "Pass", driver);

		} catch (AssertionError validateForecastDiffPercentage) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateForecastDiffPercentage test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateForecastDiffPercentage_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateForecastDiffPercentage.printStackTrace();
			node.fail(validateForecastDiffPercentage);
			Assert.fail();
			extent.flush();

		} catch (Exception validateForecastDiffPercentage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateForecastDiffPercentage test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateForecastDiffPercentage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateForecastDiffPercentage.printStackTrace();
			node.fail(validateForecastDiffPercentage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _221
	@Test(priority = 46)
	public void validateBackAndNextStepButtonVisibilityInStep3() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user is able to see the Back step and Next step button on the step-3 page.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Refresh the page
			IElementActions.pageRefresh();

			// Calling loadInterestPaymentPageAndNavigateToStep3 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Scrolled Down to Bottom of the Page
			IElementActions.scrollToBottom(driver);
			System.out.println("STEP1 : Scrolled Down to Bottom of the Page");
			node.log(Status.INFO, "STEP1 : Scrolled Down to Bottom of the Page");

			// Check the visibility of Back Step Button
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.backStepButton,
					"STEP2 : BUG: The Back Step Button is not coming in Step3",
					"STEP2 : EXPECTED: The Back Step Button is coming in in Step3");

			// Check the visibility of Next Step Button
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.nextStepButton,
					"STEP3 : BUG: The Next Step Button is not coming in Step3",
					"STEP3 : EXPECTED: The Next Step Button is coming in Step3");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateBackAndNextStepButtonVisibilityInStep3", "Pass", driver);

		} catch (AssertionError validateBackAndNextStepButtonVisibilityInStep3) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateBackAndNextStepButtonVisibilityInStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBackAndNextStepButtonVisibilityInStep3_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBackAndNextStepButtonVisibilityInStep3.printStackTrace();
			node.fail(validateBackAndNextStepButtonVisibilityInStep3);
			Assert.fail();
			extent.flush();

		} catch (Exception validateBackAndNextStepButtonVisibilityInStep3) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateBackAndNextStepButtonVisibilityInStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBackAndNextStepButtonVisibilityInStep3_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBackAndNextStepButtonVisibilityInStep3.printStackTrace();
			node.fail(validateBackAndNextStepButtonVisibilityInStep3);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _222
	@Test(priority = 47)
	public void validateBackAndNextStepButtonInStep3() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user is able to click on  the Back step and Next step button on the step-3 page.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function from Funding Page
			// to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the bottomBackStepButton function from Funding Page
			FundingPage.bottomBackStepButton(FundingInterestPaymentPO.backStepButton, 3, "Month on Month Comparison");

			// Check if the 'step--current' is present in the class attribute
			boolean step2IsHighlighted = IElementActions
					.checkAttributePresentInClass(FundingInterestPaymentPO.healthStep, "step--current");

			// Assert that user is Redirected to Previous Step
			IElementActions.assertTrue_usingboolean(node, driver, step2IsHighlighted,
					"STEP1 : BUG: After clicked on Back Step Button User is not redirected to Step2 i.e.Health",
					"STEP1 : PASS : After clicked on Back Step Button User is redirected to Step2 i.e.Health");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function from Funding Page
			// to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the bottomNextStepButton function from Funding Page
			FundingPage.bottomNextStepButton(FundingInterestPaymentPO.nextStepButton, 3, "Month on Month Comparison");

			// Check if the 'step--current' is present in the class attribute
			boolean step4IsHighlighted = IElementActions
					.checkAttributePresentInClass(FundingInterestPaymentPO.returnAnalysisStep, "step--current");

			// Assert that user is Redirected to Next Step
			IElementActions.assertTrue_usingboolean(node, driver, step4IsHighlighted,
					"STEP2 : BUG: After clicked on Next Step Button User is not redirected to Step4 i.e.Return Analysis",
					"STEP2 : PASS : After clicked on Next Step Button User is redirected to Step4 i.e.Return Analysis");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateBackAndNextStepButtonInStep3", "Pass", driver);

		} catch (AssertionError validateBackAndNextStepButtonInStep3) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateBackAndNextStepButtonInStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBackAndNextStepButtonInStep3_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBackAndNextStepButtonInStep3.printStackTrace();
			node.fail(validateBackAndNextStepButtonInStep3);
			Assert.fail();
			extent.flush();

		} catch (Exception validateBackAndNextStepButtonInStep3) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateBackAndNextStepButtonInStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBackAndNextStepButtonInStep3_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBackAndNextStepButtonInStep3.printStackTrace();
			node.fail(validateBackAndNextStepButtonInStep3);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _223
	@Test(priority = 48)
	public void validateBackStepButtonInStep3() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the when user is click on the Back step button, the user is navigate to step-2")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function from Funding Page
			// to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the bottomBackStepButton function from Funding Page
			FundingPage.bottomBackStepButton(FundingInterestPaymentPO.backStepButton, 3, "Month on Month Comparison");

			// Check if the 'step--current' is present in the class attribute
			boolean step2IsHighlighted = IElementActions
					.checkAttributePresentInClass(FundingInterestPaymentPO.healthStep, "step--current");

			// Assert that user is Redirected to Previous Step
			IElementActions.assertTrue_usingboolean(node, driver, step2IsHighlighted,
					"STEP1 : BUG: After clicked on Back Step Button User is not redirected to Step2 i.e.Health",
					"STEP1 : PASS : After clicked on Back Step Button User is redirected to Step2 i.e.Health");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateBackStepButtonInStep3", "Pass", driver);

		} catch (AssertionError validateBackStepButtonInStep3) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateBackStepButtonInStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBackStepButtonInStep3_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBackStepButtonInStep3.printStackTrace();
			node.fail(validateBackStepButtonInStep3);
			Assert.fail();
			extent.flush();

		} catch (Exception validateBackStepButtonInStep3) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateBackStepButtonInStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateBackStepButtonInStep3_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBackStepButtonInStep3.printStackTrace();
			node.fail(validateBackStepButtonInStep3);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _224
	@Test(priority = 49)
	public void validateNextStepButtonInStep3() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the when user is click on the Next step button, the user is navigate to the next step(step-4)")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep3 function from Funding Page
			// to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep3(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the bottomNextStepButton function from Funding Page
			FundingPage.bottomNextStepButton(FundingInterestPaymentPO.nextStepButton, 3, "Month on Month Comparison");

			// Check if the 'step--current' is present in the class attribute
			boolean step4IsHighlighted = IElementActions
					.checkAttributePresentInClass(FundingInterestPaymentPO.returnAnalysisStep, "step--current");

			// Assert that user is Redirected to Next Step
			IElementActions.assertTrue_usingboolean(node, driver, step4IsHighlighted,
					"STEP1 : BUG: After clicked on Next Step Button User is not redirected to Step4 i.e.Return Analysis",
					"STEP1 : PASS : After clicked on Next Step Button User is redirected to Step4 i.e.Return Analysis");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateNextStepButtonInStep3", "Pass", driver);

		} catch (AssertionError validateNextStepButtonInStep3) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNextStepButtonInStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNextStepButtonInStep3_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNextStepButtonInStep3.printStackTrace();
			node.fail(validateNextStepButtonInStep3);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateNextStepButtonInStep3) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNextStepButtonInStep3 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNextStepButtonInStep3_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNextStepButtonInStep3.printStackTrace();
			node.fail(validateNextStepButtonInStep3);
			Assert.fail();
			extent.flush();

			// TODO: handle exception
		}

	}

}
