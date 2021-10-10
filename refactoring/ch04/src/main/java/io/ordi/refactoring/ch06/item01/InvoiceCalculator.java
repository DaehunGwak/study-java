package io.ordi.refactoring.ch06.item01;

import java.time.LocalDate;

public class InvoiceCalculator {

    public void printOwing(Invoice invoice) {
        printBanner();
        long outstanding = calculateOutstanding(invoice);
        recordDueDate(invoice);
        printDetails(invoice, outstanding);
    }

    private void printBanner() {
        System.out.println("*********************");
        System.out.println("****** 고객 채무 ******");
        System.out.println("*********************");
    }

    private long calculateOutstanding(Invoice invoice) {
        long result = 0;
        for (Order o : invoice.getOrders()) {
            result += o.getAmount();
        }
        return result;
    }

    private void recordDueDate(Invoice invoice) {
        LocalDate today = LocalDate.now();
        invoice.setDueDate(today.plusDays(30));
    }

    private void printDetails(Invoice invoice, long outstanding) {
        System.out.println("고객명: " + invoice.getCustomer());
        System.out.println("채무액: " + outstanding);
        System.out.println("마감일: " + invoice.getDueDate());
    }

    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        invoice.setCustomer("ordi");
        invoice.getOrders().add(new Order(20L));
        invoice.getOrders().add(new Order(30L));
        invoice.getOrders().add(new Order(70L));

        InvoiceCalculator invoiceCalculator = new InvoiceCalculator();
        invoiceCalculator.printOwing(invoice);
    }
}
