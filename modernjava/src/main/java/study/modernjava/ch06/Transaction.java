package study.modernjava.ch06;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Transaction {

    private final Currency currency;
    private final double value;

}
