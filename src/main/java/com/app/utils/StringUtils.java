package com.app.utils;

import org.springframework.stereotype.Component;


public class StringUtils {
    public static String removeSpecialCharsFromString(String inputString) {
        return inputString.replaceAll("[–-]", "").replaceAll("[^a-zA-Z0-9]", "");
    }
}
