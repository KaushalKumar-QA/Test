package com.qa.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.aventstack.extentreports.Status;
import com.locators.allPages.PipelinePO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.url.AllPagesUrl;

public class PipelinePage extends Baseclass {

	public static void loadDatabasePage() {
		// Open the Pipeline Database
		node.log(Status.INFO, "SUB-STEP_0.001 : Opening the Database page under Pipeline");
		System.out.println("SUB-STEP_0.001 :  Opening the Database page under Pipeline");
		driver.get(AllPagesUrl.pipelineDatabasePage);
		// Wait for the visibility of Pipeline Database page
		node.log(Status.INFO, "STEP1 : Waiting for the visibility of Pipeline Database page");
		System.out.println("STEP1 : Waiting for the visibility of Pipeline Database page");
		IWaitStrategy.waitForVisiblity(node, driver, PipelinePO.pipelineDatabaseText);
		IWaitStrategy.waitForVisiblity(node, driver, PipelinePO.editIcon);
		node.log(Status.INFO, "STEP2 : Pipeline Database page is visible");
		System.out.println("STEP2 : Pipeline Database page is visible");
	}

	public static void loadArchivePage() {
		// Open the Pipeline Database
		node.log(Status.INFO, "SUB-STEP_0.001 : Opening the Archive page under Pipeline");
		System.out.println("SUB-STEP_0.001 :  Opening the Archive page under Pipeline");
		driver.get(AllPagesUrl.pipelineArchivePage);
		// Wait for the visibility of Pipeline Archive page
		node.log(Status.INFO, "STEP1 : Waiting for the visibility of Pipeline Archive page");
		System.out.println("STEP1 : Waiting for the visibility of Pipeline Archive page");
		IWaitStrategy.waitForVisiblity(node, driver, PipelinePO.archiveHeaderText);
		node.log(Status.INFO, "STEP2 : Pipeline Archive page is visible");
		System.out.println("STEP2 : Pipeline Archive page is visible");
	}

	// Method to extract loan number using regular expressions
	public static String extractLoanNumber(String url) {
		Pattern pattern = Pattern.compile("/PL/(\\w+)/");
		Matcher matcher = pattern.matcher(url);
		if (matcher.find()) {
			return matcher.group(1);
		} else {
			return null; // Return null if no match is found
		}
	}

	public static void createLoanInPipeline(String internalReference)
			throws InterruptedException, FileNotFoundException, IOException {
		// Open the Pipeline Database
		node.log(Status.INFO, "SUB-STEP_0.001 : Opening the new pipeline page");
		System.out.println("SUB-STEP_0.001 :  Opening the new pipeline page");
		driver.get(AllPagesUrl.newPipelinePage);

		// Wait for the visibility of new pipeline page
		node.log(Status.INFO, "STEP1 : Waiting for the visibility of new pipeline page");
		System.out.println("STEP1 : Waiting for the visibility of new pipeline page");
		IWaitStrategy.waitForVisiblity(node, driver, PipelinePO.pipelineNewLoanText);
		node.log(Status.INFO, "STEP2 : New pipeline page is visible");
		System.out.println("STEP2 : New pipeline page is visible");

		// Enter the value in internal reference
		IElementActions.sendKeys_usingXpath(node, driver, PipelinePO.internalReference, internalReference);
		node.log(Status.INFO, "SUB-STEP_0.004 : Entered the value in internal search");
		System.out.println("SUB-STEP_0.004 : Entered the value in internal search");

		// Save loan
		Utils.saveLoan();

		Thread.sleep(2000);
		// Get the current URL
		String currentUrl = driver.getCurrentUrl();

		// Extract the loan number from the URL using regular expressions
		String loanNumber = PipelinePage.extractLoanNumber(currentUrl);
		node.log(Status.INFO, "SUB-STEP_0.006 : Loan number is " + loanNumber);
		System.out.println("SUB-STEP_0.006 : Loan number is " + loanNumber);

		// Update created loan number on excel
		updateDataOnExcel(31, loanNumber);
	}

	public static void openPipelineLoanByUsingEditIcon() {
		// Click on the edit button
		IElementActions.clickelement_usingXpath(node, driver, PipelinePO.editIcon);
		node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on the edit");
		System.out.println("SUB-STEP_0.001 : Clicked on the edit");

		// Wait for the visibility of pipeline loan page
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of pipeline loan page");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of pipeline loan page");
		IWaitStrategy.waitForVisiblity(node, driver, PipelinePO.pipelineLoanText);
		node.log(Status.INFO, "SUB-STEP_0.003 : Pipeline loan page is visible");
		System.out.println("SUB-STEP_0.003 : Pipeline loan page is visible");
	}

}
