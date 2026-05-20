package com.vgm.invest.application.basket.command.handler;

import com.vgm.invest.application.basket.command.DeleteBasketCommand;
import com.vgm.invest.domain.basket.entity.Basket;
import com.vgm.invest.domain.basket.repository.BasketRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteBasketHandler {

    private final BasketRepository basketRepository;

    public DeleteBasketHandler(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public void deactiveBasket(DeleteBasketCommand command){
        Basket basket = basketRepository.findById(command.uuid())
                .orElseThrow(()-> new RuntimeException("Cesta não encontrada"));
        basket.deactivateBasket();
        basketRepository.save(basket);
    }


}
