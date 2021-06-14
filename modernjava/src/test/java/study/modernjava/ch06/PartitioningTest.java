package study.modernjava.ch06;

import org.junit.jupiter.api.Test;
import study.modernjava.Dish;
import study.modernjava.DishExampleBuilder;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.partitioningBy;

public class PartitioningTest {

    List<Dish> menu = DishExampleBuilder.buildMenu();

    @Test
    void testPartitioningDefault() {
        Map<Boolean, List<Dish>> partitionedMenu =
                menu.stream().collect(partitioningBy(Dish::isVegetarian));
        List<Dish> vegetarianDishes = partitionedMenu.get(true);
    }
}
