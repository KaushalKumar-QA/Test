package com.locators.allPages;

public interface ReportingManagementAccountsPO {

	String managementAccountsText = "//h3[text()=' Management Accounts ']";
	String saveDraft = "//ngb-alert[text()=' Save Draft ']//parent::div";
	String searchByDate = "//label[text()='Search by Date']//following-sibling::select";

	String interestCashflows = "//a[text()=' Interest Cashflows ']";
	String capitalRepayments = "//a[text()=' Capital Repayments ']";

	String calculationPeriod = "//span[text()='Calculation Period']//following-sibling::span";

	// Interest analysis
	String interestAnalysisText = "//strong[text()='Interest Analysis']//parent::h4";
	String newInterestMarginColumn = "//h3[text()='Net Interest Margin ']";
	String netInterestMargin = "//h3[text()='Net Interest Margin ']//ancestor::div[@class='m-portlet__head-caption']//following-sibling::div//strong";

	// Interest income
	String interestIncomeColumn = "//h3[text()='Interest Income']";
	String interestIncome = "//h3[text()='Interest Income']//ancestor::div[@class='m-portlet__head-caption']//following-sibling::div//strong";
	String grossInterestIncome = "//strong[text()='Gross Interest Income']//parent::p//parent::div//following-sibling::div//strong";
	String regularInterest = "(//p[text()='Regular Interest']//parent::div//following-sibling::div//p)[1]";
	String deferredInterestReceived = "(//p[text()='Deferred Interest Received']//parent::div//following-sibling::div//p)[1]";

	// Interest Expense
	String interestExpenseColumn = "//h3[text()='Interest Expense']";
	String interestExpense = "//h3[text()='Interest Expense']//ancestor::div[@class='m-portlet__head-caption']//following-sibling::div//strong";
	String totalFacilityPayments = "//strong[text()='Total Facility Payments']//parent::p//parent::div//following-sibling::div//strong";
	String regularInterestOfInterestExpense = "(//p[text()='Regular Interest']//parent::div//following-sibling::div//p)[2]";
	String cashInterest = "//p[text()='Cash Interest']//parent::div//following-sibling::div//p";
	String defaultInterest = "//p[text()='Default Interest']//parent::div//following-sibling::div//p";
	String tax = "//p[text()='Tax']//parent::div//following-sibling::div//p";
	String withholdingTaxOfInterestExpense = "//strong[text()='Withholding Tax']//parent::p//parent::div//following-sibling::div//strong";

	// Cashflows
	String cashflows = "//strong[text()='Cashflows']//parent::h4";
	String cashflowsTable = "//strong[text()='Cashflows']//parent::h4//parent::div//following-sibling::div";
	String details = "//h6[text()='Details']";
	String facilityName = "//th[text()=' Facility Name ']";
	String companyName = "//th[text()=' Company Name ']";
	String interestThisMonth = "//h6[text()='Interest This Month']";
	String regular = "//th[text()=' Regular ']";
	String cash = "//th[text()=' Cash ']";
	String deferredReleased = "//th[text()=' Deferred Released ']";
	String standardRateDeferred = "//th[text()=' Standard Rate Deferred ']";
	String deferredBF = "//th[text()=' Deferred B/F ']";
	String totals = "//h6[text()='Totals']";
	String amountCF = "//th[text()=' Amount C/F ']";
	String grossPayable = "//th[text()=' Gross Payable ']";
	String netPayable = "//th[text()=' Net Payable ']";
	String withholdingTax = "//th[text()=' Withholding Tax ']";
	String deferredPayments = "//th[text()=' Deferred Payments ']";
	String confirmations = "//h6[text()='Confirmations']";
	String cashflowsConfirmed = "//th[text()=' Cashflows Confirmed ']";

	String grossPayableCashflowLoans = "//span[text()='Loans']//parent::div//parent::td//following-sibling::td[@title='Gross Payable']";
	String regularInterestCashflowLoans = "//span[text()='Loans']//parent::div//parent::td//following-sibling::td[@title='Regular']";
	String deferredReleasedCashflowLoans = "//span[text()='Loans']//parent::div//parent::td//following-sibling::td[@title='Deferred Released']";

	String netPayableCashflowPortfolio = "//span[text()='Portfolio']//parent::div//parent::td//following-sibling::td[@title='Net Payable']";
	String regularCashflowPortfolio = "//span[text()='Portfolio']//parent::div//parent::td//following-sibling::td[@title='Regular']";
	String cashCashflowPortfolio = "//span[text()='Portfolio']//parent::div//parent::td//following-sibling::td[@title='Cash']";
	String deferredReleasedCashflowPortfolio = "//span[text()='Portfolio']//parent::div//parent::td//following-sibling::td[@title='Deferred Released']";
	String withholdingTaxCashflowPortfolio = "//span[text()='Portfolio']//parent::div//parent::td//following-sibling::td[@title='Withholding Tax']";

	String facilitiesName = "//span[text()='Portfolio']//parent::div//parent::td//parent::tr//following-sibling::tr//td[@title='Facility Name']";
	String regularOfFacilities = "//span[text()='Portfolio']//parent::div//parent::td//parent::tr//following-sibling::tr//td[@title='Regular']";
	String cashOfFacilities = "//span[text()='Portfolio']//parent::div//parent::td//parent::tr//following-sibling::tr//td[@title='Cash']";
	String deferredReleasedOfFacilities = "//span[text()='Portfolio']//parent::div//parent::td//parent::tr//following-sibling::tr//td[@title='Deferred Released']";
	String grossPayableOfFacilities = "//span[text()='Portfolio']//parent::div//parent::td//parent::tr//following-sibling::tr//td[@title='Gross Payable']";
	String netPayableOfFacilities = "//span[text()='Portfolio']//parent::div//parent::td//parent::tr//following-sibling::tr//td[@title='Net Payable']";
	String withholdingTaxOfFacilities = "//span[text()='Portfolio']//parent::div//parent::td//parent::tr//following-sibling::tr//td[@title='Withholding Tax']";

}
