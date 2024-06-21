package com.locators.allPages;

public interface FundingDatabasePO {

	String headerLoanFacilityDatabaseText = "//h3[text()='Loan Facility Database']";
	String editLoanFacilityText = "//h3[text()=' Edit Loan Facility ']";
	String referenceSearchField = "(//th[text()=' Reference ']//ancestor::thead//tr[2]//th//input[contains(@class,'ui-inputtext')])[2]";
	String internalReference = "//div[contains(@class,'right')]//p[contains(@class,'m')]";

	// Table header
	String status = "//th[text()=' Status ']";
	String loanFacilityType = "//th[text()=' Loan Facility Type ']";
	String approvalStatus = "//th[text()=' Approval Status ']";
	String internalReferenceHeader = "//th[text()=' Internal Reference ']";
	String reference = "//th[text()=' Reference ']";
	String lenderRef = "//th[text()=' Lender Ref ']";
	String lender = "//th[text()=' Lender ']";
	String amount = "//th[text()=' Amount ']";
	String drawn = "//th[text()=' Drawn ']";
	String allocatedAmount = "//th[text()=' Allocated Amount ']";
	String cash = "//th[text()=' Cash ']";
	String available = "//th[text()=' Available ']";
	String rateMin = "//th[text()=' Rate Min ']";
	String ratePercentage = "//th[text()=' Rate Percentage ']";
	String rateFee = "//th[text()=' Rate Fee ']";
	String rateFeePercentage = "//th[text()=' Rate Fee % ']";

	// Table sort icon
	String statusSortIcon = "//th[text()=' Status ']//p-sorticon";
	String loanFacilityTypeSortIcon = "//th[text()=' Loan Facility Type ']//p-sorticon";
	String approvalStatusSortIcon = "//th[text()=' Approval Status ']//p-sorticon";
	String internalReferenceHeaderSortIcon = "//th[text()=' Internal Reference ']//p-sorticon";
	String referenceSortIcon = "//th[text()=' Reference ']//p-sorticon";
	String lenderRefSortIcon = "//th[text()=' Lender Ref ']//p-sorticon";
	String lenderSortIcon = "//th[text()=' Lender ']//p-sorticon";
	String amountSortIcon = "//th[text()=' Amount ']//p-sorticon";
	String drawnSortIcon = "//th[text()=' Drawn ']//p-sorticon";
	String allocatedAmountSortIcon = "//th[text()=' Allocated Amount ']//p-sorticon";
	String cashSortIcon = "//th[text()=' Cash ']//p-sorticon";
	String availableSortIcon = "//th[text()=' Available ']//p-sorticon";
	String rateMinSortIcon = "//th[text()=' Rate Min ']//p-sorticon";
	String ratePercentageSortIcon = "//th[text()=' Rate Percentage ']//p-sorticon";
	String rateFeeSortIcon = "//th[text()=' Rate Fee ']//p-sorticon";
	String rateFeePercentageSortIcon = "//th[text()=' Rate Fee % ']//p-sorticon";

	// Table search box
	String statusSearchBox = "//tr[2]//th[2]";
	String loanFacilityTypeSearchBox = "//tr[2]//th[3]";
	String approvalStatusSearchBox = "//tr[2]//th[4]";
	String internalReferenceHeaderSearchBox = "//tr[2]//th[5]//input";
	String referenceSearchBox = "//tr[2]//th[6]//input";
	String lenderRefSearchBox = "//tr[2]//th[7]//input";
	String lenderSearchBox = "//tr[2]//th[8]//input";
	String amountSearchBoxMin = "//tr[2]//th[9]//input[@id='amount1']";
	String amountSearchBoxMax = "//tr[2]//th[9]//input[@id='amount2']";
	String drawnSearchBoxMin = "//tr[2]//th[10]//input[@id='drawn1']";
	String drawnSearchBoxMax = "//tr[2]//th[10]//input[@id='drawn2']";
	String allocatedAmountSearchBoxMin = "//tr[2]//th[11]//input[@id='allocatedAmount1']";
	String allocatedAmountSearchBoxMax = "//tr[2]//th[11]//input[@id='allocatedAmount2']";
	String cashSearchBoxMin = "//tr[2]//th[12]//input[@id='cash1']";
	String cashSearchBoxMax = "//tr[2]//th[12]//input[@id='cash2']";
	String availableSearchBoxMin = "//tr[2]//th[13]//input[@id='available1']";
	String availableSearchBoxMax = "//tr[2]//th[13]//input[@id='available2']";
	String rateMinSearchBoxMin = "//tr[2]//th[14]//input[@id='rateMin1']";
	String rateMinSearchBoxMax = "//tr[2]//th[14]//input[@id='rateMin2']";
	String ratePercentageSearchBoxMin = "//tr[2]//th[15]//input[@id='ratePercentage1']";
	String ratePercentageSearchBoxMax = "//tr[2]//th[15]//input[@id='ratePercentage2']";
	String rateFeeSearchBoxMin = "//tr[2]//th[16]//input[@id='rateFee1']";
	String rateFeeSearchBoxMax = "//tr[2]//th[16]//input[@id='rateFee2']";
	String rateFeePercentageSearchBoxMin = "//tr[2]//th[17]//input[@id='rateFeePercentage1']";
	String rateFeePercentageSearchBoxMax = "//tr[2]//th[17]//input[@id='rateFeePercentage2']";

	// Facility Loan
	String facilityLoanText = "//h3[text()=' Edit Loan Facility ']";
	String internalReferenceField = "//label[text()=' Internal Reference']//following-sibling::div//input";
	String internalReferenceEditIcon = "//label[text()=' Internal Reference']//following-sibling::div//button[@id='single-button']";
	String newValue = "//label[text()=' New Value']//following-sibling::div//input[contains(@class,'form-control')]";
	String confirmButton = "//button[text()='Confirm']";

	// Table
	String statusElements = "//tbody[@class='ui-table-tbody']//tr//td[2]";
	String loanFacilityTypeElements = "//tbody[@class='ui-table-tbody']//tr//td[3]";
	String approvalStatusElements = "//tbody[@class='ui-table-tbody']//tr//td[4]";
	String internalReferenceElements = "//tbody[@class='ui-table-tbody']//tr//td[5]";
	String references = "//tbody[@class='ui-table-tbody']//tr//td[6]";
	String dynamicReference = "//tbody[@class='ui-table-tbody']//tr[value]//td[6]";

	String lenderRefElements = "//tbody[@class='ui-table-tbody']//tr//td[7]";
	String lenderElements = "//tbody[@class='ui-table-tbody']//tr//td[8]";
	String amountElements = "//tbody[@class='ui-table-tbody']//tr//td[9]";
	String drawnElements = "//tbody[@class='ui-table-tbody']//tr//td[10]";
	String allocatedAmountElements = "//tbody[@class='ui-table-tbody']//tr//td[11]";
	String cashElements = "//tbody[@class='ui-table-tbody']//tr//td[12]";
	String availableElements = "//tbody[@class='ui-table-tbody']//tr//td[13]";
	String rateMinElements = "//tbody[@class='ui-table-tbody']//tr//td[14]";
	String ratePercentageElements = "//tbody[@class='ui-table-tbody']//tr//td[15]";
	String rateFeeElements = "//tbody[@class='ui-table-tbody']//tr//td[16]";
	String rateFeePercentageElements = "//tbody[@class='ui-table-tbody']//tr//td[17]";

	// Table first row value
	String internalReferenceFirstRowValue = "//tr[1]//td[5]";
	String referenceFirstRowValue = "//tr[1]//td[6]";
	String lenderRefFirstRowValue = "//tr[1]//td[7]";
	String lenderFirstRowValue = "//tr[1]//td[8]";
	String amountFirstRowValue = "//tr[1]//td[9]";
	String drawnFirstRowValue = "//tr[1]//td[10]";
	String allocatedAmountFirstRowValue = "//tr[1]//td[11]";
	String cashFirstRowValue = "//tr[1]//td[12]";
	String availableFirstRowValue = "//tr[1]//td[13]";
	String rateMinFirstRowValue = "//tr[1]//td[14]";
	String ratePercentageFirstRowValue = "//tr[1]//td[15]";
	String rateFeeFirstRowValue = "//tr[1]//td[16]";
	String rateFeePercentageFirstRowValue = "//tr[1]//td[17]";

	// Table dropdown
	String statusDropdown = "(//span[text()='All']//parent::label)[1]";
	String loanFacilityTypeDropdown = "(//span[text()='All']//parent::label)[2]";
	String approvalStatusDropdown = "(//span[text()='All']//parent::label)[3]";

	// Dropdown option
	String dropdownOption = "//div[@class='ui-dropdown-items-wrapper']//li[@aria-label='locator']";

	String referenceCloseIcon = "//button[contains(@class,'ui-button-danger')]";

}
