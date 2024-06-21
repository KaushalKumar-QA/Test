package com.locators.allPages;

public interface ForgotPO {

	String forgotPasswordText = "//h3[contains(text(),'Forgot Password')]";
	String singIn = "//a[contains(text(),'Sign')]";
	String email = "//input[@name='email']";
	String sendButton = "//button[contains(text(),'Send')]";
	String invalidEmailLoginError = "//p[contains(@class,'error')]//span[contains(text(),'Error sending')]";

}
