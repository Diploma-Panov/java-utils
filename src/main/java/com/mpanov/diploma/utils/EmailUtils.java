package com.mpanov.diploma.utils;

import org.apache.commons.lang3.StringUtils;

public class EmailUtils {

    public static String normalizeEmail(String email) {
        if (StringUtils.isBlank(email)) {
            return null;
        }
        return email.trim().toLowerCase();
    }

    private EmailUtils() {}

}
