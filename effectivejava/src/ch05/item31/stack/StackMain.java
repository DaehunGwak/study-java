package ch05.item31.stack;

import java.util.ArrayList;
import java.util.List;

public class StackMain {

    public static void main(String[] args) {
        pushTestMain();
        popTestMain();
    }

    public static void pushTestMain() {
        Iterable<Integer> integers = List.of(1, 2, 3);

        Stack<Number> numberStack = new Stack<>();
//        numberStack.pushAll(integers); // E가 Number이므로 pushAll의 타입은 Number 아니면 안됨

        WildCardStack<Number> wildCardStack = new WildCardStack<>();
        wildCardStack.pushAll(integers);
        wildCardStack.push(1);
    }

    public static void popTestMain() {
        Iterable<Integer> integers = List.of(1, 2, 3);

        Stack<Integer> stack = new Stack<>();
        List<Object> dstStack = new ArrayList<>();
        stack.pushAll(integers);
//        stack.popAllTo(dstStack);

        WildCardStack<Integer> wildCardStack = new WildCardStack<>();
        List<Object> wildCardDstStack = new ArrayList<>();
        wildCardStack.pushAll(integers);
        wildCardStack.popAllTo(wildCardDstStack);
    }
}
