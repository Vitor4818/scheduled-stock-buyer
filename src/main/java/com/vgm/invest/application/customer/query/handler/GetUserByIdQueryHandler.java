package com.vgm.invest.application.customer.query.handler;

import com.vgm.invest.application.customer.query.dto.CustomerResponse;
import com.vgm.invest.domain.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import com.vgm.invest.application.customer.query.GetCustomerByIdQuery;

@Service
public class GetUserByIdQueryHandler {

    final CustomerRepository customerRepository;

    public GetUserByIdQueryHandler(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public CustomerResponse getCustomerById (GetCustomerByIdQuery queryHandler){
        return customerRepository.findById(queryHandler.customerId())
                .map(CustomerResponse::fromEntity)
                .orElseThrow(()-> new RuntimeException("Usuario não encontrado!"));

    }



}
