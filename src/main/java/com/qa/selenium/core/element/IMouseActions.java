package com.qa.selenium.core.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.qa.baseclass.Baseclass;

public class IMouseActions extends Baseclass {

	// Method to hover the Mouse
	public static void mouseHover(WebDriver driver, String hoverElementLocator, String hoverElementName) {
		// Wait for the visibility of the Hover Element
		node.log(Status.INFO, "SUB-STEP_0.001 : Waiting for the visibility of the " + hoverElementName + " ");
		System.out.println("SUB-STEP_0.001 : Waiting for the visibility of the " + hoverElementName + " ");
		IWaitStrategy.waitForVisiblity(node, driver, hoverElementLocator);
		node.log(Status.INFO, "SUB-STEP_0.002 : " + hoverElementName + " is visible");
		System.out.println("SUB-STEP_0.002 : " + hoverElementName + " is visible");
		// Create an instance of the Actions class
		Actions actions = new Actions(driver);
		// Perform the hover action
		actions.moveToElement(driver.findElement(By.xpath(hoverElementLocator))).perform();
		node.log(Status.INFO, "SUB-STEP_0.003 : : Hover the Mouse on " + hoverElementName + " ");
		System.out.println("SUB-STEP_0.003 : : Hover the Mouse on " + hoverElementName + " ");
	}

	// Method to over the mouse and click
	public static void mouseHoverByOffsetAndClick(int xOffset, int yOffset) {
		// Create an instance of the Actions class
		Actions actions = new Actions(driver);
		// Perform the hover and click action
		actions.moveByOffset(xOffset, yOffset).click().build().perform();
		node.log(Status.INFO, "SUB-STEP_0.001 : : Hover the Mouse by offset and clicking");
		System.out.println("SUB-STEP_0.001 : : Hover the Mouse by offset and clicking");
	}
}
