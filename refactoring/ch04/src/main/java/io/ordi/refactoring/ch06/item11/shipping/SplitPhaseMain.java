package io.ordi.refactoring.ch06.item11.shipping;

public class SplitPhaseMain {

    static public double getPriceOrder(Product product, long quantity, ShippingMethod shippingMethod) {
        PriceData priceData = calculatePricingData(product, quantity);
        return applyShipping(priceData, shippingMethod);
    }

    static private PriceData calculatePricingData(Product product, long quantity) {
        double basePrice = product.getBasePrice() * quantity;
        double discount = Math.max(quantity - product.getDiscountThreshold(), 0)
                * product.getBasePrice() * product.getDiscountRate();
        return PriceData.builder()
                .basePrice(basePrice)
                .quantity(quantity)
                .discount(discount)
                .build();
    }

    static private double applyShipping(PriceData priceData, ShippingMethod shippingMethod) {
        double shippingPerCase = (priceData.getBasePrice() > shippingMethod.getDiscountThreshold())
                ? shippingMethod.getDiscountedFee() : shippingMethod.getFeePerCase();
        double shippingCost = priceData.getQuantity() * shippingPerCase;
        return priceData.getBasePrice() - priceData.getDiscount() + shippingCost;
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
