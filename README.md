# Refatoração de Sistema de Faturas

Este projeto transforma um código Java confuso e com problemas em uma aplicação limpa, organizada e funcional.

O código original era inseguro e difícil de manter, com classes que faziam muitas coisas ao mesmo tempo, dados expostos e lógica repetida.

## O Que Foi Feito

A refatoração seguiu 7 passos principais para corrigir os problemas:

1.  **Dados Protegidos (Encapsulamento):** Os campos que eram públicos (`public`) foram trocados para privados (`private`), garantindo que os dados só possam ser acessados e modificados de forma controlada.

2.  **Objetos no Lugar de Listas:** Três listas separadas para produtos, quantidades e preços foram substituídas por uma única classe `OrderItem`. Isso garante que os dados de um item estejam sempre juntos e consistentes.

3.  **Menos Dependências:** A classe `Order` não depende mais diretamente do `EmailService`. Criei uma "ponte" (a interface `NotificationService`) que desacopla o código e o torna mais flexível.

4.  **Cada Classe com sua Função:** A responsabilidade de imprimir a fatura foi movida para uma nova classe, a `InvoicePrinter`. Agora, cada classe tem um trabalho único e bem definido.

5.  **Cliente como Classe:** As informações do cliente (nome e e-mail) foram movidas para sua própria classe `Client`.

6.  **Funções para Cálculos:** A lógica de calcular o subtotal, o desconto e o total foi extraída para seus próprios métodos (`calculateSubtotal()`, etc.), deixando o código mais limpo.

7.  **Mais Segurança:** Adicionei validações para impedir a criação de itens com quantidade ou preço negativo.

## Estrutura Final do Projeto
```
/src
`-- main/java/com/logistica/
    |-- App.java
    |-- Client.java
    |-- Order.java
    |-- OrderItem.java
    |-- InvoicePrinter.java
    |-- DiscountPolicy.java
    |-- NotificationService.java
    `-- EmailNotificationService.java
```

## Como Executar

1.  **Pré-requisitos:** Java JDK e Maven.
2.  **Clone o repositório:**
    ```sh
    git clone https://github.com/AndreFerrarez/GerenciarFaturasTP03.git
    cd GerenciarFaturasTP03
    ```
3.  **Execute via Maven:**
    ```sh
    mvn exec:java -Dexec.mainClass="com.logistica.App"
    ```

## Tecnologias
- Java
- Maven
- Git

---
*Autor: André Ferrarez*