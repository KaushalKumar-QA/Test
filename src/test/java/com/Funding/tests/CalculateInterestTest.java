package com.Funding.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.locators.allPages.FundingCalculateInterestPO;
import com.locators.allPages.SideMenuPO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.url.AllPagesUrl;
import com.qa.utils.FundingPage;
import com.qa.utils.LoginPage;
import com.qa.utils.Utils;

public class CalculateInterestTest extends Baseclass {

	@Test(priority = 1)
	public void validateCalculateInterestPageVisibility() throws IOException {
		try {
			extenttest = extent
					.createTest(
							"Verify that the user can access the Calculate Interest menu from the side menu options.")
					.assignCategory(fundingCalculateInterest_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			// Call the userLoginProcess function from the utils login
			LoginPage.userLoginProcess(node, driver, getDataFromExcel(1), getDataFromExcel(2));

			// Click on the funding
			Utils.clickOnMenu(node, driver, SideMenuPO.funding);

			// Click on the calculate interest
			Utils.clickOnMenu(node, driver, SideMenuPO.calculateInterest);

			// Wait for the visibility of the button
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the page");
			System.out.println("STEP1 : Waiting for the visibility of the page");
			IWaitStrategy.waitForVisiblity(node, driver, FundingCalculateInterestPO.runScriptButton);
			node.log(Status.INFO, "STEP2 : Page is visible");
			System.out.println("STEP2 : Page is visible");

			Thread.sleep(2000);
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			// Assert that Calculate Interest page is visible
			System.out.println("STEP3 : Asserting that Calculate Interest page is visible");
			node.log(Status.INFO, "STEP3 : Asserting that Calculate Interest page is visible");

			Utils.validateUrl(node, driver, currentUrl, AllPagesUrl.calculateInterestPage,
					"validateCalculateInterestPageVisibility");

		} catch (AssertionError validateCalculateInterestPageVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCalculateInterestPageVisibility test in CalculateInterestTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCalculateInterestPageVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCalculateInterestPageVisibility.printStackTrace();
			node.fail(validateCalculateInterestPageVisibility);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateCalculateInterestPageVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCalculateInterestPageVisibility test in CalculateInterestTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCalculateInterestPageVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCalculateInterestPageVisibility.printStackTrace();
			node.fail(validateCalculateInterestPageVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	@Test(priority = 2)
	public void validateCalculateInterestPageSections() throws IOException {
		try {
			extenttest = extent.createTest("Verify the sections under the Calculate Interest page")
					.assignCategory(fundingCalculateInterest_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadCalculateInterestPage function from the FundingPage
			FundingPage.loadCalculateInterestPage();

			// Verify the section in Calculate Interest page
			node.log(Status.INFO, "STEP1 : Verify the section");
			System.out.println("STEP1 : Verify the section");

			IElementActions.assertTrue_usingXpath(node, driver, FundingCalculateInterestPO.runScriptButton,
					"STEP2 : BUG: Run script button is not coming on Calculate Interest page",
					"STEP2 : EXPECTED: Run script button is coming on Calculate Interest page");
			IElementActions.assertTrue_usingXpath(node, driver, FundingCalculateInterestPO.date,
					"STEP3 : BUG: Date is not coming on Calculate Interest page",
					"STEP3 : EXPECTED: Date is coming on Calculate Interest page");
			IElementActions.assertTrue_usingXpath(node, driver, FundingCalculateInterestPO.selectedDate,
					"STEP4 : BUG: Select Date is not coming on Calculate Interest page",
					"STEP4 : EXPECTED: Select Date is coming on Calculate Interest page");
			IElementActions.assertTrue_usingXpath(node, driver, FundingCalculateInterestPO.launchDate,
					"STEP5 : BUG: Launch Date is not coming on Calculate Interest page",
					"STEP5 : EXPECTED:  Launch Date is coming on Calculate Interest page");
			IElementActions.assertTrue_usingXpath(node, driver, FundingCalculateInterestPO.customDate,
					"STEP6 : BUG:  Custom Date is not coming on Calculate Interest page",
					"STEP6 : EXPECTED:  Custom Date is coming on Calculate Interest page");
			IElementActions.assertTrue_usingXpath(node, driver, FundingCalculateInterestPO.scheduled,
					"STEP7 : BUG: Scheduled is not coming on Calculate Interest page",
					"STEP7 : EXPECTED: Scheduled is coming on Calculate Interest page");
			IElementActions.assertTrue_usingXpath(node, driver, FundingCalculateInterestPO.status,
					"STEP8 : BUG: Status is not coming on Calculate Interest page",
					"STEP8 : EXPECTED: Status is coming on Calculate Interest page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCalculateInterestPageSections", "Pass", driver);

		} catch (AssertionError validateCalculateInterestPageSections) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCalculateInterestPageSections test in CalculateInterestTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCalculateInterestPageSections_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCalculateInterestPageSections.printStackTrace();
			node.fail(validateCalculateInterestPageSections);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateCalculateInterestPageSections) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCalculateInterestPageSections test in CalculateInterestTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCalculateInterestPageSections_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCalculateInterestPageSections.printStackTrace();
			node.fail(validateCalculateInterestPageSections);
			Assert.fail();
			extent.flush();
		}
	}

	@Test(priority = 3)
	public void validateLaunchDateSorting() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify the table displaying all calculated interest runs sorted by Launch Date in reverse chronological order")
					.assignCategory(fundingCalculateInterest_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadCalculateInterestPage function from the FundingPage
			FundingPage.loadCalculateInterestPage();

			// Verify the sorting in lauch date
			node.log(Status.INFO, "STEP1 : Verify the sorting order");
			System.out.println("STEP1 : Verify the sorting order");

			Utils.validateDateSorting(node, driver, FundingCalculateInterestPO.launchDateValues, "descending",
					"validateLaunchDateSorting", "dd/MM/yyyy HH:mm", "LocalDateTime");

		} catch (AssertionError validateLaunchDateSorting) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLaunchDateSorting test in CalculateInterestTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLaunchDateSorting_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLaunchDateSorting.printStackTrace();
			node.fail(validateLaunchDateSorting);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateLaunchDateSorting) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLaunchDateSorting test in CalculateInterestTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLaunchDateSorting_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLaunchDateSorting.printStackTrace();
			node.fail(validateLaunchDateSorting);
			Assert.fail();
			extent.flush();
		}
	}

	@Test(priority = 4)
	public void validateRunScriptWithoutSelectingDate() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify the data if the user doesn't select a date from the dropdown, or selects the current date")
					.assignCategory(fundingCalculateInterest_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadCalculateInterestPage function from the FundingPage
			FundingPage.loadCalculateInterestPage();

			// Click on the RunScript
			IElementActions.clickelement_usingXpath(node, driver, FundingCalculateInterestPO.runScriptButton);
			node.log(Status.INFO, "STEP1 : clicked on the RunScript");
			System.out.println("STEP1 : clicked on the RunScript");

			// Wait for the visibility of the entry
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the record");
			System.out.println("STEP2 : Waiting for the visibility of the record");
			IWaitStrategy.waitForVisiblity(node, driver, FundingCalculateInterestPO.firstRecordStatusInProgress);
			node.log(Status.INFO, "STEP3 : Record is visible");
			System.out.println("STEP3 : Record is visible");

			// Verify the section in Calculate Interest page
			node.log(Status.INFO, "STEP4 : Verify the records");
			System.out.println("STEP4 : Verify the records");

			IElementActions.assertTrue_usingXpath(extenttest, driver, FundingCalculateInterestPO.firstRecordlaunchDate,
					"STEP5 : BUG: Launch Date is not coming on Calculate Interest page",
					"STEP5 : EXPECTED:  Launch Date is coming on Calculate Interest page");
			IElementActions.assertTrue_usingXpath(extenttest, driver, FundingCalculateInterestPO.firstRecordScheduled,
					"STEP6 : BUG: Scheduled is not coming on Calculate Interest page",
					"STEP6 : EXPECTED: Scheduled is coming on Calculate Interest page");
			IElementActions.assertTrue_usingXpath(extenttest, driver,
					FundingCalculateInterestPO.firstRecordStatusInProgress,
					"STEP7 : BUG: Status is not coming on Calculate Interest page",
					"STEP7 : EXPECTED: Status is coming on Calculate Interest page");

			IElementActions.assertEquals_usingString(node, driver,
					IElementActions.getElementText_usingXpath(node, driver,
							FundingCalculateInterestPO.firstRecordCustomDate),
					"NO", "STEP8 : BUG: 'NO' is not displayed in the CustomDate",
					"STEP8 : EXPECTED: 'NO' is displayed in the CustomDate");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateRunScriptWithoutSelectingDate", "Pass", driver);

		} catch (AssertionError validateRunScriptWithoutSelectingDate) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateRunScriptWithoutSelectingDate test in CalculateInterestTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRunScriptWithoutSelectingDate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRunScriptWithoutSelectingDate.printStackTrace();
			node.fail(validateRunScriptWithoutSelectingDate);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateRunScriptWithoutSelectingDate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateRunScriptWithoutSelectingDate test in CalculateInterestTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRunScriptWithoutSelectingDate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRunScriptWithoutSelectingDate.printStackTrace();
			node.fail(validateRunScriptWithoutSelectingDate);
			Assert.fail();
			extent.flush();
		}
	}

	@Test(priority = 5)
	public void validateCalenderOpening() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that if the user clicks the date dropdown, a calendar is displayed where the user can select a date if they choose")
					.assignCategory(fundingCalculateInterest_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadCalculateInterestPage function from the FundingPage
			FundingPage.loadCalculateInterestPage();

			// Click on the RunScript
			IElementActions.clickelement_usingXpath(node, driver, FundingCalculateInterestPO.date);
			node.log(Status.INFO, "STEP1 : clicked on the date");
			System.out.println("STEP1 : clicked on the date");

			// Wait for the visibility of the entry
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the calender popup");
			System.out.println("STEP2 : Waiting for the visibility of the calender popup");
			IWaitStrategy.waitForVisiblity(node, driver, FundingCalculateInterestPO.calenderMonth);
			node.log(Status.INFO, "STEP3 : Calender popup is visible");
			System.out.println("STEP3 : Calender popup is visible");

			// Verify the section in Calculate Interest page
			node.log(Status.INFO, "STEP4 : Verify the calender popup");
			System.out.println("STEP4 : Verify the calender popup");

			IElementActions.assertTrue_usingXpath(extenttest, driver, FundingCalculateInterestPO.calenderMonth,
					"STEP5 : BUG: Calender popup is not visible", "STEP5 : EXPECTED: Calender popup is visible");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCalenderOpening", "Pass", driver);

		} catch (AssertionError validateCalenderOpening) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCalenderOpening test in CalculateInterestTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCalenderOpening_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCalenderOpening.printStackTrace();
			node.fail(validateCalenderOpening);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateCalenderOpening) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCalenderOpening test in CalculateInterestTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCalenderOpening_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCalenderOpening.printStackTrace();
			node.fail(validateCalenderOpening);
			Assert.fail();
			extent.flush();
		}
	}

	@Test(priority = 6)
	public void validateCalenderFutureDate() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user clicks the date dropdown, future dates are not available for selection")
					.assignCategory(fundingCalculateInterest_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadCalculateInterestPage function from the FundingPage
			FundingPage.loadCalculateInterestPage();

			IElementActions.pageRefresh();

			Thread.sleep(5000);

			// Wait for the visibility of the entry
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the date");
			System.out.println("STEP1 : Waiting for the visibility of the date");
			IWaitStrategy.waitForVisiblity(node, driver, FundingCalculateInterestPO.date);
			node.log(Status.INFO, "STEP2 : Date is visible");
			System.out.println("STEP2 : Date popup is visible");

			// Click on the date
			IElementActions.clickelement_usingXpath(node, driver, FundingCalculateInterestPO.date);
			node.log(Status.INFO, "STEP3 : clicked on the date");
			System.out.println("STEP3 : clicked on the date");

			// Wait for the visibility of the entry
			node.log(Status.INFO, "STEP4 : Waiting for the visibility of the calender popup");
			System.out.println("STEP4 : Waiting for the visibility of the calender popup");
			IWaitStrategy.waitForVisiblity(node, driver, FundingCalculateInterestPO.calenderMonth);
			node.log(Status.INFO, "STEP5 : Calender popup is visible");
			System.out.println("STEP5 : Calender popup is visible");

			// Verify the section in Calculate Interest page
			node.log(Status.INFO, "STEP6 : Verify that the future dates are not available for selection");
			System.out.println("STEP6 : Verify that the future dates are not available for selection");

			String formattedDate = Utils.getTomorrowDateFormatted();

			String futureDateElement = IElementActions.createDynamicLocatorString(FundingCalculateInterestPO.futureDate,
					"locatorValue", formattedDate);

			// Check if the 'disabled' class is present in the class attribute
			boolean isDisabled = IElementActions.checkAttributePresentInClass(futureDateElement, "disabled");

			// Print the result
			if (isDisabled) {
				System.out.println("SUB-STEP_0.001 :The future date is disabled.");
				node.log(Status.INFO, "SUB-STEP_0.001 :The future date is disabled.");

				Assert.assertTrue(true, "The future date is disabled.");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateCalenderFutureDate", "Pass", driver);
			} else {
				System.out.println("SUB-STEP_0.001 :The future date is enabled.");
				node.log(Status.INFO, "SUB-STEP_0.001 :The future date is enabled.");

				Assert.assertTrue(false, "The future date is enabled.");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateCalenderFutureDate", "Fail", driver);
			}

		} catch (AssertionError validateCalenderFutureDate) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCalenderFutureDate test in CalculateInterestTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCalenderFutureDate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCalenderFutureDate.printStackTrace();
			node.fail(validateCalenderFutureDate);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateCalenderFutureDate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCalenderFutureDate test in CalculateInterestTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCalenderFutureDate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCalenderFutureDate.printStackTrace();
			node.fail(validateCalenderFutureDate);
			Assert.fail();
			extent.flush();
		}
	}

}
