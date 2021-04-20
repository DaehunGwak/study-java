package ch02.item06;

import java.util.regex.Pattern;

public class RomanNumerals {

    // 6-1, 패턴 리터럴이 매번 생성되고 있음
    static boolean isRomanNumeralSlow(String s) {
        // String.matches 내부적으로 Pattern.matches를 사용하는데
        // 이때 Pattern 생성 시, 유한 상태머신을 만들어 객체 생성 비용이 높음
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    // 6-2, 패턴 리터럴 재사용
    // 먼저 유한 상태머신 미리 만들기
    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
            + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    // 만들어진 상태머신 재활용
    static boolean isRomanNumeralFast(String s) {
        return ROMAN.matcher(s).matches();
    }

    /**
     * 실행 결과 리포트
     * - 각 결과는 numReps 할때마다 경과를 찍은 것임 (각 set을 말함)
     *
     * 테스트 아규먼트 값
     * - numSets: 10
     * - numReps: 100_000
     *
     * 1) isRomanNumeralSlow
     * 378743 μs.
     * 139601 μs.
     * 137092 μs.
     * 136215 μs.
     * 159714 μs.
     * 144093 μs.
     * 142872 μs.
     * 174976 μs.
     * 144932 μs.
     * 135001 μs.
     *
     * 2) isRomanNumeralFast
     * 92944 μs.
     * 41099 μs.
     * 40150 μs.
     * 39686 μs.
     * 35264 μs.
     * 35464 μs.
     * 35246 μs.
     * 34525 μs.
     * 28893 μs.
     * 22735 μs.
     */
    public static void main(String[] args) {
        int numSets = Integer.parseInt(args[0]);
        int numReps = Integer.parseInt(args[1]);
        boolean b = false;

        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < numReps; j++) {
                b ^= isRomanNumeralSlow("MCMLXXVI");
//                b ^= isRomanNumeralFast("MCMLXXVI");
            }
            long end = System.nanoTime();
            System.out.println((end - start) / 1_000 + " μs.");
        }

        // VM 최적화 못하도록 막는 코드
        if (!b) {
            System.out.println();
        }
    }
}
