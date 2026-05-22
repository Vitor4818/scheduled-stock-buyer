package com.vgm.invest.domain.customer.service;

import com.vgm.invest.domain.customer.vo.Cpf;
import com.vgm.invest.domain.customer.vo.CustomerEmail;
import com.vgm.invest.domain.customer.repository.CustomerRepository;
import com.vgm.invest.domain.exception.DataConflictException;
import org.springframework.stereotype.Service;


@Service
public class CustomerRegistrationService {

    private final CustomerRepository customerRepository;

    public CustomerRegistrationService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
    }

    public void validateCpfAndEmail(Cpf cpf, CustomerEmail email){
        //Verifica se te algum usuario com o CPF digitado no forms de cadastro
        if(customerRepository.existsByCpf(cpf)){
            throw new DataConflictException("O CPF informado já está associado a uma conta ativa.");
        }
        //Verifica se te algum usuario com o Email digitado no forms de cadastro
        if (customerRepository.existsByEmail(email)){
            throw new DataConflictException("O e-mail informado já está associado a uma conta ativa.");
        }


    }



}
