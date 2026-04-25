package com.vgm.invest.infrastructure.persistence.jpa.Basket;

import com.vgm.invest.domain.basket.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataBasketRepository extends JpaRepository<Basket, UUID> {
    boolean existsByName(String name);
}
