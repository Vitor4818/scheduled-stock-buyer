package com.vgm.invest.api.controller;

import com.vgm.invest.application.command.CreateCustomerRequest;
import com.vgm.invest.application.handler.CreateCustomerHandler;
import com.vgm.invest.domain.model.Customer.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CreateCustomerHandler createCustomerHandler;

    public CustomerController(CreateCustomerHandler createCustomerHandler) {
        this.createCustomerHandler = createCustomerHandler;
    }

    @PostMapping
    public ResponseEntity<Void> postCustomer(@RequestBody CreateCustomerRequest command){
        Customer savedCustomer = createCustomerHandler.createCustomer(command);
        return ResponseEntity.created(URI.create("/customers/"+savedCustomer.getId())).build();


    }

}
