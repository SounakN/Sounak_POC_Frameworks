package com.Automation.driver;

import com.Automation.StepDefinitions.Mobile.Native.SetUp_Native;
import com.Automation.StepDefinitions.Mobile.mWeb.SetUp_mWeb;
import com.Automation.utilities.EnvUtil;
import com.browserstack.local.Local;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public interface ANDROIDDriver extends IMobDriver {



    void startDriver();
    void stopDriver() throws Exception;
    AppiumDriver get();
    void setOptions() throws MalformedURLException;


    /*class AndroidMobileWeb implements  ANDROIDDriver{
        public static String AUTOMATE_USERNAME = null;
        public static String AUTOMATE_ACCESS_KEY = null;
        public static String URL = null;
        private Local l;
        public AppiumDriver driver ;
        public static AppiumDriverLocalService service=null;
        public static Properties prop =null;
        private String Timestampidentifier = null;
        private HashMap var = new HashMap<String, String>();

        public  AndroidMobileWeb() {
            prop = EnvUtil.getProperties();
            AUTOMATE_USERNAME = prop.getProperty("Browserstack_username");
            AUTOMATE_ACCESS_KEY = prop.getProperty("Browserstack_password");
            URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub.browserstack.com/wd/hub";
        }


        public void startDriver() {
            try {
                if(BasicConstants.Browserstack_switch.equals("false"))
                {
                    if(service==null)
                    {
                        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort().withArgument(() -> "--allow-insecure","chromedriver_autodownload"));
                    }
                    service.start();
                }else if(BasicConstants.browserstack_local.equalsIgnoreCase("true") && BasicConstants.Browserstack_switch.equals("true") ){

                    if(l==null)
                    {
                        var.put("key", AUTOMATE_ACCESS_KEY);
                        Timestampidentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER")+"_"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy.HH.MM.ss"));
                        var.put("localIdentifier", Timestampidentifier);

                    }
                    l = new Local();
                    l.start(var);
                }
                setOptions();
                driver.manage().timeouts().pageLoadTimeout(BasicConstants.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(BasicConstants.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
            }
            catch (Exception e) {
                e.printStackTrace();
                SetUp_mWeb.Sc.log("The Scenario has failed and the Driver has failed before Initialization" + e.getMessage());
            }
        }

        @Override
        public void setOptions() throws MalformedURLException {
            if(BasicConstants.Browserstack_switch.equals("true"))
            {
                DesiredCapabilities caps = new DesiredCapabilities();
                //For Browserstack
                caps.setCapability("os_version", BasicConstants.os_version_mobile);
                caps.setCapability("device", BasicConstants.Mobile_device);
                caps.setCapability("build", System.getenv("BROWSERSTACK_BUILD_NAME"));
                caps.setCapability("name", SetUp_mWeb.ScenarioName);
                caps.setCapability("real_mobile", "true");
                caps.setCapability("browserstack.console", "errors");
                caps.setCapability("browserstack.networkLogs", "true");
                caps.setCapability("browser", BasicConstants.Browser_mobile);
                caps.setCapability("browserstack.networkProfile", "4g-lte-good");
                caps.setCapability("browserstack.local", BasicConstants.browserstack_local);
                caps.setCapability("browserstack.localIdentifier", Timestampidentifier);
                try{
                    driver =new AppiumDriver(new URL(URL), caps);
                }catch(Exception e)
                {
                    e.printStackTrace();
                    SetUp_mWeb.Sc.log("The Scenario has failed at Driver initialization" + e.getMessage());
                }


            }else{
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, BasicConstants.Mobile_device_android);;
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
                capabilities.setCapability(MobileCapabilityType.BROWSER_NAME , BasicConstants.Browser_mobile_android);

                try{
                    driver = new AndroidDriver(AndroidMobileWeb.service.getUrl(), capabilities);
                    driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 100);
                }catch(Exception e)
                {
                    e.printStackTrace();
                    SetUp_mWeb.Sc.log("The Scenario has failed at Driver initialization" + e.getMessage());
                }

            }

        }

        // To stop the driver
        public void stopDriver() throws Exception {
            try {
                driver.quit();

                if(BasicConstants.Browserstack_switch.equalsIgnoreCase("false"))
                {
                    service.stop();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } finally {
                driver = null;
                if (BasicConstants.browserstack_local.equalsIgnoreCase("true") && BasicConstants.Browserstack_switch.equals("true"))
                {
                    l.stop();
                }

            }
        }
        public AppiumDriver get() {

            if (null == driver)
            {
                this.startDriver();
            }
            return driver;
        }

    }
    class AndroidNative implements  ANDROIDDriver{

        public static String AUTOMATE_USERNAME = null;
        public static String AUTOMATE_ACCESS_KEY = null;
        public static String URL = null;
        private  Local l;
        private String Timestampidentifier = null;
        private HashMap var = new HashMap<String, String>();
        public AppiumDriver driver ;
        public static AppiumDriverLocalService service=null;
        public static Properties prop =null;
        public  AndroidNative() {
            prop = EnvUtil.getProperties();
            AUTOMATE_USERNAME = prop.getProperty("Browserstack_username");
            AUTOMATE_ACCESS_KEY = prop.getProperty("Browserstack_password");
            URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub.browserstack.com/wd/hub";
        }


        public void startDriver() {
            try {
                if(BasicConstants.Browserstack_switch.equals("false"))
                {
                    if(service==null)
                    {
                        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort().withArgument(() -> "--allow-insecure","chromedriver_autodownload"));
                    }
                    service.start();
                }else if(BasicConstants.browserstack_local.equalsIgnoreCase("true") && BasicConstants.Browserstack_switch.equals("true") ){
                    if(l==null)
                    {
                        var.put("key", AUTOMATE_ACCESS_KEY);
                        Timestampidentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER")+"_"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy.HH.MM.ss"));
                        var.put("localIdentifier", Timestampidentifier);

                    }
                    l = new Local();
                    l.start(var);
                }
                setOptions();
                //driver.manage().timeouts().pageLoadTimeout(BasicConstants.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(BasicConstants.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
            }
            catch (Exception e) {
                e.printStackTrace();
                SetUp_Native.Sc.log("The Scenario has failed before Driver Initialization" + e.getMessage());
            }
        }

        @Override
        public void setOptions() throws MalformedURLException {

            if(BasicConstants.Browserstack_switch.equals("true")) {
                DesiredCapabilities caps = new DesiredCapabilities();

                //For Browserstack
                caps.setCapability("os_version", BasicConstants.os_version_mobile);
                caps.setCapability("device", BasicConstants.Mobile_device);
                caps.setCapability("build", System.getenv("BROWSERSTACK_BUILD_NAME"));
                caps.setCapability("name", SetUp_Native.ScenarioName);
                caps.setCapability("real_mobile", "true");
                caps.setCapability("browserstack.console", "errors");
                caps.setCapability("browserstack.networkLogs", "true");
                caps.setCapability("app", prop.getProperty("Browserstack_Android_APP_Hashcode"));
                caps.setCapability("browserstack.idleTimeout", "120");
                caps.setCapability("browserstack.networkProfile", "4g-lte-good");
                caps.setCapability("browserstack.local", BasicConstants.browserstack_local);
                caps.setCapability("autoGrantPermissions", "true");
                caps.setCapability("browserstack.localIdentifier", Timestampidentifier);
                caps.setCapability("browserstack.appium_version", "1.22.0");

                try{

                    driver =new AppiumDriver(new URL(URL), caps);
                }catch(Exception e)
                {
                    e.printStackTrace();
                    SetUp_Native.Sc.log("The Scenario has failed at Driver initialization" + e.getMessage());
                }

            }else{
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, BasicConstants.Mobile_device_android);
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
                capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") +"/src/test/resources/Installables/"+System.getProperty("Env")+"/"+prop.getProperty("Mobile_app_name_android"));
                capabilities.setCapability("appPackage",BasicConstants.AppPackage);
                //capabilities.setCapability("appWaitActivity",BasicConstants.AppWaitActivity);
                capabilities.setCapability(MobileCapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
               // capabilities.setCapability("autoGrantPermissions", true);
                capabilities.setCapability("locationServiceAuthorized", true);
                try{
                    driver = new AndroidDriver(AndroidNative.service.getUrl(), capabilities);
                    driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 100);
                }catch(Exception e)
                {
                    e.printStackTrace();
                    SetUp_Native.Sc.log("The Scenario has failed at Driver initialization" + e.getMessage());
                }


            }

        }

        // To stop the driver
        public void stopDriver() throws Exception {
            try {
                driver.quit();

                if(BasicConstants.Browserstack_switch.equalsIgnoreCase("false"))
                {
                    service.stop();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } finally {
                driver = null;
                if (BasicConstants.browserstack_local.equalsIgnoreCase("true") && BasicConstants.Browserstack_switch.equals("true"))
                {
                    l.stop();
                }

            }
        }
        public AppiumDriver get() {

            if (null == driver)
            {
                this.startDriver();
            }
            return driver;
        }
    }*/
}
