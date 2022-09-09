package com.Automation.driver;

import org.openqa.selenium.WebDriver;

public class WebBrowser {
	public WebBrowser() {
	};

	public static IDriver DriverService = null;
	private static Browsers BrowserDriver;
	private static WebDriver driver = null;

	// To set the browser type through a Singleton Methodology
	public static void setBrowserType(String BrowserType) throws Exception {

		BrowserDriver = Browsers.get(BrowserType);
		if (null == DriverService) {
			switch (BrowserDriver) {

				case CHROME:
					DriverService = new CHDriver();
					break;

				case FIREFOX:
					DriverService = new FFDriver();
					break;

				case EDGE:
					DriverService = new EDGEDriver();
					break;

				default:
					break;
			}
		}

		driver = DriverService.get();
	}

	public static WebDriver getDriver() {
		return driver;
	}

	// To stop the driver
	public static void Quit() throws Exception {
		DriverService.stopDriver();

	}



}