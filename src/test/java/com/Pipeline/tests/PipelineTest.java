package com.Pipeline.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.locators.allPages.LoansNewLoanPO;
import com.locators.allPages.PipelinePO;
import com.locators.allPages.SideMenuPO;
import com.locators.allPages.UtilsPO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.url.AllPagesUrl;
import com.qa.utils.LoginPage;
import com.qa.utils.PipelinePage;
import com.qa.utils.Utils;

public class PipelineTest extends Baseclass {

	// TC_Pipeline _001
	@Test(priority = 1)
	public void validatePipelineVisibility() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that the user can view the Pipeline menu from the side menu options.")
					.assignCategory(pipeline_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadLoginPage function from the login
			LoginPage.loadLoginPage();

			// Calling the userLoginProcess function from the LoginPage
			LoginPage.userLoginProcess(node, driver, getDataFromExcel(1), getDataFromExcel(2));

			// Check the visibility of pipeline
			IElementActions.assertTrue_usingXpath(node, driver, SideMenuPO.pipeline,
					"STEP1 : BUG : Pipeline module is not coming on the side menu",
					"STEP1 : EXPECTED : Pipeline module is coming on the side menu");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validatePipelineVisibility", "Pass", driver);

		} catch (AssertionError validatePipelineVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePipelineVisibility test in PipelineTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatePipelineVisibility_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePipelineVisibility.printStackTrace();
			node.fail(validatePipelineVisibility);
			Assert.fail();
			extent.flush();
		} catch (Exception validatePipelineVisibility) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePipelineVisibility test in PipelineTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatePipelineVisibility_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePipelineVisibility.printStackTrace();
			node.fail(validatePipelineVisibility);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Pipeline _002
	@Test(priority = 2)
	public void validatePipelineOptions() throws IOException {

		try {
			extenttest = extent.createTest("Verify submenu options of Pipeline menu")
					.assignCategory(pipeline_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Click on the Pipeline Menu
			Utils.clickOnMenu(node, driver, SideMenuPO.pipeline);

			// Check the visibility of calculator
			IElementActions.assertTrue_usingXpath(node, driver, SideMenuPO.calculator,
					"STEP1 : BUG : Calculator is not coming under pipeline module",
					"STEP1 : EXPECTED : Calculator is coming under pipeline module");

			// Check the visibility of new pipeline
			IElementActions.assertTrue_usingXpath(node, driver, SideMenuPO.pipelineNewLoan,
					"STEP2 : BUG : New loan is not coming under pipeline module",
					"STEP2 : EXPECTED : New loan is coming under pipeline module");

			// Check the visibility of database
			IElementActions.assertTrue_usingXpath(node, driver, SideMenuPO.pipelineDatabase,
					"STEP3 : BUG : Database is not coming under pipeline module",
					"STEP3 : EXPECTED : Database is coming under pipeline module");

			// Check the visibility of archive
			IElementActions.assertTrue_usingXpath(node, driver, SideMenuPO.pipelineArchive,
					"STEP4 : BUG : Archive is not coming under pipeline module",
					"STEP4 : EXPECTED : Archive is coming under pipeline module");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validatePipelineOptions", "Pass", driver);

		} catch (AssertionError validatePipelineOptions) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePipelineOptions test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatePipelineOptions_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePipelineOptions.printStackTrace();
			node.fail(validatePipelineOptions);
			Assert.fail();
			extent.flush();
		} catch (Exception validatePipelineOptions) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePipelineOptions test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatePipelineOptions_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePipelineOptions.printStackTrace();
			node.fail(validatePipelineOptions);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Pipeline_Database_001
	@Test(priority = 3)
	public void validatePipelineDatabase() throws IOException {

		try {
			extenttest = extent.createTest("Verify user has Access to the Database Page")
					.assignCategory(pipeline_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Click on the Pipeline Menu
			Utils.clickOnMenu(node, driver, SideMenuPO.pipeline);

			// Click on the Pipeline Database Sub Menu
			Utils.clickOnMenu(node, driver, SideMenuPO.pipelineDatabase);

			// Wait for the visibility of Pipeline Database page
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of Pipeline Database page");
			System.out.println("STEP1 : Waiting for the visibility of Pipeline Database page");
			IWaitStrategy.waitForVisiblity(node, driver, PipelinePO.pipelineDatabaseText);
			node.log(Status.INFO, "STEP2 : Pipeline Database page is visible");
			System.out.println("STEP2 : Pipeline Database page is visible");

			Thread.sleep(2000);
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			// Check the visibility of all loans table
			IElementActions.assertTrue_usingXpath(node, driver, PipelinePO.pipelineDatabaseTable,
					"STEP3 : BUG : All loans table is not coming under pipeline database",
					"STEP3 : EXPECTED : All loans table is coming under pipeline database");

			// Calling the validateUrl from Utils
			Utils.validateUrl(node, driver, currentUrl, AllPagesUrl.pipelineDatabasePage, "validatePipelineDatabase");

		} catch (AssertionError validatePipelineDatabase) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePipelineDatabase test in PipelineTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatePipelineDatabase_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePipelineDatabase.printStackTrace();
			node.fail(validatePipelineDatabase);
			Assert.fail();
			extent.flush();
		} catch (Exception validatePipelineDatabase) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePipelineDatabase test in PipelineTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validatePipelineDatabase_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePipelineDatabase.printStackTrace();
			node.fail(validatePipelineDatabase);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Pipeline_Database_019
	@Test(priority = 4)
	public void validatePipelineDatabaseActionColumn() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that under the Action column Edit and Move to Archive button icons are visible")
					.assignCategory(pipeline_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadDatabasePage from PipelinePage
			PipelinePage.loadDatabasePage();

			// Check the visibility of edit icon
			IElementActions.assertTrue_usingXpath(node, driver, PipelinePO.editIcon,
					"STEP1 : BUG : Edit icon is not coming under action on database page",
					"STEP1 : EXPECTED : Edit icon is coming under action on database page");

			// Check the visibility of move to archive icon
			IElementActions.assertTrue_usingXpath(node, driver, PipelinePO.archiveIcon,
					"STEP2 : BUG :  Move to archive icon is not coming under action on database page",
					"STEP2 : EXPECTED : Move to archive icon is coming under action on database page");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validatePipelineDatabaseActionColumn", "Pass", driver);

		} catch (AssertionError validatePipelineDatabaseActionColumn) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validatePipelineDatabaseActionColumn test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePipelineDatabaseActionColumn_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePipelineDatabaseActionColumn.printStackTrace();
			node.fail(validatePipelineDatabaseActionColumn);
			Assert.fail();
			extent.flush();
		} catch (Exception validatePipelineDatabaseActionColumn) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validatePipelineDatabaseActionColumn test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validatePipelineDatabaseActionColumn_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validatePipelineDatabaseActionColumn.printStackTrace();
			node.fail(validatePipelineDatabaseActionColumn);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Pipeline_Database_020
	@Test(priority = 5)
	public void validateArchive() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify when user click on the Archive icon, and the loan is moved to the Pipeline Archive page.")
					.assignCategory(pipeline_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Generate string of 4 or 5 characters starting with '1 A'
			String generatedInternalReference = Utils.generateString();

			// Output the generated string
			System.out.println("Generated String: " + generatedInternalReference);

			// Update created loan internal reference number on excel
			updateDataOnExcel(32, generatedInternalReference);

			// Create loan
			PipelinePage.createLoanInPipeline(generatedInternalReference);

			// Click on the move to pipeline archive and wait for popup
			Utils.clickAndWait(PipelinePO.moveToPipelineArchiveButton, "Move to pipeline archive", UtilsPO.popUp);
			node.log(Status.INFO, "STEP1 : Clicked on the move to pipeline archive");
			System.out.println("STEP1 : Clicked on the move to pipeline archive");

			// Click on the move button
			IElementActions.clickelement_usingXpath(node, driver, PipelinePO.moveButton);
			node.log(Status.INFO, "STEP2 : Clicked on the move button");
			System.out.println("STEP2 : Clicked on the move button");

			// Wait for the visibility of the PopUp
			node.log(Status.INFO, "STEP3 : Waiting for the visibility of the popup");
			System.out.println("STEP3 : Waiting for the visibility of the popup");
			IWaitStrategy.waitForVisiblity(node, driver, UtilsPO.popUp);
			node.log(Status.INFO, "STEP4 : Popup is visible");
			System.out.println("STEP4 : Popup is visible");

			// Click on popup close button
			IElementActions.clickelement_usingXpath(node, driver, PipelinePO.closeButtonInPopup);
			node.log(Status.INFO, "STEP5 : Clicked on the close icon");
			System.out.println("STEP5 : Clicked on the close icon");

			// Wait for the invisibility of the PopUp
			node.log(Status.INFO, "STEP6 : Waiting for the invisibility of the popup");
			System.out.println("STEP6 : Waiting for the invisibility of the popup");
			IWaitStrategy.waitForInVisiblity(node, driver, UtilsPO.popUp);
			node.log(Status.INFO, "STEP7 : Popup is not visible");
			System.out.println("STEP7 : Popup is not visible");

			// Wait for the visibility of Pipeline Archive page
			node.log(Status.INFO, "STEP8 : Waiting for the visibility of Pipeline Archive page");
			System.out.println("STEP8 : Waiting for the visibility of Pipeline Archive page");
			IWaitStrategy.waitForVisiblity(node, driver, PipelinePO.archiveHeaderText);
			node.log(Status.INFO, "STEP9 : Pipeline Archive page is visible");
			System.out.println("STEP9 : Pipeline Archive page is visible");

			// Click on the internal reference column header to sort
			IElementActions.clickelement_usingXpath(node, driver, PipelinePO.internalReferenceColumnHeader);
			node.log(Status.INFO, "STEP10 : Clicked on the internal reference column header to sort");
			System.out.println("STEP10 : Clicked on the internal reference column header to sort");

			// Wait for the visibility of record
			node.log(Status.INFO, "STEP11 : Waiting for the visibility of record");
			System.out.println("STEP11 : Waiting for the visibility of record");
			IWaitStrategy.waitForVisiblity(node, driver, PipelinePO.firstRowInternalReference);
			node.log(Status.INFO, "STEP12 : Record is visible");
			System.out.println("STEP12 : Record is visible");

			// Create locator based on the internal reference
			String internalReferenceLocator = IElementActions.createDynamicLocatorString(
					PipelinePO.dynamicInternalReference, "locator", generatedInternalReference);

			// Get internal reference
			String firstRowArchiveInternalRef = IElementActions.getElementText_usingXpath(node, driver,
					internalReferenceLocator);

			if (firstRowArchiveInternalRef.equalsIgnoreCase(generatedInternalReference)) {
				Assert.assertTrue(true, firstRowArchiveInternalRef + "The loan is moved to the Pipeline Archive page.");
				System.out.println(firstRowArchiveInternalRef + "The loan is moved to the Pipeline Archive page.");
				node.log(Status.PASS, firstRowArchiveInternalRef + "The loan is moved to the Pipeline Archive page.");

				// Click on the delete icon and wait for popup
				Utils.clickAndWait(PipelinePO.deleteIcon, "Delete", UtilsPO.popUp);
				node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on the delete icon");
				System.out.println("SUB-STEP_0.001 : Clicked on the delete icon");

				// Wait for the visibility of delete button
				node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of delete button");
				System.out.println("SUB-STEP_0.002 : Waiting for the visibility of delete button");
				IWaitStrategy.waitForVisiblity(node, driver, PipelinePO.deleteButton);
				node.log(Status.INFO, "SUB-STEP_0.003 : Delete button is visible");
				System.out.println("SUB-STEP_0.003 : Delete button is visible");

				// Click on the delete button
				IElementActions.clickelement_usingXpath(node, driver, PipelinePO.deleteButton);
				node.log(Status.INFO, "SUB-STEP_0.004 : Clicked on the delete button");
				System.out.println("SUB-STEP_0.004 : Clicked on the delete button");

				// Wait for the visibility of close button
				node.log(Status.INFO, "SUB-STEP_0.005 : Waiting for the visibility of close button");
				System.out.println("SUB-STEP_0.005 : Waiting for the visibility of close button");
				IWaitStrategy.waitForVisiblity(node, driver, PipelinePO.closeButtonInPopup);
				node.log(Status.INFO, "SUB-STEP_0.006 : Close button is visible");
				System.out.println("SUB-STEP_0.006 : Close button is visible");

				// Click on popup close button
				IElementActions.clickelement_usingXpath(node, driver, PipelinePO.closeButtonInPopup);
				node.log(Status.INFO, "SUB-STEP_0.007 : Clicked on the close button");
				System.out.println("SUB-STEP_0.007 : Clicked on the close button");
			} else {
				Assert.assertTrue(false, firstRowArchiveInternalRef + " loan is displayed in the archive page,"
						+ generatedInternalReference + " is not moved to the Pipeline Archive page.");
				System.out.println(firstRowArchiveInternalRef + " loan is displayed in the archive page,"
						+ generatedInternalReference + " is not moved to the Pipeline Archive page.");
				node.log(Status.FAIL, firstRowArchiveInternalRef + " loan is displayed in the archive page,"
						+ generatedInternalReference + " is not moved to the Pipeline Archive page.");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateArchive", "Pass", driver);

		} catch (AssertionError validateArchive) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateArchive test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateArchive_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateArchive.printStackTrace();
			node.fail(validateArchive);
			Assert.fail();
			extent.flush();
		} catch (Exception validateArchive) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateArchive test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateArchive_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateArchive.printStackTrace();
			node.fail(validateArchive);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Pipeline_Database_021
	@Test(priority = 6)
	public void validateEditButtonNavigation() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify user is able to edit the loan by clicking on the Edit icon, and it takes them back to the input section of the Loan section for that loan i.e. Edit loan page. ")
					.assignCategory(pipeline_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadDatabasePage from PipelinePage
			PipelinePage.loadDatabasePage();

			// Wait for the visibility of record
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of record");
			System.out.println("STEP1 : Waiting for the visibility of record");
			IWaitStrategy.waitForVisiblity(node, driver, PipelinePO.firstRowInternalReference);
			node.log(Status.INFO, "STEP2 : Record is visible");
			System.out.println("STEP2 : Record is visible");

			// Get internal reference
			String firstRowInternalRef = IElementActions.getElementText_usingXpath(node, driver,
					PipelinePO.firstRowInternalReference);

			// Open loan by clicking edit icon
			PipelinePage.openPipelineLoanByUsingEditIcon();

			// Get internal reference
			String internalRef = IElementActions.getElementValue(node, driver, PipelinePO.internalReference);

			if (firstRowInternalRef.equalsIgnoreCase(internalRef)) {

				Assert.assertTrue(true, firstRowInternalRef + "The loan is moved to the Pipeline Archive page.");
				System.out.println(firstRowInternalRef + "The loan is moved to the Pipeline Archive page.");
				node.log(Status.PASS, firstRowInternalRef + "The loan is moved to the Pipeline Archive page.");

			} else {
				Assert.assertTrue(false, firstRowInternalRef + " loan is displayed in the archive page," + internalRef
						+ " is not moved to the Pipeline Archive page.");
				System.out.println(firstRowInternalRef + " loan is displayed in the archive page," + internalRef
						+ " is not moved to the Pipeline Archive page.");
				node.log(Status.FAIL, firstRowInternalRef + " loan is displayed in the archive page," + internalRef
						+ " is not moved to the Pipeline Archive page.");
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateEditButtonNavigation", "Pass", driver);

		} catch (AssertionError validateEditButtonNavigation) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateEditButtonNavigation test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateEditButtonNavigation_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateEditButtonNavigation.printStackTrace();
			node.fail(validateEditButtonNavigation);
			Assert.fail();
			extent.flush();
		} catch (Exception validateEditButtonNavigation) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateEditButtonNavigation test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateEditButtonNavigation_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateEditButtonNavigation.printStackTrace();
			node.fail(validateEditButtonNavigation);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Pipeline_Database_022
	@Test(priority = 7)
	public void validateEdit() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify user is able to edit the the loan and then Save the loan information.")
					.assignCategory(pipeline_tag + "_" + env);
			node = extenttest.createNode("Report");

			IElementActions.pageRefresh();

			// Calling the loadDatabasePage from PipelinePage
			PipelinePage.loadDatabasePage();

			// Get internal reference
			String internalRefExpected = "test" + IElementActions.getRandomNumber();

			// Open loan by clicking edit icon
			PipelinePage.openPipelineLoanByUsingEditIcon();

			// Enter the value in internal reference
			IElementActions.clearAndInputElementUsingAction_Xpath(node, driver, PipelinePO.internalReference,
					internalRefExpected);

			// Save loan
			Utils.saveLoan();

			// Get internal reference
			String internalRefActual = IElementActions.getElementValue(node, driver, PipelinePO.internalReference);

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
			IScreenAction.captureScreenShot_PassCase("validateEdit", "Pass", driver);

		} catch (AssertionError validateEdit) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateEdit test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateEdit_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateEdit.printStackTrace();
			node.fail(validateEdit);
			Assert.fail();
			extent.flush();
		} catch (Exception validateEdit) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateEdit test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validateEdit_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateEdit.printStackTrace();
			node.fail(validateEdit);
			Assert.fail();
			extent.flush();
		}
	}

	// TC_Pipeline_Database_023
	@Test(priority = 8)
	public void validateMoveToBridgeLoanDatabase() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify user is able to edit the the loan and move the loan to the Bridge Loan Database page under Loans module")
					.assignCategory(pipeline_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Calling the loadDatabasePage from PipelinePage
			PipelinePage.loadDatabasePage();

			// Open loan by clicking edit icon
			PipelinePage.openPipelineLoanByUsingEditIcon();

			// Get internal reference
			String internalRef = IElementActions.getElementValue(node, driver, PipelinePO.internalReference);

			// Click on the move to bridge loan database button
			Utils.clickAndWait(PipelinePO.moveToBridgeLoanDatabaseButton, "Move to bridge loan database",
					UtilsPO.popUp);
			node.log(Status.INFO, "STEP1 : Clicked on the move to bridge loan database");
			System.out.println("STEP1 : Clicked on the move to bridge loan database");

			// Click on popup close button
			IElementActions.clickelement_usingXpath(node, driver, PipelinePO.closeButtonInPopup);
			node.log(Status.INFO, "STEP2 : Clicked on the close icon");
			System.out.println("STEP2 : Clicked on the close icon");

			// Wait for the invisibility of the PopUp
			node.log(Status.INFO, "STEP3 : Waiting for the invisibility of the popup");
			System.out.println("STEP3 : Waiting for the invisibility of the popup");
			IWaitStrategy.waitForInVisiblity(node, driver, UtilsPO.popUp);
			node.log(Status.INFO, "STEP4 : Popup is not visible");
			System.out.println("STEP4 : Popup is not visible");

			// Wait for the visibility of the Bridge Loan Header Text
			node.log(Status.INFO, "STEP5 : Waiting for the visibility of the bridge loan page");
			System.out.println("STEP5 : Waiting for the visibility of the bridge loan page");
			IWaitStrategy.waitForVisiblity(node, driver, LoansNewLoanPO.editBridgeLoanHeaderText);
			node.log(Status.INFO, "STEP6 : Bridge loan page is visible");
			System.out.println("STEP6 : Bridge loan page is visible");

			Thread.sleep(2000);
			String currentUrl = IElementActions.getCurrentUrl(node, driver);

			// Assert that Borrower page is visible
			if (currentUrl.contains("borrower")) {
				Assert.assertTrue(true, internalRef + " loan is moved to the bridge loan database");
				System.out.println(internalRef + " loan is moved to the bridge loan database");
				node.log(Status.PASS, internalRef + " loan is moved to the bridge loan database");

			} else {
				Assert.assertTrue(false,
						internalRef + " loan is not moved to the bridge loan database, and url is " + currentUrl);
				System.out.println(
						internalRef + " loan is not moved to the bridge loan database, and url is " + currentUrl);
				node.log(Status.FAIL,
						internalRef + " loan is not moved to the bridge loan database, and url is " + currentUrl);
			}

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("validateMoveToBridgeLoanDatabase", "Pass", driver);

		} catch (AssertionError validateMoveToBridgeLoanDatabase) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateMoveToBridgeLoanDatabase test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateMoveToBridgeLoanDatabase_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMoveToBridgeLoanDatabase.printStackTrace();
			node.fail(validateMoveToBridgeLoanDatabase);
			Assert.fail();
			extent.flush();
		} catch (Exception validateMoveToBridgeLoanDatabase) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateMoveToBridgeLoanDatabase test in DatabaseTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateMoveToBridgeLoanDatabase_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateMoveToBridgeLoanDatabase.printStackTrace();
			node.fail(validateMoveToBridgeLoanDatabase);
			Assert.fail();
			extent.flush();
		}
	}
}
