package com.Funding.InterestPayment.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.locators.allPages.FundingDatabasePO;
import com.locators.allPages.FundingInterestPaymentPO;
import com.locators.allPages.SideMenuPO;
import com.locators.allPages.UtilsPO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.utils.FundingPage;
import com.qa.utils.LoginPage;
import com.qa.utils.Utils;

public class InterestPaymentStep5Test extends Baseclass {

	// TC_InterestPayment_Step5_352
	@Test(priority = 1)
	public void validateNavigationToStep5() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the when user clicks on the Next Step button in Step3, the user is navigated to the next step(Step-5)")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			// Calling the userLoginProcess function from the utils login
			LoginPage.userLoginProcess(node, driver, getDataFromExcel(1), getDataFromExcel(2));

			// Calling the loadInterestPaymentPageAndNavigateToStep5 function from
			// FundingPage to access the step5 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep5(getDataFromExcel(6), getDataFromExcel(7));

			// Check if the 'step--current' is present in the class attribute
			boolean isHighlighted = IElementActions
					.checkAttributePresentInClass(FundingInterestPaymentPO.accountingStep, "step--current");

			// Assert that the User is not Navigated to Step 5
			IElementActions.assertTrue_usingboolean(node, driver, isHighlighted,
					"STEP1 : BUG : The User is not Navigated to Step 5",
					"STEP1 : PASS : The User is Navigated to Step 5");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateNavigationToStep5", "Pass", driver);

		} catch (AssertionError validateNavigationToStep5) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNavigationToStep5 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateNavigationToStep5_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNavigationToStep5.printStackTrace();
			node.fail(validateNavigationToStep5);
			Assert.fail();
			extent.flush();

		} catch (Exception validateNavigationToStep5) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNavigationToStep5 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateNavigationToStep5_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNavigationToStep5.printStackTrace();
			node.fail(validateNavigationToStep5);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step5_353
	@Test(priority = 2)
	public void validateCalculationStartAndEndDate() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the 'Calculation Start Date' and 'Calculation End Date' in Step 5")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Check the visibility of Calculation Start Date in Step2
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.calculationStartDateField,
					"STEP1 : BUG: The Calculation Start Date is not coming in Step2",
					"STEP1 : EXPECTED: The Calculation Start Date is coming in Step2");

			// Get The Calculation Start Date
			String calculationStartDateInStep2 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.calculationStartDateField);
			node.log(Status.INFO, "STEP2 : The Calculation Start Date in Step2 : " + calculationStartDateInStep2);
			System.out.println("STEP2 : The Calculation Start Date in Step2 : " + calculationStartDateInStep2);

			// Check the visibility of Calculation End Date in Step2
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.calculationEndDateField,
					"STEP3 : BUG: The Calculation End Date is not coming in Step2",
					"STEP3 : EXPECTED: The Calculation End Date is coming in Step2");

			// Get The Calculation End Date
			String calculationEndDateInStep2 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.calculationEndDateField);
			node.log(Status.INFO, "STEP4 : The Calculation End Date in Step2 : " + calculationEndDateInStep2);
			System.out.println("STEP4 : The Calculation End Date in Step2 : " + calculationEndDateInStep2);

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.accountingStep5);

			// Check the visibility of Calculation Start Date in Step5
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.calculationStartDateInStep5,
					"STEP5 : BUG: The Calculation Start Date is not coming in Step5",
					"STEP5 : EXPECTED: The Calculation Start Date is coming in Step5");

			// Get The Calculation Start Date
			String calculationStartDateInStep5 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.calculationStartDateInStep5);
			node.log(Status.INFO, "STEP6 : The Calculation Start Date in Step5 : " + calculationStartDateInStep5);
			System.out.println("STEP6 : The Calculation Start Date in Step5 : " + calculationStartDateInStep5);

			// Check the visibility of Calculation End Date in Step5
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.calculationEndDateInStep5,
					"STEP7 : BUG: The Calculation End Date is not coming in Step5",
					"STEP7 : EXPECTED: The Calculation End Date is coming in Step5");

			// Get The Calculation End Date
			String calculationEndDateInStep5 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.calculationEndDateInStep5);
			node.log(Status.INFO, "STEP8 : The Calculation End Date in Step5 : " + calculationEndDateInStep5);
			System.out.println("STEP8 : The Calculation End Date in Step5 : " + calculationEndDateInStep5);

			// Assert Calculation Start Date
			IElementActions.assertEquals_usingString(node, driver, calculationStartDateInStep5,
					calculationStartDateInStep2,
					"STEP9 : BUG : The Calculation Start Date in Step5 is not Same as Calculation Start Date in Step2",
					"STEP9 : PASS : The Calculation Start Date in Step5 is Same as Calculation Start Date in Step2");

			// Assert Calculation End Date
			IElementActions.assertEquals_usingString(node, driver, calculationEndDateInStep5, calculationEndDateInStep2,
					"STEP10 : BUG : The Calculation End Date in Step5 is not Same as Calculation End Date in Step2",
					"STEP10 : PASS : The Calculation End Date in Step5 is Same as Calculation End Date in Step2");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCalculationStartAndEndDate", "Pass", driver);

		} catch (AssertionError validateCalculationStartAndEndDate) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCalculationStartAndEndDate test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCalculationStartAndEndDate_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCalculationStartAndEndDate.printStackTrace();
			node.fail(validateCalculationStartAndEndDate);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCalculationStartAndEndDate) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCalculationStartAndEndDate test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCalculationStartAndEndDate_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCalculationStartAndEndDate.printStackTrace();
			node.fail(validateCalculationStartAndEndDate);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step5_357
	@Test(priority = 3)
	public void validateFacilityTableColumnsVisibility() throws IOException {

		try {
			extenttest = extent.createTest("Verify the fields under the facility table")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep5 function from
			// FundingPage to access the step5 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep5(getDataFromExcel(6), getDataFromExcel(7));

			// Check the visibility of Facility Name Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.facilityNameColumn,
					"STEP1 : BUG: The Facility Name Column is not coming under Facility table in Step5",
					"STEP1 : EXPECTED: The Facility Name Column is coming under Facility table in Step5");

			// Check the visibility of Internal Reference Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.internalReferenceColumn,
					"STEP2 : BUG: The Internal Reference Column is not coming under Facility table in Step5",
					"STEP2 : EXPECTED: The Internal Reference Column is coming under Facility table in Step5");

			// Check the visibility of Amount Payable Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.amountPayableColumn,
					"STEP3 : BUG: The Amount Payable Column is not coming under Facility table in Step5",
					"STEP3 : EXPECTED: The Amount Payable Column is coming under Facility table in Step5");

			// Check the visibility of Carried Forward Column
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.carriedForwardColumn,
					"STEP4 : BUG: The Carried Forward Column is not coming under Facility table in Step5",
					"STEP4 : EXPECTED: The Carried Forward Column is coming under Facility table in Step5");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityTableColumnsVisibility", "Pass", driver);

		} catch (AssertionError validateFacilityTableColumnsVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityTableColumnsVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityTableColumnsVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityTableColumnsVisibility.printStackTrace();
			node.fail(validateFacilityTableColumnsVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityTableColumnsVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityTableColumnsVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityTableColumnsVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityTableColumnsVisibility.printStackTrace();
			node.fail(validateFacilityTableColumnsVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step5_358
	@Test(priority = 4)
	public void validateInternalReferenceOfAllFacilities() throws IOException {

		try {
			extenttest = extent.createTest("Verify that the user can see the internal reference of all the facilities")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep4 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Locate the list element by its XPath
			List<WebElement> referenceElementsStep4 = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.facilitiesReferenceInStep4);

			// Initialize a List to store facilities reference as strings
			List<String> facilitiesReferenceInStep4 = new ArrayList<>();

			// Iterate through each element in the list
			for (WebElement element : referenceElementsStep4) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				facilitiesReferenceInStep4.add(elementValue);
			}

			// Print or use the List of facilities reference as needed
			System.out.println("Facilities Reference In Step4: " + facilitiesReferenceInStep4);

			// Calling the navigateToStep function from the FundingPage
			FundingPage.navigateToStep(FundingInterestPaymentPO.accountingStep5);

			// Wait for the visibility of the element
			node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the step5 page");
			System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the step5 page");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.internalReferenceColumn);
			node.log(Status.INFO, "SUB-STEP_0.002 : Step5 page is visible");
			System.out.println("SUB-STEP_0.002 : Step5 page is visible");

			// Locate the list element by its XPath or any other suitable method
			List<WebElement> referenceElementsStep5 = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.internalReferenceAllFacilities);

			// Initialize a List to store facility reference as strings
			List<String> facilitiesReferenceInStep5 = new ArrayList<>();

			// Iterate through each element in the list
			for (WebElement element : referenceElementsStep5) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				facilitiesReferenceInStep5.add(elementValue);
			}

			// Print or use the List of facility reference as needed
			System.out.println("Facilities Reference In Step5: " + facilitiesReferenceInStep5);

			// Perform assertion for each pair of values in the lists
			boolean allValuesMatch = true;

			System.out.println("facilitiesReferenceInStep4 " + facilitiesReferenceInStep4.size());
			System.out.println("facilitiesReferenceInStep5 " + facilitiesReferenceInStep5.size());
			for (int i = 0; i < facilitiesReferenceInStep4.size(); i++) {
				String valueFromList1 = facilitiesReferenceInStep4.get(i);
				String valueFromList2 = facilitiesReferenceInStep5.get(i);

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

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateInternalReferenceOfAllFacilities", "Pass", driver);

		} catch (AssertionError validateInternalReferenceOfAllFacilities) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInternalReferenceOfAllFacilities test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInternalReferenceOfAllFacilities_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInternalReferenceOfAllFacilities.printStackTrace();
			node.fail(validateInternalReferenceOfAllFacilities);
			Assert.fail();
			extent.flush();

		} catch (Exception validateInternalReferenceOfAllFacilities) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInternalReferenceOfAllFacilities test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInternalReferenceOfAllFacilities_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInternalReferenceOfAllFacilities.printStackTrace();
			node.fail(validateInternalReferenceOfAllFacilities);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step5_359
	@Test(priority = 5)
	public void validateFacilityNameCorrespondingInternalReference() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify the 'Facility Name' corresponding to a 'Internal Reference' and is same as displayed at Loan Facility Summary page")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep5 function from
			// FundingPage to access the step5 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep5(getDataFromExcel(6), getDataFromExcel(7));

			String facilityReference = getDataFromExcel(9);

			String facilityNameLocator = IElementActions.createDynamicLocatorString(
					FundingInterestPaymentPO.facilityName, "locatorValue", facilityReference);

			// Get the Facility Name
			String facilityName = IElementActions.getElementText_usingXpath(node, driver, facilityNameLocator);
			node.log(Status.INFO, "STEP1 :  Facility Name : " + facilityName);
			System.out.println("STEP1 :  Facility Name : " + facilityName);

			// Click on the Database SubMenu
			Utils.clickOnMenu(node, driver, SideMenuPO.fundingDatabase);

			// Calling the openRecordUsingSearch from Utils
			Utils.openRecordUsingSearch(UtilsPO.headerSearchCrossIcon, FundingDatabasePO.referenceSearchField,
					facilityReference, UtilsPO.editIcon, FundingDatabasePO.editLoanFacilityText);

			// Get the Internal Reference
			String internalReference = IElementActions
					.getElementText_usingXpath(node, driver, FundingDatabasePO.internalReference).substring(21);
			node.log(Status.INFO, "STEP2 : Internal Reference : " + internalReference);
			System.out.println("STEP2 : Internal Reference : " + internalReference);

			// Assert the Facility Name
			IElementActions.assertEquals_usingString(node, driver, facilityName, internalReference,
					"STEP3 : BUG : The Facility Name corresponding to a Internal Reference in Step5 of Interest Payment is not same as Internal Reference of Edit Loan Facility Page",
					"STEP3 : PASS : The Facility Name corresponding to a Internal Referencein Step5 of Interest Payment is same as Internal Reference of Edit Loan Facility Page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityNameCorrespondingInternalReference", "Pass",
					driver);

		} catch (AssertionError validateFacilityNameCorrespondingInternalReference) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityNameCorrespondingInternalReference test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityNameCorrespondingInternalReference_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityNameCorrespondingInternalReference.printStackTrace();
			node.fail(validateFacilityNameCorrespondingInternalReference);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityNameCorrespondingInternalReference) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityNameCorrespondingInternalReference test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityNameCorrespondingInternalReference_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityNameCorrespondingInternalReference.printStackTrace();
			node.fail(validateFacilityNameCorrespondingInternalReference);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step5_360
	@Test(priority = 6)
	public void validateFacilityAmountPayable() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify the Facility Amount Payable is same as Interest Payment Amount at Step4")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep4 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Locate the list element by its XPath
			List<WebElement> payableElementsStep4 = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.facilitiesPayableAmountInStep4);

			// Initialize a List to store facilities payable as strings
			List<String> facilitiesPayableInStep4 = new ArrayList<>();

			// Iterate through each element in the list
			for (WebElement element : payableElementsStep4) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				facilitiesPayableInStep4.add(elementValue);
			}

			// Print or use the List of facilities reference as needed
			System.out.println("Facilities Payable In Step4: " + facilitiesPayableInStep4);

			// Calling the navigateToStep function from the FundingPage
			FundingPage.navigateToStep(FundingInterestPaymentPO.accountingStep5);

			// Wait for the visibility of the element
			node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the step5 page");
			System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the step5 page");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.allFacilitiesAmountPayable);
			node.log(Status.INFO, "SUB-STEP_0.002 : Step5 page is visible");
			System.out.println("SUB-STEP_0.002 : Step5 page is visible");

			// Locate the list element by its XPath or any other suitable method
			List<WebElement> payableElementsStep5 = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.allFacilitiesAmountPayable);

			// Initialize a List to store facility payable as strings
			List<String> facilitiesPayableInStep5 = new ArrayList<>();

			// Iterate through each element in the list
			for (WebElement element : payableElementsStep5) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				facilitiesPayableInStep5.add(elementValue);
			}

			// Print or use the List of facility amounts as needed
			System.out.println("Facilities Payable In Step5: " + facilitiesPayableInStep5);

			// Perform assertion for each pair of values in the lists
			boolean allValuesMatch = true;

			for (int i = 0; i < facilitiesPayableInStep4.size(); i++) {
				String valueFromList1 = facilitiesPayableInStep4.get(i);
				String valueFromList2 = facilitiesPayableInStep5.get(i);

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

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFacilityAmountPayable", "Pass", driver);

		} catch (AssertionError validateFacilityAmountPayable) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFacilityAmountPayable test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityAmountPayable_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityAmountPayable.printStackTrace();
			node.fail(validateFacilityAmountPayable);
			Assert.fail();
			extent.flush();

		} catch (Exception validateFacilityAmountPayable) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFacilityAmountPayable test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFacilityAmountPayable_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFacilityAmountPayable.printStackTrace();
			node.fail(validateFacilityAmountPayable);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step5_361
	@Test(priority = 7)
	public void validateCarriedForwardLoanAmount() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify the Carried Forward Loan Amount corresponding to an 'Internal Reference'")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling loadInterestPaymentPageAndNavigateToStep4 function to access step3 of
			// interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep4(getDataFromExcel(6), getDataFromExcel(7));

			// Locate the list element by its XPath
			List<WebElement> carriedForwardElementsStep4 = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.facilitiesCarridForwardAmountInStep4);

			// Initialize a List to store facilities carried forward as strings
			List<String> carriedForwardInStep4 = new ArrayList<>();

			// Iterate through each element in the list
			for (WebElement element : carriedForwardElementsStep4) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				carriedForwardInStep4.add(elementValue);
			}

			// Print or use the List of facilities reference as needed
			System.out.println("Facilities carried forward in step4: " + carriedForwardInStep4);

			// Calling the navigateToStep function from the FundingPage
			FundingPage.navigateToStep(FundingInterestPaymentPO.accountingStep5);

			// Wait for the visibility of the element
			node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the step5 page");
			System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the step5 page");
			IWaitStrategy.waitForVisiblity(node, driver, FundingInterestPaymentPO.allFacilitiesCarriedForward);
			node.log(Status.INFO, "SUB-STEP_0.002 : Step5 page is visible");
			System.out.println("SUB-STEP_0.002 : Step5 page is visible");

			// Locate the list element by its XPath or any other suitable method
			List<WebElement> carriedForwardElementsStep5 = IElementActions.returnElements(node, driver,
					FundingInterestPaymentPO.allFacilitiesCarriedForward);

			// Initialize a List to store facility amounts as strings
			List<String> carriedForwardInStep5 = new ArrayList<>();

			// Iterate through each element in the list
			for (WebElement element : carriedForwardElementsStep5) {
				// Get the text value from the element and add it to the List
				String elementValue = element.getText();
				carriedForwardInStep5.add(elementValue);
			}

			// Print or use the List of facility amounts as needed
			System.out.println("Facilities carried forward in step5: " + carriedForwardInStep5);

			// Perform assertion for each pair of values in the lists
			boolean allValuesMatch = true;

			for (int i = 0; i < carriedForwardInStep4.size(); i++) {
				String valueFromList1 = carriedForwardInStep4.get(i);
				String valueFromList2 = carriedForwardInStep5.get(i);

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

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCarriedForwardLoanAmount", "Pass", driver);

		} catch (AssertionError validateCarriedForwardLoanAmount) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCarriedForwardLoanAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCarriedForwardLoanAmount_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCarriedForwardLoanAmount.printStackTrace();
			node.fail(validateCarriedForwardLoanAmount);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCarriedForwardLoanAmount) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCarriedForwardLoanAmount test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCarriedForwardLoanAmount_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCarriedForwardLoanAmount.printStackTrace();
			node.fail(validateCarriedForwardLoanAmount);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step5_362
	@Test(priority = 8)
	public void validateOverallSectionVisibility() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the 'Overall' section is displayed to the user when they click on the next step of Step 4'")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep5 function from
			// FundingPage to access the step5 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep5(getDataFromExcel(6), getDataFromExcel(7));

			// Check the visibility of Overall Section
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.overallSection,
					"STEP1 : BUG: The Overall Section is not coming in Step5",
					"STEP1 : EXPECTED: The Overall Section is coming in Step5");

			// Check the visibility of Interest Income field
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestIncomeUnderOverall,
					"STEP2 : BUG: The Interest Income field is not coming under Overall Section in Step5",
					"STEP2 : EXPECTED: The Interest Income field is coming under Overall Section in Step5");

			// Check the visibility of Interest Expense field
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.interestExpenseFieldInStep5,
					"STEP3 : BUG: The Interest Expense field is not coming under Overall Section in Step5",
					"STEP3 : EXPECTED: The Interest Expense field is coming under Overall Section in Step5");

			// Check the visibility of Net Interest Margin Field
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.netInterestMarginFieldInStep5,
					"STEP4 : BUG: The Net Interest Margin Field is not coming under Overall Section in Step5",
					"STEP4 : EXPECTED: The Net Interest Margin Field is coming under Overall Section in Step5");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateOverallSectionVisibility", "Pass", driver);

		} catch (AssertionError validateOverallSectionVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateOverallSectionVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateOverallSectionVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateOverallSectionVisibility.printStackTrace();
			node.fail(validateOverallSectionVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateOverallSectionVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateOverallSectionVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateOverallSectionVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateOverallSectionVisibility.printStackTrace();
			node.fail(validateOverallSectionVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step5_363
	@Test(priority = 9)
	public void validateInterestIncomeAtStep5() throws IOException {

		try {
			extenttest = extent.createTest("Verify the 'Interest Income' under Overall")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Scrolloed down to Facility Rate Max Difference Tolerance
			IElementActions.scrollbyJSExecutorUsingElementPath(driver,
					FundingInterestPaymentPO.facilityRateMaxDifferenceTolerance);
			node.log(Status.INFO, "STEP1 : Scrolloed down to Facility Rate Max Difference Tolerance");
			System.out.println("STEP1 : Scrolloed down to Facility Rate Max Difference Tolerance");

			// Check the visibility of Facility Loan Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.facilityLoanAmount,
					"STEP2 : BUG: The Facility Loan Amount is not coming under Facility Table in Step2",
					"STEP2 : EXPECTED: The Facility Loan Amount is coming under Facility Table in Step2");

			// Get the Facility Loan Amount under Facility Table
			String facilityLoanAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.facilityLoanAmount);
			node.log(Status.INFO,
					"STEP3 : The Facility Loan Amount under Facility Table in Step2 : " + facilityLoanAmount);
			System.out
					.println("STEP3 : The Facility Loan Amount under Facility Table in Step2 : " + facilityLoanAmount);

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.accountingStep5);

			// Get the Interest Income under Overall Section
			String interestIncomeAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.interestIncomeUnderOverall);
			node.log(Status.INFO,
					"STEP4 : The Interest Income Amount under Overall Section in Step5: " + interestIncomeAmount);
			System.out.println(
					"STEP4 : The Interest Income Amount under Overall Section in Step5 : " + interestIncomeAmount);

			// Assert the Interest Income Amount
			IElementActions.assertEquals_usingString(node, driver, interestIncomeAmount, facilityLoanAmount,
					"STEP5 : BUG : The Interest Income Amount under Overall Section in Step5 is not same as Loan Amount under Facility Table in Step2",
					"STEP5 : PASS : The Interest Income Amount under Overall Section in Step5 is same as Loan Amount under Facility Table in Step2");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateInterestIncomeAtStep5", "Pass", driver);

		} catch (AssertionError validateInterestIncomeAtStep5) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInterestIncomeAtStep5 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestIncomeAtStep5_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestIncomeAtStep5.printStackTrace();
			node.fail(validateInterestIncomeAtStep5);
			Assert.fail();
			extent.flush();

		} catch (Exception validateInterestIncomeAtStep5) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInterestIncomeAtStep5 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestIncomeAtStep5_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestIncomeAtStep5.printStackTrace();
			node.fail(validateInterestIncomeAtStep5);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step5_364
	@Test(priority = 10)
	public void validateInterestExpenseAtStep5() throws IOException {

		try {
			extenttest = extent.createTest("Verify the 'Interest Expense' under Overall")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Scrolloed down to Facility Rate Max Difference Tolerance
			IElementActions.scrollbyJSExecutorUsingElementPath(driver,
					FundingInterestPaymentPO.facilityRateMaxDifferenceTolerance);
			node.log(Status.INFO, "STEP1 : Scrolloed down to Facility Rate Max Difference Tolerance");
			System.out.println("STEP1 : Scrolloed down to Facility Rate Max Difference Tolerance");

			// Check the visibility of Total Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.totalLoanAmount,
					"STEP2 : BUG: The Facility Total Amount is not coming under Facility Table in Step2",
					"STEP2 : EXPECTED: The Facility Amount is coming under Facility Table in Step2");

			// Get the Facility Total Amount under Facility Table
			String facilityTotalAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.totalLoanAmount);
			node.log(Status.INFO,
					"STEP3 : The Facility Total Amount under Facility Table in Step2 : " + facilityTotalAmount);
			System.out.println(
					"STEP3 : The Facility Total Amount under Facility Table in Step2 : " + facilityTotalAmount);

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.accountingStep5);

			// Get the Interest Expense under Overall Section
			String interestExpenseAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.interestExpenseFieldInStep5);
			node.log(Status.INFO,
					"STEP4 : The Interest Expense Amount under Overall Section in Step5 : " + interestExpenseAmount);
			System.out.println(
					"STEP4 : The Expense Income Amount under Overall Section in Step5 : " + interestExpenseAmount);

			// Assert the Interest Expense Amount
			IElementActions.assertEquals_usingString(node, driver, interestExpenseAmount, facilityTotalAmount,
					"STEP5 : BUG : The Interest Expense Amount under Overall Section in Step5 is not same as Facility Total Amount under Facility Table in Step2",
					"STEP5 : PASS : The Interest Expense Amount under Overall Section in Step5 is same as Facility Total Amount under Facility Table in Step2");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateInterestExpenseAtStep5", "Pass", driver);

		} catch (AssertionError validateInterestExpenseAtStep5) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInterestExpenseAtStep5 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestExpenseAtStep5_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestExpenseAtStep5.printStackTrace();
			node.fail(validateInterestExpenseAtStep5);
			Assert.fail();
			extent.flush();

		} catch (Exception validateInterestExpenseAtStep5) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInterestExpenseAtStep5 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestExpenseAtStep5_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestExpenseAtStep5.printStackTrace();
			node.fail(validateInterestExpenseAtStep5);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step5_365
	@Test(priority = 11)
	public void validateNetInterestMarginAtStep5() throws IOException {

		try {
			extenttest = extent.createTest("Verify the 'Net Interest Margin' under Overall")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Check the visibility of Total Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.netInterestMarginField,
					"STEP1 : BUG: The Net Interest Margin Amount is not coming on NIM Popup in Step2",
					"STEP1 : EXPECTED: The Net Interest Margin Amount is coming on NIM Popup in Step2");

			// Get the Net Interest Margin Amount
			String netInterestMarginAmountAtNIM = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.netInterestMarginField);
			node.log(Status.INFO,
					"STEP2 : The Net Interest Margin Amount On NIM Popup in Step2 : " + netInterestMarginAmountAtNIM);
			System.out.println(
					"STEP2 : The Net Interest Margin Amount On NIM Popup in Step2 : " + netInterestMarginAmountAtNIM);

			// Calling the closePopUp() function from FundingPage
			FundingPage.closePopUp();

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.accountingStep5);

			// Get the Net Interest Margin under Overall Section
			String netInterestMarginAmountInStep5 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.netInterestMarginFieldInStep5);
			node.log(Status.INFO, "STEP3 : The Net Interest Margin Amount under Overall Section in Step5 : "
					+ netInterestMarginAmountInStep5);
			System.out.println("STEP3 : The Net Interest Margin Amount under Overall Section in Step5 : "
					+ netInterestMarginAmountInStep5);

			// Assert the Net Interest Margin Amount
			IElementActions.assertEquals_usingString(node, driver, netInterestMarginAmountInStep5,
					netInterestMarginAmountAtNIM,
					"STEP4 : BUG : The Net Interest Margin Amount in Step5 is not same as Net Interest Margin Amount On NIM Popup in Step2",
					"STEP4 : PASS : The Net Interest Margin Amount in Step5 is same as Net Interest Margin Amount On NIM Popup in Step2");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateNetInterestMarginAtStep5", "Pass", driver);

		} catch (AssertionError validateNetInterestMarginAtStep5) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNetInterestMarginAtStep5 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNetInterestMarginAtStep5_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNetInterestMarginAtStep5.printStackTrace();
			node.fail(validateNetInterestMarginAtStep5);
			Assert.fail();
			extent.flush();

		} catch (Exception validateNetInterestMarginAtStep5) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNetInterestMarginAtStep5 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNetInterestMarginAtStep5_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNetInterestMarginAtStep5.printStackTrace();
			node.fail(validateNetInterestMarginAtStep5);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step5_366
	@Test(priority = 12)
	public void validateCustomerLoansSectionVisibility() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the 'Customer Loans' section is displayed to the user when they click on the next step of Step 4'")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep5 function from
			// FundingPage to access the step5 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep5(getDataFromExcel(6), getDataFromExcel(7));

			// Check the visibility of Customer Loans Section
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.customerLoansSection,
					"STEP1 : BUG: The Customer Loans Section is not coming in Step5",
					"STEP1 : EXPECTED: The Customer Loans Section is coming in Step5");

			// Check the visibility of Interest Income field
			IElementActions.assertTrue_usingXpath(node, driver,
					FundingInterestPaymentPO.interestIncomeUnderCustomerLoans,
					"STEP2 : BUG: The Interest Income field is not coming under Customer Loans Section in Step5",
					"STEP2 : EXPECTED: The Interest Income field is coming under Customer Loans Section in Step5");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCustomerLoansSectionVisibility", "Pass", driver);

		} catch (AssertionError validateCustomerLoansSectionVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCustomerLoansSectionVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCustomerLoansSectionVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCustomerLoansSectionVisibility.printStackTrace();
			node.fail(validateCustomerLoansSectionVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCustomerLoansSectionVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCustomerLoansSectionVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCustomerLoansSectionVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCustomerLoansSectionVisibility.printStackTrace();
			node.fail(validateCustomerLoansSectionVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step5_367
	@Test(priority = 13)
	public void validateInterestIncomeUnderCustomerLoansAtStep5() throws IOException {

		try {
			extenttest = extent.createTest("Verify the 'Interest Income' under Customer Loans")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Scrolloed down to Facility Rate Max Difference Tolerance
			IElementActions.scrollbyJSExecutorUsingElementPath(driver,
					FundingInterestPaymentPO.facilityRateMaxDifferenceTolerance);
			node.log(Status.INFO, "STEP1 : Scrolloed down to Facility Rate Max Difference Tolerance");
			System.out.println("STEP1 : Scrolloed down to Facility Rate Max Difference Tolerance");

			// Check the visibility of Facility Loan Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.facilityLoanAmount,
					"STEP2 : BUG: The Facility Loan Amount is not coming under Facility Table in Step2",
					"STEP2 : EXPECTED: The Facility Loan Amount is coming under Facility Table in Step2");

			// Get the Facility Loan Amount under Facility Table
			String facilityLoanAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.facilityLoanAmount);
			node.log(Status.INFO,
					"STEP3 : The Facility Loan Amount under Facility Table in Step2 : " + facilityLoanAmount);
			System.out
					.println("STEP3 : The Facility Loan Amount under Facility Table in Step2 : " + facilityLoanAmount);

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.accountingStep5);

			// Get the Interest Income under Customer Loans Section
			String interestIncomeAmount = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.interestIncomeUnderCustomerLoans);
			node.log(Status.INFO, "STEP4 : The Interest Income Amount under Customer Loans Section in Step5: "
					+ interestIncomeAmount);
			System.out.println("STEP4 : The Interest Income Amount under Customer Loans Section in Step5 : "
					+ interestIncomeAmount);

			// Assert the Interest Income Amount
			IElementActions.assertEquals_usingString(node, driver, interestIncomeAmount, facilityLoanAmount,
					"STEP5 : BUG : The Interest Income Amount under Customer Loans Section in Step5 is not same as Loan Amount under Facility Table in Step2",
					"STEP5 : PASS : The Interest Income Amount under Customer Loans Section in Step5 is same as Loan Amount under Facility Table in Step2");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateInterestIncomeUnderCustomerLoansAtStep5", "Pass", driver);

		} catch (AssertionError validateInterestIncomeUnderCustomerLoansAtStep5) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInterestIncomeUnderCustomerLoansAtStep5 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestIncomeUnderCustomerLoansAtStep5_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestIncomeUnderCustomerLoansAtStep5.printStackTrace();
			node.fail(validateInterestIncomeUnderCustomerLoansAtStep5);
			Assert.fail();
			extent.flush();

		} catch (Exception validateInterestIncomeUnderCustomerLoansAtStep5) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInterestIncomeUnderCustomerLoansAtStep5 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateInterestIncomeUnderCustomerLoansAtStep5_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInterestIncomeUnderCustomerLoansAtStep5.printStackTrace();
			node.fail(validateInterestIncomeUnderCustomerLoansAtStep5);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step5_368
	@Test(priority = 14)
	public void validateNIMAnalysisSectionVisibility() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify that the 'NIM Analysis' section is displayed to the user when they click on the next step of Step-4'")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep5 function from
			// FundingPage to access the step5 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep5(getDataFromExcel(6), getDataFromExcel(7));

			// Scrolloed down to Overall Section
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingInterestPaymentPO.overallSection);
			node.log(Status.INFO, "STEP1 : Scrolloed down to Overall Section");
			System.out.println("STEP1 : Scrolloed down to Overall Section");

			// Check the visibility of NIM Analysis Section
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.nIMAnalysisSection,
					"STEP2 : BUG: The NIM Analysis Section is not coming in Step5",
					"STEP2 : EXPECTED: The NIM Analysis Section is coming in Step5");

			// Check the visibility of Cash Interest field
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.cashInterestFieldInStep5,
					"STEP3 : BUG: The Cash Interest field is not coming under NIM Analysis Section in Step5",
					"STEP3 : EXPECTED: The Cash Interest field is coming under NIM Analysis Section in Step5");

			// Check the visibility of Loan Interest field
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.loanInterestFieldInStep5,
					"STEP4 : BUG: The Loan Interest field is not coming under NIM Analysis Section in Step5",
					"STEP4 : EXPECTED: The Loan Interest field is coming under NIM Analysis Section in Step5");

			// Check the visibility of Default Interest Field
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.defaultInterestUnderNIMSection,
					"STEP5 : BUG: The Default Interest Field is not coming under NIM Analysis Section in Step5",
					"STEP5 : EXPECTED: The Default Interest Field is coming under NIM Analysis Section in Step5");

			// Check the visibility of Net Field
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.netFieldUnderNIMSection,
					"STEP6 : BUG: The Net Field is not coming under NIM Analysis Section in Step5",
					"STEP6 : EXPECTED: The Net Field is coming under NIM Analysis Section in Step5");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateNIMAnalysisSectionVisibility", "Pass", driver);

		} catch (AssertionError validateNIMAnalysisSectionVisibility) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNIMAnalysisSectionVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNIMAnalysisSectionVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNIMAnalysisSectionVisibility.printStackTrace();
			node.fail(validateNIMAnalysisSectionVisibility);
			Assert.fail();
			extent.flush();

		} catch (Exception validateNIMAnalysisSectionVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNIMAnalysisSectionVisibility test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateNIMAnalysisSectionVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNIMAnalysisSectionVisibility.printStackTrace();
			node.fail(validateNIMAnalysisSectionVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step5_369
	@Test(priority = 15)
	public void validateCashInterestAmountAtStep5() throws IOException {

		try {
			extenttest = extent.createTest("Verify the 'Cash Interest' under NIM Analysis")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Check the visibility of Cash Interest
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.cashInterestField,
					"STEP1 : BUG: The Cash Interest Amount Field is not coming on NIM Popup in Step2",
					"STEP1 : EXPECTED: The Cash Interest Amount Field  is coming on NIM Popup in Step2");

			// Get the Cash Interest Amount
			String cashInterestAmountOnNIMPopup = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.cashInterestField);
			node.log(Status.INFO,
					"STEP2 : The Cash Interest Amount On NIM Popup in Step2 : " + cashInterestAmountOnNIMPopup);
			System.out.println(
					"STEP2 : The Cash Interest Amount On NIM Popup in Step2 : " + cashInterestAmountOnNIMPopup);

			// Calling the closePopUp function from FundingPage
			FundingPage.closePopUp();

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.accountingStep5);

			// Scrolloed down to Overall Section
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingInterestPaymentPO.overallSection);
			node.log(Status.INFO, "STEP3 : Scrolloed down to Overall Section");
			System.out.println("STEP3 : Scrolloed down to Overall Section");

			// Get the Cash Interest Amount under NIM Analysis Section
			String cashInterestAmountInStep5 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.cashInterestFieldInStep5);
			node.log(Status.INFO, "STEP4 : The Cash Interest Amount under NIM Analysis Section in Step5 : "
					+ cashInterestAmountInStep5);
			System.out.println("STEP4 : The Cash Interest Amount under NIM Analysis Section in Step5 : "
					+ cashInterestAmountInStep5);

			// Assert the Cash Interest Amount
			IElementActions.assertEquals_usingString(node, driver, cashInterestAmountInStep5,
					cashInterestAmountOnNIMPopup,
					"STEP5 : BUG : The Cash Interest Amount under NIM Section in Step5 is not same as Cash Interest Amount On NIM Popup in Step2",
					"STEP5 : PASS : The Cash Interest Amount under NIM Section in Step5 is same as Cash Interest Amount On NIM Popup in Step2");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateCashInterestAmountAtStep5", "Pass", driver);

		} catch (AssertionError validateCashInterestAmountAtStep5) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateCashInterestAmountAtStep5 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashInterestAmountAtStep5_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashInterestAmountAtStep5.printStackTrace();
			node.fail(validateCashInterestAmountAtStep5);
			Assert.fail();
			extent.flush();

		} catch (Exception validateCashInterestAmountAtStep5) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateCashInterestAmountAtStep5 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateCashInterestAmountAtStep5_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateCashInterestAmountAtStep5.printStackTrace();
			node.fail(validateCashInterestAmountAtStep5);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step5_370
	@Test(priority = 16)
	public void validateLoanInterestAmountAtStep5() throws IOException {

		try {
			extenttest = extent.createTest("Verify the 'Loan Interest' under NIM Analysis")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Check the visibility of Regular Interest
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.regularInterestField,
					"STEP1 : BUG: The Regular Interest Amount Field is not coming on NIM Popup in Step2",
					"STEP1 : EXPECTED: The Regular Interest Amount Field is coming on NIM Popup in Step2");

			// Get the Regular Interest Amount
			String regularInterestAmountOnNIMPopup = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.regularInterestField);
			node.log(Status.INFO,
					"STEP2 : The Regular Interest Amount On NIM Popup in Step2 : " + regularInterestAmountOnNIMPopup);
			System.out.println(
					"STEP2 : The Regular Interest Amount On NIM Popup in Step2 : " + regularInterestAmountOnNIMPopup);

			// Calling the closePopUp function from FundingPage
			FundingPage.closePopUp();

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.accountingStep5);

			// Scrolloed down to Overall Section
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingInterestPaymentPO.overallSection);
			node.log(Status.INFO, "STEP3 : Scrolloed down to Overall Section");
			System.out.println("STEP3 : Scrolloed down to Overall Section");

			// Get the Loan Interest Amount under NIM Analysis Section
			String loanInterestAmountInStep5 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.loanInterestFieldInStep5);
			node.log(Status.INFO, "STEP4 : The Loan Interest Amount under NIM Analysis Section in Step5 : "
					+ loanInterestAmountInStep5);
			System.out.println("STEP4 : The Loan Interest Amount under NIM Analysis Section in Step5 : "
					+ loanInterestAmountInStep5);

			// Assert the Loan Interest Amount
			IElementActions.assertEquals_usingString(node, driver, loanInterestAmountInStep5,
					regularInterestAmountOnNIMPopup,
					"STEP5 : BUG : The Loan Interest Amount under NIM Section in Step5 is not same as Regular Interest Amount On NIM Popup in Step2",
					"STEP5 : PASS : The Loan Interest Amount under NIM Section in Step5 is same as Regular Interest Amount On NIM Popup in Step2");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateLoanInterestAmountAtStep5", "Pass", driver);

		} catch (AssertionError validateLoanInterestAmountAtStep5) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateLoanInterestAmountAtStep5 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanInterestAmountAtStep5_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanInterestAmountAtStep5.printStackTrace();
			node.fail(validateLoanInterestAmountAtStep5);
			Assert.fail();
			extent.flush();

		} catch (Exception validateLoanInterestAmountAtStep5) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateLoanInterestAmountAtStep5 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateLoanInterestAmountAtStep5_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateLoanInterestAmountAtStep5.printStackTrace();
			node.fail(validateLoanInterestAmountAtStep5);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step5_371
	@Test(priority = 17)
	public void validateDefaultInterestAmountAtStep5() throws IOException {

		try {
			extenttest = extent.createTest("Verify the 'Default Interest' under NIM Analysis")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Check the visibility of Default Interest Field
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.defaultInterestField,
					"STEP1 : BUG: The Default Interest Amount Field is not coming on NIM Popup in Step2",
					"STEP1 : EXPECTED: The Default Interest Amount Field is coming on NIM Popup in Step2");

			// Get the Default Interest Amount
			String defaultInterestAmountOnNIMPopup = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.defaultInterestField);
			node.log(Status.INFO,
					"STEP2 : The Default Interest Amount On NIM Popup in Step2 : " + defaultInterestAmountOnNIMPopup);
			System.out.println(
					"STEP2 : The Default Interest Amount On NIM Popup in Step2 : " + defaultInterestAmountOnNIMPopup);

			// Calling the closePopUp function from FundingPage
			FundingPage.closePopUp();

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.accountingStep5);

			// Scrolloed down to Overall Section
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingInterestPaymentPO.overallSection);
			node.log(Status.INFO, "STEP3 : Scrolloed down to Overall Section");
			System.out.println("STEP3 : Scrolloed down to Overall Section");

			// Get the Default Interest Amount under NIM Analysis Section
			String defaultInterestAmountInStep5 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.defaultInterestUnderNIMSection);
			node.log(Status.INFO, "STEP4 : The Default Interest Amount under NIM Analysis Section in Step5 : "
					+ defaultInterestAmountInStep5);
			System.out.println("STEP4 : The Default Interest Amount under NIM Analysis Section in Step5 : "
					+ defaultInterestAmountInStep5);

			// Assert the Default Interest Amount
			IElementActions.assertEquals_usingString(node, driver, defaultInterestAmountInStep5,
					defaultInterestAmountOnNIMPopup,
					"STEP5 : BUG : The Default Interest Amount under NIM Section in Step5 is not same as Default Interest Amount On NIM Popup in Step2",
					"STEP5 : PASS : The Default Interest Amount under NIM Section in Step5 is same as Default Interest Amount On NIM Popup in Step2");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDefaultInterestAmountAtStep5", "Pass", driver);

		} catch (AssertionError validateDefaultInterestAmountAtStep5) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDefaultInterestAmountAtStep5 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDefaultInterestAmountAtStep5_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDefaultInterestAmountAtStep5.printStackTrace();
			node.fail(validateDefaultInterestAmountAtStep5);
			Assert.fail();
			extent.flush();

		} catch (Exception validateDefaultInterestAmountAtStep5) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDefaultInterestAmountAtStep5 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateDefaultInterestAmountAtStep5_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDefaultInterestAmountAtStep5.printStackTrace();
			node.fail(validateDefaultInterestAmountAtStep5);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_InterestPayment_Step5_372
	@Test(priority = 18)
	public void validateNetAmountAtStep5() throws IOException {

		try {
			extenttest = extent.createTest("Verify the 'Net' under NIM Analysis")
					.assignCategory(fundingInterestPayement_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadInterestPaymentPageAndNavigateToStep2 function from
			// FundingPage to access the step2 of interest payment page
			FundingPage.loadInterestPaymentPageAndNavigateToStep2(getDataFromExcel(6), getDataFromExcel(7));

			// Calling the validateFourSideArrowIcon function from FundingPage
			FundingPage.validateFourSideArrowIcon(FundingInterestPaymentPO.nimAnalysisFourSideArrowIcon,
					FundingInterestPaymentPO.nimAnalysisPopup, FundingInterestPaymentPO.nimAnalysisPopupHeader,
					"NIM Analysis");

			// Check the visibility of Net Interest Margin Field
			IElementActions.assertTrue_usingXpath(node, driver, FundingInterestPaymentPO.netInterestMarginsField,
					"STEP1 : BUG: The Net Interest Margin Amount Field is not coming on NIM Popup in Step2",
					"STEP1 : EXPECTED: The Net Interest Margin Amount Field is coming on NIM Popup in Step2");

			// Get the Net Interest Margin Amount
			String netInterestMarginAmountOnNIMPopup = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.netInterestMarginsField);
			node.log(Status.INFO, "STEP2 : The Net Interest Margin Amount On NIM Popup in Step2 : "
					+ netInterestMarginAmountOnNIMPopup);
			System.out.println("STEP2 : The Net Interest Margin Amount On NIM Popup in Step2 : "
					+ netInterestMarginAmountOnNIMPopup);

			// Calling the closePopUp function from FundingPage
			FundingPage.closePopUp();

			// Calling the navigateToStep function from Funding Page
			FundingPage.navigateToStep(FundingInterestPaymentPO.accountingStep5);

			// Scrolloed down to Overall Section
			IElementActions.scrollbyJSExecutorUsingElementPath(driver, FundingInterestPaymentPO.overallSection);
			node.log(Status.INFO, "STEP3 : Scrolloed down to Overall Section");
			System.out.println("STEP3 : Scrolloed down to Overall Section");

			// Get the Net Amount under NIM Analysis Section
			String netAmountInStep5 = IElementActions.getElementText_usingXpath(node, driver,
					FundingInterestPaymentPO.netFieldUnderNIMSection);
			node.log(Status.INFO, "STEP4 : The Net Amount under NIM Analysis Section in Step5 : " + netAmountInStep5);
			System.out.println("STEP4 : The Net Amount under NIM Analysis Section in Step5 : " + netAmountInStep5);

			// Assert the Net Amount
			IElementActions.assertEquals_usingString(node, driver, netAmountInStep5, netInterestMarginAmountOnNIMPopup,
					"STEP5 : BUG : The Net Amount under NIM Section in Step5 is not same as Net Interest Margin Amount On NIM Popup in Step2",
					"STEP5 : PASS : The Net Amount under NIM Section in Step5 is same as Net Interest Margin Amount On NIM Popup in Step2");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateNetAmountAtStep5", "Pass", driver);

		} catch (AssertionError validateNetAmountAtStep5) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateNetAmountAtStep5 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateNetAmountAtStep5_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNetAmountAtStep5.printStackTrace();
			node.fail(validateNetAmountAtStep5);
			Assert.fail();
			extent.flush();

		} catch (Exception validateNetAmountAtStep5) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateNetAmountAtStep5 test in InterestPaymentTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateNetAmountAtStep5_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateNetAmountAtStep5.printStackTrace();
			node.fail(validateNetAmountAtStep5);
			Assert.fail();
			extent.flush();

			// TODO: handle exception
		}

	}

}
