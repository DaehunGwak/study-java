package ch05.item32;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class VarargsMain {

    public static void main(String[] args) {
//        printVarargs("123 string", 123, 2.4);

//        dangerous(List.of("hello", "world"), List.of("123", "ab123"));

        System.out.println(pickTwo("좋은", "빠른", "저렴한"));
//        String[] attributes = pickTwo("좋은", "빠른", "저렴한");
        List<String> attributes = pickEnhancedTwo("좋은", "빠른", "저렴한");
        System.out.println(attributes);
    }

    /** 가변인자 예제 */
    private static void printVarargs(Object... objects) {
        for (Object o : objects) {
            System.out.println(o);
        }
    }

    /** 32-1 제네릭과 varargs를 혼용하면 타입 안정성이 깨진다 */
    private static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList;  // 힙 오염
        String s = stringLists[0].get(0);  // ClassCastException
    }

    /** 32-2 가변인수 참조를 외부로 노출해 위험한 경우 */
    private static <T> T[] toArray(T... args) {
        return args;
    }

    /** 제네릭 varargs 매개변수 배열에 다른 메서드가 접근하도록 허용하면 안전하지 않음 */
    static <T> T[] pickTwo(T a, T b, T c) {
        switch(ThreadLocalRandom.current().nextInt(3)) {
            case 0: return toArray(a, b);
            case 1: return toArray(b, c);
            case 2: return toArray(a, c);
        }
        throw new AssertionError();
    }

    static <T> List<T> pickEnhancedTwo(T a, T b, T c) {
        switch(ThreadLocalRandom.current().nextInt(3)) {
            case 0: return List.of(a, b);
            case 1: return List.of(b, c);
            case 2: return List.of(a, c);
        }
        throw new AssertionError();
    }
}
