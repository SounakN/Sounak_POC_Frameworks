package com.Automation.StepDefinitions.Mobile.Native;

import com.Automation.driver.MobileWebNative;
import com.Automation.utilities.EnvUtil;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.util.Date;
import java.util.Properties;

public class SetUp_Native {
    public static AppiumDriver driver;
    public static String ScenarioName;
    public static Scenario Sc;
    File file;
    public static byte[][] screenshotsArray = new byte[10][10000];
    public static Date date;
    public static String BrowserName = "";
    public static Properties data = null;
    public static Properties Env_data = null;
    public static String Driver;

    static {
        EnvUtil.loadProperties(System.getProperty("Env"));
        data = EnvUtil.getProperties();
        System.out.println(data.getProperty("Email"));
    }


    @Before()
    public void setupTest(Scenario scenario) throws Exception {
        Sc = scenario;
        ScenarioName = scenario.getName();
        //Getting the browser
        Driver = (System.getProperty("Driver_mobile") != null) ? System.getProperty("Driver_mobile") : data.getProperty("Driver_mobile");
        //MobileWebNative.setAppType(Driver);
        driver = MobileWebNative.getDriver();
        System.out.println("-----------");
        System.out.println(driver.toString());
        System.out.println("--------");
        System.out.println(Thread.currentThread().getId());
        Capabilities cap1 = ((RemoteWebDriver) driver).getCapabilities();
    }


    @After()
    public void tearDown(Scenario scenario) throws Exception {
        System.out.println("In TearDown");
        System.out.println("result :: " + scenario);
        try {
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.toString());

                /*//Browser STack Failure reporting
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"FAILED\"}}");
                //Allure.addAttachment("Failed Screen", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));*/
            }
        } catch (Exception e) {
            scenario.log("The Scenario has failed and the Driver has failed to Take screenshot too");
        } finally {
            //Quiting Driver
            MobileWebNative.Quit();
        }
    }
}
