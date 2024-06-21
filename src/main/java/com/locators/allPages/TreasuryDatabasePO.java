package com.locators.allPages;

public interface TreasuryDatabasePO {

	String allocationDate = "//label[contains(text(),'Allocation Date:')]//following-sibling::input";
	String toggleAllLoans = "//button[text()='Toggle All Loans']";
	String toggleAllFacilities = "//button[text()='Toggle All Facilities']";
	String facilities = "//thead//th[contains(@class, 'ng-star-inserted')]";
	String facilitiesCheckbox = "//thead//th[contains(@class, 'ng-star-inserted')]//input";
	String facilityReferenceNumber = "//a[text()='locatorValue']";

	String loanRows = "//tbody//tr[@class='ng-star-inserted']";
	String loansCheckbox = "//tbody//tr[@class='ng-star-inserted']";
	String loanReferences = "//tbody//tr[@class='ng-star-inserted']//td[1]";
	String loanReferencesCheckbox = "//tbody//tr[@class='ng-star-inserted']//td[1]//input";

	String facilityAmountForLoanReferences = "//tbody//tr[@class='ng-star-inserted']//td[locatorValue]";
	String facilitiesAmountForLoanReferences = "//tbody//tr[@class='ng-star-inserted'][loanPosition]//td[facilityPosition]";

	String totalFacilityAmount = "//th[contains(text(), 'Facility Amount')]//following-sibling::td[@class='custom-datatable-cell']";
	String facilitiesAmount = "//th[contains(text(), 'Facility Amount')]//following-sibling::td[contains(@class, 'ng-star-inserted')]";
	String facilityAmount = "//th[contains(text(), 'Facility Amount')]//following-sibling::td[contains(@class, 'ng-star-inserted')][facilityPosition]";
	String totalDrawnAmount = "//th[contains(text(), 'Drawn Amount')]//following-sibling::td[@class='custom-datatable-cell']";
	String facilitiesDrawnAmount = "//th[contains(text(), 'Drawn Amount')]//following-sibling::td[contains(@class, 'ng-star-inserted')]";
	String facilityDrawnAmount = "//th[contains(text(), 'Drawn Amount')]//following-sibling::td[contains(@class, 'ng-star-inserted')][facilityPosition]";
	String totalAllocatedAmount = "//th[contains(text(), 'Allocated Amount')]//following-sibling::td[@class='custom-datatable-cell']";
	String facilitiesAllocatedAmount = "//th[contains(text(), 'Allocated Amount')]//following-sibling::td[contains(@class, 'ng-star-inserted')]";
	String facilityAllocatedAmount = "//th[contains(text(), 'Allocated Amount')]//following-sibling::td[contains(@class, 'ng-star-inserted')][facilityPosition]";
	String totalLoanAmount = "//a[text()='locatorValue']//parent::label//parent::td//following-sibling::td[1]";
	String loanAmounts = "//a[text()='locatorValue']//parent::label//parent::td//following-sibling::td[contains(@class, 'ng-star-inserted')]";
	String loanAmountOfFacility = "//a[text()='locatorValue']//parent::label//parent::td//following-sibling::td[contains(@class, 'ng-star-inserted')][facilityPosition]";
	String nextStepButton = "//a[text()=' Next Step ']";

	// Last Step
	String amendFacilityAllocations = "//h3[text()=' Amend Facility Allocations']";
	String currentAllocation = "//th[contains(text(), 'current')]";
	String revisedAllocation = "//th[contains(text(), 'Revised')]";
	String facilitiesInStep2 = "//a[contains(@href,'/loan-facility/LFSummary/')]";
	String amountCorrespondingToLoan = "//a[contains(@href,'/bridge-loan/BLSummary/locatorValue')]//parent::td//following-sibling::td[facilityPosition]";
	String revisedAmountCorrespondingToLoan = "//a[contains(@href,'/bridge-loan/BLSummary/locatorValue')]//parent::td//following-sibling::td[facilityPosition]//input";
	String popupMessage = "//div[contains(@class,'modal-content-custom')]//span[not(contains(@class, 'sr-only'))]";

	String facilitiesAmountInStep2 = "//th[text()='Facility Amount']//following-sibling::th[contains(@class, 'ng-star-inserted')]";
	String drawnAmountInStep2 = "//th[text()='Drawn Amount']//following-sibling::th[contains(@class, 'ng-star-inserted')]";
	String allocatedAmountInStep2 = "//th[text()='Allocated Amount']//following-sibling::th[contains(@class, 'ng-star-inserted')]";
	String cashInStep2 = "//th[text()='Cash']//following-sibling::th[contains(@class, 'ng-star-inserted')]";
	String cashPercentageInStep2 = "//th[text()='Cash %']//following-sibling::th[contains(@class, 'ng-star-inserted')]";

	String differenceValue = "//a[text()='locatorValue']//parent::td//following-sibling::td[1]";

	// Last Step Compliance
	String showDetails = "(//button[@title='Show details'])[facilityPosition]";
	String complianceTickMarck = "(//button[@title='Show details']/preceding-sibling::i)[facilityPosition]";
	String singleLoanMaxPercentageValue = "//th[text()='Single loan max %']//following-sibling::td[1]";
	String singleLoanMaxPercentageCriteria = "//th[text()='Single loan max %']//following-sibling::td[2]";
	String singleBorrowerMaxValue = "//th[text()='Single borrower max %']//following-sibling::td[1]";
	String singleBorrowerMaxCriteria = "//th[text()='Single borrower max %']//following-sibling::td[2]";
	String maxCumulativeSecondChargesValue = "//th[text()='Max cumulative second charges']//following-sibling::td[1]";
	String maxCumulativeSecondChargesCriteria = "//th[text()='Max cumulative second charges']//following-sibling::td[2]";
	String maxCommercialPropertiesValue = "//th[text()='Max commercial properties']//following-sibling::td[1]";
	String maxCommercialPropertiesCriteria = "//th[text()='Max commercial properties']//following-sibling::td[2]";
	String maxDevelopmentPropertiesValue = "//th[text()='Max development properties']//following-sibling::td[1]";
	String maxDevelopmentPropertiesCriteria = "//th[text()='Max development properties']//following-sibling::td[2]";

}
