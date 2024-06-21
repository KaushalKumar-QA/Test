package com.locators.allPages;

public interface SideMenuPO {

	// Header
	String headerUserName = "//span[@class='m-topbar__userpic']//parent::a[contains(@class,'m-nav__link')]";
	String logout = "//span[contains(text(),'Logout ')]";

	// Administration
	String administration = "//span[text()=' Administration ']";
	String users = "//span[text()=' Users ']";
	String database = "//span[text()=' Users ']//parent::a//following-sibling::div//span[text()=' Database ']";

	// Pipeline
	String pipeline = "(//span[text()=' Pipeline '])[1]";
	String calculator = "//span[text()=' Pipeline ']//parent::a//following-sibling::div//span[text()=' Calculator ']";
	String pipelineNewLoan = "//span[text()=' Pipeline ']//parent::a//following-sibling::div//span[text()=' New Loan ']";
	String pipelineDatabase = "//span[text()=' Pipeline ']//parent::a//following-sibling::div//span[text()=' Database ']";
	String pipelineArchive = "//span[text()=' Pipeline ']//parent::a//following-sibling::div//span[text()=' Archive ']";

	// Loans
	String loans = "(//span[text()=' Loans '])[1]";
	String newLoan = "//span[text()=' Loans ']//parent::a//following-sibling::div//span[text()=' New Loan ']";
	String loansDatabase = "//span[text()=' Loans ']//parent::a//following-sibling::div//span[text()=' Database ']";

	// Funding
	String funding = "(//span[text()=' Funding '])[1]";
	String calculateInterest = "//span[text()=' Calculate Interest ']";
	String interestPayment = "//span[text()=' Interest Payment ']";
	String fundingDatabase = "//span[text()=' Funding ']//parent::a//following-sibling::div//span[text()=' Database ']";
	String fundingNewFacility = "//span[contains(text(),'Funding')]/ancestor::li//span[text()=' New Facility ']";
	String fundingOverdueInterest = "//span[contains(text(),'Funding')]/ancestor::li//span[text()=' Overdue Interest ']";
	String fundingManagementAccounts = "//span[text()=' Funding ']//parent::a//following-sibling::div//span[text()=' Management Accounts ']";

	// Treasury
	String treasury = "(//span[text()=' Treasury '])[1]";
	String singleTreasury = "(//span[text()=' Single '])[1]";
	String portfolioTreasury = "(//span[text()=' Portfolio '])[1]";
	String databaseTreasury = "//span[text()=' Treasury ']//ancestor::li//div//span[text()=' Database ']";
	String historyTreasury = "(//span[text()=' History '])[1]";
	String manageAllocationsTreasury = "(//span[text()=' Manage Allocations '])[1]";
	String initalAllocationTreasury = "(//span[text()=' Initial Allocation '])[1]";

	// Reporting
	String reporting = "//span[text()=' Reporting ']//parent::a";
	String update = "//span[text()=' Updates ']//parent::a";
	String balanceSheet = "//span[text()=' Balance Sheet ']//parent::a";
	String reportingLoans = "(//span[text()=' Loans '])[2]//parent::a";
	String Loans = "//span[text()=' Reporting ']//parent::a//following-sibling::div//span[text()=' Loans ']//parent::a";
	String reportingManagementAccounts = "//span[text()=' Reporting ']//parent::a//following-sibling::div//span[text()=' Management Accounts ']";
}
