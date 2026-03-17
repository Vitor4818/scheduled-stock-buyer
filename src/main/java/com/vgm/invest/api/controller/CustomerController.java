package com.vgm.invest.api.controller;

import com.vgm.invest.application.customer.command.CreateCustomerCommand;
import com.vgm.invest.application.customer.command.handler.CreateCustomerHandler;
import com.vgm.invest.application.customer.query.GetCustomerByIdQuery;
import com.vgm.invest.application.customer.query.dto.CustomerResponse;
import com.vgm.invest.application.customer.query.handler.GetUserByIdQueryHandler;
import com.vgm.invest.domain.customer.entities.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CreateCustomerHandler createCustomerHandler;
    private final GetUserByIdQueryHandler getUserByIdQueryHandler;

    public CustomerController(CreateCustomerHandler createCustomerHandler, GetUserByIdQueryHandler getUserByIdQueryHandler) {
        this.createCustomerHandler = createCustomerHandler;
        this.getUserByIdQueryHandler = getUserByIdQueryHandler;
    }

    @PostMapping
    public ResponseEntity<Void> postCustomer(@RequestBody CreateCustomerCommand command){
        Customer savedCustomer = createCustomerHandler.createCustomer(command);
        return ResponseEntity.created(URI.create("/customers/"+savedCustomer.getId())).build();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable UUID uuid){
        GetCustomerByIdQuery getCustomerByIdQuery = new GetCustomerByIdQuery(uuid);
        var response = getUserByIdQueryHandler.getCustomerById(getCustomerByIdQuery);
        return ResponseEntity.ok(response);
    }

}
