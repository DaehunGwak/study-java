package io.ordi.refactoring.ch06.item11;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Product {
    double basePrice;
    double discountThreshold;
    double discountRate;
}
