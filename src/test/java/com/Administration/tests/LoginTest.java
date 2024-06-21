package com.Administration.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.locators.allPages.ForgotPO;
import com.locators.allPages.LoginPO;
import com.locators.allPages.ReportingPO;
import com.locators.allPages.SideMenuPO;
import com.locators.allPages.UsersDatabasePO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.utils.LoginPage;
import com.qa.utils.Utils;

public class LoginTest extends Baseclass {

	@Test(priority = 1)
	public void validUserLogin() throws IOException {
		try {
			extenttest = extent.createTest("Verify that user is able to login with valid credentials")
					.assignCategory(administration_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			// Call the userLoginProcess function from the utils login
			LoginPage.userLoginProcess(node, driver, getDataFromExcel(1), getDataFromExcel(2));

			// Verify that logged in user name is visible on top of Dashboard
			// page
			node.log(Status.INFO, "STEP1 : Verify that logged in user name is visible on top of the page");
			System.out.println("STEP1 : Verify that logged in user name is visible on top of the page");
			IElementActions.assertTrue_usingXpath(extenttest, driver, ReportingPO.headerUsername,
					"STEP2 : BUG:Logged in user name not coming on dashboard page",
					"STEP2 : EXPECTED:Logged in user name is coming on dashboard page");

			// Take Screenshot of dashboard after user login
			IScreenAction.captureScreenShot_PassCase("validUserLogin", "Pass", driver);

		} catch (AssertionError validUserLogin) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validUserLogin test in LoginTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validUserLogin_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validUserLogin.printStackTrace();
			node.fail(validUserLogin);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validUserLogin) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validUserLogin test in LoginTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "validUserLogin_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validUserLogin.printStackTrace();
			node.fail(validUserLogin);
			Assert.fail();
			extent.flush();
		}
	}

	@Test(priority = 2)
	public void invalidUserNameLogin() throws IOException {
		try {
			extenttest = extent.createTest("Verify that user is not able to login to app with Invalid username")
					.assignCategory(administration_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			String invalidUsername = "123" + getDataFromExcel(1);

			// Call the enterLoginDetailsAndSubmit function from the utils login
			LoginPage.enterLoginDetailsAndSubmit(node, driver, invalidUsername, getDataFromExcel(2));

			// Wait for the visibility of the error
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the error");
			System.out.println("STEP1 : Waiting for the visibility of the error");
			IWaitStrategy.waitForVisiblity(node, driver, LoginPO.invaliUsernameLoginError);
			node.log(Status.INFO, "STEP2 : Error is visible after login");
			System.out.println("STEP2 : Error is visible after login");

			// Verify that error message is displayed
			node.log(Status.INFO, "STEP3 : Verify that error message is displayed");
			System.out.println("STEP3 : Verify that error message is displayed");

			IElementActions.assertTrue_usingXpath(node, driver, LoginPO.invaliUsernameLoginError,
					"STEP4 : BUG - Error message is not displayed on the login page",
					"STEP4 : EXPECTED - Error message is displayed on the login page");

			// Take Screenshot of dashboard after user login
			IScreenAction.captureScreenShot_PassCase("invalidUserNameLogin", "Pass", driver);

		} catch (AssertionError invalidUserNameLogin) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In invalidUserNameLogin test in LoginTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "invalidUserNameLogin_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			invalidUserNameLogin.printStackTrace();
			node.fail(invalidUserNameLogin);
			Assert.fail();
			extent.flush();
		}

		catch (Exception invalidUserNameLogin) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In invalidUserNameLogin test in LoginTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "invalidUserNameLogin_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			invalidUserNameLogin.printStackTrace();
			node.fail(invalidUserNameLogin);
			Assert.fail();
			extent.flush();
		}

	}

	@Test(priority = 3)
	public void invalidPasswordLogin() throws IOException {
		try {
			extenttest = extent.createTest("Verify that user is not able to login to app with Invalid Password.")
					.assignCategory(administration_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			String invalidPassword = "123" + getDataFromExcel(2);

			// Call the enterLoginDetailsAndSubmit function from the utils login
			LoginPage.enterLoginDetailsAndSubmit(node, driver, getDataFromExcel(1), invalidPassword);

			// Wait for the visibility of the error
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the error");
			System.out.println("STEP1 : Waiting for the visibility of the error");
			IWaitStrategy.waitForVisiblity(node, driver, LoginPO.invaliUsernameLoginError);
			node.log(Status.INFO, "STEP2 : Error is visible after login");
			System.out.println("STEP2 : Error is visible after login");

			// Verify that error message is displayed
			node.log(Status.INFO, "STEP3 : Verify that error message is displayed");
			System.out.println("STEP3 : Verify that error message is displayed");

			IElementActions.assertTrue_usingXpath(node, driver, LoginPO.invaliUsernameLoginError,
					"STEP4 : BUG - Error message is not displayed on the login page",
					"STEP4 : EXPECTED - Error message is displayed on the login page");

			// Take Screenshot of dashboard after user login
			IScreenAction.captureScreenShot_PassCase("invalidPasswordLogin", "Pass", driver);

		} catch (AssertionError invalidPasswordLogin) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In invalidPasswordLogin test in LoginTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "invalidPasswordLogin_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			invalidPasswordLogin.printStackTrace();
			node.fail(invalidPasswordLogin);
			Assert.fail();
			extent.flush();
		}

		catch (Exception invalidPasswordLogin) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In invalidPasswordLogin test in LoginTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "invalidPasswordLogin_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			invalidPasswordLogin.printStackTrace();
			node.fail(invalidPasswordLogin);
			Assert.fail();
			extent.flush();
		}

	}

	@Test(priority = 4)
	public void skipUserNameAndTryLogin() throws IOException {

		try {
			extenttest = extent.createTest("Verify that user is not able to login to app without entering Username")
					.assignCategory(administration_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			// Click on password field and input the password
			IElementActions.clickAndInput_usingXpath(node, driver, LoginPO.password, getDataFromExcel(2));
			node.log(Status.INFO, "STEP1 : Password entered by user on the login page");
			System.out.println("STEP1 : Password entered by user on the login page");

			// Press enter to submit login detail
			IElementActions.pressEnter_usingXpath(node, driver, LoginPO.password);
			node.log(Status.INFO, "STEP2 : Pressed enter to submit the login details");
			System.out.println("STEP2 : Pressed enter to submit the login details");

			// Wait for the visibility of the error
			node.log(Status.INFO, "STEP3 : Waiting for the visibility of the error");
			System.out.println("STEP3 : Waiting for the visibility of the error");
			IWaitStrategy.waitForVisiblity(node, driver, LoginPO.invaliUsernameLoginError);
			node.log(Status.INFO, "STEP4 : Error is visible after login");
			System.out.println("STEP4 : Error is visible after login");

			// Verify that error message is displayed
			node.log(Status.INFO, "STEP5 : Verify that error message is displayed");
			System.out.println("STEP5 : Verify that error message is displayed");

			IElementActions.assertTrue_usingXpath(node, driver, LoginPO.invaliUsernameLoginError,
					"STEP6 : BUG - Error message is not displayed on the login page",
					"STEP6 : EXPECTED - Error message is displayed on the login page");

			// Take Screenshot of dashboard after user login
			IScreenAction.captureScreenShot_PassCase("skipUserNameAndTryLogin", "Pass", driver);

		} catch (AssertionError skipUserNameAndTryLogin) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In skipUserNameAndTryLogin test in LoginTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "skipUserNameAndTryLogin_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			skipUserNameAndTryLogin.printStackTrace();
			node.fail(skipUserNameAndTryLogin);
			Assert.fail();
			extent.flush();
		}

		catch (Exception skipUserNameAndTryLogin) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In skipUserNameAndTryLogin test in LoginTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "skipUserNameAndTryLogin_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			skipUserNameAndTryLogin.printStackTrace();
			node.fail(skipUserNameAndTryLogin);
			Assert.fail();
			extent.flush();
		}

	}

	@Test(priority = 5)
	public void skipPasswordAndTryLogin() throws IOException {
		try {
			extenttest = extent.createTest("Verify that user is not able to login to app without entering Password")
					.assignCategory(administration_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			// Click on username field and input the username
			IElementActions.clickAndInput_usingXpath(node, driver, LoginPO.username, getDataFromExcel(1));
			node.log(Status.INFO, "STEP1 : Username entered by user on the login page");
			System.out.println("STEP1 : Username entered by user on the login page");

			// Press enter to submit login detail
			IElementActions.pressEnter_usingXpath(node, driver, LoginPO.password);
			node.log(Status.INFO, "STEP2 : Pressed enter to submit the login details");
			System.out.println("STEP2 : Pressed enter to submit the login details");

			// Wait for the visibility of the error
			node.log(Status.INFO, "STEP3 : Waiting for the visibility of the error");
			System.out.println("STEP3 : Waiting for the visibility of the error");
			IWaitStrategy.waitForVisiblity(node, driver, LoginPO.invaliUsernameLoginError);
			node.log(Status.INFO, "STEP4 : Error is visible after login");
			System.out.println("STEP4 : Error is visible after login");

			// Verify that error message is displayed
			node.log(Status.INFO, "STEP5 : Verify that error message is displayed");
			System.out.println("STEP5 : Verify that error message is displayed");

			IElementActions.assertTrue_usingXpath(node, driver, LoginPO.invaliUsernameLoginError,
					"STEP6 : BUG - Error message is not displayed on the login page",
					"STEP6 : EXPECTED - Error message is displayed on the login page");

			// Take Screenshot of dashboard after user login
			IScreenAction.captureScreenShot_PassCase("skipPasswordAndTryLogin", "Pass", driver);

		} catch (AssertionError skipPasswordAndTryLogin) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In skipPasswordAndTryLogin test in LoginTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "skipPasswordAndTryLogin_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			skipPasswordAndTryLogin.printStackTrace();
			node.fail(skipPasswordAndTryLogin);
			Assert.fail();
			extent.flush();
		}

		catch (Exception skipPasswordAndTryLogin) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In skipPasswordAndTryLogin test in LoginTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "skipPasswordAndTryLogin_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			skipPasswordAndTryLogin.printStackTrace();
			node.fail(skipPasswordAndTryLogin);
			Assert.fail();
			extent.flush();
		}

	}

	@Test(priority = 6)
	public void validateForgetPasswordRedirection() throws IOException {
		try {
			extenttest = extent.createTest(
					"Verify that when user click on Forget Password link then user navigate to the Forget Password page ")
					.assignCategory(administration_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			// Click on the forgot password
			IElementActions.clickelement_usingXpath(node, driver, LoginPO.forgotPassword);
			node.log(Status.INFO, "STEP1 : clicked on the forgot password");
			System.out.println("STEP1 : clicked on the forgot password");

			// Wait for the visibility of the forgot password page
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the forgot password page");
			System.out.println("STEP2 : Waiting for the visibility of the forgot password page");
			IWaitStrategy.waitForVisiblity(node, driver, ForgotPO.forgotPasswordText);
			node.log(Status.INFO, "STEP3 : Forgot password page is visible");
			System.out.println("STEP3 : Forgot password page is visible");

			// Verify the forgot password page
			node.log(Status.INFO, "STEP4 : Verify that the forgot password page is displayed");
			System.out.println("STEP4 : Verify that the forgot password page is displayed");

			IElementActions.assertTrue_usingXpath(node, driver, ForgotPO.forgotPasswordText,
					"STEP5 : BUG - Forgot password page is not displayed",
					"STEP5 : EXPECTED - Forgot password page is displayed");

			// Take Screenshot of dashboard after user login
			IScreenAction.captureScreenShot_PassCase("validateForgetPasswordRedirection", "Pass", driver);

		} catch (AssertionError validateForgetPasswordRedirection) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateForgetPasswordRedirection test in LoginTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateForgetPasswordRedirection_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateForgetPasswordRedirection.printStackTrace();
			node.fail(validateForgetPasswordRedirection);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateForgetPasswordRedirection) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateForgetPasswordRedirection test in LoginTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateForgetPasswordRedirection_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateForgetPasswordRedirection.printStackTrace();
			node.fail(validateForgetPasswordRedirection);
			Assert.fail();
			extent.flush();
		}

	}

	@Test(priority = 7)
	public void invalidEmailInForgotPassword() throws IOException {

		try {
			extenttest = extent
					.createTest("Verify that when the user enters an invalid Email id then error message is displayed.")
					.assignCategory(administration_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			// Click on the forgot password
			IElementActions.clickelement_usingXpath(node, driver, LoginPO.forgotPassword);
			node.log(Status.INFO, "STEP1 : clicked on the forgot password");
			System.out.println("STEP1 : clicked on the forgot password");

			// Wait for the visibility of the forgot password page
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the forgot password page");
			System.out.println("STEP2 : Waiting for the visibility of the forgot password page");
			IWaitStrategy.waitForVisiblity(node, driver, ForgotPO.forgotPasswordText);
			node.log(Status.INFO, "STEP3 : Forgot password page is visible");
			System.out.println("STEP3 : Forgot password page is visible");

			String invalidEmail = "123" + getDataFromExcel(3);

			// Click on email field and input the email
			IElementActions.clickAndInput_usingXpath(node, driver, ForgotPO.email, invalidEmail);
			node.log(Status.INFO, "STEP4 : Email entered by user on the forgot password page");
			System.out.println("STEP4 : Email entered by user on the forgot password page");

			// Press enter to submit login detail
			IElementActions.clickelement_usingXpath(node, driver, ForgotPO.sendButton);
			node.log(Status.INFO, "STEP5 : Clicked on the send button");
			System.out.println("STEP5 : Clicked on the send button");

			// Wait for the visibility of the error
			node.log(Status.INFO, "STEP6 : Waiting for the visibility of the error");
			System.out.println("STEP6 : Waiting for the visibility of the error");
			IWaitStrategy.waitForVisiblity(node, driver, ForgotPO.invalidEmailLoginError);
			node.log(Status.INFO, "STEP7 : Error is visible after sending invalid email");
			System.out.println("STEP7 : Error is visible after sending invalid email");

			// Verify that error message is displayed
			node.log(Status.INFO, "STEP8 : Verify that error message is displayed");
			System.out.println("STEP8 : Verify that error message is displayed");

			IElementActions.assertTrue_usingXpath(node, driver, ForgotPO.invalidEmailLoginError,
					"STEP9 : BUG - Error message is not displayed on the forgot password page",
					"STEP9 : EXPECTED - Error message is displayed on the forgot password page");

			// Take Screenshot of dashboard after user login
			IScreenAction.captureScreenShot_PassCase("invalidEmailInForgotPassword", "Pass", driver);

		} catch (AssertionError invalidEmailInForgotPassword) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In invalidEmailInForgotPassword test in LoginTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "invalidEmailInForgotPassword_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			invalidEmailInForgotPassword.printStackTrace();
			node.fail(invalidEmailInForgotPassword);
			Assert.fail();
			extent.flush();
		}

		catch (Exception invalidEmailInForgotPassword) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In invalidEmailInForgotPassword test in LoginTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "invalidEmailInForgotPassword_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			invalidEmailInForgotPassword.printStackTrace();
			node.fail(invalidEmailInForgotPassword);
			Assert.fail();
			extent.flush();
		}

	}

	@Test(priority = 8)
	public void validateSignInRedirectionFromForgotPassword() throws IOException {

		try {
			extenttest = extent.createTest(
					"Verify when the user clicks on the 'Sign in' link then the user navigates to the Sign-in page")
					.assignCategory(administration_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			// Click on the forgot password
			IElementActions.clickelement_usingXpath(node, driver, LoginPO.forgotPassword);
			node.log(Status.INFO, "STEP1 : clicked on the forgot password");
			System.out.println("STEP1 : clicked on the forgot password");

			// Wait for the visibility of the forgot password page
			node.log(Status.INFO, "STEP2 : Waiting for the visibility of the forgot password page");
			System.out.println("STEP2 : Waiting for the visibility of the forgot password page");
			IWaitStrategy.waitForVisiblity(node, driver, ForgotPO.forgotPasswordText);
			node.log(Status.INFO, "STEP3 : Forgot password page is visible");
			System.out.println("STEP3 : Forgot password page is visible");

			// Click on the Sign in
			IElementActions.clickelement_usingXpath(node, driver, ForgotPO.singIn);
			node.log(Status.INFO, "STEP4 : clicked on the Sign in");
			System.out.println("STEP4 : clicked on the Sign in");

			// Wait for the visibility of the sign in page
			node.log(Status.INFO, "STEP5 : Waiting for the visibility of the sign in page");
			System.out.println("STEP5 : Waiting for the visibility of the sign in page");
			IWaitStrategy.waitForVisiblity(node, driver, LoginPO.signInText);
			node.log(Status.INFO, "STEP6 : Sign in page is visible");
			System.out.println("STEP6 : Sign in page is visible");

			// Verify the Sign in page
			node.log(Status.INFO, "STEP7 : Verify that the Sign in page is displayed");
			System.out.println("STEP7 : Verify that the Sign in page is displayed");

			IElementActions.assertTrue_usingXpath(node, driver, LoginPO.signInText,
					"STEP8 : BUG - Sign in page is not displayed", "STEP5 : EXPECTED - Sign in page is displayed");

			// Take Screenshot of dashboard after user login
			IScreenAction.captureScreenShot_PassCase("validateSignInRedirectionFromForgotPassword", "Pass", driver);

		} catch (AssertionError validateSignInRedirectionFromForgotPassword) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateSignInRedirectionFromForgotPassword test in LoginTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateSignInRedirectionFromForgotPassword_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSignInRedirectionFromForgotPassword.printStackTrace();
			node.fail(validateSignInRedirectionFromForgotPassword);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateSignInRedirectionFromForgotPassword) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateSignInRedirectionFromForgotPassword test in LoginTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateSignInRedirectionFromForgotPassword_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateSignInRedirectionFromForgotPassword.printStackTrace();
			node.fail(validateSignInRedirectionFromForgotPassword);
			Assert.fail();
			extent.flush();
		}

	}

	// @Test(priority = 9)
	public void validateResetPasswordUsingChangePassword() throws IOException {
		try {
			extenttest = extent.createTest("Verify that a user can reset their Password using the provided link.")
					.assignCategory(administration_tag + "_" + env);
			node = extenttest.createNode("Report");

			String username = getDataFromExcel(3);
			String password = getDataFromExcel(4);
			String newPassword = password + IElementActions.getRandomNumber();

			updateDataOnExcel(5, password);

			System.out.println(getDataFromExcel(5));

			// Call the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			// Call the userLoginProcess function from the utils login
			LoginPage.userLoginProcess(node, driver, username, password);

			// Click on the administration
			Utils.clickOnMenu(node, driver, SideMenuPO.administration);

			// Click on the users
			Utils.clickOnMenu(node, driver, SideMenuPO.users);

			IElementActions.scrollbyJSExecutorUsingElementPath(driver, SideMenuPO.database);

			// Click on the users database
			Utils.clickOnMenu(node, driver, SideMenuPO.database);

			Thread.sleep(5000);

			// Click on username field and input the username
			IElementActions.clickAndInput_usingXpath(node, driver, UsersDatabasePO.usernameSearchBox, username);
			node.log(Status.INFO, "STEP1 : Username entered by user on the database page");
			System.out.println("STEP1 : Username entered by user on the database page");

			// Click on the edit icon
			IElementActions.clickelement_usingXpath(node, driver, UsersDatabasePO.editIcon);
			node.log(Status.INFO, "STEP2 : clicked on the edit icon");
			System.out.println("STEP2 : clicked on the edit icon");

			// Wait for the visibility of edit user page
			node.log(Status.INFO, "STEP3 : Waiting for the visibility of edit user page");
			System.out.println("STEP3 : Waiting for the visibility of edit user page");
			IWaitStrategy.waitForVisiblity(node, driver, UsersDatabasePO.changePasswordLink);
			node.log(Status.INFO, "STEP4 : Edit user page is visible");
			System.out.println("STEP4 : Edit user page is visible");

			// Click on the change password
			IElementActions.clickelement_usingXpath(node, driver, UsersDatabasePO.changePasswordLink);
			node.log(Status.INFO, "STEP5 : clicked on the change password");
			System.out.println("STEP5 : clicked on the change password");

			// Wait for the visibility of change password
			node.log(Status.INFO, "STEP6 : Waiting for the visibility of change password");
			System.out.println("STEP6 : Waiting for the visibility of change password");
			IWaitStrategy.waitForVisiblity(node, driver, UsersDatabasePO.changePasswordText);
			node.log(Status.INFO, "STEP7 : Change password is visible");
			System.out.println("STEP7 : Change password is visible");

			// Click on old password field and input the old password
			IElementActions.clickAndInput_usingXpath(node, driver, UsersDatabasePO.oldPassword, password);
			node.log(Status.INFO, "STEP8 : Old password entered by user on the change password");
			System.out.println("STEP8 : Old password entered by user on the change password");

			// Click on new password field and input the new password
			IElementActions.clickAndInput_usingXpath(node, driver, UsersDatabasePO.newPassword, newPassword);
			node.log(Status.INFO, "STEP9 : New password entered by user on the change password");
			System.out.println("STEP9 : New password entered by user on the change password");

			// Click on confirm password field and input the same new password
			IElementActions.clickAndInput_usingXpath(node, driver, UsersDatabasePO.confirmPassword, newPassword);
			node.log(Status.INFO, "STEP10 : Confirm password entered by user on the change password");
			System.out.println("STEP10 : Confirm password entered by user on the change password");

			// Click on the save button
			IElementActions.clickelement_usingXpath(node, driver, UsersDatabasePO.saveButton);
			node.log(Status.INFO, "STEP11 : Clicked on the save");
			System.out.println("STEP11 : Clicked on the save");

			if (IElementActions.isElementPresentByGetCheckingSize_usingXpath(node, driver,
					UsersDatabasePO.successPopupClose) > 0) {

				// Wait for the visibility of the success popup
				node.log(Status.INFO, "SUB-STEP1 : Waiting for the visibility of success popup");
				System.out.println("SUB-STEP1 : Waiting for the visibility of success popup");
				IWaitStrategy.waitForVisiblity(node, driver, UsersDatabasePO.successPopupClose);
				node.log(Status.INFO, "SUB-STEP2 : Success popup is visible");
				System.out.println("SUB-STEP2 : Success popup is visible");

				// Click on the close button
				IElementActions.clickelement_usingXpath(node, driver, UsersDatabasePO.successPopupClose);
				node.log(Status.INFO, "SUB-STEP3 : Clicked on the close button");
				System.out.println("SUB-STEP3 : Clicked on the close button");
			}

			updateDataOnExcel(4, newPassword);
			node.log(Status.INFO, "STEP12 : Updated the old password in excel");
			System.out.println("STEP12 : Updated the old password in excel");

			// Click on the header username
			IElementActions.clickelement_usingXpath(node, driver, SideMenuPO.headerUserName);
			node.log(Status.INFO, "STEP13 : Clicked on the header username");
			System.out.println("STEP13 : Clicked on the header username");

			// Click on the logout
			IElementActions.clickelement_usingXpath(node, driver, SideMenuPO.logout);
			node.log(Status.INFO, "STEP14 : Clicked on the logout");
			System.out.println("STEP14 : Clicked on the logout");

			// Call the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			node.log(Status.INFO, "STEP15 : Now login with new reset password");
			System.out.println("STEP15 : Now login with new reset password");

			// Call the enterLoginDetailsAndSubmit function from the utils login
			LoginPage.enterLoginDetailsAndSubmit(node, driver, getDataFromExcel(3), getDataFromExcel(4));

			// Verify that logged in user name is visible on top of Dashboard
			// page
			node.log(Status.INFO, "STEP16 : Verify that user able to login with new password");
			System.out.println("STEP16 : Verify that user able to login with new password");
			IElementActions.assertTrue_usingXpath(extenttest, driver, ReportingPO.headerUsername,
					"STEP17 : BUG:Logged in user name not coming on dashboard page",
					"STEP17 : EXPECTED:Logged in user name is coming on dashboard page");

			// Take Screenshot of dashboard after user login
			IScreenAction.captureScreenShot_PassCase("validateResetPasswordUsingChangePassword", "Pass", driver);

		} catch (AssertionError validateResetPasswordUsingChangePassword) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateResetPasswordUsingChangePassword test in LoginTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateResetPasswordUsingChangePassword_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateResetPasswordUsingChangePassword.printStackTrace();
			node.fail(validateResetPasswordUsingChangePassword);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateResetPasswordUsingChangePassword) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateResetPasswordUsingChangePassword test in LoginTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateResetPasswordUsingChangePassword_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateResetPasswordUsingChangePassword.printStackTrace();
			node.fail(validateResetPasswordUsingChangePassword);
			Assert.fail();
			extent.flush();
		}

	}

	// @Test(priority = 10)
	public void userLoginByNewlySetPassword() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the user can only log in with a newly set Password")
					.assignCategory(administration_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			// Call the userLoginProcess function from the utils login
			LoginPage.userLoginProcess(node, driver, getDataFromExcel(3), getDataFromExcel(4));

			// Verify that logged in user name is visible on top of Dashboard
			// page
			node.log(Status.INFO, "STEP1 : Verify that logged in user name is visible on top of the page");
			System.out.println("STEP1 : Verify that logged in user name is visible on top of the page");
			IElementActions.assertTrue_usingXpath(extenttest, driver, ReportingPO.headerUsername,
					"STEP2 : BUG:Logged in user name not coming on dashboard page",
					"STEP2 : EXPECTED:Logged in user name is coming on dashboard page");

			// Take Screenshot of dashboard after user login
			IScreenAction.captureScreenShot_PassCase("userLoginByNewlySetPassword", "Pass", driver);

		} catch (AssertionError userLoginByNewlySetPassword) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In userLoginByNewlySetPassword test in LoginTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "userLoginByNewlySetPassword_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			userLoginByNewlySetPassword.printStackTrace();
			node.fail(userLoginByNewlySetPassword);
			Assert.fail();
			extent.flush();
		}

		catch (Exception userLoginByNewlySetPassword) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In userLoginByNewlySetPassword test in LoginTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver, "userLoginByNewlySetPassword_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			userLoginByNewlySetPassword.printStackTrace();
			node.fail(userLoginByNewlySetPassword);
			Assert.fail();
			extent.flush();
		}

	}

	@Test(priority = 11)
	public void validateUserLoginByOldPassword() throws IOException {
		try {
			extenttest = extent.createTest("Verify that the user is not able Login with the old password")
					.assignCategory(administration_tag + "_" + env);
			node = extenttest.createNode("Report");

			// Call the loadLoginPage function from the utils login
			LoginPage.loadLoginPage();

			// Call the enterLoginDetailsAndSubmit function from the utils login
			LoginPage.enterLoginDetailsAndSubmit(node, driver, getDataFromExcel(3), getDataFromExcel(5));

			// Wait for the visibility of the error
			node.log(Status.INFO, "STEP1 : Waiting for the visibility of the error");
			System.out.println("STEP1 : Waiting for the visibility of the error");
			IWaitStrategy.waitForVisiblity(node, driver, LoginPO.invaliUsernameLoginError);
			node.log(Status.INFO, "STEP2 : Error is visible after login");
			System.out.println("STEP2 : Error is visible after login");

			// Verify that error message is displayed
			node.log(Status.INFO, "STEP3 : Verify that error message is displayed");
			System.out.println("STEP3 : Verify that error message is displayed");

			IElementActions.assertTrue_usingXpath(node, driver, LoginPO.invaliUsernameLoginError,
					"STEP4 : BUG - Error message is not displayed on the login page",
					"STEP4 : EXPECTED - Error message is displayed on the login page");

			// Take Screenshot of dashboard after user login
			IScreenAction.captureScreenShot_PassCase("validateUserLoginByOldPassword", "Pass", driver);
		} catch (AssertionError validateUserLoginByOldPassword) {

			node.log(Status.INFO,
					"EXCEPTION BLOCK 1 : FAIL : Some Assertion Error Caught In validateUserLoginByOldPassword test in LoginTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateUserLoginByOldPassword_Fail");
			node.log(Status.FAIL, "Some Assertion Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateUserLoginByOldPassword.printStackTrace();
			node.fail(validateUserLoginByOldPassword);
			Assert.fail();
			extent.flush();
		}

		catch (Exception validateUserLoginByOldPassword) {
			node.log(Status.INFO,
					"EXCEPTION BLOCK 2 : FAIL : Some Exception Error Caught In validateUserLoginByOldPassword test in LoginTest class");

			// Take the failed case screenshot
			String screenpath = IScreenAction.captureScreenShot_FailedCase(driver,
					"validateUserLoginByOldPassword_Fail");
			node.log(Status.FAIL, "Some Exception Error" + extenttest.addScreenCaptureFromPath(screenpath));

			validateUserLoginByOldPassword.printStackTrace();
			node.fail(validateUserLoginByOldPassword);
			Assert.fail();
			extent.flush();
		}

	}

}
