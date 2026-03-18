package com.vgm.invest.application.customer.command.handler;

import com.vgm.invest.application.customer.command.DeleteCustomerCommand;
import com.vgm.invest.domain.customer.entities.Customer;
import com.vgm.invest.domain.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteCustomerHandler {

private final CustomerRepository customerRepository;


    public DeleteCustomerHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public void deleteCustomer(DeleteCustomerCommand command){
        Customer customer = customerRepository.findById(command.uuid()).orElseThrow(() -> new RuntimeException("Usuario não existe"));
        customer.deactive();
        customerRepository.save(customer);
    }
}
