package com.vgm.invest.infrastructure.persistence.jpa.TradingAccount;

import com.vgm.invest.domain.tradingAccount.entities.TradingAccount;
import com.vgm.invest.domain.tradingAccount.repository.TradingAccountRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class TradingAccountRepositoryImpl implements TradingAccountRepository {

    private final SpringDataTradingAccountRepository tradingAccountRepository;

    public TradingAccountRepositoryImpl(SpringDataTradingAccountRepository tradingAccountRepository) {
        this.tradingAccountRepository = tradingAccountRepository;
    }

    @Override
    public TradingAccount save(TradingAccount tradingAccount) {
        return tradingAccountRepository.save(tradingAccount);
    }

    @Override
    public Optional<TradingAccount> findById(UUID uuid) {
        return tradingAccountRepository.findById(uuid);
    }

    @Override
    public Optional<TradingAccount> findByCustomerId(UUID uuid) {
        return tradingAccountRepository.findByCustomerId(uuid);
    }
}
