package com.vgm.invest.domain.tradingAccount.vo;

import java.time.LocalDate;

public class NumberAccount {

    private String value;

    public NumberAccount(String value) {
        if (!value.isBlank() && value != null){
            this.value = value;
        }

    }
}
