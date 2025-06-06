package com.logistica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final Client client;
    private final List<OrderItem> items = new ArrayList<>();
    private final double discountRate;

    public Order(Client client, double discountRate) {
        this.client = client;
        this.discountRate = discountRate;
    }

    public void addItem(OrderItem item) {
        if (item != null) {
            this.items.add(item);
        }
    }

    public double calculateSubtotal() {
        return items.stream()
                .mapToDouble(OrderItem::getSubtotal)
                .sum();
    }

    public double calculateDiscount() {
        return DiscountPolicy.calculateDiscount(calculateSubtotal(), this.discountRate);
    }

    public double calculateFinalTotal() {
        return calculateSubtotal() - calculateDiscount();
    }

    // Getters para expor dados de forma segura
    public Client getClient() {
        return client;
    }

    public List<OrderItem> getItems() {
        // Retorna uma visão não modificável da lista para proteger o encapsulamento
        return Collections.unmodifiableList(items);
    }
}