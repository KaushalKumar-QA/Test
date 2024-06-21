package com.locators.allPages;

public interface InvestorChangePasswordPO {
	//Change password
	String changePasswordLink = "//span[normalize-space()='Change Password']";
	
	String changePasswordText = "//h3[contains(text(),'Change Your Password')]";

	String oldPassword = "//input[@id='oldPassword']";
	String newPassword = "//input[@id='newPassword']";
	String confirmPassword = "//input[@id='newPassword_2']";
	String saveButton = "//button[text()=' Save ']";

	String successPopupClose = "//button[text()=' Close ']";


}
