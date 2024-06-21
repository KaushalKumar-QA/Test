package com.locators.allPages;

public interface FundingCalculateInterestPO {

	String runScriptButton = "//span[contains(text(),'Run Script')]//parent::button";

	String date = "//span[text()='Run Script']//parent::button/following-sibling::div//input";
	String calenderMonth = "(//select[@class='custom-select'])[1]";
	String futureDate = "//div[@aria-label='locatorValue']";

	String selectedDate = "//th[text()='Selected Date']";
	String launchDate = "//th[text()='Launch Date']";
	String launchDateValues = "//tr[@class='ng-star-inserted']//td[2]";
	String customDate = "//th[text()='Custom Date']";
	String scheduled = "//th[text()='Selected Date']";
	String status = "//th[text()='Status']";

	String firstRecordSelectedDate = "(//tr[@class='ng-star-inserted']//td[1])[1]";
	String selectedDates = "//tr[@class='ng-star-inserted']//td[1]";
	String firstRecordlaunchDate = "(//tr[@class='ng-star-inserted']//td[2])[1]";
	String firstRecordCustomDate = "(//tr[@class='ng-star-inserted']//td[3])[1]//div";
	String firstRecordScheduled = "(//tr[@class='ng-star-inserted']//td[4])[1]";
	String firstRecordStatus = "(//tr[@class='ng-star-inserted']//td[5])[1]//span";
	String firstRecordStatusInProgress = "(//div[contains(@class,'progress-bar')])[1]";
	String firstRecordStatusError = "(//div[contains(text(),'ERROR')])[1]";

	String secondRecordStatus = "(//tr[@class='ng-star-inserted']//td[5])[2]//span";
	String secondRecordStatusInProgress = "(//div[contains(@class,'progress-bar')])[2]";
	String secondRecordStatusError = "(//div[contains(text(),'ERROR')])[2]";

	// Error modal
	String errorPaymentModal = "//div[contains(@class,'modal-content-custom')]";
	String closeButtonErrorPaymentModal = "//div[@class='modal-footer']//button[contains(text(),'Close')]";

}
