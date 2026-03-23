package com.vgm.invest.api.controller;

import com.vgm.invest.application.TradingAccount.query.GetTradingAccountByUserId;
import com.vgm.invest.application.TradingAccount.query.dto.TradingAccountResponse;
import com.vgm.invest.application.TradingAccount.query.handler.GetTradingAccountByUserIdHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/tradingAccount")
public class TradingAccount {

private final GetTradingAccountByUserIdHandler getTradingAccount;

    public TradingAccount(GetTradingAccountByUserIdHandler getTradingAccount) {
        this.getTradingAccount = getTradingAccount;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<TradingAccountResponse> getTradingAccountByUserId(@PathVariable UUID uuid){
        GetTradingAccountByUserId dto = new GetTradingAccountByUserId(uuid);
        var response = getTradingAccount.getTradingAccount(dto);
        return ResponseEntity.ok(response);
    }
}
