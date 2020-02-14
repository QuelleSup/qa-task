package com.task.selenium.utils;

import static java.lang.String.format;

public final class CssSelector {

    public static String cssClass(String className) {
        return format(".%s", className);
    }

    public static String id(String id) {
        return format("#%s", id);
    }

    public static String name(String nameValue) {
        return "[name='" + nameValue + "']";
    }

    public static String href(String href) {
        return "[href*='" + href + "']";
    }
}
