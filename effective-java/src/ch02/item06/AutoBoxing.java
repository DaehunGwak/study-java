package ch02.item06;

public class AutoBoxing {

    private static long getElapsedAutoBoxingSum() {
        long start = System.nanoTime();

        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;  // i가 Long으로 오토박싱 됨
        }

        long end = System.nanoTime();
        return (end - start) / 1_000;
    }

    private static long getElapsedPureSum() {
        long start = System.nanoTime();

        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;  // pure~
        }

        long end = System.nanoTime();
        return (end - start) / 1_000;
    }


    public static void main(String[] args) {
        System.out.println(getElapsedAutoBoxingSum());  // 6903692 μs
        System.out.println(getElapsedPureSum());  // 1042610 μs
    }

}
