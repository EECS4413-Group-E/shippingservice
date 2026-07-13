package com.eecs4413.groupe.shippingservice.util;

import java.security.SecureRandom;

public final class TrackingNumberGenerator {

    private static final String CHARACTERS = "0123456789";
    private static final int LENGTH = 12;

    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generate() {
        StringBuilder stringBuilder = new StringBuilder("TN");

        for (int i = 0; i < LENGTH; i++) {
            int randomIndex = RANDOM.nextInt(CHARACTERS.length());
            stringBuilder.append(CHARACTERS.charAt(randomIndex));
        }

        return stringBuilder.toString();
    }

}