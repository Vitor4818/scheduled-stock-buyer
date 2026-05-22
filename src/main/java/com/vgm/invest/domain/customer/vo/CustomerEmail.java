package com.vgm.invest.domain.customer.vo;

import com.vgm.invest.domain.exception.ValidationException;
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

    public CustomerEmail(String value) {
        //Verifica se não é nulo antes de salvar
        if(value == null){
            throw new ValidationException("O endereço de e-mail é obrigatório e deve ser informado.");
        }
        this.value = value;
    }
}