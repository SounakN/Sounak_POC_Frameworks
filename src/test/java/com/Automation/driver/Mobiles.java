package com.Automation.driver;

public enum Mobiles {
    ANDROID_WEB,
    IOS_WEB,
    BROWSERSTACK_MWEB,
    ANDROID_NATIVE,
    BROWSERSTACK_NATIVE, IOS_NATIVE;

    //Get the Enum
    public static Mobiles get(String s) {
        return Mobiles.valueOf(s.trim().toUpperCase());
    }
}
