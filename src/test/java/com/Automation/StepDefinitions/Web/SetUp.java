package com.Automation.StepDefinitions.Web;

import com.Automation.driver.BasicConstants;
import com.Automation.driver.WebBrowser;
import com.Automation.utilities.EnvUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.util.Date;
import java.util.Properties;


public class SetUp {

    public static WebDriver driver;
    public static String ScenarioName;
    public static Scenario Sc;
    //public static EnvUtil EnvUtil = new EnvUtil();
    File file;
    public static byte[][] screenshotsArray = new byte[10][10000];
    public static Date date;
    public static String BrowserName = "";
    public static Properties data = null;
    public static Properties Env_data = null;

    static {
        EnvUtil.loadProperties(System.getProperty("Env"));
        data = EnvUtil.getProperties();

    }

    @Before()
    public void setupTest(Scenario scenario) throws Exception {
        Sc = scenario;
        ScenarioName = scenario.getName();
        //Getting the browser
        String browser = (System.getProperty("Driver") != null) ? System.getProperty("Driver") : data.getProperty("Driver");
        WebBrowser.setBrowserType(browser);
        driver = WebBrowser.getDriver();
        System.out.println("-----------");
        System.out.println(driver.toString() + "Session ID: " + ((RemoteWebDriver) driver).getSessionId());
        System.out.println("--------");
        System.out.println(Thread.currentThread().getId());
        Capabilities cap1 = ((RemoteWebDriver) driver).getCapabilities();
        BrowserName = cap1.getBrowserName().toLowerCase();
        System.out.println("BrowserName == " + BrowserName);

    }



    @After
    public void tearDown(Scenario scenario) throws Exception {
        System.out.println("In TearDown");
        System.out.println("result :: " + scenario);

        try {


            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.toString());

                /*//Browser STack Failure reporting
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"FAILED\"}}");
                //Allure.addAttachment("Failed Screen", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));*/
            }

        } catch (Exception e) {
            scenario.log("The Scenario has failed and the Driver has failed to Take screenshot too" + e.getMessage());
        } finally {
            //Quiting Driver
            WebBrowser.Quit();
        }


    }


}
