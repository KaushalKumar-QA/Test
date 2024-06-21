package com.locators.allPages;

public interface TreasuryPortfolioPO {

	String step1Text = "//div[text()=' New Faciliy Allocations ']";
	String step2Text = "//div[text()=' Target Specification ']";
	String step3Text = "//div[text()=' Reallocate Loans ']";
	String step4Text = "//div[text()=' Amend Allocations ']";
	String dynamicReference = "//a[text()=' locatorValue ']";

	// Step 1 - New Faciliy Allocations
	String newFaciliyAllocationsStep = "//div[contains(text(),'Step 1')]/../preceding-sibling::a/..";

	// Step 2 - Target Specification
	String targetSpecificationStep = "//div[contains(text(),'Step 2')]/../preceding-sibling::a/..";
	String step2 = "//a[contains(@href,'step2')]//span";
	String fundingSummaryTitle = "//th[text()='Funding Summary']";
	String utilisation = "//label[text()=' Utilisation ']";
	String rate = "//label[text()=' Rate ']";
	String utilisationThreshold = "//label[text()='Utilisation Threshold']//following-sibling::div//input";
	String updateRanking = "//button[text()='Update Ranking']";
	String residualMaturityLimit = "//label[text()='Residual Maturity Limit']//following-sibling::div//input";
	String updateSuggestions = "//button[text()='Update Suggestions ']";

	// Step 2 - Target Specification - Funding Summary
	String totalLoans = "//th[text()='Total Loans']//following-sibling::td";
	String availableLoans = "//th[text()='Available Loans']//following-sibling::td";
	String excludedLoans = "//th[text()='Excluded Loans']//following-sibling::td";
	String doubleInclusion = "//th[text()='Double Inclusion']//following-sibling::td";
	String loanPool = "//th[text()='Loan Pool']//following-sibling::td";
	String totalFacilities = "//th[text()='Total Facilities']//following-sibling::td";
	String totalDrawn = "//th[text()='Total Drawn']//following-sibling::td";
	String availableFunding = "//th[text()='Available Funding']//following-sibling::td";
	String facilitiesPool = "//th[text()='Facilities Pool']//following-sibling::td";
	String poolCoverage = "//th[text()='Pool Coverage']//following-sibling::td";

	// Step 2 - Target Specification - Allocation Summary
	String currentAllocation = "//th[text()='Current Allocation']//following-sibling::td";
	String unallocated = "//th[text()='Unallocated']//following-sibling::td";
	String maxUtilisation = "//th[text()='Max Utilisation']//following-sibling::td";
	String additionalAllocation = "//th[text()='Additional Allocation']//following-sibling::td";
	String requiredDrawdowns = "//th[text()='Required Drawdowns']//following-sibling::td";

	// Step 2 - Facility Table
	String facilityTable = "(//tbody[@class='ui-table-tbody'])[1]//preceding::thead[@class='ui-table-thead']//parent::table//parent::div[contains(@class,'ui-table-wrapper')]";
	String excludedText = "(//th[text()=' Excluded '])[1]";
	String facilities = "(//tbody[@class='ui-table-tbody'])[1]//tr//td[2]//div[@class='ng-star-inserted']";
	String amountInFacilities = "(//tbody[@class='ui-table-tbody'])[1]//tr//td[4]//div[@class='ng-star-inserted']";
	String drawnAmountInFacilities = "(//tbody[@class='ui-table-tbody'])[1]//tr//td[5]//div[@class='ng-star-inserted']";
	String currentDeploymentInFacilities = "(//tbody[@class='ui-table-tbody'])[1]//tr//td[6]//div[@class='ng-star-inserted']";
	String additionalUtilizationInFacilities = "(//tbody[@class='ui-table-tbody'])[1]//tr//td[9]//div[@class='ng-star-inserted']";
	String targetInFacilities = "(//tbody[@class='ui-table-tbody'])[1]//tr//td[11]//input";
	String excludedFacilities = "(//tbody[@class='ui-table-tbody'])[1]//tr//td[13]//div[@class='ng-star-inserted']";
	String currentUtilizationInFacilities = "(//tbody[@class='ui-table-tbody'])[1]//tr//td[7]//div[@class='ng-star-inserted']";
	String proposedUtilizationInFacilities = "(//tbody[@class='ui-table-tbody'])[1]//tr//td[8]//div[@class='ng-star-inserted']";

	String amountCorrespondingToFacility = "//a[text()=' locatorValue ']//parent::div//parent::div//parent::td//following-sibling::td[2]";
	String drawnAmountCorrespondingToFacility = "//a[text()=' locatorValue ']//parent::div//parent::div//parent::td//following-sibling::td[3]";

	// Step 2 - Loan Table
	String loanTable = "(//tbody[@class='ui-table-tbody']//preceding::thead[@class='ui-table-thead']//parent::table//parent::div[contains(@class,'ui-table-wrapper')])[2]";
	String allocatedAmountText = "//th[text()=' Allocated Amount ']";
	String loanReferences = "(//tbody[@class='ui-table-tbody'])[2]//tr//td[2]//div[@class='ng-star-inserted']";
	String currentLoanAmount = "(//tbody[@class='ui-table-tbody'])[2]//tr//td[6]//div[@class='ng-star-inserted']";
	String allocatedAmount = "(//tbody[@class='ui-table-tbody'])[2]//tr//td[7]//div[contains(@class,'ng-star-inserted')]";
	String residualMaturity = "(//tbody[@class='ui-table-tbody'])[2]//tr//td[9]//div[contains(@class,'ng-star-inserted')]";
	String excludedLoansCheckbox = "(//tbody[@class='ui-table-tbody'])[2]//tr//td[11]//div[@class='ng-star-inserted']";
	String CurrentLoanAmountCorrespondingToLoan = "//a[text()=' locatorValue ']//parent::div//parent::div//parent::td//following-sibling::td[4]//div[contains(@class,'ng-star-inserted')]";
	String allocatedAmountCorrespondingToLoan = "//a[text()=' locatorValue ']//parent::div//parent::div//parent::td//following-sibling::td[5]//div[contains(@class,'ng-star-inserted')]";
	String excludeCheckboxCorrespondingToLoan = "//a[text()=' locatorValue ']//parent::div//parent::div//parent::td//following-sibling::td[9]//div[contains(@class,'ng-star-inserted')]//span";

	// Step 3 - Reallocate Loans
	String reallocateLoansStep = "//div[contains(text(),'Step 3')]/../preceding-sibling::a/..";
	String step3 = "//a[contains(@href,'step3')]//span";
	String target = "//th[text()='Target']";

	// Step 4 - Amend Allocations
	String amendAllocationsStep = "//div[contains(text(),'Step 4')]/../preceding-sibling::a/..";
	String step4 = "//a[contains(@href,'step4')]//span";
	String facilityAmount = "//th[text()='Facility Amount']";
	String compliance = "//th[text()='Compliance']";
	String facilitiesAmounts = "//tbody//tr[@class='ng-star-inserted']//td[locatorValue]";
	String revisedFacilitiesAmounts = "//tbody//tr[@class='ng-star-inserted']//td[locatorValue]//input";
	String facilitiesInStep4 = "//a[contains(@href,'/loan-facility/LFSummary/')]";

}
