package com.qa.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.locators.allPages.LoginPO;
import com.locators.allPages.ReportingPO;
import com.locators.allPages.UtilsPO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.url.AllPagesUrl;

public class LoginPage extends Baseclass {

	/**
	 * The "loadLoginPage" function is used to load login page
	 *
	 * @author Daffodil Software Private Limited
	 * @version 1.0
	 * @since 19.12.2023
	 */
	public static void loadLoginPage() {
		// Open the login page
		node.log(Status.INFO,
				"SUB-STEP_0.001 : Opening the Lend Direct loginpage by fetching the url from AllPagesUrls");
		System.out.println("SUB-STEP_0.001 : Opening the Lend Direct loginpage by fetching the url from AllPagesUrls");
		driver.get(AllPagesUrl.loginPage);
		// Wait for the visibility of login form
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of login form");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of login form");
		IWaitStrategy.waitForVisiblity(node, driver, LoginPO.username);
		node.log(Status.INFO, "SUB-STEP_0.003 : Login form is visible now");
		System.out.println("SUB-STEP_0.003 : Login form is visible now");
	}

	/**
	 * The "enterLoginDetailsAndSubmit" function is used to enter login details and
	 * click on the submit button
	 *
	 * @param node     Extent Test Instance
	 * @param driver   Selenium WebDriver Instance *
	 * @param userName UserName at run time
	 * @param passord  Enter password at run time
	 * @author Daffodil Software Private Limited
	 * @version 1.0
	 * @since 19.12.2023
	 */
	public static void enterLoginDetailsAndSubmit(ExtentTest node, WebDriver driver, String userName, String Password)
			throws InterruptedException {
		// Click on username field and input the username
		
		IElementActions.clickAndInput_usingXpath(node, driver, LoginPO.username, userName);
		node.log(Status.INFO, "SUB-STEP_0.001 : Username entered by user on the login page");
		System.out.println("SUB-STEP_0.001 : Username entered by user on the login page");
		// Click on password field and input the password
		
		IElementActions.clickAndInput_usingXpath(node, driver, LoginPO.password, Password);
		node.log(Status.INFO, "SUB-STEP_0.002 : Password entered by user on the login page");
		System.out.println("SUB-STEP_0.002 : Password entered by user on the login page");
		// Press enter to submit login detail
		
		IElementActions.pressEnter_usingXpath(node, driver, LoginPO.password);
		
		node.log(Status.INFO, "SUB-STEP_0.003 : Pressed enter to submit the login details");
		System.out.println("SUB-STEP_0.003 : Pressed enter to submit the login details");
	}

	/**
	 * The "userLoginProcess" function is used to login by entering login details,
	 * OTP details
	 *
	 * @param node     Extent Test Instance
	 * @param driver   Selenium WebDriver Instance *
	 * @param userName UserName at run time
	 * @param passord  Enter password at run time
	 * @author Daffodil Software Private Limited
	 * @version 1.0
	 * @since 19.12.2023
	 */
	public static void userLoginProcess(ExtentTest node, WebDriver driver, String userName, String Password)
			throws FileNotFoundException, InterruptedException, IOException {
		Thread.sleep(5000);
		String otp = getDataFromExcel(8);
		// Call the enterLoginDetailsAndSubmit function from the utils login
		enterLoginDetailsAndSubmit(node, driver, userName, Password);
		IWaitStrategy.WaitForPageLoadingToComplete(node, driver);
		if (IElementActions.isElementPresentByGetCheckingSize_usingXpath(node, driver, LoginPO.codeText) > 0) {
			// Wait for the visibility of OTP screen
			node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of OTP screen");
			System.out.println("SUB-STEP_0.001 : Waiting for the visibility of OTP screen");
			IWaitStrategy.waitForVisiblity(node, driver, LoginPO.codeText);
			IWaitStrategy.waitForPresence(node, driver, LoginPO.codeText);
			node.log(Status.INFO, "SUB-STEP_0.002 : OTP screen is visible now");
			System.out.println("SUB-STEP_0.002 : OTP screen is visible now");
			// Enter OTP
			IElementActions.sendKeys_usingXpath(node, driver, LoginPO.code, otp);
			node.log(Status.INFO, "SUB-STEP_0.003 : OTP entered by user on the OTP page");
			System.out.println("SUB-STEP_0.003 : OTP entered by user on the OTP page");
			IElementActions.clickelement_usingXpath(node, driver, LoginPO.loginButton);
			System.out.println("SUB-STEP 0.004 : Clicked on OTP login button.");
			node.log(Status.INFO, "SUB-STEP 0.004 : Clicked on OTP login button.");
		}
		if (IElementActions.isElementPresentByGetCheckingSize_usingXpath(node, driver, LoginPO.popupheader) > 0) {
			IElementActions.scrollToBottom(driver);
			// Wait for the visibility of dashboad page after login
			node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of Accept button");
			System.out.println("SUB-STEP_0.001 : Waiting for the visibility of Accept button");
			IWaitStrategy.waitForVisiblity(node, driver, ReportingPO.headerUsername);
			node.log(Status.INFO, "SUB-STEP_0.002 : Accept button is visible");
			System.out.println("SUB-STEP_0.002 : Accept button is visible");
			IElementActions.clickelement_usingXpath(node, driver, LoginPO.popupAccept);
			System.out.println("SUB-STEP 0.004 : Clicked on  Accept button.");
			node.log(Status.INFO, "SUB-STEP 0.004 : Clicked on  Accept button.");
		}
		// Wait for the visibility of dashboad page after login
		node.log(Status.INFO, "SUB-STEP_0.01 : Waiting for the visibility of dashboad page after login");
		System.out.println("SUB-STEP_0.01 : Waiting for the visibility of dashboad page after login");
		IWaitStrategy.waitForVisiblity(node, driver, ReportingPO.headerUsername);
		IWaitStrategy.waitForVisiblity(node, driver, UtilsPO.dashboard);
		node.log(Status.INFO, "SUB-STEP_0.02 : Dashboard page is visible after login");
		System.out.println("SUB-STEP_0.02 : Dashboard page is visible after login");
	}

}
