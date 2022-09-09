package com.Automation.driver;

import io.appium.java_client.AppiumDriver;

public class MobileWebNative {

    public static IMobDriver DriverService = null;
    private static Mobiles MobilesDriver;
    private static AppiumDriver driver = null;

   /* // To set the browser type through a Singleton Methodology
    public static void setAppType(String BrowserType) throws Exception {

        MobilesDriver = Mobiles.get(BrowserType);
        System.out.println("Driver to be set is: "+MobilesDriver);
      *//*  if (null == DriverService) {
            switch (MobilesDriver) {

                case ANDROID_WEB:
                    DriverService = new ANDROIDDriver.AndroidMobileWeb();
                    break;

                case ANDROID_NATIVE:
                    DriverService = new ANDROIDDriver.AndroidNative();
                    break;

                case IOS_NATIVE:
                    DriverService   =   new IOSDriver.iOSNative();
                    break;
                default:
                    break;
            }*//*
        }


        driver= DriverService.get();
    }*/
    public static AppiumDriver getDriver()
    {
        return driver;
    }


    // To stop the driver
    public static void Quit() throws Exception {
        DriverService.stopDriver();
    }

}
