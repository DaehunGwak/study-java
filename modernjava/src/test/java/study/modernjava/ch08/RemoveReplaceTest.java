package study.modernjava.ch08;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RemoveReplaceTest {

    @Test
    void removeIf() {
        List<Transaction> transactions = new ArrayList<>(
                List.of(new Transaction("a12"),
                        new Transaction("C14"),
                        new Transaction("13b")));
        transactions.removeIf(t ->
                Character.isDigit(t.getReferenceCode().charAt(0)));
        System.out.println(transactions);
    }

    @Test
    void replaceAll() {
        List<String> referenceCodes = new ArrayList<>(List.of("a12", "C14", "b13"));
        referenceCodes.replaceAll(code ->
                Character.toUpperCase(code.charAt(0)) + code.substring(1));
        System.out.println(referenceCodes); // [A12, C14, B13]
    }
}
