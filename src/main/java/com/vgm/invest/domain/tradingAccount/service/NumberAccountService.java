package com.vgm.invest.domain.tradingAccount.service;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDate;

@Service
public class NumberAccountService {

    private static final SecureRandom RANDOM = new SecureRandom();

    public String generateAccountNumber(LocalDate date) {
        String base = generateBase(date);
        int checkDigit = calculateCheckDigit(base);
        return base + "-" + checkDigit;
    }

    private String generateBase(LocalDate date) {
        String formattedDate = date.toString().replace("-", "");
        int randomNumber = RANDOM.nextInt(10000); // 0 a 9999
        return formattedDate + randomNumber;
    }

    private int calculateCheckDigit(String base) {
        int sum = 0;

        for (char c : base.toCharArray()) {
            int digit = Character.getNumericValue(c);
            int doubled = digit * 2;

            // Se for maior que 9, soma os dígitos (ex: 12 → 1 + 2 = 3)
            if (doubled > 9) {
                doubled = (doubled / 10) + (doubled % 10);
            }

            sum += doubled;
        }

        int checkDigit = 10 - (sum % 10);
        return (checkDigit == 10) ? 0 : checkDigit;
    }
}