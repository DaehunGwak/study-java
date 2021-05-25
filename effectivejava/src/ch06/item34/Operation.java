package ch06.item34;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum Operation {
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    }
    ;

    private static final Map<String, Operation> stringToEnum = Stream.of(values())
            .collect(toMap(Object::toString, e -> e));

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    public abstract double apply(double x, double y);

    public static void main(String[] args) {
        double v1 = 4.29;
        double v2 = 97.47;
        for (Operation op: Operation.values()) {
            System.out.printf("%f %s %f = %f%n",
                    v1, op, v2, op.apply(v1, v2));
//            System.out.println(Operation.fromString(op.toString()));
        }
    }

}
