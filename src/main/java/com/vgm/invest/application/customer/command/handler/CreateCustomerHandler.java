package com.vgm.invest.application.customer.command.handler;

import com.vgm.invest.application.customer.command.CreateCustomerRequest;
import com.vgm.invest.application.TradingAccount.command.handler.CreateTradingAccountHandler;
import com.vgm.invest.domain.customer.vo.Cpf;
import com.vgm.invest.domain.customer.entities.Customer;
import com.vgm.invest.domain.customer.vo.CustomerEmail;
import com.vgm.invest.domain.customer.vo.MonthlyInvestment;
import com.vgm.invest.domain.customer.repository.CustomerRepository;
import com.vgm.invest.domain.customer.service.CustomerRegistrationService;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerHandler {

    //Injeção de dependencias
    private final CustomerRepository customerRepository;
    private final CustomerRegistrationService customerRegistrationService;
    private final CreateTradingAccountHandler createTradingAccountHandler;

    public CreateCustomerHandler(CustomerRepository customerRepository, CustomerRegistrationService customerRegistrationService, CreateTradingAccountHandler createTradingAccountHandler) {
        this.customerRepository = customerRepository;
        this.customerRegistrationService = customerRegistrationService;
        this.createTradingAccountHandler = createTradingAccountHandler;
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
        customerRepository.save(customer);
        createTradingAccountHandler.createTradingAccount(customer);
        return customer;
    }

}
