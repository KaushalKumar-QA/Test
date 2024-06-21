package com.qa.selenium.core.element;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.baseclass.Baseclass;

public class IElementActions extends Baseclass {

	/**
	 * The "isElementPresent_usingXpath" function is used to check the element
	 * present on webPage by passing its xpath
	 *
	 * @param test   Extent Test Instance
	 * @param driver Selenium WebDriver Instance
	 * @param Xpath  Pass xpath of element at run time
	 *
	 * @return boolean
	 * @throws InterruptedException
	 */
	public static boolean isElementPresent_usingXpath(ExtentTest test, WebDriver driver, String Xpath)
			throws InterruptedException {
		Thread.sleep(1000);
		return driver.findElement(By.xpath(Xpath)).isDisplayed();
	}

	/**
	 * The "isElementEnabled_usingXpath" function is used to check the element is
	 * enabled/disabled on webPage by passing its xpath
	 *
	 * @param test   Extent Test Instance
	 * @param driver Selenium WebDriver Instance
	 * @param Xpath  Pass xpath of element at run time
	 *
	 * @return boolean
	 */

	public static boolean isElementEnabled_usingXpath(ExtentTest test, WebDriver driver, String Xpath) {
		return driver.findElement(By.xpath(Xpath)).isEnabled();
	}

	/**
	 * The "isElementPresentByGetCheckingSize_usingXpath" function is used to check
	 * the element size present on webPage by passing its xpath
	 *
	 * @param test   Extent Test Instance
	 * @param driver Selenium WebDriver Instance
	 * @param Xpath  Pass xpath of element at run time
	 *
	 * @return Integer
	 */

	public static int isElementPresentByGetCheckingSize_usingXpath(ExtentTest test, WebDriver driver, String Xpath) {

		return driver.findElements(By.xpath(Xpath)).size();
	}

	public static boolean isElementAvailable(ExtentTest test, WebDriver driver, String Xpath) {

		return driver.findElements(By.xpath(Xpath)).size() > 0;
	}

	/**
	 * The "getElementText_usingXpath" function is used to get the text of the
	 * element present on webPage by passing its xpath
	 *
	 * @param test   Extent Test Instance
	 * @param driver Selenium WebDriver Instance
	 * @param Xpath  Pass xpath of element at run time
	 *
	 * @return
	 */

	public static String getElementText_usingXpath(ExtentTest test, WebDriver driver, String Xpath) {
		// System.out.println(driver.findElement(By.xpath(Xpath)).getText());
		return driver.findElement(By.xpath(Xpath)).getText();
	}

	/**
	 * The "getCurrentUrl" function is used to get the url of the current/active
	 * page
	 *
	 * @param test   Extent Test Instance
	 * @param driver Selenium WebDriver Instance
	 *
	 *
	 * @return String
	 */
	public static String getCurrentUrl(ExtentTest test, WebDriver driver) {
		return driver.getCurrentUrl();

	}

	/**
	 * The "clickelement_usingXpath" function is used to click on any of the element
	 * present on webPage by passing its xpath
	 *
	 * @param test   Extent Test Instance
	 * @param driver Selenium WebDriver Instance
	 * @param Xpath  Pass xpath of element at run time
	 *
	 */

	public static void clickelement_usingXpath(ExtentTest test, WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public static void clickAndSend_usingXpath(ExtentTest test, WebDriver driver, String xpath, String keysToSend) {
		driver.findElement(By.xpath(xpath)).click();
		node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on the element");
		System.out.println("SUB-STEP_0.001 : Clicked on the element");

		driver.findElement(By.xpath(xpath)).sendKeys(keysToSend);
		node.log(Status.INFO, "SUB-STEP_0.002 : Entered the value");
		System.out.println("SUB-STEP_0.002 : Entered the value");
	}

	/**
	 * The "switchToFrame" function is used to switch into frame present on webPage
	 * by passing its xpath
	 *
	 * @param test   Extent Test Instance
	 * @param driver Selenium WebDriver Instance
	 * @param Xpath  Pass xpath of element at run time
	 *
	 */

	public static void switchToFrame(ExtentTest test, WebDriver driver, String Xpath) {
		WebElement frameXpath = driver.findElement(By.xpath(Xpath));
		driver.switchTo().frame(frameXpath);
		System.out.println("SUB STEP 1 : Switched to frame");
		node.log(Status.INFO, "SUB STEP 1 : Switched to frame");
	}

	/**
	 * The "switchToFrameById" function is used to switch into frame present on
	 * webPage by passing its id
	 *
	 * @param test   Extent Test Instance
	 * @param driver Selenium WebDriver Instance
	 * @param id     of element at run time
	 *
	 */

	public static void switchToFrameById(ExtentTest test, WebDriver driver, String Id) {

		driver.switchTo().frame(Id);
		System.out.println("SUB STEP 1 : Switched to frame");
		// node.log(Status.INFO, "SUB STEP 1 : Switched to frame");
	}

	/**
	 * The "clearElement_usingXpath" function is used to clear/remove the value
	 * present on webPage field by passing its xpath
	 *
	 * @param test   Extent Test Instance
	 * @param driver Selenium WebDriver Instance
	 * @param Xpath  Pass xpath of element at run time
	 *
	 */

	public static void clearElement_usingXpath(ExtentTest test, WebDriver driver, String Xpath) {
		driver.findElement(By.xpath(Xpath)).clear();
		System.out.println("SUB STEP 1 : Value removed from the field");
		node.log(Status.INFO, "SUB STEP 1 : Value removed from the field");
	}

	/**
	 * The "clickClearAndInput_usingXpath" function is used to click on the field
	 * and removing the previous retained data present on the field and entering the
	 * new data by passing its xpath
	 *
	 * @param test   Extent Test Instance
	 * @param driver Selenium WebDriver Instance
	 * @param Xpath  Pass xpath of element at run time
	 *
	 */

	public static void clickClearAndInput_usingXpath(ExtentTest test, WebDriver driver, String xpath,
			String keysToSend) {

		// Click on field
		clickelement_usingXpath(node, driver, xpath);
		System.out.println("SUB STEP 1 : Clicked on the field");
		node.log(Status.INFO, "SUB STEP 1 : Clicked on the field");

		// Clear the old data
		WebElement ele = driver.findElement(By.xpath(xpath));
		new Actions(driver).click(ele).pause(200).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).pause(200)
				.sendKeys(Keys.BACK_SPACE).perform();

		System.out.println("SUB STEP 2 : Value removed from the field");
		node.log(Status.INFO, "SUB STEP 2 : Value removed from the field");

		// Input in the field as per new value
		driver.findElement(By.xpath(xpath)).sendKeys(keysToSend);
		System.out.println("SUB STEP 1 : Value entered in the field");
		node.log(Status.INFO, "SUB STEP 1 : Value entered in the field");

	}

	/**
	 * The "clickelement_usingId" function is used to click on any of the element
	 * present on webPage by passing its id
	 *
	 * @param test   Extent Test Instance
	 * @param driver Selenium WebDriver Instance
	 * @param id     Pass id of element at run time
	 *
	 */
	public static void clickelement_usingId(ExtentTest test, WebDriver driver, String id) {
		driver.findElement(By.id(id)).click();
	}

	/**
	 * The "assertTrue_usingXpath" function is used to assert the visibility of any
	 * element
	 *
	 * @param test        Extent Test instance
	 * @param driver      Selenium WebDriver instance
	 * @param xpath       Xpath of field
	 * @param BugMessage  To be shown if assert fails
	 * @param PassMessage To be shown if assert passes
	 *
	 *
	 */
	public static void assertTrue_usingXpath(ExtentTest test, WebDriver driver, String xpath, String BugMessage,
			String PassMessage) {
		Assert.assertTrue(driver.findElements(By.xpath(xpath)).size() > 0, BugMessage);
		System.out.println(PassMessage);
		node.log(Status.INFO, PassMessage);
	}

	/**
	 * The "assertFalse_usingXpath" function is used to assert the invisibility of
	 * any element
	 *
	 * @param test        Extent Test instance
	 * @param driver      Selenium WebDriver instance
	 * @param xpath       Xpath of field
	 * @param BugMessage  To be shown if assert fails
	 * @param PassMessage To be shown if assert passes
	 *
	 *
	 */
	public static void assertFalse_usingXpath(ExtentTest test, WebDriver driver, String xpath, String BugMessage,
			String PassMessage) {
		Assert.assertFalse(driver.findElements(By.xpath(xpath)).size() > 0, BugMessage);
		System.out.println(PassMessage);
		node.log(Status.INFO, PassMessage);
	}

	/**
	 * The "assertEquals_usingString" function is used Assert the actual String
	 * result with expected String result
	 *
	 * @param test           Extent Test Instance
	 * @param driver         Selenium WebDriver Instance
	 *
	 * @param actualResult   Pass the string that contains actual result
	 *
	 * @param expectedResult Pass the string that contains expected result
	 *
	 * @param BugMessage     To be shown if assert fails
	 *
	 * @param PassMessage    To be shown if assert passes
	 *
	 *
	 */
	public static void assertEquals_usingString(ExtentTest test, WebDriver driver, String actualResult,
			String expectedResult, String BugMessage, String PassMessage) {
		Assert.assertEquals(actualResult, expectedResult, BugMessage);
		System.out.println(PassMessage);
		node.log(Status.INFO, PassMessage);
	}

	public static void assertContains_usingString(ExtentTest test, WebDriver driver, String actualText,
			String expectedText, String BugMessage, String PassMessage) {
		Assert.assertTrue(actualText.contains(expectedText), BugMessage);
		System.out.println(PassMessage);
		node.log(Status.INFO, PassMessage);
	}

	/**
	 * The "assertEquals_usingInteger" function is used Assert the actual value
	 * result with expected value result
	 *
	 * @param test           Extent Test Instance
	 * @param driver         Selenium WebDriver Instance
	 *
	 * @param actualResult   Pass the string that contains actual result
	 *
	 * @param expectedResult Pass the string that contains expected result
	 *
	 * @param BugMessage     To be shown if assert fails
	 *
	 * @param PassMessage    To be shown if assert passes
	 *
	 *
	 */
	public static void assertEquals_usingInteger(ExtentTest test, WebDriver driver, int actualResult,
			int expectedResult, String BugMessage, String PassMessage) {
		Assert.assertEquals(actualResult, expectedResult, BugMessage);
		System.out.println(PassMessage);
		node.log(Status.INFO, PassMessage);
	}

	public static void assertEquals_usingDouble(ExtentTest test, WebDriver driver, double actualResult,
			double expectedResult, String BugMessage, String PassMessage) {
		Assert.assertEquals(actualResult, expectedResult, BugMessage);
		System.out.println(PassMessage);
		node.log(Status.INFO, PassMessage);
	}

	/**
	 * The "sendKeys_usingXpath" function is used send keys to any field by using
	 * xpath as locator
	 *
	 * @param test       Extent Test Instance
	 * @param driver     Selenium WebDriver Instance
	 * @param Xpath      Pass the xpath of element on run time
	 * @param keysToSend Selenium WebDriver Instance *
	 *
	 */
	public static void sendKeys_usingXpath(ExtentTest test, WebDriver driver, String Xpath, String keysToSend) {

		driver.findElement(By.xpath(Xpath)).sendKeys(keysToSend);
	}

	public static void pressKeys_usingXpath(ExtentTest test, WebDriver driver, String Xpath, Keys down) {

		driver.findElement(By.xpath(Xpath)).sendKeys(down);
	}

	public static void pressEnter_usingXpath(ExtentTest test, WebDriver driver, String Xpath) {

		driver.findElement(By.xpath(Xpath)).sendKeys(Keys.ENTER);
	}

	/**
	 * The "assertEquals_usingList" function is used Assert the actual ArrayList
	 * result with expected ArrayList result
	 *
	 * @param actualResult   Pass the string that contains actual result
	 *
	 * @param expectedResult Pass the string that contains expected result
	 *
	 * @param BugMessage     To be shown if assert fails
	 *
	 * @param PassMessage    To be shown if assert passes
	 *
	 *
	 */
	public static void assertEquals_usingList(ExtentTest test, WebDriver driver, ArrayList<String> actualResult,
			List<String> expectedResult, String BugMessage, String PassMessage) {
		Assert.assertEquals(actualResult, expectedResult, BugMessage);
		System.out.println(PassMessage);
		node.log(Status.INFO, PassMessage);
	}

	/**
	 * The "clickAndInput_usingXpath" function firstly clicks on any input field and
	 * then input the data as per need
	 *
	 * @param test       Extent Test Instance
	 * @param driver     Selenium WebDriver Instance *
	 * @param Xpath      Pass xpath of element at run time
	 * @param keysToSend Fetch the value from property file
	 *
	 */
	public static void clickAndInput_usingXpath(ExtentTest test, WebDriver driver, String xpath, String keysToSend) {

		// Click on field
		clickelement_usingXpath(node, driver, xpath);
		System.out.println("SUB STEP 1 : Clicked on the field");
		node.log(Status.INFO, "SUB STEP 1 : Clicked on the field");

		// Input value in field as per need by fetching the value from
		// Corresponding Interface
		driver.findElement(By.xpath(xpath)).sendKeys(keysToSend);
		System.out.println("SUB STEP 2 : Value entered in the field");
		node.log(Status.INFO, "SUB STEP 2 : Value entered in the filed");
	}

	/**
	 * The "clickAndInput_usingId" function firstly clicks on any input field and
	 * then input the data as per need
	 *
	 * @param test       Extent Test Instance
	 * @param driver     Selenium WebDriver Instance *
	 * @param Id         Pass id of element at run time
	 * @param keysToSend Fetch the value from property file
	 * @param fieldName  Give name of field
	 *
	 */
	public static void clickAndInput_usingId(ExtentTest test, WebDriver driver, String id, String keysToSend,
			String fieldName) {

		// Click on field
		clickelement_usingId(node, driver, id);

		System.out.println("SUB STEP 1 : Clicked on " + fieldName);
		node.log(Status.INFO, "SUB STEP 1 : Clicked on " + fieldName);

		// Input value in field as per need by fetching the value from
		// Corresponding Interface
		driver.findElement(By.id(id)).sendKeys(keysToSend);

		System.out.println("SUB STEP 2 : Value entered in: " + fieldName);
		node.log(Status.INFO, "SUB STEP 2 : Value entered in: " + fieldName);
	}

	/**
	 * The "assertTrue_usingId" function is used to assert the visibility of any
	 * element
	 *
	 * @param test        Extent Test instance
	 * @param driver      Selenium WebDriver instance
	 * @param id          id of field
	 * @param BugMessage  To be shown if assert fails
	 * @param PassMessage To be shown if assert passes
	 *
	 */
	public static void assertTrue_usingId(ExtentTest test, WebDriver driver, String id, String BugMessage,
			String PassMessage) {
		Assert.assertTrue(driver.findElements(By.id(id)).size() > 0, BugMessage);
		System.out.println(PassMessage);
		node.log(Status.INFO, PassMessage);
	}

	/**
	 * The "assertFalse_usingId" function is used to assert the invisibility of any
	 * element
	 *
	 * @param test        Extent Test instance
	 * @param driver      Selenium WebDriver instance
	 * @param id          id of field
	 * @param BugMessage  To be shown if assert fails
	 * @param PassMessage To be shown if assert passes
	 *
	 */
	public static void assertFalse_usingId(ExtentTest test, WebDriver driver, String id, String BugMessage,
			String PassMessage) {
		Assert.assertFalse(driver.findElements(By.id(id)).size() > 0, BugMessage);
		System.out.println(PassMessage);
		node.log(Status.INFO, PassMessage);
	}

	/**
	 * The "sendKeys_usingId" function is used send keys to any field by using id as
	 * locator
	 *
	 * @param test       Extent Test Instance
	 * @param driver     Selenium WebDriver Instance
	 * @param Id         Pass the id of element on run time
	 * @param keysToSend Selenium WebDriver Instance *
	 *
	 */
	public static void sendKeys_usingId(ExtentTest test, WebDriver driver, String id, String keysToSend) {
		driver.findElement(By.id(id)).sendKeys(keysToSend);
	}

	public static void clicking_element_in_dynamic_searchResults_dropdown_suggestions_usingXpath(ExtentTest test,
			WebDriver driver, String xpath, String keyword) {
		List<WebElement> list = driver.findElements(By.xpath(xpath));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equalsIgnoreCase(keyword)) {
				list.get(i).click();
				break;
			}
		}
		System.out.println("SUB STEP 1 : Clicked on option " + keyword);
		node.log(Status.INFO, "SUB STEP 1 : Clicked on option " + keyword);

	}

	public static void clicking_elementViaJavascript_in_dynamic_searchResults_dropdown_suggestions_usingXpath(
			ExtentTest test, WebDriver driver, String xpath, String keyword) {
		List<WebElement> list = driver.findElements(By.xpath(xpath));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equalsIgnoreCase(keyword)) {
				list.get(i).click();
				break;
			}
		}
		System.out.println("SUB STEP 1 : Clicked on option " + keyword);
		node.log(Status.INFO, "SUB STEP 1 : Clicked on option " + keyword);

	}

	public static void assertTrue_dynamic_search_usingXpath(ExtentTest test, WebDriver driver, String xpath,
			String keyword, String BugMessage, String PassMessage) {
		List<WebElement> searchedResults = driver.findElements(By.xpath(xpath));
		for (int i = 0; i < searchedResults.size(); i++) {
			Assert.assertTrue(searchedResults.get(i).getText().toLowerCase().contains(keyword),
					keyword + BugMessage + " " + searchedResults.get(i).getText());
			System.out.println(keyword + " " + PassMessage + " " + searchedResults.get(i).getText());
			node.log(Status.INFO, keyword + " " + PassMessage + " " + searchedResults.get(i).getText());
		}
	}

	public static void click_viaJavascript_usingXpath(ExtentTest test, WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", element);
	}

	public static void assertEquals_viaGetText_usingXpath(ExtentTest test, WebDriver driver, String xpath,
			String actualResult, String BugMessage, String PassMessage) {

		String expectedResult = driver.findElement(By.xpath(xpath)).getText().toLowerCase();
		Assert.assertEquals(actualResult, expectedResult, BugMessage);
		System.out.println(PassMessage);
		node.log(Status.INFO, PassMessage);
	}

	public static void scrollByJSExecutor(WebDriver driver, int pixel) {
		// to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixel + ")", "");
	}

	public static void scrollbyJSExecutorUsingElement(WebDriver driver, WebElement element) {
		// to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	/**
	 * The "scrollbyJSExecutorUsingElementPath" function is used to scroll till the
	 * given element appears
	 *
	 * @param driver  Selenium WebDriver Instance
	 * @param element Pass the element on run time
	 *
	 * @throws InterruptedException
	 */
	public static void scrollbyJSExecutorUsingElementPath(WebDriver driver, String element) {
		// to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", IElementActions.returnElement(node, driver, element));
	}

	public static void scrollToBottom(WebDriver driver) {
		// Create a JavascriptExecutor instance
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll to the bottom of the page
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// You can also use the following alternative to scroll to the bottom:
		// js.executeScript("window.scrollTo(0,
		// document.documentElement.scrollHeight)");
	}

	public static void clickig_all_elements_of_list_usingXpath(ExtentTest test, WebDriver driver, String xpath)
			throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath(xpath));
		for (int i = 0; i < list.size(); i++) {
			Thread.sleep(5000);
			list.get(i).click();
			Thread.sleep(5000);
			scrollByJSExecutor(driver, 150);
			System.out.println("SUB STEP" + (i + 1) + " : Clicked on  " + list.get(i).getText());
			node.log(Status.INFO, "SUB STEP" + (i + 1) + " : Clicked on " + list.get(i).getText());
		}

	}

	public static boolean isAttribtuePresent(ExtentTest test, WebDriver driver, String xpath, String attribute) {
		Boolean result = false;
		try {
			String value = driver.findElement(By.xpath(xpath)).getAttribute(attribute);
			if (value != null) {
				result = true;
			}
		} catch (Exception e) {
		}

		return result;
	}

	public static void assertTrueFewElements_dynamic_search_usingXpath(ExtentTest test, WebDriver driver, String xpath,
			String keyword, String BugMessage, String PassMessage) {
		List<WebElement> searchedResults = driver.findElements(By.xpath(xpath));
		for (int i = 0; i < searchedResults.size(); i++) {
			if (searchedResults.get(i).getText().toLowerCase().contains(keyword)) {
				Assert.assertTrue(searchedResults.get(i).getText().toLowerCase().contains(keyword),
						keyword + BugMessage + " " + searchedResults.get(i).getText());
				System.out.println(keyword + " " + PassMessage + " " + searchedResults.get(i).getText());
				node.log(Status.INFO, keyword + " " + PassMessage + " " + searchedResults.get(i).getText());
			} else if (!searchedResults.get(i).getText().toLowerCase().contains(keyword)) {
				System.out.println(keyword + " does not exist in " + searchedResults.get(i).getText()
						+ " as product type is same but product name is different");
				node.log(Status.INFO, keyword + " does not exist in " + searchedResults.get(i).getText()
						+ " as product type is same but product name is different");

			}
		}
	}

	public static void assertEqualsFalse_usingString(ExtentTest test, WebDriver driver, String actualResult,
			String expectedResult, String BugMessage, String PassMessage) {
		Assert.assertFalse(actualResult.equalsIgnoreCase(expectedResult), BugMessage);
		System.out.println(PassMessage);
		node.log(Status.INFO, PassMessage);
	}

	/**
	 * The "getElementTextFromAttribute_usingXpath" function is used to get the text
	 * of the element present in the webpage from its attribute by passing its xpath
	 * & attribute name
	 *
	 * @param test      Extent Test Instance
	 * @param driver    Selenium WebDriver Instance
	 * @param Xpath     Pass xpath of element at run time
	 * @param attribute Pass attribute name of element
	 *
	 * @return String
	 */

	public static String getElementTextFromAttribute_usingXpath(ExtentTest test, WebDriver driver, String xpath,
			String attribute) {

		WebElement element = driver.findElement(By.xpath(xpath));
		return element.getAttribute(attribute);
	}

	/**
	 * The "clearAndInputElementUsingAction_Xpath" function is used to clear/remove
	 * the value using action class for element present on the webPage by passing
	 * its xpath & enter the value
	 *
	 * @param test   Extent Test Instance
	 * @param driver Selenium WebDriver Instance
	 * @param Xpath  Pass xpath of element at run time
	 *
	 * @throws InterruptedException
	 */

	public static void clearAndInputElementUsingAction_Xpath(ExtentTest test, WebDriver driver, String xpath,
			String keysToSend) throws InterruptedException {
		WebDriverWait wait1 = new WebDriverWait(driver, 90);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

		// Clear the old data
		WebElement ele = driver.findElement(By.xpath(xpath));
		new Actions(driver).click(ele).pause(200).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).pause(200)
				.sendKeys(Keys.BACK_SPACE).perform();

		System.out.println("SUB STEP 1 : Value removed from the field");
		node.log(Status.INFO, "SUB STEP 1 : Value removed from the field");

		Thread.sleep(1000);
		driver.findElement(By.xpath(xpath)).sendKeys(keysToSend);
		System.out.println("SUB STEP 2 : Value entered in the field");
		node.log(Status.INFO, "SUB STEP 2 : Value entered in the field");

	}

	/**
	 * The "selectValueFromDropdown" function is used to select the value from the
	 * dropdown using xpath of element
	 *
	 * @param test   Extent Test Instance
	 * @param driver Selenium WebDriver Instance
	 * @param Xpath  Pass the xpath of element at run time
	 * @param name   Select the name from the dropdown
	 *
	 */

	public static void selectValueFromDropdown(ExtentTest test, WebDriver driver, String xpath, String name) {

		WebElement ele = driver.findElement(By.xpath(xpath));
		Select drp = new Select(ele);
		drp.selectByVisibleText(name);

		System.out.println("SUB STEP 1 : Value selected from the dropdown");
		node.log(Status.INFO, "SUB STEP 1 : Value selected from the dropdown");
	}

	public static void selectByValueFromDropdown(ExtentTest test, WebDriver driver, String xpath, String name) {

		WebElement ele = driver.findElement(By.xpath(xpath));
		Select drp = new Select(ele);
		drp.selectByValue(name);

		System.out.println("SUB STEP 1 : Value selected from the dropdown");
		node.log(Status.INFO, "SUB STEP 1 : Value selected from the dropdown");
	}

	public static String getFirstValueFromDropdown(ExtentTest test, WebDriver driver, String xpath) {

		WebElement ele = driver.findElement(By.xpath(xpath));
		Select drp = new Select(ele);
		// Get the first selected option value
		String firstOptionValue = drp.getFirstSelectedOption().getAttribute("Value");
		return firstOptionValue;
	}

	/**
	 * The "moveToElementAndClick_usingXpath" function is used to move on any of the
	 * element and click on that element using JavascriptExecutor
	 *
	 * @param test   Extent Test Instance
	 * @param driver Selenium WebDriver Instance
	 * @param Xpath  Pass xpath of element at run time
	 *
	 */

	public static void moveToElementAndClick_usingXpath(ExtentTest test, WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

	}

	/**
	 * The "returnElement" function is used to return the WebElement
	 *
	 * @param test   Extent Test Instance
	 * @param driver Selenium WebDriver Instance
	 * @param Xpath  Pass xpath of element at run time
	 *
	 * @return WebElement
	 */

	public static WebElement returnElement(ExtentTest test, WebDriver driver, String Xpath) {
		return driver.findElement(By.xpath(Xpath));
	}

	public static String getElementValue(ExtentTest test, WebDriver driver, String Xpath) {
		WebElement element = driver.findElement(By.xpath(Xpath));
		String elementValue = element.getAttribute("value");
		node.log(Status.INFO, "Sub Step1 : Element value is " + elementValue);
		System.out.println("Sub Step1 : Element value is " + elementValue);
		return elementValue;
	}

	/**
	 * The "returnElements" function is used to return the WebElements
	 *
	 * @param test   Extent Test Instance
	 * @param driver Selenium WebDriver Instance
	 * @param Xpath  Pass xpath of element at run time
	 *
	 * @return WebElements
	 */

	public static List<WebElement> returnElements(ExtentTest test, WebDriver driver, String Xpath) {
		return driver.findElements(By.xpath(Xpath));
	}

	/**
	 * The "equalLists" function is used to compair 2 lists and return the result
	 *
	 * @param a First List Instance
	 * @param b Second List Instance
	 *
	 * @return boolean
	 */
	public static boolean equalLists(List<String> first, List<String> Second) {
		// Check for sizes and nulls
		// Sort and compare the two lists
		Collections.sort(first);
		Collections.sort(Second);
		return first.equals(Second);
	}

	/**
	 * The "waitintilElementClickable" function is used to wait for the element to
	 * be clickable and then click on the Element
	 *
	 * @param test   Extent Test Instance
	 * @param driver Selenium WebDriver Instance
	 * @param Xpath  Pass xpath of element at run time
	 *
	 */
	public static void waitintilElementClickable(ExtentTest test, WebDriver driver, String Xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath)));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	/**
	 * The "isLinkBroken" function is used to check how many broken links available
	 * based on response.
	 *
	 * @param URL url will enter return String
	 ***/
	public static String isLinkBroken(URL url) throws Exception

	{

		String response = "";

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		try

		{

			connection.connect();

			response = connection.getResponseMessage();

			connection.disconnect();

			return response;

		}

		catch (Exception exp)

		{

			return exp.getMessage();

		}

	}

	/**
	 * The "findAllLinks" function is used fetch data in list based on same tag or
	 * you wan modify this functiona as per your requirement .
	 *
	 * @param driver Selenium WebDriver Instance *
	 *
	 * @return WebElements
	 ***/
	public static List<WebElement> findAllLinks(WebDriver driver)

	{

		List<WebElement> elementList = new ArrayList<WebElement>();

		elementList = driver.findElements(By.tagName("a"));

		elementList.addAll(driver.findElements(By.tagName("img")));

		List<WebElement> finalList = new ArrayList<WebElement>();

		for (WebElement element : elementList)

		{

			if (element.getAttribute("href") != null && element.getAttribute("href").contains("  ")) // add name

			{

				finalList.add(element);

			}

		}

		return finalList;

	}

	/**
	 * The "ChangeDateFormat" function is used to change date format .
	 *
	 * @param NewFormat In which formate you want to chagne
	 * @param Date      date instance
	 *
	 * @return String
	 ***/
	public static String ChangeDateFormat(String NewFormat, String Date) {

		try {

			DateFormat formatter1 = new SimpleDateFormat(NewFormat);
			Date = formatter1.format(Date);

		} catch (Exception e) {

		}
		return Date;
	}

	/**
	 * The "getRandomNumber" function is used to generate random number between
	 * given limit*
	 *
	 * @param lowerBound minimum range *
	 * @param upperBound maximum range
	 *
	 * @return Integer
	 */
	public static int getRandomNumber() {
		int randomNumber = 0;
		Random random = new Random();
		randomNumber = random.nextInt(1000);
		return randomNumber;

	}

	/**
	 * The "PauseTestExecution" function is used to pause run time execution as per
	 * given time*
	 *
	 * @param sec pause time based on second at time time
	 */
	public static void PauseTestExecution(int sec) {

		if (sec > 5)// show a warnig message, if test execution is paused more
			// than 5 seconds from
			// any
			System.out.println("Test Execution paused for " + sec);

		try {
			Thread.sleep(1000 * sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void setExcelSheetData(String sheetName, String cellvalue, int row, int col) throws IOException {
		File src = new File("D:\\Automation Backup\\NewExcel.xlsx");

		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet("sheetName");
		sheet.getRow(row).getCell(col).setCellValue(cellvalue);

		FileOutputStream fos = new FileOutputStream(src);
		wb.write(fos);
		wb.close();
		fos.close();

	}

	public static String getTextbyXpath(ExtentTest test, String xpath) {
		String text = driver.findElement(By.xpath(xpath)).getText();
		return text;
	}

	/**
	 * The "dateTime" function is used to create date .
	 *
	 * @return String
	 **/
	public static String dateTime()

	{
		// Add Timestamp
		String dateName = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
		return dateName;
	}

	/**
	 * The "moveToElement_MouseHover" function is used to move on any of the element
	 * using Actions class
	 *
	 * @param test   Extent Test Instance
	 * @param driver Selenium WebDriver Instance
	 * @param Xpath  Pass xpath of element at run time
	 */
	public static void moveToElement_MouseHover(ExtentTest test, WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		Actions ac = new Actions(driver);
		ac.moveToElement(element).build().perform();
	}

	/**
	 * The "moveToElementUsingActionAndGetText" function is used to move on any of
	 * the element using action class and get the text
	 *
	 * @param test   Extent Test Instance
	 * @param driver Selenium WebDriver Instance
	 * @param Xpath  Pass xpath of element at run time
	 * @return String
	 */
	public static String moveToElementUsingActionAndGetText(ExtentTest test, WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		Actions ac = new Actions(driver);
		ac.moveToElement(element).build().perform();
		return element.getText();
	}

	/**
	 * The "moveToFromElementAndClick" function is used to move from source element
	 * to destination element and then click on the destination element
	 *
	 * @param test             Extent Test Instance
	 * @param driver           Selenium WebDriver Instance
	 * @param sourceXpath      xpath of source element at run time
	 * @param destinationXpath xpath of destination element at run time
	 */
	public static void moveToFromElementAndClick(ExtentTest test, WebDriver driver, String sourceXpath,
			String destinationXpath) {
		Actions action = new Actions(driver);
		WebElement source = driver.findElement(By.xpath(sourceXpath));
		WebElement destination = driver.findElement(By.xpath(destinationXpath));
		action.click(source).moveToElement(destination).click().build().perform();

	}

	/**
	 * The "closeChildWindowAndSwitchToParent" function is used to close all child
	 * windows except parent window
	 *
	 * @param mainWindowHandle Input parent window
	 * @throws IOException
	 */

	public static void closeChildWindowAndSwitchToParent(String mainWindowHandle) throws InterruptedException {
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				driver.close();
			}
			driver.switchTo().window(mainWindowHandle);
		}
	}

	public static void getWindowhandlesbyIndex() {
		Set<String> windows = driver.getWindowHandles();
		int totalWin = windows.size();
		String winTitle = null;
		winTitle = windows.toArray()[totalWin - 1].toString();
		driver.switchTo().window(winTitle);
	}

	public static int clickAllElementsOfLists(ExtentTest test, WebDriver driver, String xpath)
			throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath(xpath));
		for (int i = 0; i < list.size(); i++) {
			Thread.sleep(5000);
			list.get(i).click();
			Thread.sleep(5000);
			IElementActions.scrollByJSExecutor(driver, 150);
			System.out.println("SUB STEP" + (i + 1) + " : Clicked on  " + list.get(i).getText());
			node.log(Status.INFO, "SUB STEP" + (i + 1) + " : Clicked on " + list.get(i).getText());
		}
		return list.size();
	}

	public void closeChildWindowsIfAny() throws InterruptedException, IOException {

		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();
		IElementActions.closeChildWindowAndSwitchToParent(mainWindowHandle);
	}

	public static void switchToChildWindow() {
		// Get handles of the windows
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();

		Iterator<String> iterator = allWindowHandles.iterator();

		// // Here we will check if child window has other child windows and
		// will fetch the
		// // heading of the child window
		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
			}
		}
	}

	public static void assertTrue_ConditionBased(ExtentTest test, WebDriver driver, boolean condition,
			String BugMessage, String PassMessage) {
		Assert.assertTrue(condition, "BUG : " + BugMessage);
		System.out.println("PASS : " + PassMessage);
		node.log(Status.INFO, "PASS : " + PassMessage);
	}

	/**
	 * The "assertTrue_usingboolean" function is used to assert the boolean value of
	 * any element
	 *
	 * @param test        Extent Test instance
	 * @param driver      Selenium WebDriver instance
	 * @param value       boolean value
	 * @param BugMessage  To be shown if assert fails
	 * @param PassMessage To be shown if assert passes
	 */

	public static void assertTrue_usingboolean(ExtentTest test, WebDriver driver, boolean value, String BugMessage,
			String PassMessage) {
		Assert.assertTrue(value, BugMessage);
		System.out.println(PassMessage);
		node.log(Status.INFO, PassMessage);
	}

	/**
	 * The "assertEquals_usingBoolean" function is used Assert the actual String
	 * result with expected String result
	 *
	 * @param test           Extent Test Instance
	 * @param driver         Selenium WebDriver Instance
	 *
	 * @param actualResult   Pass the boolean that contains actual result
	 *
	 * @param expectedResult Pass the boolean that contains expected result
	 *
	 * @param BugMessage     To be shown if assert fails
	 *
	 * @param PassMessage    To be shown if assert passes
	 *
	 */
	public static void assertEquals_usingboolean(ExtentTest test, WebDriver driver, boolean actualResult,
			boolean expectedResult, String BugMessage, String PassMessage) {
		Assert.assertEquals(actualResult, expectedResult, BugMessage);
		System.out.println(PassMessage);
		node.log(Status.INFO, PassMessage);
	}

	/**
	 * The "assertFalse_ConditionBased" function is used to Assert the that a
	 * specified condition is false
	 *
	 * @param test        Extent Test Instance
	 * @param driver      Selenium WebDriver Instance
	 *
	 * @param Pass        the boolean that contains condition
	 *
	 * @param BugMessage  To be shown if assert fails
	 *
	 * @param PassMessage To be shown if assert passes
	 *
	 */

	public static void assertFalse_ConditionBased(ExtentTest test, WebDriver driver, boolean condition,
			String BugMessage, String PassMessage) {
		Assert.assertFalse(condition, "BUG : " + BugMessage);
		System.out.println("PASS : " + PassMessage);
		node.log(Status.INFO, "PASS : " + PassMessage);
	}

	public static boolean isElementSelected_usingXpath(ExtentTest test, WebDriver driver, String Xpath)
			throws InterruptedException {
		Thread.sleep(1000);
		return driver.findElement(By.xpath(Xpath)).isSelected();
	}

	public static String createDynamicLocatorString(String originalXPath, String wordToReplace, String replacement) {

		return originalXPath.replaceAll(wordToReplace, replacement);

	}

	public static WebElement createDynamicLocator(String originalXPath, String wordToReplace, String replacement) {

		String dynamicXpathInString = originalXPath.replaceAll(wordToReplace, replacement);
		WebElement dynamicXpathWebElement = driver.findElement(By.xpath(dynamicXpathInString));
		return dynamicXpathWebElement;

	}

	public static boolean checkAttributePresentInClass(String xpath, String property) {
		WebElement element = driver.findElement(By.xpath(xpath));
		boolean checkProperty = element.getAttribute("class").contains(property);
		return checkProperty;

	}

	public static void pageRefresh() {
		driver.navigate().refresh();

	}

	// Function to check if an element is present
	public static boolean isElementPresent(WebDriver driver, String xpath) {
		try {
			// Use findElements instead of findElement
			// findElements returns a list of elements matching the criteria
			// If the list is empty, the element is not present
			return !driver.findElements(By.xpath(xpath)).isEmpty();
		} catch (Exception e) {
			// Handle any exceptions, e.g., print a message or log it
			System.out.println("Exception while checking element presence: " + e.getMessage());
			return false;
		}
	}

	// Method to scroll to the top of the page using JavascriptExecutor
	public static void scrollToTop(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
	}

	// Method to scroll horizontally to the last element on the page using
	// JavascriptExecutor
	public static void scrollHorizontalToLast(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll to the right by a large value to ensure reaching the last element
		js.executeScript("window.scrollTo(10000, 0);");
	}

	public static void scrollIntoView(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void scrollHorizontally(WebDriver driver, String xpath, int scrollValue) {
		WebElement element = driver.findElement(By.xpath(xpath));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollLeft = arguments[1];", element, scrollValue);
	}

	public static double parseStringToDoubleWithTwoDecimal(WebDriver driver, String data) {
		double value = Double.parseDouble(data);

		// Create a DecimalFormat object with the desired format
		DecimalFormat decimalFormat = new DecimalFormat("#.##");

		// Format the double value with two decimal places
		String formattedValue = decimalFormat.format(value);

		// Parse the formatted string back to a double (if needed)
		return Double.parseDouble(formattedValue);
	}

	public static String formattedDoubleWithTwoDecimal(WebDriver driver, double data) {
		// Create a DecimalFormat object with the desired format
		DecimalFormat decimalFormat = new DecimalFormat("#.##");

		// Format the double value with two decimal places
		return decimalFormat.format(data);

	}

	/**
	 * The "assertEqualsFalse_usingDouble" function is used to assert the actual
	 * result is not equals with the expected result
	 *
	 * @param test
	 * @param driver
	 * @param actualResult
	 * @param expectedResult
	 * @param BugMessage
	 * @param PassMessage
	 */
	public static void assertEqualsFalse_usingDouble(ExtentTest test, WebDriver driver, double actualResult,
			double expectedResult, String BugMessage, String PassMessage) {
		Assert.assertFalse(actualResult == expectedResult, BugMessage);
		System.out.println(PassMessage);
		node.log(Status.INFO, PassMessage);
	}

	/**
	 * The "assertEqualsFalse_usingInteger" function is used to assert the actual
	 * result is not equals with the expected result
	 *
	 * @param test
	 * @param driver
	 * @param actualResult
	 * @param expectedResult
	 * @param BugMessage
	 * @param PassMessage
	 */
	public static void assertEqualsFalse_usingInteger(ExtentTest test, WebDriver driver, int actualResult,
			int expectedResult, String BugMessage, String PassMessage) {
		Assert.assertFalse(actualResult == expectedResult, BugMessage);
		System.out.println(PassMessage);
		node.log(Status.INFO, PassMessage);
	}

	public static String getFirstValueFromDropdownByText(ExtentTest test, WebDriver driver, String xpath) {
		WebElement ele = driver.findElement(By.xpath(xpath));
		Select drp = new Select(ele);
		// Get the first selected option value
		String firstOptionValue = drp.getFirstSelectedOption().getText();
		return firstOptionValue;
	}

	public static void selectValueFromDropdownByIndex(ExtentTest test, WebDriver driver, String xpath, int index) {
		WebElement ele = driver.findElement(By.xpath(xpath));
		Select drp = new Select(ele);
		drp.selectByIndex(index);
		System.out.println("SUB STEP 1 : Value selected from the dropdown");
		node.log(Status.INFO, "SUB STEP 1 : Value selected from the dropdown");
	}

}