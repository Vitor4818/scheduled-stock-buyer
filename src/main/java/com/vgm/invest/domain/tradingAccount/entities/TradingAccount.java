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
    @Column(columnDefinition = "BINARY(16)")
    private UUID uuid;
    @OneToOne // Ou @ManyToOne, dependendo da sua regra
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    @Embedded
    private NumberAccount numberAccount;
    @Enumerated(EnumType.STRING) // Importante para salvar o texto do Enum no banco
    @Column(name = "account_type")
    private TIPO type;
    @Column(name = "created_at")
    private LocalDate date;

    public TradingAccount(TIPO type, LocalDate date, NumberAccount numberAccount, Customer customerId, UUID uuid) {
        this.type = TIPO.FILHOTE;
        this.date = LocalDate.now();
        this.numberAccount = numberAccount;
        this.uuid = uuid;
    }
}
