package ch06.item39.marker;

public class Sample {

    // 성공
    @Test
    public static void m1() {}

    public static void m2() {}

    // 실패
    @Test
    public static void m3() {
        throw new RuntimeException("Boom");
    }

    public static void m4() {}

    // static 이 아니라 잘못 사용된 예
    @Test
    public void m5() {}

    public static void m6() {}

    // 실패
    @Test
    public static void m7() {
        throw new RuntimeException("Crash");
    }

    public static void m8() {}
}
