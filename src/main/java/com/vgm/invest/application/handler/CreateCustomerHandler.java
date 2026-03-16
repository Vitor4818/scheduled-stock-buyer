package com.vgm.invest.application.handler;

import com.vgm.invest.application.command.CreateCustomerRequest;
import com.vgm.invest.domain.model.Customer.Cpf;
import com.vgm.invest.domain.model.Customer.Customer;
import com.vgm.invest.domain.model.Customer.CustomerEmail;
import com.vgm.invest.domain.model.Customer.MonthlyInvestment;
import com.vgm.invest.domain.repository.CustomerRepository;
import com.vgm.invest.domain.service.CustomerRegistrationService;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerHandler {

    //Injeção de dependencias
    private final CustomerRepository customerRepository;
    private final CustomerRegistrationService customerRegistrationService;

    public CreateCustomerHandler(CustomerRepository customerRepository, CustomerRegistrationService customerRegistrationService) {
        this.customerRepository = customerRepository;
        this.customerRegistrationService = customerRegistrationService;
    }

    //POST usuario
    public Customer createCustomer(CreateCustomerRequest customerDto){
        //Cria os Values Objects da entidade de usuário
        //VO já realiza a validação dos dados, caso dê algum erro de validação que passou despercebido do DTO
        //Já irá lançar uma exception antes de sequer criar o usuário ou fazer consultas ao banco de dados
        Cpf cpfVO = new Cpf(customerDto.cpf());
        CustomerEmail customerEmailVO = new CustomerEmail(customerDto.email());
        MonthlyInvestment monthlyInvestmentVO = new MonthlyInvestment(customerDto.monthlyInvestment());

        //Faz consulta no banco de dados para ver se não tem nenhum usuário co CPF ou email que foi inserido no formulário de cadastro
        customerRegistrationService.validateCpfAndEmail(cpfVO, customerEmailVO);

        //Cria o objeto de usuario
        Customer customer = new Customer(
                monthlyInvestmentVO,
                customerEmailVO,
                cpfVO,
                customerDto.name()
        );

        //Salva o usuario no banco de dados
        return customerRepository.save(customer);
    }

}
