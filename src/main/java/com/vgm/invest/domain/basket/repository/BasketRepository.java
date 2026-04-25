package com.vgm.invest.domain.basket.repository;

import com.vgm.invest.domain.basket.entity.Basket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface BasketRepository {
    Basket save (Basket basket);
    Optional<Basket> findById(UUID uuid);
    Page<Basket> getAllBasket(Pageable pageable);
    boolean existByName(String name);
}
