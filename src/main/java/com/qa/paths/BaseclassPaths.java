package com.qa.paths;

import java.io.IOException;

import com.qa.baseclass.Baseclass;

public class BaseclassPaths extends Baseclass {

	public static String environment;
	public static String siteUrl;
	public static String environmentUrl;

	public static void property() throws IOException {
		environment = configFile.getProperty("Environment");
		if (environment.equalsIgnoreCase("Staging")) {
			siteUrl = "https://stagingcdn.lenddirect.io/";
			environmentUrl = "stagingcdn";
		} else if (environment.equalsIgnoreCase("QA")) {
			siteUrl = "https://QA.lenddirect.io/";
			environmentUrl = "QA";
		} else if (environment.equalsIgnoreCase("production")) {
			siteUrl = "https://app.lenddirect.io/";
			environmentUrl = "app";
		}
	}

}
