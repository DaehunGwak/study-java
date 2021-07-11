package study.modernjava.ch12;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class DurationPeriodTest {

    @Test
    void testDuration() {
        Duration between = Duration.between(
                LocalDateTime.parse("2021-07-05T00:00:00"),
                LocalDateTime.now());

        System.out.println(between);  // PT4H33M22.604684S
        System.out.println(between.getSeconds());  // 16402
    }

    @Test
    void testPeriod() {
        Period between = Period.between(
                LocalDate.parse("2021-07-05"),
                LocalDate.of(2021, 6, 20));

        System.out.println(between);  // P-15D
        System.out.println(between.getDays());  // -15
    }
}
