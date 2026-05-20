package com.vgm.invest.application.basket.query.dto;

import com.vgm.invest.domain.basket.entity.Basket;

import java.time.LocalDate;
import java.util.UUID;

public record BasketResponse(
        UUID uuid,
        String name,
        boolean isActive,
        LocalDate activationDate,
        LocalDate deactivationDate
) {
    public BasketResponse(UUID uuid, String name, boolean isActive, LocalDate activationDate, LocalDate deactivationDate) {
        this.uuid = uuid;
        this.name = name;
        this.isActive = isActive;
        this.activationDate = activationDate;
        this.deactivationDate = deactivationDate;
    }

    public static BasketResponse fromEntity(Basket basket){
        return new BasketResponse(
                basket.getId(),
                basket.getName(),
                basket.isActive(),
                basket.getActivationDate(),
                basket.getDeactivationDate()
        );
    }

}
