package com.Automation.driver;


public enum Browsers {

    EDGE,
    FIREFOX,
    CHROME,
    SAFARI,
    BROWSERSTACK,
    BROWSERSTACK_MWEB,
    NEXUS,
    TOSHIBA,
    IPHONE,
    IPAD,
    OTHER;

    //Get the Enum
    public static Browsers get(String s) {
        return Browsers.valueOf(s.trim().toUpperCase());
    }
}
