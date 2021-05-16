package ch05.item29;

import java.util.Locale;

public class GenericStackMain {

    public static void main(String[] args) {
        GenericStack<String> stack = new GenericStack<>();
        for (String arg : args)
            stack.push(arg);
        while (!stack.isEmpty())
            System.out.println(stack.pop().toUpperCase());
    }
}
