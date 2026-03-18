package com.vgm.invest.domain.customer.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.DecimalMin;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MonthlyInvestment {

    @Column(name = "monthlyInvestment")
    @DecimalMin(value = "1.00")
    private BigDecimal value;

    public MonthlyInvestment(BigDecimal value) {
        //Verifica se é nulo antes de salvar
        if (value == null){
            throw new RuntimeException("O valor deve ser preenchido.");
        }
        //Por regra de negócios, o valor do aporte mensal não pode ser menor que zero
        if (value.compareTo(BigDecimal.ZERO) <= 0 ){
            throw new RuntimeException("O valor deve ser positivo!  ");
        }
        this.value = value;
    }
}
