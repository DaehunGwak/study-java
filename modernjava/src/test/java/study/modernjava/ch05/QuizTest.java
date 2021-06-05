package study.modernjava.ch05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.modernjava.Dish;
import study.modernjava.DishExampleBuilder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuizTest {

    List<Dish> menu;

    @BeforeEach
    void setUp() {
        menu = DishExampleBuilder.buildMenu();
    }

    @Test
    void quiz5_1_filtering() {
        List<Dish> dishes = menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(dishes);
    }

    @Test
    void quiz5_2_mapping_1() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> results = integers.stream()
                .map(i -> i * i)
                .collect(Collectors.toList());
        System.out.println(results);
    }

    @Test
    void quiz5_2_mapping_2() {
        List<Integer> integers1 = Arrays.asList(1, 2, 3);
        List<Integer> integers2 = Arrays.asList(3, 4);
        List<List<Integer>> collect = integers1.stream()
                .flatMap(i -> integers2.stream()
                        .map(j -> Arrays.asList(i, j)))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    void quiz5_2_mapping_3() {
        List<Integer> integers1 = Arrays.asList(1, 2, 3);
        List<Integer> integers2 = Arrays.asList(3, 4);
        List<List<Integer>> collect = integers1.stream()
                .flatMap(i -> integers2.stream()
                        .map(j -> Arrays.asList(i, j)))
                .filter(li -> (li.get(0) + li.get(1)) % 3 == 0)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    void quiz5_2_mapping_3_answer() {
        List<Integer> integers1 = Arrays.asList(1, 2, 3);
        List<Integer> integers2 = Arrays.asList(3, 4);
        List<List<Integer>> collect = integers1.stream()
                .flatMap(i ->
                        integers2.stream()
                                .filter(j -> (i + j) % 3 == 0)
                                .map(j -> Arrays.asList(i, j)))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    void quiz5_3_reduce() {
        int count = menu.stream()
                .map(dish -> 1)
                .reduce(0, Integer::sum);
        System.out.println(count);

        System.out.println(menu.stream().count());
        System.out.println(menu.size());
    }

    @Test
    @DisplayName("피보나치수열 집합")
    void quiz5_4_fibonacci() {
        Stream.iterate(new int[]{0, 1}, ints -> new int[]{ints[1], ints[0] + ints[1]})
                .limit(20)
                .forEach(t -> System.out.printf("(%d, %d) ", t[0], t[1]));
    }
}
