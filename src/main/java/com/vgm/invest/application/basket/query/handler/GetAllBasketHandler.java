package com.vgm.invest.application.basket.query.handler;

import com.vgm.invest.application.basket.query.GetAllBasketQuery;
import com.vgm.invest.domain.basket.entity.Basket;
import com.vgm.invest.domain.basket.repository.BasketRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class GetAllBasketHandler {

private final BasketRepository basketRepository;

    public GetAllBasketHandler(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public Page<Basket> getAllBasket(GetAllBasketQuery dto){
        Page<Basket> baskets = basketRepository.getAllBasket(dto.pageable());
        return baskets;

    }
}
