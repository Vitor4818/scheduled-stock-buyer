package com.vgm.invest.domain.tradingAccount.service;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Random;

@Service
public class NumberAccountService {

public String numberAccount(LocalDate date){

    String halfDate = date.toString().replace("-", "").concat(String.valueOf(new SecureRandom().nextInt(9999)));
    String[] aux = halfDate.split("");

    int num = 0;
    int[] auxInt = new int[halfDate.length()];

    for (int i = 0; i<halfDate.length(); i++ ){
        int soma = Integer.parseInt(aux[i]) * 2;
        if (soma>9){
            String[] parcial = String.valueOf(soma).split("");
            soma = Integer.parseInt(parcial[1])+Integer.parseInt(parcial[2]);
        }
        auxInt[i] = soma;
    }

    for (int n : auxInt){
        num += n;
    }

    int digitoVerificador = 10-(num%10);
    if (digitoVerificador == 10) digitoVerificador = 0;

    String numberAccount = halfDate.concat("-").concat(String.valueOf(digitoVerificador));
    return numberAccount;

}



}
