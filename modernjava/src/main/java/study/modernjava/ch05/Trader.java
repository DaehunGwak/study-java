package study.modernjava.ch05;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Trader {
    private final String name;
    private final String city;
}
