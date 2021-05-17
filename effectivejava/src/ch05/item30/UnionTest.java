package ch05.item30;

import java.util.HashSet;
import java.util.Set;

public class UnionTest {

    /** 타입이 불안정한 로 함수
     * 개별적으로 타입이 다를 수 있음 */
    public static Set rawUnion(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    /** 제네릭 함수로 타입 안정성을 보장
     * E 타입을 통해 모든 인수, 변수들이 E 타입을 일관적으로 쓰도록 보장 */
    public static <E> Set<E> genericUnion(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args) {
        rawVsGenericMain();
//        typeSafetyMain();
    }

    public static void rawVsGenericMain() {
        Set<String> guys = Set.of("Tom", "Nick", "Harry");
        Set<String> stooges = Set.of("Larry", "Moe", "Curly");

        Set<String> raws = rawUnion(guys, stooges);  // unchecked warning
        System.out.println(raws);

        Set<String> generics = genericUnion(guys, stooges);
        System.out.println(generics);
    }

    public static void typeSafetyMain() {
        Set<String> guys = Set.of("Tom", "Nick", "Harry");
        Set<Long> longs = Set.of(5L, 20L, 45L, 90L);

        Set<Object> objects = rawUnion(guys, longs);
        System.out.println(objects);

//        Set<Object> objects2 = genericUnion(guys, longs);  // 컴파일 시 오류 보장
//        System.out.println(objects2);
    }
}
