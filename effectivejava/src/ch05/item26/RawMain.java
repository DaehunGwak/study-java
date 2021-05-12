package ch05.item26;

import java.util.ArrayList;
import java.util.List;

public class RawMain {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        unsafeAdd(strings, String.valueOf(10));
        unsafeAdd(strings, Integer.valueOf(10));

        String s0 = strings.get(0);
        System.out.println(s0);

        String s1 = strings.get(1);  // ClassCastException
        System.out.println(s1);
    }

    private static void unsafeAdd(List list, Object o) {
//    private static void unsafeAdd(List<Object> list, Object o) {
        list.add(o);
    }
}
