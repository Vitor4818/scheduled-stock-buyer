package com.vgm.invest.application.customer.command;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record UpdateCustomerCommand(
        //Realizando a validação dos dados
        @Size(max = 100)
        String name,
        @DecimalMin(value = "1.00", message = "O valor deve ser maior que zero!")
        BigDecimal monthlyInvestment
) {
}
