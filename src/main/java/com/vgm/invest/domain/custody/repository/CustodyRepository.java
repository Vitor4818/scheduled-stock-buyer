package com.vgm.invest.domain.custody.repository;

import com.vgm.invest.domain.custody.entity.Custody;

import java.util.Optional;
import java.util.UUID;

public interface CustodyRepository {
    Custody save(Custody custody);
    Optional<Custody> findById(UUID uuid);
    Optional<Custody> findByTradingAccountId(UUID uuid);
    Optional<Custody> findByTradingAccount_IdAndTicker(UUID id, String ticker);
}
