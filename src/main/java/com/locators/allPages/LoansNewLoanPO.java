package com.locators.allPages;

public interface LoansNewLoanPO {

	String editBridgeLoanHeaderText = "//h3[text()=' Edit Bridge Loan ']";
	String internalReference = "//div[contains(@class,'pull-right')]//p";
	String previousButton = "//button[text()=' Previous ']";
	String nextButton = "//button[text()=' Next ']";
	String popUpStatus = "//h4[@class='modal-title']";

	// Borrower Tab
	String newBridgeLoanHeaderText = "//h3[text()=' New Bridge Loan ']";
	String loanStatusLabel = "//div[contains(@class,'pull-left')]//p";
	String loanStatus = "//div[contains(@class,'pull-left')]//p//span[1]";
	String ApprovalStatusLabel = "//div[contains(@class,'pull-left')]//p//span[2]";
	String ApprovalStatus = "//div[contains(@class,'pull-left')]//p//span[3]";
	String bridgeLoanInternalReferenceField = "//label[text()='Bridge Loan Internal Reference']//parent::div//following::div//input[contains(@class,'ng-untouched ')]";
	String borrowerType = "//label[text()='Borrower Type']//parent::div";
	String activeBorrowerType = "//label[text()='Borrower Type']//following-sibling::div//label[contains(@class,'active')]//input";
	String borrowerTypeValue = "//label[text()='Borrower Type']//following-sibling::div//label[contains(text(),'locator')]";
	String actionTypeValue = "//label[text()=' Action']//following-sibling::div//label[contains(text(),'locator')]";
	String borrowerInternalReference = "//label[text()=' Internal Reference']//following-sibling::div//input";
	String name = "//label[text()='Name']//following-sibling::div//input";
	String nameDropdown = "//label[text()=' Name ']//following-sibling::div";
	String company = "//label[text()='Company']//following-sibling::div//input";
	String companyDropdown = "//label[text()=' Company ']//following-sibling::div";
	String dropdownSearchBar = "//input[contains(@class,'ui-dropdown-filter')]";
	String dropdownOption = "//li[contains(@aria-label,'locator')]";

	// Loan Tab
	String loanTab = "//a[text()=' Loan ']";
	String facilityDisbursement = "//label[text()=' Facility Disbursement ']";
	String bulletUpsize = "//label[text()=' Bullet Upsize ']";
	String extension = "//label[text()=' Extension ']";
	String loanType = "//label[text()=' Loan Type']//following-sibling::div//label[contains(text(),'locator')]";
	String amount = "//label[text()=' Amount']//following-sibling::div//input";

	// Loan Tab >> - Repayment
	String repayment = "//label[text()=' Repayment ']";
	String repaymentType = "//label[text()=' Repayment Type']//following-sibling::div//label[contains(text(),'locator')]";
	String payementDate = "//label[text()='Payment Date']//following-sibling::div//div[@id='amendable-input']";
	String payementDateValue = "//label[text()='Payment Date']//following-sibling::div//div[@id='amendable-input']//input";
	String repaymentButton = "//label[text()=' Repayment ']";
	String repaymentPopup = "//div[@class='modal-content']";
	String repaymentTypeFull = "//label[text()='Full ']";
	String repaymentTypePartial = "//label[text()='Partial ']";
	String cancelButton = "//button[text()='Cancel']";
	String repaymentPopupNextButton = "//button[text()='Next']";
	String effectiveDate = "//div[@id='disbursementDate']";
	String effectiveDateValue = "//div[@id='disbursementDate']//input";
	String interestRefund = "//label[text()='Interest Refund']//following-sibling::div";
	String refundDate = "//label[text()='Refund Date']//following-sibling::div";
	String refundDateInput = "//label[text()='Refund Date']//following-sibling::div//input";
	String warningPopup = "(//div[@class='modal-content'])[2]";
	String warningMessageFirstLine = "//div[@class='modal-content']//div[@class='m-portlet__body']//p[1]";
	String warningPopupYes = "//button[text()='Yes']";
	String warningPopupNo = "//button[text()='No']";
	String partialEffectiveDate = "//label[text()=' Effective Date']//following-sibling::div//input";
	String duePayment = "//label[text()=' Due Payment ']//following-sibling::div//p";
	String partialAmount = "//label[text()=' Amount ']//following-sibling::div//input";
	String partialConfirmButton = "//button[text()='Confirm']";

	// Loan Tab >> - Loan Disbursement Section
	String loanDisbursementSection = "//h3[text()=' Loan Disbursement ']//ancestor::div[contains(@class,'col-lg')]";
	String loanDisbursementHeader = "//h3[text()=' Loan Disbursement ']";
	String currentAmountValue = "//label[text()=' Current Amount']//parent::div//p[contains(@class,'current')]";

	// Loan Tab >> - Repayment Section
	String repaymentSection = "//h3[text()=' Repayment ']//ancestor::div[contains(@class,'col-lg')]";

	// Loan Tab >> - Fees Section
	String feesSection = "//h3[text()=' Fees ']//ancestor::div[contains(@class,'col-lg')]";

	// Loan Tab >> - Interest Rates Section
	String interestRatesSection = "//h3[text()=' Interest Rates ']//ancestor::div[contains(@class,'col-lg')]";
	String interestRatesSectionHeader = "//h3[text()=' Interest Rates ']";
	String defaultInterestRateField = "//label[text()=' Default Interest Rate ']//parent::div//div[@id='amendable-input']//input[contains(@class,'m-input')]";
	String defaultInterestRateEditIcon = "//label[text()=' Default Interest Rate ']//parent::div//div[@id='amendable-input']//button[@id='single-button']";
	String currentValueField = "//label[text()=' Current Value']//parent::div//p[contains(@class,'current')]";

	// Loan Tab >> - Interest Payment Dates Section
	String interestPaymentDateSection = "//h3[text()=' Interest Payment Dates ']//ancestor::div[contains(@class,'col-lg')]";

	// Loan Tab >> - Broker Section
	String brokerSection = "//h3[text()=' Broker ']//ancestor::div[contains(@class,'col-lg')]";

	// Loan Tab >> - Contractual Details Section
	String contractualDetailsSection = "//h3[text()=' Contractual Details ']//ancestor::div[contains(@class,'col-sm')]";

	// Loan Tab >> - Redemption Request Section
	String redemptionRequestSection = "//h3[text()=' Redemption Request ']//ancestor::div[contains(@class,'col-sm')]";

	// Loan Details Section
	String annualInterestRate = "//th[text()='Annual Interest Rate']//following-sibling::td";

	// Property Tab
	String propertyTab = "//a[text()=' Property ']";
	String propertyInformation = "//h3[text()=' Property Information ']";
	String propertyType = "//label[text()=' Property Type']//following-sibling::div//label[contains(text(),'locator')]";

	// Loan status
	String loanStatusTab = "//a[text()=' Loan Status ']";
	String currectStatusText = "//label[text()=' Current Status']";
	String changeStatusYes = "//label[text()=' Yes ']";
	String newStatus = "//button[contains(text(),'locator')]";

	// Summary Tab
	String summaryTab = "//li//a[text()=' Summary ']";
	String bridgeLoanSummaryTextHeader = "//h3[text()=' Bridge Loan Summary ']";
	String loanDetailsHeader = "//h3[text()=' Loan Details ']";

	// Summary Tab >> Loan Details
	String amountSummary = "//th[text()='Amount']//following-sibling::td";
	String currentAmountSummary = "//th[text()='Current Amount']//following-sibling::td";
	String disbursementDate = "//th[text()='Disbursement Date']//parent::tr//following-sibling::div//tbody//tr[1]//th[1]";

	// Cashflows Tab
	String cashflowsTab = "//li//a[text()=' Cashflows ']";
	String cashflowsHeader = "//span[text()='Add New Cashflow ']";
	String addNewCashflow = "//span[contains(text(),'Add New Cashflow')]//parent::div";
	String firstRowConfirmationStatus = "//tbody//tr[@class='ng-star-inserted'][1]//td[2]//i";
	String firstRowScheduleDate = "//tbody//tr[@class='ng-star-inserted'][1]//td[3]";
	String firstRowEffectiveDate = "//tbody//tr[@class='ng-star-inserted'][1]//td[4]";
	String firstRowCashflowAmount = "//tbody//tr[@class='ng-star-inserted'][1]//td[7]";
	String firstRowActualCashflowAmount = "//tbody//tr[@class='ng-star-inserted'][1]//td[9]";
	String scheduleStartDate = "(//input[@placeholder='start date'])[1]";
	String effectiveStartDate = "(//input[@placeholder='start date'])[2]";
	String effectiveEndDate = "(//input[@placeholder='end date'])[2]";
	String viewButton = "(//button[@mattooltip='View'])[1]";
	String confirmPayment = "//button[text()='Confirm Payment ']";
	String paymentReceiptDropdown = "(//label[text()='All'])[1]";
	String receiptDropdownoption = "//div[@class='ui-dropdown-items-wrapper']//li[@aria-label='Receipt']";

	// Cashflows Tab >> Add New Cashflow Popup
	String addNewCashflowPopupHeader = "//h4[contains(text(),'Add New Cashflow')]";
	String paymentAddNewCashflow = "//label[contains(text(),' Payment ')]";
	String receiptAddNewCashflow = "//label[contains(text(),' Receipt ')]";
	String amountInAddNewCashflow = "//label[text()=' Amount']//following-sibling::div//input";
	String loanDisbursement = "//label[text()='Loan Disbursement ']";
	String loanRepayment = "//label[text()='Loan Repayment ']";
	String dateAddNewCashflow = "//input[@id='date']//parent::div";
	String viewPaymentDetails = "//button[text()='View Payment Details']";
	String addNewCashflowSave = "//button[text()='Save ']";

	// Loan History Tab
	String loanHistoryTab = "//li//a[text()=' Loan History ']";
	String action = "//th[contains(text(),'Action ')]";
	String confirmed = "//th[contains(text(),'Confirmed ')]";
	String scheduleDate = "//th[contains(text(),'Schedule Date ')]";
	String effectiveDateCashflow = "//th[contains(text(),'Effective Date ')]";
	String PaymentReceipt = "//th[contains(text(),'Payment/Receipt ')]";
	String paymentType = "//th[contains(text(),'Payment Type ')]";
	String expectedCashflowAmount = "//th[contains(text(),'Expected Cashflow Amount ')]";
	String adjustmentAmount = "//th[contains(text(),'Adjustment Amount ')]";
	String actualCashflowAmount = "//th[contains(text(),'Actual Cashflow Amount ')]";
	String outstandingAmount = "//th[contains(text(),'Outstanding Amount ')]";

	String editAmendsHeader = "//th[text()=' Edit/Amends ']";
	String firstRowChangeType = "//tr[contains(@class,'ui-selectable-row')][1]//td[3]";
	String firstRowOldValue = "//tr[contains(@class,'ui-selectable-row')][1]//td[6]";
	String firstRowNewValue = "//tr[contains(@class,'ui-selectable-row')][1]//td[7]";
	String firstRowCreatedDateValue = "//tr[contains(@class,'ui-selectable-row')][1]//td[9]";

}
