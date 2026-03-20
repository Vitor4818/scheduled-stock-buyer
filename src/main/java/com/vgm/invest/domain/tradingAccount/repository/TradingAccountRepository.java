package com.vgm.invest.domain.tradingAccount.repository;
import com.vgm.invest.domain.tradingAccount.entities.TradingAccount;

import java.util.Optional;
import java.util.UUID;

public interface TradingAccountRepository {
    TradingAccount save(TradingAccount tradingAccount);
    Optional<TradingAccount> findById(UUID uuid);

}
