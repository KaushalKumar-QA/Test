package com.Funding.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.locators.allPages.FundingDatabasePO;
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

public class FundingDatabaseTest extends Baseclass {

	// TC_Funding_Database _001
	@Test(priority = 1)
	public void validateFundingDatabaseVisibility() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the user can access the Database menu from the side menu options.")
					.assignCategory(fundingDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			// Call the userLoginProcess function from the utils login
			LoginPage.userLoginProcess(node, driver, getDataFromExcel(1), getDataFromExcel(2));

			// Click on the administration
			Utils.clickOnMenu(node, driver, SideMenuPO.funding);

			// Click on the users
			Utils.clickOnMenu(node, driver, SideMenuPO.fundingDatabase);

			// Wait for the visibility of the error
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the page");
			System.out.println("STEP1 : Waiting for the visibility of the page");
			IWaitStrategy.waitForVisiblity(node, driver, FundingDatabasePO.headerLoanFacilityDatabaseText);
			node.log(Status.INFO, "STEP2 : Page is visible");
			System.out.println("STEP2 : Page is visible");

			Thread.sleep(2000);
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			// Assert that funding database page is visible
			Utils.validateUrl(node, driver, currentUrl, AllPagesUrl.fundingDatabasePage,
					"validateFundingDatabaseVisibility");

		} catch (AssertionError validateFundingDatabaseVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFundingDatabaseVisibility test in FundingDatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFundingDatabaseVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFundingDatabaseVisibility.printStackTrace();
			node.fail(validateFundingDatabaseVisibility);
			Assert.fail();
			extent.flush();
		} catch (Exception validateFundingDatabaseVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFundingDatabaseVisibility test in FundingDatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFundingDatabaseVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFundingDatabaseVisibility.printStackTrace();
			node.fail(validateFundingDatabaseVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Database _003
	@Test(priority = 2)
	public void validateDatabaseHeaderText() throws IOException {
		try {
			extenttest = extent.createTest("Verify the page name in the Database page header")
					.assignCategory(fundingDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadDatabasePage function from the FundingPage
			FundingPage.loadDatabasePage();

			// Get header text
			String actualHeaderText = IElementActions.getElementText_usingXpath(node, driver,
					FundingDatabasePO.headerLoanFacilityDatabaseText);

			IElementActions.assertEquals_usingString(node, driver, actualHeaderText, "Loan Facility Database",
					"BUG: Loan Facility Database is displayed in the header of the Database page.",
					"PASS: Loan Facility Database is displayed in the header of the Database page.");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDatabaseHeaderText", "Pass", driver);

		} catch (AssertionError validateDatabaseHeaderText) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDatabaseHeaderText test in FundingDatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDatabaseHeaderText_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDatabaseHeaderText.printStackTrace();
			node.fail(validateDatabaseHeaderText);
			Assert.fail();
			extent.flush();
		} catch (Exception validateDatabaseHeaderText) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDatabaseHeaderText test in FundingDatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDatabaseHeaderText_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDatabaseHeaderText.printStackTrace();
			node.fail(validateDatabaseHeaderText);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Database _004
	@Test(priority = 3)
	public void validateDatabaseData() throws IOException {
		try {
			extenttest = extent.createTest("Verify the data of Database table")
					.assignCategory(fundingDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadDatabasePage function from the FundingPage
			FundingPage.loadDatabasePage();

			// Check the visibility of edit icon
			IElementActions.assertTrue_usingXpath(node, driver, UtilsPO.editIcon,
					"STEP1 : BUG : Edit icon is not coming under action on database page",
					"STEP1 : EXPECTED : Edit icon is coming under action on database page");

			// Check the visibility of delete icon
			IElementActions.assertTrue_usingXpath(node, driver, UtilsPO.deleteIcon,
					"STEP2 : BUG : Delete icon is not coming under action on database page",
					"STEP2 : EXPECTED : Delete icon is coming under action on database page");

			// Check the visibility of Loan Status
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.status,
					"STEP3 : BUG : Loan Status is not coming under funding database page",
					"STEP3 : EXPECTED : Loan Status is coming under funding database page");

			// Check the visibility of Loan Facility Type
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.loanFacilityType,
					"STEP4 : BUG : Loan Facility Type is not coming under funding database page",
					"STEP4 : EXPECTED : Loan Facility Type is coming under funding database page");

			// Check the visibility of Approval Status
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.approvalStatus,
					"STEP5 : BUG : Approval Status is not coming under funding database page",
					"STEP5 : EXPECTED : Approval Status is coming under funding database page");

			// Check the visibility of Internal Reference
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.internalReferenceHeader,
					"STEP6 : BUG : Internal Reference is not coming under funding database page",
					"STEP6 : EXPECTED : Internal Reference is coming under funding database page");

			// Check the visibility of Reference
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.reference,
					"STEP7 : BUG : Reference is not coming under funding database page",
					"STEP7 : EXPECTED : Reference is coming under funding database page");

			// Check the visibility of Lender Ref
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.lenderRef,
					"STEP8 : BUG : Lender Ref is not coming under funding database page",
					"STEP8 : EXPECTED : Lender Ref is coming under funding database page");

			// Check the visibility of Lender
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.lender,
					"STEP9 : BUG : Lender is not coming under funding database page",
					"STEP9 : EXPECTED : Lender is coming under funding database page");

			// Check the visibility of Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.amount,
					"STEP10 : BUG : Amount is not coming under funding database page",
					"STEP10 : EXPECTED : Amount is coming under funding database page");

			// Check the visibility of Drawn
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.drawn,
					"STEP11 : BUG : Drawn is not coming under funding database page",
					"STEP11 : EXPECTED : Drawn is coming under funding database page");

			// Check the visibility of Allocated Amount
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.allocatedAmount,
					"STEP12 : BUG : Allocated Amount is not coming under funding database page",
					"STEP12 : EXPECTED : Allocated Amount is coming under funding database page");

			// Check the visibility of Cash
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.cash,
					"STEP13 : BUG : Cash is not coming under funding database page",
					"STEP13 : EXPECTED : Cash is coming under funding database page");

			// Check the visibility of Available
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.available,
					"STEP14 : BUG : Available is not coming under funding database page",
					"STEP14 : EXPECTED : Available is coming under funding database page");

			// Check the visibility of Rate Min
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.rateMin,
					"STEP15 : BUG : Rate Min is not coming under funding database page",
					"STEP15 : EXPECTED : Rate Min is coming under funding database page");

			// Check the visibility of Rate Percentage
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.ratePercentage,
					"STEP16 : BUG : Rate Percentage is not coming under funding database page",
					"STEP16 : EXPECTED : Rate Percentage is coming under funding database page");

			// Check the visibility of Rate Fee
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.rateFee,
					"STEP17 : BUG : Rate Fee is not coming under funding database page",
					"STEP17 : EXPECTED : Rate Fee is coming under funding database page");

			// Check the visibility of Rate Fee %
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.rateFeePercentage,
					"STEP18 : BUG : Rate Fee % is not coming under funding database page",
					"STEP18 : EXPECTED : Rate Fee % is coming under funding database page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDatabaseData", "Pass", driver);

		} catch (AssertionError validateDatabaseData) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDatabaseData test in FundingDatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDatabaseData_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDatabaseData.printStackTrace();
			node.fail(validateDatabaseData);
			Assert.fail();
			extent.flush();
		} catch (Exception validateDatabaseData) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDatabaseData test in FundingDatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDatabaseData_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDatabaseData.printStackTrace();
			node.fail(validateDatabaseData);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Database _005
	@Test(priority = 4)
	public void validateDatabaseEdit() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the user can edit any record from the table of the Database")
					.assignCategory(fundingDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadDatabasePage function from the FundingPage
			FundingPage.loadDatabasePage();

			// Get internal reference
			String internalRefExpected = "test" + IElementActions.getRandomNumber();

			// Open facility loan by clicking edit icon
			FundingPage.openFacilityLoanByUsingEditIcon();

			// Click on the edit button
			Utils.clickAndWait(FundingDatabasePO.internalReferenceEditIcon, "Edit", UtilsPO.popUp);
			node.log(Status.INFO, "STEP1 : Clicked on the edit icon");
			System.out.println("STEP1 : Clicked on the edit icon");

			// Click on the new value field
			IElementActions.clickelement_usingXpath(node, driver, FundingDatabasePO.newValue);
			node.log(Status.INFO, "STEP2 : Clicked on new value");
			System.out.println("STEP2 : Clicked on new value");

			Thread.sleep(1000);
			// Click on the new value field
			IElementActions.clearElement_usingXpath(node, driver, FundingDatabasePO.newValue);
			node.log(Status.INFO, "STEP3 : Clear old value from new value");
			System.out.println("STEP3 : Clear old value from new value");

			// Enter the value in internal reference
			IElementActions.sendKeys_usingXpath(node, driver, FundingDatabasePO.newValue, internalRefExpected);
			node.log(Status.INFO, "STEP4 : Entered the value in new value");
			System.out.println("STEP4 : Entered the value in new value");

			// Click on the confirm button
			IElementActions.clickelement_usingXpath(node, driver, FundingDatabasePO.confirmButton);
			node.log(Status.INFO, "STEP5 : Clicked on confirm button");
			System.out.println("STEP5 : Clicked on confirm button");

			// Wait for the invisibility of the popup
			node.log(Status.INFO, "STEP6 : Waiting for the invisibility of the popup");
			System.out.println("STEP6 : Waiting for the invisibility of the popup");
			IWaitStrategy.waitForInVisiblity(node, driver, UtilsPO.successPopup);
			node.log(Status.INFO, "STEP7 : Popup is not displayed");
			System.out.println("STEP7 : Popup is not displayed");

			// Get internal reference
			String internalRefActual = IElementActions.getElementValue(node, driver,
					FundingDatabasePO.internalReferenceField);

			if (internalRefExpected.equalsIgnoreCase(internalRefActual)) {

				Assert.assertTrue(true, internalRefActual + " loan is updated.");
				System.out.println(internalRefActual + " loan is updated.");
				node.log(Status.PASS, internalRefActual + " loan is updated.");

			} else {
				Assert.assertTrue(false,
						internalRefActual + " is displayed in the loan," + internalRefExpected + " is not updated.");
				System.out.println(
						internalRefActual + " is displayed in the loan," + internalRefExpected + " is not updated.");
				node.log(Status.FAIL,
						internalRefActual + " is displayed in the loan," + internalRefExpected + " is not updated.");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateDatabaseEdit", "Pass", driver);
		} catch (AssertionError validateDatabaseEdit) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateDatabaseEdit test in FundingDatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDatabaseEdit_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDatabaseEdit.printStackTrace();
			node.fail(validateDatabaseEdit);
			Assert.fail();
			extent.flush();
		} catch (Exception validateDatabaseEdit) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateDatabaseEdit test in FundingDatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateDatabaseEdit_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateDatabaseEdit.printStackTrace();
			node.fail(validateDatabaseEdit);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Database _008
	@Test(priority = 5)
	public void validateSortIconVisibility() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the user can see the sorting icon on the  following titles: "
					+ "Status, Loan Facility Type, Approval Status, Internal Reference, Reference, Lender Ref, Lender, Amount, Drawn, Allocated Amount, Cash, Available, Rate Min, Rate Percentage, Rate Fee, Rate Fee %")
					.assignCategory(fundingDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadDatabasePage function from the FundingPage
			FundingPage.loadDatabasePage();

			// Check the visibility of Sort icon of status column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.statusSortIcon,
					"STEP1 : BUG: The sort Icon is not coming in status column header on database table",
					"STEP1 : EXPECTED: The sort Icon is coming in status column header on database table");

			// Check the visibility of Sort icon of loan facility type column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.loanFacilityTypeSortIcon,
					"STEP2 : BUG: The sort Icon is not coming in loan facility type column header on database table",
					"STEP2 : EXPECTED: The sort Icon is coming in loan facility type column header on database table");

			// Check the visibility of Sort icon of approval status column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.approvalStatusSortIcon,
					"STEP3 : BUG: The sort Icon is not coming in approval status column header on database table",
					"STEP3 : EXPECTED: The sort Icon is coming in approval status column header on database table");

			// Check the visibility of Sort icon of internal reference column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.internalReferenceHeaderSortIcon,
					"STEP4 : BUG: The sort Icon is not coming in internal reference column header on database table",
					"STEP4 : EXPECTED: The sort Icon is coming in internal reference column header on database table");

			// Check the visibility of Sort icon of reference column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.referenceSortIcon,
					"STEP5 : BUG: The sort Icon is not coming in reference column header on database table",
					"STEP5 : EXPECTED: The sort Icon is coming in reference column header on database table");

			// Check the visibility of Sort icon of lenderRef column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.lenderRefSortIcon,
					"STEP6 : BUG: The sort Icon is not coming in lenderRef column header on database table",
					"STEP6 : EXPECTED: The sort Icon is coming in lenderRef column header on database table");

			// Check the visibility of Sort icon of lender column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.lenderSortIcon,
					"STEP7 : BUG: The sort Icon is not coming in lender column header on database table",
					"STEP7 : EXPECTED: The sort Icon is coming in lender column header on database table");

			// Check the visibility of Sort icon of amount column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.amountSortIcon,
					"STEP8 : BUG: The sort Icon is not coming in amount column header on database table",
					"STEP8 : EXPECTED: The sort Icon is coming in amount column header on database table");

			// Check the visibility of Sort icon of drawn column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.drawnSortIcon,
					"STEP9 : BUG: The sort Icon is not coming in drawn column header on database table",
					"STEP9 : EXPECTED: The sort Icon is coming in drawn column header on database table");

			// Check the visibility of Sort icon of allocated amount column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.allocatedAmountSortIcon,
					"STEP10 : BUG: The sort Icon is not coming in allocated amount column header on database table",
					"STEP10 : EXPECTED: The sort Icon is coming in allocated amount column header on database table");

			// Check the visibility of Sort icon of cash column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.cashSortIcon,
					"STEP11 : BUG: The sort Icon is not coming in cash column header on database table",
					"STEP11 : EXPECTED: The sort Icon is coming in cash column header on database table");

			// Check the visibility of Sort icon of available column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.availableSortIcon,
					"STEP12 : BUG: The sort Icon is not coming in available column header on database table",
					"STEP12 : EXPECTED: The sort Icon is coming in available column header on database table");

			// Check the visibility of Sort icon of rate min column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.rateMinSortIcon,
					"STEP13 : BUG: The sort Icon is not coming in rate min column header on database table",
					"STEP13 : EXPECTED: The sort Icon is coming in rate min column header on database table");

			// Check the visibility of Sort icon of rate percentage column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.ratePercentageSortIcon,
					"STEP14 : BUG: The sort Icon is not coming in rate percentage column header on database table",
					"STEP14 : EXPECTED: The sort Icon is coming in rate percentage column header on database table");

			// Check the visibility of Sort icon of rate fee column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.rateFeeSortIcon,
					"STEP15 : BUG: The sort Icon is not coming in rate fee column header on database table",
					"STEP15 : EXPECTED: The sort Icon is coming in rate fee column header on database table");

			// Check the visibility of Sort icon of rate fee percentage column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.rateFeePercentageSortIcon,
					"STEP16 : BUG: The sort Icon is not coming in rate fee percentage column header on database table",
					"STEP16 : EXPECTED: The sort Icon is coming in rate fee percentage column header on database table");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateSortIconVisibility", "Pass", driver);
		} catch (AssertionError validateSortIconVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateSortIconVisibility test in FundingDatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateSortIconVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSortIconVisibility.printStackTrace();
			node.fail(validateSortIconVisibility);
			Assert.fail();
			extent.flush();
		} catch (Exception validateSortIconVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateSortIconVisibility test in FundingDatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateSortIconVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSortIconVisibility.printStackTrace();
			node.fail(validateSortIconVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Database _009
	@Test(priority = 6)
	public void validateSorting() throws IOException {
		try {
			extenttest = extent.createTest("Verify the sorting of the following titles:"
					+ "Status, Loan Facility Type, Approval Status, Internal Reference, Reference, Lender Ref, Lender, Amount, Drawn, Allocated Amount, Cash, Available, Rate Min, Rate Percentage, Rate Fee, Rate Fee % ")
					.assignCategory(fundingDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadDatabasePage function from the FundingPage
			FundingPage.loadDatabasePage();

			// Click on the sort icon and check sorting
			FundingPage.clickTitlesAndCheckSort(node, driver, FundingDatabasePO.statusSortIcon,
					FundingDatabasePO.statusElements, "descending", "validateStatusSorting", "stringValue");

			// Click on the sort icon and check sorting
			FundingPage.clickTitlesAndCheckSort(node, driver, FundingDatabasePO.loanFacilityTypeSortIcon,
					FundingDatabasePO.loanFacilityTypeElements, "descending", "validateLoanFacilityTypeSorting",
					"stringValue");

			// Click on the sort icon and check sorting
			FundingPage.clickTitlesAndCheckSort(node, driver, FundingDatabasePO.approvalStatusSortIcon,
					FundingDatabasePO.approvalStatusElements, "descending", "validateApprovalStatusSorting",
					"stringValue");

			// Click on the sort icon and check sorting
			FundingPage.clickTitlesAndCheckSort(node, driver, FundingDatabasePO.internalReferenceHeaderSortIcon,
					FundingDatabasePO.internalReferenceElements, "descending", "validateinternalReferenceSorting",
					"stringValue");

			// Click on the sort icon and check sorting
			FundingPage.clickTitlesAndCheckSort(node, driver, FundingDatabasePO.referenceSortIcon,
					FundingDatabasePO.references, "descending", "validateReferenceSorting", "stringValue");

			// Click on the sort icon and check sorting
			FundingPage.clickTitlesAndCheckSort(node, driver, FundingDatabasePO.lenderRefSortIcon,
					FundingDatabasePO.lenderRefElements, "descending", "validateLenderRefSorting", "stringValue");

			// Click on the sort icon and check sorting
			FundingPage.clickTitlesAndCheckSort(node, driver, FundingDatabasePO.lenderSortIcon,
					FundingDatabasePO.lenderElements, "descending", "validateLenderSorting", "stringValue");

			// Click on the sort icon and check sorting
			FundingPage.clickTitlesAndCheckSort(node, driver, FundingDatabasePO.amountSortIcon,
					FundingDatabasePO.amountElements, "descending", "validateAmountSorting", "intValue");

			// Click on the sort icon and check sorting
			FundingPage.clickTitlesAndCheckSort(node, driver, FundingDatabasePO.drawnSortIcon,
					FundingDatabasePO.drawnElements, "descending", "validateDrawnSorting", "intValue");

			// Click on the sort icon and check sorting
			FundingPage.clickTitlesAndCheckSort(node, driver, FundingDatabasePO.allocatedAmountSortIcon,
					FundingDatabasePO.allocatedAmountElements, "descending", "validateAllocatedAmountSorting",
					"intValue");

			// Click on the sort icon and check sorting
			FundingPage.clickTitlesAndCheckSort(node, driver, FundingDatabasePO.cashSortIcon,
					FundingDatabasePO.cashElements, "descending", "validateCashSorting", "intValue");

			// Click on the sort icon and check sorting
			FundingPage.clickTitlesAndCheckSort(node, driver, FundingDatabasePO.availableSortIcon,
					FundingDatabasePO.availableElements, "descending", "validateAvailableSorting", "intValue");

			// Click on the sort icon and check sorting
			FundingPage.clickTitlesAndCheckSort(node, driver, FundingDatabasePO.rateMinSortIcon,
					FundingDatabasePO.rateMinElements, "descending", "validateRateMinSorting", "intValue");

			// Click on the sort icon and check sorting
			FundingPage.clickTitlesAndCheckSort(node, driver, FundingDatabasePO.ratePercentageSortIcon,
					FundingDatabasePO.ratePercentageElements, "descending", "validateRatePercentageSorting",
					"intValue");

			// Click on the sort icon and check sorting
			FundingPage.clickTitlesAndCheckSort(node, driver, FundingDatabasePO.rateFeeSortIcon,
					FundingDatabasePO.rateFeeElements, "descending", "validateRateFeeSorting", "intValue");

			// Click on the sort icon and check sorting
			FundingPage.clickTitlesAndCheckSort(node, driver, FundingDatabasePO.rateFeePercentageSortIcon,
					FundingDatabasePO.rateFeePercentageElements, "descending", "validateRateFeePercentageSorting",
					"intValue");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateSorting", "Pass", driver);

		} catch (AssertionError validateSorting) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateSorting test in FundingDatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateSorting_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSorting.printStackTrace();
			node.fail(validateSorting);
			Assert.fail();
			extent.flush();
		} catch (Exception validateSorting) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateSorting test in FundingDatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateSorting_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSorting.printStackTrace();
			node.fail(validateSorting);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Database _010
	@Test(priority = 7)
	public void validateSearchIconVisibility() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the user is able to see the search box below the followings titles:"
							+ "Internal Reference, Reference, Lender Ref, Lender, Amount, Drawn, Allocated Amount, Cash, Available, Rate Min, Rate Percentage, Rate Fee, Rate Fee % ")
					.assignCategory(fundingDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadDatabasePage function from the FundingPage
			FundingPage.loadDatabasePage();

			// Check the visibility of search box of status column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.statusSearchBox,
					"STEP1 : BUG: The search box is not coming in status column of database table",
					"STEP1 : EXPECTED: The search box is coming in status column of database table");

			// Check the visibility of search box of loan facility type column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.loanFacilityTypeSearchBox,
					"STEP2 : BUG: The search box is not coming in loan facility type column of database table",
					"STEP2 : EXPECTED: The search box is coming in loan facility type column of database table");

			// Check the visibility of search box of approval status column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.approvalStatusSearchBox,
					"STEP3 : BUG: The search box is not coming in approval status column of database table",
					"STEP3 : EXPECTED: The search box is coming in approval status column of database table");

			// Check the visibility of search box of internal reference column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.internalReferenceHeaderSearchBox,
					"STEP4 : BUG: The search box is not coming in internal reference column of database table",
					"STEP4 : EXPECTED: The search box is coming in internal reference column of database table");

			// Check the visibility of search box of reference column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.referenceSearchBox,
					"STEP5 : BUG: The search box is not coming in reference column of database table",
					"STEP5 : EXPECTED: The search box is coming in reference column of database table");

			// Check the visibility of search box of lenderRef column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.lenderRefSearchBox,
					"STEP6 : BUG: The search box is not coming in lenderRef column of database table",
					"STEP6 : EXPECTED: The search box is coming in lenderRef column of database table");

			// Check the visibility of search box of lender column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.lenderSearchBox,
					"STEP7 : BUG: The search box is not coming in lender column of database table",
					"STEP7 : EXPECTED: The search box is coming in lender column of database table");

			// Check the visibility of search box of amount column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.amountSearchBoxMin,
					"STEP8 : BUG: The search box is not coming in amount column of database table",
					"STEP8 : EXPECTED: The search box is coming in amount column of database table");

			// Check the visibility of search box of drawn column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.drawnSearchBoxMin,
					"STEP9 : BUG: The search box is not coming in drawn column of database table",
					"STEP9 : EXPECTED: The search box is coming in drawn column of database table");

			// Check the visibility of search box of allocated amount column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.allocatedAmountSearchBoxMin,
					"STEP10 : BUG: The search box is not coming in allocated amount column of database table",
					"STEP10 : EXPECTED: The search box is coming in allocated amount column of database table");

			// Check the visibility of search box of cash column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.cashSearchBoxMin,
					"STEP11 : BUG: The search box is not coming in cash column of database table",
					"STEP11 : EXPECTED: The search box is coming in cash column of database table");

			// Check the visibility of search box of available column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.availableSearchBoxMin,
					"STEP12 : BUG: The search box is not coming in available column of database table",
					"STEP12 : EXPECTED: The search box is coming in available column of database table");

			// Check the visibility of search box of rate min column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.rateMinSearchBoxMin,
					"STEP13 : BUG: The search box is not coming in rate min column of database table",
					"STEP13 : EXPECTED: The search box is coming in rate min column of database table");

			// Check the visibility of search box of rate percentage column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.ratePercentageSearchBoxMin,
					"STEP14 : BUG: The search box is not coming in rate percentage column of database table",
					"STEP14 : EXPECTED: The search box is coming in rate percentage column of database table");

			// Check the visibility of search box of rate fee column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.rateFeeSearchBoxMin,
					"STEP15 : BUG: The search box is not coming in rate fee column of database table",
					"STEP15 : EXPECTED: The search box is coming in rate fee column of database table");

			// Check the visibility of search box of rate fee percentage column
			IElementActions.assertTrue_usingXpath(node, driver, FundingDatabasePO.rateFeePercentageSearchBoxMin,
					"STEP16 : BUG: The search box is not coming in rate fee percentage column of database table",
					"STEP16 : EXPECTED: The search box is coming in rate fee percentage column of database table");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateSearchIconVisibility", "Pass", driver);
		} catch (AssertionError validateSearchIconVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateSearchIconVisibility test in FundingDatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateSearchIconVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSearchIconVisibility.printStackTrace();
			node.fail(validateSearchIconVisibility);
			Assert.fail();
			extent.flush();
		} catch (Exception validateSearchIconVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateSearchIconVisibility test in FundingDatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateSearchIconVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSearchIconVisibility.printStackTrace();
			node.fail(validateSearchIconVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Database _011
	// TC_Funding_Database _012
	// TC_Funding_Database _013
	@Test(priority = 8)
	public void validateInputAndResultInSearch() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the user is able to enter the input data in the search field."
					+ "Verify that, based on the input given, the respective details are searched and visible to the user."
					+ "Verify that the user should also be able to search by Min and Max (range)")
					.assignCategory(fundingDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadDatabasePage function from the FundingPage
			FundingPage.loadDatabasePage();

			// Get the data from excel
			String internalReferenceHeaderSearchValue = getDataFromExcel(33);
			String referenceSearchValue = getDataFromExcel(34);
			String lenderRefSearchValue = getDataFromExcel(35);
			String lenderSearchValue = getDataFromExcel(36);
			String amountSearchValueMin = getDataFromExcel(37);
			String drawnSearchValueMin = getDataFromExcel(38);
			String allocatedAmountSearchValueMin = getDataFromExcel(39);
			String cashSearchValueMin = getDataFromExcel(40);
			String availableSearchValueMin = getDataFromExcel(41);
			String rateMinSearchValueMin = getDataFromExcel(42);
			String ratePercentageSearchValueMin = getDataFromExcel(43);
			String rateFeeSearchValueMin = getDataFromExcel(44);
			String rateFeePercentageSearchValueMin = getDataFromExcel(45);

			String amountSearchValueMax = getDataFromExcel(49);
			String drawnSearchValueMax = getDataFromExcel(50);
			String allocatedAmountSearchValueMax = getDataFromExcel(51);
			String cashSearchValueMax = getDataFromExcel(52);
			String availableSearchValueMax = getDataFromExcel(53);
			String rateMinSearchValueMax = getDataFromExcel(54);
			String ratePercentageSearchValueMax = getDataFromExcel(55);
			String rateFeeSearchValueMax = getDataFromExcel(56);
			String rateFeePercentageSearchValueMax = getDataFromExcel(57);

			Thread.sleep(1000);

			// Enter on search box of internal reference column
			Utils.enterSearchTextAndValidate(UtilsPO.headerSearchCrossIcon,
					FundingDatabasePO.internalReferenceHeaderSearchBox, internalReferenceHeaderSearchValue,
					FundingDatabasePO.internalReferenceFirstRowValue);

			// Enter on search box of reference column
			Utils.enterSearchTextAndValidate(UtilsPO.headerSearchCrossIcon, FundingDatabasePO.referenceSearchBox,
					referenceSearchValue, FundingDatabasePO.referenceFirstRowValue);

			// Enter on search box of lenderRef column
			Utils.enterSearchTextAndValidate(UtilsPO.headerSearchCrossIcon, FundingDatabasePO.lenderRefSearchBox,
					lenderRefSearchValue, FundingDatabasePO.lenderRefFirstRowValue);

			// Enter on search box of lender column
			Utils.enterSearchTextAndValidate(UtilsPO.headerSearchCrossIcon, FundingDatabasePO.lenderSearchBox,
					lenderSearchValue, FundingDatabasePO.lenderFirstRowValue);

			// Enter on search box of amount column
			Utils.enterSearchTextAndValidateInBetween(UtilsPO.headerSearchCrossIcon,
					FundingDatabasePO.amountSearchBoxMin, FundingDatabasePO.amountSearchBoxMax, amountSearchValueMin,
					amountSearchValueMax, FundingDatabasePO.amountFirstRowValue);

			// Enter on search box of drawn column
			Utils.enterSearchTextAndValidateInBetween(UtilsPO.headerSearchCrossIcon,
					FundingDatabasePO.drawnSearchBoxMin, FundingDatabasePO.drawnSearchBoxMax, drawnSearchValueMin,
					drawnSearchValueMax, FundingDatabasePO.drawnFirstRowValue);

			// Enter on search box of allocated amount column
			Utils.enterSearchTextAndValidateInBetween(UtilsPO.headerSearchCrossIcon,
					FundingDatabasePO.allocatedAmountSearchBoxMin, FundingDatabasePO.allocatedAmountSearchBoxMax,
					allocatedAmountSearchValueMin, allocatedAmountSearchValueMax,
					FundingDatabasePO.allocatedAmountFirstRowValue);

			// Enter on search box of cash column
			Utils.enterSearchTextAndValidateInBetween(UtilsPO.headerSearchCrossIcon, FundingDatabasePO.cashSearchBoxMin,
					FundingDatabasePO.cashSearchBoxMax, cashSearchValueMin, cashSearchValueMax,
					FundingDatabasePO.cashFirstRowValue);

			// Enter on search box of available column
			Utils.enterSearchTextAndValidateInBetween(UtilsPO.headerSearchCrossIcon,
					FundingDatabasePO.availableSearchBoxMin, FundingDatabasePO.availableSearchBoxMax,
					availableSearchValueMin, availableSearchValueMax, FundingDatabasePO.availableFirstRowValue);

			// Enter on search box of rate min column
			Utils.enterSearchTextAndValidateInBetween(UtilsPO.headerSearchCrossIcon,
					FundingDatabasePO.rateMinSearchBoxMin, FundingDatabasePO.rateMinSearchBoxMax, rateMinSearchValueMin,
					rateMinSearchValueMax, FundingDatabasePO.rateMinFirstRowValue);

			// Enter on search box of rate percentage column
			Utils.enterSearchTextAndValidateInBetween(UtilsPO.headerSearchCrossIcon,
					FundingDatabasePO.ratePercentageSearchBoxMin, FundingDatabasePO.ratePercentageSearchBoxMax,
					ratePercentageSearchValueMin, ratePercentageSearchValueMax,
					FundingDatabasePO.ratePercentageFirstRowValue);

			// Enter on search box of rate fee column
			Utils.enterSearchTextAndValidateInBetween(UtilsPO.headerSearchCrossIcon,
					FundingDatabasePO.rateFeeSearchBoxMin, FundingDatabasePO.rateFeeSearchBoxMax, rateFeeSearchValueMin,
					rateFeeSearchValueMax, FundingDatabasePO.rateFeeFirstRowValue);

			// Enter on search box of rate fee percentage column
			Utils.enterSearchTextAndValidateInBetween(UtilsPO.headerSearchCrossIcon,
					FundingDatabasePO.rateFeePercentageSearchBoxMin, FundingDatabasePO.rateFeePercentageSearchBoxMax,
					rateFeePercentageSearchValueMin, rateFeePercentageSearchValueMax,
					FundingDatabasePO.rateFeePercentageFirstRowValue);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateInputInSearch", "Pass", driver);
		} catch (AssertionError validateInputInSearch) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateInputInSearch test in FundingDatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateInputInSearch_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInputInSearch.printStackTrace();
			node.fail(validateInputInSearch);
			Assert.fail();
			extent.flush();
		} catch (Exception validateInputInSearch) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateInputInSearch test in FundingDatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateInputInSearch_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateInputInSearch.printStackTrace();
			node.fail(validateInputInSearch);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Database _014
	@Test(priority = 9)
	public void validateFilterByStatus() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the user can filter the records based on the status")
					.assignCategory(fundingDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Call the loadDatabasePage function from the FundingPage
			FundingPage.loadDatabasePage();

			// Check cross icon is available or not
			boolean checkCrossIcon = IElementActions.isElementAvailable(node, driver, UtilsPO.headerSearchCrossIcon);

			// If cross icon is present, click on it to clear the search
			if (checkCrossIcon) {
				// Click on the cross icon to clear the search
				IElementActions.clickelement_usingXpath(node, driver, UtilsPO.headerSearchCrossIcon);
				node.log(Status.INFO, "STEP_0.001 : clicked on the cross icon");
				System.out.println("STEP_0.001 : clicked on the cross icon");
			}

			// Get the data from excel
			String statusFilterValue = getDataFromExcel(46);

			Utils.selectValueInDropdownAndValidateResult(FundingDatabasePO.statusDropdown, statusFilterValue,
					FundingDatabasePO.statusElements);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFilterByStatus", "Pass", driver);
		} catch (AssertionError validateFilterByStatus) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFilterByStatus test in FundingDatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFilterByStatus_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFilterByStatus.printStackTrace();
			node.fail(validateFilterByStatus);
			Assert.fail();
			extent.flush();
		} catch (Exception validateFilterByStatus) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFilterByStatus test in FundingDatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateFilterByStatus_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFilterByStatus.printStackTrace();
			node.fail(validateFilterByStatus);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Database _015
	@Test(priority = 10)
	public void validateFilterByLoanFacilityType() throws IOException {
		try {
			extenttest = extent
					.createTest("Verify that the user can filter the records based on the Loan Facility Type")
					.assignCategory(fundingDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Call the loadDatabasePage function from the FundingPage
			FundingPage.loadDatabasePage();

			// Get the data from excel
			String loanFacilityTypeFilterValue = getDataFromExcel(47);

			Utils.selectValueInDropdownAndValidateResult(FundingDatabasePO.loanFacilityTypeDropdown,
					loanFacilityTypeFilterValue, FundingDatabasePO.loanFacilityTypeElements);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFilterByLoanFacilityType", "Pass", driver);
		} catch (AssertionError validateFilterByLoanFacilityType) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFilterByLoanFacilityType test in FundingDatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFilterByLoanFacilityType_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFilterByLoanFacilityType.printStackTrace();
			node.fail(validateFilterByLoanFacilityType);
			Assert.fail();
			extent.flush();
		} catch (Exception validateFilterByLoanFacilityType) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFilterByLoanFacilityType test in FundingDatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFilterByLoanFacilityType_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFilterByLoanFacilityType.printStackTrace();
			node.fail(validateFilterByLoanFacilityType);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Funding_Database _016
	@Test(priority = 11)
	public void validateFilterByApprovalStatus() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the user can filter the records based on the Approval Status")
					.assignCategory(fundingDatabase_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Call the loadDatabasePage function from the FundingPage
			FundingPage.loadDatabasePage();

			// Get the data from excel
			String approvalStatusFilterValue = getDataFromExcel(48);

			Utils.selectValueInDropdownAndValidateResult(FundingDatabasePO.approvalStatusDropdown,
					approvalStatusFilterValue, FundingDatabasePO.approvalStatusElements);

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateFilterByApprovalStatus", "Pass", driver);
		} catch (AssertionError validateFilterByApprovalStatus) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateFilterByApprovalStatus test in FundingDatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFilterByApprovalStatus_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFilterByApprovalStatus.printStackTrace();
			node.fail(validateFilterByApprovalStatus);
			Assert.fail();
			extent.flush();
		} catch (Exception validateFilterByApprovalStatus) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateFilterByApprovalStatus test in FundingDatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateFilterByApprovalStatus_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateFilterByApprovalStatus.printStackTrace();
			node.fail(validateFilterByApprovalStatus);
			Assert.fail();
			extent.flush();
		}
	}

}
