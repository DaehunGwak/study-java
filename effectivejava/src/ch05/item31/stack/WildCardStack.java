package ch05.item31.stack;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

public class WildCardStack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")  // 첫번째 우회 방법, 안정성 보장 후 워닝 해제
    public WildCardStack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public <T extends E> void push(T e) {
        ensureCapacity();
        elements[size++] = e;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E result = elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /** 와일드 카드 + 재귀적 타입 한정 */
    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }

    /** 모든 아이템을 pop 함과 동시에 dst로 elements를 옮김 */
    public void popAllTo(Collection<? super E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }
}
