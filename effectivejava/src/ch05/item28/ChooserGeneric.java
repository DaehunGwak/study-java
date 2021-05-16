package ch05.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserGeneric<T> {
    private final List<T> choiceList;
//    private final T[] choiceArray;

    public ChooserGeneric(Collection<T> choices) {
        choiceList = new ArrayList<>(choices);
//        choiceArray = (T[]) choices.toArray();
    }

    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
//        return choiceArray[rnd.nextInt(choiceArray.length)];
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }
}
