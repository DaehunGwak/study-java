package study.modernjava.ch04;

import org.junit.jupiter.api.Test;
import study.modernjava.Dish;
import study.modernjava.DishExampleBuilder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DishExampleBuilderTest {

    @Test
    void testBuildList() {
        List<Dish> dishes = DishExampleBuilder.buildMenu();
        System.out.println(dishes);
        assertTrue(dishes.size() > 5);
    }

}