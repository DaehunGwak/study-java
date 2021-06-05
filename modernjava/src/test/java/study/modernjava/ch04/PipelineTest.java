package study.modernjava.ch04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.modernjava.Dish;
import study.modernjava.DishExampleBuilder;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PipelineTest {

    List<Dish> menu; // 데이터 소스

    @BeforeEach
    void setUp() {
        menu = DishExampleBuilder.buildMenu();
    }

    @Test
    void testPipeline() {
        List<String> threeHighCaloricDishNames =
                menu.stream() // 연속된 스트림
                    .filter(dish -> dish.getCalories() > 300) // 데이터 처리 연산
                    .map(Dish::getName)
                    .limit(3) // 여기까지 모든과정이 파이프라인
                    .collect(Collectors.toList()); // 파이프라인 결과를 리스트로 반환
        System.out.println(threeHighCaloricDishNames);
        assertEquals(threeHighCaloricDishNames.size(), 3);
    }
}
