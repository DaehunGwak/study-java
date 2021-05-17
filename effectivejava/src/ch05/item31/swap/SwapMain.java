package ch05.item31.swap;

import java.util.List;

public class SwapMain {

//    public static void swap(List<?> list, int i, int j) {
//        list.set(i, list.set(j, list.get(i))); // ??? (List<?> 는 null외 어떤 값도 넣을 수 없음)
//    }

    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }
}
