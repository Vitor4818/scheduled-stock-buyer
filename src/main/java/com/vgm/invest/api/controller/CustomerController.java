package com.vgm.invest.api.controller;

import com.vgm.invest.application.customer.command.CreateCustomerRequest;
import com.vgm.invest.application.customer.command.DeleteCustomerCommand;
import com.vgm.invest.application.customer.command.UpdateCustomerCommand;
import com.vgm.invest.application.customer.command.handler.CreateCustomerHandler;
import com.vgm.invest.application.customer.command.handler.DeleteCustomerHandler;
import com.vgm.invest.application.customer.command.handler.UpdateCustomerHandler;
import com.vgm.invest.application.customer.query.GetAllCustomersQuery;
import com.vgm.invest.application.customer.query.GetCustomerByIdQuery;
import com.vgm.invest.application.customer.query.dto.CustomerResponse;
import com.vgm.invest.application.customer.query.handler.GetAllCustomerHandler;
import com.vgm.invest.application.customer.query.handler.GetUserByIdQueryHandler;
import com.vgm.invest.domain.customer.entities.Customer;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    private final GetAllCustomerHandler getAllCustomerHandler;
    private final DeleteCustomerHandler deleteCustomerHandler;
    private final UpdateCustomerHandler updateCustomerHandler;


    public CustomerController(UpdateCustomerHandler updateCustomerHandler, GetAllCustomerHandler getAllCustomerHandler, GetUserByIdQueryHandler getUserByIdQueryHandler, CreateCustomerHandler createCustomerHandler, DeleteCustomerHandler deleteCustomerHandler) {
        this.getAllCustomerHandler = getAllCustomerHandler;
        this.getUserByIdQueryHandler = getUserByIdQueryHandler;
        this.createCustomerHandler = createCustomerHandler;
        this.deleteCustomerHandler = deleteCustomerHandler;
        this.updateCustomerHandler = updateCustomerHandler;
    }

    //Metodo para cadastrar o usuario
    @PostMapping
    public ResponseEntity<Void> postCustomer(@RequestBody CreateCustomerRequest command){
        Customer savedCustomer = createCustomerHandler.createCustomer(command);
        return ResponseEntity.created(URI.create("/customers/"+savedCustomer.getId())).build();
    }

    //Metodo para pegar o usuario pelo ID
    @GetMapping("/{uuid}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable UUID uuid){
        GetCustomerByIdQuery getCustomerByIdQuery = new GetCustomerByIdQuery(uuid);
        var response = getUserByIdQueryHandler.getCustomerById(getCustomerByIdQuery);
        return ResponseEntity.ok(response);
    }

    //Metodo para retornar todos os usuarios
    @GetMapping()
    public ResponseEntity<Page<CustomerResponse>> getAllCustomer(Pageable pageable){
       var query = new GetAllCustomersQuery(pageable);
       var response =  getAllCustomerHandler.getAllCustomers(query);
       return ResponseEntity.ok(response);
    }

    //Metodo para fazer o soft delete do usuario
    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable UUID uuid){
        var command = new DeleteCustomerCommand(uuid);
        deleteCustomerHandler.deleteCustomer(command);
        return ResponseEntity.noContent().build();
    }

    //Metodo para atualizar os dados do usuario
    @PutMapping("/{uuid}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable UUID uuid, @RequestBody UpdateCustomerCommand command){
        var response = updateCustomerHandler.updateCustomer(uuid, command);
        return ResponseEntity.ok(response);
    }

}
