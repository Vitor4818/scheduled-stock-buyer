package com.vgm.invest.application.basket.command.handler;

import com.vgm.invest.application.basket.command.UpdateBasketCommand;
import com.vgm.invest.application.basket.query.dto.BasketResponse;
import com.vgm.invest.domain.basket.entity.Basket;
import com.vgm.invest.domain.basket.repository.BasketRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateBasketHandler {

    private final BasketRepository basketRepository;


    public UpdateBasketHandler(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public BasketResponse updateBasket(UUID uuid, UpdateBasketCommand command){
        Basket basket = basketRepository.findById(uuid).orElseThrow(()-> new RuntimeException("Cesta não encontrada"));
        basket.updateBasket(command);
        basketRepository.save(basket);
        return BasketResponse.fromEntity(basket);
    }
}
