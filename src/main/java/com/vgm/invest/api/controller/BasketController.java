package com.vgm.invest.api.controller;

import com.vgm.invest.application.basket.command.CreateBasketCommand;
import com.vgm.invest.application.basket.command.DeleteBasketCommand;
import com.vgm.invest.application.basket.command.UpdateBasketCommand;
import com.vgm.invest.application.basket.command.handler.CreateBasketHandler;
import com.vgm.invest.application.basket.command.handler.DeleteBasketHandler;
import com.vgm.invest.application.basket.command.handler.UpdateBasketHandler;
import com.vgm.invest.application.basket.query.GetAllBasketQuery;
import com.vgm.invest.application.basket.query.GetBasketById;
import com.vgm.invest.application.basket.query.dto.BasketResponse;
import com.vgm.invest.application.basket.query.handler.GetAllBasketHandler;
import com.vgm.invest.application.basket.query.handler.GetBasketByIdHandler;
import com.vgm.invest.domain.basket.entity.Basket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@Controller
@RequestMapping("/basket")
public class BasketController {


    private final CreateBasketHandler createBasketHandler;
    private final GetAllBasketHandler getAllBasketHandler;
    private final GetBasketByIdHandler getBasketByIdHanlder;
    private final UpdateBasketHandler updateBasketHandler;
    private final DeleteBasketHandler deleteBasketHandler;

    public BasketController(CreateBasketHandler createBasketHandler, GetAllBasketHandler getAllBasketHandler, GetBasketByIdHandler getBasketByIdHanlder, UpdateBasketHandler updateBasketHandler, DeleteBasketHandler deleteBasketHandler) {
        this.createBasketHandler = createBasketHandler;
        this.getAllBasketHandler = getAllBasketHandler;
        this.getBasketByIdHanlder = getBasketByIdHanlder;
        this.updateBasketHandler = updateBasketHandler;
        this.deleteBasketHandler = deleteBasketHandler;
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

    @GetMapping("/{uuid}")
    public ResponseEntity<BasketResponse> getBasketById(@PathVariable UUID uuid){
        var query = new GetBasketById(uuid);
        var response = getBasketByIdHanlder.getBasketById(query);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<BasketResponse> updateBasket(@PathVariable UUID uuid, @RequestBody UpdateBasketCommand command){
        var response = updateBasketHandler.updateBasket(uuid, command);
       return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteBasket(@PathVariable UUID uuid){
        var command = new DeleteBasketCommand(uuid);
        deleteBasketHandler.deactiveBasket(command);
        return ResponseEntity.noContent().build();
    }

}
