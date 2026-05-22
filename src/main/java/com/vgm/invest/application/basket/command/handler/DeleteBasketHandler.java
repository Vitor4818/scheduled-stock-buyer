package com.vgm.invest.application.basket.command.handler;

import com.vgm.invest.application.basket.command.DeleteBasketCommand;
import com.vgm.invest.domain.basket.entity.Basket;
import com.vgm.invest.domain.basket.repository.BasketRepository;
import com.vgm.invest.domain.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DeleteBasketHandler {

    private final BasketRepository basketRepository;

    public DeleteBasketHandler(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public void deactiveBasket(DeleteBasketCommand command){
        Basket basket = basketRepository.findById(command.uuid())
                .orElseThrow(()-> new ResourceNotFoundException("Cesta não localizada com o identificador informado."));
        basket.deactivateBasket();
        basketRepository.save(basket);
    }


}
