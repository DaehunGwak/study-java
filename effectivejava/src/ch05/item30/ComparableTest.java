package ch05.item30;

import java.util.Collection;
import java.util.Objects;

public class ComparableTest {

    /** 재귀적 한정 사용
     *
     * E 타입은 Comparable 하위 (혹은 동일) 타입으로 제한한다
     *
     * 이 말의 의미는 비교 가능한 타입만 max 연산을 허용한다는 의미
     */
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty()) {
            throw new IllegalStateException("컬렉션이 비어 있습니다.");
        }

        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        }

        return result;
    }
}
