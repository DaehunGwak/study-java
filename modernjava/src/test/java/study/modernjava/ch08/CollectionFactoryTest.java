package study.modernjava.ch08;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CollectionFactoryTest {

    @Test
    void asList() {
        List<String> strings = Arrays.asList("a", "b");
        System.out.println(strings);
    }

    @Test
    void listOf() {
        List<String> strings = List.of("a", "b");
        System.out.println(strings);
    }

    @Test
    void map1() {
        Map<String, Integer> map = Map.of(
                "a", 30,
                "b", 25);
        System.out.println(map);
    }

    @Test
    void map2() {
        Map<String, Integer> map = Map.ofEntries(
                Map.entry("a", 10),
                Map.entry("b", 25));

        System.out.println(map);
        
    }
}
