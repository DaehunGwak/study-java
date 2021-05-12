package ch05.item26;

import java.util.ArrayList;
import java.util.List;

public class ClassCastExceptionMain {

    public static void main(String[] args) {
        List items = new ArrayList(); // raw type

        items.add(new Item("item 1"));
        items.add(new Item("item 2"));
        items.add(new Coin(100)); // 실수~

        for (Object o : items) {
            Item item = (Item) o;  // java.lang.ClassCastException 발생
            System.out.println(item.getName());
        }

        // 로 타입을 사용하니 런타임에서 오류가 남
    }
}