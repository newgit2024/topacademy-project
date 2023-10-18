package org.example.inters.artur;

import java.util.HashMap;
import java.util.Map;

public class TaxCalculator {
    private static final Map<String, Double> countryTaxRates = new HashMap<>();

    static {
        // Заполняем таблицу соответствия кода страны и налогового сбора
        countryTaxRates.put("RU", 0.13); // Налог 13% для России
        countryTaxRates.put("DE", 0.19); // Налог 19% для Германии
        // Добавьте другие страны и их налоговые ставки по необходимости
    }

    public static double calculateNetto(double brutto, String countryCode) {
        if (!countryTaxRates.containsKey(countryCode)) {
            throw new IllegalArgumentException("Country code not supported");
        }

        double taxRate = countryTaxRates.get(countryCode);
        double netto = brutto * (1 - taxRate);
        return netto;
    }

    public static void main(String[] args) {
        double brutto = 100;
        String countryCode = "RU";
        double netto = calculateNetto(brutto, countryCode);
        System.out.println("Netto amount for " + countryCode + ": " + netto);

        countryCode = "DE";
        netto = calculateNetto(brutto, countryCode);
        System.out.println("Netto amount for " + countryCode + ": " + netto);
    }
}

