package com.Treasury.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.locators.allPages.FundingInterestPaymentPO;
import com.locators.allPages.PipelinePO;
import com.locators.allPages.SideMenuPO;
import com.locators.allPages.TreasuryDatabasePO;
import com.locators.allPages.TreasuryPortfolioPO;
import com.locators.allPages.TreasurySinglePO;
import com.locators.allPages.UtilsPO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.url.AllPagesUrl;
import com.qa.utils.FundingPage;
import com.qa.utils.LoginPage;
import com.qa.utils.TreasuryPage;
import com.qa.utils.Utils;

public class DatabaseTest extends Baseclass {

	// TC_Treasury_Database_001
	@Test(priority = 1)
	public void validateDatabaseTreasury() throws IOException {
		try {
			extenttest = extent.createTest("Admin should be navigated to the Database treasury page.")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadLoginPage function from the login
			LoginPage.loadLoginPage();

			// Calling the userLoginProcess function from the LoginPage
			LoginPage.userLoginProcess(node, driver, getDataFromExcel(1), getDataFromExcel(2));

			// Click on the Treasury Menu
			Utils.clickOnMenu(node, driver, SideMenuPO.treasury);

			// Click on the Portfolio Treasury Sub Menu
			Utils.clickOnMenu(node, driver, SideMenuPO.databaseTreasury);

			// Wait for the visibility of Treasury Single page
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of Treasury Database page");
			System.out.println("STEP1 : Waiting for the visibility of Treasury Database page");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryDatabasePO.facilities);
			IWaitStrategy.WaitUntilElementClickable(node, driver, TreasuryDatabasePO.facilities);
			node.log(Status.INFO, "STEP2 : Treasury Database page is visible");
			System.out.println("STEP2 : Treasury Database page is visible");

			Thread.sleep(2000);
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			// Calling the validateUrl from Utils
			Utils.validateUrl(node, driver, currentUrl, AllPagesUrl.TreasuryDatabasePage, "validateDatabaseTreasury");

		} catch (AssertionError validateDatabaseTreasury) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDatabaseTreasury test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDatabaseTreasury_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDatabaseTreasury.printStackTrace();
			node.fail(validateDatabaseTreasury);
			Assert.fail();
			extent.flush();
		} catch (Exception validateDatabaseTreasury) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDatabaseTreasury test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDatabaseTreasury_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDatabaseTreasury.printStackTrace();
			node.fail(validateDatabaseTreasury);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_003
	@Test(priority = 2)
	public void validateDatabaseTableVisibility() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the user has selected a date, a table of all facilities and their allocations to loans on that date are displayed")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadTreasuryDatabasePage from treasury
			TreasuryPage.loadTreasuryDatabasePage();

			// Check the visibility of facilities
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryDatabasePO.facilities,
					"STEP1 : BUG : Facilities is not coming under database page",
					"STEP1 : EXPECTED : Facilities is coming under database page");

			// Check the visibility of loans allocation
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryDatabasePO.loanRows,
					"STEP2 : BUG : Loans is not coming under database page",
					"STEP2 : EXPECTED : Loans is coming under database page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDatabaseTableVisibility", "Pass", driver);

		} catch (AssertionError validateDatabaseTableVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDatabaseTableVisibility test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDatabaseTableVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDatabaseTableVisibility.printStackTrace();
			node.fail(validateDatabaseTableVisibility);
			Assert.fail();
			extent.flush();
		} catch (Exception validateDatabaseTableVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDatabaseTableVisibility test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDatabaseTableVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDatabaseTableVisibility.printStackTrace();
			node.fail(validateDatabaseTableVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_004
	@Test(priority = 3)
	public void validateToggleLoans() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the user can toggle loans in order to select a cross-section of the table on a given date")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadTreasuryDatabasePage from treasury
			TreasuryPage.loadTreasuryDatabasePage();

			// Wait for the visibility of the toggle all loans
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the toggle all loans");
			System.out.println("STEP1 : Waiting for the visibility of the toggle all loans");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryDatabasePO.toggleAllLoans);
			IWaitStrategy.WaitUntilElementClickable(node, driver, TreasuryDatabasePO.toggleAllLoans);
			node.log(Status.INFO, "STEP2 : Toggle all loans is visible");
			System.out.println("STEP2 : Toggle all loans is visible");

			// Click on the toggle all loans button
			IElementActions.clickelement_usingXpath(node, driver, TreasuryDatabasePO.toggleAllLoans);
			node.log(Status.INFO, "STEP3 : Clicked on the toggle loans button");
			System.out.println("STEP3 : Clicked on the toggle loans button");

			// Scroll to the loan reference
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, TreasuryDatabasePO.loanRows);
			node.log(Status.INFO, "STEP4 : Scrolled vertically to the loan reference element");
			System.out.println("STEP4 : Scrolled vertically to the loan reference element");

			// Wait for the visibility of the loan reference
			node.log(Status.INFO, "STEP5 : Waiting for the visibility of the loan reference");
			System.out.println("STEP5 : Waiting for the visibility of the loan reference");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryDatabasePO.loanReferencesCheckbox);
			node.log(Status.INFO, "STEP6 : Loan reference is visible");
			System.out.println("STEP6 : Loan reference is visible");

			// Find all checkboxes of loans reference
			List<WebElement> loanCheckboxes = IElementActions.returnElements(node, driver,
					TreasuryDatabasePO.loanReferencesCheckbox);

			int incorrectValue = 0;
			for (WebElement checkbox : loanCheckboxes) {
				// Check if the checkbox is selected or not
				boolean isSelected = checkbox.isSelected();
				// Increase the count if checkbox is not selected
				if (isSelected) {
					incorrectValue++;
				}
			}

			// Assert checkbox is selected or not
			if (incorrectValue == 0) {
				node.log(Status.INFO, "SUB-STEP_0.001 : The loan checkbox is unchecked");
				System.out.println("SUB-STEP_0.001 : The loan checkbox is unchecked");

				Assert.assertTrue(true, "The loan checkbox is unchecked");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateToggleLoans", "Pass", driver);
			} else {
				node.log(Status.INFO, "SUB-STEP_0.001 : The loan checkbox is checked");
				System.out.println("SUB-STEP_0.001 : The loan checkbox is checked");

				Assert.assertTrue(false, "The loan checkbox is checked");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateToggleLoans", "Fail", driver);
			}
		} catch (AssertionError validateToggleLoans) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateToggleLoans test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateToggleLoans_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateToggleLoans.printStackTrace();
			node.fail(validateToggleLoans);
			Assert.fail();
			extent.flush();
		} catch (Exception validateToggleLoans) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateToggleLoans test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateToggleLoans_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateToggleLoans.printStackTrace();
			node.fail(validateToggleLoans);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_005
	@Test(priority = 4)
	public void validateToggleFacilities() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the user can toggle facilities in order to select a cross-section of the table on a given date")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadTreasuryDatabasePage from treasury
			TreasuryPage.loadTreasuryDatabasePage();

			// Scroll to top
			IElementActions.scrollToTop(driver);

			// Wait for the visibility of the toggle all facilities
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the toggle all facilities");
			System.out.println("STEP1 : Waiting for the visibility of the toggle all facilities");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryDatabasePO.toggleAllFacilities);
			IWaitStrategy.WaitUntilElementClickable(node, driver, TreasuryDatabasePO.toggleAllFacilities);
			node.log(Status.INFO, "STEP2 : Toggle all facilities is visible");
			System.out.println("STEP2 : Toggle all facilities is visible");

			// Click on the toggle all facilities button
			IElementActions.clickelement_usingXpath(node, driver, TreasuryDatabasePO.toggleAllFacilities);
			node.log(Status.INFO, "STEP3 : Clicked on the toggle facilities button");
			System.out.println("STEP3 : Clicked on the toggle facilities button");

			// Wait for the visibility of the facilities reference
			node.log(Status.INFO, "STEP4 : Waiting for the visibility of the facilities reference");
			System.out.println("STEP4 : Waiting for the visibility of the facilities reference");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryDatabasePO.loanReferences);
			node.log(Status.INFO, "STEP5 : Facilities reference is visible");
			System.out.println("STEP5 : Facilities reference is visible");

			// Find all checkboxes of facilities reference
			List<WebElement> facilitiesCheckboxes = IElementActions.returnElements(node, driver,
					TreasuryDatabasePO.facilitiesCheckbox);

			int incorrectValue = 0;
			for (WebElement checkbox : facilitiesCheckboxes) {
				// Check if the checkbox is selected or not
				boolean isSelected = checkbox.isSelected();
				// Increase the count if checkbox is not selected
				if (isSelected) {
					incorrectValue++;
				}
			}

			// Assert checkbox is selected or not
			if (incorrectValue == 0) {
				node.log(Status.INFO, "SUB-STEP_0.001 : The facilities checkbox is unchecked");
				System.out.println("SUB-STEP_0.001 : The facilities checkbox is unchecked");

				Assert.assertTrue(true, "The facilities checkbox is unchecked");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateToggleFacilities", "Pass", driver);
			} else {
				node.log(Status.INFO, "SUB-STEP_0.001 : The facilities checkbox is checked");
				System.out.println("SUB-STEP_0.001 : The facilities checkbox is checked");

				Assert.assertTrue(false, "The facilities checkbox is checked");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateToggleFacilities", "Fail", driver);
			}
		} catch (AssertionError validateToggleFacilities) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateToggleFacilities test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateToggleFacilities_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateToggleFacilities.printStackTrace();
			node.fail(validateToggleFacilities);
			Assert.fail();
			extent.flush();
		} catch (Exception validateToggleFacilities) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateToggleFacilities test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateToggleFacilities_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateToggleFacilities.printStackTrace();
			node.fail(validateToggleFacilities);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_006
	// TC_Treasury_Database_027
	@Test(priority = 5)
	public void validateDatabaseNextStep() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that when the user clicks on the “Next Step”, the user should able to view the isolated section of the Database on the date that the user has selected")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadTreasuryDatabasePage from treasury
			TreasuryPage.loadTreasuryDatabasePage();

			// Calling the bottomNextStepButton function from Funding Page
			FundingPage.bottomNextStepButton(TreasuryDatabasePO.nextStepButton, 2, "Database");

			// Wait for the visibility of the amend facility allocations
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the amend facility allocations");
			System.out.println("STEP1 : Waiting for the visibility of the amend facility allocations");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryDatabasePO.amendFacilityAllocations);
			node.log(Status.INFO, "STEP2 : Amend facility allocations is visible");
			System.out.println("STEP2 : Amend facility allocations is visible");

			// Check the visibility of amend facility allocations
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryDatabasePO.amendFacilityAllocations,
					"STEP3 : BUG : Amend facility allocations is not coming under database page",
					"STEP3 : EXPECTED : Amend facility allocations is coming under database page");

			// Check the visibility of current allocation
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryDatabasePO.currentAllocation,
					"STEP3 : BUG : Current allocation is not coming under database page",
					"STEP3 : EXPECTED : Current allocation is coming under database page");

			// Check the visibility of revised allocation
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryDatabasePO.revisedAllocation,
					"STEP3 : BUG : Revised allocation is not coming under database page",
					"STEP3 : EXPECTED : Revised allocation is coming under database page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDatabaseNextStep", "Pass", driver);
		} catch (AssertionError validateDatabaseNextStep) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDatabaseNextStep test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDatabaseNextStep_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDatabaseNextStep.printStackTrace();
			node.fail(validateDatabaseNextStep);
			Assert.fail();
			extent.flush();
		} catch (Exception validateDatabaseNextStep) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDatabaseNextStep test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDatabaseNextStep_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDatabaseNextStep.printStackTrace();
			node.fail(validateDatabaseNextStep);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_007
	@Test(priority = 6)
	public void validateFacilityAmount() throws IOException {
		try {
			extenttest = extent.createTest("Verify the 'Facility Amount' corresponding to a facility")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get facility reference number
			String facilityReferenceNumber = getDataFromExcel(34);

			// Calling the loadTreasuryDatabasePage from treasury
			TreasuryPage.loadTreasuryDatabasePage();

			// Find all elements of the facilities in database
			List<String> facilitiesReferenceInDatabase = Utils.extractTextFromElements(TreasuryDatabasePO.facilities);

			int facilityPositions = 1;

			for (int i = 0; i < facilitiesReferenceInDatabase.size(); i++) {
				String facilitiesReferenceValue = facilitiesReferenceInDatabase.get(i);
				if (facilitiesReferenceValue.equals(facilityReferenceNumber)) {
					facilityPositions = facilityPositions + i;
					break;
				}
			}

			// Create the dynamic locator for facility amount
			String facilityAmountLocator = IElementActions.createDynamicLocatorString(TreasuryDatabasePO.facilityAmount,
					"facilityPosition", Integer.toString(facilityPositions));

			// Get the facility amount
			String actualFacilityAmount = IElementActions.getElementText_usingXpath(node, driver,
					facilityAmountLocator);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Create the dynamic locator for facility reference
			String facilityReference = IElementActions.createDynamicLocatorString(TreasuryPortfolioPO.dynamicReference,
					"locatorValue", facilityReferenceNumber);

			// Create the dynamic locator for facility amount corresponding to facility
			String amountCorrespondingToFacility = IElementActions.createDynamicLocatorString(
					TreasuryPortfolioPO.amountCorrespondingToFacility, "locatorValue", facilityReferenceNumber);

			// Scroll to the element vertically
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, facilityReference);
			node.log(Status.INFO, "STEP1 : Scrolled to the element vertically");
			System.out.println("STEP1 : Scrolled to the element vertically");

			// Wait for the visibility of facility amount
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of facility amount");
			System.out.println("STEP2 : Waiting for the visibility of facility amount");
			IWaitStrategy.waitForVisiblity(node, driver, amountCorrespondingToFacility);
			node.log(Status.INFO, "STEP3 : The facility amount is visible");
			System.out.println("STEP3 : The facility amount is visible");

			// Get the facility amount
			String expectedFacilityAmount = IElementActions.getElementText_usingXpath(node, driver,
					amountCorrespondingToFacility);

			// Assert the facility amount
			IElementActions.assertEquals_usingString(node, driver, actualFacilityAmount, expectedFacilityAmount,
					"STEP4 : BUG : Facility amount value in database is " + actualFacilityAmount
							+ " and is not equal to the facility amount value in portfolio " + expectedFacilityAmount,
					"STEP4 : EXPECTED : Facility amount value in database is " + actualFacilityAmount
							+ "  and is equal to the facility amount value in portfolio " + expectedFacilityAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityAmount", "Pass", driver);
		} catch (AssertionError validateFacilityAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityAmount test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFacilityAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityAmount.printStackTrace();
			node.fail(validateFacilityAmount);
			Assert.fail();
			extent.flush();
		} catch (Exception validateFacilityAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityAmount test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFacilityAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityAmount.printStackTrace();
			node.fail(validateFacilityAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_008
	@Test(priority = 7)
	public void validateDrawnAmount() throws IOException {
		try {
			extenttest = extent.createTest("Verify the 'Drawn Amount' corresponding to a facility")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get facility reference number
			String facilityReferenceNumber = getDataFromExcel(34);

			// Calling the loadTreasuryDatabasePage from treasury
			TreasuryPage.loadTreasuryDatabasePage();

			// Find all elements of the facilities in database
			List<String> facilitiesReferenceInDatabase = Utils.extractTextFromElements(TreasuryDatabasePO.facilities);

			int facilityPositions = 1;

			for (int i = 0; i < facilitiesReferenceInDatabase.size(); i++) {
				String facilitiesReferenceValue = facilitiesReferenceInDatabase.get(i);
				if (facilitiesReferenceValue.equals(facilityReferenceNumber)) {
					facilityPositions = facilityPositions + i;
					break;
				}
			}

			// Create the dynamic locator for facility drawn amount
			String facilityDrawnAmountLocator = IElementActions.createDynamicLocatorString(
					TreasuryDatabasePO.facilityDrawnAmount, "facilityPosition", Integer.toString(facilityPositions));

			// Get the facility drawn amount
			String actualFacilityDrawnAmount = IElementActions.getElementText_usingXpath(node, driver,
					facilityDrawnAmountLocator);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Create the dynamic locator for facility reference
			String facilityReference = IElementActions.createDynamicLocatorString(TreasuryPortfolioPO.dynamicReference,
					"locatorValue", facilityReferenceNumber);

			// Scroll to the element vertically
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, facilityReference);
			node.log(Status.INFO, "STEP1 : Scrolled to the element vertically");
			System.out.println("STEP1 : Scrolled to the element vertically");

			// Create the dynamic locator for drawn amount corresponding to facility
			String drawAmountCorrespondingToFacility = IElementActions.createDynamicLocatorString(
					TreasuryPortfolioPO.drawnAmountCorrespondingToFacility, "locatorValue", facilityReferenceNumber);

			// Wait for the visibility of facility amount
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of facility drawn amount");
			System.out.println("STEP2 : Waiting for the visibility of facility drawn amount");
			IWaitStrategy.waitForVisiblity(node, driver, drawAmountCorrespondingToFacility);
			node.log(Status.INFO, "STEP3 : The facility drawn amount is visible");
			System.out.println("STEP3 : The facility drawn amount is visible");

			// Get the facility drawn amount
			String expectedFacilityDrawnAmount = IElementActions.getElementText_usingXpath(node, driver,
					drawAmountCorrespondingToFacility);

			// Assert the facility drawn amount
			IElementActions.assertEquals_usingString(node, driver, actualFacilityDrawnAmount,
					expectedFacilityDrawnAmount,
					"STEP4 : BUG : Facility drawn amount value in database is " + actualFacilityDrawnAmount
							+ " and is not equal to the facility drawn amount value in portfolio "
							+ expectedFacilityDrawnAmount,
					"STEP4 : EXPECTED : Facility drawn amount value in database is " + actualFacilityDrawnAmount
							+ "  and is equal to the facility drawn amount value in portfolio "
							+ expectedFacilityDrawnAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDrawnAmount", "Pass", driver);
		} catch (AssertionError validateDrawnAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDrawnAmount test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDrawnAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDrawnAmount.printStackTrace();
			node.fail(validateDrawnAmount);
			Assert.fail();
			extent.flush();
		} catch (Exception validateDrawnAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDrawnAmount test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDrawnAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDrawnAmount.printStackTrace();
			node.fail(validateDrawnAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_009
	@Test(priority = 8)
	public void validateAllocatedAmount() throws IOException {
		try {
			extenttest = extent.createTest("Verify the 'Allocated Amount' corresponding to a facility")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get facility reference number
			String facilityReferenceNumber = getDataFromExcel(65);

			// Calling the loadTreasuryDatabasePage from treasury
			TreasuryPage.loadTreasuryDatabasePage();

			// Find all elements of the facilities in database
			List<String> facilitiesReferenceInDatabase = Utils.extractTextFromElements(TreasuryDatabasePO.facilities);

			int facilityPositions = 1;

			for (int i = 0; i < facilitiesReferenceInDatabase.size(); i++) {
				String facilitiesReferenceValue = facilitiesReferenceInDatabase.get(i);
				if (facilitiesReferenceValue.equals(facilityReferenceNumber)) {
					facilityPositions = facilityPositions + i;
					break;
				}
			}

			// Create the dynamic locator for facility allocated amount
			String facilityAllocatedAmountLocator = IElementActions.createDynamicLocatorString(
					TreasuryDatabasePO.facilityAllocatedAmount, "facilityPosition",
					Integer.toString(facilityPositions));

			// Get the facility allocated amount
			String actualFacilityAllocatedAmount = IElementActions.getElementText_usingXpath(node, driver,
					facilityAllocatedAmountLocator);

			// Calling the loadLatestInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadLatestInterestPaymentPageAndNavigateToStep4();

			// Create the dynamic locator for facility reference
			String facilityReference = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.facilityIIcon, "locatorValue", facilityReferenceNumber);

			// Scroll to the element vertically
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, facilityReference);
			node.log(Status.INFO, "STEP1 : Scrolled to the element vertically");
			System.out.println("STEP1 : Scrolled to the element vertically");
			IElementActions.scrollByJSExecutor(driver, -100);

			// Calling the facilityIButton function from FundingPage
			FundingPage.facilityIButton(facilityReference, FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Get the facility allocated amount
			String expectedFacilityAllocatedAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.lastDateSum);

			// Assert the facility allocated amount
			IElementActions.assertEquals_usingString(node, driver, actualFacilityAllocatedAmount,
					expectedFacilityAllocatedAmount,
					"STEP2 : BUG : Facility allocated amount value in database is " + actualFacilityAllocatedAmount
							+ " and is not equal to the facility allocated amount value in interest payment "
							+ expectedFacilityAllocatedAmount,
					"STEP2 : EXPECTED : Facility allocated amount value in database is " + actualFacilityAllocatedAmount
							+ "  and is equal to the facility allocated amount value in interest payment "
							+ expectedFacilityAllocatedAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAllocatedAmount", "Pass", driver);
		} catch (AssertionError validateAllocatedAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAllocatedAmount test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAllocatedAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocatedAmount.printStackTrace();
			node.fail(validateAllocatedAmount);
			Assert.fail();
			extent.flush();
		} catch (Exception validateAllocatedAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAllocatedAmount test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAllocatedAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocatedAmount.printStackTrace();
			node.fail(validateAllocatedAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_014
	@Test(priority = 9)
	public void validateLoanAmount() throws IOException {
		try {
			extenttest = extent.createTest("Verify the loan amount corresponding to a facility")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(66);

			// Get facility reference number
			String facilityReferenceNumber = getDataFromExcel(65);

			// Calling the loadTreasuryDatabasePage from treasury
			TreasuryPage.loadTreasuryDatabasePage();

			// Find all elements of the facilities in database
			List<String> facilitiesReferenceInDatabase = Utils.extractTextFromElements(TreasuryDatabasePO.facilities);

			int facilityPositions = 1;

			for (int i = 0; i < facilitiesReferenceInDatabase.size(); i++) {
				String facilitiesReferenceValue = facilitiesReferenceInDatabase.get(i);
				if (facilitiesReferenceValue.equals(facilityReferenceNumber)) {
					facilityPositions = facilityPositions + i;
					break;
				}
			}

			// Create the dynamic locator for loan reference
			String loanReference = IElementActions.createDynamicLocatorString(TreasuryDatabasePO.loanAmountOfFacility,
					"locatorValue", loanReferenceNumber);

			// Create the dynamic locator for facility loan amount
			String facilityLoanAmountLocator = IElementActions.createDynamicLocatorString(loanReference,
					"facilityPosition", Integer.toString(facilityPositions));

			// Get the facility loan amount
			String actualFacilityLoanAmount = IElementActions.getElementText_usingXpath(node, driver,
					facilityLoanAmountLocator);

			node.log(Status.INFO, "STEP1 : For loan " + loanReferenceNumber + " of facility " + facilityReferenceNumber
					+ " the value is " + actualFacilityLoanAmount);
			System.out.println("STEP1 : For loan " + loanReferenceNumber + " of facility " + facilityReferenceNumber
					+ " the value is " + actualFacilityLoanAmount);

			// Calling the loadInterestPaymentPageAndNavigateToStep4 function from
			// FundingPage to access the step4 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Create the dynamic locator for facility reference
			String facilityReference = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.facilityIIcon, "locatorValue", facilityReferenceNumber);

			// Scroll to the element vertically
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, facilityReference);
			node.log(Status.INFO, "STEP1 : Scrolled to the element vertically");
			System.out.println("STEP1 : Scrolled to the element vertically");
			IElementActions.scrollByJSExecutor(driver, -100);

			// Calling the facilityIButton function from FundingPage
			FundingPage.facilityIButton(facilityReference, FundingInterestPaymentPO.interestPaymentDetailsPopup,
					FundingInterestPaymentPO.interestPaymentDetailsPopupHeader);

			// Create the dynamic locator for loan reference
			String loanReferenceInInterestPayement = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.lastDateLoan, "locatorValue", loanReferenceNumber);

			// Scroll to the element vertically
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, loanReferenceInInterestPayement);
			node.log(Status.INFO, "SUB-STEP_0.001 : Scrolled to the element vertically");
			System.out.println("SUB-STEP_0.001 : Scrolled to the element vertically");

			// Wait for the visibility of facility loan amount
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of facility loan amount");
			System.out.println("STEP2 : Waiting for the visibility of facility loan amount");
			IWaitStrategy.waitForVisiblity(node, driver, loanReferenceInInterestPayement);
			node.log(Status.INFO, "STEP3 : The facility loan amount is visible");
			System.out.println("STEP3 : The facility loan amount is visible");

			// Get the facility loan amount
			String expectedFacilityLoanAmount = IElementActions.getElementText_usingXpath(node, driver,
					loanReferenceInInterestPayement);

			// Assert the facility loan amount
			IElementActions.assertEquals_usingString(node, driver, actualFacilityLoanAmount, expectedFacilityLoanAmount,
					"STEP02 : BUG : Facility loan amount value in database is " + actualFacilityLoanAmount
							+ " and is not equal to the facility loan amount value in interest payment "
							+ expectedFacilityLoanAmount,
					"STEP02 : EXPECTED : Facility loan amount value in database is " + actualFacilityLoanAmount
							+ "  and is equal to the facility loan amount value in interest payment "
							+ expectedFacilityLoanAmount);
			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanAmount", "Pass", driver);
		} catch (AssertionError validateLoanAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanAmount test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanAmount.printStackTrace();
			node.fail(validateLoanAmount);
			Assert.fail();
			extent.flush();
		} catch (Exception validateLoanAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanAmount test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanAmount.printStackTrace();
			node.fail(validateLoanAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_015
	@Test(priority = 10)
	public void validateTotalFacilityAmount() throws IOException {
		try {
			extenttest = extent.createTest("Verify the 'Facility Amount' total")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadTreasuryDatabasePage from treasury
			TreasuryPage.loadTreasuryDatabasePage();

			// Extract the values from the total facility amount
			double totalFacilityAmount = Utils.getTextAndParseToDouble(TreasuryDatabasePO.totalFacilityAmount);
			System.out.println("STEP01 : Total facility amount value is: " + totalFacilityAmount);
			node.log(Status.INFO, "STEP01 : Total facility amount value is: " + totalFacilityAmount);

			// Get sum of all facility amount
			double facilitiesAmountSum = Utils.calculateSumOfList(TreasuryDatabasePO.facilitiesAmount);
			System.out.println("STEP02 : All facility amount sum is : " + facilitiesAmountSum);
			node.log(Status.INFO, "STEP02  All facility amount sum is : " + facilitiesAmountSum);

			// Assert the facility amount total
			IElementActions.assertEquals_usingDouble(node, driver, totalFacilityAmount, facilitiesAmountSum,
					"STEP02 : BUG : Total facility amount value is " + totalFacilityAmount
							+ " and is not equal to the sum of all facility amount" + facilitiesAmountSum,
					"STEP02 : EXPECTED : Total facility amount value is " + totalFacilityAmount
							+ "  and is equal to the sum of all facility amount " + facilitiesAmountSum);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateTotalFacilityAmount", "Pass", driver);
		} catch (AssertionError validateTotalFacilityAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateTotalFacilityAmount test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTotalFacilityAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalFacilityAmount.printStackTrace();
			node.fail(validateTotalFacilityAmount);
			Assert.fail();
			extent.flush();
		} catch (Exception validateTotalFacilityAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateTotalFacilityAmount test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTotalFacilityAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalFacilityAmount.printStackTrace();
			node.fail(validateTotalFacilityAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_016
	@Test(priority = 11)
	public void validateTotalDrawnAmount() throws IOException {
		try {
			extenttest = extent.createTest("Verify the 'Drawn Amount' total")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Deviation
			double deviatedValue = Double.parseDouble(getDataFromExcel(10));

			// Calling the loadTreasuryDatabasePage from treasury
			TreasuryPage.loadTreasuryDatabasePage();

			// Extract the values from the total drawn amount
			double totalDrawnAmount = Utils.getTextAndParseToDouble(TreasuryDatabasePO.totalDrawnAmount);
			System.out.println("STEP01 : Total facility drawn amount value is: " + totalDrawnAmount);
			node.log(Status.INFO, "STEP01 : Total facility amount drawn value is: " + totalDrawnAmount);

			// Get sum of all facility drawn amount
			double facilitiesDrawnAmountSum = Utils.calculateSumOfList(TreasuryDatabasePO.facilitiesDrawnAmount);
			System.out.println("STEP02 : All drawn  amount sum is : " + facilitiesDrawnAmountSum);
			node.log(Status.INFO, "STEP02  All drawn amount sum is : " + facilitiesDrawnAmountSum);

			// Perform assertion allowing for a difference 5 with a delta parameter
			Assert.assertEquals(totalDrawnAmount, facilitiesDrawnAmountSum, deviatedValue,
					"Difference is greater than the acceptable range between Total drawn value" + totalDrawnAmount
							+ " and the sum of drawn amount" + facilitiesDrawnAmountSum);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateTotalDrawnAmount", "Pass", driver);
		} catch (AssertionError validateTotalDrawnAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateTotalDrawnAmount test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTotalDrawnAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalDrawnAmount.printStackTrace();
			node.fail(validateTotalDrawnAmount);
			Assert.fail();
			extent.flush();
		} catch (Exception validateTotalDrawnAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateTotalDrawnAmount test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTotalDrawnAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalDrawnAmount.printStackTrace();
			node.fail(validateTotalDrawnAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_017
	@Test(priority = 12)
	public void validateTotalAllocatedAmount() throws IOException {
		try {
			extenttest = extent.createTest("Verify the 'Allocated Amount' total")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Deviation
			double deviatedValue = Double.parseDouble(getDataFromExcel(10));

			// Calling the loadTreasuryDatabasePage from treasury
			TreasuryPage.loadTreasuryDatabasePage();

			// Extract the values from the total allocated amount
			double totalAllocatedAmount = Utils.getTextAndParseToDouble(TreasuryDatabasePO.totalAllocatedAmount);
			System.out.println("STEP01 : Total allocated amount value is: " + totalAllocatedAmount);
			node.log(Status.INFO, "STEP01 : Total allocated amount value is: " + totalAllocatedAmount);

			// Get sum of all facility allocated amount
			double facilitiesAllocatedAmountSum = Utils
					.calculateSumOfList(TreasuryDatabasePO.facilitiesAllocatedAmount);
			System.out.println("STEP02 : All allocated amount sum is : " + facilitiesAllocatedAmountSum);
			node.log(Status.INFO, "STEP02  All allocated amount sum is : " + facilitiesAllocatedAmountSum);

			// Perform assertion allowing for a difference 5 with a delta parameter
			Assert.assertEquals(totalAllocatedAmount, facilitiesAllocatedAmountSum, deviatedValue,
					"Difference is greater than the acceptable range between Total allocated value"
							+ totalAllocatedAmount + " and the sum of allocated amount" + facilitiesAllocatedAmountSum);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateTotalAllocatedAmount", "Pass", driver);
		} catch (AssertionError validateTotalAllocatedAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateTotalAllocatedAmount test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTotalAllocatedAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalAllocatedAmount.printStackTrace();
			node.fail(validateTotalAllocatedAmount);
			Assert.fail();
			extent.flush();
		} catch (Exception validateTotalAllocatedAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateTotalAllocatedAmount test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTotalAllocatedAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalAllocatedAmount.printStackTrace();
			node.fail(validateTotalAllocatedAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_022
	@Test(priority = 13)
	public void validateTotalLoanAmount() throws IOException {
		try {
			extenttest = extent.createTest("Verify the loan amount total")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(66);

			// Deviation
			double deviatedValue = Double.parseDouble(getDataFromExcel(10));

			// Calling the loadTreasuryDatabasePage from treasury
			TreasuryPage.loadTreasuryDatabasePage();

			// Create the dynamic locator for total loan amount
			String loanAmountLocator = IElementActions.createDynamicLocatorString(TreasuryDatabasePO.totalLoanAmount,
					"locatorValue", loanReferenceNumber);

			// Get the total amount amount
			Double totalLoanAmount = Utils.getTextAndParseToDouble(loanAmountLocator);

			// Create the dynamic locator for all loan amount
			String allLoanAmountLocator = IElementActions.createDynamicLocatorString(TreasuryDatabasePO.loanAmounts,
					"locatorValue", loanReferenceNumber);

			// Get sum of all loan amount
			double loanAmountSum = Utils.calculateSumOfList(allLoanAmountLocator);
			System.out.println("STEP01 : All loan amount sum is : " + loanAmountSum);
			node.log(Status.INFO, "STEP01  All loan amount sum is : " + loanAmountSum);

			// Perform assertion allowing for a difference 5 with a delta parameter
			Assert.assertEquals(totalLoanAmount, loanAmountSum, deviatedValue,
					"Difference is greater than the acceptable range between Total loan value" + totalLoanAmount
							+ " and the sum of loan amount" + loanAmountSum);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateTotalLoanAmount", "Pass", driver);
		} catch (AssertionError validateTotalLoanAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateTotalLoanAmount test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTotalLoanAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalLoanAmount.printStackTrace();
			node.fail(validateTotalLoanAmount);
			Assert.fail();
			extent.flush();
		} catch (Exception validateTotalLoanAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateTotalLoanAmount test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTotalLoanAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalLoanAmount.printStackTrace();
			node.fail(validateTotalLoanAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_023
	@Test(priority = 14)
	public void validateInputInAllocationBox() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the user is able to enter a custom amount into the allocation box/Revised")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the openDatabaseLastStep from treasury
			TreasuryPage.openDatabaseLastStep();

			// Get facility reference number
			String facilityReferenceNumber = getDataFromExcel(65);

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(66);

			// Get allocation amount
			String allocationAmount = getDataFromExcel(67);

			// Get the dynamic locator for revised
			String facilityLoanAmountLocator = TreasuryPage.getRevisedAmountLocatorInDatabase();

			// Enter the amount in allocation box/Revised
			IElementActions.clearAndInputElementUsingAction_Xpath(node, driver, facilityLoanAmountLocator,
					allocationAmount);
			node.log(Status.INFO, "STEP1 : Enter amount " + allocationAmount + " in the allocation box/Revised of loan "
					+ loanReferenceNumber + " for facility " + facilityReferenceNumber);
			System.out.println("STEP1 : Enter amount " + allocationAmount + " in the allocation box/Revised of loan "
					+ loanReferenceNumber + " for facility " + facilityReferenceNumber);

			Thread.sleep(1000);
			// Get the facility allocation amount
			String actualAllocationAmount = IElementActions.getElementValue(extenttest, driver,
					facilityLoanAmountLocator);

			// Assert the facility allocation amount
			IElementActions.assertEquals_usingString(node, driver, actualAllocationAmount, allocationAmount,
					"STEP2 : BUG : Facility allocation amount entered " + actualAllocationAmount
							+ " and is not equal to the expected allocation " + allocationAmount,
					"STEP2 : PASS : Facility allocation amount entered " + actualAllocationAmount
							+ " and is equal to the expected allocation " + allocationAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateInputInAllocationBox", "Pass", driver);
		} catch (AssertionError validateInputInAllocationBox) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInputInAllocationBox test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateInputInAllocationBox_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInputInAllocationBox.printStackTrace();
			node.fail(validateInputInAllocationBox);
			Assert.fail();
			extent.flush();
		} catch (Exception validateInputInAllocationBox) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInputInAllocationBox test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateInputInAllocationBox_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInputInAllocationBox.printStackTrace();
			node.fail(validateInputInAllocationBox);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_024
	@Test(priority = 15)
	public void validateSaveAfterAllocation() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the user clicks ‘Save’, the custom allocation amount is saved and the allocation Database is updated from the selected date onwards")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get facility reference number
			String facilityReferenceNumber = getDataFromExcel(65);

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(66);

			// Get allocation amount
			String allocationAmount = getDataFromExcel(67);

			// Calling the openDatabaseLastStep from treasury
			TreasuryPage.openDatabaseLastStep();

			// Get the facility locator
			String facilityLoanAmountLocator = TreasuryPage.addNewAllocationAndSave(facilityReferenceNumber,
					loanReferenceNumber, allocationAmount);

			// Get the facility allocation amount
			String actualAllocationAmount = IElementActions.getElementValue(extenttest, driver,
					facilityLoanAmountLocator);

			actualAllocationAmount = Utils.formatText(actualAllocationAmount);

			// Assert the facility allocation amount
			IElementActions.assertEquals_usingString(node, driver, actualAllocationAmount, allocationAmount,
					"STEP1 : BUG : Facility allocation amount entered " + actualAllocationAmount
							+ " and is not equal to the expected allocation " + allocationAmount,
					"STEP1 : BUG : Facility allocation amount entered " + actualAllocationAmount
							+ " and is not equal to the expected allocation " + allocationAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateSaveAfterAllocation", "Pass", driver);
		} catch (AssertionError validateSaveAfterAllocation) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateSaveAfterAllocation test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateSaveAfterAllocation_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSaveAfterAllocation.printStackTrace();
			node.fail(validateSaveAfterAllocation);
			Assert.fail();
			extent.flush();
		} catch (Exception validateSaveAfterAllocation) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateSaveAfterAllocation test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateSaveAfterAllocation_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSaveAfterAllocation.printStackTrace();
			node.fail(validateSaveAfterAllocation);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_025
	@Test(priority = 16)
	public void validateAllocationIfPriorAllocationIsLess() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the new allocation amount is less than the prior allocation amount, the difference (Current allocation - Revised allocation) is returned to the facility as cash")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get facility reference number
			String facilityReferenceNumber = getDataFromExcel(65);

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(66);

			// Get difference amount
			int difference = Integer.parseInt(getDataFromExcel(68));

			// Calling the openDatabaseLastStep from treasury
			TreasuryPage.openDatabaseLastStep();

			// Get the dynamic locator for current
			String currentLocator = TreasuryPage.getCurrentAmountLocatorInDatabase();

			// Wait for the visibility of the current element
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the current element");
			System.out.println("STEP1 : Waiting for the visibility of the current element");
			IWaitStrategy.waitForVisiblity(node, driver, currentLocator);
			node.log(Status.INFO, "STEP2 : Current element is visible");
			System.out.println("STEP2 : Current element is visible");

			int currentValue = Utils.getTextAndParseToInt(currentLocator);
			currentValue = currentValue - difference;

			// Get the facility locator
			String facilityLoanAmountLocator = TreasuryPage.addNewAllocationAndSave(facilityReferenceNumber,
					loanReferenceNumber, String.valueOf(Math.abs(currentValue)));

			// Create the dynamic locator for loan reference
			String differenceLocator = IElementActions.createDynamicLocatorString(TreasuryDatabasePO.differenceValue,
					"locatorValue", loanReferenceNumber);

			// Expected difference is supposed to be less
			String expectedDifference = "-" + difference;

			// Get the difference value
			String differenceValue = Utils.getFormattedTextWithSign(differenceLocator);

			// Assert the difference value
			IElementActions.assertEquals_usingString(node, driver, differenceValue, expectedDifference,
					"STEP3 : BUG : Difference between revised and current value " + differenceValue
							+ " and is not equal to the expected difference " + expectedDifference,
					"STEP3 : Pass : Difference between revised and current value " + differenceValue
							+ " and is equal to the expected difference " + expectedDifference);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAllocationIfPriorAllocationIsLess", "Pass", driver);
		} catch (AssertionError validateAllocationIfPriorAllocationIsLess) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAllocationIfPriorAllocationIsLess test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllocationIfPriorAllocationIsLess_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocationIfPriorAllocationIsLess.printStackTrace();
			node.fail(validateAllocationIfPriorAllocationIsLess);
			Assert.fail();
			extent.flush();
		} catch (Exception validateAllocationIfPriorAllocationIsLess) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAllocationIfPriorAllocationIsLess test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllocationIfPriorAllocationIsLess_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocationIfPriorAllocationIsLess.printStackTrace();
			node.fail(validateAllocationIfPriorAllocationIsLess);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_026
	@Test(priority = 17)
	public void validateAllocationIfPriorAllocationIsGreater() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that that the new allocation is greater than the prior allocation amount, the difference (new allocation - prior allocation) is deducted from the selected facility’s cash balance")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get facility reference number
			String facilityReferenceNumber = getDataFromExcel(65);

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(66);

			// Get difference amount
			int difference = Integer.parseInt(getDataFromExcel(68));

			// Calling the openDatabaseLastStep from treasury
			TreasuryPage.openDatabaseLastStep();

			// Get the dynamic locator for current
			String currentLocator = TreasuryPage.getCurrentAmountLocatorInDatabase();

			// Wait for the visibility of the current element
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the current element");
			System.out.println("STEP1 : Waiting for the visibility of the current element");
			IWaitStrategy.waitForVisiblity(node, driver, currentLocator);
			node.log(Status.INFO, "STEP2 : Current element is visible");
			System.out.println("STEP2 : Current element is visible");

			int currentValue = Utils.getTextAndParseToInt(currentLocator);
			currentValue = currentValue + difference;

			// Get the facility locator
			String facilityLoanAmountLocator = TreasuryPage.addNewAllocationAndSave(facilityReferenceNumber,
					loanReferenceNumber, String.valueOf(currentValue));

			// Create the dynamic locator for loan reference
			String differenceLocator = IElementActions.createDynamicLocatorString(TreasuryDatabasePO.differenceValue,
					"locatorValue", loanReferenceNumber);

			// Get the expected difference value
			String expectedDifference = Integer.toString(difference);

			// Get the difference value
			String differenceValue = Utils.getFormattedTextWithSign(differenceLocator);

			// Assert the difference value
			IElementActions.assertEquals_usingString(node, driver, differenceValue, expectedDifference,
					"STEP3 : BUG : Difference between revised and current value " + differenceValue
							+ " and is not equal to the expected difference " + expectedDifference,
					"STEP3 : Pass : Difference between revised and current value " + differenceValue
							+ " and is equal to the expected difference " + expectedDifference);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAllocationIfPriorAllocationIsGreater", "Pass", driver);
		} catch (AssertionError validateAllocationIfPriorAllocationIsGreater) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAllocationIfPriorAllocationIsGreater test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllocationIfPriorAllocationIsGreater_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocationIfPriorAllocationIsGreater.printStackTrace();
			node.fail(validateAllocationIfPriorAllocationIsGreater);
			Assert.fail();
			extent.flush();
		} catch (Exception validateAllocationIfPriorAllocationIsGreater) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAllocationIfPriorAllocationIsGreater test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllocationIfPriorAllocationIsGreater_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocationIfPriorAllocationIsGreater.printStackTrace();
			node.fail(validateAllocationIfPriorAllocationIsGreater);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_028
	@Test(priority = 18)
	public void validateFacilityAmountInStep2() throws IOException {
		try {
			extenttest = extent.createTest("Validate the 'Facility Amount'")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadTreasuryDatabasePage from treasury
			TreasuryPage.loadTreasuryDatabasePage();

			List<String> facilitiesAmount = Utils.extractTextFromElements(TreasuryDatabasePO.facilitiesAmount);

			// Calling the bottomNextStepButton function from Funding Page
			FundingPage.bottomNextStepButton(TreasuryDatabasePO.nextStepButton, 2, "Database");

			// Wait for the visibility of the amend facility allocations
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the amend facility allocations");
			System.out.println("STEP1 : Waiting for the visibility of the amend facility allocations");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryDatabasePO.amendFacilityAllocations);
			node.log(Status.INFO, "STEP2 : Amend facility allocations is visible");
			System.out.println("STEP2 : Amend facility allocations is visible");

			List<String> facilitiesAmountInStep2 = Utils
					.extractTextFromElements(TreasuryDatabasePO.facilitiesAmountInStep2);

			// Validate facilities amount
			Utils.validateList(facilitiesAmount, facilitiesAmountInStep2,
					"Facilities amount in step2 is not equal to the facilities amount at Step1",
					"Facilities amount in step2 is equal to the facilities amount at Step1");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityAmountInStep2", "Pass", driver);
		} catch (AssertionError validateFacilityAmountInStep2) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityAmountInStep2 test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityAmountInStep2_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityAmountInStep2.printStackTrace();
			node.fail(validateFacilityAmountInStep2);
			Assert.fail();
			extent.flush();
		} catch (Exception validateFacilityAmountInStep2) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityAmountInStep2 test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityAmountInStep2_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityAmountInStep2.printStackTrace();
			node.fail(validateFacilityAmountInStep2);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_029
	@Test(priority = 19)
	public void validateDrawnAmountInStep2() throws IOException {
		try {
			extenttest = extent.createTest("Validate the 'Drawn Amount'")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadTreasuryDatabasePage from treasury
			TreasuryPage.loadTreasuryDatabasePage();

			List<String> facilitiesDrawnAmount = Utils
					.extractTextFromElements(TreasuryDatabasePO.facilitiesDrawnAmount);

			// Calling the bottomNextStepButton function from Funding Page
			FundingPage.bottomNextStepButton(TreasuryDatabasePO.nextStepButton, 2, "Database");

			// Wait for the visibility of the amend facility allocations
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the amend facility allocations");
			System.out.println("STEP1 : Waiting for the visibility of the amend facility allocations");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryDatabasePO.amendFacilityAllocations);
			node.log(Status.INFO, "STEP2 : Amend facility allocations is visible");
			System.out.println("STEP2 : Amend facility allocations is visible");

			List<String> drawnAmountInStep2 = Utils.extractTextFromElements(TreasuryDatabasePO.drawnAmountInStep2);

			// Validate drawn amount
			Utils.validateList(facilitiesDrawnAmount, drawnAmountInStep2,
					"Drawn amount in step2 is not equal to the drawn amount at Step1",
					"Drawn amount in step2 is equal to the drawn amount at Step1");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDrawnAmountInStep2", "Pass", driver);
		} catch (AssertionError validateDrawnAmountInStep2) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDrawnAmountInStep2 test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDrawnAmountInStep2_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDrawnAmountInStep2.printStackTrace();
			node.fail(validateDrawnAmountInStep2);
			Assert.fail();
			extent.flush();
		} catch (Exception validateDrawnAmountInStep2) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDrawnAmountInStep2 test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDrawnAmountInStep2_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDrawnAmountInStep2.printStackTrace();
			node.fail(validateDrawnAmountInStep2);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_030
	@Test(priority = 20)
	public void validateAllocatedAmountInStep2() throws IOException {
		try {
			extenttest = extent.createTest("Validate the 'Allocated Amount'")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadTreasuryDatabasePage from treasury
			TreasuryPage.loadTreasuryDatabasePage();

			List<String> facilitiesAllocatedAmount = Utils
					.extractTextFromElements(TreasuryDatabasePO.facilitiesAllocatedAmount);

			// Calling the bottomNextStepButton function from Funding Page
			FundingPage.bottomNextStepButton(TreasuryDatabasePO.nextStepButton, 2, "Database");

			// Wait for the visibility of the amend facility allocations
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the amend facility allocations");
			System.out.println("STEP1 : Waiting for the visibility of the amend facility allocations");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryDatabasePO.amendFacilityAllocations);
			node.log(Status.INFO, "STEP2 : Amend facility allocations is visible");
			System.out.println("STEP2 : Amend facility allocations is visible");

			List<String> currentAllocatedAmountInStep2 = Utils
					.getEvenPositionElements(TreasuryDatabasePO.allocatedAmountInStep2);

			// Validate allocated amount
			Utils.validateList(facilitiesAllocatedAmount, currentAllocatedAmountInStep2,
					"Allocated amount in step2 is not equal to the allocation amount at Step1",
					"Allocated amount in step2 is equal to the allocation amount at Step1");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAllocatedAmountInStep2", "Pass", driver);
		} catch (AssertionError validateAllocatedAmountInStep2) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAllocatedAmountInStep2 test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllocatedAmountInStep2_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocatedAmountInStep2.printStackTrace();
			node.fail(validateAllocatedAmountInStep2);
			Assert.fail();
			extent.flush();
		} catch (Exception validateAllocatedAmountInStep2) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAllocatedAmountInStep2 test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateAllocatedAmountInStep2_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocatedAmountInStep2.printStackTrace();
			node.fail(validateAllocatedAmountInStep2);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_031
	@Test(priority = 21)
	public void validateCash() throws IOException {
		try {
			extenttest = extent
					.createTest("Validate the 'Cash' Current/ Revised Cash = Drawn amount - Allocated Amount")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the openDatabaseLastStep from treasury
			TreasuryPage.openDatabaseLastStep();

			// Get all the facilities drawn amount
			List<String> drawnAmountInStep2 = Utils.extractTextFromElements(TreasuryDatabasePO.drawnAmountInStep2);

			// Get current allocation amount
			List<String> currentAmountInStep2 = Utils
					.getEvenPositionElements(TreasuryDatabasePO.allocatedAmountInStep2);

			// Get revised allocation amount
			List<String> revisedAllocatedAmountInStep2 = Utils
					.getOddPositionElements(TreasuryDatabasePO.allocatedAmountInStep2);

			// Get difference between drawn and current allocation amount
			List<String> currentDifferenceList = Utils.calculateDifferences(drawnAmountInStep2, currentAmountInStep2);

			// Get difference between drawn and revised allocation amount
			List<String> revisedDifferenceList = Utils.calculateDifferences(drawnAmountInStep2,
					revisedAllocatedAmountInStep2);

			// Get current cash amount
			List<String> currentCashInStep2 = Utils.getEvenPositionElements(TreasuryDatabasePO.cashInStep2);

			// Get revised cash amount
			List<String> revisedCashInStep2 = Utils.getOddPositionElements(TreasuryDatabasePO.cashInStep2);

			// Validate current cash
			Utils.validateList(currentDifferenceList, currentCashInStep2,
					"Difference between drawn and current allocation amount is not equal to current cash",
					"Difference between drawn and current allocation amount is equal to current cash");

			// Validate revised cash
			Utils.validateList(revisedDifferenceList, revisedCashInStep2,
					"Difference between drawn and revised allocation amount is not equal to revised cash",
					"Difference between drawn and revised allocation amount is equal to revised cash");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCash", "Pass", driver);
		} catch (AssertionError validateCash) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCash test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCash_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCash.printStackTrace();
			node.fail(validateCash);
			Assert.fail();
			extent.flush();
		} catch (Exception validateCash) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCash test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCash_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCash.printStackTrace();
			node.fail(validateCash);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_032
	@Test(priority = 22)
	public void validateCashPercentage() throws IOException {
		try {
			extenttest = extent
					.createTest("Validate the 'Cash%'"
							+ "Current cash % is calculated as (100 * (current cash)/drawn amount)"
							+ "Revised cash % is calculated as (100 * (revised cash)/drawn amount)")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the openDatabaseLastStep from treasury
			TreasuryPage.openDatabaseLastStep();

			// Get all the facilities drawn amount
			List<String> drawnAmountInStep2 = Utils.extractTextFromElements(TreasuryDatabasePO.drawnAmountInStep2);

			// Get current allocation amount
			List<String> currentAmountInStep2 = Utils
					.getEvenPositionElements(TreasuryDatabasePO.allocatedAmountInStep2);

			// Get revised allocation amount
			List<String> revisedAmountInStep2 = Utils.getOddPositionElements(TreasuryDatabasePO.allocatedAmountInStep2);

			// Get difference between drawn and current allocation amount
			List<String> currentQuotientsList = Utils.calculateQuotients(currentAmountInStep2, drawnAmountInStep2);

			// Get difference between drawn and revised allocation amount
			List<String> revisedQuotientsList = Utils.calculateQuotients(revisedAmountInStep2, drawnAmountInStep2);

			// Get current cash percentage
			List<String> currentCashPercentageInStep2 = Utils
					.getEvenPositionElements(TreasuryDatabasePO.cashPercentageInStep2);

			// Get revised cash percentage
			List<String> revisedCashPercentageInStep2 = Utils
					.getOddPositionElements(TreasuryDatabasePO.cashPercentageInStep2);

			// Validate current cash %
			Utils.validateList(currentQuotientsList, currentCashPercentageInStep2,
					"Calculated current cash % is not equal to expected current cash percentage",
					"Calculated current cash % is equal to expected current cash percentage");

			// Validate revised cash %
			Utils.validateList(revisedQuotientsList, revisedCashPercentageInStep2,
					"Calculated revised cash % is not equal to expected revised cash percentage",
					"Calculated revised cash % is equal to expected revised cash percentage");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashPercentage", "Pass", driver);
		} catch (AssertionError validateCashPercentage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashPercentage test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCashPercentage_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashPercentage.printStackTrace();
			node.fail(validateCashPercentage);
			Assert.fail();
			extent.flush();
		} catch (Exception validateCashPercentage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashPercentage test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCashPercentage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashPercentage.printStackTrace();
			node.fail(validateCashPercentage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_039
	// TC_Treasury_Database_040
	@Test(priority = 23)
	public void validateComplianceCriteria() throws IOException {
		try {
			extenttest = extent.createTest(
					"RedTick : Validate that the facility displayed as having a red tick if breached 'Compliance'"
							+ "GreenTick : Validate that the facility displayed as having a green tick if meets 'Compliance' criteria")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the openDatabaseLastStep from treasury
			TreasuryPage.openDatabaseLastStep();

			// Get facility reference number
			String facilityReferenceNumber = getDataFromExcel(65);

			// Get the facility position
			int facilityPosition = TreasuryPage.getFacilityPosition(facilityReferenceNumber);

			Thread.sleep(1000);
			// Create the dynamic locator for facility current amount
			String showIconButton = IElementActions.createDynamicLocatorString(TreasuryDatabasePO.showDetails,
					"facilityPosition", Integer.toString(facilityPosition));

			// Create the dynamic locator for facility current amount
			String complianceTickMarck = IElementActions.createDynamicLocatorString(
					TreasuryDatabasePO.complianceTickMarck, "facilityPosition", Integer.toString(facilityPosition));

			String color = null;

			// Wait for the visibility of popup
			node.log(Status.INFO, "STEP1 : Waiting for the check icon to visible and clickable");
			System.out.println("STEP1 :  Waiting for the check icon to visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, showIconButton);
			IWaitStrategy.WaitUntilElementClickable(node, driver, showIconButton);
			node.log(Status.INFO, "STEP2 : The check icon is visible and clickable");
			System.out.println("STEP2 : The check icon is visible and clickable");

			// Get the value of the class attribute for the button element
			String attributeValue = IElementActions.getElementTextFromAttribute_usingXpath(node, driver,
					complianceTickMarck, "class");

			System.out.println("attributeValue " + attributeValue);

			// Check if the class attribute contains the desired value
			if (attributeValue.contains("text-success")) {
				node.log(Status.INFO, "STEP3 : Facility contains the desired value green");
				System.out.println("STEP3 : Facility contains the desired value green");
				color = "green";
			} else if (attributeValue.contains("text-danger")) {
				node.log(Status.INFO, "STEP3 : Facility contains the desired value red");
				System.out.println("STEP3 : Facility contains the desired value red");
				color = "red";
			}

			// Click on the check to open the popup
			IElementActions.clickelement_usingXpath(node, driver, showIconButton);
			node.log(Status.INFO, "STEP4 : Clicked on the check icon");
			System.out.println("STEP4 : Clicked on the check icon");

			// Wait for the visibility of popup
			node.log(Status.INFO, "STEP5 : Waiting for the visibility of the popup");
			System.out.println("STEP5 : Waiting for the visibility of the popup");
			IWaitStrategy.waitForVisiblity(node, driver, UtilsPO.popUp);
			node.log(Status.INFO, "STEP6 : The popup is visible");
			System.out.println("STEP6 : The popup is visible");

			int failCount = 0;

			// Wait for the visibility of element
			node.log(Status.INFO, "STEP7 : Waiting for the visibility of the single loan max percentage amount");
			System.out.println("STEP7 : Waiting for the visibility of the single loan max percentage amount");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryDatabasePO.singleLoanMaxPercentageValue);
			node.log(Status.INFO, "STEP8 : The single loan max percentage amount is visible");
			System.out.println("STEP8 : The single loan max percentage amount is visible");

			Double singleLoanMaxPercentageAmount = Utils
					.getTextAndParseToDouble(TreasuryDatabasePO.singleLoanMaxPercentageValue);
			Double singleLoanMaxPercentageCriteriaAmount = Utils
					.getTextAndParseToDouble(TreasuryDatabasePO.singleLoanMaxPercentageCriteria);

			Double singleBorrowerMaxAmount = Utils.getTextAndParseToDouble(TreasuryDatabasePO.singleBorrowerMaxValue);
			Double singleBorrowerMaxCriteriaAmount = Utils
					.getTextAndParseToDouble(TreasuryDatabasePO.singleBorrowerMaxCriteria);

			Double maxCumulativeSecondChargesAmount = Utils
					.getTextAndParseToDouble(TreasuryDatabasePO.maxCumulativeSecondChargesValue);
			Double maxCumulativeSecondChargesCriteriaAmount = Utils
					.getTextAndParseToDouble(TreasuryDatabasePO.maxCumulativeSecondChargesCriteria);

			Double maxCommercialPropertiesAmount = Utils
					.getTextAndParseToDouble(TreasuryDatabasePO.maxCommercialPropertiesValue);
			Double maxCommercialPropertiesCriteriaAmount = Utils
					.getTextAndParseToDouble(TreasuryDatabasePO.maxCommercialPropertiesCriteria);

			Double maxDevelopmentPropertiesAmount = Utils
					.getTextAndParseToDouble(TreasuryDatabasePO.maxDevelopmentPropertiesValue);
			Double maxDevelopmentPropertiesCriteriaAmount = Utils
					.getTextAndParseToDouble(TreasuryDatabasePO.maxDevelopmentPropertiesCriteria);

			// Check if the element has the limit-respected
			if ((singleLoanMaxPercentageAmount < singleLoanMaxPercentageCriteriaAmount
					&& singleBorrowerMaxAmount < singleBorrowerMaxCriteriaAmount
					&& maxCumulativeSecondChargesAmount < maxCumulativeSecondChargesCriteriaAmount
					&& maxCommercialPropertiesAmount < maxCommercialPropertiesCriteriaAmount
					&& maxDevelopmentPropertiesAmount < maxDevelopmentPropertiesCriteriaAmount)
					&& (attributeValue.contains("text-success"))) {
				node.log(Status.INFO, "Compliance is highlighted in green for " + facilityReferenceNumber
						+ ", as expected single loan max percentage amount " + singleLoanMaxPercentageAmount
						+ " is less than single loan max percentage criteria amount "
						+ singleLoanMaxPercentageCriteriaAmount + " and single borrower max amount "
						+ singleBorrowerMaxAmount + " is less than single borrower max criteria amount "
						+ singleBorrowerMaxCriteriaAmount + " and max cumulative second charges amount "
						+ maxCumulativeSecondChargesAmount
						+ " is less than max cumulative second charges criteria amount "
						+ maxCumulativeSecondChargesCriteriaAmount + " and max commercial properties amount "
						+ maxCommercialPropertiesAmount + " is less than max commercial properties criteria amount "
						+ maxCommercialPropertiesCriteriaAmount + " and max development properties amount "
						+ maxDevelopmentPropertiesAmount + " is less than max development properties criteria amount "
						+ maxDevelopmentPropertiesCriteriaAmount);
				System.out.println("Compliance is highlighted in green for " + facilityReferenceNumber
						+ ", as expected single loan max percentage amount " + singleLoanMaxPercentageAmount
						+ " is less than single loan max percentage criteria amount "
						+ singleLoanMaxPercentageCriteriaAmount + " and single borrower max amount "
						+ singleBorrowerMaxAmount + " is less than single borrower max criteria amount "
						+ singleBorrowerMaxCriteriaAmount + " and max cumulative second charges amount "
						+ maxCumulativeSecondChargesAmount
						+ " is less than max cumulative second charges criteria amount "
						+ maxCumulativeSecondChargesCriteriaAmount + " and max commercial properties amount "
						+ maxCommercialPropertiesAmount + " is less than max commercial properties criteria amount "
						+ maxCommercialPropertiesCriteriaAmount + " and max development properties amount "
						+ maxDevelopmentPropertiesAmount + " is less than max development properties criteria amount "
						+ maxDevelopmentPropertiesCriteriaAmount);
			} else if ((singleLoanMaxPercentageAmount > singleLoanMaxPercentageCriteriaAmount
					|| singleBorrowerMaxAmount > singleBorrowerMaxCriteriaAmount
					|| maxCumulativeSecondChargesAmount > maxCumulativeSecondChargesCriteriaAmount
					|| maxCommercialPropertiesAmount > maxCommercialPropertiesCriteriaAmount
					|| maxDevelopmentPropertiesAmount > maxDevelopmentPropertiesCriteriaAmount)
					&& (attributeValue.contains("text-danger"))) {

				node.log(Status.INFO,
						"Compliance is highlighted in red for " + facilityReferenceNumber
								+ ", as expected single loan max percentage amount " + singleLoanMaxPercentageAmount
								+ " may be greater than single loan max percentage criteria amount "
								+ singleLoanMaxPercentageCriteriaAmount + " or single borrower max amount "
								+ singleBorrowerMaxAmount + " may be greater than single borrower max criteria amount "
								+ singleBorrowerMaxCriteriaAmount + " or max cumulative second charges amount "
								+ maxCumulativeSecondChargesAmount
								+ " may be greater than max cumulative second charges criteria amount "
								+ maxCumulativeSecondChargesCriteriaAmount + " or max commercial properties amount "
								+ maxCommercialPropertiesAmount
								+ " may be greater than max commercial properties criteria amount "
								+ maxCommercialPropertiesCriteriaAmount + " or max development properties amount "
								+ maxDevelopmentPropertiesAmount
								+ " may be greater than max development properties criteria amount "
								+ maxDevelopmentPropertiesCriteriaAmount);
				System.out.println("Compliance is highlighted in red for " + facilityReferenceNumber
						+ ", as expected single loan max percentage amount " + singleLoanMaxPercentageAmount
						+ " may be greater than single loan max percentage criteria amount "
						+ singleLoanMaxPercentageCriteriaAmount + " or single borrower max amount "
						+ singleBorrowerMaxAmount + " may be greater than single borrower max criteria amount "
						+ singleBorrowerMaxCriteriaAmount + " or max cumulative second charges amount "
						+ maxCumulativeSecondChargesAmount
						+ " may be greater than max cumulative second charges criteria amount "
						+ maxCumulativeSecondChargesCriteriaAmount + " or max commercial properties amount "
						+ maxCommercialPropertiesAmount
						+ " may be greater than max commercial properties criteria amount "
						+ maxCommercialPropertiesCriteriaAmount + " or max development properties amount "
						+ maxDevelopmentPropertiesAmount
						+ " may be greater than max development properties criteria amount "
						+ maxDevelopmentPropertiesCriteriaAmount);

			} else {
				failCount++;
			}

			// Assert element is highlighted in red and green as per expected criteri
			if (failCount == 0) {
				node.log(Status.INFO, "Compliance is highlighted in red and green as per expected criteria");
				System.out.println("Compliance is highlighted in red and green as per expected criteria");

				Assert.assertTrue(true, "Compliance is highlighted in red and green as per expected criteria");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateComplianceCriteria", "Pass", driver);
			} else {
				System.out.println("Compliance is not highlighted in red and green as per expected criteria");
				node.log(Status.INFO, "Compliance is not highlighted in red and green as per expected criteria");

				Assert.assertTrue(false, "Compliance is not highlighted in red and green as per expected criteria");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateComplianceCriteria", "Fail", driver);
			}

			// Click on popup close button
			IElementActions.clickelement_usingXpath(node, driver, TreasurySinglePO.closeIcon);
			node.log(Status.INFO, "STEP9 : Clicked on the close icon");
			System.out.println("STEP9 : Clicked on the close icon");

			// Wait for the invisibility of the PopUp
			node.log(Status.INFO, "STEP10 : Waiting for the invisibility of the popup");
			System.out.println("STEP10 : Waiting for the invisibility of the popup");
			IWaitStrategy.waitForInVisiblity(node, driver, UtilsPO.popUp);
			node.log(Status.INFO, "STEP11 : Popup is not visible");
			System.out.println("STEP12 : Popup is not visible");

		} catch (AssertionError validateComplianceCriteria) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateComplianceCriteria test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateComplianceCriteria_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateComplianceCriteria.printStackTrace();
			node.fail(validateComplianceCriteria);
			Assert.fail();
			extent.flush();
		} catch (Exception validateComplianceCriteria) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateComplianceCriteria test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateComplianceCriteria_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateComplianceCriteria.printStackTrace();
			node.fail(validateComplianceCriteria);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_041
	@Test(priority = 24)
	public void validateAllocationProfile() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that when the user is navigated to update 'Amend Facility Allocations', a table showing the allocation profile of each facility to each loan is displayed, showing the current allocation as well as a preview of the revised allocation values")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the openDatabaseLastStep from treasury
			TreasuryPage.openDatabaseLastStep();

			Thread.sleep(1000);
			// Get the dynamic locator for current
			String currentLocator = TreasuryPage.getCurrentAmountLocatorInDatabase();

			// Get the dynamic locator for revised
			String revisedLocator = TreasuryPage.getRevisedAmountLocatorInDatabase();

			// Check the visibility of current locator
			IElementActions.assertTrue_usingXpath(node, driver, currentLocator,
					"STEP1 : BUG : The current allocation value is not displayed",
					"STEP1 : EXPECTED : The current allocation value is displayed");

			// Check the visibility of revised locator
			IElementActions.assertTrue_usingXpath(node, driver, revisedLocator,
					"STEP2 : BUG : The revised allocation value is not displayed",
					"STEP2 : EXPECTED : The revised allocation value is displayed");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAllocationProfile", "Pass", driver);
		} catch (AssertionError validateAllocationProfile) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAllocationProfile test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAllocationProfile_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocationProfile.printStackTrace();
			node.fail(validateAllocationProfile);
			Assert.fail();
			extent.flush();
		} catch (Exception validateAllocationProfile) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAllocationProfile test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAllocationProfile_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocationProfile.printStackTrace();
			node.fail(validateAllocationProfile);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_042
	@Test(priority = 25)
	public void validateSuccessMessageAfterAmend() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that users can amend any individual allocations on a facility to a loan and able to save the changes with a success message 'Allocations have been updated succesfully!'")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the openDatabaseLastStep from treasury
			TreasuryPage.openDatabaseLastStep();

			// Get facility reference number
			String facilityReferenceNumber = getDataFromExcel(65);

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(66);

			// Get allocation amount
			String allocationAmount = getDataFromExcel(67);

			// Get the dynamic locator for revised
			String facilityLoanAmountLocator = TreasuryPage.getRevisedAmountLocatorInDatabase();

			// Enter the amount in allocation box/Revised
			IElementActions.clearAndInputElementUsingAction_Xpath(node, driver, facilityLoanAmountLocator,
					allocationAmount);
			node.log(Status.INFO, "STEP1 : Enter amount " + allocationAmount + " in the allocation box/Revised of loan "
					+ loanReferenceNumber + " for facility " + facilityReferenceNumber);
			System.out.println("STEP1 : Enter amount " + allocationAmount + " in the allocation box/Revised of loan "
					+ loanReferenceNumber + " for facility " + facilityReferenceNumber);

			IElementActions.scrollToBottom(driver);
			node.log(Status.INFO, "STEP2 : Scrolled down to the bottom of page");
			System.out.println("STEP2 : Scrolled down to the bottom of page");

			// Wait for the visibility of the PopUp
			node.log(Status.INFO, "STEP3 : Waiting for the visibility of the save button");
			System.out.println("STEP3 : Waiting for the visibility of the save button");
			IWaitStrategy.waitForVisiblity(node, driver, UtilsPO.saveButton);
			node.log(Status.INFO, "STEP4 : Save button is visible");
			System.out.println("STEP4 : Save button is visible");

			// Click on the save button
			IElementActions.clickelement_usingXpath(node, driver, UtilsPO.saveButton);
			node.log(Status.INFO, "STEP5 : Clicked on the save button");
			System.out.println("STEP5 : Clicked on the save button");

			Thread.sleep(2000);
			// Wait for the visibility of element
			node.log(Status.INFO, "STEP6 : Waiting for the visibility of the popup");
			System.out.println("STEP6 : Waiting for the visibility of the popup");
			IWaitStrategy.waitForVisiblity(node, driver, UtilsPO.popUp);
			node.log(Status.INFO, "STEP7 : The popup is visible");
			System.out.println("STEP7 : The popup is visible");

			// Get the popup message
			String actualMessage = IElementActions.getElementText_usingXpath(node, driver,
					TreasuryDatabasePO.popupMessage);

			String expectedMessage = "Allocations have been updated succesfully!";

			// Assert the facility amount
			IElementActions.assertEquals_usingString(node, driver, actualMessage, expectedMessage,
					"STEP8 : BUG : " + actualMessage + " appears and is not equal to the expected message "
							+ expectedMessage,
					"STEP8 : EXPECTED : " + actualMessage + " appears and is equal to the expected message "
							+ expectedMessage);

			// Click on popup close button
			IElementActions.clickelement_usingXpath(node, driver, PipelinePO.closeButtonInPopup);
			node.log(Status.INFO, "STEP9 : Clicked on the close icon");
			System.out.println("STEP9 : Clicked on the close icon");

			// Wait for the visibility of the PopUp
			node.log(Status.INFO, "STEP10 : Waiting for the invisibility of the popup");
			System.out.println("STEP10 : Waiting for the invisibility of the popup");
			IWaitStrategy.waitForInVisiblity(node, driver, UtilsPO.popUp);
			node.log(Status.INFO, "STEP11 : Popup is not visible");
			System.out.println("STEP11 : Popup is not visible");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateSuccessMessageAfterAmend", "Pass", driver);

		} catch (AssertionError validateSuccessMessageAfterAmend) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateSuccessMessageAfterAmend test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateSuccessMessageAfterAmend_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSuccessMessageAfterAmend.printStackTrace();
			node.fail(validateSuccessMessageAfterAmend);
			Assert.fail();
			extent.flush();
		} catch (Exception validateSuccessMessageAfterAmend) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateSuccessMessageAfterAmend test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateSuccessMessageAfterAmend_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSuccessMessageAfterAmend.printStackTrace();
			node.fail(validateSuccessMessageAfterAmend);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_043
	@Test(priority = 26)
	public void validateRevisedAndCurrentAllocationAfterSave() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that when the user has made any amendments and pressed “Save”,  the allocations will update so that the Revised allocation becomes the Current allocation displayed in update 'Amend Facility Allocations' screen")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get facility reference number
			String facilityReferenceNumber = getDataFromExcel(65);

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(66);

			// Get allocation amount
			String allocationAmount = getDataFromExcel(67);

			// Calling the openDatabaseLastStep from treasury
			TreasuryPage.openDatabaseLastStep();

			// Get the facility locator
			String facilityLoanAmountLocator = TreasuryPage.addNewAllocationAndSave(facilityReferenceNumber,
					loanReferenceNumber, allocationAmount);

			// Calling the openDatabaseLastStep from treasury
			TreasuryPage.openDatabaseLastStep();

			Thread.sleep(1000);
			// Get the dynamic locator for current
			String currentLocator = TreasuryPage.getCurrentAmountLocatorInDatabase();

			// Get the dynamic locator for revised
			String revisedLocator = TreasuryPage.getRevisedAmountLocatorInDatabase();

			// Wait for the visibility of the current element
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the current element");
			System.out.println("STEP1 : Waiting for the visibility of the current element");
			IWaitStrategy.waitForVisiblity(node, driver, currentLocator);
			node.log(Status.INFO, "STEP2 : Current element is visible");
			System.out.println("STEP2 : Current element is visible");

			// Get the current value
			String currentValue = IElementActions.getElementText_usingXpath(node, driver, currentLocator);

			// Get the revised value
			String revisedValue = IElementActions.getElementValue(extenttest, driver, revisedLocator);

			// Assert the current and revised value
			IElementActions.assertEquals_usingString(node, driver, currentValue, revisedValue,
					"STEP3 : BUG : Current value " + currentValue + " is not equal to the revised value "
							+ revisedValue,
					"STEP3 : PASS : Current value " + currentValue + " is not equal to the revised value "
							+ revisedValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateRevisedAndCurrentAllocationAfterSave", "Pass", driver);

		} catch (AssertionError validateRevisedAndCurrentAllocationAfterSave) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateRevisedAndCurrentAllocationAfterSave test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRevisedAndCurrentAllocationAfterSave_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRevisedAndCurrentAllocationAfterSave.printStackTrace();
			node.fail(validateRevisedAndCurrentAllocationAfterSave);
			Assert.fail();
			extent.flush();
		} catch (Exception validateRevisedAndCurrentAllocationAfterSave) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateRevisedAndCurrentAllocationAfterSave test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateRevisedAndCurrentAllocationAfterSave_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRevisedAndCurrentAllocationAfterSave.printStackTrace();
			node.fail(validateRevisedAndCurrentAllocationAfterSave);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Database_044
	@Test(priority = 27)
	public void validateBackButton() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the user can back to selection from update by clicking on back button")
					.assignCategory(treasuryDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the openDatabaseLastStep from treasury
			TreasuryPage.openDatabaseLastStep();

			// Calling the bottomBackStepButton function from Funding Page
			FundingPage.bottomBackStepButton(UtilsPO.backStepButton, 2, "Amend Allocations");

			// Wait for the visibility of Treasury Database page
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of Treasury Database page");
			System.out.println("STEP1 : Waiting for the visibility of Treasury Database page");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryDatabasePO.loanRows);
			IWaitStrategy.WaitUntilElementClickable(node, driver, TreasuryDatabasePO.loanRows);
			node.log(Status.INFO, "STEP2 : Treasury Database page is visible");
			System.out.println("STEP2 : Treasury Database page is visible");

			Thread.sleep(2000);
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			// Calling the validateUrl from Utils
			Utils.validateUrl(node, driver, currentUrl, AllPagesUrl.TreasuryDatabasePage, "validateDatabaseTreasury");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateBackButton", "Pass", driver);
		} catch (AssertionError validateBackButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateBackButton test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateBackButton_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBackButton.printStackTrace();
			node.fail(validateBackButton);
			Assert.fail();
			extent.flush();
		} catch (Exception validateBackButton) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateBackButton test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateBackButton_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBackButton.printStackTrace();
			node.fail(validateBackButton);
			Assert.fail();
			extent.flush();
		}
	}
}
