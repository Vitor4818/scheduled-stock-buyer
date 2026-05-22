package com.vgm.invest.application.basket.command.handler;

import com.vgm.invest.application.basket.command.CreateBasketCommand;
import com.vgm.invest.domain.basket.entity.Basket;
import com.vgm.invest.domain.basket.repository.BasketRepository;
import com.vgm.invest.domain.exception.DataConflictException;
import org.springframework.stereotype.Service;

@Service
public class CreateBasketHandler {

    public CreateBasketHandler(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    private final BasketRepository basketRepository;

public Basket createBasket(CreateBasketCommand dto){
    if (basketRepository.existByName(dto.name())){
        throw new DataConflictException("O nome de cesta '"+dto.name()+"' já está em uso. Escolha um nome exclusivo para esta nova estratégia.");
    }
    Basket basket = new Basket(dto.name());
    return basketRepository.save(basket);


}



}
