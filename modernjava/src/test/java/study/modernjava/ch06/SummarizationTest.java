package study.modernjava.ch06;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.modernjava.Dish;
import study.modernjava.DishExampleBuilder;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class SummarizationTest {

    List<Dish> menu = DishExampleBuilder.buildMenu();

    @Test
    @DisplayName("카운트")
    void testCounting() {
        long howManyDishes = menu.stream().collect(counting());
        long howManyDishes2 = menu.stream().count();
        long howManyDishes3 = menu.size();
    }

    @Test
    @DisplayName("최대, 최소")
    void testMinByMaxBy() {
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu.stream().collect(maxBy(dishComparator));
        Optional<Dish> mostCalorieDish2 = menu.stream().max(dishComparator);
    }

    @Test
    @DisplayName("합")
    void testSumming() {
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        int totalCalories2 = menu.stream().mapToInt(Dish::getCalories).sum();
    }

    @Test
    @DisplayName("평균")
    void testAveraging() {
        double aver = menu.stream().collect(averagingInt(Dish::getCalories));
    }

    @Test
    @DisplayName("통계 요약")
    void testSummaryStatistics() {
        IntSummaryStatistics summary = menu.stream().collect(summarizingInt(Dish::getCalories));
    }

    @Test
    @DisplayName("문자열 합치기")
    void testJoining() {
        String names = menu.stream().map(Dish::getName).collect(joining(", "));
    }
}
