package com.vgm.invest.domain.custody.entity;

import com.vgm.invest.domain.custody.vo.AveragePrice;
import com.vgm.invest.domain.tradingAccount.entities.TradingAccount;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tb_custody")

public class Custody {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trading_account_id", nullable = false)
    private TradingAccount tradingAccount;
    private String ticker;
    private int qty;
    @Embedded
    private AveragePrice averagePrice;
    private LocalDate lastUpdateDate;


    public Custody(AveragePrice averagePrice, int qty, String ticker, TradingAccount tradingAccountId) {
        this.lastUpdateDate = LocalDate.now();
        this.averagePrice = new AveragePrice(BigDecimal.ZERO);
        this.qty = qty;
        this.ticker = ticker;
        this.tradingAccount = tradingAccountId;
    }


}
