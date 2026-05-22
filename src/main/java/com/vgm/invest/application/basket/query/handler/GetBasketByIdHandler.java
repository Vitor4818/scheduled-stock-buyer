package com.vgm.invest.application.basket.query.handler;

import com.vgm.invest.application.basket.query.GetBasketById;
import com.vgm.invest.application.basket.query.dto.BasketResponse;
import com.vgm.invest.domain.basket.repository.BasketRepository;
import com.vgm.invest.domain.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class GetBasketByIdHandler {

    private final BasketRepository basketRepository;

    public GetBasketByIdHandler(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public BasketResponse getBasketById(GetBasketById dto){
        return basketRepository.findById(dto.uuid())
                .map(BasketResponse::fromEntity)
                .orElseThrow(()-> new ResourceNotFoundException("Cesta não localizada com o identificador informado."));
    }

}
