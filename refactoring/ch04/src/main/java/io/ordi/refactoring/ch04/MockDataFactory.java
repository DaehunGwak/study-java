package io.ordi.refactoring.ch04;

import java.util.List;

public class MockDataFactory {

    public Province sampleProvinceData() {
        List<Producer> producers = List.of(
                new Producer("Byzantium", 10, 9),
                new Producer("Attalia", 12, 10),
                new Producer("Sinope", 10, 6)
        );
        return new Province("Asia", producers, 30, 20);
    }
}
