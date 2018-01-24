package com.epam.training.transport.utils;

import java.util.Formatter;

public class TimeFormatter {

    private TimeFormatter() {
        throw new IllegalStateException("Utility class");
    }

    public static String format(int departureTime) {
        Formatter formatter = new Formatter();
        String time = formatter.format("%02d:%02d", departureTime / 60, departureTime % 60)
                .toString();
        formatter.close();
        return time;
    }

    public static int format(final String departureTime) {
        String[] strings =
                departureTime.trim()
                        .split(":");
        return Integer.valueOf(strings[0]) * 60 + Integer.valueOf(strings[1]);
    }
}
