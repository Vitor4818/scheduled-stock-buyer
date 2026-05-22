package com.vgm.invest.domain.customer.vo;

import com.vgm.invest.domain.exception.BusinessRuleException;
import com.vgm.invest.domain.exception.ValidationException;
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
        final BigDecimal minValue = new BigDecimal("1");
        //Verifica se é nulo antes de salvar
        if (value == null){
            throw new ValidationException("O valor do aporte é obrigatório e deve ser informado.");
        }
        //Por regra de negócios, o valor do aporte mensal não pode ser menor que zero
        if (value.compareTo(minValue) <= -1 ){
            throw new BusinessRuleException("O valor do aporte informado é inferior ao limite mínimo permitido de R$ 1,00.");
        }
        this.value = value;
    }
}
