package ch02.item07;

import java.util.Arrays;

// 7-1 메모리 누수 발생하는 지점은?
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * 문제가 있는 부분
     * elements에서 참조를 해제하지 않아 GC의 대상이 되지 않음
     */
//    public Object pop() {
//        if (size == 0)
//            throw new EmptyStackException();
//        return elements[--size];
//    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];

        // 참조를 해제해 해당 객체가 다른곳에서 사용되지 않으면 GC의 대상이 될 수 있음
        elements[size] = null;

        return result;
    }



    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        for (String arg : args)
            stack.push(arg);

        while (true)
            System.err.println(stack.pop());
    }
}
