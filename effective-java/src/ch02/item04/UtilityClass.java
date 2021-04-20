package ch02.item04;

import java.lang.Math;

public class UtilityClass {

    // 인스턴스화 방지용
    private UtilityClass() {
        System.out.println("try to create object");
        throw new AssertionError();
    }

    /**
     * 아래부턴 테스트 용
     */
    // 인스턴스화 강제로 하는 테스트 용, 원래 없어야 함
    public static UtilityClass createUCForTest() {
        return new UtilityClass();
    }

    public static void main(String[] args) {
        // 에러 발생 테스트
        UtilityClass uc = UtilityClass.createUCForTest();
    }
}
