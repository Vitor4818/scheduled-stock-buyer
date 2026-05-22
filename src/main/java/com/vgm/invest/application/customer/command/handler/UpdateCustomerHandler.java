package com.vgm.invest.application.customer.command.handler;


import com.vgm.invest.application.customer.command.UpdateCustomerCommand;
import com.vgm.invest.application.customer.query.dto.CustomerResponse;
import com.vgm.invest.domain.customer.entities.Customer;
import com.vgm.invest.domain.customer.repository.CustomerRepository;
import com.vgm.invest.domain.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateCustomerHandler {

private final CustomerRepository customerRepository;


    public UpdateCustomerHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    //Metodo para atualizar dados do usuario
    public CustomerResponse updateCustomer(UUID uuid, UpdateCustomerCommand command){
        //Procura o usuario pelo ID, se nao existir, retorna um erro
        Customer customer = customerRepository.findById(uuid)
                .orElseThrow(()-> new ResourceNotFoundException("Cliente não localizado com o identificador informado."));
        //Chama o metodo que realiza as alterações pelos novos dados
        customer.updateCustomer(command);
        //Salva as alterações
        customerRepository.save(customer);
        //Converte o objeto do tipo Customer para o tipo CustomerResponse
        return CustomerResponse.fromEntity(customer);

    }
}
