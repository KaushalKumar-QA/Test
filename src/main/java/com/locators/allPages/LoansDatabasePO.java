package com.locators.allPages;

public interface LoansDatabasePO {

	String bridgeLoanDatabseText = "//h3[text()='Bridge Loan Database']";
	String loanRefSearchField = "(//th[text()=' Loan Ref ']//ancestor::thead//tr[2]//th//input[contains(@class,'ui-inputtext')])[2]";
	String borrowerRefSearchField = "(//th[text()=' Borrower Ref ']//ancestor::thead//tr[2]//th//input[contains(@class,'ui-inputtext')])[3]";
	String internalRefSearchField = "(//th[text()=' Internal Reference ']//ancestor::thead//tr[2]//th//input[contains(@class,'ui-inputtext')])[1]";
	String statusDropdown = "(//span[text()='All']//parent::label)[1]";
	String liveDropdownoption = "//div[@class='ui-dropdown-items-wrapper']//li[@aria-label='Live']";
	String amountMin = "(//input[@placeholder='Min'])[1]";
	String firstLoanRefRowValue = "//tr[1]//td[5]";
	String firstLoanCurrentAmountRowValue = "//tr[1]//td[8]";
	String firstLoanInternalRefNameRowValue = "//tr[1]//td[4]";

	String amountSortIcon = "//th[text()=' Amount ']//p-sorticon";
	String currentAmount = "//th[text()=' Current Amount ']//p-sorticon";
	String amountValues = "//tbody//td[7]";

	String loanReference = "//td[5]";
	String borrowerReference = "//td[6]";
	String internalReference = "//td[4]";
	String status = "//td[2]";
	String allocateLoanAmount = "//td[7]";
	String currentLoanAmount = "//td[8]";
	String repaymentDate = "//td[10]";
	String ltvValues = "//td[11]";
	String propertyCharge = "//td[12]";

	String annualInterestRate = "//td[14]";
	String propertyAddress = "//td[16]";
	String region = "//td[17]";
	String propertyType = "//td[18]";

}
