package com.logistica;



public class App {
    public static void main(String[] args) {
        // 1. Configuração dos dados
        Client client = new Client("João Silva", "joao.silva@email.com");
        Order order = new Order(client, 0.10); // 10% de desconto

        // 2. Adicionar itens ao pedido de forma segura
        order.addItem(new OrderItem("Notebook Pro M3", 1, 3500.0));
        order.addItem(new OrderItem("Mouse sem fio", 2, 80.0));
        order.addItem(new OrderItem("Teclado Mecânico", 1, 250.0));

        // 3. Processar o pedido usando os serviços dedicados
        InvoicePrinter printer = new InvoicePrinter();
        printer.print(order);

        // Usando a abstração para enviar a notificação
        NotificationService notificationService = new EmailNotificationService();
        notificationService.sendOrderConfirmation(order.getClient(), order);
    }
}