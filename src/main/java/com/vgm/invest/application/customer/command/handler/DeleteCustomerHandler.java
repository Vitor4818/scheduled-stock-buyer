package com.vgm.invest.application.customer.command.handler;

import com.vgm.invest.application.customer.command.DeleteCustomerCommand;
import com.vgm.invest.domain.customer.entities.Customer;
import com.vgm.invest.domain.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteCustomerHandler {

private final CustomerRepository customerRepository;

    //Injetando a dependencia pelo construtor
    public DeleteCustomerHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //Metodo para realizar soft delete do usuario
    public void deleteCustomer(DeleteCustomerCommand command){
        //Procura o usuario pelo ID, se nao existir, retorna um erro
        Customer customer = customerRepository.findById(command.uuid()).orElseThrow(() -> new RuntimeException("Usuario não existe"));
        //Chama o metodo de desativar usuario, que altera a variavel booleana isActive para falsa e zera o valor dos aportes mensais
        customer.deactive();
        //Salva as alterações
        customerRepository.save(customer);
    }
}
