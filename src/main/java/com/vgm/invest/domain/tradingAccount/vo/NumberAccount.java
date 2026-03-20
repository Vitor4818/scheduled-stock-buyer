package com.vgm.invest.domain.tradingAccount.vo;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class NumberAccount {

    private String value;

    public NumberAccount(String value) {
        if (!value.isBlank() && value != null){
            this.value = value;
        }
    }
}
