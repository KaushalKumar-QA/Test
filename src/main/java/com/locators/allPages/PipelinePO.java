package com.locators.allPages;

public interface PipelinePO {

	// Pipeline New Loan
	String pipelineNewLoanText = "//h3[text()=' New Pipeline ']";
	String internalReference = "//div[@id='INTERNAL_REFERENCE']//input";
	String moveToBridgeLoanDatabaseButton = "//button[text()=' Move to Bridge Loan Database']";
	String moveToPipelineArchiveButton = "//button[text()=' Move to Pipeline Archive']";

	// Pipeline Loan
	String pipelineLoanText = "//h3[text()=' Edit Pipeline ']";
	String moveButton = "//button[text()='Move']";
	String closeButtonInPopup = "//button[text()=' Close ']";

	// Pipeline Database
	String pipelineDatabaseText = "//h3[text()=' Pipeline Database ']";
	String pipelineDatabaseTable = "//tbody[@class='ui-table-tbody']";
	String editIcon = "//button[@mattooltip='Edit']";
	String archiveIcon = "//button[@mattooltip='Move to Archive']";

	// Pipeline Archive
	String archiveHeaderText = "//h3[text()=' Pipeline Archive ']";
	String internalReferenceColumnHeader = "//th[text()=' Internal Reference ']";
	String firstRowInternalReference = "//tbody//tr[contains(@class,'ng-star-inserted')][1]//td[2]";
	String dynamicInternalReference = "//td[text()=' locator ']";
	String deleteIcon = "//button[@mattooltip='Delete']";
	String deleteButton = "//button[text()='Delete']";

}
