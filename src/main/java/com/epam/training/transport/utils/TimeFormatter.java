package com.epam.training.transport.utils;

import java.util.Formatter;

public class TimeFormatter {

    public static String format(int departureTime) {
        Formatter formatter = new Formatter();
        return formatter.format("%02d:%02d", departureTime / 60, departureTime % 60)
            .toString();
    }

    public static int format(final String departureTime) {
        String[] strings =
            departureTime.trim()
                .split(":");
        return Integer.valueOf(strings[0]) * 60 + Integer.valueOf(strings[1]);
    }
}
