package com.qa.utils;

import com.aventstack.extentreports.Status;
import com.locators.allPages.UsersDatabasePO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.element.IWaitStrategy;
import com.qa.url.AllPagesUrl;

public class AdministrationPage extends Baseclass {

	/**
	 * The "loadUsersDatabasePage" function is used to load the database page under
	 * Administration >> Users
	 *
	 * @author Daffodil Software Private Limited
	 * @version 1.0
	 * @since 19.12.2023
	 */
	public static void loadUsersDatabasePage() {
		// Open the login page
		node.log(Status.INFO, "SUB-STEP_0.001 : Opening the database page under users");
		System.out.println("SUB-STEP_0.001 : Opening the database page under users");
		driver.get(AllPagesUrl.userDatabasePage);
		// Wait for the visibility of database page
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of users database page");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of users database page");
		IWaitStrategy.waitForVisiblity(node, driver, UsersDatabasePO.usernameSearchBox);
		IWaitStrategy.WaitUntilElementClickable(node, driver, UsersDatabasePO.usernameSearchBox);
		node.log(Status.INFO, "SUB-STEP_0.003 : Users database page is visible");
		System.out.println("SUB-STEP_0.003 : Users database page is visible");
		
	}

}
