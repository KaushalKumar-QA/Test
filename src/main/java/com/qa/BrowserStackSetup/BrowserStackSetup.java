package com.qa.BrowserStackSetup;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.baseclass.Baseclass;

public class BrowserStackSetup extends Baseclass {

	// Browsertack account configuration
	public static final String AUTOMATE_USERNAME = configFile.getProperty("BrowserstackUserName");
	public static final String AUTOMATE_ACCESS_KEY = configFile.getProperty("BrowserstackPassword");
	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";

	// Browserstack setup on Chrome Browser For Windows 10
	public static WebDriver setupChromeBrowserstack() throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "latest");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("resolution", "1440x900");
		options.addArguments("start-maximized");
		caps.setCapability("unhandledPromptBehavior", "ignore");
		caps.setCapability("browserstack.idleTimeout", "300");
		driver = new RemoteWebDriver(new URL(URL), caps);
		return driver;

	}

}
