package study.modernjava.ch07;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreamTest {

    static final long N = 10_000_000;

    @RepeatedTest(100)
    void testRangedParallelSum() {
        System.out.println(rangedParallelSum(N));
    }

    @RepeatedTest(100)
    void testRangedSequentialSum() {
        System.out.println(rangedSequentialSum(N));
    }

    @RepeatedTest(100)
    void testParallelSum() {
//        System.out.println(
//                Runtime.getRuntime().availableProcessors()
//        );
        System.out.println(parallelSum(N));
    }

    @RepeatedTest(100)
    void testSequentialSum() {
        System.out.println(sequentialSum(N));
    }

    @RepeatedTest(100)
    void testIterativeSum() {
        System.out.println(iterativeSum(N));
    }

    public long rangedParallelSum(long n) {
        return LongStream.rangeClosed(1L, n)
                .parallel()
                .sum();
    }

    public long rangedSequentialSum(long n) {
        return LongStream.rangeClosed(1L, n).sum();
    }

    public long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public long iterativeSum(long n) {
        long result = 0;
        for (long i = 1; i <= n; i++)
            result += i;
        return result;
    }

    @RepeatedTest(100)
    void testSideEffectSum() {
        System.out.println(sideEffectSum(N)); // 다 값이 제각각 임을 알 수 있음
    }

    public long sideEffectSum(long n) {
        // 동기화 문제가 있음 : 병렬로 실행시 total 변수 동시 접근
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    public static class Accumulator {
        public long total = 0;
        public void add(long value) {
            total += value;
        }
    }
}
