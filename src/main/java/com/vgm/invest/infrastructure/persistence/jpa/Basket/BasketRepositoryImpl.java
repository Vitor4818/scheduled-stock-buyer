package com.vgm.invest.infrastructure.persistence.jpa.Basket;

import com.vgm.invest.domain.basket.entity.Basket;
import com.vgm.invest.domain.basket.repository.BasketRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public class BasketRepositoryImpl implements BasketRepository {
    private final SpringDataBasketRepository basketRepository;

    public BasketRepositoryImpl(SpringDataBasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @Override
    public Basket save(Basket basket) {
        return basketRepository.save(basket);
    }

    @Override
    public Optional<Basket> findById(UUID uuid) {
        return basketRepository.findById(uuid);
    }

    @Override
    public Page<Basket> getAllBasket(Pageable pageable) {
        return basketRepository.findAll(pageable);
    }

    @Override
    public boolean existByName(String name) {
        return basketRepository.existsByName(name);
    }
}
