package com.Treasury.tests;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.locators.allPages.LoansNewLoanPO;
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
import com.qa.utils.LoansPage;
import com.qa.utils.LoginPage;
import com.qa.utils.TreasuryPage;
import com.qa.utils.Utils;

public class PortfolioTest extends Baseclass {

	// TC_Treasury_Portfolio_001
	@Test(priority = 1)
	public void validatePortfolioTreasury() throws IOException {

		try {
			extenttest = extent
					.createTest(
							"Verify that the user can access the Portfolio treasury menu from the side menu options.")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadLoginPage function from the login
			LoginPage.loadLoginPage();

			// Calling the userLoginProcess function from the LoginPage
			LoginPage.userLoginProcess(node, driver, getDataFromExcel(1), getDataFromExcel(2));

			// Click on the Treasury Menu
			Utils.clickOnMenu(node, driver, SideMenuPO.treasury);

			// Click on the Portfolio Treasury Sub Menu
			Utils.clickOnMenu(node, driver, SideMenuPO.portfolioTreasury);

			// Wait for the visibility of Portfolio Treasury page
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of Portfolio Treasury page");
			System.out.println("STEP1 : Waiting for the visibility of Pipeline Database page");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryPortfolioPO.step1Text);
			node.log(Status.INFO, "STEP2 : Portfolio Treasury page is visible");
			System.out.println("STEP2 : Portfolio Treasury page is visible");

			Thread.sleep(2000);
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			// Calling the validateUrl from Utils
			Utils.validateUrl(node, driver, currentUrl, AllPagesUrl.TreasuryPortfolioPage, "validatePortfolioTreasury");

		} catch (AssertionError validatePortfolioTreasury) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePortfolioTreasury test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatePortfolioTreasury_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePortfolioTreasury.printStackTrace();
			node.fail(validatePortfolioTreasury);
			Assert.fail();
			extent.flush();
		} catch (Exception validatePortfolioTreasury) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePortfolioTreasury test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatePortfolioTreasury_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePortfolioTreasury.printStackTrace();
			node.fail(validatePortfolioTreasury);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_003
	@Test(priority = 2)
	public void validatePortfolioSteps() throws IOException {

		try {
			extenttest = extent.createTest("Verify the sections under the Portfolio treasury page")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadPortfolioPage from treasury
			TreasuryPage.loadPortfolioPage();

			// Check the visibility of step1
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryPortfolioPO.step1Text,
					"STEP1 : BUG : New Faciliy Allocations in step1 is not coming under portfolio page",
					"STEP1 : EXPECTED : New Faciliy Allocations in step1 is coming under portfolio page");

			// Check the visibility of step2
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryPortfolioPO.step2Text,
					"STEP2 : BUG : Target Specification in step2 is not coming under portfolio page",
					"STEP2 : EXPECTED : Target Specification in step2 is coming under portfolio page");

			// Check the visibility of step3
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryPortfolioPO.step3Text,
					"STEP3 : BUG : Reallocate Loans in step3 is not coming under portfolio page",
					"STEP3 : EXPECTED : Reallocate Loans in step3 is coming under portfolio page");

			// Check the visibility of step4
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryPortfolioPO.step4Text,
					"STEP4 : BUG : Amend Allocations in step4 is not coming under portfolio page",
					"STEP4 : EXPECTED : Amend Allocations in step4 is coming under portfolio page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validatePortfolioSteps", "Pass", driver);

		} catch (AssertionError validatePortfolioSteps) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePortfolioSteps test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatePortfolioSteps_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePortfolioSteps.printStackTrace();
			node.fail(validatePortfolioSteps);
			Assert.fail();
			extent.flush();
		} catch (Exception validatePortfolioSteps) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePortfolioSteps test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatePortfolioSteps_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePortfolioSteps.printStackTrace();
			node.fail(validatePortfolioSteps);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_004
	@Test(priority = 3)
	public void validateNewFacilityAllocationsStep1Highlighted() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the Step1 New Facility Allocations is highlighted when the user is in step1 of the Portfolio page")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadPortfolioPage from treasury
			TreasuryPage.loadPortfolioPage();

			// Check if the 'step--current' is present in the class attribute
			boolean isHighlighted = IElementActions
					.checkAttributePresentInClass(TreasuryPortfolioPO.newFaciliyAllocationsStep, "step--current");

			// Assert New FacilityAllocations step is highlighted or not
			if (isHighlighted) {
				node.log(Status.INFO, "SUB-STEP_0.001 :The Step 1 New Faciliy Allocations is highlighted");
				System.out.println("SUB-STEP_0.001 : The Step 1 New Faciliy Allocations is highlighted");

				Assert.assertTrue(true, "The Step 1 New Faciliy Allocations is highlighted");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateNewFacilityAllocationsStep1Highlighted", "Pass",
						driver);
			} else {
				System.out.println("SUB-STEP_0.001 : The Step 1 New Faciliy Allocations is not highlighted");
				node.log(Status.INFO, "SUB-STEP_0.001 :The Step 1 New Faciliy Allocations is not highlighted");

				Assert.assertTrue(false, "The Step 1 New Faciliy Allocations is not highlighted");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateNewFacilityAllocationsStep1Highlighted", "Fail",
						driver);
			}
		} catch (AssertionError validateNewFacilityAllocationsStep1Highlighted) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNewFacilityAllocationsStep1Highlighted test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNewFacilityAllocationsStep1Highlighted_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNewFacilityAllocationsStep1Highlighted.printStackTrace();
			node.fail(validateNewFacilityAllocationsStep1Highlighted);
			Assert.fail();
			extent.flush();
		} catch (Exception validateNewFacilityAllocationsStep1Highlighted) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNewFacilityAllocationsStep1Highlighted test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNewFacilityAllocationsStep1Highlighted_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNewFacilityAllocationsStep1Highlighted.printStackTrace();
			node.fail(validateNewFacilityAllocationsStep1Highlighted);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_014
	@Test(priority = 4)
	public void validateTargetSpecificationStep2Highlighted() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user has selected a date, when they click on Step 2 the Funding Summary should be visible")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadPortfolioPage from treasury
			TreasuryPage.loadPortfolioPage();

			IElementActions.clickelement_usingXpath(node, driver, TreasuryPortfolioPO.step2);
			node.log(Status.INFO, "STEP1 : Clicked on the step2");
			System.out.println("STEP1 : Clicked on the step2");

			// Wait for the visibility of the step2
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the step2");
			System.out.println("STEP2 : Waiting for the visibility of the step2");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryPortfolioPO.fundingSummaryTitle);
			node.log(Status.INFO, "STEP3 : Step2 is visible");
			System.out.println("STEP3 : Step2 is visible");

			// Check if the 'step--current' is present in the class attribute
			boolean isHighlighted = IElementActions
					.checkAttributePresentInClass(TreasuryPortfolioPO.targetSpecificationStep, "step--current");

			// Assert New FacilityAllocations step is highlighted or not
			if (isHighlighted) {
				node.log(Status.INFO, "STEP4 :The Step 1 New Faciliy Allocations is highlighted");
				System.out.println("STEP4 : The Step 1 New Faciliy Allocations is highlighted");

				Assert.assertTrue(true, "The Step 1 New Faciliy Allocations is highlighted");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateTargetSpecificationStep2Highlighted", "Pass", driver);
			} else {
				System.out.println("STEP4 : The Step 1 New Faciliy Allocations is not highlighted");
				node.log(Status.INFO, "STEP4 :The Step 1 New Faciliy Allocations is not highlighted");

				Assert.assertTrue(false, "The Step 1 New Faciliy Allocations is not highlighted");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateTargetSpecificationStep2Highlighted", "Fail", driver);
			}
		} catch (AssertionError validateTargetSpecificationStep2Highlighted) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateTargetSpecificationStep2Highlighted test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateTargetSpecificationStep2Highlighted_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTargetSpecificationStep2Highlighted.printStackTrace();
			node.fail(validateTargetSpecificationStep2Highlighted);
			Assert.fail();
			extent.flush();
		} catch (Exception validateTargetSpecificationStep2Highlighted) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateTargetSpecificationStep2Highlighted test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateTargetSpecificationStep2Highlighted_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTargetSpecificationStep2Highlighted.printStackTrace();
			node.fail(validateTargetSpecificationStep2Highlighted);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_015
	@Test(priority = 5)
	public void validateFundingSummaryFields() throws IOException {

		try {
			extenttest = extent.createTest("Verify the fields under the 'Funding Summary'")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Check the visibility of total loans
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryPortfolioPO.totalLoans,
					"STEP1 : BUG : Total loans is not coming under step2 funding summary",
					"STEP1 : EXPECTED : Total loans is coming under step2 funding summary");
			// Check the visibility of available loans
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryPortfolioPO.availableLoans,
					"STEP2 : BUG : Available Loans is not coming under step2 funding summary",
					"STEP2 : EXPECTED : Available Loans is coming under step2 funding summary");
			// Check the visibility of excluded loans
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryPortfolioPO.excludedLoans,
					"STEP3 : BUG : Excluded Loans is not coming under step2 funding summary",
					"STEP3 : EXPECTED : Excluded Loans is coming under step2 funding summary");
			// Check the visibility of double inclusion
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryPortfolioPO.doubleInclusion,
					"STEP4 : BUG : Double inclusion is not coming under step2 funding summary",
					"STEP4 : EXPECTED : Double inclusion is coming under step2 funding summary");
			// Check the visibility of loan pool
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryPortfolioPO.loanPool,
					"STEP5 : BUG : Loan pool is not coming under step2 funding summary",
					"STEP5 : EXPECTED : Loan pool is coming under step2 funding summary");
			// Check the visibility of total facilities
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryPortfolioPO.totalFacilities,
					"STEP6 : BUG : Total facilities is not coming under step2 funding summary",
					"STEP6 : EXPECTED : Total facilities is coming under step2 funding summary");
			// Check the visibility of total drawn
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryPortfolioPO.totalDrawn,
					"STEP7 : BUG : Total drawn is not coming under step2 funding summary",
					"STEP7 : EXPECTED : Total drawn is coming under step2 funding summary");
			// Check the visibility of available funding
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryPortfolioPO.availableFunding,
					"STEP8 : BUG : Available funding is not coming under step2 funding summary",
					"STEP8 : EXPECTED : Available funding is coming under step2 funding summary");
			// Check the visibility of facilities pool
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryPortfolioPO.facilitiesPool,
					"STEP9 : BUG : Facilities pool is not coming under step2 funding summary",
					"STEP9 : EXPECTED : Facilities pool is coming under step2 funding summary");
			// Check the visibility of pool coverage
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryPortfolioPO.poolCoverage,
					"STEP10 : BUG : Pool coverage is not coming under step2 funding summary",
					"STEP10 : EXPECTED : Pool coverage is coming under step2 funding summary");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFundingSummaryFields", "Pass", driver);

		} catch (AssertionError validateFundingSummaryFields) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFundingSummaryFields test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFundingSummaryFields_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFundingSummaryFields.printStackTrace();
			node.fail(validateFundingSummaryFields);
			Assert.fail();
			extent.flush();
		} catch (Exception validateFundingSummaryFields) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFundingSummaryFields test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFundingSummaryFields_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFundingSummaryFields.printStackTrace();
			node.fail(validateFundingSummaryFields);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_016
	@Test(priority = 6)
	public void validateTotalLoans() throws IOException {

		try {
			extenttest = extent.createTest("Validate that the Total Loans value is the sum of all current loan amounts")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Deviation
			double deviatedValue = Double.parseDouble(getDataFromExcel(10));

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Extract the values from the elements
			double totalLoans = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.totalLoans);
			System.out.println("STEP01 : Total loans value is: " + totalLoans);
			node.log(Status.INFO, "STEP01 : Total loans value is: " + totalLoans);

			// Get sum of current loan amount column
			double currentLoanAmount = Utils.calculateSumOfList(TreasuryPortfolioPO.currentLoanAmount);
			System.out.println("STEP02 : Current loan amount sum is : " + currentLoanAmount);
			node.log(Status.INFO, "STEP02 : Current loan amount sum is : " + currentLoanAmount);

			// Perform assertion allowing for a difference 5 with a delta parameter
			Assert.assertEquals(totalLoans, currentLoanAmount, deviatedValue,
					"Difference is greater than the acceptable range between Total loans value" + totalLoans
							+ " and the sum of current loan amount" + currentLoanAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateTotalLoans", "Pass", driver);

		} catch (AssertionError validateTotalLoans) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateTotalLoans test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTotalLoans_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalLoans.printStackTrace();
			node.fail(validateTotalLoans);
			Assert.fail();
			extent.flush();
		} catch (Exception validateTotalLoans) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateTotalLoans test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTotalLoans_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalLoans.printStackTrace();
			node.fail(validateTotalLoans);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_017
	@Test(priority = 7)
	public void validateAvailableLoans() throws IOException {

		try {
			extenttest = extent.createTest(
					"Validate that the Available Loans value is the sum of Current Deployment values for all excluded facilities under Facility Table")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Scroll vertically and horizontally to access loan table exclude checkbox
			TreasuryPage.scrollVerticalAndHorizontalToAccessTable(TreasuryPortfolioPO.excludedText,
					TreasuryPortfolioPO.facilityTable, TreasuryPortfolioPO.excludedFacilities);

			// Extract text using the reusable method
			List<String> facilitiesElements = Utils.extractTextFromElements(TreasuryPortfolioPO.facilities);

			// Extract text using the reusable method
			List<String> currentDeploymentElements = Utils
					.extractTextFromElements(TreasuryPortfolioPO.currentDeploymentInFacilities);

			// Find all elements of excluded elements
			List<WebElement> excludedElements = IElementActions.returnElements(node, driver,
					TreasuryPortfolioPO.excludedFacilities);

			// Store the positions of checked checkboxes in excludedFacilities
			List<Integer> checkedPositions = new ArrayList<>();

			// Store the positions of unchecked checkboxes in excludedFacilities
			List<Integer> uncheckedPositions = new ArrayList<>();

			// Extract the values from the elements
			double availableLoans = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.availableLoans);
			System.out.println("STEP01 : Available loans value is: " + availableLoans);
			node.log(Status.INFO, "STEP01 : Available loans value is: " + availableLoans);

			for (int i = 0; i < excludedElements.size(); i++) {
				WebElement checkbox = excludedElements.get(i).findElement(By.tagName("span"));
				if (checkbox.getAttribute("class").contains("pi-check")) {
					checkedPositions.add(i);
				} else {
					uncheckedPositions.add(i);
				}
			}

			// Sum up all the values of currentDeploymentInFacilities corresponding to
			// checked excludedFacilities
			int sum = 0;
			// Find the difference between target and current deployment
			for (int uncheckPosition : uncheckedPositions) {

				String facilityElementValue = facilitiesElements.get(uncheckPosition);

				String currentDeploymentValue = currentDeploymentElements.get(uncheckPosition);

				// Convert the values to integers (assuming they represent numbers)
				int currentDeployment = Utils.removeCurrencyAndParseToInt(currentDeploymentValue);

				sum += currentDeployment;
			}

			// Assert the double inclusion value
			IElementActions.assertEquals_usingDouble(node, driver, availableLoans, sum,
					"STEP02 : BUG : Available loans value is " + availableLoans
							+ " and is not equal to the sum of current deployment excluded in facilities " + sum,
					"STEP02 : EXPECTED :Available loans value is " + availableLoans
							+ "  and is equal to the sum of current deployment excluded in facilities " + sum);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAvailableLoans", "Pass", driver);

		} catch (AssertionError validateAvailableLoans) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAvailableLoans test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAvailableLoans_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAvailableLoans.printStackTrace();
			node.fail(validateAvailableLoans);
			Assert.fail();
			extent.flush();
		} catch (Exception validateAvailableLoans) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAvailableLoans test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAvailableLoans_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAvailableLoans.printStackTrace();
			node.fail(validateAvailableLoans);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_018
	@Test(priority = 8)
	public void validateExcludedLoans() throws IOException {

		try {
			extenttest = extent.createTest("Validate that the Excluded Loans are loans not included for allocation")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Deviation
			int deviatedValue = Integer.parseInt(getDataFromExcel(10));

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Extract the values from the elements
			int excludedLoans = Utils.getTextAndParseToInt(TreasuryPortfolioPO.excludedLoans);
			System.out.println("STEP01 : Excluded loans value is: " + excludedLoans);
			node.log(Status.INFO, "STEP01 : Excluded loans value is: " + excludedLoans);

			int sum = TreasuryPage.sumOfExcludedElements(TreasuryPortfolioPO.allocatedAmount,
					TreasuryPortfolioPO.allocatedAmountText, TreasuryPortfolioPO.loanTable,
					TreasuryPortfolioPO.excludedLoansCheckbox);

			// Perform assertion allowing for a difference 5 with a delta parameter
			Assert.assertEquals(excludedLoans, sum, deviatedValue,
					"Difference is greater than the acceptable range between Available loans value" + excludedLoans
							+ " and the sum of current deployment excluded in facilities" + sum);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateExcludedLoans", "Pass", driver);

		} catch (AssertionError validateExcludedLoans) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateExcludedLoans test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateExcludedLoans_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateExcludedLoans.printStackTrace();
			node.fail(validateExcludedLoans);
			Assert.fail();
			extent.flush();
		} catch (Exception validateExcludedLoans) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateExcludedLoans test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateExcludedLoans_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateExcludedLoans.printStackTrace();
			node.fail(validateExcludedLoans);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_019
	@Test(priority = 9)
	public void validateDoubleInclusion() throws IOException {

		try {
			extenttest = extent.createTest(
					"Validate that the Double Inclusion values are excluded loans that are allocated to excluded facilities")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Deviation
			int deviatedValue = Integer.parseInt(getDataFromExcel(10));

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Extract the values from the elements
			double doubleInclusion = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.doubleInclusion);
			System.out.println("STEP1 : Double inclusion value is: " + doubleInclusion);
			node.log(Status.INFO, "STEP1 : Double inclusion value is: " + doubleInclusion);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Find all elements of the facilities column
			List<WebElement> facilitiesElements = IElementActions.returnElements(node, driver,
					TreasuryPortfolioPO.facilities);

			// Scroll vertically and horizontally to access loan table exclude checkbox
			TreasuryPage.scrollVerticalAndHorizontalToAccessTable(TreasuryPortfolioPO.excludedText,
					TreasuryPortfolioPO.facilityTable, TreasuryPortfolioPO.excludedFacilities);

			// Find all elements of excluded elements
			List<WebElement> excludedFacilitiesElements = IElementActions.returnElements(node, driver,
					TreasuryPortfolioPO.excludedFacilities);

			// Find all elements of the loan reference column
			List<WebElement> loansElements = IElementActions.returnElements(node, driver,
					TreasuryPortfolioPO.loanReferences);

			// Scroll vertically and horizontally to access loan table exclude checkbox
			TreasuryPage.scrollVerticalAndHorizontalToAccessTable(TreasuryPortfolioPO.allocatedAmountText,
					TreasuryPortfolioPO.loanTable, TreasuryPortfolioPO.excludedLoansCheckbox);

			// Find all elements of excluded elements
			List<WebElement> excludedLoansElements = IElementActions.returnElements(node, driver,
					TreasuryPortfolioPO.excludedLoansCheckbox);

			// Store the positions of checked checkboxes of excluded facilities
			List<String> facilitiesExcluded = new ArrayList<>();

			// Store the positions of checked checkboxes of excluded loans
			List<String> loansExcluded = new ArrayList<>();

			for (int i = 0; i < excludedFacilitiesElements.size(); i++) {
				WebElement checkbox = excludedFacilitiesElements.get(i).findElement(By.tagName("span"));
				if (checkbox.getAttribute("class").contains("pi-check")) {
					WebElement facilitiesElement = facilitiesElements.get(i);
					String facilityReference = facilitiesElement.getText();
					facilitiesExcluded.add(facilityReference);
				}
			}

			for (int i = 0; i < excludedLoansElements.size(); i++) {
				WebElement checkbox = excludedLoansElements.get(i).findElement(By.tagName("span"));
				if (checkbox.getAttribute("class").contains("pi-check")) {
					WebElement loanElement = loansElements.get(i);
					String loanReference = loanElement.getText();
					loansExcluded.add(loanReference);
				}
			}

			// Calling the loadTreasuryDatabasePage from treasury
			TreasuryPage.loadTreasuryDatabasePage();

			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the loan references");
			System.out.println("STEP2 : Waiting for the visibility of the loan references");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryDatabasePO.loanReferences);
			node.log(Status.INFO, "STEP3 : Loan references is visible");
			System.out.println("STEP3 : Loan references is visible");

			Thread.sleep(5000);

			// Find all elements of the facilities in database
			List<String> facilitiesReferenceInDatabase = Utils.extractTextFromElements(TreasuryDatabasePO.facilities);

			List<String> loanReferencesInDatabase = Utils.extractTextFromElements(TreasuryDatabasePO.loanReferences);

			// Store the excluded facility positions
			List<Integer> facilityPositions = new ArrayList<>();

			// Store the excluded loan positions
			List<Integer> loanPositions = new ArrayList<>();

			for (String facilityExcluded : facilitiesExcluded) {
				for (int i = 0; i < facilitiesReferenceInDatabase.size(); i++) {
					String facilityReferenceInDatabase = facilitiesReferenceInDatabase.get(i);
					if (facilityExcluded.equals(facilityReferenceInDatabase)) {
						facilityPositions.add(i);
					}
				}
			}

			for (String loanExcluded : loansExcluded) {
				for (int j = 0; j < loanReferencesInDatabase.size(); j++) {
					String loanReferenceInDatabase = loanReferencesInDatabase.get(j);
					if (loanExcluded.equals(loanReferenceInDatabase)) {
						loanPositions.add(j);
					}
				}
			}

			// Initialize the variable to store the sum
			int sum = 0;

			for (int i = 0; i < facilityPositions.size(); i++) {
				int facilityAmountPosition = facilityPositions.get(i);
				facilityAmountPosition = facilityAmountPosition + 3;
				for (int j = 0; j < loanPositions.size(); j++) {
					int loanAmountPosition = loanPositions.get(j);
					loanAmountPosition = loanAmountPosition + 1;

					// Create the locator for dynamic loan amount
					String amountLoanLocator = IElementActions.createDynamicLocatorString(
							TreasuryDatabasePO.facilitiesAmountForLoanReferences, "loanPosition",
							Integer.toString(loanAmountPosition));

					// Create the locator for dynamic loan facility amount
					String amountLocator = IElementActions.createDynamicLocatorString(amountLoanLocator,
							"facilityPosition", Integer.toString(facilityAmountPosition));

					int amountValue = Utils.getTextAndParseToInt(amountLocator);

					sum += amountValue;
				}
			}

			// Assert the double inclusion value and allowing for a difference 5 with a
			// delta parameter
			Assert.assertEquals(doubleInclusion, sum, deviatedValue,
					"STEP4 : BUG : Double inclusion value is " + doubleInclusion
							+ " and is not equal to the sum of the facilities amount corresponding to loans " + sum);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDoubleInclusion", "Pass", driver);
		} catch (AssertionError validateDoubleInclusion) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDoubleInclusion test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDoubleInclusion_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDoubleInclusion.printStackTrace();
			node.fail(validateDoubleInclusion);
			Assert.fail();
			extent.flush();
		} catch (Exception validateDoubleInclusion) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDoubleInclusion test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDoubleInclusion_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDoubleInclusion.printStackTrace();
			node.fail(validateDoubleInclusion);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_020
	@Test(priority = 10)
	public void validateLoanPool() throws IOException {

		try {
			extenttest = extent.createTest(
					"Validate that the Loan Pool value is Available Loans - Excluded Loans + Double Inclusion Loans ")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Get the deviation value from Excel
			double deviatedValue = Double.parseDouble(getDataFromExcel(10));

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Extract the values from the elements
			double availableLoans = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.availableLoans);
			System.out.println("STEP01 : Available loans value is: " + availableLoans);
			node.log(Status.INFO, "STEP01 : Available loans value is: " + availableLoans);

			// Extract the values from the elements
			double excludedLoans = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.excludedLoans);
			System.out.println("STEP02 : Excluded loans value is: " + excludedLoans);
			node.log(Status.INFO, "STEP02 : Excluded loans value is: " + excludedLoans);

			// Extract the values from the elements
			double doubleInclusion = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.doubleInclusion);
			System.out.println("STEP03 : Double inclusion value is: " + doubleInclusion);
			node.log(Status.INFO, "STEP03 : Double inclusion value is: " + doubleInclusion);

			// Extract the values from the elements
			double loanPool = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.loanPool);
			System.out.println("STEP04 : Loan pool value is: " + loanPool);
			node.log(Status.INFO, "STEP04 : Loan pool value is: " + loanPool);

			double diff = Utils.calculateDifference(availableLoans, excludedLoans);

			double calculatedLoanPool = Utils.calculateAddition(diff, doubleInclusion);

			// Assert the loan pool value
			Assert.assertEquals(loanPool, calculatedLoanPool, deviatedValue,
					"Deviation is greater than expected value and the Loan pool value : " + loanPool
							+ " is not equal to the calculated loan pool value " + calculatedLoanPool);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanPool", "Pass", driver);

		} catch (AssertionError validateLoanPool) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanPool test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanPool_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanPool.printStackTrace();
			node.fail(validateLoanPool);
			Assert.fail();
			extent.flush();
		} catch (Exception validateLoanPool) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanPool test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateLoanPool_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanPool.printStackTrace();
			node.fail(validateLoanPool);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_021
	@Test(priority = 11)
	public void validateTotalFacilities() throws IOException {

		try {
			extenttest = extent.createTest("Validate that the Total facilities = amount pledged (note item)")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Deviation
			double deviatedValue = Double.parseDouble(getDataFromExcel(10));

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Extract the values from the elements
			double totalFacilities = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.totalFacilities);
			System.out.println("STEP01 : Total facilities value is : " + totalFacilities);
			node.log(Status.INFO, "STEP01 : Total facilities value is : " + totalFacilities);

			// Get sum of amount column in facilities
			double amountInFacilities = Utils.calculateSumOfList(TreasuryPortfolioPO.amountInFacilities);
			System.out.println("STEP02 : Amount sum in facilities is : " + amountInFacilities);
			node.log(Status.INFO, "STEP02 : Amount sum in facilities is : " + amountInFacilities);

			// Perform assertion allowing for a difference 5 with a delta parameter
			Assert.assertEquals(totalFacilities, amountInFacilities, deviatedValue,
					"Difference is greater than the acceptable range between Total facilities value" + totalFacilities
							+ " and the sum of amount in facilities" + amountInFacilities);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateTotalFacilities", "Pass", driver);

		} catch (AssertionError validateTotalFacilities) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateTotalFacilities test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTotalFacilities_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalFacilities.printStackTrace();
			node.fail(validateTotalFacilities);
			Assert.fail();
			extent.flush();
		} catch (Exception validateTotalFacilities) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateTotalFacilities test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTotalFacilities_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalFacilities.printStackTrace();
			node.fail(validateTotalFacilities);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_022
	@Test(priority = 12)
	public void validateTotalDrawn() throws IOException {

		try {
			extenttest = extent.createTest("Validate that the Total drawn = total drawdowns on all facilities")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Deviation
			double deviatedValue = Double.parseDouble(getDataFromExcel(10));

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Extract the values from the elements
			double totalDrawn = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.totalDrawn);
			System.out.println("STEP01 : Total drawn value is : " + totalDrawn);
			node.log(Status.INFO, "STEP01 : Total drawn value is : " + totalDrawn);

			// Get sum of drawn amount column in facilities
			double drawnAmountInFacilities = Utils.calculateSumOfList(TreasuryPortfolioPO.drawnAmountInFacilities);
			System.out.println("STEP02 : Drawn amount sum in facilities is : " + drawnAmountInFacilities);
			node.log(Status.INFO, "STEP02 : Drawn amount sum in facilities is : " + drawnAmountInFacilities);

			// Perform assertion allowing for a difference 5 with a delta parameter
			Assert.assertEquals(totalDrawn, drawnAmountInFacilities, deviatedValue,
					"Difference is greater than the acceptable range between Total drawn value" + totalDrawn
							+ " and the sum of drawn amount in facilities" + drawnAmountInFacilities);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateTotalDrawn", "Pass", driver);

		} catch (AssertionError validateTotalDrawn) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateTotalDrawn test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatePortfolioSteps_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalDrawn.printStackTrace();
			node.fail(validateTotalDrawn);
			Assert.fail();
			extent.flush();
		} catch (Exception validateTotalDrawn) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateTotalDrawn test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateTotalDrawn_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateTotalDrawn.printStackTrace();
			node.fail(validateTotalDrawn);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_023
	@Test(priority = 13)
	public void validateAvailableFunding() throws IOException {

		try {
			extenttest = extent
					.createTest("Validate that the Available funding = Total Drawn - Excluded Facilities Drawn")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Deviation
			double deviatedValue = Double.parseDouble(getDataFromExcel(10));

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Extract the values from the elements
			double availableFunding = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.availableFunding);
			System.out.println("STEP01 : Available funding value is : " + availableFunding);
			node.log(Status.INFO, "STEP01 : Available funding value is : " + availableFunding);

			// Extract the values from the elements
			double totalDrawn = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.totalDrawn);
			System.out.println("STEP02 : Total drawn value is : " + totalDrawn);
			node.log(Status.INFO, "STEP02 : Total drawn value is : " + totalDrawn);

			double sum = TreasuryPage.sumOfExcludedElements(TreasuryPortfolioPO.drawnAmountInFacilities,
					TreasuryPortfolioPO.excludedText, TreasuryPortfolioPO.facilityTable,
					TreasuryPortfolioPO.excludedFacilities);

			// Get include drawn amount
			double includedDrawn = Utils.calculateDifference(totalDrawn, sum);
			System.out.println("STEP03 : Difference between total drawn and excluded drawn is : " + includedDrawn);
			node.log(Status.INFO, "STEP03 : Difference between total drawn and excluded drawn is :" + includedDrawn);

			// Perform assertion allowing for a difference 5 with a delta parameter
			Assert.assertEquals(availableFunding, includedDrawn, deviatedValue,
					"Difference is greater than the acceptable range between Available funding value" + availableFunding
							+ " and the sum of include drawn amount in facilities" + includedDrawn);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAvailableFunding", "Pass", driver);

		} catch (AssertionError validateAvailableFunding) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAvailableFunding test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAvailableFunding_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAvailableFunding.printStackTrace();
			node.fail(validateAvailableFunding);
			Assert.fail();
			extent.flush();
		} catch (Exception validateAvailableFunding) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAvailableFunding test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAvailableFunding_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAvailableFunding.printStackTrace();
			node.fail(validateAvailableFunding);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_024
	@Test(priority = 14)
	public void validateFacilitiesPool() throws IOException {

		try {
			extenttest = extent
					.createTest(
							"Validate that the Facilities Pool = Available Funding - Excluded Loans + Double Inclusion")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Extract the values from the elements
			double availableFunding = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.availableFunding);
			System.out.println("STEP01 : Available funding value is : " + availableFunding);
			node.log(Status.INFO, "STEP01 : Available funding value is : " + availableFunding);

			// Extract the values from the elements
			double excludedLoans = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.excludedLoans);
			System.out.println("STEP02 : Excluded loans value is: " + excludedLoans);
			node.log(Status.INFO, "STEP02 : Excluded loans value is: " + excludedLoans);

			// Extract the values from the elements
			double doubleInclusion = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.doubleInclusion);
			System.out.println("STEP03 : Double inclusion value is: " + doubleInclusion);
			node.log(Status.INFO, "STEP03 : Double inclusion value is: " + doubleInclusion);

			// Extract the values from the elements
			double facilitiesPool = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.facilitiesPool);
			System.out.println("STEP04 : Facilities pool value is: " + facilitiesPool);
			node.log(Status.INFO, "STEP04 : Facilities pool value is: " + facilitiesPool);

			double diff = Utils.calculateDifference(availableFunding, excludedLoans);

			double calculatedFacilitiesPool = Utils.calculateAddition(diff, doubleInclusion);

			// Assert the facilities pool value
			IElementActions.assertEquals_usingDouble(node, driver, facilitiesPool, calculatedFacilitiesPool,
					"STEP05 : BUG : Facilities pool value " + facilitiesPool
							+ " is not equal to the calculated facilities pool value " + calculatedFacilitiesPool,
					"STEP05 : EXPECTED : Facilities pool value " + facilitiesPool
							+ " is equal to the calculated facilities pool value " + calculatedFacilitiesPool);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilitiesPool", "Pass", driver);

		} catch (AssertionError validateFacilitiesPool) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilitiesPool test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFacilitiesPool_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilitiesPool.printStackTrace();
			node.fail(validateFacilitiesPool);
			Assert.fail();
			extent.flush();
		} catch (Exception validateFacilitiesPool) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilitiesPool test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatePortfolioSteps_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilitiesPool.printStackTrace();
			node.fail(validateFacilitiesPool);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_025
	@Test(priority = 15)
	public void validatePoolCoverage() throws IOException {

		try {
			extenttest = extent.createTest("Validate that the Pool coverage = Facilities pool / loan pool")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Extract the values from the elements
			double poolCoverage = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.poolCoverage);
			System.out.println("STEP01 : Pool coverage value is: " + poolCoverage);
			node.log(Status.INFO, "STEP01 : Pool coverage value is: " + poolCoverage);

			// Extract the values from the elements
			double facilitiesPool = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.facilitiesPool);
			System.out.println("STEP02 : Facilities pool value is: " + facilitiesPool);
			node.log(Status.INFO, "STEP02 : Facilities pool value is: " + facilitiesPool);

			// Extract the values from the elements
			double loanPool = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.loanPool);
			System.out.println("STEP03 : Loan pool value is: " + loanPool);
			node.log(Status.INFO, "STEP03 : Loan pool value is: " + loanPool);

			double poolCoveragecalculated = (facilitiesPool / loanPool) * 100;

			// Format the number to display only 1 digit after the decimal point
			DecimalFormat df = new DecimalFormat("#.#");
			String formattedNumber = df.format(poolCoveragecalculated);

			// Format the number to display only 1 digit after the decimal point
			double calculatedPoolCoverage = Double.parseDouble(formattedNumber);

			// Assert the pool coverage value
			IElementActions.assertEquals_usingDouble(node, driver, poolCoverage, calculatedPoolCoverage,
					"STEP04 : BUG : Pool coverage value " + poolCoverage
							+ " is not equal to the calculated pool coverage value " + calculatedPoolCoverage,
					"STEP04 : EXPECTED : Pool coverage " + poolCoverage
							+ " is equal to the calculated pool coverage value " + calculatedPoolCoverage);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validatePoolCoverage", "Pass", driver);

		} catch (AssertionError validatePoolCoverage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePoolCoverage test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatePoolCoverage_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePoolCoverage.printStackTrace();
			node.fail(validatePoolCoverage);
			Assert.fail();
			extent.flush();
		} catch (Exception validatePoolCoverage) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePoolCoverage test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatePoolCoverage_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePoolCoverage.printStackTrace();
			node.fail(validatePoolCoverage);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_026
	@Test(priority = 16)
	public void validateUtilisationThresholdUpdate() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that user is able to add and update the Utilisation Threshold in the percentage format in the field and click on Update Ranking")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Get utilisation threshold value
			String utilisationThreshold = getDataFromExcel(62);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Wait for the utilisation threshold field is visible and clickable
			System.out
					.println("STEP01 : Waiting for the utilisation threshold input field to be visible and clickable");
			node.log(Status.INFO,
					"STEP01 : Waiting for the utilisation threshold input field to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryPortfolioPO.utilisationThreshold);
			IWaitStrategy.WaitUntilElementClickable(node, driver, TreasuryPortfolioPO.utilisationThreshold);
			System.out.println("STEP02 :  Utilisation threshold input field is visible and clickable");
			node.log(Status.INFO, "STEP02 : Utilisation threshold input field is visible and clickable");

			// Enter the value in the utilisation threshold input field
			IElementActions.clearAndInputElementUsingAction_Xpath(node, driver,
					TreasuryPortfolioPO.utilisationThreshold, utilisationThreshold);
			System.out.println("STEP03 : Entered the value in the utilisation threshold input field.");
			node.log(Status.INFO, "STEP03 : Entered the value in the utilisation threshold input field.");

			// Click on the update ranking button
			IElementActions.clickelement_usingXpath(node, driver, TreasuryPortfolioPO.updateRanking);
			System.out.println("STEP04 : Clicked on the update ranking button");
			node.log(Status.INFO, "STEP04 : Clicked on the update ranking button");

			// Get utilisation value
			String utilisationValueExpected = IElementActions.getElementValue(node, driver,
					TreasuryPortfolioPO.utilisationThreshold);

			String utilisationValue = Utils.formatText(utilisationValueExpected);

			// Assert the utilisation
			IElementActions.assertEquals_usingString(node, driver, utilisationValue, utilisationThreshold,
					"BUG : The utilisation after update is " + utilisationValue
							+ " is not equal to the expected updated utilisation value i.e " + utilisationThreshold,
					"PASS : The utilisation after update is " + utilisationValue
							+ " is equal to the expected updated utilisation value i.e " + utilisationThreshold);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateUtilisationThresholdUpdate", "Pass", driver);

		} catch (AssertionError validateUtilisationThresholdUpdate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateUtilisationThresholdUpdate test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateUtilisationThresholdUpdate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateUtilisationThresholdUpdate.printStackTrace();
			node.fail(validateUtilisationThresholdUpdate);
			Assert.fail();
			extent.flush();
		} catch (Exception validateUtilisationThresholdUpdate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateUtilisationThresholdUpdate test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateUtilisationThresholdUpdate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateUtilisationThresholdUpdate.printStackTrace();
			node.fail(validateUtilisationThresholdUpdate);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_027
	@Test(priority = 17)
	public void validateRateUpdate() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that user is able to add and update the Rate in the percentage format in the field and click on Update Ranking")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Get utilisation threshold rate value
			String utilisationThresholdRate = getDataFromExcel(63);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Wait for the utilisation threshold rate is visible and clickable
			System.out.println("STEP01 : Waiting for the rate field to be visible and clickable");
			node.log(Status.INFO, "STEP01 : Waiting for the rate field to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryPortfolioPO.rate);
			IWaitStrategy.WaitUntilElementClickable(node, driver, TreasuryPortfolioPO.rate);
			System.out.println("STEP02 :  Rate field is visible and clickable");
			node.log(Status.INFO, "STEP02 : Rate field is visible and clickable");

			// Click on the rate
			IElementActions.clickelement_usingXpath(node, driver, TreasuryPortfolioPO.rate);
			System.out.println("STEP03 : Clicked on the rate");
			node.log(Status.INFO, "STEP03 : Clicked on the rate");

			// Wait for the utilisation threshold rate field is visible and clickable
			System.out.println(
					"STEP04 : Waiting for the utilisation threshold rate input field to be visible and clickable");
			node.log(Status.INFO,
					"STEP04 : Waiting for the utilisation threshold rate input field to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryPortfolioPO.utilisationThreshold);
			IWaitStrategy.WaitUntilElementClickable(node, driver, TreasuryPortfolioPO.utilisationThreshold);
			System.out.println("STEP05 :  Utilisation threshold rate input field is visible and clickable");
			node.log(Status.INFO, "STEP05 : Utilisation threshold rate input field is visible and clickable");

			// Enter the value in the utilisation threshold rate input field
			IElementActions.clearAndInputElementUsingAction_Xpath(node, driver,
					TreasuryPortfolioPO.utilisationThreshold, utilisationThresholdRate);
			System.out.println("STEP06 : Entered the value in the utilisation threshold input field for rate.");
			node.log(Status.INFO, "STEP06 : Entered the value in the utilisation threshold input field for rate.");

			// Click on the update ranking button
			IElementActions.clickelement_usingXpath(node, driver, TreasuryPortfolioPO.updateRanking);
			System.out.println("STEP07 : Clicked on the update ranking button");
			node.log(Status.INFO, "STEP07 : Clicked on the update ranking button");

			// Get utilisation rate value
			String utilisationRateExpected = IElementActions.getElementValue(node, driver,
					TreasuryPortfolioPO.utilisationThreshold);

			String utilisationRateValue = Utils.formatText(utilisationRateExpected);

			// Assert the utilisation rate
			IElementActions.assertEquals_usingString(node, driver, utilisationThresholdRate, utilisationRateValue,
					"BUG : The utilisation rate after update is " + utilisationThresholdRate
							+ " is not equal to the expected updated utilisation rate value i.e "
							+ utilisationRateValue,
					"PASS : The utilisation rate after update is " + utilisationThresholdRate
							+ " is equal to the expected updated utilisation rate value i.e " + utilisationRateValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateRateUpdate", "Pass", driver);

		} catch (AssertionError validateRateUpdate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateRateUpdate test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateRateUpdate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRateUpdate.printStackTrace();
			node.fail(validateRateUpdate);
			Assert.fail();
			extent.flush();
		} catch (Exception validateRateUpdate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateRateUpdate test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateRateUpdate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateRateUpdate.printStackTrace();
			node.fail(validateRateUpdate);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_028
	@Test(priority = 18)
	public void validateAllocationSummary() throws IOException {

		try {
			extenttest = extent.createTest("Verify the fields under the 'Allocation Summary'")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Check the visibility of current allocation
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryPortfolioPO.currentAllocation,
					"STEP1 : BUG : Current allocation is not coming under step2 allocation summary",
					"STEP1 : EXPECTED : Current allocation is coming under step2 allocation summary");
			// Check the visibility of unallocated
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryPortfolioPO.unallocated,
					"STEP2 : BUG : Unallocated is not coming under step2 allocation summary",
					"STEP2 : EXPECTED : Unallocated is coming under step2 allocation summary");
			// Check the visibility of max utilisation
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryPortfolioPO.maxUtilisation,
					"STEP3 : BUG : Max utilisation is not coming under step2 allocation summary",
					"STEP3 : EXPECTED : Max utilisation is coming under step2 allocation summary");
			// Check the visibility of additional allocation allocation
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryPortfolioPO.additionalAllocation,
					"STEP4 : BUG : Additional allocation is not coming under step2 allocation summary",
					"STEP4 : EXPECTED : Additional allocation is coming under step2 allocation summary");
			// Check the visibility of required drawdowns
			IElementActions.assertTrue_usingXpath(node, driver, TreasuryPortfolioPO.requiredDrawdowns,
					"STEP5 : BUG : Required drawdowns is not coming under step2 allocation summary",
					"STEP5 : EXPECTED : Required drawdowns is coming under step2 allocation summary");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateAllocationSummary", "Pass", driver);

		} catch (AssertionError validateAllocationSummary) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateAllocationSummary test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAllocationSummary_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocationSummary.printStackTrace();
			node.fail(validateAllocationSummary);
			Assert.fail();
			extent.flush();
		} catch (Exception validateAllocationSummary) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateAllocationSummary test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateAllocationSummary_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateAllocationSummary.printStackTrace();
			node.fail(validateAllocationSummary);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_029
	@Test(priority = 19)
	public void validateCurrentAllocation() throws IOException {

		try {
			extenttest = extent.createTest("Validate the Current Allocation value")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Deviation
			double deviatedValue = Double.parseDouble(getDataFromExcel(10));

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Extract the values from the elements
			double currentAllocation = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.currentAllocation);
			System.out.println("STEP01 : Current allocation value is : " + currentAllocation);
			node.log(Status.INFO, "STEP01 : Current allocation value is : " + currentAllocation);

			// Get sum of allocated amount column in facilities
			double allocatedAmount = Utils.calculateSumOfList(TreasuryPortfolioPO.allocatedAmount);
			System.out.println("STEP02 : Allocated amount sum in facilities is : " + allocatedAmount);
			node.log(Status.INFO, "STEP02 : Allocated amount sum in facilities is : " + allocatedAmount);

			// Perform assertion allowing for a difference 5 with a delta parameter
			Assert.assertEquals(currentAllocation, allocatedAmount, deviatedValue,
					"Difference is greater than the acceptable range between Current allocation value"
							+ currentAllocation + " and the sum of drawn allocated in facilities" + allocatedAmount);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCurrentAllocation", "Pass", driver);

		} catch (AssertionError validateCurrentAllocation) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCurrentAllocation test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCurrentAllocation_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCurrentAllocation.printStackTrace();
			node.fail(validateCurrentAllocation);
			Assert.fail();
			extent.flush();
		} catch (Exception validateCurrentAllocation) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCurrentAllocation test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateCurrentAllocation_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCurrentAllocation.printStackTrace();
			node.fail(validateCurrentAllocation);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_030
	@Test(priority = 20)
	public void validateUnallocatedValue() throws IOException {

		try {
			extenttest = extent.createTest("Validate the Unallocated value")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get the deviation value from Excel
			double deviatedValue = Double.parseDouble(getDataFromExcel(10));

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Extract the values from the elements
			double totalLoans = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.totalLoans);
			System.out.println("STEP01 : Total loans value is: " + totalLoans);
			node.log(Status.INFO, "STEP01 : Total loans value is: " + totalLoans);

			// Extract the values from the elements
			double currentAllocation = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.currentAllocation);
			System.out.println("STEP02 : Current allocation value is : " + currentAllocation);
			node.log(Status.INFO, "STEP02 : Current allocation value is : " + currentAllocation);

			// Extract the values from the elements
			double unallocated = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.unallocated);
			System.out.println("STEP03 : Unallocated value is: " + unallocated);
			node.log(Status.INFO, "STEP03 : Unallocated value is: " + unallocated);

			double calculatedUnallocatedValue = Utils.calculateDifference(totalLoans, currentAllocation);

			// Assert the unallocated value
			Assert.assertEquals(unallocated, calculatedUnallocatedValue, deviatedValue,
					"Deviation is greater than expected value and the Unallocated value : " + unallocated
							+ " is not equal to the calculated unallocated value " + calculatedUnallocatedValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateUnallocatedValue", "Pass", driver);

		} catch (AssertionError validateUnallocatedValue) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateUnallocatedValue test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateUnallocatedValue_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateUnallocatedValue.printStackTrace();
			node.fail(validateUnallocatedValue);
			Assert.fail();
			extent.flush();
		} catch (Exception validateUnallocatedValue) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateUnallocatedValue test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateUnallocatedValue_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateUnallocatedValue.printStackTrace();
			node.fail(validateUnallocatedValue);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_031
	@Test(priority = 21)
	public void validateMaxUtilisation() throws IOException {

		try {
			extenttest = extent.createTest("Validate the Max Utilisation value")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Deviation
			double deviatedValue = Double.parseDouble(getDataFromExcel(12));

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Extract the values from the elements
			double maxUtilisation = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.maxUtilisation);
			System.out.println("STEP01 : Max utilisation value is: " + maxUtilisation);
			node.log(Status.INFO, "STEP01 : Max utilisation value is: " + maxUtilisation);

			// Extract the values from the elements
			double currentAllocation = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.currentAllocation);
			System.out.println("STEP02 : Current allocation value is : " + currentAllocation);
			node.log(Status.INFO, "STEP02 : Current allocation value is : " + currentAllocation);

			// Extract the values from the elements
			double currentDrawdown = Utils.getTextAndParseToDouble(TreasuryPortfolioPO.totalDrawn);
			System.out.println("STEP03 : Current drawdown value is: " + currentDrawdown);
			node.log(Status.INFO, "STEP03 : Current drawdown value is: " + currentDrawdown);

			double maxUtilisationCalculated = (currentAllocation / currentDrawdown) * 100;

			// Format the number to display only 1 digit after the decimal point
			DecimalFormat df = new DecimalFormat("#.#");
			String formattedNumber = df.format(maxUtilisationCalculated);

			// Format the number to display only 1 digit after the decimal point
			double calculatedMaxUtilisation = Double.parseDouble(formattedNumber);

			// Perform assertion allowing for a difference 5 with a delta parameter
			Assert.assertEquals(maxUtilisation, calculatedMaxUtilisation, deviatedValue,
					"Difference is greater than the acceptable range between Max utilisation value" + maxUtilisation
							+ " and calculated max utilisation value " + calculatedMaxUtilisation);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateMaxUtilisation", "Pass", driver);

		} catch (AssertionError validateMaxUtilisation) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateMaxUtilisation test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateMaxUtilisation_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMaxUtilisation.printStackTrace();
			node.fail(validateMaxUtilisation);
			Assert.fail();
			extent.flush();
		} catch (Exception validateMaxUtilisation) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateMaxUtilisation test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateMaxUtilisation_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMaxUtilisation.printStackTrace();
			node.fail(validateMaxUtilisation);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_035
	@Test(priority = 22)
	public void validateResidualMaturityLimit() throws IOException {
		try {
			extenttest = extent.createTest(
					"Validate the 'Residual Maturity Limit' by Updating Residual Maturity Limit, any loans with Residual Maturity <= Residual Maturity Limit should be excluded (unless Current Loan Amount not equal to Allocated Amount)")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Get residual maturity limit value
			String residualMaturityLimit = getDataFromExcel(64);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Wait for the residual maturity limit field is visible and clickable
			System.out.println(
					"STEP01 : Waiting for the residual maturity limit input field to be visible and clickable");
			node.log(Status.INFO,
					"STEP01 : Waiting for the residual maturity limit input field to be visible and clickable");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryPortfolioPO.residualMaturityLimit);
			IWaitStrategy.WaitUntilElementClickable(node, driver, TreasuryPortfolioPO.residualMaturityLimit);
			System.out.println("STEP02 : Residual maturity limit input field is visible and clickable");
			node.log(Status.INFO, "STEP02 : Residual maturity limit input field is visible and clickable");

			// Enter the value in the residual maturity limit input field
			IElementActions.clearAndInputElementUsingAction_Xpath(node, driver,
					TreasuryPortfolioPO.residualMaturityLimit, residualMaturityLimit);
			System.out.println("STEP03 : Entered the value in the residual maturity limit input field for rate.");
			node.log(Status.INFO, "STEP03 : Entered the value in the residual maturity limit input field for rate.");

			// Click on the update suggestions button
			IElementActions.clickelement_usingXpath(node, driver, TreasuryPortfolioPO.updateSuggestions);
			System.out.println("STEP04 : Clicked on the update suggestions button");
			node.log(Status.INFO, "STEP04 : Clicked on the update suggestions button");

			// Scroll vertically and horizontally to access loan table exclude checkbox
			TreasuryPage.scrollVerticalAndHorizontalToAccessTable(TreasuryPortfolioPO.allocatedAmountText,
					TreasuryPortfolioPO.loanTable, TreasuryPortfolioPO.residualMaturity);

			// Extract text using the reusable method
			List<String> residualMaturityElements = Utils.extractTextFromElements(TreasuryPortfolioPO.residualMaturity);

			// Extract text using the reusable method
			List<String> currentLoanAmountElements = Utils
					.extractTextFromElements(TreasuryPortfolioPO.currentLoanAmount);

			// Extract text using the reusable method
			List<String> allocatedAmountElements = Utils.extractTextFromElements(TreasuryPortfolioPO.allocatedAmount);

			// Scroll vertically and horizontally to access loan table exclude checkbox
			TreasuryPage.scrollVerticalAndHorizontalToAccessTable(TreasuryPortfolioPO.allocatedAmountText,
					TreasuryPortfolioPO.loanTable, TreasuryPortfolioPO.excludedLoansCheckbox);

			// Find all elements of excluded elements
			List<WebElement> excludedElements = IElementActions.returnElements(node, driver,
					TreasuryPortfolioPO.excludedLoansCheckbox);

			// Store the positions of checked checkboxes in excludedFacilities
			List<Integer> checkedPositions = new ArrayList<>();

			for (int i = 0; i < excludedElements.size(); i++) {
				WebElement checkbox = excludedElements.get(i).findElement(By.tagName("span"));
				System.out.println(checkbox.getAttribute("class").contains("pi-check"));
				if (checkbox.getAttribute("class").contains("pi-check")) {
					checkedPositions.add(i);
				}
			}

			int incorrectValue = 0;
			// Store the values of elements checked corresponding to excluded checkbox
			List<String> valuesOfElementExcluded = new ArrayList<>();
			for (int position : checkedPositions) {
				String residualMaturityValue = residualMaturityElements.get(position);
				String currentLoanAmountValue = currentLoanAmountElements.get(position);
				String allocatedAmountValue = allocatedAmountElements.get(position);
				System.out.println(
						"STEP05 : Value of the element is " + residualMaturityValue + " at position " + position);
				node.log(Status.INFO,
						"STEP05 : Value of the element is " + residualMaturityValue + " at position " + position);

				if (residualMaturityValue.equals("-")
						|| Integer.parseInt(residualMaturityValue) < Integer.parseInt(residualMaturityLimit)) {
					System.out.println("STEP06 : Value of excluded element value is " + residualMaturityValue);
					node.log(Status.INFO, "STEP06 : Value of excluded element value is " + residualMaturityValue);
				} else if (currentLoanAmountValue.equals(allocatedAmountValue)) {
					System.out.println("STEP06 : Current loan amount value " + currentLoanAmountValue
							+ " is equal to allocated amount value " + allocatedAmountValue);
					node.log(Status.INFO, "STEP06 : Current loan amount value " + currentLoanAmountValue
							+ " is equal to allocated amount value " + allocatedAmountValue);
				} else {
					System.out.println("STEP06 : Incorrect value i.e residual maturity limit is greater than "
							+ residualMaturityLimit + " of excluded element value is " + residualMaturityValue
							+ " and current loan amount value " + currentLoanAmountValue
							+ " is not equal to allocated amount value " + allocatedAmountValue);
					node.log(Status.INFO,
							"STEP06 : Incorrect value i.e residual maturity limit is greater than "
									+ residualMaturityLimit + " of excluded element value is " + residualMaturityValue
									+ " and current loan amount value " + currentLoanAmountValue
									+ " is not equal to allocated amount value " + allocatedAmountValue);
					incorrectValue++;
				}
			}

			// Assert Residual Maturity Limit
			if (incorrectValue == 0) {
				node.log(Status.INFO, "STEP07 : Loans with Residual Maturity <= Residual Maturity Limit is excluded");
				System.out.println("STEP07 : Loans with Residual Maturity <= Residual Maturity Limit is excluded");
				Assert.assertTrue(true, "Loans with Residual Maturity <= Residual Maturity Limit is excluded");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateResidualMaturityLimit", "Pass", driver);
			} else {
				System.out.println("STEP08 : Loans with Residual Maturity <= Residual Maturity Limit is not excluded");
				node.log(Status.INFO,
						"STEP08 :Loans with Residual Maturity <= Residual Maturity Limit is not excluded");
				Assert.assertTrue(false, "Loans with Residual Maturity <= Residual Maturity Limit is not excluded");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateResidualMaturityLimit", "Fail", driver);
			}
		} catch (AssertionError validateResidualMaturityLimit) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateResidualMaturityLimit test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateResidualMaturityLimit_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateResidualMaturityLimit.printStackTrace();
			node.fail(validateResidualMaturityLimit);
			Assert.fail();
			extent.flush();
		} catch (Exception validateResidualMaturityLimit) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateResidualMaturityLimit test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateResidualMaturityLimit_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateResidualMaturityLimit.printStackTrace();
			node.fail(validateResidualMaturityLimit);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_055
	@Test(priority = 23)
	public void validatUpdateRanking() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that if the user includes or excludes a loan, when they press Update Ranking the page recalculates correctly")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Deviation
			int deviatedValue = Integer.parseInt(getDataFromExcel(10));

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Get utilisation threshold value
			String utilisationThreshold = getDataFromExcel(62);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Scroll vertically and horizontally to access loan table exclude checkbox
			TreasuryPage.scrollVerticalAndHorizontalToAccessTable(TreasuryPortfolioPO.excludedText,
					TreasuryPortfolioPO.facilityTable, TreasuryPortfolioPO.excludedFacilities);

			// Extract text using the reusable method
			List<String> facilitiesElements = Utils.extractTextFromElements(TreasuryPortfolioPO.facilities);

			// Extract text using the reusable method
			List<String> targetValueElements = Utils
					.extractTextFromInputElements(TreasuryPortfolioPO.targetInFacilities);

			// Extract text using the reusable method
			List<String> currentDeploymentElements = Utils
					.extractTextFromElements(TreasuryPortfolioPO.currentDeploymentInFacilities);

			// Extract text using the reusable method
			List<String> additionalUtilizationElements = Utils
					.extractTextFromElements(TreasuryPortfolioPO.additionalUtilizationInFacilities);

			// Find all elements of excluded elements
			List<WebElement> excludedElements = IElementActions.returnElements(node, driver,
					TreasuryPortfolioPO.excludedFacilities);

			// Store the positions of checked checkboxes in excludedFacilities
			List<Integer> checkedPositions = new ArrayList<>();

			// Store the positions of unchecked checkboxes in excludedFacilities
			List<Integer> uncheckedPositions = new ArrayList<>();

			for (int i = 0; i < excludedElements.size(); i++) {
				WebElement checkbox = excludedElements.get(i).findElement(By.tagName("span"));
				if (checkbox.getAttribute("class").contains("pi-check")) {
					checkedPositions.add(i);
				} else {
					uncheckedPositions.add(i);
				}
			}

			int incorrectValue = 0;

			for (int position : checkedPositions) {
				String targetValue = targetValueElements.get(position);
				String currentDeploymentValue = currentDeploymentElements.get(position);
				String facilityElementValue = facilitiesElements.get(position);
				if (targetValue.equals(currentDeploymentValue)) {
					System.out.println("STEP01 : Target value " + targetValue + " is equal to current deployment value "
							+ currentDeploymentValue);
					node.log(Status.INFO, "STEP01 : Target value " + targetValue
							+ " is equal to current deployment value " + currentDeploymentValue);
				} else {
					System.out.println("STEP01 : For facility " + facilityElementValue + " Target value " + targetValue
							+ " is not equal to current deployment value " + currentDeploymentValue);
					node.log(Status.INFO, "STEP01 : For facility " + facilityElementValue + " Target value "
							+ targetValue + " is not equal to current deployment value " + currentDeploymentValue);
					incorrectValue++;
				}
			}

			// Find the difference between target and current deployment
			for (int uncheckPosition : uncheckedPositions) {

				String facilityElementValue = facilitiesElements.get(uncheckPosition);
				String targetValue = targetValueElements.get(uncheckPosition);
				String currentDeploymentValue = currentDeploymentElements.get(uncheckPosition);
				String additionalUtilizationValue = additionalUtilizationElements.get(uncheckPosition);

				// Convert the values to integers (assuming they represent numbers)
				int target = Utils.removeCurrencyAndParseToInt(targetValue);
				int currentDeployment = Utils.removeCurrencyAndParseToInt(currentDeploymentValue);
				int additionalUtilization = Utils.removeCurrencyAndParseToInt(additionalUtilizationValue);

				// Calculate the difference between target and current deployment
				int difference = target - currentDeployment;

				int absoluteDifference = Math.abs(additionalUtilization - difference);
				// Compare the difference with additional utilization
				if ((difference == additionalUtilization) || (absoluteDifference <= deviatedValue)) {
					System.out.println("STEP02 : At position " + uncheckPosition
							+ ": Target - Current Deployment = Additional Utilization");
				} else {

					System.out.println("STEP02 : At position " + uncheckPosition + " for facility "
							+ facilityElementValue + " : Target(" + target + ") - Current Deployment ("
							+ currentDeployment + ") != Additional Utilization(" + additionalUtilization);

					incorrectValue++;
				}
			}

			// Assert Residual Maturity Limit
			if (incorrectValue == 0) {
				node.log(Status.INFO, "STEP03 : For excluded facilities, Target value = Current Deployment amount"
						+ "For Included facilities, Observe Target - Current Deployment = Additional Utilization");
				System.out.println("STEP03 : For excluded facilities, Target value = Current Deployment amount"
						+ "For Included facilities, Observe Target - Current Deployment = Additional Utilization");

				Assert.assertTrue(true, "STEP03 : For excluded facilities, Target value = Current Deployment amount"
						+ "For Included facilities, Observe Target - Current Deployment = Additional Utilization");
			} else {
				System.out.println(
						"STEP03 : For excluded facilities, Target value is not equal to Current Deployment amount"
								+ "or either Included facilities,  Target and Current Deployment difference is not equal to Additional Utilization");
				node.log(Status.INFO,
						"STEP03 : For excluded facilities, Target value is not equal to Current Deployment amount"
								+ "or either Included facilities,  Target and Current Deployment difference is not equal to Additional Utilization");

				Assert.assertTrue(false,
						"STEP03 : For excluded facilities, Target value is not equal to Current Deployment amount"
								+ "or either Included facilities,  Target and Current Deployment difference is not equal to Additional Utilization");
			}

			// Scroll to the update ranking button
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, TreasuryPortfolioPO.utilisationThreshold);
			node.log(Status.INFO, "STEP04 : Scrolled to the update ranking button");
			System.out.println("STEP04 : Scrolled to the update ranking button");

			// Wait for the visibility of the update ranking button
			node.log(Status.INFO, "STEP05 : Waiting for the visibility of the update ranking button");
			System.out.println("STEP05 : Waiting for the visibility of the update ranking button");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryPortfolioPO.updateRanking);
			node.log(Status.INFO, "STEP06 :  Update ranking button is visible");
			System.out.println("STEP06 : Update ranking button is visible");

			// Click on the update ranking button
			IElementActions.clickelement_usingXpath(node, driver, TreasuryPortfolioPO.updateRanking);
			System.out.println("STEP07 : Clicked on the update ranking button");
			node.log(Status.INFO, "STEP07 : Clicked on the update ranking button");

			// Scroll vertically and horizontally to access loan table exclude checkbox
			TreasuryPage.scrollVerticalAndHorizontalToAccessTable(TreasuryPortfolioPO.excludedText,
					TreasuryPortfolioPO.facilityTable, TreasuryPortfolioPO.excludedFacilities);

			// Extract text using the reusable method
			List<String> currentUtilizationElements = Utils
					.extractTextFromElements(TreasuryPortfolioPO.currentUtilizationInFacilities);

			// Extract text using the reusable method
			List<String> proposedUtilizationElements = Utils
					.extractTextFromElements(TreasuryPortfolioPO.proposedUtilizationInFacilities);

			// Find all elements of excluded elements
			List<WebElement> excludedElementsAfterUpdate = IElementActions.returnElements(node, driver,
					TreasuryPortfolioPO.excludedFacilities);

			// Store the positions of checked checkboxes in excludedFacilities
			List<Integer> checkedPositionsAfterUpdate = new ArrayList<>();

			for (int i = 0; i < excludedElementsAfterUpdate.size(); i++) {
				WebElement checkbox = excludedElementsAfterUpdate.get(i).findElement(By.tagName("span"));
				if (checkbox.getAttribute("class").contains("pi-check")) {
					checkedPositionsAfterUpdate.add(i);
				}
			}

			for (int position : checkedPositionsAfterUpdate) {
				String proposedUtilizationValue = proposedUtilizationElements.get(position);
				String currentUtilizationtValue = currentUtilizationElements.get(position);
				String facilityElementValue = facilitiesElements.get(position);
				if (proposedUtilizationValue.equals(currentUtilizationtValue)) {
					System.out.println("STEP08 : Proposed utilization value " + proposedUtilizationValue
							+ " is equal to current utilization value " + currentUtilizationtValue);
					node.log(Status.INFO, "STEP08 : Proposed utilization value " + proposedUtilizationValue
							+ " is equal to current utilization value " + currentUtilizationtValue);
					Assert.assertTrue(true, "STEP08 : Proposed utilization value " + proposedUtilizationValue
							+ " is equal to current utilization value " + currentUtilizationtValue);
				} else {
					System.out.println("STEP08 : For facility " + facilityElementValue + " proposed utilization value "
							+ proposedUtilizationValue + " is not equal to current utilization value "
							+ currentUtilizationtValue);
					node.log(Status.INFO,
							"STEP08 : For facility " + facilityElementValue + " proposed utilization value "
									+ proposedUtilizationValue + " is not equal to current utilization value "
									+ currentUtilizationtValue);
					Assert.assertTrue(false,
							"STEP08 : For facility " + facilityElementValue + " proposed utilization value "
									+ proposedUtilizationValue + " is not equal to current utilization value "
									+ currentUtilizationtValue);
				}
			}

			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("validatUpdateRanking", "Pass", driver);

		} catch (AssertionError validatUpdateRanking) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatUpdateRanking test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatUpdateRanking_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatUpdateRanking.printStackTrace();
			node.fail(validatUpdateRanking);
			Assert.fail();
			extent.flush();
		} catch (Exception validatUpdateRanking) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatUpdateRanking test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatUpdateRanking_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatUpdateRanking.printStackTrace();
			node.fail(validatUpdateRanking);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_059
	@Test(priority = 24)
	public void validatUnallocatedAmountAfterDisbursement() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that if a user confirms a loan disbursement, when they navigate to Treasury > Portfolio and select a date on or after the disbursement, the disbursement is added to the Unallocated Amount and the correct Loan Current Amount shows in the table, and is highlighted in red")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			TreasuryPage.openPortfolioStep2();

			// Extract the values from the elements
			int unallocatedValue = Utils.getTextAndParseToInt(TreasuryPortfolioPO.unallocated);
			System.out.println("STEP1 : Unallocated value before disbursement is: " + unallocatedValue);
			node.log(Status.INFO, "STEP1 : Unallocated value before disbursement is: " + unallocatedValue);

			// Create loan and update status to live
			LoansPage.createLoanAndUpdateStatus("Live");

			// Get loan disbursement
			String loanDisbursementValue = getDataFromExcel(29);

			// Add a loan disbursement cash flow
			LoansPage.addCashflow(LoansNewLoanPO.paymentAddNewCashflow, LoansNewLoanPO.loanDisbursement,
					loanDisbursementValue);

			// Wait for the visibility of first row cashflow amount
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of first row cashflow amount");
			System.out.println("STEP2 : Waiting for the visibility of first row cashflow amount");
			IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.firstRowCashflowAmount);
			node.log(Status.INFO, "STEP3 : The first row cashflow amount is visible");
			System.out.println("STEP3 : The first row cashflow amount is visible");

			// Approve the cashflow
			LoansPage.approveCashflow(LoansNewLoanPO.firstRowCashflowAmount);

			// Get loan reference
			String loanReferenceNumber = getDataFromExcel(25);

			TreasuryPage.openPortfolioStep2();

			int disbursementValue = Integer.parseInt(loanDisbursementValue);

			// Extract the values from the elements
			int unallocatedValueAfterDisbursement = Utils.getTextAndParseToInt(TreasuryPortfolioPO.unallocated);
			System.out.println("STEP4 : Unallocated value after disbursement is: " + unallocatedValue);
			node.log(Status.INFO, "STEP4 : Unallocated value after disbursement is: " + unallocatedValue);

			// Calculate the unallocated value
			int calculatedUnallocatedValue = disbursementValue + unallocatedValue;

			// Assert the unallocated value before and after disbursement
			IElementActions.assertEquals_usingInteger(node, driver, calculatedUnallocatedValue,
					unallocatedValueAfterDisbursement,
					"STEP5 : BUG : Unallocated value before disbursement of " + disbursementValue + " is "
							+ unallocatedValue + " and sum of these values " + calculatedUnallocatedValue
							+ " is not equal to the unallocated value after disbursement "
							+ unallocatedValueAfterDisbursement,
					"STEP5 : PASS : Unallocated value before disbursement of " + disbursementValue + " is "
							+ unallocatedValue + " and sum of these values " + calculatedUnallocatedValue
							+ " is equal to the unallocated value after disbursement "
							+ unallocatedValueAfterDisbursement);

			// Create the Dynamic Locator for Reference Number
			String loanReferenceLocator = IElementActions.createDynamicLocatorString(
					TreasuryPortfolioPO.dynamicReference, "locatorValue", loanReferenceNumber);

			// Get loan value
			String loanValue = IElementActions.getElementText_usingXpath(node, driver, loanReferenceLocator);

			// Create the Dynamic Locator for Reference Number
			String currentLoanAmountLocator = IElementActions.createDynamicLocatorString(
					TreasuryPortfolioPO.CurrentLoanAmountCorrespondingToLoan, "locatorValue", loanReferenceNumber);

			// Create the Dynamic Locator for Reference Number
			String allocatedAmountLocator = IElementActions.createDynamicLocatorString(
					TreasuryPortfolioPO.allocatedAmountCorrespondingToLoan, "locatorValue", loanReferenceNumber);

			// Scroll vertically and horizontally to access loan table exclude checkbox
			TreasuryPage.scrollVerticalAndHorizontalToAccessTable(loanReferenceLocator, TreasuryPortfolioPO.loanTable,
					allocatedAmountLocator);

			// Get current loan amount value
			int currentLoanAmountValue = Utils.getTextAndParseToInt(currentLoanAmountLocator);

			// Assert the current loan amount value
			IElementActions.assertEquals_usingDouble(node, driver, currentLoanAmountValue, disbursementValue,
					"STEP6 : BUG : Current loan amount " + currentLoanAmountValue + " is not equal to the disbursement "
							+ disbursementValue,
					"STEP6 : PASS : Current loan amount " + currentLoanAmountValue + " is equal to the disbursement "
							+ disbursementValue);

			// Get color of allocation
			boolean allocationColor = IElementActions.checkAttributePresentInClass(allocatedAmountLocator,
					"redDisplay");

			// Assert allocation color is red or not
			if (allocationColor) {
				node.log(Status.INFO, "SUB-STEP_0.001 :Allocated amount is highligted in red color");
				System.out.println("SUB-STEP_0.001 : Allocated amount is highligted in red color");
				Assert.assertTrue(true, "Allocated amount is highligted in red color");
			} else {
				System.out.println("SUB-STEP_0.001 : Allocated amount is not highligted in red color");
				node.log(Status.INFO, "SUB-STEP_0.001 : Allocated amount is not highligted in red color");
				Assert.assertTrue(false, "Allocated amount is not highligted in red color");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validatUnallocatedAmountAfterDisbursement", "Pass", driver);

		} catch (AssertionError validatUnallocatedAmountAfterDisbursement) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatUnallocatedAmountAfterDisbursement test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatUnallocatedAmountAfterDisbursement_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatUnallocatedAmountAfterDisbursement.printStackTrace();
			node.fail(validatUnallocatedAmountAfterDisbursement);
			Assert.fail();
			extent.flush();
		} catch (Exception validatUnallocatedAmountAfterDisbursement) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatUnallocatedAmountAfterDisbursement test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatUnallocatedAmountAfterDisbursement_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatUnallocatedAmountAfterDisbursement.printStackTrace();
			node.fail(validatUnallocatedAmountAfterDisbursement);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_060
	@Test(priority = 25)
	public void validatBackFromStep2ToStep1() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user can back to 'Step1' from 'Step2' by clicking on back button or stepper")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Calling the bottomBackStepButton function from Funding Page
			FundingPage.bottomBackStepButton(UtilsPO.backStepButton, 2, "New Faciliy Allocations");

			// Check if the 'step--current' is present in the class attribute
			boolean isHighlighted = IElementActions
					.checkAttributePresentInClass(TreasuryPortfolioPO.newFaciliyAllocationsStep, "step--current");

			// Assert New FacilityAllocations step is highlighted or not
			if (isHighlighted) {
				node.log(Status.INFO, "SUB-STEP_0.001 :The Step 1 New Faciliy Allocations is highlighted");
				System.out.println("SUB-STEP_0.001 : The Step 1 New Faciliy Allocations is highlighted");

				Assert.assertTrue(true, "The Step 1 New Faciliy Allocations is highlighted");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validatBackFromStep2ToStep1", "Pass", driver);
			} else {
				System.out.println("SUB-STEP_0.001 : The Step 1 New Faciliy Allocations is not highlighted");
				node.log(Status.INFO, "SUB-STEP_0.001 :The Step 1 New Faciliy Allocations is not highlighted");

				Assert.assertTrue(false, "The Step 1 New Faciliy Allocations is not highlighted");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validatBackFromStep2ToStep1", "Fail", driver);
			}

		} catch (AssertionError validatBackFromStep2ToStep1) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatBackFromStep2ToStep1 test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatBackFromStep2ToStep1_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatBackFromStep2ToStep1.printStackTrace();
			node.fail(validatBackFromStep2ToStep1);
			Assert.fail();
			extent.flush();
		} catch (Exception validatBackFromStep2ToStep1) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatBackFromStep2ToStep1 test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatBackFromStep2ToStep1_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatBackFromStep2ToStep1.printStackTrace();
			node.fail(validatBackFromStep2ToStep1);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_061
	@Test(priority = 26)
	public void validateNextStepInStep2() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that when the user clicks on 'Next Step' in Step 2,  the Reallocate Loans should be visible")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Calling the bottomNextStepButton function from Funding Page
			FundingPage.bottomNextStepButton(UtilsPO.nextStepButton, 2, "New Faciliy Allocations");

			// Check if the 'step--current' is present in the class attribute
			boolean isHighlighted = IElementActions
					.checkAttributePresentInClass(TreasuryPortfolioPO.reallocateLoansStep, "step--current");

			// Assert Reallocate Loans step is highlighted or not
			if (isHighlighted) {
				node.log(Status.INFO, "SUB-STEP_0.001 :The Step 3 Reallocate Loans is highlighted");
				System.out.println("SUB-STEP_0.001 : The Step 3 Reallocate Loans is highlighted");

				Assert.assertTrue(true, "The 3 Reallocate Loans is highlighted");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateNextStepInStep2", "Pass", driver);
			} else {
				System.out.println("SUB-STEP_0.001 : The Step 3 Reallocate Loans is not highlighted");
				node.log(Status.INFO, "SUB-STEP_0.001 :The Step 3 Reallocate Loans is not highlighted");

				Assert.assertTrue(false, "The Step 3 Reallocate Loans is not highlighted");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateNextStepInStep2", "Fail", driver);
			}

		} catch (AssertionError validateNextStepInStep2) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNextStepInStep2 test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateNextStepInStep2_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNextStepInStep2.printStackTrace();
			node.fail(validateNextStepInStep2);
			Assert.fail();
			extent.flush();
		} catch (Exception validateNextStepInStep2) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNextStepInStep2 test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateNextStepInStep2_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNextStepInStep2.printStackTrace();
			node.fail(validateNextStepInStep2);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_071
	@Test(priority = 27)
	public void validateExcludedForFullyAllocatedOverdueLoans() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the 'Excluded' is checked for 'Loan' which is ALL fully allocated overdue loans are excluded. Other loans may be excluded in addition to those which are overdue")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Scroll vertically and horizontally to access loan table exclude checkbox
			TreasuryPage.scrollVerticalAndHorizontalToAccessTable(TreasuryPortfolioPO.allocatedAmountText,
					TreasuryPortfolioPO.loanTable, TreasuryPortfolioPO.excludedLoansCheckbox);

			// Find all elements of the loan reference column
			List<String> loanReferenceElements = Utils.extractTextFromElements(TreasuryPortfolioPO.loanReferences);

			// Find all elements of excluded elements
			List<String> currentLoanAmountElements = Utils
					.extractTextFromElements(TreasuryPortfolioPO.currentLoanAmount);

			// Find all elements of excluded elements
			List<String> allocatedAmountElements = Utils.extractTextFromElements(TreasuryPortfolioPO.allocatedAmount);

			// Find all elements of excluded elements
			List<WebElement> excludedElements = IElementActions.returnElements(node, driver,
					TreasuryPortfolioPO.excludedLoansCheckbox);

			// Store the positions of checked checkboxes in excludedFacilities
			List<Integer> checkedPositions = new ArrayList<>();

			for (int i = 0; i < excludedElements.size(); i++) {
				WebElement checkbox = excludedElements.get(i).findElement(By.tagName("span"));
				if (checkbox.getAttribute("class").contains("pi-check")) {
					checkedPositions.add(i);
				}
			}

			for (int position : checkedPositions) {
				String currentLoanAmountValue = currentLoanAmountElements.get(position);
				String allocatedAmountValue = allocatedAmountElements.get(position);
				String loanReference = loanReferenceElements.get(position);
				// Compare the difference with additional utilization
				if (currentLoanAmountValue.equals(allocatedAmountValue)) {
					System.out.println("At position " + position + ": Current loan amount " + currentLoanAmountValue
							+ " is equal to the allocated amount " + allocatedAmountValue);
					node.log(Status.INFO, "At position " + position + ": Current loan amount " + currentLoanAmountValue
							+ " is equal to the allocated amount " + allocatedAmountValue);
					Assert.assertTrue(true, "At position " + position + ": Current loan amount "
							+ currentLoanAmountValue + " is equal to the allocated amount " + allocatedAmountValue);
				} else {
					System.out.println("At position " + position + " for Loan Reference " + loanReference
							+ ": Current loan amount " + currentLoanAmountValue
							+ " is not equal to the allocated amount " + allocatedAmountValue);
					node.log(Status.INFO,
							"At position " + position + " for Loan Reference " + loanReference
									+ ": Current loan amount " + currentLoanAmountValue
									+ " is not equal to the allocated amount " + allocatedAmountValue);
					Assert.assertTrue(false,
							"At position " + position + " for Loan Reference " + loanReference
									+ ": Current loan amount " + currentLoanAmountValue
									+ " is not equal to the allocated amount " + allocatedAmountValue);
				}
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateExcludedForFullyAllocatedOverdueLoans", "Pass", driver);

		} catch (AssertionError validateExcludedForFullyAllocatedOverdueLoans) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateExcludedForFullyAllocatedOverdueLoans test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateExcludedForFullyAllocatedOverdueLoans_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateExcludedForFullyAllocatedOverdueLoans.printStackTrace();
			node.fail(validateExcludedForFullyAllocatedOverdueLoans);
			Assert.fail();
			extent.flush();
		} catch (Exception validateExcludedForFullyAllocatedOverdueLoans) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateExcludedForFullyAllocatedOverdueLoans test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateExcludedForFullyAllocatedOverdueLoans_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateExcludedForFullyAllocatedOverdueLoans.printStackTrace();
			node.fail(validateExcludedForFullyAllocatedOverdueLoans);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_072
	@Test(priority = 28)
	public void validateExcludedForLoansResidualMaturity() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the 'Excluded' is checked for the loan’s residual maturity less than a prescribed number of days (LARA default is 30 days)")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Get residual maturity limit value
			// String residualMaturityLimit = getDataFromExcel(64);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			WebElement residualMaturityLimitElement = IElementActions.returnElement(node, driver,
					TreasuryPortfolioPO.residualMaturityLimit);
			String residualMaturityLimitValue = residualMaturityLimitElement.getAttribute("value");

			// Scroll vertically and horizontally to access loan table exclude checkbox
			TreasuryPage.scrollVerticalAndHorizontalToAccessTable(TreasuryPortfolioPO.allocatedAmountText,
					TreasuryPortfolioPO.loanTable, TreasuryPortfolioPO.excludedLoansCheckbox);

			// Extract text using the reusable method
			List<String> residualMaturityElements = Utils.extractTextFromElements(TreasuryPortfolioPO.residualMaturity);

			// Extract text using the reusable method
			List<String> currentLoanAmountElements = Utils
					.extractTextFromElements(TreasuryPortfolioPO.currentLoanAmount);

			// Extract text using the reusable method
			List<String> allocatedAmountElements = Utils.extractTextFromElements(TreasuryPortfolioPO.allocatedAmount);

			// Scroll vertically and horizontally to access loan table exclude checkbox
			TreasuryPage.scrollVerticalAndHorizontalToAccessTable(TreasuryPortfolioPO.allocatedAmountText,
					TreasuryPortfolioPO.loanTable, TreasuryPortfolioPO.excludedLoansCheckbox);

			// Thread.sleep(2000);
			// Find all elements of excluded elements
			List<WebElement> excludedElements = IElementActions.returnElements(node, driver,
					TreasuryPortfolioPO.excludedLoansCheckbox);

			// Store the positions of checked checkboxes in excludedFacilities
			List<Integer> checkedPositions = new ArrayList<>();

			for (int i = 0; i < excludedElements.size(); i++) {
				WebElement checkbox = excludedElements.get(i).findElement(By.tagName("span"));
				if (checkbox.getAttribute("class").contains("pi-check")) {
					checkedPositions.add(i);
				}
			}

			int incorrectValue = 0;
			// Store the values of elements checked corresponding to excluded checkbox
			List<String> valuesOfElementExcluded = new ArrayList<>();
			for (int position : checkedPositions) {
				String residualMaturityValue = residualMaturityElements.get(position);
				String currentLoanAmountValue = currentLoanAmountElements.get(position);
				String allocatedAmountValue = allocatedAmountElements.get(position);
				System.out.println(
						"STEP01 : Value of the element is " + residualMaturityValue + " at position " + position);
				node.log(Status.INFO,
						"STEP01 : Value of the element is " + residualMaturityValue + " at position " + position);

				if (residualMaturityValue.equals("-")
						|| Integer.parseInt(residualMaturityValue) < Integer.parseInt(residualMaturityLimitValue)) {
					System.out.println("STEP02 : Value of excluded element value is " + residualMaturityValue);
					node.log(Status.INFO, "STEP02 : Value of excluded element value is " + residualMaturityValue);
				} else if (currentLoanAmountValue.equals(allocatedAmountValue)) {
					System.out.println("STEP02 : Current loan amount value " + currentLoanAmountValue
							+ " is equal to allocated amount value " + allocatedAmountValue);
					node.log(Status.INFO, "STEP02 : Current loan amount value " + currentLoanAmountValue
							+ " is equal to allocated amount value " + allocatedAmountValue);
				} else {
					System.out.println("STEP02 : Incorrect value i.e residual maturity limit is greater than "
							+ residualMaturityLimitValue + " of excluded element value is " + residualMaturityValue
							+ " and current loan amount value " + currentLoanAmountValue
							+ " is not equal to allocated amount value " + allocatedAmountValue);
					node.log(Status.INFO,
							"STEP02 : Incorrect value i.e residual maturity limit is greater than "
									+ residualMaturityLimitValue + " of excluded element value is "
									+ residualMaturityValue + " and current loan amount value " + currentLoanAmountValue
									+ " is not equal to allocated amount value " + allocatedAmountValue);
					incorrectValue++;
				}
			}

			// Assert Residual Maturity Limit
			if (incorrectValue == 0) {
				node.log(Status.INFO, "STEP03 : Loans with Residual Maturity <= Residual Maturity Limit is excluded");
				System.out.println("STEP03 : Loans with Residual Maturity <= Residual Maturity Limit is excluded");
				Assert.assertTrue(true, "Loans with Residual Maturity <= Residual Maturity Limit is excluded");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateExcludedForLoansResidualMaturity", "Pass", driver);
			} else {
				System.out.println("STEP03 : Loans with Residual Maturity <= Residual Maturity Limit is not excluded");
				node.log(Status.INFO,
						"STEP03 : Loans with Residual Maturity <= Residual Maturity Limit is not excluded");
				Assert.assertTrue(false, "Loans with Residual Maturity <= Residual Maturity Limit is not excluded");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateExcludedForLoansResidualMaturity", "Fail", driver);
			}
		} catch (AssertionError validateExcludedForLoansResidualMaturity) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateExcludedForLoansResidualMaturity test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateExcludedForLoansResidualMaturity_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateExcludedForLoansResidualMaturity.printStackTrace();
			node.fail(validateExcludedForLoansResidualMaturity);
			Assert.fail();
			extent.flush();
		} catch (Exception validateExcludedForLoansResidualMaturity) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateExcludedForLoansResidualMaturity test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateExcludedForLoansResidualMaturity_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateExcludedForLoansResidualMaturity.printStackTrace();
			node.fail(validateExcludedForLoansResidualMaturity);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_073
	@Test(priority = 29)
	public void validateExcludedLoansIfAllocatedInFixedManner() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that the user can exclude the loan if the loan is allocated in a fixed manner e.g. the loan is allocated entirely to a single facility")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

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

			// Get loan reference
			String loanReferenceNumber = getDataFromExcel(25);

			// Calling the openTreasuryAndEnterDetails from treasury
			TreasuryPage.openTreasuryAndEnterDetails(loanReferenceNumber);

			// Click on the save button and wait for popup
			Utils.clickAndWait(TreasurySinglePO.save, "Save Button", UtilsPO.popUp);

			// Click on popup close button
			IElementActions.clickelement_usingXpath(node, driver, PipelinePO.closeButtonInPopup);
			node.log(Status.INFO, "STEP3 : Clicked on the close icon");
			System.out.println("STEP3 : Clicked on the close icon");

			// Wait for the invisibility of the PopUp
			node.log(Status.INFO, "STEP4 : Waiting for the invisibility of the popup");
			System.out.println("STEP4 : Waiting for the invisibility of the popup");
			IWaitStrategy.waitForInVisiblity(node, driver, UtilsPO.popUp);
			node.log(Status.INFO, "STEP5 : Popup is not visible");
			System.out.println("STEP5 : Popup is not visible");

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Create the Dynamic Locator for Reference Number
			String loanReferenceLocator = IElementActions.createDynamicLocatorString(
					TreasuryPortfolioPO.dynamicReference, "locatorValue", loanReferenceNumber);

			// Get loan value
			String loanValue = IElementActions.getElementText_usingXpath(node, driver, loanReferenceLocator);

			// Create the Dynamic Locator for exclude checkbox
			String excludeCheckboxCorrespondingToLoanLocator = IElementActions.createDynamicLocatorString(
					TreasuryPortfolioPO.excludeCheckboxCorrespondingToLoan, "locatorValue", loanReferenceNumber);

			// Scroll vertically and horizontally to access loan table exclude checkbox
			TreasuryPage.scrollVerticalAndHorizontalToAccessTable(loanReferenceLocator, TreasuryPortfolioPO.loanTable,
					excludeCheckboxCorrespondingToLoanLocator);

			boolean loanExcludedStatus = IElementActions
					.checkAttributePresentInClass(excludeCheckboxCorrespondingToLoanLocator, "pi-check");

			// Assert loan is excluded
			if (loanExcludedStatus) {
				node.log(Status.INFO, "STEP6 : Loan " + loanValue + " is excluded i.e exclude checbox is checked");
				System.out.println("STEP6 : Loan " + loanValue + " is excluded i.e exclude checbox is checked");
				Assert.assertTrue(true, "Loan " + loanValue + " is excluded i.e exclude checbox is checked");
				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateExcludedLoansIfAllocatedInFixedManner", "Pass",
						driver);
			} else {
				System.out.println("STEP6 : Loan " + loanValue + " is not excluded i.e exclude checbox is not checked");
				node.log(Status.INFO,
						"STEP6 : Loan " + loanValue + " is not excluded i.e exclude checbox is not checked");
				Assert.assertTrue(false, "Loan " + loanValue + " is not excluded i.e exclude checbox is not checked");
				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateExcludedLoansIfAllocatedInFixedManner", "Fail",
						driver);
			}
		} catch (AssertionError validateExcludedLoansIfAllocatedInFixedManner) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateExcludedLoansIfAllocatedInFixedManner test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateExcludedLoansIfAllocatedInFixedManner_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateExcludedLoansIfAllocatedInFixedManner.printStackTrace();
			node.fail(validateExcludedLoansIfAllocatedInFixedManner);
			Assert.fail();
			extent.flush();
		} catch (Exception validateExcludedLoansIfAllocatedInFixedManner) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateExcludedLoansIfAllocatedInFixedManner test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateExcludedLoansIfAllocatedInFixedManner_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateExcludedLoansIfAllocatedInFixedManner.printStackTrace();
			node.fail(validateExcludedLoansIfAllocatedInFixedManner);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_086
	@Test(priority = 30)
	public void validateNavigationFromStep3ToStep4() throws IOException {

		try {
			extenttest = extent
					.createTest(
							"Verify that the user can proceed from 'step3' to 'step4' by clicking on the 'Next Step'")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			IElementActions.clickelement_usingXpath(node, driver, TreasuryPortfolioPO.step3);
			node.log(Status.INFO, "STEP1 : Clicked on the step3");
			System.out.println("STEP1 : Clicked on the step3");

			// Wait for page loading
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

			Thread.sleep(5000);
			// Wait for the visibility of the step3
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the step3");
			System.out.println("STEP2 : Waiting for the visibility of the step3");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryPortfolioPO.target);
			node.log(Status.INFO, "STEP3 : Step3 is visible");
			System.out.println("STEP3 : Step3 is visible");

			Thread.sleep(5000);
			// Calling the bottomNextStepButton function from Funding Page
			FundingPage.bottomNextStepButton(UtilsPO.nextStepButton, 3, "Reallocate Loans");

			// Wait for page loading
			IWaitStrategy.WaitForPageLoadingToComplete(node, driver);
			Thread.sleep(10000);
			// Wait for the visibility of the step4
			node.log(Status.INFO, "STEP4 : Waiting for the visibility of the step4 elements");
			System.out.println("STEP4 : Waiting for the visibility of the step4 elements");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryPortfolioPO.facilityAmount);
			node.log(Status.INFO, "STEP5 : Step4 is visible");
			System.out.println("STEP5 : Step4 is visible");

			Thread.sleep(2000);
			// Check if the 'step--current' is present in the class attribute
			boolean isHighlighted = IElementActions
					.checkAttributePresentInClass(TreasuryPortfolioPO.amendAllocationsStep, "step--current");

			// Assert Reallocate Loans step is highlighted or not
			if (isHighlighted) {
				node.log(Status.INFO, "SUB-STEP_0.001 :The Step 4 Amend Allocations is highlighted");
				System.out.println("SUB-STEP_0.001 : The Step 4 Amend Allocations is highlighted");

				Assert.assertTrue(true, "The 4 Amend Allocations is highlighted");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateNavigationFromStep3ToStep4", "Pass", driver);
			} else {
				System.out.println("SUB-STEP_0.001 : The Step 4 Amend Allocations is not highlighted");
				node.log(Status.INFO, "SUB-STEP_0.001 :The Step 4 Amend Allocations is not highlighted");

				Assert.assertTrue(false, "The Step 4 Amend Allocations is not highlighted");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateNavigationFromStep3ToStep4", "Fail", driver);
			}

		} catch (AssertionError validateNavigationFromStep3ToStep4) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNavigationFromStep3ToStep4 test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNavigationFromStep3ToStep4_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNavigationFromStep3ToStep4.printStackTrace();
			node.fail(validateNavigationFromStep3ToStep4);
			Assert.fail();
			extent.flush();
		} catch (Exception validateNavigationFromStep3ToStep4) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNavigationFromStep3ToStep4 test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNavigationFromStep3ToStep4_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNavigationFromStep3ToStep4.printStackTrace();
			node.fail(validateNavigationFromStep3ToStep4);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_120
	@Test(priority = 31)
	public void validateCurrentAllocationForAllExcludedFacilities() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that for all excluded facilities, Current Allocation = Revised Allocation before user presses 'Save'")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadLoginPage function from the login
			LoginPage.loadLoginPage();

			// Calling the userLoginProcess function from the LoginPage
			LoginPage.userLoginProcess(node, driver, getDataFromExcel(1), getDataFromExcel(2));

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Scroll to the element vertically
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, TreasuryPortfolioPO.excludedText);
			node.log(Status.INFO, "STEP1 : Scrolled to the element vertically");
			System.out.println("STEP1 : Scrolled to the element vertically");

			// Wait for the visibility of the facilities
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the excluded elements");
			System.out.println("STEP2: Waiting for the visibility of the excluded elements");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryPortfolioPO.facilities);
			node.log(Status.INFO, "STEP3 :  Excluded elements is visible");
			System.out.println("STEP3 : Excluded elements is visible");

			// Find all elements of the facilities column
			List<WebElement> facilitiesElements = IElementActions.returnElements(node, driver,
					TreasuryPortfolioPO.facilities);

			// Scroll horizontally in Table
			Thread.sleep(1000);
			IElementActions.scrollHorizontally(driver, TreasuryPortfolioPO.facilityTable, 1000);
			node.log(Status.INFO, "STEP4 : Scrolled to the element horizontally");
			System.out.println("STEP4 : Scrolled to the element horizontally");

			// Wait for the visibility of the excluded elements
			node.log(Status.INFO, "STEP5 : Waiting for the visibility of the excluded elements");
			System.out.println("STEP5 : Waiting for the visibility of the excluded elements");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryPortfolioPO.excludedFacilities);
			node.log(Status.INFO, "STEP6 :  Excluded elements is visible");
			System.out.println("STEP6 : Excluded elements is visible");

			// Find all elements of excluded elements
			List<WebElement> excludedElements = IElementActions.returnElements(node, driver,
					TreasuryPortfolioPO.excludedFacilities);

			// Store the positions of checked checkboxes in excludedFacilities
			List<Integer> checkedPositions = new ArrayList<>();

			// Store the positions of unchecked checkboxes in excludedFacilities
			List<Integer> uncheckedPositions = new ArrayList<>();

			for (int i = 0; i < excludedElements.size(); i++) {
				WebElement checkbox = excludedElements.get(i).findElement(By.tagName("span"));
				if (checkbox.getAttribute("class").contains("pi-check")) {
					checkedPositions.add(i);
				} else {
					uncheckedPositions.add(i);
				}
			}

			// Store the values of elements checked corresponding to excluded checkbox
			List<String> excludedFacilities = new ArrayList<>();

			for (int position : checkedPositions) {
				WebElement facilitiesElement = facilitiesElements.get(position);
				String facilitynumber = facilitiesElement.getText();
				excludedFacilities.add(facilitynumber);
			}

			// Click on step3
			TreasuryPage.clickOnStepper(TreasuryPortfolioPO.step3, TreasuryPortfolioPO.target);
			node.log(Status.INFO, "STEP7 : Clicked on the step3");
			System.out.println("STEP7 : Clicked on the step3");

			// Click on step4
			TreasuryPage.clickOnStepper(TreasuryPortfolioPO.step4, TreasuryPortfolioPO.facilityAmount);
			node.log(Status.INFO, "STEP2 : Clicked on the step4");
			System.out.println("STEP2 : Clicked on the step4");

			// Find all elements of the facilities in step4
			List<WebElement> facilityElementsInStep4 = IElementActions.returnElements(node, driver,
					TreasuryPortfolioPO.facilitiesInStep4);

			// Store the excluded facility positions of step4
			List<Integer> facilityPositions = new ArrayList<>();

			// Store the matched facility of step4
			List<String> facilityInStep4 = new ArrayList<>();

			for (String excludedFacility : excludedFacilities) {
				for (int j = 0; j < facilityElementsInStep4.size(); j++) {
					WebElement facilityElement = facilityElementsInStep4.get(j);
					String facilityValueInStep4 = facilityElement.getText();
					if (facilityValueInStep4.equals(excludedFacility)) {
						facilityPositions.add(j);
						facilityInStep4.add(facilityValueInStep4);
						break;
					}
				}
			}

			int incorrectValue = 0;

			for (int i = 0; i < facilityPositions.size(); i++) {

				String facilityReference = facilityInStep4.get(i);

				int facilityCurrentAmountPosition = facilityPositions.get(i);
				facilityCurrentAmountPosition = (facilityCurrentAmountPosition * 2) + 5;

				// Create the dynamic locator for facility current amount
				String facilityCurrentAmountLocator = IElementActions.createDynamicLocatorString(
						TreasuryPortfolioPO.facilitiesAmounts, "locatorValue",
						Integer.toString(facilityCurrentAmountPosition));

				int facilityRevisedAmountPosition = facilityCurrentAmountPosition + 1;

				// Create the dynamic locator for facility current amount
				String facilityRevisedAmountLocator = IElementActions.createDynamicLocatorString(
						TreasuryPortfolioPO.revisedFacilitiesAmounts, "locatorValue",
						Integer.toString(facilityRevisedAmountPosition));

				// Scroll vertically and horizontally to access loan table exclude checkbox
				TreasuryPage.scrollVerticalAndHorizontalToAccessTable(TreasuryPortfolioPO.compliance,
						facilityRevisedAmountLocator, facilityRevisedAmountLocator);

				// Find all elements of the facility current amount column
				List<String> facilityCurrentAmountElements = Utils
						.extractTextFromElements(facilityCurrentAmountLocator);

				// Find all elements of excluded elements
				List<String> facilityRevisedAmountElements = Utils
						.extractTextFromInputElements(facilityRevisedAmountLocator);

				for (int k = 0; k < facilityCurrentAmountElements.size(); k++) {
					// Get the value of facility current amount
					String facilityCurrentAmountValue = facilityCurrentAmountElements.get(k);
					// Get the value of facility current amount
					String facilityRevisedAmountValue = facilityRevisedAmountElements.get(k);
					// Compare the facility current amount with facility revised amount
					if (facilityCurrentAmountValue.equals(facilityRevisedAmountValue)) {
						System.out.println("STEP8 : At position " + (k + 1) + ": Facility " + facilityReference
								+ " current amount " + facilityCurrentAmountValue
								+ " is equal to the facility revised amount " + facilityRevisedAmountValue);
						node.log(Status.INFO,
								"STEP8 : At position " + (k + 1) + ": Facility " + facilityReference
										+ " current amount " + facilityCurrentAmountValue
										+ " is equal to the facility revised amount " + facilityRevisedAmountValue);
					} else {
						System.out.println("STEP8 : At position " + (k + 1) + ": Facility " + facilityReference
								+ " current amount " + facilityCurrentAmountValue
								+ " is equal to the facility revised amount " + facilityRevisedAmountValue);
						node.log(Status.INFO,
								"STEP8 : At position " + (k + 1) + ": Facility " + facilityReference
										+ " current amount " + facilityCurrentAmountValue
										+ " is equal to the facility revised amount " + facilityRevisedAmountValue);
						incorrectValue++;
					}
				}
			}

			// Assert excluded facility current amount and facility revised amount
			if (incorrectValue == 0) {
				node.log(Status.INFO, "STEP9 : Excluded facilities current amount and revised amount are same");
				System.out.println("STEP9 : Excluded facilities current amount and revised amount are same");
				Assert.assertTrue(true, "STEP9 : Excluded facilities current amount and revised amount are same");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateCurrentAllocationForAllExcludedFacilities", "Pass",
						driver);
			} else {
				System.out.println("STEP9 : Excluded facilities current amount and revised amount are not same");
				node.log(Status.INFO, "STEP9 : Excluded facilities current amount and revised amount are not same");
				Assert.assertTrue(false, "STEP9 : Excluded facilities current amount and revised amount are not same");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateCurrentAllocationForAllExcludedFacilities", "Fail",
						driver);
			}
		} catch (AssertionError validateCurrentAllocationForAllExcludedFacilities) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCurrentAllocationForAllExcludedFacilities test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatePortfolioSteps_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCurrentAllocationForAllExcludedFacilities.printStackTrace();
			node.fail(validateCurrentAllocationForAllExcludedFacilities);
			Assert.fail();
			extent.flush();
		} catch (Exception validateCurrentAllocationForAllExcludedFacilities) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCurrentAllocationForAllExcludedFacilities test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCurrentAllocationForAllExcludedFacilities_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCurrentAllocationForAllExcludedFacilities.printStackTrace();
			node.fail(validateCurrentAllocationForAllExcludedFacilities);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Treasury_Portfolio_122
	@Test(priority = 32)
	public void validateBackFromStep4ToStep3() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the user can back to 'Step3' from 'Step4' by clicking on back button or stepper")
					.assignCategory(treasuryPortfolio_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Get loan reference number
			String loanReferenceNumber = getDataFromExcel(13);

			// Calling the openPortfolioStep2 from treasury
			TreasuryPage.openPortfolioStep2();

			// Wait for the visibility of the step3 stepper in step2
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the step3");
			System.out.println("STEP1 : Waiting for the visibility of the step3");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryPortfolioPO.step3);
			IWaitStrategy.WaitUntilElementClickable(node, driver, TreasuryPortfolioPO.step3);
			node.log(Status.INFO, "STEP2 : Step3 is visible and clickable");
			System.out.println("STEP2 : Step3 is visible and clickable");

			IElementActions.clickelement_usingXpath(node, driver, TreasuryPortfolioPO.step3);
			node.log(Status.INFO, "STEP3 : Clicked on the step3");
			System.out.println("STEP3 : Clicked on the step3");

			// Wait for the visibility of the step3 elements
			node.log(Status.INFO, "STEP4 : Waiting for the visibility of the step3");
			System.out.println("STEP4 : Waiting for the visibility of the step3");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryPortfolioPO.target);
			IWaitStrategy.WaitUntilElementClickable(node, driver, TreasuryPortfolioPO.step4);
			node.log(Status.INFO, "STEP5 : Step3 is visible");
			System.out.println("STEP5 : Step3 is visible");

			IElementActions.clickelement_usingXpath(node, driver, TreasuryPortfolioPO.step4);
			node.log(Status.INFO, "STEP6 : Clicked on the step4");
			System.out.println("STEP6 : Clicked on the step4");

			// Wait for the visibility of the step4 elements
			node.log(Status.INFO, "STEP7 : Waiting for the visibility of the step4");
			System.out.println("STEP7 : Waiting for the visibility of the step4");
			IWaitStrategy.waitForVisiblity(node, driver, TreasuryPortfolioPO.facilityAmount);
			node.log(Status.INFO, "STEP8 : Step4 is visible");
			System.out.println("STEP8 : Step4 is visible");

			// Calling the bottomBackStepButton function from Funding Page
			FundingPage.bottomBackStepButton(UtilsPO.backStepButton, 4, "Step 4 Amend Allocations");

			// Check if the 'step--current' is present in the class attribute
			boolean isHighlighted = IElementActions
					.checkAttributePresentInClass(TreasuryPortfolioPO.reallocateLoansStep, "step--current");

			// Assert Reallocate Loans step is highlighted or not
			if (isHighlighted) {
				node.log(Status.INFO, "SUB-STEP_0.001 :The Step 3 Reallocate Loans is highlighted");
				System.out.println("SUB-STEP_0.001 : The Step 3 Reallocate Loans is highlighted");

				Assert.assertTrue(true, "The 3 Reallocate Loans is highlighted");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateBackFromStep4ToStep3", "Pass", driver);
			} else {
				System.out.println("SUB-STEP_0.001 : The Step 3 Reallocate Loans is not highlighted");
				node.log(Status.INFO, "SUB-STEP_0.001 :The Step 3 Reallocate Loans is not highlighted");

				Assert.assertTrue(false, "The Step 3 Reallocate Loans is not highlighted");

				// Take screenshot
				IScreenAction.captureScreenShot_PassCase("validateBackFromStep4ToStep3", "Fail", driver);
			}

		} catch (AssertionError validateBackFromStep4ToStep3) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateBackFromStep4ToStep3 test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateBackFromStep4ToStep3_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBackFromStep4ToStep3.printStackTrace();
			node.fail(validateBackFromStep4ToStep3);
			Assert.fail();
			extent.flush();
		} catch (Exception validateBackFromStep4ToStep3) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateBackFromStep4ToStep3 test in PortfolioTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateBackFromStep4ToStep3_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateBackFromStep4ToStep3.printStackTrace();
			node.fail(validateBackFromStep4ToStep3);
			Assert.fail();
			extent.flush();
		}
	}
}