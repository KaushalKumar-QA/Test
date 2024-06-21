package com.locators.allPages;

public interface ReportingBalanceSheetPO {

	String balanceSheetHeader = "//h3[text()=' Balance Sheet ']";
	String balanceSheetSummary = "//li//a[text()=' Balance Sheet Summary ']";
	String balanceSheetDetail = "//li//a[text()=' Balance Sheet Detail ']";
	String cashBalance = "//li//a[text()=' Cash Balance ']";
	String loanAccount = "//li//a[text()=' Loan Account ']";
	String fundingAccount = "//li//a[text()=' Funding Account ']";
	String amountCorrespondingToLoanOrFacility = "//a[text()=' locatorValue ']//parent::td//following-sibling::td";

	// Balance Sheet Summary page
	String asset = "//h5[text()='Asset']";
	String liabilities = "//h5[text()='Liabilities']";
	String loanAmount = "//h5[text()='Loan Amount']";
	String facilityAmount = "//h5[text()='Facilities Amount']";
	String cashAmount = "//h5[text()='Cash Amount']";
	String assetAmountValue = "//h5[text()='Asset']/parent::div/following-sibling::div/h4";
	String liabilitiesAmountValue = "//h5[text()='Liabilities']/parent::div/following-sibling::div/h4";
	String loanAmountValue = "//h5[text()='Loan Amount']/parent::div/following-sibling::div/h4";
	String cashAmountValue = "//h5[text()='Cash Amount']/parent::div/following-sibling::div/h4";
	String facilitiesAmountValue = " //h5[text()='Facilities Amount']/parent::div/following-sibling::div/h4";
	String loanBalanceAmountValue = "//h4[text()='Loan Balance']/parent::div//div[@class='m-portlet__head-tools ng-star-inserted']";
	String facilityBalanceAmountValue = "//h4[text()='Facility Balance']/parent::div//div[@class='m-portlet__head-tools ng-star-inserted']";

	// Spinner or progress bar
	String spinner = "//div[contains(@class,'spinner')]";
	String progressBar = "(//mat-progress-bar[@role='progressbar'])[1]";
	String loadingAfterSearch = "//ngx-loading//div";

	// Search By Month
	String searchByMonth = "//label[text()='Search by Month']";
	String searchByMonthInputField = "//label[text()='Search by Month']/parent::div//input";
	String allMonthsCalendar = "//div[contains(@class,'ui-monthpicker')]";
	String calendarPreviousArrrow = "//a[contains(@class,'ui-datepicker-prev')]";
	String calendarNextArrow = "//a[contains(@class,'ui-datepicker-next')]";
	String calendarYear = "//select[contains(@class,'ui-datepicker-year')]";
	String januaryMonth = "//a[contains(@class,'ui-monthpicker-month') and text()=' Jan ']";
	String searchByMonthSearchButton = "//label[text()='Search by Month']/parent::div//div[contains(@class,'btn btn-search')]";

	// Custom Search
	String customSearch = "//label[text()='Custom Search']";
	String customSearchField = "//input[contains(@class,'input-filter')]//parent::div";
	String customSearchInputField = "//input[contains(@class,'form-control m-input input-filter')]";
	String customSearchButton = "//label[text()='Custom Search']/parent::div//div[contains(@class,'btn btn-search')]";

	// Loan Balance
	String loanBalanceTable = "//h4[text()='Loan Balance']//parent::div";
	String loanBalanceInternalRefColumn = "//h4[text()='Loan Balance']/parent::div//th[contains(text(),'Internal Reference')]";
	String loanBalanceLoanRefColumn = "//h4[text()='Loan Balance']/parent::div//th[contains(text(),'Loan Ref')]";
	String loanBalanceAmountColumn = "//h4[text()='Loan Balance']/parent::div//th[contains(text(),'Amount')]";

	String loanBalanceInternalRefColumnValue = "//h4[text()='Loan Balance']/parent::div//td[2]/a";
	String loanBalanceLoanRefColumnValue = "//h4[text()='Loan Balance']/parent::div//td[3]/a";
	String loanBalanceAmountColumnValue = "//h4[text()='Loan Balance']/parent::div//td[4]/div";
	String loanBalanceDisbursementsColumnValue = "//h4[text()='Loan Balance']/parent::div//td[5]/div";
	String loanBalanceRepaymentsColumnValue = "//h4[text()='Loan Balance']/parent::div//td[6]/div";
	String loanBalanceClosingBalanceColumnValue = "//h4[text()='Loan Balance']/parent::div//td[7]/div";

	String loanBalanceInternalRefColumnToggle = "(//h4[text()='Loan Balance']/parent::div//th/p-sorticon)[1]";
	String loanBalanceLoanRefColumnToggle = "(//h4[text()='Loan Balance']/parent::div//th/p-sorticon)[2]";
	String loanBalanceAmountColumnToggle = "(//h4[text()='Loan Balance']/parent::div//th/p-sorticon)[3]";
	String loanBalanceDisbursementsColumnToggle = "(//h4[text()='Loan Balance']/parent::div//th/p-sorticon)[4]";
	String loanBalanceRepaymentsColumnToggle = "(//h4[text()='Loan Balance']/parent::div//th/p-sorticon)[5]";
	String loanBalanceClosingBalanceColumnToggle = "(//h4[text()='Loan Balance']/parent::div//th/p-sorticon)[6]";

	String firstLoanBalanceInternalRefName = "(//h4[text()='Loan Balance']/parent::div//td[2]/a)[1]";
	String firstLoanBalanceLoanRefColumnValue = "(//h4[text()='Loan Balance']/parent::div//td[3]/a)[1]";
	String firstLoanBalanceAmountColumnValue = "(//h4[text()='Loan Balance']/parent::div//td/div)[1]";

	// Facility Balance
	String facilityBalanceTable = "//h4[text()='Facility Balance']//parent::div";
	String facilityBalanceInternalRefColumn = "//h4[text()='Facility Balance']/parent::div//th[contains(text(),'Internal Reference')]";
	String facilityBalanceFacilityRefColumn = "//h4[text()='Facility Balance']/parent::div//th[contains(text(),'Facility Ref')]";
	String facilityBalanceAmountColumn = "//h4[text()='Facility Balance']/parent::div//th[contains(text(),'Amount')]";

	String facilityBalanceInternalRefColumnToggle = "(//h4[text()='Facility Balance']/parent::div//th/p-sorticon)[1]";
	String facilityBalanceFacilityRefColumnToggle = "(//h4[text()='Facility Balance']/parent::div//th/p-sorticon)[2]";
	String facilityBalanceAmountColumnToggle = "(//h4[text()='Facility Balance']/parent::div//th/p-sorticon)[3]";

	String facilityBalanceInternalRefColumnValue = "//h4[text()='Facility Balance']/parent::div//td[2]/a";
	String facilityBalanceFacilityRefColumnValue = "//h4[text()='Facility Balance']/parent::div//td[3]/a";
	String facilityBalanceAmountColumnValue = "//h4[text()='Facility Balance']/parent::div//td/div";

	String firstFacilityBalanceInternalRefColumnValue = "(//h4[text()='Facility Balance']/parent::div//td[2]/a)[1]";
	String firstFacilityBalanceFacilityRefColumnValue = "(//h4[text()='Facility Balance']/parent::div//td[3]/a)[1]";
	String firstFacilityBalanceAmountColumnValue = "(//h4[text()='Facility Balance']/parent::div//td/div)[1]";
	String secondFacilityBalanceAmountColumnValue = "(//h4[text()='Facility Balance']/parent::div//td/div)[2]";

	// Balance Sheet Detail Tab
	String searchByMonthSection = "//label[text()='Search by Month']//parent::div";
	String customSearchSection = "//label[text()='Custom Search']//parent::div";
	String assetBalanceSection = "(//div[contains(@class,'row summary')]//h5[text()='Asset Balance']//parent::div//parent::div)[1]";
	String cashBalanceSection = "(//div[contains(@class,'row summary')]//h5[text()='Cash Balance']//parent::div//parent::div)[1]";
	String loanBalanceSection = "(//div[contains(@class,'row summary')]//h5[text()='Loan Balance']//parent::div//parent::div)[1]";
	String facilitiesBalanceSection = "(//div[contains(@class,'row summary')]//h5[text()='Facilities Balance']//parent::div//parent::div)[1]";

	// Search By Month Section
	String searchByMonthCalendarPopup = "//div[contains(@class,' ui-datepicker')]";
	String startDate = "//input[@placeholder='start date']//parent::div";
	String endDate = "//input[@placeholder='end date']//parent::div";
	String dateCalender = "//ngb-datepicker[contains(@class,'dropdown-menu')]";
	String dynamicDate = "//div[contains(@aria-label,'locatorValue')]";

	// Custom Search Section
	String customSearchStartDateField = "(//input[contains(@class,'form-control m-input input-filter')])[1]";
	String customSearchEndDateField = "(//input[contains(@class,'form-control m-input input-filter')])[2]";
	String calenderPopup = "//ngb-datepicker[contains(@class,'dropdown-menu show ng-star-inserted')]";
	String customSearchErrorMessage = "//div[@class='modal-body']";
	String customSearchErrorPopup = "//div[contains(@class,'ui-dialog-draggable')]";

	// Asset Balance Section
	String assetBalanceAmount = "//h5[text()='Asset Balance']//parent::div//following-sibling::div//label[text()='locatorValue']//following-sibling::h5";

	// Cash Balance Section
	String cashBalanceAmount = "//h5[text()='Cash Balance']//parent::div//following-sibling::div//label[text()='locatorValue']//following-sibling::h5";

	// Loan Balance Section
	String loanBalanceAmount = "//h5[text()='Loan Balance']//parent::div//following-sibling::div//label[text()='locatorValue']//following-sibling::h5";

	// Facilities Balance Section
	String facilitiesBalanceAmount = "//h5[text()='Facilities Balance']//parent::div//following-sibling::div//label[text()='locatorValue']//following-sibling::h5";

	// Loan Balance Table
	String referenceColumn = "//h4[text()='Loan Balance']/parent::div//th[3][contains(text(),'Reference')]";
	String openingBalanceColumn = "//h4[text()='Loan Balance']/parent::div//th[4][contains(text(),' Opening Balance ')]";
	String disbursementsColumn = "//h4[text()='Loan Balance']/parent::div//th[5][contains(text(),' Disbursements')]";
	String repaymentsColumn = "//h4[text()='Loan Balance']/parent::div//th[6][contains(text(),' Repayments ')]";
	String closingBalanceColumn = "//h4[text()='Loan Balance']/parent::div//th[7][contains(text(),' Closing Balance ')]";

	String disbursementColumnValues = "//h4[text()='Loan Balance']/parent::div//td[5]";
	String repaymentsColumnValues = "//h4[text()='Loan Balance']/parent::div//td[6]";
	String closingBalanceColumnValues = "//h4[text()='Loan Balance']/parent::div//td[7]";

	// Facility Balance Table
	String facilityBalanceReferenceColumn = "//h4[text()='Facility Balance']/parent::div//th[3][contains(text(),'Reference')]";
	String facilityBalanceOpeningBalanceColumn = "//h4[text()='Facility Balance']/parent::div//th[4][contains(text(),' Opening Balance ')]";
	String drawdownsColumn = "//h4[text()='Facility Balance']/parent::div//th[5][contains(text(),' Drawdowns ')]";
	String facilityBalancerepaymentsColumn = "//h4[text()='Facility Balance']/parent::div//th[6][contains(text(),' Repayments ')]";
	String facilityBalanceclosingBalanceColumn = "//h4[text()='Facility Balance']/parent::div//th[7][contains(text(),' Closing Balance ')]";

	String drawdownsColumnValues = "//h4[text()='Facility Balance']/parent::div//td[5]";
	String facilityBalanceRepaymentsColumnValues = "//h4[text()='Facility Balance']/parent::div//td[6]";
	String facilityBalanceClosingBalanceColumnValues = "//h4[text()='Facility Balance']/parent::div//td[7]";

	// Cash Balance Tab
	String fundingAccountSection = "//h5[text()='Funding Account']//parent::div";
	String loanAccountSection = "//h5[text()='Loan Account']//parent::div";
	String currentCashAmountSection = "//h5[text()='Current Cash Amount']//parent::div";
	String allButton = "//button[text()='All ']";
	String paymentsButton = "//button[text()=' Payments ']";
	String receiptsButton = "//button[text()=' Receipts ']";
	String cashBalanceTable = "//div[contains(@class,'ui-table-hoverable-rows')]";

	String fundingAccountAmount = "//h5[text()='Funding Account']//following-sibling::h4";
	String loanAccountAmount = "//h5[text()='Loan Account']//following-sibling::h4";
	String currentCashAmount = "//h5[text()='Current Cash Amount']//following-sibling::h4";

	String dateColumn = "//th[text()=' Date ']";
	String internalReferenceColumn = "//th[text()=' Internal Reference ']";
	String referenceColumns = "//th[text()=' Reference ']";
	String transactionColumn = "//th[text()=' Transaction ']";
	String paymentsColumn = "//th[text()=' Payments ']";
	String receiptsColumn = "//th[text()=' Receipts ']";
	String cashBalanceColumn = "//th[text()=' Cash Balance ']";

	String dateColumnValues = "//tr//td[1]";
	String paymentsColumnValues = "//th[text()=' Payments ']//parent::tr//following::tbody//tr//td[5]//div";
	String receiptsColumnValues = "//th[text()=' Receipts ']//parent::tr//following::tbody//tr//td[6]//div";
	String cashBalanceColumnValues = "//th[text()=' Cash Balance ']//parent::tr//following::tbody//tr//td[7]//div";

	String dateColumnFirstValue = "(//th[text()=' Date ']//parent::tr//following::tbody//tr//td[1]//div)[1]";
	String cashBalanceColumnFirstValue = "(//th[text()=' Cash Balance ']//parent::tr//following::tbody//tr//td[7]//div)[1]";

	// Loan Account Tab
	String dateColumnInLoanAccount = "//tr//td[2]//div";
	String totalLoanDisbursementsSection = "//h5[text()='Total Loan Disbursements']//parent::div";
	String totalLoanRepaymentsSection = "//h5[text()='Total Loan Repayments']//parent::div";
	String currentLoanBalanceSection = "//h5[text()='Current Loan Balance']//parent::div";

	String totalLoanDisbursementsAmount = "//h5[text()='Total Loan Disbursements']//following-sibling::h4";
	String totalLoanRepaymentsAmount = "//h5[text()='Total Loan Repayments']//following-sibling::h4";
	String currentLoanBalanceAmount = "//h5[text()='Current Loan Balance']//following-sibling::h4";

	String actionColumnHeader = "//th[text()=' Action ']";
	String disbursementsColumnHeader = "//th[text()=' Disbursements ']";
	String repaymentsColumnHeader = "//th[text()=' Repayments ']";
	String loanBalanceColumnHeader = "//th[text()=' Loan Balance ']";

	String loanBalanceColumnValues = "//th[text()=' Loan Balance ']//parent::tr//following::tbody//tr//td[8]//div";

	String dateColumnFirstDate = "(//th[text()=' Date ']//parent::tr//following::tbody//tr//td[2]//div)[1]";
	String loanBalanceFirstAmount = "(//th[text()=' Loan Balance ']//parent::tr//following::tbody//tr//td[8]//div)[1]";

	// Funding Account Tab
	String totalFacilityDrawdownsSection = "//h5[text()='Total Facility Drawdowns']//parent::div";
	String totalFacilityRepaymentsSection = "//h5[text()='Total Facility Repayments']//parent::div";
	String currentAllocatedAmountSection = "//h5[text()='Current Allocated Amount']//parent::div";

	String totalFacilityDrawdownsAmount = "//h5[text()='Total Facility Drawdowns']//following-sibling::h4";
	String totalFacilityRepaymentsAmount = "//h5[text()='Total Facility Repayments']//following-sibling::h4";
	String currentAllocatedAmount = "//h5[text()='Current Allocated Amount']//following-sibling::h4";

	String repaymentColumnHeader = "//th[text()=' Repayment ']";
	String drawdownColumnHeader = "//th[text()=' Drawdown ']";
	String amountAllocatedColumnHeader = "//th[text()=' Amount Allocated ']";

	String amountAllocatedFirstAmount = "(//th[text()=' Amount Allocated ']//parent::tr//following::tbody//tr//td[8]//div)[1]";

	String dateColumnInFundingAccount = "//tr//td[2]//div";

}
