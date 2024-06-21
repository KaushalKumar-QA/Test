package com.qa.url;

import com.qa.paths.BaseclassPaths;

public interface AllPagesUrl {

	String loginPage = "http://stagingcdn.lenddirect.io/bridgeLoan/login.html#/";
	String userDatabasePage = "https://" + BaseclassPaths.environmentUrl
			+ ".lenddirect.io/bridgeLoan/private/index.html#/admin/user-list";

	// Pipeline
	String newPipelinePage = "https://" + BaseclassPaths.environmentUrl
			+ ".lenddirect.io/bridgeLoan/private/index.html#/" + "pipeline/PL/new/input?reset=true";
	String pipelineDatabasePage = "https://" + BaseclassPaths.environmentUrl
			+ ".lenddirect.io/bridgeLoan/private/index.html#/" + "pipeline/pipelineReport";
	String pipelineArchivePage = "https://" + BaseclassPaths.environmentUrl
			+ ".lenddirect.io/bridgeLoan/private/index.html#/" + "pipeline/pipelineArchive";

	// Loans
	String newLoanPage = "https://" + BaseclassPaths.environmentUrl + ".lenddirect.io/bridgeLoan/private/index.html#/"
			+ "bridge-loan/bl/new/borrower";

	// Database
	String databasePage = "https://" + BaseclassPaths.environmentUrl + ".lenddirect.io/bridgeLoan/private/index.html#/"
			+ "bridge-loan/bridgeLoanList";

	// Funding
	String interestPaymentPage = "https://" + BaseclassPaths.environmentUrl
			+ ".lenddirect.io/bridgeLoan/private/index.html#/" + "loan-facility/FacilityInterestPayment/compile";
	String interestPaymentHealthStepPage = "https://" + BaseclassPaths.environmentUrl
			+ ".lenddirect.io/bridgeLoan/private/index.html#/" + "loan-facility/FacilityInterestPayment/health";
	String calculateInterestPage = "https://" + BaseclassPaths.environmentUrl
			+ ".lenddirect.io/bridgeLoan/private/index.html#/" + "loan-facility/calculateInterest";
	String fundingDatabasePage = "https://" + BaseclassPaths.environmentUrl
			+ ".lenddirect.io/bridgeLoan/private/index.html#/" + "loan-facility/loanFacilityList";
	String fundingNewFacilityPage = "https://" + BaseclassPaths.environmentUrl
			+ ".lenddirect.io/bridgeLoan/private/index.html#/" + "loan-facility/lf/new/lender";
	String fundingManagementAccounts = "https://" + BaseclassPaths.environmentUrl
			+ ".lenddirect.io/bridgeLoan/private/index.html#/" + "loan-facility/managementAccount";

	// Treasury
	String TreasurySinglePage = "https://" + BaseclassPaths.environmentUrl
			+ ".lenddirect.io/bridgeLoan/private/index.html#/" + "loan-allocation/new-loan-allocation";
	String TreasuryPortfolioPage = "https://" + BaseclassPaths.environmentUrl
			+ ".lenddirect.io/bridgeLoan/private/index.html#/" + "loan-allocation/new-facility-allocation/step1";
	String TreasuryDatabasePage = "https://" + BaseclassPaths.environmentUrl
			+ ".lenddirect.io/bridgeLoan/private/index.html#/" + "loan-allocation/amend-allocations/selection";

	// Reporting
	String ReportingLoansPage = "https://" + BaseclassPaths.environmentUrl
			+ ".lenddirect.io/bridgeLoan/private/index.html#/" + "reporting/reporting-summary";
	String ReportingUpdatesPage = "https://" + BaseclassPaths.environmentUrl
			+ ".lenddirect.io/bridgeLoan/private/index.html#/" + "reporting/updates";
	String ReportingBalanceSheetPage = "https://" + BaseclassPaths.environmentUrl
			+ ".lenddirect.io/bridgeLoan/private/index.html#/" + "reporting/balance-sheet/live-balance-sheet";
	String reportingManagementAccounts = "https://" + BaseclassPaths.environmentUrl
			+ ".lenddirect.io/bridgeLoan/private/index.html#/" + "reporting/management-accounts/";
}
