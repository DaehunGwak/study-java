package study.modernjava.ch06;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.modernjava.CaloricLevel;
import study.modernjava.Dish;
import study.modernjava.DishExampleBuilder;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class GroupingTest {

    List<Dish> menu = DishExampleBuilder.buildMenu();

    @Test
    void testGroupingByDefault() {
        Map<Dish.Type, List<Dish>> dishesByType =
                menu.stream().collect(groupingBy(Dish::getType));
    }

    @Test
    void testGroupingByCollectorArgument() {
        Map<Dish.Type, List<Dish>> caloricDishesByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                filtering(dish -> dish.getCalories() > 500, toList())));
    }

    @Test
    void testGroupingByMultiLevel() {
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream().collect(
                groupingBy(Dish::getType,
                        groupingBy(dish -> {
                            if (dish.getCalories() <= 400)
                                return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700)
                                return CaloricLevel.NORMAL;
                            else
                                return CaloricLevel.FAT;
                        }))
        );
    }
}
