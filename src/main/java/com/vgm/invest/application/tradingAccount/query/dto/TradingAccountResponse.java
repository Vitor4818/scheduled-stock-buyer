package com.vgm.invest.application.TradingAccount.query.dto;


import com.vgm.invest.domain.tradingAccount.entities.TradingAccount;

import java.time.LocalDate;
import java.util.UUID;

public record TradingAccountResponse(
        UUID id,
        String customerName,
        UUID customerId,// Pegamos apenas o nome do cliente, não o objeto todo
        String accountNumber,     // Pegamos o valor de dentro do seu VO @Embedded
        String type,              // O Enum formatado como String
        LocalDate createdAt       // A data de criação
) {
    // Método estático para converter a Entity para o DTO de forma limpa
    public static TradingAccountResponse fromEntity(TradingAccount entity) {
        return new TradingAccountResponse(
                entity.getId(),
                entity.getCustomer().getName(), // Supondo que seu Customer tem getName()
                entity.getCustomer().getId(),
                entity.getNumberAccount().getValue(), // Pega o valor da String dentro do VO
                entity.getType().name(),
                entity.getDate()
        );
    }
}