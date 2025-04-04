package com.mpanov.diploma.utils;

public class NullUtils {

    public static String coalesce(String... strings) {
        for (String string : strings) {
            if (string != null) {
                return string;
            }
        }
        return null;
    }

    private NullUtils() {}

}
