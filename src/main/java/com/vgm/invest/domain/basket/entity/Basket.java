package com.vgm.invest.domain.basket.entity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table (name = "tb_basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private boolean isActive;
    private LocalDate activationDate;
    private LocalDate deactivationDate ;

    public Basket(String name) {
        this.name = name;
        this.activationDate = LocalDate.now();
        this.isActive = true;
    }

    public void deactivateBasket(){
        this.isActive = false;
        this.deactivationDate = LocalDate.now();
    }
}
