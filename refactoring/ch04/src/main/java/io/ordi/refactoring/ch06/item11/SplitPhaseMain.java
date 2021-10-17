package io.ordi.refactoring.ch06.item11;

public class SplitPhaseMain {

    static public double getPriceOrder(Product product, long quantity, ShippingMethod shippingMethod) {
        double basePrice = product.getBasePrice() * quantity;
        double discount = Math.max(quantity - product.getDiscountThreshold(), 0)
                * product.getBasePrice() * product.getDiscountRate();
        double shippingPerCase = (basePrice > shippingMethod.getDiscountThreshold())
                ? shippingMethod.getDiscountedFee() : shippingMethod.getFeePerCase();
        double shippingCost = quantity * shippingPerCase;
        return basePrice - discount + shippingCost;
    }

    public static void main(String[] args) {
        Product product = Product.builder()
                .basePrice(100)
                .discountRate(0.1)
                .discountThreshold(3)
                .build();
        ShippingMethod shippingMethod = ShippingMethod.builder()
                .discountThreshold(500)
                .discountedFee(5)
                .feePerCase(7)
                .build();

        double priceOrder = getPriceOrder(product, 10, shippingMethod);
        System.out.println(priceOrder);
    }
}
