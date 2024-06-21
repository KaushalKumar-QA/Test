package com.qa.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.locators.allPages.LoansDatabasePO;
import com.locators.allPages.LoansNewLoanPO;
import com.locators.allPages.UtilsPO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.url.AllPagesUrl;

public class LoansPage extends Baseclass {

	public static void loadNewLoanPage() {
		// Open the Loans New Loan
		node.log(Status.INFO, "SUB-STEP_0.001 : Opening the New Loan page under Loans");
		System.out.println("SUB-STEP_0.001 :  Opening the New Loan page under Loans");
		driver.get(AllPagesUrl.newLoanPage);
		// Wait for the visibility of Loans New Loan page
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of Loans New Loan page");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of Loans New Loan page");
		IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.newBridgeLoanHeaderText);
		node.log(Status.INFO, "SUB-STEP_0.003 : Loans New Loan page is visible");
		System.out.println("SUB-STEP_0.003 : Loans New Loan page is visible");
	}

	public static void loadDatabasePage() {

		IElementActions.pageRefresh();
		// Open the Loans Database
		node.log(Status.INFO, "SUB-STEP_0.001 : Opening the Database page under Loans");
		System.out.println("SUB-STEP_0.001 :  Opening the Database page under Loans");
		driver.get(AllPagesUrl.databasePage);
		// Wait for the visibility of Loans Database page
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of Loans Database page");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of Loans Database page");
		IWaitStrategy.waitForVisiblity(node, driver, LoansDatabasePO.bridgeLoanDatabseText);
		node.log(Status.INFO, "SUB-STEP_0.003 : Loans Database page is visible");
		System.out.println("SUB-STEP_0.003 : Loans Database page is visible");
	}

	public static void loadDatabasePageAndClearSearchResult() {
		loadDatabasePage();
		// Check cross icon is available or not
		boolean checkCrossIcon = IElementActions.isElementAvailable(node, driver, UtilsPO.headerSearchCrossIcon);

		// If cross icon is present, click on it to clear the search
		if (checkCrossIcon) {
			// Click on the cross icon to clear the search
			IElementActions.clickelement_usingXpath(node, driver, UtilsPO.headerSearchCrossIcon);
			node.log(Status.INFO, "STEP_0.001 : clicked on the cross icon");
			System.out.println("STEP_0.001 : clicked on the cross icon");
		}

		// Wait for the sort icon to be visible and clickable
		node.log(Status.INFO, "STEP2 : Waiting for the sort icon to be visible and clickable");
		System.out.println("STEP2 : Waiting for the sort icon to be visible and clickable");
		IWaitStrategy.waitForVisiblityDynamic(node, driver, LoansDatabasePO.amountSortIcon, 150);
		node.log(Status.INFO, "STEP3 : Sort icon is visible and clickable");
		System.out.println("STEP3 : Sort icon is visible and clickable");
	}

	// Method to extract loan number using regular expressions
	public static String extractLoanNumber(String url) {
		Pattern pattern = Pattern.compile("/bl/(\\w+)/");
		Matcher matcher = pattern.matcher(url);
		if (matcher.find()) {
			return matcher.group(1);
		} else {
			return null; // Return null if no match is found
		}
	}

	public static void enterBorrowerDetails(String borrowerTypeValue, String actionTypeValue,
			String internalReferenceValue, String companyOrNameValue) {

		// Create a dynamic selector based on the provided borrower type value
		String borrowerTypeLocator = IElementActions.createDynamicLocatorString(LoansNewLoanPO.borrowerTypeValue,
				"locator", borrowerTypeValue);

		// Create a dynamic selector based on the provided action type value
		String actionTypeLocator = IElementActions.createDynamicLocatorString(LoansNewLoanPO.actionTypeValue, "locator",
				actionTypeValue);

		// Click on the borrower type based on the provided value
		IElementActions.clickelement_usingXpath(node, driver, borrowerTypeLocator);
		node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on the borrower type");
		System.out.println("SUB-STEP_0.001 : Clicked on the borrower type");

		// Click on the action type based on the provided value
		IElementActions.clickelement_usingXpath(node, driver, actionTypeLocator);
		node.log(Status.INFO, "SUB-STEP_0.002 : Clicked on the action type");
		System.out.println("SUB-STEP_0.002 : Clicked on the action type");

		if (borrowerTypeValue.equals("Individual") && actionTypeValue.equals("Existing")) {

			// Create a dynamic selector based on the provided name value
			String nameValueLocator = IElementActions.createDynamicLocatorString(LoansNewLoanPO.dropdownOption,
					"locator", companyOrNameValue);

			// Wait for the visibility of the name dropdown
			node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the name dropdown");
			System.out.println("STEP1 : Waiting for the visibility of the name dropdown");
			IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.nameDropdown);
			node.log(Status.INFO, "SUB-STEP_0.002 : Name dropdown is visible");
			System.out.println("SUB-STEP_0.002 : Name dropdown is visible");

			// Click on the name dropdown
			IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.nameDropdown);
			node.log(Status.INFO, "SUB-STEP_0.003 : Clicked on the name dropdown");
			System.out.println("SUB-STEP_0.003 : Clicked on the name dropdown");

			// Enter the value in dropdown search bar
			IElementActions.sendKeys_usingXpath(node, driver, LoansNewLoanPO.dropdownSearchBar, companyOrNameValue);
			node.log(Status.INFO, "SUB-STEP_0.004 : Entered the value in dropdown search bar");
			System.out.println("SUB-STEP_0.004 : Entered the value in dropdown search bar");

			// Wait for the visibility of the name dropdown
			node.log(Status.INFO, "SUB-STEP_0.005 : Waiting for the presence of the dropdown option");
			System.out.println("SUB-STEP_0.005 : Waiting for the presence of the dropdown option");
			IWaitStrategy.waitForPresence(node, driver, nameValueLocator);
			node.log(Status.INFO, "SUB-STEP_0.006 : Dropdown option is present");
			System.out.println("SUB-STEP_0.006 : Dropdown option is present");

			// Click on the name option
			IElementActions.clickelement_usingXpath(node, driver, nameValueLocator);
			node.log(Status.INFO, "SUB-STEP_0.007 : Clicked on the name option");
			System.out.println("SUB-STEP_0.007 : Clicked on the name option");

		} else if (borrowerTypeValue.equals("Individual") && actionTypeValue.equals("New")) {

			// Wait for the visibility of the success popup
			node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the internal reference");
			System.out.println("SUB-STEP_0.002 : Waiting for the visibility of the internal reference");
			IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.borrowerInternalReference);
			node.log(Status.INFO, "SUB-STEP_0.002 : Internal reference field is visible");
			System.out.println("SUB-STEP_0.002 : Internal reference field is visible");

			// Enter the value in bridge loan internal reference field
			IElementActions.sendKeys_usingXpath(node, driver, LoansNewLoanPO.borrowerInternalReference,
					internalReferenceValue);
			node.log(Status.INFO, "SUB-STEP_0.003 : Entered the value in bridge loan internal reference field");
			System.out.println("SUB-STEP_0.003 : Entered the value in bridge loan internal reference field");

			// Wait for the visibility of the success popup
			node.log(Status.INFO, "SUB-STEP_0.004 : Waiting for the visibility of the name");
			System.out.println("SUB-STEP_0.004 : Waiting for the visibility of the name");
			IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.name);
			node.log(Status.INFO, "SUB-STEP_0.005 : Name field is visible");
			System.out.println("SUB-STEP_0.005 : Name field is visible");

			// Enter the value in company field
			IElementActions.sendKeys_usingXpath(node, driver, LoansNewLoanPO.name, companyOrNameValue);
			node.log(Status.INFO, "SUB-STEP_0.006 : Entered the value in the company field");
			System.out.println("SUB-STEP_0.006 : Entered the value in the company field");

		} else if (borrowerTypeValue.equals("Corporate") && actionTypeValue.equals("Existing")) {

			// Create a dynamic selector based on the provided company value
			String companyValueLocator = IElementActions.createDynamicLocatorString(LoansNewLoanPO.dropdownOption,
					"locator", companyOrNameValue);

			// Wait for the visibility of the company dropdown
			node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the company dropdown");
			System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the company dropdown");
			IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.companyDropdown);
			node.log(Status.INFO, "SUB-STEP_0.002 : Company dropdown is visible");
			System.out.println("SUB-STEP_0.002 : Company dropdown is visible");

			// Click on the company dropdown
			IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.companyDropdown);
			node.log(Status.INFO, "SUB-STEP_0.003 : Clicked on the company dropdown");
			System.out.println("SUB-STEP_0.003 : Clicked on the company dropdown");

			// Enter the value in dropdown search bar
			IElementActions.sendKeys_usingXpath(node, driver, LoansNewLoanPO.dropdownSearchBar, companyOrNameValue);
			node.log(Status.INFO, "SUB-STEP_0.004 : Entered the value in dropdown search bar");
			System.out.println("SUB-STEP_0.004 : Entered the value in dropdown search bar");

			// Wait for the visibility of the name dropdown
			node.log(Status.INFO, "SUB-STEP_0.005 : Waiting for the presence of the dropdown option");
			System.out.println("SUB-STEP_0.005 : Waiting for the presence of the dropdown option");
			IWaitStrategy.waitForPresence(node, driver, companyValueLocator);
			node.log(Status.INFO, "SUB-STEP_0.006 : Dropdown option is present");
			System.out.println("SUB-STEP_0.006 : Dropdown option is present");

			// Click on the company option
			IElementActions.clickelement_usingXpath(node, driver, companyValueLocator);
			node.log(Status.INFO, "SUB-STEP_0.007 : Clicked on the company option");
			System.out.println("SUB-STEP_0.007 : Clicked on the company option");

		} else if (borrowerTypeValue.equals("Corporate") && actionTypeValue.equals("New")) {
			// Wait for the visibility of the success popup
			node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the internal reference");
			System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the internal reference");
			IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.borrowerInternalReference);
			node.log(Status.INFO, "SUB-STEP_0.002 : Internal reference field is visible");
			System.out.println("SUB-STEP_0.002 : Internal reference field is visible");

			// Enter the value in bridge loan internal reference field
			IElementActions.sendKeys_usingXpath(node, driver, LoansNewLoanPO.borrowerInternalReference,
					internalReferenceValue);
			node.log(Status.INFO, "SUB-STEP_0.003 : Entered the value in bridge loan internal reference field");
			System.out.println("SUB-STEP_0.003 : Entered the value in bridge loan internal reference field");

			// Wait for the visibility of the success popup
			node.log(Status.INFO, "SUB-STEP_0.004 : Waiting for the visibility of the company");
			System.out.println("SUB-STEP_0.004 : Waiting for the visibility of the company");
			IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.company);
			node.log(Status.INFO, "SUB-STEP_0.005 : Company field is visible");
			System.out.println("SUB-STEP_0.005 : Company field is visible");

			// Enter the value in company field
			IElementActions.sendKeys_usingXpath(node, driver, LoansNewLoanPO.company, companyOrNameValue);
			node.log(Status.INFO, "SUB-STEP_0.006 : Entered the value in the company field");
			System.out.println("SUB-STEP_0.006 : Entered the value in the company field");

		}

	}

	public static void createLoan(String repaymentDate)
			throws FileNotFoundException, IOException, InterruptedException {
		// Get the data from excel
		String borrowerTypeValue = getDataFromExcel(17);
		String actionTypeValue = getDataFromExcel(18);
		String internalReferenceValue = getDataFromExcel(19);
		String companyOrNameValue = getDataFromExcel(20);
		String loanType = getDataFromExcel(21);
		String borrowerAmount = getDataFromExcel(22);
		String repaymentType = getDataFromExcel(23);
		String propertyType = getDataFromExcel(24);

		Thread.sleep(1000);
		LoansPage.enterBorrowerDetails(borrowerTypeValue, actionTypeValue, internalReferenceValue, companyOrNameValue);

		// Click on loan tab
		Utils.clickOnTab(LoansNewLoanPO.loanTab, LoansNewLoanPO.loanDisbursementHeader, "Loan");

		// Create a dynamic selector based on the provided action type value
		String loanTypeLocator = IElementActions.createDynamicLocatorString(LoansNewLoanPO.loanType, "locator",
				loanType);

		// Create a dynamic selector based on the provided repayment type value
		String repaymentTypeLocator = IElementActions.createDynamicLocatorString(LoansNewLoanPO.repaymentType,
				"locator", repaymentType);

		// Click on the loan type based on the provided value
		IElementActions.clickelement_usingXpath(node, driver, loanTypeLocator);
		node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on the loan type");
		System.out.println("SUB-STEP_0.001 : Clicked on the loan type");

		// Enter the borrower amount
		IElementActions.sendKeys_usingXpath(node, driver, LoansNewLoanPO.amount, borrowerAmount);
		node.log(Status.INFO, "SUB-STEP_0.002 : Entered the value in the amount field");
		System.out.println("SUB-STEP_0.002 : Entered the value in the amount field");

		// Click on the repayment type based on the provided value
		IElementActions.clickelement_usingXpath(node, driver, repaymentTypeLocator);
		node.log(Status.INFO, "SUB-STEP_0.003 : Clicked on the repayment type");
		System.out.println("SUB-STEP_0.003 : Clicked on the repayment type");

		switch (repaymentDate) {
		case "today":
			repaymentDate = Utils.getTodayDate();
			break;
		case "tomorrow":
			repaymentDate = Utils.getTomorrowDate();
			break;
		}

		// Split date string into day, month, and year
		String[] dateParts = repaymentDate.split("/");
		String date = dateParts[0];
		String month = dateParts[1];
		String year = dateParts[2];

		// Enter the payment date
		Utils.enterDate(LoansNewLoanPO.payementDate, UtilsPO.calenderMonth, month, UtilsPO.calenderYear, year,
				UtilsPO.calenderDay, date);
		node.log(Status.INFO, "SUB-STEP_0.004 : Entered the value in the payment date field");
		System.out.println("SUB-STEP_0.004 : Entered the value in the payment date field");

		// Click on property tab
		Utils.clickOnTab(LoansNewLoanPO.propertyTab, LoansNewLoanPO.propertyInformation, "Property");

		// Create a dynamic selector based on the provided repayment type value
		String propertyTypeLocator = IElementActions.createDynamicLocatorString(LoansNewLoanPO.propertyType, "locator",
				propertyType);

		// Click on the property type based on the provided value
		IElementActions.clickelement_usingXpath(node, driver, propertyTypeLocator);
		node.log(Status.INFO, "SUB-STEP_0.005 : Clicked on the property type");
		System.out.println("SUB-STEP_0.005 : Clicked on the property type");

		// Click on summary tab
		Utils.clickOnTab(LoansNewLoanPO.summaryTab, LoansNewLoanPO.loanDetailsHeader, "Summary");

		// Save loan
		Utils.saveLoan();

		Thread.sleep(2000);
		// Get the current URL
		String currentUrl = driver.getCurrentUrl();

		// Extract the loan number from the URL using regular expressions
		String loanNumber = LoansPage.extractLoanNumber(currentUrl);
		node.log(Status.INFO, "SUB-STEP_0.006 : Loan number is " + loanNumber);
		System.out.println("SUB-STEP_0.006 : Loan number is " + loanNumber);

		// Update created loan number on excel
		updateDataOnExcel(25, loanNumber);
	}

	public static void checkStatusAndUpdate(String status) {
		// Loop until status contains expected status
		while (true) {
			String currectStatus = IElementActions.getElementText_usingXpath(node, driver,
					LoansNewLoanPO.loanStatusLabel);
			System.out.println("Current status: " + currectStatus);
			if (status.contains(status)) {
				System.out.println("Status is Live. Exiting loop.");
				node.log(Status.INFO, "Status is Live. Exiting loop.");
				break;
			} else {
				// Assuming you have a method to update the status
				LoansPage.updateStatus(status);
			}
		}
	}

	// Method to update the status
	public static void updateStatus(String newStatus) {
		// Click on loan status tab
		Utils.clickOnTab(LoansNewLoanPO.loanStatusTab, LoansNewLoanPO.currectStatusText, "Loan Status");

		// Click on "Change Status: Yes" button
		IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.changeStatusYes);
		node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on the yes to change status");
		System.out.println("SUB-STEP_0.001 : Clicked on the yes to change status");

		// Create dynamic locator for new status
		String newStatusLocator = IElementActions.createDynamicLocatorString(LoansNewLoanPO.newStatus, "locator",
				newStatus);

		// Select status
		IElementActions.clickelement_usingXpath(node, driver, newStatusLocator);
		node.log(Status.INFO, "SUB-STEP_0.002 : Clicked on the status " + newStatus);
		System.out.println("SUB-STEP_0.002 : Clicked on the status " + newStatus);

		// Save loan
		Utils.saveLoan();
	}

	public static void createLoanAndUpdateStatus(String status)
			throws InterruptedException, FileNotFoundException, IOException {
		// Load new loan
		loadNewLoanPage();

		// Create loan
		LoansPage.createLoan("tomorrow");

		// Update status
		LoansPage.updateStatus(status);
	}

	public static void openRepaymentPopUpAndGoToEffectiveDate() {
		// Click and wait
		Utils.clickAndWait(LoansNewLoanPO.repaymentButton, "Repayment", LoansNewLoanPO.repaymentTypeFull);

		// Click on the full repayment
		IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.repaymentTypeFull);
		node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on the full repayment.");
		System.out.println("SUB-STEP_0.001 : Clicked on the full repayment.");

		// Wait for the visibility of the effective date
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the next button to become clickable");
		System.out.println("SUB-STEP_0.002 : Waiting for the next button to become clickable");
		IWaitStrategy.WaitUntilElementClickable(node, driver, LoansNewLoanPO.repaymentPopupNextButton);
		node.log(Status.INFO, "SUB-STEP_0.003 : Next button is clickable");
		System.out.println("SUB-STEP_0.003 : Next button is clickable");

		// Click on the next button
		IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.repaymentPopupNextButton);
		node.log(Status.INFO, "SUB-STEP_0.004 : Clicked on the next button");
		System.out.println("SUB-STEP_0.004 : Clicked on the next button");

		// Wait for the visibility of the effective date
		node.log(Status.INFO,
				"SUB-STEP_0.005 : Waiting for the visibility of the effective date and for the next button to become clickable");
		System.out.println(
				"SUB-STEP_0.005 : Waiting for the visibility of the effective date and for the next button to become clickable");
		IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.effectiveDate);
		IWaitStrategy.WaitUntilElementClickable(node, driver, LoansNewLoanPO.repaymentPopupNextButton);
		node.log(Status.INFO, "SUB-STEP_0.006 : Effective date is visible and next button is clickable");
		System.out.println("SUB-STEP_0.006 : Effective date is visible and next button is clickable");
	}

	public static void openRepaymentPopUpAndGoToRefundDate() {
		// Open repayment popup and go to effective date
		openRepaymentPopUpAndGoToEffectiveDate();

		// Click on the next button on repayment effective date popup
		IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.repaymentPopupNextButton);
		node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on the next button on repayment effective date popup");
		System.out.println("SUB-STEP_0.001 : Clicked on the next button on repayment effective date popup");

		// Wait for the visibility of the refund date
		node.log(Status.INFO,
				"SUB-STEP_0.002 : Waiting for the visibility of the refund date and for the next button to become clickable");
		System.out.println(
				"SUB-STEP_0.002 : Waiting for the visibility of the refund date and for the next button to become clickable");
		IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.refundDate);
		IWaitStrategy.WaitUntilElementClickable(node, driver, LoansNewLoanPO.repaymentPopupNextButton);
		node.log(Status.INFO, "SUB-STEP_0.003 : Refund date is visible and next button is clickable");
		System.out.println("SUB-STEP_0.003 : Refund date is visible and next button is clickable");
	}

	public static void openRepaymentPopUpAndGoToConfirmation() {
		// Open repayment popup and go to refund date
		openRepaymentPopUpAndGoToRefundDate();

		// Click on the next button
		IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.repaymentPopupNextButton);
		node.log(Status.INFO,
				"SUB-STEP_0.001 : Clicked on the next button on refund date popup to view warning message");
		System.out.println("SUB-STEP_0.001 : Clicked on the next button on refund date popup to view warning message");

		// Wait for the visibility of warning message
		node.log(Status.INFO,
				"SUB-STEP_0.002 : Waiting for the visibility of warning message and for the yes button to become clickable");
		System.out.println(
				"SUB-STEP_0.002 : Waiting for the visibility of warning message and for the yes button to become clickable");
		IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.warningMessageFirstLine);
		IWaitStrategy.WaitUntilElementClickable(node, driver, LoansNewLoanPO.warningPopupYes);
		node.log(Status.INFO, "SUB-STEP_0.003 : Warning message is visible and yes button is clickable");
		System.out.println("SUB-STEP_0.003 : Warning message is visible and yes button is clickable");
	}

	public static void openPartialRepaymentPopUpAndGoToEffectiveDate() {
		// Click and wait
		Utils.clickAndWait(LoansNewLoanPO.repaymentButton, "Repayment", LoansNewLoanPO.repaymentTypePartial);

		// Click on the full repayment
		IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.repaymentTypePartial);
		node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on the partial repayment.");
		System.out.println("SUB-STEP_0.001 : Clicked on the partial repayment.");

		// Wait for the visibility of the effective date
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the next button to become clickable");
		System.out.println("SUB-STEP_0.002 : Waiting for the next button to become clickable");
		IWaitStrategy.WaitUntilElementClickable(node, driver, LoansNewLoanPO.repaymentPopupNextButton);
		node.log(Status.INFO, "SUB-STEP_0.003 : Next button is clickable");
		System.out.println("SUB-STEP_0.003 : Next button is clickable");

		// Click on the next button
		IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.repaymentPopupNextButton);
		node.log(Status.INFO, "SUB-STEP_0.004 : Clicked on the next button");
		System.out.println("SUB-STEP_0.004 : Clicked on the next button");

		// Wait for the visibility of the effective date
		node.log(Status.INFO,
				"SUB-STEP_0.005 : Waiting for the visibility of the effective date and for the confirm button to become clickable");
		System.out.println(
				"SUB-STEP_0.005 : Waiting for the visibility of the effective date and for the confirm button to become clickable");
		IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.partialEffectiveDate);
		IWaitStrategy.WaitUntilElementClickable(node, driver, LoansNewLoanPO.partialConfirmButton);
		node.log(Status.INFO, "SUB-STEP_0.006 : Effective date is visible and confirm button is clickable");
		System.out.println("SUB-STEP_0.006 : Effective date is visible and confirm button is clickable");
	}

	public static String createPartialRepayment(String partialAmount) {
		// Open partial repayment popup and go to effective date
		openPartialRepaymentPopUpAndGoToEffectiveDate();

		// Enter the partial amount
		IElementActions.sendKeys_usingXpath(node, driver, LoansNewLoanPO.partialAmount, partialAmount);
		node.log(Status.INFO, "SUB-STEP_0.001 : Entered the value in the amount field");
		System.out.println("SUB-STEP_0.001 : Entered the value in the amount field");

		// Click on the partial effective date
		IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.partialEffectiveDate);
		node.log(Status.INFO, "SUB-STEP_0.002 : Clicked on the date");
		System.out.println("SUB-STEP_0.002 : Clicked on the date");

		// Get tomorrow day
		String day = Utils.getTodayDayFormatted();

		// Select day in refund date calender
		Utils.enterDay(UtilsPO.calenderDay, day);

		// Get effective date
		WebElement effectiveDate = IElementActions.returnElement(node, driver, LoansNewLoanPO.partialEffectiveDate);
		String effectiveDateValue = effectiveDate.getAttribute("value");

		// Click on the confirm button on repayment effective date popup
		IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.partialConfirmButton);
		node.log(Status.INFO, "SUB-STEP_0.003 : Clicked on the confirm button on repayment effective date popup");
		System.out.println("SUB-STEP_0.003 : Clicked on the confirm button on repayment effective date popup");

		// Wait for the invisibility of success popup
		node.log(Status.INFO, "SUB-STEP_0.004 : Waiting for the invisibility of the success popup");
		System.out.println("SUB-STEP_0.004 : Waiting for the invisibility of the success popup");
		IWaitStrategy.waitForInVisiblity(node, driver, UtilsPO.successPopup);
		node.log(Status.INFO, "SUB-STEP_0.005 : The success popup is not visible");
		System.out.println("SUB-STEP_0.005 : The success popup is not visible");

		// Assertion to verify that the popup is closed
		IElementActions.assertFalse_usingXpath(node, driver, UtilsPO.successPopup,
				"SUB-STEP_0.006 : Success popup is still displayed",
				"SUB-STEP_0.006 : Success popup is still displayed");
		return effectiveDateValue;
	}

	public static void openRecordAndUpdateStatus(String clearPreviousSearch, String searchBoxLocator,
			String searchValue, String iconLocator, String pageHeader, String status) throws InterruptedException {
		// Search record based on the provide loan reference and open it
		Utils.openRecordUsingSearch(clearPreviousSearch, searchBoxLocator, searchValue, iconLocator, pageHeader);

		// Update status
		LoansPage.checkStatusAndUpdate(status);
	}

	public static void addCashflow(String paymentOrReceipt, String paymentType, String loanDisbursementValue) {
		// Click on cashflows tab
		Utils.clickOnTab(LoansNewLoanPO.cashflowsTab, LoansNewLoanPO.cashflowsHeader, "Cashflows");

		// Click and wait
		Utils.clickAndWait(LoansNewLoanPO.addNewCashflow, "Add New Cashflow", LoansNewLoanPO.addNewCashflowPopupHeader);

		// Click on the payment button
		IElementActions.clickelement_usingXpath(node, driver, paymentOrReceipt);
		node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on the payment|receipt");
		System.out.println("SUB-STEP_0.001 : Clicked on the payment|receipt");

		// Wait for the visibility of payment type
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of payment type");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of payment type");
		IWaitStrategy.waitForVisiblity(node, driver, paymentType);
		IWaitStrategy.WaitUntilElementClickable(node, driver, paymentType);
		node.log(Status.INFO, "SUB-STEP_0.003 : The payment type is visible and clickable");
		System.out.println("SUB-STEP_0.003 : The payment type is visible and clickable");

		// Enter the loan disbursement amount
		IElementActions.sendKeys_usingXpath(node, driver, LoansNewLoanPO.amountInAddNewCashflow, loanDisbursementValue);
		node.log(Status.INFO, "SUB-STEP_0.004 : Entered the amount");
		System.out.println("SUB-STEP_0.004 : Entered the amount");

		// Click on the date
		IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.dateAddNewCashflow);
		node.log(Status.INFO, "SUB-STEP_0.005 : Clicked on the date");
		System.out.println("SUB-STEP_0.005 : Clicked on the date");

		// Get today day
		String day = Utils.getTodayDayFormatted();

		// Select day in refund date calender
		Utils.enterDay(UtilsPO.calenderDay, day);

		// Click on the loan disbursement
		IElementActions.clickelement_usingXpath(node, driver, paymentType);
		node.log(Status.INFO, "SUB-STEP_0.006 : Clicked on the payment type");
		System.out.println("SUB-STEP_0.006 : Clicked on the payment type");

		// Click on the view payment details button
		IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.viewPaymentDetails);
		node.log(Status.INFO, "SUB-STEP_0.007 : Clicked on the view payment details button");
		System.out.println("SUB-STEP_0.007 : Clicked on the view payment details button");

		// Wait for the visibility of save button in payment view popup
		node.log(Status.INFO, "SUB-STEP_0.008 : Waiting for the visibility of save button in payment view popup");
		System.out.println("SUB-STEP_0.008 : Waiting for the visibility of save button in payment view popup");
		IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.addNewCashflowSave);
		IWaitStrategy.WaitUntilElementClickable(node, driver, LoansNewLoanPO.addNewCashflowSave);
		node.log(Status.INFO, "SUB-STEP_0.009 : The save button in payment view popup is visible and save clickable");
		System.out.println("SUB-STEP_0.009 : The save button in payment view popup is visible and clickable");

		// Click on the save button
		IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.addNewCashflowSave);
		node.log(Status.INFO, "SUB-STEP_0.0010 : Clicked on the save button");
		System.out.println("SUB-STEP_0.0010 : Clicked on the save button");

		// Wait for the invisibility of the success popup
		node.log(Status.INFO, "SUB-STEP_0.0011 : Waiting for the invisibility of the success popup");
		System.out.println("SUB-STEP_0.0011 : Waiting for the invisibility of the success popup");
		IWaitStrategy.waitForInVisiblity(node, driver, UtilsPO.successPopup);
		node.log(Status.INFO, "SUB-STEP_0.0012 : Success popup is not visible");
		System.out.println("SUB-STEP_0.0012 : Success popup is not visible");

	}

	public static void approveCashflow(String row) {
		// Click and wait
		Utils.clickAndWait(LoansNewLoanPO.viewButton, "Payment View", LoansNewLoanPO.confirmPayment);

		// Click and wait
		Utils.clickAndWait(LoansNewLoanPO.confirmPayment, "Effective Confirmation Date",
				LoansNewLoanPO.repaymentPopupNextButton);

		// Click on the next button
		IElementActions.clickelement_usingXpath(node, driver, LoansNewLoanPO.repaymentPopupNextButton);
		node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on the next button");
		System.out.println("SUB-STEP_0.001 : Clicked on the next button");

		// Wait for the invisibility of the success popup
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the invisibility of the success popup");
		System.out.println("SUB-STEP_0.002 : Waiting for the invisibility of the success popup");
		IWaitStrategy.waitForInVisiblity(node, driver, UtilsPO.successPopup);
		node.log(Status.INFO, "SUB-STEP_0.003 : Success popup is not visible");
		System.out.println("SUB-STEP_0.003 : Success popup is not visible");
	}

	public static void clickDropdownAndItsOption(String dropdown, String dropdownOption) throws InterruptedException {

		// Wait for the visibility of dropdown
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of dropdown");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of dropdown");
		IWaitStrategy.waitForVisiblity(node, driver, dropdown);
		IWaitStrategy.WaitUntilElementClickable(node, driver, dropdown);
		node.log(Status.INFO, "SUB-STEP_0.002 : The dropdown is visible and clickable");
		System.out.println("SUB-STEP_0.002 : The dropdown is visible and clickable");

		// Click on the dropdown
		IElementActions.clickelement_usingXpath(node, driver, dropdown);
		node.log(Status.INFO, "SUB-STEP_0.003 : Clicked on the dropdown");
		System.out.println("SUB-STEP_0.003 : Clicked on the dropdown");

		// Wait for the visibility of dropdown option
		node.log(Status.INFO, "SUB-STEP_0.004 : Waiting for the visibility of dropdown option");
		System.out.println("SUB-STEP_0.004 : Waiting for the visibility of dropdown option");
		IWaitStrategy.waitForVisiblity(node, driver, dropdownOption);
		IWaitStrategy.WaitUntilElementClickable(node, driver, dropdownOption);
		node.log(Status.INFO, "SUB-STEP_0.005 : The dropdown is visible and clickable option");
		System.out.println("SUB-STEP_0.005 : The dropdown is visible and clickable option");

		// Click on the dropdown option
		IElementActions.clickelement_usingXpath(node, driver, dropdownOption);
		node.log(Status.INFO, "SUB-STEP_0.006 : Clicked on the dropdown option");
		System.out.println("SUB-STEP_0.006 : Clicked on the dropdown option");
	}

}
