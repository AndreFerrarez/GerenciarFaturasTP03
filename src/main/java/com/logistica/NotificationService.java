package com.logistica;

public interface NotificationService {
    void sendOrderConfirmation(Client client, Order order);
}