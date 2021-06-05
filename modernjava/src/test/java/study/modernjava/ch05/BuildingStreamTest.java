package study.modernjava.ch05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuildingStreamTest {

    @Test
    @DisplayName("ofNullable을 이용한 스트림 만들기")
    void testOfNullable() {
//        System.out.println(System.getProperties());
        Stream<String> propertiesStream = Stream.ofNullable(System.getProperty("os.name"));
        System.out.println(propertiesStream.collect(Collectors.joining()));

        // home 은 empty 스트리이 만들어짐
        Stream<String> valueStreams = Stream.of("os.name", "home", "java.version")
                .flatMap(key -> Stream.ofNullable(System.getProperty(key)));
        System.out.println(valueStreams.collect(Collectors.joining()));
    }

    @Test
    @DisplayName("무한 스트림 iterate")
    void testIterate() {
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
    }
}
