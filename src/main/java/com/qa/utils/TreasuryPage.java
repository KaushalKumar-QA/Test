package com.qa.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.locators.allPages.PipelinePO;
import com.locators.allPages.TreasuryDatabasePO;
import com.locators.allPages.TreasuryPortfolioPO;
import com.locators.allPages.TreasurySinglePO;
import com.locators.allPages.UtilsPO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.url.AllPagesUrl;

public class TreasuryPage extends Baseclass {

	public static void loadSinglePage() {
		// Open the Treasury Single
		node.log(Status.INFO, "SUB-STEP_0.001 : Opening the Treasury Single page under Treasury");
		System.out.println("SUB-STEP_0.001 :  Opening the Treasury Single page under Treasury");
		driver.get(AllPagesUrl.TreasurySinglePage);
		// Wait for the visibility of Treasury Single page
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of Treasury Single page");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of Treasury Single page");
		IWaitStrategy.waitForVisiblity(node, driver, TreasurySinglePO.allocationDate);
		IWaitStrategy.WaitUntilElementClickable(node, driver, TreasurySinglePO.allocationDate);
		node.log(Status.INFO, "SUB-STEP_0.003 : Treasury Single page is visible");
		System.out.println("SUB-STEP_0.003 : Treasury Single page is visible");
	}

	public static void loadTreasuryDatabasePage() throws InterruptedException {
		// Open the Treasury Database
		node.log(Status.INFO, "SUB-STEP_0.001 : Opening the Treasury Database page under Treasury");
		System.out.println("SUB-STEP_0.001 :  Opening the Treasury Database page under Treasury");
		driver.get(AllPagesUrl.TreasuryDatabasePage);
		Thread.sleep(50000);
		// Wait for the visibility of Treasury Database page
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of Treasury Database page");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of Treasury Database page");
		IWaitStrategy.waitForVisiblity(node, driver, TreasuryDatabasePO.loanRows);
		IWaitStrategy.WaitUntilElementClickable(node, driver, TreasuryDatabasePO.loanRows);
		node.log(Status.INFO, "SUB-STEP_0.003 : Treasury Database page is visible");
		System.out.println("SUB-STEP_0.003 : Treasury Database page is visible");
	}

	public static void getTextAndValidateIfTextHavingBlank(String element, String fieldName) {
		// Get element text
		String fieldText = IElementActions.getElementText_usingXpath(node, driver, element).trim();
		// Assert if the text is not blank
		if (!fieldText.isEmpty()) {
			Assert.assertTrue(true, fieldText + " is displayed in the field " + fieldName);
			System.out.println(fieldText + " is displayed in the field " + fieldName);
			node.log(Status.PASS, fieldText + " is displayed in the field " + fieldName);
		} else {
			Assert.assertTrue(false, fieldText + " is displayed in the field " + fieldName);
			System.out.println(fieldText + " is displayed in the field " + fieldName);
			node.log(Status.FAIL, fieldText + " is displayed in the field " + fieldName);
		}
	}

	public static void openTreasuryAndEnterDetails(String loanReferenceNumber)
			throws FileNotFoundException, IOException, InterruptedException {
		// Calling the loadSinglePage
		loadSinglePage();

		// Enter allocation details
		enterAllocationDateAndLoanReference(loanReferenceNumber);

		IWaitStrategy.WaitForPageLoadingToComplete(node, driver);
		// Wait for the visibility of data population
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the treasury single table");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the treasury single table");
		IWaitStrategy.waitForVisiblity(node, driver, TreasurySinglePO.table);
		IWaitStrategy.waitForVisiblity(node, driver, TreasurySinglePO.includePreviewValue);
		node.log(Status.INFO, "SUB-STEP_0.002 : Treasury single table is visible");
		System.out.println("SUB-STEP_0.002 : Treasury single table is visible");
	}

	public static void openPortfolioEnterDetailsAndGoToStep2(String loanReferenceNumber)
			throws FileNotFoundException, IOException, InterruptedException {
		// Calling the loadPortfolioPage
		loadPortfolioPage();

		Thread.sleep(1000);
		// Enter allocation details
		enterAllocationDateAndLoanReference(loanReferenceNumber);

		Thread.sleep(5000);
		// Scroll to top
		IElementActions.scrollToTop(driver);
		IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

		// Wait for the visibility of the allocation date
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the steps");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the steps");
		IWaitStrategy.waitForVisiblity(node, driver, TreasuryPortfolioPO.step2);
		node.log(Status.INFO, "SUB-STEP_0.002 : Steps is visible");
		System.out.println("SUB-STEP_0.002 : Steps is visible");

		// Click on step2
		IElementActions.clickelement_usingXpath(node, driver, TreasuryPortfolioPO.step2);
		node.log(Status.INFO, "SUB-STEP_0.003 : Clicked on the step2");
		System.out.println("SUB-STEP_0.003 : Clicked on the step2");

		// Wait for page loading
		IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

		// Wait for the visibility of the step2
		node.log(Status.INFO, "SUB-STEP_0.004 : Waiting for the visibility of the step2");
		System.out.println("SUB-STEP_0.004 : Waiting for the visibility of the step2");
		IWaitStrategy.waitForVisiblity(node, driver, TreasuryPortfolioPO.loanReferences);
		node.log(Status.INFO, "SUB-STEP_0.005 : Step2 is visible");
		System.out.println("SUB-STEP_0.005 : Step2 is visible");
		Thread.sleep(2000);
	}

	public static void openPortfolioStep2() throws FileNotFoundException, IOException, InterruptedException {

		IElementActions.pageRefresh();

		// Calling the loadPortfolioPage
		loadPortfolioPage();

		Thread.sleep(2000);
		IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

		// Wait for the visibility of the allocation date
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the steps");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the steps");
		IWaitStrategy.waitForVisiblity(node, driver, TreasuryPortfolioPO.step2);
		node.log(Status.INFO, "SUB-STEP_0.002 : Steps is visible");
		System.out.println("SUB-STEP_0.002 : Steps is visible");

		// Click on step2
		IElementActions.clickelement_usingXpath(node, driver, TreasuryPortfolioPO.step2);
		node.log(Status.INFO, "SUB-STEP_0.003 : Clicked on the step2");
		System.out.println("SUB-STEP_0.003 : Clicked on the step2");

		// Wait for page loading
		IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

		// Wait for the visibility of the step2
		node.log(Status.INFO, "SUB-STEP_0.004 : Waiting for the visibility of the step2");
		System.out.println("SUB-STEP_0.004 : Waiting for the visibility of the step2");
		IWaitStrategy.waitForVisiblity(node, driver, TreasuryPortfolioPO.loanReferences);
		node.log(Status.INFO, "SUB-STEP_0.005 : Step2 is visible");
		System.out.println("SUB-STEP_0.005 : Step2 is visible");
		Thread.sleep(2000);
	}

	public static void enterAllocationDateAndLoanReference(String loanReferenceNumber)
			throws FileNotFoundException, IOException, InterruptedException {
		// Enter allocation date
		enterAllocationDate();

		// Select loan reference
		selectLoanReference(loanReferenceNumber);
	}

	public static void enterAllocationDate() throws FileNotFoundException, IOException, InterruptedException {
		IElementActions.scrollToTop(driver);

		// Wait for the visibility of the allocation date
		node.log(Status.INFO, "STEP1 : Waiting for the visibility of the allocation date");
		System.out.println("STEP1 : Waiting for the visibility of the allocation date");
		IWaitStrategy.waitForVisiblity(node, driver, TreasurySinglePO.allocationDate);
		node.log(Status.INFO, "STEP2 : Allocation date is visible");
		System.out.println("STEP2 : Allocation date is visible");

		// Click on allocation date
		IElementActions.clickelement_usingXpath(node, driver, TreasurySinglePO.allocationDate);
		node.log(Status.INFO, "STEP3 : Clicked on the date");
		System.out.println("STEP3 : Clicked on the date");

		// Get today day
		String today = Utils.getTodayDayFormatted();

		// Select day in allocation date calender
		Utils.enterDay(UtilsPO.calenderDay, today);
	}

	public static void clickOnStepper(String step, String stepElementVisibility)
			throws FileNotFoundException, IOException, InterruptedException {
		IElementActions.scrollToTop(driver);

		// Wait for the visibility of the allocation date
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the step");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the step");
		IWaitStrategy.waitForVisiblity(node, driver, step);
		node.log(Status.INFO, "SUB-STEP_0.002 : Step is visible");
		System.out.println("SUB-STEP_0.002 : Step is visible");

		// Click on allocation date
		IElementActions.clickelement_usingXpath(node, driver, step);
		node.log(Status.INFO, "SUB-STEP_0.003 : Clicked on the step");
		System.out.println("SUB-STEP_0.003 : Clicked on the step");

		// Wait for page loading
		IWaitStrategy.WaitForPageLoadingToComplete(node, driver);

		// Wait for the visibility of the step2
		node.log(Status.INFO, "SUB-STEP_0.004 : Waiting for the visibility of the step element");
		System.out.println("SUB-STEP_0.004 : Waiting for the visibility of the step element");
		IWaitStrategy.waitForVisiblity(node, driver, stepElementVisibility);
		node.log(Status.INFO, "SUB-STEP_0.005 : Step element is visible");
		System.out.println("SUB-STEP_0.005 : Step element is visible");
		Thread.sleep(2000);
	}

	public static void selectLoanReference(String loanReferenceNumber)
			throws FileNotFoundException, IOException, InterruptedException {
		Thread.sleep(5000);
		// Wait for the visibility of the loan reference
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the loan reference");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the loan reference");
		IWaitStrategy.waitForVisiblity(node, driver, TreasurySinglePO.loanReference);
		node.log(Status.INFO, "SUB-STEP_0.002 : Loan reference is visible");
		System.out.println("SUB-STEP_0.002 : Loan reference is visible");

		// Select loan from loan reference dropdown
		IElementActions.selectValueFromDropdown(node, driver, TreasurySinglePO.loanReference, loanReferenceNumber);
	}

	public static void loadPortfolioPage() {
		// Open the Treasury Portfolio
		node.log(Status.INFO, "SUB-STEP_0.001 : Opening the Portfolio page under Treasury");
		System.out.println("SUB-STEP_0.001 :  Opening the Portfolio page under Treasury");
		driver.get(AllPagesUrl.TreasuryPortfolioPage);
		// Wait for the visibility of Treasury Portfolio page
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of Treasury Portfolio page");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of Treasury Portfolio page");
		IWaitStrategy.waitForVisiblity(node, driver, TreasuryPortfolioPO.step1Text);
		IWaitStrategy.WaitUntilElementClickable(node, driver, TreasuryPortfolioPO.step2);
		node.log(Status.INFO, "SUB-STEP_0.003 : Treasury Portfolio page is visible");
		System.out.println("SUB-STEP_0.003 : Treasury Portfolio page is visible");
	}

	public static int sumOfExcludedElements(String column, String verticalScroll, String horizontalScroll,
			String excludedElement) throws InterruptedException {
		// Find all elements of the column
		List<WebElement> columnElements = IElementActions.returnElements(node, driver, column);

		// Scroll to the element vertically
		IElementActions.scrollbyJSExecutorUsingElementPath(driver, verticalScroll);
		node.log(Status.INFO, "SUB-STEP_0.001 : Scrolled to the element vertically");
		System.out.println("SUB-STEP_0.001 : Scrolled to the element vertically");

		// Scroll horizontally in Table
		Thread.sleep(1000);
		IElementActions.scrollHorizontally(driver, horizontalScroll, 1000);
		node.log(Status.INFO, "SUB-STEP_0.002 : Scrolled to the element horizontally");
		System.out.println("SUB-STEP_0.002 : Scrolled to the element horizontally");

		// Wait for the visibility of the excluded elements
		node.log(Status.INFO, "SUB-STEP_0.003 : Waiting for the visibility of the  excluded elements");
		System.out.println("SUB-STEP_0.003 : Waiting for the visibility of the  excluded elements");
		IWaitStrategy.waitForVisiblity(node, driver, excludedElement);
		node.log(Status.INFO, "SUB-STEP_0.004 :  Excluded elements is visible");
		System.out.println("SUB-STEP_0.004 : Excluded elements is visible");

		// Find all elements of excluded elements
		List<WebElement> excludedElements = IElementActions.returnElements(node, driver, excludedElement);

		// Store the positions of checked checkboxes in excludedFacilities
		List<Integer> checkedPositions = new ArrayList<>();
		for (int i = 0; i < excludedElements.size(); i++) {
			WebElement checkbox = excludedElements.get(i).findElement(By.tagName("span"));
			if (checkbox.getAttribute("class").contains("pi-check")) {
				checkedPositions.add(i);
			}
		}

		// Store the values of elements checked corresponding to excluded checkbox
		List<Integer> valuesOfElementExcluded = new ArrayList<>();
		for (int position : checkedPositions) {
			WebElement correspondingElement = columnElements.get(position);
			String valueStr = correspondingElement.getText();
			int value = Utils.removeCurrencyAndParseToInt(valueStr);
			valuesOfElementExcluded.add(value);
		}

		// Sum up all the values of currentDeploymentInFacilities corresponding to
		// checked excludedFacilities
		int sum = 0;
		for (int value : valuesOfElementExcluded) {
			sum += value;
		}

		// Print the sum
		System.out.println("Sum of values: " + sum);
		node.log(Status.INFO, "Sum of values: " + sum);
		return sum;
	}

	public static void scrollVerticalAndHorizontalToAccessTable(String verticalScroll, String table,
			String elementVisibility) throws InterruptedException {
		// Scroll to the element vertically
		IElementActions.scrollbyJSExecutorUsingElementPath(driver, verticalScroll);
		node.log(Status.INFO, "SUB-STEP_0.001 : Scrolled to the element vertically");
		System.out.println("SUB-STEP_0.001 : Scrolled to the element vertically");

		// Scroll horizontally in Table
		Thread.sleep(1000);
		IElementActions.scrollHorizontally(driver, table, 1000);
		node.log(Status.INFO, "SUB-STEP_0.002 : Scrolled to the element horizontally");
		System.out.println("SUB-STEP_0.002 : Scrolled to the element horizontally");

		// Wait for the visibility of the excluded elements
		node.log(Status.INFO, "SUB-STEP_0.003 : Waiting for the visibility of the excluded elements");
		System.out.println("SUB-STEP_0.003 : Waiting for the visibility of the excluded elements");
		IWaitStrategy.waitForVisiblity(node, driver, elementVisibility);
		node.log(Status.INFO, "SUB-STEP_0.004 :  Excluded elements is visible");
		System.out.println("SUB-STEP_0.004 : Excluded elements is visible");
	}

	public static void openDatabaseLastStep() throws InterruptedException, FileNotFoundException, IOException {
		IElementActions.pageRefresh();

		// Calling the loadTreasuryDatabasePage from treasury
		TreasuryPage.loadTreasuryDatabasePage();

		// Calling the bottomNextStepButton function from Funding Page
		FundingPage.bottomNextStepButton(TreasuryDatabasePO.nextStepButton, 2, "Database");

		// Wait for the visibility of the amend facility allocations
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the amend facility allocations");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the amend facility allocations");
		IWaitStrategy.waitForVisiblity(node, driver, TreasuryDatabasePO.amendFacilityAllocations);
		node.log(Status.INFO, "SUB-STEP_0.002 : Amend facility allocations is visible");
		System.out.println("SUB-STEP_0.002 : Amend facility allocations is visible");
	}

	public static int getFacilityPosition(String facilityReferenceNumber)
			throws InterruptedException, FileNotFoundException, IOException {
		// Find all elements of the facilities in database
		List<String> facilitiesReferenceInDatabase = Utils
				.extractTextFromElements(TreasuryDatabasePO.facilitiesInStep2);
		int facilityPosition = 1;
		for (int i = 0; i < facilitiesReferenceInDatabase.size(); i++) {
			String facilitiesReferenceValue = facilitiesReferenceInDatabase.get(i);
			if (facilitiesReferenceValue.equals(facilityReferenceNumber)) {
				facilityPosition = facilityPosition + i;
				break;
			}
		}
		return facilityPosition;
	}

	public static String addNewAllocationAndSave(String facilityReferenceNumber, String loanReferenceNumber,
			String allocationAmount) throws FileNotFoundException, InterruptedException, IOException {

		// Get the facility position
		int facilityPosition = TreasuryPage.getFacilityPosition(facilityReferenceNumber);

		// Create the dynamic locator for loan reference
		String loanReference = IElementActions.createDynamicLocatorString(
				TreasuryDatabasePO.revisedAmountCorrespondingToLoan, "locatorValue", loanReferenceNumber);

		facilityPosition = (facilityPosition * 2) + 3;

		Thread.sleep(1000);
		// Create the dynamic locator for facility loan amount
		String facilityLoanAmountLocator = IElementActions.createDynamicLocatorString(loanReference, "facilityPosition",
				Integer.toString(facilityPosition));

		// Wait for the visibility of the revised field
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the revised field");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the revised field");
		IWaitStrategy.waitForVisiblity(node, driver, facilityLoanAmountLocator);
		IWaitStrategy.WaitUntilElementClickable(node, driver, facilityLoanAmountLocator);
		node.log(Status.INFO, "SUB-STEP_0.002 : Revised field is visible");
		System.out.println("SUB-STEP_0.002 : Revised field is visible");

		// Enter the amount in allocation box/Revised
		IElementActions.clearAndInputElementUsingAction_Xpath(node, driver, facilityLoanAmountLocator,
				allocationAmount);
		node.log(Status.INFO,
				"SUB-STEP_0.003 : Enter amount " + allocationAmount + " in the allocation box/Revised of loan "
						+ loanReferenceNumber + " for facility " + facilityReferenceNumber);
		System.out
				.println("SUB-STEP_0.003 : Enter amount " + allocationAmount + " in the allocation box/Revised of loan "
						+ loanReferenceNumber + " for facility " + facilityReferenceNumber);

		scrollAndClickOnSave();
		if (IElementActions.isElementAvailable(node, driver, UtilsPO.error)) {
			// Get the error message
			String errorMessage = IElementActions.getElementText_usingXpath(node, driver, UtilsPO.errorMessage);
			node.log(Status.FAIL, "SUB-STEP_0.0001 : Error appears " + errorMessage);
			System.out.println("SUB-STEP_0.0001 : Error appears " + errorMessage);

			// Click on popup close button
			IElementActions.clickelement_usingXpath(node, driver, PipelinePO.closeButtonInPopup);
			node.log(Status.INFO, "SUB-STEP_0.0002 : Clicked on the close icon of error popup");
			System.out.println("SUB-STEP_0.0002 : Clicked on the close icon of error popup");

			// Wait for the invisibility of the PopUp
			node.log(Status.INFO, "SUB-STEP_0.0003 : Waiting for the invisibility of the error popup");
			System.out.println("SUB-STEP_0.0003 : Waiting for the invisibility of the error popup");
			IWaitStrategy.waitForInVisiblity(node, driver, UtilsPO.popUp);
			node.log(Status.INFO, "SUB-STEP_0.0004 : Error popup is not visible");
			System.out.println("SUB-STEP_0.0004 : Error popup is not visible");

			// Scroll down and click on the save button
			scrollAndClickOnSave();
		}

		// Click on popup close button
		IElementActions.clickelement_usingXpath(node, driver, PipelinePO.closeButtonInPopup);
		node.log(Status.INFO, "SUB-STEP_0.004 : Clicked on the close icon");
		System.out.println("SUB-STEP_0.004 : Clicked on the close icon");

		// Wait for the invisibility of the PopUp
		node.log(Status.INFO, "SUB-STEP_0.005 : Waiting for the invisibility of the popup");
		System.out.println("SUB-STEP_0.005 : Waiting for the invisibility of the popup");
		IWaitStrategy.waitForInVisiblity(node, driver, UtilsPO.popUp);
		node.log(Status.INFO, "SUB-STEP_0.006 : Popup is not visible");
		System.out.println("SUB-STEP_0.006 : Popup is not visible");

		// Scroll to top
		IElementActions.scrollToTop(driver);

		// Wait for the visibility of the amend facility allocations
		node.log(Status.INFO, "SUB-STEP_0.007 : Waiting for the visibility of the amend facility allocations");
		System.out.println("SUB-STEP_0.007 : Waiting for the visibility of the amend facility allocations");
		IWaitStrategy.waitForVisiblity(node, driver, TreasuryDatabasePO.amendFacilityAllocations);
		node.log(Status.INFO, "SUB-STEP_0.008 : Amend facility allocations is visible");
		System.out.println("SUB-STEP_0.008 : Amend facility allocations is visible");

		return facilityLoanAmountLocator;
	}

	public static void scrollAndClickOnSave() throws InterruptedException {
		IElementActions.scrollToBottom(driver);
		node.log(Status.INFO, "SUB-STEP_0.001 : Scrolled down to the bottom of page");
		System.out.println("SUB-STEP_0.001 : Scrolled down to the bottom of page");

		// Wait for the visibility of the save button
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of the save button");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of the save button");
		IWaitStrategy.waitForVisiblity(node, driver, UtilsPO.saveButton);
		node.log(Status.INFO, "SUB-STEP_0.003 : Save button is visible");
		System.out.println("SUB-STEP_0.003 : Save button is visible");

		// Click on the save button
		IElementActions.clickelement_usingXpath(node, driver, UtilsPO.saveButton);
		node.log(Status.INFO, "SUB-STEP_0.004 : Clicked on the save button");
		System.out.println("SUB-STEP_0.004 : Clicked on the save button");

		Thread.sleep(2000);
		// Wait for the visibility of element
		node.log(Status.INFO, "SUB-STEP_0.005 : Waiting for the visibility of the popup");
		System.out.println("SUB-STEP_0.005 : Waiting for the visibility of the popup");
		IWaitStrategy.waitForVisiblity(node, driver, UtilsPO.popUp);
		node.log(Status.INFO, "SUB-STEP_0.006 : The popup is visible");
		System.out.println("SUB-STEP_0.006 : The popup is visible");
	}

	public static String getCurrentAmountLocatorInDatabase()
			throws FileNotFoundException, IOException, InterruptedException {

		// Get facility reference number
		String facilityReferenceNumber = getDataFromExcel(65);

		// Get loan reference number
		String loanReferenceNumber = getDataFromExcel(66);

		// Get the facility position
		int facilityPosition = TreasuryPage.getFacilityPosition(facilityReferenceNumber);

		// Create the dynamic locator for current loan reference
		String loanReferenceForCurrent = IElementActions.createDynamicLocatorString(
				TreasuryDatabasePO.amountCorrespondingToLoan, "locatorValue", loanReferenceNumber);

		int facilityCurrentPosition = (facilityPosition * 2) + 2;

		Thread.sleep(1000);
		// Create the dynamic locator for facility current amount
		String currentLocator = IElementActions.createDynamicLocatorString(loanReferenceForCurrent, "facilityPosition",
				Integer.toString(facilityCurrentPosition));

		return currentLocator;
	}

	public static String getRevisedAmountLocatorInDatabase()
			throws FileNotFoundException, IOException, InterruptedException {

		// Get facility reference number
		String facilityReferenceNumber = getDataFromExcel(65);

		// Get loan reference number
		String loanReferenceNumber = getDataFromExcel(66);

		// Get the facility position
		int facilityPosition = TreasuryPage.getFacilityPosition(facilityReferenceNumber);

		// Create the dynamic locator for revised loan reference
		String loanReferenceForRevised = IElementActions.createDynamicLocatorString(
				TreasuryDatabasePO.revisedAmountCorrespondingToLoan, "locatorValue", loanReferenceNumber);

		int facilityRevisedPosition = (facilityPosition * 2) + 3;

		Thread.sleep(1000);
		// Create the dynamic locator for facility revised amount
		String revisedLocator = IElementActions.createDynamicLocatorString(loanReferenceForRevised, "facilityPosition",
				Integer.toString(facilityRevisedPosition));
		return revisedLocator;
	}

}