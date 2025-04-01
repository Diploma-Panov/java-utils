package com.mpanov.diploma.utils;

import java.security.SecureRandom;

public class RandomUtils {

    private static final SecureRandom R = new SecureRandom();

    private static final String LOWER_ALPHABET = "abcdefghijklmnopqrsuvwxyz";

    private static final String UPPER_ALPHABET = LOWER_ALPHABET.toUpperCase();

    private static final String NUMERIC_ALPHABET = "0123456789";

    private static final String ALPHABETICAL_COMBINED = LOWER_ALPHABET + UPPER_ALPHABET;

    private static final String ALPHANUMERICAL = ALPHABETICAL_COMBINED + NUMERIC_ALPHABET;

    public static String generateRandomAlphabeticalString(int length) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            b.append(ALPHABETICAL_COMBINED.charAt(R.nextInt(ALPHABETICAL_COMBINED.length())));
        }
        return b.toString();
    }

    public static String generateRandomNumericString(int length) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            b.append(NUMERIC_ALPHABET.charAt(R.nextInt(NUMERIC_ALPHABET.length())));
        }
        return b.toString();
    }

    public static String generateRandomAlphanumericString(int length) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            b.append(ALPHANUMERICAL.charAt(R.nextInt(ALPHANUMERICAL.length())));
        }
        return b.toString();
    }

    private RandomUtils() {}

}
