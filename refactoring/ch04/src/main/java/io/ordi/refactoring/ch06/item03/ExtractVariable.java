package io.ordi.refactoring.ch06.item03;

import lombok.Getter;
import lombok.Setter;

public class ExtractVariable {

    private double before(Order order) {
        return order.getQuantity() * order.getItemPrice()
                - Math.max(0, order.getQuantity() - 500) * order.getItemPrice() * 0.05
                + Math.min(order.getQuantity() * order.getItemPrice() * 0.1, 100);
    }

    private double after(Order order) {
        final double basePrice = order.getQuantity() * order.getItemPrice();
        final double quantityDiscount = Math.max(0, order.getQuantity() - 500) * order.getItemPrice() * 0.05;
        final double shipping = Math.min(basePrice * 0.1, 100);
        return basePrice - quantityDiscount + shipping;
    }

    private double classVersion(Order order) {
        return order.getPrice();
    }

    @Getter @Setter
    public static class Order {

        private long quantity;
        private long itemPrice;

        public double getPrice() {
            return getBasePrice() - getQuantityDiscount() + getShipping();
        }

        public double getBasePrice() {
            return getQuantity() * getItemPrice();
        }

        public double getQuantityDiscount() {
            return Math.max(0, getQuantity() - 500) * getItemPrice() * 0.05;
        }

        public double getShipping() {
            return Math.min(getBasePrice() * 0.1, 100);
        }
    }
}
