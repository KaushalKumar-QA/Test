package com.locators.allPages;

public interface ReportingUpdatesPO {

	String runScriptButton = "//span[contains(text(),'Run Script')]//parent::button";
	String launchDate = "//th[text()='Launch Date']";
	String scheduled = "//th[text()='Scheduled']";
	String status = "//th[text()='Status']";

	String paginationDropdown = "//div[contains(@class,'ui-dropdown-trigger')]";
	String paginationDropdownListing = "//li[@aria-label='locatorValue']";

	String speacificPage = "//span[@class='ui-paginator-pages']//a[text()='locatorValue']";
	String currentPage = "//span[@class='ui-paginator-pages']//a[contains(@class,'ui-state-active')]";

	String tableRows = "//tbody//tr[@class='ng-star-inserted']";
	String nextButton = "//a[contains(@class,'ui-paginator-next')]";
	String previousButton = "//a[contains(@class,'ui-paginator-prev')]";

	String firstRecordLaunchDate = "(//tr[@class='ng-star-inserted']//td[1])[1]";
	String firstRecordScheduledDate = "(//tr[@class='ng-star-inserted']//td[2])[1]";

	String firstRecordStatus = "(//tr[@class='ng-star-inserted']//td[3])[1]//span";
	String firstRecordStatusInProgress = "(//div[contains(@class,'progress-bar')])[1]";
	String firstRecordStatusError = "(//div[contains(text(),'ERROR')])[1]";

	String secondRecordStatus = "(//tr[@class='ng-star-inserted']//td[3])[2]//span";
	String secondRecordStatusInProgress = "(//div[contains(@class,'progress-bar')])[2]";
	String secondRecordStatusError = "(//div[contains(text(),'ERROR')])[2]";

	String firstDoneSuccessLaunchDate = "(//span[contains(text(),'DONE_SUCCESS')])[1]/ancestor::tr//td[1]";

	String dailyBatchRunDate = "//td[contains(text(),'locatorValue 07:30')]";

}
