package com.vgm.invest.application.tradingAccount.query.handler;
import com.vgm.invest.application.TradingAccount.query.GetTradingAccountByUserId;
import com.vgm.invest.application.TradingAccount.query.dto.TradingAccountResponse;
import com.vgm.invest.domain.customer.entities.Customer;
import com.vgm.invest.domain.customer.repository.CustomerRepository;
import com.vgm.invest.domain.exception.ResourceNotFoundException;
import com.vgm.invest.domain.tradingAccount.entities.TradingAccount;
import com.vgm.invest.domain.tradingAccount.repository.TradingAccountRepository;
import org.springframework.stereotype.Service;


@Service
public class GetTradingAccountByUserIdHandler {

    private final TradingAccountRepository tradingAccountRepository;
    private final CustomerRepository customerRepository;

    public GetTradingAccountByUserIdHandler(TradingAccountRepository tradingAccountRepository, CustomerRepository customerRepository) {
        this.tradingAccountRepository = tradingAccountRepository;
        this.customerRepository = customerRepository;
    }

    public TradingAccountResponse getTradingAccount(GetTradingAccountByUserId query){
        Customer customer = customerRepository.findById(query.uuid())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não localizado com o identificador informado."));
        TradingAccount tradingAccount = tradingAccountRepository.findByCustomerId(customer.getId())
                .orElseThrow(()-> new ResourceNotFoundException("Inconsistência cadastral: O cliente informado não possui uma conta gráfica vinculada."));
        return TradingAccountResponse.fromEntity(tradingAccount);

    }
}
