package ch05.item27;

import java.util.HashSet;
import java.util.Set;

public class UncheckTestMain {

    public static void main(String[] args) {
        Set<Long> s = new HashSet();
        s.add(10L);
        System.out.println(s.contains(10L));
    }
}
