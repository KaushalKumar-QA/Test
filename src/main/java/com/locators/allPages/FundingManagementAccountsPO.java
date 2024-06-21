package com.locators.allPages;

public interface FundingManagementAccountsPO {

	String runScriptButton = "//span[contains(text(),'Run Script')]//parent::button";

	String launchDate = "//th[text()='Launch Date']";
	String scheduled = "//th[text()='Scheduled']";
	String status = "//th[text()='Status']";
	String preview = "//th[text()='Preview']";

	String firstRecordLaunchDate = "(//tr[@class='ng-star-inserted']//td[1])[1]";
	String firstRecordScheduled = "(//tr[@class='ng-star-inserted']//td[2])[1]";
	String firstRecordPreview = "(//tr[@class='ng-star-inserted']//td[4])[1]//button";

	String firstRecordStatus = "(//tr[@class='ng-star-inserted']//td[3])[1]//span";
	String firstRecordStatusInProgress = "(//div[contains(@class,'progress-bar')])[1]";
	String firstRecordStatusError = "(//tr[@class='ng-star-inserted']//td[3])[1]//div";

	//

	String currentPage = "//span[@class='ui-paginator-pages']//a[contains(@class,'ui-state-active')]";
	String speacificPage = "//span[@class='ui-paginator-pages']//a[text()='locatorValue']";
	String nextButton = "//a[contains(@class,'ui-paginator-next')]";
	String previousButton = "//a[contains(@class,'ui-paginator-prev')]";
	String dailyBatchRunDate = "//td[contains(text(),'locatorValue 04:')]";

}
