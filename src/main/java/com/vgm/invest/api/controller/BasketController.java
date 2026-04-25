package com.vgm.invest.api.controller;

import com.vgm.invest.application.basket.command.CreateBasketCommand;
import com.vgm.invest.application.basket.command.handler.CreateBasketHandler;
import com.vgm.invest.application.basket.query.GetAllBasketQuery;
import com.vgm.invest.application.basket.query.handler.GetAllBasketHandler;
import com.vgm.invest.domain.basket.entity.Basket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

@Controller
@RequestMapping("/basket")
public class BasketController {


    private final CreateBasketHandler createBasketHandler;
    private final GetAllBasketHandler getAllBasketHandler;


    public BasketController(CreateBasketHandler createBasketHandler, GetAllBasketHandler getAllBasketHandler) {
        this.createBasketHandler = createBasketHandler;
        this.getAllBasketHandler = getAllBasketHandler;
    }

    @PostMapping
    public ResponseEntity<Void> createBasket(@RequestBody CreateBasketCommand dto) {
        Basket basket = createBasketHandler.createBasket(dto);
        return ResponseEntity.created(URI.create("/basket/" + basket.getId())).build();
    }

    @GetMapping
    public ResponseEntity<Page<Basket>> getAllBasket(Pageable pageable) {
        var query = new GetAllBasketQuery(pageable);
        var response = getAllBasketHandler.getAllBasket(query);
        return ResponseEntity.ok(response);
    }

}
