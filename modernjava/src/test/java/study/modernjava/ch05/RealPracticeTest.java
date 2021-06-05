package study.modernjava.ch05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 5.6 실전 연습
 */
public class RealPracticeTest {

    List<Transaction> transactions;

    @BeforeEach
    void setUp() {
        transactions = TransactionExampleBuilder.build();
    }

    @Test
    @DisplayName("1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오")
    void test1() {
        List<Transaction> t2021 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(t2021);
    }

    @Test
    @DisplayName("2. 거래자가 근무하는 모든 도시를 중복없이 나열하시오")
    void test2() {
        List<String> cities = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(cities);
    }

    @Test
    @DisplayName("3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오")
    void test3() {
        System.out.println(
                transactions.stream()
                        .map(Transaction::getTrader)
                        .distinct()
                        .filter(t -> t.getCity().equals("Cambridge"))
                        .map(Trader::getName)
                        .sorted()
                        .collect(Collectors.toList())
        );
    }

    @Test
    @DisplayName("4. 모든 거래자의 이름을 알파벳순으 정렬해서 반환하시오")
    void test4() {
        System.out.println(
                transactions.stream()
                        .map(Transaction::getTrader)
                        .distinct()
                        .map(Trader::getName)
                        .sorted()
                        .collect(Collectors.toList())

        );
    }

    @Test
    @DisplayName("5. 밀라노에 거래자가 있는가?")
    void test5() {
        System.out.println(
                transactions.stream()
                        .map(Transaction::getTrader)
                        .map(Trader::getCity)
                        .anyMatch(city -> city.equals("Milan"))
        );
    }

    @Test
    @DisplayName("6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오.")
    void test6() {
        List<Transaction> cambridge = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .collect(Collectors.toList());
        System.out.println(cambridge);
    }

    @Test
    @DisplayName("7. 전체 트랜잭션 중 최댓값은 얼마인가?")
    void test7() {
        Optional<Integer> reduce = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(reduce.orElse(-1));
    }

    @Test
    @DisplayName("8. 전체 트랜잭션 중 최솟값은 얼마인가")
    void test8() {
        Optional<Integer> reduce = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);
        System.out.println(reduce.orElse(-1));
    }
}
