package study.modernjava.ch05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.modernjava.Dish;
import study.modernjava.DishExampleBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class SlicingTest {

    List<Dish> specialMenu;

    @BeforeEach
    void setUp() {
        specialMenu = DishExampleBuilder.buildSpecialMenu();
    }

    @Test
    void testTakeWhile() {
        List<Dish> dishes = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());
        System.out.println(dishes); // season fruit, prawns
    }

    @Test
    void testDropWhile() {
        List<Dish> dishes = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());
        System.out.println(dishes); // rice, chicken, french fries
    }

    @Test
    void testLimit() {
        List<Dish> dishes = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(dishes);
    }

    @Test
    void testSkip() {
        List<Dish> dishes = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(dishes);
    }
}
