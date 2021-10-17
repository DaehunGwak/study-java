package io.ordi.refactoring.ch06.item11;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PriceData {
    double basePrice;
    long quantity;
    double discount;
}
