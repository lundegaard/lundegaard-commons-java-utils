/*
 * Copyright (C) 2019 Lundegaard a.s., All Rights Reserved
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; version 3.0 of the License.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * https://www.gnu.org/licenses/lgpl-3.0.html
 */
package eu.lundegaard.commons.util;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;

/**
 * Utility class for working with {@link Date}, {@link LocalDate} etc.
 *
 * @author Jiri Kadlec (jiri.kadlec@lundegaard.eu)
 * @author Ales Rybak (ales.rybak@lundegaard.eu)
 */
public final class DateUtil {

    private DateUtil() {
        // private constructor for util class
    }

    public static Date toDate(LocalDate input) {
        return toDate(input, ZoneId.systemDefault());
    }

    public static Date toDate(LocalDate input, ZoneId zone) {
        if (input == null) {
            return null;
        }
        if (zone == null) {
            return null;
        }

        return Date.from(input.atStartOfDay(zone).toInstant());
    }

    public static Date toDate(LocalDateTime input) {
        return toDate(input, ZoneId.systemDefault());
    }

    public static Date toDate(LocalDateTime input, ZoneId zone) {
        if (input == null) {
            return null;
        }
        if (zone == null) {
            return null;
        }

        return Date.from(input.atZone(zone).toInstant());
    }

    public static Date toDate(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }

        return new Date(timestamp.getTime());
    }

    public static LocalDateTime toLocalDateTime(Date input) {
        return toLocalDateTime(input, ZoneId.systemDefault());
    }

    public static LocalDateTime toLocalDateTime(Date input, ZoneId zone) {
        if (input == null) {
            return null;
        }
        if (zone == null) {
            return null;
        }

        return LocalDateTime.ofInstant(input.toInstant(), zone);
    }

    public static LocalDateTime toLocalDateTime(long epochMiliseconds) {
        return Instant.ofEpochMilli(epochMiliseconds).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }


    public static LocalDate toLocalDate(Date input) {
        if (input == null) {
            return null;
        }

        return toLocalDateTime(input, ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDate toLocalDate(Date input, ZoneId zone) {
        if (input == null) {
            return null;
        }
        if (zone == null) {
            return null;
        }

        return toLocalDateTime(input, zone).toLocalDate();
    }

    public static Timestamp toTimestamp(Date date) {
        if (date == null) {
            return null;
        }

        return new Timestamp(date.getTime());
    }

    public static LocalDate toLocalDate(long epochMiliseconds) {
        return Instant.ofEpochMilli(epochMiliseconds).atZone(ZoneId.systemDefault()).toLocalDate();
    }


    public static Instant toInstant(LocalDate input) {
        return toInstant(input, ZoneId.systemDefault());
    }

    public static Instant toInstant(LocalDate input, ZoneId zone) {
        return input.atStartOfDay(zone).toInstant();
    }

    public static Instant toInstant(LocalDateTime input) {
        return toInstant(input, ZoneId.systemDefault());
    }

    public static Instant toInstant(LocalDateTime input, ZoneId zone) {
        return input.atZone(zone).toInstant();
    }

    public static Instant toInstant(Date input) {
        return input.toInstant();
    }

    /**
     * Returns the date-time with time at end of the day.
     *
     * The resulting time will be 23:59:59.999999999
     *
     * @return The date-time with time at end of the day.
     */
    public static LocalDateTime endOfDay() {
        return endOfDay(LocalDate.now());
    }

    public static LocalDateTime endOfDay(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.plusDays(1).atStartOfDay().minusNanos(1);
    }

    public static LocalDate beginOfWeek(Locale locale) {
        return beginOfWeek(LocalDate.now(), locale);
    }

    public static LocalDate beginOfWeek(LocalDate date, Locale locale) {
        if (date == null) {
            return null;
        }
        if (locale == null) {
            throw new IllegalArgumentException("Locale must not be null.");
        }

        TemporalField weekField = WeekFields.of(locale).dayOfWeek();
        return date.with(weekField, 1);
    }

    public static LocalDate endOfWeek(Locale locale) {
        return endOfWeek(LocalDate.now(), locale);
    }

    public static LocalDate endOfWeek(LocalDate date, Locale locale) {
        if (date == null) {
            return null;
        }
        if (locale == null) {
            throw new IllegalArgumentException("Locale must not be null.");
        }
        TemporalField weekField = WeekFields.of(locale).dayOfWeek();
        return date.with(weekField, 7);
    }

    public static LocalDate beginOfMonth() {
        return beginOfMonth(LocalDate.now());
    }

    public static LocalDate beginOfMonth(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.withDayOfMonth(1);
    }

    public static LocalDate endOfMonth() {
        return endOfMonth(LocalDate.now());
    }

    public static LocalDate endOfMonth(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.withDayOfMonth(1).plusMonths(1).minusDays(1);
    }

    public static LocalDate beginOfYear() {
        return beginOfYear(LocalDate.now());
    }

    public static LocalDate beginOfYear(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.withDayOfYear(1);
    }

    public static LocalDate endOfYear() {
        return endOfYear(LocalDate.now());
    }

    public static LocalDate endOfYear(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.withDayOfYear(1).plusYears(1).minusDays(1);
    }

}
