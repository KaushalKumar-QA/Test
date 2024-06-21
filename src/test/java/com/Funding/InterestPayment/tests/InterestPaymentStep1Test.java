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
import com.locators.allPages.FundingInterestPaymentPO;
import com.locators.allPages.ReportingUpdatesPO;
import com.locators.allPages.SideMenuPO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.url.AllPagesUrl;
import com.qa.utils.FundingPage;
import com.qa.utils.LoginPage;
import com.qa.utils.Utils;

public class InterestPaymentStep1Test extends Baseclass {

	// TC_Funding_Interest _001
	@Test(priority = 1)
	public void validateInterestPaymentPageVisibility() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the user can access the Interest menu from the side menu options.")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			// Calling the userLoginProcess function from the LoginPage
			LoginPage.userLoginProcess(node, driver, getDataFromExcel(1), getDataFromExcel(2));

			// Click on the funding
			Utils.clickOnMenu(node, driver, SideMenuPO.funding);

			// Click on the interestPayment
			Utils.clickOnMenu(node, driver, SideMenuPO.interestPayment);

			// Wait for the visibility of the compile
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the page");
			System.out.println("STEP1 : Waiting for the visibility of the page");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.compile);
			node.log(Status.INFO, "STEP2 : Page is visible");
			System.out.println("STEP2 : Page is visible");

			Thread.sleep(2000);
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			// Assert that Interest Payment page is visible
			System.out.println("STEP3 : Asserting that Interest Payment page is visible");
			node.log(Status.INFO, "STEP3 : Asserting that Interest Payment page is visible");

			// Calling the validateUrl from Utils
			Utils.validateUrl(node, driver, currentUrl, AllPagesUrl.interestPaymentPage,
					"validateInterestPaymentPageVisibility");

		} catch (AssertionError validateInterestPaymentPageVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInterestPaymentPageVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestPaymentPageVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestPaymentPageVisibility.printStackTrace();
			node.fail(validateInterestPaymentPageVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateInterestPaymentPageVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInterestPaymentPageVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestPaymentPageVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestPaymentPageVisibility.printStackTrace();
			node.fail(validateInterestPaymentPageVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _003
	@Test(priority = 2)
	public void validateInterestPaymentPageSections() throws IOException {

		try {
			extenttest = extent.createTest("Verify the sections under the Interest page")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadInterestPaymentPage function from the FundingPage
			FundingPage.loadInterestPaymentPage();

			// Verify the section in Calculate Interest page
			node.log(Status.INFO, "STEP1 : Verify the section");
			System.out.println("STEP1 : Verify the section");

			// Check the visibility of Compile
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.compile,
					"STEP2 : BUG: Compile is not coming on Interest Paymente page",
					"STEP2 : EXPECTED: Compile is coming on Interest Paymente page");

			// Check the visibility of Health
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.health,
					"STEP3 : BUG: Health is not coming on Interest Paymente page",
					"STEP3 : EXPECTED: Health is coming on Interest Paymente page");

			// Check the visibility of Month on month comparison
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.monthOnMonthComparison,
					"STEP4 : BUG: Month on month comparison is not coming on Interest Paymente page",
					"STEP4 : EXPECTED: Month on month comparison is coming on Interest Paymente page");

			// Check the visibility of Return Analysis
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.returnAnalysis,
					"STEP5 : BUG: Return Analysis is not coming on Interest Paymente page",
					"STEP5 : EXPECTED: Return Analysis is coming on Interest Paymente page");

			// Check the visibility of Accounting
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.accounting,
					"STEP6 : BUG: Accounting is not coming on Interest Paymente page",
					"STEP6 : EXPECTED: Accounting is coming on Interest Paymente page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateInterestPaymentPageSections", "Pass", driver);

		} catch (AssertionError validateInterestPaymentPageSections) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInterestPaymentPageSections test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestPaymentPageSections_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestPaymentPageSections.printStackTrace();
			node.fail(validateInterestPaymentPageSections);
			Assert.fail();
			extent.flush();

		} catch (Exception validateInterestPaymentPageSections) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInterestPaymentPageSections test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestPaymentPageSections_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestPaymentPageSections.printStackTrace();
			node.fail(validateInterestPaymentPageSections);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _004
	@Test(priority = 3)
	public void validateCompileStepHighlighted() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the Step1 compile is highlighted when the user is in step1 of the interest page")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPage function from the FundingPage
			FundingPage.loadInterestPaymentPage();

			// Check if the 'step--current' is present in the class attribute
			boolean isHighlighted = IElementActions.checkAttributePresentInClass(FundingInterestPaymentPO.compileStep,
					"step--current");

			// Print the result
			if (isHighlighted) {
				node.log(Status.INFO, "SUB-STEP_0.001 :The Step 1 compile is highlighted");
				System.out.println("SUB-STEP_0.001 : The Step 1 compile is highlighted");

				Assert.assertTrue(true, "The Step 1 compile is highlighted");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateByDefaultCompileStepHighlighted", "Pass", driver);
			} else {
				System.out.println("SUB-STEP_0.001 : The Step 1 compile is not highlighted");
				node.log(Status.INFO, "SUB-STEP_0.001 :The Step 1 compile is not highlighted");

				Assert.assertTrue(false, "The Step 1 compile is not highlighted");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateCompileStepHighlighted", "Fail", driver);
			}

		} catch (AssertionError validateCompileStepHighlighted) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCompileStepHighlighted test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCompileStepHighlighted_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCompileStepHighlighted.printStackTrace();
			node.fail(validateCompileStepHighlighted);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCompileStepHighlighted) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCompileStepHighlighted test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCompileStepHighlighted_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCompileStepHighlighted.printStackTrace();
			node.fail(validateCompileStepHighlighted);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _005
	@Test(priority = 4)
	public void validateDatesBaseOnSelectedYearandMonth() throws IOException {

		try {
			extenttest = extent.createTest("Verify that a user can view the dates based on the selected Year and Month")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadInterestPaymentPage function from the FundingPage
			FundingPage.loadInterestPaymentPage();

			// Get the values of month and year from excel
			String selectedYear = getDataFromExcel(6);
			String selectedMonth = getDataFromExcel(7);

			// Select Year from Year Dropdown
			node.log(Status.INFO, "STEP1 : Select the Year from the Year Dropdown");
			System.out.println("STEP1 : Select the Year from the Year Dropdown");
			IElementActions.selectValueFromDropdown(node, driver, FundingInterestPaymentPO.yearDropDown, selectedYear);

			// Select Month from Month Dropdown
			node.log(Status.INFO, "STEP2 : Select the Month from the Month Dropdown");
			System.out.println("STEP2 : Select the Month from the Month Dropdown");
			IElementActions.selectValueFromDropdown(node, driver, FundingInterestPaymentPO.monthDropDown,
					String.valueOf(selectedMonth));

			// Waiting for the visibility of Calculation Start Date
			node.log(Status.INFO, "STEP3 : Waiting for the visibility of Calculation Start Date");
			System.out.println("STEP3 : Waiting for the visibility of Calculation Start Date");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.calStartDate);
			node.log(Status.INFO, "STEP4 : Calculation Start Date is visible");
			System.out.println("STEP4 : Calculation Start Date is visible");

			// Get the calculation start date
			String actualStartDate = IElementActions.getTextbyXpath(node, FundingInterestPaymentPO.calStartDate);
			node.log(Status.INFO, "STEP5 : " + actualStartDate + " is displayed in Calculation Start Date field");
			System.out.println("STEP5 : " + actualStartDate + " is displayed in Calculation Start Date field");

			// Get the calculation end date
			String actualEndDate = IElementActions.getTextbyXpath(node, FundingInterestPaymentPO.calEndDate);
			node.log(Status.INFO, "STEP6 : " + actualEndDate + " is displayed in Calculation End Date field");
			System.out.println("STEP6 : " + actualEndDate + " is displayed in Calculation End Date field");

			// Call the function and get start and end dates
			String[] dates = FundingPage.calculateDates(selectedYear, selectedMonth);

			String expectedStartDate = dates[0];
			String expectedEndDate = dates[1];

			// Assert calculation start date
			IElementActions.assertEquals_usingString(node, driver, actualStartDate, expectedStartDate,
					"BUG : Calculation start date is not matching with the expectedStartDate" + expectedStartDate,
					"PASS : Calculation start date is matching with the expectedStartDate" + expectedStartDate);

			// Assert calculation end date
			IElementActions.assertEquals_usingString(node, driver, actualEndDate, expectedEndDate,
					"BUG : Calculation end date is not matching with the expectedEndDate" + expectedEndDate,
					"PASS : Calculation end date is matching with the expectedEndDate" + expectedEndDate);

			// Scroll to the calEndDate
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingInterestPaymentPO.calEndDate);
			node.log(Status.INFO, "STEP7 : Scrolled to the Calculation End Date");
			System.out.println("STEP7 : Scrolled to the Calculation End Date");

			// Get the Today's Date from Today's Date field
			String todayDate = IElementActions.getTextbyXpath(node, FundingInterestPaymentPO.todaysDate);
			node.log(Status.INFO, "STEP8 : " + todayDate + " is displayed in Today's Date field");
			System.out.println("STEP8 : " + todayDate + " is displayed in Today's Date field");

			// Get the Today's Date
			String getTodayDate = Utils.getTodayDateFormatted();

			// Assert calculation today's date
			IElementActions.assertEquals_usingString(node, driver, todayDate, getTodayDate,
					"BUG :" + getTodayDate + " is not same as on Today's Date field",
					"PASS : " + getTodayDate + " is same as on Today's Date field");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateDatesBaseOnSelectedYearandMonth", "Pass", driver);

		} catch (AssertionError validateDatesBaseOnSelectedYearandMonth) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDatesBaseOnSelectedYearandMonth test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDatesBaseOnSelectedYearandMonth_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDatesBaseOnSelectedYearandMonth.printStackTrace();
			node.fail(validateDatesBaseOnSelectedYearandMonth);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDatesBaseOnSelectedYearandMonth) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDatesBaseOnSelectedYearandMonth test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDatesBaseOnSelectedYearandMonth_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDatesBaseOnSelectedYearandMonth.printStackTrace();
			node.fail(validateDatesBaseOnSelectedYearandMonth);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _006
	@Test(priority = 5)
	public void validateListOfBatchRuns() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that a user can view a list of batch runs based on the selected Year and Month")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadInterestPaymentPage function from the FundingPage
			FundingPage.loadInterestPaymentPage();

			// Select Year from Year Dropdown
			IElementActions.selectValueFromDropdown(node, driver, FundingInterestPaymentPO.yearDropDown,
					getDataFromExcel(6));

			// Select Month from Month Dropdown
			IElementActions.selectValueFromDropdown(node, driver, FundingInterestPaymentPO.monthDropDown,
					getDataFromExcel(7));

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

			List<String> dateList = new ArrayList<>();
			// Initialize lists to store passed and failed dates
			List<String> passedDates = new ArrayList<>();
			List<String> failedDates = new ArrayList<>();

			// Loop until there is a next button available
			while (true) {
				// Find all date elements on the page
				List<WebElement> dateElements = IElementActions.returnElements(node, driver,
						FundingInterestPaymentPO.selectedDateValues);

				// Add each date to the list
				for (WebElement dateElement : dateElements) {
					dateList.add(dateElement.getText());
				}

				// Check if there is a next button available
				WebElement nextButton = IElementActions.returnElement(node, driver, ReportingUpdatesPO.nextButton);

				if (nextButton.getAttribute("class").contains("disabled")) {
					break;
				} else {
					// Click on the next button
					nextButton.click();
				}
			}

			// Validate dates in the list
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			for (String dateStr : dateList) {
				LocalDate date = LocalDate.parse(dateStr, formatter);
				if (date.isEqual(startDate) || date.isEqual(endDate)
						|| (date.isAfter(startDate) && date.isBefore(endDate))) {
					// Date is within the range
					passedDates.add(dateStr);
				} else {
					// Date is outside the range
					failedDates.add(dateStr);
				}
			}

			// Assertion based on the size of failed dates list
			assert failedDates.isEmpty() : "Test case failed for dates: " + failedDates;

			// Log passed dates
			System.out.println("Passed dates: " + passedDates);
			System.out.println("All dates are within the specified range.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateListOfBatchRuns", "Pass", driver);
		} catch (

		AssertionError validateListOfBatchRuns) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateListOfBatchRuns test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateListOfBatchRuns_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateListOfBatchRuns.printStackTrace();
			node.fail(validateListOfBatchRuns);
			Assert.fail();
			extent.flush();

		} catch (Exception validateListOfBatchRuns) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateListOfBatchRuns test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateListOfBatchRuns_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateListOfBatchRuns.printStackTrace();
			node.fail(validateListOfBatchRuns);
			Assert.fail();
			extent.flush();
		}

	}

	// TC_Funding_Interest _007
	// @Test(priority = 6)
	public void validateListofBatchValues() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that a user can view a list of batch runs generated from the “Calculate Interest” module in Interest Payment Step 1")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPage function from the FundingPage
			FundingPage.loadInterestPaymentPage();

			// Verify the section in Calculate Interest page
			node.log(Status.INFO, "STEP1 : Verify the list of Batch");
			System.out.println("STEP1 :  Verify the list of Batch");

			// Scroll to the Today's Date
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingInterestPaymentPO.todaysDate);
			node.log(Status.INFO, "STEP2 : Scrolled to the  today's date");
			System.out.println("STEP2 : Scrolled to the today's date");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateListofBatchValues", "Pass", driver);

		} catch (AssertionError validateListofBatchValues) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateListofBatchValues test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateListofBatchValues_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateListofBatchValues.printStackTrace();
			node.fail(validateListofBatchValues);
			Assert.fail();
			extent.flush();

		} catch (Exception validateListofBatchValues) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateListofBatchValues test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateListofBatchValues_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateListofBatchValues.printStackTrace();
			node.fail(validateListofBatchValues);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _008
	@Test(priority = 7)
	public void validateBatchRunListDetails() throws IOException {

		try {
			extenttest = extent.createTest("Verify the batch list in step 1")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPage function from the FundingPage
			FundingPage.loadInterestPaymentPage();

			// Verify the section in Calculate Interest page
			node.log(Status.INFO, "STEP1 : Verify the batch list details");
			System.out.println("STEP1 :  Verify the batch list details");

			// Scroll to the Today's Date
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingInterestPaymentPO.todaysDate);
			node.log(Status.INFO, "STEP2 : Scrolled to the  today's date");
			System.out.println("STEP2 : Scrolled to the today's date");

			// Check the visibility of Selected Date
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.selectedDate,
					"STEP3 : BUG: Selected date is not coming in compile step on Interest Payment page",
					"STEP3 : EXPECTED: Selected date is coming in compile step on Interest Payment page");

			// Check the visibility of Launch Date
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.LaunchDate,
					"STEP4 : BUG: Launch date is not coming in compile step on Interest Payment page",
					"STEP4 : EXPECTED: Launch date is coming in compile step on Interest Payment page");

			// Check the visibility of Scheduled
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.scheduled,
					"STEP5 : BUG: Scheduled is not coming in compile step on Interest Payment page",
					"STEP5 : EXPECTED: Scheduled is coming in compile step on Interest Payment page");

			// Check the visibility of View
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.view,
					"STEP6 : BUG: View is not coming in compile step on Interest Payment page",
					"STEP6 : EXPECTED: View is coming in compile step on Interest Payment page");

			// Check the visibility of Selected date values
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.selectedDateValues,
					"STEP7 : BUG: Selected date values are not coming under Selected Date column in compile step on Interest Payment page",
					"STEP7 : EXPECTED: Selected date values are coming under Selected Date column in compile step on Interest Payment page");

			// Check the visibility of Launch date values
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.launchDateValues,
					"STEP8 : BUG: Launch date values are not coming under Launch Date column in compile step on Interest Payment page",
					"STEP8 : EXPECTED: Launch date values are coming under Launch Date column in compile step on Interest Payment page");

			// Check the visibility of Scheduled values
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.scheduledValues,
					"STEP9 : BUG: Scheduled values are not coming under scheduled column in compile step on Interest Payment page",
					"STEP9 : EXPECTED: Scheduled values are coming under scheduled column in compile step on Interest Payment page");

			// Check the visibility of View values
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.viewValues,
					"STEP10 : BUG: View values are not coming under view column in compile step on Interest Payment page",
					"STEP10 : EXPECTED: View values are coming under view column in compile step on Interest Payment page");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateBatchRunListDetails", "Pass", driver);

		} catch (AssertionError validateBatchRunListDetails) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateBatchRunListDetails test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateBatchRunListDetails_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBatchRunListDetails.printStackTrace();
			node.fail(validateBatchRunListDetails);
			Assert.fail();
			extent.flush();

		} catch (Exception validateBatchRunListDetails) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateBatchRunListDetails test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateBatchRunListDetails_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBatchRunListDetails.printStackTrace();
			node.fail(validateBatchRunListDetails);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _009
	@Test(priority = 8)
	public void validateViewInterestButton() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that  when the user selects a batch run, they are taken to Step 2 of that calculation")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPage function from the FundingPage
			FundingPage.loadInterestPaymentPage();

			// Scroll to the Today's Date
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingInterestPaymentPO.todaysDate);
			node.log(Status.INFO, "STEP1 : Scrolled to the  today's date");
			System.out.println("STEP1 : Scrolled to the today's date");

			// Wait for the visibility of the firstViewInterestButton
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the View Interest button");
			System.out.println("STEP2 : Waiting for the visibility of the View Interest button");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.firstViewInterestButton);
			node.log(Status.INFO, "STEP3 : View Interest button is visible");
			System.out.println("STEP3 : View Interest button is visible");

			// Click on View interest first Button
			IElementActions.clickelement_usingXpath(node, driver, FundingInterestPaymentPO.firstViewInterestButton);
			node.log(Status.INFO, "STEP4 : Clicked on the first View Interest Button");
			System.out.println("STEP4 : Clicked on the first View Interest first Button");

			// Wait for Page Load
			node.log(Status.INFO, "STEP5 : Waiting for the complete page loding");
			System.out.println("STEP5 : Waiting for the complete page loading");
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.healthStep);
			node.log(Status.INFO, "STEP6 : Complete Page is load successfully");
			System.out.println("STEP6 : Complete Page is load successfully");

			Thread.sleep(2000);
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			// Assert that Calculate Interest page is visible
			System.out.println("STEP7 : Asserting that user is redirecting to the Step2 i.e Helath");
			node.log(Status.INFO, "STEP7 : Asserting that user is redirecting to the Step2 i.e Helath");
			Utils.validateUrl(node, driver, currentUrl, AllPagesUrl.interestPaymentHealthStepPage,
					"validateViewInterestButton");

			// Check if the 'step--current' is present in the class attribute
			boolean isHighlighted = IElementActions.checkAttributePresentInClass(FundingInterestPaymentPO.healthStep,
					"step--current");

			// Print the result
			if (isHighlighted) {
				node.log(Status.INFO,
						"SUB-STEP_0.001 :The user is redirected to Step 2 of that calculation i.e Health");
				System.out.println("SUB-STEP_0.001 : The user is redirected to Step 2 of that calculation i.e Health");

				Assert.assertTrue(true, "The user is redirected to Step 2 of that calculation i.e Health");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateViewInterestButton", "Pass", driver);
			} else {
				System.out.println(
						"SUB-STEP_0.001 : The user is not redirected to Step 2 of that calculation i.e Health");
				node.log(Status.INFO,
						"SUB-STEP_0.001 :The user is not redirected to Step 2 of that calculation i.e Health");

				Assert.assertTrue(false, "The user is not redirected to Step 2 of that calculation i.e Health");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateViewInterestButton", "Fail", driver);
			}

		} catch (AssertionError validateViewInterestButton) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateViewInterestButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateViewInterestButton_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateViewInterestButton.printStackTrace();
			node.fail(validateViewInterestButton);
			Assert.fail();
			extent.flush();

		} catch (Exception validateViewInterestButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateViewInterestButton test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateViewInterestButton_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateViewInterestButton.printStackTrace();
			node.fail(validateViewInterestButton);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Interest _010
	@Test(priority = 9)
	public void validateListOfAllFacilities() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the list of all the facilities in the system is displayed under 'Toggle All Facilities' on the interest page")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPage function from the FundingPage
			FundingPage.loadInterestPaymentPage();

			// Check the visibility of all Facilities
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.allFacilities,
					"STEP1 : BUG: The list of facilities is not coming under 'Toggle All Facilities' in Health step on interest payment page",
					"STEP1 : EXPECTED: The list of facilities is  displayed under 'Toggle All Facilities' in Health step on interest payment page");

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validateListOfAllFacilities", "Pass", driver);

		} catch (AssertionError validateListOfAllFacilities) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateListOfAllFacilities test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateListOfAllFacilities_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateListOfAllFacilities.printStackTrace();
			node.fail(validateListOfAllFacilities);
			Assert.fail();
			extent.flush();

		} catch (Exception validateListOfAllFacilities) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateListOfAllFacilities test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateListOfAllFacilities_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateListOfAllFacilities.printStackTrace();
			node.fail(validateListOfAllFacilities);
			Assert.fail();
			extent.flush();
		}
	}
}
