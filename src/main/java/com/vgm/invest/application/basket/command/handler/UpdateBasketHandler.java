package com.vgm.invest.application.basket.command.handler;

import com.vgm.invest.application.basket.command.UpdateBasketCommand;
import com.vgm.invest.application.basket.query.dto.BasketResponse;
import com.vgm.invest.domain.basket.entity.Basket;
import com.vgm.invest.domain.basket.repository.BasketRepository;
import com.vgm.invest.domain.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateBasketHandler {

    private final BasketRepository basketRepository;


    public UpdateBasketHandler(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public BasketResponse updateBasket(UUID uuid, UpdateBasketCommand command){
        Basket basket = basketRepository.findById(uuid)
                .orElseThrow(()-> new ResourceNotFoundException("Cesta não localizada com o identificador informado."));
        basket.updateBasket(command);
        basketRepository.save(basket);
        return BasketResponse.fromEntity(basket);
    }
}
