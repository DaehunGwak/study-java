package study.modernjava.ch07;

import org.junit.jupiter.api.Test;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SpliteratorTest {

    final String SENTENCE =
            "Nel        mezzo del cammin di nostra vita " +
                    "mi ritrovai in una  selva oscura " +
                    "ch  la dritta via era  smarrita ";

    @Test
    void testCountWordsIteratively() {
        System.out.println("Found " + countWordsIteratively(SENTENCE) + " words");
    }

    public int countWordsIteratively(String s) {
        int count = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) count++;
                lastSpace = false;
            }
        }
        return count;
    }

    @Test
    void testCountWords() {
        Stream<Character> characterStream = IntStream.range(0, SENTENCE.length())
                .mapToObj(SENTENCE::charAt);
        System.out.println("Found " + countWords(characterStream) + " words");
    }

    @Test
    void testCountWordsParallel() {
        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);
        System.out.println("Found " + countWords(stream) + " words");
    }

    public int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(
                new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combine);
        return wordCounter.getCounter();
    }
}
