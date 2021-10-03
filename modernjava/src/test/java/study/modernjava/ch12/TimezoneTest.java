package study.modernjava.ch12;

import org.junit.jupiter.api.Test;

import java.time.*;

public class TimezoneTest {

    @Test
    void testTimezone() {
        ZoneId koreaZone = ZoneId.of("Asia/Seoul");
        LocalDateTime dateTime = LocalDateTime.of(2021, Month.JULY, 5, 3, 5, 20);
        ZonedDateTime zdt = dateTime.atZone(koreaZone);  // 2021-07-05T03:05:20+09:00[Asia/Seoul]
        Instant instant = zdt.toInstant();
    }

    @Test
    void testOffset() {
        ZoneOffset zoneOffset = ZoneOffset.of("+09:00");
        LocalDateTime dateTime = LocalDateTime.of(2021, Month.JULY, 5, 3, 5, 20);
        OffsetDateTime offsetDateTime = OffsetDateTime.of(dateTime, zoneOffset);  // 2021-07-05T03:05:20+09:00
        System.out.println(offsetDateTime);
    }
}
