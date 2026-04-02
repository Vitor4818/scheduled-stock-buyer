package com.vgm.invest.infrastructure.persistence.jpa.Custody;

import com.vgm.invest.domain.custody.entity.Custody;
import com.vgm.invest.domain.tradingAccount.entities.TradingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataCustodyRepository extends JpaRepository<Custody, UUID> {
    Optional<Custody>findByTradingAccountId(UUID uuid);
    Optional<Custody> findByTradingAccount_IdAndTicker(UUID id, String ticker);

}
