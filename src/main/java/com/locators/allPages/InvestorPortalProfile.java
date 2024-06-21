package com.locators.allPages;

public interface InvestorPortalProfile {

	String ChangePassword = "(//th[@class='ng-star-inserted'])[4]//input";

	String editIcon = "(//button[@mattooltip='Edit'])[1]";


	// Change password
	String changePasswordLink = "//li[@class='m-nav__item ng-star-inserted'][2]";
	String changePasswordText = "//h3[contains(text(),'Change Your Password')]";
	

	String oldPassword = "//input[@id='oldPassword']";
	String newPassword = "//input[@id='newPassword']";
	String confirmPassword = "//input[@id='newPassword_2']";
	String saveButton = "//button[text()=' Save ']";

	String successPopupClose = "//button[text()=' Close ']";

	// Edit user >> reset user password page
	String generatePasswordResetLink = "//span[contains(text(),'Generate a Password Reset link')]";
	String copy = "//button//p[text()='Copy']";
	
	
}
