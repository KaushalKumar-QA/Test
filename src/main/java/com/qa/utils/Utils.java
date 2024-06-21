package com.qa.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.DateUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.locators.allPages.FundingDatabasePO;
import com.locators.allPages.ReportingUpdatesPO;
import com.locators.allPages.UtilsPO;
import com.qa.baseclass.Baseclass;
import com.qa.selenium.core.driver.IScreenAction;
import com.qa.selenium.core.element.IElementActions;
import com.qa.selenium.core.element.IWaitStrategy;

public class Utils extends Baseclass {

	/**
	 * The "clickOnMenu" function is used to click on the side menu based on the
	 * provided xpath
	 *
	 * @param node   Extent Test Instance
	 * @param driver Selenium WebDriver Instance *
	 * @param menu   Menu at run time
	 * @author Daffodil Software Private Limited
	 * @version 1.0
	 * @since 19.12.2023
	 */
	public static void clickOnMenu(ExtentTest node, WebDriver driver, String menu) throws InterruptedException {
		// Wait for the visibility of menu
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of menu");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of menu");
		IWaitStrategy.waitForVisiblity(node, driver, menu);
		IWaitStrategy.WaitUntilElementClickable(node, driver, menu);
		node.log(Status.INFO, "SUB-STEP_0.002 : Menu is visible");
		System.out.println("SUB-STEP_0.002 : Menu is visible");
		// Click on the menu
		IElementActions.clickelement_usingXpath(node, driver, menu);
		node.log(Status.INFO, "SUB-STEP_0.003 : clicked on the menu");
		System.out.println("SUB-STEP_0.003 : clicked on the menu");
	}

	public static void validateUrl(ExtentTest node, WebDriver driver, String actualUrl, String expectedUrl,
			String testCaseName) throws InterruptedException {
		if (actualUrl.equalsIgnoreCase(expectedUrl)) {
			System.out.println("SUB-STEP_0.001 : Url is same " + IElementActions.getCurrentUrl(node, driver));
			node.log(Status.INFO, "SUB-STEP_0.001 :  Url end same " + IElementActions.getCurrentUrl(node, driver));
			Assert.assertTrue(true, "Url is same " + actualUrl);
			// Take screenshot
			IScreenAction.captureScreenShot_PassCase(testCaseName, "Pass", driver);
		} else {
			System.out.println("SUB-STEP_0.001 : Url is not same " + IElementActions.getCurrentUrl(node, driver));
			node.log(Status.INFO, "SUB-STEP_0.001 : Url is not same " + IElementActions.getCurrentUrl(node, driver));
			Assert.assertTrue(false, "Url is not same " + actualUrl);
			// Take screenshot
			IScreenAction.captureScreenShot_PassCase(testCaseName, "Fail", driver);
		}
	}

	public static void validateDataSorting(ExtentTest node, WebDriver driver, String elements, String sortingOrder,
			String testCaseName) throws InterruptedException {
		// Extract elements and store them in a list
		List<String> originalData = Utils.extractTextFromElements(elements);

		for (String element : originalData) {
			System.out.println(element);
		}

		// Create a copy of the original list and sort it in descending order
		List<String> sortedData = new ArrayList<>(originalData);
		if (sortingOrder.equalsIgnoreCase("descending")) {
			// Sort the data list in descending order
			Collections.sort(sortedData, Collections.reverseOrder());
		} else {
			// Sort the data list in ascending order
			Collections.sort(sortedData);
		}

		for (String element : sortedData) {
			System.out.println(element);
		}

		for (String element : originalData) {
			System.out.println(element);
		}

		// Compare the original list with the sorted list
		if (originalData.equals(sortedData)) {
			System.out.println("SUB-STEP_0.001 : Data is sorted");
			node.log(Status.PASS, "SUB-STEP_0.001 : Data is sorted");
			Assert.assertTrue(true, "Data is sorted");
			// Take screenshot
			IScreenAction.captureScreenShot_PassCase(testCaseName, "Pass", driver);
		} else {
			System.out.println("SUB-STEP_0.001 : Data is not sorted");
			node.log(Status.FAIL, "SUB-STEP_0.001 : Data is not sorted");
			Assert.assertTrue(false, "Data is not sorted");
			// Take screenshot
			IScreenAction.captureScreenShot_PassCase(testCaseName, "Fail", driver);
		}
	}

	public static boolean isSortedDescending(String elements) throws InterruptedException {

		// Extract elements and store them in a list
		List<String> originalData = Utils.extractTextFromElements(elements);

		// Preprocess original data
		List<String> processedData = new ArrayList<>();
		for (String element : originalData) {
			// Remove currency symbol and commas, then add to processed data list
			String processedElement = element.replaceAll("[£,]", "");
			if (processedElement.equalsIgnoreCase("-")) {
				processedElement = "0";
			}
			processedData.add(processedElement);
		}

		// Iterate through the list
		for (int i = 0; i < processedData.size() - 1; i++) {
			// If any element is smaller than the next one, the list is not sorted in
			// descending order
			if (Integer.parseInt(processedData.get(i)) < Integer.parseInt(processedData.get(i + 1))) {
				return false;
			}
		}
		// If the loop completes without finding any out-of-order elements, the list is
		// sorted in descending order
		return true;
	}

	public static void validateDescendingOrder(ExtentTest node, WebDriver driver, String elementName,
			String sortIconLocator, String listLocator, String testcaseName) throws InterruptedException {

		// Click twice
		Utils.clickTwice(sortIconLocator, elementName);

		// Check the descending order
		Boolean isSortedInDescendingOrder = Utils.isSortedDescending(listLocator);

		if (isSortedInDescendingOrder) {
			System.out.println("SUB-STEP_0.001 : Data is sorted in descending order");
			node.log(Status.PASS, "SUB-STEP_0.001 : Data is sorted in descending order");
			Assert.assertTrue(true, "Data is sorted in descending order");
			// Take screenshot
			IScreenAction.captureScreenShot_PassCase("testcaseName", "Pass", driver);
		} else {
			System.out.println("SUB-STEP_0.001 : Data is not sorted in descending order");
			node.log(Status.FAIL, "SUB-STEP_0.001 : Data is not sorted in descending order");
			Assert.assertTrue(false, "Data is not sorted in descending order");

			// Take Screenshot
			IScreenAction.captureScreenShot_PassCase("testcaseName", "Pass", driver);
		}

	}

	public static void validateDataSortingOrder(ExtentTest node, WebDriver driver, String elements, String testCaseName,
			String dataType) throws InterruptedException {
		// Identify the elements column element using XPath
		List<WebElement> dateElements = IElementActions.returnElements(node, driver, elements);

		// Extract elements and store them in a list
		List<String> originalData = new ArrayList<>();
		for (WebElement dateElement : dateElements) {
			originalData.add(dateElement.getText());
		}

		boolean isAscending = true;
		boolean isDescending = true;

		List<Integer> ascendingMismatchIndices = new ArrayList<>();
		List<Integer> descendingMismatchIndices = new ArrayList<>();

		// Switch statement for string input
		switch (dataType) {
		case "stringValue":
			// Check if the data is sorted in ascending order
			for (int i = 0; i < originalData.size() - 1; i++) {
				if (originalData.get(i).toLowerCase().compareTo(originalData.get(i + 1).toLowerCase()) > 0) {
					isAscending = false;
					ascendingMismatchIndices.add(i);
				}
			}
			// Check if the data is sorted in descending order
			for (int i = 0; i < originalData.size() - 1; i++) {
				if (originalData.get(i).toLowerCase().compareTo(originalData.get(i + 1).toLowerCase()) < 0) {
					isDescending = false;
					descendingMismatchIndices.add(i);
				}
			}
			break;
		case "intValue":
			// Check if the data is sorted in ascending order
			for (int i = 0; i < originalData.size() - 1; i++) {
				if (compareCurrency(originalData.get(i), originalData.get(i + 1)) > 0) {
					isAscending = false;
					ascendingMismatchIndices.add(i);
				}
			}
			// Check if the data is sorted in descending order
			for (int i = 0; i < originalData.size() - 1; i++) {
				if (compareCurrency(originalData.get(i), originalData.get(i + 1)) < 0) {
					isDescending = false;
					descendingMismatchIndices.add(i);
				}
			}
			break;
		}

		// Determine if the data is sorted and log accordingly
		if (isAscending) {
			System.out.println("SUB-STEP_0.001 : Data is sorted in ascending order");
			node.log(Status.PASS, "SUB-STEP_0.001 : Data is sorted in ascending order");
			Assert.assertTrue(true, "Data is sorted in ascending order");
			// Take screenshot
			IScreenAction.captureScreenShot_PassCase(testCaseName, "Pass", driver);
		} else if (isDescending) {
			System.out.println("SUB-STEP_0.001 : Data is sorted in descending order");
			node.log(Status.PASS, "SUB-STEP_0.001 : Data is sorted in descending order");
			Assert.assertTrue(true, "Data is sorted in descending order");
			// Take screenshot
			IScreenAction.captureScreenShot_PassCase(testCaseName, "Pass", driver);
		} else {
			System.out.println("SUB-STEP_0.001 : Data is not sorted");
			node.log(Status.FAIL, "SUB-STEP_0.001 : Data is not sorted");
			System.out.println("Mismatching elements in ascending order:");
			for (int index : ascendingMismatchIndices) {
				System.out.println(originalData.get(index) + " > " + originalData.get(index + 1));
			}
			System.out.println("Mismatching elements in descending order:");
			for (int index : descendingMismatchIndices) {
				System.out.println(originalData.get(index) + " < " + originalData.get(index + 1));
			}
			Assert.assertTrue(false, "Data is not sorted");
			// Take screenshot
			IScreenAction.captureScreenShot_PassCase(testCaseName, "Fail", driver);
		}
	}

	public static void validateDataSortingBothOrder(String sortIcon, String elementName, String columnValues,
			String testcaseName, String dataType) throws InterruptedException {
		// Clicked on the sort icon
		IElementActions.clickelement_usingXpath(node, driver, sortIcon);
		node.log(Status.INFO, "STEP1 : Clicked on sort icon of " + elementName);
		System.out.println("STEP1 : Clicked on sort icon of " + elementName);

		// Validate values are sorted in ascending Oreder
		Utils.validateDataSortingOrder(node, driver, columnValues, "testcaseName", dataType);

		// Clicked on the sort icon
		IElementActions.clickelement_usingXpath(node, driver, sortIcon);
		node.log(Status.INFO, "STEP1 : Clicked on sort icon of " + elementName);
		System.out.println("STEP1 : Clicked on sort icon of " + elementName);

		// Validate values are sorted in dscending Oreder
		Utils.validateDataSortingOrder(node, driver, columnValues, "testcaseName", dataType);
	}

	// Helper method to compare currency values
	private static int compareCurrency(String currency1, String currency2) {
		double value1 = extractNumericValue(currency1);
		double value2 = extractNumericValue(currency2);
		return Double.compare(value1, value2);
	}

	// Helper method to extract numeric value from currency string
	public static double extractNumericValue(String currency) {
		try {
			// Remove non-numeric characters except periods and percentage signs
			String numericString = currency.replaceAll("[^0-9.%]", "");
			// Remove percentage sign
			numericString = numericString.replaceAll("%", "");
			NumberFormat format = NumberFormat.getNumberInstance(Locale.US);
			Number number = format.parse(numericString);
			return number.doubleValue();
		} catch (ParseException e) {
			// Handle parse exception
			e.printStackTrace();
			return Double.MAX_VALUE; // Return a large value in case of error
		}
	}

	// Method to extract numeric value from a string (removing currency symbols and
	// commas)
	public static double extractNumeric(String text) {
		// Remove currency symbol and commas
		String cleanedText = text.replaceAll("[^\\d.]", "");

		// Parse the string to double
		try {
			return NumberFormat.getNumberInstance(Locale.getDefault()).parse(cleanedText).doubleValue();
		} catch (ParseException e) {
			e.printStackTrace();
			return 0; // Return 0 if parsing fails
		}
	}

	public static void validateDateSorting(ExtentTest node, WebDriver driver, String elements, String sortingOrder,
			String testCaseName, String dateFormatter, String dateType) throws InterruptedException {
		// Identify the elements column element using XPath (adjust the locator based on
		// your HTML structure)
		List<WebElement> dateElements = IElementActions.returnElements(node, driver, elements);
		// Extract elements and store them in a list
		List<String> originalData = new ArrayList<>();
		for (WebElement dateElement : dateElements) {
			originalData.add(dateElement.getText());
		}
		// Create a copy of the original list and sort it
		List<String> sortedData = new ArrayList<>(originalData);
		// Define the date formatter
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatter);
		// Define a custom comparator for sorting
		Comparator<String> dateComparator;
		switch (dateType) {
		case "LocalDate":
			dateComparator = (s1, s2) -> {
				LocalDate date1 = LocalDate.parse(s1, formatter);
				LocalDate date2 = LocalDate.parse(s2, formatter);
				return sortingOrder.equalsIgnoreCase("descending") ? date2.compareTo(date1) : date1.compareTo(date2);
			};
			break;
		case "LocalDateTime":
			dateComparator = (s1, s2) -> {
				LocalDateTime date1 = LocalDateTime.parse(s1, formatter);
				LocalDateTime date2 = LocalDateTime.parse(s2, formatter);
				return sortingOrder.equalsIgnoreCase("descending") ? date2.compareTo(date1) : date1.compareTo(date2);
			};
			break;
		default:
			throw new IllegalArgumentException("Invalid dateType: " + dateType);
		}
		// Sort the data list using the custom comparator
		Collections.sort(sortedData, dateComparator);
		// Compare the original list with the sorted list
		if (originalData.equals(sortedData)) {
			System.out.println("SUB-STEP_0.001 : Data is sorted");
			node.log(Status.PASS, "SUB-STEP_0.001 : Data is sorted");
			Assert.assertTrue(true, "Data is sorted");
			// Take screenshot
			IScreenAction.captureScreenShot_PassCase(testCaseName, "Pass", driver);
		} else {
			System.out.println("SUB-STEP_0.001 : Data is not sorted");
			node.log(Status.FAIL, "SUB-STEP_0.001 : Data is not sorted");
			Assert.assertTrue(false, "Data is not sorted");
			// Take screenshot
			IScreenAction.captureScreenShot_PassCase(testCaseName, "Fail", driver);
		}
	}

	public static String getTomorrowDateFormatted() throws InterruptedException {
		// Get the current date
		LocalDate currentDate = LocalDate.now();
		// Add one day to the current date to get tomorrow's date
		LocalDate tomorrowDate = currentDate.plusDays(1);
		// Create a DateTimeFormatter object with the desired format
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
		// Use the format method to get the formatted date as a string
		String formattedDate = tomorrowDate.format(dateFormatter);
		return formattedDate;
	}

	public static String getTodayDate() {
		// Get the current date
		LocalDate currentDate = LocalDate.now();
		// Create a DateTimeFormatter object with the desired format
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/yyyy");
		// Use the format method to get the formatted date as a string
		String formattedDate = currentDate.format(dateFormatter);
		return formattedDate;
	}

	public static String getTomorrowDate() {
		// Get the current date
		LocalDate currentDate = LocalDate.now();
		// Add one day to the current date to get tomorrow's date
		LocalDate tomorrowDate = currentDate.plusDays(1);
		// Create a DateTimeFormatter object with the desired format
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/yyyy");
		// Use the format method to get the formatted date as a string
		String formattedDate = tomorrowDate.format(dateFormatter);
		return formattedDate;
	}

	public static String getTomorrowDayFormatted() {
		// Get tomorrow's date
		LocalDate tomorrowDate = LocalDate.now().plusDays(1);
		// Create a DateTimeFormatter object with the desired format
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d");
		// Use the format method to get the formatted date as a string
		String formattedDate = tomorrowDate.format(dateFormatter);
		node.log(Status.INFO, "SUB-STEP_0.001 : Tomorrow day is " + formattedDate);
		System.out.println("SUB-STEP_0.001 : Tomorrow day is " + formattedDate);
		return formattedDate;
	}

	public static String getTodayDayFormatted() {
		// Get today's date
		LocalDate todayDate = LocalDate.now();
		// Create a DateTimeFormatter object with the desired format
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d");
		// Use the format method to get the formatted date as a string
		String formattedDate = todayDate.format(dateFormatter);
		node.log(Status.INFO, "SUB-STEP_0.001 : Today day is " + formattedDate);
		System.out.println("SUB-STEP_0.001 : Today day is " + formattedDate);
		return formattedDate;
	}

	public static String getYesterdayDayFormatted() {
		// Get yesterday's date
		LocalDate yesterdayDate = LocalDate.now().minusDays(1);
		// Create a DateTimeFormatter object with the desired format
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d");
		// Use the format method to get the formatted date as a string
		String formattedDate = yesterdayDate.format(dateFormatter);
		System.out.println("Yesterday day is " + formattedDate);
		return formattedDate;
	}

	public static String getYesterdayDateFormatted() {
		// Get the current date
		LocalDate currentDate = LocalDate.now();
		// Subtract one day from the current date to get yesterday's date
		LocalDate yesterdayDate = currentDate.minusDays(1);
		// Create a DateTimeFormatter object with the desired format
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy");
		// Use the format method to get the formatted date as a string
		String formattedDate = yesterdayDate.format(dateFormatter);
		return formattedDate;
	}

	public static String getTodayDateFormatted() {
		// Get the current date
		LocalDate currentDate = LocalDate.now();
		// Create a DateTimeFormatter object with the desired format
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// Use the format method to get the formatted date as a string
		String formattedDate = currentDate.format(dateFormatter);
		return formattedDate;
	}

	public static String getTodayDateFormattedInDash() {
		// Get the current date
		LocalDate currentDate = LocalDate.now();
		// Create a DateTimeFormatter object with the desired format
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		// Use the format method to get the formatted date as a string
		String formattedDate = currentDate.format(dateFormatter);
		return formattedDate;
	}

	public static String getYesterdayDate() {
		// Get the current date
		LocalDate currentDate = LocalDate.now();
		// Subtract one day from the current date to get yesterday's date
		LocalDate yesterdayDate = currentDate.minusDays(1);
		// Create a DateTimeFormatter object with the desired format
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// Use the format method to get the formatted date as a string
		String formattedDate = yesterdayDate.format(dateFormatter);
		return formattedDate;
	}

	public static String getCurrectYear() {
		// Get current year
		LocalDate currentDate = LocalDate.now();
		// Create a DateTimeFormatter object with the desired format for year
		DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yyyy");
		// Use the format method to get the formatted year as a string
		String formattedYear = currentDate.format(yearFormatter);
		// Log the formatted year
		System.out.println("Current year is: " + formattedYear);
		return formattedYear;
	}

	public static String getCurrentMonth() {
		// Get current month
		LocalDate currentDate = LocalDate.now();
		// Create a DateTimeFormatter object with the desired format for month
		DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("M");
		// Use the format method to get the formatted month as a string
		String formattedMonth = currentDate.format(monthFormatter);
		// Convert the formatted month string to an integer
		// int numericMonth = Integer.parseInt(formattedMonth);
		// Log the formatted month
		System.out.println("Current month is: " + formattedMonth);
		return formattedMonth;
	}

	public static String getCurrentMonthName() {
		// Get current month
		LocalDate currentDate = LocalDate.now();
		// Create a DateTimeFormatter object with the desired format for month name
		DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM");
		// Use the format method to get the formatted month name as a string
		String formattedMonth = currentDate.format(monthFormatter);
		// Log the formatted month name
		System.out.println("Current month is: " + formattedMonth);
		return formattedMonth;
	}

	public static String getNextMonth() {
		// Get current date and add one month to it
		LocalDate nextMonthDate = LocalDate.now().plusMonths(1);
		// Create a DateTimeFormatter object with the desired format for month
		DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("M");
		// Use the format method to get the formatted month as a string
		String formattedMonth = nextMonthDate.format(monthFormatter);
		// Log the formatted month
		System.out.println("Next month is: " + formattedMonth);
		return formattedMonth;
	}

	public static String convertDateFormat(String inputDate) {
		// Define the input date format
		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy", Locale.ENGLISH);
		// Parse the input date string
		LocalDate localDate = LocalDate.parse(inputDate, inputFormatter);
		// Define the desired output format
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// Format the date to the desired output format
		String formattedDate = localDate.format(outputFormatter);
		return formattedDate;
	}

	public static String convertDashDateToSlash(String inputDate) throws ParseException {
		// Specify the original date format
		SimpleDateFormat originalDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		// Specify the desired date format
		SimpleDateFormat desiredDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		// Parse the original date string
		Date originalDate = originalDateFormat.parse(inputDate);
		// Format the date in the desired format
		String desiredDateString = desiredDateFormat.format(originalDate);
		return desiredDateString;
	}

	public static String convertSlashDateToDashAndReverse(String inputDate) throws ParseException {
		// Specify the original date format
		SimpleDateFormat originalDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		// Specify the desired date format
		SimpleDateFormat desiredDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// Parse the original date string
		Date originalDate = originalDateFormat.parse(inputDate);
		// Format the date in the desired format
		String desiredDateString = desiredDateFormat.format(originalDate);
		return desiredDateString;
	}

	public static void validatePagination(ExtentTest node, WebDriver driver, int pagination, String testCaseName)
			throws InterruptedException {
		int currentPageNumber = 1;
		IWaitStrategy.WaitForPageLoadingToComplete(node, driver);
		Thread.sleep(3000);
		// Wait for the table rows to be present
		node.log(Status.INFO,
				"SUB-STEP_0.001 : Waiting for the visibility of the table rows in " + currentPageNumber + " page");
		System.out.println(
				"SUB-STEP_0.001 : Waiting for the visibility of the table rows " + currentPageNumber + " page");
		IWaitStrategy.waitForPresence(node, driver, ReportingUpdatesPO.tableRows);
		node.log(Status.INFO, "SUB-STEP_0.002 : Table rows are visible in page " + currentPageNumber);
		System.out.println("SUB-STEP_0.002 : Table rows are visible in page " + currentPageNumber);
		// Scroll down to the bottom of the page and select the pagination
		Utils.scrollDownAndSelectPagination(node, driver, pagination);
		// Validate the number of records in the current page
		boolean success = Utils.validateNumberOfRecords(node, driver, ReportingUpdatesPO.tableRows, pagination,
				currentPageNumber);
		// Check for pagination and navigate to the next page
		while (!(IElementActions.checkAttributePresentInClass(ReportingUpdatesPO.nextButton, "ui-state-disabled"))
				&& success) {
			// Click on the next page button
			IElementActions.clickelement_usingXpath(node, driver, ReportingUpdatesPO.nextButton);
			node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on the next page button");
			System.out.println("SUB-STEP_0.001 : Clicked on the next page button");
			currentPageNumber++;
			// Validate the number of records in the current page
			success = Utils.validateNumberOfRecords(node, driver, ReportingUpdatesPO.tableRows, pagination,
					currentPageNumber);
		}
		// Print the final result based on the success variable
		if (success) {
			System.out.println("SUB-STEP_0.001 : Validation successful");
			node.log(Status.INFO, "SUB-STEP_0.001 : Validation successful");
			Assert.assertTrue(true, "Recordes are present on the page as per selected pagination");
			// Take screenshot
			IScreenAction.captureScreenShot_PassCase(testCaseName, "Pass", driver);
		} else {
			System.out.println("SUB-STEP_0.001 : Validation failed: More than " + pagination + " records on the page.");
			node.log(Status.INFO,
					"SUB-STEP_0.001 : Validation failed: More than " + pagination + " records on the page.");
			Assert.assertTrue(false, "Validation failed: More than " + pagination + " records on the page.");
			// Take screenshot
			IScreenAction.captureScreenShot_PassCase(testCaseName, "Fail", driver);
		}
	}

	public static void scrollDownAndSelectPagination(ExtentTest node, WebDriver driver, int pagination)
			throws InterruptedException {
		String paginationNumber = String.valueOf(pagination);
		Thread.sleep(2000);
		IElementActions.scrollToBottom(driver);
		Thread.sleep(2000);
		// Wait for the visibility of the pagination dropdown
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the pagination dropdown");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the pagination dropdown");
		IWaitStrategy.waitForVisiblity(node, driver, ReportingUpdatesPO.paginationDropdown);
		IWaitStrategy.waitForVisiblityAndPresence(node, driver, ReportingUpdatesPO.paginationDropdown);
		node.log(Status.INFO, "SUB-STEP_0.002 : Pagination dropdown is visible");
		System.out.println("SUB-STEP_0.002 : Pagination dropdown is visible");
		// Click on the pagination dropdown
		IElementActions.clickelement_usingXpath(node, driver, ReportingUpdatesPO.paginationDropdown);
		node.log(Status.INFO, "SUB-STEP_0.003 : Clicked on the pagination dropdown");
		System.out.println("SUB-STEP_0.003 : Clicked on the pagination dropdown");
		Thread.sleep(5000);
		// Get pagination number selector dynamically
		String paginationNumberLocator = IElementActions.createDynamicLocatorString(
				ReportingUpdatesPO.paginationDropdownListing, "locatorValue", paginationNumber);
		Thread.sleep(5000);
		// Wait for the visibility of the pagination number
		node.log(Status.INFO, "SUB-STEP_0.004 : Waiting for the visibility of the pagination number");
		System.out.println("SUB-STEP_0.004 : Waiting for the visibility of the pagination number");
		IWaitStrategy.waitForVisiblityAndPresence(node, driver, paginationNumberLocator);
		node.log(Status.INFO, "SUB-STEP_0.005 : Pagination number is visible");
		System.out.println("SUB-STEP_0.005 : Pagination number is visible");
		// Click on the pagination number
		IElementActions.clickelement_usingXpath(node, driver, paginationNumberLocator);
		node.log(Status.INFO, "SUB-STEP_0.006 : Clicked on the pagination number");
		System.out.println("SUB-STEP_0.006 : Clicked on the pagination number");
	}

	public static boolean validateNumberOfRecords(ExtentTest node, WebDriver driver, String tableRowLocator,
			int paginationNumber, int currentPageNumber) {
		// Wait for the table rows to be present
		node.log(Status.INFO,
				"SUB-STEP_0.001 : Waiting for the visibility of the table rows in " + currentPageNumber + " page");
		System.out.println(
				"SUB-STEP_0.001 : Waiting for the visibility of the table rows " + currentPageNumber + " page");
		IWaitStrategy.waitForPresence(node, driver, tableRowLocator);
		node.log(Status.INFO, "SUB-STEP_0.002 : Table rows are visible in page " + currentPageNumber);
		System.out.println("SUB-STEP_0.002 : Table rows are visible in page " + currentPageNumber);
		// Find the table rows on the current page
		int numberOfRecords = IElementActions.isElementPresentByGetCheckingSize_usingXpath(node, driver,
				ReportingUpdatesPO.tableRows);
		node.log(Status.INFO, "SUB-STEP_0.003 : Number of records " + numberOfRecords);
		System.out.println("SUB-STEP_0.003 : Number of records " + numberOfRecords);
		// Validate the number of records (Assuming 50 for pagination)
		if (numberOfRecords > paginationNumber) {
			System.out.println(
					"SUB-STEP_0.001 : Validation failed: More than " + paginationNumber + " records on the page.");
			node.log(Status.INFO,
					"SUB-STEP_0.001 : Validation failed: More than " + paginationNumber + " records on the page.");
			return false;
		} else {
			System.out.println("SUB-STEP_0.001 : Validation successful: " + numberOfRecords + " records on the page.");
			node.log(Status.INFO,
					"SUB-STEP_0.001 : Validation successful: " + numberOfRecords + " records on the page.");
			return true;
		}
	}

	public static void refreshPagenTill(ExtentTest node, WebDriver driver, int maxDurationInMinutes,
			int refreshAtEveryMin, String xRecordDoneStatus, String xRecordInProgressStatus, String xRecordErrorStatus)
			throws InterruptedException {
		// Set the interval for refreshing (in milliseconds)
		long refreshIntervalInMillis = refreshAtEveryMin * 60 * 1000; // 2 minutes
		// Set the timeout for the loop (in milliseconds)
		long maxDurationInMillis = maxDurationInMinutes * 60 * 1000;
		// Set the start time
		long startTime = System.currentTimeMillis();
		// Start a loop to refresh the page and check the status
		while ((System.currentTimeMillis() - startTime) < maxDurationInMillis) {
			// Refresh the page
			driver.navigate().refresh();
			// Wait for the visibility of Calculate Interest page
			node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the current page");
			System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the current page");
			IWaitStrategy.waitForVisiblity(node, driver, UtilsPO.runScriptButton);
			IWaitStrategy.WaitUntilElementClickable(node, driver, UtilsPO.runScriptButton);
			node.log(Status.INFO, "SUB-STEP_0.002 : Current page is visible");
			System.out.println("SUB-STEP_0.002 : Current page is visible");
			String actualStatus = Utils.checkStatus(xRecordDoneStatus, xRecordInProgressStatus, xRecordErrorStatus);
			Thread.sleep(2000);
			// Check if the status is updated
			if (actualStatus.equals("DONE_SUCCESS") || actualStatus.equals("ERROR")) {
				System.out.println("SUB-STEP_0.001 : Status is updated successfully");
				node.log(Status.INFO, "SUB-STEP_0.001 : Status is updated successfully");
				break;
			} else {
				System.out.println("SUB-STEP_0.001 : Status is not updated");
				node.log(Status.INFO, "SUB-STEP_0.001 : Status is not updated");
				// Wait before the next refresh
				try {
					Thread.sleep(refreshIntervalInMillis);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void clickOnRunScriptButton() {
		// Wait for the visibility of the error
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the page");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the page");
		IWaitStrategy.waitForVisiblity(node, driver, UtilsPO.runScriptButton);
		node.log(Status.INFO, "SUB-STEP_0.002 : Page is visible");
		System.out.println("SUB-STEP_0.002 : Page is visible");
		// Click on the RunScript
		IElementActions.clickelement_usingXpath(node, driver, UtilsPO.runScriptButton);
		node.log(Status.INFO, "SUB-STEP_0.003 : Clicked on the RunScript");
		System.out.println("SUB-STEP_0.003 : Clicked on the RunScript");
	}

	public static long getNumberOfDaysBetweenTwoDates(String expectedStartDate, String expectedEndDate) {
		// Assuming date1 and date2 are in the format 'dd/MM/yyyy'
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date1 = LocalDate.parse(expectedStartDate, formatter);
		LocalDate date2 = LocalDate.parse(expectedEndDate, formatter);
		long daysDifference = ChronoUnit.DAYS.between(date1, date2);
		return daysDifference;
	}

	// Reusable function for subtraction
	public static int calculateDifference(int a, int b) {
		return a - b;
	}

	// Reusable function for subtraction
	public static double calculateDifference(double a, double b) {
		return a - b;
	}

	// Reusable function for addition
	public static int calculateAddition(int a, int b) {
		return a + b;
	}

	// Reusable function for addition
	public static double calculateAddition(double a, double b) {
		return a + b;
	}

	// Reusable method to remove currency symbols from a string and parse to int
	public static int removeCurrencyAndParseToInt(String text) {
		// Replace currency symbols and commas with an empty string
		String formattedText = text.replaceAll("[£$€,]", "");
		int value = Integer.parseInt(formattedText);
		node.log(Status.INFO, "SUB-STEP_0.001 : Field value is " + value);
		System.out.println("SUB-STEP_0.001 :Field value is " + value);
		return value;
	}

	public static int getTextAndParseToInt(String locator) {
		String text = IElementActions.getElementText_usingXpath(node, driver, locator);
		// Replace currency symbols and commas with an empty string
		String formattedText = text.replaceAll("[£$€,%]", "");
		int value = Integer.parseInt(formattedText);
		return value;
	}

	public static String getFormattedText(String locator) {
		String text = IElementActions.getElementText_usingXpath(node, driver, locator);
		// Replace currency symbols and commas with an empty string
		String formattedText = text.replaceAll("[£$€,%-]", "");
		return formattedText;
	}

	public static String getFormattedTextWithSign(String locator) {
		String text = IElementActions.getElementText_usingXpath(node, driver, locator);
		// Replace currency symbols and commas with an empty string
		String formattedText = text.replaceAll("[£$€,]", "");
		return formattedText;
	}

	public static String formatText(String text) {
		// Replace currency symbols and commas with an empty string
		String formatted = text.replaceAll("[£$€,%-]", "");
		String formattedText = formatted.trim();
		return formattedText.trim();
	}

	public static double getTextAndParseToDouble(String locator) {
		String text = IElementActions.getElementText_usingXpath(node, driver, locator);
		// Replace currency symbols and commas with an empty string
		String formattedText = text.replaceAll("[£$€,%]", "");
		Double value = Double.parseDouble(formattedText);
		return value;
	}

	public static long getTextAndParseToLong(String locator) {
		String text = IElementActions.getElementText_usingXpath(node, driver, locator);
		// Replace currency symbols and commas with an empty string
		String formattedText = text.replaceAll("[£$€,%]", "");
		long value = Long.parseLong(formattedText);
		return value;
	}

	public static double getPercentageTextAndParseToDouble(String locator) {
		String text = IElementActions.getElementText_usingXpath(node, driver, locator);
		// Replace currency symbols and commas with an empty string
		String formattedText = text.replaceAll("[£$€,%]", "");
		Double value = Double.parseDouble(formattedText);
		value = value / 100;
		return value;
	}

	public static int parseCurrencyValue(String value) {
		// Remove currency sign and commas, then parse the integer value
		try {
			NumberFormat format = NumberFormat.getInstance(Locale.UK); // Use Locale.UK for British Pound symbol
			Number number = format.parse(value.replaceAll("[^\\d.-]", "")); // Allow for negative values
			return number.intValue();
		} catch (ParseException e) {
			throw new RuntimeException("Error parsing currency value", e);
		}
	}

	public static double parseCurrencyValueToDouble(String value) {
		// Remove currency sign and commas, then parse the integer value
		try {
			NumberFormat format = NumberFormat.getInstance(Locale.UK); // Use Locale.UK for British Pound symbol
			Number number = format.parse(value.replaceAll("[^\\d.-]", "")); // Allow for negative values
			return number.doubleValue();
		} catch (ParseException e) {
			throw new RuntimeException("Error parsing currency value", e);
		}
	}

	public static double getValueAfterCurrencyInDouble(String value) {
		// Get the Cash Amount
		String text = IElementActions.getElementText_usingXpath(node, driver, value);

		// Define a regular expression pattern to match the currency symbol and digits
		Pattern pattern = Pattern.compile("£([\\d,]+)");
		Matcher matcher = pattern.matcher(text);
		String formattedValue = null;
		// Check if the pattern is found
		if (matcher.find()) {
			// Extract the matched group (value after currency symbol)
			formattedValue = matcher.group(1);
			System.out.println("Value after currency onwards: " + formattedValue);
		} else {
			System.out.println("Currency value not found in the text.");
		}

		return parseCurrencyValueToDouble(formattedValue);

	}

	public static double getHighestValueFromList(String locator) {
		// Extract text using the reusable method
		List<String> values = Utils.extractTextFromElements(locator);

		// Extract numerical values from text and store them in a list
		List<Double> numericalValues = new ArrayList<>();
		for (String element : values) {
			// Remove '%' sign and convert text to double
			double value = Double.parseDouble(element.replaceAll("%", ""));
			numericalValues.add(value);
		}

		// Sort the list of numerical values
		Collections.sort(numericalValues);

		// Retrieve the highest value
		double highestValue = numericalValues.get(numericalValues.size() - 1);
		return highestValue;
	}

	public static List<String> getTop5ValuesAsStringFromList(String locator) {
		// Extract text using the reusable method
		List<String> values = Utils.extractTextFromElements(locator);

		// Extract numerical values from text and store them in a list
		List<Double> numericalValues = new ArrayList<>();
		for (String element : values) {
			// Remove '%' sign and convert text to double
			double value = Double.parseDouble(element.replaceAll("[%,£,]", ""));
			numericalValues.add(value);
		}

		// Sort the list of numerical values in descending order
		numericalValues.sort(Collections.reverseOrder());

		// Retrieve the top 5 values
		List<String> top5Values = new ArrayList<>();
		for (int i = 0; i < Math.min(5, numericalValues.size()); i++) {
			// Convert double value to string and add to the list
			top5Values.add(Double.toString(numericalValues.get(i)));
		}

		return top5Values;
	}

	public static List<String> getStarting5Values(String elements) throws InterruptedException {

		// Wait for the elemet to be visible
		node.log(Status.INFO, "STEP51: Waiting for element to be visible");
		System.out.println("STEP1 : Waiting for element to be visible");
		IWaitStrategy.waitForVisiblity(node, driver, elements);
		node.log(Status.INFO, "STEP2 : Element is visible");
		System.out.println("STEP2 : Element is visible");

		List<String> listData = Utils.extractTextFromElements(elements);

		List<String> starting5Values = new ArrayList<>();
		for (int i = 0; i < Math.min(5, listData.size()); i++) {
			starting5Values.add(listData.get(i));
		}
		// Print each element of the ArrayList
		for (String element : starting5Values) {
			System.out.println(element);
			node.log(Status.INFO, element);
		}
		return starting5Values;
	}

	public static void openRecordUsingSearch(String clearPreviousSearch, String searchBoxLocator, String searchValue,
			String iconLocator, String pageHeader) throws InterruptedException {
		clearResultAndEnterValueInSearchBox(clearPreviousSearch, searchBoxLocator, searchValue);

		// Click on the Edit Icon
		IElementActions.clickelement_usingXpath(node, driver, iconLocator);
		node.log(Status.INFO, "STEP_0.001 : clicked on the Edit Icon");
		System.out.println("STEP_0.001 : clicked on the Edit Icon");

		// Wait for the visibility of page
		node.log(Status.INFO, "STEP_0.002 : Waiting for the visibility of page");
		System.out.println("STEP_0.002 : Waiting for the visibility of page");
		IWaitStrategy.waitForVisiblity(node, driver, pageHeader);
		node.log(Status.INFO, "STEP_0.003 : page is visible");
		System.out.println("STEP_0.003 : page is visible");
	}

	public static void enterSearchTextAndValidate(String clearPreviousSearch, String searchBoxLocator,
			String searchValue, String firstRowElement) throws InterruptedException {
		clearResultAndEnterValueInSearchBox(clearPreviousSearch, searchBoxLocator, searchValue);

		// Get element value
		String elementValue = IElementActions.getElementValue(node, driver, searchBoxLocator);
		node.log(Status.INFO, "STEP_0.001 : Value on the Search Field is " + elementValue);
		System.out.println("STEP_0.001 : Value on the Search Field is " + elementValue);

		IElementActions.assertEquals_usingString(node, driver, searchValue, elementValue,
				"BUG: Entered search value " + searchValue + " and search box value " + elementValue + " is not same",
				"PASS: Entered search value " + searchValue + " and search box value " + elementValue + " is same");

		String firstRowElementValue = IElementActions.getElementText_usingXpath(node, driver, firstRowElement);

		// Assert search value
		if (firstRowElementValue.toLowerCase().contains(elementValue.toLowerCase())) {
			Assert.assertTrue(true, "The searched value " + elementValue + " and the result record is the same, i.e.,"
					+ firstRowElementValue);
			System.out.println("The searched value " + elementValue + " and the result record is the same, i.e.,"
					+ firstRowElementValue);
			node.log(Status.PASS, "The searched value " + elementValue + " and the result record is the same, i.e.,"
					+ firstRowElementValue);
		} else {
			Assert.assertTrue(false, "The searched value " + elementValue
					+ " and the result record is not the same, i.e.," + firstRowElementValue);
			System.out.println("The searched value " + elementValue + " and the result record is not the same, i.e.,"
					+ firstRowElementValue);
			node.log(Status.FAIL, "The searched value " + elementValue + " and the result record is not the same, i.e.,"
					+ firstRowElementValue);
		}
	}

	public static void enterSearchTextAndValidateInBetween(String clearPreviousSearch, String searchBoxLocator1,
			String searchBoxLocator2, String searchValueMin, String searchValueMax, String firstRowElement)
			throws InterruptedException {
		clearResultAndEnterValueInSearchBox(clearPreviousSearch, searchBoxLocator1, searchValueMin);

		// Get element value
		String elementValueMin = IElementActions.getElementValue(node, driver, searchBoxLocator1);
		node.log(Status.INFO, "STEP_0.001 : Value on the Search Field is " + elementValueMin);
		System.out.println("STEP_0.001 : Value on the Search Field is " + elementValueMin);

		enterValueInSearchBox(searchBoxLocator2, searchValueMax);

		Thread.sleep(1000);
		// Get element value
		String elemenMaxValue = IElementActions.getElementValue(node, driver, searchBoxLocator2);
		node.log(Status.INFO, "STEP_0.002 : Value on the Search Field max is " + elemenMaxValue);
		System.out.println("STEP_0.002 : Value on the Search Field max is " + elemenMaxValue);

		Double minValue = Double.parseDouble(elementValueMin);
		Double maxValue = Double.parseDouble(elemenMaxValue);

		Thread.sleep(1000);
		double resultValue = Utils.getTextAndParseToDouble(firstRowElement);

		// Assert if resultValue lies between minValue and maxValue
		if (resultValue >= minValue && resultValue <= maxValue) {
			Assert.assertTrue(true, "The result value " + resultValue
					+ " and the result record is lies between the min " + minValue + " and max " + maxValue);
			System.out.println("The result value " + resultValue + " and the result record is lies between the min "
					+ minValue + " and max " + maxValue);
			node.log(Status.PASS, "The result value " + resultValue + " and the result record is lies between the min "
					+ minValue + " and max " + maxValue);
		} else {
			Assert.assertTrue(false,
					"The result value " + resultValue + " is not between " + minValue + " and " + maxValue);
			System.out.println("The result value " + resultValue + " is not between " + minValue + " and " + maxValue);
			node.log(Status.FAIL,
					"The result value " + resultValue + " is not between " + minValue + " and " + maxValue);
		}
	}

	public static void enterValueInSearchBox(String searchBoxLocator, String searchValue) throws InterruptedException {
		// Wait for the visibility of Search Field
		node.log(Status.INFO, "STEP_0.001 : Waiting for the visibility of Search Field");
		System.out.println("STEP_0.001 : Waiting for the visibility of Search Field");
		IWaitStrategy.waitForVisiblity(node, driver, searchBoxLocator);
		IWaitStrategy.WaitUntilElementClickable(node, driver, searchBoxLocator);
		node.log(Status.INFO, "STEP_0.002 : Search Field is visible");
		System.out.println("STEP_0.002 : Search Field is visible");

		Thread.sleep(1000);
		// Remove data from the Search Field
		IElementActions.clearElement_usingXpath(node, driver, searchBoxLocator);
		node.log(Status.INFO, "STEP_0.003 : Removed data from the Search Field");
		System.out.println("STEP_0.003 : Removed data from the Search Field");

		Thread.sleep(3000);
		// Enter the value in search box
		IElementActions.sendKeys_usingXpath(node, driver, searchBoxLocator, searchValue);
		node.log(Status.INFO, "STEP_0.004 : Enter on the Search Field");
		System.out.println("STEP_0.004 : Enter on the Search Field");

		Thread.sleep(2000);
		IElementActions.pressKeys_usingXpath(node, driver, searchBoxLocator, Keys.SPACE);
		Thread.sleep(1000);
		IElementActions.pressKeys_usingXpath(node, driver, searchBoxLocator, Keys.BACK_SPACE);

		// Wait for the visibility of Edit Icon
		node.log(Status.INFO, "STEP_0.005 : Waiting for the visibility of Edit Icon");
		System.out.println("STEP_0.005 : Waiting for the visibility of Edit Icon");
		IWaitStrategy.waitForVisiblity(node, driver, UtilsPO.editIcon);
		node.log(Status.INFO, "STEP_0.006 : Edit Icon is visible");
		System.out.println("STEP_0.006 : Edit Icon is visible");
	}

	public static void clearResultAndEnterValueInSearchBox(String clearPreviousSearch, String searchBoxLocator,
			String searchValue) throws InterruptedException {
		// Create an instance of JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Execute JavaScript to scroll horizontally to the end of the left
		js.executeScript("window.scrollTo(0, 0);");

		// Check cross icon is available or not
		boolean checkCrossIcon = IElementActions.isElementAvailable(node, driver, clearPreviousSearch);

		// If cross icon is present, click on it to clear the search
		if (checkCrossIcon) {
			// Click on the cross icon to clear the search
			IElementActions.clickelement_usingXpath(node, driver, clearPreviousSearch);
			node.log(Status.INFO, "STEP_0.001 : clicked on the cross icon");
			System.out.println("STEP_0.001 : clicked on the cross icon");
		}
		enterValueInSearchBox(searchBoxLocator, searchValue);
	}

	public static void selectValueInDropdown(String dropdown, String dropdownOption) throws InterruptedException {
		// Check cross icon available or not
		boolean checkCrossIcon = IElementActions.isElementAvailable(node, driver, UtilsPO.headerSearchCrossIcon);

		// If cross icon is present, click on it to clear the search
		if (checkCrossIcon) {
			// Click on the cross icon to clear the search
			IElementActions.clickelement_usingXpath(node, driver, UtilsPO.headerSearchCrossIcon);
			node.log(Status.INFO, "STEP_0.001 : clicked on the cross icon");
			System.out.println("STEP_0.001 : clicked on the cross icon");
		}

		Thread.sleep(1000);
		// click on the dropdown and select option
		LoansPage.clickDropdownAndItsOption(dropdown, dropdownOption);
	}

	public static void selectValueInDropdownAndValidateResult(String dropdown, String dropdownOptionValue,
			String resultElements) throws InterruptedException {

		// Create locator based on the provided status
		String dropdownOption = IElementActions.createDynamicLocatorString(FundingDatabasePO.dropdownOption, "locator",
				dropdownOptionValue);

		// Clear result and select value from dropdown
		Utils.selectValueInDropdown(dropdown, dropdownOption);

		// Wait for the visibility of status elements
		node.log(Status.INFO, "STEP_0.001 : Waiting for the visibility of status elements");
		System.out.println("STEP_0.001 : Waiting for the visibility of status elements");
		IWaitStrategy.waitForVisiblity(node, driver, resultElements);
		node.log(Status.INFO, "STEP_0.002 : Status elements is visible");
		System.out.println("STEP_0.003 : Status elements is visible");

		// Wait for the listing to populateif necessary
		Thread.sleep(2000);
		// Find all elements representing the status column in the filtered result
		// listing
		List<WebElement> statusElements = IElementActions.returnElements(node, driver, resultElements);

		// Counter for incorrect statuses
		int incorrectCount = 0;
		String count = null;

		// Iterate over the status elements and check for statuses other than "live"
		for (int i = 0; i < statusElements.size(); i++) {
			WebElement statusElement = statusElements.get(i);
			String statusText = statusElement.getText().toLowerCase();
			node.log(Status.INFO, "STEP_0.0001 : Status of element is " + statusText + " and selected option is "
					+ dropdownOptionValue);
			System.out.println("STEP_0.0001 : Status of element is " + statusText + " and selected option is "
					+ dropdownOptionValue);

			if (!statusText.equalsIgnoreCase(dropdownOptionValue)) {
				incorrectCount++;
				count = Integer.toString(i + 1);
				// Create locator based on the provided status
				String referenceLocator = IElementActions.createDynamicLocatorString(FundingDatabasePO.dynamicReference,
						"value", count);

				// Print facility number associated with the incorrect status
				String facilityNumber = IElementActions.getElementText_usingXpath(node, driver, referenceLocator);
				System.out.println(
						"Facility Number for incorrect status at count " + incorrectCount + ": " + facilityNumber);
				node.log(Status.FAIL,
						"Facility Number for incorrect status at count " + incorrectCount + ": " + facilityNumber);
			}
		}

		// Validate result
		if (incorrectCount == 0) {
			Assert.assertTrue(true, "All elements in the filtered result have " + dropdownOptionValue + " status.");
			System.out.println("All elements in the filtered result have " + dropdownOptionValue + " status.");
			node.log(Status.PASS, "All elements in the filtered result have " + dropdownOptionValue + " status.");
		} else {
			Assert.assertTrue(false,
					"Error: Found " + incorrectCount + " elements with statuses other than " + dropdownOptionValue);
			System.out.println(
					"Error: Found " + incorrectCount + " elements with statuses other than " + dropdownOptionValue);
			node.log(Status.FAIL,
					"Error: Found " + incorrectCount + " elements with statuses other than " + dropdownOptionValue);
		}
	}

	public static double calculateSumOfList(String listElements) {
		// Locate the list element by its XPath
		List<WebElement> elements = IElementActions.returnElements(node, driver, listElements);

		// Initialize the variable to store the sum
		double sum = 0;

		// Iterate through each element in the list
		for (WebElement element : elements) {
			String getLoanAmountValue = element.getText();
			String formattedAmountString = getLoanAmountValue.replace("£", "").replace(",", "").replace("%", "");

			// Get the numerical value from the element and add it to the sum
			double elementValue = Double.parseDouble(formattedAmountString);
			sum += elementValue;
		}
		node.log(Status.INFO, "SUB-STEP_0.001 : Total sum is " + sum);
		System.out.println("SUB-STEP_0.001 : Total sum is " + sum);
		return sum;
	}

	public static double sumOfGreaterThanZeroValues(String listElements) {
		// Locate the list element by its XPath
		List<WebElement> elements = IElementActions.returnElements(node, driver, listElements);

		// Initialize the variable to store the sum
		double sum = 0;

		// Iterate through each element in the list
		for (WebElement element : elements) {
			String getLoanAmountValue = element.getText();
			String formattedAmountString = getLoanAmountValue.replace("£", "").replace(",", "").replace("%", "");

			// Get the numerical value from the element
			double elementValue = Double.parseDouble(formattedAmountString);

			// Check if the element value is greater than 0 before adding it to the sum
			if (elementValue > 0) {
				sum += elementValue;
			}
		}

		node.log(Status.INFO, "SUB-STEP_0.001 : Total sum is " + sum);
		System.out.println("SUB-STEP_0.001 : Total sum is " + sum);
		return sum;
	}

	public static double calculateSumOfPercentageList(String listElements) {
		// Locate the list element by its XPath
		List<WebElement> elements = IElementActions.returnElements(node, driver, listElements);

		// Initialize the variable to store the sum
		double sum = 0;

		// Iterate through each element in the list
		for (WebElement element : elements) {
			String getLoanAmountValue = element.getText();
			String formattedAmountString = getLoanAmountValue.replace("£", "").replace(",", "").replace("%", "");

			// Get the numerical value from the element and add it to the sum
			double elementValue = Double.parseDouble(formattedAmountString);
			elementValue = elementValue / 100;
			sum += elementValue;
		}
		node.log(Status.INFO, "SUB-STEP_0.001 : Total sum is " + sum);
		System.out.println("SUB-STEP_0.001 : Total sum is " + sum);
		return sum;
	}

	public static void validateSumForDoubleValues(String actualElement, String listElements, String acceptableDeviation,
			String columnName) {
		double acceptableDifference = Double.parseDouble(acceptableDeviation);
		// Wait for Page Load
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the complete page loding");
		System.out.println("SUB-STEP_0.001 : Waiting for the complete page loading");
		IWaitStrategy.WaitForPageLoadingToComplete(node, driver);
		IWaitStrategy.waitForVisiblity(node, driver, actualElement);
		node.log(Status.INFO, "SUB-STEP_0.002 : Complete Page is load successfully");
		System.out.println("SUB-STEP_0.002 : Complete Page is load successfully");
		String totalAmountValue = IElementActions.getElementText_usingXpath(node, driver, actualElement);
		// Remove the currency symbol and comma
		String cleanedAmountString = totalAmountValue.replace("£", "").replace(",", "");
		// Convert the cleaned string to a numerical value
		double totalAmount = Double.parseDouble(cleanedAmountString);
		node.log(Status.INFO, "SUB-STEP_0.003 : Total amount in " + columnName + totalAmount);
		System.out.println("SUB-STEP_0.003 : Total amount in " + columnName + totalAmount);
		double sum = Utils.calculateSumOfList(listElements);
		// Perform assertion allowing for a difference around 1 with a delta parameter
		Assert.assertEquals(totalAmount, sum, acceptableDifference, "Difference is greater than the acceptable range");
	}

	public static void clickOnTab(String tabLocator, String pageHeaderLoactor, String tabName) {
		IElementActions.scrollToTop(driver);
		// Wait for the visibility of Tab
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of " + tabName + " tab ");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of " + tabName + " tab ");
		IWaitStrategy.waitForVisiblity(node, driver, tabLocator);
		IWaitStrategy.WaitUntilElementClickable(node, driver, tabLocator);
		node.log(Status.INFO, "SUB-STEP_0.002 : The " + tabName + " tab is visible");
		System.out.println("SUB-STEP_0.002 : The " + tabName + " tab is visible");
		// Click on Tab
		IElementActions.clickelement_usingXpath(node, driver, tabLocator);
		node.log(Status.INFO, "SUB-STEP_0.003 : Clicked on " + tabName + " tab");
		System.out.println("SUB-STEP_0.003 : Clicked on " + tabName + " tab");
		// Wait for the visibility of page
		node.log(Status.INFO, "STEP_0.004 : Waiting for the visibility of page");
		System.out.println("STEP_0.004 : Waiting for the visibility of page");
		IWaitStrategy.waitForVisiblity(node, driver, pageHeaderLoactor);
		node.log(Status.INFO, "STEP_0.005 : Page is visible");
		System.out.println("STEP_0.005 : Page is visible");
	}

	public static void waitAndClickOnTab(String tabLocator, String pageHeaderLoactor, String tabName)
			throws InterruptedException {
		Thread.sleep(1000);
		IElementActions.scrollToTop(driver);
		// Wait for the visibility of Tab
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of " + tabName + " tab ");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of " + tabName + " tab ");
		IWaitStrategy.waitForVisiblity(node, driver, tabLocator);
		IWaitStrategy.WaitUntilElementClickable(node, driver, tabLocator);
		node.log(Status.INFO, "SUB-STEP_0.002 : The " + tabName + " tab is visible");
		System.out.println("SUB-STEP_0.002 : The " + tabName + " tab is visible");

		// Move to element and click on the tab
		IElementActions.moveToElementAndClick_usingXpath(node, driver, tabLocator);
		node.log(Status.INFO, "SUB-STEP_0.003 : Clicked on " + tabName + " tab");
		System.out.println("SUB-STEP_0.003 : Clicked on " + tabName + " tab");

		// Wait for the visibility of page
		node.log(Status.INFO, "STEP_0.004 : Waiting for the visibility of page");
		System.out.println("STEP_0.004 : Waiting for the visibility of page");
		IWaitStrategy.waitForVisiblity(node, driver, pageHeaderLoactor);
		node.log(Status.INFO, "STEP_0.005 : Page is visible");
		System.out.println("STEP_0.005 : Page is visible");
	}

	public static void clickAndWait(String button, String buttonName, String waitLocator) {
		// Click on the button
		IElementActions.clickelement_usingXpath(node, driver, button);
		node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on the " + buttonName);
		System.out.println("SUB-STEP_0.001 : Clicked on the " + buttonName);
		// Wait for the visibility of element
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of the element");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of the element");
		IWaitStrategy.waitForVisiblity(node, driver, waitLocator);
		node.log(Status.INFO, "SUB-STEP_0.003 : The element is visible");
		System.out.println("SUB-STEP_0.003 : The element is visible");
	}

	public static String getDateValueFromExcel(String excelValue, String DateFormat) {// Convert string to double
		double cellValue = Double.parseDouble(excelValue);
		// Converting numeric value to date
		java.util.Date date = DateUtil.getJavaDate(cellValue);
		// Formatting the date as needed
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DateFormat);
		return sdf.format(date);
	}

	public static void enterDate(String date, String month, String monthValue, String year, String yearValue,
			String day, String dayValue) {
		// Clicked on Date
		IElementActions.clickelement_usingXpath(node, driver, date);
		node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on the date");
		System.out.println("SUB-STEP_0.001 : Clicked on the date");

		// Wait for the visibility of the entry
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of the month in calender popup");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of the month in calender popup");
		IWaitStrategy.waitForVisiblity(node, driver, month);
		node.log(Status.INFO, "SUB-STEP_0.003 : Month is visible");
		System.out.println("SUB-STEP_0.003 : Month is visible");

		// Select month
		IElementActions.selectByValueFromDropdown(node, driver, month, monthValue);
		node.log(Status.INFO, "SUB-STEP_0.004 : Selected month");
		System.out.println("SUB-STEP_0.004 : Selected month");

		// Select year
		IElementActions.selectByValueFromDropdown(node, driver, year, yearValue);
		node.log(Status.INFO, "SUB-STEP_0.005 : Selected year");
		System.out.println("SUB-STEP_0.005 : Selected year");

		// Select day
		enterDay(day, dayValue);
	}

	public static void enterDay(String day, String dayValue) {
		// Create the Dynamic date locator
		String dateLocator = IElementActions.createDynamicLocatorString(day, "locatorValue", dayValue);

		// Wait for the visibility of the dateLocator
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the date");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the date");
		IWaitStrategy.waitForVisiblity(node, driver, dateLocator);
		node.log(Status.INFO, "SUB-STEP_0.002 : Date is visible");
		System.out.println("SUB-STEP_0.002 : Date is visible");

		// Click on the date
		IElementActions.clickelement_usingXpath(node, driver, dateLocator);
		node.log(Status.INFO, "SUB-STEP_0.003 : Clicked on the date");
		System.out.println("SUB-STEP_0.003 : Clicked on the date");
	}

	public static String generateString() {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		sb.append("1 A");
		for (int i = 0; i < (int) (Math.random() * 2) + 3; i++) {
			sb.append(alphabet.charAt((int) (Math.random() * alphabet.length())));
		}
		return sb.toString();
	}

	public static void saveLoan() {
		// Click on the save button
		IElementActions.clickelement_usingXpath(node, driver, UtilsPO.save);
		node.log(Status.INFO, "SUB-STEP_0.001 : Clicked on the save");
		System.out.println("SUB-STEP_0.001 : Clicked on the save");

		// Wait for the visibility of the success popup
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of the success popup");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of the success popup");
		IWaitStrategy.waitForVisiblity(node, driver, UtilsPO.successPopup);
		node.log(Status.INFO, "SUB-STEP_0.003 : Success popup is visible");
		System.out.println("SUB-STEP_0.003 : Success popup is visible");

		// Check the popup
		IElementActions.assertTrue_usingXpath(node, driver, UtilsPO.successPopup,
				"SUB-STEP_0.004 : BUG: Success popup is not coming on clicking save button",
				"SUB-STEP_0.004 : BUG: Success popup is not coming on clicking save button");

		// Click on the close button
		IElementActions.clickelement_usingXpath(node, driver, UtilsPO.closePopUp);
		node.log(Status.INFO, "SUB-STEP_0.005 : Closed success popup");
		System.out.println("SUB-STEP_0.005 : Closed success popup");

		// Wait for the invisibility of the success popup
		node.log(Status.INFO, "SUB-STEP_0.006 : Waiting for the invisibility of the success popup");
		System.out.println("SUB-STEP_0.006 : Waiting for the invisibility of the success popup");
		IWaitStrategy.waitForInVisiblity(node, driver, UtilsPO.successPopup);
		node.log(Status.INFO, "SUB-STEP_0.007 : Success popup is not displayed");
		System.out.println("SUB-STEP_0.007 : Success popup is not displayed");
	}

	public static String removeCurrencySymbol(String value) {
		// Remove commas and currency symbols
		return value.replaceAll("[,\\$£€]", "");
	}

	// Method to check if the include element is checked
	public static boolean isIncludeChecked(WebElement includeElement) {
		String classes = includeElement.getAttribute("class");
		return classes.contains("ui-state-active");
	}

	public static List<String> extractTextFromElements(String locator) {

		// Wait for the elemet to be visible
		node.log(Status.INFO, "STEP51: Waiting for element to be visible");
		System.out.println("STEP1 : Waiting for element to be visible");
		IWaitStrategy.waitForVisiblityDynamic(node, driver, locator, 150);
		node.log(Status.INFO, "STEP2 : Element is visible");
		System.out.println("STEP2 : Element is visible");

		List<WebElement> elements = IElementActions.returnElements(node, driver, locator);
		List<String> textList = new ArrayList<>();
		for (WebElement element : elements) {
			textList.add(element.getText());
		}

		return textList;
	}

	public static List<String> extractTextFromElementsAndRemoveCurrency(String locator) {
		List<WebElement> elements = IElementActions.returnElements(node, driver, locator);
		List<String> textList = new ArrayList<>();
		for (WebElement element : elements) {

			String text = element.getText().replaceAll("[£,%]", ""); // Remove currency symbol and commas

			textList.add(text);
		}
		return textList;
	}

	public static List<Double> extractTextForNumeric(String locator) {
		List<WebElement> elements = IElementActions.returnElements(node, driver, locator);
		List<Double> doubleList = new ArrayList<>();
		for (WebElement element : elements) {
			try {
				String text = element.getText().replaceAll("[£,%]", "").trim(); // Remove currency symbols and commas
				if (!text.isEmpty()) {
					double value = Double.parseDouble(text);
					doubleList.add(value);
				}
			} catch (NumberFormatException e) {
				// Handle the exception if the text cannot be parsed to a double
				System.err.println("Unable to parse text to double: " + element.getText());
			}
		}
		return doubleList;
	}

	public static double calculateMedian(List<String> values) {
		List<Double> numericalValues = new ArrayList<>();

		// Convert strings to doubles
		for (String value : values) {
			numericalValues.add(Double.parseDouble(value));
		}

		// Sort the list
		Collections.sort(numericalValues);

		int size = numericalValues.size();
		if (size % 2 == 0) {
			// If the size is even, average the middle two values
			int middleIndex1 = size / 2 - 1;
			int middleIndex2 = size / 2;
			return (numericalValues.get(middleIndex1) + numericalValues.get(middleIndex2)) / 2.0;
		} else {
			// If the size is odd, return the middle value
			int middleIndex = size / 2;
			return numericalValues.get(middleIndex);
		}
	}

	public static List<String> extractTextFromInputElements(String locator) {
		List<WebElement> elements = IElementActions.returnElements(node, driver, locator);
		List<String> textList = new ArrayList<>();
		for (WebElement element : elements) {
			String elementValue = element.getAttribute("value");
			textList.add(elementValue);
		}

		return textList;
	}

	public static List<Double> extractDoubleValuesFromElements(String locator) {
		List<WebElement> elements = IElementActions.returnElements(node, driver, locator);
		List<Double> doubleValues = new ArrayList<>();
		for (WebElement element : elements) {
			String text = element.getText().replaceAll("[£,]", ""); // Remove currency symbol and commas
			double value = Double.parseDouble(text);
			doubleValues.add(value);
		}

		return doubleValues;
	}

	public static List<Integer> extractIntegerValuesFromElements(String locator) {
		List<WebElement> elements = IElementActions.returnElements(node, driver, locator);
		List<Integer> intValues = new ArrayList<>();
		for (WebElement element : elements) {
			String text = element.getText().replaceAll("[£,%]", ""); // Remove currency symbol and commas
			Integer value = Integer.parseInt(text);
			intValues.add(value);
		}

		return intValues;
	}

	public static List<Double> extractPercentageToValueFromElements(String locator) {
		List<WebElement> elements = IElementActions.returnElements(node, driver, locator);
		List<Double> doubleValues = new ArrayList<>();
		for (WebElement element : elements) {
			String text = element.getText().replaceAll("[£,%]", ""); // Remove currency symbol and commas
			double value = Double.parseDouble(text);
			value = value / 100;
			doubleValues.add(value);
		}

		return doubleValues;
	}

	public static List<Integer> extractElementsGreaterThanZero(String locator) {
		List<WebElement> elements = IElementActions.returnElements(node, driver, locator);
		List<Integer> intValues = new ArrayList<>();
		for (WebElement element : elements) {
			String text = element.getText().replaceAll("[£,%]", ""); // Remove currency symbol and commas
			Integer value = Integer.parseInt(text);

			// Check if the element value is greater than 0 before adding it to the sum
			if (value > 0) {
				intValues.add(value);
			} else if (value <= 0) {
				value = 0;
				intValues.add(value);
			}
		}

		return intValues;
	}

	public static void spinner(String spinnerXpath) {
		try {
			while (driver.findElement(By.xpath(spinnerXpath)).isDisplayed()) {
				System.out.println("spinner");
			}
		} catch (Exception e) {
			System.out.println("spinner gone");
		}
	}

	public static double calculateSumOfListExceptUndefinedValue(String listElements) {
		// Locate the list element by its XPath
		List<WebElement> elements = IElementActions.returnElements(node, driver, listElements);

		// Initialize the variable to store the sum
		double sum = 0;

		// Iterate through each element in the list
		for (WebElement element : elements) {
			String getLoanAmountValue = element.getText();
			if (!(getLoanAmountValue.contains("-"))) {
				String formattedAmountString = getLoanAmountValue.replace("£", "").replace(",", "");

				// Get the numerical value from the element and add it to the sum
				double elementValue = Double.parseDouble(formattedAmountString);
				sum += elementValue;
			}
		}
		node.log(Status.INFO, "SUB-STEP_0.001 : Total sum is " + sum);
		System.out.println("SUB-STEP_0.001 : Total sum is " + sum);
		return sum;
	}

	/**
	 * The "getLastDayOfPreviousMonth" function is used to get the last day of the
	 * previous month in dd/MM/yyyy format
	 *
	 * @return
	 */
	public static String getLastDayOfPreviousMonth() {
		// Getting last day of the previous month
		LocalDate lastDayOfPreviousMonth = LocalDate.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());

		// Formatted date in to dd/MM/yyyy
		String formattedDate = lastDayOfPreviousMonth.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return formattedDate;
	}

	public static void validateList(List<String> list1, List<String> list2, String errorMessage, String passMessage)
			throws NumberFormatException, FileNotFoundException, IOException {
		// Deviation
		String value = getDataFromExcel(69);
		double deviatedValue = Double.parseDouble(getDataFromExcel(69));

		// Perform assertion for each pair of values in the lists
		boolean allValuesMatch = true;
		// Check if both lists have the same size
		if (list1.size() != list2.size()) {
			allValuesMatch = false;
			System.out.println("Lists have different sizes");
		} else {
			for (int i = 0; i < list1.size(); i++) {
				String list1Value = Utils.formatText(list1.get(i));
				String list2Value = Utils.formatText(list2.get(i));
				double valueFromList1 = Utils.parseCurrencyValueToDouble(list1Value);
				double valueFromList2 = Utils.parseCurrencyValueToDouble(list2Value);

				// Format the values to one decimal place
				DecimalFormat df = new DecimalFormat("#.#");
				valueFromList1 = Double.parseDouble(df.format(valueFromList1));
				valueFromList2 = Double.parseDouble(df.format(valueFromList2));

				Double absoluteDifference = Math.abs(valueFromList1 - valueFromList2);

				// Check if the values match
				if (!(valueFromList1 == valueFromList2 || absoluteDifference <= deviatedValue)) {
					allValuesMatch = false;
					System.out.println("List 1: " + valueFromList1 + " at position " + i
							+ " do not match with the List 2:  " + valueFromList2);
					node.log(Status.FAIL, "List 1: " + valueFromList1 + " at position " + i
							+ " do not match with the List 2:  " + valueFromList2);
				}
			}
		}

		// Perform the final assertion based on the matching status
		if (allValuesMatch) {
			Assert.assertTrue(true, passMessage);
			System.out.println(passMessage);
			node.log(Status.PASS, passMessage);
		} else {
			Assert.assertTrue(false, errorMessage + " i.e not all values in the lists match");
			System.out.println(errorMessage + " i.e not all values in the lists match");
			node.log(Status.FAIL, errorMessage + " i.e not all values in the lists match");
		}

	}

	public static void validateStringList(List<String> list1, List<String> list2, String errorMessage,
			String passMessage) throws NumberFormatException, FileNotFoundException, IOException {
		// Perform assertion for each pair of values in the lists
		boolean allValuesMatch = true;
		// Check if both lists have the same size
		if (list1.size() != list2.size()) {
			allValuesMatch = false;
			System.out.println("Lists have different sizes");
		} else {
			for (int i = 0; i < list1.size(); i++) {
				String list1Value = Utils.formatText(list1.get(i));

				String list2Value = Utils.formatText(list2.get(i));

				// Compare the string values directly
				if (!list1Value.equalsIgnoreCase(list2Value)) {
					allValuesMatch = false;
					System.out.println("List 1: " + list1Value + " at position " + i
							+ " do not match with the List 2:  " + list2Value);
					node.log(Status.FAIL, "List 1: " + list1Value + " at position " + i
							+ " do not match with the List 2:  " + list2Value);
				}
			}
		}

		// Perform the final assertion based on the matching status
		if (allValuesMatch) {
			Assert.assertTrue(true, passMessage);
			System.out.println(passMessage);
			node.log(Status.PASS, passMessage);
		} else {
			Assert.assertTrue(false, errorMessage + " i.e not all values in the lists match");
			System.out.println(errorMessage + " i.e not all values in the lists match");
			node.log(Status.FAIL, errorMessage + " i.e not all values in the lists match");
		}
	}

	public static List<String> getEvenPositionElements(String elements) {
		List<String> listData = Utils.extractTextFromElements(elements);

		// Create a list to store even-positioned elements
		List<String> evenElements = new ArrayList<>();

		// Iterate through the elements and add even-positioned ones to the list
		for (int i = 0; i < listData.size(); i++) {
			if (i % 2 == 0) { // Check if the index is even
				evenElements.add(listData.get(i));
			}
		}
		return evenElements;
	}

	public static List<String> getOddPositionElements(String elements) {
		List<String> listData = Utils.extractTextFromElements(elements);

		// Create a list to store odd-positioned elements
		List<String> oddElements = new ArrayList<>();

		// Iterate through the elements and add odd-positioned ones to the list
		for (int i = 0; i < listData.size(); i++) {
			if (i % 2 != 0) { // Check if the index is odd
				oddElements.add(listData.get(i));
			}
		}
		return oddElements;
	}

	public static List<String> calculateDifferences(List<String> list1, List<String> list2) {
		// Create a list to store the differences
		List<String> differences = new ArrayList<>();

		// Iterate through the elements of both lists
		for (int i = 0; i < list1.size(); i++) {
			// Extract numerical values from strings and remove currency
			double value1 = parseCurrencyValueToDouble(list1.get(i));
			double value2 = parseCurrencyValueToDouble(list2.get(i));

			// Calculate the difference and add it to the list
			differences.add(String.format("%.0f", value1 - value2));
		}
		return differences;
	}

	public static List<String> calculateQuotients(List<String> list1, List<String> list2) {
		// Create a list to store the quotients
		List<String> quotients = new ArrayList<>();

		// Iterate through the elements of both lists
		for (int i = 0; i < list1.size(); i++) {
			// Extract numerical values from strings and remove currency
			double value1 = parseCurrencyValueToDouble(list1.get(i));
			double value2 = parseCurrencyValueToDouble(list2.get(i));

			// Check if value2 is not zero to avoid division by zero
			if (value2 != 0) {
				// Calculate the quotient and add it to the list
				quotients.add(String.valueOf(value1 / value2));
			} else {
				// Handle division by zero scenario
				// quotients.add("Error: Division by zero");
				quotients.add("0");
			}
		}

		return quotients;
	}

	public static void clickTwice(String element, String elementName) throws InterruptedException {
		// Scroll to theelement
		IElementActions.scrollbyJSExecutorUsingElementPath(driver, element);
		node.log(Status.INFO, "SUB-STEP_0.001 : Scrolled to the element");
		System.out.println("SUB-STEP_0.001 : Scrolled to the element");

		// Wait for the sort icon to be visible and clickable
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the sort icon to be visible and clickable");
		System.out.println("SUB-STEP_0.002 : Waiting for the sort icon to be visible and clickable");
		IWaitStrategy.waitForVisiblity(node, driver, element);
		IWaitStrategy.WaitUntilElementClickable(node, driver, element);
		node.log(Status.INFO, "SUB-STEP_0.003 : Sort icon is visible and clickable");
		System.out.println("SUB-STEP_0.003 : Sort icon is visible and clickable");

		// Click first time on element
		IElementActions.clickelement_usingXpath(node, driver, element);
		node.log(Status.INFO, "SUB-STEP_0.004 : Clicked first time on the " + elementName);
		System.out.println("SUB-STEP_0.004 : Clicked first time on the " + elementName);

		// Wait for the sort icon to be visible and clickable
		node.log(Status.INFO, "SUB-STEP_0.005 : Waiting for the sort icon to be visible and clickable");
		System.out.println("SUB-STEP_0.005 : Waiting for the sort icon to be visible and clickable");
		IWaitStrategy.waitForVisiblity(node, driver, element);
		IWaitStrategy.WaitUntilElementClickable(node, driver, element);
		node.log(Status.INFO, "SUB-STEP_0.006 : Sort icon is visible and clickable");
		System.out.println("SUB-STEP_0.006 : Sort icon is visible and clickable");
		Thread.sleep(2000);
		// Click second time on element
		IElementActions.clickelement_usingXpath(node, driver, element);
		node.log(Status.INFO, "SUB-STEP_0.007 : Clicked second time on the " + elementName);
		System.out.println("SUB-STEP_0.007 : Clicked second time on the " + elementName);
	}

	// Method to verify the current order of the listing
	private static boolean isListingInDescendingOrder(WebDriver driver, String listLocator) {
		// Get the list of elements in the listing
		List<WebElement> listingElements = IElementActions.returnElements(node, driver, listLocator);

		// Loop through the listing elements to check if they are in descending order
		for (int i = 0; i < listingElements.size() - 1; i++) {
			// Extract numeric values from the text
			int current = extractNumericData(listingElements.get(i).getText());
			int next = extractNumericData(listingElements.get(i + 1).getText());

			// Compare current element with the next one
			if (current < next) {
				return false; // If not in descending order, return false
			}
		}
		return true; // If all elements are in descending order, return true
	}

	// Method to extract numeric value from a string
	private static int extractNumericData(String text) {
		// Define a pattern to match numeric values
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(text);

		// Extract and concatenate digits
		StringBuilder numericValue = new StringBuilder();
		while (matcher.find()) {
			numericValue.append(matcher.group());
		}

		// Parse the numeric value to an integer
		return Integer.parseInt(numericValue.toString());
	}

	public static void sortListingInDescendin(String sortIcon, String elementName, String listLocator)
			throws InterruptedException {

		// Click on the sort icon to toggle the sorting order
		IElementActions.clickelement_usingXpath(node, driver, sortIcon);
		node.log(Status.INFO, "STEP1 : Clicked on the sort icon " + elementName);
		System.out.println("STEP1 : Clicked on the sort icon " + elementName);

		Thread.sleep(2000);
		// Check the current order of the listing
		boolean isDescending = isListingInDescendingOrder(driver, listLocator);

		// Determine the sorting order based on the current order
		if (!isDescending) {
			// If currently descending, click again for ascending order
			IElementActions.clickelement_usingXpath(node, driver, sortIcon);
			node.log(Status.INFO, "STEP1 : Clicked on the sort icon " + elementName);
			System.out.println("STEP1 : Clicked on the sort icon " + elementName);
		}
	}

	public static void sortListingInAscendin(String sortIcon, String elementName, String listLocator)
			throws InterruptedException {

		// Click on the sort icon to toggle the sorting order
		IElementActions.clickelement_usingXpath(node, driver, sortIcon);
		node.log(Status.INFO, "STEP1 : Clicked on the sort icon " + elementName);
		System.out.println("STEP1 : Clicked on the sort icon " + elementName);

		Thread.sleep(2000);

		// Check the current order of the listing
		boolean isDescending = isListingInDescendingOrder(driver, listLocator);

		// Determine the sorting order based on the current order
		if (isDescending) {
			// If currently descending, click again for ascending order
			IElementActions.clickelement_usingXpath(node, driver, sortIcon);
			node.log(Status.INFO, "STEP1 : Clicked on the sort icon " + elementName);
			System.out.println("STEP1 : Clicked on the sort icon " + elementName);
		}
	}

	public static String getDecimalOneDigit(double value) {
		// Format the values to one decimal place
		DecimalFormat df = new DecimalFormat("#.#");

		// Rounding down to one decimal place
		double roundedValue = Math.floor(value * 10) / 10;

		// Format the rounded median
		String calculated = df.format(roundedValue);

		return calculated;

	}

	public static long calculateSumProduct(List<Integer> list1, List<Integer> list2) {
		// Check if the lists have the same size
		if (list1.size() != list2.size()) {
			throw new IllegalArgumentException("Lists must have the same size");
		}

		long sumProduct = 0; // Change int to long

		// Iterate through the lists and calculate the sumproduct
		for (int i = 0; i < list1.size(); i++) {
			sumProduct += (long) list1.get(i) * list2.get(i); // Cast list1.get(i) to long
		}

		return sumProduct;
	}

	public static double calculateSumProductForDouble(List<Double> list1, List<Double> list2) {
		// Check if the lists have the same size
		if (list1.size() != list2.size()) {
			throw new IllegalArgumentException("Lists must have the same size");
		}

		double sumProduct = 0.0;

		// Iterate through the lists and calculate the sumproduct
		for (int i = 0; i < list1.size(); i++) {
			sumProduct += list1.get(i) * list2.get(i);
		}

		return sumProduct;
	}

	public static void scrollVerticalAndHorizontalToAccessTable(String verticalScroll, String table,
			String elementVisibility) throws InterruptedException {
		// Scroll to the element vertically
		IElementActions.scrollbyJSExecutorUsingElementPath(driver, verticalScroll);
		node.log(Status.INFO, "SUB-STEP_0.001 : Scrolled to the element vertically");
		System.out.println("SUB-STEP_0.001 : Scrolled to the element vertically");

		// Scroll horizontally in Table
		Thread.sleep(1000);
		IElementActions.scrollHorizontally(driver, table, 1000);
		node.log(Status.INFO, "SUB-STEP_0.002 : Scrolled to the element horizontally");
		System.out.println("SUB-STEP_0.002 : Scrolled to the element horizontally");

		// Wait for the visibility of the excluded elements
		node.log(Status.INFO, "SUB-STEP_0.003 : Waiting for the visibility of the excluded elements");
		System.out.println("SUB-STEP_0.003 : Waiting for the visibility of the excluded elements");
		IWaitStrategy.waitForVisiblity(node, driver, elementVisibility);
		node.log(Status.INFO, "SUB-STEP_0.004 :  Excluded elements is visible");
		System.out.println("SUB-STEP_0.004 : Excluded elements is visible");
	}

	/**
	 * Helper method to check if a given value is effectively zero.
	 *
	 * @param The value to check.
	 * @return True if the value is '0' or '0.0', otherwise false.
	 */
	public static String isZeroLtv(String value) {
		if (value.equals("0")) {
			value = "0.0";
		}
		return value;
	}

	public static String getLaunchDate(ExtentTest node, WebDriver driver, String launchDateLocator) {
		// Wait for the visibility of the row
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the first record");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the first record");
		IWaitStrategy.waitForVisiblity(node, driver, launchDateLocator);
		IWaitStrategy.waitForVisiblityAndPresence(node, driver, launchDateLocator);
		node.log(Status.INFO, "SUB-STEP_0.002 : First record on the page is visible");
		System.out.println("SUB-STEP_0.002 : First record on the page is visible");
		String launchDate = IElementActions.getElementText_usingXpath(node, driver, launchDateLocator);
		node.log(Status.INFO, "SUB-STEP_0.003 : First record date on the page is " + launchDate);
		System.out.println("SUB-STEP_0.003 : First record date on the page is " + launchDate);
		return launchDate;
	}

	public static String getCurrentPageNumber(ExtentTest node, WebDriver driver, String currentPageNumberLocator) {
		IElementActions.scrollToBottom(driver);
		node.log(Status.INFO, "SUB-STEP_0.001 : Scrolled down to the bottom of the page");
		System.out.println("SUB-STEP_0.001 : Scrolled down to the bottom of the page");
		// Wait for the visibility of the specific page
		node.log(Status.INFO, "SUB-STEP_0.002 : Waiting for the visibility of the next page first record");
		System.out.println("SUB-STEP_0.002 : Waiting for the visibility of the next page first record");
		IWaitStrategy.waitForVisiblity(node, driver, currentPageNumberLocator);
		IWaitStrategy.waitForVisiblityAndPresence(node, driver, currentPageNumberLocator);
		node.log(Status.INFO, "SUB-STEP_0.003: First record on the next page is visible");
		System.out.println("SUB-STEP_0.003 : First record on the next page is visible");
		String currentPageNumber = IElementActions.getElementText_usingXpath(node, driver, currentPageNumberLocator);
		node.log(Status.INFO, "SUB-STEP_0.004 : Current page is " + currentPageNumber);
		System.out.println("SUB-STEP_0.004 : Current page is " + currentPageNumber);
		return currentPageNumber;
	}

	public static String checkStatus(String xRecordDoneStatus, String xRecordInProgressStatus,
			String xRecordErrorStatus) {
		// Check if the span element is present for done status
		boolean isSpanPresent = IElementActions.isElementAvailable(node, driver, xRecordDoneStatus);
		// Check if the div element is present for progress status
		boolean isDivPresent = IElementActions.isElementAvailable(node, driver, xRecordInProgressStatus);
		// Check if the div element is present for error status
		boolean isDivErrorPresent = IElementActions.isElementAvailable(node, driver, xRecordErrorStatus);
		// Determine the status based on element presence
		String status = null;
		if (isSpanPresent) {
			status = IElementActions.getElementText_usingXpath(node, driver, xRecordDoneStatus);
		} else if (isDivPresent) {
			status = IElementActions.getElementText_usingXpath(node, driver, xRecordInProgressStatus);
		} else if (isDivErrorPresent) {
			status = IElementActions.getElementText_usingXpath(node, driver, xRecordErrorStatus);
		}
		return status;
	}

	public static String[] extractDateParts(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		try {
			LocalDate date = LocalDate.parse(dateString, formatter);

			String day = String.valueOf(date.getDayOfMonth());
			String month = String.valueOf(date.getMonthValue());
			String year = String.valueOf(date.getYear());

			return new String[] { day, month, year };
		} catch (DateTimeParseException e) {
			return new String[] { "Invalid date format. Please use dd-MM-yyyy." };
		}
	}

}
