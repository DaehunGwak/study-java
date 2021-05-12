package ch05.item26;

import java.util.ArrayList;
import java.util.List;

public class ParametrizedCollectionTypeMain {

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>(); // raw type

        items.add(new Item("item 1"));
        items.add(new Item("item 2"));
//        items.add(new Coin(100)); // 실수를 컴파일 타임에서 잡아줌

        for (Item item : items) {
            System.out.println(item.getName());
        }
    }
}
