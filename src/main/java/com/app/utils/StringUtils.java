package com.app.utils;


public class StringUtils {
    public static String removeSpecialCharsFromString(String inputString) {
        return inputString.replaceAll("[–-]", "").replaceAll("[^a-zA-Z0-9]", "");
    }
}
