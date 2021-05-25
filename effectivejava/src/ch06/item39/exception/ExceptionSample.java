package ch06.item39.exception;

public class ExceptionSample {

    @ExceptionTest(ArithmeticException.class)
    public static void m1() { // 성공해야 함
        int i = 0;
        i = i / i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2() { // 실패해야 함 (다른 예외)
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3() {} // 실패해야 함 (예외가 발생하지 않음)

}
