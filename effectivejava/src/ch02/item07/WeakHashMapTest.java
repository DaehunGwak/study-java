package ch02.item07;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest {

    public static void main(String[] args) {
        // setup
        Map<Integer, Stack> weakMap = new WeakHashMap<>();
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        weakMap.put(20, s1);
        weakMap.put(450, s2);

        // 정상적으로 2개 출력
        for (Map.Entry<Integer, Stack> elem : weakMap.entrySet()) {
            System.out.printf("%d: %s\n", elem.getKey(), elem.getValue());
        }

        // 강제 GC
        s2 = null;
        System.gc();

        // WeakHashMap 에서 450 키가 자동으로 사라진 것을 확인할 수 있음
        for (Map.Entry<Integer, Stack> elem : weakMap.entrySet()) {
            System.out.printf("%d: %s\n", elem.getKey(), elem.getValue());
        }
    }
}
