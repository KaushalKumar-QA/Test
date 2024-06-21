package com.locators.allPages;

public interface LoginPO {

	String signInText = "//h3[contains(text(),'Sign in')]";

	// LoginForm
	String username = "//input[@id='j_username']";
	String password = "//input[@id='j_password']";
	String loginButton = "//button[contains(text(),'Login')]";

	String forgotPassword = "//a[contains(text(),'Forgot')]";

	String invaliUsernameLoginError = "//p[@id='login_error']//span";

	// OTP Screen
	String code = "//input[@type='password']";
	String codeText = "//h4[contains(text(),'A code')]";

	// Acceptance popup for new user
	String popup = "//div[@class='modal-content']";
	String popupheader = "//div[@class='modal-content']//div[@class='modal-header']";
	String popupAccept = "//button[text()='Accept']";
    
}
