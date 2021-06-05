package study.modernjava.ch05;

import org.junit.jupiter.api.BeforeEach;
import study.modernjava.Dish;
import study.modernjava.DishExampleBuilder;

import java.util.List;

public class NumberStreamTest {

    List<Dish> menu;

    @BeforeEach
    void setUp() {
        menu = DishExampleBuilder.buildMenu();
    }

}
