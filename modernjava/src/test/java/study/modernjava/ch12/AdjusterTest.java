package study.modernjava.ch12;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

public class AdjusterTest {

    @Test
    void testWithAttribute() {
        LocalDate date = LocalDate.of(2021, 7, 5);  // 2021-07-05
        LocalDate date1 = date.withYear(2000);  // 2000-07-05
        LocalDate date2 = date1.withMonth(2);  // 2000-02-05
        LocalDate date3 = date2.with(ChronoField.DAY_OF_MONTH, 20);  // 2000-02-20

        System.out.println(date);
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);
    }

    @Test
    void testPlusMinus() {
        LocalDateTime dt = LocalDateTime.parse("2021-07-05T03:05:20");
        LocalDateTime dt1 = dt.plusWeeks(1);  // 2021-07-12T03:05:20
        LocalDateTime dt2 = dt1.minusYears(2);  // 2019-07-12T03:05:20
        LocalDateTime dt3 = dt2.plus(13, ChronoUnit.MONTHS);  // 2020-08-12T03:05:20

        System.out.println(dt);
        System.out.println(dt1);
        System.out.println(dt2);
        System.out.println(dt3);
    }

    @Test
    void testTemporalAdjusters() {
        LocalDate date = LocalDate.of(2021, 7, 5);
        LocalDate date1 = date.with(nextOrSame(DayOfWeek.SUNDAY));  // 2021-07-11
        LocalDate date2 = date1.with(lastDayOfMonth());  // 2021-07-31
        System.out.println(date1);
        System.out.println(date2);
    }
}
