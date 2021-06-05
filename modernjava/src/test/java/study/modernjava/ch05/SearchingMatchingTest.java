package study.modernjava.ch05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.modernjava.Dish;
import study.modernjava.DishExampleBuilder;

import java.util.List;
import java.util.Optional;

public class SearchingMatchingTest {

    List<Dish> menu;

    @BeforeEach
    void setUp() {
        menu = DishExampleBuilder.buildMenu();
    }

    @Test
    void testAnyMatch() {
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("채식 친화 적 메뉴...");
        }
    }

    @Test
    void testAllMatch() {
        boolean isHealthy = menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);
        System.out.println(isHealthy);
    }

    @Test
    void testNoneMatch() {
        boolean isHealthy = menu.stream()
                .noneMatch(dish -> dish.getCalories() >= 1000);
        System.out.println(isHealthy);
    }

    @Test
    void testFindAny() {
        Optional<Dish> optionalDish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
        Dish x = optionalDish.orElse(new Dish("null dish", false, 0 , Dish.Type.OTHER));
        System.out.println(x);
    }

}
