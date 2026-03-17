package com.vgm.invest.application.customer.command;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record CreateCustomerCommand(
        //Realizando a validação dos dados
        @Size(max = 100)
        @NotBlank (message = "O nome deve ser preenchido!")
        String name,
        @NotBlank(message = "Cpf deve ser preenchido")
        String cpf,
        @Email (message = "Insira um email válido!")
        @NotBlank (message = "O Email deve ser preenchido!")
        @Size(max = 150)
        String email,
        @DecimalMin(value = "1.00", message = "O valor deve ser maior que zero!")
        @NotNull
        BigDecimal monthlyInvestment
        ) {
}
