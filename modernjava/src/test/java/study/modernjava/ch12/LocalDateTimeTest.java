package study.modernjava.ch12;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoField;

public class LocalDateTimeTest {

    @Test
    void testLocalDate() {
        LocalDate now = LocalDate.now();  // 오늘 일자

        LocalDate date = LocalDate.of(2021, 7, 4);  // 2021-07-04
        int year = date.getYear();  // 2021
        Month month = date.getMonth();  // JULY
        int dayOfMonth = date.getDayOfMonth();  // 4
        DayOfWeek dayOfWeek = date.getDayOfWeek();  // SUNDAY
        int length = date.lengthOfMonth();  // 31 (해당 달의 일 수)
        boolean leapYear = date.isLeapYear();  // false (윤년 체크)

        System.out.println(now);

        System.out.println(date);
        System.out.println(year);
        System.out.println(month);
        System.out.println(dayOfMonth);
        System.out.println(dayOfWeek);
        System.out.println(length);
        System.out.println(leapYear);
    }

    @Test
    void testLocalDateUsingTemporalField() {
        LocalDate now = LocalDate.now();
        int year = now.get(ChronoField.YEAR);
        int month = now.get(ChronoField.MONTH_OF_YEAR);
        int day = now.get(ChronoField.DAY_OF_MONTH);

        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
    }

    @Test
    void testLocalTime() {
        LocalTime time = LocalTime.of(13, 45, 20);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
    }

    @Test
    void testParse() {
        LocalDate date = LocalDate.parse("2021-07-04");
        LocalTime time = LocalTime.parse("15:00:32");
        System.out.println(date);
        System.out.println(time);
    }

    @Test
    void testLocalDateTime() {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        LocalDateTime dt0 = LocalDateTime.parse("2021-07-04T15:00:32");  // ISO-8601
        LocalDateTime dt1 = LocalDateTime.of(2021, Month.JULY, 4, 15, 0, 32);
        LocalDateTime dt2 = date.atTime(time);
        LocalDateTime dt3 = time.atDate(date);

        System.out.println(dt0);
        System.out.println(dt1);
        System.out.println(dt2);
        System.out.println(dt3);

        LocalDate localDate = dt1.toLocalDate();
        LocalTime localTime = dt1.toLocalTime();
    }

    @Test
    void testInstant() {
        // 1970-01-01T00:00:02Z
        Instant epochSecond = Instant.ofEpochSecond(2);
        System.out.println(epochSecond);

        // 1970-01-01T00:00:02.100Z
        Instant epochSecond2 = Instant.ofEpochSecond(2, 100_000_000);
        System.out.println(epochSecond2);
    }

}
