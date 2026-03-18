package com.vgm.invest.application.customer.query.handler;
import com.vgm.invest.application.customer.query.dto.CustomerResponse;

import com.vgm.invest.application.customer.query.GetAllCustomersQuery;
import com.vgm.invest.domain.customer.entities.Customer;
import com.vgm.invest.domain.customer.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class GetAllCustomerHandler {

    private final CustomerRepository customerRepository;

    public GetAllCustomerHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //GetAll
    public Page<CustomerResponse> getAllCustomers(GetAllCustomersQuery query){
        Page<Customer> customers = customerRepository.findAllActive(query.pageable());
        return customers.map(CustomerResponse::fromEntity);
    }
}
