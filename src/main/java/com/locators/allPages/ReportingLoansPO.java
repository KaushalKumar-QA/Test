package com.locators.allPages;

public interface ReportingLoansPO {

	String loansSingleSelectDateDropdown = "(//select[@class='form-control select-radius'])[2]";
	String singleSelectDatefirstOption = "(//select[@class='form-control select-radius'])[2]//option[1]";
	String loansHeaderText = "//h3[text()='Facility Reporting']";

	String summaryTab = "//a[text()=' Summary ']";
	String loanPortfolioTab = "//a[text()=' Loan Portfolio ']";
	String interest = "//a[text()=' Interest ']";
	String credit = "//a[text()=' Credit ']";
	String repayment = "//a[text()=' Repayment ']";
	String risk = "//a[text()=' Risk ']";
	String filterSection = "//select[@name='singleSelect']//parent::div//parent::div[@class='row']";
	String interestTab = "//a[text()=' Interest ']";
	String creditTab = "//a[text()=' Credit ']";
	String repaymentTab = "//a[text()=' Repayment ']";
	String riskTab = "//a[text()=' Risk ']";

	String facilityFilterBox = "(//div[@class='row']//select[@name='singleSelect'])[2]//parent::div";
	String facilityFilter = "(//div[@class='row']//select[@name='singleSelect'])[2]";
	String facilityOptions = "//option[contains(text(),'locatorValue')]";

	String dateFilterBox = "(//div[@class='row']//select[@name='singleSelect'])[3]//parent::div";

	// Lending Criteria
	String lendingCriteria = "//span[contains(text(),'Lending Criteria ')]";
	String lendingCriteriaIcon = "//span[contains(text(),'Lending Criteria ')]//parent::div";
	String lendingCriteriaSubheader = "//span[contains(text(),'Using Facility amount at termination date, not the live current amount.')]";
	String portfolioCriteriaSection = "(//table[@class='table lending-block-1']//parent::div[contains(@class,'col')])[1]";
	String regionalLimitSection = "(//table[@class='table lending-block-1']//parent::div[contains(@class,'col')])[2]";
	String mapViewSection = "(//div[contains(@class,'col-xs')])[3]";

	String firstColumnPortfolioValues = "//table[contains(@class,'lending-block-1')]//tr[not(contains(@class, 'ng-star-inserted'))]//td[(contains(@class, 'limit-respected')) or (contains(@class, 'error-limit'))]";
	String portfolioValues = "//table[contains(@class,'lending-block-1')]//tr[not(contains(@class, 'ng-star-inserted'))]//td[not(contains(@class, 'limit-respected')) and not(contains(@class, 'error-limit'))]";
	String firstColumnRegionalLimitValues = "//table[contains(@class,'lending-block-1')]//tr[contains(@class, 'ng-star-inserted')]//td[(contains(@class, 'limit-respected')) or (contains(@class, 'error-limit'))]";
	String regionalLimitValues = "//table[contains(@class,'lending-block-1')]//tr[contains(@class, 'ng-star-inserted')]//td[not(contains(@class, 'limit-respected')) and not(contains(@class, 'error-limit'))]";

	// Drawn Section
	String drawnSection = "//h5[text()='Drawn']//parent::div//parent::div[contains(@class,'m-portlet--full-height')]";
	String drawnAmount = "//h5[text()='Drawn']//following-sibling::h4";
	String drwanPercentage = "//h5[text()='Drawn']//following-sibling::Label";

	// Utilisation Section
	String utilisationSection = "//h5[text()='Utilisation']//parent::div//parent::div[contains(@class,'m-portlet--full-height')]";
	String utilisationAmount = "//h5[text()='Utilisation']//following-sibling::h4";
	String utilisationPercentage = "//h5[text()='Utilisation']//following-sibling::label";

	String numberOfLoansSection = "//h5[text()='Number of Loans']//parent::div//parent::div[contains(@class,'m-portlet--full-height')]";
	String wAMaturitySection = "//h5[text()='WA Maturity']//parent::div//parent::div[contains(@class,'m-portlet--full-height')]";
	String wAMaturity = "(//h5[text()='WA Maturity']//parent::div//following::p)[1]";
	String averageLoanSizeSection = "//h5[text()='Average Loan Size']//parent::div//parent::div[contains(@class,'m-portlet--full-height')]";
	String averageLoanSizePercentage = "//h5[text()='Average Loan Size']//following-sibling::div//p";
	String facilityInterestSection = "//h5[text()='Facility Interest']//parent::div//parent::div[contains(@class,'m-portlet--full-height')]";
	String facilityInterest = "(//h5[text()='Facility Interest']//parent::div//following::p)[1]";
	String terminatingSection = "//h5[text()='Terminating']//parent::div//parent::div[contains(@class,'m-portlet--full-height')]";
	String terminatingValue = "//h5[text()='Terminating']//parent::div//following-sibling::div[@align='right']//p";
	String frozenSection = "//h5[text()='Frozen']//parent::div//parent::div[contains(@class,'m-portlet--full-height')]";
	String frozenDrawn = "//h5[text()='Frozen']//following-sibling::div//p[text()='Effective']//parent::div//following-sibling::div[1]";
	String frozenDrawnText = "//h5[text()='Frozen']//following-sibling::div//p[text()='Termination status']//parent::div//following-sibling::div[1]";
	String frozenAllocated = "//h5[text()='Frozen']//following-sibling::div//p[text()='Effective']//parent::div//following-sibling::div[2]";
	String frozenAllocatedText = "//h5[text()='Frozen']//following-sibling::div//p[text()='Termination status']//parent::div//following-sibling::div[2]";
	String wALTVSection = "//h5[text()='WA LTV']//parent::div//parent::div[contains(@class,'m-portlet--full-height')]";
	String wALTVValue = "//h5[text()='WA LTV']//following-sibling::div//p";
	String firstChargeSection = "//h5[text()='1st Charge']//parent::div//parent::div[contains(@class,'m-portlet--full-height')]";
	String firstChargeValue = "//h5[text()='1st Charge']//following-sibling::div//p";
	String maxLoanSizeSection = "//h5[text()='Max Loan Size']//parent::div//parent::div[contains(@class,'m-portlet--full-height')]";
	String maxLoanSizeValue = "//h5[text()='Max Loan Size']//following-sibling::div//p";
	String bridgeLoanInterestSection = "//h5[text()='Bridge Loan Interest']//parent::div//parent::div[contains(@class,'m-portlet--full-height')]";
	String bridgeLoanInterestValue = "//h5[text()='Bridge Loan Interest']//following-sibling::div//p";
	String sumOfInterestReturnsSection = "//h3[text()=' Sum of Interest Returns ']//ancestor::div[contains(@class,'m-portlet--full-height')]";
	String creditPerformanceSection = "//h3[text()=' Credit Performance ']//ancestor::div[contains(@class,'m-portlet--full-height')]";
	String loansByRegionSection = "//h3[text()=' Loans By Region ']//ancestor::div[contains(@class,'m-portlet--full-height')]";
	String repaymentProfileSection = "//h3[text()=' Repayment Profile ']//ancestor::div[contains(@class,'m-portlet--full-height')]";
	String stressScenariosSection = "//h3[text()=' Stress Scenarios ']//ancestor::div[contains(@class,'m-portlet--full-height')]";

	String numberOfLoans = "//h5[text()='Number of Loans']//following-sibling::div//p";
	String cashToggleOfSumOfInterest = "//div[text()='£ ']//parent::button";
	String percentageToggleOfSumOfInterest = "//div[text()='% ']//parent::button";
	String firstMonthFirstYearValueInSumOfInterest = "//div[contains(@class,'summary-interest-table')]//div[contains(@class,'ui-table-unfrozen-view')]//tbody//tr[1]//td[1]";

	// Loan portfolio >> Facility Section
	String facilityAmountsSection = "//h5[text()='Facility Amount']//parent::div//ancestor::div[contains(@class,'m-portlet--full-height')]";

	String facilityAmount = "//h5[text()='Facility Amount']//following-sibling::h4";
	String drawnAmountValue = "//label[text()='Drawn']//following-sibling::p";
	String undrawnAmount = "//label[text()='Undrawn']//following-sibling::p";
	String allocatedAmount = "//label[text()='Allocated']//following-sibling::p";
	String cashAmount = "//label[text()='Cash']//following-sibling::p";
	String frozenCash = "//label[text()='Frozen Cash']";
	String frozenCashTNGAmount = "(//label[text()='Frozen Cash']//following-sibling::p)[1]";
	String availableCashAmount = "//label[text()='Available Cash']//following-sibling::p";
	String terminationInLoanPortfolio = "//a[text()=' Terminating ']";

	// Loan portfolio >> Top 5 Loan section
	String top5LoanAmount = "//h3[text()=' Top 5 Loans ']//parent::div//parent::div//parent::div//following-sibling::div//h5[@class='top-amount']";
	String top5LoanInternalReference = "//h3[text()=' Top 5 Loans ']//parent::div//parent::div//parent::div//following-sibling::div//a";
	String top5LoanDisbursementDate = "//h3[text()=' Top 5 Loans ']//parent::div//parent::div//parent::div//following-sibling::div//p[@class='top-type']";
	String top5LoanInterestRate = "//h3[text()=' Top 5 Loans ']//parent::div//parent::div//parent::div//following-sibling::div//p[not(contains(@class,'top-type'))]";

	// Loan portfolio >> Top 5 Borrower section
	String top5BorrowerLoanAmount = "//h3[text()=' Top 5 Borrowers ']//parent::div//parent::div//parent::div//following-sibling::div//h5[@class='top-amount']";
	String top5LoanBorrowerReference = "//h3[text()=' Top 5 Borrowers ']//parent::div//parent::div//parent::div//following-sibling::div//div[contains(@class,'row top-5-section')]//p[@class='top-reference']";
	String top5BorrowerType = "//h3[text()=' Top 5 Borrowers ']//parent::div//parent::div//parent::div//following-sibling::div//div[contains(@class,'row top-5-section')]//p[@class='top-type']";
	String top5LoanBorrowerInterestRate = "//h3[text()=' Top 5 Borrowers ']//parent::div//parent::div//parent::div//following-sibling::div//h5[@class='top-amount']//following-sibling::p";

	// Loan portfolio >> Loan table
	String ltvSortIcon = "//th[text()=' LTV ']//p-sorticon";
	String currentLoanAmountSortIcon = "//th[text()=' Current Loan Amount ']//p-sorticon";
	String loanReference = "//tbody//tr[contains(@class,'ui-selectable-row')]//td[1]";
	String internalReference = "//tbody//tr[contains(@class,'ui-selectable-row')]//td[2]";
	String status = "//tbody//tr[contains(@class,'ui-selectable-row')]//td[4]";
	String allocateLoanAmount = "//tbody//td[5]";
	String currentLoanAmount = "//tbody//td[6]";
	String repaymentDate = "//tbody//td[7]";
	String ltvValues = "//tbody//td[8]";
	String propertyCharge = "//tbody//td[9]";
	String annualInterestRate = "//tbody//td[10]";
	String propertyAddress = "//tbody//td[11]";
	String region = "//tbody//td[12]";
	String propertyType = "//tbody//td[13]";
	String loanType = "//h5[text()='Loan Type']//following-sibling::div//div[@class='chartjs-size-monitor-shrink']";
	String canvas = "//h5[text()='Loan Type']//following-sibling::div//canvas";

	// Loan Size Section
	String loanSizeSection = "//h5[text()='Loan Size']//parent::div//ancestor::div[contains(@class,'m-portlet--full-height')]";

	String minLabel = "(//h5[text()='Loan Size']//following::label[text()='Min'])[1]";
	String minLoanAmount = "(//h5[text()='Loan Size']//following::label[text()='Min'])[1]//following-sibling::p[1]";
	String minLoanAmountInterestRate = "(//h5[text()='Loan Size']//following::label[text()='Min'])[1]//following-sibling::p[2]";

	String maxLabel = "(//h5[text()='Loan Size']//following::label[text()='Max'])[1]";
	String maxLoanAmount = "(//h5[text()='Loan Size']//following::label[text()='Max'])[1]//following-sibling::p[1]";
	String maxLoanAmountInterestRate = "(//h5[text()='Loan Size']//following::label[text()='Max'])[1]//following-sibling::p[2]";

	String averageLabel = "//h5[text()='Loan Size']//following::label[text()='Average']";
	String averageLoanAmount = "//h5[text()='Loan Size']//following::label[text()='Average']//following-sibling::p[1]";

	String medianLabel = "(//h5[text()='Loan Size']//following::label[text()='Median'])[1]";
	String medianLoanAmount = "(//h5[text()='Loan Size']//following::label[text()='Median'])[1]//following-sibling::p[1]";
	String medianLoanAmountInterestRate = "(//h5[text()='Loan Size']//following::label[text()='Median'])[1]//following-sibling::p[2]";

	// Loan portfolio >> LTV Section
	String lTVSection = "//h5[text()='LTV']//parent::div//ancestor::div[contains(@class,'m-portlet--full-height')]";
	String lTVMinLabel = "//h5[text()='LTV']//following::label[text()='Min']";
	String minLTV = "//h5[text()='LTV']//following::label[text()='Min']//following-sibling::p";

	String lTVMaxLabel = "//h5[text()='LTV']//following::label[text()='Max']";
	String maxLTV = "//h5[text()='LTV']//following::label[text()='Max']//following-sibling::p";

	String wAverageLabel = "//h5[text()='LTV']//following::label[text()='W Average']";
	String wAverageLTV = "//label[text()='W Average']//following-sibling::p";
	String lTVMedianLabel = "//h5[text()='LTV']//following::label[text()='Median']";
	String lTVMedian = "//h5[text()='LTV']//following::label[text()='Median']//following-sibling::p";

	// Charge Section
	String chargeSection = "//h5[text()='Charge']//parent::div//ancestor::div[contains(@class,'m-portlet--full-height')]";

	// Key Stats Section
	String keyStatsSection = "//h5[text()='Key Stats']//parent::div//ancestor::div[contains(@class,'m-portlet--full-height')]";

	String numberOfLoan = "//label[text()='Numbers of Loans']";
	String numberOfLoansValue = "//label[text()='Numbers of Loans']//following-sibling::p";

	String wAMaturitys = "//label[text()='WA Maturity']";
	String wAMaturityValue = "//label[text()='WA Maturity']//following-sibling::p";

	String interestRate = "//label[text()='Interest Rate']";
	String interestRateValue = "//label[text()='Interest Rate']//following-sibling::p";

	// Loan Type Section
	String loanTypeSection = "//h5[text()='Loan Type']//parent::div//ancestor::div[contains(@class,'m-portlet--full-height')]";

	// Top 5 Borrowers Section
	String top5BorrowersSection = "//h3[text()=' Top 5 Borrowers ']//parent::div//ancestor::div[contains(@class,'m-portlet--full-height')]";

	// Top 5 Loans Section
	String top5LoansSection = "//h3[text()=' Top 5 Loans ']//parent::div//ancestor::div[contains(@class,'m-portlet--full-height')]";

	// Loans Section
	String loansSection = "//h3[text()=' Loans ']//parent::div//ancestor::div[contains(@class,'m-portlet--full-height')]";

	// Loans Table
	String loansTable = "(//h3[text()=' Loans ']//parent::div//parent::div//ancestor::div[@class='row'])[3]";

	String loanReferenceColumnHeader = "//th[contains(text(),' Loan Reference ')]";
	String internalReferenceColumnHeader = "//th[contains(text(),' Internal Reference ')]";
	String commentColumnHeader = "//th[contains(text(),' Comment')]";
	String statusColumnHeader = "//th[contains(text(),' Status')]";
	String allocationColumnHeader = "//th[contains(text(),' Allocation')]";
	String currentLoanAmountColumnHeader = "//th[contains(text(),' Current Loan Amount ')]";
	String repaymentDateColumnHeader = "//th[contains(text(),' Repayment Date ')]";
	String lTVColumnHeader = "//th[contains(text(),' LTV')]";
	String chargeColumnHeader = "//th[contains(text(),' Charge')]";
	String annualInterestRateColumnHeader = "//th[contains(text(),' Annual Interest Rate ')]";
	String propertyAddressColumnHeader = "//th[contains(text(),' Property Address ')]";
	String regionColumnHeader = "//th[contains(text(),' Region ')]";
	String propertyTypeColumnHeader = "//th[contains(text(),' Property Type ')]";

	String loanReferenceSortIcon = "//th[contains(text(),' Loan Reference ')]//i";
	String internalReferenceSortIcon = "//th[contains(text(),' Internal Reference ')]//i";
	String commentSortIcon = "//th[contains(text(),' Comment')]//i";
	String statusSortIcon = "//th[contains(text(),' Status')]//i";
	String allocationSortIcon = "//th[contains(text(),' Allocation')]//i";
	String repaymentDateSortIcon = "//th[contains(text(),' Repayment Date ')]//p-sorticon";
	String lTVColumnSortIcon = "//th[contains(text(),' LTV')]//i";
	String chargeSortIcon = "//th[contains(text(),' Charge')]//i";
	String annualInterestRateSortIcon = "//th[contains(text(),' Annual Interest Rate ')]//i";
	String propertyAddressSortIcon = "//th[contains(text(),' Property Address ')]//i";
	String regionSortIcon = "//th[contains(text(),' Region ')]//i";
	String propertyTypeSortIcon = "//th[contains(text(),' Property Type ')]//i";

	String loanReferenceAllValues = "//tbody[contains(@class,'tbody')]//tr//td[1]";
	String internalReferenceAllValues = "//tbody[contains(@class,'tbody')]//tr//td[2]";
	String commentAllValues = "//tbody[contains(@class,'tbody')]//tr//td[3]";
	String statusAllValues = "//tbody[contains(@class,'tbody')]//tr//td[4]";
	String allocationAllValues = "//tbody[contains(@class,'tbody')]//tr//td[5]";
	String currentLoanAmountAllValues = "//tbody[contains(@class,'tbody')]//tr//td[6]";
	String repaymentDateAllValues = "//tbody[contains(@class,'tbody')]//tr//td[7]";
	String lTVColumnAllValues = "//tbody[contains(@class,'tbody')]//tr//td[8]";
	String chargeAllValues = "//tbody[contains(@class,'tbody')]//tr//td[9]//div";
	String anualInterestRateAllValues = "//tbody[contains(@class,'tbody')]//tr//td[10]";
	String propertyAddressAllValues = "//tbody[contains(@class,'tbody')]//tr//td[11]";
	String regionAllValues = "//tbody[contains(@class,'tbody')]//tr//td[12]";
	String propertyTypeAllValues = "//tbody[contains(@class,'tbody')]//tr//td[13]";

	String loanRefFirstValue = "//tbody[contains(@class,'tbody')]//tr[1]//td[1]";
	String internalRefFirstValue = "//tbody[contains(@class,'tbody')]//tr[1]//td[2]";
	String statusFirstValue = "//tbody[contains(@class,'tbody')]//tr[1]//td[4]";
	String currentLoanAmountFirstAmount = "//tbody[contains(@class,'tbody')]//tr[1]//td[6]";
	String lTVColumnFirstValue = "//tbody[contains(@class,'tbody')]//tr[1]//td[8]";

	// Repayment tab
	String repaymentHeaderText = "//h3[text()=' Repayment Analysis ']";
	String repaymentAmount = "//tbody//td[5]";
	String timeToMaturity = "//tbody//td[11]";

	// Interest tab
	String allocationValuesInInterest = "//tbody//td[4]";
	String annualInterestRateInInterestTab = "//tbody//td[6]";

	// Credit tab
	String performingText = "(//p[text()='Performing '])[1]";
	String performing = "(//p[text()='Performing ']//parent::div//following-sibling::div//h5)[1]";
	String nintyDaysOverdue = "(//p[text()=' 90 days overdue']//parent::div//following-sibling::div//h5)[1]";
	String nintyOneToOneEightyDaysOverdue = "(//p[text()='91-180 days overdue']//parent::div//following-sibling::div//h5)[1]";
	String oneEightyDaysOverdue = "(//p[text()='180 days overdue']//parent::div//following-sibling::div//h5)[1]";
	String repossessed = "(//p[text()='Repossessed']//parent::div//following-sibling::div//h5)[1]";

	String performingAmount = "(//p[text()='Performing ']//parent::div//following-sibling::div//p)[1]";
	String nintyDaysOverdueAmount = "(//p[text()=' 90 days overdue']//parent::div//following-sibling::div//p)[1]";
	String nintyOneToOneEightyDaysOverdueAmount = "(//p[text()='91-180 days overdue']//parent::div//following-sibling::div//p)[1]";
	String oneEightyDaysOverdueAmount = "(//p[text()='180 days overdue']//parent::div//following-sibling::div//p)[1]";
	String repossessedAmount = "(//p[text()='Repossessed']//parent::div//following-sibling::div//p)[1]";

}
