package com.vgm.invest.application.TradingAccount.command.handler;

import com.vgm.invest.domain.customer.entities.Customer;
import com.vgm.invest.domain.customer.repository.CustomerRepository;
import com.vgm.invest.domain.tradingAccount.entities.TIPO;
import com.vgm.invest.domain.tradingAccount.entities.TradingAccount;
import com.vgm.invest.domain.tradingAccount.repository.TradingAccountRepository;
import com.vgm.invest.domain.tradingAccount.service.NumberAccountService;
import com.vgm.invest.domain.tradingAccount.vo.NumberAccount;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CreateTradingAccountHandler {

    private final CustomerRepository customerRepository;
    private final TradingAccountRepository tradingAccountRepository;
    private final NumberAccountService numberAccountService;

    public CreateTradingAccountHandler(CustomerRepository customerRepository, TradingAccountRepository tradingAccountRepository, NumberAccountService numberAccount) {
        this.customerRepository = customerRepository;
        this.tradingAccountRepository = tradingAccountRepository;
        this.numberAccountService = numberAccount;
    }

    //cria conta gráfica
    public TradingAccount createTradingAccount(Customer customer){
        String numberAccount = numberAccountService.generateAccountNumber(customer.getAccessionDate());
        NumberAccount numberAccountVO = new NumberAccount(numberAccount);
        TradingAccount tradingAccount = new TradingAccount(TIPO.FILHOTE, LocalDate.now(),numberAccountVO, customer);
        return tradingAccountRepository.save(tradingAccount);
    }

}
