package com.vgm.invest.infrastructure.persistence.jpa.TradingAccount;

import com.vgm.invest.domain.tradingAccount.entities.TradingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataTradingAccountRepository extends JpaRepository<TradingAccount, UUID> {

}
