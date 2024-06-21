package com.locators.allPages;

public interface UtilsPO {

	String calenderDay = "//div[text()='locatorValue']";
	String calenderMonth = "//div[contains(@class,'ngb-dp-header')]//select[@class='custom-select'][1]";
	String calenderYear = "//select[@title='Select year']";

	String dashboard = "//div[contains(@class,'summary-top-section')]";

	// Save button and success popup
	String save = "//button[text()=' Save ']";
	String saveButton = "//a[text()=' Save ']";
	String successPopup = "//div[contains(@class,'modal-content-custom')]";
	String closePopUp = "//button[text()=' Close ']";
	String popUp = "//div[@class='modal-content']";

	// Error
	String error = "//h4[text()='ERROR']";
	String errorMessage = "//span[text()='Error:']//following-sibling::span";

	// Poup text
	String popupText = "//h4[@class='modal-title']";

	// Action icons
	String editIcon = "//button[@mattooltip='Edit']";
	String deleteIcon = "//button[@mattooltip='Delete']";

	// Search bar
	String headerSearchCrossIcon = "//button[contains(@class,'ui-button-danger')]";

	// Page Bottom
	String backStepButton = "//a[text()=' Back ']";
	String nextStepButton = "//a[text()=' Next Step ']";

	String runScriptButton = "//span[contains(text(),'Run Script')]//parent::button";

}
