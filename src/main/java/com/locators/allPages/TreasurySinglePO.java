package com.locators.allPages;

public interface TreasurySinglePO {

	String calenderDay = "//div[text()='locatorValue']";
	String calenderMonth = "//div[contains(@class,'ngb-dp-header')]//select[@class='custom-select'][1]";
	String calenderYear = "//select[@title='Select year']";

	String table = "//table[@class='ui-table-scrollable-body-table']";
	String facilityCurrentAllocation = "//a[text()='locatorValue']//ancestor::td//following-sibling::td[4]//div";
	String equal = "//input[@value='EQUALS']//parent::label";
	String prorata = "//input[@value='PRO_RATA']//parent::label";
	String save = "//button[text()=' Save ']";

	// Allocation Inputs
	String allocationInputs = "//h3[text()=' Allocation Inputs ']";
	String allocationInputsSection = "(//h3[text()=' Allocation Inputs ']//ancestor::div[contains(@class,'m-portlet')])[1]";
	String allocationPreview = "//h3[text()=' Allocation Preview ']";
	String allocationPreviewSection = "(//h3[text()=' Allocation Preview ']//ancestor::div[contains(@class,'m-portlet')])[1]";

	String allocationDate = "//label[contains(text(),'Allocation Date')]//following-sibling::div";
	String loanReference = "//label[contains(text(),'Loan Reference')]//following-sibling::div//select";
	String internalReference = "//label[contains(text(),'Internal Reference')]//following-sibling::div";
	String loanAmount = "//label[contains(text(),'Loan Amount')]//following-sibling::div";
	String allocatedAmount = "//label[contains(text(),'Allocated Amount')]//following-sibling::div";
	String unAllocatedAmount = "//label[contains(text(),'Un-allocated Amount')]//following-sibling::div";
	String borrowerRate = "//label[contains(text(),'Borrower Rate')]//following-sibling::div";
	String LTV = "//label[contains(text(),'LTV')]//following-sibling::div";
	String availableCash = "//label[contains(text(),'Available Cash')]//following-sibling::div";
	String allocationType = "//label[contains(text(),'Allocation Type')]//following-sibling::div";

	// Allocation Preview header
	String includePreview = "//th[text()=' Include ']";
	String facilityRefPreview = "//th[text()=' Facility Ref ']";
	String facilityStatusPreview = "//th[text()=' Facility Status ']";
	String borrowerRatePreview = "//th[text()=' Borrower Rate ']";
	String drawnAmountPreview = "//th[text()=' Drawn Amount ']";
	String currentAllocationPreview = "//th[text()=' Current Allocation ']";
	String availableCashPreview = "//th[text()=' Available Cash ']";
	String newAllocationPreview = "//th[text()=' New Allocation ']";
	String checksPreview = "//th[text()=' Checks ']";

	// Allocation Preview First Row Value
	String totalCurrentAllocationPreviewValue = "//tr[1]//td[6]";
	String totalAvailableCashPreviewValue = "//tr[1]//td[7]";

	// Allocation Preview Second Row Value
	String includePreviewValue = "//tr[2]//td[1]//div[contains(@class,'ui-chkbox-box')]";
	String includePreviewUncheckValue = "//tr[2]//td[1]//div[contains(@class,'ui-chkbox-box') and not(contains(@class, 'ui-state-active'))]";
	String includePreviewCheckValue = "//tr[2]//td[1]//div[contains(@class,'ui-chkbox-box') and (contains(@class, 'ui-state-active'))]";
	String facilityRefPreviewValue = "//tr[2]//td[2]";
	String facilityStatusPreviewValue = "//tr[2]//td[3]";
	String borrowerRatePreviewValue = "//tr[2]//td[4]";
	String drawnAmountPreviewValue = "//tr[2]//td[5]";
	String currentAllocationPreviewValue = "//tr[2]//td[6]";
	String availableCashPreviewValue = "//tr[2]//td[7]";
	String newAllocationPreviewValue = "//tr[2]//td[8]";
	String checksPreviewValue = "//tr[2]//td[9]";

	// Allocation Preview
	String allInclude = "//tr//td[1]";
	String allFacilityRef = "//tr//td[2]";
	String allFacilityStatus = "//tr//td[3]";
	String allCurrentAllocation = "//tbody//tr//td[6]";
	String allNewAllocation = "//tr//td[8]";
	String allChecks = "//tr//td[9]//div//button";

	// Check popup
	String closeIcon = "//button[@class='close']";
	String maxLoanAllocation = "//label[contains(text(),'Max Loan Allocation')]//following-sibling::div//p";
	String cashAfterAllocation = "//label[contains(text(),'Cash After Allocation')]//following-sibling::div//p";

	String singleLoanMaxCurrent = "//label[contains(text(),'Single Loan Max')]//following-sibling::div[1]//p";
	String singleBorrowerMaxCurrent = "//label[contains(text(),'Single Borrower Max')]//following-sibling::div[1]//p";

	String singleLoanMax = "//label[contains(text(),'Single Loan Max')]//following-sibling::div[2]//p";
	String singleBorrowerMax = "//label[contains(text(),'Single Borrower Max')]//following-sibling::div[2]//p";
}
