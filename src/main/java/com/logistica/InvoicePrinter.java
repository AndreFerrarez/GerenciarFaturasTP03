package com.logistica;

public class InvoicePrinter {
    public void print(Order order) {
        System.out.println("===================================");
        System.out.println("           FATURA DO PEDIDO        ");
        System.out.println("===================================");
        System.out.println("Cliente: " + order.getClient().getName());
        System.out.println("-----------------------------------");

        for (OrderItem item : order.getItems()) {
            System.out.printf("%dx %-20s R$ %.2f\n",
                    item.getQuantity(),
                    item.getProductName(),
                    item.getSubtotal());
        }

        System.out.println("-----------------------------------");
        printTotalLine("Subtotal:", order.calculateSubtotal());
        printTotalLine("Desconto:", order.calculateDiscount());
        printTotalLine("Total final:", order.calculateFinalTotal());
        System.out.println("===================================");
    }

    private void printTotalLine(String label, double amount) {
        System.out.printf("%-23s R$ %.2f\n", label, amount);
    }
}