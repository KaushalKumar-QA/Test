package com.locators.allPages;

public interface FundingNewFacilityPO {

	String editLoanFacilityText = "//h3[text()=' Edit Loan Facility ']";
	String internalReference = "//div[contains(@class,'right')]//p[contains(@class,'m')]";
	String reference = "(//th[text()=' Reference ']//ancestor::thead//tr[2]//th//input[contains(@class,'ui-inputtext')])[2]";

	// Summary Tab
	String summaryTab = "//a[text()=' Summary ']";
	String loanFacilitySummaryTextHeader = "//h3[text()=' Loan Facility Summary ']";
	String loanFacilitySummaryText = "//h3[text()='Facility Summary']";
	String summarySaveButton = "//button[contains(text(),'Save')]";
	String popupCloseButton = "//button[@class='btn cancel-btn']";

	// Summary Tab - Facility Summary
	String facilitySummaryHeader = "//h3[text()='Facility Summary']";
	String facilityAmountValue = "//th[text()='Facility Amount']//following-sibling::td";

	// Summary Tab - Current Drawdown
	String cashValue = "//th[text()='Cash']//following-sibling::td";
	String bridgeLoansValue = "//th[text()='Bridge Loans']//following-sibling::td";
	String cashRateValue = "//th[text()='Cash Rate']//following-sibling::td";
	String utilisationValue = "//th[text()='Utilisation']//following-sibling::td";

	// New Facility page
	String newFacilityPageHeader = "//h3[@class='m-portlet__head-text']";
	String loanFacilityStatus = "(//div[contains(@class,'m-portlet__body')]//p)[1]";
	String internalReferenceText = "//div[@class='form-group row']/label[@for='name']";
	String lenderTab = "//a[contains(text(),'Lender')]";
	String facilityTab = "//a[text()=' Facility ']";
	String collateralTab = "//a[text()=' Collateral ']";
	String facilityStatusTab = "//a[text()=' Facility Status ']";
	String accountBalancesTab = "//a[text()=' Account Balances ']";
	String documentsTab = "//a[text()=' Documents ']";
	String cashflowsTab = "//a[text()=' Cashflows ']";
	String transactionLogTab = "//a[text()=' Transaction Log ']";
	String facilityHistoryTab = "//a[text()=' Facility History ']";

	// Facility Tab
	String amountInputField = "//m-amount-input//input";
	String availableAmount = "//label[text()='Available Amount']//following-sibling::div//p";
	String nextButton = "//button[text()=' Next']";

	// Facility Status Tab
	String error = "//span[contains(@class,'error')]";
	String deleteButton = "//button[text()='Delete']";
	String confirmButton = "//button[text()=' Confirm']";
	String effectiveDate = "//label[text()=' Effective Date']//following-sibling::div//input";
	String firstColumnPortfolioValues = "//table[contains(@class,'display-info')]//tr[not(contains(@class, 'ng-star-inserted'))]//td[(contains(@class, 'limit-respected')) or (contains(@class, 'error-limit'))]";
	String portfolioValues = "//table[contains(@class,'display-info')]//tr[not(contains(@class, 'ng-star-inserted'))]//td[not(contains(@class, 'limit-respected')) and not(contains(@class, 'error-limit'))]";
	String firstColumnRegionalLimitValues = "//th[contains(text(),'Regional limits')]//parent::tr//following-sibling::tr//td[(contains(@class, 'limit-respected')) or (contains(@class, 'error-limit'))]";
	String regionalLimitValues = "//th[contains(text(),'Regional limits')]//parent::tr//following-sibling::tr//td[not(contains(@class, 'limit-respected')) and not(contains(@class, 'error-limit'))]";

	// Facility Status Tab - drawdowns
	String drawdownsSection = "//th[text()='Drawdowns']";
	String newDrawdownButton = "//button[text()='New Drawdown']";
	String drawdownDateCloumn = "//th[text()='Drawdowns']/ancestor::table/following-sibling::table//th[text()='Date']";
	String drawdownAmountCloumn = "//th[text()='Drawdowns']/ancestor::table/following-sibling::table//th[text()='Amount']";
	String drawdownDateInputField = "//label[text()='Date']//following-sibling::input";
	String drawdownAmountInputField = "//input[contains(@class,'m-input')]";
	String drawdownSaveButton = "//button[text()='Save']";
	String firstRowDrawdown = "//th[text()='Drawdowns']//ancestor::table//following-sibling::table//tr[2]";
	String firstRowAmount = "(//th[text()='Amount']//parent::tr//following-sibling::tr//td)[2]";
	String firstRowDate = "//th[text()='Amount']//parent::tr//following-sibling::tr[1]//td[1]";
	String secondRowDate = "//th[text()='Amount']//parent::tr//following-sibling::tr[2]//td[1]";
	String drawdownsAmount = "//th[text()='Drawdowns']//ancestor::table//following-sibling::table//tr//td[2]";
	String editIcon = "(//a[@title='Edit'])[1]";
	String confirmIcon = "(//a[@title='Confirm'])[1]";
	String deleteIcon = "(//a[@title='Delete'])[1]";
	String isConfirmed = "(//i[@title='Is confirmed?'])[1]";

	// Facility Status Tab - Repayments
	String repaymentSection = "//th[text()='Repayments']";
	String newRepaymentButton = "//button[text()='New Repayment']";
	String repaymentDateColumn = "//th[text()='Repayments']/ancestor::table/following-sibling::table//th[text()='Date']";
	String repaymentAmountCloumn = "//th[text()='Repayments']/ancestor::table/following-sibling::table//th[text()='Amount']";
	String repaymentDateInputField = "//label[text()='Date']/../input";
	String repaymentAmountInputField = "//input[contains(@class,'form-control m-input')]";
	String repaymentSaveButton = "//button[text()='Save']";
	String firstRowRepayment = "//th[text()='Repayments']//ancestor::table//following-sibling::table//tr[2]";
	String firstRowRepaymentAmount = "//th[text()='Repayments']//ancestor::table//following-sibling::table//tr[2]//td[2]";
	String firstRowRepaymentDate = "//th[text()='Repayments']//ancestor::table//following-sibling::table//tr[2]//td[1]";
	String repaymentsAmount = "//th[text()='Repayments']//ancestor::table//following-sibling::table//tr//td[2]";
	String editIconRepayment = "//th[text()='Repayments']//ancestor::table//following-sibling::table//tr[2]//td[4]//a[@title='Edit']";
	String confirmIconRepayment = "//th[text()='Repayments']//ancestor::table//following-sibling::table//tr[2]//td[4]//a[@title='Confirm']";
	String confirmIconRepaymentSecond = "//th[text()='Repayments']//ancestor::table//following-sibling::table//tr[3]//td[4]//a[@title='Confirm']";
	String deleteIconRepayment = "//th[text()='Repayments']//ancestor::table//following-sibling::table//tr[2]//td[4]//a[@title='Delete']";
	String isConfirmedRepayment = "(//th[text()='Repayments']//ancestor::table//following-sibling::table//tr//i[@title='Is confirmed?'])[1]";

	// Account Balances
	String balanceText = "//h5[text()='Balance']";
	String firstRowDateInAccountBalance = "(//td[1])[1]";
	String firstRowPayment = "(//td[3])[1]";
	String firstRowReceipt = "(//td[4])[1]";
	String interestUnderAccountBalance = "//button[text()='Interest ']";
	String oneYear = "//button[text()='1Y']";
	String dynamicInterestAmountValue = "//td[text()='locatorValue ']";

	// Documents
	String documentsHeaderText = "//div[text()='Upload Type']";
	String single = "//input[@value='SINGLE']//parent::label";
	String description = "//label[text()=' New Document']//following-sibling::div//input[@placeholder='Description']";
	String upload = "//input[@name='photo']";
	String uploadedFileRow = "//div[contains(@class,'input-group')]";
	String deleteDocument = "//a[@title='Delete']";

}
