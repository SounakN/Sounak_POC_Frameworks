package com.Automation.driver;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface IDriver {
	void startDriver() throws Exception;
	void stopDriver() throws Exception;
	WebDriver get() throws Exception;

	void setOptions() throws MalformedURLException;

}