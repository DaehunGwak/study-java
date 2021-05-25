package ch06.item39.exception.repeatable;

import java.util.ArrayList;
import java.util.List;

public class Sample {

    @ExceptionTest(IndexOutOfBoundsException.class)
    @ExceptionTest(NullPointerException.class)
    public static void doublyBad() {
        List<String> list = new ArrayList<>();
        list.addAll(5, null); // 명세에 따르면 위의 두가지 예외를 던질 수 있음
    }

}
