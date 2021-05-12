package ch05.item26;

import java.util.HashSet;
import java.util.Set;

public class UnboundedWildCardMain {

    public static void main(String[] args) {
        Set<Long> s1 = new HashSet<>();
        s1.add(10L);
        s1.add(20L);

        Set<String> s2 = new HashSet<>();
        s2.add("20L");
        s2.add("30L");

        System.out.println(numElementsInCommon(s1, s2));
    }

    static int numElementsInCommon(Set s1, Set s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1))
                result++;
        }
        return result;
    }
}
