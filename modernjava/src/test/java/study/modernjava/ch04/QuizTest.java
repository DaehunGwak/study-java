package study.modernjava.ch04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.modernjava.Dish;
import study.modernjava.DishExampleBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class QuizTest {

    List<Dish> menu;

    @BeforeEach
    void setUp() {
        menu = DishExampleBuilder.buildMenu();
    }

    @Test
    void quiz4_1() {
        List<String> highCaloricDishes = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(highCaloricDishes);
    }
}
