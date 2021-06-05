package study.modernjava.ch05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.modernjava.Dish;
import study.modernjava.DishExampleBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MappingTest {

    List<Dish> menu;

    @BeforeEach
    void setUp() {
        menu = DishExampleBuilder.buildMenu();
    }

    @Test
    void testMap() {
        List<Integer> dishNameLengths = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(dishNameLengths);
    }

    @Test
    void testFlatMap() {
        List<String> words = Arrays.asList("Goodbye", "World");
        List<String> uniqueCharacters = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueCharacters);
    }
}
