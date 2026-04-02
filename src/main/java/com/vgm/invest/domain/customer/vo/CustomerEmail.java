package com.vgm.invest.domain.customer.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomerEmail {
    @Column(name = "email")
    @Email
    private String value;

    public CustomerEmail(String value){
        //Verifica se não é nulo antes de salvar
        if(value == null){
            throw new RuntimeException("Erro de email nulo");
        }
        this.value = value;
    }
}