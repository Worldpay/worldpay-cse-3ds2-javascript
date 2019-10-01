package com.worldpay.poc.dragonspay.util;

import com.worldpay.poc.dragonspay.model.Date;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class DateTimeUtils {

    private static int dateInstanceCounter = 0;

    public static Date generateNextDate() {

        LocalDate today = LocalDate.now().plusDays(dateInstanceCounter).plusYears(dateInstanceCounter);
        Date date = new Date();
        date.setDayOfMonth(String.valueOf(today.getDayOfMonth()));
        date.setMonth(String.valueOf(today.getMonthValue()));
        date.setYear(today.getYear());
        dateInstanceCounter++;
        return date;
    }

    public static Long getTimeInMillisFrom(String timeSource) {

        String[] tokens = timeSource.split(":");
        int hours = Integer.parseInt(tokens[0]);
        int minutes = Integer.parseInt(tokens[1]);
        int seconds = Integer.parseInt(tokens[2]);

        int time = seconds + 60 * minutes + 3600 * hours;

        return TimeUnit.MILLISECONDS.convert(time, TimeUnit.SECONDS);
    }
}
