package com.logistica;

public class EmailNotificationService implements NotificationService {

    @Override
    public void sendOrderConfirmation(Client client, Order order) {
        String message = String.format(
                "Pedido recebido! Obrigado pela sua compra, %s.",
                client.getName()
        );
        System.out.println("\nEnviando e-mail para " + client.getEmail() + ": " + message);
    }
}