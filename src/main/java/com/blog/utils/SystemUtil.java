package com.blog.utils;

public class SystemUtil {
    public static String nullToBlank(String value) {
        if (value == null) {
            return "";
        }
        return value;
    }
}
