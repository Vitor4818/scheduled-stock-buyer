package com.vgm.invest.domain.tradingAccount.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class NumberAccount {
    @Column(name = "number_account")
    private String value;

    public NumberAccount(String value) {
        if (!value.isBlank() && value != null){
            this.value = value;
        }
    }
}
