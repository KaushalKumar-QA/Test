package com.locators.allPages;

public interface FundingInterestPaymentPO {

	String compile = "//div[contains(text(),'Compile')]";
	String health = "//div[contains(text(),'Health')]";
	String monthOnMonthComparison = "//div[contains(text(),'Month on Month Comparison')]";
	String returnAnalysis = "//div[contains(text(),'Return Analysis')]";
	String accounting = "//div[contains(text(),'Accounting')]";

	// Step 1 - Compile
	String compileStep = "//div[contains(text(),'Step 1')]/../preceding-sibling::a/..";
	String compileStepSymbol = "(//a[@class='m-wizard__step-number']//span)[1]";
	String allFacilities = "//li[@class='ng-star-inserted']";
	String yearDropDown = "(//div//select[contains(@class,'form-control max-input-width')])[1]";
	String monthDropDown = "(//div//select[contains(@class,'form-control max-input-width')])[2]";
	String calStartDate = "//label[text()=' Calculation Start Date']//..//p";
	String calEndDate = "//label[text()=' Calculation End Date']//..//p";
	String todaysDate = "//label[contains(text(),'Today')]//..//p";

	String selectedDate = "//th[text()='Selected Date']";
	String LaunchDate = "//th[text()='Launch Date']";
	String scheduled = "//th[text()='Scheduled']";
	String view = "//th[text()=' View ']";

	String selectedDateValues = "//tr[@class='ng-star-inserted']//td[1]";
	String launchDateValues = "//tr[@class='ng-star-inserted']//td[2]";
	String scheduledValues = "//tr[@class='ng-star-inserted']//td[3]";
	String viewValues = "//tr[@class='ng-star-inserted']//td[4]";
	String firstViewInterestButton = "(//button[text()=' View Interest '])[1]";

	// Step 2 - Health
	String healthStep = "//div[contains(text(),'Step 2')]/../preceding-sibling::a/..";
	String healthStepSymbol = "(//a[@class='m-wizard__step-number']//span)[2]";
	String healthStep2 = "//a[contains(@href,'health')]";
	String systemHealthCheckValue = "//label[text()='locatorValue']//following-sibling::div//p";
	String healthChecksValue = "//label[text()='locatorValue']//following-sibling::div//label";

	String interestPaymentDateLabel = "//label[text()=' Interest Payment Date']";
	String interestPaymentDateField = "//label[text()=' Interest Payment Date']//..//div/p";
	String calculationStartDateLabel = "//label[text()=' Calculation Start Date']";
	String calculationStartDateField = "//label[text()=' Calculation Start Date']//..//div/p";
	String calculationEndDateLabel = "//label[text()=' Calculation End Date']";
	String calculationEndDateField = "//label[text()=' Calculation End Date']//..//div/p";
	String systemHealthCheck = "//label[text()=' System Health Check']";
	String allAllocationsBalanced = "//label[text()=' All Allocations Balanced']";
	String allAllocationFourSideArrowIcon = "//label[text()=' All Allocations Balanced']//..//i[@class='fa fa-arrows-alt']";
	String nimAnalysis = "//label[text()=' NIM Analysis']";
	String nimAnalysisFourSideArrowIcon = "//label[text()=' NIM Analysis']//..//i[@class='fa fa-arrows-alt']";
	String reserves = "//label[text()=' Reserves']";
	String reservesFourSideArrowIcon = "//label[text()=' Reserves']//..//i[@class='fa fa-arrows-alt']";
	String reserveReleases = "//label[text()=' Reserve Releases']";
	String reserveReleasesFourSideArrowIcon = "//label[text()=' Reserve Releases']//..//i[@class='fa fa-arrows-alt']";
	String forecastTolerance = "//label[text()=' Forecast Tolerance']";
	String bridgeLoanRateDifferenceTolerance = "//label[text()=' Bridge Loan Rate Difference Tolerance']";
	String facilityRateMaxDifferenceTolerance = "//label[text()=' Facility Rate Max Difference Tolerance']";
	String tolerance = "//p[text()='Tolerance']";
	String facility = "//label[text()='Facility']";
	String carriedForward = "//label[text()='Carried Forward']";
	String forecasted = "//label[text()='Forecasted']";
	String difference = "//label[text()='Difference (%)']";
	String dayCountFraction = "//h4[text()='Day Count Fraction']";
	String dayCountFractionTable = "//h4[text()='Day Count Fraction']//..//following::div[1][@class='scrolling-wrapper']";
	String deferredInterestCheck = "//h4[text()='Deferred Interest Check']";
	String deferredInterestCheckTable = "//h4[text()='Deferred Interest Check']//..//following::div[1][@class='scrolling-wrapper']";
	String deploymentChangeCheck = "//h4[text()='Deployment Change Check (Weighted Average)']";
	String deploymentChangeCheckTable = "//h4[text()='Deployment Change Check (Weighted Average)']//..//following::div[1][@class='scrolling-wrapper']";
	String rateChangesCheck = "//h4[text()='Rate Changes Check (by Deployment and Cohort)']";
	String rateChangesCheckTable = "//h4[text()='Rate Changes Check (by Deployment and Cohort)']//..//following::div[1][@class='scrolling-wrapper']";
	String regularInterestCheck = "//h4[text()='Regular Interest Check']";
	String regularInterestCheckATable = "//h4[text()='Regular Interest Check']//..//following::div[1][@class='scrolling-wrapper']";
	String backStepButton = "//button[text()=' Back Step ']";
	String nextStepButton = "//button[text()=' Next Step ']";
	String newPaymentLinkText = "//button[@class='btn btn-outline-danger ng-star-inserted']//p";
	String reCalculateToleranceButton = "//button[text()=' Re-Calculate Tolerance ']";
	String facilityAllocationTable = "//div[contains(@class,'no-padding ng-star-inserted')]//div";
	String deferredInternalReferenceColumn = "(//p[text()='Internal Reference'])[1]";
	String deferredReferenceColumn = "(//p[text()='Reference'])[1]";
	String deferredLastMonthColumn = "(//p[text()='Last Month'])[1]";
	String deferredThisMonthColumn = "(//p[text()='This Month'])[1]";
	String deferredChangeColumn = "(//p[text()='Change'])[1]";
	String deferredDayCountColumn = "(//p[text()='Last Month / This Month]'])[1]";
	String deferredthisMonthSumAmount = "(//p[text()='This Month']//parent::div//following::p)[5]";
	String deferredLastMonthSumAmount = "(//p[text()='Last Month']//parent::div//following::p)[5]";
	String deferredChangeSumAmount = "(//p[text()='Change']//parent::div//following::p)[5]";
	String forecastToleranceField = "//label[text()=' Forecast Tolerance']//parent::div//p[contains(@class,'current')]";

	String rateCohortColumnName = "//p[text()='Rate Cohort']";
	String lastMonthDeploymentColumnName = "//p[text()='Last Month Deployment']";
	String thisMonthDeploymentColumnName = "//p[text()='This Month Deployment']";
	String rateChangesChageColumnName = "(//p[text()='Change'])[3]";
	String thisMonthRateCohortLoan = "//p[text()='Rate Cohort']//ancestor::div[contains(@class,'d-inline-flex')]//parent::div//following-sibling::div//p[text()='Sum']//parent::div//following-sibling::div[2]";

	// Deferred Interest Check Table
	String internalReferenceValue = "//h4[text()='Deferred Interest Check']//following::div[1][@class='scrolling-wrapper']//p[text()='locatorValue']//parent::div//preceding-sibling::div";
	String referenceValue = "//h4[text()='Deferred Interest Check']//following::div[1][@class='scrolling-wrapper']//p[text()='locatorValue']";
	String lastMonthValue = "//h4[text()='Deferred Interest Check']//following::div[1][@class='scrolling-wrapper']//p[text()='locatorValue']//parent::div//following-sibling::div[1]//p";
	String thisMonthValue = "//h4[text()='Deferred Interest Check']//following::div[1][@class='scrolling-wrapper']//p[text()='locatorValue']//parent::div//following-sibling::div[2]//p";
	String dayCountValue = "//h4[text()='Deferred Interest Check']//following::div[1][@class='scrolling-wrapper']//p[text()='locatorValue']//parent::div//following-sibling::div[4]//p";
	String allReferenceValues = "//h4[text()='Deferred Interest Check']//following::div[1][@class='scrolling-wrapper']//p[contains(text(),'LB')]";
	String allDayCountValues = "//h4[text()='Deferred Interest Check']//following::div[1][@class='scrolling-wrapper']//p[contains(text(),'LB')]//parent::div/following-sibling::div[4]//p";

	// Allocations Balanced Details Poup
	String allocationsBalancedPopup = "//div[@class='modal-content modal-content-custom']";
	String allocationsBalancedPopupHeader = "//h4[text()='Allocations Balanced Details']";
	String allocationsBalancedAnalysis = "//label[text()=' Allocations Balanced Analysis']";
	String detailsArrowIcon = "//p[contains(text(),' Details ')]";
	String detailsUpSideArrowIcon = "//i[contains(@class,'double-up')]";
	String dateDifference = "//th[text()=' Date Difference ']";
	String amountDifference = "//th[text()=' Amount Difference ']";
	String dateDifferenceValues = "//td[1][contains(@class,'ui-resizable-column')]//div[@class='ng-star-inserted']";
	String amountDifferenceValues = "//td[2][contains(@class,'ui-resizable-column')]//div[@class='ng-star-inserted']";

	String dates = "//table[contains(@class,'custom-data-table')]//th[contains(@class,'ng-star-inserted')]";
	String differences = "//td[text()=' Difference ']//parent::tr//td[contains(@class,'inserted')]";
	String loanAllocations = "//td[text()=' Loan Allocation ']//parent::tr//td[contains(@class,'ng')]";
	String facilityAllocations = "//td[text()=' Facility Allocation ']//parent::tr//td[contains(@class,'ng')]";
	String facilityAllAllocations = "//a[text()=' locatorValue ']//parent::td//parent::tr";
	String facilityAllocationAllDates = "//a[text()=' locatorValue ']//parent::td//parent::tr//td";
	String allFacilitiesRefList = "//table[contains(@class,'custom-data-table')]//tr//a[contains(text(),' F00')]";

	String dateDifferenceSortIcon = "//th[contains(text(),' Date Difference ')]//i[contains(@class,'ui-sortable-column-icon')]";
	String amountDifferenceSortIcon = "//th[contains(text(),' Amount Difference ')]//i[contains(@class,'ui-sortable-column-icon')]";
	String closeButton = "//button[text()=' Close']";

	// NIM Analysis Details Poup
	String nimAnalysisPopup = "//div[@class='modal-content modal-content-custom']";
	String nimAnalysisPopupHeader = "//h4[text()='NIM Analysis Details']";
	String interestIncomeField = "//label[text()=' Interest Income']//parent::div//p[contains(@class,'max-input-width')]";
	String interestExpenseField = "//label[text()=' Interest Expense']//parent::div//p[contains(@class,'max-input-width')]";
	String netInterestMarginField = "//div[contains(@class,'col-lg')]//label[text()=' Net Interest Margin']//parent::div//p[contains(@class,'max-input-width')]";
	String nimCheck = "//label[text()=' NIM Check ']//parent::div//p[contains(@class,'badge')]";
	String cashInterestField = "//label[text()=' Cash Interest']//parent::div//p[contains(@class,'max-input-width')]";
	String regularInterestField = "//label[text()=' Regular Interest']//parent::div//p[contains(@class,'max-input-width')]";
	String defaultInterestField = "//label[text()=' Default Interest']//parent::div//p[contains(@class,'max-input-width')]";
	String netInterestMarginsField = "//label[text()=' Net Interest Margin']//parent::div//div[contains(@class,' col-xs')]";
	String facilityTotalsCashInterest = "(//td[text()=' Cash Interest ']//parent::tr//td[contains(text(),'£')])[1]";
	String loansRegularInterest = "//td[text()=' Regular Interest ']//parent::tr//td[2]";
	String facilityTotalsRegularInterest = "//td[text()=' Regular Interest ']//parent::tr//td[3]";
	String loansDefaultInterestPaid = "//td[text()=' Default Interest Paid ']//parent::tr//td[2]";
	String facilityTotalsDefaultInterestPaid = "//td[text()=' Default Interest Paid ']//parent::tr//td[3]";
	String facilityDataTable = "(//div[@class='bottom-separation']//parent::div)[1]";
	String loansColumn = "(//th[text()=' Loans '])[1]";
	String facilityTotalsColumn = "(//th[text()=' Facility Totals '])[1]";
	String facilityRefList = "//th[text()=' - ']//parent::tr//a[contains(text(),'F0')]";
	String interestIncome = "//td[text()=' Interest Income ']//parent::tr";
	String interestExpense = "//td[text()=' Interest Expense ']//parent::tr";
	String cashInterest = "//td[text()=' Cash Interest ']//parent::tr";
	String regularInterest = "//td[text()=' Regular Interest ']//parent::tr";
	String reserveDetails = "//th[text()=' Reserve Details ']";
	String loans = "//th[text()=' Reserve Details ']//following-sibling::th[text()=' Loans ']";
	String facilityTotals = "(//th[text()=' Facility Totals '])[2]";
	String defaultInterest = "//td[text()=' Default Interest ']//parent::tr";
	String defaultInterestPaid = "//td[text()=' Default Interest Paid ']//parent::tr";
	String anyFacilityInterestExpenseAmount = "(//a[text()=' locatorValue ']//ancestor::tr//following::tr[2]//td)[4]";
	String anyFacilityCashInterestAmount = "(//a[text()=' locatorValue ']//ancestor::tr//following::tr[3]//td)[4]";
	String anyFacilityRegualrInterestAmount = "(//a[text()=' locatorValue ']//ancestor::tr//following::tr[4]//td)[4]";
	String loansDefaultInterestAmount = "//td[text()=' Default Interest ']//following-sibling::td[1]";
	String anyFacilityDefaultInterest = "(//a[text()=' locatorValue ']//ancestor::tr//following::tr[1]//td[4])[2]";
	String anyFacilityDefaultInterestPaid = "(//a[text()=' locatorValue ']//ancestor::tr//following::tr[2]//td[4])[2]";

	// Facility table
	String facilityLoanAmount = "(//p[text()='Loan']//parent::div//following-sibling::div//p)[1]";
	String anyFacilityLoanAmount = "(//p[text()='locatorValue']//parent::div//following-sibling::div//p)[1]";
	String totalLoanAmount = "(//p[text()='Total']//parent::div//following-sibling::div//p)[1]";
	String facilitiesLoanAmount = "//p[text()='Total']//parent::div//parent::div//following-sibling::span//div[@class='standard-cell-style'][2]";
	String facilityRefInFacilityTable = "//p[text()='locatorValue']";

	String carriedForwardText = "//label[text()='Carried Forward']";
	String facilityCarriedForwardLoanAmount = "(//p[text()='Loan']//parent::div//following-sibling::div//p)[2]";
	String totalCarriedForwardAmount = "(//p[text()='Total']//parent::div//following-sibling::div//p)[2]";
	String facilitiesCarriedForwardAmount = "//p[text()='Total']//parent::div//parent::div//following-sibling::span//div[@class='standard-cell-style'][3]";
	String facilitiesCarriedForwardAmountInStep3 = "//p[text()='Loan']//parent::div//parent::div//following-sibling::div//div[@class='standard-cell-style'][3]";

	String facilityForecastedLoanAmount = "(//p[text()='Loan']//parent::div//following-sibling::div//p)[3]";
	String facilitiesForecastedAmount = "//p[text()='Total']//parent::div//parent::div//following-sibling::span//div[@class='standard-cell-style'][4]";
	String totalDifferencePercentage = "(//p[text()='Loan']//parent::div//following-sibling::div//p)[4]";
	String facilitiesDifferencePercentage = "//p[text()='Total']//parent::div//parent::div//following-sibling::span//div[@class='standard-cell-style'][5]";

	// for forecastTable, forecast diff Table
	String forecastTableInStep3 = "//label[text()='locatorValue']//parent::div//following-sibling::div//p";

	// day count fraction
	String lastPeriodNumberOfDays = "//p[text()='Last Period Number of Days']";
	String thisPeriodNumberOfDays = "//p[text()='This Period Number of Days']";
	String lastMonthDCF = "//p[text()='Last Month DCF']";
	String thisMonthDCF = "//p[text()='This Month DCF']";
	String DCFAdjustment = "//p[text()='DCF Adjustment']";

	String lastPeriodNumberOfDaysValue = "(//p[text()='DCF Adjustment']//parent::div//parent::div[contains(@class,'d-inline-flex')]//parent::div[contains(@class,'row')]//following-sibling::div[contains(@class,'row')]//p)[1]";
	String thisPeriodNumberOfDaysValue = "(//p[text()='DCF Adjustment']//parent::div//parent::div[contains(@class,'d-inline-flex')]//parent::div[contains(@class,'row')]//following-sibling::div[contains(@class,'row')]//p)[2]";
	String lastMonthDCFValue = "(//p[text()='DCF Adjustment']//parent::div//parent::div[contains(@class,'d-inline-flex')]//parent::div[contains(@class,'row')]//following-sibling::div[contains(@class,'row')]//p)[3]";
	String thisMonthDCFValue = "(//p[text()='DCF Adjustment']//parent::div//parent::div[contains(@class,'d-inline-flex')]//parent::div[contains(@class,'row')]//following-sibling::div[contains(@class,'row')]//p)[4]";
	String DCFAdjustmentValue = "(//p[text()='DCF Adjustment']//parent::div//parent::div[contains(@class,'d-inline-flex')]//parent::div[contains(@class,'row')]//following-sibling::div[contains(@class,'row')]//p)[5]";

	// Step 3 - month-on-month-comparison
	String monthOnMonthComparisonStep3 = "//a[contains(@href,'month-on-month-comparison')]";
	String monthOnMonthComparisonStep = "//div[contains(text(),'Step 3')]/parent::div//parent::div[contains(@class,'step--current')]";
	String dataTableInStep3 = "//div[@class='scrolling-wrapper']";
	String thisMonthPayableLoanAmount = "(//p[text()='Loan']//parent::div//following-sibling::div//p)[1]";
	String thisMonthPayableTable = "//p[text()='Loan']//parent::div//parent::div//following-sibling::div//div[@class='standard-cell-style'][2]";
	String forecastTable = "//label[text()='locator']//ancestor::div[contains(@class,'mx-4')]//p";

	// priorMonthPayment
	String loanPriorMonthPayment = "//label[text()='Prior Month Payment']//parent::div[contains(@class,'row')]//parent::div//div[@class='row']";
	String priorMonthPayments = "//label[text()='Prior Month Payment']//parent::div[contains(@class,'row')]//parent::div//div[contains(@class,'ng-star-inserted')]";

	// step3 popup
	String popUp = "//div[@class='modal-content']";
	String crossIcon = "//div[@class='modal-content']//button[@class='close']";
	String popUpHeaderText = "//h4[text()='locatorValue']";
	String firstValue = "(//div[contains(@class,'second-row-spacing')]//p)[1]";
	String secondValue = "(//div[contains(@class,'second-row-spacing')]//p)[2]";
	String thirdValue = "(//div[contains(@class,'second-row-spacing')]//p)[3]";
	String fourthValue = "(//div[contains(@class,'second-row-spacing')]//p)[4]";
	String fifthValue = "(//div[contains(@class,'second-row-spacing')]//p)[5]";
	String blueSingleColumnTable = "//label[text()='locatorValue']//ancestor::div[contains(@class,'mx-4')]//div//p";

	// deferral
	String deferralPlusButton = "//label[text()='Deferral']//following-sibling::div//button";
	String deferralSection = "//label[text()='Deferral']//parent::div[@class='row']//parent::div[contains(@class,'mx-4')]";
	String deferralLastMonth = "//label[text()='Deferral']//parent::div[@class='row']//parent::div[contains(@class,'mx-4')]//label[text()='Last Month']";
	String deferralThisMonth = "//label[text()='Deferral']//parent::div[@class='row']//parent::div[contains(@class,'mx-4')]//label[text()='this Month']";
	String deferralDifference = "//label[text()='Deferral']//parent::div[@class='row']//parent::div[contains(@class,'mx-4')]//label[text()='Difference']";
	String deferralLastMonthLoanValue = "(//label[text()='Deferral']//ancestor::div[contains(@class,'mx-4')]//div[@class='row']//p)[1]";
	String deferralThisMonthLoanValue = "(//label[text()='Deferral']//ancestor::div[contains(@class,'mx-4')]//div[@class='row']//p)[2]";
	String deferralLastMonthValue = "(//label[text()='Deferral']//ancestor::div[contains(@class,'mx-4')]//div[contains(@class,'ng-star-inserted')]//p)[3]";
	String deferralLastMonthValues = "//label[text()='Deferral']//ancestor::div[contains(@class,'mx-4')]//div[contains(@class,'row ng-star-inserted')]//div[1]//p";
	String deferralThisMonthValue = "(//label[text()='Deferral']//ancestor::div[contains(@class,'mx-4')]//div[contains(@class,'ng-star-inserted')]//p)[4]";
	String deferralThisMonthValues = "//label[text()='Deferral']//ancestor::div[contains(@class,'mx-4')]//div[contains(@class,'row ng-star-inserted')]//div[2]//p";
	String deferralDifferenceValue = "(//label[text()='Deferral']//ancestor::div[contains(@class,'mx-4')]//div[contains(@class,'ng-star-inserted')]//p)[5]";
	String deferralFirstIButtonsAfterLoan = "(//label[text()='Deferral']//ancestor::div[contains(@class,'mx-4')]//div[@class='btn-adjust']//button[contains(@class,'btn-circle')])[2]";

	String lastPeriodNumberDaysValue = "(//div[contains(@class,'row')][2]//p[contains(@class,'current-amount-p')])[1]";
	String thisPeriodNumberDaysValue = "(//div[contains(@class,'row')][2]//p[contains(@class,'current-amount-p')])[2]";
	String lastMonthDCFValueInStep3 = "(//div[contains(@class,'row')][2]//p[contains(@class,'current-amount-p')])[3]";
	String thisMonthDCFValueInstep3 = "(//div[contains(@class,'row')][2]//p[contains(@class,'current-amount-p')])[4]";
	String dCFAdjustmentValueInstep3 = "(//div[contains(@class,'row')][2]//p[contains(@class,'current-amount-p')])[5]";
	String differenceToleranceValue = "(//div[contains(@class,'row')][2]//p[contains(@class,'current-amount-p')])[6]";

	// deferralPopUp
	String currentPeriodDeferred = "//p[text()='Current Period Deferred']";
	String lastPeriodDeferred = "//p[text()='Last Period Deferred']";
	String differenceTextInPopup = "//p[text()='Difference']";

	// Deployment
	String deploymentPlusButton = "//label[text()='Deployment']//following-sibling::div//button";
	String deploymentSection = "//label[text()='Deployment']//parent::div[@class='row']//parent::div[contains(@class,'mx-4')]";
	String deploymentLastMonth = "//label[text()='Deployment']//parent::div[@class='row']//parent::div[contains(@class,'mx-4')]//label[text()='Last Month']";
	String deploymentThisMonth = "//label[text()='Deployment']//parent::div[@class='row']//parent::div[contains(@class,'mx-4')]//label[text()='this Month']";
	String deploymentDifference = "//label[text()='Deployment']//parent::div[@class='row']//parent::div[contains(@class,'mx-4')]//label[text()='Difference']";
	String deploymentLastMonthLoanValue = "(//label[text()='Deployment']//ancestor::div[contains(@class,'mx-4')]//div[@class='row']//p)[1]";
	String deploymentThisMonthLoanValue = "(//label[text()='Deployment']//ancestor::div[contains(@class,'mx-4')]//div[@class='row']//p)[2]";
	String deploymentLastMonthValue = "(//label[text()='Deployment']//ancestor::div[contains(@class,'mx-4')]//div[contains(@class,'ng-star-inserted')]//p)[4]";
	String deploymentLastMonthValues = "//label[text()='Deployment']//ancestor::div[contains(@class,'mx-4')]//div[contains(@class,'row ng-star-inserted')]//div[1]//p";
	String deploymentThisMonthValue = "(//label[text()='Deployment']//ancestor::div[contains(@class,'mx-4')]//div[contains(@class,'ng-star-inserted')]//p)[5]";
	String deploymentThisMonthValues = "//label[text()='Deployment']//ancestor::div[contains(@class,'mx-4')]//div[contains(@class,'row ng-star-inserted')]//div[2]//p";
	String deploymentDifferenceValue = "(//label[text()='Deployment']//ancestor::div[contains(@class,'mx-4')]//div[contains(@class,'ng-star-inserted')]//p)[6]";
	String deploymentFirstIButtonsAfterLoan = "(//label[text()='Deployment']//ancestor::div[contains(@class,'mx-4')]//div[@class='btn-adjust']//button[contains(@class,'btn-circle')])[2]";

	// Deployment PopUp
	String lastMonthWADeployment = "//p[text()='Last Month WA Deployment']";
	String thisMonthWADeployment = "//p[text()='This Month WA Deployment']";
	String monthDeploymentDelta = "//p[text()='Monthly Deployment Delta']";
	String lastMonthInterest = "//p[text()='Last Month Interest (Total)']";
	String deploymentCalculation = "//p[text()='Deployment Calculation']";

	// Rate
	String ratePlusButton = "//label[text()='Rate']//following-sibling::div//button";
	String rateSection = "//label[text()='Rate']//parent::div[@class='row']//parent::div[contains(@class,'mx-4')]";
	String rateLastMonth = "//label[text()='Rate']//parent::div[@class='row']//parent::div[contains(@class,'mx-4')]//label[text()='Last Month']";
	String rateThisMonth = "//label[text()='Rate']//parent::div[@class='row']//parent::div[contains(@class,'mx-4')]//label[text()='this Month']";
	String rateDifference = "//label[text()='Rate']//parent::div[@class='row']//parent::div[contains(@class,'mx-4')]//label[text()='Difference']";
	String rateLastMonthValue = "(//label[text()='Rate']//ancestor::div[contains(@class,'mx-4')]//div[contains(@class,'ng-star-inserted')]//p)[4]";
	String rateThisMonthValue = "(//label[text()='Rate']//ancestor::div[contains(@class,'mx-4')]//div[contains(@class,'ng-star-inserted')]//p)[5]";
	String rateDifferenceValue = "(//label[text()='Rate']//ancestor::div[contains(@class,'mx-4')]//div[contains(@class,'ng-star-inserted')]//p)[6]";
	String rateFirstIButtonsAfterLoan = "(//label[text()='Rate']//ancestor::div[contains(@class,'mx-4')]//div[@class='btn-adjust']//button[contains(@class,'btn-circle')])[2]";

	// Rate PopUp
	String lastMonthBridgeLoanRate = "//p[text()='Last Month Bridge Loan Rate']";
	String thisMonthBridgeLoanRate = "//p[text()='This Month Bridge Loan Rate']";
	String monthDifferenceRate = "//p[text()='Monthly Difference']";
	String lastMonthInterestRate = "//p[text()='Last Month Interest (Total)']";
	String rateCalculation = "//p[text()='Rate Calculation']";
	String lastMonthRates = "//label[text()='Rate']//parent::div//following-sibling::div//div[1]";
	String thisMonthRates = "//label[text()='Rate']//parent::div//following-sibling::div//div[2]";

	// Day Count step3
	String dayCountFirstIButtonsAfterLoan = "(//label[text()='Day Count']//ancestor::div[contains(@class,'mx-4')]//button[contains(@class,'btn-circle')])[2]";
	String dayCountSection = "//label[text()='Day Count']//parent::div[contains(@class,'row')]//parent::div[contains(@class,'mx-4')]";
	String dayCountCalculationValueInTable = "(//label[text()='Day Count']//parent::div[contains(@class,'row')]//parent::div[contains(@class,'mx-4')]//div[contains(@class, ng-star-inserted)]//div[@class='standard-cell-style'])[2]";
	String lastMonthDCFDayCount = "//div[@class='modal-body']//p[text()='Last Month DCF']";
	String thisMonthDCFDayCount = "//div[@class='modal-body']//p[text()='This Month DCF']";
	String monthDeltaDayCount = "//p[text()='Monthly Delta']";
	String lastMonthInterestDayCount = "//p[text()='Last Month Interest (Total)']";
	String dayCountCalculation = "//p[text()='Day Count Calculation']";

	// Step 4 - returnAnalysis
	String returnAnalysisStep4 = "//a[contains(@href,'returnAnalysis')]";
	String returnAnalysisSymbol = "//a[contains(@href,'returnAnalysis')]//span";
	String returnAnalysisStep = "//div[contains(text(),'Step 4')]/parent::div//parent::div[contains(@class,'step--current')]";
	String facilitiesReferenceInStep4 = "//p[text()='Loan']//parent::div//parent::div[@class='row']//following-sibling::div[contains(@class,'row ng-star-inserted')]//div[1]";

	String facilityIButton = "(//i[contains(@class,'circle')])[2]";
	String loanIButton = "//p[text()='Loan']//parent::div//parent::div//i[contains(@class,'circle')]";
	String dynamicFacilityIButton = "//p[text()='locatorValue']//parent::div//following-sibling::div//i[contains(@class,'fa-info-circle')]";
	String facilitiesPayableAmountInStep4 = "//p[text()='Loan']//parent::div//parent::div[@class='row']//following-sibling::div[contains(@class,'row ng-star-inserted')]//div[2]";
	String facilitiesCarridForwardAmountInStep4 = "//p[text()='Loan']//parent::div//parent::div[@class='row']//following-sibling::div[contains(@class,'row ng-star-inserted')]//div[4]";

	String CashAmount = "//th[text()='Cash Amount']//following-sibling::td";

	// Ste4 >> Loan i button >> Loan details
	String loanRegularInterest = "//th[text()='Loan Regular Interest ']";
	String loanRegularInterestAmount = "//th[text()='Loan Regular Interest ']//following-sibling::td[2]";
	String loanDefaultInterest = "//th[text()=' Loan Default Interest ']";
	String loanDefaultInterestAmount = "//th[text()=' Loan Default Interest ']//following-sibling::td[2]";
	String loanDefaultInterestPaid = "//th[text()='Loan Default Interest Paid ']";
	String loanDefaultInterestPaidAmount = "//th[text()='Loan Default Interest Paid ']//following-sibling::td[2]";
	String loansDefaultInterest = "//th[text()=' Loan Default Interest ']//following-sibling::td[2]";
	String defaultInterestAmount = "(//th[text()='Default Interest']//ancestor::thead//following::td[contains(text(),' £')])[2]";
	String defaultInterestPaidAmount = "(//th[text()='Default Interest Paid']//ancestor::thead//following::td[contains(text(),' £')])[5]";

	// Ste4 >> Loan i button >> current month calculation
	String interestPayment = "//th[text()='Interest Payment Amount']";
	String interestPaymentAmount = "//th[text()='Interest Payment Amount']//following-sibling::td";
	String regularInterests = "//th[text()='Regular Interest']";
	String regularInterestAmount = "//th[text()='Regular Interest']//following-sibling::td";
	String interestRelease = "//th[text()='Interest Release']";
	String interestReleaseAmount = "//th[text()='Interest Release']//following-sibling::td";
	String cashAmount = "//th[text()='Cash Amount']";
	String cashAmountValue = "//th[text()='Cash Amount']//following-sibling::td";
	String deferredInterestCF = "//th[text()='Deferred Interest C/F']";
	String deferredInterestCFAmount = "//th[text()='Deferred Interest C/F']//following-sibling::td";
	String deferredInterestBF = "//th[text()='Deferred Interest B/F']";
	String deferredInterestBFAmount = "//th[text()='Deferred Interest B/F']//following-sibling::td";
	String deferredInterestThisPeriod = "//th[text()='Deferred Interest This Period']";
	String deferredInterestThisPeriodAmount = "//th[text()='Deferred Interest This Period']//following-sibling::td";
	String deferredInterestRelease = "//th[text()='Deferred Interest Release']";
	String deferredInterestReleaseAmount = "//th[text()='Deferred Interest Release']//following-sibling::td";

	// Ste4 >> Loan i button >> table
	String referenceColumnInLoan = "//td[@class='datatable-header-cell']";
	String regularDaysColumnInLoan = "//td[@class='custom-datatable-cell'][7]";
	String regularInterestsColumnInLoan = "//td[@class='custom-datatable-cell'][8]";
	String standardInterestDaysColumnInLoan = "//td[@class='custom-datatable-cell'][9]";
	String standardInterestsColumnInLoan = "//td[@class='custom-datatable-cell'][10]";
	String adjustmentColumnInLoan = "//td[@class='custom-datatable-cell'][12]";
	String defaultInterestPaidColumnInLoan = "//td[@class='custom-datatable-cell'][13]";
	String broughtForwardColumnInLoan = "//td[@class='custom-datatable-cell'][14]";
	String carriedForwardColumnInLoan = "//td[@class='custom-datatable-cell'][15]";
	String rowsInLoan = "//td[@class='custom-datatable-cell']//parent::tr";

	// Ste4 >> Facilities i button >> table
	String defaultInterestPaidColumnInFacility = "//td[@class='custom-datatable-cell'][7]";
	String defaultInterestSumInFacility = "//a[contains(text(),'Sum')]//parent::td//following-sibling::td[contains(@class,'custom-datatable-cell')][16]";
	String defaultInterestPaidSumInFacility = "//a[contains(text(),'Sum')]//parent::td//following-sibling::td[contains(@class,'custom-datatable-cell')][19]";
	String adjustmentCashRow = "//td[contains(text(),'Cash')]//parent::tr//following-sibling::td[position()=last()-4]";
	String rowsInFacility = "//a[contains(text(),'Sum')]//parent::td//parent::tr//following-sibling::tr[contains(@class,'ng-star-inserted')]";
	String referenceColumnInFacility = "//a[contains(text(),'Sum')]//parent::td//parent::tr//following-sibling::tr[contains(@class,'ng-star-inserted')]//td[1]";
	String standardDefaultDaysColumnInFacility = "//td[@class='custom-datatable-cell']//parent::tr//following-sibling::tr[contains(@class,'ng-star-inserted')]//td[position()=last()-12]";
	String regularDaysColumnInFacility = "//td[@class='custom-datatable-cell']//parent::tr//following-sibling::tr[contains(@class,'ng-star-inserted')]//td[position()=last()-11]";
	String datesInFacility = "//th[contains(text(),'Reference')]//following-sibling::th[contains(@class,'ng-star-inserted')]";

	// Bridge Loan Table
	String bridgeLoanTable1 = "//label[text()='Facility']//ancestor::div[contains(@class,'col-sm')]";
	String bridgeLoanTable2 = "//label[text()=' Bridge Loan']//ancestor::div[contains(@class,'col-sm')]";
	String facilityColumnName = "//label[text()='Facility']";
	String payableColumnName = "//label[text()='Payable']";
	String carriedForwardColumnName = "//label[text()='Carried Forward']";
	String bridgeLoanCalculatedColumnName = "//label[text()=' Bridge Loan']//ancestor::div[contains(@class,'col-sm')]//label[text()='Calculated']";
	String bridgeLoanLastMonthColumnName = "//label[text()=' Bridge Loan']//ancestor::div[contains(@class,'col-sm')]//label[text()='Last Month']";
	String bridgeLoanSystemColumnName = "//label[text()=' Bridge Loan']//ancestor::div[contains(@class,'col-sm')]//label[text()='System']";
	String facilityNumbers = "//div[contains(@class,'col-sm')]//p[contains(text(),'F')]";
	String bridgeLoanLastMonth = "//label[text()=' Bridge Loan']//ancestor::div[contains(@class,'col-sm-3')]//div//following-sibling::div//p[2]";
	String bridgeLoanCalculated = "//label[text()=' Bridge Loan']//ancestor::div[contains(@class,'col-sm-3')]//div//following-sibling::div//p[1]";

	// Facility Rate Table Step4
	String facilityRateTable = "//label[text()='Facility Rate']//ancestor::div[contains(@class,'col-sm')]";
	String facilityRateCalculatedColumnName = "//label[text()='Facility Rate']//ancestor::div[contains(@class,'col-sm')]//following::label[text()='Calculated']";
	String facilityRateLastMonthColumnName = "//label[text()='Facility Rate']//ancestor::div[contains(@class,'col-sm')]//following::label[text()='Last Month']";
	String facilityRateSystemColumnName = "//label[text()='Facility Rate']//ancestor::div[contains(@class,'col-sm')]//following::label[text()='System']";

	String lastMonthRatesInStep4 = "//label[text()='Facility Rate']//ancestor::div[contains(@class,'col-sm-3')]//div//following-sibling::div//p[2]";
	String systemRatesInStep4 = "//label[text()='Facility Rate']//ancestor::div[contains(@class,'col-sm-3')]//div//following-sibling::div//p[3]";

	// Actual Rate Table
	String actualRateTable = "//label[text()='Actual Rate']//ancestor::div[contains(@class,'col-sm')]";
	String annualColumnName = "//label[text()='Actual Rate']//ancestor::div[contains(@class,'col-sm')]//following::label[text()='Annual']";

	// Loan Interest Details Popup //Interest Payment Details Popup
	String loanInterestDetailsPopup = "//div[contains(@class,'content-custom')]";
	String loanInterestDetailsPopupHeader = "//h4[text()='Loan Interest Details']";
	String loanDetailsSection = "//h4[text()='Loan Details']//parent::div[contains(@class,'col-sm')]";
	String monthonMonthComparisonSection = "//h4[text()='Month on Month Comparison']//parent::div[contains(@class,'col-sm')]";
	String currentMonthCalculationsSection = "//h4[text()='Current Month Calculations']//parent::div[contains(@class,'col-sm')]";
	String loanInterestDetailsPopupTable = "//th[text()=' Reference ']//ancestor::div[contains(@class,'col-md')]";

	String priorPayment = "//th[text()='Prior Payment']";
	String priorPaymentAmount = "//th[text()='Prior Payment']//following-sibling::td[2]";
	String changeDueTo = "//th[text()='Change due to:']";
	String dayCountFractions = "//th[contains(text(),'Day Count Fraction ')]";
	String dayCountFractionAmount = "//th[contains(text(),'Day Count Fraction ')]//following-sibling::td[2]";
	String lendingRates = "//th[contains(text(),'Lending Rates ')]";
	String lendingRatesAmount = "//th[contains(text(),'Lending Rates ')]//following-sibling::td[2]";
	String deployment = "//th[contains(text(),'Deployment ')]";
	String deploymentAmount = "//th[contains(text(),'Deployment ')]//following-sibling::td[2]";
	String cashInterests = "//th[contains(text(),'Cash Interest ')]";
	String cashInterestAmount = "//th[contains(text(),'Cash Interest ')]//following-sibling::td[2]";
	String interestDeferral = "//th[contains(text(),'Interest Deferral ')]";
	String interestDeferralAmount = "//th[contains(text(),'Interest Deferral ')]//following-sibling::td[2]";
	String totalChange = "//th[contains(text(),'Total change')]";
	String totalChangeAmount = "//th[contains(text(),'Total change')]//following-sibling::td[2]";
	String newPayment = "//th[contains(text(),'New Payment')]";
	String newPaymentAmount = "//th[contains(text(),'New Payment')]//following-sibling::td[2]";
	String changeSumValue = "(//p[text()='Change']//ancestor::div[contains(@class,'d-inline-flex')]//parent::div[contains(@class,'row')]//following-sibling::div[contains(@class,'row')]//p)[4]";

	// Table
	String reference = "//th[text()=' Reference ']";
	String facilityIIcon = "//p[text()='locatorValue']//parent::div//following-sibling::div//a[@class='icon-tab']";
	String scheduledRepaymentDate = "//th[text()=' Scheduled Repayment Date ']";
	String revisedRepaymentDate = "//th[text()=' Revised Repayment Date ']";
	String revisionDate = "//th[text()=' Revision Date ']";
	String actualRepaymentDate = "//th[text()=' Actual Repayment Date ']";
	String monthlyInterestRate = "//th[text()=' Monthly Interest Rate ']";
	String defaultInterestRate = "//th[text()=' Default Interest Rate ']";
	String regularDays = "//th[text()=' Regular Days ']";
	String regularInterestColumnName = "//th[text()=' Regular Interest ']";
	String standardInterestDays = "//th[text()=' Standard Interest Days ']";
	String standardInterest = "//th[text()=' Standard Interest ']";
	String expectedDefaultInterest = "//th[text()=' Expected Default Interest ']";
	String adjustment = "//th[text()=' Adjustment ']";
	String defaultInterestPaidColumnName = "//th[text()=' Default Interest Paid ']";
	String broughtForward = "//th[text()=' Brought Forward ']";
	String carriedForwardColumnNames = "//th[text()=' Carried Forward ']";

	String loanReferencenumbersValues = "//table//following::td[contains(@class,'header')]";
	String scheduledRepaymentDateValues = "//table//tr//td[2][contains(@class,'custom-datatable')]";
	String revisedRepaymentDateValues = "//table//tr//td[3][contains(@class,'custom-datatable')]";
	String revisionDateValues = "//table//tr//td[4][contains(@class,'custom-datatable')]";
	String actualRepaymentDateValues = "//table//tr//td[5][contains(@class,'custom-datatable')]";

	String referenceNumber = "//table//following::td[text()=' locatorValue ']";
	String monthlyInterestRateValue = "//td[text()=' locatorValue ']//following-sibling::td[5]";
	String defaultInterestRateValue = "//td[text()=' locatorValue ']//following-sibling::td[6]";
	String regularDaysValue = "//td[text()=' locatorValue ']//following-sibling::td[7]";
	String regularInterestValue = "//td[text()=' locatorValue ']//following-sibling::td[8]";
	String standardInterestDaysValue = "//td[text()=' locatorValue ']//following-sibling::td[9]";
	String standardInterestValue = "//td[text()=' locatorValue ']//following-sibling::td[10]";
	String defaultInterestPaidVal = "//td[text()=' locatorValue ']//following-sibling::td[13]";
	String broughtForwardValue = "//td[text()=' locatorValue ']//following-sibling::td[14]";
	String carriedForwardVal = "//td[text()=' locatorValue ']//following-sibling::td[15]";

	// Facility Interest Payment Details Popup
	String interestPaymentDetailsPopupHeader = "//h4[text()='Interest Payment Details']";
	String interestPaymentDetailsPopup = "//div[contains(@class,'modal-content-custom')]";

	// Interest Payment Details Popup - Facility Details Section
	String facilityDetailsSection = "//h4[text()='Facility Details']//parent::div[contains(@class,'sm')]";
	String facilityReference = "//th[text()='Facility Reference']";
	String facilityReferenceValue = "//th[text()='Facility Reference']//parent::tr//a";
	String startPeriod = "//th[text()='Start Period']";
	String startPeriodDate = "//th[text()='Start Period']//following-sibling::td[2]";
	String endPeriod = "//th[text()='End Period']";
	String endPeriodDate = "//th[text()='End Period']//following-sibling::td[2]";
	String facilityAmount = "//th[text()='Facility Amount']";
	String facilityAmountValue = "//th[text()='Facility Amount']//following-sibling::td[2]";
	String drawnAmount = "//th[text()='Drawn Amount']";
	String drawnAmountValue = "//th[text()='Drawn Amount']//following-sibling::td[2]";
	String cashRate = "//th[text()='Cash Rate']";
	String cashRateValue = "//th[text()='Cash Rate']//following-sibling::td[2]";

	String dayCountFractionIButton = "//th[contains(text(),'Day Count Fraction ')]//a[contains(@class,'tab-info-btn')]";
	String lendingRatesIButton = "//th[contains(text(),'Lending Rates ')]//a[contains(@class,'tab-info-btn')]";
	String deploymentIButton = "//th[contains(text(),'Deployment ')]//a[contains(@class,'tab-info-btn')]";
	String cashInterestIButton = "//th[contains(text(),'Cash Interest ')]//a[contains(@class,'tab-info-btn')]";
	String interestDeferralIButton = "//th[contains(text(),'Interest Deferral ')]//a[contains(@class,'tab-info-btn')]";

	String carriedForwardColumnSumAmount = "(//th[text()='Carried Forward']//ancestor::thead//following::td[contains(text(),' £')])[7]";
	String carriedOverColumnSumAmount = "(//th[text()='Carried Over']//ancestor::thead//following::td[contains(text(),' £')])[1]";
	String regualrInterestColumnSumAmount = "(//th[text()='Regular Interest']//ancestor::thead//following::td[contains(text(),' £')])[6]";

	String interestPaymentDetailsPopupTable = "//th[text()='Reference']//ancestor::table[@id='facilityInterestDetailsGrid']";
	String standardDefaultDaysColumnHeader = "//th[text()='Standard Default Days']";
	String regularInterestDaysColumnHeader = "//th[text()='Regular Interest Days']";
	String carriedOverColumnHeader = "//th[text()='Carried Over']";
	String defaultInterestColumnHeader = "//th[text()='Default Interest']";
	String expectedDefaultInterestColumnHeader = "//th[text()='Expected Default Interest']";
	String adjsutmentColumnHeader = "//th[text()='Adjustment']";
	String DefaultInterestPaidColumnHeader = "//th[text()='Default Interest Paid']";
	String regularInterestColumnHeader = "//table[@id='facilityInterestDetailsGrid']//th[text()='Regular Interest']";
	String carriedForwardColumnHeader = "//th[text()='Carried Forward']";
	String loanRateColumnHeader = "//th[text()='Loan Rate']";
	String defaultLoanRateColumnHeader = "//th[text()='Default Loan Rate']";
	String facilityRateColumnHeader = "//th[text()='Facility Rate']";
	String defaultFacilityRateColumnHeader = "//th[text()='Default Facility Rate']";

	String loanReferenceNumber = "//a[text()='locatorValue']";
	String loanReferenceAllValues = "//a[text()='locatorValue']//parent::td//following-sibling::td";
	String facilityAmountForLoanReferences = "//a[text()='referenceLocatorValue']//parent::td//following-sibling::td[dateLocatorValue]";

	String regularInterestDaysValue = "//a[text()='locatorValue']//parent::td//following-sibling::td[position()=last()-11]";
	String carriedOverValue = "//a[text()='locatorValue']//parent::td//following-sibling::td[position()=last()-10]";
	String defaultInterestValue = "//a[text()='locatorValue']//parent::td//following-sibling::td[position()=last()-9]";
	String defaultInterestPaidValue = "//a[text()='locatorValue']//parent::td//following-sibling::td[position()=last()-6]";
	String regularInterestColumnValueFacility = "//a[text()='locatorValue']//parent::td//following-sibling::td[position()=last()-5]";
	String carriedForwardValue = "//a[text()='locatorValue']//parent::td//following-sibling::td[position()=last()-4]";
	String loanRateValue = "//a[text()='locatorValue']//parent::td//following-sibling::td[position()=last()-3]";
	String defaultLoanRateValue = "//a[text()='locatorValue']//parent::td//following-sibling::td[position()=last()-2]";
	String facilityRateValue = "//a[text()='locatorValue']//parent::td//following-sibling::td[position()=last()-1]";
	String defaultFacilityRateValue = "//a[text()='locatorValue']//parent::td//following-sibling::td[position()=last()]";

	String lastDateSum = "//a[text()='Sum']//parent::td//following-sibling::td[position()=last()-13]";
	String lastDateLoan = "//a[text()='locatorValue']//parent::td//following-sibling::td[position()=last()-13]";

	// Step 5 - Accounting
	String accountingStep = "//div[contains(text(),'Step 5')]/parent::div//parent::div[contains(@class,'step--current')]";
	String accountingStep5 = "//a[contains(@href,'accounting')]";
	String calculationStartDateInStep5 = "//label[text()=' Calculation Start Date']//parent::div//p[contains(@class,'current-amount-p')]";
	String calculationEndDateInStep5 = "//label[text()=' Calculation End Date']//parent::div//p[contains(@class,'current-amount-p')]";

	String facilityNameColumn = "//label[text()=' Facility Name']";
	String internalReferenceColumn = "//label[text()=' Internal Reference']";
	String amountPayableColumn = "//label[text()=' Amount Payable']";
	String carriedForwardColumn = "//label[text()=' Carried Forward']";
	String facilityName = "//p[contains(text(),'locatorValue')]//parent::div//preceding-sibling::div//p";

	String internalReferenceAllFacilities = "//label[text()=' Amount Payable']//parent::div//following-sibling::div//div[2]";
	String allFacilityAmountPayable = "(//p[text()=' F00018']//parent::div//following-sibling::div/p[contains(@class,'current-amount')])[1]";
	String allFacilitiesAmountPayable = "//label[text()=' Amount Payable']//parent::div//following-sibling::div//div[3]";
	String allFacilitiesCarriedForward = "//label[text()=' Amount Payable']//parent::div//following-sibling::div//div[4]";

	// Overall Section
	String overallSection = "//label[text()=' Overall']";
	String interestIncomeUnderOverall = "(//label[text()=' Interest Income']//parent::div//p[contains(@class,'current')])[1]";
	String interestExpenseFieldInStep5 = "//label[text()=' Interest Expense']//parent::div//p[contains(@class,'current')]";
	String netInterestMarginFieldInStep5 = "//label[text()=' Net Interest Margin']//parent::div//p[contains(@class,'current')]";

	// Customer Loans Section
	String customerLoansSection = "//label[text()=' Customer Loans']";
	String interestIncomeUnderCustomerLoans = "(//label[text()=' Interest Income']//parent::div//p[contains(@class,'current')])[2]";

	// NIM Analysis Section
	String nIMAnalysisSection = "//label[text()=' NIM Analysis']";
	String cashInterestFieldInStep5 = "(//label[text()=' Cash Interest']//parent::div//p[contains(@class,'current')])[1]";
	String loanInterestFieldInStep5 = "(//label[text()=' Loan Interest']//parent::div//p[contains(@class,'current')])[1]";
	String defaultInterestUnderNIMSection = "(//label[text()=' Default Interest']//parent::div//p[contains(@class,'current')])[1]";
	String netFieldUnderNIMSection = "(//label[text()=' Net']//parent::div//p[contains(@class,'current')])[1]";
}
