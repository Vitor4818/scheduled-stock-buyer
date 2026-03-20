package com.vgm.invest.domain.tradingAccount.entities;

import com.vgm.invest.domain.customer.entities.Customer;
import com.vgm.invest.domain.tradingAccount.vo.NumberAccount;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tb_trading_account")
public class TradingAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private Customer customerId;
    private NumberAccount numberAccount;
    private TIPO type;
    private LocalDate date;

    public TradingAccount(TIPO type, LocalDate date, NumberAccount numberAccount, Customer customerId, UUID uuid) {
        this.type = TIPO.FILHOTE;
        this.date = LocalDate.now();
        this.numberAccount = numberAccount;
        this.uuid = uuid;
    }
}
