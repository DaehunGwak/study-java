package study.modernjava.ch12;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatterTest {

    @Test
    void testDateTimeFormatter() {
        LocalDate date = LocalDate.of(2021, 7, 5);
        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));  // 2021-07-05
        System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));  // 20210705
    }

    @Test
    void testPattern() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.of(2021, 7, 5);
        String formattedDate = date.format(formatter);  // 05/07/2021
        LocalDate parsedFormattedDate = LocalDate.parse(formattedDate, formatter);

        System.out.println(formattedDate);
        System.out.println(parsedFormattedDate);
    }

    @Test
    void testLocale() {
        DateTimeFormatter koreaFormatter = DateTimeFormatter.ofPattern("yyyy MMMM d", Locale.KOREA);
        LocalDate date = LocalDate.of(2021, 7, 5);
        System.out.println(date.format(koreaFormatter));  // 2021 7월 5
    }
}
