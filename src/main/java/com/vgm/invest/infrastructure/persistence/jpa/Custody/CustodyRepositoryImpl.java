package com.vgm.invest.infrastructure.persistence.jpa.Custody;

import com.vgm.invest.domain.custody.entity.Custody;
import com.vgm.invest.domain.custody.repository.CustodyRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class CustodyRepositoryImpl implements CustodyRepository {
    private  final SpringDataCustodyRepository custodyRepository;

    public CustodyRepositoryImpl(SpringDataCustodyRepository custodyRepository) {
        this.custodyRepository = custodyRepository;
    }


    @Override
    public Custody save(Custody custody) {
        return custodyRepository.save(custody);
    }

    @Override
    public Optional<Custody> findById(UUID uuid) {
        return custodyRepository.findById(uuid);
    }

    @Override
    public Optional<Custody> findByTradingAccountId(UUID uuid) {
        return custodyRepository.findByTradingAccountId(uuid);
    }

    @Override
    public Optional<Custody> findByTradingAccount_IdAndTicker(UUID id, String ticker) {
        return custodyRepository.findByTradingAccount_IdAndTicker(id, ticker);
    }
}
