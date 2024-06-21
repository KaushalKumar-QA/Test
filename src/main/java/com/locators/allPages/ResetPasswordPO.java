package com.locators.allPages;

public interface ResetPasswordPO {

	String createNewtPasswordText = "//h3[contains(text(),'Create New Password')]";
	String newPassword = "//input[@ng-model='newPassword']";
	String confirmPassword = "//input[@ng-model='newPassword2']";
	String saveButton = "//button[contains(text(),'Save')]";
	
	String loggedinusername = "(//span[text()=' Investor Test '])[1]";
	String viewpersonalprofile = "//span[text() =' View Personal Profile ']";
	

}
