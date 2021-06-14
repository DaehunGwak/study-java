package ch07.item42;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorMain {

    /**
     * String 길이로 sorting 하는 예제
     */
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(List.of("cb", "abcd", "123"));

//        sortOldVersion(words);
//        sortLambda(words);
        sortUsingUtil(words);

        System.out.println(words);
    }

    /** 42-1 익명 클래스의 인스턴스를 함수 객체로 사용 - 낡은 기법 */
    private static void sortOldVersion(List<String> words) {
        words.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
    }

    /** 42-2 람다식을 함수 객체로 사용 - 익명 클래스 대체 */
    private static void sortLambda(List<String> words) {
        words.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
    }

    /** 더 간단히 가능 */
    private static void sortUsingUtil(List<String> words) {
        words.sort(Comparator.comparingInt(String::length));
    }
}
