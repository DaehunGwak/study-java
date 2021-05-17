package ch05.item30;

import java.util.function.UnaryOperator;

/** 항등 함수(Identity Function) 예제
 * Function.identity를 사용하면 되지만 공부를 위해 직접 작성
 */
public class GenericSingletonFactory {

    /** 자기 그대로를 반환하므로 타입안정성 보장 */
    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

    /** 타입 안정성이 보장되어 unchecked 워닝 해제 */
    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> getIdentityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    public static void main(String[] args) {
        String[] strings = {"삼베", "나일론", "대마"};
        UnaryOperator<String> sameString = getIdentityFunction();
        for (String s : strings) {
            System.out.println(sameString.apply(s));
        }

        Number[] numbers = { 1, 2.0, 3L };
        UnaryOperator<Number> sameNumber = getIdentityFunction();
        for (Number n : numbers) {
            System.out.println(n.getClass() + " : " + sameNumber.apply(n));
        }
    }
}
