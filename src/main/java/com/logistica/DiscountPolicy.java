package com.logistica;

public class DiscountPolicy {
    public static double calculateDiscount(double amount, double rate) {
        if (amount < 0 || rate < 0 || rate > 1) {
            return 0; // Evita descontos inválidos
        }
        return amount * rate;
    }
}