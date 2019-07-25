/**
 * Copyright (C) Lundegaard a.s. 2019 - All Rights Reserved
 *
 * Proprietary and confidential. Unauthorized copying of this file, via any
 * medium is strictly prohibited.
 */
package eu.lundegaard.commons.util

import spock.lang.Specification

import java.sql.Timestamp
import java.time.*

import static eu.lundegaard.commons.util.DateUtil.*

/**
 * @author Ales Rybak(ales.rybak@lundegaard.eu)
 */
class DateUtilTest extends Specification {

    public static final ZoneId DEFAULT_ZONE = ZoneId.systemDefault()
    public static final Locale CZECH_LOCALE = new Locale("cs", "CZ")

    def "Converts LocalDate to Date"() {
        given:
        LocalDate originalLocalDate = LocalDate.now();

        when:
        Date result = toDate(originalLocalDate)

        then:
        toInstant(originalLocalDate) == toInstant(result)
    }

    def "Converts LocalDate to Date with zone"() {
        given:
        LocalDate originalLocalDate = LocalDate.now(zoneId);

        when:
        Date result = toDate(originalLocalDate, zoneId)

        then:
        toInstant(originalLocalDate, zoneId) == toInstant(result)

        where:
        zoneId                       | _
        ZoneId.of("Europe/Prague")   | _
        ZoneId.of("UTC")             | _
        ZoneId.of("America/Yakutat") | _
        ZoneId.of("Asia/Qyzylorda")  | _
    }

    def "Converts LocalDateTime to Date"() {
        given:
        // we explicitly set nano to round number because converting to Date loses precision
        LocalDateTime originalLocalDateTime = LocalDateTime.now().withNano(123_000_000)

        when:
        Date result = toDate(originalLocalDateTime)

        then:
        toLocalDateTime(result) == originalLocalDateTime
    }

    def "Converts LocalDateTime to Date with zone"() {
        given:
        // we explicitly set nano to round number because converting to Date loses precision
        LocalDateTime originalLocalDateTime = LocalDateTime.now(zoneId).withNano(123_000_000)

        when:
        Date result = toDate(originalLocalDateTime, zoneId)

        then:
        toLocalDateTime(result, zoneId) == originalLocalDateTime

        where:
        zoneId                       | _
        ZoneId.of("Europe/Prague")   | _
        ZoneId.of("UTC")             | _
        ZoneId.of("America/Yakutat") | _
        ZoneId.of("Asia/Qyzylorda")  | _
    }

    def "Converts Timestamp to Date"() {
        given:
        // we explicitly set nano to round number because converting to Date loses precision
        LocalDateTime originalLocalDateTime = LocalDateTime.now().withNano(123_000_000)
        Timestamp timestamp = Timestamp.valueOf(originalLocalDateTime)

        when:
        Date result = toDate(timestamp)

        then:
        toLocalDateTime(result) == originalLocalDateTime
    }

    def "Converts Date to LocalDateTime"() {
        given:
        Date originalDate = new Date();

        when:
        LocalDateTime result = toLocalDateTime(originalDate)

        then:
        toDate(result) == originalDate
    }

    def "Converts Date to LocalDateTime with zone"() {
        given:
        Date originalDate = new Date();

        when:
        LocalDateTime result = toLocalDateTime(originalDate, zoneId)

        then:
        toDate(result, zoneId) == originalDate

        where:
        zoneId                       | _
        ZoneId.of("Europe/Prague")   | _
        ZoneId.of("UTC")             | _
        ZoneId.of("America/Yakutat") | _
        ZoneId.of("Asia/Qyzylorda")  | _
    }

    def "Converts Date to LocalDate"() {
        given:
        Date originalDate = Date.from(LocalDate.now().atTime(0, 0).atZone(DEFAULT_ZONE).toInstant())

        when:
        LocalDate result = toLocalDate(originalDate)

        then:
        toDate(result) == originalDate
    }

    def "Converts Date to LocalDate with zone"() {
        given:
        Date originalDate = Date.from(LocalDate.now().atTime(0, 0).atZone(zoneId).toInstant());

        when:
        LocalDate result = toLocalDate(originalDate, zoneId);

        then:
        toInstant(originalDate) == toInstant(result, zoneId)

        where:
        zoneId                       | _
        ZoneId.of("Europe/Prague")   | _
        ZoneId.of("UTC")             | _
        ZoneId.of("America/Yakutat") | _
        ZoneId.of("Asia/Qyzylorda")  | _
    }

    def "Converts Date to Timestamp"() {
        given:
        Date originalDate = new Date();

        when:
        Timestamp result = toTimestamp(originalDate);

        then:
        toInstant(originalDate) == toInstant(result)
    }

    def "Get end of today"() {
        when:
        LocalDateTime endOfDay = endOfDay()

        then:
        endOfDay == LocalDate.now().atTime(23, 59, 59, 999_999_999)
    }

    def "Get end of given day"(LocalDate input, LocalDateTime result) {
        expect:
        result == endOfDay(input)

        where:
        input                              | result
        LocalDate.now()                    | LocalDate.now().atTime(23, 59, 59, 999_999_999)
        LocalDate.parse("1982-09-20") | LocalDateTime.parse("1982-09-20T23:59:59.999999999")
        null                               | null
    }

    def "Get beginning of current week"() {
        given:
        LocalDate today = LocalDate.now()

        when:
        LocalDate result = beginOfWeek(CZECH_LOCALE)

        then:
        !result.isAfter(today)
        !result.isBefore(today.minusDays(7))
        result.getDayOfWeek() == DayOfWeek.MONDAY
    }

    def "Get beginning of given week"() {
        expect:
        result == beginOfWeek(input, locale)

        where:
        input                         | locale       | result
        null                          | Locale.US    | null
        LocalDate.parse("2016-07-20") | Locale.US    | LocalDate.parse("2016-07-17")
        LocalDate.parse("2016-07-20") | CZECH_LOCALE | LocalDate.parse("2016-07-18")
        LocalDate.parse("2016-07-18") | CZECH_LOCALE | LocalDate.parse("2016-07-18")
        LocalDate.parse("2016-07-24") | CZECH_LOCALE | LocalDate.parse("2016-07-18")
        LocalDate.parse("2016-07-25") | CZECH_LOCALE | LocalDate.parse("2016-07-25")
    }

    def "Get end of current week"() {
        given:
        LocalDate today = LocalDate.now()

        when:
        LocalDate result = endOfWeek(CZECH_LOCALE)

        then:
        !result.isBefore(today)
        !result.isAfter(today.plusDays(7))
        result.getDayOfWeek() == DayOfWeek.SUNDAY
    }

    def "Get end of given week"() {
        expect:
        result == endOfWeek(input, locale)

        where:
        input                         | locale       | result
        null                          | Locale.US    | null
        LocalDate.parse("2016-07-20") | Locale.US    | LocalDate.parse("2016-07-23")
        LocalDate.parse("2016-07-20") | CZECH_LOCALE | LocalDate.parse("2016-07-24")
        LocalDate.parse("2016-07-18") | CZECH_LOCALE | LocalDate.parse("2016-07-24")
        LocalDate.parse("2016-07-24") | CZECH_LOCALE | LocalDate.parse("2016-07-24")
        LocalDate.parse("2016-07-25") | CZECH_LOCALE | LocalDate.parse("2016-07-31")
    }

    def "Get beginning of current month"() {
        given:
        LocalDate today = LocalDate.now()

        when:
        LocalDate result = beginOfMonth()

        then:
        1 == result.getDayOfMonth()
        today.getMonth() == result.getMonth()
        today.getYear() == result.getYear()
    }

    def "Get beginning of given month"() {
        expect:
        result == beginOfMonth(input)

        where:
        input                         | result
        null                          | null
        LocalDate.parse("2016-07-01") | LocalDate.parse("2016-07-01")
        LocalDate.parse("2016-07-20") | LocalDate.parse("2016-07-01")
        LocalDate.parse("2016-07-31") | LocalDate.parse("2016-07-01")
    }

    def "Get end of current month"() {
        given:
        LocalDate today = LocalDate.now()

        when:
        LocalDate result = endOfMonth()

        then:
        today.plusMonths(1).withDayOfMonth(1).minusDays(1).getDayOfMonth() == result.getDayOfMonth()
        today.getMonth() == result.getMonth()
        today.getYear() == result.getYear()
    }

    def "Get end of given month"() {
        expect:
        result == endOfMonth(input)

        where:
        input                         | result
        null                          | null
        LocalDate.parse("2016-07-01") | LocalDate.parse("2016-07-31")
        LocalDate.parse("2016-07-24") | LocalDate.parse("2016-07-31")
        LocalDate.parse("2016-07-31") | LocalDate.parse("2016-07-31")
    }

    def "Get beginning of current year"() {
        given:
        LocalDate today = LocalDate.now()

        when:
        LocalDate result = beginOfYear()

        then:
        1 == result.getDayOfMonth()
        Month.JANUARY == result.getMonth()
        today.getYear() == result.getYear()
        1 == result.getDayOfYear()
    }

    def "Get beginning of given year"() {
        expect:
        result == beginOfYear(input)

        where:
        input                         | result
        null                          | null
        LocalDate.parse("2016-01-01") | LocalDate.parse("2016-01-01")
        LocalDate.parse("2016-07-01") | LocalDate.parse("2016-01-01")
        LocalDate.parse("2016-07-20") | LocalDate.parse("2016-01-01")
        LocalDate.parse("2016-07-31") | LocalDate.parse("2016-01-01")
        LocalDate.parse("2016-12-31") | LocalDate.parse("2016-01-01")
    }

    def "Get end of current year"() {
        given:
        LocalDate today = LocalDate.now()

        when:
        LocalDate result = endOfYear()

        then:
        31 == result.getDayOfMonth()
        Month.DECEMBER == result.getMonth()
        today.getYear() == result.getYear()
        365 == result.getDayOfYear() || 366 == result.getDayOfYear()
    }

    def "Get end of given year"() {
        expect:
        result == endOfYear(input)

        where:
        input                         | result
        null                          | null
        LocalDate.parse("2016-01-01") | LocalDate.parse("2016-12-31")
        LocalDate.parse("2016-07-01") | LocalDate.parse("2016-12-31")
        LocalDate.parse("2016-07-24") | LocalDate.parse("2016-12-31")
        LocalDate.parse("2016-07-31") | LocalDate.parse("2016-12-31")
        LocalDate.parse("2016-12-31") | LocalDate.parse("2016-12-31")
    }
}
